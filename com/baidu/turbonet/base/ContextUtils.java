package com.baidu.turbonet.base;

import android.content.Context;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes19.dex */
public class ContextUtils {
    private static Context mGk;

    private static native void nativeInitNativeSideApplicationContext(Context context);

    public static Context getApplicationContext() {
        return mGk;
    }

    public static void fF(Context context) {
        if (mGk != null && mGk != context) {
            a.d("ContextUtils", "Multiple contexts detected, ignoring new application context.");
        } else {
            fG(context);
        }
    }

    public static void dxZ() {
        if (mGk == null) {
            throw new RuntimeException("Cannot have native global application context be null.");
        }
        nativeInitNativeSideApplicationContext(mGk);
    }

    private static void fG(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        mGk = context;
    }
}
