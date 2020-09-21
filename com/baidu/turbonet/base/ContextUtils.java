package com.baidu.turbonet.base;

import android.content.Context;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes15.dex */
public class ContextUtils {
    private static Context njC;

    private static native void nativeInitNativeSideApplicationContext(Context context);

    public static Context getApplicationContext() {
        return njC;
    }

    public static void fY(Context context) {
        if (njC != null && njC != context) {
            a.d("ContextUtils", "Multiple contexts detected, ignoring new application context.");
        } else {
            fZ(context);
        }
    }

    public static void dNU() {
        if (njC == null) {
            throw new RuntimeException("Cannot have native global application context be null.");
        }
        nativeInitNativeSideApplicationContext(njC);
    }

    private static void fZ(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        njC = context;
    }
}
