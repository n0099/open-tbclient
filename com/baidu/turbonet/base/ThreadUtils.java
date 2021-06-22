package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes5.dex */
public class ThreadUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f22405a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f22406b = false;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f22407c;

    public static Handler a() {
        Handler handler;
        synchronized (f22405a) {
            if (f22407c == null) {
                if (!f22406b) {
                    f22407c = new Handler(Looper.getMainLooper());
                } else {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
            }
            handler = f22407c;
        }
        return handler;
    }

    public static void b(Runnable runnable) {
        a().post(runnable);
    }

    public static void c(Runnable runnable) {
        if (d()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }

    public static boolean d() {
        return a().getLooper() == Looper.myLooper();
    }

    @CalledByNative
    public static boolean isThreadPriorityAudio(int i2) {
        return Process.getThreadPriority(i2) == -16;
    }

    @CalledByNative
    public static void setThreadPriorityAudio(int i2) {
        Process.setThreadPriority(i2, -16);
    }
}
