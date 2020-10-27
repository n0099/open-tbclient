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
    private static final Object ocI;
    private static final HandlerThread ocJ;
    private static volatile boolean ocK;
    private static boolean ocL;
    private static List<Runnable> ocM;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        ocI = new Object();
        ocJ = new HandlerThread("TurboNetInit");
        ocK = false;
        ocL = false;
        ocM = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long dXN() {
        if (ocL) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (ocI) {
            if (!ocK) {
                ocK = true;
                ContextUtils.gi(context.getApplicationContext());
                builder.dYE();
                ContextUtils.dXy();
                com.baidu.turbonet.base.a.f("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.gi(context.getApplicationContext());
                if (!ocJ.isAlive()) {
                    ocJ.start();
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

    private static boolean dXO() {
        return ocJ.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void gl(Context context) {
        if (!$assertionsDisabled && !ocK) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !dXO()) {
            throw new AssertionError();
        }
        if (!ocL) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.dYk();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : ocM) {
                runnable.run();
            }
            ocM.clear();
            ocL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void A(Runnable runnable) {
        if (dXO()) {
            runnable.run();
        } else {
            new Handler(ocJ.getLooper()).post(runnable);
        }
    }
}
