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
import androidx.core.view.ViewCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tieba.R;
import com.baidu.ufosdk.UfoSDK;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.Timer;
/* loaded from: classes5.dex */
public class FeedbackFacePageActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences.Editor f22690a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f22691b;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f22695f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f22696g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f22697h;
    public Button i;
    public Button j;
    public TextView k;
    public TextView l;
    public RelativeLayout m;
    public View n;
    public WebView o;
    public Timer p;
    public TextView q;
    public TextView r;
    public TextView s;
    public String t;
    public LinearLayout w;

    /* renamed from: c  reason: collision with root package name */
    public String f22692c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f22693d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f22694e = "";
    public boolean u = false;
    @SuppressLint({"HandlerLeak"})
    public Handler v = new ah(this);

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
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra("url", this.f22692c);
        intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        intent.putExtra("extra", this.f22693d);
        intent.setClass(this, FeedbackListActivity.class);
        startActivity(intent);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:103:0x085f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:104:0x0741 */
    /* JADX WARN: Can't wrap try/catch for region: R(34:1|(11:2|3|(1:5)|6|(1:8)|9|(7:100|101|(1:103)|104|(1:106)|107|(1:109))|11|(1:13)|14|(1:16))|(2:18|19)|(4:20|21|(1:23)|24)|(4:(2:26|(1:(1:29)(30:94|32|(1:34)|35|36|37|38|39|40|41|(1:43)|44|45|46|47|48|(14:53|54|55|56|57|(1:59)|60|61|62|63|(1:67)|69|70|71)|77|(4:79|80|81|82)|83|57|(0)|60|61|62|63|(2:65|67)|69|70|71))(31:95|31|32|(0)|35|36|37|38|39|40|41|(0)|44|45|46|47|48|(15:50|53|54|55|56|57|(0)|60|61|62|63|(0)|69|70|71)|77|(0)|83|57|(0)|60|61|62|63|(0)|69|70|71))(1:96)|69|70|71)|30|31|32|(0)|35|36|37|38|39|40|41|(0)|44|45|46|47|48|(0)|77|(0)|83|57|(0)|60|61|62|63|(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x05b2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x05b3, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x063e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x063f, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x072d, code lost:
        com.baidu.ufosdk.f.c.a("webView --> This API level do not support `removeJavascriptInterface`");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0552 A[Catch: Exception -> 0x085e, TryCatch #2 {Exception -> 0x085e, blocks: (B:35:0x0128, B:37:0x012c, B:38:0x0133, B:43:0x03d6, B:47:0x03f0, B:49:0x03f5, B:51:0x0552, B:52:0x0559, B:57:0x05b6, B:62:0x0642, B:64:0x06a8, B:65:0x06af, B:69:0x0733, B:71:0x0743, B:74:0x0754, B:77:0x076e, B:85:0x07a9, B:87:0x07ea, B:88:0x07ed, B:91:0x0837, B:93:0x0852, B:95:0x085a, B:78:0x0778, B:80:0x078c, B:83:0x079b, B:84:0x07a2, B:68:0x072d, B:61:0x063f, B:56:0x05b3, B:44:0x03da, B:45:0x03e4, B:46:0x03ed, B:58:0x062c, B:66:0x0704, B:53:0x059f), top: B:108:0x0128, inners: #1, #3, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x06a8 A[Catch: Exception -> 0x085e, TryCatch #2 {Exception -> 0x085e, blocks: (B:35:0x0128, B:37:0x012c, B:38:0x0133, B:43:0x03d6, B:47:0x03f0, B:49:0x03f5, B:51:0x0552, B:52:0x0559, B:57:0x05b6, B:62:0x0642, B:64:0x06a8, B:65:0x06af, B:69:0x0733, B:71:0x0743, B:74:0x0754, B:77:0x076e, B:85:0x07a9, B:87:0x07ea, B:88:0x07ed, B:91:0x0837, B:93:0x0852, B:95:0x085a, B:78:0x0778, B:80:0x078c, B:83:0x079b, B:84:0x07a2, B:68:0x072d, B:61:0x063f, B:56:0x05b3, B:44:0x03da, B:45:0x03e4, B:46:0x03ed, B:58:0x062c, B:66:0x0704, B:53:0x059f), top: B:108:0x0128, inners: #1, #3, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0743 A[Catch: Exception -> 0x085e, TryCatch #2 {Exception -> 0x085e, blocks: (B:35:0x0128, B:37:0x012c, B:38:0x0133, B:43:0x03d6, B:47:0x03f0, B:49:0x03f5, B:51:0x0552, B:52:0x0559, B:57:0x05b6, B:62:0x0642, B:64:0x06a8, B:65:0x06af, B:69:0x0733, B:71:0x0743, B:74:0x0754, B:77:0x076e, B:85:0x07a9, B:87:0x07ea, B:88:0x07ed, B:91:0x0837, B:93:0x0852, B:95:0x085a, B:78:0x0778, B:80:0x078c, B:83:0x079b, B:84:0x07a2, B:68:0x072d, B:61:0x063f, B:56:0x05b3, B:44:0x03da, B:45:0x03e4, B:46:0x03ed, B:58:0x062c, B:66:0x0704, B:53:0x059f), top: B:108:0x0128, inners: #1, #3, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x078c A[Catch: Exception -> 0x085e, TRY_LEAVE, TryCatch #2 {Exception -> 0x085e, blocks: (B:35:0x0128, B:37:0x012c, B:38:0x0133, B:43:0x03d6, B:47:0x03f0, B:49:0x03f5, B:51:0x0552, B:52:0x0559, B:57:0x05b6, B:62:0x0642, B:64:0x06a8, B:65:0x06af, B:69:0x0733, B:71:0x0743, B:74:0x0754, B:77:0x076e, B:85:0x07a9, B:87:0x07ea, B:88:0x07ed, B:91:0x0837, B:93:0x0852, B:95:0x085a, B:78:0x0778, B:80:0x078c, B:83:0x079b, B:84:0x07a2, B:68:0x072d, B:61:0x063f, B:56:0x05b3, B:44:0x03da, B:45:0x03e4, B:46:0x03ed, B:58:0x062c, B:66:0x0704, B:53:0x059f), top: B:108:0x0128, inners: #1, #3, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x07ea A[Catch: Exception -> 0x085e, TryCatch #2 {Exception -> 0x085e, blocks: (B:35:0x0128, B:37:0x012c, B:38:0x0133, B:43:0x03d6, B:47:0x03f0, B:49:0x03f5, B:51:0x0552, B:52:0x0559, B:57:0x05b6, B:62:0x0642, B:64:0x06a8, B:65:0x06af, B:69:0x0733, B:71:0x0743, B:74:0x0754, B:77:0x076e, B:85:0x07a9, B:87:0x07ea, B:88:0x07ed, B:91:0x0837, B:93:0x0852, B:95:0x085a, B:78:0x0778, B:80:0x078c, B:83:0x079b, B:84:0x07a2, B:68:0x072d, B:61:0x063f, B:56:0x05b3, B:44:0x03da, B:45:0x03e4, B:46:0x03ed, B:58:0x062c, B:66:0x0704, B:53:0x059f), top: B:108:0x0128, inners: #1, #3, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0852 A[Catch: Exception -> 0x085e, TryCatch #2 {Exception -> 0x085e, blocks: (B:35:0x0128, B:37:0x012c, B:38:0x0133, B:43:0x03d6, B:47:0x03f0, B:49:0x03f5, B:51:0x0552, B:52:0x0559, B:57:0x05b6, B:62:0x0642, B:64:0x06a8, B:65:0x06af, B:69:0x0733, B:71:0x0743, B:74:0x0754, B:77:0x076e, B:85:0x07a9, B:87:0x07ea, B:88:0x07ed, B:91:0x0837, B:93:0x0852, B:95:0x085a, B:78:0x0778, B:80:0x078c, B:83:0x079b, B:84:0x07a2, B:68:0x072d, B:61:0x063f, B:56:0x05b3, B:44:0x03da, B:45:0x03e4, B:46:0x03ed, B:58:0x062c, B:66:0x0704, B:53:0x059f), top: B:108:0x0128, inners: #1, #3, #8 }] */
    /* JADX WARN: Type inference failed for: r0v17, types: [android.widget.RelativeLayout, android.view.View] */
    /* JADX WARN: Type inference failed for: r10v9, types: [android.widget.RelativeLayout] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v50 */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        ?? r3;
        LinearLayout linearLayout;
        View view;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        int i;
        int i2;
        int i3;
        String b2;
        File file;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setSoftInputMode(32);
        com.baidu.ufosdk.f.r.a(this, getWindow());
        com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.f22695f = relativeLayout;
            relativeLayout.setBackgroundColor(com.baidu.ufosdk.b.z);
            this.f22695f.setFitsSystemWindows(true);
            setContentView(this.f22695f);
            SharedPreferences sharedPreferences = getSharedPreferences("UfoSharePreference", 0);
            this.f22691b = sharedPreferences;
            if (sharedPreferences != null) {
                this.f22690a = sharedPreferences.edit();
            }
            if (this.f22690a != null) {
                this.f22690a.putBoolean("ADD_PIC_FLAG", true);
                this.f22690a.commit();
            }
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    String stringExtra = intent.getStringExtra("username");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        com.baidu.ufosdk.b.f22596b = stringExtra;
                    }
                    String stringExtra2 = intent.getStringExtra("baiducuid");
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        com.baidu.ufosdk.b.f22597c = stringExtra2;
                    }
                    String stringExtra3 = intent.getStringExtra("prefix");
                    if (!TextUtils.isEmpty(stringExtra3)) {
                        com.baidu.ufosdk.b.l = stringExtra3;
                    }
                } catch (Exception e2) {
                    com.baidu.ufosdk.f.c.d("fromIntentForAppsearch error! " + e2.getMessage());
                }
            }
            int intExtra = getIntent().getIntExtra("feedback_channel", 0);
            com.baidu.ufosdk.f.c.a("####### channelInt = " + intExtra);
            com.baidu.ufosdk.b.j = intExtra;
            com.baidu.ufosdk.b.k = getIntent().getIntExtra("faq_channel", 0);
            this.f22694e = getIntent().getStringExtra("faq_id");
            String stringExtra4 = getIntent().getStringExtra("msgid");
            this.t = stringExtra4;
            if (TextUtils.isEmpty(stringExtra4)) {
                this.t = "newMessage";
            }
            if (TextUtils.isEmpty(this.f22694e)) {
                this.f22694e = "";
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            Toast.makeText(this, "组件创建失败，请稍候重试!", 0).show();
            com.baidu.ufosdk.f.c.d("onCreate error !!");
            finish();
        }
        try {
            this.o = new WebView(this);
        } catch (Exception unused) {
            Toast.makeText(this, "WebView组件加载失败，请稍候重试!", 0).show();
            com.baidu.ufosdk.f.c.d("webView = new WebView(this) error !!");
            finish();
        }
        try {
            if (this.o == null) {
                this.o = new WebView(this);
            }
            this.f22695f.setId(R.drawable.res_0x7f080004_avd_show_password__1);
            ?? relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setId(R.id.BOTTOM);
            linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0, 0, 0);
            ImageView imageView = new ImageView(this);
            this.f22697h = imageView;
            imageView.setId(R.drawable.res_0x7f080001_avd_hide_password__1);
            this.f22697h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f22697h.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_back_icon_browser.png")));
            linearLayout.addView(this.f22697h, layoutParams);
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
            relativeLayout2.addView(linearLayout, layoutParams3);
            TextView textView2 = new TextView(this);
            this.k = textView2;
            textView2.setId(R.drawable.res_0x7f080002_avd_hide_password__2);
            this.k.setText(com.baidu.ufosdk.f.s.a("7"));
            this.k.setTextColor(com.baidu.ufosdk.b.r);
            this.k.setTextSize(com.baidu.ufosdk.b.T);
            this.k.setGravity(17);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams4.addRule(13);
            relativeLayout2.addView(this.k, layoutParams4);
            Button button = new Button(this);
            this.i = button;
            button.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_GROUP));
            this.i.setId(R.id.DOWN);
            this.i.setTextColor(com.baidu.ufosdk.b.s);
            this.i.setTextSize(com.baidu.ufosdk.b.U);
            this.i.setGravity(17);
            this.i.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.s, com.baidu.ufosdk.b.t, com.baidu.ufosdk.b.s, com.baidu.ufosdk.b.s));
            this.i.setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
            this.i.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(11);
            layoutParams5.addRule(15);
            layoutParams5.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 6.0f), 0);
            relativeLayout2.addView(this.i, layoutParams5);
            this.l = new TextView(this);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 9.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 9.0f));
            this.l.setTextColor(-1);
            this.l.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_newmsg_flag.png")));
            this.l.setGravity(17);
            this.l.setVisibility(8);
            layoutParams6.addRule(11);
            layoutParams6.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 13.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), 0);
            relativeLayout2.addView(this.l, layoutParams6);
            relativeLayout2.setBackgroundColor(com.baidu.ufosdk.b.A);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
            layoutParams7.addRule(10);
            this.f22695f.addView(relativeLayout2, layoutParams7);
            view = new View(this);
            view.setId(R.id.SYM);
            view.setBackgroundColor(-2894893);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            layoutParams8.addRule(3, relativeLayout2.getId());
            this.f22695f.addView(view, layoutParams8);
            LinearLayout linearLayout4 = new LinearLayout(this);
            this.w = linearLayout4;
            linearLayout4.setId(R.id.TOP);
            this.w.setOrientation(0);
            this.w.setBackgroundColor(com.baidu.ufosdk.b.B);
            linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            linearLayout2.setBackgroundColor(com.baidu.ufosdk.b.B);
            linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(0);
            linearLayout3.setGravity(17);
            linearLayout3.setBackgroundColor(com.baidu.ufosdk.b.B);
            TextView textView3 = new TextView(this);
            this.r = textView3;
            textView3.setText(com.baidu.ufosdk.f.s.a("42"));
            this.r.setTextColor(-13421773);
            this.r.setTextSize(com.baidu.ufosdk.b.Z);
            TextView textView4 = new TextView(this);
            this.s = textView4;
            textView4.setText(com.baidu.ufosdk.f.s.a("43"));
            this.s.setTextColor(-13421773);
            this.s.setTextSize(com.baidu.ufosdk.b.Z);
            i = com.baidu.ufosdk.b.q;
        } catch (Exception unused2) {
            r3 = 0;
            Toast.makeText(this, "组件创建失败，请稍候重试!", (int) r3).show();
            com.baidu.ufosdk.f.c.d("initRootView error !!");
            finish();
            com.baidu.ufosdk.f.c.a("执行动画...");
            overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_out_to_left"));
            return;
        }
        try {
            if (i == 0) {
                linearLayout2.setVisibility(0);
            } else if (i == 1) {
                linearLayout2.setVisibility(0);
                linearLayout3.setVisibility(8);
                i3 = 10;
                i2 = 7;
                linearLayout2.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
                ImageView imageView2 = new ImageView(this);
                imageView2.setImageBitmap(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_face_customer.png"));
                imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                linearLayout2.addView(imageView2, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f)));
                linearLayout2.addView(this.r, new LinearLayout.LayoutParams(-2, -2));
                linearLayout3.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
                ImageView imageView3 = new ImageView(this);
                imageView3.setImageBitmap(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_face_advise.png"));
                imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
                linearLayout3.addView(imageView3, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f)));
                linearLayout3.addView(this.s, new LinearLayout.LayoutParams(-2, -2));
                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams9.setMargins(com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a(this, i3), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
                layoutParams9.weight = 1.0f;
                this.w.addView(linearLayout2, layoutParams9);
                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams10.setMargins(com.baidu.ufosdk.f.i.a(this, i2), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
                layoutParams10.weight = 1.0f;
                this.w.addView(linearLayout3, layoutParams10);
                RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
                layoutParams11.addRule(12);
                this.f22695f.addView(this.w, layoutParams11);
                View view2 = new View(this);
                view2.setId(R.id.TRIANGLE);
                view2.setBackgroundColor(-2894893);
                RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
                layoutParams12.addRule(2, this.w.getId());
                this.f22695f.addView(view2, layoutParams12);
                linearLayout3.setOnClickListener(new ai(this));
                linearLayout2.setOnClickListener(new ak(this));
                linearLayout.setOnClickListener(new am(this));
                this.i.setOnClickListener(new an(this));
                int id = view.getId();
                int id2 = view2.getId();
                this.m = new RelativeLayout(this);
                if (this.o == null) {
                }
                this.m.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                LinearLayout linearLayout5 = new LinearLayout(this);
                this.f22696g = linearLayout5;
                linearLayout5.setOrientation(1);
                this.f22696g.setGravity(17);
                this.f22696g.setVisibility(8);
                new LinearLayout.LayoutParams(-2, -2);
                ImageView imageView4 = new ImageView(this);
                LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 115.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 85.0f));
                imageView4.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_no_netwrok.png")));
                this.f22696g.addView(imageView4, layoutParams13);
                TextView textView5 = new TextView(this);
                this.q = textView5;
                textView5.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f));
                this.q.setTextSize(com.baidu.ufosdk.b.O);
                this.q.setTextColor(com.baidu.ufosdk.b.x);
                LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, -2);
                com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
                this.f22696g.addView(this.q, layoutParams14);
                Button button2 = new Button(this);
                this.j = button2;
                button2.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
                this.j.setTextSize(com.baidu.ufosdk.b.P);
                this.j.setTextColor(com.baidu.ufosdk.b.w);
                this.j.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
                LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 122.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
                layoutParams15.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0);
                this.f22696g.addView(this.j, layoutParams15);
                RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams16.addRule(13);
                this.m.addView(this.f22696g, layoutParams16);
                this.j.setOnClickListener(new ao(this));
                LinearLayout linearLayout6 = new LinearLayout(this);
                linearLayout6.setOrientation(0);
                linearLayout6.setGravity(16);
                LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-1, -1);
                if (Integer.parseInt(Build.VERSION.SDK) >= 11) {
                }
                linearLayout6.addView(this.o, layoutParams17);
                this.m.addView(linearLayout6, new RelativeLayout.LayoutParams(-1, -1));
                this.n = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams18.addRule(13);
                this.m.addView(this.n, layoutParams18);
                RelativeLayout.LayoutParams layoutParams19 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams19.addRule(3, id);
                layoutParams19.addRule(2, id2);
                this.f22695f.addView(this.m, layoutParams19);
                this.o.getSettings().setJavaScriptEnabled(true);
                this.o.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
                this.o.getClass().getMethod("removeJavascriptInterface", String.class);
                this.o.removeJavascriptInterface("searchBoxJavaBridge_");
                this.o.removeJavascriptInterface("accessibility");
                this.o.removeJavascriptInterface("accessibilityTraversal");
                b2 = com.baidu.ufosdk.b.d.b(getApplicationContext());
                r3 = RomUtils.UNKNOWN;
                if (!b2.contains(RomUtils.UNKNOWN)) {
                    this.f22690a.putBoolean("CHECK_WEBVIEW", false);
                    this.f22690a.commit();
                    this.f22696g.setVisibility(8);
                    this.o.setVisibility(0);
                    this.o.getSettings().setCacheMode(-1);
                    this.o.getSettings().setAppCacheMaxSize(8388608L);
                    String str = getFilesDir().getAbsolutePath() + "/UfoCacheFile";
                    file = new File(str);
                    com.baidu.ufosdk.f.c.c("appCacheDir --> cacheDirPath=" + str);
                    if (!file.exists()) {
                    }
                    this.o.getSettings().setBlockNetworkImage(false);
                    this.o.getSettings().setDatabaseEnabled(true);
                    this.o.getSettings().setDomStorageEnabled(true);
                    this.o.getSettings().setDatabasePath(str);
                    this.o.getSettings().setAppCachePath(str);
                    this.o.getSettings().setAppCacheEnabled(true);
                    r3 = 0;
                    this.o.getSettings().setAllowFileAccess(false);
                    this.o.setWebViewClient(new av(this, (byte) 0));
                    this.o.setWebChromeClient(new com.baidu.ufosdk.d.a("ufo", UfoJavaScriptInterface.class));
                    com.baidu.ufosdk.f.c.c("webview init finished!!--webview 初始化完成！");
                    if (UfoSDK.clientid != null) {
                    }
                    com.baidu.ufosdk.f.c.a("执行动画...");
                    overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_out_to_left"));
                    return;
                }
                this.o.getSettings().setCacheMode(1);
                if (this.f22691b.getBoolean("CHECK_WEBVIEW", true)) {
                }
                this.n.setVisibility(8);
                this.o.getSettings().setAppCacheMaxSize(8388608L);
                String str2 = getFilesDir().getAbsolutePath() + "/UfoCacheFile";
                file = new File(str2);
                com.baidu.ufosdk.f.c.c("appCacheDir --> cacheDirPath=" + str2);
                if (!file.exists()) {
                }
                this.o.getSettings().setBlockNetworkImage(false);
                this.o.getSettings().setDatabaseEnabled(true);
                this.o.getSettings().setDomStorageEnabled(true);
                this.o.getSettings().setDatabasePath(str2);
                this.o.getSettings().setAppCachePath(str2);
                this.o.getSettings().setAppCacheEnabled(true);
                r3 = 0;
                this.o.getSettings().setAllowFileAccess(false);
                this.o.setWebViewClient(new av(this, (byte) 0));
                this.o.setWebChromeClient(new com.baidu.ufosdk.d.a("ufo", UfoJavaScriptInterface.class));
                com.baidu.ufosdk.f.c.c("webview init finished!!--webview 初始化完成！");
                if (UfoSDK.clientid != null) {
                }
                com.baidu.ufosdk.f.c.a("执行动画...");
                overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_out_to_left"));
                return;
            } else if (i == 2) {
                linearLayout2.setVisibility(8);
                linearLayout3.setVisibility(0);
                i3 = 7;
                i2 = 10;
                linearLayout2.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
                ImageView imageView22 = new ImageView(this);
                imageView22.setImageBitmap(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_face_customer.png"));
                imageView22.setScaleType(ImageView.ScaleType.FIT_XY);
                linearLayout2.addView(imageView22, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f)));
                linearLayout2.addView(this.r, new LinearLayout.LayoutParams(-2, -2));
                linearLayout3.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
                ImageView imageView32 = new ImageView(this);
                imageView32.setImageBitmap(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_face_advise.png"));
                imageView32.setScaleType(ImageView.ScaleType.FIT_XY);
                linearLayout3.addView(imageView32, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f)));
                linearLayout3.addView(this.s, new LinearLayout.LayoutParams(-2, -2));
                LinearLayout.LayoutParams layoutParams92 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams92.setMargins(com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a(this, i3), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
                layoutParams92.weight = 1.0f;
                this.w.addView(linearLayout2, layoutParams92);
                LinearLayout.LayoutParams layoutParams102 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams102.setMargins(com.baidu.ufosdk.f.i.a(this, i2), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
                layoutParams102.weight = 1.0f;
                this.w.addView(linearLayout3, layoutParams102);
                RelativeLayout.LayoutParams layoutParams112 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
                layoutParams112.addRule(12);
                this.f22695f.addView(this.w, layoutParams112);
                View view22 = new View(this);
                view22.setId(R.id.TRIANGLE);
                view22.setBackgroundColor(-2894893);
                RelativeLayout.LayoutParams layoutParams122 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
                layoutParams122.addRule(2, this.w.getId());
                this.f22695f.addView(view22, layoutParams122);
                linearLayout3.setOnClickListener(new ai(this));
                linearLayout2.setOnClickListener(new ak(this));
                linearLayout.setOnClickListener(new am(this));
                this.i.setOnClickListener(new an(this));
                int id3 = view.getId();
                int id22 = view22.getId();
                this.m = new RelativeLayout(this);
                if (this.o == null) {
                    this.o = new WebView(this);
                }
                this.m.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                LinearLayout linearLayout52 = new LinearLayout(this);
                this.f22696g = linearLayout52;
                linearLayout52.setOrientation(1);
                this.f22696g.setGravity(17);
                this.f22696g.setVisibility(8);
                new LinearLayout.LayoutParams(-2, -2);
                ImageView imageView42 = new ImageView(this);
                LinearLayout.LayoutParams layoutParams132 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 115.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 85.0f));
                imageView42.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_no_netwrok.png")));
                this.f22696g.addView(imageView42, layoutParams132);
                TextView textView52 = new TextView(this);
                this.q = textView52;
                textView52.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f));
                this.q.setTextSize(com.baidu.ufosdk.b.O);
                this.q.setTextColor(com.baidu.ufosdk.b.x);
                LinearLayout.LayoutParams layoutParams142 = new LinearLayout.LayoutParams(-2, -2);
                com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
                this.f22696g.addView(this.q, layoutParams142);
                Button button22 = new Button(this);
                this.j = button22;
                button22.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
                this.j.setTextSize(com.baidu.ufosdk.b.P);
                this.j.setTextColor(com.baidu.ufosdk.b.w);
                this.j.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
                LinearLayout.LayoutParams layoutParams152 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 122.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
                layoutParams152.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0);
                this.f22696g.addView(this.j, layoutParams152);
                RelativeLayout.LayoutParams layoutParams162 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams162.addRule(13);
                this.m.addView(this.f22696g, layoutParams162);
                this.j.setOnClickListener(new ao(this));
                LinearLayout linearLayout62 = new LinearLayout(this);
                linearLayout62.setOrientation(0);
                linearLayout62.setGravity(16);
                LinearLayout.LayoutParams layoutParams172 = new LinearLayout.LayoutParams(-1, -1);
                if (Integer.parseInt(Build.VERSION.SDK) >= 11) {
                    this.o.setLayerType(1, null);
                }
                linearLayout62.addView(this.o, layoutParams172);
                this.m.addView(linearLayout62, new RelativeLayout.LayoutParams(-1, -1));
                this.n = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                RelativeLayout.LayoutParams layoutParams182 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams182.addRule(13);
                this.m.addView(this.n, layoutParams182);
                RelativeLayout.LayoutParams layoutParams192 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams192.addRule(3, id3);
                layoutParams192.addRule(2, id22);
                this.f22695f.addView(this.m, layoutParams192);
                this.o.getSettings().setJavaScriptEnabled(true);
                this.o.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
                this.o.getClass().getMethod("removeJavascriptInterface", String.class);
                this.o.removeJavascriptInterface("searchBoxJavaBridge_");
                this.o.removeJavascriptInterface("accessibility");
                this.o.removeJavascriptInterface("accessibilityTraversal");
                b2 = com.baidu.ufosdk.b.d.b(getApplicationContext());
                r3 = RomUtils.UNKNOWN;
                if (!b2.contains(RomUtils.UNKNOWN) && !com.baidu.ufosdk.b.d.b(getApplicationContext()).contains("NONE")) {
                    this.f22690a.putBoolean("CHECK_WEBVIEW", false);
                    this.f22690a.commit();
                    this.f22696g.setVisibility(8);
                    this.o.setVisibility(0);
                    this.o.getSettings().setCacheMode(-1);
                    this.o.getSettings().setAppCacheMaxSize(8388608L);
                    String str22 = getFilesDir().getAbsolutePath() + "/UfoCacheFile";
                    file = new File(str22);
                    com.baidu.ufosdk.f.c.c("appCacheDir --> cacheDirPath=" + str22);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.o.getSettings().setBlockNetworkImage(false);
                    this.o.getSettings().setDatabaseEnabled(true);
                    this.o.getSettings().setDomStorageEnabled(true);
                    this.o.getSettings().setDatabasePath(str22);
                    this.o.getSettings().setAppCachePath(str22);
                    this.o.getSettings().setAppCacheEnabled(true);
                    r3 = 0;
                    this.o.getSettings().setAllowFileAccess(false);
                    this.o.setWebViewClient(new av(this, (byte) 0));
                    this.o.setWebChromeClient(new com.baidu.ufosdk.d.a("ufo", UfoJavaScriptInterface.class));
                    com.baidu.ufosdk.f.c.c("webview init finished!!--webview 初始化完成！");
                    if (UfoSDK.clientid != null && UfoSDK.clientid.length() != 0) {
                        b();
                    }
                    com.baidu.ufosdk.f.c.a("执行动画...");
                    overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_out_to_left"));
                    return;
                }
                this.o.getSettings().setCacheMode(1);
                if (this.f22691b.getBoolean("CHECK_WEBVIEW", true)) {
                    com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
                    this.f22696g.setVisibility(0);
                    this.o.setVisibility(8);
                }
                this.n.setVisibility(8);
                this.o.getSettings().setAppCacheMaxSize(8388608L);
                String str222 = getFilesDir().getAbsolutePath() + "/UfoCacheFile";
                file = new File(str222);
                com.baidu.ufosdk.f.c.c("appCacheDir --> cacheDirPath=" + str222);
                if (!file.exists()) {
                }
                this.o.getSettings().setBlockNetworkImage(false);
                this.o.getSettings().setDatabaseEnabled(true);
                this.o.getSettings().setDomStorageEnabled(true);
                this.o.getSettings().setDatabasePath(str222);
                this.o.getSettings().setAppCachePath(str222);
                this.o.getSettings().setAppCacheEnabled(true);
                r3 = 0;
                this.o.getSettings().setAllowFileAccess(false);
                this.o.setWebViewClient(new av(this, (byte) 0));
                this.o.setWebChromeClient(new com.baidu.ufosdk.d.a("ufo", UfoJavaScriptInterface.class));
                com.baidu.ufosdk.f.c.c("webview init finished!!--webview 初始化完成！");
                if (UfoSDK.clientid != null) {
                    b();
                }
                com.baidu.ufosdk.f.c.a("执行动画...");
                overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_out_to_left"));
                return;
            } else {
                linearLayout2.setVisibility(0);
            }
            com.baidu.ufosdk.f.c.a("执行动画...");
            overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "slide_out_to_left"));
            return;
        } catch (Exception unused3) {
            com.baidu.ufosdk.f.c.d("执行动画错误！exit!");
            return;
        }
        linearLayout3.setVisibility(0);
        i3 = 7;
        i2 = 7;
        linearLayout2.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
        ImageView imageView222 = new ImageView(this);
        imageView222.setImageBitmap(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_face_customer.png"));
        imageView222.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout2.addView(imageView222, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f)));
        linearLayout2.addView(this.r, new LinearLayout.LayoutParams(-2, -2));
        linearLayout3.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
        ImageView imageView322 = new ImageView(this);
        imageView322.setImageBitmap(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_face_advise.png"));
        imageView322.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout3.addView(imageView322, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f)));
        linearLayout3.addView(this.s, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams922 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams922.setMargins(com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a(this, i3), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
        layoutParams922.weight = 1.0f;
        this.w.addView(linearLayout2, layoutParams922);
        LinearLayout.LayoutParams layoutParams1022 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams1022.setMargins(com.baidu.ufosdk.f.i.a(this, i2), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
        layoutParams1022.weight = 1.0f;
        this.w.addView(linearLayout3, layoutParams1022);
        RelativeLayout.LayoutParams layoutParams1122 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
        layoutParams1122.addRule(12);
        this.f22695f.addView(this.w, layoutParams1122);
        View view222 = new View(this);
        view222.setId(R.id.TRIANGLE);
        view222.setBackgroundColor(-2894893);
        RelativeLayout.LayoutParams layoutParams1222 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        layoutParams1222.addRule(2, this.w.getId());
        this.f22695f.addView(view222, layoutParams1222);
        linearLayout3.setOnClickListener(new ai(this));
        linearLayout2.setOnClickListener(new ak(this));
        linearLayout.setOnClickListener(new am(this));
        this.i.setOnClickListener(new an(this));
        int id32 = view.getId();
        int id222 = view222.getId();
        this.m = new RelativeLayout(this);
        if (this.o == null) {
        }
        this.m.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout522 = new LinearLayout(this);
        this.f22696g = linearLayout522;
        linearLayout522.setOrientation(1);
        this.f22696g.setGravity(17);
        this.f22696g.setVisibility(8);
        new LinearLayout.LayoutParams(-2, -2);
        ImageView imageView422 = new ImageView(this);
        LinearLayout.LayoutParams layoutParams1322 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 115.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 85.0f));
        imageView422.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_no_netwrok.png")));
        this.f22696g.addView(imageView422, layoutParams1322);
        TextView textView522 = new TextView(this);
        this.q = textView522;
        textView522.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f));
        this.q.setTextSize(com.baidu.ufosdk.b.O);
        this.q.setTextColor(com.baidu.ufosdk.b.x);
        LinearLayout.LayoutParams layoutParams1422 = new LinearLayout.LayoutParams(-2, -2);
        com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
        this.f22696g.addView(this.q, layoutParams1422);
        Button button222 = new Button(this);
        this.j = button222;
        button222.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
        this.j.setTextSize(com.baidu.ufosdk.b.P);
        this.j.setTextColor(com.baidu.ufosdk.b.w);
        this.j.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
        LinearLayout.LayoutParams layoutParams1522 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 122.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
        layoutParams1522.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0);
        this.f22696g.addView(this.j, layoutParams1522);
        RelativeLayout.LayoutParams layoutParams1622 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams1622.addRule(13);
        this.m.addView(this.f22696g, layoutParams1622);
        this.j.setOnClickListener(new ao(this));
        LinearLayout linearLayout622 = new LinearLayout(this);
        linearLayout622.setOrientation(0);
        linearLayout622.setGravity(16);
        LinearLayout.LayoutParams layoutParams1722 = new LinearLayout.LayoutParams(-1, -1);
        if (Integer.parseInt(Build.VERSION.SDK) >= 11) {
        }
        linearLayout622.addView(this.o, layoutParams1722);
        this.m.addView(linearLayout622, new RelativeLayout.LayoutParams(-1, -1));
        this.n = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
        RelativeLayout.LayoutParams layoutParams1822 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams1822.addRule(13);
        this.m.addView(this.n, layoutParams1822);
        RelativeLayout.LayoutParams layoutParams1922 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams1922.addRule(3, id32);
        layoutParams1922.addRule(2, id222);
        this.f22695f.addView(this.m, layoutParams1922);
        this.o.getSettings().setJavaScriptEnabled(true);
        this.o.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.o.getClass().getMethod("removeJavascriptInterface", String.class);
        this.o.removeJavascriptInterface("searchBoxJavaBridge_");
        this.o.removeJavascriptInterface("accessibility");
        this.o.removeJavascriptInterface("accessibilityTraversal");
        b2 = com.baidu.ufosdk.b.d.b(getApplicationContext());
        r3 = RomUtils.UNKNOWN;
        if (!b2.contains(RomUtils.UNKNOWN)) {
        }
        this.o.getSettings().setCacheMode(1);
        if (this.f22691b.getBoolean("CHECK_WEBVIEW", true)) {
        }
        this.n.setVisibility(8);
        this.o.getSettings().setAppCacheMaxSize(8388608L);
        String str2222 = getFilesDir().getAbsolutePath() + "/UfoCacheFile";
        file = new File(str2222);
        com.baidu.ufosdk.f.c.c("appCacheDir --> cacheDirPath=" + str2222);
        if (!file.exists()) {
        }
        this.o.getSettings().setBlockNetworkImage(false);
        this.o.getSettings().setDatabaseEnabled(true);
        this.o.getSettings().setDomStorageEnabled(true);
        this.o.getSettings().setDatabasePath(str2222);
        this.o.getSettings().setAppCachePath(str2222);
        this.o.getSettings().setAppCacheEnabled(true);
        r3 = 0;
        this.o.getSettings().setAllowFileAccess(false);
        this.o.setWebViewClient(new av(this, (byte) 0));
        this.o.setWebChromeClient(new com.baidu.ufosdk.d.a("ufo", UfoJavaScriptInterface.class));
        com.baidu.ufosdk.f.c.c("webview init finished!!--webview 初始化完成！");
        if (UfoSDK.clientid != null) {
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.ufosdk.f.a.f22631a = null;
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
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        try {
            this.o.setVisibility(0);
        } catch (Exception unused) {
            com.baidu.ufosdk.f.c.d("onRestart--webView setVisibility error !!");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b5 A[Catch: Exception -> 0x00d1, TryCatch #0 {Exception -> 0x00d1, blocks: (B:3:0x0005, B:5:0x000e, B:6:0x0034, B:8:0x0042, B:9:0x0047, B:12:0x00a1, B:16:0x00ad, B:18:0x00b5, B:20:0x00c3, B:13:0x00a4), top: B:25:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c3 A[Catch: Exception -> 0x00d1, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d1, blocks: (B:3:0x0005, B:5:0x000e, B:6:0x0034, B:8:0x0042, B:9:0x0047, B:12:0x00a1, B:16:0x00ad, B:18:0x00b5, B:20:0x00c3, B:13:0x00a4), top: B:25:0x0005 }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResume() {
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
            this.i.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_GROUP));
            this.r.setText(com.baidu.ufosdk.f.s.a("42"));
            this.s.setText(com.baidu.ufosdk.f.s.a("43"));
            com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
            this.j.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
            com.baidu.ufosdk.f.i.a((RelativeLayout) this.n, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
            this.i.setTextSize(com.baidu.ufosdk.b.U);
            if (this.t != null) {
                if (this.t.length() == 0) {
                }
                if (UfoSDK.clientid.length() != 0) {
                    new Thread(new ar(this)).start();
                    return;
                } else {
                    new Thread(new as(this)).start();
                    return;
                }
            }
            this.t = "newMessage";
            if (UfoSDK.clientid.length() != 0) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.ufosdk.f.c.d("onResume--webView setVisibility error !!");
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            this.o.setVisibility(0);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.ufosdk.f.c.d("onStart--webView setVisibility error !!");
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
