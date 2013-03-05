package com.baidu.tieba.pb;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import com.baidu.mobstat.StatService;
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
    private static volatile long ap = 0;
    private static volatile long aq = 0;
    private static volatile int ar = 0;
    private TranslateAnimation as;
    private TranslateAnimation at;
    private ListView d = null;
    private AlertDialog e = null;
    private TextView f = null;
    private Button g = null;
    private Button h = null;
    private Button i = null;
    private Button j = null;
    private Button k = null;
    private EditText l = null;
    private Button m = null;
    private ca n = null;
    private bw o = null;
    private com.baidu.tieba.b.q p = null;
    private String q = null;
    private String r = null;
    private ProgressBar s = null;
    private Handler t = new Handler();
    private AdapterView.OnItemLongClickListener u = null;
    private View.OnClickListener v = null;
    private long w = -1;
    private com.baidu.tieba.a.al x = null;
    private AlertDialog y = null;
    private AlertDialog z = null;
    private Dialog A = null;
    private View B = null;
    private LinearLayout C = null;
    private View D = null;
    private LinearLayout E = null;
    private Dialog F = null;
    private View G = null;
    private Button H = null;
    private Button I = null;
    private TextView J = null;
    private Dialog K = null;
    private View L = null;
    private int M = 0;
    private RadioGroup N = null;
    private RadioButton O = null;
    private RadioButton P = null;
    private RadioButton Q = null;
    private Button R = null;
    private Button S = null;
    private TextView T = null;
    private Dialog U = null;
    private View V = null;
    private RadioGroup W = null;
    private CompoundButton.OnCheckedChangeListener X = null;
    private Button Y = null;
    private Button Z = null;
    private String aa = null;
    private bu ab = null;
    private bv ac = null;
    private bz ad = null;
    private b ae = null;
    private a af = null;
    private String ag = null;
    private int ah = -1;
    private com.baidu.tieba.a.ac ai = null;
    private boolean aj = true;
    private String ak = null;
    private boolean al = false;
    private boolean am = false;
    private long an = 0;
    private boolean ao = true;
    private Animation.AnimationListener au = null;
    private boolean av = false;
    private boolean aw = true;
    private int ax = 0;
    private RelativeLayout ay = null;
    private Runnable az = new ao(this);
    DialogInterface.OnClickListener c = new bb(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.a.ac acVar, boolean z) {
        if (acVar != null) {
            String x = TiebaApplication.x();
            if (x == null || x.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100009);
                return;
            }
            acVar.e(TiebaApplication.x());
            if (!z) {
                if (com.baidu.tieba.c.k.m(acVar.d())) {
                    b(getString(R.string.success));
                    this.p.a((String) null);
                    this.n.notifyDataSetChanged();
                    return;
                }
                b(getString(R.string.fail));
            } else if (com.baidu.tieba.c.k.a(acVar)) {
                b(getString(R.string.success));
                this.p.a(acVar.j());
                this.n.notifyDataSetChanged();
            } else {
                b(getString(R.string.fail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.a.al alVar) {
        String x = TiebaApplication.x();
        if (x == null || x.length() <= 0) {
            if (this.p != null && this.p.a() != null && this.p.a().f() != null) {
                this.p.a().f().a(1);
            }
            if (alVar != null) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100005);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100004);
            }
        } else if (this.q != null && this.q.length() > 0 && this.p.a() != null) {
            if (alVar != null) {
                WriteActivity.a(this, this.p.a().a().b(), this.p.a().a().c(), this.q, alVar.a(), alVar.c(), getIntent().getBooleanExtra("isAd", false), this.p.a().f());
            } else {
                WriteActivity.a(this, this.p.a().a().b(), this.p.a().a().c(), this.q, null, 0, getIntent().getBooleanExtra("isAd", false), this.p.a().f());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.a.ac o() {
        com.baidu.tieba.a.ac acVar = new com.baidu.tieba.a.ac();
        Date date = new Date();
        acVar.e(TiebaApplication.x());
        acVar.b(this.q);
        if (this.p.a() != null) {
            acVar.c(this.p.a().b().c());
            if (this.w >= 0 && this.w < this.p.a().d().size()) {
                acVar.c(((com.baidu.tieba.a.al) this.p.a().d().get((int) this.w)).c());
                acVar.d(((com.baidu.tieba.a.al) this.p.a().d().get((int) this.w)).a());
            }
            acVar.a(this.p.a().b().h().c());
            acVar.a(this.p.a().b().d());
        }
        acVar.a(date.getTime());
        acVar.a(this.p.d());
        acVar.a(Boolean.valueOf(this.p.c()));
        if (this.p.a().i()) {
            acVar.b(1);
            acVar.f(this.p.a().a().b());
            acVar.g(this.p.a().a().c());
            acVar.h(this.p.a().b().a());
        }
        return acVar;
    }

    public String i() {
        return this.r;
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

    public static void a(Context context, com.baidu.tieba.a.ac acVar) {
        Intent intent = new Intent(context, PbActivity.class);
        if (acVar.d() != null && acVar.j() != null) {
            intent.putExtra("mark", acVar);
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
        this.ak = TiebaApplication.x();
        r();
        p();
        a(bundle);
    }

    private void p() {
        if (this.au == null) {
            this.au = new bm(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        int height = this.C.getHeight();
        if (this.as == null) {
            this.as = new TranslateAnimation(0.0f, 0.0f, 0.0f, -height);
            this.as.setDuration(300L);
            this.as.setFillAfter(true);
        }
        if (this.at == null) {
            this.at = new TranslateAnimation(0.0f, 0.0f, -height, 0.0f);
            this.at.setDuration(300L);
            this.at.setFillAfter(true);
        }
        this.as.setAnimationListener(this.au);
        this.at.setAnimationListener(this.au);
    }

    public int j() {
        return this.C.getHeight();
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
        this.t.removeCallbacks(this.az);
        try {
            if (this.o != null) {
                this.o.a();
                this.o = null;
            }
            if (this.n != null) {
                this.n.a();
                this.n.b().b();
            }
            if (this.ae != null) {
                this.ae.a();
            }
            if (this.p != null && this.p.a() != null) {
                this.p.a((com.baidu.tieba.a.ai) null);
            }
            if (this.ab != null) {
                this.ab.a();
                this.ab = null;
            }
            if (this.ac != null) {
                this.ac.a();
                this.ac = null;
            }
            k();
            this.s.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.a(getClass().getName(), "onDestroy", e.toString());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("id", this.q);
        bundle.putString("pid", this.r);
        bundle.putBoolean("sequence", this.p.c());
        bundle.putBoolean("hostMode", this.p.d());
        bundle.putString("markid", this.p.j());
        bundle.putBoolean("markMode", this.p.n());
        if (this.ag != null) {
            bundle.putString("st_type", this.ag);
        }
    }

    public static boolean a(com.baidu.tieba.b.q qVar) {
        com.baidu.tieba.a.at b;
        String a;
        return qVar == null || qVar.a() == null || (b = qVar.a().b()) == null || b.h() == null || (a = b.h().a()) == null || a.equals("0");
    }

    public void k() {
        if (this.e != null && this.e.isShowing()) {
            this.e.dismiss();
        }
        if (this.y != null && this.y.isShowing()) {
            this.y.dismiss();
        }
        if (this.z != null && this.z.isShowing()) {
            this.z.dismiss();
        }
        if (this.A != null && this.A.isShowing()) {
            this.A.dismiss();
        }
        if (this.F != null && this.F.isShowing()) {
            this.F.dismiss();
        }
        if (this.K != null && this.K.isShowing()) {
            this.K.dismiss();
        }
        if (this.U != null && this.U.isShowing()) {
            this.U.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        if (this.n != null && this.n.j() != TiebaApplication.b().ae()) {
            this.n.c(TiebaApplication.b().ae());
            this.n.notifyDataSetChanged();
        }
        if (this.n != null && this.n.i() != TiebaApplication.b().ad()) {
            this.n.c(TiebaApplication.b().ad());
            this.n.notifyDataSetChanged();
        }
        com.baidu.tieba.a.ac l = com.baidu.tieba.c.k.l(this.q);
        if (this.p != null) {
            if (l != null) {
                this.p.a(l.j());
            } else {
                this.p.a((String) null);
            }
            String x = TiebaApplication.x();
            if (this.ak == null && x != null && x.length() > 0) {
                this.ak = x;
                if (this.p.a() != null && this.p.a().f() != null) {
                    this.p.a().f().a(1);
                }
            }
        }
        if (this.n != null) {
            this.n.notifyDataSetChanged();
        }
        this.az.run();
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.n.b().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.a(this.ay, i);
        com.baidu.tieba.c.ae.c(this.C, i);
        com.baidu.tieba.c.ae.c(this.f, i);
        com.baidu.tieba.c.ae.e((TextView) this.j, i);
        com.baidu.tieba.c.ae.h(this.m, i);
        com.baidu.tieba.c.ae.b(this.d, i);
        this.n.notifyDataSetChanged();
        if (i == 1) {
            this.f.setBackgroundResource(R.drawable.pb_title_button_1);
            a(this.g, R.drawable.pb_bottom_btn_reply_1);
            a(this.h, R.drawable.pb_bottom_btn_share_1);
            a(this.k, R.drawable.pb_bottom_btn_more_1);
            this.g.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.h.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.k.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            if (this.p.d()) {
                a(this.i, R.drawable.pb_bottom_btn_viewall_1);
            } else {
                a(this.i, R.drawable.pb_bottom_btn_viewhost_1);
            }
            this.i.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.E.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            return;
        }
        this.f.setBackgroundResource(R.drawable.pb_title_button);
        a(this.g, R.drawable.pb_bottom_btn_reply);
        a(this.h, R.drawable.pb_bottom_btn_share);
        a(this.k, R.drawable.pb_bottom_btn_more);
        this.g.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.h.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.k.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        if (this.p.d()) {
            a(this.i, R.drawable.pb_bottom_btn_viewall);
        } else {
            a(this.i, R.drawable.pb_bottom_btn_viewhost);
        }
        this.i.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.E.setBackgroundResource(R.drawable.maintab_toolbar_bg);
    }

    private void a(Button button, int i) {
        button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(i), (Drawable) null, (Drawable) null);
    }

    private void r() {
        this.ay = (RelativeLayout) findViewById(R.id.parent);
        this.u = new bn(this);
        this.v = new bo(this);
        this.f = (TextView) findViewById(R.id.title_text);
        this.C = (LinearLayout) findViewById(R.id.title);
        this.E = (LinearLayout) findViewById(R.id.bottom_bar);
        this.f.setClickable(true);
        this.f.setOnClickListener(new bp(this));
        this.k = (Button) findViewById(R.id.more);
        this.k.setOnClickListener(new bq(this));
        this.j = (Button) findViewById(R.id.back);
        this.j.setOnClickListener(new bs(this));
        this.i = (Button) findViewById(R.id.view_host);
        this.i.setOnClickListener(new bt(this));
        this.g = (Button) findViewById(R.id.reply);
        this.g.setOnClickListener(new ar(this));
        this.h = (Button) findViewById(R.id.share);
        this.h.setOnClickListener(new as(this));
        this.m = (Button) findViewById(R.id.recommend);
        this.m.setOnClickListener(new at(this));
        this.d = (ListView) findViewById(R.id.pb_list);
        this.d.setFastScrollEnabled(true);
        this.n = new ca(this, null, com.baidu.tieba.c.ai.a(this, 234.0f), this.v);
        this.n.c(TiebaApplication.b().ae());
        this.n.c(TiebaApplication.b().ad());
        this.n.b(0);
        this.n.a(0);
        this.d.setAdapter((ListAdapter) this.n);
        this.d.setOnItemClickListener(new au(this));
        this.d.setOnScrollListener(new av(this));
        this.d.setOnItemLongClickListener(this.u);
        this.d.setOnTouchListener(new ax(this, new GestureDetector(this, new aw(this))));
        this.s = (ProgressBar) findViewById(R.id.progress);
        this.s.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.p != null && this.p.a() != null) {
            if (TiebaApplication.b().k()) {
                StatService.onEvent(this, "pb_share", "pbclick", 1);
            }
            try {
                Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
                intent.addCategory("android.intent.category.DEFAULT");
                String a = this.p.a().b().a();
                String c = this.p.a().a().c();
                String c2 = this.p.a().b().c();
                if (c2.length() > 140) {
                    c2 = c2.substring(0, 140);
                }
                new com.baidu.tieba.account.ak("client_share", a).start();
                intent.putExtra("android.intent.extra.TEXT", MessageFormat.format(getApplicationContext().getResources().getString(R.string.share_format), c2, c, "http://tieba.baidu.com/p/" + a + "?share=9105"));
                intent.setFlags(268435456);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, getApplicationContext().getResources().getString(R.string.share_to)));
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b("PbActivity", "share", "error" + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.A == null) {
            this.A = new Dialog(this, R.style.common_alert_dialog);
            this.A.setCanceledOnTouchOutside(true);
            this.A.setCancelable(true);
            this.D = getLayoutInflater().inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            this.A.setContentView(this.D);
            WindowManager.LayoutParams attributes = this.A.getWindow().getAttributes();
            attributes.gravity = 49;
            attributes.y = com.baidu.tieba.c.ai.a(this, 54.0f);
            attributes.width = (int) (com.baidu.tieba.c.ai.a((Context) this) * 0.9d);
            this.A.getWindow().setAttributes(attributes);
            this.A.setOnKeyListener(new ay(this));
            this.l = (EditText) this.D.findViewById(R.id.input_page_number);
            this.l.setOnFocusChangeListener(new az(this));
            ((Button) this.D.findViewById(R.id.dialog_button_ok)).setOnClickListener(new ba(this));
            ((Button) this.D.findViewById(R.id.dialog_button_cancel)).setOnClickListener(new bc(this));
        }
        if (this.p.a() != null) {
            TextView textView = (TextView) this.D.findViewById(R.id.current_page_number);
            int b = this.p.a().e().b();
            int a = this.p.a().e().a();
            if (b <= 0) {
                b = 1;
            }
            if (a <= 0) {
                a = 1;
            }
            textView.setText(MessageFormat.format(getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(b), Integer.valueOf(a)));
            this.A.show();
            this.l.setText("");
            this.l.requestFocus();
            a(this.l, WebChromeClient.STRING_DLG_BTN_SET);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AlertDialog u() {
        String str;
        if (e() != null && e().isShowing()) {
            return e();
        }
        bd bdVar = new bd(this);
        com.baidu.tieba.a.al alVar = (com.baidu.tieba.a.al) this.n.getItem(this.ah);
        if (alVar == null || this.p == null || alVar.a() == null) {
            str = null;
        } else if (alVar.a().equals(this.p.j())) {
            str = getString(R.string.delete_mark);
        } else {
            str = getString(R.string.add_mark);
        }
        return str != null ? a(new String[]{getString(R.string.copy), str}, bdVar) : a(new String[]{getString(R.string.copy)}, bdVar);
    }

    private void d(int i) {
        ArrayList d;
        if (this.p != null && this.p.a() != null && (d = this.p.a().d()) != null && d.size() > 0) {
            if (i == 0) {
                e(2);
            } else {
                e(1);
            }
            if (this.o != null) {
                if (i == 0) {
                    this.n.b(true);
                } else {
                    this.n.a(true);
                }
                this.n.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        d(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        d(0);
    }

    private void a(Bundle bundle) {
        Boolean valueOf;
        Boolean valueOf2;
        this.af = new a(this, new String[]{getString(R.string.reply), getString(R.string.mark), getString(R.string.share)});
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setAdapter(this.af, this.c);
        if (this.e == null) {
            this.e = builder.create();
            this.e.setCanceledOnTouchOutside(true);
        }
        this.p = new com.baidu.tieba.b.q();
        Boolean.valueOf(true);
        Boolean.valueOf(false);
        String str = null;
        this.am = getIntent().getBooleanExtra("is_message_pv", false);
        this.an = getIntent().getLongExtra("message_id", 0L);
        if (bundle != null) {
            this.q = bundle.getString("id");
            this.r = bundle.getString("pid");
            Boolean valueOf3 = Boolean.valueOf(bundle.getBoolean("sequence", true));
            Boolean valueOf4 = Boolean.valueOf(bundle.getBoolean("hostMode", false));
            String string = bundle.getString("markid");
            this.p.i(bundle.getBoolean("markMode", false));
            this.ag = bundle.getString("st_type");
            valueOf = valueOf3;
            valueOf2 = valueOf4;
            str = string;
        } else {
            Intent intent = getIntent();
            this.ag = intent.getStringExtra("st_type");
            com.baidu.tieba.a.ac acVar = (com.baidu.tieba.a.ac) intent.getSerializableExtra("mark");
            if (acVar != null) {
                this.q = acVar.d();
                Boolean h = acVar.h();
                Boolean valueOf5 = Boolean.valueOf(acVar.i());
                String j = acVar.j();
                this.p.i(true);
                valueOf = h;
                valueOf2 = valueOf5;
                str = j;
            } else {
                this.q = intent.getStringExtra("id");
                this.r = intent.getStringExtra("pid");
                valueOf = Boolean.valueOf(intent.getBooleanExtra("sequence", true));
                valueOf2 = Boolean.valueOf(intent.getBooleanExtra("hostMode", false));
                com.baidu.tieba.a.ac l = com.baidu.tieba.c.k.l(this.q);
                a(intent.getBooleanExtra("can_skip", true));
                if (l != null) {
                    str = l.j();
                }
            }
        }
        TiebaApplication tiebaApplication = (TiebaApplication) getApplication();
        if (tiebaApplication != null) {
            this.p.a(tiebaApplication.s());
            this.p.g(tiebaApplication.t());
        }
        if (valueOf2.booleanValue()) {
            valueOf = true;
        }
        this.p.b(valueOf.booleanValue());
        this.p.c(valueOf2.booleanValue());
        if (valueOf2.booleanValue()) {
            this.i.setText(R.string.view_all);
        } else {
            this.i.setText(R.string.view_host);
        }
        this.p.a(str);
        if (this.p.n()) {
            a(false);
            e(4);
        } else if (this.r != null) {
            a(false);
            e(6);
        } else {
            e(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.ao = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        BasicNameValuePair basicNameValuePair;
        if (this.o != null) {
            this.o.a();
            this.o = null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append("http://c.tieba.baidu.com/");
            stringBuffer.append("c/f/pb/page");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kz", this.q));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(30)));
            if (!this.p.c()) {
                arrayList.add(new BasicNameValuePair("r", String.valueOf(1)));
            }
            if (this.p.d()) {
                arrayList.add(new BasicNameValuePair("lz", String.valueOf(1)));
            }
            if (this.q != null && this.q.length() > 0) {
                if (i == 5) {
                    int parseInt = Integer.parseInt(this.l.getText().toString(), 10);
                    int a = this.p.a().e().a();
                    int i2 = parseInt >= 1 ? parseInt : 1;
                    if (i2 <= a) {
                        a = i2;
                    }
                    arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(a)).toString()));
                    arrayList.add(new BasicNameValuePair("back", "0"));
                    this.s.setVisibility(0);
                } else if (i == 2) {
                    arrayList.add(new BasicNameValuePair("back", "1"));
                    if (!this.p.n() && this.r == null) {
                        if (this.p.c()) {
                            arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.p.l() + (-1) < 0 ? 1 : this.p.l() - 1)).toString()));
                        } else if (this.p.k() < this.p.a().e().a()) {
                            arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.p.k() + 1)).toString()));
                            this.p.h(false);
                        } else {
                            this.p.h(true);
                        }
                    }
                    ArrayList d = this.p.a().d();
                    if (d != null && d.size() > 0) {
                        int size = d.size();
                        String a2 = ((com.baidu.tieba.a.al) d.get(0)).a();
                        if (a2 != null && a2.length() > 0) {
                            arrayList.add(new BasicNameValuePair("pid", a2));
                        }
                        if (size > com.baidu.tieba.a.i.b() - 30) {
                            for (int i3 = 1; i3 <= size - (com.baidu.tieba.a.i.b() - 30) && size - i3 >= 0; i3++) {
                                d.remove(size - i3);
                            }
                            this.n.b(2);
                            this.n.notifyDataSetChanged();
                        }
                    }
                } else if (i == 1) {
                    arrayList.add(new BasicNameValuePair("back", String.valueOf(0)));
                    ArrayList d2 = this.p.a().d();
                    if (d2 != null && d2.size() > 0) {
                        int size2 = d2.size();
                        String a3 = ((com.baidu.tieba.a.al) d2.get(size2 - 1)).a();
                        if (a3 != null && a3.length() > 0) {
                            arrayList.add(new BasicNameValuePair("pid", a3));
                        }
                        if (size2 > com.baidu.tieba.a.i.b() - 30) {
                            for (int b = com.baidu.tieba.a.i.b() - 30; b < size2; b++) {
                                d2.remove(0);
                            }
                            this.n.a(2);
                            this.n.notifyDataSetChanged();
                        }
                    } else if (!this.p.c()) {
                        arrayList.add(new BasicNameValuePair("last", String.valueOf(1)));
                    }
                    if (!this.p.n() && this.r == null) {
                        if (this.p.c()) {
                            if (this.p.k() < this.p.a().e().a()) {
                                arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.p.k() + 1)).toString()));
                                this.p.h(false);
                            } else {
                                this.p.h(true);
                            }
                        } else {
                            arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.p.l() - 1)).toString()));
                        }
                    }
                } else if (i == 4) {
                    arrayList.add(new BasicNameValuePair("pid", this.p.j()));
                    arrayList.add(new BasicNameValuePair("back", "0"));
                    arrayList.add(new BasicNameValuePair("st_type", "tb_bookmarklist"));
                    this.n.b(0);
                    this.n.a(0);
                    this.s.setVisibility(0);
                } else if (i == 6) {
                    arrayList.add(new BasicNameValuePair("pid", this.r));
                    arrayList.add(new BasicNameValuePair("back", "0"));
                    this.n.b(0);
                    this.n.a(0);
                    this.s.setVisibility(0);
                    if (this.ag != null) {
                        arrayList.add(new BasicNameValuePair("st_type", this.ag));
                    }
                } else if (i == 3) {
                    arrayList.add(new BasicNameValuePair("back", "0"));
                    if (this.p.c()) {
                        arrayList.add(new BasicNameValuePair("pn", "1"));
                    } else if ((getIntent().getStringExtra("st_type") == null || !getIntent().getStringExtra("st_type").equals("tb_frslist") || getIntent().getBooleanExtra("sequence", true)) && this.p != null && this.p.a() != null && this.p.a().e() != null) {
                        arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.p.a().e().a())).toString()));
                    }
                    if (this.p != null) {
                        this.p.i(false);
                        if (!this.p.c()) {
                            arrayList.add(new BasicNameValuePair("last", String.valueOf(1)));
                        }
                        if (this.p.a() != null) {
                            this.p.a().d().clear();
                            this.n.notifyDataSetChanged();
                        }
                    }
                    this.n.b(0);
                    this.n.a(0);
                    if (this.ag != null) {
                        arrayList.add(new BasicNameValuePair("st_type", this.ag));
                    }
                    this.s.setVisibility(0);
                    System.gc();
                }
                if (i == 4 || i == 6) {
                    basicNameValuePair = new BasicNameValuePair("mark", "1");
                } else {
                    basicNameValuePair = new BasicNameValuePair("mark", "0");
                }
                arrayList.add(basicNameValuePair);
                this.o = new bw(this, stringBuffer.toString(), arrayList, i);
                this.o.execute(stringBuffer.toString(), arrayList);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("PbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.p.c(true);
        if (TiebaApplication.b().ag() == 1) {
            a(this.i, R.drawable.pb_bottom_btn_viewall_1);
        } else {
            a(this.i, R.drawable.pb_bottom_btn_viewall);
        }
        this.i.setText(R.string.view_all);
        this.p.b(true);
        e(3);
        this.n.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.p.c(false);
        if (TiebaApplication.b().ag() == 1) {
            a(this.i, R.drawable.pb_bottom_btn_viewhost_1);
        } else {
            a(this.i, R.drawable.pb_bottom_btn_viewhost);
        }
        this.i.setText(R.string.view_host);
        e(3);
        this.n.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.p.b(false);
        this.p.c(false);
        if (TiebaApplication.b().ag() == 1) {
            a(this.i, R.drawable.pb_bottom_btn_viewhost_1);
        } else {
            a(this.i, R.drawable.pb_bottom_btn_viewhost);
        }
        this.i.setText(R.string.view_host);
        e(3);
        this.n.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.p.b(true);
        e(3);
        this.n.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.p.g(true);
        TiebaApplication.b().b((Boolean) true);
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.p.g(false);
        TiebaApplication.b().b((Boolean) false);
        D();
    }

    public void a(int i, String str, int i2) {
        if (this.F == null) {
            this.F = new Dialog(this, R.style.common_alert_dialog);
            this.F.setCanceledOnTouchOutside(true);
            this.F.setCancelable(true);
            this.G = getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.F.setContentView(this.G);
            WindowManager.LayoutParams attributes = this.F.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ai.a((Context) this) * 0.9d);
            this.F.getWindow().setAttributes(attributes);
            this.H = (Button) this.G.findViewById(R.id.dialog_button_ok);
            this.I = (Button) this.G.findViewById(R.id.dialog_button_cancel);
            this.I.setOnClickListener(new be(this));
            this.J = (TextView) this.G.findViewById(R.id.confirm_text);
        }
        if (this.p != null && this.p.a() != null) {
            this.H.setOnClickListener(new bf(this, i, str, i2));
            if (i == 1) {
                this.J.setText(R.string.del_thread_confirm);
            } else {
                this.J.setText(R.string.del_post_confirm);
            }
            this.F.show();
        }
    }

    public void a(String str, int i) {
        if (this.K == null) {
            this.K = new Dialog(this, R.style.common_alert_dialog);
            this.K.setCanceledOnTouchOutside(true);
            this.K.setCancelable(true);
            this.L = getLayoutInflater().inflate(R.layout.forbid_user, (ViewGroup) null);
            this.K.setContentView(this.L);
            WindowManager.LayoutParams attributes = this.K.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ai.a((Context) this) * 0.9d);
            this.K.getWindow().setAttributes(attributes);
            this.N = (RadioGroup) this.L.findViewById(R.id.radio_group);
            this.O = (RadioButton) this.L.findViewById(R.id.radio_button_1day);
            this.P = (RadioButton) this.L.findViewById(R.id.radio_button_3day);
            this.Q = (RadioButton) this.L.findViewById(R.id.radio_button_10day);
            bg bgVar = new bg(this);
            this.O.setOnCheckedChangeListener(bgVar);
            this.P.setOnCheckedChangeListener(bgVar);
            this.Q.setOnCheckedChangeListener(bgVar);
            this.R = (Button) this.L.findViewById(R.id.dialog_button_ok);
            this.S = (Button) this.L.findViewById(R.id.dialog_button_cancel);
            this.S.setOnClickListener(new bh(this));
            this.T = (TextView) this.L.findViewById(R.id.user_name);
        }
        if (this.p != null && this.p.a() != null) {
            this.T.setText(str);
            this.N.check(R.id.radio_button_1day);
            if (i == 2) {
                this.P.setVisibility(8);
                this.Q.setVisibility(8);
            }
            this.R.setOnClickListener(new bi(this, str));
            this.K.show();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1100004:
                    a((com.baidu.tieba.a.al) null);
                    return;
                case 1100005:
                    a(this.x);
                    return;
                case 1100006:
                    x();
                    return;
                case 1100007:
                    z();
                    return;
                case 1100009:
                    a(this.ai, this.aj);
                    return;
                case 1300001:
                case 1300002:
                    try {
                        String x = TiebaApplication.x();
                        String a = this.p.a().b().h().a();
                        if (!this.p.d() || x.equals(a)) {
                            if (this.p.c() && this.n.f() == 1) {
                                v();
                            } else if (!this.p.c() && this.n.d() == 1) {
                                w();
                            }
                        }
                        return;
                    } catch (Exception e) {
                        com.baidu.tieba.c.ag.b(getClass().getName(), "onActivityResult", e.getMessage());
                        return;
                    }
                case 1300004:
                    String stringExtra = intent.getStringExtra("del_post_id");
                    if (stringExtra != null && this.p != null && this.p.a() != null) {
                        ArrayList d = this.p.a().d();
                        int size = d.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                if (!stringExtra.equals(((com.baidu.tieba.a.al) d.get(i3)).a())) {
                                    i3++;
                                } else {
                                    d.remove(i3);
                                }
                            }
                        }
                        D();
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
        String x = TiebaApplication.x();
        if (x == null || x.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100017);
        } else if (!this.p.f()) {
            this.p.d(true);
            if (this.ab != null) {
                this.ab.a();
                this.ab = null;
            }
            com.baidu.tieba.a.q a = this.p.a().a();
            this.ab = new bu(this, a.b(), a.c(), this.p.a().b().a(), str, i, i2);
            if (i == 1) {
                str2 = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/delthread";
            } else {
                str2 = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/delpost";
            }
            this.ab.execute(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String x = TiebaApplication.x();
        if (x == null || x.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100018);
        } else if (!this.p.g()) {
            this.p.e(true);
            if (this.ac != null) {
                this.ac.a();
                this.ac = null;
            }
            com.baidu.tieba.a.q a = this.p.a().a();
            this.ac = new bv(this, a.b(), a.c(), this.p.a().b().a(), str, String.valueOf(this.M));
            this.ac.execute("http://c.tieba.baidu.com/c/c/bawu/commitprison");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        try {
            if (this.p != null && this.p.a() != null) {
                if (this.p.a().d() != null) {
                    this.n.a(this.p);
                    this.n.notifyDataSetChanged();
                }
                com.baidu.tieba.a.q a = this.p.a().a();
                if (a != null && a.c() != null) {
                    this.f.setText(String.valueOf(a.c()) + getString(R.string.forum));
                }
                if (a(this.p)) {
                    this.i.setEnabled(false);
                }
            }
            if (this.al) {
                this.d.setSelection(this.d.getCount());
            }
            this.al = false;
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("PbActivity", "refreshActivity", "error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        String str;
        String x = TiebaApplication.x();
        if (x == null || x.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100022);
        } else if (!this.p.h()) {
            this.p.f(true);
            if (this.ad != null) {
                this.ad.a();
                this.ad = null;
            }
            com.baidu.tieba.a.q a = this.p.a().a();
            this.ad = new bz(this, a.b(), a.c(), this.p.a().b().a(), i);
            if (i == 5) {
                str = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/goodlist";
            } else if (i == 1 || i == 2) {
                str = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/commitgood";
            } else {
                str = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/committop";
            }
            this.ad.execute(str);
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
            if (this.U == null) {
                this.U = new Dialog(this, R.style.common_alert_dialog);
                this.U.setCanceledOnTouchOutside(true);
                this.U.setCancelable(true);
                this.V = getLayoutInflater().inflate(R.layout.commit_good, (ViewGroup) null);
                this.U.setContentView(this.V);
                WindowManager.LayoutParams attributes = this.U.getWindow().getAttributes();
                attributes.width = (int) (com.baidu.tieba.c.ai.a((Context) this) * 0.9d);
                this.U.getWindow().setAttributes(attributes);
                this.X = new bj(this);
                this.W = (RadioGroup) this.V.findViewById(R.id.good_class_group);
                this.Z = (Button) this.V.findViewById(R.id.dialog_button_cancel);
                this.Z.setOnClickListener(new bk(this));
                this.Y = (Button) this.V.findViewById(R.id.dialog_button_ok);
                this.Y.setOnClickListener(new bl(this));
            }
            if (this.p != null && this.p.a() != null) {
                this.W.removeAllViews();
                LayoutInflater layoutInflater = getLayoutInflater();
                RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                radioButton.setTag("0");
                radioButton.setText(getResources().getString(R.string.def_good_class));
                radioButton.setOnCheckedChangeListener(this.X);
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
                layoutParams.setMargins(com.baidu.tieba.c.ai.a(this, 10.0f), com.baidu.tieba.c.ai.a(this, 5.0f), com.baidu.tieba.c.ai.a(this, 10.0f), com.baidu.tieba.c.ai.a(this, 5.0f));
                this.W.addView(radioButton, layoutParams);
                this.W.requestLayout();
                this.W.check(radioButton.getId());
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                    radioButton2.setTag(String.valueOf(((com.baidu.tieba.a.t) arrayList.get(i2)).b()));
                    radioButton2.setText(((com.baidu.tieba.a.t) arrayList.get(i2)).a());
                    radioButton2.setOnCheckedChangeListener(this.X);
                    this.W.addView(radioButton2, layoutParams);
                    this.W.requestLayout();
                }
                this.U.show();
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "openCommitGoodDialog", e.getMessage());
        }
    }
}
