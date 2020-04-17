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
/* loaded from: classes.dex */
class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object lIQ;
    private static final HandlerThread lIR;
    private static volatile boolean lIS;
    private static boolean lIT;
    private static List<Runnable> lIU;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        lIQ = new Object();
        lIR = new HandlerThread("TurboNetInit");
        lIS = false;
        lIT = false;
        lIU = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long diQ() {
        if (lIT) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (lIQ) {
            if (!lIS) {
                lIS = true;
                ContextUtils.fy(context.getApplicationContext());
                builder.djI();
                ContextUtils.diA();
                com.baidu.turbonet.base.a.g("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.fy(context.getApplicationContext());
                if (!lIR.isAlive()) {
                    lIR.start();
                }
                B(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.fB(context);
                    }
                });
            }
        }
    }

    private static boolean diR() {
        return lIR.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fB(Context context) {
        if (!$assertionsDisabled && !lIS) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !diR()) {
            throw new AssertionError();
        }
        if (!lIT) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.djn();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : lIU) {
                runnable.run();
            }
            lIU.clear();
            lIT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void B(Runnable runnable) {
        if (diR()) {
            runnable.run();
        } else {
            new Handler(lIR.getLooper()).post(runnable);
        }
    }
}
