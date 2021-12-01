package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public final class WebViewClientWrapper extends WebViewClient {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.baidu.webkit.sdk.WebViewClient mClient;
    public final WebViewImpl mWebView;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1625004992, "Lcom/baidu/webkit/sdk/system/WebViewClientWrapper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1625004992, "Lcom/baidu/webkit/sdk/system/WebViewClientWrapper;");
            }
        }
    }

    public WebViewClientWrapper(WebViewImpl webViewImpl, com.baidu.webkit.sdk.WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webViewImpl, webViewClient};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mWebView = webViewImpl;
        this.mClient = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, webView, str, z) == null) {
            this.mClient.doUpdateVisitedHistory(this.mWebView.getWebView(), str, z, false, false, false);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, message, message2) == null) {
            this.mClient.onFormResubmission(this.mWebView.getWebView(), message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
            this.mClient.onLoadResource(this.mWebView.getWebView(), str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
            this.mClient.onPageCommitVisible(this.mWebView.getWebView(), str, false);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) {
            this.mClient.onPageFinished(this.mWebView.getWebView(), str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, webView, str, bitmap) == null) {
            this.mClient.onPageStarted(this.mWebView.getWebView(), str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, webView, clientCertRequest) == null) {
            this.mClient.onReceivedClientCertRequest(this.mWebView.getWebView(), ClientCertRequestImpl.from(clientCertRequest));
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048583, this, webView, i2, str, str2) == null) {
            this.mClient.onReceivedError(this.mWebView.getWebView(), i2, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, webResourceRequest, webResourceError) == null) {
            this.mClient.onReceivedError(this.mWebView.getWebView(), WebResourceRequestImpl.from(webResourceRequest), WebResourceErrorImpl.from(webResourceError));
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, webView, httpAuthHandler, str, str2) == null) {
            this.mClient.onReceivedHttpAuthRequest(this.mWebView.getWebView(), HttpAuthHandlerImpl.from(httpAuthHandler), str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, webView, webResourceRequest, webResourceResponse) == null) {
            this.mClient.onReceivedHttpError(this.mWebView.getWebView(), WebResourceRequestImpl.from(webResourceRequest), Glue.cast(webResourceResponse));
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, webView, str, str2, str3) == null) {
            this.mClient.onReceivedLoginRequest(this.mWebView.getWebView(), str, str2, str3);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, webView, sslErrorHandler, sslError) == null) {
            this.mClient.onReceivedSslError(this.mWebView.getWebView(), sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView webView, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{webView, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.mClient.onScaleChanged(this.mWebView.getWebView(), f2, f3);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, webView, message, message2) == null) {
            this.mClient.onTooManyRedirects(this.mWebView.getWebView(), message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, webView, keyEvent) == null) {
            this.mClient.onUnhandledKeyEvent(this.mWebView.getWebView(), keyEvent);
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, webView, webResourceRequest)) == null) ? Glue.cast(this.mClient.shouldInterceptRequest(this.mWebView.getWebView(), WebResourceRequestImpl.from(webResourceRequest))) : (WebResourceResponse) invokeLL.objValue;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, str)) == null) ? Glue.cast(this.mClient.shouldInterceptRequest(this.mWebView.getWebView(), str)) : (WebResourceResponse) invokeLL.objValue;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, webView, keyEvent)) == null) ? this.mClient.shouldOverrideKeyEvent(this.mWebView.getWebView(), keyEvent) : invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, webView, str)) == null) ? this.mClient.shouldOverrideUrlLoading(this.mWebView.getWebView(), str) : invokeLL.booleanValue;
    }
}
