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
/* loaded from: classes12.dex */
class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object onq;
    private static final HandlerThread onr;
    private static volatile boolean ons;
    private static boolean ont;
    private static List<Runnable> onu;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        onq = new Object();
        onr = new HandlerThread("TurboNetInit");
        ons = false;
        ont = false;
        onu = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long ebu() {
        if (ont) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (onq) {
            if (!ons) {
                ons = true;
                ContextUtils.gh(context.getApplicationContext());
                builder.ecl();
                ContextUtils.ebf();
                com.baidu.turbonet.base.a.f("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.gh(context.getApplicationContext());
                if (!onr.isAlive()) {
                    onr.start();
                }
                A(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.gk(context);
                    }
                });
            }
        }
    }

    private static boolean ebv() {
        return onr.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void gk(Context context) {
        if (!$assertionsDisabled && !ons) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !ebv()) {
            throw new AssertionError();
        }
        if (!ont) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.ebR();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : onu) {
                runnable.run();
            }
            onu.clear();
            ont = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void A(Runnable runnable) {
        if (ebv()) {
            runnable.run();
        } else {
            new Handler(onr.getLooper()).post(runnable);
        }
    }
}
