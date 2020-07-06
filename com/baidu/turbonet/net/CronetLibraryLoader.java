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
    private static final Object mzn;
    private static final HandlerThread mzo;
    private static volatile boolean mzp;
    private static boolean mzq;
    private static List<Runnable> mzr;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        mzn = new Object();
        mzo = new HandlerThread("TurboNetInit");
        mzp = false;
        mzq = false;
        mzr = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long dvb() {
        if (mzq) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (mzn) {
            if (!mzp) {
                mzp = true;
                ContextUtils.fC(context.getApplicationContext());
                builder.dvT();
                ContextUtils.duM();
                com.baidu.turbonet.base.a.g("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.fC(context.getApplicationContext());
                if (!mzo.isAlive()) {
                    mzo.start();
                }
                D(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.fF(context);
                    }
                });
            }
        }
    }

    private static boolean dvc() {
        return mzo.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fF(Context context) {
        if (!$assertionsDisabled && !mzp) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !dvc()) {
            throw new AssertionError();
        }
        if (!mzq) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.dvy();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : mzr) {
                runnable.run();
            }
            mzr.clear();
            mzq = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void D(Runnable runnable) {
        if (dvc()) {
            runnable.run();
        } else {
            new Handler(mzo.getLooper()).post(runnable);
        }
    }
}
