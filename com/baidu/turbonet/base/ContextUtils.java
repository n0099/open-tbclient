package com.baidu.turbonet.base;

import android.content.Context;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes17.dex */
public class ContextUtils {
    private static Context okE;

    private static native void nativeInitNativeSideApplicationContext(Context context);

    public static Context getApplicationContext() {
        return okE;
    }

    public static void gi(Context context) {
        if (okE != null && okE != context) {
            a.d("ContextUtils", "Multiple contexts detected, ignoring new application context.");
        } else {
            gj(context);
        }
    }

    public static void ebg() {
        if (okE == null) {
            throw new RuntimeException("Cannot have native global application context be null.");
        }
        nativeInitNativeSideApplicationContext(okE);
    }

    private static void gj(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        okE = context;
    }
}
