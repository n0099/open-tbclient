package com.bytedance.pangle.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes9.dex */
public class k {
    public static final /* synthetic */ boolean a = !k.class.desiredAssertionStatus();
    public static final Object b = new Object();
    public static Handler c = null;

    public static Handler a() {
        Handler handler;
        synchronized (b) {
            if (c == null) {
                c = new Handler(Looper.getMainLooper());
            }
            handler = c;
        }
        return handler;
    }

    public static void a(Runnable runnable) {
        boolean z;
        if (a().getLooper() == Looper.myLooper()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }
}
