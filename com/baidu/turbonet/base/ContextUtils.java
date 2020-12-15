package com.baidu.turbonet.base;

import android.content.Context;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes14.dex */
public class ContextUtils {
    private static Context sApplicationContext;

    private static native void nativeInitNativeSideApplicationContext(Context context);

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static void gR(Context context) {
        if (sApplicationContext != null && sApplicationContext != context) {
            a.d("ContextUtils", "Multiple contexts detected, ignoring new application context.");
        } else {
            gS(context);
        }
    }

    public static void egL() {
        if (sApplicationContext == null) {
            throw new RuntimeException("Cannot have native global application context be null.");
        }
        nativeInitNativeSideApplicationContext(sApplicationContext);
    }

    private static void gS(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        sApplicationContext = context;
    }
}
