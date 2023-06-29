package com.baidu.webkit.sdk.system;

import com.baidu.webkit.sdk.HttpAuthHandler;
/* loaded from: classes9.dex */
public final class HttpAuthHandlerImpl extends HttpAuthHandler {
    public final android.webkit.HttpAuthHandler mHandler;

    public HttpAuthHandlerImpl(android.webkit.HttpAuthHandler httpAuthHandler) {
        this.mHandler = httpAuthHandler;
    }

    public static HttpAuthHandler from(android.webkit.HttpAuthHandler httpAuthHandler) {
        if (httpAuthHandler == null) {
            return null;
        }
        return new HttpAuthHandlerImpl(httpAuthHandler);
    }

    @Override // com.baidu.webkit.sdk.HttpAuthHandler
    public final void cancel() {
        this.mHandler.cancel();
    }

    @Override // com.baidu.webkit.sdk.HttpAuthHandler
    public final void proceed(String str, String str2) {
        this.mHandler.proceed(str, str2);
    }

    @Override // com.baidu.webkit.sdk.HttpAuthHandler
    public final boolean useHttpAuthUsernamePassword() {
        return this.mHandler.useHttpAuthUsernamePassword();
    }
}
