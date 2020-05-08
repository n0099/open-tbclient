package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean lIf;
    private static Handler lIg;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        lIf = false;
        lIg = null;
    }

    private static Handler diI() {
        Handler handler;
        synchronized (sLock) {
            if (lIg == null) {
                if (lIf) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                lIg = new Handler(Looper.getMainLooper());
            }
            handler = lIg;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (diJ()) {
            runnable.run();
        } else {
            diI().post(runnable);
        }
    }

    public static void z(Runnable runnable) {
        diI().post(runnable);
    }

    public static boolean diJ() {
        return diI().getLooper() == Looper.myLooper();
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
