package com.baidu.turbonet.base;

import android.content.Context;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes10.dex */
public class ContextUtils {
    private static Context mZl;

    private static native void nativeInitNativeSideApplicationContext(Context context);

    public static Context getApplicationContext() {
        return mZl;
    }

    public static void fS(Context context) {
        if (mZl != null && mZl != context) {
            a.d("ContextUtils", "Multiple contexts detected, ignoring new application context.");
        } else {
            fT(context);
        }
    }

    public static void dJN() {
        if (mZl == null) {
            throw new RuntimeException("Cannot have native global application context be null.");
        }
        nativeInitNativeSideApplicationContext(mZl);
    }

    private static void fT(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        mZl = context;
    }
}
