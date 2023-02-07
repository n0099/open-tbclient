package com.baidu.tieba;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.HashMap;
/* loaded from: classes6.dex */
public interface tb6 {
    public static final ServiceReference a = new ServiceReference("Frames", "JsPromptBridge");

    void a(WebView webView, String str, HashMap<String, Object> hashMap);

    boolean b(WebView webView, String str, JsPromptResult jsPromptResult);

    void c(vb6 vb6Var, Object obj);
}
