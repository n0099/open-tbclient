package com.baidu.webkit.sdk.system;

import android.content.Context;
import com.baidu.webkit.sdk.WebViewDatabase;
/* loaded from: classes9.dex */
final class WebViewDatabaseImpl extends WebViewDatabase {
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebViewDatabaseImpl(Context context) {
        this.mContext = null;
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
}
