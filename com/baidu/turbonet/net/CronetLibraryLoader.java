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
/* loaded from: classes10.dex */
class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object naL;
    private static final HandlerThread naM;
    private static volatile boolean naN;
    private static boolean naO;
    private static List<Runnable> naP;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        naL = new Object();
        naM = new HandlerThread("TurboNetInit");
        naN = false;
        naO = false;
        naP = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long dKl() {
        if (naO) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (naL) {
            if (!naN) {
                naN = true;
                ContextUtils.fS(context.getApplicationContext());
                builder.dLd();
                ContextUtils.dJW();
                com.baidu.turbonet.base.a.f("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.fS(context.getApplicationContext());
                if (!naM.isAlive()) {
                    naM.start();
                }
                z(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.fV(context);
                    }
                });
            }
        }
    }

    private static boolean dKm() {
        return naM.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fV(Context context) {
        if (!$assertionsDisabled && !naN) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !dKm()) {
            throw new AssertionError();
        }
        if (!naO) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.dKI();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : naP) {
                runnable.run();
            }
            naP.clear();
            naO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void z(Runnable runnable) {
        if (dKm()) {
            runnable.run();
        } else {
            new Handler(naM.getLooper()).post(runnable);
        }
    }
}
