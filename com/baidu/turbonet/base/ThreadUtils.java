package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes17.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean nzs;
    private static Handler nzt;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        nzs = false;
        nzt = null;
    }

    private static Handler dRQ() {
        Handler handler;
        synchronized (sLock) {
            if (nzt == null) {
                if (nzs) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                nzt = new Handler(Looper.getMainLooper());
            }
            handler = nzt;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (dRR()) {
            runnable.run();
        } else {
            dRQ().post(runnable);
        }
    }

    public static void x(Runnable runnable) {
        dRQ().post(runnable);
    }

    public static boolean dRR() {
        return dRQ().getLooper() == Looper.myLooper();
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
