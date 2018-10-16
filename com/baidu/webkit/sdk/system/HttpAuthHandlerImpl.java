package com.baidu.webkit.sdk.system;

import com.baidu.webkit.sdk.HttpAuthHandler;
/* loaded from: classes2.dex */
final class HttpAuthHandlerImpl extends HttpAuthHandler {
    private final android.webkit.HttpAuthHandler mHandler;

    private HttpAuthHandlerImpl(android.webkit.HttpAuthHandler httpAuthHandler) {
        this.mHandler = httpAuthHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
