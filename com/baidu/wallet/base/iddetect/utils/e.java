package com.baidu.wallet.base.iddetect.utils;

import androidx.recyclerview.widget.ItemTouchHelper;
/* loaded from: classes5.dex */
public class e {
    public static int[] a(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 >> 1) * i) + i3;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < i) {
                int i10 = (bArr[i4] & 255) - 16;
                if (i10 < 0) {
                    i10 = 0;
                }
                if ((i7 & 1) == 0) {
                    int i11 = i6 + 1;
                    i9 = (bArr[i6] & 255) + com.alipay.sdk.encrypt.a.f1921g;
                    i6 = i11 + 1;
                    i8 = (bArr[i11] & 255) + com.alipay.sdk.encrypt.a.f1921g;
                }
                int i12 = i10 * 1192;
                int i13 = (i9 * 1634) + i12;
                int i14 = (i12 - (i9 * 833)) - (i8 * 400);
                int i15 = i12 + (i8 * 2066);
                if (i13 < 0) {
                    i13 = 0;
                } else if (i13 > 262143) {
                    i13 = 262143;
                }
                if (i14 < 0) {
                    i14 = 0;
                } else if (i14 > 262143) {
                    i14 = 262143;
                }
                if (i15 < 0) {
                    i15 = 0;
                } else if (i15 > 262143) {
                    i15 = 262143;
                }
                iArr[i4] = ((i15 >> 10) & 255) | ((i13 << 6) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | (-16777216) | ((i14 >> 2) & 65280);
                i7++;
                i4++;
            }
        }
        return iArr;
    }
}
