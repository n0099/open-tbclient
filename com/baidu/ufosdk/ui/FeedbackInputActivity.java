package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.c1;
import com.baidu.ufosdk.d0;
import com.baidu.ufosdk.e0;
import com.baidu.ufosdk.e1;
import com.baidu.ufosdk.f0;
import com.baidu.ufosdk.g1;
import com.baidu.ufosdk.h1;
import com.baidu.ufosdk.j0;
import com.baidu.ufosdk.k0;
import com.baidu.ufosdk.m1;
import com.baidu.ufosdk.p1;
import com.baidu.ufosdk.r1;
import com.baidu.ufosdk.s1;
import com.baidu.ufosdk.screencapedt.ScreenCapEditActivity;
import com.baidu.ufosdk.t0;
import com.baidu.ufosdk.t1;
import com.baidu.ufosdk.u0;
import com.baidu.ufosdk.v0;
import com.baidu.ufosdk.v1;
import com.baidu.ufosdk.w0;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
@SuppressLint({"NewApi", "HandlerLeak"})
/* loaded from: classes9.dex */
public class FeedbackInputActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public static Bitmap m0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public ArrayList<View> E;
    public c1 F;
    public g1 G;
    public int H;
    public String I;
    public String J;
    public int K;
    public String L;
    public int M;
    public JSONArray N;
    public WindowManager O;
    public View P;
    public boolean Q;
    public WindowManager.LayoutParams R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1196T;
    public String U;
    public boolean V;
    public Handler W;
    public BroadcastReceiver X;
    public boolean Y;
    public EditText Z;
    public int a;
    public String a0;
    public LinearLayout b;
    public boolean b0;
    public List<byte[]> c;
    public String c0;
    public LinearLayout d;
    public boolean d0;
    public LinearLayout e;
    public int e0;
    public LinearLayout f;
    public String f0;
    public RelativeLayout g;
    public Button g0;
    public RelativeLayout h;
    public boolean h0;
    public ImageView i;
    public TextView i0;
    public Button j;
    public boolean j0;
    public LinearLayout k;
    public LinearLayout.LayoutParams k0;
    public String l;
    public e0 l0;
    public String m;
    public String n;
    public List<Map<String, Object>> o;
    public ListView p;
    public s q;
    public View r;
    public ExecutorService s;
    public TextView t;
    public boolean u;
    public SharedPreferences.Editor v;
    public SharedPreferences w;
    public View x;
    public boolean y;
    public boolean z;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            getWindow().setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.getDecorView().setSystemUiVisibility(1280);
                if (Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(8192);
                }
                window.getDecorView().setBackgroundColor(-1);
                window.setStatusBarColor(0);
            }
            this.f1196T = com.baidu.ufosdk.b.m() == 1;
            this.l0 = e0.a(this);
            if (this.f1196T) {
                if (this.S) {
                    return;
                }
                this.R = new WindowManager.LayoutParams(2, 24, -2);
                this.O = getWindowManager();
                View view2 = new View(this);
                this.P = view2;
                view2.setBackgroundColor(-16777216);
                this.P.setAlpha(0.5f);
                this.O.addView(this.P, this.R);
                this.S = true;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            String str = "*^^* --> 宽：" + displayMetrics.widthPixels + ", 高：" + displayMetrics.heightPixels + "; 密度：" + displayMetrics.density + ", 密度DPI：" + displayMetrics.densityDpi;
            SharedPreferences sharedPreferences = getSharedPreferences("UfoSharePreference", 0);
            this.w = sharedPreferences;
            this.v = sharedPreferences.edit();
            this.a0 = getIntent().getStringExtra("faq_id");
            this.l = getIntent().getStringExtra("msgid");
            this.n = getIntent().getStringExtra("appid");
            this.V = getIntent().getIntExtra("isToolEva", 0) == 1;
            String str2 = "isToolEva: " + this.V;
            this.j0 = getIntent().getBooleanExtra("openList", false);
            this.c0 = getIntent().getStringExtra("no_result");
            if (TextUtils.isEmpty(this.l)) {
                this.l = "newMessage";
            }
            if (TextUtils.isEmpty(this.a0)) {
                this.a0 = "";
            }
            SharedPreferences sharedPreferences2 = getSharedPreferences("UfoSharePreference", 0);
            this.w = sharedPreferences2;
            String string = sharedPreferences2.getString("cryptContactData", "");
            if (string != null && string.trim().length() > 0) {
                this.f0 = com.baidu.ufosdk.b.a(string);
            } else {
                this.f0 = "";
            }
            this.v.putBoolean("ADD_PIC_FLAG", true);
            this.v.commit();
            this.h0 = getIntent().getBooleanExtra("from_facepage", false);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.h = relativeLayout;
            relativeLayout.setId(2030632964);
            this.h.setBackgroundColor(-1);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setId(2030632965);
            new RelativeLayout(this).setId(2030632967);
            Button button = new Button(this);
            this.j = button;
            button.setText(t1.a("23"));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.h.addView(this.j, layoutParams);
            this.j.setVisibility(8);
            TextView textView = new TextView(this);
            textView.setId(2030632962);
            textView.setText("咨询问题");
            textView.setTextColor(-16777216);
            textView.setTextSize(1, 16.0f);
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setGravity(17);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams2.addRule(13);
            relativeLayout2.addView(textView, layoutParams2);
            Button button2 = new Button(this);
            this.g0 = button2;
            button2.setVisibility(8);
            this.g0.setText(t1.a("17"));
            this.g0.setId(2031091714);
            this.g0.setTextColor(-10066330);
            this.g0.setTextSize(1, 14.0f);
            this.g0.setGravity(17);
            this.g0.setTextColor(p1.a(-10066330, -5262406, -10066330, -10066330));
            this.g0.setBackgroundColor(16777215);
            this.g0.setPadding(p1.a(getApplicationContext(), 8.0f), 0, p1.a(getApplicationContext(), 8.0f), 0);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(15);
            layoutParams3.setMargins(0, 0, p1.a(getApplicationContext(), 10.0f), 0);
            relativeLayout2.addView(this.g0, layoutParams3);
            relativeLayout2.setBackgroundColor(-1);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 38.0f));
            layoutParams4.addRule(10);
            this.h.addView(relativeLayout2, layoutParams4);
            View view3 = new View(this);
            view3.setId(2031091715);
            view3.setBackgroundColor(-1644826);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 0.5f));
            layoutParams5.addRule(3, relativeLayout2.getId());
            this.h.addView(view3, layoutParams5);
            this.x = p1.c(this, t1.a("25"));
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams6.addRule(13);
            this.h.addView(this.x, layoutParams6);
            this.x.setVisibility(8);
            LinearLayout linearLayout = new LinearLayout(this);
            this.f = linearLayout;
            linearLayout.setId(2030632977);
            this.f.setOrientation(0);
            LinearLayout linearLayout2 = new LinearLayout(this);
            this.e = linearLayout2;
            linearLayout2.setId(2030632963);
            this.e.setOrientation(1);
            this.e.setBackgroundColor(-1);
            RelativeLayout relativeLayout3 = new RelativeLayout(this);
            this.g = relativeLayout3;
            relativeLayout3.setId(2030632969);
            this.g.setFocusable(true);
            this.g.setFocusableInTouchMode(true);
            TextView textView2 = new TextView(this);
            this.i0 = textView2;
            textView2.setText("发送");
            this.i0.setTextColor(-1);
            this.i0.setTextSize(1, 11.0f);
            this.i0.setGravity(17);
            this.i0.setId(2030633003);
            this.i0.setBackgroundResource(R.drawable.obfuscated_res_0x7f081396);
            this.i0.setPadding(p1.a(getApplicationContext(), 14.0f), p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 14.0f), p1.a(getApplicationContext(), 0.0f));
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 50.0f), p1.a(getApplicationContext(), 24.0f));
            layoutParams7.addRule(11);
            layoutParams7.addRule(15);
            layoutParams7.setMargins(0, 0, p1.a(getApplicationContext(), 8.0f), 0);
            this.g.addView(this.i0, layoutParams7);
            this.i0.setVisibility(8);
            f0 f0Var = new f0(this);
            this.i = f0Var;
            f0Var.setId(2030632961);
            this.i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.i.setBackgroundDrawable(new BitmapDrawable(p1.b(getApplicationContext(), "ufo_back_icon_browser.png")));
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 19.0f), p1.a(getApplicationContext(), 19.0f));
            layoutParams8.addRule(9);
            layoutParams8.addRule(15);
            layoutParams8.setMargins(p1.a(getApplicationContext(), 13.0f), 0, p1.a(getApplicationContext(), 15.0f), 0);
            this.g.addView(this.i, layoutParams8);
            ImageView imageView = new ImageView(this);
            imageView.setId(2030632971);
            imageView.setBackgroundDrawable(new BitmapDrawable(p1.b(getApplicationContext(), "ufo_pluspic_icon.png")));
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 25.0f), p1.a(getApplicationContext(), 25.0f));
            layoutParams9.setMargins(p1.a(getApplicationContext(), 12.0f), 0, p1.a(getApplicationContext(), 12.0f), 0);
            if (this.i0.getVisibility() == 8) {
                layoutParams9.addRule(11);
                layoutParams9.addRule(15);
            } else {
                layoutParams9.addRule(0, this.i0.getId());
                layoutParams9.addRule(15);
            }
            this.g.addView(imageView, layoutParams9);
            EditText editText = new EditText(this);
            this.Z = editText;
            editText.setId(2030632978);
            this.Z.setImeOptions(4);
            this.Z.setInputType(262144);
            this.Z.setSingleLine(false);
            this.Z.setId(2030632970);
            this.Z.setVisibility(0);
            this.Z.setTextSize(1, 15.0f);
            this.Z.setGravity(16);
            this.Z.setHint("请描述您遇到的问题...");
            this.Z.setBackgroundResource(R.drawable.obfuscated_res_0x7f081546);
            this.Z.setPadding(p1.a(getApplicationContext(), 8.0f), 0, p1.a(getApplicationContext(), 15.0f), 0);
            RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 280.0f), p1.a(getApplicationContext(), 28.0f));
            layoutParams10.addRule(0, imageView.getId());
            layoutParams10.addRule(1, this.i.getId());
            layoutParams10.addRule(15);
            this.g.addView(this.Z, layoutParams10);
            this.Z.setOnEditorActionListener(new m(this));
            this.Z.addTextChangedListener(new n(this, imageView));
            imageView.setOnClickListener(new o(this));
            this.i0.setOnClickListener(new p(this));
            this.g0.setOnClickListener(new q(this));
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -1);
            this.k0 = layoutParams11;
            this.f.addView(this.g, layoutParams11);
            this.f.setGravity(16);
            this.k0 = new LinearLayout.LayoutParams(-1, p1.a(getApplicationContext(), 41.0f));
            this.f.setPadding(p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 3.0f), p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 3.0f));
            this.e.setGravity(3);
            this.e.addView(this.f, this.k0);
            LinearLayout linearLayout3 = new LinearLayout(this);
            this.b = linearLayout3;
            linearLayout3.setOrientation(0);
            this.b.setPadding(0, p1.a(getApplicationContext(), 8.0f), 0, p1.a(getApplicationContext(), 8.0f));
            this.b.setId(2030632974);
            this.b.setVisibility(8);
            this.c = new ArrayList();
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("shot");
            if (byteArrayExtra != null && byteArrayExtra.length > 0) {
                this.c.add(byteArrayExtra);
                this.c.add(p1.a(this, this.f1196T));
                this.b.setVisibility(0);
            } else {
                this.c.add(p1.a(this));
                this.b.setVisibility(8);
            }
            c();
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 254.0f), p1.a(getApplicationContext(), 84.0f));
            this.k0 = layoutParams12;
            this.e.addView(this.b, layoutParams12);
            RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams13.addRule(12);
            this.e.setPadding(p1.a(getApplicationContext(), 7.0f), p1.a(getApplicationContext(), 1.0f), p1.a(getApplicationContext(), 7.0f), p1.a(getApplicationContext(), 1.0f));
            this.e.bringToFront();
            this.h.addView(this.e, layoutParams13);
            View view4 = new View(this);
            view4.setId(2031091716);
            view4.setBackgroundColor(-1644826);
            RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 0.5f));
            layoutParams14.addRule(2, this.e.getId());
            this.h.addView(view4, layoutParams14);
            ListView listView = new ListView(this);
            this.p = listView;
            listView.setBackgroundColor(-1);
            this.p.setDivider(new ColorDrawable(-855310));
            this.p.setDividerHeight(0);
            s sVar = new s(this, this);
            this.q = sVar;
            this.p.setAdapter((ListAdapter) sVar);
            this.p.setFocusable(false);
            this.p.setCacheColorHint(-855310);
            this.p.setClickable(false);
            this.p.setTranscriptMode(2);
            this.p.setRecyclerListener(new r(this));
            LinearLayout linearLayout4 = new LinearLayout(this);
            this.k = linearLayout4;
            linearLayout4.setId(2030632987);
            this.k.setBackgroundColor(-1);
            this.k.clearAnimation();
            this.k0 = new LinearLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams15.addRule(3, view3.getId());
            layoutParams15.addRule(2, view4.getId());
            layoutParams15.setMargins(0, 0, 0, 0);
            this.k.addView(this.p, this.k0);
            this.h.addView(this.k, layoutParams15);
            LinearLayout linearLayout5 = new LinearLayout(this);
            this.d = linearLayout5;
            linearLayout5.setOrientation(1);
            this.k0 = new LinearLayout.LayoutParams(-2, -2);
            ImageView imageView2 = new ImageView(this);
            this.k0 = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 115.0f), p1.a(getApplicationContext(), 85.0f));
            try {
                imageView2.setBackgroundDrawable(new BitmapDrawable(p1.b(getApplicationContext(), "ufo_no_netwrok.png")));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.d.addView(imageView2, this.k0);
            TextView textView3 = new TextView(this);
            this.t = textView3;
            textView3.setPadding(p1.a(getApplicationContext(), 10.0f), p1.a(getApplicationContext(), 18.0f), p1.a(getApplicationContext(), 10.0f), p1.a(getApplicationContext(), 11.0f));
            this.t.setTextSize(1, 18.0f);
            this.t.setTextColor(-16777216);
            this.k0 = new LinearLayout.LayoutParams(-2, -2);
            p1.a(getApplicationContext(), this.t);
            this.d.addView(this.t, this.k0);
            Button button3 = new Button(this);
            this.j = button3;
            button3.setText(t1.a("22"));
            this.j.setTextSize(1, 16.0f);
            this.j.setTextColor(-12814593);
            this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810c6);
            LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 122.0f), p1.a(getApplicationContext(), 40.0f));
            this.k0 = layoutParams16;
            layoutParams16.setMargins(0, p1.a(getApplicationContext(), 15.0f), 0, 0);
            this.d.addView(this.j, this.k0);
            RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams17.addRule(13);
            this.h.addView(this.d, layoutParams17);
            this.d.setGravity(17);
            this.d.setVisibility(8);
            setContentView(this.h, new ViewGroup.LayoutParams(-1, -1));
            this.r = p1.c(this, t1.a("13"));
            RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams18.addRule(13);
            this.h.addView(this.r, layoutParams18);
            if (this.l0.a.length() == 0) {
                Toast.makeText(getApplicationContext(), t1.a("18"), 1).show();
                Intent intent = new Intent(this, FeedbackListActivity.class);
                intent.putExtra("feedback_channel", com.baidu.ufosdk.b.h());
                startActivity(intent);
                finish();
                return;
            }
            String str3 = "1606 --> msgId = " + this.l;
            String str4 = this.l;
            if (str4 != null && str4.length() > 0 && !this.l.equals("newMessage")) {
                this.g0.setVisibility(8);
                this.C = true;
                this.d0 = true;
                this.s.execute(new b(this));
            } else {
                this.g0.setVisibility(8);
                this.C = true;
                this.d0 = false;
                this.r.setVisibility(8);
                this.x.setVisibility(8);
                this.W.obtainMessage(5, "newMessage").sendToTarget();
            }
            this.i.setOnClickListener(new c(this));
            this.e.setOnClickListener(new d(this));
            this.j.setOnClickListener(new e(this));
            new Thread(new t0(this)).start();
        }
    }

    /* loaded from: classes9.dex */
    public class s extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public final /* synthetic */ FeedbackInputActivity b;

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                return null;
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                return 0L;
            }
            return invokeI.longValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:321:0x19ef  */
        /* JADX WARN: Removed duplicated region for block: B:322:0x19f5  */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int i2, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            int i3;
            Object obj;
            Object obj2;
            u uVar;
            int i4;
            t tVar;
            v vVar;
            RelativeLayout relativeLayout;
            x xVar;
            RelativeLayout relativeLayout2;
            int i5;
            w wVar;
            RelativeLayout relativeLayout3;
            RelativeLayout relativeLayout4;
            RelativeLayout relativeLayout5;
            View view3;
            View view4;
            String str;
            int i6;
            int i7;
            FeedbackInputActivity feedbackInputActivity;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view2, viewGroup)) == null) {
                if (((Map) this.b.o.get(i2)).get("from").equals(0)) {
                    i3 = (((String) ((Map) this.b.o.get(i2)).get("contenttype")).contentEquals("1") || ((String) ((Map) this.b.o.get(i2)).get("contenttype")).contentEquals("2")) ? 1 : 2;
                } else {
                    if (((Map) this.b.o.get(i2)).get("from").equals(1)) {
                        if (((String) ((Map) this.b.o.get(i2)).get("contenttype")).contentEquals("1") || ((String) ((Map) this.b.o.get(i2)).get("contenttype")).contentEquals("2") || ((Map) this.b.o.get(i2)).get("content").toString().startsWith("http://bs.baidu.com") || ((Map) this.b.o.get(i2)).get("content").toString().startsWith("https://bs.baidu.com")) {
                            i3 = 4;
                        } else if (((String) ((Map) this.b.o.get(i2)).get("contenttype")).contentEquals("-1")) {
                            i3 = 5;
                        }
                    }
                    i3 = 3;
                }
                if (view2 == null || ((Integer) view2.getTag(2031091712)).intValue() != i3) {
                    if (i3 == 1) {
                        w wVar2 = new w();
                        RelativeLayout relativeLayout6 = new RelativeLayout(this.a);
                        RelativeLayout relativeLayout7 = new RelativeLayout(this.a);
                        RelativeLayout relativeLayout8 = new RelativeLayout(this.a);
                        relativeLayout6.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                        relativeLayout6.setBackgroundColor(-1);
                        relativeLayout7.setBackgroundColor(-1);
                        relativeLayout8.setBackgroundColor(-1);
                        relativeLayout8.setId(2030632968);
                        relativeLayout8.setClickable(false);
                        TextView textView = new TextView(this.b);
                        textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081544);
                        textView.setTextColor(-1);
                        textView.setTextSize(1, 12.0f);
                        textView.setGravity(17);
                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                        textView.setPadding(p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 2.0f) + 2, p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 2.0f));
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(0, p1.a(this.b.getApplicationContext(), 10.0f), 0, 0);
                        layoutParams.addRule(14);
                        relativeLayout8.addView(textView, layoutParams);
                        ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                        relativeLayout8.setPadding(0, p1.a(this.b.getApplicationContext(), 6.0f), 0, p1.a(this.b.getApplicationContext(), 8.0f));
                        relativeLayout6.addView(relativeLayout8, layoutParams2);
                        wVar2.a = textView;
                        wVar2.d = relativeLayout8;
                        ImageView imageView = new ImageView(this.b);
                        imageView.setId(2030632966);
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(p1.a(this.b.getApplicationContext(), 40.0f), p1.a(this.b.getApplicationContext(), 40.0f));
                        layoutParams3.addRule(11);
                        layoutParams3.setMargins(p1.a(this.b.getApplicationContext(), 6.0f), 0, p1.a(this.b.getApplicationContext(), 8.0f), 0);
                        relativeLayout7.addView(imageView, layoutParams3);
                        wVar2.b = imageView;
                        RelativeLayout relativeLayout9 = new RelativeLayout(this.b);
                        try {
                            relativeLayout9.setBackgroundResource(R.drawable.obfuscated_res_0x7f081548);
                            relativeLayout9.setPadding(p1.a(this.b.getApplicationContext(), 1.0f), p1.a(this.b.getApplicationContext(), 1.0f), 11, p1.a(this.b.getApplicationContext(), 1.0f));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        ImageView imageView2 = new ImageView(this.b);
                        imageView2.setOnClickListener(new f(this));
                        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                        if (p1.a() < 23) {
                            imageView2.setAdjustViewBounds(true);
                            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                            i5 = 0;
                            layoutParams4.setMargins(0, 0, 0, 0);
                            relativeLayout9.addView(imageView2, layoutParams4);
                        } else {
                            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(p1.a(this.b.getApplicationContext(), 80.0f), p1.a(this.b.getApplicationContext(), 120.0f));
                            i5 = 0;
                            layoutParams5.setMargins(0, 0, 0, 0);
                            relativeLayout9.addView(imageView2, layoutParams5);
                        }
                        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams6.setMargins(p1.a(this.b.getApplicationContext(), 55.0f), i5, i5, i5);
                        layoutParams6.addRule(i5, imageView.getId());
                        relativeLayout7.addView(relativeLayout9, layoutParams6);
                        wVar2.c = imageView2;
                        relativeLayout7.setPadding(i5, i5, i5, p1.a(this.b.getApplicationContext(), 20.0f));
                        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams7.addRule(3, relativeLayout8.getId());
                        relativeLayout6.addView(relativeLayout7, layoutParams7);
                        relativeLayout6.setOnClickListener(new g(this));
                        relativeLayout6.setTag(2031091713, wVar2);
                        relativeLayout6.setTag(2031091712, Integer.valueOf(i3));
                        obj = "contenttype";
                        obj2 = "content";
                        wVar = wVar2;
                        relativeLayout3 = relativeLayout6;
                        xVar = null;
                        tVar = null;
                        uVar = null;
                        vVar = null;
                    } else if (i3 == 2) {
                        x xVar2 = new x();
                        RelativeLayout relativeLayout10 = new RelativeLayout(this.a);
                        RelativeLayout relativeLayout11 = new RelativeLayout(this.a);
                        RelativeLayout relativeLayout12 = new RelativeLayout(this.a);
                        ViewGroup.LayoutParams layoutParams8 = new AbsListView.LayoutParams(-1, -2);
                        relativeLayout10.setBackgroundColor(-1);
                        relativeLayout11.setBackgroundColor(-1);
                        relativeLayout12.setBackgroundColor(-1);
                        relativeLayout10.setLayoutParams(layoutParams8);
                        relativeLayout12.setId(2030632968);
                        relativeLayout12.setClickable(false);
                        TextView textView2 = new TextView(this.b);
                        textView2.setBackgroundResource(R.drawable.obfuscated_res_0x7f081544);
                        textView2.setTextColor(-1);
                        textView2.setTextSize(1, 12.0f);
                        textView2.setGravity(17);
                        textView2.setMovementMethod(LinkMovementMethod.getInstance());
                        textView2.setPadding(p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 2.0f) + 2, p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 2.0f));
                        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams9.setMargins(0, p1.a(this.b.getApplicationContext(), 10.0f), 0, 0);
                        layoutParams9.addRule(14);
                        relativeLayout12.addView(textView2, layoutParams9);
                        ViewGroup.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, -2);
                        relativeLayout12.setPadding(0, p1.a(this.b.getApplicationContext(), 6.0f), 0, p1.a(this.b.getApplicationContext(), 8.0f));
                        relativeLayout10.addView(relativeLayout12, layoutParams10);
                        xVar2.a = textView2;
                        xVar2.d = relativeLayout12;
                        ImageView imageView3 = new ImageView(this.b);
                        imageView3.setId(2030632966);
                        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(p1.a(this.b.getApplicationContext(), 40.0f), p1.a(this.b.getApplicationContext(), 40.0f));
                        layoutParams11.addRule(11);
                        layoutParams11.setMargins(p1.a(this.b.getApplicationContext(), 6.0f), 0, p1.a(this.b.getApplicationContext(), 8.0f), 0);
                        relativeLayout11.addView(imageView3, layoutParams11);
                        xVar2.b = imageView3;
                        TextView textView3 = new TextView(this.b);
                        textView3.setTextColor(-13421773);
                        textView3.setTextSize(1, 17.0f);
                        textView3.setLineSpacing(4.0f, 1.0f);
                        textView3.setBackgroundResource(R.drawable.obfuscated_res_0x7f081548);
                        textView3.setGravity(16);
                        textView3.setPadding(p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 8.0f), p1.a(this.b.getApplicationContext(), 14.0f), p1.a(this.b.getApplicationContext(), 8.0f));
                        textView3.setLineSpacing(5.0f, 1.0f);
                        textView3.setAutoLinkMask(1);
                        textView3.setMovementMethod(LinkMovementMethod.getInstance());
                        textView3.setOnLongClickListener(new h(this));
                        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams12.setMargins(p1.a(this.b.getApplicationContext(), 55.0f), 0, 0, 0);
                        layoutParams12.addRule(0, imageView3.getId());
                        relativeLayout11.addView(textView3, layoutParams12);
                        xVar2.c = textView3;
                        relativeLayout11.setPadding(0, 0, 0, p1.a(this.b.getApplicationContext(), 10.0f));
                        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams13.addRule(3, relativeLayout12.getId());
                        relativeLayout10.addView(relativeLayout11, layoutParams13);
                        relativeLayout10.setOnClickListener(new i(this));
                        relativeLayout10.setTag(2031091713, xVar2);
                        relativeLayout10.setTag(2031091712, Integer.valueOf(i3));
                        xVar = xVar2;
                        obj = "contenttype";
                        obj2 = "content";
                        relativeLayout2 = relativeLayout10;
                        tVar = null;
                        view4 = relativeLayout2;
                        uVar = null;
                        view3 = view4;
                        vVar = null;
                        relativeLayout3 = view3;
                        wVar = null;
                    } else if (i3 == 3) {
                        v vVar2 = new v();
                        RelativeLayout relativeLayout13 = new RelativeLayout(this.a);
                        RelativeLayout relativeLayout14 = new RelativeLayout(this.a);
                        RelativeLayout relativeLayout15 = new RelativeLayout(this.a);
                        ViewGroup.LayoutParams layoutParams14 = new AbsListView.LayoutParams(-1, -2);
                        relativeLayout13.setBackgroundColor(-1);
                        relativeLayout14.setBackgroundColor(-1);
                        relativeLayout15.setBackgroundColor(-1);
                        relativeLayout13.setLayoutParams(layoutParams14);
                        relativeLayout15.setId(2030632968);
                        relativeLayout15.setClickable(false);
                        TextView textView4 = new TextView(this.b);
                        textView4.setBackgroundResource(R.drawable.obfuscated_res_0x7f081544);
                        textView4.setTextColor(-1);
                        textView4.setTextSize(1, 12.0f);
                        textView4.setGravity(17);
                        textView4.setMovementMethod(LinkMovementMethod.getInstance());
                        textView4.setPadding(p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 2.0f) + 2, p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 2.0f));
                        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams15.setMargins(0, p1.a(this.b.getApplicationContext(), 10.0f), 0, 0);
                        layoutParams15.addRule(14);
                        relativeLayout15.addView(textView4, layoutParams15);
                        ViewGroup.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-1, -2);
                        relativeLayout15.setPadding(0, p1.a(this.b.getApplicationContext(), 6.0f), 0, p1.a(this.b.getApplicationContext(), 8.0f));
                        relativeLayout13.addView(relativeLayout15, layoutParams16);
                        vVar2.a = textView4;
                        vVar2.d = relativeLayout15;
                        ImageView imageView4 = new ImageView(this.b);
                        imageView4.setId(2030632966);
                        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams(p1.a(this.b.getApplicationContext(), 40.0f), p1.a(this.b.getApplicationContext(), 40.0f));
                        layoutParams17.setMargins(p1.a(this.b.getApplicationContext(), 8.0f), 0, p1.a(this.b.getApplicationContext(), 4.0f), 0);
                        layoutParams17.addRule(9);
                        relativeLayout14.addView(imageView4, layoutParams17);
                        vVar2.b = imageView4;
                        LinearLayout linearLayout = new LinearLayout(this.a);
                        linearLayout.setOrientation(1);
                        linearLayout.setId(2031091720);
                        linearLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f08154d);
                        TextView textView5 = new TextView(this.b);
                        textView5.setId(2031091719);
                        obj2 = "content";
                        textView5.setPadding(p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 8.0f), p1.a(this.b.getApplicationContext(), 8.0f), p1.a(this.b.getApplicationContext(), 8.0f));
                        textView5.setGravity(16);
                        textView5.setLineSpacing(5.0f, 1.0f);
                        textView5.setTextColor(-13421773);
                        textView5.setTextSize(1, 17.0f);
                        textView5.setAutoLinkMask(1);
                        textView5.setMovementMethod(LinkMovementMethod.getInstance());
                        textView5.setOnLongClickListener(new j(this));
                        textView5.setOnClickListener(new k(this));
                        vVar2.c = textView5;
                        linearLayout.addView(textView5, new LinearLayout.LayoutParams(-2, -2));
                        RelativeLayout relativeLayout16 = new RelativeLayout(this.a);
                        relativeLayout16.setVisibility(8);
                        relativeLayout16.setBackgroundColor(-1);
                        LinearLayout linearLayout2 = new LinearLayout(this.a);
                        linearLayout2.setBackgroundColor(-1);
                        linearLayout2.setOrientation(0);
                        TextView textView6 = new TextView(this.a);
                        textView6.setText("满 意");
                        textView6.setTextColor(-12814593);
                        textView6.setTextSize(1, 15.0f);
                        textView6.setGravity(17);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(p1.b(this.b.getApplicationContext(), "ufo_solved.png"));
                        obj = "contenttype";
                        bitmapDrawable.setBounds(p1.a(this.b.getApplicationContext(), 13.0f), 0, p1.a(this.b.getApplicationContext(), 33.0f), p1.a(this.b.getApplicationContext(), 20.0f));
                        textView6.setCompoundDrawables(bitmapDrawable, null, null, null);
                        textView6.setBackgroundResource(R.drawable.obfuscated_res_0x7f0813d0);
                        LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(-1, p1.a(this.b.getApplicationContext(), 35.0f));
                        layoutParams18.setMargins(0, 0, p1.a(this.b.getApplicationContext(), 5.0f), 0);
                        layoutParams18.weight = 1.0f;
                        linearLayout2.addView(textView6, layoutParams18);
                        TextView textView7 = new TextView(this.a);
                        textView7.setText("不满意");
                        textView7.setTextColor(-65536);
                        textView7.setTextSize(1, 15.0f);
                        textView7.setGravity(17);
                        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(p1.b(this.b.getApplicationContext(), "ufo_not_solved.png"));
                        int i8 = i3;
                        bitmapDrawable2.setBounds(p1.a(this.b.getApplicationContext(), 13.0f), 0, p1.a(this.b.getApplicationContext(), 33.0f), p1.a(this.b.getApplicationContext(), 20.0f));
                        textView7.setCompoundDrawables(bitmapDrawable2, null, null, null);
                        textView7.setBackgroundResource(R.drawable.obfuscated_res_0x7f0813d0);
                        LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(-1, p1.a(this.b.getApplicationContext(), 35.0f));
                        layoutParams19.setMargins(p1.a(this.b.getApplicationContext(), 5.0f), 0, 0, 0);
                        layoutParams19.weight = 1.0f;
                        linearLayout2.addView(textView7, layoutParams19);
                        relativeLayout16.addView(linearLayout2, new RelativeLayout.LayoutParams(-1, -1));
                        vVar2.e = relativeLayout16;
                        vVar2.f = textView6;
                        vVar2.g = textView7;
                        k0 k0Var = new k0(this.b, -3355444);
                        k0Var.setVisibility(8);
                        vVar2.h = k0Var;
                        ImageView imageView5 = new ImageView(this.b);
                        imageView5.setId(2030632979);
                        imageView5.setVisibility(8);
                        vVar2.i = imageView5;
                        LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams20.setMargins(p1.a(this.b.getApplicationContext(), 16.0f), p1.a(this.b.getApplicationContext(), 3.0f), p1.a(this.b.getApplicationContext(), 16.0f), p1.a(this.b.getApplicationContext(), 13.0f));
                        linearLayout.addView(relativeLayout16, layoutParams20);
                        LinearLayout.LayoutParams layoutParams21 = new LinearLayout.LayoutParams(-1, p1.a(this.b.getApplicationContext(), 0.5f));
                        layoutParams21.setMargins(p1.a(this.b.getApplicationContext(), 16.0f), p1.a(this.b.getApplicationContext(), 3.0f), p1.a(this.b.getApplicationContext(), 16.0f), p1.a(this.b.getApplicationContext(), 3.0f));
                        linearLayout.addView(k0Var, layoutParams21);
                        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(p1.a(this.b.getApplicationContext(), 20.0f), p1.a(this.b.getApplicationContext(), 20.0f));
                        layoutParams22.setMargins(p1.a(this.b.getApplicationContext(), 16.0f), p1.a(this.b.getApplicationContext(), 3.0f), p1.a(this.b.getApplicationContext(), 16.0f), p1.a(this.b.getApplicationContext(), 13.0f));
                        linearLayout.addView(imageView5, layoutParams22);
                        RelativeLayout.LayoutParams layoutParams23 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams23.setMargins(0, 0, p1.a(this.b.getApplicationContext(), 57.0f), 0);
                        layoutParams23.addRule(1, imageView4.getId());
                        relativeLayout14.addView(linearLayout, layoutParams23);
                        TextView textView8 = new TextView(this.a);
                        textView8.setVisibility(8);
                        textView8.setText("填写不满意原因");
                        textView8.setTextSize(15.0f);
                        textView8.setTextColor(p1.a(-12814593, -15644211, -12814593, -12814593));
                        Drawable a2 = p1.a(this.a, (int) R.drawable.obfuscated_res_0x7f08154f);
                        a2.setBounds(p1.a(this.a, 1.0f), p1.a(this.a, 1.0f), p1.a(this.a, 14.0f), p1.a(this.a, 14.0f));
                        textView8.setCompoundDrawables(null, null, a2, null);
                        RelativeLayout.LayoutParams layoutParams24 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams24.addRule(3, linearLayout.getId());
                        layoutParams24.addRule(1, imageView4.getId());
                        layoutParams24.setMargins(p1.a(this.b.getApplicationContext(), 3.0f), p1.a(this.b.getApplicationContext(), 8.0f), p1.a(this.b.getApplicationContext(), 16.0f), p1.a(this.b.getApplicationContext(), 13.0f));
                        relativeLayout14.addView(textView8, layoutParams24);
                        vVar2.j = textView8;
                        relativeLayout14.setPadding(0, 0, 0, p1.a(this.b.getApplicationContext(), 10.0f));
                        RelativeLayout.LayoutParams layoutParams25 = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams25.addRule(3, relativeLayout15.getId());
                        relativeLayout13.addView(relativeLayout14, layoutParams25);
                        relativeLayout13.setOnClickListener(new l(this));
                        relativeLayout13.setTag(2031091713, vVar2);
                        relativeLayout13.setTag(2031091712, Integer.valueOf(i8));
                        vVar = vVar2;
                        relativeLayout = relativeLayout13;
                        i3 = i8;
                        xVar = null;
                        tVar = null;
                        uVar = null;
                        relativeLayout3 = relativeLayout;
                        wVar = null;
                    } else {
                        obj = "contenttype";
                        obj2 = "content";
                        if (i3 == 4) {
                            t tVar2 = new t();
                            RelativeLayout relativeLayout17 = new RelativeLayout(this.a);
                            RelativeLayout relativeLayout18 = new RelativeLayout(this.a);
                            RelativeLayout relativeLayout19 = new RelativeLayout(this.a);
                            ViewGroup.LayoutParams layoutParams26 = new AbsListView.LayoutParams(-1, -2);
                            relativeLayout17.setBackgroundColor(-1);
                            relativeLayout18.setBackgroundColor(-1);
                            relativeLayout19.setBackgroundColor(-1);
                            relativeLayout17.setLayoutParams(layoutParams26);
                            relativeLayout19.setId(2030632968);
                            relativeLayout19.setClickable(false);
                            TextView textView9 = new TextView(this.b);
                            textView9.setBackgroundResource(R.drawable.obfuscated_res_0x7f081544);
                            textView9.setTextColor(-1);
                            textView9.setTextSize(1, 12.0f);
                            textView9.setGravity(17);
                            textView9.setMovementMethod(LinkMovementMethod.getInstance());
                            textView9.setPadding(p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 2.0f) + 2, p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 2.0f));
                            RelativeLayout.LayoutParams layoutParams27 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams27.setMargins(0, p1.a(this.b.getApplicationContext(), 10.0f), 0, 0);
                            layoutParams27.addRule(14);
                            relativeLayout19.addView(textView9, layoutParams27);
                            ViewGroup.LayoutParams layoutParams28 = new RelativeLayout.LayoutParams(-1, -2);
                            relativeLayout19.setPadding(0, p1.a(this.b.getApplicationContext(), 6.0f), 0, p1.a(this.b.getApplicationContext(), 8.0f));
                            relativeLayout17.addView(relativeLayout19, layoutParams28);
                            tVar2.a = textView9;
                            tVar2.d = relativeLayout19;
                            ImageView imageView6 = new ImageView(this.b);
                            imageView6.setId(2030632966);
                            RelativeLayout.LayoutParams layoutParams29 = new RelativeLayout.LayoutParams(p1.a(this.b.getApplicationContext(), 40.0f), p1.a(this.b.getApplicationContext(), 40.0f));
                            layoutParams29.setMargins(p1.a(this.b.getApplicationContext(), 8.0f), 0, p1.a(this.b.getApplicationContext(), 4.0f), 0);
                            layoutParams29.addRule(9);
                            relativeLayout18.addView(imageView6, layoutParams29);
                            tVar2.b = imageView6;
                            RelativeLayout relativeLayout20 = new RelativeLayout(this.b);
                            relativeLayout20.setBackgroundResource(R.drawable.obfuscated_res_0x7f08154d);
                            relativeLayout20.setPadding(11, p1.a(this.b.getApplicationContext(), 1.2f), p1.a(this.b.getApplicationContext(), 1.0f), p1.a(this.b.getApplicationContext(), 1.0f));
                            ImageView imageView7 = new ImageView(this.b);
                            imageView7.setOnClickListener(new m(this));
                            imageView7.setScaleType(ImageView.ScaleType.FIT_XY);
                            if (p1.a() < 23) {
                                imageView7.setAdjustViewBounds(true);
                                RelativeLayout.LayoutParams layoutParams30 = new RelativeLayout.LayoutParams(-2, -2);
                                i4 = 0;
                                layoutParams30.setMargins(0, 0, 0, 0);
                                relativeLayout20.addView(imageView7, layoutParams30);
                            } else {
                                i4 = 0;
                                RelativeLayout.LayoutParams layoutParams31 = new RelativeLayout.LayoutParams(p1.a(this.b.getApplicationContext(), 80.0f), p1.a(this.b.getApplicationContext(), 120.0f));
                                layoutParams31.setMargins(0, 0, 0, 0);
                                relativeLayout20.addView(imageView7, layoutParams31);
                            }
                            RelativeLayout.LayoutParams layoutParams32 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams32.setMargins(i4, i4, p1.a(this.b.getApplicationContext(), 57.0f), i4);
                            layoutParams32.addRule(1, imageView6.getId());
                            relativeLayout18.addView(relativeLayout20, layoutParams32);
                            tVar2.c = imageView7;
                            relativeLayout18.setPadding(i4, i4, i4, p1.a(this.b.getApplicationContext(), 10.0f));
                            RelativeLayout.LayoutParams layoutParams33 = new RelativeLayout.LayoutParams(-1, -2);
                            layoutParams33.addRule(3, relativeLayout19.getId());
                            relativeLayout17.addView(relativeLayout18, layoutParams33);
                            relativeLayout17.setOnClickListener(new n(this));
                            relativeLayout17.setTag(2031091713, tVar2);
                            relativeLayout17.setTag(2031091712, Integer.valueOf(i3));
                            tVar = tVar2;
                            relativeLayout5 = relativeLayout17;
                            xVar = null;
                            view4 = relativeLayout5;
                            uVar = null;
                            view3 = view4;
                            vVar = null;
                            relativeLayout3 = view3;
                            wVar = null;
                        } else {
                            if (i3 == 5) {
                                u uVar2 = new u();
                                RelativeLayout relativeLayout21 = new RelativeLayout(this.a);
                                RelativeLayout relativeLayout22 = new RelativeLayout(this.a);
                                RelativeLayout relativeLayout23 = new RelativeLayout(this.a);
                                ViewGroup.LayoutParams layoutParams34 = new AbsListView.LayoutParams(-1, -2);
                                relativeLayout21.setBackgroundColor(-1);
                                relativeLayout22.setBackgroundColor(-1);
                                relativeLayout23.setBackgroundColor(-1);
                                relativeLayout21.setLayoutParams(layoutParams34);
                                relativeLayout23.setId(2030632968);
                                relativeLayout23.setClickable(false);
                                TextView textView10 = new TextView(this.b);
                                textView10.setBackgroundResource(R.drawable.obfuscated_res_0x7f081544);
                                textView10.setTextColor(-1);
                                textView10.setTextSize(1, 12.0f);
                                textView10.setGravity(17);
                                textView10.setMovementMethod(LinkMovementMethod.getInstance());
                                textView10.setPadding(p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 2.0f) + 2, p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 2.0f));
                                RelativeLayout.LayoutParams layoutParams35 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams35.setMargins(0, p1.a(this.b.getApplicationContext(), 10.0f), 0, 0);
                                layoutParams35.addRule(14);
                                relativeLayout23.addView(textView10, layoutParams35);
                                ViewGroup.LayoutParams layoutParams36 = new RelativeLayout.LayoutParams(-1, -2);
                                relativeLayout23.setPadding(0, p1.a(this.b.getApplicationContext(), 6.0f), 0, p1.a(this.b.getApplicationContext(), 8.0f));
                                relativeLayout21.addView(relativeLayout23, layoutParams36);
                                uVar2.a = textView10;
                                uVar2.f = relativeLayout23;
                                ImageView imageView8 = new ImageView(this.b);
                                imageView8.setId(2030632966);
                                RelativeLayout.LayoutParams layoutParams37 = new RelativeLayout.LayoutParams(p1.a(this.b.getApplicationContext(), 40.0f), p1.a(this.b.getApplicationContext(), 40.0f));
                                layoutParams37.setMargins(p1.a(this.b.getApplicationContext(), 8.0f), 0, p1.a(this.b.getApplicationContext(), 4.0f), 0);
                                layoutParams37.addRule(9);
                                relativeLayout22.addView(imageView8, layoutParams37);
                                uVar2.b = imageView8;
                                LinearLayout linearLayout3 = new LinearLayout(this.b);
                                linearLayout3.setOrientation(1);
                                linearLayout3.setId(2031091718);
                                linearLayout3.setBackgroundResource(R.drawable.obfuscated_res_0x7f08154e);
                                linearLayout3.setPadding(10, 3, 2, 2);
                                TextView textView11 = new TextView(this.b);
                                textView11.setGravity(16);
                                textView11.setLineSpacing(5.0f, 1.0f);
                                textView11.setSingleLine(false);
                                textView11.setTextColor(-13421773);
                                textView11.setBackgroundColor(BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT);
                                textView11.setTextSize(1, 17.0f);
                                textView11.setPadding(p1.a(this.b.getApplicationContext(), 10.0f), p1.a(this.b.getApplicationContext(), 5.0f), 0, p1.a(this.b.getApplicationContext(), 5.0f));
                                linearLayout3.addView(textView11, new LinearLayout.LayoutParams(-1, -2));
                                uVar2.d = textView11;
                                j0 j0Var = new j0(this.b);
                                j0Var.setBackgroundColor(-1);
                                j0Var.setDivider(new ColorDrawable(-855310));
                                j0Var.setDividerHeight(0);
                                linearLayout3.addView(j0Var, new LinearLayout.LayoutParams(-1, -2));
                                uVar2.c = j0Var;
                                View view5 = new View(this.b);
                                view5.setBackgroundColor(BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT);
                                view5.setVisibility(8);
                                linearLayout3.addView(view5, new LinearLayout.LayoutParams(-1, p1.a(this.b.getApplicationContext(), 1.0f)));
                                LinearLayout linearLayout4 = new LinearLayout(this.b);
                                linearLayout4.setBackgroundColor(-1);
                                TextView textView12 = new TextView(this.b);
                                textView12.setGravity(16);
                                textView12.setBackgroundColor(-1);
                                textView12.setLineSpacing(5.0f, 1.0f);
                                textView12.setTextColor(-13421773);
                                textView12.setTextSize(1, 14.0f);
                                textView12.setAutoLinkMask(1);
                                LinearLayout.LayoutParams layoutParams38 = new LinearLayout.LayoutParams(-1, -2);
                                layoutParams38.setMargins(p1.a(this.b.getApplicationContext(), 5.0f), p1.a(this.b.getApplicationContext(), 5.0f), p1.a(this.b.getApplicationContext(), 15.0f), p1.a(this.b.getApplicationContext(), 5.0f));
                                linearLayout4.addView(textView12, layoutParams38);
                                uVar2.e = textView12;
                                RelativeLayout.LayoutParams layoutParams39 = new RelativeLayout.LayoutParams(-1, -2);
                                layoutParams39.setMargins(0, 0, p1.a(this.b.getApplicationContext(), 57.0f), 0);
                                layoutParams39.addRule(1, imageView8.getId());
                                relativeLayout22.addView(linearLayout3, layoutParams39);
                                RelativeLayout.LayoutParams layoutParams40 = new RelativeLayout.LayoutParams(-1, -2);
                                layoutParams40.addRule(1, imageView8.getId());
                                layoutParams40.addRule(3, linearLayout3.getId());
                                relativeLayout22.addView(linearLayout4, layoutParams40);
                                relativeLayout22.setPadding(0, 0, 0, p1.a(this.b.getApplicationContext(), 10.0f));
                                RelativeLayout.LayoutParams layoutParams41 = new RelativeLayout.LayoutParams(-1, -2);
                                layoutParams41.addRule(3, relativeLayout23.getId());
                                relativeLayout21.addView(relativeLayout22, layoutParams41);
                                relativeLayout21.setTag(2031091713, uVar2);
                                relativeLayout21.setTag(2031091712, Integer.valueOf(i3));
                                uVar = uVar2;
                                relativeLayout4 = relativeLayout21;
                                xVar = null;
                                tVar = null;
                                view3 = relativeLayout4;
                                vVar = null;
                                relativeLayout3 = view3;
                                wVar = null;
                            }
                            relativeLayout2 = view2;
                            xVar = null;
                            tVar = null;
                            view4 = relativeLayout2;
                            uVar = null;
                            view3 = view4;
                            vVar = null;
                            relativeLayout3 = view3;
                            wVar = null;
                        }
                    }
                } else if (i3 == 1) {
                    wVar = (w) view2.getTag(2031091713);
                    relativeLayout3 = view2;
                    obj = "contenttype";
                    obj2 = "content";
                    xVar = null;
                    tVar = null;
                    uVar = null;
                    vVar = null;
                } else if (i3 == 2) {
                    relativeLayout2 = view2;
                    obj = "contenttype";
                    obj2 = "content";
                    xVar = (x) view2.getTag(2031091713);
                    tVar = null;
                    view4 = relativeLayout2;
                    uVar = null;
                    view3 = view4;
                    vVar = null;
                    relativeLayout3 = view3;
                    wVar = null;
                } else if (i3 == 3) {
                    relativeLayout = view2;
                    obj = "contenttype";
                    obj2 = "content";
                    vVar = (v) view2.getTag(2031091713);
                    xVar = null;
                    tVar = null;
                    uVar = null;
                    relativeLayout3 = relativeLayout;
                    wVar = null;
                } else if (i3 == 4) {
                    relativeLayout5 = view2;
                    obj = "contenttype";
                    obj2 = "content";
                    tVar = (t) view2.getTag(2031091713);
                    xVar = null;
                    view4 = relativeLayout5;
                    uVar = null;
                    view3 = view4;
                    vVar = null;
                    relativeLayout3 = view3;
                    wVar = null;
                } else if (i3 == 5) {
                    relativeLayout4 = view2;
                    obj = "contenttype";
                    obj2 = "content";
                    uVar = (u) view2.getTag(2031091713);
                    xVar = null;
                    tVar = null;
                    view3 = relativeLayout4;
                    vVar = null;
                    relativeLayout3 = view3;
                    wVar = null;
                } else {
                    obj = "contenttype";
                    obj2 = "content";
                    relativeLayout2 = view2;
                    xVar = null;
                    tVar = null;
                    view4 = relativeLayout2;
                    uVar = null;
                    view3 = view4;
                    vVar = null;
                    relativeLayout3 = view3;
                    wVar = null;
                }
                if (i3 != 1 || wVar == null) {
                    Object obj3 = obj2;
                    Object obj4 = obj;
                    if (i3 == 2 && xVar != null) {
                        xVar.d.setVisibility(0);
                        if (i2 == 0) {
                            xVar.a.setText(p1.c(Long.parseLong((String) ((Map) this.b.o.get(i2)).get("time"))));
                        } else {
                            long parseLong = Long.parseLong((String) ((Map) this.b.o.get(i2 - 1)).get("time"));
                            long parseLong2 = Long.parseLong((String) ((Map) this.b.o.get(i2)).get("time"));
                            long j2 = parseLong - parseLong2;
                            if (j2 <= 3600000 && parseLong2 - parseLong <= 3600000) {
                                xVar.d.setVisibility(8);
                            } else {
                                xVar.a.setText(p1.b(parseLong2));
                                if (j2 > 86400000 || parseLong2 - parseLong > 86400000) {
                                    xVar.a.setText(p1.c(parseLong2));
                                }
                            }
                        }
                        try {
                            xVar.b.setBackgroundDrawable(new BitmapDrawable(p1.c(this.b.getApplicationContext())));
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        xVar.c.setText((String) ((Map) this.b.o.get(i2)).get(obj3));
                    } else if (i3 == 3 && vVar != null) {
                        vVar.d.setVisibility(0);
                        if (i2 == 0) {
                            vVar.a.setText(p1.c(Long.parseLong((String) ((Map) this.b.o.get(i2)).get("time"))));
                        } else {
                            long parseLong3 = Long.parseLong((String) ((Map) this.b.o.get(i2 - 1)).get("time"));
                            long parseLong4 = Long.parseLong((String) ((Map) this.b.o.get(i2)).get("time"));
                            long j3 = parseLong3 - parseLong4;
                            if (j3 <= 3600000 && parseLong4 - parseLong3 <= 3600000) {
                                vVar.d.setVisibility(8);
                            } else {
                                vVar.a.setText(p1.b(parseLong4));
                                if (j3 > 86400000 || parseLong4 - parseLong3 > 86400000) {
                                    vVar.a.setText(p1.c(parseLong4));
                                }
                            }
                        }
                        try {
                            vVar.b.setBackgroundDrawable(new BitmapDrawable(p1.b(this.b.getApplicationContext(), "ufo_defult_server_icon.png")));
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        if (vVar.c != null) {
                            String valueOf = String.valueOf(((Map) this.b.o.get(i2)).get(obj3));
                            if (!valueOf.startsWith("http://bs.baidu.com") && !valueOf.startsWith("https://bs.baidu.com")) {
                                if (valueOf.contains("<a") && valueOf.contains("</a>")) {
                                    vVar.c.setText(a(valueOf));
                                    vVar.c.setMovementMethod(LinkMovementMethod.getInstance());
                                } else if (valueOf.contains("我的反馈")) {
                                    String str2 = "**********************indexof : 我的反馈: " + valueOf.lastIndexOf("我的反馈");
                                    this.b.z = true;
                                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(valueOf);
                                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-11821318), valueOf.lastIndexOf("我的反馈"), valueOf.lastIndexOf("我的反馈") + 4, 33);
                                    vVar.c.setText(spannableStringBuilder);
                                    if (this.b.E == null) {
                                        this.b.E = new ArrayList();
                                        this.b.E.add(vVar.c);
                                    }
                                } else if (valueOf.contains("人工反馈")) {
                                    String str3 = "**********************lastIndexof : 人工反馈: " + valueOf.lastIndexOf("人工反馈");
                                    this.b.z = !feedbackInputActivity.d0;
                                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(valueOf);
                                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(-12814593), valueOf.lastIndexOf("人工反馈"), valueOf.lastIndexOf("人工反馈") + 4, 33);
                                    if (this.b.d0) {
                                        vVar.c.setText(valueOf);
                                    } else {
                                        vVar.c.setText(spannableStringBuilder2);
                                    }
                                    if (this.b.E == null) {
                                        this.b.E = new ArrayList();
                                        this.b.E.add(vVar.c);
                                    }
                                } else {
                                    vVar.c.setText(valueOf);
                                }
                            } else {
                                Bitmap a3 = m1.a().a(new r1(this.b.getApplicationContext(), vVar.c, this.b.W), valueOf);
                                if (a3 != null) {
                                    ImageSpan imageSpan = new ImageSpan(this.b.getApplicationContext(), a3);
                                    SpannableString spannableString = new SpannableString("icon");
                                    spannableString.setSpan(imageSpan, 0, 4, 33);
                                    vVar.c.setText(spannableString.toString());
                                }
                            }
                        }
                        try {
                            i6 = ((Integer) ((Map) this.b.o.get(i2)).get("ask")).intValue();
                        } catch (Exception unused) {
                            i6 = 0;
                        }
                        if (i6 == 0) {
                            vVar.e.setVisibility(8);
                            vVar.h.setVisibility(8);
                            vVar.i.setVisibility(8);
                            vVar.j.setVisibility(8);
                        } else if (i6 == 1) {
                            vVar.h.setVisibility(8);
                            vVar.i.setVisibility(8);
                            vVar.j.setVisibility(8);
                            vVar.e.setVisibility(0);
                            vVar.g.setClickable(true);
                            vVar.f.setClickable(true);
                            vVar.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f0813d0);
                            vVar.g.setBackgroundResource(R.drawable.obfuscated_res_0x7f0813d0);
                        } else if (i6 == 2) {
                            vVar.e.setVisibility(0);
                            vVar.j.setVisibility(8);
                            vVar.g.setClickable(false);
                            vVar.f.setClickable(false);
                            vVar.h.setVisibility(8);
                            vVar.i.setVisibility(8);
                            vVar.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f081540);
                            vVar.g.setBackgroundResource(R.drawable.obfuscated_res_0x7f08153f);
                        } else if (i6 == 3) {
                            vVar.e.setVisibility(0);
                            vVar.j.setVisibility(8);
                            vVar.f.setClickable(false);
                            vVar.g.setClickable(false);
                            vVar.h.setVisibility(8);
                            vVar.i.setVisibility(8);
                            vVar.g.setBackgroundResource(R.drawable.obfuscated_res_0x7f081540);
                            vVar.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f08153f);
                        } else if (i6 == 9) {
                            if (this.b.K != 0) {
                                i7 = 0;
                                vVar.j.setVisibility(0);
                            } else {
                                i7 = 0;
                            }
                            vVar.e.setVisibility(8);
                            vVar.h.setVisibility(i7);
                            vVar.i.setVisibility(i7);
                            vVar.i.setBackgroundDrawable(new BitmapDrawable(p1.b(this.b.getApplicationContext(), "ufo_not_solved.png")));
                        } else if (i6 == 11) {
                            vVar.j.setVisibility(8);
                            vVar.e.setVisibility(8);
                            vVar.h.setVisibility(0);
                            vVar.i.setVisibility(0);
                            vVar.i.setBackgroundDrawable(new BitmapDrawable(p1.b(this.b.getApplicationContext(), "ufo_solved.png")));
                        }
                        if ((i6 == 3 || i6 == 9) && this.b.K != 0) {
                            vVar.j.setVisibility(0);
                            if (((Map) this.b.o.get(i2)).containsKey("isClicked")) {
                                vVar.j.setTextColor(p1.a(2034005759, -15644211, 2034005759, 2034005759));
                                Drawable a4 = p1.a(this.a, (int) R.drawable.obfuscated_res_0x7f081550);
                                a4.setAlpha(127);
                                a4.setBounds(p1.a(this.a, 1.0f), p1.a(this.a, 1.0f), p1.a(this.a, 14.0f), p1.a(this.a, 14.0f));
                                vVar.j.setCompoundDrawables(null, null, a4, null);
                            } else {
                                vVar.j.setTextColor(p1.a(-12814593, -15644211, -12814593, -12814593));
                                Drawable a5 = p1.a(this.a, (int) R.drawable.obfuscated_res_0x7f08154f);
                                a5.setBounds(p1.a(this.a, 1.0f), p1.a(this.a, 1.0f), p1.a(this.a, 14.0f), p1.a(this.a, 14.0f));
                                vVar.j.setCompoundDrawables(null, null, a5, null);
                            }
                            String str4 = (String) ((Map) this.b.o.get(i2)).get("discontent_reason");
                            JSONArray jSONArray = (JSONArray) ((Map) this.b.o.get(i2)).get("discontent_labels");
                            if (TextUtils.isEmpty(str4) && (jSONArray == null || jSONArray.length() == 0)) {
                                vVar.j.setText("填写不满意原因");
                            } else {
                                vVar.j.setText("查看不满意原因");
                            }
                            vVar.j.setOnClickListener(new a(this, str4, jSONArray, i2));
                        }
                        if (i6 == 1) {
                            vVar.f.setOnClickListener(new b(this, i2));
                            vVar.g.setOnClickListener(new c(this, i2));
                        } else {
                            vVar.f.setClickable(false);
                            vVar.f.setOnClickListener(null);
                            vVar.g.setClickable(false);
                            vVar.g.setOnClickListener(null);
                        }
                    } else if (i3 == 4 && tVar != null) {
                        tVar.d.setVisibility(0);
                        if (i2 == 0) {
                            tVar.a.setText(p1.c(Long.parseLong((String) ((Map) this.b.o.get(i2)).get("time"))));
                        } else {
                            long parseLong5 = Long.parseLong((String) ((Map) this.b.o.get(i2 - 1)).get("time"));
                            long parseLong6 = Long.parseLong((String) ((Map) this.b.o.get(i2)).get("time"));
                            long j4 = parseLong5 - parseLong6;
                            if (j4 <= 3600000 && parseLong6 - parseLong5 <= 3600000) {
                                tVar.d.setVisibility(8);
                            } else {
                                tVar.a.setText(p1.b(parseLong6));
                                if (j4 > 86400000 || parseLong6 - parseLong5 > 86400000) {
                                    tVar.a.setText(p1.c(parseLong6));
                                }
                            }
                        }
                        try {
                            tVar.b.setBackgroundDrawable(new BitmapDrawable(p1.b(this.b.getApplicationContext(), "ufo_defult_server_icon.png")));
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        if (!((String) ((Map) this.b.o.get(i2)).get(obj4)).contentEquals("1") && !((Map) this.b.o.get(i2)).get(obj3).toString().startsWith("http://bs.baidu.com") && !((Map) this.b.o.get(i2)).get(obj3).toString().startsWith("https://bs.baidu.com")) {
                            if (((String) ((Map) this.b.o.get(i2)).get(obj4)).contentEquals("2") && tVar.c != null) {
                                Bitmap bitmap = (Bitmap) ((Map) this.b.o.get(i2)).get(obj3);
                                if (bitmap.getHeight() > bitmap.getWidth()) {
                                    tVar.c.setMaxWidth(p1.a(this.b.getApplicationContext(), 80.0f));
                                    tVar.c.setMaxHeight(p1.a(this.b.getApplicationContext(), 120.0f));
                                } else {
                                    tVar.c.setMaxWidth(p1.a(this.b.getApplicationContext(), 120.0f));
                                    tVar.c.setMaxHeight(p1.a(this.b.getApplicationContext(), 80.0f));
                                }
                                tVar.c.setImageBitmap(bitmap);
                            }
                        } else {
                            tVar.c.setImageBitmap(p1.b(this.a, "ufo_pic_defult_icon.png"));
                            Bitmap a6 = m1.a().a(new r1(this.b.getApplicationContext(), tVar.c, this.b.W), (String) ((Map) this.b.o.get(i2)).get(obj3));
                            if (a6 != null) {
                                tVar.c.setImageBitmap(a6);
                                if (a6.getHeight() > a6.getWidth()) {
                                    tVar.c.setMaxWidth(p1.a(this.b.getApplicationContext(), 80.0f));
                                    tVar.c.setMaxHeight(p1.a(this.b.getApplicationContext(), 120.0f));
                                } else {
                                    tVar.c.setMaxWidth(p1.a(this.b.getApplicationContext(), 120.0f));
                                    tVar.c.setMaxHeight(p1.a(this.b.getApplicationContext(), 80.0f));
                                }
                            }
                        }
                    } else if (i3 == 5 && uVar != null) {
                        uVar.f.setVisibility(0);
                        if (i2 == 0) {
                            uVar.a.setText(p1.c(Long.parseLong((String) ((Map) this.b.o.get(i2)).get("time"))));
                        } else {
                            long parseLong7 = Long.parseLong((String) ((Map) this.b.o.get(i2 - 1)).get("time"));
                            long parseLong8 = Long.parseLong((String) ((Map) this.b.o.get(i2)).get("time"));
                            long j5 = parseLong7 - parseLong8;
                            if (j5 <= 3600000 && parseLong8 - parseLong7 <= 3600000) {
                                uVar.f.setVisibility(8);
                            } else {
                                uVar.a.setText(p1.b(parseLong8));
                                if (j5 > 86400000 || parseLong8 - parseLong7 > 86400000) {
                                    uVar.a.setText(p1.c(parseLong8));
                                }
                            }
                        }
                        try {
                            uVar.b.setBackgroundDrawable(new BitmapDrawable(p1.b(this.b.getApplicationContext(), "ufo_defult_server_icon.png")));
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        FeedbackInputActivity feedbackInputActivity2 = this.b;
                        h1 h1Var = new h1(feedbackInputActivity2, (JSONArray) ((Map) feedbackInputActivity2.o.get(i2)).get(obj3), ((Integer) ((Map) this.b.o.get(i2)).get("subtype")).intValue());
                        if (((Integer) ((Map) this.b.o.get(i2)).get("subtype")).intValue() == 1) {
                            uVar.d.setText("请选择问题发生的场景");
                            uVar.e.setVisibility(8);
                        } else {
                            String str5 = "";
                            try {
                                str = (String) ((Map) this.b.o.get(i2)).get("tip");
                            } catch (Exception e7) {
                                e = e7;
                            }
                            try {
                                if (TextUtils.isEmpty(str)) {
                                    str = "您是不是要问以下问题？";
                                }
                            } catch (Exception e8) {
                                e = e8;
                                str5 = str;
                                e.printStackTrace();
                                str = str5;
                                uVar.d.setText(str);
                                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("没有想要的，进入人工反馈");
                                spannableStringBuilder3.setSpan(new ForegroundColorSpan(-12814593), 8, 12, 33);
                                if (!this.b.d0) {
                                }
                                uVar.e.setVisibility(0);
                                uVar.e.setOnClickListener(new d(this));
                                uVar.c.setAdapter((ListAdapter) h1Var);
                                uVar.c.setOnItemClickListener(new e(this, i2));
                                FeedbackInputActivity.a(this.b, uVar.c);
                                return relativeLayout3;
                            }
                            uVar.d.setText(str);
                            SpannableStringBuilder spannableStringBuilder32 = new SpannableStringBuilder("没有想要的，进入人工反馈");
                            spannableStringBuilder32.setSpan(new ForegroundColorSpan(-12814593), 8, 12, 33);
                            if (!this.b.d0) {
                                uVar.e.setText("没有想要的，进入人工反馈");
                            } else {
                                uVar.e.setText(spannableStringBuilder32);
                            }
                            uVar.e.setVisibility(0);
                            uVar.e.setOnClickListener(new d(this));
                        }
                        uVar.c.setAdapter((ListAdapter) h1Var);
                        uVar.c.setOnItemClickListener(new e(this, i2));
                        FeedbackInputActivity.a(this.b, uVar.c);
                    }
                } else {
                    wVar.d.setVisibility(0);
                    if (i2 == 0) {
                        wVar.a.setText(p1.c(Long.parseLong((String) ((Map) this.b.o.get(i2)).get("time"))));
                    } else {
                        long parseLong9 = Long.parseLong((String) ((Map) this.b.o.get(i2 - 1)).get("time"));
                        long parseLong10 = Long.parseLong((String) ((Map) this.b.o.get(i2)).get("time"));
                        long j6 = parseLong9 - parseLong10;
                        if (j6 <= 3600000 && parseLong10 - parseLong9 <= 3600000) {
                            wVar.d.setVisibility(8);
                        } else {
                            wVar.a.setText(p1.b(parseLong10));
                            if (j6 > 86400000 || parseLong10 - parseLong9 > 86400000) {
                                wVar.a.setText(p1.c(parseLong10));
                            }
                        }
                    }
                    try {
                        wVar.b.setBackgroundDrawable(new BitmapDrawable(p1.c(this.b.getApplicationContext())));
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                    Object obj5 = obj;
                    if (((String) ((Map) this.b.o.get(i2)).get(obj5)).contentEquals("1")) {
                        wVar.c.setImageBitmap(p1.b(this.a, "ufo_pic_defult_icon.png"));
                        Bitmap a7 = m1.a().a(new r1(this.b.getApplicationContext(), wVar.c, this.b.W), (String) ((Map) this.b.o.get(i2)).get(obj2));
                        if (a7 != null) {
                            wVar.c.setImageBitmap(a7);
                            if (a7.getHeight() > a7.getWidth()) {
                                wVar.c.setMaxWidth(p1.a(this.b.getApplicationContext(), 80.0f));
                                wVar.c.setMaxHeight(p1.a(this.b.getApplicationContext(), 120.0f));
                            } else {
                                wVar.c.setMaxWidth(p1.a(this.b.getApplicationContext(), 120.0f));
                                wVar.c.setMaxHeight(p1.a(this.b.getApplicationContext(), 80.0f));
                            }
                        }
                    } else {
                        Object obj6 = obj2;
                        if (((String) ((Map) this.b.o.get(i2)).get(obj5)).contentEquals("2") && wVar.c != null) {
                            Bitmap bitmap2 = (Bitmap) ((Map) this.b.o.get(i2)).get(obj6);
                            if (bitmap2.getHeight() > bitmap2.getWidth()) {
                                wVar.c.setMaxWidth(p1.a(this.b.getApplicationContext(), 80.0f));
                                wVar.c.setMaxHeight(p1.a(this.b.getApplicationContext(), 120.0f));
                            } else {
                                wVar.c.setMaxWidth(p1.a(this.b.getApplicationContext(), 120.0f));
                                wVar.c.setMaxHeight(p1.a(this.b.getApplicationContext(), 80.0f));
                            }
                            wVar.c.setImageBitmap(bitmap2);
                        }
                    }
                }
                return relativeLayout3;
            }
            return (View) invokeILL.objValue;
        }

        /* loaded from: classes9.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ s b;

            /* loaded from: classes9.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                public a(b bVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        b bVar = this.a;
                        if (bVar.b.b.o.get(bVar.a).containsKey("chatId")) {
                            StringBuilder sb = new StringBuilder();
                            b bVar2 = this.a;
                            sb.append(bVar2.b.b.o.get(bVar2.a).get("chatId"));
                            sb.append("");
                            str = sb.toString();
                        } else {
                            str = this.a.b.b.m;
                        }
                        FeedbackInputActivity feedbackInputActivity = this.a.b.b;
                        com.baidu.ufosdk.b.a(feedbackInputActivity, str, 11, feedbackInputActivity.n);
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put("appid", this.a.b.b.l0.b);
                            hashMap.put("id", this.a.b.b.l);
                            String b = com.baidu.ufosdk.b.b(com.baidu.ufosdk.b.a(hashMap));
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("sdk_encrypt", b);
                            String a = d0.a(s1.m, d0.a(hashMap2));
                            Context context = this.a.b.a;
                            String str2 = this.a.b.b.l0.a;
                            com.baidu.ufosdk.b.c(context, this.a.b.b.l, this.a.b.b.l0.b);
                            this.a.b.b.W.obtainMessage(7, a).sendToTarget();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            public b(s sVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = sVar;
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.b.b.o.get(this.a).put("ask", 2);
                    new Thread(new a(this)).start();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ s b;

            /* loaded from: classes9.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                public a(c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = cVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        try {
                            com.baidu.ufosdk.b.a(this.a.b.b, this.a.b.b.m, 9, this.a.b.b.n);
                            Context context = this.a.b.a;
                            String str = this.a.b.b.l0.a;
                            com.baidu.ufosdk.b.c(context, this.a.b.b.l, this.a.b.b.l0.b);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            public c(s sVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = sVar;
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    FeedbackInputActivity feedbackInputActivity = this.b.b;
                    int i = this.a;
                    feedbackInputActivity.H = i;
                    feedbackInputActivity.o.get(i).put("ask", 3);
                    if (this.b.b.o.get(this.a).containsKey("chatId")) {
                        FeedbackInputActivity feedbackInputActivity2 = this.b.b;
                        feedbackInputActivity2.m = this.b.b.o.get(this.a).get("chatId") + "";
                    }
                    this.b.b.s.execute(new a(this));
                    FeedbackInputActivity.a(this.b.b, false, true);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class e implements AdapterView.OnItemClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public String b;
            public final /* synthetic */ int c;
            public final /* synthetic */ s d;

            /* loaded from: classes9.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                public a(e eVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {eVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = eVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.a.d.b.Q = false;
                    FeedbackInputActivity feedbackInputActivity = this.a.d.b;
                    Context applicationContext = feedbackInputActivity.getApplicationContext();
                    e eVar = this.a;
                    FeedbackInputActivity feedbackInputActivity2 = eVar.d.b;
                    feedbackInputActivity.a(applicationContext, feedbackInputActivity2.l0.a, feedbackInputActivity2.l, feedbackInputActivity2.n, eVar.b, feedbackInputActivity2.f0, null, feedbackInputActivity2.W, eVar.a);
                }
            }

            public e(s sVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = sVar;
                this.c = i;
                this.a = 0;
                this.b = null;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                    String str = "FeedbackInputActiviy --> FeedbackInput item clicked! " + i;
                    if (((Integer) this.d.b.o.get(this.c).get("subtype")).intValue() == 0) {
                        String str2 = "FeedbackInputActiviy clicked! -- > \n" + this.d.b.o.get(this.c).get("content").toString();
                        try {
                            JSONObject jSONObject = (JSONObject) ((JSONArray) this.d.b.o.get(this.c).get("content")).get(i);
                            this.a = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_QID);
                            this.b = jSONObject.getString("question");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        new Thread(new a(this)).start();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setClass(this.d.b, FeedbackEditActivity.class);
                    intent.putExtra("msgid", this.d.b.l);
                    intent.putExtra("feedback_channel", com.baidu.ufosdk.b.h());
                    intent.putExtra("come_from", 0);
                    this.d.b.startActivity(intent);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ JSONArray b;
            public final /* synthetic */ int c;
            public final /* synthetic */ s d;

            public a(s sVar, String str, JSONArray jSONArray, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar, str, jSONArray, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = sVar;
                this.a = str;
                this.b = jSONArray;
                this.c = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                JSONArray jSONArray;
                JSONArray jSONArray2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (!TextUtils.isEmpty(this.a) || ((jSONArray2 = this.b) != null && jSONArray2.length() != 0)) {
                        this.d.b.o.get(this.c).put("isClicked", 1);
                    }
                    FeedbackInputActivity feedbackInputActivity = this.d.b;
                    int i = this.c;
                    feedbackInputActivity.H = i;
                    if (feedbackInputActivity.o.get(i).containsKey("chatId")) {
                        FeedbackInputActivity feedbackInputActivity2 = this.d.b;
                        feedbackInputActivity2.m = this.d.b.o.get(this.c).get("chatId") + "";
                    }
                    if (TextUtils.isEmpty(this.a) && ((jSONArray = this.b) == null || jSONArray.length() == 0)) {
                        FeedbackInputActivity.a(this.d.b, false, false);
                    } else {
                        FeedbackInputActivity.a(this.d.b, true, false);
                    }
                    this.d.b.q.notifyDataSetChanged();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

            public d(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    FeedbackInputActivity feedbackInputActivity = this.a.b;
                    if (!feedbackInputActivity.d0) {
                        feedbackInputActivity.W.obtainMessage(10).sendToTarget();
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class f implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

            public f(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    try {
                        FeedbackInputActivity.m0 = ((BitmapDrawable) ((ImageView) view2).getDrawable()).getBitmap();
                        this.a.b.startActivity(new Intent(this.a.b, FeedbackImageViewFlipperActivity.class));
                    } catch (Exception unused) {
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class g implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public g(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    view2.setBackgroundColor(-1184275);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class h implements View.OnLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

            public h(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                    this.a.b.a(view2);
                    return false;
                }
                return invokeL.booleanValue;
            }
        }

        /* loaded from: classes9.dex */
        public class i implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public i(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    view2.setBackgroundColor(-1184275);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class j implements View.OnLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

            public j(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                    this.a.b.a(view2);
                    return false;
                }
                return invokeL.booleanValue;
            }
        }

        /* loaded from: classes9.dex */
        public class k implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

            public k(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    String charSequence = ((TextView) view2).getText().toString();
                    if (!com.baidu.ufosdk.b.n() && this.a.b.z && charSequence.contains("我的反馈")) {
                        this.a.b.y = true;
                        Intent intent = new Intent(this.a.b, FeedbackListActivity.class);
                        intent.putExtra("feedback_channel", com.baidu.ufosdk.b.h());
                        this.a.b.startActivity(intent);
                        this.a.b.finish();
                    } else if (!com.baidu.ufosdk.b.n() && this.a.b.z && charSequence.contains("人工反馈")) {
                        this.a.b.W.obtainMessage(10).sendToTarget();
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class l implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public l(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    view2.setBackgroundColor(-1184275);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class m implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

            public m(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    try {
                        FeedbackInputActivity.m0 = ((BitmapDrawable) ((ImageView) view2).getDrawable()).getBitmap();
                        this.a.b.startActivity(new Intent(this.a.b, FeedbackImageViewFlipperActivity.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class n implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public n(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    view2.setBackgroundColor(-1184275);
                }
            }
        }

        public s(FeedbackInputActivity feedbackInputActivity, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = feedbackInputActivity;
            this.a = context;
        }

        public final CharSequence a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                Spanned fromHtml = Html.fromHtml(str);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
                URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), URLSpan.class);
                if (uRLSpanArr != null && uRLSpanArr.length > 0) {
                    for (URLSpan uRLSpan : uRLSpanArr) {
                        spannableStringBuilder.setSpan(new w0(this, uRLSpan), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
                    }
                }
                return spannableStringBuilder;
            }
            return (CharSequence) invokeL.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b.o.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ FeedbackInputActivity b;

        /* JADX WARN: Can't wrap try/catch for region: R(13:(3:164|165|(2:167|168)(1:205))|(2:169|170)|(2:172|(8:183|184|185|186|(2:188|(1:193)(1:192))|194|(1:190)|193)(4:176|177|178|(1:182)))|201|(1:174)|183|184|185|186|(0)|194|(0)|193) */
        /* JADX WARN: Code restructure failed: missing block: B:252:0x087f, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:253:0x0880, code lost:
            r0.printStackTrace();
         */
        /* JADX WARN: Removed duplicated region for block: B:127:0x0556  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x05d5  */
        /* JADX WARN: Removed duplicated region for block: B:139:0x060c  */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0612  */
        /* JADX WARN: Removed duplicated region for block: B:203:0x079b A[Catch: Exception -> 0x06f9, TryCatch #6 {Exception -> 0x06f9, blocks: (B:168:0x06eb, B:177:0x0707, B:179:0x0713, B:181:0x0723, B:183:0x072c, B:188:0x0738, B:191:0x0740, B:193:0x0755, B:194:0x0762, B:196:0x0770, B:201:0x078f, B:203:0x079b, B:205:0x07ab, B:207:0x07cf, B:209:0x07db, B:211:0x07e1, B:261:0x08b0, B:263:0x08bc, B:265:0x08d0, B:266:0x08d6, B:268:0x08dc, B:213:0x07f7, B:215:0x0803, B:217:0x0809, B:219:0x0816, B:237:0x084c, B:239:0x0852, B:241:0x0860, B:243:0x0865, B:245:0x086b, B:246:0x086f, B:256:0x0886, B:258:0x088c, B:259:0x0894, B:253:0x0880, B:234:0x0846, B:260:0x08a0, B:200:0x0788, B:248:0x0874, B:250:0x087a), top: B:348:0x06eb, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:204:0x07aa  */
        /* JADX WARN: Removed duplicated region for block: B:207:0x07cf A[Catch: Exception -> 0x06f9, TryCatch #6 {Exception -> 0x06f9, blocks: (B:168:0x06eb, B:177:0x0707, B:179:0x0713, B:181:0x0723, B:183:0x072c, B:188:0x0738, B:191:0x0740, B:193:0x0755, B:194:0x0762, B:196:0x0770, B:201:0x078f, B:203:0x079b, B:205:0x07ab, B:207:0x07cf, B:209:0x07db, B:211:0x07e1, B:261:0x08b0, B:263:0x08bc, B:265:0x08d0, B:266:0x08d6, B:268:0x08dc, B:213:0x07f7, B:215:0x0803, B:217:0x0809, B:219:0x0816, B:237:0x084c, B:239:0x0852, B:241:0x0860, B:243:0x0865, B:245:0x086b, B:246:0x086f, B:256:0x0886, B:258:0x088c, B:259:0x0894, B:253:0x0880, B:234:0x0846, B:260:0x08a0, B:200:0x0788, B:248:0x0874, B:250:0x087a), top: B:348:0x06eb, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:208:0x07da  */
        /* JADX WARN: Removed duplicated region for block: B:211:0x07e1 A[Catch: Exception -> 0x06f9, TryCatch #6 {Exception -> 0x06f9, blocks: (B:168:0x06eb, B:177:0x0707, B:179:0x0713, B:181:0x0723, B:183:0x072c, B:188:0x0738, B:191:0x0740, B:193:0x0755, B:194:0x0762, B:196:0x0770, B:201:0x078f, B:203:0x079b, B:205:0x07ab, B:207:0x07cf, B:209:0x07db, B:211:0x07e1, B:261:0x08b0, B:263:0x08bc, B:265:0x08d0, B:266:0x08d6, B:268:0x08dc, B:213:0x07f7, B:215:0x0803, B:217:0x0809, B:219:0x0816, B:237:0x084c, B:239:0x0852, B:241:0x0860, B:243:0x0865, B:245:0x086b, B:246:0x086f, B:256:0x0886, B:258:0x088c, B:259:0x0894, B:253:0x0880, B:234:0x0846, B:260:0x08a0, B:200:0x0788, B:248:0x0874, B:250:0x087a), top: B:348:0x06eb, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:213:0x07f7 A[Catch: Exception -> 0x06f9, TryCatch #6 {Exception -> 0x06f9, blocks: (B:168:0x06eb, B:177:0x0707, B:179:0x0713, B:181:0x0723, B:183:0x072c, B:188:0x0738, B:191:0x0740, B:193:0x0755, B:194:0x0762, B:196:0x0770, B:201:0x078f, B:203:0x079b, B:205:0x07ab, B:207:0x07cf, B:209:0x07db, B:211:0x07e1, B:261:0x08b0, B:263:0x08bc, B:265:0x08d0, B:266:0x08d6, B:268:0x08dc, B:213:0x07f7, B:215:0x0803, B:217:0x0809, B:219:0x0816, B:237:0x084c, B:239:0x0852, B:241:0x0860, B:243:0x0865, B:245:0x086b, B:246:0x086f, B:256:0x0886, B:258:0x088c, B:259:0x0894, B:253:0x0880, B:234:0x0846, B:260:0x08a0, B:200:0x0788, B:248:0x0874, B:250:0x087a), top: B:348:0x06eb, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:237:0x084c A[Catch: Exception -> 0x06f9, TryCatch #6 {Exception -> 0x06f9, blocks: (B:168:0x06eb, B:177:0x0707, B:179:0x0713, B:181:0x0723, B:183:0x072c, B:188:0x0738, B:191:0x0740, B:193:0x0755, B:194:0x0762, B:196:0x0770, B:201:0x078f, B:203:0x079b, B:205:0x07ab, B:207:0x07cf, B:209:0x07db, B:211:0x07e1, B:261:0x08b0, B:263:0x08bc, B:265:0x08d0, B:266:0x08d6, B:268:0x08dc, B:213:0x07f7, B:215:0x0803, B:217:0x0809, B:219:0x0816, B:237:0x084c, B:239:0x0852, B:241:0x0860, B:243:0x0865, B:245:0x086b, B:246:0x086f, B:256:0x0886, B:258:0x088c, B:259:0x0894, B:253:0x0880, B:234:0x0846, B:260:0x08a0, B:200:0x0788, B:248:0x0874, B:250:0x087a), top: B:348:0x06eb, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:250:0x087a A[Catch: Exception -> 0x087f, TRY_LEAVE, TryCatch #1 {Exception -> 0x087f, blocks: (B:248:0x0874, B:250:0x087a), top: B:338:0x0874, outer: #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:256:0x0886 A[Catch: Exception -> 0x06f9, TryCatch #6 {Exception -> 0x06f9, blocks: (B:168:0x06eb, B:177:0x0707, B:179:0x0713, B:181:0x0723, B:183:0x072c, B:188:0x0738, B:191:0x0740, B:193:0x0755, B:194:0x0762, B:196:0x0770, B:201:0x078f, B:203:0x079b, B:205:0x07ab, B:207:0x07cf, B:209:0x07db, B:211:0x07e1, B:261:0x08b0, B:263:0x08bc, B:265:0x08d0, B:266:0x08d6, B:268:0x08dc, B:213:0x07f7, B:215:0x0803, B:217:0x0809, B:219:0x0816, B:237:0x084c, B:239:0x0852, B:241:0x0860, B:243:0x0865, B:245:0x086b, B:246:0x086f, B:256:0x0886, B:258:0x088c, B:259:0x0894, B:253:0x0880, B:234:0x0846, B:260:0x08a0, B:200:0x0788, B:248:0x0874, B:250:0x087a), top: B:348:0x06eb, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:263:0x08bc A[Catch: Exception -> 0x06f9, TryCatch #6 {Exception -> 0x06f9, blocks: (B:168:0x06eb, B:177:0x0707, B:179:0x0713, B:181:0x0723, B:183:0x072c, B:188:0x0738, B:191:0x0740, B:193:0x0755, B:194:0x0762, B:196:0x0770, B:201:0x078f, B:203:0x079b, B:205:0x07ab, B:207:0x07cf, B:209:0x07db, B:211:0x07e1, B:261:0x08b0, B:263:0x08bc, B:265:0x08d0, B:266:0x08d6, B:268:0x08dc, B:213:0x07f7, B:215:0x0803, B:217:0x0809, B:219:0x0816, B:237:0x084c, B:239:0x0852, B:241:0x0860, B:243:0x0865, B:245:0x086b, B:246:0x086f, B:256:0x0886, B:258:0x088c, B:259:0x0894, B:253:0x0880, B:234:0x0846, B:260:0x08a0, B:200:0x0788, B:248:0x0874, B:250:0x087a), top: B:348:0x06eb, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:267:0x08da  */
        /* JADX WARN: Removed duplicated region for block: B:281:0x0973  */
        /* JADX WARN: Removed duplicated region for block: B:284:0x097f  */
        /* JADX WARN: Removed duplicated region for block: B:306:0x0a2a  */
        /* JADX WARN: Removed duplicated region for block: B:322:0x0af7  */
        /* JADX WARN: Removed duplicated region for block: B:325:0x0b28  */
        /* JADX WARN: Removed duplicated region for block: B:328:0x0b33  */
        /* JADX WARN: Removed duplicated region for block: B:331:0x0b3e  */
        /* JADX WARN: Removed duplicated region for block: B:354:0x099f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:366:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            CharSequence charSequence;
            String str;
            String str2;
            String str3;
            String str4;
            CharSequence charSequence2;
            ArrayList arrayList;
            boolean z;
            String str5;
            String str6;
            a aVar;
            CharSequence charSequence3;
            String str7;
            String string;
            String str8;
            String str9;
            String str10;
            JSONArray jSONArray;
            String str11;
            String str12;
            CharSequence charSequence4;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, message) != null) {
                return;
            }
            a aVar2 = this;
            super.handleMessage(message);
            int i = message.what;
            if (i == 12) {
                FeedbackInputActivity feedbackInputActivity = aVar2.b;
                if (feedbackInputActivity.y) {
                    feedbackInputActivity.y = false;
                    return;
                }
                feedbackInputActivity.x.setVisibility(8);
                FeedbackInputActivity feedbackInputActivity2 = aVar2.b;
                feedbackInputActivity2.Y = false;
                feedbackInputActivity2.Z.setEnabled(true);
                aVar2.b.Z.setText("");
                aVar2.b.m = "" + message.arg1;
                FeedbackInputActivity feedbackInputActivity3 = aVar2.b;
                feedbackInputActivity3.l = feedbackInputActivity3.m;
                String str13 = "" + message.arg2;
                String str14 = "Handler = 12 PluginInvoker  tempRobotSwitch = " + aVar2.b.C + "; id = " + aVar2.b.m;
                if (aVar2.b.C && aVar2.b.m != null && aVar2.b.m.length() > 0) {
                    aVar2.b.s.execute(new RunnableC0560a(aVar2, str13));
                }
            } else if (i == 13) {
                FeedbackInputActivity feedbackInputActivity4 = aVar2.b;
                feedbackInputActivity4.Y = false;
                feedbackInputActivity4.x.setVisibility(8);
                aVar2.b.Z.setEnabled(true);
                aVar2.b.i0.setVisibility(0);
            } else if (i == 14) {
                aVar2.b.Z.setEnabled(true);
                aVar2.b.Z.setText("");
                FeedbackInputActivity feedbackInputActivity5 = aVar2.b;
                feedbackInputActivity5.z = false;
                FeedbackInputActivity.B(feedbackInputActivity5);
                FeedbackInputActivity feedbackInputActivity6 = aVar2.b;
                if (feedbackInputActivity6.y) {
                    feedbackInputActivity6.y = false;
                    return;
                }
                feedbackInputActivity6.b0 = false;
                if (!TextUtils.isEmpty(feedbackInputActivity6.l) && TextUtils.isEmpty(aVar2.b.a0)) {
                    aVar2.b.v.putString(aVar2.b.l, "");
                }
                if (!TextUtils.isEmpty(aVar2.b.a0)) {
                    aVar2.b.v.putString(aVar2.b.a0, "");
                }
                aVar2.b.x.setVisibility(8);
                FeedbackInputActivity feedbackInputActivity7 = aVar2.b;
                feedbackInputActivity7.Y = false;
                feedbackInputActivity7.b.setVisibility(8);
                aVar2.b.m = "" + message.arg1;
                FeedbackInputActivity feedbackInputActivity8 = aVar2.b;
                feedbackInputActivity8.l = feedbackInputActivity8.m;
                String str15 = "" + message.arg2;
                aVar2.b.v.putString(Config.TRACE_VISIT_FIRST + aVar2.b.m, aVar2.a);
                aVar2.b.v.commit();
                String str16 = "Handler = 14 tempRobotSwitch = " + aVar2.b.C + "; id = " + aVar2.b.m;
                if (!aVar2.b.C || aVar2.b.m == null || aVar2.b.m.length() <= 0) {
                    if (aVar2.b.m != null && !aVar2.b.m.equals("newMessage")) {
                        aVar2.b.s.execute(new c(aVar2, str15));
                    }
                } else {
                    aVar2.b.s.execute(new b(aVar2, str15));
                }
            } else if (i == 15) {
                try {
                    ((InputMethodManager) aVar2.b.Z.getContext().getSystemService("input_method")).showSoftInput(aVar2.b.Z, 0);
                } catch (Exception unused) {
                }
            } else if (i == 16) {
                if (aVar2.b.getCurrentFocus() != null && aVar2.b.getCurrentFocus().getWindowToken() != null) {
                    ((InputMethodManager) aVar2.b.getSystemService("input_method")).hideSoftInputFromWindow(aVar2.b.getCurrentFocus().getWindowToken(), 2);
                }
            } else if (i == 17) {
                FeedbackInputActivity feedbackInputActivity9 = aVar2.b;
                feedbackInputActivity9.Y = false;
                feedbackInputActivity9.x.setVisibility(8);
            }
            int i2 = message.what;
            String str17 = "id";
            String str18 = "chatId";
            String str19 = "0";
            String str20 = "flagRobot";
            String str21 = "answer";
            String str22 = "from";
            String str23 = "discontent_labels";
            String str24 = "discontent_reason";
            String str25 = "evaluation";
            String str26 = "tip";
            CharSequence charSequence5 = "</br>";
            if (i2 == 1) {
                HashMap hashMap = new HashMap();
                hashMap.put("from", 0);
                hashMap.put("content", message.obj);
                hashMap.put("contenttype", "0");
                hashMap.put("time", String.valueOf(System.currentTimeMillis()));
                aVar2.b.o.add(hashMap);
                aVar2.b.q.notifyDataSetChanged();
                aVar2.b.p.setSelection(aVar2.b.p.getBottom());
                aVar2.b.x.setVisibility(8);
                aVar2.b.Z.setEnabled(true);
                aVar2.b.Z.setText("");
            } else if (i2 == 2) {
                FeedbackInputActivity.f(aVar2.b);
                String str27 = "@@@@@@@@: 规定交互轮次：" + aVar2.b.A + " ***当前交互次数" + aVar2.b.B;
                if (aVar2.b.B >= aVar2.b.A && aVar2.b.C) {
                    if (!aVar2.b.D) {
                        aVar2.b.s.execute(new d(aVar2));
                    }
                    String str28 = "handler = 2 tempRobotSwitch = " + aVar2.b.C;
                    aVar2.b.C = false;
                }
                FeedbackInputActivity feedbackInputActivity10 = aVar2.b;
                if (feedbackInputActivity10.d0) {
                    feedbackInputActivity10.m = feedbackInputActivity10.l;
                }
                FeedbackInputActivity feedbackInputActivity11 = aVar2.b;
                feedbackInputActivity11.z = false;
                feedbackInputActivity11.k.setVisibility(0);
                ArrayList arrayList2 = (ArrayList) message.obj;
                charSequence = "";
                int i3 = 0;
                while (i3 < arrayList2.size()) {
                    String str29 = str17;
                    if (((Map) arrayList2.get(i3)).get(str17).equals(aVar2.b.m)) {
                        HashMap hashMap2 = new HashMap();
                        if (((Integer) ((Map) arrayList2.get(i3)).get(str20)).intValue() == 0) {
                            if (((Map) arrayList2.get(i3)).containsKey("chatId")) {
                                hashMap2.put("chatId", ((Map) arrayList2.get(i3)).get("chatId"));
                            }
                            hashMap2.put("from", 1);
                            hashMap2.put("content", ((Map) arrayList2.get(i3)).get("content"));
                            hashMap2.put("time", ((Map) arrayList2.get(i3)).get("time"));
                            hashMap2.put("contenttype", str19);
                            str2 = str20;
                            if (((Map) arrayList2.get(i3)).get("toggle").equals("yes") && !aVar2.b.D) {
                                hashMap2.put("ask", 1);
                                aVar2.b.Q = false;
                            } else {
                                hashMap2.put("ask", 0);
                            }
                            String str30 = (String) hashMap2.get("content");
                            str3 = str19;
                            charSequence2 = charSequence5;
                            if (((String) hashMap2.get("content")).contains(charSequence2)) {
                                str30 = str30.replace(charSequence2, "\n");
                            }
                            hashMap2.remove("content");
                            hashMap2.put("content", str30);
                            if (str30.contains(".jpg") && str30.contains("http")) {
                                hashMap2.remove("contenttype");
                                hashMap2.put("contenttype", "1");
                            }
                            str4 = str26;
                            arrayList = arrayList2;
                        } else {
                            str2 = str20;
                            str3 = str19;
                            charSequence2 = charSequence5;
                            try {
                                JSONArray jSONArray2 = new JSONArray((String) ((Map) arrayList2.get(i3)).get("content"));
                                hashMap2.put("chatId", ((Map) arrayList2.get(i3)).get("chatId"));
                                hashMap2.put("from", 1);
                                hashMap2.put("content", jSONArray2);
                                hashMap2.put("time", ((Map) arrayList2.get(i3)).get("time"));
                                hashMap2.put("contenttype", "-1");
                                hashMap2.put("subtype", 0);
                                str4 = str26;
                            } catch (Exception e2) {
                                e = e2;
                                str4 = str26;
                            }
                            try {
                                hashMap2.put(str4, ((Map) arrayList2.get(i3)).get(str4));
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                arrayList = arrayList2;
                                if (!((Map) arrayList2.get(i3)).get("toggle").equals("yes")) {
                                }
                                hashMap2.put("ask", 0);
                                aVar2.b.o.add(hashMap2);
                                aVar2.b.q.notifyDataSetChanged();
                                aVar2.b.p.setSelection(aVar2.b.p.getBottom());
                                i3++;
                                charSequence5 = charSequence2;
                                arrayList2 = arrayList;
                                str17 = str29;
                                str19 = str3;
                                str26 = str4;
                                str20 = str2;
                            }
                            arrayList = arrayList2;
                            if (!((Map) arrayList2.get(i3)).get("toggle").equals("yes") && !aVar2.b.D) {
                                hashMap2.put("ask", 1);
                                aVar2.b.Q = false;
                            } else {
                                hashMap2.put("ask", 0);
                            }
                        }
                        aVar2.b.o.add(hashMap2);
                        aVar2.b.q.notifyDataSetChanged();
                        aVar2.b.p.setSelection(aVar2.b.p.getBottom());
                    } else {
                        str2 = str20;
                        str3 = str19;
                        str4 = str26;
                        charSequence2 = charSequence5;
                        arrayList = arrayList2;
                    }
                    i3++;
                    charSequence5 = charSequence2;
                    arrayList2 = arrayList;
                    str17 = str29;
                    str19 = str3;
                    str26 = str4;
                    str20 = str2;
                }
                str = str20;
                String str31 = str19;
                String str32 = str17;
                String str33 = str26;
                CharSequence charSequence6 = charSequence5;
                if (message.what == 3) {
                    aVar2.b.z = false;
                    byte[] bArr = (byte[]) message.obj;
                    if (bArr == null) {
                        return;
                    }
                    try {
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        if (decodeByteArray == null) {
                            return;
                        }
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("from", 0);
                        hashMap3.put("content", decodeByteArray);
                        hashMap3.put("contenttype", "2");
                        hashMap3.put("time", String.valueOf(System.currentTimeMillis()));
                        aVar2.b.o.add(hashMap3);
                        aVar2.b.q.notifyDataSetChanged();
                        aVar2.b.p.setSelection(aVar2.b.p.getBottom());
                        aVar2.b.Z.setEnabled(true);
                        aVar2.b.Z.setText(charSequence);
                        FeedbackInputActivity.B(aVar2.b);
                        aVar2.b.b.setVisibility(8);
                    } catch (OutOfMemoryError unused2) {
                        System.gc();
                        return;
                    }
                }
                if (message.what != 4) {
                    aVar2.b.k.setVisibility(8);
                    aVar2.b.e.setVisibility(8);
                    p1.a(aVar2.b.getApplicationContext(), aVar2.b.t);
                    z = false;
                    aVar2.b.d.setVisibility(0);
                    aVar2.b.r.setVisibility(8);
                } else {
                    z = false;
                }
                if (message.what != 5) {
                    FeedbackInputActivity feedbackInputActivity12 = aVar2.b;
                    feedbackInputActivity12.z = z;
                    feedbackInputActivity12.o.clear();
                    String l = com.baidu.ufosdk.b.l();
                    if (TextUtils.isEmpty(l)) {
                        l = "您好，请问有什么可以帮您？如果我知道您说的问题，会很快告诉您答案。另外，有什么建议也可以告诉我，我会第一时间转达产品小哥哥和小姐姐。";
                    }
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("from", 1);
                    hashMap4.put("content", l);
                    str6 = str31;
                    hashMap4.put("contenttype", str6);
                    String str34 = (String) message.obj;
                    if (str34.equals("newMessage") || str34.length() == 0) {
                        charSequence3 = charSequence6;
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        aVar2.a = valueOf;
                        hashMap4.put("time", valueOf);
                    } else {
                        SharedPreferences sharedPreferences = aVar2.b.w;
                        StringBuilder sb = new StringBuilder();
                        charSequence3 = charSequence6;
                        sb.append(Config.TRACE_VISIT_FIRST);
                        sb.append(aVar2.b.l);
                        String string2 = sharedPreferences.getString(sb.toString(), str6);
                        if (string2.equals(str6)) {
                            try {
                                string2 = (String) new JSONArray(str34).getJSONObject(0).get("time");
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        hashMap4.put("time", string2);
                    }
                    aVar2.b.o.add(hashMap4);
                    if (aVar2.b.q != null) {
                        aVar2.b.q.notifyDataSetChanged();
                    }
                    try {
                        JSONArray jSONArray3 = new JSONArray(str34);
                        int i4 = 0;
                        while (i4 < jSONArray3.length()) {
                            HashMap hashMap5 = new HashMap();
                            int intValue = ((Integer) jSONArray3.getJSONObject(i4).get(str22)).intValue();
                            hashMap5.put(str22, Integer.valueOf(intValue));
                            if (aVar2.b.d0) {
                                try {
                                    str5 = str22;
                                } catch (Exception e5) {
                                    e = e5;
                                    str5 = str22;
                                    aVar = this;
                                    e.printStackTrace();
                                    if (message.what == 6) {
                                    }
                                    if (message.what == 7) {
                                    }
                                    if (message.what == 8) {
                                    }
                                    if (message.what == 10) {
                                    }
                                    if (message.what == 11) {
                                    }
                                    if (message.what == 17) {
                                    }
                                    if (message.what == 18) {
                                    }
                                }
                                try {
                                    aVar2.b.U = jSONArray3.getJSONObject(0).optString("appid");
                                } catch (Exception e6) {
                                    e = e6;
                                    aVar = this;
                                    e.printStackTrace();
                                    if (message.what == 6) {
                                    }
                                    if (message.what == 7) {
                                    }
                                    if (message.what == 8) {
                                    }
                                    if (message.what == 10) {
                                    }
                                    if (message.what == 11) {
                                    }
                                    if (message.what == 17) {
                                    }
                                    if (message.what == 18) {
                                    }
                                }
                            } else {
                                str5 = str22;
                            }
                            try {
                                if (intValue == 1) {
                                    String str35 = str25;
                                    int intValue2 = jSONArray3.getJSONObject(i4).has(str35) ? ((Integer) jSONArray3.getJSONObject(i4).get(str35)).intValue() : 0;
                                    hashMap5.put(str35, Integer.valueOf(intValue2));
                                    if (intValue2 == 0) {
                                        hashMap5.put("ask", 0);
                                    } else if (intValue2 == 10) {
                                        hashMap5.put("ask", 1);
                                    } else {
                                        if (intValue2 <= 9) {
                                            hashMap5.put("ask", 9);
                                            str7 = str24;
                                            if (jSONArray3.getJSONObject(i4).has(str7)) {
                                                hashMap5.put(str7, (String) jSONArray3.getJSONObject(i4).get(str7));
                                            }
                                            str25 = str35;
                                            String str36 = str23;
                                            if (jSONArray3.getJSONObject(i4).has(str36)) {
                                                hashMap5.put(str36, (JSONArray) jSONArray3.getJSONObject(i4).get(str36));
                                            }
                                            str23 = str36;
                                        } else {
                                            str25 = str35;
                                            str7 = str24;
                                            if (intValue2 >= 11) {
                                                hashMap5.put("ask", 11);
                                            }
                                        }
                                        String str37 = str32;
                                        hashMap5.put(str18, Integer.valueOf(!jSONArray3.getJSONObject(i4).has(str37) ? ((Integer) jSONArray3.getJSONObject(i4).get(str37)).intValue() : 0));
                                        String str38 = (String) jSONArray3.getJSONObject(i4).get("contenttype");
                                        hashMap5.put("contenttype", str38);
                                        str32 = str37;
                                        String str39 = str18;
                                        string = !jSONArray3.getJSONObject(i4).has("extra") ? jSONArray3.getJSONObject(i4).getString("extra") : null;
                                        if (!TextUtils.isEmpty(string)) {
                                            hashMap5.put("content", jSONArray3.getJSONObject(i4).get("content"));
                                            str8 = str;
                                            hashMap5.put(str8, 0);
                                            str9 = str7;
                                        } else {
                                            str8 = str;
                                            str9 = str7;
                                            JSONObject jSONObject = new JSONObject(string);
                                            if (intValue == 1 && str38.equals(str6)) {
                                                int optInt = jSONObject.optInt(str8);
                                                hashMap5.put(str8, Integer.valueOf(optInt));
                                                if (optInt == 0) {
                                                    hashMap5.put("content", jSONArray3.getJSONObject(i4).getString("content"));
                                                } else {
                                                    try {
                                                        jSONArray = jSONObject.has("robot") ? (JSONArray) jSONObject.get("robot") : null;
                                                    } catch (Exception e7) {
                                                        e = e7;
                                                        jSONArray = null;
                                                    }
                                                    try {
                                                    } catch (Exception e8) {
                                                        e = e8;
                                                        e.printStackTrace();
                                                        str11 = null;
                                                        if (jSONArray == null) {
                                                        }
                                                        hashMap5.put(str8, 0);
                                                        str10 = str21;
                                                        if (jSONObject.has(str10)) {
                                                        }
                                                        str12 = null;
                                                        if (str12 == null) {
                                                        }
                                                        hashMap5.put("content", jSONArray3.getJSONObject(i4).getString("content"));
                                                        if (((Integer) hashMap5.get(str8)).intValue() != 0) {
                                                        }
                                                        hashMap5.put("time", jSONArray3.getJSONObject(i4).get("time"));
                                                        aVar = this;
                                                        aVar.b.o.add(hashMap5);
                                                        i4++;
                                                        str21 = str10;
                                                        aVar2 = aVar;
                                                        charSequence3 = charSequence4;
                                                        str22 = str5;
                                                        String str40 = str9;
                                                        str = str8;
                                                        str18 = str39;
                                                        str24 = str40;
                                                    }
                                                    if (jSONObject.has(str33)) {
                                                        str11 = (String) jSONObject.get(str33);
                                                        if (jSONArray == null && jSONArray.length() > 0) {
                                                            hashMap5.put(str8, 1);
                                                            hashMap5.put("content", jSONArray);
                                                            hashMap5.put("contenttype", "-1");
                                                            hashMap5.put("subtype", 0);
                                                            if (str11 != null && str11.length() > 0) {
                                                                hashMap5.put(str33, str11);
                                                            }
                                                        } else {
                                                            hashMap5.put(str8, 0);
                                                            str10 = str21;
                                                            if (jSONObject.has(str10)) {
                                                                str12 = jSONObject.getString(str10);
                                                                if (str12 == null && str12.length() > 0) {
                                                                    hashMap5.put("content", jSONObject.getString(str10));
                                                                } else {
                                                                    hashMap5.put("content", jSONArray3.getJSONObject(i4).getString("content"));
                                                                }
                                                            }
                                                            str12 = null;
                                                            if (str12 == null) {
                                                            }
                                                            hashMap5.put("content", jSONArray3.getJSONObject(i4).getString("content"));
                                                        }
                                                    }
                                                    str11 = null;
                                                    if (jSONArray == null) {
                                                    }
                                                    hashMap5.put(str8, 0);
                                                    str10 = str21;
                                                    if (jSONObject.has(str10)) {
                                                    }
                                                    str12 = null;
                                                    if (str12 == null) {
                                                    }
                                                    hashMap5.put("content", jSONArray3.getJSONObject(i4).getString("content"));
                                                }
                                            } else {
                                                str10 = str21;
                                                hashMap5.put("content", jSONArray3.getJSONObject(i4).get("content"));
                                                hashMap5.put(str8, 0);
                                            }
                                            if (((Integer) hashMap5.get(str8)).intValue() != 0) {
                                                String str41 = (String) hashMap5.get("content");
                                                charSequence4 = charSequence3;
                                                if (((String) hashMap5.get("content")).contains(charSequence4)) {
                                                    str41 = str41.replace(charSequence4, "\n");
                                                }
                                                hashMap5.put("content", str41);
                                            } else {
                                                charSequence4 = charSequence3;
                                            }
                                            hashMap5.put("time", jSONArray3.getJSONObject(i4).get("time"));
                                            aVar = this;
                                            aVar.b.o.add(hashMap5);
                                            i4++;
                                            str21 = str10;
                                            aVar2 = aVar;
                                            charSequence3 = charSequence4;
                                            str22 = str5;
                                            String str402 = str9;
                                            str = str8;
                                            str18 = str39;
                                            str24 = str402;
                                        }
                                        str10 = str21;
                                        if (((Integer) hashMap5.get(str8)).intValue() != 0) {
                                        }
                                        hashMap5.put("time", jSONArray3.getJSONObject(i4).get("time"));
                                        aVar = this;
                                        aVar.b.o.add(hashMap5);
                                        i4++;
                                        str21 = str10;
                                        aVar2 = aVar;
                                        charSequence3 = charSequence4;
                                        str22 = str5;
                                        String str4022 = str9;
                                        str = str8;
                                        str18 = str39;
                                        str24 = str4022;
                                    }
                                    str25 = str35;
                                }
                                aVar.b.o.add(hashMap5);
                                i4++;
                                str21 = str10;
                                aVar2 = aVar;
                                charSequence3 = charSequence4;
                                str22 = str5;
                                String str40222 = str9;
                                str = str8;
                                str18 = str39;
                                str24 = str40222;
                            } catch (Exception e9) {
                                e = e9;
                                e.printStackTrace();
                                if (message.what == 6) {
                                }
                                if (message.what == 7) {
                                }
                                if (message.what == 8) {
                                }
                                if (message.what == 10) {
                                }
                                if (message.what == 11) {
                                }
                                if (message.what == 17) {
                                }
                                if (message.what == 18) {
                                }
                            }
                            str7 = str24;
                            String str372 = str32;
                            hashMap5.put(str18, Integer.valueOf(!jSONArray3.getJSONObject(i4).has(str372) ? ((Integer) jSONArray3.getJSONObject(i4).get(str372)).intValue() : 0));
                            String str382 = (String) jSONArray3.getJSONObject(i4).get("contenttype");
                            hashMap5.put("contenttype", str382);
                            str32 = str372;
                            String str392 = str18;
                            if (!jSONArray3.getJSONObject(i4).has("extra")) {
                            }
                            if (!TextUtils.isEmpty(string)) {
                            }
                            str10 = str21;
                            if (((Integer) hashMap5.get(str8)).intValue() != 0) {
                            }
                            hashMap5.put("time", jSONArray3.getJSONObject(i4).get("time"));
                            aVar = this;
                        }
                        str5 = str22;
                        aVar = aVar2;
                        if (aVar.b.q != null) {
                            aVar.b.q.notifyDataSetChanged();
                        }
                        aVar.b.k.setVisibility(0);
                        aVar.b.e.setVisibility(0);
                        aVar.b.d.setVisibility(8);
                        aVar.b.r.setVisibility(8);
                        aVar.b.p.setSelection(aVar.b.p.getBottom());
                        aVar.b.u = true;
                        new Handler().postDelayed(new e(aVar), 1500L);
                    } catch (Exception e10) {
                        e = e10;
                        str5 = str22;
                        aVar = aVar2;
                    }
                } else {
                    str5 = "from";
                    str6 = str31;
                    aVar = aVar2;
                }
                if (message.what == 6 && aVar.b.u) {
                    aVar.b.p.setSelection(aVar.b.p.getBottom());
                }
                if (message.what == 7) {
                    try {
                        String a = com.baidu.ufosdk.b.a((String) message.obj);
                        if (!TextUtils.isEmpty(a) && new JSONObject(a).optInt("errno", -1) == 0) {
                            aVar.b.z = false;
                            if (aVar.b.q != null) {
                                aVar.b.q.notifyDataSetChanged();
                            }
                            aVar.b.p.setSelection(aVar.b.p.getBottom());
                            return;
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    Toast.makeText(aVar.b.getApplicationContext(), aVar.b.I, 1).show();
                    FeedbackInputActivity feedbackInputActivity13 = aVar.b;
                    feedbackInputActivity13.z = false;
                    if (feedbackInputActivity13.q != null) {
                        aVar.b.q.notifyDataSetChanged();
                    }
                    aVar.b.p.setSelection(aVar.b.p.getBottom());
                }
                if (message.what == 8) {
                    if (aVar.b.K == 1) {
                        if (message.obj != null) {
                            if (TextUtils.isEmpty(aVar.b.J)) {
                                Toast.makeText(aVar.b.getApplicationContext(), t1.a("36"), 1).show();
                            } else {
                                Toast.makeText(aVar.b.getApplicationContext(), aVar.b.J, 0).show();
                            }
                        }
                        HashMap hashMap6 = new HashMap();
                        hashMap6.put(str5, 1);
                        hashMap6.put("content", aVar.b.getString(R.string.obfuscated_res_0x7f0f1267));
                        hashMap6.put("contenttype", str6);
                        hashMap6.put("time", String.valueOf(System.currentTimeMillis()));
                        hashMap6.put("ask", 0);
                        aVar.b.o.add(hashMap6);
                    } else if (TextUtils.isEmpty(aVar.b.J)) {
                        Toast.makeText(aVar.b.getApplicationContext(), t1.a("36"), 1).show();
                    } else {
                        Toast.makeText(aVar.b.getApplicationContext(), aVar.b.J, 0).show();
                    }
                    FeedbackInputActivity feedbackInputActivity14 = aVar.b;
                    feedbackInputActivity14.z = true;
                    feedbackInputActivity14.q.notifyDataSetChanged();
                    aVar.b.p.setSelection(aVar.b.p.getBottom());
                }
                if (message.what == 10) {
                    Intent intent = new Intent();
                    intent.setClass(aVar.b, FeedbackEditActivity.class);
                    intent.putExtra("msgid", aVar.b.l);
                    intent.putExtra("feedback_channel", com.baidu.ufosdk.b.h());
                    intent.putExtra("come_from", 0);
                    aVar.b.startActivity(intent);
                }
                if (message.what == 11) {
                    FeedbackInputActivity.a(aVar.b, message);
                }
                if (message.what == 17) {
                    aVar.b.b();
                }
                if (message.what == 18) {
                    ((InputMethodManager) aVar.b.getSystemService("input_method")).showSoftInput(aVar.b.F.k, 1);
                    String str42 = "show keyboard! " + message.obj.toString();
                    return;
                }
                return;
            }
            str = "flagRobot";
            charSequence = "";
            String str312 = str19;
            String str322 = str17;
            String str332 = str26;
            CharSequence charSequence62 = charSequence5;
            if (message.what == 3) {
            }
            if (message.what != 4) {
            }
            if (message.what != 5) {
            }
            if (message.what == 6) {
                aVar.b.p.setSelection(aVar.b.p.getBottom());
            }
            if (message.what == 7) {
            }
            if (message.what == 8) {
            }
            if (message.what == 10) {
            }
            if (message.what == 11) {
            }
            if (message.what == 17) {
            }
            if (message.what == 18) {
            }
        }

        /* renamed from: com.baidu.ufosdk.ui.FeedbackInputActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC0560a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0560a(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    FeedbackInputActivity feedbackInputActivity = this.b.b;
                    com.baidu.ufosdk.b.a(feedbackInputActivity, feedbackInputActivity.m, this.a);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public b(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        com.baidu.ufosdk.b.a(this.b.b, this.b.b.m, this.a);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public c(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        FeedbackInputActivity feedbackInputActivity = this.b.b;
                        String str = this.b.b.l0.a;
                        com.baidu.ufosdk.b.b(feedbackInputActivity, this.b.b.m, this.a);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public d(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        com.baidu.ufosdk.b.a(this.a.b, this.a.b.m, 9, this.a.b.n);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public e(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.b.u = false;
            }
        }

        public a(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = feedbackInputActivity;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackInputActivity a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        if (this.a.a.n != null && this.a.a.n.length() > 0) {
                            str = this.a.a.n;
                        } else {
                            str = this.a.a.l0.b;
                        }
                        String d = com.baidu.ufosdk.b.d(this.a.a.getApplicationContext(), this.a.a.l, str);
                        if (d != null && d.length() != 0) {
                            this.a.a.W.obtainMessage(5, d).sendToTarget();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public e(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackInputActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                try {
                    this.a.d.setVisibility(8);
                    this.a.r.setVisibility(0);
                    if (this.a.l != null && this.a.l.length() > 0) {
                        this.a.s.execute(new a(this));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackInputActivity a;

        public b(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackInputActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str2 = this.a.n;
                if (str2 != null && str2.length() > 0) {
                    str = this.a.n;
                } else {
                    str = this.a.l0.b;
                }
                String d = com.baidu.ufosdk.b.d(this.a.getApplicationContext(), this.a.l, str);
                if (d != null && d.length() != 0) {
                    this.a.W.obtainMessage(5, d).sendToTarget();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackInputActivity a;

        public c(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackInputActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FeedbackInputActivity feedbackInputActivity = this.a;
                feedbackInputActivity.y = true;
                feedbackInputActivity.a();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public d(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackInputActivity a;

        public f(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackInputActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FeedbackInputActivity feedbackInputActivity = this.a;
                if (feedbackInputActivity.Y) {
                    return;
                }
                feedbackInputActivity.c.remove(((Integer) view2.getTag()).intValue());
                if (this.a.c.size() == 1) {
                    byte[] a = p1.a(this.a.getApplicationContext());
                    if (a == null) {
                        return;
                    }
                    this.a.c.set(0, a);
                }
                this.a.c();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackInputActivity a;

        public g(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackInputActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FeedbackInputActivity feedbackInputActivity = this.a;
                if (feedbackInputActivity.Y) {
                    return;
                }
                feedbackInputActivity.a = ((Integer) view2.getTag()).intValue();
                if (p1.a() >= 23) {
                    FeedbackInputActivity.z(this.a);
                } else {
                    FeedbackInputActivity.z(this.a);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackInputActivity a;

        public h(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackInputActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l0.a();
                if (this.a.l0.a.length() != 0) {
                    this.a.W.obtainMessage(1, null).sendToTarget();
                } else {
                    this.a.W.obtainMessage(4, null).sendToTarget();
                }
                Context applicationContext = this.a.getApplicationContext();
                String str = this.a.l0.a;
                String g = com.baidu.ufosdk.b.g(applicationContext);
                if (g != null) {
                    this.a.W.obtainMessage(0, g).sendToTarget();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackInputActivity a;

        public i(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackInputActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context applicationContext = this.a.getApplicationContext();
                String str = this.a.l0.a;
                String g = com.baidu.ufosdk.b.g(applicationContext);
                if (g != null) {
                    this.a.W.obtainMessage(0, g).sendToTarget();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ PopupWindow b;
        public final /* synthetic */ FeedbackInputActivity c;

        public j(FeedbackInputActivity feedbackInputActivity, View view2, PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity, view2, popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = feedbackInputActivity;
            this.a = view2;
            this.b = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ((ClipboardManager) this.c.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(((TextView) this.a).getText().toString());
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public k(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackInputActivity a;

        public l(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackInputActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                if (intent.getAction().equals("com.baidu.ufosdk.getchat")) {
                    this.a.W.obtainMessage(2, intent.getExtras().getParcelableArrayList("msgList")).sendToTarget();
                }
                if (intent.getAction().equals("com.baidu.ufosdk.getmsgid")) {
                    this.a.l = intent.getStringExtra("msgid");
                    if (!TextUtils.isEmpty(this.a.l) && !this.a.l.equals("newMessage")) {
                        FeedbackInputActivity feedbackInputActivity = this.a;
                        if (feedbackInputActivity != null) {
                            v1.b.a.a(new v0(feedbackInputActivity));
                        } else {
                            throw null;
                        }
                    }
                }
                if (intent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss")) {
                    this.a.r.setVisibility(8);
                }
                if (intent.getAction().equals("com.baidu.ufosdk.reload")) {
                    Toast.makeText(this.a.getApplicationContext(), t1.a("18"), 1).show();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackInputActivity a;

        public m(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackInputActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 4) {
                    FeedbackInputActivity.w(this.a);
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class n implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ FeedbackInputActivity b;

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public n(FeedbackInputActivity feedbackInputActivity, ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity, imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = feedbackInputActivity;
            this.a = imageView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                FeedbackInputActivity feedbackInputActivity = this.b;
                int i = feedbackInputActivity.e0;
                if (i != 0) {
                    if (i == 1 && feedbackInputActivity.Z.getText().toString().trim().length() <= 0) {
                        this.b.i0.setVisibility(8);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(p1.a(this.b.getApplicationContext(), 25.0f), p1.a(this.b.getApplicationContext(), 25.0f));
                        layoutParams.setMargins(p1.a(this.b.getApplicationContext(), 12.0f), 0, p1.a(this.b.getApplicationContext(), 12.0f), 0);
                        if (this.b.i0.getVisibility() == 8) {
                            layoutParams.addRule(11);
                            layoutParams.addRule(15);
                        } else {
                            layoutParams.addRule(0, this.b.i0.getId());
                            layoutParams.addRule(15);
                        }
                        this.b.g.removeView(this.a);
                        this.b.g.addView(this.a, layoutParams);
                    }
                } else if (feedbackInputActivity.Z.getText().toString().trim().length() > 0) {
                    this.b.i0.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(p1.a(this.b.getApplicationContext(), 25.0f), p1.a(this.b.getApplicationContext(), 25.0f));
                    layoutParams2.setMargins(p1.a(this.b.getApplicationContext(), 12.0f), 0, p1.a(this.b.getApplicationContext(), 12.0f), 0);
                    if (this.b.i0.getVisibility() == 8) {
                        layoutParams2.addRule(11);
                        layoutParams2.addRule(15);
                    } else {
                        layoutParams2.addRule(0, this.b.i0.getId());
                        layoutParams2.addRule(15);
                    }
                    this.b.g.removeView(this.a);
                    this.b.g.addView(this.a, layoutParams2);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                if (this.b.Z.getText().toString().trim().length() <= 0) {
                    this.b.e0 = 0;
                } else {
                    this.b.e0 = 1;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackInputActivity a;

        public o(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackInputActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FeedbackInputActivity feedbackInputActivity = this.a;
                if (feedbackInputActivity.Y) {
                    return;
                }
                if (feedbackInputActivity.b.getVisibility() == 0) {
                    this.a.b.setVisibility(8);
                } else {
                    this.a.b.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackInputActivity a;

        public p(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackInputActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !com.baidu.ufosdk.b.n()) {
                FeedbackInputActivity.w(this.a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackInputActivity a;

        public q(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackInputActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Intent intent = new Intent(this.a, FeedbackListActivity.class);
                intent.putExtra("feedback_channel", com.baidu.ufosdk.b.h());
                this.a.startActivity(intent);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public r(FeedbackInputActivity feedbackInputActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackInputActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;
        public ImageView c;
        public RelativeLayout d;

        public t() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;
        public ListView c;
        public TextView d;
        public TextView e;
        public RelativeLayout f;

        public u() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;
        public TextView c;
        public RelativeLayout d;
        public RelativeLayout e;
        public TextView f;
        public TextView g;
        public k0 h;
        public ImageView i;
        public TextView j;

        public v() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;
        public ImageView c;
        public RelativeLayout d;

        public w() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;
        public TextView c;
        public RelativeLayout d;

        public x() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public FeedbackInputActivity() {
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
        this.a = -1;
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = new ArrayList();
        this.s = Executors.newSingleThreadExecutor();
        this.u = false;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.B = 0;
        this.C = true;
        this.D = false;
        this.F = null;
        this.G = null;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = 1;
        this.L = null;
        this.M = 0;
        this.N = null;
        this.O = null;
        this.P = null;
        this.f1196T = false;
        this.W = new a(this);
        this.X = new l(this);
        this.Y = false;
        this.a0 = "";
        this.b0 = true;
        this.d0 = true;
        this.h0 = false;
        this.j0 = false;
        this.k0 = null;
    }

    public static void B(FeedbackInputActivity feedbackInputActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, feedbackInputActivity) == null) {
            feedbackInputActivity.b.removeAllViews();
            feedbackInputActivity.c.clear();
            feedbackInputActivity.c.add(p1.a(feedbackInputActivity));
            feedbackInputActivity.c();
        }
    }

    public static /* synthetic */ int f(FeedbackInputActivity feedbackInputActivity) {
        int i2 = feedbackInputActivity.B;
        feedbackInputActivity.B = i2 + 1;
        return i2;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, keyEvent)) == null) {
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                this.y = true;
                a();
                return false;
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, bitmap, i2)) == null) {
            if (bitmap == null || i2 <= 0) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > i2 && height > i2) {
                int max = (Math.max(width, height) * i2) / Math.min(width, height);
                if (width > height) {
                    i3 = max;
                } else {
                    i3 = i2;
                }
                if (width > height) {
                    max = i2;
                }
                try {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, max, true);
                    Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, (i3 - i2) / 2, (max - i2) / 2, i2, i2);
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

    public static void a(FeedbackInputActivity feedbackInputActivity, Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, feedbackInputActivity, message) == null) {
            feedbackInputActivity.F.j.setVisibility(8);
            feedbackInputActivity.F.l.setBackgroundResource(R.drawable.obfuscated_res_0x7f08058e);
            feedbackInputActivity.F.l.setTextColor(-1);
            feedbackInputActivity.F.l.setClickable(true);
            feedbackInputActivity.F.k.setFocusable(true);
            feedbackInputActivity.F.k.setFocusableInTouchMode(true);
            feedbackInputActivity.F.k.requestFocus();
            if (((Integer) message.obj).intValue() == 0) {
                c1 c1Var = feedbackInputActivity.F;
                if (c1Var != null && c1Var.isShowing()) {
                    feedbackInputActivity.F.dismiss();
                }
                c1 c1Var2 = feedbackInputActivity.F;
                if (c1Var2 != null) {
                    c1Var2.g.clear();
                    c1Var2.k.setText("");
                    c1Var2.a(c1Var2.q);
                    c1Var2.a(c1Var2.r);
                    c1Var2.a(c1Var2.s);
                    c1Var2.a(c1Var2.t);
                    c1Var2.a(c1Var2.u);
                }
                if (TextUtils.isEmpty(feedbackInputActivity.J)) {
                    Toast.makeText(feedbackInputActivity.getApplicationContext(), t1.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK), 0).show();
                } else {
                    Toast.makeText(feedbackInputActivity.getApplicationContext(), feedbackInputActivity.J, 0).show();
                }
            } else {
                Toast.makeText(feedbackInputActivity.getApplicationContext(), "发生失败，请稍候重试", 1).show();
            }
            feedbackInputActivity.q.notifyDataSetChanged();
        }
    }

    public static void a(FeedbackInputActivity feedbackInputActivity, ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, feedbackInputActivity, listView) == null) {
            if (feedbackInputActivity != null) {
                ListAdapter adapter = listView.getAdapter();
                if (adapter != null) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < adapter.getCount(); i3++) {
                        View view2 = adapter.getView(i3, null, listView);
                        view2.measure(0, 0);
                        i2 += view2.getMeasuredHeight();
                    }
                    ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
                    layoutParams.height = i2 + (listView.getDividerHeight() * (adapter.getCount() - 1));
                    listView.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(FeedbackInputActivity feedbackInputActivity, boolean z, boolean z2) {
        JSONArray jSONArray;
        String str;
        g1 g1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{feedbackInputActivity, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (feedbackInputActivity.K == 0) {
                feedbackInputActivity.W.obtainMessage(8, 0).sendToTarget();
            } else if (z) {
                try {
                    if (feedbackInputActivity.o.get(feedbackInputActivity.H).containsKey("discontent_labels")) {
                        jSONArray = (JSONArray) feedbackInputActivity.o.get(feedbackInputActivity.H).get("discontent_labels");
                    } else {
                        jSONArray = null;
                    }
                } catch (Exception unused) {
                    jSONArray = null;
                }
                if (feedbackInputActivity.o.get(feedbackInputActivity.H).containsKey("discontent_reason")) {
                    str = (String) feedbackInputActivity.o.get(feedbackInputActivity.H).get("discontent_reason");
                    if (feedbackInputActivity.G == null) {
                        feedbackInputActivity.G = new g1(feedbackInputActivity, R.style.obfuscated_res_0x7f100446);
                    }
                    g1Var = feedbackInputActivity.G;
                    if (g1Var == null) {
                        if (jSONArray != null && jSONArray.length() > 0) {
                            g1Var.b.findViewById(R.id.obfuscated_res_0x7f091618).setVisibility(0);
                            int length = jSONArray.length();
                            if (length != 1) {
                                if (length != 2) {
                                    if (length != 3) {
                                        if (length != 4) {
                                            if (length == 5) {
                                                g1Var.b.findViewById(R.id.obfuscated_res_0x7f09161b).setVisibility(0);
                                                CheckBox checkBox = (CheckBox) g1Var.b.findViewById(R.id.obfuscated_res_0x7f090662);
                                                checkBox.setVisibility(0);
                                                checkBox.setText(jSONArray.optString(4));
                                            }
                                        } else {
                                            g1Var.b.findViewById(R.id.obfuscated_res_0x7f09161a).setVisibility(0);
                                            CheckBox checkBox2 = (CheckBox) g1Var.b.findViewById(R.id.obfuscated_res_0x7f090661);
                                            checkBox2.setVisibility(0);
                                            checkBox2.setText(jSONArray.optString(3));
                                        }
                                    } else {
                                        g1Var.b.findViewById(R.id.obfuscated_res_0x7f09161a).setVisibility(0);
                                        CheckBox checkBox3 = (CheckBox) g1Var.b.findViewById(R.id.obfuscated_res_0x7f090660);
                                        checkBox3.setVisibility(0);
                                        checkBox3.setText(jSONArray.optString(2));
                                    }
                                } else {
                                    g1Var.b.findViewById(R.id.obfuscated_res_0x7f091619).setVisibility(0);
                                    CheckBox checkBox4 = (CheckBox) g1Var.b.findViewById(R.id.obfuscated_res_0x7f09065f);
                                    checkBox4.setVisibility(0);
                                    checkBox4.setText(jSONArray.optString(1));
                                }
                            } else {
                                g1Var.b.findViewById(R.id.obfuscated_res_0x7f091619).setVisibility(0);
                                CheckBox checkBox5 = (CheckBox) g1Var.b.findViewById(R.id.obfuscated_res_0x7f09065e);
                                checkBox5.setVisibility(0);
                                checkBox5.setText(jSONArray.optString(0));
                            }
                            if (jSONArray.length() == 4) {
                                g1Var.b.findViewById(R.id.obfuscated_res_0x7f09161b).setVisibility(8);
                            }
                            if (jSONArray.length() == 3) {
                                g1Var.b.findViewById(R.id.obfuscated_res_0x7f09161b).setVisibility(8);
                                ((CheckBox) g1Var.b.findViewById(R.id.obfuscated_res_0x7f090661)).setVisibility(4);
                            }
                            if (jSONArray.length() == 2) {
                                g1Var.b.findViewById(R.id.obfuscated_res_0x7f09161b).setVisibility(8);
                                g1Var.b.findViewById(R.id.obfuscated_res_0x7f09161a).setVisibility(8);
                            }
                            if (jSONArray.length() == 1) {
                                g1Var.b.findViewById(R.id.obfuscated_res_0x7f09161b).setVisibility(8);
                                g1Var.b.findViewById(R.id.obfuscated_res_0x7f09161a).setVisibility(8);
                                ((CheckBox) g1Var.b.findViewById(R.id.obfuscated_res_0x7f09065f)).setVisibility(4);
                            }
                        } else {
                            g1Var.b.findViewById(R.id.obfuscated_res_0x7f091618).setVisibility(8);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            g1Var.b.findViewById(R.id.obfuscated_res_0x7f091f79).setVisibility(0);
                            ((TextView) g1Var.b.findViewById(R.id.obfuscated_res_0x7f0927a3)).setText(str);
                        } else {
                            g1Var.b.findViewById(R.id.obfuscated_res_0x7f091f79).setVisibility(8);
                        }
                        feedbackInputActivity.G.show();
                        return;
                    }
                    throw null;
                }
                str = null;
                if (feedbackInputActivity.G == null) {
                }
                g1Var = feedbackInputActivity.G;
                if (g1Var == null) {
                }
            } else {
                if (feedbackInputActivity.F == null) {
                    feedbackInputActivity.F = new c1(feedbackInputActivity, R.style.obfuscated_res_0x7f100446, feedbackInputActivity.N, feedbackInputActivity.M, feedbackInputActivity.L, feedbackInputActivity.W, feedbackInputActivity.o);
                }
                c1 c1Var = feedbackInputActivity.F;
                c1Var.p = z2;
                c1Var.o = feedbackInputActivity.H;
                c1Var.m = feedbackInputActivity.m;
                c1Var.n = feedbackInputActivity.U;
                c1Var.show();
            }
        }
    }

    public static void w(FeedbackInputActivity feedbackInputActivity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65576, null, feedbackInputActivity) == null) && !feedbackInputActivity.Y) {
            if (feedbackInputActivity.Z.getText().toString().trim().length() <= 0) {
                Toast.makeText(feedbackInputActivity, t1.a("12"), 0).show();
            } else if (feedbackInputActivity.Z.getText().toString().trim().length() > 200) {
                Toast.makeText(feedbackInputActivity, t1.a("16"), 0).show();
            } else if (!p1.e(feedbackInputActivity)) {
                Toast.makeText(feedbackInputActivity, t1.a("19"), 1).show();
            } else if (feedbackInputActivity.l0.a.length() == 0) {
                Toast.makeText(feedbackInputActivity, t1.a("18"), 1).show();
                feedbackInputActivity.l0.a(false);
            } else {
                if (feedbackInputActivity.getCurrentFocus() != null && feedbackInputActivity.getCurrentFocus().getWindowToken() != null) {
                    ((InputMethodManager) feedbackInputActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackInputActivity.getCurrentFocus().getWindowToken(), 2);
                }
                feedbackInputActivity.Y = true;
                feedbackInputActivity.Z.setEnabled(false);
                feedbackInputActivity.x.setVisibility(0);
                feedbackInputActivity.x.bringToFront();
                new Thread(new u0(feedbackInputActivity)).start();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InputMethodManager inputMethodManager;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                LinearLayout linearLayout = this.e;
                boolean z2 = true;
                if (linearLayout != null) {
                    int[] iArr = {0, 0};
                    linearLayout.getLocationInWindow(iArr);
                    int i2 = iArr[0];
                    int i3 = iArr[1];
                    int height = linearLayout.getHeight() + i3;
                    int width = linearLayout.getWidth() + i2;
                    if (motionEvent.getX() <= i2 || motionEvent.getX() >= width || motionEvent.getY() <= i3 || motionEvent.getY() >= height) {
                        ArrayList<View> arrayList = this.E;
                        if (arrayList != null) {
                            Iterator<View> it = arrayList.iterator();
                            while (it.hasNext()) {
                                View next = it.next();
                                int[] iArr2 = new int[2];
                                next.getLocationOnScreen(iArr2);
                                int i4 = iArr2[0];
                                int i5 = iArr2[1];
                                if (motionEvent.getX() >= i4 && motionEvent.getX() <= i4 + next.getWidth() && motionEvent.getY() >= i5 && motionEvent.getY() <= i5 + next.getHeight()) {
                                    z = true;
                                    continue;
                                } else {
                                    z = false;
                                    continue;
                                }
                                if (z) {
                                }
                            }
                        }
                        if (z2 && (inputMethodManager = (InputMethodManager) getSystemService("input_method")) != null) {
                            inputMethodManager.hideSoftInputFromWindow(linearLayout.getWindowToken(), 0);
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    inputMethodManager.hideSoftInputFromWindow(linearLayout.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public static void x(FeedbackInputActivity feedbackInputActivity) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, feedbackInputActivity) == null) {
            if (feedbackInputActivity != null) {
                String str = s1.k;
                String str2 = "getEvaluateConfig url: " + str;
                HashMap hashMap = new HashMap();
                hashMap.put("clientid", feedbackInputActivity.l0.a);
                hashMap.put("appid", feedbackInputActivity.l0.b);
                hashMap.put("devid", feedbackInputActivity.l0.c);
                hashMap.put("brand", "");
                hashMap.put("model", "");
                hashMap.put("sdkvn", "4.1.9.1");
                hashMap.put("os", "android");
                hashMap.put("appvn", com.baidu.ufosdk.c.b());
                hashMap.put("baiducuid", com.baidu.ufosdk.b.f());
                hashMap.put("extra", com.baidu.ufosdk.b.g());
                hashMap.put("uid", com.baidu.ufosdk.b.c());
                hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.c());
                hashMap.put("username", com.baidu.ufosdk.b.b());
                hashMap.put("extend_feedback_channel", com.baidu.ufosdk.b.h());
                hashMap.put("osvn", "");
                String b2 = com.baidu.ufosdk.b.b(com.baidu.ufosdk.b.a(hashMap));
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("sdk_encrypt", b2);
                    String a2 = d0.a(str, d0.a(hashMap2));
                    if (!TextUtils.isEmpty(a2)) {
                        JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.b.a(a2));
                        String str3 = "getEvaluateConfig response is -----------------> " + jSONObject.toString();
                        if (jSONObject.optInt("errno", 1) != 1 && (optJSONObject = jSONObject.optJSONObject("conf")) != null) {
                            feedbackInputActivity.I = optJSONObject.optString("good_toast");
                            feedbackInputActivity.J = optJSONObject.optString("bad_toast");
                            int optInt = optJSONObject.optInt("discontent_switch");
                            feedbackInputActivity.K = optInt;
                            if (optInt != 0 && (optJSONObject2 = optJSONObject.optJSONObject("discontent")) != null) {
                                feedbackInputActivity.L = optJSONObject2.optString("discontent_reason_tips");
                                JSONArray optJSONArray = optJSONObject2.optJSONArray("required_discontent_fields");
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    if (optJSONArray.length() == 2) {
                                        feedbackInputActivity.M = 3;
                                    } else if (optJSONArray.length() == 1) {
                                        if (optJSONArray.toString().contains("discontent_reason")) {
                                            feedbackInputActivity.M = 1;
                                        } else if (optJSONArray.toString().contains("discontent_labels")) {
                                            feedbackInputActivity.M = 2;
                                        }
                                    }
                                }
                                feedbackInputActivity.N = optJSONObject2.optJSONArray("discontent_labels");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            throw null;
        }
    }

    public static void z(FeedbackInputActivity feedbackInputActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, feedbackInputActivity) == null) {
            if (feedbackInputActivity != null) {
                if (!com.baidu.ufosdk.b.n()) {
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                    intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                    if (feedbackInputActivity.a == feedbackInputActivity.c.size() - 1) {
                        if (feedbackInputActivity.getCurrentFocus() != null && feedbackInputActivity.getCurrentFocus().getWindowToken() != null) {
                            ((InputMethodManager) feedbackInputActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackInputActivity.getCurrentFocus().getWindowToken(), 2);
                        }
                        try {
                            feedbackInputActivity.startActivityForResult(intent, 11);
                            try {
                                feedbackInputActivity.overridePendingTransition(p1.a(feedbackInputActivity.getApplicationContext(), "ufo_slide_in_from_bottom"), 0);
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        } catch (ActivityNotFoundException unused2) {
                            Toast.makeText(feedbackInputActivity, t1.a("0"), 1).show();
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

    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            Button button = new Button(this);
            button.setBackgroundDrawable(null);
            button.setText("复制");
            button.setTextSize(1, 12.0f);
            button.setTextColor(-1);
            button.setGravity(17);
            PopupWindow popupWindow = new PopupWindow((View) button, p1.a(getApplicationContext(), 60.0f), p1.a(getApplicationContext(), 35.0f), true);
            popupWindow.setTouchable(true);
            popupWindow.getContentView().setOnClickListener(new j(this, view2, popupWindow));
            popupWindow.setTouchInterceptor(new k(this));
            try {
                popupWindow.setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.obfuscated_res_0x7f081547)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            popupWindow.showAsDropDown(view2);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.x.getVisibility() == 0) {
                this.x.setVisibility(8);
                this.Y = false;
                this.i0.setVisibility(0);
                this.Z.setEnabled(true);
                return;
            }
            if (this.j0) {
                Intent intent = new Intent(this, FeedbackListActivity.class);
                intent.putExtra("feedback_channel", com.baidu.ufosdk.b.h());
                intent.putExtra("backPress", true);
                startActivity(intent);
            }
            finish();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("from", 1);
            hashMap.put("content", getString(R.string.obfuscated_res_0x7f0f1267));
            hashMap.put("contenttype", "0");
            hashMap.put("time", String.valueOf(System.currentTimeMillis()));
            hashMap.put("ask", 0);
            this.o.add(hashMap);
            this.z = true;
            this.q.notifyDataSetChanged();
            ListView listView = this.p;
            listView.setSelection(listView.getBottom());
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            super.onPause();
            this.v.putString("contactWay", null);
            if (this.b0) {
                if (!TextUtils.isEmpty(this.a0)) {
                    this.v.putString(this.a0, this.Z.getText().toString());
                } else {
                    this.v.putString(this.l, this.Z.getText().toString());
                }
            }
            this.v.commit();
        }
    }

    public final boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6, Handler handler, int i2) {
        InterceptResult invokeCommon;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, str2, str3, str4, str5, str6, handler, Integer.valueOf(i2)})) == null) {
            String str7 = s1.f;
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", str);
            if (str3 != null && str3.length() > 0) {
                hashMap.put("appid", str3);
            } else {
                hashMap.put("appid", this.l0.b);
            }
            hashMap.put("devid", this.l0.c);
            if (i2 != -999) {
                hashMap.put("robotQuestionId", Integer.valueOf(i2));
            }
            String str8 = "sendChat---2018 tempRobotSwitch = " + this.C;
            if (this.C && !this.V) {
                hashMap.put("answerPerson", "robot");
            }
            if (str2 != null && !str2.contains("newMessage")) {
                hashMap.put("id", str2);
            }
            hashMap.put("content", str4);
            if (p1.a(str5)) {
                c2 = 1;
            } else if (p1.b(str5)) {
                c2 = 2;
            } else if (p1.c(str5)) {
                c2 = 3;
            } else {
                c2 = 0;
            }
            String str9 = "contactWay is " + str5;
            if (c2 == 0) {
                hashMap.put("contact_way", str5);
            } else if (c2 == 1) {
                hashMap.put("email", str5);
            } else if (c2 == 2) {
                hashMap.put("tel", str5);
            } else if (c2 == 3) {
                hashMap.put(LoginConstants.QQ_LOGIN, str5);
            } else {
                hashMap.put("contact_way", str5);
            }
            hashMap.put("brand", "");
            hashMap.put("model", "");
            hashMap.put("sdkvn", "4.1.9.1");
            hashMap.put("os", "android");
            hashMap.put("appvn", com.baidu.ufosdk.c.b());
            hashMap.put("baiducuid", com.baidu.ufosdk.b.f());
            hashMap.put("extra", com.baidu.ufosdk.b.g());
            hashMap.put("uid", com.baidu.ufosdk.b.c());
            hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.c());
            hashMap.put("username", com.baidu.ufosdk.b.b());
            hashMap.put("extend_feedback_channel", com.baidu.ufosdk.b.h());
            hashMap.put("osvn", "");
            if (!TextUtils.isEmpty(this.a0)) {
                hashMap.put("faq_id", this.a0);
            }
            hashMap.put("phonetime", String.valueOf(System.currentTimeMillis()));
            hashMap.put(FpsTracer.UBC_KEY_NET_TYPE, p1.b(context));
            hashMap.put("screenSize", com.baidu.ufosdk.b.h(context));
            hashMap.put("ip_location", com.baidu.ufosdk.b.k());
            String b2 = com.baidu.ufosdk.b.b(com.baidu.ufosdk.b.a(hashMap));
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sdk_encrypt", b2);
                if (!TextUtils.isEmpty(str6)) {
                    hashMap2.put(StatisticConstants.SCREENSHOT, str6);
                }
                String a2 = d0.a(str7, d0.a(hashMap2));
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.b.a(a2));
                    String str10 = "postUrl: " + str7;
                    String str11 = "sendChat response is -----------------> " + jSONObject.toString();
                    String str12 = "sendChat---2111 tempRobotSwitch = " + this.C;
                    if (this.C) {
                        if (jSONObject.has("round")) {
                            this.A = ((Integer) jSONObject.get("round")).intValue();
                        } else {
                            this.C = false;
                        }
                    }
                    int intValue = ((Integer) jSONObject.get("errno")).intValue();
                    if (intValue == 0) {
                        com.baidu.ufosdk.b.a(context, System.currentTimeMillis());
                        String valueOf = String.valueOf(jSONObject.get("id"));
                        String str13 = "sendChat --> msgId = " + str2;
                        if (str2 != null && str2.contains("newMessage")) {
                            if (str3 != null && str3.length() > 0) {
                                handler.obtainMessage(14, Integer.parseInt(valueOf), Integer.parseInt(str3)).sendToTarget();
                            } else {
                                handler.obtainMessage(14, Integer.parseInt(valueOf), Integer.parseInt(this.l0.b)).sendToTarget();
                            }
                        } else if (str3 != null && str3.length() > 0) {
                            handler.obtainMessage(12, Integer.parseInt(valueOf), Integer.parseInt(str3)).sendToTarget();
                        } else {
                            handler.obtainMessage(12, Integer.parseInt(valueOf), Integer.parseInt(this.l0.b)).sendToTarget();
                        }
                        return true;
                    } else if (intValue == 4) {
                        String str14 = (String) jSONObject.get("errmsg");
                        com.baidu.ufosdk.b.a(str14, 1);
                        handler.obtainMessage(17, str14).sendToTarget();
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            } catch (Exception unused) {
                com.baidu.ufosdk.b.a(t1.a("18"), 1);
                handler.obtainMessage(13).sendToTarget();
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void c() {
        LinearLayout linearLayout;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (linearLayout = this.b) == null) {
            return;
        }
        linearLayout.removeAllViews();
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            if (i2 != this.c.size() - 1) {
                e1 e1Var = new e1(this);
                e1Var.setTag(Integer.valueOf(i2));
                e1Var.setBackgroundDrawable(null);
                e1Var.setPadding(0, 0, 0, 0);
                e1Var.setScaleType(ImageView.ScaleType.CENTER_CROP);
                e1Var.setMaxHeight(p1.a(getApplicationContext(), 56.0f));
                e1Var.setMinimumHeight(p1.a(getApplicationContext(), 56.0f));
                e1Var.setMaxWidth(p1.a(getApplicationContext(), 56.0f));
                e1Var.setMinimumWidth(p1.a(getApplicationContext(), 56.0f));
                relativeLayout.addView(e1Var, new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 56.0f), p1.a(getApplicationContext(), 56.0f)));
                try {
                    if (this.c.get(i2) != null) {
                        if (BitmapFactory.decodeByteArray(this.c.get(i2), 0, this.c.get(i2).length) == null) {
                            return;
                        }
                        bitmap = BitmapFactory.decodeByteArray(this.c.get(i2), 0, this.c.get(i2).length);
                    } else {
                        bitmap = null;
                    }
                    if (bitmap != null && a(bitmap, p1.a(getApplicationContext(), 56.0f)) != null) {
                        e1Var.setImageBitmap(bitmap);
                        ImageButton imageButton = new ImageButton(this);
                        imageButton.setTag(Integer.valueOf(i2));
                        imageButton.setBackgroundDrawable(null);
                        imageButton.setPadding(p1.a(getApplicationContext(), 9.0f), 0, 0, p1.a(getApplicationContext(), 9.0f));
                        imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
                        Bitmap b2 = p1.b(getApplicationContext(), "ufo_delete_little_icon.png");
                        if (b2 == null) {
                            return;
                        }
                        imageButton.setImageBitmap(b2);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 26.0f), p1.a(getApplicationContext(), 26.0f));
                        layoutParams.addRule(11);
                        layoutParams.addRule(10);
                        relativeLayout.addView(imageButton, layoutParams);
                        imageButton.setOnClickListener(new f(this));
                    } else {
                        return;
                    }
                } catch (OutOfMemoryError unused) {
                    System.gc();
                    return;
                }
            } else {
                ImageView imageView = new ImageView(this);
                imageView.setTag(Integer.valueOf(i2));
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(0, 0, 0, 0);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setMaxHeight(p1.a(getApplicationContext(), 56.0f));
                imageView.setMinimumHeight(p1.a(getApplicationContext(), 56.0f));
                imageView.setMaxWidth(p1.a(getApplicationContext(), 56.0f));
                imageView.setMinimumWidth(p1.a(getApplicationContext(), 56.0f));
                relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 56.0f), p1.a(getApplicationContext(), 56.0f)));
                try {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(this.c.get(i2), 0, this.c.get(i2).length);
                    if (decodeByteArray != null && a(decodeByteArray, p1.a(getApplicationContext(), 45.0f)) != null) {
                        imageView.setImageBitmap(decodeByteArray);
                        imageView.setOnClickListener(new g(this));
                    } else {
                        return;
                    }
                } catch (OutOfMemoryError unused2) {
                    System.gc();
                    return;
                }
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 56.0f), p1.a(getApplicationContext(), 56.0f));
            if (i2 == 0) {
                layoutParams2.setMargins(p1.a(getApplicationContext(), 8.0f), 0, 0, 0);
            } else {
                layoutParams2.setMargins(p1.a(getApplicationContext(), 7.0f), 0, 0, 0);
            }
            layoutParams2.gravity = 17;
            this.b.addView(relativeLayout, layoutParams2);
        }
        if (this.c.size() == 5) {
            Toast.makeText(this, "最多上传4张图", 0).show();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e4, code lost:
        if (r15 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f2, code lost:
        if (r15 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f4, code lost:
        r15.close();
     */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i2, int i3, Intent intent) {
        byte[] bArr;
        Uri uri;
        byte[] bArr2;
        Exception e2;
        int i4;
        byte[] byteArray;
        Cursor cursor;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, intent) == null) {
            String str = " --*^o^*-- requestCode = " + i2 + "; resultCode = " + i3 + "currentIcon = " + this.a;
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                return;
            }
            if (i3 == -76) {
                List<byte[]> list = this.c;
                list.remove(list.size() - 1);
                this.W.obtainMessage(17).sendToTarget();
            }
            if (i2 == this.c.size() - 1) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("shot");
                if (byteArrayExtra != null && byteArrayExtra.length > 0) {
                    this.c.set(i2, byteArrayExtra);
                }
                this.c.add(p1.a(this, this.f1196T));
                c();
                return;
            } else if (intent == null) {
                return;
            } else {
                bArr = null;
                try {
                    uri = intent.getData();
                } catch (Exception unused) {
                    uri = null;
                }
                if (uri == null) {
                    return;
                }
                try {
                    InputStream openInputStream = getContentResolver().openInputStream(uri);
                    try {
                        if (openInputStream.available() < 8388608) {
                            byte[] bArr3 = new byte[1024];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                int read = openInputStream.read(bArr3);
                                i4 = 0;
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr3, 0, read);
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            openInputStream.close();
                            try {
                                if (byteArray == null) {
                                    Toast.makeText(this, t1.a("21"), 1).show();
                                    return;
                                }
                                try {
                                    cursor = getContentResolver().query(uri, null, null, null, null);
                                    if (cursor != null) {
                                        try {
                                            cursor.moveToFirst();
                                            String string = cursor.getString(cursor.getColumnIndex("orientation"));
                                            if (string != null) {
                                                i4 = Integer.parseInt(string);
                                            }
                                        } catch (Exception unused2) {
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (cursor != null) {
                                                try {
                                                    cursor.close();
                                                } catch (Exception unused3) {
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (Exception unused4) {
                                    cursor = null;
                                } catch (Throwable th3) {
                                    cursor = null;
                                    th = th3;
                                }
                            } catch (Exception e3) {
                                e2 = e3;
                                bArr2 = byteArray;
                            }
                        } else {
                            Toast.makeText(this, t1.a("21"), 1).show();
                            return;
                        }
                    } catch (Exception e4) {
                        bArr2 = null;
                        e2 = e4;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            }
        } else {
            return;
        }
        bArr2 = com.baidu.ufosdk.b.a(byteArray, i4);
        try {
        } catch (Exception e6) {
            e2 = e6;
            byte[] bArr4 = bArr2;
            e = e2;
            bArr = bArr4;
            System.out.println(e.getMessage());
            bArr2 = bArr;
            if (bArr2 != null && bArr2.length != 0 && i2 == 11) {
                int i5 = this.a;
                Intent intent2 = new Intent(this, ScreenCapEditActivity.class);
                intent2.putExtra("inputshot", bArr2);
                intent2.putExtra("input", true);
                startActivityForResult(intent2, i5);
            }
            this.Z.setFocusable(true);
            this.Z.setFocusableInTouchMode(true);
        }
        if (bArr2 == null) {
            Toast.makeText(this, t1.a("21"), 1).show();
        } else if (bArr2.length > 1048576) {
            Toast.makeText(this, t1.a("21"), 1).show();
        } else {
            if (p1.d(this) < 35000) {
                Toast.makeText(this, t1.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK), 1).show();
                System.gc();
                return;
            }
            if (bArr2 != null) {
                int i52 = this.a;
                Intent intent22 = new Intent(this, ScreenCapEditActivity.class);
                intent22.putExtra("inputshot", bArr2);
                intent22.putExtra("input", true);
                startActivityForResult(intent22, i52);
            }
            this.Z.setFocusable(true);
            this.Z.setFocusableInTouchMode(true);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c1 c1Var = this.F;
            if (c1Var != null) {
                if (c1Var.isShowing()) {
                    this.F.dismiss();
                }
                this.F = null;
            }
            m1.b = null;
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStart();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.ufosdk.getchat");
            intentFilter.addAction("com.baidu.ufosdk.getmsgid");
            intentFilter.addAction("com.baidu.ufosdk.deletemsg_dialogdismiss");
            intentFilter.addAction("com.baidu.ufosdk.reload");
            registerReceiver(this.X, intentFilter);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        View currentFocus;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStop();
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && (currentFocus = getCurrentFocus()) != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getApplicationWindowToken(), 2);
            }
            unregisterReceiver(this.X);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            this.j.setText(t1.a("22"));
            p1.a((RelativeLayout) this.r, t1.a("13"));
            if (!TextUtils.isEmpty(this.l) && !this.l.equals("newMessage")) {
                v1.b.a.a(new v0(this));
            }
            p1.a((RelativeLayout) this.x, t1.a("25"));
            this.b0 = true;
            String str = this.l;
            if (str == null) {
                this.l = "newMessage";
            } else if (str.length() == 0) {
                this.l = "newMessage";
            }
            String str2 = this.c0;
            String str3 = "";
            if (str2 != null) {
                this.Z.setText(str2);
            } else if (!TextUtils.isEmpty(this.a0)) {
                str3 = this.w.getString(this.a0, "");
                this.Z.setText(str3);
            } else {
                str3 = this.w.getString(this.l, "");
                this.Z.setText(str3);
            }
            this.Z.setSelection(str3.length());
            if (this.Z.getText().toString().trim().length() <= 0) {
                this.i0.setVisibility(8);
            } else {
                this.i0.setVisibility(0);
            }
            if (this.l0.a.length() == 0) {
                new Thread(new h(this)).start();
            } else {
                new Thread(new i(this)).start();
            }
        }
    }
}
