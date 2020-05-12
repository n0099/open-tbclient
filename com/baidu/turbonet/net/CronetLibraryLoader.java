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
    private static final Object lIU;
    private static final HandlerThread lIV;
    private static volatile boolean lIW;
    private static boolean lIX;
    private static List<Runnable> lIY;

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static native long nativeGetTurboNetHandler();

    private static native String nativeGetTurboNetVersion();

    static {
        $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
        lIU = new Object();
        lIV = new HandlerThread("TurboNetInit");
        lIW = false;
        lIX = false;
        lIY = new ArrayList();
    }

    CronetLibraryLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long diO() {
        if (lIX) {
            return nativeGetTurboNetHandler();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, TurbonetEngine.Builder builder) {
        synchronized (lIU) {
            if (!lIW) {
                lIW = true;
                ContextUtils.fm(context.getApplicationContext());
                builder.djG();
                ContextUtils.diy();
                com.baidu.turbonet.base.a.g("TurboNetLibraryLoader", "TurboNet version: %s, arch: %s", nativeGetTurboNetVersion(), System.getProperty("os.arch"));
                ContextUtils.fm(context.getApplicationContext());
                if (!lIV.isAlive()) {
                    lIV.start();
                }
                B(new Runnable() { // from class: com.baidu.turbonet.net.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.fp(context);
                    }
                });
            }
        }
    }

    private static boolean diP() {
        return lIV.getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fp(Context context) {
        if (!$assertionsDisabled && !lIW) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !diP()) {
            throw new AssertionError();
        }
        if (!lIX) {
            NetworkChangeNotifier.init(context);
            NetworkChangeNotifier.djl();
            nativeCronetInitOnInitThread();
            for (Runnable runnable : lIY) {
                runnable.run();
            }
            lIY.clear();
            lIX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void B(Runnable runnable) {
        if (diP()) {
            runnable.run();
        } else {
            new Handler(lIV.getLooper()).post(runnable);
        }
    }
}
