package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes10.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean mZE;
    private static Handler mZF;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        mZE = false;
        mZF = null;
    }

    private static Handler dJX() {
        Handler handler;
        synchronized (sLock) {
            if (mZF == null) {
                if (mZE) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                mZF = new Handler(Looper.getMainLooper());
            }
            handler = mZF;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (dJY()) {
            runnable.run();
        } else {
            dJX().post(runnable);
        }
    }

    public static void x(Runnable runnable) {
        dJX().post(runnable);
    }

    public static boolean dJY() {
        return dJX().getLooper() == Looper.myLooper();
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
