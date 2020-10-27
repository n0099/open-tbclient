package com.baidu.turbonet.base;

import android.content.Context;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes17.dex */
public class ContextUtils {
    private static Context obz;

    private static native void nativeInitNativeSideApplicationContext(Context context);

    public static Context getApplicationContext() {
        return obz;
    }

    public static void gi(Context context) {
        if (obz != null && obz != context) {
            a.d("ContextUtils", "Multiple contexts detected, ignoring new application context.");
        } else {
            gj(context);
        }
    }

    public static void dXy() {
        if (obz == null) {
            throw new RuntimeException("Cannot have native global application context be null.");
        }
        nativeInitNativeSideApplicationContext(obz);
    }

    private static void gj(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        obz = context;
    }
}
