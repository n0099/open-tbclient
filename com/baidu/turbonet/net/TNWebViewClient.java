package com.baidu.turbonet.net;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k99;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes6.dex */
public class TNWebViewClient extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TurbonetEngine a;

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            super.onPageFinished(webView, str);
            Log.d("tn_TNWebViewClient", "TNWebViewClient loading page finish " + str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
            Log.d("tn_TNWebViewClient", "TNWebViewClient loading page start " + str);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        String str;
        String str2;
        String[] split;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest)) == null) {
            try {
            } catch (MalformedURLException e) {
                Log.e("tn_TNWebViewClient", "MalformedURLException when intercept webview request: " + e.toString());
            } catch (IOException e2) {
                Log.e("tn_TNWebViewClient", "IOException when intercept webview request: " + e2.toString());
            } catch (Exception e3) {
                Log.e("tn_TNWebViewClient", "Exception when intercept webview request: " + e3.toString());
            }
            if (!webResourceRequest.getMethod().equals("GET") || this.a.f()) {
                return null;
            }
            Log.d("tn_TNWebViewClient", "Intercept request and send " + webResourceRequest.getUrl().toString());
            k99 k99Var = new k99(new URL(webResourceRequest.getUrl().toString()), this.a);
            k99Var.setRequestMethod(webResourceRequest.getMethod());
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders != null) {
                for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                    k99Var.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            CookieManager cookieManager = CookieManager.getInstance();
            String cookie = cookieManager.getCookie(webResourceRequest.getUrl().toString());
            if (!TextUtils.isEmpty(cookie)) {
                k99Var.setRequestProperty("Cookie", cookie);
            }
            int responseCode = k99Var.getResponseCode();
            if (responseCode >= 100 && responseCode <= 599 && (responseCode <= 299 || responseCode >= 400)) {
                String headerField = k99Var.getHeaderField("Set-Cookie");
                if (!TextUtils.isEmpty(headerField)) {
                    cookieManager.setCookie(k99Var.getURL().toString(), headerField);
                }
                String headerField2 = k99Var.getHeaderField("Content-Type");
                String str3 = "UTF-8";
                if (headerField2 == null || (length = (split = headerField2.split(ParamableElem.DIVIDE_PARAM)).length) <= 0) {
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
                Map headerFields = k99Var.getHeaderFields();
                if (headerFields != null) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry entry2 : headerFields.entrySet()) {
                        Iterator it = ((List) entry2.getValue()).iterator();
                        StringBuilder sb = new StringBuilder();
                        while (it.hasNext()) {
                            sb.append((String) it.next());
                            if (it.hasNext()) {
                                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                            }
                        }
                        hashMap.put((String) entry2.getKey(), sb.toString());
                    }
                    if (!TextUtils.isEmpty(k99Var.getResponseMessage())) {
                        return new WebResourceResponse(str2, str, k99Var.getResponseCode(), k99Var.getResponseMessage(), hashMap, k99Var.getInputStream());
                    }
                    return new WebResourceResponse(str2, str, k99Var.getInputStream());
                }
                return null;
            }
            Log.d("tn_TNWebViewClient", "The status code passed to WebResourceResponse needs to be in the ranges [100, 299], [400, 599].");
            return null;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }
}
