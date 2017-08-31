package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import android.os.Build;
/* loaded from: classes.dex */
public class NativeDaemonAPI20 extends NativeDaemonBase {
    public native void doDaemon(String str, String str2, String str3);

    public NativeDaemonAPI20(Context context) {
        super(context);
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 20) {
                System.loadLibrary("nativeKeepLive20");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
