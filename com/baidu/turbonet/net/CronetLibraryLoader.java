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
    private static final Object olM;
    private static final HandlerThread olN;
    private static volatile boolean olO;
    private static boolean olP;
    private static List<Runnable> olQ;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        olM = new Object();
        olN = new HandlerThread("TurboNetInit");
        olO = false;
        olP = false;
        olQ = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long ebv() {
        if (olP) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (olM) {
            if (!olO) {
                olO = true;
                ContextUtils.gi(context.getApplicationContext());
                builder.ecm();
                ContextUtils.ebg();
                com.baidu.turbonet.base.a.f("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.gi(context.getApplicationContext());
                if (!olN.isAlive()) {
                    olN.start();
                }
                A(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.gl(context);
                    }
                });
            }
        }
    }

    private static boolean ebw() {
        return olN.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void gl(Context context) {
        if (!$assertionsDisabled && !olO) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !ebw()) {
            throw new AssertionError();
        }
        if (!olP) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.ebS();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : olQ) {
                runnable.run();
            }
            olQ.clear();
            olP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void A(Runnable runnable) {
        if (ebw()) {
            runnable.run();
        } else {
            new Handler(olN.getLooper()).post(runnable);
        }
    }
}
