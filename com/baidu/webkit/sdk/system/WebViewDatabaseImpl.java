package com.baidu.webkit.sdk.system;

import android.content.Context;
import android.os.Build;
import com.baidu.webkit.sdk.WebViewDatabase;
/* loaded from: classes7.dex */
public final class WebViewDatabaseImpl extends WebViewDatabase {
    public Context mContext;

    public WebViewDatabaseImpl(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final void clearFormData() {
        android.webkit.WebViewDatabase.getInstance(this.mContext).clearFormData();
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final void clearHttpAuthUsernamePassword() {
        android.webkit.WebViewDatabase.getInstance(this.mContext).clearHttpAuthUsernamePassword();
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final void clearUsernamePassword() {
        android.webkit.WebViewDatabase.getInstance(this.mContext).clearUsernamePassword();
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final String[] getHttpAuthUsernamePassword(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return android.webkit.WebViewDatabase.getInstance(this.mContext).getHttpAuthUsernamePassword(str, str2);
        }
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final boolean hasFormData() {
        return android.webkit.WebViewDatabase.getInstance(this.mContext).hasFormData();
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final boolean hasHttpAuthUsernamePassword() {
        return android.webkit.WebViewDatabase.getInstance(this.mContext).hasHttpAuthUsernamePassword();
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final boolean hasUsernamePassword() {
        return android.webkit.WebViewDatabase.getInstance(this.mContext).hasUsernamePassword();
    }

    @Override // com.baidu.webkit.sdk.WebViewDatabase
    public final void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (Build.VERSION.SDK_INT >= 26) {
            android.webkit.WebViewDatabase.getInstance(this.mContext).setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }
}
