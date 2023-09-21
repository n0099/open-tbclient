package com.baidu.tieba;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface xm6 {
    void a(WebView webView, String str, JSONObject jSONObject);

    @Deprecated
    boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);

    void onDestroy();
}
