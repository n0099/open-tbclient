package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes17.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean obS;
    private static Handler obT;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        obS = false;
        obT = null;
    }

    private static Handler dXI() {
        Handler handler;
        synchronized (sLock) {
            if (obT == null) {
                if (obS) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                obT = new Handler(Looper.getMainLooper());
            }
            handler = obT;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (dXJ()) {
            runnable.run();
        } else {
            dXI().post(runnable);
        }
    }

    public static void y(Runnable runnable) {
        dXI().post(runnable);
    }

    public static boolean dXJ() {
        return dXI().getLooper() == Looper.myLooper();
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
