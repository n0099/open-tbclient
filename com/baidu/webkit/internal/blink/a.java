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
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.File;
/* loaded from: classes9.dex */
public abstract class a {
    public WebKitFactory.WebkitInstallListener a;
    public EngineManager b;
    public int c = 13;

    public a(EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        this.b = engineManager;
        this.a = webkitInstallListener;
    }

    private boolean e() {
        String d = d();
        if (d == null) {
            return false;
        }
        String downloadLibPath = UtilsBlink.getDownloadLibPath(WebKitFactory.getContext());
        for (String str : GlobalConstants.LIB_ZEUS_SO) {
            String str2 = downloadLibPath + str;
            if (new File(str2).exists() && !com.baidu.webkit.internal.utils.a.a(str2)) {
                WebKitFactory.getLoadErrorCode().addDownloadInfo("1015 : ".concat(String.valueOf(str2)));
                return false;
            }
        }
        if (!UtilsBlink.createDownloadLibPath(WebKitFactory.getContext())) {
            WebKitFactory.getLoadErrorCode().addDownloadInfo(1016);
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install create path failed");
            return false;
        }
        boolean unZip = ZipUtils.getInstance().unZip(WebKitFactory.getContext(), d, downloadLibPath, false);
        if (!unZip) {
            WebKitFactory.getLoadErrorCode().addDownloadInfo(1017);
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install unzip failed");
            this.c = 6;
        }
        return unZip;
    }

    public final boolean a() {
        String d = d();
        if (TextUtils.isEmpty(d)) {
            return false;
        }
        if (!new File(d).exists()) {
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.installSync file not exist");
            return false;
        }
        EngineManager engineManager = this.b;
        if (engineManager != null) {
            engineManager.onInstallStart(d);
        }
        WebKitFactory.WebkitInstallListener webkitInstallListener = this.a;
        if (webkitInstallListener != null) {
            webkitInstallListener.onInstallStart();
        }
        if (!c()) {
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install init failed");
        }
        boolean e = e();
        Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install result=".concat(String.valueOf(e)));
        if (e) {
            this.c = 0;
            ZeusWebViewPreloadClass.getInstance().deleteSavingClassesFile();
        }
        WebKitFactory.WebkitInstallListener webkitInstallListener2 = this.a;
        if (webkitInstallListener2 != null) {
            int i = this.c;
            if (i == 0) {
                this.a.onInstallFinish(this.c, UtilsBlink.getDownloadLibPath(WebKitFactory.getContext()));
            } else {
                webkitInstallListener2.onInstallFinish(i, null);
            }
        }
        EngineManager engineManager2 = this.b;
        if (engineManager2 != null) {
            engineManager2.onInstallFinish(this.c == 0);
        }
        ZeusPerformanceTiming.setZeusDownloadInfo(WebKitFactory.getLoadErrorCode().getDownloadInfo());
        ZeusPerformanceTiming.recordDownloadInitStatistics();
        return e;
    }

    public final void b() {
        Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.installAsync");
        if (this.b == null || WebKitFactory.getContext() == null) {
            WebKitFactory.getLoadErrorCode().addDownloadInfo(1012);
            WebKitFactory.WebkitInstallListener webkitInstallListener = this.a;
            if (webkitInstallListener != null) {
                webkitInstallListener.onInstallFinish(13, null);
                return;
            }
            return;
        }
        String d = d();
        if (TextUtils.isEmpty(d)) {
            WebKitFactory.getLoadErrorCode().addDownloadInfo(1013);
        } else if (!new File(d).exists()) {
            WebKitFactory.getLoadErrorCode().addDownloadInfo(1014);
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.installAsync file not exist");
        } else {
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
    }

    public abstract boolean c();

    public abstract String d();
}
