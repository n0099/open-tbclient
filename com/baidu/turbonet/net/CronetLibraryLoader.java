package com.baidu.turbonet.net;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.baidu.turbonet.base.ContextUtils;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.net.TurbonetEngine;
import java.util.ArrayList;
import java.util.List;
@JNINamespace
/* loaded from: classes5.dex */
public class CronetLibraryLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f22323a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final HandlerThread f22324b = new HandlerThread("TurboNetInit");

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f22325c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f22326d = false;

    /* renamed from: e  reason: collision with root package name */
    public static List<Runnable> f22327e = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f22328e;

        public a(Context context) {
            this.f22328e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetLibraryLoader.b(this.f22328e);
        }
    }

    public static void a(Context context, TurbonetEngine.Builder builder) {
        synchronized (f22323a) {
            if (f22325c) {
                return;
            }
            f22325c = true;
            ContextUtils.b(context.getApplicationContext());
            builder.n();
            ContextUtils.c();
            d.a.l0.a.a.h("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
            ContextUtils.b(context.getApplicationContext());
            if (!f22324b.isAlive()) {
                f22324b.start();
            }
            e(new a(context));
        }
    }

    public static void b(Context context) {
        if (f22326d) {
            return;
        }
        NetworkChangeNotifier.init(context);
        NetworkChangeNotifier.n();
        nativeCronetInitOnInitThread();
        for (Runnable runnable : f22327e) {
            runnable.run();
        }
        f22327e.clear();
        f22326d = true;
    }

    public static long c() {
        if (f22326d) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    public static boolean d() {
        return f22324b.getLooper() == Looper.myLooper();
    }

    public static void e(Runnable runnable) {
        if (d()) {
            runnable.run();
        } else {
            new Handler(f22324b.getLooper()).post(runnable);
        }
    }

    public static native void nativeCronetInitOnInitThread();

    public static native String nativeGetCronetVersion();

    public static native long nativeGetTurboNetHandler();

    public static native String nativeGetTurboNetVersion();
}
