package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes17.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean okX;
    private static Handler okY;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        okX = false;
        okY = null;
    }

    private static Handler ebq() {
        Handler handler;
        synchronized (sLock) {
            if (okY == null) {
                if (okX) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                okY = new Handler(Looper.getMainLooper());
            }
            handler = okY;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (ebr()) {
            runnable.run();
        } else {
            ebq().post(runnable);
        }
    }

    public static void y(Runnable runnable) {
        ebq().post(runnable);
    }

    public static boolean ebr() {
        return ebq().getLooper() == Looper.myLooper();
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
