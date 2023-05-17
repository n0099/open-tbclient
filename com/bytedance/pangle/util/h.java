package com.bytedance.pangle.util;

import android.os.Build;
/* loaded from: classes8.dex */
public final class h {
    public static boolean a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21 && i <= 23) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        if (Build.VERSION.SDK_INT > 23) {
            return true;
        }
        return false;
    }

    public static boolean d() {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            if (i != 27 || Build.VERSION.PREVIEW_SDK_INT <= 0) {
                return false;
            }
            return true;
        }
        return true;
    }
}
