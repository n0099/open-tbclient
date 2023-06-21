package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rc1 extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WebView a;
    public final WebViewClient b;

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, webView, renderProcessGoneDetail)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements lc1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ SslErrorHandler b;
        public final /* synthetic */ SslError c;
        public final /* synthetic */ rc1 d;

        public a(rc1 rc1Var, WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc1Var, webView, sslErrorHandler, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = rc1Var;
            this.a = webView;
            this.b = sslErrorHandler;
            this.c = sslError;
        }

        @Override // com.baidu.tieba.lc1
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.d.b != null) {
                this.d.b.onReceivedSslError(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ic1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ HttpAuthHandler b;

        public b(rc1 rc1Var, WebView webView, HttpAuthHandler httpAuthHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc1Var, webView, httpAuthHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webView;
            this.b = httpAuthHandler;
        }

        @Override // com.baidu.tieba.ic1
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                this.b.proceed(str, str2);
            }
        }

        @Override // com.baidu.tieba.ic1
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.cancel();
            }
        }

        @Override // com.baidu.tieba.ic1
        public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, str4) == null) {
                this.a.setHttpAuthUsernamePassword(str, str2, str3, str4);
            }
        }
    }

    public rc1(WebView webView, WebViewClient webViewClient, dk0 dk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, webViewClient, dk0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = webView;
        this.b = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        WebViewClient webViewClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048576, this, webView, str, z) == null) && (webViewClient = this.b) != null) {
            webViewClient.doUpdateVisitedHistory(webView, str, z);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, message, message2) == null) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onPageStarted(webView, str, bitmap);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, webView, webResourceRequest, webResourceError) == null) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            WebViewClient webViewClient = this.b;
            if (webViewClient != null && Build.VERSION.SDK_INT >= 23) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, webView, webResourceRequest, webResourceResponse) == null) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            WebViewClient webViewClient = this.b;
            if (webViewClient != null && Build.VERSION.SDK_INT >= 23) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, webView, sslErrorHandler, sslError) == null) {
            if (webView.isShown()) {
                new ac1(webView.getContext()).v(new a(this, webView, sslErrorHandler, sslError), sslErrorHandler, sslError);
                return;
            }
            sslErrorHandler.cancel();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{webView, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            super.onScaleChanged(webView, f, f2);
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f, f2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
            super.onLoadResource(webView, str);
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
            super.onPageCommitVisible(webView, str);
            WebViewClient webViewClient = this.b;
            if (webViewClient != null && Build.VERSION.SDK_INT >= 23) {
                webViewClient.onPageCommitVisible(webView, str);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) {
            super.onPageFinished(webView, str);
            if (webView != null) {
                webView.loadUrl("javascript:(function go_back_js_interface_name(){window.history.back=function(){javascript:(function(){if(typeof(window.go_back_js_interface_name)=='undefined'){window.prompt('BdboxApp:'+JSON.stringify({obj:'go_back_js_interface_name',func:'onGoBack',args:[]}));}else{window.go_back_js_interface_name.onGoBack();}})()};})()");
            }
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            }
            qb1.a().a(this.a.getContext(), str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, webView, clientCertRequest) == null) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
                    return;
                }
                return;
            }
            super.onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, webView, keyEvent) == null) {
            super.onUnhandledKeyEvent(webView, keyEvent);
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, webView, webResourceRequest)) == null) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null && Build.VERSION.SDK_INT >= 21) {
                return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, webView, keyEvent)) == null) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null && webViewClient.shouldOverrideKeyEvent(webView, keyEvent)) {
                return true;
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, str)) == null) {
            WebViewClient webViewClient = this.b;
            if (webViewClient != null && webViewClient.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        String str3;
        String[] httpAuthUsernamePassword;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, httpAuthHandler, str, str2) == null) {
            String str4 = null;
            if (httpAuthHandler.useHttpAuthUsernamePassword() && webView != null && (httpAuthUsernamePassword = webView.getHttpAuthUsernamePassword(str, str2)) != null && httpAuthUsernamePassword.length == 2) {
                str4 = httpAuthUsernamePassword[0];
                str3 = httpAuthUsernamePassword[1];
            } else {
                str3 = null;
            }
            if (str4 != null && str3 != null) {
                httpAuthHandler.proceed(str4, str3);
            } else if (webView != null && webView.isShown()) {
                new ac1(webView.getContext()).q(new b(this, webView, httpAuthHandler), str, str2);
            } else {
                httpAuthHandler.cancel();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, @Nullable String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, webView, str, str2, str3) == null) {
            super.onReceivedLoginRequest(webView, str, str2, str3);
            WebViewClient webViewClient = this.b;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }
    }
}
