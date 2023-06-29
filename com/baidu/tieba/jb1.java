package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.NadNativeBrowserView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class jb1 extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public gb1 b;
    public NadNativeBrowserView c;

    public jb1(NadNativeBrowserView webView, gb1 gb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, gb1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.a = "NativeWebViewClient";
        this.b = gb1Var;
        this.c = webView;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
            String str2 = this.a;
            ua1.a(str2, "calling onPageFinished with browserView >>> " + this.c + " with kernel " + this.c.getWebView());
            super.onPageFinished(webView, str);
            gb1 gb1Var = this.b;
            if (gb1Var != null) {
                gb1Var.f(this.c, str);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, webView, str, z) == null) {
            super.doUpdateVisitedHistory(webView, str, z);
            il0.a.a(str);
            gb1 gb1Var = this.b;
            if (gb1Var != null) {
                gb1Var.m(this.c, str, z);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, message, message2) == null) {
            super.onFormResubmission(webView, message, message2);
            gb1 gb1Var = this.b;
            if (gb1Var != null) {
                gb1Var.a(this.c, message, message2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
            gb1 gb1Var = this.b;
            if (gb1Var != null) {
                gb1Var.g(this.c, str, bitmap);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, webView, sslErrorHandler, sslError) == null) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            gb1 gb1Var = this.b;
            if (gb1Var != null) {
                gb1Var.j(this.c, sslErrorHandler, sslError);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
            super.onLoadResource(webView, str);
            gb1 gb1Var = this.b;
            if (gb1Var != null) {
                gb1Var.c(this.c, str);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, webView, keyEvent) == null) {
            super.onUnhandledKeyEvent(webView, keyEvent);
            gb1 gb1Var = this.b;
            if (gb1Var != null) {
                gb1Var.l(this.c, keyEvent);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        InterceptResult invokeLL;
        eb1 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, str)) == null) {
            gb1 gb1Var = this.b;
            Object obj = null;
            if (gb1Var != null && (b = gb1Var.b(this.c, str)) != null) {
                b.a();
                throw null;
            } else if (obj instanceof WebResourceResponse) {
                return null;
            } else {
                return super.shouldInterceptRequest(webView, str);
            }
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, webView, keyEvent)) == null) {
            gb1 gb1Var = this.b;
            if (gb1Var != null) {
                return gb1Var.d(this.c, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, webView, str)) == null) {
            gb1 gb1Var = this.b;
            if (gb1Var != null) {
                return gb1Var.e(this.c, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048581, this, webView, i, str, str2) == null) {
            super.onReceivedError(webView, i, str, str2);
            gb1 gb1Var = this.b;
            if (gb1Var != null) {
                gb1Var.h(this.c, i, str, str2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, webView, httpAuthHandler, str, str2) == null) {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            gb1 gb1Var = this.b;
            if (gb1Var != null) {
                NadNativeBrowserView nadNativeBrowserView = this.c;
                hb1 hb1Var = new hb1();
                hb1Var.b(httpAuthHandler);
                gb1Var.i(nadNativeBrowserView, hb1Var, str, str2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{webView, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            super.onScaleChanged(webView, f, f2);
            gb1 gb1Var = this.b;
            if (gb1Var != null) {
                gb1Var.k(this.c, f, f2);
            }
        }
    }
}
