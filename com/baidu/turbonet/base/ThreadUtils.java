package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes14.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static Handler oBA;
    private static boolean oBz;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        oBz = false;
        oBA = null;
    }

    private static Handler egU() {
        Handler handler;
        synchronized (sLock) {
            if (oBA == null) {
                if (oBz) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                oBA = new Handler(Looper.getMainLooper());
            }
            handler = oBA;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (egV()) {
            runnable.run();
        } else {
            egU().post(runnable);
        }
    }

    public static void y(Runnable runnable) {
        egU().post(runnable);
    }

    public static boolean egV() {
        return egU().getLooper() == Looper.myLooper();
    }

    @CalledByNative
    public static void setThreadPriorityAudio(int i) {
        Process.setThreadPriority(i, -16);
    }

    @CalledByNative
    private static boolean isThreadPriorityAudio(int i) {
        return Process.getThreadPriority(i) == -16;
    }
}
