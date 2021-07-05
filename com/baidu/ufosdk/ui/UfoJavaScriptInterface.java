package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class UfoJavaScriptInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UfoJavaScriptInterface() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void clickOnAndroid(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, webView, str) == null) {
            if (com.baidu.ufosdk.f.h.a()) {
                com.baidu.ufosdk.f.c.a("FAQ fast click, return");
                return;
            }
            Context context = webView.getContext();
            Intent intent = new Intent();
            intent.setClass(context, FeedbackHotActivity.class);
            if (!str.contains("http")) {
                str = "http://" + str;
            }
            intent.putExtra("hoturl", str);
            com.baidu.ufosdk.f.c.c("hoturl---->" + str);
            context.startActivity(intent);
        }
    }
}
