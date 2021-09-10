package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class ax extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackHotActivity f59734a;

    public ax(FeedbackHotActivity feedbackHotActivity) {
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
        this.f59734a = feedbackHotActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        TextView textView;
        WebView webView;
        WebView webView2;
        View view;
        TextView textView2;
        LinearLayout linearLayout;
        WebView webView3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            if (message.what == 3) {
                webView = this.f59734a.f59668j;
                if (webView.getProgress() < 100) {
                    webView2 = this.f59734a.f59668j;
                    webView2.stopLoading();
                    view = this.f59734a.l;
                    view.setVisibility(8);
                    Context applicationContext = this.f59734a.getApplicationContext();
                    textView2 = this.f59734a.m;
                    com.baidu.ufosdk.f.i.a(applicationContext, textView2);
                    linearLayout = this.f59734a.f59666h;
                    linearLayout.setVisibility(0);
                    webView3 = this.f59734a.f59668j;
                    webView3.setVisibility(8);
                }
            }
            if (message.what == 0) {
                textView = this.f59734a.n;
                textView.setText(com.baidu.ufosdk.f.s.a("8"));
            }
        }
    }
}
