package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ResumeCallBack;
import com.baidu.ufosdk.UfoSDK;
import java.util.HashMap;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"InlinedApi", "SetJavaScriptEnabled", "JavascriptInterface", "NewApi"})
/* loaded from: classes5.dex */
public class FeedbackHotActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f23389a;

    /* renamed from: b  reason: collision with root package name */
    public final int f23390b;

    /* renamed from: c  reason: collision with root package name */
    public final int f23391c;

    /* renamed from: d  reason: collision with root package name */
    public final int f23392d;

    /* renamed from: e  reason: collision with root package name */
    public final int f23393e;

    /* renamed from: f  reason: collision with root package name */
    public final String f23394f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f23395g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f23396h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f23397i;
    public WebView j;
    public Button k;
    public View l;
    public TextView m;
    public TextView n;
    public String o;
    public String p;
    public Timer q;
    @SuppressLint({"NewApi", "HandlerLeak"})
    public Handler r;
    public boolean s;

    public FeedbackHotActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23389a = R.id.App_Launch_Circle_Animation_View;
        this.f23390b = R.id.App_Launch_Shimmer_Animation_View;
        this.f23391c = R.id.BLOCK;
        this.f23392d = R.id.BOTH;
        this.f23393e = R.id.BOTTOM;
        this.f23394f = "UfoCacheFile";
        this.o = "";
        this.p = "";
        this.r = new ax(this);
        this.s = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || UfoSDK.clientid.length() == 0) {
            return;
        }
        String stringExtra = getIntent().getStringExtra("hoturl");
        this.o = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        com.baidu.ufosdk.f.c.c("hoturl is " + this.o);
        this.o = this.o.replace("http://ufosdk.baidu.com/", "https://ufosdk.baidu.com/");
        com.baidu.ufosdk.f.c.c("replaced hoturl is " + this.o);
        String[] split = this.o.split("&");
        if (split.length > 0) {
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String str = split[i2];
                if (str.startsWith("faq_id=")) {
                    String replace = str.replace("faq_id=", "");
                    try {
                        Integer.parseInt(replace);
                        this.p = replace;
                        break;
                    } catch (NumberFormatException unused) {
                        this.p = "";
                    }
                } else {
                    i2++;
                }
            }
        }
        if (this.o.contains("ufosdk.baidu.com")) {
            if (this.o.contains("http")) {
                this.j.loadUrl(this.o);
                return;
            }
            WebView webView = this.j;
            webView.loadUrl("https://" + this.o);
            return;
        }
        this.r.obtainMessage(0).sendToTarget();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IAdRequestParam.OS, "android");
            jSONObject.put("appvn", com.baidu.ufosdk.b.e.b());
            jSONObject.put("devid", UfoSDK.devid);
            jSONObject.put("osvn", Build.VERSION.RELEASE);
            jSONObject.put("appname", com.baidu.ufosdk.b.e.a());
            jSONObject.put("channel_id", com.baidu.ufosdk.b.j);
            jSONObject.put("nettype", com.baidu.ufosdk.b.d.b(this));
            jSONObject.put("model", Build.MODEL);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String jSONObject2 = jSONObject.length() > 0 ? jSONObject.toString() : "";
        HashMap hashMap = new HashMap();
        hashMap.put("refertype", "mobile");
        hashMap.put("newreferer", jSONObject2);
        if (Build.VERSION.SDK_INT >= 8) {
            this.j.loadUrl(this.o, hashMap);
        } else {
            this.j.loadUrl(this.o);
        }
    }

    public static /* synthetic */ void a(FeedbackHotActivity feedbackHotActivity, String str) {
        if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(feedbackHotActivity.getApplicationContext(), com.baidu.ufosdk.f.s.a("62"), 1).show();
            if (com.baidu.ufosdk.b.d.c(feedbackHotActivity.getApplicationContext())) {
                new Thread(new bb(feedbackHotActivity)).start();
                return;
            }
            return;
        }
        int i2 = 0;
        try {
            i2 = Integer.parseInt(str.split("=")[1]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setClass(feedbackHotActivity, FeedbackEditActivity.class);
        intent.putExtra("msgid", "newMessage");
        intent.putExtra("faq_id", feedbackHotActivity.p);
        intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        intent.putExtra("product_type", i2);
        intent.putExtra("come_from", 1);
        feedbackHotActivity.startActivity(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                finish();
                try {
                    com.baidu.ufosdk.f.c.d("执行动画...");
                    overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_out_to_right"));
                } catch (Exception unused) {
                    com.baidu.ufosdk.f.c.d("执行动画失败！！");
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            try {
                com.baidu.ufosdk.f.c.d("执行动画...");
                overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_out_to_left"));
            } catch (Exception unused) {
                com.baidu.ufosdk.f.c.d("执行动画错误！");
            }
            super.onCreate(bundle);
            requestWindowFeature(1);
            com.baidu.ufosdk.f.r.a(this, getWindow());
            com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.f23395g = relativeLayout;
            relativeLayout.setFitsSystemWindows(true);
            this.f23395g.setId(R.id.BOTH);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setId(R.id.BLOCK);
            this.f23395g.setBackgroundColor(com.baidu.ufosdk.b.z);
            LinearLayout linearLayout = new LinearLayout(this);
            this.f23396h = linearLayout;
            linearLayout.setOrientation(1);
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 115.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 85.0f));
            try {
                imageView.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_no_netwrok.png")));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f23396h.addView(imageView, layoutParams);
            TextView textView = new TextView(this);
            this.m = textView;
            textView.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f));
            this.m.setTextSize(com.baidu.ufosdk.b.O);
            this.m.setTextColor(com.baidu.ufosdk.b.x);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            com.baidu.ufosdk.f.i.a(getApplicationContext(), this.m);
            this.f23396h.addView(this.m, layoutParams2);
            Button button = new Button(this);
            this.k = button;
            button.setText(com.baidu.ufosdk.f.s.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE));
            this.k.setTextSize(com.baidu.ufosdk.b.P);
            this.k.setTextColor(com.baidu.ufosdk.b.w);
            try {
                this.k.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 122.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
            layoutParams3.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0);
            this.f23396h.addView(this.k, layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(13);
            this.f23395g.addView(this.f23396h, layoutParams4);
            this.f23396h.setGravity(17);
            this.f23396h.setVisibility(8);
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            linearLayout2.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
            layoutParams5.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0, 0, 0);
            ImageView imageView2 = new ImageView(this);
            this.f23397i = imageView2;
            imageView2.setId(R.id.App_Launch_Circle_Animation_View);
            this.f23397i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f23397i.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_back_icon_browser.png")));
            linearLayout2.addView(this.f23397i, layoutParams5);
            TextView textView2 = new TextView(this);
            textView2.setText(com.baidu.ufosdk.b.f23290i);
            textView2.setTextSize(com.baidu.ufosdk.b.M);
            textView2.setTextColor(com.baidu.ufosdk.b.H);
            textView2.setGravity(16);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams6.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
            linearLayout2.addView(textView2, layoutParams6);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.addRule(9);
            layoutParams7.addRule(15);
            relativeLayout2.addView(linearLayout2, layoutParams7);
            relativeLayout2.setBackgroundColor(com.baidu.ufosdk.b.A);
            TextView textView3 = new TextView(this);
            this.n = textView3;
            textView3.setId(R.id.App_Launch_Shimmer_Animation_View);
            this.n.setText(com.baidu.ufosdk.f.s.a("8"));
            this.n.setTextColor(com.baidu.ufosdk.b.r);
            this.n.setTextSize(com.baidu.ufosdk.b.S);
            this.n.setGravity(17);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams8.addRule(13);
            relativeLayout2.addView(this.n, layoutParams8);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
            layoutParams9.addRule(10);
            this.f23395g.addView(relativeLayout2, layoutParams9);
            View view = new View(this);
            view.setId(R.id.BOTTOM);
            view.setBackgroundColor(-2894893);
            RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            layoutParams10.addRule(3, relativeLayout2.getId());
            this.f23395g.addView(view, layoutParams10);
            WebView webView = new WebView(this);
            this.j = webView;
            webView.setBackgroundColor(com.baidu.ufosdk.b.z);
            RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams11.addRule(12);
            layoutParams11.addRule(3, view.getId());
            this.f23395g.addView(this.j, layoutParams11);
            new RelativeLayout.LayoutParams(-1, -1);
            this.f23395g.setLayoutParams(layoutParams6);
            setContentView(this.f23395g);
            this.l = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a("13"));
            RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams12.addRule(13);
            this.f23395g.addView(this.l, layoutParams12);
            WebSettings settings = this.j.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            if (com.baidu.ufosdk.b.d.b(getApplicationContext()).contains(RomUtils.UNKNOWN) || com.baidu.ufosdk.b.d.b(getApplicationContext()).contains("NONE")) {
                this.l.setVisibility(8);
            } else {
                this.f23396h.setVisibility(8);
                this.j.setVisibility(0);
            }
            this.j.setWebViewClient(new bc(this, (byte) 0));
            linearLayout2.setOnClickListener(new ay(this));
            this.k.setOnClickListener(new az(this));
            a();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            ResumeCallBack resumeCallBack = com.baidu.ufosdk.b.ac;
            if (resumeCallBack != null) {
                resumeCallBack.onResumeCallback();
            }
            this.k.setText(com.baidu.ufosdk.f.s.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE));
            this.n.setText(com.baidu.ufosdk.f.s.a("8"));
            com.baidu.ufosdk.f.i.a((RelativeLayout) this.l, com.baidu.ufosdk.f.s.a("13"));
            this.j.resumeTimers();
            if (UfoSDK.clientid.length() == 0) {
                new Thread(new ba(this)).start();
            }
        }
    }
}
