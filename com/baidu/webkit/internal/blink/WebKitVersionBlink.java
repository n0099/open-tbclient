package com.baidu.webkit.internal.blink;

import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes9.dex */
public class WebKitVersionBlink implements INoProGuard {
    private static final String TAG = "WebKitBlinkVer";

    public static String getVersionName() {
        if (WebViewFactory.hasProvider()) {
            try {
                WebViewFactory.getLoadedPackageInfo();
                return WebViewFactory.getLoadedPackageInfo().versionName;
            } catch (Throwable th) {
                com.a.a.a.a.a.a.a.a(th);
            }
        }
        return GlobalConstants.DEFAULT_VERSION;
    }

    public static String getZeusVersionByUpdate() {
        if (WebViewFactory.hasProvider() && WebKitFactory.getCurEngine() == 1) {
            try {
                WebViewFactory.getLoadedPackageInfo();
                return WebViewFactory.getLoadedPackageInfo().versionName;
            } catch (Throwable th) {
                com.a.a.a.a.a.a.a.a(th);
            }
        }
        return GlobalConstants.ZEUS_VERSION_NAME;
    }
}
