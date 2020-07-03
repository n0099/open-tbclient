package com.baidu.turbonet.base;

import android.content.Context;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes.dex */
public class ContextUtils {
    private static Context myc;

    private static native void nativeInitNativeSideApplicationContext(Context context);

    public static Context getApplicationContext() {
        return myc;
    }

    public static void fC(Context context) {
        if (myc != null && myc != context) {
            a.d("ContextUtils", "Multiple contexts detected, ignoring new application context.");
        } else {
            fD(context);
        }
    }

    public static void duI() {
        if (myc == null) {
            throw new RuntimeException("Cannot have native global application context be null.");
        }
        nativeInitNativeSideApplicationContext(myc);
    }

    private static void fD(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        myc = context;
    }
}
