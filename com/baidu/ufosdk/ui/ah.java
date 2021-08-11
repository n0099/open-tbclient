package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
public final class ah extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackFacePageActivity f59338a;

    public ah(FeedbackFacePageActivity feedbackFacePageActivity) {
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
        this.f59338a = feedbackFacePageActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        boolean z;
        String str;
        String str2;
        SharedPreferences.Editor editor;
        SharedPreferences.Editor editor2;
        String str3;
        String str4;
        SharedPreferences.Editor editor3;
        String str5;
        boolean z2;
        String str6;
        String str7;
        SharedPreferences.Editor editor4;
        SharedPreferences.Editor editor5;
        String str8;
        String str9;
        SharedPreferences.Editor editor6;
        String str10;
        View view;
        TextView textView;
        LinearLayout linearLayout;
        WebView webView;
        WebView webView2;
        WebView webView3;
        View view2;
        TextView textView2;
        LinearLayout linearLayout2;
        WebView webView4;
        WebView webView5;
        TextView textView3;
        TextView textView4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            if (message.what == 0) {
                if (Integer.parseInt((String) message.obj) > 0) {
                    textView4 = this.f59338a.l;
                    textView4.setVisibility(0);
                } else {
                    textView3 = this.f59338a.l;
                    textView3.setVisibility(8);
                }
            }
            if (message.what == 1) {
                this.f59338a.b();
            }
            if (message.what == 2) {
                String format = String.format("os=android&appid=%s&devid=%s&clientid=%s&appvn=%s&sdkvn=%s&baiducuid=%s&nettype=%s&model=%s&osvn=%s&channel_id=%s", UfoSDK.appid, UfoSDK.devid, UfoSDK.clientid, com.baidu.ufosdk.b.e.b(), "2.9.10", com.baidu.ufosdk.b.f59170c, com.baidu.ufosdk.b.d.a(this.f59338a.getApplicationContext()), Build.MODEL, Build.VERSION.RELEASE, String.valueOf(com.baidu.ufosdk.b.f59177j));
                StringBuilder sb = new StringBuilder("https://ufosdk.baidu.com/?m=Web&a=getnfaqlist&");
                sb.append(format);
                String sb2 = sb.toString();
                com.baidu.ufosdk.f.c.c("webview postString is " + sb2);
                webView5 = this.f59338a.o;
                webView5.loadUrl(sb2);
            }
            if (message.what == 3) {
                webView2 = this.f59338a.o;
                if (webView2.getProgress() < 100) {
                    webView3 = this.f59338a.o;
                    webView3.stopLoading();
                    view2 = this.f59338a.n;
                    view2.setVisibility(8);
                    Context applicationContext = this.f59338a.getApplicationContext();
                    textView2 = this.f59338a.q;
                    com.baidu.ufosdk.f.i.a(applicationContext, textView2);
                    linearLayout2 = this.f59338a.f59275g;
                    linearLayout2.setVisibility(0);
                    webView4 = this.f59338a.o;
                    webView4.setVisibility(8);
                }
            }
            int i2 = message.what;
            if (i2 == 4) {
                view = this.f59338a.n;
                view.setVisibility(8);
                Context applicationContext2 = this.f59338a.getApplicationContext();
                textView = this.f59338a.q;
                com.baidu.ufosdk.f.i.a(applicationContext2, textView);
                linearLayout = this.f59338a.f59275g;
                linearLayout.setVisibility(0);
                webView = this.f59338a.o;
                webView.setVisibility(8);
            } else if (i2 == 12) {
                z2 = this.f59338a.u;
                if (z2) {
                    this.f59338a.u = false;
                    return;
                }
                str6 = this.f59338a.t;
                if (!TextUtils.isEmpty(str6)) {
                    str9 = this.f59338a.f59273e;
                    if (TextUtils.isEmpty(str9)) {
                        editor6 = this.f59338a.f59269a;
                        str10 = this.f59338a.t;
                        editor6.putString(str10, "");
                    }
                }
                str7 = this.f59338a.f59273e;
                if (!TextUtils.isEmpty(str7)) {
                    editor5 = this.f59338a.f59269a;
                    str8 = this.f59338a.f59273e;
                    editor5.putString(str8, "");
                }
                editor4 = this.f59338a.f59269a;
                editor4.commit();
            } else if (i2 != 14) {
                if (i2 == 15) {
                    com.baidu.ufosdk.f.c.d("msg.what== 15");
                } else if (i2 != 16) {
                    if (i2 == 17) {
                    }
                } else if (this.f59338a.getCurrentFocus() == null || this.f59338a.getCurrentFocus().getWindowToken() == null) {
                } else {
                    ((InputMethodManager) this.f59338a.getSystemService("input_method")).hideSoftInputFromWindow(this.f59338a.getCurrentFocus().getWindowToken(), 2);
                }
            } else {
                z = this.f59338a.u;
                if (z) {
                    this.f59338a.u = false;
                    return;
                }
                str = this.f59338a.t;
                if (!TextUtils.isEmpty(str)) {
                    str4 = this.f59338a.f59273e;
                    if (TextUtils.isEmpty(str4)) {
                        editor3 = this.f59338a.f59269a;
                        str5 = this.f59338a.t;
                        editor3.putString(str5, "");
                    }
                }
                str2 = this.f59338a.f59273e;
                if (!TextUtils.isEmpty(str2)) {
                    editor2 = this.f59338a.f59269a;
                    str3 = this.f59338a.f59273e;
                    editor2.putString(str3, "");
                }
                editor = this.f59338a.f59269a;
                editor.commit();
                Intent intent = new Intent();
                intent.setClass(this.f59338a, FeedbackInputActivity.class);
                intent.putExtra("msgid", (String) message.obj);
                intent.putExtra("feedback_channel", com.baidu.ufosdk.b.f59177j);
                this.f59338a.startActivity(intent);
            }
        }
    }
}
