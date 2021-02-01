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
/* loaded from: classes6.dex */
class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static volatile boolean oPm;
    private static List<Runnable> oPn;
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
        oPm = false;
        sInitThreadInitDone = false;
        oPn = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long ega() {
        if (sInitThreadInitDone) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (sLoadLock) {
            if (!oPm) {
                oPm = true;
                ContextUtils.initApplicationContext(context.getApplicationContext());
                builder.egH();
                ContextUtils.efR();
                com.baidu.turbonet.base.a.i("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.initApplicationContext(context.getApplicationContext());
                if (!sInitThread.isAlive()) {
                    sInitThread.start();
                }
                postToInitThread(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.hm(context);
                    }
                });
            }
        }
    }

    private static boolean egb() {
        return sInitThread.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void hm(Context context) {
        if (!$assertionsDisabled && !oPm) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !egb()) {
            throw new AssertionError();
        }
        if (!sInitThreadInitDone) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.egn();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : oPn) {
                runnable.run();
            }
            oPn.clear();
            sInitThreadInitDone = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void postToInitThread(Runnable runnable) {
        if (egb()) {
            runnable.run();
        } else {
            new Handler(sInitThread.getLooper()).post(runnable);
        }
    }
}
