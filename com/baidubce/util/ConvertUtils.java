package com.baidubce.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class ConvertUtils {
    public static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final byte[] CHUNK_SEPARATOR = {13, 10};

    public static byte[] decodeHex(char[] cArr) throws IOException {
        int length = cArr.length;
        if ((length & 1) == 0) {
            byte[] bArr = new byte[length >> 1];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i2 + 1;
                i2 = i4 + 1;
                bArr[i3] = (byte) (((toDigit(cArr[i2], i2) << 4) | toDigit(cArr[i4], i4)) & 255);
                i3++;
            }
            return bArr;
        }
        throw new IOException("Odd number of characters.");
    }

    public static char[] encodeHex(byte[] bArr) {
        char[] cArr = DIGITS_LOWER;
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            cArr2[i2] = cArr[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr2[i4] = cArr[bArr[i3] & 15];
        }
        return cArr2;
    }

    public static byte[] inputStreamToByte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read();
            if (read != -1) {
                byteArrayOutputStream.write(read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static int toDigit(char c2, int i2) throws IOException {
        int digit = Character.digit(c2, 16);
        if (digit != -1) {
            return digit;
        }
        throw new IOException("Illegal hexadecimal character " + c2 + " at index " + i2);
    }
}
