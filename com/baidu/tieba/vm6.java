package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface vm6 {
    public static final ServiceReference a = new ServiceReference(WebView.LOGTAG, "IWebViewDebug");

    JSONObject a();

    void b();

    void c();
}
