package com.baidu.webkit.internal.blink;

import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes7.dex */
public class WebKitVersionBlink implements INoProGuard {
    public static final String TAG = "WebKitBlinkVer";

    public static String getVersionName() {
        if (WebViewFactory.hasProvider()) {
            try {
                if (WebViewFactory.isOptimizedPackageInfoEnabled() && WebKitFactory.getCurEngine() == 1) {
                    return WebViewFactory.getZeusVersionName();
                }
                WebViewFactory.getLoadedPackageInfo();
                return WebViewFactory.getLoadedPackageInfo().versionName;
            } catch (Throwable th) {
                th.printStackTrace();
                return GlobalConstants.DEFAULT_VERSION;
            }
        }
        return GlobalConstants.DEFAULT_VERSION;
    }

    public static String getZeusVersionByUpdate() {
        if (WebViewFactory.hasProvider() && WebKitFactory.getCurEngine() == 1) {
            try {
                if (WebViewFactory.isOptimizedPackageInfoEnabled()) {
                    return WebViewFactory.getZeusVersionName();
                }
                WebViewFactory.getLoadedPackageInfo();
                return WebViewFactory.getLoadedPackageInfo().versionName;
            } catch (Throwable th) {
                th.printStackTrace();
                return GlobalConstants.ZEUS_VERSION_NAME;
            }
        }
        return GlobalConstants.ZEUS_VERSION_NAME;
    }
}
