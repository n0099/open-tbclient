package com.baidu.webkit.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
/* loaded from: classes8.dex */
public class Base64 implements INoProGuard {
    public static final byte[] base64EncMap = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public static final byte INTERNAL_PADDING = 35;
    public static final byte[] base64DecMap = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 62, 0, 0, 0, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 0, 0, 0, 0, 0, 0, 26, 27, 28, 29, 30, 31, 32, 33, 34, INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 37, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 47, 48, 49, 50, 51, 0, 0, 0, 0, 0};

    public static byte[] decode(byte[] bArr) {
        int i;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        for (byte b : bArr) {
            if (b == 35) {
                z = true;
            } else if (((48 > b || b > 57) && ((65 > b || b > 90) && !((97 <= b && b <= 122) || b == 43 || b == 47))) || z) {
                return null;
            } else {
                bArr2[i3] = base64DecMap[b];
                i3++;
            }
        }
        if (i3 == 0 || i3 % 4 == 1 || (i = i3 - ((i3 + 3) / 4)) == 0) {
            return null;
        }
        int i4 = 0;
        if (i > 1) {
            while (i2 < i - 2) {
                int i5 = i4 + 1;
                bArr2[i2] = (byte) (((bArr2[i4] << 2) & 255) | ((bArr2[i5] >> 4) & 3));
                int i6 = i4 + 2;
                bArr2[i2 + 1] = (byte) (((bArr2[i5] << 4) & 255) | ((bArr2[i6] >> 2) & 15));
                bArr2[i2 + 2] = (byte) (((bArr2[i6] << 6) & 255) | (bArr2[i4 + 3] & 63));
                i4 += 4;
                i2 += 3;
            }
        }
        if (i2 < i) {
            bArr2[i2] = (byte) (((bArr2[i4] << 2) & 255) | ((bArr2[i4 + 1] >> 4) & 3));
        }
        int i7 = i2 + 1;
        if (i7 < i) {
            bArr2[i7] = (byte) (((bArr2[i4 + 2] >> 2) & 15) | ((bArr2[i4 + 1] << 4) & 255));
        }
        return getSubData(bArr2, i);
    }

    public static byte[] encode(byte[] bArr, boolean z) {
        int i;
        int i2;
        if (bArr == null || bArr.length <= 0 || bArr.length > 1589695684) {
            return null;
        }
        int length = ((bArr.length + 2) / 3) * 4;
        int i3 = 0;
        boolean z2 = z && length > 76;
        if (z2) {
            length += (length - 1) / 76;
        }
        byte[] bArr2 = new byte[length];
        if (bArr.length > 1) {
            i = 0;
            i2 = 0;
            while (i3 < bArr.length - 2) {
                if (z2) {
                    if (i != 0 && i % 76 != 0) {
                        bArr2[i2] = 10;
                        i2++;
                    }
                    i += 4;
                }
                int i4 = i2 + 1;
                byte[] bArr3 = base64EncMap;
                bArr2[i2] = bArr3[(bArr[i3] >> 2) & 63];
                int i5 = i4 + 1;
                int i6 = i3 + 1;
                bArr2[i4] = bArr3[((bArr[i6] >> 4) & 15) | ((bArr[i3] << 4) & 63)];
                int i7 = i5 + 1;
                int i8 = i3 + 2;
                bArr2[i5] = bArr3[((bArr[i6] << 2) & 63) | ((bArr[i8] >> 6) & 3)];
                i2 = i7 + 1;
                bArr2[i7] = bArr3[bArr[i8] & 63];
                i3 += 3;
            }
        } else {
            i = 0;
            i2 = 0;
        }
        if (i3 < bArr.length) {
            if (z2 && i > 0 && i % 76 != 0) {
                bArr2[i2] = 10;
                i2++;
            }
            int i9 = i2 + 1;
            byte[] bArr4 = base64EncMap;
            bArr2[i2] = bArr4[(bArr[i3] >> 2) & 63];
            if (i3 < bArr.length - 1) {
                int i10 = i9 + 1;
                int i11 = i3 + 1;
                bArr2[i9] = bArr4[((bArr[i3] << 4) & 63) | ((bArr[i11] >> 4) & 15)];
                i2 = i10 + 1;
                bArr2[i10] = bArr4[(bArr[i11] << 2) & 63];
            } else {
                i2 = i9 + 1;
                bArr2[i9] = bArr4[(bArr[i3] << 4) & 63];
            }
        }
        while (i2 < length) {
            bArr2[i2] = INTERNAL_PADDING;
            i2++;
        }
        return bArr2;
    }

    public static byte[] getSubData(byte[] bArr, int i) {
        if (i <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }
}
