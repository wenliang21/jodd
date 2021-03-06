// Copyright (c) 2003-present, Jodd Team (http://jodd.org)
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// 1. Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.
//
// 2. Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.

package jodd.typeconverter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static jodd.util.ArraysUtil.ints;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {

	private List<Integer> intsList(int... array) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : array) {
			list.add(Integer.valueOf(i));
		}
		return list;
	}

	@Test
	void testIntMatrix2() {
		ArrayList<List<Integer>> matrix = new ArrayList<>();

		matrix.add(intsList(1, 2, 3));
		matrix.add(intsList(9, 8, 7));

		int[][] arr = TypeConverterManager.get().convertType(matrix, int[][].class);

		assertEquals(2, arr.length);

		assertArrayEquals(ints(1,2,3), arr[0]);
		assertArrayEquals(ints(9,8,7), arr[1]);
	}

	@Test
	void testStringToIntMatrix() {
		String[][] strings = new String[][] {
				{"123", "865"},
				{"432", "345", "9832"}
		};

		int[][] arr = TypeConverterManager.get().convertType(strings, int[][].class);

		assertEquals(2, arr.length);

		assertArrayEquals(ints(123,865), arr[0]);
		assertArrayEquals(ints(432,345,9832), arr[1]);
	}

	@Test
	void testIntToStringMatrix() {
		int[][] values = new int[][] {
				{123, 865},
				{432, 345, 9832}
		};

		String[][] arr = TypeConverterManager.get().convertType(values, String[][].class);

		assertEquals(2, arr.length);

		assertEquals("123", arr[0][0]);
		assertEquals("865", arr[0][1]);

		assertEquals("432", arr[1][0]);
		assertEquals("345", arr[1][1]);
		assertEquals("9832", arr[1][2]);
	}
}
