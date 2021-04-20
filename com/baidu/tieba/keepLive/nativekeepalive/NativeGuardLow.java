package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import android.os.Build;
/* loaded from: classes4.dex */
public class NativeGuardLow extends NativeGuardAbs {
    static {
        try {
            if (Build.VERSION.SDK_INT <= 20) {
                System.loadLibrary("nativeKeepLive20");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public NativeGuardLow(Context context) {
        super(context);
    }

    public native void doDaemon(String str, String str2, String str3);
}
