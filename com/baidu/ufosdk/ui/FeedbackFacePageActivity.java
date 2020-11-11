package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tieba.R;
import com.baidu.ufosdk.UfoSDK;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.Timer;
/* loaded from: classes22.dex */
public class FeedbackFacePageActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences.Editor f3734a;
    private SharedPreferences b;
    private RelativeLayout f;
    private LinearLayout g;
    private ImageView h;
    private Button i;
    private Button j;
    private TextView k;
    private TextView l;
    private RelativeLayout m;
    private View n;
    private WebView o;
    private Timer p;
    private TextView q;
    private TextView r;
    private TextView s;
    private String t;
    private LinearLayout w;
    private String c = "";
    private String d = "";
    private String e = "";
    private boolean u = false;
    @SuppressLint({"HandlerLeak"})
    private Handler v = new ah(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (UfoSDK.clientid.length() == 0) {
            return;
        }
        this.v.obtainMessage(2, null).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        getApplicationContext();
        new au(this).execute(new Void[0]);
    }

    public final void a() {
        if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(getApplicationContext(), com.baidu.ufosdk.f.s.a("62"), 1).show();
            if (com.baidu.ufosdk.b.d.c(getApplicationContext())) {
                new Thread(new at(this)).start();
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.putExtra("url", this.c);
        intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        intent.putExtra("extra", this.d);
        intent.setClass(this, FeedbackListActivity.class);
        startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setSoftInputMode(32);
        com.baidu.ufosdk.f.r.a(this, getWindow());
        com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
        try {
            this.f = new RelativeLayout(this);
            this.f.setBackgroundColor(com.baidu.ufosdk.b.z);
            this.f.setFitsSystemWindows(true);
            setContentView(this.f);
            this.b = getSharedPreferences("UfoSharePreference", 0);
            if (this.b != null) {
                this.f3734a = this.b.edit();
            }
            if (this.f3734a != null) {
                this.f3734a.putBoolean("ADD_PIC_FLAG", true);
                this.f3734a.commit();
            }
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    String stringExtra = intent.getStringExtra("username");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        com.baidu.ufosdk.b.b = stringExtra;
                    }
                    String stringExtra2 = intent.getStringExtra("baiducuid");
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        com.baidu.ufosdk.b.c = stringExtra2;
                    }
                    String stringExtra3 = intent.getStringExtra("prefix");
                    if (!TextUtils.isEmpty(stringExtra3)) {
                        com.baidu.ufosdk.b.l = stringExtra3;
                    }
                } catch (Exception e) {
                    com.baidu.ufosdk.f.c.d("fromIntentForAppsearch error! " + e.getMessage());
                }
            }
            int intExtra = getIntent().getIntExtra("feedback_channel", 0);
            com.baidu.ufosdk.f.c.a("####### channelInt = " + intExtra);
            com.baidu.ufosdk.b.j = intExtra;
            com.baidu.ufosdk.b.k = getIntent().getIntExtra("faq_channel", 0);
            this.e = getIntent().getStringExtra("faq_id");
            this.t = getIntent().getStringExtra("msgid");
            if (TextUtils.isEmpty(this.t)) {
                this.t = "newMessage";
            }
            if (TextUtils.isEmpty(this.e)) {
                this.e = "";
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Toast.makeText(this, "组件创建失败，请稍候重试!", 0).show();
            com.baidu.ufosdk.f.c.d("onCreate error !!");
            finish();
        }
        try {
            this.o = new WebView(this);
        } catch (Exception e3) {
            Toast.makeText(this, "WebView组件加载失败，请稍候重试!", 0).show();
            com.baidu.ufosdk.f.c.d("webView = new WebView(this) error !!");
            finish();
        }
        try {
            if (this.o == null) {
                this.o = new WebView(this);
            }
            this.f.setId(R.raw.ala_play);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            relativeLayout.setId(R.string.abc_action_mode_done);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0, 0, 0);
            this.h = new ImageView(this);
            this.h.setId(R.raw.aiapp_guide);
            this.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.h.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_back_icon_browser.png")));
            linearLayout.addView(this.h, layoutParams);
            TextView textView = new TextView(this);
            textView.setText(com.baidu.ufosdk.b.i);
            textView.setTextSize(com.baidu.ufosdk.b.M);
            textView.setTextColor(com.baidu.ufosdk.b.H);
            textView.setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
            linearLayout.addView(textView, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(9);
            layoutParams3.addRule(15);
            relativeLayout.addView(linearLayout, layoutParams3);
            this.k = new TextView(this);
            this.k.setId(R.raw.ala_live1);
            this.k.setText(com.baidu.ufosdk.f.s.a("7"));
            this.k.setTextColor(com.baidu.ufosdk.b.r);
            this.k.setTextSize(com.baidu.ufosdk.b.T);
            this.k.setGravity(17);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams4.addRule(13);
            relativeLayout.addView(this.k, layoutParams4);
            this.i = new Button(this);
            this.i.setText(com.baidu.ufosdk.f.s.a("17"));
            this.i.setId(R.string.abc_capital_off);
            this.i.setTextColor(com.baidu.ufosdk.b.s);
            this.i.setTextSize(com.baidu.ufosdk.b.U);
            this.i.setGravity(17);
            this.i.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.s, com.baidu.ufosdk.b.t, com.baidu.ufosdk.b.s, com.baidu.ufosdk.b.s));
            this.i.setBackgroundColor(16777215);
            this.i.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(11);
            layoutParams5.addRule(15);
            layoutParams5.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 6.0f), 0);
            relativeLayout.addView(this.i, layoutParams5);
            this.l = new TextView(this);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 9.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 9.0f));
            this.l.setTextColor(-1);
            this.l.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_newmsg_flag.png")));
            this.l.setGravity(17);
            this.l.setVisibility(8);
            layoutParams6.addRule(11);
            layoutParams6.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 13.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), 0);
            relativeLayout.addView(this.l, layoutParams6);
            relativeLayout.setBackgroundColor(com.baidu.ufosdk.b.A);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
            layoutParams7.addRule(10);
            this.f.addView(relativeLayout, layoutParams7);
            View view = new View(this);
            view.setId(R.string.status_bar_notification_info_overflow);
            view.setBackgroundColor(-2894893);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            layoutParams8.addRule(3, relativeLayout.getId());
            this.f.addView(view, layoutParams8);
            this.w = new LinearLayout(this);
            this.w.setId(R.string.sapi_sdk_common_loading_timeout);
            this.w.setOrientation(0);
            this.w.setBackgroundColor(com.baidu.ufosdk.b.B);
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            linearLayout2.setBackgroundColor(com.baidu.ufosdk.b.B);
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(0);
            linearLayout3.setGravity(17);
            linearLayout3.setBackgroundColor(com.baidu.ufosdk.b.B);
            this.r = new TextView(this);
            this.r.setText(com.baidu.ufosdk.f.s.a("42"));
            this.r.setTextColor(-13421773);
            this.r.setTextSize(com.baidu.ufosdk.b.Z);
            this.s = new TextView(this);
            this.s.setText(com.baidu.ufosdk.f.s.a("43"));
            this.s.setTextColor(-13421773);
            this.s.setTextSize(com.baidu.ufosdk.b.Z);
            int i = 7;
            int i2 = 7;
            switch (com.baidu.ufosdk.b.q) {
                case 0:
                    linearLayout2.setVisibility(0);
                    linearLayout3.setVisibility(0);
                    i = 7;
                    i2 = 7;
                    break;
                case 1:
                    linearLayout2.setVisibility(0);
                    linearLayout3.setVisibility(8);
                    i = 10;
                    break;
                case 2:
                    linearLayout2.setVisibility(8);
                    linearLayout3.setVisibility(0);
                    i2 = 10;
                    break;
                default:
                    linearLayout2.setVisibility(0);
                    linearLayout3.setVisibility(0);
                    i = 7;
                    i2 = 7;
                    break;
            }
            linearLayout2.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_face_customer.png"));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout2.addView(imageView, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f)));
            linearLayout2.addView(this.r, new LinearLayout.LayoutParams(-2, -2));
            linearLayout3.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
            ImageView imageView2 = new ImageView(this);
            imageView2.setImageBitmap(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_face_advise.png"));
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout3.addView(imageView2, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f)));
            linearLayout3.addView(this.s, new LinearLayout.LayoutParams(-2, -2));
            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams9.setMargins(com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a(this, i), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
            layoutParams9.weight = 1.0f;
            this.w.addView(linearLayout2, layoutParams9);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams10.setMargins(com.baidu.ufosdk.f.i.a(this, i2), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
            layoutParams10.weight = 1.0f;
            this.w.addView(linearLayout3, layoutParams10);
            RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
            layoutParams11.addRule(12);
            this.f.addView(this.w, layoutParams11);
            View view2 = new View(this);
            view2.setId(R.string.sapi_sdk_common_retry_btn_text);
            view2.setBackgroundColor(-2894893);
            RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            layoutParams12.addRule(2, this.w.getId());
            this.f.addView(view2, layoutParams12);
            linearLayout3.setOnClickListener(new ai(this));
            linearLayout2.setOnClickListener(new ak(this));
            linearLayout.setOnClickListener(new am(this));
            this.i.setOnClickListener(new an(this));
            int id = view.getId();
            int id2 = view2.getId();
            this.m = new RelativeLayout(this);
            if (this.o == null) {
                this.o = new WebView(this);
            }
            this.m.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.g = new LinearLayout(this);
            this.g.setOrientation(1);
            this.g.setGravity(17);
            this.g.setVisibility(8);
            new LinearLayout.LayoutParams(-2, -2);
            ImageView imageView3 = new ImageView(this);
            LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 115.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 85.0f));
            try {
                imageView3.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_no_netwrok.png")));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.g.addView(imageView3, layoutParams13);
            this.q = new TextView(this);
            this.q.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f));
            this.q.setTextSize(com.baidu.ufosdk.b.O);
            this.q.setTextColor(com.baidu.ufosdk.b.x);
            LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, -2);
            com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
            this.g.addView(this.q, layoutParams14);
            this.j = new Button(this);
            this.j.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
            this.j.setTextSize(com.baidu.ufosdk.b.P);
            this.j.setTextColor(com.baidu.ufosdk.b.w);
            try {
                this.j.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 122.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
            layoutParams15.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0);
            this.g.addView(this.j, layoutParams15);
            RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams16.addRule(13);
            this.m.addView(this.g, layoutParams16);
            this.j.setOnClickListener(new ao(this));
            LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.setOrientation(0);
            linearLayout4.setGravity(16);
            LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-1, -1);
            if (Integer.parseInt(Build.VERSION.SDK) >= 11) {
                this.o.setLayerType(1, null);
            }
            linearLayout4.addView(this.o, layoutParams17);
            this.m.addView(linearLayout4, new RelativeLayout.LayoutParams(-1, -1));
            this.n = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
            RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams18.addRule(13);
            this.m.addView(this.n, layoutParams18);
            RelativeLayout.LayoutParams layoutParams19 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams19.addRule(3, id);
            layoutParams19.addRule(2, id2);
            this.f.addView(this.m, layoutParams19);
            this.o.getSettings().setJavaScriptEnabled(true);
            this.o.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            try {
                this.o.getClass().getMethod("removeJavascriptInterface", String.class);
                this.o.removeJavascriptInterface("searchBoxJavaBridge_");
                this.o.removeJavascriptInterface("accessibility");
                this.o.removeJavascriptInterface("accessibilityTraversal");
            } catch (Exception e6) {
                com.baidu.ufosdk.f.c.a("webView --> This API level do not support `removeJavascriptInterface`");
            }
            if (com.baidu.ufosdk.b.d.b(getApplicationContext()).contains(RomUtils.UNKNOWN) || com.baidu.ufosdk.b.d.b(getApplicationContext()).contains("NONE")) {
                this.o.getSettings().setCacheMode(1);
                if (this.b.getBoolean("CHECK_WEBVIEW", true)) {
                    com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
                    this.g.setVisibility(0);
                    this.o.setVisibility(8);
                }
                this.n.setVisibility(8);
            } else {
                this.f3734a.putBoolean("CHECK_WEBVIEW", false);
                this.f3734a.commit();
                this.g.setVisibility(8);
                this.o.setVisibility(0);
                this.o.getSettings().setCacheMode(-1);
            }
            this.o.getSettings().setAppCacheMaxSize(8388608L);
            String str = getFilesDir().getAbsolutePath() + "/UfoCacheFile";
            File file = new File(str);
            com.baidu.ufosdk.f.c.c("appCacheDir --> cacheDirPath=" + str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.o.getSettings().setBlockNetworkImage(false);
            this.o.getSettings().setDatabaseEnabled(true);
            this.o.getSettings().setDomStorageEnabled(true);
            this.o.getSettings().setDatabasePath(str);
            this.o.getSettings().setAppCachePath(str);
            this.o.getSettings().setAppCacheEnabled(true);
            this.o.getSettings().setAllowFileAccess(false);
            this.o.setWebViewClient(new av(this, (byte) 0));
            this.o.setWebChromeClient(new com.baidu.ufosdk.d.a("ufo", UfoJavaScriptInterface.class));
            com.baidu.ufosdk.f.c.c("webview init finished!!--webview 初始化完成！");
            if (UfoSDK.clientid != null && UfoSDK.clientid.length() != 0) {
                b();
            }
        } catch (Exception e7) {
            Toast.makeText(this, "组件创建失败，请稍候重试!", 0).show();
            com.baidu.ufosdk.f.c.d("initRootView error !!");
            finish();
        }
        try {
            com.baidu.ufosdk.f.c.a("执行动画...");
            overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_out_to_left"));
        } catch (Exception e8) {
            com.baidu.ufosdk.f.c.d("执行动画错误！exit!");
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.baidu.ufosdk.f.a.f3711a = null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.u = true;
            c();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        try {
            this.o.setVisibility(0);
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("onRestart--webView setVisibility error !!");
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            if (TextUtils.isEmpty(UfoSDK.clientid)) {
                SharedPreferences sharedPreferences = getSharedPreferences("UfoSharePreference", 0);
                UfoSDK.clientid = sharedPreferences.getString("UfoClientId", "");
                UfoSDK.appid = sharedPreferences.getString("UfoAppId", "");
                UfoSDK.devid = sharedPreferences.getString("UfoDevId", "");
                UfoSDK.productid = sharedPreferences.getString("UfoProductId", "");
            }
            this.o.setVisibility(0);
            this.o.resumeTimers();
            if (com.baidu.ufosdk.b.ac != null) {
                com.baidu.ufosdk.b.ac.onResumeCallback();
            }
            this.k.setText(com.baidu.ufosdk.f.s.a("7"));
            this.i.setText(com.baidu.ufosdk.f.s.a("17"));
            this.r.setText(com.baidu.ufosdk.f.s.a("42"));
            this.s.setText(com.baidu.ufosdk.f.s.a("43"));
            com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
            this.j.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
            com.baidu.ufosdk.f.i.a((RelativeLayout) this.n, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
            this.i.setTextSize(com.baidu.ufosdk.b.U);
            if (this.t == null) {
                this.t = "newMessage";
            } else if (this.t.length() == 0) {
                this.t = "newMessage";
            }
            if (UfoSDK.clientid.length() == 0) {
                new Thread(new ar(this)).start();
            } else {
                new Thread(new as(this)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.ufosdk.f.c.d("onResume--webView setVisibility error !!");
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            this.o.setVisibility(0);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.ufosdk.f.c.d("onStart--webView setVisibility error !!");
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }
}
