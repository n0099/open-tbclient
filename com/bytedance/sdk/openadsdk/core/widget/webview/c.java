package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.downloadnew.a.g;
import com.bytedance.sdk.openadsdk.e.j;
import com.bytedance.sdk.openadsdk.e.k;
import com.bytedance.sdk.openadsdk.r.h;
import com.sina.weibo.sdk.utils.FileUtils;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes5.dex */
public class c extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HashSet<String> f30960a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final w f30961b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f30962c;

    /* renamed from: d  reason: collision with root package name */
    public final String f30963d;

    /* renamed from: e  reason: collision with root package name */
    public j f30964e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30965f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30966g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1282682338, "Lcom/bytedance/sdk/openadsdk/core/widget/webview/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1282682338, "Lcom/bytedance/sdk/openadsdk/core/widget/webview/c;");
                return;
            }
        }
        HashSet<String> hashSet = new HashSet<>();
        f30960a = hashSet;
        hashSet.add("png");
        f30960a.add("ico");
        f30960a.add("jpg");
        f30960a.add("gif");
        f30960a.add("svg");
        f30960a.add("jpeg");
    }

    public c(Context context, w wVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, wVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30965f = true;
        this.f30966g = true;
        this.f30962c = context;
        this.f30961b = wVar;
        this.f30963d = str;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf == str.length() - 1 || (substring = str.substring(lastIndexOf)) == null || !f30960a.contains(substring.toLowerCase(Locale.getDefault()))) {
                return null;
            }
            return FileUtils.IMAGE_FILE_START + substring;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            super.onLoadResource(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            if (com.bytedance.sdk.component.utils.j.a()) {
                com.bytedance.sdk.component.utils.j.a("WebChromeClient", "onPageFinished " + str);
            }
            j jVar = this.f30964e;
            if (jVar != null) {
                jVar.a(webView, str);
            }
            if (webView != null && this.f30965f) {
                try {
                    String a2 = a.a(o.h().j(), this.f30963d);
                    if (!TextUtils.isEmpty(a2)) {
                        i.a(webView, a2);
                    }
                } catch (Throwable unused) {
                }
            }
            super.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
            j jVar = this.f30964e;
            if (jVar != null) {
                jVar.a(webView, str, bitmap);
            }
            if (this.f30966g) {
                a.a(this.f30962c).a(Build.VERSION.SDK_INT >= 19).a(webView);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048579, this, webView, i2, str, str2) == null) {
            super.onReceivedError(webView, i2, str, str2);
            j jVar = this.f30964e;
            if (jVar != null) {
                jVar.a(i2, str, str2, a(str2));
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, webView, webResourceRequest, webResourceResponse) == null) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (this.f30964e == null || webResourceResponse == null) {
                return;
            }
            Uri url = webResourceRequest.getUrl();
            String str = "";
            String uri = url != null ? url.toString() : "";
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders.containsKey("Accept")) {
                str = requestHeaders.get("Accept");
            } else if (requestHeaders.containsKey(BOSTokenRequest.ACCEPT)) {
                str = requestHeaders.get(BOSTokenRequest.ACCEPT);
            }
            this.f30964e.a(webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), uri, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, webView, sslErrorHandler, sslError) == null) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (this.f30964e != null) {
                int i2 = 0;
                String str = "SslError: unknown";
                String str2 = null;
                if (sslError != null) {
                    try {
                        i2 = sslError.getPrimaryError();
                        str = "SslError: " + String.valueOf(sslError);
                        str2 = sslError.getUrl();
                    } catch (Throwable unused) {
                    }
                }
                this.f30964e.a(i2, str, str2, a(str2));
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, webResourceRequest)) == null) {
            j jVar = this.f30964e;
            if (jVar != null) {
                jVar.a(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Uri parse;
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, webView, str)) == null) {
            com.bytedance.sdk.component.utils.j.b("WebChromeClient", "shouldOverrideUrlLoading " + str);
            try {
                parse = Uri.parse(str);
                lowerCase = parse.getScheme().toLowerCase();
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.j.b("WebChromeClient", "shouldOverrideUrlLoading", e2);
                w wVar = this.f30961b;
                if (wVar != null && wVar.e()) {
                    return true;
                }
            }
            if ("bytedance".equals(lowerCase)) {
                h.a(parse, this.f30961b);
                return true;
            }
            if (d.l.a.a.a.g.a.a(parse) && this.f30961b != null && this.f30961b.d() != null) {
                String p = this.f30961b.p();
                m d2 = this.f30961b.d();
                boolean c2 = g.d().p().c(this.f30962c, parse, com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(p, d2, null).h(), com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(d2, this.f30961b.p()).d(), com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(d2).d());
                com.bytedance.sdk.openadsdk.r.d.a(true);
                if (c2) {
                    return true;
                }
            }
            if (!com.bytedance.sdk.component.utils.m.a(str) && this.f30961b != null && this.f30961b.d() != null) {
                String p2 = this.f30961b.p();
                com.bytedance.sdk.component.utils.j.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading tag " + p2);
                m d3 = this.f30961b.d();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                com.bytedance.sdk.openadsdk.e.d.a(this.f30962c, d3, p2, "lp_open_dpl", lowerCase);
                if (com.bytedance.sdk.openadsdk.r.o.k(this.f30962c)) {
                    if (com.bytedance.sdk.openadsdk.r.o.a(this.f30962c, intent)) {
                        com.bytedance.sdk.component.utils.j.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading 该app已经安装 tag " + p2 + " URL " + str);
                        com.bytedance.sdk.component.utils.b.a(this.f30962c, intent, new b.a(this, d3, p2) { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.c.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ m f30967a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f30968b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ c f30969c;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, d3, p2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f30969c = this;
                                this.f30967a = d3;
                                this.f30968b = p2;
                            }

                            @Override // com.bytedance.sdk.component.utils.b.a
                            public void a() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    com.bytedance.sdk.component.utils.j.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading startActivitySuccess ");
                                    com.bytedance.sdk.openadsdk.e.d.b(this.f30969c.f30962c, this.f30967a, this.f30968b, "lp_openurl");
                                    com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f30967a, this.f30968b, "lp_deeplink_success_realtime");
                                }
                            }

                            @Override // com.bytedance.sdk.component.utils.b.a
                            public void a(Throwable th) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                                    com.bytedance.sdk.component.utils.j.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading 调起该app失败 ");
                                    com.bytedance.sdk.openadsdk.e.d.b(this.f30969c.f30962c, this.f30967a, this.f30968b, "lp_openurl_failed");
                                    com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f30967a, this.f30968b, "lp_deeplink_fail_realtime");
                                }
                            }
                        });
                        com.bytedance.sdk.component.utils.j.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading OpenAppSuccEvent.obtain().send true ");
                        k.a().a(d3, p2, true);
                    } else {
                        com.bytedance.sdk.component.utils.j.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading 该app没有安装 tag " + p2 + " url " + str);
                        com.bytedance.sdk.openadsdk.e.d.b(this.f30962c, d3, p2, "lp_openurl_failed");
                        com.bytedance.sdk.openadsdk.e.d.b(o.a(), d3, p2, "lp_deeplink_fail_realtime");
                    }
                } else {
                    this.f30962c.startActivity(intent);
                    com.bytedance.sdk.component.utils.j.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading startActivitySuccess ");
                    com.bytedance.sdk.openadsdk.e.d.b(this.f30962c, d3, p2, "lp_openurl");
                    k.a().a(d3, p2, true);
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, webResourceRequest, webResourceError) == null) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (this.f30964e == null || webResourceError == null) {
                return;
            }
            Uri url = webResourceRequest.getUrl();
            String str = "";
            String uri = url != null ? url.toString() : "";
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders.containsKey("Accept")) {
                str = requestHeaders.get("Accept");
            } else if (requestHeaders.containsKey(BOSTokenRequest.ACCEPT)) {
                str = requestHeaders.get(BOSTokenRequest.ACCEPT);
            }
            this.f30964e.a(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), uri, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str)) == null) ? super.shouldInterceptRequest(webView, str) : (WebResourceResponse) invokeLL.objValue;
    }

    public c(Context context, w wVar, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, wVar, str, jVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f30965f = true;
        this.f30966g = true;
        this.f30962c = context;
        this.f30961b = wVar;
        this.f30963d = str;
        this.f30964e = jVar;
    }
}
