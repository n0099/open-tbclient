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
    private static final Object mHs;
    private static final HandlerThread mHt;
    private static volatile boolean mHu;
    private static boolean mHv;
    private static List<Runnable> mHw;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        mHs = new Object();
        mHt = new HandlerThread("TurboNetInit");
        mHu = false;
        mHv = false;
        mHw = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long dyo() {
        if (mHv) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (mHs) {
            if (!mHu) {
                mHu = true;
                ContextUtils.fF(context.getApplicationContext());
                builder.dzg();
                ContextUtils.dxZ();
                com.baidu.turbonet.base.a.g("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.fF(context.getApplicationContext());
                if (!mHt.isAlive()) {
                    mHt.start();
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

    private static boolean dyp() {
        return mHt.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fI(Context context) {
        if (!$assertionsDisabled && !mHu) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !dyp()) {
            throw new AssertionError();
        }
        if (!mHv) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.dyL();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : mHw) {
                runnable.run();
            }
            mHw.clear();
            mHv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void C(Runnable runnable) {
        if (dyp()) {
            runnable.run();
        } else {
            new Handler(mHt.getLooper()).post(runnable);
        }
    }
}
