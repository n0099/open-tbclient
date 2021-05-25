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
    public static final Object f22252a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final HandlerThread f22253b = new HandlerThread("TurboNetInit");

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f22254c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f22255d = false;

    /* renamed from: e  reason: collision with root package name */
    public static List<Runnable> f22256e = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f22257e;

        public a(Context context) {
            this.f22257e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetLibraryLoader.b(this.f22257e);
        }
    }

    public static void a(Context context, TurbonetEngine.Builder builder) {
        synchronized (f22252a) {
            if (f22254c) {
                return;
            }
            f22254c = true;
            ContextUtils.b(context.getApplicationContext());
            builder.n();
            ContextUtils.c();
            d.a.o0.a.a.h("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
            ContextUtils.b(context.getApplicationContext());
            if (!f22253b.isAlive()) {
                f22253b.start();
            }
            e(new a(context));
        }
    }

    public static void b(Context context) {
        if (f22255d) {
            return;
        }
        NetworkChangeNotifier.init(context);
        NetworkChangeNotifier.n();
        nativeCronetInitOnInitThread();
        for (Runnable runnable : f22256e) {
            runnable.run();
        }
        f22256e.clear();
        f22255d = true;
    }

    public static long c() {
        if (f22255d) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    public static boolean d() {
        return f22253b.getLooper() == Looper.myLooper();
    }

    public static void e(Runnable runnable) {
        if (d()) {
            runnable.run();
        } else {
            new Handler(f22253b.getLooper()).post(runnable);
        }
    }

    public static native void nativeCronetInitOnInitThread();

    public static native String nativeGetCronetVersion();

    public static native long nativeGetTurboNetHandler();

    public static native String nativeGetTurboNetVersion();
}
