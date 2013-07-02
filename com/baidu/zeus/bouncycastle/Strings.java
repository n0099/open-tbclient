package com.baidu.zeus.bouncycastle;

import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public final class Strings {
    public static String fromUTF8ByteArray(byte[] bArr) {
        char c;
        int i;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 < bArr.length) {
            i3++;
            if ((bArr[i4] & 240) == 240) {
                i3++;
                i4 += 4;
            } else if ((bArr[i4] & 224) == 224) {
                i4 += 3;
            } else if ((bArr[i4] & 192) == 192) {
                i4 += 2;
            } else {
                i4++;
            }
        }
        char[] cArr = new char[i3];
        int i5 = 0;
        while (i5 < bArr.length) {
            if ((bArr[i5] & 240) == 240) {
                int i6 = (((((bArr[i5] & 15) << 18) | ((bArr[i5 + 1] & 63) << 12)) | ((bArr[i5 + 2] & 63) << 6)) | (bArr[i5 + 3] & 63)) - 65536;
                char c2 = (char) (55296 | (i6 >> 10));
                c = (char) ((i6 & 1023) | 56320);
                i = i2 + 1;
                cArr[i2] = c2;
                i5 += 4;
            } else if ((bArr[i5] & 224) == 224) {
                c = (char) (((bArr[i5] & 31) << 12) | ((bArr[i5 + 1] & 63) << 6) | (bArr[i5 + 2] & 63));
                i5 += 3;
                i = i2;
            } else if ((bArr[i5] & 192) == 192) {
                c = (char) (((bArr[i5] & 63) << 6) | (bArr[i5 + 1] & 63));
                i5 += 2;
                i = i2;
            } else {
                c = (char) (bArr[i5] & 255);
                i5++;
                i = i2;
            }
            i2 = i + 1;
            cArr[i] = c;
        }
        return new String(cArr);
    }

    public static byte[] toUTF8ByteArray(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            char c = charArray[i];
            if (c < 128) {
                byteArrayOutputStream.write(c);
            } else if (c < 2048) {
                byteArrayOutputStream.write((c >> 6) | 192);
                byteArrayOutputStream.write((c & '?') | DERTags.TAGGED);
            } else if (c >= 55296 && c <= 57343) {
                if (i + 1 >= charArray.length) {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
                i++;
                char c2 = charArray[i];
                if (c > 56319) {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
                int i2 = (((c & 1023) << 10) | (c2 & 1023)) + 65536;
                byteArrayOutputStream.write((i2 >> 18) | 240);
                byteArrayOutputStream.write(((i2 >> 12) & 63) | DERTags.TAGGED);
                byteArrayOutputStream.write(((i2 >> 6) & 63) | DERTags.TAGGED);
                byteArrayOutputStream.write((i2 & 63) | DERTags.TAGGED);
            } else {
                byteArrayOutputStream.write((c >> '\f') | 224);
                byteArrayOutputStream.write(((c >> 6) & 63) | DERTags.TAGGED);
                byteArrayOutputStream.write((c & '?') | DERTags.TAGGED);
            }
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String toUpperCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('a' <= c && 'z' >= c) {
                z = true;
                charArray[i] = (char) ((c - 'a') + 65);
            }
        }
        if (z) {
            return new String(charArray);
        }
        return str;
    }

    public static String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && 'Z' >= c) {
                z = true;
                charArray[i] = (char) ((c - 'A') + 97);
            }
        }
        if (z) {
            return new String(charArray);
        }
        return str;
    }
}
