package com.baidu.turbonet.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes5.dex */
public class ThreadUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f22661a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f22662b = false;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f22663c;

    public static Handler a() {
        Handler handler;
        synchronized (f22661a) {
            if (f22663c == null) {
                if (!f22662b) {
                    f22663c = new Handler(Looper.getMainLooper());
                } else {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
            }
            handler = f22663c;
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
    public static boolean isThreadPriorityAudio(int i) {
        return Process.getThreadPriority(i) == -16;
    }

    @CalledByNative
    public static void setThreadPriorityAudio(int i) {
        Process.setThreadPriority(i, -16);
    }
}
