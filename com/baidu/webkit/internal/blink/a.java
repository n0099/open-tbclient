package com.baidu.webkit.internal.blink;

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
    public WebKitFactory.WebkitInstallListener f27381a;

    /* renamed from: b  reason: collision with root package name */
    public EngineManager f27382b;

    /* renamed from: c  reason: collision with root package name */
    public int f27383c = 13;

    public a(EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        this.f27382b = engineManager;
        this.f27381a = webkitInstallListener;
    }

    public final boolean a() {
        boolean unZip;
        EngineManager engineManager = this.f27382b;
        if (engineManager != null) {
            engineManager.onInstallStart();
        }
        WebKitFactory.WebkitInstallListener webkitInstallListener = this.f27381a;
        if (webkitInstallListener != null) {
            webkitInstallListener.onInstallStart();
        }
        if (!b()) {
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install init failed");
        }
        String c2 = c();
        if (c2 != null) {
            String downloadLibPath = UtilsBlink.getDownloadLibPath(WebKitFactory.getContext());
            String[] strArr = GlobalConstants.LIB_ZEUS_SO;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    String str = downloadLibPath + strArr[i2];
                    if (new File(str).exists() && !com.baidu.webkit.internal.utils.a.a(str)) {
                        break;
                    }
                    i2++;
                } else if (UtilsBlink.createDownloadLibPath(WebKitFactory.getContext())) {
                    unZip = ZipUtils.getInstance().unZip(WebKitFactory.getContext(), c2, downloadLibPath, false);
                    if (!unZip) {
                        Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install unzip failed");
                        this.f27383c = 6;
                    }
                } else {
                    Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install create path failed");
                }
            }
        }
        unZip = false;
        Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install result=" + unZip);
        if (unZip) {
            this.f27383c = 0;
            ZeusWebViewPreloadClass.getInstance().deleteSavingClassesFile();
        }
        WebKitFactory.WebkitInstallListener webkitInstallListener2 = this.f27381a;
        if (webkitInstallListener2 != null) {
            int i3 = this.f27383c;
            if (i3 == 0) {
                this.f27381a.onInstallFinish(this.f27383c, UtilsBlink.getDownloadLibPath(WebKitFactory.getContext()));
            } else {
                webkitInstallListener2.onInstallFinish(i3, null);
            }
        }
        EngineManager engineManager2 = this.f27382b;
        if (engineManager2 != null) {
            engineManager2.onInstallFinish(this.f27383c == 0);
        }
        return unZip;
    }

    public abstract boolean b();

    public abstract String c();
}
