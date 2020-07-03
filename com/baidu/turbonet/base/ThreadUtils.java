package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean myv;
    private static Handler myw;
    private static final Object sLock;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
        myv = false;
        myw = null;
    }

    private static Handler duS() {
        Handler handler;
        synchronized (sLock) {
            if (myw == null) {
                if (myv) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                myw = new Handler(Looper.getMainLooper());
            }
            handler = myw;
        }
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (duT()) {
            runnable.run();
        } else {
            duS().post(runnable);
        }
    }

    public static void B(Runnable runnable) {
        duS().post(runnable);
    }

    public static boolean duT() {
        return duS().getLooper() == Looper.myLooper();
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
