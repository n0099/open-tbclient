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
    private static final Object nat;
    private static final HandlerThread nau;
    private static volatile boolean nav;
    private static boolean naw;
    private static List<Runnable> nax;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        nat = new Object();
        nau = new HandlerThread("TurboNetInit");
        nav = false;
        naw = false;
        nax = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long dKc() {
        if (naw) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (nat) {
            if (!nav) {
                nav = true;
                ContextUtils.fS(context.getApplicationContext());
                builder.dKU();
                ContextUtils.dJN();
                com.baidu.turbonet.base.a.f("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.fS(context.getApplicationContext());
                if (!nau.isAlive()) {
                    nau.start();
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

    private static boolean dKd() {
        return nau.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fV(Context context) {
        if (!$assertionsDisabled && !nav) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !dKd()) {
            throw new AssertionError();
        }
        if (!naw) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.dKz();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : nax) {
                runnable.run();
            }
            nax.clear();
            naw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void z(Runnable runnable) {
        if (dKd()) {
            runnable.run();
        } else {
            new Handler(nau.getLooper()).post(runnable);
        }
    }
}
