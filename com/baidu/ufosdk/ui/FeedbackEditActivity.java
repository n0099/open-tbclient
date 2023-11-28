package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.FeedbackManager;
import com.baidu.ufosdk.IFeedbackMethodCallback;
import com.baidu.ufosdk.d0;
import com.baidu.ufosdk.d1;
import com.baidu.ufosdk.e0;
import com.baidu.ufosdk.e1;
import com.baidu.ufosdk.i1;
import com.baidu.ufosdk.l0;
import com.baidu.ufosdk.m0;
import com.baidu.ufosdk.n0;
import com.baidu.ufosdk.o0;
import com.baidu.ufosdk.p0;
import com.baidu.ufosdk.p1;
import com.baidu.ufosdk.q0;
import com.baidu.ufosdk.r0;
import com.baidu.ufosdk.s1;
import com.baidu.ufosdk.screencapedt.ScreenCapEditActivity;
import com.baidu.ufosdk.t1;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes9.dex */
public class FeedbackEditActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public IFeedbackMethodCallback C;
    @SuppressLint({"HandlerLeak"})
    public Handler D;
    public ScrollView E;
    public String F;
    public int G;
    public String H;
    public RelativeLayout.LayoutParams I;
    public LinearLayout.LayoutParams J;
    public e0 K;
    public boolean L;
    public String[] M;
    public String[] N;
    public boolean O;
    public RelativeLayout P;
    public ListView Q;
    public RelativeLayout R;
    public TextView S;

    /* renamed from: T  reason: collision with root package name */
    public SpannableString f1183T;
    public ClickableSpan U;
    public SharedPreferences.Editor a;
    public SharedPreferences b;
    public int c;
    public boolean d;
    public String e;
    public String f;
    public RelativeLayout g;
    public ImageView h;
    public Button i;
    public TextView j;
    public RelativeLayout k;
    public EditText l;
    public EditText m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public List<byte[]> s;
    public HashMap<String, String> t;
    public Boolean u;
    public String v;
    public View w;
    public boolean x;
    public boolean y;
    public boolean z;

    @Override // android.app.Activity
    @SuppressLint({"ObsoleteSdkInt"})
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setRequestedOrientation(1);
            boolean z = com.baidu.ufosdk.b.m() == 1;
            this.d = z;
            if (Build.VERSION.SDK_INT >= 21 && !z) {
                Window window = getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.getDecorView().setSystemUiVisibility(1280);
                if (Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(8192);
                }
                window.getDecorView().setBackgroundColor(-1);
                window.setStatusBarColor(0);
            }
            this.K = e0.a(this);
            this.C = FeedbackManager.getInstance(this).getFeedbackCallback();
            if (this.c == 33013) {
                getWindow().addFlags(4718592);
            }
            getWindow().setSoftInputMode(32);
            SharedPreferences sharedPreferences = getSharedPreferences("UfoSharePreference", 0);
            this.b = sharedPreferences;
            String string = sharedPreferences.getString("cryptContactData", "");
            if (string != null && string.trim().length() > 0) {
                this.F = com.baidu.ufosdk.b.a(string);
            } else {
                this.F = "";
            }
            this.a = this.b.edit();
            this.e = getIntent().getStringExtra("faq_id");
            this.v = getIntent().getStringExtra("msgid");
            getIntent().getIntExtra("product_type", -1);
            this.G = getIntent().getIntExtra("come_from", -1);
            getIntent().getIntExtra("extend_feedback_channel", -1);
            this.L = getIntent().getIntExtra("showProblem", 0) == 1;
            this.M = getResources().getStringArray(R.array.obfuscated_res_0x7f030018);
            this.N = getResources().getStringArray(R.array.obfuscated_res_0x7f030017);
            if (TextUtils.isEmpty(this.v)) {
                this.v = "newMessage";
            }
            if (TextUtils.isEmpty(this.e)) {
                this.e = "";
            }
            this.a.putBoolean("ADD_PIC_FLAG", true);
            this.a.commit();
            this.s = new ArrayList();
            this.t = new HashMap<>();
            this.E = new ScrollView(this);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.g = relativeLayout;
            relativeLayout.setId(2030567428);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setId(2030632963);
            this.g.setBackgroundColor(this.d ? -15132391 : -1);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setId(2030632962);
            linearLayout.setOrientation(0);
            linearLayout.setBackgroundColor(this.d ? -15132391 : -1);
            linearLayout.setGravity(16);
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setGravity(16);
            linearLayout2.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 19.0f), p1.a(getApplicationContext(), 19.0f));
            this.J = layoutParams;
            layoutParams.setMargins(p1.a(getApplicationContext(), 10.0f), 0, p1.a(getApplicationContext(), 10.0f), 0);
            ImageView imageView = new ImageView(this);
            this.h = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.h.setBackgroundDrawable(new BitmapDrawable(p1.b(getApplicationContext(), this.d ? "ufo_back_icon_browser_night.png" : "ufo_back_icon_browser.png")));
            linearLayout2.addView(this.h, this.J);
            if (com.baidu.ufosdk.b.e() == 0) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 35.0f), -1);
                this.J = layoutParams2;
                layoutParams2.setMargins(p1.a(getApplicationContext(), 10.0f), 0, 0, 0);
                linearLayout.addView(linearLayout2, this.J);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 42.0f));
            this.I = layoutParams3;
            layoutParams3.addRule(12);
            this.g.addView(linearLayout, this.I);
            View view2 = new View(this);
            view2.setId(2030632970);
            view2.setBackgroundColor(this.d ? -13619152 : -1644826);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 0.5f));
            this.I = layoutParams4;
            layoutParams4.addRule(2, linearLayout.getId());
            this.g.addView(view2, this.I);
            TextView textView = new TextView(this);
            this.j = textView;
            textView.setId(2030567426);
            this.j.setTextColor(this.d ? -5131855 : -16777216);
            this.j.setTextSize(16.0f);
            this.j.setGravity(17);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -1);
            this.I = layoutParams5;
            layoutParams5.addRule(13);
            relativeLayout2.addView(this.j, this.I);
            if (com.baidu.ufosdk.b.e() == 1) {
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -1);
                this.I = layoutParams6;
                layoutParams6.addRule(9);
                this.I.addRule(15);
                this.J.setMargins(p1.a(getApplicationContext(), 10.0f), 0, 0, 0);
                relativeLayout2.addView(linearLayout2, this.I);
                view2.setVisibility(8);
                linearLayout.setVisibility(8);
            }
            this.i = new Button(this);
            if (getIntent().getIntExtra("continue", 0) == 1) {
                this.i.setVisibility(4);
            }
            this.i.setText("提交");
            this.i.setId(2030632966);
            this.i.setTextColor(-12814593);
            this.i.setAlpha(0.3f);
            this.i.setTextSize(14.0f);
            this.i.setGravity(17);
            this.i.setBackgroundColor(16777215);
            this.i.setPadding(p1.a(getApplicationContext(), 10.0f), 0, p1.a(getApplicationContext(), 10.0f), 0);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            this.I = layoutParams7;
            layoutParams7.addRule(11);
            this.I.addRule(15);
            relativeLayout2.addView(this.i, this.I);
            relativeLayout2.setBackgroundColor(this.d ? -15132391 : -1);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 38.0f));
            this.I = layoutParams8;
            layoutParams8.addRule(10);
            this.g.addView(relativeLayout2, this.I);
            View view3 = new View(this);
            view3.setId(126910480);
            view3.setBackgroundColor(this.d ? -13619152 : -1644826);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 0.5f));
            this.I = layoutParams9;
            layoutParams9.addRule(3, relativeLayout2.getId());
            this.g.addView(view3, this.I);
            RelativeLayout relativeLayout3 = new RelativeLayout(this);
            this.k = relativeLayout3;
            relativeLayout3.setId(2030567429);
            this.k.setBackgroundColor(this.d ? -15132391 : -1);
            View c2 = p1.c(this, t1.a("25"));
            this.w = c2;
            c2.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams10.addRule(13);
            this.k.addView(this.w, layoutParams10);
            RelativeLayout relativeLayout4 = new RelativeLayout(this);
            this.P = relativeLayout4;
            relativeLayout4.setBackgroundColor(this.d ? -15132391 : -1);
            ListView listView = new ListView(this);
            this.Q = listView;
            listView.setDivider(new ColorDrawable(this.d ? -13619152 : -3355444));
            this.Q.setDividerHeight(1);
            this.P.addView(this.Q, new RelativeLayout.LayoutParams(-1, -2));
            this.E.addView(this.k);
            RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams11.addRule(3, view3.getId());
            layoutParams11.addRule(2, view2.getId());
            this.g.addView(this.E, layoutParams11);
            this.g.addView(this.P, layoutParams11);
            float a2 = p1.a((Context) this, 3.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.d ? -15132391 : -1);
            gradientDrawable.setCornerRadius(a2);
            gradientDrawable.setStroke(3, this.d ? -14540254 : -3355444);
            RelativeLayout relativeLayout5 = new RelativeLayout(this);
            this.R = relativeLayout5;
            relativeLayout5.setId(2030632978);
            this.R.setBackgroundColor(this.d ? -15132391 : -1);
            TextView textView2 = new TextView(this);
            textView2.setTextColor(this.d ? -5131855 : -16777216);
            textView2.setText("问题类型");
            textView2.setTextSize(16.0f);
            textView2.setGravity(16);
            RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams12.setMargins(p1.a(getApplicationContext(), 15.0f), 0, 0, 0);
            layoutParams12.addRule(15);
            this.R.addView(textView2, layoutParams12);
            TextView textView3 = new TextView(this);
            this.S = textView3;
            textView3.setTextColor(this.d ? -5131855 : -6710887);
            this.S.setTextSize(13.0f);
            this.S.setGravity(16);
            this.S.setSingleLine(true);
            RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams13.setMargins(0, 0, p1.a(getApplicationContext(), 15.0f), 0);
            layoutParams13.addRule(15);
            layoutParams13.addRule(11);
            this.R.addView(this.S, layoutParams13);
            View view4 = new View(this);
            view4.setBackgroundColor(this.d ? -13619152 : -1644826);
            RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 0.5f));
            layoutParams14.setMargins(p1.a(getApplicationContext(), 15.0f), 0, p1.a(getApplicationContext(), 15.0f), 0);
            layoutParams14.addRule(12);
            this.R.addView(view4, layoutParams14);
            RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 42.0f));
            layoutParams15.addRule(10);
            this.k.addView(this.R, layoutParams15);
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setId(2030632968);
            linearLayout3.setOrientation(1);
            linearLayout3.setBackgroundColor(this.d ? -15329770 : -1);
            TextView textView4 = new TextView(this);
            this.o = textView4;
            textView4.setBackgroundColor(this.d ? -15329770 : -1);
            this.o.setTextColor(this.d ? -5131855 : -16777216);
            SpannableString spannableString = new SpannableString("问题描述*");
            spannableString.setSpan(new ForegroundColorSpan(-1293499), 4, 5, 34);
            this.o.setText(spannableString);
            this.o.setPadding(p1.a(getApplicationContext(), 15.0f), p1.a(getApplicationContext(), 0.0f), 0, 0);
            this.o.setTextSize(16.0f);
            this.o.setGravity(16);
            LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-1, p1.a(getApplicationContext(), 41.0f));
            this.J = layoutParams16;
            layoutParams16.setMargins(0, p1.a(getApplicationContext(), 6.0f), 0, 0);
            linearLayout3.addView(this.o, this.J);
            RelativeLayout relativeLayout6 = new RelativeLayout(this);
            float a3 = p1.a((Context) this, 3.0f);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(this.d ? -15132391 : -1);
            gradientDrawable2.setCornerRadius(a3);
            gradientDrawable2.setStroke(3, this.d ? -14540254 : -3355444);
            relativeLayout6.setBackgroundDrawable(gradientDrawable2);
            EditText editText = new EditText(this);
            this.l = editText;
            editText.setId(2030632969);
            this.l.setBackgroundColor(this.d ? -15132391 : -1);
            this.l.setTextColor(this.d ? -5131855 : -13421773);
            this.l.setTextSize(14.0f);
            this.l.setHint(t1.a("6"));
            this.l.setHintTextColor(this.d ? -5131855 : -6710887);
            this.l.setGravity(3);
            this.l.setPadding(p1.a(getApplicationContext(), 11.0f), p1.a(getApplicationContext(), 5.0f), p1.a(getApplicationContext(), 11.0f), p1.a(getApplicationContext(), 5.0f));
            RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 62.0f));
            this.I = layoutParams17;
            layoutParams17.setMargins(p1.a((Context) this, 2.0f), p1.a((Context) this, 3.0f), p1.a((Context) this, 2.0f), p1.a((Context) this, 3.0f));
            relativeLayout6.addView(this.l, this.I);
            TextView textView5 = new TextView(this);
            this.n = textView5;
            textView5.setBackgroundColor(this.d ? -15132391 : -1);
            this.n.setTextSize(11.0f);
            this.n.setTextColor(this.d ? -5131855 : -6710887);
            this.n.setText("8-200字");
            RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-2, -2);
            this.I = layoutParams18;
            layoutParams18.addRule(3, this.l.getId());
            this.I.addRule(11);
            this.n.setPadding(0, 0, p1.a(getApplicationContext(), 7.0f), 0);
            relativeLayout6.setPadding(0, 0, p1.a(getApplicationContext(), 1.0f), p1.a(getApplicationContext(), 7.0f));
            relativeLayout6.addView(this.n, this.I);
            LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(-1, -2);
            this.J = layoutParams19;
            layoutParams19.setMargins(p1.a(getApplicationContext(), 15.0f), 0, p1.a(getApplicationContext(), 15.0f), p1.a(getApplicationContext(), 17.0f));
            linearLayout3.addView(relativeLayout6, this.J);
            RelativeLayout.LayoutParams layoutParams20 = new RelativeLayout.LayoutParams(-1, -2);
            this.I = layoutParams20;
            layoutParams20.addRule(3, this.R.getId());
            this.k.addView(linearLayout3, this.I);
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("shot");
            if (byteArrayExtra != null && byteArrayExtra.length > 0) {
                this.s.add(byteArrayExtra);
            }
            LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.setId(2030632976);
            linearLayout4.setOrientation(1);
            linearLayout4.setBackgroundColor(this.d ? -15329770 : -1);
            TextView textView6 = new TextView(this);
            this.p = textView6;
            textView6.setText("上传问题截图");
            this.p.setBackgroundColor(this.d ? -15329770 : -1);
            this.p.setTextColor(this.d ? -5131855 : -16777216);
            this.p.setTextSize(16.0f);
            this.p.setGravity(16);
            this.p.setPadding(p1.a(getApplicationContext(), 15.0f), 0, 0, 0);
            LinearLayout.LayoutParams layoutParams21 = new LinearLayout.LayoutParams(-1, p1.a(getApplicationContext(), 41.0f));
            this.J = layoutParams21;
            linearLayout4.addView(this.p, layoutParams21);
            LinearLayout linearLayout5 = new LinearLayout(this);
            this.r = linearLayout5;
            linearLayout5.setOrientation(0);
            this.r.setPadding(p1.a(getApplicationContext(), 8.0f), p1.a(getApplicationContext(), 0.0f), 0, p1.a(getApplicationContext(), 0.0f));
            this.J = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 350.0f), p1.a(getApplicationContext(), 77.0f));
            this.s.add(p1.a(this, this.d));
            b();
            linearLayout4.addView(this.r, this.J);
            RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(-1, -2);
            this.I = layoutParams22;
            layoutParams22.addRule(3, linearLayout3.getId());
            this.k.addView(linearLayout4, this.I);
            LinearLayout linearLayout6 = new LinearLayout(this);
            linearLayout6.setId(2030632977);
            linearLayout6.setOrientation(1);
            linearLayout6.setBackgroundColor(this.d ? -15132391 : -1);
            TextView textView7 = new TextView(this);
            this.q = textView7;
            textView7.setBackgroundColor(this.d ? -15329770 : -1);
            this.q.setTextColor(this.d ? -5131855 : -16777216);
            this.q.setText("联系方式");
            this.q.setPadding(p1.a(getApplicationContext(), 15.0f), p1.a(getApplicationContext(), 2.0f), 0, 0);
            this.q.setTextSize(16.0f);
            this.q.setGravity(16);
            LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-1, p1.a(getApplicationContext(), 41.0f));
            this.J = layoutParams23;
            layoutParams23.setMargins(0, p1.a(getApplicationContext(), 17.0f), p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 0.0f));
            linearLayout6.addView(this.q, this.J);
            EditText editText2 = new EditText(this);
            this.m = editText2;
            editText2.setBackgroundDrawable(gradientDrawable);
            this.m.setTextColor(this.d ? -5131855 : -13421773);
            this.m.setTextSize(14.0f);
            this.m.setGravity(16);
            this.m.setHint("请留下您的邮箱/手机/QQ号");
            this.m.setHintTextColor(this.d ? -5131855 : -6710887);
            this.m.setSingleLine();
            this.m.setPadding(p1.a(getApplicationContext(), 11.0f), p1.a(getApplicationContext(), 5.0f), p1.a(getApplicationContext(), 11.0f), p1.a(getApplicationContext(), 5.0f));
            LinearLayout.LayoutParams layoutParams24 = new LinearLayout.LayoutParams(-1, p1.a(getApplicationContext(), 33.0f));
            this.J = layoutParams24;
            layoutParams24.setMargins(p1.a(getApplicationContext(), 15.0f), 0, p1.a(getApplicationContext(), 15.0f), 0);
            linearLayout6.addView(this.m, this.J);
            RelativeLayout.LayoutParams layoutParams25 = new RelativeLayout.LayoutParams(-1, -2);
            this.I = layoutParams25;
            layoutParams25.addRule(3, linearLayout4.getId());
            this.k.setPadding(0, 0, 0, p1.a(getApplicationContext(), 30.0f));
            this.k.addView(linearLayout6, this.I);
            if (this.G == 3) {
                int id = linearLayout6.getId();
                LinearLayout linearLayout7 = new LinearLayout(this);
                linearLayout7.setOrientation(0);
                linearLayout7.setBackgroundColor(this.d ? -15329770 : -1);
                ImageView imageView2 = new ImageView(this);
                imageView2.setBackgroundDrawable(new BitmapDrawable(p1.b(this, this.d ? "ufo_checkbox_checked_night.png" : "ufo_checkbox_checked.png")));
                imageView2.setOnClickListener(new r0(this, imageView2));
                LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams(p1.a((Context) this, 15.0f), p1.a((Context) this, 15.0f));
                layoutParams26.setMargins(0, p1.a((Context) this, 3.0f), 0, 0);
                linearLayout7.addView(imageView2, layoutParams26);
                TextView textView8 = new TextView(this);
                SpannableString spannableString2 = new SpannableString("允许第三方网站使用您的反馈资料,《相关说明》");
                spannableString2.setSpan(this.U, 16, spannableString2.length(), 33);
                this.f1183T = spannableString2;
                textView8.setText(spannableString2);
                textView8.setTextSize(14.0f);
                textView8.setTextColor(this.d ? -10066330 : -6710887);
                textView8.setMovementMethod(LinkMovementMethod.getInstance());
                LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams27.setMargins(p1.a((Context) this, 7.0f), 0, 0, 0);
                linearLayout7.addView(textView8, layoutParams27);
                RelativeLayout.LayoutParams layoutParams28 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams28.addRule(3, id);
                layoutParams28.setMargins(p1.a(getApplicationContext(), 13.0f), p1.a(getApplicationContext(), 20.0f), 0, 0);
                this.k.addView(linearLayout7, layoutParams28);
            }
            this.l.addTextChangedListener(new p0(this));
            this.m.addTextChangedListener(new q0(this));
            this.h.setOnClickListener(new m0(this));
            this.i.setOnClickListener(new n0(this));
            d1 d1Var = new d1(this, this.M, this.d);
            this.Q.setAdapter((ListAdapter) d1Var);
            this.Q.setOnItemClickListener(new o0(this, d1Var));
            if (this.L) {
                this.j.setText("问题类型");
                this.i.setVisibility(8);
                this.P.setVisibility(0);
                this.R.setVisibility(8);
            } else {
                this.j.setText(this.H);
                this.i.setVisibility(0);
                this.P.setVisibility(8);
                this.R.setVisibility(8);
            }
            setContentView(this.g);
        }
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackEditActivity a;

        public a(FeedbackEditActivity feedbackEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackEditActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K.a();
                if (TextUtils.isEmpty(this.a.K.b)) {
                    this.a.D.obtainMessage(4, null).sendToTarget();
                } else {
                    this.a.D.obtainMessage(1, null).sendToTarget();
                }
                Context applicationContext = this.a.getApplicationContext();
                String str = this.a.K.a;
                String g = com.baidu.ufosdk.b.g(applicationContext);
                if (g != null) {
                    this.a.D.obtainMessage(0, g).sendToTarget();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackEditActivity a;

        public b(FeedbackEditActivity feedbackEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackEditActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context applicationContext = this.a.getApplicationContext();
                String str = this.a.K.a;
                String g = com.baidu.ufosdk.b.g(applicationContext);
                if (g != null) {
                    this.a.D.obtainMessage(0, g).sendToTarget();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackEditActivity a;

        public c(FeedbackEditActivity feedbackEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FeedbackEditActivity feedbackEditActivity = this.a;
                if (feedbackEditActivity.x) {
                    return;
                }
                feedbackEditActivity.s.remove(((Integer) view2.getTag()).intValue());
                if (this.a.s.size() == 1) {
                    byte[] a = p1.a(this.a.getApplicationContext(), this.a.d);
                    if (a == null) {
                        return;
                    }
                    this.a.s.set(0, a);
                }
                this.a.b();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackEditActivity a;

        public d(FeedbackEditActivity feedbackEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FeedbackEditActivity feedbackEditActivity = this.a;
                if (feedbackEditActivity.x) {
                    return;
                }
                feedbackEditActivity.A = ((Integer) view2.getTag()).intValue();
                FeedbackEditActivity feedbackEditActivity2 = this.a;
                byte[] bArr = feedbackEditActivity2.s.get(feedbackEditActivity2.A);
                int i = this.a.A;
                if (feedbackEditActivity2 != null) {
                    Intent intent = new Intent(feedbackEditActivity2, ScreenCapEditActivity.class);
                    intent.putExtra("shot", bArr);
                    intent.putExtra("direct", true);
                    feedbackEditActivity2.startActivityForResult(intent, i);
                    return;
                }
                throw null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackEditActivity a;

        public e(FeedbackEditActivity feedbackEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FeedbackEditActivity feedbackEditActivity = this.a;
                if (feedbackEditActivity.x) {
                    return;
                }
                feedbackEditActivity.A = ((Integer) view2.getTag()).intValue();
                if (p1.a() >= 23) {
                    FeedbackEditActivity.c(this.a);
                } else {
                    FeedbackEditActivity.c(this.a);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackEditActivity a;

        public f(FeedbackEditActivity feedbackEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackEditActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i = message.what;
                if (i != 12) {
                    if (i != 13) {
                        if (i != 14) {
                            if (i == 15) {
                                try {
                                    ((InputMethodManager) this.a.l.getContext().getSystemService("input_method")).showSoftInput(this.a.l, 0);
                                    return;
                                } catch (Exception unused) {
                                    return;
                                }
                            } else if (i == 16) {
                                if (this.a.getCurrentFocus() != null && this.a.getCurrentFocus().getWindowToken() != null) {
                                    ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
                                    return;
                                }
                                return;
                            } else if (i != 17) {
                                if (i != 19) {
                                    return;
                                }
                                this.a.x = false;
                                this.a.i.setTextColor(-12814593);
                                this.a.w.setVisibility(8);
                                String str = (String) message.obj;
                                if (!TextUtils.isEmpty(str)) {
                                    Toast.makeText(this.a, str, 1).show();
                                    return;
                                }
                                return;
                            } else {
                                this.a.b();
                                return;
                            }
                        }
                        this.a.x = false;
                        FeedbackEditActivity feedbackEditActivity = this.a;
                        if (feedbackEditActivity != null) {
                            feedbackEditActivity.s = new ArrayList();
                            feedbackEditActivity.b();
                            FeedbackEditActivity feedbackEditActivity2 = this.a;
                            if (!feedbackEditActivity2.y) {
                                feedbackEditActivity2.u = Boolean.FALSE;
                                if (!TextUtils.isEmpty(feedbackEditActivity2.v) && TextUtils.isEmpty(this.a.e)) {
                                    FeedbackEditActivity feedbackEditActivity3 = this.a;
                                    feedbackEditActivity3.a.putString(feedbackEditActivity3.v, "");
                                }
                                if (!TextUtils.isEmpty(this.a.e)) {
                                    FeedbackEditActivity feedbackEditActivity4 = this.a;
                                    feedbackEditActivity4.a.putString(feedbackEditActivity4.e, "");
                                }
                                this.a.a.commit();
                                this.a.w.setVisibility(8);
                                if (this.a.C != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("result", "success");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    this.a.C.onMessageSubmit(jSONObject.toString());
                                }
                                Toast.makeText(this.a, t1.a(PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK), 0).show();
                                this.a.finish();
                                return;
                            }
                            feedbackEditActivity2.y = false;
                            return;
                        }
                        throw null;
                    }
                    this.a.x = false;
                    this.a.w.setVisibility(8);
                    this.a.i.setTextColor(-12814593);
                    if (this.a.C != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("result", "fail");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        this.a.C.onMessageSubmit(jSONObject2.toString());
                    }
                    Toast.makeText(this.a, t1.a("18"), 1).show();
                    return;
                }
                this.a.x = false;
                FeedbackEditActivity feedbackEditActivity5 = this.a;
                if (feedbackEditActivity5 != null) {
                    feedbackEditActivity5.s = new ArrayList();
                    feedbackEditActivity5.b();
                    FeedbackEditActivity feedbackEditActivity6 = this.a;
                    if (!feedbackEditActivity6.y) {
                        feedbackEditActivity6.u = Boolean.FALSE;
                        if (!TextUtils.isEmpty(feedbackEditActivity6.v) && TextUtils.isEmpty(this.a.e)) {
                            FeedbackEditActivity feedbackEditActivity7 = this.a;
                            feedbackEditActivity7.a.putString(feedbackEditActivity7.v, "");
                        }
                        if (!TextUtils.isEmpty(this.a.e)) {
                            FeedbackEditActivity feedbackEditActivity8 = this.a;
                            feedbackEditActivity8.a.putString(feedbackEditActivity8.e, "");
                        }
                        this.a.a.commit();
                        this.a.w.setVisibility(8);
                        this.a.finish();
                        return;
                    }
                    feedbackEditActivity6.y = false;
                    return;
                }
                throw null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackEditActivity a;

        public g(FeedbackEditActivity feedbackEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackEditActivity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FeedbackEditActivity.b(this.a);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(BaseAnimatedElement.DEBUG_PAINT_COLOR);
                textPaint.setUnderlineText(false);
            }
        }
    }

    public FeedbackEditActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = false;
        this.e = "";
        this.f = "";
        this.u = Boolean.TRUE;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = -1;
        this.B = -1;
        this.D = new f(this);
        this.G = -1;
        this.H = "反馈建议";
        this.I = null;
        this.J = null;
        this.O = true;
        this.U = new g(this);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.w.getVisibility() == 0) {
                this.w.setVisibility(8);
                this.i.setTextColor(-12814593);
                this.x = false;
            } else if (this.L && this.R.getVisibility() == 0) {
                this.P.setVisibility(0);
                this.R.setVisibility(8);
                this.y = false;
                this.i.setVisibility(8);
                this.j.setText("问题类型");
            } else {
                finish();
            }
        }
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bitmap, i)) == null) {
            if (bitmap == null || i <= 0) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > i && height > i) {
                int max = (Math.max(width, height) * i) / Math.min(width, height);
                if (width > height) {
                    i2 = max;
                } else {
                    i2 = i;
                }
                if (width > height) {
                    max = i;
                }
                try {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, max, true);
                    Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, (i2 - i) / 2, (max - i) / 2, i, i);
                    createScaledBitmap.recycle();
                    return createBitmap;
                } catch (Exception unused) {
                    return null;
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static void b(FeedbackEditActivity feedbackEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, feedbackEditActivity) == null) {
            if (feedbackEditActivity != null) {
                new i1(feedbackEditActivity).show();
                return;
            }
            throw null;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, keyEvent)) == null) {
            if (i == 4) {
                this.y = true;
                a();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(FeedbackEditActivity feedbackEditActivity, Bitmap bitmap) {
        InterceptResult invokeLL;
        Exception e2;
        byte[] bArr;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, feedbackEditActivity, bitmap)) == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            byte[] bArr2 = null;
            byteArrayOutputStream2 = null;
            if (feedbackEditActivity != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e3) {
                    e2 = e3;
                    bArr = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream2 != null) {
                    }
                    throw th;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
                    bArr2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    try {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        return bArr2;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return bArr2;
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    byte[] bArr3 = bArr2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    bArr = bArr3;
                    try {
                        e2.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.flush();
                                byteArrayOutputStream2.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        return bArr;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.flush();
                                byteArrayOutputStream2.close();
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    th = th;
                    if (byteArrayOutputStream2 != null) {
                    }
                    throw th;
                }
            }
            throw null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static void c(FeedbackEditActivity feedbackEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, feedbackEditActivity) == null) {
            if (feedbackEditActivity != null) {
                if (!com.baidu.ufosdk.b.n()) {
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                    intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                    if (feedbackEditActivity.A == feedbackEditActivity.s.size() - 1) {
                        if (feedbackEditActivity.getCurrentFocus() != null && feedbackEditActivity.getCurrentFocus().getWindowToken() != null) {
                            ((InputMethodManager) feedbackEditActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackEditActivity.getCurrentFocus().getWindowToken(), 2);
                        }
                        try {
                            feedbackEditActivity.startActivityForResult(intent, feedbackEditActivity.A);
                            try {
                                feedbackEditActivity.overridePendingTransition(p1.a(feedbackEditActivity.getApplicationContext(), "ufo_slide_in_from_bottom"), 0);
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        } catch (ActivityNotFoundException unused2) {
                            Toast.makeText(feedbackEditActivity, t1.a("0"), 1).show();
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public boolean a(Context context, String str, String str2, String str3, String str4, String str5, Handler handler) {
        InterceptResult invokeCommon;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, str3, str4, str5, handler})) == null) {
            String str6 = s1.f;
            String str7 = "url is " + str6;
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", str);
            hashMap.put("appid", this.K.b);
            hashMap.put("devid", this.K.c);
            hashMap.put("id", str2);
            StringBuilder sb = new StringBuilder();
            if (this.L) {
                sb.append("问题类型: ");
                sb.append(this.S.getText());
                sb.append("  问题描述: ");
            }
            sb.append(str3);
            hashMap.put("content", sb.toString());
            if (p1.a(str4)) {
                c2 = 1;
            } else if (p1.b(str4)) {
                c2 = 2;
            } else if (p1.c(str4)) {
                c2 = 3;
            } else {
                c2 = 0;
            }
            String str8 = "contactWay is " + str4;
            if (c2 == 0) {
                hashMap.put("contact_way", str4);
            } else if (c2 == 1) {
                hashMap.put("email", str4);
            } else if (c2 == 2) {
                hashMap.put("tel", str4);
            } else if (c2 == 3) {
                hashMap.put("qq", str4);
            } else {
                hashMap.put("contact_way", str4);
            }
            hashMap.put("brand", "");
            hashMap.put("model", "");
            hashMap.put("sdkvn", "4.1.9.1");
            hashMap.put("os", com.baidu.ufosdk.b.e(context));
            hashMap.put("appvn", com.baidu.ufosdk.c.b());
            hashMap.put("baiducuid", com.baidu.ufosdk.b.f());
            hashMap.put("uid", com.baidu.ufosdk.b.c());
            hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.c());
            hashMap.put("username", com.baidu.ufosdk.b.b());
            hashMap.put("osvn", "");
            hashMap.put("extend_feedback_channel", com.baidu.ufosdk.b.h());
            hashMap.put("extra", com.baidu.ufosdk.b.g());
            if (!TextUtils.isEmpty(this.e)) {
                hashMap.put("faq_id", this.e);
            }
            hashMap.put("phonetime", String.valueOf(System.currentTimeMillis()));
            hashMap.put(FpsTracer.UBC_KEY_NET_TYPE, p1.b(context));
            hashMap.put("screenSize", com.baidu.ufosdk.b.h(context));
            hashMap.put("ip_location", com.baidu.ufosdk.b.k());
            String b2 = com.baidu.ufosdk.b.b(com.baidu.ufosdk.b.a(hashMap));
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sdk_encrypt", b2);
                if (!TextUtils.isEmpty(str5)) {
                    hashMap2.put(StatisticConstants.SCREENSHOT, str5);
                }
                String a2 = d0.a(str6, d0.a(hashMap2));
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.b.a(a2));
                    r0 = "response is -----------------> " + jSONObject.toString();
                    int intValue = ((Integer) jSONObject.get("errno")).intValue();
                    if (intValue == 0) {
                        com.baidu.ufosdk.b.a(context, System.currentTimeMillis());
                        if (str2.contains("newMessage")) {
                            handler.obtainMessage(14, String.valueOf(jSONObject.get("id"))).sendToTarget();
                        } else {
                            handler.obtainMessage(12).sendToTarget();
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", this.K.d + "_" + jSONObject.optString("feedback_id"));
                        if (this.L) {
                            jSONObject2.put("type", this.N[this.B]);
                        } else if (this.G == 3) {
                            jSONObject2.put("type", 1002);
                        } else {
                            jSONObject2.put("type", 1001);
                        }
                        String jSONObject3 = jSONObject2.toString();
                        String str9 = "callback json: " + jSONObject3;
                        com.baidu.ufosdk.b.a((Context) this, 0, true, jSONObject3);
                    } else if (intValue == 4) {
                        handler.obtainMessage(19, (String) jSONObject.get("errmsg")).sendToTarget();
                    }
                    return true;
                }
            } catch (Exception unused) {
                handler.obtainMessage(13).sendToTarget();
            }
            this.x = false;
            com.baidu.ufosdk.b.a((Context) this, 0, false, "");
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void b() {
        LinearLayout linearLayout;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (linearLayout = this.r) == null) {
            return;
        }
        linearLayout.removeAllViews();
        for (int i = 0; i < this.s.size(); i++) {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            if (i != this.s.size() - 1) {
                e1 e1Var = new e1(this);
                e1Var.setTag(Integer.valueOf(i));
                e1Var.setBackgroundDrawable(null);
                e1Var.setPadding(0, 0, 0, 0);
                e1Var.setScaleType(ImageView.ScaleType.CENTER_CROP);
                e1Var.setMaxHeight(p1.a(getApplicationContext(), 77.0f));
                e1Var.setMinimumHeight(p1.a(getApplicationContext(), 77.0f));
                e1Var.setMaxWidth(p1.a(getApplicationContext(), 77.0f));
                e1Var.setMinimumWidth(p1.a(getApplicationContext(), 77.0f));
                relativeLayout.addView(e1Var, new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 77.0f), p1.a(getApplicationContext(), 77.0f)));
                try {
                    if (this.s.get(i) != null) {
                        bitmap = BitmapFactory.decodeByteArray(this.s.get(i), 0, this.s.get(i).length);
                        if (bitmap == null) {
                            return;
                        }
                    } else {
                        bitmap = null;
                    }
                    if (bitmap != null && a(bitmap, p1.a(getApplicationContext(), 45.0f)) != null) {
                        e1Var.setImageBitmap(bitmap);
                        ImageButton imageButton = new ImageButton(this);
                        imageButton.setTag(Integer.valueOf(i));
                        imageButton.setBackgroundDrawable(null);
                        imageButton.setPadding(p1.a(getApplicationContext(), 2.0f), p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 2.0f));
                        imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
                        Bitmap b2 = p1.b(getApplicationContext(), "ufo_delete_little_icon.png");
                        if (b2 == null) {
                            return;
                        }
                        imageButton.setImageBitmap(b2);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 19.0f), p1.a(getApplicationContext(), 19.0f));
                        layoutParams.addRule(11);
                        layoutParams.addRule(10);
                        layoutParams.setMargins(0, 0, 0, 0);
                        relativeLayout.addView(imageButton, layoutParams);
                        imageButton.setOnClickListener(new c(this));
                        e1Var.setOnClickListener(new d(this));
                    } else {
                        return;
                    }
                } catch (OutOfMemoryError unused) {
                    System.gc();
                    return;
                }
            } else {
                ImageView imageView = new ImageView(this);
                imageView.setTag(Integer.valueOf(i));
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(0, 0, 0, 0);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setMaxHeight(p1.a(getApplicationContext(), 77.0f));
                imageView.setMinimumHeight(p1.a(getApplicationContext(), 77.0f));
                imageView.setMaxWidth(p1.a(getApplicationContext(), 77.0f));
                imageView.setMinimumWidth(p1.a(getApplicationContext(), 77.0f));
                relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 77.0f), p1.a(getApplicationContext(), 77.0f)));
                try {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(this.s.get(i), 0, this.s.get(i).length);
                    if (decodeByteArray != null && a(decodeByteArray, p1.a(getApplicationContext(), 45.0f)) != null) {
                        imageView.setImageBitmap(decodeByteArray);
                        imageView.setOnClickListener(new e(this));
                    } else {
                        return;
                    }
                } catch (OutOfMemoryError unused2) {
                    System.gc();
                    return;
                }
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 77.0f), p1.a(getApplicationContext(), 77.0f));
            layoutParams2.setMargins(p1.a(getApplicationContext(), 7.0f), 0, 0, 0);
            layoutParams2.gravity = 80;
            this.r.addView(relativeLayout, layoutParams2);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri uri;
        byte[] bArr;
        Exception e2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            String str = " --*^o^*-- requestCode = " + i + "; resultCode = " + i2;
            if (!this.z) {
                this.z = true;
            }
            if (i2 != -1 || intent == null) {
                return;
            }
            try {
                uri = intent.getData();
            } catch (Exception unused) {
                uri = null;
            }
            if (uri == null) {
                String stringExtra = intent.getStringExtra("shotUrl");
                byte[] byteArrayExtra = intent.getByteArrayExtra("shot");
                boolean booleanExtra = intent.getBooleanExtra("editAgain", false);
                if (byteArrayExtra != null && byteArrayExtra.length > 0) {
                    this.s.set(i, byteArrayExtra);
                    if (!booleanExtra) {
                        this.s.add(p1.a(this, this.d));
                    }
                    b();
                    return;
                } else if (stringExtra != null && stringExtra.length() > 0) {
                    new Thread(new l0(this, stringExtra, i)).start();
                    return;
                } else {
                    return;
                }
            }
            try {
                InputStream openInputStream = getContentResolver().openInputStream(uri);
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = openInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                openInputStream.close();
                try {
                } catch (Exception e3) {
                    e2 = e3;
                    System.out.println(e2.getMessage());
                    if (i == this.s.size() - 1) {
                        Intent intent2 = new Intent(this, ScreenCapEditActivity.class);
                        intent2.putExtra("shot", bArr);
                        intent2.putExtra("direct", false);
                        startActivityForResult(intent2, i);
                    }
                    b();
                }
            } catch (Exception e4) {
                bArr = null;
                e2 = e4;
            }
            if (bArr == null) {
                Toast.makeText(this, t1.a("21"), 1).show();
                return;
            }
            try {
                Cursor query = getContentResolver().query(uri, null, null, null, null);
                if (query != null) {
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("orientation"));
                    if (string == null) {
                        i3 = 0;
                    } else {
                        i3 = Integer.parseInt(string);
                    }
                    try {
                        query.close();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception unused3) {
            }
            i3 = 0;
            bArr = com.baidu.ufosdk.b.a(bArr, i3);
            if (bArr == null) {
                Toast.makeText(this, t1.a("21"), 1).show();
            } else if (bArr.length > 512000) {
                Toast.makeText(this, t1.a("21"), 1).show();
            } else if (bArr.length == 0) {
                Toast.makeText(this, "图片错误，请重新选择一张。", 1).show();
            } else {
                if (p1.d(this) < 35000) {
                    Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
                    System.gc();
                    return;
                }
                if (i == this.s.size() - 1 && bArr != null && bArr.length != 0) {
                    Intent intent22 = new Intent(this, ScreenCapEditActivity.class);
                    intent22.putExtra("shot", bArr);
                    intent22.putExtra("direct", false);
                    startActivityForResult(intent22, i);
                }
                b();
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            IFeedbackMethodCallback iFeedbackMethodCallback = this.C;
            if (iFeedbackMethodCallback != null) {
                iFeedbackMethodCallback.onDestory();
                FeedbackManager.getInstance(this).setFeedbackCallback(null);
                this.C = null;
            }
            SpannableString spannableString = this.f1183T;
            if (spannableString != null) {
                spannableString.removeSpan(this.U);
                this.U = null;
                this.f1183T = null;
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            String obj = this.m.getText().toString();
            if (obj != null && obj.trim().length() > 0) {
                this.a.putString("cryptContactData", com.baidu.ufosdk.b.b(obj));
            } else {
                this.a.putString("cryptContactData", "");
            }
            if (this.u.booleanValue()) {
                if (!TextUtils.isEmpty(this.e)) {
                    this.a.putString(this.e, this.l.getText().toString());
                } else {
                    this.a.putString(this.v, this.l.getText().toString());
                }
            }
            this.a.commit();
            if (this.c == 33013) {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            p1.a((RelativeLayout) this.w, t1.a("25"));
            this.i.setTextSize(14.0f);
            this.u = Boolean.TRUE;
            String str = this.v;
            if (str == null) {
                this.v = "newMessage";
            } else if (str.length() == 0) {
                this.v = "newMessage";
            }
            if (!TextUtils.isEmpty(this.e)) {
                string = this.b.getString(this.e, "");
                this.l.setText(string);
            } else {
                string = this.b.getString(this.v, "");
                this.l.setText(string);
            }
            this.l.setSelection(string.length());
            String string2 = this.b.getString("cryptContactData", "");
            if (string2 != null && string2.trim().length() > 0) {
                this.m.setText(com.baidu.ufosdk.b.a(string2));
            } else {
                this.m.setText("");
            }
            if (TextUtils.isEmpty(this.K.b)) {
                new Thread(new a(this)).start();
            } else {
                new Thread(new b(this)).start();
            }
        }
    }
}
