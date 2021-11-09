package com.baidu.turbonet.net;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import b.a.s0.b.e.d;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes10.dex */
public class TNWebViewClient extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TurbonetEngine f56572a;

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            super.onPageFinished(webView, str);
            String str2 = "TNWebViewClient loading page finish " + str;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
            String str2 = "TNWebViewClient loading page start " + str;
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        String str;
        String str2;
        String[] split;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest)) == null) {
            try {
            } catch (MalformedURLException e2) {
                String str3 = "MalformedURLException when intercept webview request: " + e2.toString();
            } catch (IOException e3) {
                String str4 = "IOException when intercept webview request: " + e3.toString();
            } catch (Exception e4) {
                String str5 = "Exception when intercept webview request: " + e4.toString();
            }
            if (webResourceRequest.getMethod().equals("GET") && !this.f56572a.f()) {
                String str6 = "Intercept request and send " + webResourceRequest.getUrl().toString();
                d dVar = new d(new URL(webResourceRequest.getUrl().toString()), this.f56572a);
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
                    String str7 = "UTF-8";
                    if (headerField2 == null || (length = (split = headerField2.split(";")).length) <= 0) {
                        str = "UTF-8";
                        str2 = headerField2;
                    } else {
                        String str8 = split[0];
                        for (int i2 = 0; i2 < length; i2++) {
                            String trim = split[i2].trim();
                            if (trim.toLowerCase(Locale.ENGLISH).startsWith("charset=")) {
                                str7 = trim.substring(8);
                            }
                        }
                        str = str7;
                        str2 = str8;
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
                return null;
            }
            return null;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }
}
