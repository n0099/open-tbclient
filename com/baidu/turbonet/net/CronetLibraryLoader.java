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
    private static final Object mdv;
    private static final HandlerThread mdw;
    private static volatile boolean mdx;
    private static boolean mdy;
    private static List<Runnable> mdz;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        mdv = new Object();
        mdw = new HandlerThread("TurboNetInit");
        mdx = false;
        mdy = false;
        mdz = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long dqs() {
        if (mdy) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (mdv) {
            if (!mdx) {
                mdx = true;
                ContextUtils.fB(context.getApplicationContext());
                builder.drk();
                ContextUtils.dqd();
                com.baidu.turbonet.base.a.g("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.fB(context.getApplicationContext());
                if (!mdw.isAlive()) {
                    mdw.start();
                }
                D(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.fE(context);
                    }
                });
            }
        }
    }

    private static boolean dqt() {
        return mdw.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fE(Context context) {
        if (!$assertionsDisabled && !mdx) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !dqt()) {
            throw new AssertionError();
        }
        if (!mdy) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.dqP();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : mdz) {
                runnable.run();
            }
            mdz.clear();
            mdy = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void D(Runnable runnable) {
        if (dqt()) {
            runnable.run();
        } else {
            new Handler(mdw.getLooper()).post(runnable);
        }
    }
}
