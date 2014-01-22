package com.baidu.tieba.util;
/* loaded from: classes.dex */
public class m {
    static String[] a = {"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"};

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length, null).toString();
    }

    public static StringBuffer a(byte[] bArr, int i, int i2, StringBuffer stringBuffer) {
        char[] charArray = a[0].toCharArray();
        if (stringBuffer == null) {
            stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        }
        int i3 = i2 - 3;
        int i4 = i;
        while (i4 <= i3) {
            int i5 = ((bArr[i4] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8) | (bArr[i4 + 2] & 255);
            stringBuffer.append(charArray[(i5 >> 18) & 63]);
            stringBuffer.append(charArray[(i5 >> 12) & 63]);
            stringBuffer.append(charArray[(i5 >> 6) & 63]);
            stringBuffer.append(charArray[i5 & 63]);
            i4 += 3;
        }
        if (i4 == (i + i2) - 2) {
            int i6 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16);
            stringBuffer.append(charArray[(i6 >> 18) & 63]);
            stringBuffer.append(charArray[(i6 >> 12) & 63]);
            stringBuffer.append(charArray[(i6 >> 6) & 63]);
        } else if (i4 == (i + i2) - 1) {
            int i7 = (bArr[i4] & 255) << 16;
            stringBuffer.append(charArray[(i7 >> 18) & 63]);
            stringBuffer.append(charArray[(i7 >> 12) & 63]);
        }
        return stringBuffer;
    }
}
