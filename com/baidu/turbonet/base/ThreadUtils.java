package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean lIb;
    private static Handler lIc;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        lIb = false;
        lIc = null;
    }

    private static Handler diL() {
        Handler handler;
        synchronized (sLock) {
            if (lIc == null) {
                if (lIb) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                lIc = new Handler(Looper.getMainLooper());
            }
            handler = lIc;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (diM()) {
            runnable.run();
        } else {
            diL().post(runnable);
        }
    }

    public static void z(Runnable runnable) {
        diL().post(runnable);
    }

    public static boolean diM() {
        return diL().getLooper() == Looper.myLooper();
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
