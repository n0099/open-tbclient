package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
/* loaded from: classes8.dex */
public final class av extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackFacePageActivity f59552a;

    public av(FeedbackFacePageActivity feedbackFacePageActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackFacePageActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59552a = feedbackFacePageActivity;
    }

    public /* synthetic */ av(FeedbackFacePageActivity feedbackFacePageActivity, byte b2) {
        this(feedbackFacePageActivity);
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        WebView webView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            StringBuilder sb = new StringBuilder("UfoWebViewClient --> onLoadResource : ");
            webView2 = this.f59552a.o;
            sb.append(webView2.getProgress());
            com.baidu.ufosdk.f.c.c(sb.toString());
            super.onLoadResource(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        View view;
        Timer timer;
        Timer timer2;
        Timer timer3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            super.onPageFinished(webView, str);
            view = this.f59552a.n;
            view.setVisibility(8);
            timer = this.f59552a.p;
            if (timer != null) {
                timer2 = this.f59552a.p;
                timer2.cancel();
                timer3 = this.f59552a.p;
                timer3.purge();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        View view;
        Timer timer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
            com.baidu.ufosdk.f.c.c("UfoWebViewClient --> onPageStarted");
            super.onPageStarted(webView, str, bitmap);
            view = this.f59552a.n;
            view.setVisibility(0);
            this.f59552a.p = new Timer();
            aw awVar = new aw(this);
            timer = this.f59552a.p;
            timer.schedule(awVar, 20000L);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        TextView textView;
        LinearLayout linearLayout;
        WebView webView2;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048579, this, webView, i2, str, str2) == null) {
            com.baidu.ufosdk.f.c.c("onReceivedError --> errorCode:" + i2 + ",description:" + str + ",failingUrl:" + str2);
            super.onReceivedError(webView, i2, str, str2);
            Context applicationContext = this.f59552a.getApplicationContext();
            textView = this.f59552a.q;
            com.baidu.ufosdk.f.i.a(applicationContext, textView);
            linearLayout = this.f59552a.f59475g;
            linearLayout.setVisibility(0);
            webView2 = this.f59552a.o;
            webView2.setVisibility(8);
            view = this.f59552a.n;
            view.setVisibility(8);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
            com.baidu.ufosdk.f.c.c("UfoWebViewClient --> shouldOverrideUrlLoading:" + str);
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }
}
