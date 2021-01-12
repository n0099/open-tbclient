package com.baidu.webkit.internal.blink;

import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.baidu.webkit.internal.utils.ZipUtils;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    WebKitFactory.WebkitInstallListener f5649a;

    /* renamed from: b  reason: collision with root package name */
    EngineManager f5650b;
    private int c = 13;

    public a(EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        this.f5650b = engineManager;
        this.f5649a = webkitInstallListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        String[] strArr;
        boolean unZip;
        if (this.f5650b != null) {
            this.f5650b.onInstallStart();
        }
        if (this.f5649a != null) {
            this.f5649a.onInstallStart();
        }
        if (!b()) {
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install init failed");
        }
        String c = c();
        if (c == null) {
            unZip = false;
        } else {
            String downloadLibPath = UtilsBlink.getDownloadLibPath(WebKitFactory.getContext());
            int length = GlobalConstants.LIB_ZEUS_SO.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    String str = downloadLibPath + strArr[i];
                    if (new File(str).exists() && !com.baidu.webkit.internal.utils.a.a(str)) {
                        unZip = false;
                        break;
                    }
                    i++;
                } else if (UtilsBlink.createDownloadLibPath(WebKitFactory.getContext())) {
                    unZip = ZipUtils.getInstance().unZip(WebKitFactory.getContext(), c, downloadLibPath, false);
                    if (!unZip) {
                        Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install unzip failed");
                        this.c = 6;
                    }
                } else {
                    Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install create path failed");
                    unZip = false;
                }
            }
        }
        Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install result=" + unZip);
        if (unZip) {
            this.c = 0;
            ZeusWebViewPreloadClass.getInstance().deleteSavingClassesFile();
        }
        if (this.f5649a != null) {
            if (this.c == 0) {
                this.f5649a.onInstallFinish(this.c, UtilsBlink.getDownloadLibPath(WebKitFactory.getContext()));
            } else {
                this.f5649a.onInstallFinish(this.c, null);
            }
        }
        if (this.f5650b != null) {
            this.f5650b.onInstallFinish(this.c == 0);
        }
        return unZip;
    }

    protected abstract boolean b();

    protected abstract String c();
}
