package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes8.dex */
public final class ao implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackFacePageActivity f59891a;

    public ao(FeedbackFacePageActivity feedbackFacePageActivity) {
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
        this.f59891a = feedbackFacePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        LinearLayout linearLayout;
        WebView webView;
        WebView webView2;
        LinearLayout linearLayout2;
        WebView webView3;
        Handler handler;
        WebView webView4;
        View view3;
        TextView textView;
        LinearLayout linearLayout3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || com.baidu.ufosdk.f.h.a()) {
            return;
        }
        try {
            view2 = this.f59891a.n;
            view2.setVisibility(0);
            linearLayout = this.f59891a.f59821g;
            linearLayout.setVisibility(8);
            webView = this.f59891a.o;
            webView.setVisibility(0);
            if (!com.baidu.ufosdk.b.d.c(this.f59891a.getApplicationContext())) {
                webView4 = this.f59891a.o;
                webView4.setVisibility(8);
                view3 = this.f59891a.n;
                view3.setVisibility(8);
                Context applicationContext = this.f59891a.getApplicationContext();
                textView = this.f59891a.q;
                com.baidu.ufosdk.f.i.a(applicationContext, textView);
                linearLayout3 = this.f59891a.f59821g;
                linearLayout3.setVisibility(0);
                Toast.makeText(this.f59891a, com.baidu.ufosdk.f.s.a(WebKitFactory.OS_64), 1).show();
            } else if (UfoSDK.clientid.length() == 0) {
                Toast.makeText(this.f59891a, com.baidu.ufosdk.f.s.a("62"), 1).show();
                new Thread(new ap(this)).start();
            } else {
                webView2 = this.f59891a.o;
                webView2.loadDataWithBaseURL(null, null, SapiWebView.DATA_MIME_TYPE, "utf-8", null);
                linearLayout2 = this.f59891a.f59821g;
                linearLayout2.setVisibility(8);
                webView3 = this.f59891a.o;
                webView3.setVisibility(0);
                handler = this.f59891a.v;
                handler.obtainMessage(1, null).sendToTarget();
                new Thread(new aq(this)).start();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
