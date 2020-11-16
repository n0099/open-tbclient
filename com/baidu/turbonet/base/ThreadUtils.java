package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes12.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean omA;
    private static Handler omB;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        omA = false;
        omB = null;
    }

    private static Handler ebp() {
        Handler handler;
        synchronized (sLock) {
            if (omB == null) {
                if (omA) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                omB = new Handler(Looper.getMainLooper());
            }
            handler = omB;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (ebq()) {
            runnable.run();
        } else {
            ebp().post(runnable);
        }
    }

    public static void y(Runnable runnable) {
        ebp().post(runnable);
    }

    public static boolean ebq() {
        return ebp().getLooper() == Looper.myLooper();
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
