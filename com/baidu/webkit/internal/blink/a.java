package com.baidu.webkit.internal.blink;

import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public abstract class a {
    WebKitFactory.WebkitInstallListener a;
    EngineManager b;
    private int c = 13;

    public a(EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        this.b = engineManager;
        this.a = webkitInstallListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        String[] strArr;
        boolean a;
        if (this.b != null) {
            this.b.onInstallStart();
        }
        if (this.a != null) {
            this.a.onInstallStart();
        }
        if (!b()) {
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install init failed");
        }
        String c = c();
        if (c == null) {
            a = false;
        } else {
            String downloadLibPath = UtilsBlink.getDownloadLibPath(WebKitFactory.getContext());
            int length = GlobalConstants.LIB_ZEUS_SO.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    String str = downloadLibPath + strArr[i];
                    if (new File(str).exists() && !com.baidu.webkit.internal.utils.a.a(str)) {
                        a = false;
                        break;
                    }
                    i++;
                } else if (UtilsBlink.createDownloadLibPath(WebKitFactory.getContext())) {
                    com.baidu.webkit.internal.utils.d a2 = com.baidu.webkit.internal.utils.d.a();
                    WebKitFactory.getContext();
                    a = a2.a(c, downloadLibPath, null);
                    if (!a) {
                        Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install unzip failed");
                        this.c = 6;
                    }
                } else {
                    Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install create path failed");
                    a = false;
                }
            }
        }
        Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install result=" + a);
        if (a) {
            this.c = 0;
        }
        if (this.a != null) {
            if (this.c == 0) {
                this.a.onInstallFinish(this.c, UtilsBlink.getDownloadLibPath(WebKitFactory.getContext()));
            } else {
                this.a.onInstallFinish(this.c, null);
            }
        }
        if (this.b != null) {
            this.b.onInstallFinish(this.c == 0);
        }
        return a;
    }

    protected abstract boolean b();

    protected abstract String c();
}
