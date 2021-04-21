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
    public static final Object f22385a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final HandlerThread f22386b = new HandlerThread("TurboNetInit");

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f22387c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f22388d = false;

    /* renamed from: e  reason: collision with root package name */
    public static List<Runnable> f22389e = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f22390e;

        public a(Context context) {
            this.f22390e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetLibraryLoader.b(this.f22390e);
        }
    }

    public static void a(Context context, TurbonetEngine.Builder builder) {
        synchronized (f22385a) {
            if (f22387c) {
                return;
            }
            f22387c = true;
            ContextUtils.b(context.getApplicationContext());
            builder.n();
            ContextUtils.c();
            d.b.k0.a.a.h("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
            ContextUtils.b(context.getApplicationContext());
            if (!f22386b.isAlive()) {
                f22386b.start();
            }
            e(new a(context));
        }
    }

    public static void b(Context context) {
        if (f22388d) {
            return;
        }
        NetworkChangeNotifier.init(context);
        NetworkChangeNotifier.n();
        nativeCronetInitOnInitThread();
        for (Runnable runnable : f22389e) {
            runnable.run();
        }
        f22389e.clear();
        f22388d = true;
    }

    public static long c() {
        if (f22388d) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    public static boolean d() {
        return f22386b.getLooper() == Looper.myLooper();
    }

    public static void e(Runnable runnable) {
        if (d()) {
            runnable.run();
        } else {
            new Handler(f22386b.getLooper()).post(runnable);
        }
    }

    public static native void nativeCronetInitOnInitThread();

    public static native String nativeGetCronetVersion();

    public static native long nativeGetTurboNetHandler();

    public static native String nativeGetTurboNetVersion();
}
