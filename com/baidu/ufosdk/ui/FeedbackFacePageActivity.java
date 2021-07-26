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
import androidx.core.view.InputDeviceCompat;
import androidx.room.RoomMasterTable;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
import java.io.File;
import java.util.Timer;
/* loaded from: classes4.dex */
public class FeedbackFacePageActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences.Editor f23538a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f23539b;

    /* renamed from: c  reason: collision with root package name */
    public String f23540c;

    /* renamed from: d  reason: collision with root package name */
    public String f23541d;

    /* renamed from: e  reason: collision with root package name */
    public String f23542e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f23543f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f23544g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f23545h;

    /* renamed from: i  reason: collision with root package name */
    public Button f23546i;
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
    public boolean u;
    @SuppressLint({"HandlerLeak"})
    public Handler v;
    public LinearLayout w;

    public FeedbackFacePageActivity() {
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
        this.f23540c = "";
        this.f23541d = "";
        this.f23542e = "";
        this.u = false;
        this.v = new ah(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || UfoSDK.clientid.length() == 0) {
            return;
        }
        this.v.obtainMessage(2, null).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            getApplicationContext();
            new au(this).execute(new Void[0]);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            intent.putExtra("url", this.f23540c);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            intent.putExtra("extra", this.f23541d);
            intent.setClass(this, FeedbackListActivity.class);
            startActivity(intent);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:108:0x085f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:113:0x0742 */
    /* JADX WARN: Can't wrap try/catch for region: R(33:3|(11:4|5|(1:7)|8|(1:10)|11|(7:102|103|(1:105)|106|(1:108)|109|(1:111))|13|(1:15)|16|(1:18))|(2:20|21)|(4:22|23|(1:25)|26)|(4:(2:28|(1:(1:31)(30:96|34|(1:36)|37|38|39|40|41|42|43|(1:45)|46|47|48|49|50|(14:55|56|57|58|59|(1:61)|62|63|64|65|(1:69)|71|72|73)|79|(4:81|82|83|84)|85|59|(0)|62|63|64|65|(2:67|69)|71|72|73))(31:97|33|34|(0)|37|38|39|40|41|42|43|(0)|46|47|48|49|50|(15:52|55|56|57|58|59|(0)|62|63|64|65|(0)|71|72|73)|79|(0)|85|59|(0)|62|63|64|65|(0)|71|72|73))(1:98)|71|72|73)|32|33|34|(0)|37|38|39|40|41|42|43|(0)|46|47|48|49|50|(0)|79|(0)|85|59|(0)|62|63|64|65|(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(50:3|4|5|(1:7)|8|(1:10)|11|(7:102|103|(1:105)|106|(1:108)|109|(1:111))|13|(1:15)|16|(1:18)|20|21|22|23|(1:25)|26|(2:28|(1:(1:31)(30:96|34|(1:36)|37|38|39|40|41|42|43|(1:45)|46|47|48|49|50|(14:55|56|57|58|59|(1:61)|62|63|64|65|(1:69)|71|72|73)|79|(4:81|82|83|84)|85|59|(0)|62|63|64|65|(2:67|69)|71|72|73))(31:97|33|34|(0)|37|38|39|40|41|42|43|(0)|46|47|48|49|50|(15:52|55|56|57|58|59|(0)|62|63|64|65|(0)|71|72|73)|79|(0)|85|59|(0)|62|63|64|65|(0)|71|72|73))(1:98)|32|33|34|(0)|37|38|39|40|41|42|43|(0)|46|47|48|49|50|(0)|79|(0)|85|59|(0)|62|63|64|65|(0)|71|72|73) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x05b4, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x05b5, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0640, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0641, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x072f, code lost:
        com.baidu.ufosdk.f.c.a("webView --> This API level do not support `removeJavascriptInterface`");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0554 A[Catch: Exception -> 0x085e, TryCatch #4 {Exception -> 0x085e, blocks: (B:37:0x012a, B:39:0x012e, B:40:0x0135, B:45:0x03d8, B:49:0x03f2, B:51:0x03f7, B:53:0x0554, B:54:0x055b, B:59:0x05b8, B:64:0x0644, B:66:0x06aa, B:67:0x06b1, B:71:0x0734, B:73:0x0744, B:76:0x0755, B:79:0x076f, B:87:0x07aa, B:89:0x07eb, B:90:0x07ee, B:93:0x0838, B:95:0x0852, B:97:0x085a, B:80:0x0779, B:82:0x078d, B:85:0x079c, B:86:0x07a3, B:70:0x072f, B:63:0x0641, B:58:0x05b5, B:46:0x03dc, B:47:0x03e6, B:48:0x03ef, B:60:0x062e, B:68:0x0706, B:55:0x05a1), top: B:117:0x012a, inners: #0, #3, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x06aa A[Catch: Exception -> 0x085e, TryCatch #4 {Exception -> 0x085e, blocks: (B:37:0x012a, B:39:0x012e, B:40:0x0135, B:45:0x03d8, B:49:0x03f2, B:51:0x03f7, B:53:0x0554, B:54:0x055b, B:59:0x05b8, B:64:0x0644, B:66:0x06aa, B:67:0x06b1, B:71:0x0734, B:73:0x0744, B:76:0x0755, B:79:0x076f, B:87:0x07aa, B:89:0x07eb, B:90:0x07ee, B:93:0x0838, B:95:0x0852, B:97:0x085a, B:80:0x0779, B:82:0x078d, B:85:0x079c, B:86:0x07a3, B:70:0x072f, B:63:0x0641, B:58:0x05b5, B:46:0x03dc, B:47:0x03e6, B:48:0x03ef, B:60:0x062e, B:68:0x0706, B:55:0x05a1), top: B:117:0x012a, inners: #0, #3, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0744 A[Catch: Exception -> 0x085e, TryCatch #4 {Exception -> 0x085e, blocks: (B:37:0x012a, B:39:0x012e, B:40:0x0135, B:45:0x03d8, B:49:0x03f2, B:51:0x03f7, B:53:0x0554, B:54:0x055b, B:59:0x05b8, B:64:0x0644, B:66:0x06aa, B:67:0x06b1, B:71:0x0734, B:73:0x0744, B:76:0x0755, B:79:0x076f, B:87:0x07aa, B:89:0x07eb, B:90:0x07ee, B:93:0x0838, B:95:0x0852, B:97:0x085a, B:80:0x0779, B:82:0x078d, B:85:0x079c, B:86:0x07a3, B:70:0x072f, B:63:0x0641, B:58:0x05b5, B:46:0x03dc, B:47:0x03e6, B:48:0x03ef, B:60:0x062e, B:68:0x0706, B:55:0x05a1), top: B:117:0x012a, inners: #0, #3, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x078d A[Catch: Exception -> 0x085e, TRY_LEAVE, TryCatch #4 {Exception -> 0x085e, blocks: (B:37:0x012a, B:39:0x012e, B:40:0x0135, B:45:0x03d8, B:49:0x03f2, B:51:0x03f7, B:53:0x0554, B:54:0x055b, B:59:0x05b8, B:64:0x0644, B:66:0x06aa, B:67:0x06b1, B:71:0x0734, B:73:0x0744, B:76:0x0755, B:79:0x076f, B:87:0x07aa, B:89:0x07eb, B:90:0x07ee, B:93:0x0838, B:95:0x0852, B:97:0x085a, B:80:0x0779, B:82:0x078d, B:85:0x079c, B:86:0x07a3, B:70:0x072f, B:63:0x0641, B:58:0x05b5, B:46:0x03dc, B:47:0x03e6, B:48:0x03ef, B:60:0x062e, B:68:0x0706, B:55:0x05a1), top: B:117:0x012a, inners: #0, #3, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x07eb A[Catch: Exception -> 0x085e, TryCatch #4 {Exception -> 0x085e, blocks: (B:37:0x012a, B:39:0x012e, B:40:0x0135, B:45:0x03d8, B:49:0x03f2, B:51:0x03f7, B:53:0x0554, B:54:0x055b, B:59:0x05b8, B:64:0x0644, B:66:0x06aa, B:67:0x06b1, B:71:0x0734, B:73:0x0744, B:76:0x0755, B:79:0x076f, B:87:0x07aa, B:89:0x07eb, B:90:0x07ee, B:93:0x0838, B:95:0x0852, B:97:0x085a, B:80:0x0779, B:82:0x078d, B:85:0x079c, B:86:0x07a3, B:70:0x072f, B:63:0x0641, B:58:0x05b5, B:46:0x03dc, B:47:0x03e6, B:48:0x03ef, B:60:0x062e, B:68:0x0706, B:55:0x05a1), top: B:117:0x012a, inners: #0, #3, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0852 A[Catch: Exception -> 0x085e, TryCatch #4 {Exception -> 0x085e, blocks: (B:37:0x012a, B:39:0x012e, B:40:0x0135, B:45:0x03d8, B:49:0x03f2, B:51:0x03f7, B:53:0x0554, B:54:0x055b, B:59:0x05b8, B:64:0x0644, B:66:0x06aa, B:67:0x06b1, B:71:0x0734, B:73:0x0744, B:76:0x0755, B:79:0x076f, B:87:0x07aa, B:89:0x07eb, B:90:0x07ee, B:93:0x0838, B:95:0x0852, B:97:0x085a, B:80:0x0779, B:82:0x078d, B:85:0x079c, B:86:0x07a3, B:70:0x072f, B:63:0x0641, B:58:0x05b5, B:46:0x03dc, B:47:0x03e6, B:48:0x03ef, B:60:0x062e, B:68:0x0706, B:55:0x05a1), top: B:117:0x012a, inners: #0, #3, #8 }] */
    /* JADX WARN: Type inference failed for: r0v19, types: [android.widget.RelativeLayout, android.view.View] */
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
        int i2;
        int i3;
        int i4;
        String b2;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) != null) {
            return;
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setSoftInputMode(32);
        com.baidu.ufosdk.f.r.a(this, getWindow());
        com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.f23543f = relativeLayout;
            relativeLayout.setBackgroundColor(com.baidu.ufosdk.b.z);
            this.f23543f.setFitsSystemWindows(true);
            setContentView(this.f23543f);
            SharedPreferences sharedPreferences = getSharedPreferences("UfoSharePreference", 0);
            this.f23539b = sharedPreferences;
            if (sharedPreferences != null) {
                this.f23538a = sharedPreferences.edit();
            }
            if (this.f23538a != null) {
                this.f23538a.putBoolean("ADD_PIC_FLAG", true);
                this.f23538a.commit();
            }
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    String stringExtra = intent.getStringExtra("username");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        com.baidu.ufosdk.b.f23441b = stringExtra;
                    }
                    String stringExtra2 = intent.getStringExtra("baiducuid");
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        com.baidu.ufosdk.b.f23442c = stringExtra2;
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
            this.f23542e = getIntent().getStringExtra("faq_id");
            String stringExtra4 = getIntent().getStringExtra("msgid");
            this.t = stringExtra4;
            if (TextUtils.isEmpty(stringExtra4)) {
                this.t = "newMessage";
            }
            if (TextUtils.isEmpty(this.f23542e)) {
                this.f23542e = "";
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
            this.f23543f.setId(R.drawable.res_0x7f080004_avd_show_password__1);
            ?? relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setId(R.id.BLOCK);
            linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0, 0, 0);
            ImageView imageView = new ImageView(this);
            this.f23545h = imageView;
            imageView.setId(R.drawable.res_0x7f080001_avd_hide_password__1);
            this.f23545h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f23545h.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_back_icon_browser.png")));
            linearLayout.addView(this.f23545h, layoutParams);
            TextView textView = new TextView(this);
            textView.setText(com.baidu.ufosdk.b.f23448i);
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
            this.f23546i = button;
            button.setText(com.baidu.ufosdk.f.s.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP));
            this.f23546i.setId(R.id.BOTTOM_END);
            this.f23546i.setTextColor(com.baidu.ufosdk.b.s);
            this.f23546i.setTextSize(com.baidu.ufosdk.b.U);
            this.f23546i.setGravity(17);
            this.f23546i.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.s, com.baidu.ufosdk.b.t, com.baidu.ufosdk.b.s, com.baidu.ufosdk.b.s));
            this.f23546i.setBackgroundColor(16777215);
            this.f23546i.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(11);
            layoutParams5.addRule(15);
            layoutParams5.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 6.0f), 0);
            relativeLayout2.addView(this.f23546i, layoutParams5);
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
            this.f23543f.addView(relativeLayout2, layoutParams7);
            view = new View(this);
            view.setId(R.id.RIGHT);
            view.setBackgroundColor(-2894893);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            layoutParams8.addRule(3, relativeLayout2.getId());
            this.f23543f.addView(view, layoutParams8);
            LinearLayout linearLayout4 = new LinearLayout(this);
            this.w = linearLayout4;
            linearLayout4.setId(R.id.SELECT);
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
            textView3.setText(com.baidu.ufosdk.f.s.a(RoomMasterTable.DEFAULT_ID));
            this.r.setTextColor(-13421773);
            this.r.setTextSize(com.baidu.ufosdk.b.Z);
            TextView textView4 = new TextView(this);
            this.s = textView4;
            textView4.setText(com.baidu.ufosdk.f.s.a("43"));
            this.s.setTextColor(-13421773);
            this.s.setTextSize(com.baidu.ufosdk.b.Z);
            i2 = com.baidu.ufosdk.b.q;
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
            if (i2 == 0) {
                linearLayout2.setVisibility(0);
            } else if (i2 == 1) {
                linearLayout2.setVisibility(0);
                linearLayout3.setVisibility(8);
                i4 = 10;
                i3 = 7;
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
                layoutParams9.setMargins(com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a(this, i4), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
                layoutParams9.weight = 1.0f;
                this.w.addView(linearLayout2, layoutParams9);
                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams10.setMargins(com.baidu.ufosdk.f.i.a(this, i3), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
                layoutParams10.weight = 1.0f;
                this.w.addView(linearLayout3, layoutParams10);
                RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
                layoutParams11.addRule(12);
                this.f23543f.addView(this.w, layoutParams11);
                View view2 = new View(this);
                view2.setId(R.id.SHIFT);
                view2.setBackgroundColor(-2894893);
                RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
                layoutParams12.addRule(2, this.w.getId());
                this.f23543f.addView(view2, layoutParams12);
                linearLayout3.setOnClickListener(new ai(this));
                linearLayout2.setOnClickListener(new ak(this));
                linearLayout.setOnClickListener(new am(this));
                this.f23546i.setOnClickListener(new an(this));
                int id = view.getId();
                int id2 = view2.getId();
                this.m = new RelativeLayout(this);
                if (this.o == null) {
                }
                this.m.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                LinearLayout linearLayout5 = new LinearLayout(this);
                this.f23544g = linearLayout5;
                linearLayout5.setOrientation(1);
                this.f23544g.setGravity(17);
                this.f23544g.setVisibility(8);
                new LinearLayout.LayoutParams(-2, -2);
                ImageView imageView4 = new ImageView(this);
                LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 115.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 85.0f));
                imageView4.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_no_netwrok.png")));
                this.f23544g.addView(imageView4, layoutParams13);
                TextView textView5 = new TextView(this);
                this.q = textView5;
                textView5.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f));
                this.q.setTextSize(com.baidu.ufosdk.b.O);
                this.q.setTextColor(com.baidu.ufosdk.b.x);
                LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, -2);
                com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
                this.f23544g.addView(this.q, layoutParams14);
                Button button2 = new Button(this);
                this.j = button2;
                button2.setText(com.baidu.ufosdk.f.s.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE));
                this.j.setTextSize(com.baidu.ufosdk.b.P);
                this.j.setTextColor(com.baidu.ufosdk.b.w);
                this.j.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
                LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 122.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
                layoutParams15.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0);
                this.f23544g.addView(this.j, layoutParams15);
                RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams16.addRule(13);
                this.m.addView(this.f23544g, layoutParams16);
                this.j.setOnClickListener(new ao(this));
                LinearLayout linearLayout6 = new LinearLayout(this);
                linearLayout6.setOrientation(0);
                linearLayout6.setGravity(16);
                LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-1, -1);
                if (Integer.parseInt(Build.VERSION.SDK) >= 11) {
                }
                linearLayout6.addView(this.o, layoutParams17);
                this.m.addView(linearLayout6, new RelativeLayout.LayoutParams(-1, -1));
                this.n = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a("13"));
                RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams18.addRule(13);
                this.m.addView(this.n, layoutParams18);
                RelativeLayout.LayoutParams layoutParams19 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams19.addRule(3, id);
                layoutParams19.addRule(2, id2);
                this.f23543f.addView(this.m, layoutParams19);
                this.o.getSettings().setJavaScriptEnabled(true);
                this.o.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
                this.o.getClass().getMethod("removeJavascriptInterface", String.class);
                this.o.removeJavascriptInterface("searchBoxJavaBridge_");
                this.o.removeJavascriptInterface("accessibility");
                this.o.removeJavascriptInterface("accessibilityTraversal");
                b2 = com.baidu.ufosdk.b.d.b(getApplicationContext());
                r3 = RomUtils.UNKNOWN;
                if (!b2.contains(RomUtils.UNKNOWN)) {
                    this.f23538a.putBoolean("CHECK_WEBVIEW", false);
                    this.f23538a.commit();
                    this.f23544g.setVisibility(8);
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
                if (this.f23539b.getBoolean("CHECK_WEBVIEW", true)) {
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
            } else if (i2 == 2) {
                linearLayout2.setVisibility(8);
                linearLayout3.setVisibility(0);
                i4 = 7;
                i3 = 10;
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
                layoutParams92.setMargins(com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a(this, i4), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
                layoutParams92.weight = 1.0f;
                this.w.addView(linearLayout2, layoutParams92);
                LinearLayout.LayoutParams layoutParams102 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams102.setMargins(com.baidu.ufosdk.f.i.a(this, i3), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
                layoutParams102.weight = 1.0f;
                this.w.addView(linearLayout3, layoutParams102);
                RelativeLayout.LayoutParams layoutParams112 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
                layoutParams112.addRule(12);
                this.f23543f.addView(this.w, layoutParams112);
                View view22 = new View(this);
                view22.setId(R.id.SHIFT);
                view22.setBackgroundColor(-2894893);
                RelativeLayout.LayoutParams layoutParams122 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
                layoutParams122.addRule(2, this.w.getId());
                this.f23543f.addView(view22, layoutParams122);
                linearLayout3.setOnClickListener(new ai(this));
                linearLayout2.setOnClickListener(new ak(this));
                linearLayout.setOnClickListener(new am(this));
                this.f23546i.setOnClickListener(new an(this));
                int id3 = view.getId();
                int id22 = view22.getId();
                this.m = new RelativeLayout(this);
                if (this.o == null) {
                    this.o = new WebView(this);
                }
                this.m.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                LinearLayout linearLayout52 = new LinearLayout(this);
                this.f23544g = linearLayout52;
                linearLayout52.setOrientation(1);
                this.f23544g.setGravity(17);
                this.f23544g.setVisibility(8);
                new LinearLayout.LayoutParams(-2, -2);
                ImageView imageView42 = new ImageView(this);
                LinearLayout.LayoutParams layoutParams132 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 115.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 85.0f));
                imageView42.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_no_netwrok.png")));
                this.f23544g.addView(imageView42, layoutParams132);
                TextView textView52 = new TextView(this);
                this.q = textView52;
                textView52.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f));
                this.q.setTextSize(com.baidu.ufosdk.b.O);
                this.q.setTextColor(com.baidu.ufosdk.b.x);
                LinearLayout.LayoutParams layoutParams142 = new LinearLayout.LayoutParams(-2, -2);
                com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
                this.f23544g.addView(this.q, layoutParams142);
                Button button22 = new Button(this);
                this.j = button22;
                button22.setText(com.baidu.ufosdk.f.s.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE));
                this.j.setTextSize(com.baidu.ufosdk.b.P);
                this.j.setTextColor(com.baidu.ufosdk.b.w);
                this.j.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
                LinearLayout.LayoutParams layoutParams152 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 122.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
                layoutParams152.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0);
                this.f23544g.addView(this.j, layoutParams152);
                RelativeLayout.LayoutParams layoutParams162 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams162.addRule(13);
                this.m.addView(this.f23544g, layoutParams162);
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
                this.n = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a("13"));
                RelativeLayout.LayoutParams layoutParams182 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams182.addRule(13);
                this.m.addView(this.n, layoutParams182);
                RelativeLayout.LayoutParams layoutParams192 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams192.addRule(3, id3);
                layoutParams192.addRule(2, id22);
                this.f23543f.addView(this.m, layoutParams192);
                this.o.getSettings().setJavaScriptEnabled(true);
                this.o.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
                this.o.getClass().getMethod("removeJavascriptInterface", String.class);
                this.o.removeJavascriptInterface("searchBoxJavaBridge_");
                this.o.removeJavascriptInterface("accessibility");
                this.o.removeJavascriptInterface("accessibilityTraversal");
                b2 = com.baidu.ufosdk.b.d.b(getApplicationContext());
                r3 = RomUtils.UNKNOWN;
                if (!b2.contains(RomUtils.UNKNOWN) && !com.baidu.ufosdk.b.d.b(getApplicationContext()).contains("NONE")) {
                    this.f23538a.putBoolean("CHECK_WEBVIEW", false);
                    this.f23538a.commit();
                    this.f23544g.setVisibility(8);
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
                if (this.f23539b.getBoolean("CHECK_WEBVIEW", true)) {
                    com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
                    this.f23544g.setVisibility(0);
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
        i4 = 7;
        i3 = 7;
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
        layoutParams922.setMargins(com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a(this, i4), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
        layoutParams922.weight = 1.0f;
        this.w.addView(linearLayout2, layoutParams922);
        LinearLayout.LayoutParams layoutParams1022 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams1022.setMargins(com.baidu.ufosdk.f.i.a(this, i3), com.baidu.ufosdk.f.i.a((Context) this, 7.0f), com.baidu.ufosdk.f.i.a((Context) this, 10.0f), com.baidu.ufosdk.f.i.a((Context) this, 7.0f));
        layoutParams1022.weight = 1.0f;
        this.w.addView(linearLayout3, layoutParams1022);
        RelativeLayout.LayoutParams layoutParams1122 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
        layoutParams1122.addRule(12);
        this.f23543f.addView(this.w, layoutParams1122);
        View view222 = new View(this);
        view222.setId(R.id.SHIFT);
        view222.setBackgroundColor(-2894893);
        RelativeLayout.LayoutParams layoutParams1222 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        layoutParams1222.addRule(2, this.w.getId());
        this.f23543f.addView(view222, layoutParams1222);
        linearLayout3.setOnClickListener(new ai(this));
        linearLayout2.setOnClickListener(new ak(this));
        linearLayout.setOnClickListener(new am(this));
        this.f23546i.setOnClickListener(new an(this));
        int id32 = view.getId();
        int id222 = view222.getId();
        this.m = new RelativeLayout(this);
        if (this.o == null) {
        }
        this.m.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout522 = new LinearLayout(this);
        this.f23544g = linearLayout522;
        linearLayout522.setOrientation(1);
        this.f23544g.setGravity(17);
        this.f23544g.setVisibility(8);
        new LinearLayout.LayoutParams(-2, -2);
        ImageView imageView422 = new ImageView(this);
        LinearLayout.LayoutParams layoutParams1322 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 115.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 85.0f));
        imageView422.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_no_netwrok.png")));
        this.f23544g.addView(imageView422, layoutParams1322);
        TextView textView522 = new TextView(this);
        this.q = textView522;
        textView522.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f));
        this.q.setTextSize(com.baidu.ufosdk.b.O);
        this.q.setTextColor(com.baidu.ufosdk.b.x);
        LinearLayout.LayoutParams layoutParams1422 = new LinearLayout.LayoutParams(-2, -2);
        com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
        this.f23544g.addView(this.q, layoutParams1422);
        Button button222 = new Button(this);
        this.j = button222;
        button222.setText(com.baidu.ufosdk.f.s.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE));
        this.j.setTextSize(com.baidu.ufosdk.b.P);
        this.j.setTextColor(com.baidu.ufosdk.b.w);
        this.j.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
        LinearLayout.LayoutParams layoutParams1522 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 122.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
        layoutParams1522.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0);
        this.f23544g.addView(this.j, layoutParams1522);
        RelativeLayout.LayoutParams layoutParams1622 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams1622.addRule(13);
        this.m.addView(this.f23544g, layoutParams1622);
        this.j.setOnClickListener(new ao(this));
        LinearLayout linearLayout622 = new LinearLayout(this);
        linearLayout622.setOrientation(0);
        linearLayout622.setGravity(16);
        LinearLayout.LayoutParams layoutParams1722 = new LinearLayout.LayoutParams(-1, -1);
        if (Integer.parseInt(Build.VERSION.SDK) >= 11) {
        }
        linearLayout622.addView(this.o, layoutParams1722);
        this.m.addView(linearLayout622, new RelativeLayout.LayoutParams(-1, -1));
        this.n = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a("13"));
        RelativeLayout.LayoutParams layoutParams1822 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams1822.addRule(13);
        this.m.addView(this.n, layoutParams1822);
        RelativeLayout.LayoutParams layoutParams1922 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams1922.addRule(3, id32);
        layoutParams1922.addRule(2, id222);
        this.f23543f.addView(this.m, layoutParams1922);
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
        if (this.f23539b.getBoolean("CHECK_WEBVIEW", true)) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            com.baidu.ufosdk.f.a.f23477a = null;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                this.u = true;
                c();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onRestart();
            try {
                this.o.setVisibility(0);
            } catch (Exception unused) {
                com.baidu.ufosdk.f.c.d("onRestart--webView setVisibility error !!");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b9 A[Catch: Exception -> 0x00d5, TryCatch #0 {Exception -> 0x00d5, blocks: (B:5:0x0009, B:7:0x0012, B:8:0x0038, B:10:0x0046, B:11:0x004b, B:14:0x00a5, B:18:0x00b1, B:20:0x00b9, B:22:0x00c7, B:15:0x00a8), top: B:30:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c7 A[Catch: Exception -> 0x00d5, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d5, blocks: (B:5:0x0009, B:7:0x0012, B:8:0x0038, B:10:0x0046, B:11:0x004b, B:14:0x00a5, B:18:0x00b1, B:20:0x00b9, B:22:0x00c7, B:15:0x00a8), top: B:30:0x0009 }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048582, this) != null) {
            return;
        }
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
            this.f23546i.setText(com.baidu.ufosdk.f.s.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP));
            this.r.setText(com.baidu.ufosdk.f.s.a(RoomMasterTable.DEFAULT_ID));
            this.s.setText(com.baidu.ufosdk.f.s.a("43"));
            com.baidu.ufosdk.f.i.a(getApplicationContext(), this.q);
            this.j.setText(com.baidu.ufosdk.f.s.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE));
            com.baidu.ufosdk.f.i.a((RelativeLayout) this.n, com.baidu.ufosdk.f.s.a("13"));
            this.f23546i.setTextSize(com.baidu.ufosdk.b.U);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
            try {
                this.o.setVisibility(0);
            } catch (Exception e2) {
                e2.printStackTrace();
                com.baidu.ufosdk.f.c.d("onStart--webView setVisibility error !!");
            }
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStop();
        }
    }
}
