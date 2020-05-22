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
    private static final Object mcl;
    private static final HandlerThread mcm;
    private static volatile boolean mcn;
    private static boolean mco;
    private static List<Runnable> mcp;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        mcl = new Object();
        mcm = new HandlerThread("TurboNetInit");
        mcn = false;
        mco = false;
        mcp = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long dqe() {
        if (mco) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (mcl) {
            if (!mcn) {
                mcn = true;
                ContextUtils.fB(context.getApplicationContext());
                builder.dqW();
                ContextUtils.dpP();
                com.baidu.turbonet.base.a.g("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.fB(context.getApplicationContext());
                if (!mcm.isAlive()) {
                    mcm.start();
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

    private static boolean dqf() {
        return mcm.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fE(Context context) {
        if (!$assertionsDisabled && !mcn) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !dqf()) {
            throw new AssertionError();
        }
        if (!mco) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.dqB();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : mcp) {
                runnable.run();
            }
            mcp.clear();
            mco = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void D(Runnable runnable) {
        if (dqf()) {
            runnable.run();
        } else {
            new Handler(mcm.getLooper()).post(runnable);
        }
    }
}
