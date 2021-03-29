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
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class ah extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackFacePageActivity f23056a;

    public ah(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f23056a = feedbackFacePageActivity;
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
        super.handleMessage(message);
        if (message.what == 0) {
            if (Integer.parseInt((String) message.obj) > 0) {
                textView4 = this.f23056a.l;
                textView4.setVisibility(0);
            } else {
                textView3 = this.f23056a.l;
                textView3.setVisibility(8);
            }
        }
        if (message.what == 1) {
            this.f23056a.b();
        }
        if (message.what == 2) {
            String format = String.format("os=android&appid=%s&devid=%s&clientid=%s&appvn=%s&sdkvn=%s&baiducuid=%s&nettype=%s&model=%s&osvn=%s&channel_id=%s", UfoSDK.appid, UfoSDK.devid, UfoSDK.clientid, com.baidu.ufosdk.b.e.b(), "2.9.10", com.baidu.ufosdk.b.f22904c, com.baidu.ufosdk.b.d.a(this.f23056a.getApplicationContext()), Build.MODEL, Build.VERSION.RELEASE, String.valueOf(com.baidu.ufosdk.b.j));
            StringBuilder sb = new StringBuilder("https://ufosdk.baidu.com/?m=Web&a=getnfaqlist&");
            sb.append(format);
            String sb2 = sb.toString();
            com.baidu.ufosdk.f.c.c("webview postString is " + sb2);
            webView5 = this.f23056a.o;
            webView5.loadUrl(sb2);
        }
        if (message.what == 3) {
            webView2 = this.f23056a.o;
            if (webView2.getProgress() < 100) {
                webView3 = this.f23056a.o;
                webView3.stopLoading();
                view2 = this.f23056a.n;
                view2.setVisibility(8);
                Context applicationContext = this.f23056a.getApplicationContext();
                textView2 = this.f23056a.q;
                com.baidu.ufosdk.f.i.a(applicationContext, textView2);
                linearLayout2 = this.f23056a.f23003g;
                linearLayout2.setVisibility(0);
                webView4 = this.f23056a.o;
                webView4.setVisibility(8);
            }
        }
        int i = message.what;
        if (i == 4) {
            view = this.f23056a.n;
            view.setVisibility(8);
            Context applicationContext2 = this.f23056a.getApplicationContext();
            textView = this.f23056a.q;
            com.baidu.ufosdk.f.i.a(applicationContext2, textView);
            linearLayout = this.f23056a.f23003g;
            linearLayout.setVisibility(0);
            webView = this.f23056a.o;
            webView.setVisibility(8);
        } else if (i == 12) {
            z2 = this.f23056a.u;
            if (z2) {
                this.f23056a.u = false;
                return;
            }
            str6 = this.f23056a.t;
            if (!TextUtils.isEmpty(str6)) {
                str9 = this.f23056a.f23001e;
                if (TextUtils.isEmpty(str9)) {
                    editor6 = this.f23056a.f22997a;
                    str10 = this.f23056a.t;
                    editor6.putString(str10, "");
                }
            }
            str7 = this.f23056a.f23001e;
            if (!TextUtils.isEmpty(str7)) {
                editor5 = this.f23056a.f22997a;
                str8 = this.f23056a.f23001e;
                editor5.putString(str8, "");
            }
            editor4 = this.f23056a.f22997a;
            editor4.commit();
        } else if (i != 14) {
            if (i == 15) {
                com.baidu.ufosdk.f.c.d("msg.what== 15");
            } else if (i != 16) {
                if (i == 17) {
                }
            } else if (this.f23056a.getCurrentFocus() == null || this.f23056a.getCurrentFocus().getWindowToken() == null) {
            } else {
                ((InputMethodManager) this.f23056a.getSystemService("input_method")).hideSoftInputFromWindow(this.f23056a.getCurrentFocus().getWindowToken(), 2);
            }
        } else {
            z = this.f23056a.u;
            if (z) {
                this.f23056a.u = false;
                return;
            }
            str = this.f23056a.t;
            if (!TextUtils.isEmpty(str)) {
                str4 = this.f23056a.f23001e;
                if (TextUtils.isEmpty(str4)) {
                    editor3 = this.f23056a.f22997a;
                    str5 = this.f23056a.t;
                    editor3.putString(str5, "");
                }
            }
            str2 = this.f23056a.f23001e;
            if (!TextUtils.isEmpty(str2)) {
                editor2 = this.f23056a.f22997a;
                str3 = this.f23056a.f23001e;
                editor2.putString(str3, "");
            }
            editor = this.f23056a.f22997a;
            editor.commit();
            Intent intent = new Intent();
            intent.setClass(this.f23056a, FeedbackInputActivity.class);
            intent.putExtra("msgid", (String) message.obj);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            this.f23056a.startActivity(intent);
        }
    }
}
