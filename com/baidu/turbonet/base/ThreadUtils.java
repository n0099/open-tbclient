package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean mbw;
    private static Handler mbx;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        mbw = false;
        mbx = null;
    }

    private static Handler dpZ() {
        Handler handler;
        synchronized (sLock) {
            if (mbx == null) {
                if (mbw) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                mbx = new Handler(Looper.getMainLooper());
            }
            handler = mbx;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (dqa()) {
            runnable.run();
        } else {
            dpZ().post(runnable);
        }
    }

    public static void B(Runnable runnable) {
        dpZ().post(runnable);
    }

    public static boolean dqa() {
        return dpZ().getLooper() == Looper.myLooper();
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
