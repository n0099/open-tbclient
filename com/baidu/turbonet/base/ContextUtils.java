package com.baidu.turbonet.base;

import android.content.Context;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes17.dex */
public class ContextUtils {
    private static Context nyZ;

    private static native void nativeInitNativeSideApplicationContext(Context context);

    public static Context getApplicationContext() {
        return nyZ;
    }

    public static void gg(Context context) {
        if (nyZ != null && nyZ != context) {
            a.d("ContextUtils", "Multiple contexts detected, ignoring new application context.");
        } else {
            gh(context);
        }
    }

    public static void dRG() {
        if (nyZ == null) {
            throw new RuntimeException("Cannot have native global application context be null.");
        }
        nativeInitNativeSideApplicationContext(nyZ);
    }

    private static void gh(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        nyZ = context;
    }
}
