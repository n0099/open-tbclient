package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import com.baidu.webkit.sdk.WebResourceError;
@TargetApi(23)
/* loaded from: classes9.dex */
final class WebResourceErrorImpl extends WebResourceError {
    private final android.webkit.WebResourceError mError;

    private WebResourceErrorImpl(android.webkit.WebResourceError webResourceError) {
        this.mError = webResourceError;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebResourceError from(android.webkit.WebResourceError webResourceError) {
        if (webResourceError == null) {
            return null;
        }
        return new WebResourceErrorImpl(webResourceError);
    }

    @Override // com.baidu.webkit.sdk.WebResourceError
    public final CharSequence getDescription() {
        return this.mError.getDescription();
    }

    @Override // com.baidu.webkit.sdk.WebResourceError
    public final int getErrorCode() {
        return this.mError.getErrorCode();
    }
}
