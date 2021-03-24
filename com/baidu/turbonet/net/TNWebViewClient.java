package com.baidu.turbonet.net;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.android.common.others.lang.StringUtil;
import d.b.j0.b.e.d;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes5.dex */
public class TNWebViewClient extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final TurbonetEngine f22837a;

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        Log.d("tn_TNWebViewClient", "TNWebViewClient loading page finish " + str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        Log.d("tn_TNWebViewClient", "TNWebViewClient loading page start " + str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String str;
        String str2;
        String[] split;
        int length;
        try {
        } catch (MalformedURLException e2) {
            Log.e("tn_TNWebViewClient", "MalformedURLException when intercept webview request: " + e2.toString());
        } catch (IOException e3) {
            Log.e("tn_TNWebViewClient", "IOException when intercept webview request: " + e3.toString());
        } catch (Exception e4) {
            Log.e("tn_TNWebViewClient", "Exception when intercept webview request: " + e4.toString());
        }
        if (webResourceRequest.getMethod().equals("GET") && !this.f22837a.f()) {
            Log.d("tn_TNWebViewClient", "Intercept request and send " + webResourceRequest.getUrl().toString());
            d dVar = new d(new URL(webResourceRequest.getUrl().toString()), this.f22837a);
            dVar.setRequestMethod(webResourceRequest.getMethod());
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders != null) {
                for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                    dVar.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            CookieManager cookieManager = CookieManager.getInstance();
            String cookie = cookieManager.getCookie(webResourceRequest.getUrl().toString());
            if (!TextUtils.isEmpty(cookie)) {
                dVar.setRequestProperty("Cookie", cookie);
            }
            int responseCode = dVar.getResponseCode();
            if (responseCode >= 100 && responseCode <= 599 && (responseCode <= 299 || responseCode >= 400)) {
                String headerField = dVar.getHeaderField("Set-Cookie");
                if (!TextUtils.isEmpty(headerField)) {
                    cookieManager.setCookie(dVar.getURL().toString(), headerField);
                }
                String headerField2 = dVar.getHeaderField("Content-Type");
                String str3 = "UTF-8";
                if (headerField2 == null || (length = (split = headerField2.split(";")).length) <= 0) {
                    str = "UTF-8";
                    str2 = headerField2;
                } else {
                    String str4 = split[0];
                    for (int i = 0; i < length; i++) {
                        String trim = split[i].trim();
                        if (trim.toLowerCase(Locale.ENGLISH).startsWith("charset=")) {
                            str3 = trim.substring(8);
                        }
                    }
                    str = str3;
                    str2 = str4;
                }
                Map<String, List<String>> headerFields = dVar.getHeaderFields();
                if (headerFields != null) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                        Iterator<String> it = entry2.getValue().iterator();
                        StringBuilder sb = new StringBuilder();
                        while (it.hasNext()) {
                            sb.append(it.next());
                            if (it.hasNext()) {
                                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                            }
                        }
                        hashMap.put(entry2.getKey(), sb.toString());
                    }
                    if (!TextUtils.isEmpty(dVar.getResponseMessage())) {
                        return new WebResourceResponse(str2, str, dVar.getResponseCode(), dVar.getResponseMessage(), hashMap, dVar.getInputStream());
                    }
                    return new WebResourceResponse(str2, str, dVar.getInputStream());
                }
                return null;
            }
            Log.d("tn_TNWebViewClient", "The status code passed to WebResourceResponse needs to be in the ranges [100, 299], [400, 599].");
            return null;
        }
        return null;
    }
}
