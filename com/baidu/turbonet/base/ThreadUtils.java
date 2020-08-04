package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes19.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean mGF;
    private static Handler mGG;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        mGF = false;
        mGG = null;
    }

    private static Handler dyk() {
        Handler handler;
        synchronized (sLock) {
            if (mGG == null) {
                if (mGF) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                mGG = new Handler(Looper.getMainLooper());
            }
            handler = mGG;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (dyl()) {
            runnable.run();
        } else {
            dyk().post(runnable);
        }
    }

    public static void A(Runnable runnable) {
        dyk().post(runnable);
    }

    public static boolean dyl() {
        return dyk().getLooper() == Looper.myLooper();
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
