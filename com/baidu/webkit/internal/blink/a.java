package com.baidu.webkit.internal.blink;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.baidu.webkit.internal.utils.ZipUtils;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public WebKitFactory.WebkitInstallListener f26670a;

    /* renamed from: b  reason: collision with root package name */
    public EngineManager f26671b;

    /* renamed from: c  reason: collision with root package name */
    public int f26672c = 13;

    public a(EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        this.f26671b = engineManager;
        this.f26670a = webkitInstallListener;
    }

    private boolean e() {
        String d2 = d();
        if (d2 == null) {
            return false;
        }
        String downloadLibPath = UtilsBlink.getDownloadLibPath(WebKitFactory.getContext());
        for (String str : GlobalConstants.LIB_ZEUS_SO) {
            String str2 = downloadLibPath + str;
            if (new File(str2).exists() && !com.baidu.webkit.internal.utils.a.a(str2)) {
                return false;
            }
        }
        if (!UtilsBlink.createDownloadLibPath(WebKitFactory.getContext())) {
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install create path failed");
            return false;
        }
        boolean unZip = ZipUtils.getInstance().unZip(WebKitFactory.getContext(), d2, downloadLibPath, false);
        if (!unZip) {
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install unzip failed");
            this.f26672c = 6;
        }
        return unZip;
    }

    public final boolean a() {
        String d2 = d();
        if (TextUtils.isEmpty(d2)) {
            return false;
        }
        if (!new File(d2).exists()) {
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.installSync file not exist");
            return false;
        }
        EngineManager engineManager = this.f26671b;
        if (engineManager != null) {
            engineManager.onInstallStart(d2);
        }
        WebKitFactory.WebkitInstallListener webkitInstallListener = this.f26670a;
        if (webkitInstallListener != null) {
            webkitInstallListener.onInstallStart();
        }
        if (!c()) {
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install init failed");
        }
        boolean e2 = e();
        Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install result=".concat(String.valueOf(e2)));
        if (e2) {
            this.f26672c = 0;
            ZeusWebViewPreloadClass.getInstance().deleteSavingClassesFile();
        }
        WebKitFactory.WebkitInstallListener webkitInstallListener2 = this.f26670a;
        if (webkitInstallListener2 != null) {
            int i2 = this.f26672c;
            if (i2 == 0) {
                this.f26670a.onInstallFinish(this.f26672c, UtilsBlink.getDownloadLibPath(WebKitFactory.getContext()));
            } else {
                webkitInstallListener2.onInstallFinish(i2, null);
            }
        }
        EngineManager engineManager2 = this.f26671b;
        if (engineManager2 != null) {
            engineManager2.onInstallFinish(this.f26672c == 0);
        }
        return e2;
    }

    public final void b() {
        Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.installAsync");
        if (this.f26671b == null || WebKitFactory.getContext() == null) {
            WebKitFactory.WebkitInstallListener webkitInstallListener = this.f26670a;
            if (webkitInstallListener != null) {
                webkitInstallListener.onInstallFinish(13, null);
                return;
            }
            return;
        }
        String d2 = d();
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        if (!new File(d2).exists()) {
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.installAsync file not exist");
            return;
        }
        final HandlerThread handlerThread = new HandlerThread("T7@ZeusInstaller");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: com.baidu.webkit.internal.blink.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a();
                handlerThread.quit();
            }
        });
    }

    public abstract boolean c();

    public abstract String d();
}
