package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import com.baidu.webkit.sdk.WebResourceRequest;
import java.util.Map;
@TargetApi(21)
/* loaded from: classes19.dex */
final class WebResourceRequestImpl implements WebResourceRequest {
    private final android.webkit.WebResourceRequest mRequest;

    private WebResourceRequestImpl(android.webkit.WebResourceRequest webResourceRequest) {
        this.mRequest = webResourceRequest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebResourceRequest from(android.webkit.WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null) {
            return null;
        }
        return new WebResourceRequestImpl(webResourceRequest);
    }

    @Override // com.baidu.webkit.sdk.WebResourceRequest
    public final String getMethod() {
        return this.mRequest.getMethod();
    }

    @Override // com.baidu.webkit.sdk.WebResourceRequest
    public final Map<String, String> getRequestHeaders() {
        return this.mRequest.getRequestHeaders();
    }

    @Override // com.baidu.webkit.sdk.WebResourceRequest
    public final Uri getUrl() {
        return this.mRequest.getUrl();
    }

    @Override // com.baidu.webkit.sdk.WebResourceRequest
    public final boolean hasGesture() {
        return this.mRequest.hasGesture();
    }

    @Override // com.baidu.webkit.sdk.WebResourceRequest
    public final boolean isForMainFrame() {
        return this.mRequest.isForMainFrame();
    }

    @Override // com.baidu.webkit.sdk.WebResourceRequest
    @TargetApi(24)
    public final boolean isRedirect() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.mRequest.isRedirect();
        }
        return false;
    }
}
