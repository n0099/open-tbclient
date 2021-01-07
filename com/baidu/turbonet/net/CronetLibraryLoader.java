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
    private static volatile boolean oJH;
    private static List<Runnable> oJI;
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
        oJH = false;
        sInitThreadInitDone = false;
        oJI = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long ehA() {
        if (sInitThreadInitDone) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (sLoadLock) {
            if (!oJH) {
                oJH = true;
                ContextUtils.initApplicationContext(context.getApplicationContext());
                builder.eih();
                ContextUtils.ehr();
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

    private static boolean ehB() {
        return sInitThread.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void hl(Context context) {
        if (!$assertionsDisabled && !oJH) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !ehB()) {
            throw new AssertionError();
        }
        if (!sInitThreadInitDone) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.ehN();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : oJI) {
                runnable.run();
            }
            oJI.clear();
            sInitThreadInitDone = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void postToInitThread(Runnable runnable) {
        if (ehB()) {
            runnable.run();
        } else {
            new Handler(sInitThread.getLooper()).post(runnable);
        }
    }
}
