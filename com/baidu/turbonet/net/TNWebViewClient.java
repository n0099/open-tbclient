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
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.turbonet.net.a.d;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.cookie.SM;
/* loaded from: classes5.dex */
public class TNWebViewClient extends WebViewClient {
    private final TurbonetEngine oTo;

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        Log.d("tn_TNWebViewClient", "TNWebViewClient loading page start " + str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        Log.d("tn_TNWebViewClient", "TNWebViewClient loading page finish " + str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String[] split;
        int length;
        try {
        } catch (MalformedURLException e) {
            Log.e("tn_TNWebViewClient", "MalformedURLException when intercept webview request: " + e.toString());
        } catch (IOException e2) {
            Log.e("tn_TNWebViewClient", "IOException when intercept webview request: " + e2.toString());
        } catch (Exception e3) {
            Log.e("tn_TNWebViewClient", "Exception when intercept webview request: " + e3.toString());
        }
        if (webResourceRequest.getMethod().equals("GET") && !this.oTo.egz()) {
            Log.d("tn_TNWebViewClient", "Intercept request and send " + webResourceRequest.getUrl().toString());
            d dVar = new d(new URL(webResourceRequest.getUrl().toString()), this.oTo);
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
                dVar.setRequestProperty(SM.COOKIE, cookie);
            }
            int responseCode = dVar.getResponseCode();
            if (responseCode < 100 || responseCode > 599 || (responseCode > 299 && responseCode < 400)) {
                Log.d("tn_TNWebViewClient", "The status code passed to WebResourceResponse needs to be in the ranges [100, 299], [400, 599].");
                return null;
            }
            String headerField = dVar.getHeaderField(SM.SET_COOKIE);
            if (!TextUtils.isEmpty(headerField)) {
                cookieManager.setCookie(dVar.getURL().toString(), headerField);
            }
            String headerField2 = dVar.getHeaderField("Content-Type");
            String str = "UTF-8";
            if (headerField2 != null && (length = (split = headerField2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)).length) > 0) {
                headerField2 = split[0];
                String str2 = "UTF-8";
                for (int i = 0; i < length; i++) {
                    String trim = split[i].trim();
                    if (trim.toLowerCase(Locale.ENGLISH).startsWith("charset=")) {
                        str2 = trim.substring("charset=".length());
                    }
                }
                str = str2;
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
                            sb.append(", ");
                        }
                    }
                    hashMap.put(entry2.getKey(), sb.toString());
                }
                if (!TextUtils.isEmpty(dVar.getResponseMessage())) {
                    return new WebResourceResponse(headerField2, str, dVar.getResponseCode(), dVar.getResponseMessage(), hashMap, dVar.getInputStream());
                }
                return new WebResourceResponse(headerField2, str, dVar.getInputStream());
            }
            return null;
        }
        return null;
    }
}
