package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import java.io.InputStream;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class f extends com.bytedance.sdk.openadsdk.core.widget.webview.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f66499a;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66500h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, w wVar, com.bytedance.sdk.openadsdk.core.e.m mVar, com.bytedance.sdk.openadsdk.e.j jVar, boolean z) {
        super(context, wVar, mVar.ak(), jVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, wVar, mVar, jVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (w) objArr2[1], (String) objArr2[2], (com.bytedance.sdk.openadsdk.e.j) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66499a = mVar;
        this.f66500h = z;
    }

    private WebResourceResponse a(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, webView, str)) == null) {
            com.bytedance.sdk.openadsdk.core.e.l lVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            e.a a2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
            if (a2 != e.a.f67068d) {
                Iterator<com.bytedance.sdk.openadsdk.core.e.l> it = this.f66499a.ad().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.bytedance.sdk.openadsdk.core.e.l next = it.next();
                    if (!TextUtils.isEmpty(next.a()) && !TextUtils.isEmpty(str)) {
                        String a3 = next.a();
                        if (a3.startsWith("https")) {
                            a3 = a3.replaceFirst("https", "http");
                        }
                        if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(a3)) {
                            lVar = next;
                            break;
                        }
                    }
                }
            }
            if (a2 == e.a.f67068d) {
                return a(str, "");
            }
            if (lVar != null) {
                return a(str, lVar.g());
            }
            return com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(str, a2, "");
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            this.f67090f = false;
            super.onPageFinished(webView, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
            this.f67091g = false;
            super.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest)) == null) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.c("ExpressClient", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                WebResourceResponse a2 = a(webView, str);
                a(currentTimeMillis, System.currentTimeMillis(), str, a2 != null ? 1 : 2);
                if (a2 != null) {
                    return a2;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.c("ExpressClient", "shouldInterceptRequest error2", th);
            }
            return super.shouldInterceptRequest(webView, str);
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    private WebResourceResponse a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                InputStream a2 = ImageLoaderWrapper.a(str, str2);
                if (a2 != null) {
                    return new WebResourceResponse(e.a.f67068d.a(), "utf-8", a2);
                }
                return null;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.c("ExpressClient", "get image WebResourceResponse error", th);
                return null;
            }
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    private void a(long j2, long j3, String str, int i2) {
        com.bytedance.sdk.openadsdk.e.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, Integer.valueOf(i2)}) == null) || (jVar = this.f67089e) == null || jVar.b() == null) {
            return;
        }
        e.a a2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
        if (a2 == e.a.f67065a) {
            this.f67089e.b().a(str, j2, j3, i2);
        } else if (a2 == e.a.f67067c) {
            this.f67089e.b().b(str, j2, j3, i2);
        }
    }
}
