package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes10.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean mZW;
    private static Handler mZX;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        mZW = false;
        mZX = null;
    }

    private static Handler dKg() {
        Handler handler;
        synchronized (sLock) {
            if (mZX == null) {
                if (mZW) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                mZX = new Handler(Looper.getMainLooper());
            }
            handler = mZX;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (dKh()) {
            runnable.run();
        } else {
            dKg().post(runnable);
        }
    }

    public static void x(Runnable runnable) {
        dKg().post(runnable);
    }

    public static boolean dKh() {
        return dKg().getLooper() == Looper.myLooper();
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
