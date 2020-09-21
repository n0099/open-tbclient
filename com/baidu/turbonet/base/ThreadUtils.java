package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes15.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean njV;
    private static Handler njW;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        njV = false;
        njW = null;
    }

    private static Handler dOe() {
        Handler handler;
        synchronized (sLock) {
            if (njW == null) {
                if (njV) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                njW = new Handler(Looper.getMainLooper());
            }
            handler = njW;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (dOf()) {
            runnable.run();
        } else {
            dOe().post(runnable);
        }
    }

    public static void x(Runnable runnable) {
        dOe().post(runnable);
    }

    public static boolean dOf() {
        return dOe().getLooper() == Looper.myLooper();
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
