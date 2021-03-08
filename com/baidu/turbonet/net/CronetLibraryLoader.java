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
/* loaded from: classes5.dex */
class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static volatile boolean oRR;
    private static List<Runnable> oRS;
    private static final HandlerThread sInitThread;
    private static boolean sInitThreadInitDone;
    private static final Object sLoadLock;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        sLoadLock = new Object();
        sInitThread = new HandlerThread("TurboNetInit");
        oRR = false;
        sInitThreadInitDone = false;
        oRS = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long egq() {
        if (sInitThreadInitDone) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (sLoadLock) {
            if (!oRR) {
                oRR = true;
                ContextUtils.initApplicationContext(context.getApplicationContext());
                builder.egX();
                ContextUtils.egh();
                com.baidu.turbonet.base.a.i("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.initApplicationContext(context.getApplicationContext());
                if (!sInitThread.isAlive()) {
                    sInitThread.start();
                }
                postToInitThread(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.hl(context);
                    }
                });
            }
        }
    }

    private static boolean egr() {
        return sInitThread.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void hl(Context context) {
        if (!$assertionsDisabled && !oRR) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !egr()) {
            throw new AssertionError();
        }
        if (!sInitThreadInitDone) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.egD();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : oRS) {
                runnable.run();
            }
            oRS.clear();
            sInitThreadInitDone = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void postToInitThread(Runnable runnable) {
        if (egr()) {
            runnable.run();
        } else {
            new Handler(sInitThread.getLooper()).post(runnable);
        }
    }
}
