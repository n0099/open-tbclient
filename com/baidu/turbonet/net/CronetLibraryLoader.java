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
/* loaded from: classes17.dex */
class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object nAh;
    private static final HandlerThread nAi;
    private static volatile boolean nAj;
    private static boolean nAk;
    private static List<Runnable> nAl;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        nAh = new Object();
        nAi = new HandlerThread("TurboNetInit");
        nAj = false;
        nAk = false;
        nAl = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long dRV() {
        if (nAk) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (nAh) {
            if (!nAj) {
                nAj = true;
                ContextUtils.gg(context.getApplicationContext());
                builder.dSM();
                ContextUtils.dRG();
                com.baidu.turbonet.base.a.f("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.gg(context.getApplicationContext());
                if (!nAi.isAlive()) {
                    nAi.start();
                }
                z(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.gj(context);
                    }
                });
            }
        }
    }

    private static boolean dRW() {
        return nAi.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void gj(Context context) {
        if (!$assertionsDisabled && !nAj) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !dRW()) {
            throw new AssertionError();
        }
        if (!nAk) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.dSs();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : nAl) {
                runnable.run();
            }
            nAl.clear();
            nAk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void z(Runnable runnable) {
        if (dRW()) {
            runnable.run();
        } else {
            new Handler(nAi.getLooper()).post(runnable);
        }
    }
}
