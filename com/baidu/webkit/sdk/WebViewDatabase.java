package com.baidu.webkit.sdk;

import android.content.Context;
/* loaded from: classes9.dex */
public class WebViewDatabase {
    public static Context mContext;
    public static final WebViewDatabase mInstance = new WebViewDatabase();

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

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return WebViewFactory.getProvider().getWebViewDatabase(mContext).getHttpAuthUsernamePassword(str, str2);
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

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        WebViewFactory.getProvider().getWebViewDatabase(mContext).setHttpAuthUsernamePassword(str, str2, str3, str4);
    }
}
