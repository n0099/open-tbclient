package com.baidu.ufosdk;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity;
/* loaded from: classes6.dex */
public class v extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;
    public int b;

    public v(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.a = hVar;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            super.onLoadResource(webView, str);
            if (((FeedbackBrowserActivity) this.a) != null) {
                return;
            }
            throw null;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            this.a.c(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str)) == null) {
            h hVar = this.a;
            if (hVar != null) {
                f fVar = ((FeedbackBrowserActivity) hVar).f;
                if (fVar != null) {
                    return ((FeedbackBrowserActivity.b) fVar).a(webView, str);
                }
                return false;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
            this.a.a(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, webView, webResourceRequest, webResourceResponse) == null) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, webView, sslErrorHandler, sslError) == null) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048579, this, webView, i, str, str2) == null) {
            b.a("UFOWebViewClient", "onReceivedError: " + i + ", failUrl: " + str2);
            int i2 = webView.getContext().getSharedPreferences("feedback_switch_prefs", 0).getInt("res_c_er_lim", 9);
            int i3 = this.b;
            this.b = i3 + 1;
            if (i3 >= i2 && i != -10 && i != -1) {
                this.a.a(i, str2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, webResourceRequest, webResourceError) == null) {
            b.a("UFOWebViewClient", "onReceivedError: " + webResourceError.getErrorCode() + ", failUrl: " + webResourceRequest.getUrl().toString());
            int i = webView.getContext().getSharedPreferences("feedback_switch_prefs", 0).getInt("res_c_er_lim", 9);
            int i2 = this.b;
            this.b = i2 + 1;
            if (i2 >= i && webResourceError.getErrorCode() != -10 && webResourceError.getErrorCode() != -1) {
                this.a.a(webResourceError.getErrorCode(), webResourceRequest.getUrl().toString());
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, webResourceRequest)) == null) {
            if (this.a != null && webResourceRequest != null && webResourceRequest.getUrl() != null) {
                h hVar = this.a;
                String uri = webResourceRequest.getUrl().toString();
                f fVar = ((FeedbackBrowserActivity) hVar).f;
                if (fVar != null) {
                    return ((FeedbackBrowserActivity.b) fVar).a(webView, uri);
                }
                return false;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        return invokeLL.booleanValue;
    }
}
