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
import com.baidu.android.util.devices.RomUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.R;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.webkit.internal.ETAG;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Timer;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"InlinedApi", "SetJavaScriptEnabled", "JavascriptInterface", "NewApi"})
/* loaded from: classes8.dex */
public class FeedbackHotActivity extends Activity {
    private RelativeLayout g;
    private LinearLayout h;
    private ImageView i;
    private WebView j;
    private Button k;
    private View l;
    private TextView m;
    private TextView n;
    private Timer q;

    /* renamed from: a  reason: collision with root package name */
    private final int f5692a = R.id.BLOCK;

    /* renamed from: b  reason: collision with root package name */
    private final int f5693b = R.id.BOTH;
    private final int c = R.id.BOTTOM;
    private final int d = R.id.Backward;
    private final int e = R.id.CTRL;
    private final String f = "UfoCacheFile";
    private String o = "";
    private String p = "";
    @SuppressLint({"NewApi", "HandlerLeak"})
    private Handler r = new ax(this);
    private boolean s = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (UfoSDK.clientid.length() == 0) {
            return;
        }
        this.o = getIntent().getStringExtra("hoturl");
        if (TextUtils.isEmpty(this.o)) {
            return;
        }
        com.baidu.ufosdk.f.c.c("hoturl is " + this.o);
        this.o = this.o.replace("http://ufosdk.baidu.com/", "https://ufosdk.baidu.com/");
        com.baidu.ufosdk.f.c.c("replaced hoturl is " + this.o);
        String[] split = this.o.split(ETAG.ITEM_SEPARATOR);
        if (split.length > 0) {
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str = split[i];
                if (str.startsWith("faq_id=")) {
                    String replace = str.replace("faq_id=", "");
                    try {
                        Integer.parseInt(replace);
                        this.p = replace;
                        break;
                    } catch (NumberFormatException e) {
                        this.p = "";
                    }
                } else {
                    i++;
                }
            }
        }
        if (this.o.contains("ufosdk.baidu.com")) {
            if (this.o.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.j.loadUrl(this.o);
                return;
            } else {
                this.j.loadUrl(SapiUtils.COOKIE_HTTPS_URL_PREFIX + this.o);
                return;
            }
        }
        this.r.obtainMessage(0).sendToTarget();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", HttpConstants.OS_TYPE_VALUE);
            jSONObject.put("appvn", com.baidu.ufosdk.b.e.b());
            jSONObject.put("devid", UfoSDK.devid);
            jSONObject.put("osvn", Build.VERSION.RELEASE);
            jSONObject.put("appname", com.baidu.ufosdk.b.e.a());
            jSONObject.put(SharedPrefConfig.CHANNEL_ID, com.baidu.ufosdk.b.j);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FeedbackHotActivity feedbackHotActivity, String str) {
        if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(feedbackHotActivity.getApplicationContext(), com.baidu.ufosdk.f.s.a("62"), 1).show();
            if (com.baidu.ufosdk.b.d.c(feedbackHotActivity.getApplicationContext())) {
                new Thread(new bb(feedbackHotActivity)).start();
                return;
            }
            return;
        }
        int i = 0;
        try {
            i = Integer.parseInt(str.split("=")[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setClass(feedbackHotActivity, FeedbackEditActivity.class);
        intent.putExtra("msgid", "newMessage");
        intent.putExtra("faq_id", feedbackHotActivity.p);
        intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        intent.putExtra("product_type", i);
        intent.putExtra("come_from", 1);
        feedbackHotActivity.startActivity(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            finish();
            try {
                com.baidu.ufosdk.f.c.d("执行动画...");
                overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_out_to_right"));
            } catch (Exception e) {
                com.baidu.ufosdk.f.c.d("执行动画失败！！");
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_out_to_left"));
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("执行动画错误！");
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        com.baidu.ufosdk.f.r.a(this, getWindow());
        com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
        this.g = new RelativeLayout(this);
        this.g.setFitsSystemWindows(true);
        this.g.setId(R.id.Backward);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(R.id.BOTTOM);
        this.g.setBackgroundColor(com.baidu.ufosdk.b.z);
        this.h = new LinearLayout(this);
        this.h.setOrientation(1);
        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 115.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 85.0f));
        try {
            imageView.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_no_netwrok.png")));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.h.addView(imageView, layoutParams);
        this.m = new TextView(this);
        this.m.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f));
        this.m.setTextSize(com.baidu.ufosdk.b.O);
        this.m.setTextColor(com.baidu.ufosdk.b.x);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        com.baidu.ufosdk.f.i.a(getApplicationContext(), this.m);
        this.h.addView(this.m, layoutParams2);
        this.k = new Button(this);
        this.k.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
        this.k.setTextSize(com.baidu.ufosdk.b.P);
        this.k.setTextColor(com.baidu.ufosdk.b.w);
        try {
            this.k.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 122.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
        layoutParams3.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0);
        this.h.addView(this.k, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        this.g.addView(this.h, layoutParams4);
        this.h.setGravity(17);
        this.h.setVisibility(8);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
        layoutParams5.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0, 0, 0);
        this.i = new ImageView(this);
        this.i.setId(R.id.BLOCK);
        this.i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.i.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_back_icon_browser.png")));
        linearLayout.addView(this.i, layoutParams5);
        TextView textView = new TextView(this);
        textView.setText(com.baidu.ufosdk.b.i);
        textView.setTextSize(com.baidu.ufosdk.b.M);
        textView.setTextColor(com.baidu.ufosdk.b.H);
        textView.setGravity(16);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
        linearLayout.addView(textView, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(9);
        layoutParams7.addRule(15);
        relativeLayout.addView(linearLayout, layoutParams7);
        relativeLayout.setBackgroundColor(com.baidu.ufosdk.b.A);
        this.n = new TextView(this);
        this.n.setId(R.id.BOTH);
        this.n.setText(com.baidu.ufosdk.f.s.a("8"));
        this.n.setTextColor(com.baidu.ufosdk.b.r);
        this.n.setTextSize(com.baidu.ufosdk.b.S);
        this.n.setGravity(17);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams8.addRule(13);
        relativeLayout.addView(this.n, layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
        layoutParams9.addRule(10);
        this.g.addView(relativeLayout, layoutParams9);
        View view = new View(this);
        view.setId(R.id.CTRL);
        view.setBackgroundColor(-2894893);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        layoutParams10.addRule(3, relativeLayout.getId());
        this.g.addView(view, layoutParams10);
        this.j = new WebView(this);
        this.j.setBackgroundColor(com.baidu.ufosdk.b.z);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams11.addRule(12);
        layoutParams11.addRule(3, view.getId());
        this.g.addView(this.j, layoutParams11);
        new RelativeLayout.LayoutParams(-1, -1);
        this.g.setLayoutParams(layoutParams6);
        setContentView(this.g);
        this.l = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams12.addRule(13);
        this.g.addView(this.l, layoutParams12);
        WebSettings settings = this.j.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        if (com.baidu.ufosdk.b.d.b(getApplicationContext()).contains(RomUtils.UNKNOWN) || com.baidu.ufosdk.b.d.b(getApplicationContext()).contains("NONE")) {
            this.l.setVisibility(8);
        } else {
            this.h.setVisibility(8);
            this.j.setVisibility(0);
        }
        this.j.setWebViewClient(new bc(this, (byte) 0));
        linearLayout.setOnClickListener(new ay(this));
        this.k.setOnClickListener(new az(this));
        a();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (com.baidu.ufosdk.b.ac != null) {
            com.baidu.ufosdk.b.ac.onResumeCallback();
        }
        this.k.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
        this.n.setText(com.baidu.ufosdk.f.s.a("8"));
        com.baidu.ufosdk.f.i.a((RelativeLayout) this.l, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
        this.j.resumeTimers();
        if (UfoSDK.clientid.length() == 0) {
            new Thread(new ba(this)).start();
        }
    }
}
