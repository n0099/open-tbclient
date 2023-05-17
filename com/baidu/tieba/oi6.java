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
/* loaded from: classes6.dex */
public class oi6 extends mi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final nh6 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oi6(mi6 mi6Var, nh6 nh6Var) {
        super(mi6Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mi6Var, nh6Var};
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
        this.b = nh6Var;
    }

    @Override // com.baidu.tieba.mi6, android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            super.onLoadResource(webView, str);
            nh6 nh6Var = this.b;
            if (nh6Var != null) {
                nh6Var.c(webView, str);
            }
        }
    }

    @Override // com.baidu.tieba.mi6, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            super.onPageFinished(webView, str);
            nh6 nh6Var = this.b;
            if (nh6Var != null) {
                nh6Var.onPageFinished(webView, str);
            }
        }
    }

    @Override // com.baidu.tieba.mi6, android.webkit.WebViewClient
    @RequiresApi(24)
    public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, webResourceRequest)) == null) {
            Uri url = webResourceRequest.getUrl();
            nh6 nh6Var = this.b;
            if (nh6Var != null && url != null && nh6Var.shouldOverrideUrlLoading(webView, url.toString())) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.mi6, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
            nh6 nh6Var = this.b;
            if (nh6Var != null) {
                nh6Var.d(webView, str);
            }
        }
    }

    @Override // com.baidu.tieba.mi6, android.webkit.WebViewClient
    @RequiresApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, webResourceRequest, webResourceError) == null) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            nh6 nh6Var = this.b;
            if (nh6Var != null) {
                nh6Var.b(webView, webResourceRequest, webResourceError.getErrorCode(), webResourceError.getDescription());
            }
        }
    }

    @Override // com.baidu.tieba.mi6, android.webkit.WebViewClient
    @RequiresApi(23)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, webResourceRequest, webResourceResponse) == null) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            nh6 nh6Var = this.b;
            if (nh6Var != null) {
                nh6Var.b(webView, webResourceRequest, webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase());
            }
        }
    }

    @Override // com.baidu.tieba.mi6, android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, webView, sslErrorHandler, sslError) == null) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            nh6 nh6Var = this.b;
            if (nh6Var != null) {
                nh6Var.a(webView, sslErrorHandler, sslError);
            }
        }
    }

    @Override // com.baidu.tieba.mi6, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, str)) == null) {
            nh6 nh6Var = this.b;
            if (nh6Var != null && nh6Var.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }
}
