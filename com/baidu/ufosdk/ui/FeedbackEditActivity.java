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
import android.util.Log;
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
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tieba.R;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.screencapedt.ScreenCapEditActivity;
import com.tencent.connect.common.Constants;
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
    private TextView C;
    private TextView D;
    private TextView E;
    private ScrollView G;
    private ImageView H;
    private ImageView I;
    private ImageView J;
    private Bitmap K;
    private RelativeLayout L;
    private RelativeLayout M;
    private RelativeLayout N;
    private ImageButton O;
    private ImageButton P;
    private ImageButton Q;
    private String R;
    private LinearLayout S;
    private RelativeLayout T;
    private TextView U;
    private Button V;
    private int Y;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f5689b;
    private SharedPreferences c;
    private RelativeLayout i;
    private ImageView j;
    private TextView k;
    private RelativeLayout l;
    private EditText m;
    private EditText n;
    private TextView o;
    private LinearLayout p;
    private List q;
    private HashMap r;
    private String t;
    private View u;
    private List z;
    private String d = "";
    private String e = "";
    private int f = 0;
    private String g = "";
    private String h = "";
    private Boolean s = true;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private LinearLayout.LayoutParams A = null;
    private RelativeLayout.LayoutParams B = null;
    private boolean F = true;
    private int W = 0;
    private int X = -1;
    private String Z = null;
    private String aa = null;
    private boolean ab = false;
    private String ac = com.baidu.ufosdk.f.s.a("43");
    private String ad = "";
    private String ae = "";

    /* renamed from: a  reason: collision with root package name */
    public Map f5688a = new HashMap();
    private Handler af = new ag(this);

    private void a() {
        this.S = new LinearLayout(this);
        this.S.setId(R.id.Emoji_GridView);
        this.S.setOrientation(1);
        this.S.setBackgroundColor(com.baidu.ufosdk.b.z);
        if (this.h != null && this.h.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray(this.h);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    int i2 = jSONObject.getInt("type");
                    Log.d("type====", String.valueOf(i2));
                    String string = jSONObject.getString("label");
                    Log.d("leftContent====", string);
                    String string2 = jSONObject.getString("placeholder");
                    String string3 = jSONObject.getString("field_key");
                    if (i2 == 1) {
                        this.T = new RelativeLayout(this);
                        this.T.setBackgroundColor(-1);
                        this.U = new TextView(this);
                        this.U.setTextColor(-13421773);
                        this.U.setTextSize(16.0f);
                        if (jSONObject.getInt("required") == 1) {
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + "*");
                            spannableStringBuilder.setSpan(new ForegroundColorSpan((int) SupportMenu.CATEGORY_MASK), string.length(), string.length() + 1, 34);
                            this.U.setText(spannableStringBuilder);
                        } else if (jSONObject.getInt("required") == 0) {
                            this.U.setText(string);
                        }
                        this.U.setGravity(16);
                        this.U.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
                        this.B = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
                        this.B.addRule(9);
                        this.T.addView(this.U, this.B);
                        EditText editText = new EditText(this);
                        editText.setTextColor(-13421773);
                        editText.setTextSize(16.0f);
                        editText.setGravity(16);
                        editText.setBackgroundDrawable(null);
                        editText.setHint(string2);
                        editText.setHintTextColor(-6710887);
                        editText.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 130.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f));
                        this.B = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
                        this.T.addView(editText, this.B);
                        this.A = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
                        this.A.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 9.0f), 0, 0);
                        this.S.addView(this.T, this.A);
                        if (jSONObject.getInt("required") == 1) {
                            this.z.add(editText);
                        }
                        editText.addTextChangedListener(new aa(this, editText, string3));
                    }
                }
                this.B = new RelativeLayout.LayoutParams(-1, -2);
                this.B.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), 0, 0);
                this.B.addRule(10);
                this.l.addView(this.S, this.B);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(R.id.FILL);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(com.baidu.ufosdk.b.z);
        this.C = new TextView(this);
        this.C.setBackgroundColor(com.baidu.ufosdk.b.z);
        this.C.setTextColor(-10066330);
        this.C.setText(com.baidu.ufosdk.f.s.a("48") + "*");
        this.C.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
        this.C.setTextSize(com.baidu.ufosdk.b.U - 1.0f);
        this.C.setGravity(16);
        this.A = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 35.0f));
        linearLayout.addView(this.C, this.A);
        View view = new View(this);
        view.setBackgroundColor(-2236963);
        this.A = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        linearLayout.addView(view, this.A);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        this.m = new EditText(this);
        this.m.setId(R.id.FUNCTION);
        this.m.setBackgroundColor(-1);
        this.m.setTextColor(-13421773);
        this.m.setTextSize(com.baidu.ufosdk.b.U + 1.0f);
        this.m.setHintTextColor(-2236963);
        this.m.setGravity(3);
        this.m.setFilters(new InputFilter[]{new InputFilter.LengthFilter(com.baidu.ufosdk.b.aa)});
        this.m.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 13.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 13.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        this.B = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 120.0f));
        this.B.setMargins(com.baidu.ufosdk.f.i.a((Context) this, 2.0f), com.baidu.ufosdk.f.i.a((Context) this, 3.0f), com.baidu.ufosdk.f.i.a((Context) this, 2.0f), com.baidu.ufosdk.f.i.a((Context) this, 3.0f));
        relativeLayout.addView(this.m, this.B);
        this.o = new TextView(this);
        this.o.setBackgroundColor(-1);
        this.o.setTextSize(com.baidu.ufosdk.b.V);
        this.o.setTextColor(-5131855);
        this.o.setText("4-" + com.baidu.ufosdk.b.aa + "字");
        this.B = new RelativeLayout.LayoutParams(-2, -2);
        this.B.addRule(3, this.m.getId());
        this.B.addRule(11);
        this.o.setPadding(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 14.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f));
        relativeLayout.addView(this.o, this.B);
        this.A = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.addView(relativeLayout, this.A);
        View view2 = new View(this);
        view2.setBackgroundColor(-2236963);
        this.A = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        linearLayout.addView(view2, this.A);
        this.B = new RelativeLayout.LayoutParams(-1, -2);
        this.B.addRule(3, this.S.getId());
        this.l.addView(linearLayout, this.B);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setId(R.id.SELECT);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(com.baidu.ufosdk.b.z);
        this.D = new TextView(this);
        this.D.setBackgroundColor(com.baidu.ufosdk.b.z);
        this.D.setTextColor(-10066330);
        this.D.setText(com.baidu.ufosdk.f.s.a("46"));
        this.D.setTextSize(com.baidu.ufosdk.b.U - 1.0f);
        this.D.setGravity(16);
        this.D.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
        this.A = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 35.0f));
        linearLayout2.addView(this.D, this.A);
        View view3 = new View(this);
        view3.setBackgroundColor(-2236963);
        this.A = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        linearLayout2.addView(view3, this.A);
        this.p = new LinearLayout(this);
        this.p.setOrientation(0);
        this.p.setBackgroundColor(-1);
        this.p.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), 0);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("shot");
        if (byteArrayExtra != null && byteArrayExtra.length > 0) {
            this.q.add(byteArrayExtra);
        }
        this.K = com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_addpic_icon.png");
        this.L = new RelativeLayout(this);
        this.L.setClickable(true);
        this.L.setBackgroundColor(-1);
        this.H = new ImageView(this);
        this.H.setScaleType(ImageView.ScaleType.FIT_XY);
        this.H.setImageBitmap(this.K);
        this.B = new RelativeLayout.LayoutParams(-1, -1);
        this.L.addView(this.H, this.B);
        this.O = new ImageButton(this);
        this.O.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_delete_selected_pic.png")));
        this.B = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 27.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 27.0f));
        this.B.addRule(11);
        this.B.addRule(10);
        this.B.setMargins(0, 0, 0, 0);
        this.L.addView(this.O, this.B);
        this.O.setOnClickListener(new ab(this));
        this.M = new RelativeLayout(this);
        this.M.setClickable(true);
        this.M.setBackgroundColor(-1);
        this.I = new ImageView(this);
        this.I.setScaleType(ImageView.ScaleType.FIT_XY);
        this.I.setImageBitmap(this.K);
        this.B = new RelativeLayout.LayoutParams(-1, -1);
        this.M.addView(this.I, this.B);
        this.P = new ImageButton(this);
        this.P.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_delete_selected_pic.png")));
        this.B = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 27.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 27.0f));
        this.B.addRule(11);
        this.B.addRule(10);
        this.B.setMargins(0, 0, 0, 0);
        this.M.addView(this.P, this.B);
        this.P.setOnClickListener(new ac(this));
        this.N = new RelativeLayout(this);
        this.N.setClickable(true);
        this.N.setBackgroundColor(-1);
        this.J = new ImageView(this);
        this.J.setScaleType(ImageView.ScaleType.FIT_XY);
        this.J.setImageBitmap(this.K);
        this.B = new RelativeLayout.LayoutParams(-1, -1);
        this.N.addView(this.J, this.B);
        this.Q = new ImageButton(this);
        this.Q.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_delete_selected_pic.png")));
        this.B = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 27.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 27.0f));
        this.B.addRule(11);
        this.B.addRule(10);
        this.B.setMargins(0, 0, 0, 0);
        this.N.addView(this.Q, this.B);
        this.Q.setOnClickListener(new ad(this));
        this.A = new LinearLayout.LayoutParams(-1, -1);
        this.A.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 4.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 4.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f));
        this.A.weight = 1.0f;
        this.p.addView(this.L, this.A);
        this.p.addView(this.M, this.A);
        this.p.addView(this.N, this.A);
        this.A = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 125.0f));
        linearLayout2.addView(this.p, this.A);
        View view4 = new View(this);
        view4.setBackgroundColor(-2236963);
        this.A = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        linearLayout2.addView(view4, this.A);
        this.B = new RelativeLayout.LayoutParams(-1, -2);
        this.B.addRule(3, linearLayout.getId());
        this.l.addView(linearLayout2, this.B);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setId(R.id.SHIFT);
        linearLayout3.setOrientation(1);
        linearLayout3.setBackgroundColor(com.baidu.ufosdk.b.z);
        this.E = new TextView(this);
        this.E.setBackgroundColor(com.baidu.ufosdk.b.z);
        this.E.setTextColor(-10066330);
        this.E.setText(com.baidu.ufosdk.f.s.a("47"));
        this.E.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
        this.E.setTextSize(com.baidu.ufosdk.b.U - 1.0f);
        this.E.setGravity(16);
        this.A = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 35.0f));
        linearLayout3.addView(this.E, this.A);
        View view5 = new View(this);
        view5.setBackgroundColor(-2236963);
        this.A = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        linearLayout3.addView(view5, this.A);
        this.n = new EditText(this);
        this.n.setBackgroundColor(-1);
        this.n.setTextColor(-13421773);
        this.n.setTextSize(com.baidu.ufosdk.b.U + 1.0f);
        this.n.setGravity(16);
        if (this.R.length() > 0) {
            this.n.setText(this.R);
        } else {
            this.n.setHint(com.baidu.ufosdk.f.s.a("31"));
        }
        this.n.setHintTextColor(-2236963);
        this.n.setSingleLine();
        this.n.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        this.A = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
        linearLayout3.addView(this.n, this.A);
        View view6 = new View(this);
        view6.setBackgroundColor(-2236963);
        this.A = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        linearLayout3.addView(view6, this.A);
        this.B = new RelativeLayout.LayoutParams(-1, -2);
        this.B.addRule(3, linearLayout2.getId());
        this.l.addView(linearLayout3, this.B);
        this.m.addTextChangedListener(new ae(this));
        this.n.setFilters(new InputFilter[]{new InputFilter.LengthFilter(31)});
        this.n.addTextChangedListener(new n(this));
        this.L.setOnClickListener(new o(this));
        this.M.setOnClickListener(new p(this));
        this.N.setOnClickListener(new q(this));
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FeedbackEditActivity feedbackEditActivity, int i) {
        j jVar = new j(feedbackEditActivity);
        jVar.a(new r(feedbackEditActivity, i, jVar));
        jVar.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FeedbackEditActivity feedbackEditActivity, String str, int i) {
        Intent intent = new Intent(feedbackEditActivity, ScreenCapEditActivity.class);
        intent.putExtra("shotUrl", str);
        feedbackEditActivity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.m.setEnabled(z);
        this.n.setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, boolean z, int i) {
        Intent intent = new Intent(this, ScreenCapEditActivity.class);
        intent.putExtra("shot", bArr);
        intent.putExtra(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, z);
        startActivityForResult(intent, i);
    }

    private static byte[] a(InputStream inputStream) {
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
        switch (this.q.size()) {
            case 0:
                this.H.setScaleType(ImageView.ScaleType.FIT_XY);
                this.I.setScaleType(ImageView.ScaleType.FIT_XY);
                this.J.setScaleType(ImageView.ScaleType.FIT_XY);
                if (this.K != null) {
                    this.H.setImageBitmap(this.K);
                    this.I.setImageBitmap(this.K);
                    this.J.setImageBitmap(this.K);
                }
                this.O.setVisibility(8);
                this.P.setVisibility(8);
                this.Q.setVisibility(8);
                return;
            case 1:
                this.H.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.I.setScaleType(ImageView.ScaleType.FIT_XY);
                this.J.setScaleType(ImageView.ScaleType.FIT_XY);
                try {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray((byte[]) this.q.get(0), 0, ((byte[]) this.q.get(0)).length);
                    if (decodeByteArray != null) {
                        this.H.setImageBitmap(decodeByteArray);
                    }
                    if (this.K != null) {
                        this.I.setImageBitmap(this.K);
                        this.J.setImageBitmap(this.K);
                    }
                    this.O.setVisibility(0);
                    this.P.setVisibility(8);
                    this.Q.setVisibility(8);
                    return;
                } catch (OutOfMemoryError e) {
                    System.gc();
                    return;
                }
            case 2:
                this.H.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.I.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.J.setScaleType(ImageView.ScaleType.FIT_XY);
                try {
                    Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray((byte[]) this.q.get(0), 0, ((byte[]) this.q.get(0)).length);
                    Bitmap decodeByteArray3 = BitmapFactory.decodeByteArray((byte[]) this.q.get(1), 0, ((byte[]) this.q.get(1)).length);
                    if (decodeByteArray2 != null) {
                        this.H.setImageBitmap(decodeByteArray2);
                    }
                    if (decodeByteArray3 != null) {
                        this.I.setImageBitmap(decodeByteArray3);
                    }
                    if (this.K != null) {
                        this.J.setImageBitmap(this.K);
                    }
                    this.O.setVisibility(0);
                    this.P.setVisibility(0);
                    this.Q.setVisibility(8);
                    return;
                } catch (OutOfMemoryError e2) {
                    System.gc();
                    return;
                }
            case 3:
                this.H.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.I.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.J.setScaleType(ImageView.ScaleType.CENTER_CROP);
                try {
                    Bitmap decodeByteArray4 = BitmapFactory.decodeByteArray((byte[]) this.q.get(0), 0, ((byte[]) this.q.get(0)).length);
                    Bitmap decodeByteArray5 = BitmapFactory.decodeByteArray((byte[]) this.q.get(1), 0, ((byte[]) this.q.get(1)).length);
                    Bitmap decodeByteArray6 = BitmapFactory.decodeByteArray((byte[]) this.q.get(2), 0, ((byte[]) this.q.get(2)).length);
                    if (decodeByteArray4 != null) {
                        this.H.setImageBitmap(decodeByteArray4);
                    }
                    if (decodeByteArray5 != null) {
                        this.I.setImageBitmap(decodeByteArray5);
                    }
                    if (decodeByteArray6 != null) {
                        this.J.setImageBitmap(decodeByteArray6);
                    }
                    this.O.setVisibility(0);
                    this.P.setVisibility(0);
                    this.Q.setVisibility(0);
                    return;
                } catch (OutOfMemoryError e3) {
                    System.gc();
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(EditText editText, int i) {
        try {
            if (i <= com.baidu.ufosdk.b.aa) {
                editText.setSelection(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        com.baidu.ufosdk.f.c.a("FeedbackEditActivity --> bitMapByteArray - output.close normal");
                        try {
                            byteArrayOutputStream.flush();
                            byteArrayOutputStream.close();
                            com.baidu.ufosdk.f.c.a("FeedbackEditActivity --> bitMapByteArray - output.close in finally");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.flush();
                                byteArrayOutputStream.close();
                                com.baidu.ufosdk.f.c.a("FeedbackEditActivity --> bitMapByteArray - output.close in finally");
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        return bArr;
                    }
                } catch (Exception e4) {
                    e = e4;
                    bArr = null;
                }
            } catch (Throwable th) {
                th = th;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        com.baidu.ufosdk.f.c.a("FeedbackEditActivity --> bitMapByteArray - output.close in finally");
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            byteArrayOutputStream = null;
            bArr = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.u.getVisibility() != 0) {
            getApplicationContext();
            new af(this).execute(new Void[0]);
            return;
        }
        this.u.setVisibility(8);
        this.V.setTextColor(com.baidu.ufosdk.b.v);
        this.v = false;
        a(this.v ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(FeedbackEditActivity feedbackEditActivity) {
        int size;
        if (feedbackEditActivity.v) {
            return;
        }
        if (feedbackEditActivity.n.getText().toString().trim().length() > 30) {
            Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a("32"), 0).show();
            return;
        }
        if (feedbackEditActivity.z != null && (size = feedbackEditActivity.z.size()) != 0) {
            for (int i = 0; i < size; i++) {
                if (feedbackEditActivity.z.get(i) != null && ((TextView) feedbackEditActivity.z.get(i)).getText().toString().equals("")) {
                    Log.d("content", ((TextView) feedbackEditActivity.z.get(i)).getText().toString());
                    Toast.makeText(feedbackEditActivity, "请输入带*的必填项", 0).show();
                    return;
                }
            }
        }
        if (feedbackEditActivity.m.getText().toString().trim().length() < 4) {
            Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_SET_AVATAR), 0).show();
        } else if (feedbackEditActivity.m.getText().toString().trim().length() > com.baidu.ufosdk.b.aa) {
            Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_WAP), 0).show();
        } else if (com.baidu.ufosdk.b.d.b(feedbackEditActivity.getApplicationContext()).contains(RomUtils.UNKNOWN) || com.baidu.ufosdk.b.d.b(feedbackEditActivity.getApplicationContext()).contains("NONE")) {
            Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a("64"), 0).show();
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
            feedbackEditActivity.a(!feedbackEditActivity.v);
            new Thread(new t(feedbackEditActivity)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void s(FeedbackEditActivity feedbackEditActivity) {
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        if (feedbackEditActivity.getCurrentFocus() != null && feedbackEditActivity.getCurrentFocus().getWindowToken() != null) {
            ((InputMethodManager) feedbackEditActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackEditActivity.getCurrentFocus().getWindowToken(), 2);
        }
        try {
            feedbackEditActivity.w = true;
            feedbackEditActivity.startActivityForResult(intent, 10);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a("0"), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void x(FeedbackEditActivity feedbackEditActivity) {
        feedbackEditActivity.p.removeAllViews();
        feedbackEditActivity.q.clear();
        feedbackEditActivity.b();
    }

    public final boolean a(Context context, String str, String str2, String str3, String str4, String str5, Handler handler) {
        if (str2.equals("newMessage") && com.baidu.ufosdk.b.ag != null) {
            com.baidu.ufosdk.b.ag.onSubmitNewMessage();
        }
        com.baidu.ufosdk.f.c.c("url is https://ufosdk.baidu.com/?m=Index&a=postmsg");
        this.f5688a.put("clientid", str);
        this.f5688a.put("appid", UfoSDK.appid);
        this.f5688a.put("devid", UfoSDK.devid);
        this.f5688a.put("id", str2);
        this.f5688a.put("content", str3);
        this.f5688a.put("product_type", Integer.valueOf(this.W));
        this.f5688a.put("need_manual", 1);
        int i = com.baidu.ufosdk.f.i.a(str4) ? 1 : com.baidu.ufosdk.f.i.b(str4) ? 2 : com.baidu.ufosdk.f.i.c(str4) ? 3 : 0;
        com.baidu.ufosdk.f.c.c("contactWay is " + str4 + "; type = " + i);
        if (i == 0) {
            this.f5688a.put("contact_way", str4);
        } else if (i == 1) {
            com.baidu.ufosdk.f.c.c("contactWay is email");
            this.f5688a.put(NotificationCompat.CATEGORY_EMAIL, str4);
        } else if (i == 2) {
            com.baidu.ufosdk.f.c.c("contactWay is tel");
            this.f5688a.put("tel", str4);
        } else {
            com.baidu.ufosdk.f.c.c("contactWay is qq");
            this.f5688a.put("qq", str4);
        }
        this.f5688a.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, Build.MANUFACTURER);
        this.f5688a.put("model", Build.MODEL);
        this.f5688a.put("sdkvn", "2.9.10");
        this.f5688a.put("os", HttpConstants.OS_TYPE_VALUE);
        this.f5688a.put("appvn", com.baidu.ufosdk.b.e.b());
        this.f5688a.put("freespace", String.valueOf(com.baidu.ufosdk.b.a.a()));
        this.f5688a.put("uid", com.baidu.ufosdk.b.d);
        this.f5688a.put("username", com.baidu.ufosdk.b.f5638b);
        this.f5688a.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.d);
        this.f5688a.put("osvn", Build.VERSION.RELEASE);
        this.f5688a.put("extra", com.baidu.ufosdk.b.f);
        this.f5688a.put("extend_feedback_channel", Integer.valueOf(com.baidu.ufosdk.b.j));
        this.f5688a.put("osvc", String.valueOf(com.baidu.ufosdk.f.j.a()));
        this.f5688a.put(Config.LAUNCH_REFERER, com.baidu.ufosdk.b.p);
        this.f5688a.put("baiducuid", com.baidu.ufosdk.b.c);
        if (!TextUtils.isEmpty(this.g)) {
            this.f5688a.put("faq_id", this.g);
        }
        this.f5688a.put("phonetime", String.valueOf(System.currentTimeMillis()));
        if (com.baidu.ufosdk.f.p.a("android.permission.ACCESS_NETWORK_STATE")) {
            this.f5688a.put("nettype", com.baidu.ufosdk.b.d.a(context));
        } else {
            this.f5688a.put("nettype", "N/A");
        }
        this.f5688a.put("screenSize", com.baidu.ufosdk.b.f.a(context));
        if (com.baidu.ufosdk.b.f5637a) {
            this.f5688a.put("logcat", com.baidu.ufosdk.b.b.a());
        }
        if (!TextUtils.isEmpty(com.baidu.ufosdk.b.h)) {
            this.f5688a.put("ip_location", com.baidu.ufosdk.b.h);
        }
        String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(this.f5688a));
        try {
            String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=postmsg", TextUtils.isEmpty(str5) ? "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8") : "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8") + "&screenshot=" + URLEncoder.encode(str5, "UTF-8"));
            if (TextUtils.isEmpty(a3)) {
                com.baidu.ufosdk.f.c.c("response is empty, return false!");
            } else {
                JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.f.k.b(a3));
                com.baidu.ufosdk.f.c.a("response is -----------------> " + jSONObject.toString());
                int intValue = ((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue();
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
                    handler.obtainMessage(19, (String) jSONObject.get(BaseJsonData.TAG_ERRMSG)).sendToTarget();
                    return true;
                } else {
                    com.baidu.ufosdk.f.c.c("errNo is invalid, errNo = " + intValue);
                }
            }
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("sendRecord fail.", e);
        }
        this.v = false;
        return false;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.ufosdk.f.c.a(" --*^o^*-- requestCode = " + i + "; resultCode = " + i2);
        super.onActivityResult(i, i2, intent);
        if (!this.y) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this);
            dVar.c(dVar.c() + 1);
            this.y = true;
        }
        this.w = false;
        if (intent == null) {
            return;
        }
        if (i2 == -77 && this.q.size() > 0) {
            this.q.remove(this.q.size() - 1);
            this.af.obtainMessage(17).sendToTarget();
        }
        if (i != 10 && i2 == -1) {
            String stringExtra = intent.getStringExtra("shotUrl");
            byte[] byteArrayExtra = intent.getByteArrayExtra("shot");
            if (byteArrayExtra == null || byteArrayExtra.length <= 0) {
                if (stringExtra == null || stringExtra.length() <= 0) {
                    return;
                }
                new Thread(new x(this, stringExtra, i)).start();
                return;
            }
            try {
                if (this.q.size() == 0) {
                    this.q.add(byteArrayExtra);
                } else {
                    this.q.set(i, byteArrayExtra);
                }
            } catch (Exception e) {
                com.baidu.ufosdk.f.c.a("set ArrayList error!", e);
            }
            this.af.obtainMessage(17).sendToTarget();
            return;
        }
        Uri data = intent.getData();
        if (data != null) {
            InputStream inputStream = null;
            try {
                try {
                    InputStream openInputStream = getContentResolver().openInputStream(data);
                    if (openInputStream.available() >= 8388608) {
                        Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                                return;
                            } catch (Exception e2) {
                                return;
                            }
                        }
                        return;
                    }
                    byte[] a2 = a(openInputStream);
                    if (a2 == null) {
                        Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                                return;
                            } catch (Exception e3) {
                                return;
                            }
                        }
                        return;
                    }
                    byte[] a3 = com.baidu.ufosdk.f.q.a(a2);
                    if (a3 == null) {
                        Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                    } else if (a3.length > 307200) {
                        Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                            } catch (Exception e5) {
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
                            } catch (Exception e6) {
                            }
                        }
                    }
                } catch (Exception e7) {
                    com.baidu.ufosdk.f.c.a("OnActivity Result Error!", e7);
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e8) {
                        }
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e9) {
                    }
                }
                throw th;
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setSoftInputMode(32);
        com.baidu.ufosdk.f.r.a(this, getWindow());
        com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
        this.c = getSharedPreferences("UfoSharePreference", 0);
        String string = this.c.getString("cryptContactData", "");
        if (string == null || string.trim().length() <= 0) {
            this.R = "";
        } else {
            this.R = com.baidu.ufosdk.f.k.b(string);
        }
        this.f5689b = this.c.edit();
        this.g = getIntent().getStringExtra("faq_id");
        this.t = getIntent().getStringExtra("msgid");
        this.W = getIntent().getIntExtra("product_type", 0);
        this.X = getIntent().getIntExtra("come_from", -1);
        this.Y = getIntent().getIntExtra("extend_feedback_channel", -1);
        if (this.X == 2) {
            this.h = "";
            this.ac = com.baidu.ufosdk.f.s.a("43");
        } else {
            this.ac = com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        }
        if (this.W != 0 && this.X == 1) {
            new Thread(new m(this)).start();
        }
        if (this.Y != -1) {
            new Thread(new w(this)).start();
        }
        String b2 = com.baidu.ufosdk.f.i.b(System.currentTimeMillis());
        com.baidu.ufosdk.f.c.c("--FeedbackEdit:364--today:" + b2 + "; startStr:" + UfoSDK.startStr);
        if (UfoSDK.startStr.equals(b2 + "-enable")) {
            if (!this.c.getBoolean("editFeedbackViewUV_has", false)) {
                this.f5689b.putInt("editFeedbackViewUV", this.c.getInt("editFeedbackViewUV", 0) + 1);
                this.f5689b.putBoolean("editFeedbackViewUV_has", true);
            }
            this.f5689b.commit();
        }
        if (this.X == 1) {
            this.h = "";
            if (UfoSDK.startStr.equals(b2 + "-enable")) {
                if (!this.c.getBoolean("editFeedbackViewFromFaqUV_has", false)) {
                    this.f5689b.putInt("editFeedbackViewFromFaqUV", this.c.getInt("editFeedbackViewFromFaqUV", 0) + 1);
                    this.f5689b.putBoolean("editFeedbackViewFromFaqUV_has", true);
                }
                this.f5689b.commit();
            }
        }
        if (this.X == 0) {
            this.ae = getIntent().getStringExtra("im_content");
            Log.d("imcontent", this.ae);
            this.h = getIntent().getStringExtra("data_array");
            if (UfoSDK.startStr.equals(b2 + "-enable")) {
                if (!this.c.getBoolean("editFeedbackViewFromRobotUV_has", false)) {
                    this.f5689b.putInt("editFeedbackViewFromRobotUV", this.c.getInt("editFeedbackViewFromRobotUV", 0) + 1);
                    this.f5689b.putBoolean("editFeedbackViewFromRobotUV_has", true);
                }
                this.f5689b.commit();
            }
        }
        if (TextUtils.isEmpty(this.t)) {
            this.t = "newMessage";
        }
        if (TextUtils.isEmpty(this.g)) {
            this.g = "";
        }
        this.f5689b.putBoolean("ADD_PIC_FLAG", true);
        this.f5689b.commit();
        this.f = getIntent().getIntExtra("feedback_channel", 0);
        com.baidu.ufosdk.b.j = this.f;
        this.z = new ArrayList();
        this.G = new ScrollView(this);
        this.i = new RelativeLayout(this);
        this.i.setFitsSystemWindows(true);
        this.i.setId(R.drawable.res_0x7f080004_avd_show_password__1);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(R.id.BOTTOM);
        this.i.setBackgroundColor(com.baidu.ufosdk.b.z);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        this.A = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
        this.A.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0, 0, 0);
        this.j = new ImageView(this);
        this.j.setId(R.drawable.res_0x7f080001_avd_hide_password__1);
        this.j.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_back_icon_browser.png")));
        linearLayout.addView(this.j, this.A);
        TextView textView = new TextView(this);
        textView.setText(com.baidu.ufosdk.b.i);
        textView.setTextSize(com.baidu.ufosdk.b.M);
        textView.setTextColor(com.baidu.ufosdk.b.H);
        textView.setGravity(16);
        this.A = new LinearLayout.LayoutParams(-2, -2);
        this.A.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
        linearLayout.addView(textView, this.A);
        this.B = new RelativeLayout.LayoutParams(-2, -2);
        this.B.addRule(9);
        this.B.addRule(15);
        relativeLayout.addView(linearLayout, this.B);
        this.k = new TextView(this);
        this.k.setId(R.drawable.res_0x7f080002_avd_hide_password__2);
        this.k.setText(this.ac);
        this.k.setTextColor(com.baidu.ufosdk.b.r);
        this.k.setTextSize(com.baidu.ufosdk.b.T);
        this.k.setGravity(17);
        this.B = new RelativeLayout.LayoutParams(-2, -1);
        this.B.addRule(13);
        relativeLayout.addView(this.k, this.B);
        this.V = new Button(this);
        if (getIntent().getIntExtra("continue", 0) == 1) {
            this.V.setVisibility(4);
        }
        this.V.setText(com.baidu.ufosdk.f.s.a(PayConfig.PAYMENT_POS_KEY_MANGA));
        this.V.setId(R.id.DOWN);
        if (this.ae == null || this.ae.length() < 4) {
            this.V.setTextColor(com.baidu.ufosdk.b.y);
        } else {
            this.V.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
        }
        this.V.setTextColor(com.baidu.ufosdk.b.y);
        this.V.setTextSize(com.baidu.ufosdk.b.U);
        this.V.setGravity(17);
        this.V.setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
        this.V.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
        this.B = new RelativeLayout.LayoutParams(-2, -1);
        this.B.addRule(11);
        this.B.addRule(15);
        relativeLayout.addView(this.V, this.B);
        relativeLayout.setBackgroundColor(com.baidu.ufosdk.b.A);
        this.B = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
        this.B.addRule(10);
        this.i.addView(relativeLayout, this.B);
        this.A = new LinearLayout.LayoutParams(-1, -1);
        this.A.weight = 1.0f;
        View view = new View(this);
        view.setId(133201936);
        view.setBackgroundColor(-2894893);
        this.B = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        this.B.addRule(3, relativeLayout.getId());
        this.i.addView(view, this.B);
        this.l = new RelativeLayout(this);
        this.l.setId(R.drawable.res_0x7f080005_avd_show_password__2);
        this.l.setBackgroundColor(com.baidu.ufosdk.b.z);
        this.B = new RelativeLayout.LayoutParams(-1, -1);
        this.B.addRule(3, view.getId());
        this.G.addView(this.l);
        this.i.addView(this.G, this.B);
        this.u = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_NEW_SO));
        this.B = new RelativeLayout.LayoutParams(-2, -2);
        this.B.addRule(13);
        this.l.addView(this.u, this.B);
        this.u.setVisibility(8);
        linearLayout.setOnClickListener(new y(this));
        this.V.setOnClickListener(new z(this));
        this.q = new ArrayList();
        this.r = new HashMap();
        a();
        setContentView(this.i);
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_out_to_left"));
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("exit!");
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            c();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        String obj = this.n.getText().toString();
        if (obj == null || obj.trim().length() <= 0) {
            this.f5689b.putString("cryptContactData", "");
        } else {
            this.f5689b.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
        }
        if (this.s.booleanValue()) {
            if (TextUtils.isEmpty(this.g)) {
                this.f5689b.putString(this.t, this.m.getText().toString());
            } else {
                this.f5689b.putString(this.g, this.m.getText().toString());
            }
        }
        this.f5689b.commit();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(UfoSDK.clientid)) {
            SharedPreferences sharedPreferences = getSharedPreferences("UfoSharePreference", 0);
            UfoSDK.clientid = sharedPreferences.getString("UfoClientId", "");
            UfoSDK.appid = sharedPreferences.getString("UfoAppId", "");
            UfoSDK.devid = sharedPreferences.getString("UfoDevId", "");
            UfoSDK.productid = sharedPreferences.getString("UfoProductId", "");
        }
        com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this);
        dVar.a(dVar.a() + 1);
        if (com.baidu.ufosdk.b.ac != null) {
            com.baidu.ufosdk.b.ac.onResumeCallback();
        }
        this.ac = com.baidu.ufosdk.f.s.a("43");
        this.k.setText(this.ac);
        this.V.setText(com.baidu.ufosdk.f.s.a(PayConfig.PAYMENT_POS_KEY_MANGA));
        this.C.setText(com.baidu.ufosdk.f.s.a("48") + "*");
        this.D.setText(com.baidu.ufosdk.f.s.a("46"));
        this.E.setText(com.baidu.ufosdk.f.s.a("47"));
        if (this.R.length() > 0) {
            this.n.setText(this.R);
        } else {
            this.n.setHint(com.baidu.ufosdk.f.s.a("31"));
        }
        if ("".equals(com.baidu.ufosdk.b.n)) {
            this.m.setHint(com.baidu.ufosdk.f.s.a("6"));
        } else {
            this.m.setHint(com.baidu.ufosdk.b.n);
        }
        com.baidu.ufosdk.f.i.a((RelativeLayout) this.u, com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_NEW_SO));
        this.V.setTextSize(com.baidu.ufosdk.b.U);
        this.s = true;
        if (this.t == null) {
            this.t = "newMessage";
        } else if (this.t.length() == 0) {
            this.t = "newMessage";
        }
        if (this.X == 0 && this.F) {
            this.F = false;
            if (this.ae.length() > 0) {
                if (this.ae.length() > com.baidu.ufosdk.b.aa) {
                    this.ae = this.ae.substring(0, com.baidu.ufosdk.b.aa - 1);
                }
                this.m.setText(this.ae);
                b(this.m, this.ae.length());
            }
        } else {
            String string = TextUtils.isEmpty(this.g) ? this.c.getString(this.t, "") : this.c.getString(this.g, "");
            if (string.length() > 0) {
                if (string.length() > com.baidu.ufosdk.b.aa) {
                    string = string.substring(0, com.baidu.ufosdk.b.aa - 1);
                }
                this.m.setText(string);
                b(this.m, string.length());
            }
        }
        String string2 = this.c.getString("cryptContactData", "");
        if (string2 == null || string2.trim().length() <= 0) {
            this.n.setText("");
        } else {
            this.n.setText(com.baidu.ufosdk.f.k.b(string2));
        }
        if (UfoSDK.clientid.length() == 0) {
            new Thread(new u(this)).start();
        } else {
            new Thread(new v(this)).start();
        }
    }
}
