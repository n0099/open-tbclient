package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes19.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean mGD;
    private static Handler mGE;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        mGD = false;
        mGE = null;
    }

    private static Handler dyj() {
        Handler handler;
        synchronized (sLock) {
            if (mGE == null) {
                if (mGD) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                mGE = new Handler(Looper.getMainLooper());
            }
            handler = mGE;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (dyk()) {
            runnable.run();
        } else {
            dyj().post(runnable);
        }
    }

    public static void A(Runnable runnable) {
        dyj().post(runnable);
    }

    public static boolean dyk() {
        return dyj().getLooper() == Looper.myLooper();
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
