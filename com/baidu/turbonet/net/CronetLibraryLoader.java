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
    private static final Object mzk;
    private static final HandlerThread mzl;
    private static volatile boolean mzm;
    private static boolean mzn;
    private static List<Runnable> mzo;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        mzk = new Object();
        mzl = new HandlerThread("TurboNetInit");
        mzm = false;
        mzn = false;
        mzo = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long duX() {
        if (mzn) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (mzk) {
            if (!mzm) {
                mzm = true;
                ContextUtils.fC(context.getApplicationContext());
                builder.dvP();
                ContextUtils.duI();
                com.baidu.turbonet.base.a.g("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.fC(context.getApplicationContext());
                if (!mzl.isAlive()) {
                    mzl.start();
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

    private static boolean duY() {
        return mzl.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fF(Context context) {
        if (!$assertionsDisabled && !mzm) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !duY()) {
            throw new AssertionError();
        }
        if (!mzn) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.dvu();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : mzo) {
                runnable.run();
            }
            mzo.clear();
            mzn = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void D(Runnable runnable) {
        if (duY()) {
            runnable.run();
        } else {
            new Handler(mzl.getLooper()).post(runnable);
        }
    }
}
