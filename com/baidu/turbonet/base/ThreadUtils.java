package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes4.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object sLock;
    private static Handler sUiThreadHandler;
    private static boolean sWillOverride;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        sWillOverride = false;
        sUiThreadHandler = null;
    }

    private static Handler getUiThreadHandler() {
        Handler handler;
        synchronized (sLock) {
            if (sUiThreadHandler == null) {
                if (sWillOverride) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                sUiThreadHandler = new Handler(Looper.getMainLooper());
            }
            handler = sUiThreadHandler;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runningOnUiThread()) {
            runnable.run();
        } else {
            getUiThreadHandler().post(runnable);
        }
    }

    public static void x(Runnable runnable) {
        getUiThreadHandler().post(runnable);
    }

    public static boolean runningOnUiThread() {
        return getUiThreadHandler().getLooper() == Looper.myLooper();
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
