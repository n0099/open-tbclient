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
/* loaded from: classes19.dex */
class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object mHu;
    private static final HandlerThread mHv;
    private static volatile boolean mHw;
    private static boolean mHx;
    private static List<Runnable> mHy;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        mHu = new Object();
        mHv = new HandlerThread("TurboNetInit");
        mHw = false;
        mHx = false;
        mHy = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long dyp() {
        if (mHx) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (mHu) {
            if (!mHw) {
                mHw = true;
                ContextUtils.fF(context.getApplicationContext());
                builder.dzh();
                ContextUtils.dya();
                com.baidu.turbonet.base.a.g("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.fF(context.getApplicationContext());
                if (!mHv.isAlive()) {
                    mHv.start();
                }
                C(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.fI(context);
                    }
                });
            }
        }
    }

    private static boolean dyq() {
        return mHv.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fI(Context context) {
        if (!$assertionsDisabled && !mHw) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !dyq()) {
            throw new AssertionError();
        }
        if (!mHx) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.dyM();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : mHy) {
                runnable.run();
            }
            mHy.clear();
            mHx = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void C(Runnable runnable) {
        if (dyq()) {
            runnable.run();
        } else {
            new Handler(mHv.getLooper()).post(runnable);
        }
    }
}
