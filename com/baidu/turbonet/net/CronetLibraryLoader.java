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
/* loaded from: classes4.dex */
class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static volatile boolean oFd;
    private static List<Runnable> oFe;
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
        oFd = false;
        sInitThreadInitDone = false;
        oFe = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long edI() {
        if (sInitThreadInitDone) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (sLoadLock) {
            if (!oFd) {
                oFd = true;
                ContextUtils.initApplicationContext(context.getApplicationContext());
                builder.eep();
                ContextUtils.edz();
                com.baidu.turbonet.base.a.i("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.initApplicationContext(context.getApplicationContext());
                if (!sInitThread.isAlive()) {
                    sInitThread.start();
                }
                postToInitThread(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.hj(context);
                    }
                });
            }
        }
    }

    private static boolean edJ() {
        return sInitThread.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void hj(Context context) {
        if (!$assertionsDisabled && !oFd) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !edJ()) {
            throw new AssertionError();
        }
        if (!sInitThreadInitDone) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.edV();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : oFe) {
                runnable.run();
            }
            oFe.clear();
            sInitThreadInitDone = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void postToInitThread(Runnable runnable) {
        if (edJ()) {
            runnable.run();
        } else {
            new Handler(sInitThread.getLooper()).post(runnable);
        }
    }
}
