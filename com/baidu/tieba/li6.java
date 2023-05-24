package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes6.dex */
public interface li6 {
    public static final ServiceReference a = new ServiceReference(WebView.LOGTAG, "IWebViewFactoryService");

    @NonNull
    android.webkit.WebView a(Context context, String str);

    void b(String str, android.webkit.WebView webView);
}
