package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes8.dex */
public interface tk6 {
    public static final ServiceReference a = new ServiceReference(WebView.LOGTAG, "IWebViewFactoryService");

    void a();

    @NonNull
    android.webkit.WebView b(Context context, String str);

    void c(String str, android.webkit.WebView webView);
}
