package com.baidu.webkit.sdk;

import android.content.Context;
/* loaded from: classes10.dex */
public class WebViewDatabase {
    private static final WebViewDatabase mInstance = new WebViewDatabase();
    private static Context mContext = null;

    public static WebViewDatabase getInstance(Context context) {
        if (mContext == null) {
            mContext = context;
        }
        return mInstance;
    }

    public void clearFormData() {
        WebViewFactory.getProvider().getWebViewDatabase(mContext).clearFormData();
    }

    public void clearHttpAuthUsernamePassword() {
        WebViewFactory.getProvider().getWebViewDatabase(mContext).clearHttpAuthUsernamePassword();
    }

    @Deprecated
    public void clearUsernamePassword() {
        WebViewFactory.getProvider().getWebViewDatabase(mContext).clearUsernamePassword();
    }

    public boolean hasFormData() {
        return WebViewFactory.getProvider().getWebViewDatabase(mContext).hasFormData();
    }

    public boolean hasHttpAuthUsernamePassword() {
        return WebViewFactory.getProvider().getWebViewDatabase(mContext).hasHttpAuthUsernamePassword();
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        return WebViewFactory.getProvider().getWebViewDatabase(mContext).hasUsernamePassword();
    }
}
