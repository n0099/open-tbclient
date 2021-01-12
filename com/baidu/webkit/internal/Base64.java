package com.baidu.webkit.internal;

import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes14.dex */
public class Base64 implements INoProGuard {
    static final byte[] base64EncMap = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte INTERNAL_PADDING = 35;
    static final byte[] base64DecMap = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 62, 0, 0, 0, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 0, 0, 0, 0, 0, 0, 26, 27, 28, 29, 30, 31, 32, 33, 34, INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 0, 0, 0, 0, 0};

    public static byte[] decode(byte[] bArr) {
        int i;
        int i2;
        int i3;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        int i4 = 0;
        boolean z = false;
        for (byte b2 : bArr) {
            if (b2 != 35) {
                if (((48 <= b2 && b2 <= 57) || ((65 <= b2 && b2 <= 90) || ((97 <= b2 && b2 <= 122) || b2 == 43 || b2 == 47))) && !z) {
                    bArr2[i4] = base64DecMap[b2];
                    i4++;
                }
                return null;
            }
            z = true;
        }
        if (i4 != 0 && i4 % 4 != 1 && (i = i4 - ((i4 + 3) / 4)) != 0) {
            if (i > 1) {
                i2 = 0;
                i3 = 0;
                while (i2 < i - 2) {
                    bArr2[i2] = (byte) (((bArr2[i3] << 2) & 255) | ((bArr2[i3 + 1] >> 4) & 3));
                    bArr2[i2 + 1] = (byte) (((bArr2[i3 + 1] << 4) & 255) | ((bArr2[i3 + 2] >> 2) & 15));
                    bArr2[i2 + 2] = (byte) (((bArr2[i3 + 2] << 6) & 255) | (bArr2[i3 + 3] & 63));
                    i3 += 4;
                    i2 += 3;
                }
            } else {
                i2 = 0;
                i3 = 0;
            }
            if (i2 < i) {
                bArr2[i2] = (byte) (((bArr2[i3] << 2) & 255) | ((bArr2[i3 + 1] >> 4) & 3));
            }
            int i5 = i2 + 1;
            if (i5 < i) {
                bArr2[i5] = (byte) (((bArr2[i3 + 1] << 4) & 255) | ((bArr2[i3 + 2] >> 2) & 15));
            }
            return getSubData(bArr2, i);
        }
        return null;
    }

    public static byte[] encode(byte[] bArr, boolean z) {
        int i;
        int i2;
        int i3;
        if (bArr == null || bArr.length <= 0 || bArr.length > 1589695684) {
            return null;
        }
        int length = ((bArr.length + 2) / 3) * 4;
        boolean z2 = z && length > 76;
        if (z2) {
            length += (length - 1) / 76;
        }
        byte[] bArr2 = new byte[length];
        if (bArr.length > 1) {
            i = 0;
            i2 = 0;
            i3 = 0;
            while (i3 < bArr.length - 2) {
                if (z2) {
                    if (i != 0 && i % 76 != 0) {
                        bArr2[i2] = 10;
                        i2++;
                    }
                    i += 4;
                }
                int i4 = i2 + 1;
                bArr2[i2] = base64EncMap[(bArr[i3] >> 2) & 63];
                int i5 = i4 + 1;
                bArr2[i4] = base64EncMap[((bArr[i3 + 1] >> 4) & 15) | ((bArr[i3] << 4) & 63)];
                int i6 = i5 + 1;
                bArr2[i5] = base64EncMap[((bArr[i3 + 2] >> 6) & 3) | ((bArr[i3 + 1] << 2) & 63)];
                bArr2[i6] = base64EncMap[bArr[i3 + 2] & 63];
                i3 += 3;
                i2 = i6 + 1;
            }
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        if (i3 < bArr.length) {
            if (z2 && i > 0 && i % 76 != 0) {
                bArr2[i2] = 10;
                i2++;
            }
            int i7 = i2 + 1;
            bArr2[i2] = base64EncMap[(bArr[i3] >> 2) & 63];
            if (i3 < bArr.length - 1) {
                int i8 = i7 + 1;
                bArr2[i7] = base64EncMap[((bArr[i3 + 1] >> 4) & 15) | ((bArr[i3] << 4) & 63)];
                i2 = i8 + 1;
                bArr2[i8] = base64EncMap[(bArr[i3 + 1] << 2) & 63];
            } else {
                i2 = i7 + 1;
                bArr2[i7] = base64EncMap[(bArr[i3] << 4) & 63];
            }
        }
        while (i2 < bArr2.length) {
            bArr2[i2] = INTERNAL_PADDING;
            i2++;
        }
        return bArr2;
    }

    private static byte[] getSubData(byte[] bArr, int i) {
        if (i <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }
}
