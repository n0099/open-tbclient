package com.baidu.ufosdk.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.internal.view.SupportMenu;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.widget.ConfirmDialog;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ResumeCallBack;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.screencapedt.ScreenCapEditActivity;
import com.baidu.webkit.sdk.WebKitFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.tencent.connect.common.Constants;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class FeedbackEditActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout.LayoutParams A;
    public RelativeLayout.LayoutParams B;
    public TextView C;
    public TextView D;
    public TextView E;
    public boolean F;
    public ScrollView G;
    public ImageView H;
    public ImageView I;
    public ImageView J;
    public Bitmap K;
    public RelativeLayout L;
    public RelativeLayout M;
    public RelativeLayout N;
    public ImageButton O;
    public ImageButton P;
    public ImageButton Q;
    public String R;
    public LinearLayout S;
    public RelativeLayout T;
    public TextView U;
    public Button V;
    public int W;
    public int X;
    public int Y;
    public String Z;

    /* renamed from: a  reason: collision with root package name */
    public Map f59259a;
    public String aa;
    public boolean ab;
    public String ac;
    public String ad;
    public String ae;
    public Handler af;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f59260b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f59261c;

    /* renamed from: d  reason: collision with root package name */
    public String f59262d;

    /* renamed from: e  reason: collision with root package name */
    public String f59263e;

    /* renamed from: f  reason: collision with root package name */
    public int f59264f;

    /* renamed from: g  reason: collision with root package name */
    public String f59265g;

    /* renamed from: h  reason: collision with root package name */
    public String f59266h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f59267i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f59268j;
    public TextView k;
    public RelativeLayout l;
    public EditText m;
    public EditText n;
    public TextView o;
    public LinearLayout p;
    public List q;
    public HashMap r;
    public Boolean s;
    public String t;
    public View u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public List z;

    public FeedbackEditActivity() {
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
        this.f59262d = "";
        this.f59263e = "";
        this.f59264f = 0;
        this.f59265g = "";
        this.f59266h = "";
        this.s = Boolean.TRUE;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.A = null;
        this.B = null;
        this.F = true;
        this.W = 0;
        this.X = -1;
        this.Z = null;
        this.aa = null;
        this.ab = false;
        this.ac = com.baidu.ufosdk.f.s.a("43");
        this.ad = "";
        this.ae = "";
        this.f59259a = new HashMap();
        this.af = new ag(this);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this);
            this.S = linearLayout;
            linearLayout.setId(R.id.BOTTOM_START);
            int i2 = 1;
            this.S.setOrientation(1);
            this.S.setBackgroundColor(com.baidu.ufosdk.b.z);
            String str = this.f59266h;
            int i3 = -13421773;
            float f2 = 5.0f;
            int i4 = -1;
            if (str != null && str.length() != 0) {
                try {
                    JSONArray jSONArray = new JSONArray(this.f59266h);
                    int length = jSONArray.length();
                    int i5 = 0;
                    while (i5 < length) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i5);
                        int i6 = jSONObject.getInt("type");
                        String.valueOf(i6);
                        String string = jSONObject.getString(NotificationCompatJellybean.KEY_LABEL);
                        String string2 = jSONObject.getString("placeholder");
                        String string3 = jSONObject.getString("field_key");
                        if (i6 == i2) {
                            RelativeLayout relativeLayout = new RelativeLayout(this);
                            this.T = relativeLayout;
                            relativeLayout.setBackgroundColor(i4);
                            TextView textView = new TextView(this);
                            this.U = textView;
                            textView.setTextColor(i3);
                            this.U.setTextSize(16.0f);
                            if (jSONObject.getInt("required") == i2) {
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + "*");
                                spannableStringBuilder.setSpan(new ForegroundColorSpan((int) SupportMenu.CATEGORY_MASK), string.length(), string.length() + i2, 34);
                                this.U.setText(spannableStringBuilder);
                            } else if (jSONObject.getInt("required") == 0) {
                                this.U.setText(string);
                            }
                            this.U.setGravity(16);
                            this.U.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), f2), com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), f2));
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
                            this.B = layoutParams;
                            layoutParams.addRule(9);
                            this.T.addView(this.U, this.B);
                            EditText editText = new EditText(this);
                            editText.setTextColor(-13421773);
                            editText.setTextSize(16.0f);
                            editText.setGravity(16);
                            editText.setBackgroundDrawable(null);
                            editText.setHint(string2);
                            editText.setHintTextColor(ConfirmDialog.APP_DESC_COLOR_DEFAULT);
                            editText.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 130.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f));
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
                            this.B = layoutParams2;
                            this.T.addView(editText, layoutParams2);
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
                            this.A = layoutParams3;
                            layoutParams3.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 9.0f), 0, 0);
                            this.S.addView(this.T, this.A);
                            if (jSONObject.getInt("required") == 1) {
                                this.z.add(editText);
                            }
                            editText.addTextChangedListener(new aa(this, editText, string3));
                        }
                        i5++;
                        i2 = 1;
                        i3 = -13421773;
                        f2 = 5.0f;
                        i4 = -1;
                    }
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
                    this.B = layoutParams4;
                    layoutParams4.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), 0, 0);
                    this.B.addRule(10);
                    this.l.addView(this.S, this.B);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setId(R.id.Backward);
            linearLayout2.setOrientation(1);
            linearLayout2.setBackgroundColor(com.baidu.ufosdk.b.z);
            TextView textView2 = new TextView(this);
            this.C = textView2;
            textView2.setBackgroundColor(com.baidu.ufosdk.b.z);
            this.C.setTextColor(-10066330);
            TextView textView3 = this.C;
            textView3.setText(com.baidu.ufosdk.f.s.a("48") + "*");
            this.C.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
            this.C.setTextSize(com.baidu.ufosdk.b.U - 1.0f);
            this.C.setGravity(16);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 35.0f));
            this.A = layoutParams5;
            linearLayout2.addView(this.C, layoutParams5);
            View view = new View(this);
            view.setBackgroundColor(-2236963);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            this.A = layoutParams6;
            linearLayout2.addView(view, layoutParams6);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setBackgroundColor(-1);
            EditText editText2 = new EditText(this);
            this.m = editText2;
            editText2.setId(R.id.CTRL);
            this.m.setBackgroundColor(-1);
            this.m.setTextColor(-13421773);
            this.m.setTextSize(com.baidu.ufosdk.b.U + 1.0f);
            this.m.setHintTextColor(-2236963);
            this.m.setGravity(3);
            this.m.setFilters(new InputFilter[]{new InputFilter.LengthFilter(com.baidu.ufosdk.b.aa)});
            this.m.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 13.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 13.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 120.0f));
            this.B = layoutParams7;
            layoutParams7.setMargins(com.baidu.ufosdk.f.i.a((Context) this, 2.0f), com.baidu.ufosdk.f.i.a((Context) this, 3.0f), com.baidu.ufosdk.f.i.a((Context) this, 2.0f), com.baidu.ufosdk.f.i.a((Context) this, 3.0f));
            relativeLayout2.addView(this.m, this.B);
            TextView textView4 = new TextView(this);
            this.o = textView4;
            textView4.setBackgroundColor(-1);
            this.o.setTextSize(com.baidu.ufosdk.b.V);
            this.o.setTextColor(-5131855);
            TextView textView5 = this.o;
            textView5.setText("4-" + com.baidu.ufosdk.b.aa + "字");
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
            this.B = layoutParams8;
            layoutParams8.addRule(3, this.m.getId());
            this.B.addRule(11);
            this.o.setPadding(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 14.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f));
            relativeLayout2.addView(this.o, this.B);
            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
            this.A = layoutParams9;
            linearLayout2.addView(relativeLayout2, layoutParams9);
            View view2 = new View(this);
            view2.setBackgroundColor(-2236963);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            this.A = layoutParams10;
            linearLayout2.addView(view2, layoutParams10);
            RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-1, -2);
            this.B = layoutParams11;
            layoutParams11.addRule(3, this.S.getId());
            this.l.addView(linearLayout2, this.B);
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setId(R.id.META);
            linearLayout3.setOrientation(1);
            linearLayout3.setBackgroundColor(com.baidu.ufosdk.b.z);
            TextView textView6 = new TextView(this);
            this.D = textView6;
            textView6.setBackgroundColor(com.baidu.ufosdk.b.z);
            this.D.setTextColor(-10066330);
            this.D.setText(com.baidu.ufosdk.f.s.a("46"));
            this.D.setTextSize(com.baidu.ufosdk.b.U - 1.0f);
            this.D.setGravity(16);
            this.D.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 35.0f));
            this.A = layoutParams12;
            linearLayout3.addView(this.D, layoutParams12);
            View view3 = new View(this);
            view3.setBackgroundColor(-2236963);
            LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            this.A = layoutParams13;
            linearLayout3.addView(view3, layoutParams13);
            LinearLayout linearLayout4 = new LinearLayout(this);
            this.p = linearLayout4;
            linearLayout4.setOrientation(0);
            this.p.setBackgroundColor(-1);
            this.p.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), 0);
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("shot");
            if (byteArrayExtra != null && byteArrayExtra.length > 0) {
                this.q.add(byteArrayExtra);
            }
            this.K = com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_addpic_icon.png");
            RelativeLayout relativeLayout3 = new RelativeLayout(this);
            this.L = relativeLayout3;
            relativeLayout3.setClickable(true);
            this.L.setBackgroundColor(-1);
            ImageView imageView = new ImageView(this);
            this.H = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.H.setImageBitmap(this.K);
            RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-1, -1);
            this.B = layoutParams14;
            this.L.addView(this.H, layoutParams14);
            ImageButton imageButton = new ImageButton(this);
            this.O = imageButton;
            imageButton.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_delete_selected_pic.png")));
            RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 27.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 27.0f));
            this.B = layoutParams15;
            layoutParams15.addRule(11);
            this.B.addRule(10);
            this.B.setMargins(0, 0, 0, 0);
            this.L.addView(this.O, this.B);
            this.O.setOnClickListener(new ab(this));
            RelativeLayout relativeLayout4 = new RelativeLayout(this);
            this.M = relativeLayout4;
            relativeLayout4.setClickable(true);
            this.M.setBackgroundColor(-1);
            ImageView imageView2 = new ImageView(this);
            this.I = imageView2;
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            this.I.setImageBitmap(this.K);
            RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-1, -1);
            this.B = layoutParams16;
            this.M.addView(this.I, layoutParams16);
            ImageButton imageButton2 = new ImageButton(this);
            this.P = imageButton2;
            imageButton2.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_delete_selected_pic.png")));
            RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 27.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 27.0f));
            this.B = layoutParams17;
            layoutParams17.addRule(11);
            this.B.addRule(10);
            this.B.setMargins(0, 0, 0, 0);
            this.M.addView(this.P, this.B);
            this.P.setOnClickListener(new ac(this));
            RelativeLayout relativeLayout5 = new RelativeLayout(this);
            this.N = relativeLayout5;
            relativeLayout5.setClickable(true);
            this.N.setBackgroundColor(-1);
            ImageView imageView3 = new ImageView(this);
            this.J = imageView3;
            imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
            this.J.setImageBitmap(this.K);
            RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-1, -1);
            this.B = layoutParams18;
            this.N.addView(this.J, layoutParams18);
            ImageButton imageButton3 = new ImageButton(this);
            this.Q = imageButton3;
            imageButton3.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_delete_selected_pic.png")));
            RelativeLayout.LayoutParams layoutParams19 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 27.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 27.0f));
            this.B = layoutParams19;
            layoutParams19.addRule(11);
            this.B.addRule(10);
            this.B.setMargins(0, 0, 0, 0);
            this.N.addView(this.Q, this.B);
            this.Q.setOnClickListener(new ad(this));
            LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(-1, -1);
            this.A = layoutParams20;
            layoutParams20.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 4.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 4.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f));
            LinearLayout.LayoutParams layoutParams21 = this.A;
            layoutParams21.weight = 1.0f;
            this.p.addView(this.L, layoutParams21);
            this.p.addView(this.M, this.A);
            this.p.addView(this.N, this.A);
            LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 125.0f));
            this.A = layoutParams22;
            linearLayout3.addView(this.p, layoutParams22);
            View view4 = new View(this);
            view4.setBackgroundColor(-2236963);
            LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            this.A = layoutParams23;
            linearLayout3.addView(view4, layoutParams23);
            RelativeLayout.LayoutParams layoutParams24 = new RelativeLayout.LayoutParams(-1, -2);
            this.B = layoutParams24;
            layoutParams24.addRule(3, linearLayout2.getId());
            this.l.addView(linearLayout3, this.B);
            LinearLayout linearLayout5 = new LinearLayout(this);
            linearLayout5.setId(R.id.MULTI);
            linearLayout5.setOrientation(1);
            linearLayout5.setBackgroundColor(com.baidu.ufosdk.b.z);
            TextView textView7 = new TextView(this);
            this.E = textView7;
            textView7.setBackgroundColor(com.baidu.ufosdk.b.z);
            this.E.setTextColor(-10066330);
            this.E.setText(com.baidu.ufosdk.f.s.a("47"));
            this.E.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
            this.E.setTextSize(com.baidu.ufosdk.b.U - 1.0f);
            this.E.setGravity(16);
            LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 35.0f));
            this.A = layoutParams25;
            linearLayout5.addView(this.E, layoutParams25);
            View view5 = new View(this);
            view5.setBackgroundColor(-2236963);
            LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            this.A = layoutParams26;
            linearLayout5.addView(view5, layoutParams26);
            EditText editText3 = new EditText(this);
            this.n = editText3;
            editText3.setBackgroundColor(-1);
            this.n.setTextColor(-13421773);
            this.n.setTextSize(com.baidu.ufosdk.b.U + 1.0f);
            this.n.setGravity(16);
            if (this.R.length() > 0) {
                this.n.setText(this.R);
            } else {
                this.n.setHint(com.baidu.ufosdk.f.s.a(EventType.GiftEventID.SEND_GIFT_TO_USER_FAIL));
            }
            this.n.setHintTextColor(-2236963);
            this.n.setSingleLine();
            this.n.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
            LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
            this.A = layoutParams27;
            linearLayout5.addView(this.n, layoutParams27);
            View view6 = new View(this);
            view6.setBackgroundColor(-2236963);
            LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            this.A = layoutParams28;
            linearLayout5.addView(view6, layoutParams28);
            RelativeLayout.LayoutParams layoutParams29 = new RelativeLayout.LayoutParams(-1, -2);
            this.B = layoutParams29;
            layoutParams29.addRule(3, linearLayout3.getId());
            this.l.addView(linearLayout5, this.B);
            this.m.addTextChangedListener(new ae(this));
            this.n.setFilters(new InputFilter[]{new InputFilter.LengthFilter(31)});
            this.n.addTextChangedListener(new n(this));
            this.L.setOnClickListener(new o(this));
            this.M.setOnClickListener(new p(this));
            this.N.setOnClickListener(new q(this));
            b();
        }
    }

    public static /* synthetic */ void a(FeedbackEditActivity feedbackEditActivity, int i2) {
        j jVar = new j(feedbackEditActivity);
        jVar.a(new r(feedbackEditActivity, i2, jVar));
        jVar.show();
    }

    public static /* synthetic */ void a(FeedbackEditActivity feedbackEditActivity, String str, int i2) {
        Intent intent = new Intent(feedbackEditActivity, ScreenCapEditActivity.class);
        intent.putExtra("shotUrl", str);
        feedbackEditActivity.startActivityForResult(intent, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            this.m.setEnabled(z);
            this.n.setEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{bArr, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            Intent intent = new Intent(this, ScreenCapEditActivity.class);
            intent.putExtra("shot", bArr);
            intent.putExtra("direct", z);
            startActivityForResult(intent, i2);
        }
    }

    public static byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65549, null, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            int size = this.q.size();
            if (size == 0) {
                this.H.setScaleType(ImageView.ScaleType.FIT_XY);
                this.I.setScaleType(ImageView.ScaleType.FIT_XY);
                this.J.setScaleType(ImageView.ScaleType.FIT_XY);
                Bitmap bitmap = this.K;
                if (bitmap != null) {
                    this.H.setImageBitmap(bitmap);
                    this.I.setImageBitmap(this.K);
                    this.J.setImageBitmap(this.K);
                }
                this.O.setVisibility(8);
            } else if (size != 1) {
                if (size == 2) {
                    this.H.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.I.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.J.setScaleType(ImageView.ScaleType.FIT_XY);
                    try {
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray((byte[]) this.q.get(0), 0, ((byte[]) this.q.get(0)).length);
                        Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray((byte[]) this.q.get(1), 0, ((byte[]) this.q.get(1)).length);
                        if (decodeByteArray != null) {
                            this.H.setImageBitmap(decodeByteArray);
                        }
                        if (decodeByteArray2 != null) {
                            this.I.setImageBitmap(decodeByteArray2);
                        }
                        Bitmap bitmap2 = this.K;
                        if (bitmap2 != null) {
                            this.J.setImageBitmap(bitmap2);
                        }
                        this.O.setVisibility(0);
                        this.P.setVisibility(0);
                        this.Q.setVisibility(8);
                    } catch (OutOfMemoryError unused) {
                        System.gc();
                        return;
                    }
                } else if (size != 3) {
                    return;
                } else {
                    this.H.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.I.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.J.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    try {
                        Bitmap decodeByteArray3 = BitmapFactory.decodeByteArray((byte[]) this.q.get(0), 0, ((byte[]) this.q.get(0)).length);
                        Bitmap decodeByteArray4 = BitmapFactory.decodeByteArray((byte[]) this.q.get(1), 0, ((byte[]) this.q.get(1)).length);
                        Bitmap decodeByteArray5 = BitmapFactory.decodeByteArray((byte[]) this.q.get(2), 0, ((byte[]) this.q.get(2)).length);
                        if (decodeByteArray3 != null) {
                            this.H.setImageBitmap(decodeByteArray3);
                        }
                        if (decodeByteArray4 != null) {
                            this.I.setImageBitmap(decodeByteArray4);
                        }
                        if (decodeByteArray5 != null) {
                            this.J.setImageBitmap(decodeByteArray5);
                        }
                        this.O.setVisibility(0);
                        this.P.setVisibility(0);
                        this.Q.setVisibility(0);
                        return;
                    } catch (OutOfMemoryError unused2) {
                        System.gc();
                        return;
                    }
                }
            } else {
                this.H.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.I.setScaleType(ImageView.ScaleType.FIT_XY);
                this.J.setScaleType(ImageView.ScaleType.FIT_XY);
                try {
                    Bitmap decodeByteArray6 = BitmapFactory.decodeByteArray((byte[]) this.q.get(0), 0, ((byte[]) this.q.get(0)).length);
                    if (decodeByteArray6 != null) {
                        this.H.setImageBitmap(decodeByteArray6);
                    }
                    Bitmap bitmap3 = this.K;
                    if (bitmap3 != null) {
                        this.I.setImageBitmap(bitmap3);
                        this.J.setImageBitmap(this.K);
                    }
                    this.O.setVisibility(0);
                } catch (OutOfMemoryError unused3) {
                    System.gc();
                    return;
                }
            }
            this.P.setVisibility(8);
            this.Q.setVisibility(8);
        }
    }

    public static void b(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, null, editText, i2) == null) {
            try {
                if (i2 <= com.baidu.ufosdk.b.aa) {
                    editText.setSelection(i2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static byte[] b(Bitmap bitmap) {
        InterceptResult invokeL;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, bitmap)) == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            byte[] bArr2 = null;
            byteArrayOutputStream2 = null;
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e2) {
                    e = e2;
                    bArr = null;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                com.baidu.ufosdk.f.c.a("FeedbackEditActivity --> bitMapByteArray - output.close normal");
                try {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    com.baidu.ufosdk.f.c.a("FeedbackEditActivity --> bitMapByteArray - output.close in finally");
                    return bArr2;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return bArr2;
                }
            } catch (Exception e4) {
                e = e4;
                bArr = bArr2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                e.printStackTrace();
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        com.baidu.ufosdk.f.c.a("FeedbackEditActivity --> bitMapByteArray - output.close in finally");
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        com.baidu.ufosdk.f.c.a("FeedbackEditActivity --> bitMapByteArray - output.close in finally");
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            if (this.u.getVisibility() != 0) {
                getApplicationContext();
                new af(this).execute(new Void[0]);
                return;
            }
            this.u.setVisibility(8);
            this.V.setTextColor(com.baidu.ufosdk.b.v);
            this.v = false;
            a(!false);
        }
    }

    public static /* synthetic */ void h(FeedbackEditActivity feedbackEditActivity) {
        int size;
        if (feedbackEditActivity.v) {
            return;
        }
        if (feedbackEditActivity.n.getText().toString().trim().length() > 30) {
            Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS), 0).show();
            return;
        }
        List list = feedbackEditActivity.z;
        if (list != null && (size = list.size()) != 0) {
            for (int i2 = 0; i2 < size; i2++) {
                if (feedbackEditActivity.z.get(i2) != null && ((TextView) feedbackEditActivity.z.get(i2)).getText().toString().equals("")) {
                    ((TextView) feedbackEditActivity.z.get(i2)).getText().toString();
                    Toast.makeText(feedbackEditActivity, "请输入带*的必填项", 0).show();
                    return;
                }
            }
        }
        if (feedbackEditActivity.m.getText().toString().trim().length() < 4) {
            Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a("12"), 0).show();
        } else if (feedbackEditActivity.m.getText().toString().trim().length() > com.baidu.ufosdk.b.aa) {
            Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_WAP), 0).show();
        } else if (com.baidu.ufosdk.b.d.b(feedbackEditActivity.getApplicationContext()).contains(RomUtils.UNKNOWN) || com.baidu.ufosdk.b.d.b(feedbackEditActivity.getApplicationContext()).contains("NONE")) {
            Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a(WebKitFactory.OS_64), 0).show();
        } else if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a("62"), 0).show();
            new Thread(new s(feedbackEditActivity)).start();
        } else {
            if (feedbackEditActivity.getCurrentFocus() != null && feedbackEditActivity.getCurrentFocus().getWindowToken() != null) {
                ((InputMethodManager) feedbackEditActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackEditActivity.getCurrentFocus().getWindowToken(), 2);
            }
            feedbackEditActivity.u.setVisibility(0);
            feedbackEditActivity.u.bringToFront();
            feedbackEditActivity.v = true;
            feedbackEditActivity.V.setTextColor(com.baidu.ufosdk.b.y);
            feedbackEditActivity.a(true ^ feedbackEditActivity.v);
            new Thread(new t(feedbackEditActivity)).start();
        }
    }

    public static /* synthetic */ void s(FeedbackEditActivity feedbackEditActivity) {
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
        if (feedbackEditActivity.getCurrentFocus() != null && feedbackEditActivity.getCurrentFocus().getWindowToken() != null) {
            ((InputMethodManager) feedbackEditActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackEditActivity.getCurrentFocus().getWindowToken(), 2);
        }
        try {
            feedbackEditActivity.w = true;
            feedbackEditActivity.startActivityForResult(intent, 10);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a("0"), 1).show();
        }
    }

    public static /* synthetic */ void x(FeedbackEditActivity feedbackEditActivity) {
        feedbackEditActivity.p.removeAllViews();
        feedbackEditActivity.q.clear();
        feedbackEditActivity.b();
    }

    public final boolean a(Context context, String str, String str2, String str3, String str4, String str5, Handler handler) {
        InterceptResult invokeCommon;
        Map map;
        String str6;
        Map map2;
        String str7;
        StringBuilder sb;
        String str8;
        com.baidu.ufosdk.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, str4, str5, handler})) == null) {
            if (str2.equals("newMessage") && (aVar = com.baidu.ufosdk.b.ag) != null) {
                aVar.onSubmitNewMessage();
            }
            com.baidu.ufosdk.f.c.c("url is https://ufosdk.baidu.com/?m=Index&a=postmsg");
            this.f59259a.put("clientid", str);
            this.f59259a.put("appid", UfoSDK.appid);
            this.f59259a.put("devid", UfoSDK.devid);
            this.f59259a.put("id", str2);
            this.f59259a.put("content", str3);
            this.f59259a.put("product_type", Integer.valueOf(this.W));
            this.f59259a.put("need_manual", 1);
            int i2 = com.baidu.ufosdk.f.i.a(str4) ? 1 : com.baidu.ufosdk.f.i.b(str4) ? 2 : com.baidu.ufosdk.f.i.c(str4) ? 3 : 0;
            com.baidu.ufosdk.f.c.c("contactWay is " + str4 + "; type = " + i2);
            if (i2 == 0) {
                map = this.f59259a;
                str6 = "contact_way";
            } else if (i2 == 1) {
                com.baidu.ufosdk.f.c.c("contactWay is email");
                map = this.f59259a;
                str6 = "email";
            } else if (i2 == 2) {
                com.baidu.ufosdk.f.c.c("contactWay is tel");
                map = this.f59259a;
                str6 = "tel";
            } else {
                com.baidu.ufosdk.f.c.c("contactWay is qq");
                map = this.f59259a;
                str6 = LoginConstants.QQ_LOGIN;
            }
            map.put(str6, str4);
            this.f59259a.put("brand", Build.MANUFACTURER);
            this.f59259a.put("model", Build.MODEL);
            this.f59259a.put("sdkvn", "2.9.10");
            this.f59259a.put("os", "android");
            this.f59259a.put("appvn", com.baidu.ufosdk.b.e.b());
            this.f59259a.put("freespace", String.valueOf(com.baidu.ufosdk.b.a.a()));
            this.f59259a.put("uid", com.baidu.ufosdk.b.f59171d);
            this.f59259a.put("username", com.baidu.ufosdk.b.f59169b);
            this.f59259a.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.f59171d);
            this.f59259a.put("osvn", Build.VERSION.RELEASE);
            this.f59259a.put("extra", com.baidu.ufosdk.b.f59173f);
            this.f59259a.put("extend_feedback_channel", Integer.valueOf(com.baidu.ufosdk.b.f59177j));
            this.f59259a.put("osvc", String.valueOf(com.baidu.ufosdk.f.j.a()));
            this.f59259a.put("referer", com.baidu.ufosdk.b.p);
            this.f59259a.put("baiducuid", com.baidu.ufosdk.b.f59170c);
            if (!TextUtils.isEmpty(this.f59265g)) {
                this.f59259a.put("faq_id", this.f59265g);
            }
            this.f59259a.put("phonetime", String.valueOf(System.currentTimeMillis()));
            if (com.baidu.ufosdk.f.p.a(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
                map2 = this.f59259a;
                str7 = com.baidu.ufosdk.b.d.a(context);
            } else {
                map2 = this.f59259a;
                str7 = "N/A";
            }
            map2.put("nettype", str7);
            this.f59259a.put("screenSize", com.baidu.ufosdk.b.f.a(context));
            if (com.baidu.ufosdk.b.f59168a) {
                this.f59259a.put("logcat", com.baidu.ufosdk.b.b.a());
            }
            if (!TextUtils.isEmpty(com.baidu.ufosdk.b.f59175h)) {
                this.f59259a.put("ip_location", com.baidu.ufosdk.b.f59175h);
            }
            String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(this.f59259a));
            try {
                if (TextUtils.isEmpty(str5)) {
                    sb = new StringBuilder("sdk_encrypt=");
                    sb.append(URLEncoder.encode(a2, "UTF-8"));
                } else {
                    sb = new StringBuilder("sdk_encrypt=");
                    sb.append(URLEncoder.encode(a2, "UTF-8"));
                    sb.append("&screenshot=");
                    sb.append(URLEncoder.encode(str5, "UTF-8"));
                }
                String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=postmsg", sb.toString());
                if (TextUtils.isEmpty(a3)) {
                    str8 = "response is empty, return false!";
                } else {
                    JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.f.k.b(a3));
                    com.baidu.ufosdk.f.c.a("response is -----------------> " + jSONObject.toString());
                    int intValue = ((Integer) jSONObject.get("errno")).intValue();
                    if (intValue == 0) {
                        UfoSDK.neverFeedback = false;
                        UfoSDK.lastSendTime = System.currentTimeMillis();
                        SharedPreferences.Editor edit = context.getSharedPreferences("UfoSharePreference", 0).edit();
                        edit.putBoolean("UfoNeverFeedback", false);
                        edit.putLong("Ufolastsendtime", UfoSDK.lastSendTime);
                        edit.commit();
                        handler.obtainMessage(14, String.valueOf(jSONObject.get("id"))).sendToTarget();
                        return true;
                    } else if (intValue == 4) {
                        handler.obtainMessage(19, (String) jSONObject.get("errmsg")).sendToTarget();
                        return true;
                    } else {
                        str8 = "errNo is invalid, errNo = " + intValue;
                    }
                }
                com.baidu.ufosdk.f.c.c(str8);
            } catch (Exception e2) {
                com.baidu.ufosdk.f.c.a("sendRecord fail.", e2);
            }
            this.v = false;
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
            com.baidu.ufosdk.f.c.a(" --*^o^*-- requestCode = " + i2 + "; resultCode = " + i3);
            super.onActivityResult(i2, i3, intent);
            if (!this.y) {
                com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this);
                dVar.c(dVar.c() + 1);
                this.y = true;
            }
            this.w = false;
            if (intent == null) {
                return;
            }
            if (i3 == -77 && this.q.size() > 0) {
                List list = this.q;
                list.remove(list.size() - 1);
                this.af.obtainMessage(17).sendToTarget();
            }
            if (i2 != 10 && i3 == -1) {
                String stringExtra = intent.getStringExtra("shotUrl");
                byte[] byteArrayExtra = intent.getByteArrayExtra("shot");
                if (byteArrayExtra == null || byteArrayExtra.length <= 0) {
                    if (stringExtra == null || stringExtra.length() <= 0) {
                        return;
                    }
                    new Thread(new x(this, stringExtra, i2)).start();
                    return;
                }
                try {
                    if (this.q.size() == 0) {
                        this.q.add(byteArrayExtra);
                    } else {
                        this.q.set(i2, byteArrayExtra);
                    }
                } catch (Exception e2) {
                    com.baidu.ufosdk.f.c.a("set ArrayList error!", e2);
                }
                this.af.obtainMessage(17).sendToTarget();
                return;
            }
            Uri data = intent.getData();
            if (data == null) {
                return;
            }
            InputStream inputStream = null;
            try {
                try {
                    InputStream openInputStream = getContentResolver().openInputStream(data);
                    if (openInputStream.available() >= 8388608) {
                        Toast.makeText(this, com.baidu.ufosdk.f.s.a("21"), 1).show();
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                        return;
                    }
                    byte[] a2 = a(openInputStream);
                    if (a2 == null) {
                        Toast.makeText(this, com.baidu.ufosdk.f.s.a("21"), 1).show();
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                                return;
                            } catch (Exception unused2) {
                                return;
                            }
                        }
                        return;
                    }
                    byte[] a3 = com.baidu.ufosdk.f.q.a(a2);
                    if (a3 == null) {
                        Toast.makeText(this, com.baidu.ufosdk.f.s.a("21"), 1).show();
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                    } else if (a3.length > 307200) {
                        Toast.makeText(this, com.baidu.ufosdk.f.s.a("21"), 1).show();
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                    } else {
                        if (a3.length != 0) {
                            this.q.add(a3);
                            a(a3, true, this.q.size() - 1);
                        } else {
                            Toast.makeText(this, "图片错误，请重新选择一张。", 1).show();
                        }
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                            } catch (Exception unused5) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception unused6) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                com.baidu.ufosdk.f.c.a("OnActivity Result Error!", e3);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception unused7) {
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            getWindow().setSoftInputMode(32);
            com.baidu.ufosdk.f.r.a(this, getWindow());
            com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
            SharedPreferences sharedPreferences = getSharedPreferences("UfoSharePreference", 0);
            this.f59261c = sharedPreferences;
            String string = sharedPreferences.getString("cryptContactData", "");
            if (string == null || string.trim().length() <= 0) {
                this.R = "";
            } else {
                this.R = com.baidu.ufosdk.f.k.b(string);
            }
            this.f59260b = this.f59261c.edit();
            this.f59265g = getIntent().getStringExtra("faq_id");
            this.t = getIntent().getStringExtra("msgid");
            this.W = getIntent().getIntExtra("product_type", 0);
            this.X = getIntent().getIntExtra("come_from", -1);
            this.Y = getIntent().getIntExtra("extend_feedback_channel", -1);
            if (this.X == 2) {
                this.f59266h = "";
                str = "43";
            } else {
                str = "10";
            }
            this.ac = com.baidu.ufosdk.f.s.a(str);
            if (this.W != 0 && this.X == 1) {
                new Thread(new m(this)).start();
            }
            if (this.Y != -1) {
                new Thread(new w(this)).start();
            }
            String b2 = com.baidu.ufosdk.f.i.b(System.currentTimeMillis());
            com.baidu.ufosdk.f.c.c("--FeedbackEdit:364--today:" + b2 + "; startStr:" + UfoSDK.startStr);
            String str2 = UfoSDK.startStr;
            if (str2.equals(b2 + "-enable")) {
                if (!this.f59261c.getBoolean("editFeedbackViewUV_has", false)) {
                    this.f59260b.putInt("editFeedbackViewUV", this.f59261c.getInt("editFeedbackViewUV", 0) + 1);
                    this.f59260b.putBoolean("editFeedbackViewUV_has", true);
                }
                this.f59260b.commit();
            }
            if (this.X == 1) {
                this.f59266h = "";
                String str3 = UfoSDK.startStr;
                if (str3.equals(b2 + "-enable")) {
                    if (!this.f59261c.getBoolean("editFeedbackViewFromFaqUV_has", false)) {
                        this.f59260b.putInt("editFeedbackViewFromFaqUV", this.f59261c.getInt("editFeedbackViewFromFaqUV", 0) + 1);
                        this.f59260b.putBoolean("editFeedbackViewFromFaqUV_has", true);
                    }
                    this.f59260b.commit();
                }
            }
            if (this.X == 0) {
                this.ae = getIntent().getStringExtra("im_content");
                this.f59266h = getIntent().getStringExtra("data_array");
                String str4 = UfoSDK.startStr;
                if (str4.equals(b2 + "-enable")) {
                    if (!this.f59261c.getBoolean("editFeedbackViewFromRobotUV_has", false)) {
                        this.f59260b.putInt("editFeedbackViewFromRobotUV", this.f59261c.getInt("editFeedbackViewFromRobotUV", 0) + 1);
                        this.f59260b.putBoolean("editFeedbackViewFromRobotUV_has", true);
                    }
                    this.f59260b.commit();
                }
            }
            if (TextUtils.isEmpty(this.t)) {
                this.t = "newMessage";
            }
            if (TextUtils.isEmpty(this.f59265g)) {
                this.f59265g = "";
            }
            this.f59260b.putBoolean("ADD_PIC_FLAG", true);
            this.f59260b.commit();
            int intExtra = getIntent().getIntExtra("feedback_channel", 0);
            this.f59264f = intExtra;
            com.baidu.ufosdk.b.f59177j = intExtra;
            this.z = new ArrayList();
            this.G = new ScrollView(this);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.f59267i = relativeLayout;
            relativeLayout.setFitsSystemWindows(true);
            this.f59267i.setId(R.drawable.res_0x7f080004_avd_show_password__1);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setId(R.id.BLOCK);
            this.f59267i.setBackgroundColor(com.baidu.ufosdk.b.z);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
            this.A = layoutParams;
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0, 0, 0);
            ImageView imageView = new ImageView(this);
            this.f59268j = imageView;
            imageView.setId(R.drawable.res_0x7f080001_avd_hide_password__1);
            this.f59268j.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f59268j.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_back_icon_browser.png")));
            linearLayout.addView(this.f59268j, this.A);
            TextView textView = new TextView(this);
            textView.setText(com.baidu.ufosdk.b.f59176i);
            textView.setTextSize(com.baidu.ufosdk.b.M);
            textView.setTextColor(com.baidu.ufosdk.b.H);
            textView.setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            this.A = layoutParams2;
            layoutParams2.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
            linearLayout.addView(textView, this.A);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            this.B = layoutParams3;
            layoutParams3.addRule(9);
            this.B.addRule(15);
            relativeLayout2.addView(linearLayout, this.B);
            TextView textView2 = new TextView(this);
            this.k = textView2;
            textView2.setId(R.drawable.res_0x7f080002_avd_hide_password__2);
            this.k.setText(this.ac);
            this.k.setTextColor(com.baidu.ufosdk.b.r);
            this.k.setTextSize(com.baidu.ufosdk.b.T);
            this.k.setGravity(17);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
            this.B = layoutParams4;
            layoutParams4.addRule(13);
            relativeLayout2.addView(this.k, this.B);
            this.V = new Button(this);
            if (getIntent().getIntExtra("continue", 0) == 1) {
                this.V.setVisibility(4);
            }
            this.V.setText(com.baidu.ufosdk.f.s.a("37"));
            this.V.setId(R.id.BOTTOM_END);
            String str5 = this.ae;
            if (str5 == null || str5.length() < 4) {
                this.V.setTextColor(com.baidu.ufosdk.b.y);
            } else {
                Button button = this.V;
                int i2 = com.baidu.ufosdk.b.v;
                int i3 = com.baidu.ufosdk.b.y;
                int i4 = com.baidu.ufosdk.b.v;
                button.setTextColor(com.baidu.ufosdk.f.i.a(i2, i3, i4, i4));
            }
            this.V.setTextColor(com.baidu.ufosdk.b.y);
            this.V.setTextSize(com.baidu.ufosdk.b.U);
            this.V.setGravity(17);
            this.V.setBackgroundColor(16777215);
            this.V.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -1);
            this.B = layoutParams5;
            layoutParams5.addRule(11);
            this.B.addRule(15);
            relativeLayout2.addView(this.V, this.B);
            relativeLayout2.setBackgroundColor(com.baidu.ufosdk.b.A);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
            this.B = layoutParams6;
            layoutParams6.addRule(10);
            this.f59267i.addView(relativeLayout2, this.B);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -1);
            this.A = layoutParams7;
            layoutParams7.weight = 1.0f;
            View view = new View(this);
            view.setId(133201936);
            view.setBackgroundColor(-2894893);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            this.B = layoutParams8;
            layoutParams8.addRule(3, relativeLayout2.getId());
            this.f59267i.addView(view, this.B);
            RelativeLayout relativeLayout3 = new RelativeLayout(this);
            this.l = relativeLayout3;
            relativeLayout3.setId(R.drawable.res_0x7f080005_avd_show_password__2);
            this.l.setBackgroundColor(com.baidu.ufosdk.b.z);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -1);
            this.B = layoutParams9;
            layoutParams9.addRule(3, view.getId());
            this.G.addView(this.l);
            this.f59267i.addView(this.G, this.B);
            this.u = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a("25"));
            RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
            this.B = layoutParams10;
            layoutParams10.addRule(13);
            this.l.addView(this.u, this.B);
            this.u.setVisibility(8);
            linearLayout.setOnClickListener(new y(this));
            this.V.setOnClickListener(new z(this));
            this.q = new ArrayList();
            this.r = new HashMap();
            a();
            setContentView(this.f59267i);
            try {
                com.baidu.ufosdk.f.c.d("执行动画...");
                overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_out_to_left"));
            } catch (Exception unused) {
                com.baidu.ufosdk.f.c.d("exit!");
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                c();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onPause() {
        SharedPreferences.Editor editor;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPause();
            String obj = this.n.getText().toString();
            if (obj == null || obj.trim().length() <= 0) {
                this.f59260b.putString("cryptContactData", "");
            } else {
                this.f59260b.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
            }
            if (this.s.booleanValue()) {
                if (TextUtils.isEmpty(this.f59265g)) {
                    editor = this.f59260b;
                    str = this.t;
                } else {
                    editor = this.f59260b;
                    str = this.f59265g;
                }
                editor.putString(str, this.m.getText().toString());
            }
            this.f59260b.commit();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        EditText editText;
        String str;
        SharedPreferences sharedPreferences;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            if (TextUtils.isEmpty(UfoSDK.clientid)) {
                SharedPreferences sharedPreferences2 = getSharedPreferences("UfoSharePreference", 0);
                UfoSDK.clientid = sharedPreferences2.getString("UfoClientId", "");
                UfoSDK.appid = sharedPreferences2.getString("UfoAppId", "");
                UfoSDK.devid = sharedPreferences2.getString("UfoDevId", "");
                UfoSDK.productid = sharedPreferences2.getString("UfoProductId", "");
            }
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this);
            dVar.a(dVar.a() + 1);
            ResumeCallBack resumeCallBack = com.baidu.ufosdk.b.ac;
            if (resumeCallBack != null) {
                resumeCallBack.onResumeCallback();
            }
            String a2 = com.baidu.ufosdk.f.s.a("43");
            this.ac = a2;
            this.k.setText(a2);
            this.V.setText(com.baidu.ufosdk.f.s.a("37"));
            TextView textView = this.C;
            textView.setText(com.baidu.ufosdk.f.s.a("48") + "*");
            this.D.setText(com.baidu.ufosdk.f.s.a("46"));
            this.E.setText(com.baidu.ufosdk.f.s.a("47"));
            if (this.R.length() > 0) {
                this.n.setText(this.R);
            } else {
                this.n.setHint(com.baidu.ufosdk.f.s.a(EventType.GiftEventID.SEND_GIFT_TO_USER_FAIL));
            }
            if ("".equals(com.baidu.ufosdk.b.n)) {
                editText = this.m;
                str = com.baidu.ufosdk.f.s.a("6");
            } else {
                editText = this.m;
                str = com.baidu.ufosdk.b.n;
            }
            editText.setHint(str);
            com.baidu.ufosdk.f.i.a((RelativeLayout) this.u, com.baidu.ufosdk.f.s.a("25"));
            this.V.setTextSize(com.baidu.ufosdk.b.U);
            this.s = Boolean.TRUE;
            String str3 = this.t;
            if (str3 == null || str3.length() == 0) {
                this.t = "newMessage";
            }
            if (this.X == 0 && this.F) {
                this.F = false;
                if (this.ae.length() > 0) {
                    int length = this.ae.length();
                    int i2 = com.baidu.ufosdk.b.aa;
                    if (length > i2) {
                        this.ae = this.ae.substring(0, i2 - 1);
                    }
                    this.m.setText(this.ae);
                    b(this.m, this.ae.length());
                }
            } else {
                if (TextUtils.isEmpty(this.f59265g)) {
                    sharedPreferences = this.f59261c;
                    str2 = this.t;
                } else {
                    sharedPreferences = this.f59261c;
                    str2 = this.f59265g;
                }
                String string = sharedPreferences.getString(str2, "");
                if (string.length() > 0) {
                    int length2 = string.length();
                    int i3 = com.baidu.ufosdk.b.aa;
                    if (length2 > i3) {
                        string = string.substring(0, i3 - 1);
                    }
                    this.m.setText(string);
                    b(this.m, string.length());
                }
            }
            String string2 = this.f59261c.getString("cryptContactData", "");
            if (string2 == null || string2.trim().length() <= 0) {
                this.n.setText("");
            } else {
                this.n.setText(com.baidu.ufosdk.f.k.b(string2));
            }
            (UfoSDK.clientid.length() == 0 ? new Thread(new u(this)) : new Thread(new v(this))).start();
        }
    }
}
