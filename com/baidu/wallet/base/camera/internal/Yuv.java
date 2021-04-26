package com.baidu.wallet.base.camera.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public class Yuv implements NoProguard {
    static {
        System.loadLibrary("bd_yuv");
    }

    public static void rotateCrop(byte[] bArr, int i2, int i3, Rect rect, int i4, byte[] bArr2) {
        if (bArr == null || rect == null || bArr2 == null) {
            return;
        }
        int i5 = i2 * i3;
        int width = rect.width() * rect.height();
        if (bArr.length == i5 + (i5 >> 1) && bArr2.length == width * 3) {
            rotateCropArray(bArr, i2, i3, rect.left, rect.top, rect.right, rect.bottom, i4, bArr2);
        }
    }

    public static native void rotateCropArray(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr2);

    public static native void rotateCropBmp(byte[] bArr, int i2, int i3, int i4, int i5, int i6, Bitmap bitmap);

    public static void rotateCropLuminance(byte[] bArr, int i2, int i3, Rect rect, int i4, byte[] bArr2) {
        if (bArr == null || rect == null || bArr2 == null) {
            return;
        }
        int i5 = i2 * i3;
        int width = rect.width() * rect.height();
        if (bArr.length < i5 || bArr2.length < width) {
            return;
        }
        rotateCropLuminance0(bArr, i2, i3, rect.left, rect.top, rect.right, rect.bottom, i4, bArr2);
    }

    public static native void rotateCropLuminance0(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr2);
}
