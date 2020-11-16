package com.baidu.turbonet.base;

import android.content.Context;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes12.dex */
public class ContextUtils {
    private static Context omh;

    private static native void nativeInitNativeSideApplicationContext(Context context);

    public static Context getApplicationContext() {
        return omh;
    }

    public static void gh(Context context) {
        if (omh != null && omh != context) {
            a.d("ContextUtils", "Multiple contexts detected, ignoring new application context.");
        } else {
            gi(context);
        }
    }

    public static void ebf() {
        if (omh == null) {
            throw new RuntimeException("Cannot have native global application context be null.");
        }
        nativeInitNativeSideApplicationContext(omh);
    }

    private static void gi(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        omh = context;
    }
}
