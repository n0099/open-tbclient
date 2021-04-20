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
    public WebKitFactory.WebkitInstallListener f26566a;

    /* renamed from: b  reason: collision with root package name */
    public EngineManager f26567b;

    /* renamed from: c  reason: collision with root package name */
    public int f26568c = 13;

    public a(EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        this.f26567b = engineManager;
        this.f26566a = webkitInstallListener;
    }

    public final boolean a() {
        boolean unZip;
        EngineManager engineManager = this.f26567b;
        if (engineManager != null) {
            engineManager.onInstallStart();
        }
        WebKitFactory.WebkitInstallListener webkitInstallListener = this.f26566a;
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
            int i = 0;
            while (true) {
                if (i < length) {
                    String str = downloadLibPath + strArr[i];
                    if (new File(str).exists() && !com.baidu.webkit.internal.utils.a.a(str)) {
                        break;
                    }
                    i++;
                } else if (UtilsBlink.createDownloadLibPath(WebKitFactory.getContext())) {
                    unZip = ZipUtils.getInstance().unZip(WebKitFactory.getContext(), c2, downloadLibPath, false);
                    if (!unZip) {
                        Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install unzip failed");
                        this.f26568c = 6;
                    }
                } else {
                    Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install create path failed");
                }
            }
        }
        unZip = false;
        Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install result=" + unZip);
        if (unZip) {
            this.f26568c = 0;
            ZeusWebViewPreloadClass.getInstance().deleteSavingClassesFile();
        }
        WebKitFactory.WebkitInstallListener webkitInstallListener2 = this.f26566a;
        if (webkitInstallListener2 != null) {
            int i2 = this.f26568c;
            if (i2 == 0) {
                this.f26566a.onInstallFinish(this.f26568c, UtilsBlink.getDownloadLibPath(WebKitFactory.getContext()));
            } else {
                webkitInstallListener2.onInstallFinish(i2, null);
            }
        }
        EngineManager engineManager2 = this.f26567b;
        if (engineManager2 != null) {
            engineManager2.onInstallFinish(this.f26568c == 0);
        }
        return unZip;
    }

    public abstract boolean b();

    public abstract String c();
}
