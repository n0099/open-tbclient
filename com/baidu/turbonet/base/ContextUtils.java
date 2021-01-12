package com.baidu.turbonet.base;

import android.content.Context;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes4.dex */
public class ContextUtils {
    private static Context sApplicationContext;

    private static native void nativeInitNativeSideApplicationContext(Context context);

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static void initApplicationContext(Context context) {
        if (sApplicationContext != null && sApplicationContext != context) {
            a.d("ContextUtils", "Multiple contexts detected, ignoring new application context.");
        } else {
            hh(context);
        }
    }

    public static void edz() {
        if (sApplicationContext == null) {
            throw new RuntimeException("Cannot have native global application context be null.");
        }
        nativeInitNativeSideApplicationContext(sApplicationContext);
    }

    private static void hh(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        sApplicationContext = context;
    }
}
