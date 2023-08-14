package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wl6 extends ul6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final uk6 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wl6(ul6 ul6Var, uk6 uk6Var) {
        super(ul6Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ul6Var, uk6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((WebViewClient) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = uk6Var;
    }

    @Override // com.baidu.tieba.ul6, android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            super.onLoadResource(webView, str);
            uk6 uk6Var = this.b;
            if (uk6Var != null) {
                uk6Var.c(webView, str);
            }
        }
    }

    @Override // com.baidu.tieba.ul6, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            super.onPageFinished(webView, str);
            uk6 uk6Var = this.b;
            if (uk6Var != null) {
                uk6Var.onPageFinished(webView, str);
            }
        }
    }

    @Override // com.baidu.tieba.ul6, android.webkit.WebViewClient
    @RequiresApi(24)
    public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, webResourceRequest)) == null) {
            Uri url = webResourceRequest.getUrl();
            uk6 uk6Var = this.b;
            if (uk6Var != null && url != null && uk6Var.shouldOverrideUrlLoading(webView, url.toString())) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.ul6, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
            uk6 uk6Var = this.b;
            if (uk6Var != null) {
                uk6Var.d(webView, str);
            }
        }
    }

    @Override // com.baidu.tieba.ul6, android.webkit.WebViewClient
    @RequiresApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, webResourceRequest, webResourceError) == null) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            uk6 uk6Var = this.b;
            if (uk6Var != null) {
                uk6Var.b(webView, webResourceRequest, webResourceError.getErrorCode(), webResourceError.getDescription());
            }
        }
    }

    @Override // com.baidu.tieba.ul6, android.webkit.WebViewClient
    @RequiresApi(23)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, webResourceRequest, webResourceResponse) == null) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            uk6 uk6Var = this.b;
            if (uk6Var != null) {
                uk6Var.b(webView, webResourceRequest, webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase());
            }
        }
    }

    @Override // com.baidu.tieba.ul6, android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, webView, sslErrorHandler, sslError) == null) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            uk6 uk6Var = this.b;
            if (uk6Var != null) {
                uk6Var.a(webView, sslErrorHandler, sslError);
            }
        }
    }

    @Override // com.baidu.tieba.ul6, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, str)) == null) {
            uk6 uk6Var = this.b;
            if (uk6Var != null && uk6Var.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }
}
