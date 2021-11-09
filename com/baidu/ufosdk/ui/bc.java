package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
import java.util.Timer;
/* loaded from: classes10.dex */
public final class bc extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackHotActivity f56825a;

    public bc(FeedbackHotActivity feedbackHotActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackHotActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56825a = feedbackHotActivity;
    }

    public /* synthetic */ bc(FeedbackHotActivity feedbackHotActivity, byte b2) {
        this(feedbackHotActivity);
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
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
            view = this.f56825a.l;
            view.setVisibility(8);
            webView.requestFocus();
            timer = this.f56825a.q;
            if (timer != null) {
                timer2 = this.f56825a.q;
                timer2.cancel();
                timer3 = this.f56825a.q;
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
            super.onPageStarted(webView, str, bitmap);
            webView.clearView();
            view = this.f56825a.l;
            view.setVisibility(0);
            this.f56825a.q = new Timer();
            bd bdVar = new bd(this);
            timer = this.f56825a.q;
            timer.schedule(bdVar, 20000L);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        TextView textView;
        LinearLayout linearLayout;
        WebView webView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048579, this, webView, i2, str, str2) == null) {
            super.onReceivedError(webView, i2, str, str2);
            Context applicationContext = this.f56825a.getApplicationContext();
            textView = this.f56825a.m;
            com.baidu.ufosdk.f.i.a(applicationContext, textView);
            linearLayout = this.f56825a.f56754h;
            linearLayout.setVisibility(0);
            webView2 = this.f56825a.j;
            webView2.setVisibility(8);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
            com.baidu.ufosdk.f.c.a("webClick ==> click:url-->" + str);
            com.baidu.ufosdk.f.c.a("PluginInvoker.appid=" + UfoSDK.appid);
            if (str.startsWith("feedback://")) {
                FeedbackHotActivity.a(this.f56825a, str);
                return true;
            }
            if (str.startsWith("solve://")) {
                z = this.f56825a.s;
                if (z) {
                    return true;
                }
                Toast.makeText(this.f56825a, com.baidu.ufosdk.f.s.a("26"), 0).show();
            } else if (str.startsWith("backtoufo://")) {
                this.f56825a.finish();
                return true;
            } else if (!str.startsWith("unsolved://")) {
                if (str.startsWith("https://") || str.startsWith("http://")) {
                    try {
                        com.baidu.ufosdk.f.c.a(">>跳转链接：" + str);
                        this.f56825a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } else if (str.startsWith("baidumap://")) {
                    try {
                        com.baidu.ufosdk.f.c.a("跳转链接：" + str);
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        this.f56825a.startActivity(intent);
                        return true;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        Toast.makeText(this.f56825a.getApplicationContext(), "打开失败，未安装百度地图！", 0).show();
                        return true;
                    }
                } else {
                    return true;
                }
            }
            this.f56825a.s = true;
            return true;
        }
        return invokeLL.booleanValue;
    }
}
