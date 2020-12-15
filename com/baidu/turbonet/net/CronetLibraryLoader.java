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
    private static final Object oCq;
    private static final HandlerThread oCr;
    private static volatile boolean oCs;
    private static boolean oCt;
    private static List<Runnable> oCu;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        oCq = new Object();
        oCr = new HandlerThread("TurboNetInit");
        oCs = false;
        oCt = false;
        oCu = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long eha() {
        if (oCt) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (oCq) {
            if (!oCs) {
                oCs = true;
                ContextUtils.gR(context.getApplicationContext());
                builder.ehR();
                ContextUtils.egL();
                com.baidu.turbonet.base.a.f("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.gR(context.getApplicationContext());
                if (!oCr.isAlive()) {
                    oCr.start();
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

    private static boolean ehb() {
        return oCr.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void gU(Context context) {
        if (!$assertionsDisabled && !oCs) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !ehb()) {
            throw new AssertionError();
        }
        if (!oCt) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.ehx();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : oCu) {
                runnable.run();
            }
            oCu.clear();
            oCt = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void A(Runnable runnable) {
        if (ehb()) {
            runnable.run();
        } else {
            new Handler(oCr.getLooper()).post(runnable);
        }
    }
}
