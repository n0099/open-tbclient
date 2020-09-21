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
/* loaded from: classes15.dex */
class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object nkK;
    private static final HandlerThread nkL;
    private static volatile boolean nkM;
    private static boolean nkN;
    private static List<Runnable> nkO;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        nkK = new Object();
        nkL = new HandlerThread("TurboNetInit");
        nkM = false;
        nkN = false;
        nkO = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long dOj() {
        if (nkN) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (nkK) {
            if (!nkM) {
                nkM = true;
                ContextUtils.fY(context.getApplicationContext());
                builder.dPb();
                ContextUtils.dNU();
                com.baidu.turbonet.base.a.f("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.fY(context.getApplicationContext());
                if (!nkL.isAlive()) {
                    nkL.start();
                }
                z(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.gb(context);
                    }
                });
            }
        }
    }

    private static boolean dOk() {
        return nkL.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void gb(Context context) {
        if (!$assertionsDisabled && !nkM) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !dOk()) {
            throw new AssertionError();
        }
        if (!nkN) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.dOG();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : nkO) {
                runnable.run();
            }
            nkO.clear();
            nkN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void z(Runnable runnable) {
        if (dOk()) {
            runnable.run();
        } else {
            new Handler(nkL.getLooper()).post(runnable);
        }
    }
}
