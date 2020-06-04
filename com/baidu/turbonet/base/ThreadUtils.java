package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean mcG;
    private static Handler mcH;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        mcG = false;
        mcH = null;
    }

    private static Handler dqn() {
        Handler handler;
        synchronized (sLock) {
            if (mcH == null) {
                if (mcG) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                mcH = new Handler(Looper.getMainLooper());
            }
            handler = mcH;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (dqo()) {
            runnable.run();
        } else {
            dqn().post(runnable);
        }
    }

    public static void B(Runnable runnable) {
        dqn().post(runnable);
    }

    public static boolean dqo() {
        return dqn().getLooper() == Looper.myLooper();
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
