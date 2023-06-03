package com.bytedance.pangle;

import android.os.Build;
import com.bytedance.pangle.flipped.FlippedV2Impl;
/* loaded from: classes9.dex */
public final class b {
    public static void a() {
        boolean z;
        com.bytedance.pangle.flipped.c aVar;
        int i = Build.VERSION.SDK_INT;
        boolean z2 = false;
        if (i < 30 && (i != 29 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            aVar = new FlippedV2Impl();
        } else {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28 || (i2 == 27 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                z2 = true;
            }
            if (z2) {
                aVar = new com.bytedance.pangle.flipped.b();
            } else {
                aVar = new com.bytedance.pangle.flipped.a();
            }
        }
        aVar.invokeHiddenApiRestrictions();
    }
}
