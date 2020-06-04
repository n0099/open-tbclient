package com.baidu.turbonet.base;

import android.content.Context;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes.dex */
public class ContextUtils {
    private static Context mcn;

    private static native void nativeInitNativeSideApplicationContext(Context context);

    public static Context getApplicationContext() {
        return mcn;
    }

    public static void fB(Context context) {
        if (mcn != null && mcn != context) {
            a.d("ContextUtils", "Multiple contexts detected, ignoring new application context.");
        } else {
            fC(context);
        }
    }

    public static void dqd() {
        if (mcn == null) {
            throw new RuntimeException("Cannot have native global application context be null.");
        }
        nativeInitNativeSideApplicationContext(mcn);
    }

    private static void fC(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        mcn = context;
    }
}
