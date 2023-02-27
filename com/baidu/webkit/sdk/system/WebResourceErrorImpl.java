package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import com.baidu.webkit.sdk.WebResourceError;
@TargetApi(23)
/* loaded from: classes7.dex */
public final class WebResourceErrorImpl extends WebResourceError {
    public final android.webkit.WebResourceError mError;

    public WebResourceErrorImpl(android.webkit.WebResourceError webResourceError) {
        this.mError = webResourceError;
    }

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

    @Override // com.baidu.webkit.sdk.WebResourceError
    public final int getOriginErrorCode() {
        return 0;
    }
}
