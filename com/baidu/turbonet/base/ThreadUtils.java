package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes14.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean oBB;
    private static Handler oBC;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        oBB = false;
        oBC = null;
    }

    private static Handler egV() {
        Handler handler;
        synchronized (sLock) {
            if (oBC == null) {
                if (oBB) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                oBC = new Handler(Looper.getMainLooper());
            }
            handler = oBC;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (egW()) {
            runnable.run();
        } else {
            egV().post(runnable);
        }
    }

    public static void y(Runnable runnable) {
        egV().post(runnable);
    }

    public static boolean egW() {
        return egV().getLooper() == Looper.myLooper();
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
