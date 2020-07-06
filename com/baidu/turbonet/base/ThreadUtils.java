package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean myy;
    private static Handler myz;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        myy = false;
        myz = null;
    }

    private static Handler duW() {
        Handler handler;
        synchronized (sLock) {
            if (myz == null) {
                if (myy) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                myz = new Handler(Looper.getMainLooper());
            }
            handler = myz;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (duX()) {
            runnable.run();
        } else {
            duW().post(runnable);
        }
    }

    public static void B(Runnable runnable) {
        duW().post(runnable);
    }

    public static boolean duX() {
        return duW().getLooper() == Looper.myLooper();
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
