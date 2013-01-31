package com.baidu.tieba.pb;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.zeus.WebChromeClient;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PbActivity extends com.baidu.tieba.e {
    private static volatile long ao = 0;
    private static volatile long ap = 0;
    private static volatile int aq = 0;
    private TranslateAnimation ar;
    private TranslateAnimation as;
    private ListView d = null;
    private AlertDialog e = null;
    private TextView f = null;
    private Button g = null;
    private Button h = null;
    private Button i = null;
    private Button j = null;
    private EditText k = null;
    private Button l = null;
    private bv m = null;
    private br n = null;
    private com.baidu.tieba.b.p o = null;
    private String p = null;
    private String q = null;
    private ProgressBar r = null;
    private Handler s = new Handler();
    private AdapterView.OnItemLongClickListener t = null;
    private View.OnClickListener u = null;
    private long v = -1;
    private com.baidu.tieba.a.an w = null;
    private AlertDialog x = null;
    private AlertDialog y = null;
    private Dialog z = null;
    private View A = null;
    private LinearLayout B = null;
    private View C = null;
    private LinearLayout D = null;
    private Dialog E = null;
    private View F = null;
    private Button G = null;
    private Button H = null;
    private TextView I = null;
    private Dialog J = null;
    private View K = null;
    private int L = 0;
    private RadioGroup M = null;
    private RadioButton N = null;
    private RadioButton O = null;
    private RadioButton P = null;
    private Button Q = null;
    private Button R = null;
    private TextView S = null;
    private Dialog T = null;
    private View U = null;
    private RadioGroup V = null;
    private CompoundButton.OnCheckedChangeListener W = null;
    private Button X = null;
    private Button Y = null;
    private String Z = null;
    private bp aa = null;
    private bq ab = null;
    private bu ac = null;
    private b ad = null;
    private a ae = null;
    private String af = null;
    private int ag = -1;
    private com.baidu.tieba.a.af ah = null;
    private boolean ai = true;
    private String aj = null;
    private boolean ak = false;
    private boolean al = false;
    private long am = 0;
    private boolean an = true;
    private Animation.AnimationListener at = null;
    private boolean au = false;
    private boolean av = true;
    private int aw = 0;
    private RelativeLayout ax = null;
    private Runnable ay = new ak(this);
    DialogInterface.OnClickListener c = new ax(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.a.af afVar, boolean z) {
        if (afVar != null) {
            String w = TiebaApplication.w();
            if (w == null || w.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100009);
                return;
            }
            afVar.e(TiebaApplication.w());
            if (!z) {
                if (com.baidu.tieba.c.k.m(afVar.d())) {
                    b(getString(R.string.success));
                    this.o.a((String) null);
                    this.m.notifyDataSetChanged();
                    return;
                }
                b(getString(R.string.fail));
            } else if (com.baidu.tieba.c.k.a(afVar)) {
                b(getString(R.string.success));
                this.o.a(afVar.j());
                this.m.notifyDataSetChanged();
            } else {
                b(getString(R.string.fail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.a.an anVar) {
        String w = TiebaApplication.w();
        if (w == null || w.length() <= 0) {
            if (this.o != null && this.o.a() != null && this.o.a().e() != null) {
                this.o.a().e().a(1);
            }
            if (anVar != null) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100005);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100004);
            }
        } else if (this.p != null && this.p.length() > 0 && this.o.a() != null) {
            if (anVar != null) {
                WriteActivity.a(this, this.o.a().a().b(), this.o.a().a().c(), this.p, anVar.a(), anVar.b(), getIntent().getBooleanExtra("isAd", false), this.o.a().e());
            } else {
                WriteActivity.a(this, this.o.a().a().b(), this.o.a().a().c(), this.p, null, 0, getIntent().getBooleanExtra("isAd", false), this.o.a().e());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.a.af o() {
        com.baidu.tieba.a.af afVar = new com.baidu.tieba.a.af();
        Date date = new Date();
        afVar.e(TiebaApplication.w());
        afVar.b(this.p);
        if (this.o.a() != null) {
            afVar.c(this.o.a().b().c());
            if (this.v >= 0 && this.v < this.o.a().c().size()) {
                afVar.c(((com.baidu.tieba.a.an) this.o.a().c().get((int) this.v)).b());
                afVar.d(((com.baidu.tieba.a.an) this.o.a().c().get((int) this.v)).a());
            }
            afVar.a(this.o.a().b().h().c());
            afVar.a(this.o.a().b().d());
        }
        afVar.a(date.getTime());
        afVar.a(this.o.d());
        afVar.a(Boolean.valueOf(this.o.c()));
        if (this.o.a().f()) {
            afVar.b(1);
            afVar.f(this.o.a().a().b());
            afVar.g(this.o.a().a().c());
            afVar.h(this.o.a().b().a());
        }
        return afVar;
    }

    public String i() {
        return this.q;
    }

    public static void a(Context context, String str, String str2) {
        a(context, str, true, false, str2, false);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        a(context, str, true, false, str2, z);
    }

    public static void a(Context context, String str, boolean z, long j) {
        Intent intent = new Intent(context, PbActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra("id", str);
            intent.putExtra("sequence", true);
            intent.putExtra("hostMode", false);
            intent.putExtra("is_message_pv", z);
            intent.putExtra("message_id", j);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, Boolean bool, Boolean bool2, String str2, boolean z) {
        Intent intent = new Intent(context, PbActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra("id", str);
            intent.putExtra("sequence", bool);
            intent.putExtra("hostMode", bool2);
            intent.putExtra("isAd", z);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (str2 != null) {
                intent.putExtra("st_type", str2);
            }
            if ("tb_frslist".equals(str2)) {
                ((Activity) context).startActivityForResult(intent, 1300004);
            } else {
                context.startActivity(intent);
            }
        }
    }

    public static void a(Context context, com.baidu.tieba.a.af afVar) {
        Intent intent = new Intent(context, PbActivity.class);
        if (afVar.d() != null && afVar.j() != null) {
            intent.putExtra("mark", afVar);
            intent.putExtra("st_type", "my_mark");
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, PbActivity.class);
        if (str != null && str2 != null) {
            intent.putExtra("id", str);
            intent.putExtra("pid", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("can_skip", false);
            context.startActivity(intent);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_activity);
        this.aj = TiebaApplication.w();
        r();
        p();
        a(bundle);
    }

    private void p() {
        if (this.at == null) {
            this.at = new bh(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        int height = this.B.getHeight();
        if (this.ar == null) {
            this.ar = new TranslateAnimation(0.0f, 0.0f, 0.0f, -height);
            this.ar.setDuration(300L);
            this.ar.setFillAfter(true);
        }
        if (this.as == null) {
            this.as = new TranslateAnimation(0.0f, 0.0f, -height, 0.0f);
            this.as.setDuration(300L);
            this.as.setFillAfter(true);
        }
        this.ar.setAnimationListener(this.at);
        this.as.setAnimationListener(this.at);
    }

    public int j() {
        return this.B.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void a() {
        k();
        super.a();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return true;
        }
        if (i == 4) {
            a();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.s.removeCallbacks(this.ay);
        try {
            if (this.n != null) {
                this.n.a();
                this.n = null;
            }
            if (this.m != null) {
                this.m.a();
                this.m.b().b();
            }
            if (this.ad != null) {
                this.ad.a();
            }
            if (this.o != null && this.o.a() != null) {
                this.o.a((com.baidu.tieba.a.al) null);
            }
            if (this.aa != null) {
                this.aa.a();
                this.aa = null;
            }
            if (this.ab != null) {
                this.ab.a();
                this.ab = null;
            }
            k();
            this.r.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.af.a(getClass().getName(), "onDestroy", e.toString());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("id", this.p);
        bundle.putString("pid", this.q);
        bundle.putBoolean("sequence", this.o.c());
        bundle.putBoolean("hostMode", this.o.d());
        bundle.putString("markid", this.o.j());
        bundle.putBoolean("markMode", this.o.n());
        if (this.af != null) {
            bundle.putString("st_type", this.af);
        }
    }

    public static boolean a(com.baidu.tieba.b.p pVar) {
        com.baidu.tieba.a.av b;
        String a;
        return pVar == null || pVar.a() == null || (b = pVar.a().b()) == null || b.h() == null || (a = b.h().a()) == null || a.equals("0");
    }

    public void k() {
        if (this.e != null && this.e.isShowing()) {
            this.e.dismiss();
        }
        if (this.x != null && this.x.isShowing()) {
            this.x.dismiss();
        }
        if (this.y != null && this.y.isShowing()) {
            this.y.dismiss();
        }
        if (this.z != null && this.z.isShowing()) {
            this.z.dismiss();
        }
        if (this.E != null && this.E.isShowing()) {
            this.E.dismiss();
        }
        if (this.J != null && this.J.isShowing()) {
            this.J.dismiss();
        }
        if (this.T != null && this.T.isShowing()) {
            this.T.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        if (this.m != null && this.m.j() != TiebaApplication.b().ad()) {
            this.m.c(TiebaApplication.b().ad());
            this.m.notifyDataSetChanged();
        }
        if (this.m != null && this.m.i() != TiebaApplication.b().ac()) {
            this.m.c(TiebaApplication.b().ac());
            this.m.notifyDataSetChanged();
        }
        com.baidu.tieba.a.af l = com.baidu.tieba.c.k.l(this.p);
        if (this.o != null) {
            if (l != null) {
                this.o.a(l.j());
            } else {
                this.o.a((String) null);
            }
            String w = TiebaApplication.w();
            if (this.aj == null && w != null && w.length() > 0) {
                this.aj = w;
                if (this.o.a() != null && this.o.a().e() != null) {
                    this.o.a().e().a(1);
                }
            }
        }
        if (this.m != null) {
            this.m.notifyDataSetChanged();
        }
        this.ay.run();
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.m.b().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ad.a(this.ax, i);
        com.baidu.tieba.c.ad.c(this.B, i);
        com.baidu.tieba.c.ad.c(this.f, i);
        com.baidu.tieba.c.ad.e((TextView) this.i, i);
        com.baidu.tieba.c.ad.h(this.l, i);
        com.baidu.tieba.c.ad.b(this.d, i);
        this.m.notifyDataSetChanged();
        if (i == 1) {
            this.f.setBackgroundResource(R.drawable.pb_title_button_1);
            a(this.g, R.drawable.pb_bottom_btn_reply_1);
            a(this.j, R.drawable.pb_bottom_btn_more_1);
            this.g.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.j.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            if (this.o.d()) {
                a(this.h, R.drawable.pb_bottom_btn_viewall_1);
            } else {
                a(this.h, R.drawable.pb_bottom_btn_viewhost_1);
            }
            this.h.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.D.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            return;
        }
        this.f.setBackgroundResource(R.drawable.pb_title_button);
        a(this.g, R.drawable.pb_bottom_btn_reply);
        a(this.j, R.drawable.pb_bottom_btn_more);
        this.g.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.j.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        if (this.o.d()) {
            a(this.h, R.drawable.pb_bottom_btn_viewall);
        } else {
            a(this.h, R.drawable.pb_bottom_btn_viewhost);
        }
        this.h.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.D.setBackgroundResource(R.drawable.maintab_toolbar_bg);
    }

    private void a(Button button, int i) {
        button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(i), (Drawable) null, (Drawable) null);
    }

    private void r() {
        this.ax = (RelativeLayout) findViewById(R.id.parent);
        this.t = new bi(this);
        this.u = new bj(this);
        this.f = (TextView) findViewById(R.id.title_text);
        this.B = (LinearLayout) findViewById(R.id.title);
        this.D = (LinearLayout) findViewById(R.id.bottom_bar);
        this.f.setClickable(true);
        this.f.setOnClickListener(new bk(this));
        this.j = (Button) findViewById(R.id.more);
        this.j.setOnClickListener(new bl(this));
        this.i = (Button) findViewById(R.id.back);
        this.i.setOnClickListener(new bn(this));
        this.h = (Button) findViewById(R.id.view_host);
        this.h.setOnClickListener(new bo(this));
        this.g = (Button) findViewById(R.id.reply);
        this.g.setOnClickListener(new an(this));
        this.l = (Button) findViewById(R.id.recommend);
        this.l.setOnClickListener(new ao(this));
        this.d = (ListView) findViewById(R.id.pb_list);
        this.d.setFastScrollEnabled(true);
        this.m = new bv(this, null, com.baidu.tieba.c.ah.a(this, 234.0f), this.u);
        this.m.c(TiebaApplication.b().ad());
        this.m.c(TiebaApplication.b().ac());
        this.m.b(0);
        this.m.a(0);
        this.d.setAdapter((ListAdapter) this.m);
        this.d.setOnItemClickListener(new ap(this));
        this.d.setOnScrollListener(new aq(this));
        this.d.setOnItemLongClickListener(this.t);
        this.d.setOnTouchListener(new as(this, new GestureDetector(this, new ar(this))));
        this.r = (ProgressBar) findViewById(R.id.progress);
        this.r.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.z == null) {
            this.z = new Dialog(this, R.style.common_alert_dialog);
            this.z.setCanceledOnTouchOutside(true);
            this.z.setCancelable(true);
            this.C = getLayoutInflater().inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            this.z.setContentView(this.C);
            WindowManager.LayoutParams attributes = this.z.getWindow().getAttributes();
            attributes.gravity = 49;
            attributes.y = com.baidu.tieba.c.ah.a(this, 54.0f);
            attributes.width = (int) (com.baidu.tieba.c.ah.a((Context) this) * 0.9d);
            this.z.getWindow().setAttributes(attributes);
            this.z.setOnKeyListener(new at(this));
            this.k = (EditText) this.C.findViewById(R.id.input_page_number);
            this.k.setOnFocusChangeListener(new au(this));
            ((Button) this.C.findViewById(R.id.dialog_button_ok)).setOnClickListener(new av(this));
            ((Button) this.C.findViewById(R.id.dialog_button_cancel)).setOnClickListener(new aw(this));
        }
        if (this.o.a() != null) {
            TextView textView = (TextView) this.C.findViewById(R.id.current_page_number);
            int b = this.o.a().d().b();
            int a = this.o.a().d().a();
            if (b <= 0) {
                b = 1;
            }
            if (a <= 0) {
                a = 1;
            }
            textView.setText(MessageFormat.format(getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(b), Integer.valueOf(a)));
            this.z.show();
            this.k.setText("");
            this.k.requestFocus();
            a(this.k, WebChromeClient.STRING_DLG_BTN_SET);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AlertDialog t() {
        String str;
        if (e() != null && e().isShowing()) {
            return e();
        }
        ay ayVar = new ay(this);
        com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) this.m.getItem(this.ag);
        if (anVar == null || this.o == null || anVar.a() == null) {
            str = null;
        } else if (anVar.a().equals(this.o.j())) {
            str = getString(R.string.delete_mark);
        } else {
            str = getString(R.string.add_mark);
        }
        return str != null ? a(new String[]{getString(R.string.copy), str}, ayVar) : a(new String[]{getString(R.string.copy)}, ayVar);
    }

    private void d(int i) {
        ArrayList c;
        if (this.o != null && this.o.a() != null && (c = this.o.a().c()) != null && c.size() > 0) {
            if (i == 0) {
                e(2);
            } else {
                e(1);
            }
            if (this.n != null) {
                if (i == 0) {
                    this.m.b(true);
                } else {
                    this.m.a(true);
                }
                this.m.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        d(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        d(0);
    }

    private void a(Bundle bundle) {
        Boolean valueOf;
        Boolean valueOf2;
        this.ae = new a(this, new String[]{getString(R.string.reply), getString(R.string.mark), getString(R.string.view_info)});
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setAdapter(this.ae, this.c);
        if (this.e == null) {
            this.e = builder.create();
            this.e.setCanceledOnTouchOutside(true);
        }
        this.o = new com.baidu.tieba.b.p();
        Boolean.valueOf(true);
        Boolean.valueOf(false);
        String str = null;
        this.al = getIntent().getBooleanExtra("is_message_pv", false);
        this.am = getIntent().getLongExtra("message_id", 0L);
        if (bundle != null) {
            this.p = bundle.getString("id");
            this.q = bundle.getString("pid");
            Boolean valueOf3 = Boolean.valueOf(bundle.getBoolean("sequence", true));
            Boolean valueOf4 = Boolean.valueOf(bundle.getBoolean("hostMode", false));
            String string = bundle.getString("markid");
            this.o.i(bundle.getBoolean("markMode", false));
            this.af = bundle.getString("st_type");
            valueOf = valueOf3;
            valueOf2 = valueOf4;
            str = string;
        } else {
            Intent intent = getIntent();
            this.af = intent.getStringExtra("st_type");
            com.baidu.tieba.a.af afVar = (com.baidu.tieba.a.af) intent.getSerializableExtra("mark");
            if (afVar != null) {
                this.p = afVar.d();
                Boolean h = afVar.h();
                Boolean valueOf5 = Boolean.valueOf(afVar.i());
                String j = afVar.j();
                this.o.i(true);
                valueOf = h;
                valueOf2 = valueOf5;
                str = j;
            } else {
                this.p = intent.getStringExtra("id");
                this.q = intent.getStringExtra("pid");
                valueOf = Boolean.valueOf(intent.getBooleanExtra("sequence", true));
                valueOf2 = Boolean.valueOf(intent.getBooleanExtra("hostMode", false));
                com.baidu.tieba.a.af l = com.baidu.tieba.c.k.l(this.p);
                a(intent.getBooleanExtra("can_skip", true));
                if (l != null) {
                    str = l.j();
                }
            }
        }
        TiebaApplication tiebaApplication = (TiebaApplication) getApplication();
        if (tiebaApplication != null) {
            this.o.a(tiebaApplication.s());
            this.o.g(tiebaApplication.t());
        }
        if (valueOf2.booleanValue()) {
            valueOf = true;
        }
        this.o.b(valueOf.booleanValue());
        this.o.c(valueOf2.booleanValue());
        if (valueOf2.booleanValue()) {
            this.h.setText(R.string.view_all);
        } else {
            this.h.setText(R.string.view_host);
        }
        this.o.a(str);
        if (this.o.n()) {
            a(false);
            e(4);
        } else if (this.q != null) {
            a(false);
            e(6);
        } else {
            e(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.an = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        BasicNameValuePair basicNameValuePair;
        if (this.n != null) {
            this.n.a();
            this.n = null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append("http://c.tieba.baidu.com/");
            stringBuffer.append("c/f/pb/page");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kz", this.p));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(30)));
            if (!this.o.c()) {
                arrayList.add(new BasicNameValuePair("r", String.valueOf(1)));
            }
            if (this.o.d()) {
                arrayList.add(new BasicNameValuePair("lz", String.valueOf(1)));
            }
            if (this.p != null && this.p.length() > 0) {
                if (i == 5) {
                    int parseInt = Integer.parseInt(this.k.getText().toString(), 10);
                    int a = this.o.a().d().a();
                    int i2 = parseInt >= 1 ? parseInt : 1;
                    if (i2 <= a) {
                        a = i2;
                    }
                    arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(a)).toString()));
                    arrayList.add(new BasicNameValuePair("back", "0"));
                    this.r.setVisibility(0);
                } else if (i == 2) {
                    arrayList.add(new BasicNameValuePair("back", "1"));
                    if (!this.o.n() && this.q == null) {
                        if (this.o.c()) {
                            arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.o.l() + (-1) < 0 ? 1 : this.o.l() - 1)).toString()));
                        } else if (this.o.k() < this.o.a().d().a()) {
                            arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.o.k() + 1)).toString()));
                            this.o.h(false);
                        } else {
                            this.o.h(true);
                        }
                    }
                    ArrayList c = this.o.a().c();
                    if (c != null && c.size() > 0) {
                        int size = c.size();
                        String a2 = ((com.baidu.tieba.a.an) c.get(0)).a();
                        if (a2 != null && a2.length() > 0) {
                            arrayList.add(new BasicNameValuePair("pid", a2));
                        }
                        if (size > com.baidu.tieba.a.i.b() - 30) {
                            for (int i3 = 1; i3 <= size - (com.baidu.tieba.a.i.b() - 30) && size - i3 >= 0; i3++) {
                                c.remove(size - i3);
                            }
                            this.m.b(2);
                            this.m.notifyDataSetChanged();
                        }
                    }
                } else if (i == 1) {
                    arrayList.add(new BasicNameValuePair("back", String.valueOf(0)));
                    ArrayList c2 = this.o.a().c();
                    if (c2 != null && c2.size() > 0) {
                        int size2 = c2.size();
                        String a3 = ((com.baidu.tieba.a.an) c2.get(size2 - 1)).a();
                        if (a3 != null && a3.length() > 0) {
                            arrayList.add(new BasicNameValuePair("pid", a3));
                        }
                        if (size2 > com.baidu.tieba.a.i.b() - 30) {
                            for (int b = com.baidu.tieba.a.i.b() - 30; b < size2; b++) {
                                c2.remove(0);
                            }
                            this.m.a(2);
                            this.m.notifyDataSetChanged();
                        }
                    } else if (!this.o.c()) {
                        arrayList.add(new BasicNameValuePair("last", String.valueOf(1)));
                    }
                    if (!this.o.n() && this.q == null) {
                        if (this.o.c()) {
                            if (this.o.k() < this.o.a().d().a()) {
                                arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.o.k() + 1)).toString()));
                                this.o.h(false);
                            } else {
                                this.o.h(true);
                            }
                        } else {
                            arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.o.l() - 1)).toString()));
                        }
                    }
                } else if (i == 4) {
                    arrayList.add(new BasicNameValuePair("pid", this.o.j()));
                    arrayList.add(new BasicNameValuePair("back", "0"));
                    arrayList.add(new BasicNameValuePair("st_type", "tb_bookmarklist"));
                    this.m.b(0);
                    this.m.a(0);
                    this.r.setVisibility(0);
                } else if (i == 6) {
                    arrayList.add(new BasicNameValuePair("pid", this.q));
                    arrayList.add(new BasicNameValuePair("back", "0"));
                    this.m.b(0);
                    this.m.a(0);
                    this.r.setVisibility(0);
                    if (this.af != null) {
                        arrayList.add(new BasicNameValuePair("st_type", this.af));
                    }
                } else if (i == 3) {
                    arrayList.add(new BasicNameValuePair("back", "0"));
                    if (this.o.c()) {
                        arrayList.add(new BasicNameValuePair("pn", "1"));
                    } else if ((getIntent().getStringExtra("st_type") == null || !getIntent().getStringExtra("st_type").equals("tb_frslist") || getIntent().getBooleanExtra("sequence", true)) && this.o != null && this.o.a() != null && this.o.a().d() != null) {
                        arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.o.a().d().a())).toString()));
                    }
                    if (this.o != null) {
                        this.o.i(false);
                        if (!this.o.c()) {
                            arrayList.add(new BasicNameValuePair("last", String.valueOf(1)));
                        }
                        if (this.o.a() != null) {
                            this.o.a().c().clear();
                            this.m.notifyDataSetChanged();
                        }
                    }
                    this.m.b(0);
                    this.m.a(0);
                    if (this.af != null) {
                        arrayList.add(new BasicNameValuePair("st_type", this.af));
                    }
                    this.r.setVisibility(0);
                    System.gc();
                }
                if (i == 4 || i == 6) {
                    basicNameValuePair = new BasicNameValuePair("mark", "1");
                } else {
                    basicNameValuePair = new BasicNameValuePair("mark", "0");
                }
                arrayList.add(basicNameValuePair);
                this.n = new br(this, stringBuffer.toString(), arrayList, i);
                this.n.execute(stringBuffer.toString(), arrayList);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b("PbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.o.c(true);
        if (TiebaApplication.b().af() == 1) {
            a(this.h, R.drawable.pb_bottom_btn_viewall_1);
        } else {
            a(this.h, R.drawable.pb_bottom_btn_viewall);
        }
        this.h.setText(R.string.view_all);
        this.o.b(true);
        e(3);
        this.m.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.o.c(false);
        if (TiebaApplication.b().af() == 1) {
            a(this.h, R.drawable.pb_bottom_btn_viewhost_1);
        } else {
            a(this.h, R.drawable.pb_bottom_btn_viewhost);
        }
        this.h.setText(R.string.view_host);
        e(3);
        this.m.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.o.b(false);
        this.o.c(false);
        if (TiebaApplication.b().af() == 1) {
            a(this.h, R.drawable.pb_bottom_btn_viewhost_1);
        } else {
            a(this.h, R.drawable.pb_bottom_btn_viewhost);
        }
        this.h.setText(R.string.view_host);
        e(3);
        this.m.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.o.b(true);
        e(3);
        this.m.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.o.g(true);
        TiebaApplication.b().b((Boolean) true);
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.o.g(false);
        TiebaApplication.b().b((Boolean) false);
        C();
    }

    public void a(int i, String str, int i2) {
        if (this.E == null) {
            this.E = new Dialog(this, R.style.common_alert_dialog);
            this.E.setCanceledOnTouchOutside(true);
            this.E.setCancelable(true);
            this.F = getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.E.setContentView(this.F);
            WindowManager.LayoutParams attributes = this.E.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ah.a((Context) this) * 0.9d);
            this.E.getWindow().setAttributes(attributes);
            this.G = (Button) this.F.findViewById(R.id.dialog_button_ok);
            this.H = (Button) this.F.findViewById(R.id.dialog_button_cancel);
            this.H.setOnClickListener(new az(this));
            this.I = (TextView) this.F.findViewById(R.id.confirm_text);
        }
        if (this.o != null && this.o.a() != null) {
            this.G.setOnClickListener(new ba(this, i, str, i2));
            if (i == 1) {
                this.I.setText(R.string.del_thread_confirm);
            } else {
                this.I.setText(R.string.del_post_confirm);
            }
            this.E.show();
        }
    }

    public void a(String str, int i) {
        if (this.J == null) {
            this.J = new Dialog(this, R.style.common_alert_dialog);
            this.J.setCanceledOnTouchOutside(true);
            this.J.setCancelable(true);
            this.K = getLayoutInflater().inflate(R.layout.forbid_user, (ViewGroup) null);
            this.J.setContentView(this.K);
            WindowManager.LayoutParams attributes = this.J.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ah.a((Context) this) * 0.9d);
            this.J.getWindow().setAttributes(attributes);
            this.M = (RadioGroup) this.K.findViewById(R.id.radio_group);
            this.N = (RadioButton) this.K.findViewById(R.id.radio_button_1day);
            this.O = (RadioButton) this.K.findViewById(R.id.radio_button_3day);
            this.P = (RadioButton) this.K.findViewById(R.id.radio_button_10day);
            bb bbVar = new bb(this);
            this.N.setOnCheckedChangeListener(bbVar);
            this.O.setOnCheckedChangeListener(bbVar);
            this.P.setOnCheckedChangeListener(bbVar);
            this.Q = (Button) this.K.findViewById(R.id.dialog_button_ok);
            this.R = (Button) this.K.findViewById(R.id.dialog_button_cancel);
            this.R.setOnClickListener(new bc(this));
            this.S = (TextView) this.K.findViewById(R.id.user_name);
        }
        if (this.o != null && this.o.a() != null) {
            this.S.setText(str);
            this.M.check(R.id.radio_button_1day);
            if (i == 2) {
                this.O.setVisibility(8);
                this.P.setVisibility(8);
            }
            this.Q.setOnClickListener(new bd(this, str));
            this.J.show();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1100004:
                    a((com.baidu.tieba.a.an) null);
                    return;
                case 1100005:
                    a(this.w);
                    return;
                case 1100006:
                    w();
                    return;
                case 1100007:
                    y();
                    return;
                case 1100009:
                    a(this.ah, this.ai);
                    return;
                case 1300001:
                case 1300002:
                    try {
                        String w = TiebaApplication.w();
                        String a = this.o.a().b().h().a();
                        if (!this.o.d() || w.equals(a)) {
                            if (this.o.c() && this.m.f() == 1) {
                                u();
                            } else if (!this.o.c() && this.m.d() == 1) {
                                v();
                            }
                        }
                        return;
                    } catch (Exception e) {
                        com.baidu.tieba.c.af.b(getClass().getName(), "onActivityResult", e.getMessage());
                        return;
                    }
                case 1300004:
                    String stringExtra = intent.getStringExtra("del_post_id");
                    if (stringExtra != null && this.o != null && this.o.a() != null) {
                        ArrayList c = this.o.a().c();
                        int size = c.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                if (!stringExtra.equals(((com.baidu.tieba.a.an) c.get(i3)).a())) {
                                    i3++;
                                } else {
                                    c.remove(i3);
                                }
                            }
                        }
                        C();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2) {
        String str2;
        String w = TiebaApplication.w();
        if (w == null || w.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100017);
        } else if (!this.o.f()) {
            this.o.d(true);
            if (this.aa != null) {
                this.aa.a();
                this.aa = null;
            }
            com.baidu.tieba.a.q a = this.o.a().a();
            this.aa = new bp(this, a.b(), a.c(), this.o.a().b().a(), str, i, i2);
            if (i == 1) {
                str2 = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/delthread";
            } else {
                str2 = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/delpost";
            }
            this.aa.execute(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String w = TiebaApplication.w();
        if (w == null || w.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100018);
        } else if (!this.o.g()) {
            this.o.e(true);
            if (this.ab != null) {
                this.ab.a();
                this.ab = null;
            }
            com.baidu.tieba.a.q a = this.o.a().a();
            this.ab = new bq(this, a.b(), a.c(), this.o.a().b().a(), str, String.valueOf(this.L));
            this.ab.execute("http://c.tieba.baidu.com/c/c/bawu/commitprison");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        try {
            if (this.o != null && this.o.a() != null) {
                if (this.o.a().c() != null) {
                    this.m.a(this.o);
                    this.m.notifyDataSetChanged();
                }
                com.baidu.tieba.a.q a = this.o.a().a();
                if (a != null && a.c() != null) {
                    this.f.setText(String.valueOf(a.c()) + getString(R.string.forum));
                }
                if (a(this.o)) {
                    this.h.setEnabled(false);
                }
            }
            if (this.ak) {
                this.d.setSelection(this.d.getCount());
            }
            this.ak = false;
        } catch (Exception e) {
            com.baidu.tieba.c.af.b("PbActivity", "refreshActivity", "error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        String str;
        String w = TiebaApplication.w();
        if (w == null || w.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100022);
        } else if (!this.o.h()) {
            this.o.f(true);
            if (this.ac != null) {
                this.ac.a();
                this.ac = null;
            }
            com.baidu.tieba.a.q a = this.o.a().a();
            this.ac = new bu(this, a.b(), a.c(), this.o.a().b().a(), i);
            if (i == 5) {
                str = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/goodlist";
            } else if (i == 1 || i == 2) {
                str = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/commitgood";
            } else {
                str = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/committop";
            }
            this.ac.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("cates");
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.baidu.tieba.a.t tVar = new com.baidu.tieba.a.t();
                tVar.a(optJSONArray.optJSONObject(i));
                arrayList.add(tVar);
            }
            if (this.T == null) {
                this.T = new Dialog(this, R.style.common_alert_dialog);
                this.T.setCanceledOnTouchOutside(true);
                this.T.setCancelable(true);
                this.U = getLayoutInflater().inflate(R.layout.commit_good, (ViewGroup) null);
                this.T.setContentView(this.U);
                WindowManager.LayoutParams attributes = this.T.getWindow().getAttributes();
                attributes.width = (int) (com.baidu.tieba.c.ah.a((Context) this) * 0.9d);
                this.T.getWindow().setAttributes(attributes);
                this.W = new be(this);
                this.V = (RadioGroup) this.U.findViewById(R.id.good_class_group);
                this.Y = (Button) this.U.findViewById(R.id.dialog_button_cancel);
                this.Y.setOnClickListener(new bf(this));
                this.X = (Button) this.U.findViewById(R.id.dialog_button_ok);
                this.X.setOnClickListener(new bg(this));
            }
            if (this.o != null && this.o.a() != null) {
                this.V.removeAllViews();
                LayoutInflater layoutInflater = getLayoutInflater();
                RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                radioButton.setTag("0");
                radioButton.setText(getResources().getString(R.string.def_good_class));
                radioButton.setOnCheckedChangeListener(this.W);
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
                layoutParams.setMargins(com.baidu.tieba.c.ah.a(this, 10.0f), com.baidu.tieba.c.ah.a(this, 5.0f), com.baidu.tieba.c.ah.a(this, 10.0f), com.baidu.tieba.c.ah.a(this, 5.0f));
                this.V.addView(radioButton, layoutParams);
                this.V.requestLayout();
                this.V.check(radioButton.getId());
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                    radioButton2.setTag(String.valueOf(((com.baidu.tieba.a.t) arrayList.get(i2)).b()));
                    radioButton2.setText(((com.baidu.tieba.a.t) arrayList.get(i2)).a());
                    radioButton2.setOnCheckedChangeListener(this.W);
                    this.V.addView(radioButton2, layoutParams);
                    this.V.requestLayout();
                }
                this.T.show();
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "openCommitGoodDialog", e.getMessage());
        }
    }
}
