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
/* loaded from: classes14.dex */
class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object oCo;
    private static final HandlerThread oCp;
    private static volatile boolean oCq;
    private static boolean oCr;
    private static List<Runnable> oCs;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        oCo = new Object();
        oCp = new HandlerThread("TurboNetInit");
        oCq = false;
        oCr = false;
        oCs = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long egZ() {
        if (oCr) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (oCo) {
            if (!oCq) {
                oCq = true;
                ContextUtils.gR(context.getApplicationContext());
                builder.ehQ();
                ContextUtils.egK();
                com.baidu.turbonet.base.a.f("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.gR(context.getApplicationContext());
                if (!oCp.isAlive()) {
                    oCp.start();
                }
                A(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.gU(context);
                    }
                });
            }
        }
    }

    private static boolean eha() {
        return oCp.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void gU(Context context) {
        if (!$assertionsDisabled && !oCq) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !eha()) {
            throw new AssertionError();
        }
        if (!oCr) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.ehw();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : oCs) {
                runnable.run();
            }
            oCs.clear();
            oCr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void A(Runnable runnable) {
        if (eha()) {
            runnable.run();
        } else {
            new Handler(oCp.getLooper()).post(runnable);
        }
    }
}
