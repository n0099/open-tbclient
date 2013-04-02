package com.baidu.tieba.pb;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private static volatile long aq = 0;
    private static volatile long ar = 0;
    private static volatile int as = 0;
    private TranslateAnimation at;
    private TranslateAnimation au;
    private ListView d = null;
    private AlertDialog e = null;
    private TextView f = null;
    private Button g = null;
    private Button h = null;
    private Button i = null;
    private Button j = null;
    private EditText k = null;
    private Button l = null;
    private cd m = null;
    private bz n = null;
    private com.baidu.tieba.b.r o = null;
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
    private Button Z = null;
    private Dialog aa = null;
    private View ab = null;
    private String ac = null;
    private bv ad = null;
    private bw ae = null;
    private cc af = null;
    private b ag = null;
    private a ah = null;
    private String ai = null;
    private int aj = -1;
    private com.baidu.tieba.a.ae ak = null;
    private String al = null;
    private boolean am = false;
    private boolean an = false;
    private long ao = 0;
    private boolean ap = true;
    private Animation.AnimationListener av = null;
    private boolean aw = false;
    private boolean ax = true;
    private int ay = 0;
    private boolean az = false;
    private bx aA = null;
    private RelativeLayout aB = null;
    private Runnable aC = new ao(this);
    DialogInterface.OnClickListener c = new bb(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.a.ae aeVar, boolean z) {
        if (aeVar != null) {
            String y = TiebaApplication.y();
            if (y == null || y.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100009);
                return;
            }
            if (!G()) {
                F();
            }
            aeVar.e(TiebaApplication.y());
            if (this.aA != null) {
                this.aA.a();
            }
            this.aA = new bx(this, aeVar, z);
            this.aA.execute(new Boolean[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.a.an anVar) {
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            if (this.o != null && this.o.a() != null && this.o.a().f() != null) {
                this.o.a().f().a(1);
            }
            if (anVar != null) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100005);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100004);
            }
        } else if (this.p != null && this.p.length() > 0 && this.o.a() != null) {
            if (anVar != null) {
                WriteActivity.a(this, this.o.a().a().b(), this.o.a().a().c(), this.p, anVar.a(), anVar.c(), getIntent().getBooleanExtra("isAd", false), this.o.a().f());
            } else {
                WriteActivity.a(this, this.o.a().a().b(), this.o.a().a().c(), this.p, null, 0, getIntent().getBooleanExtra("isAd", false), this.o.a().f());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.a.ae o() {
        com.baidu.tieba.a.ae aeVar = new com.baidu.tieba.a.ae();
        Date date = new Date();
        aeVar.e(TiebaApplication.y());
        aeVar.b(this.p);
        this.v = this.d.getFirstVisiblePosition();
        this.v = this.m.getItemId(this.d.getFirstVisiblePosition());
        this.v = this.v < 0 ? 0L : this.v;
        if (this.o.a() != null) {
            aeVar.c(this.o.a().b().c());
            if (this.v >= 0 && this.v < this.o.a().d().size()) {
                aeVar.c(((com.baidu.tieba.a.an) this.o.a().d().get((int) this.v)).c());
                aeVar.d(((com.baidu.tieba.a.an) this.o.a().d().get((int) this.v)).a());
            }
            aeVar.a(this.o.a().b().h().c());
            aeVar.a(this.o.a().b().d());
            if (this.o.a().k()) {
                aeVar.b(1);
                aeVar.f(this.o.a().a().b());
                aeVar.g(this.o.a().a().c());
                aeVar.h(this.o.a().b().a());
            }
            aeVar.a(date.getTime());
            aeVar.a(this.o.d());
            aeVar.a(Boolean.valueOf(this.o.c()));
            return aeVar;
        }
        return null;
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

    public static void a(Activity activity, int i, com.baidu.tieba.a.ae aeVar) {
        Intent intent = new Intent(activity, PbActivity.class);
        if (aeVar.c() != null && aeVar.g() != null) {
            intent.putExtra("mark", aeVar);
            intent.putExtra("st_type", "store_thread");
            activity.startActivityForResult(intent, i);
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
        this.al = TiebaApplication.y();
        s();
        p();
        a(bundle);
    }

    private void p() {
        if (this.av == null) {
            this.av = new bm(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        int height = this.B.getHeight();
        if (this.at == null) {
            this.at = new TranslateAnimation(0.0f, 0.0f, 0.0f, -height);
            this.at.setDuration(300L);
            this.at.setFillAfter(true);
        }
        if (this.au == null) {
            this.au = new TranslateAnimation(0.0f, 0.0f, -height, 0.0f);
            this.au.setDuration(300L);
            this.au.setFillAfter(true);
        }
        this.at.setAnimationListener(this.av);
        this.au.setAnimationListener(this.av);
    }

    public int j() {
        return this.B.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void a() {
        r();
        k();
        super.a();
    }

    private void r() {
        if (this.o.n() && this.o != null) {
            com.baidu.tieba.a.ae o = o();
            if (o != null) {
                new by(o).start();
                if (this.az) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", o);
                    setResult(-1, intent);
                }
            }
        } else if (this.o != null && this.az) {
            setResult(1);
        }
    }

    @Override // com.baidu.tieba.e, android.app.Activity, android.view.KeyEvent.Callback
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
        this.s.removeCallbacks(this.aC);
        try {
            if (this.n != null) {
                this.n.a();
                this.n = null;
            }
            if (this.aA != null) {
                this.aA.a();
                this.aA = null;
            }
            if (this.m != null) {
                this.m.a();
                this.m.b().b();
            }
            if (this.ag != null) {
                this.ag.a();
            }
            if (this.o != null && this.o.a() != null) {
                this.o.a((com.baidu.tieba.a.ak) null);
            }
            if (this.ad != null) {
                this.ad.a();
                this.ad = null;
            }
            if (this.ae != null) {
                this.ae.a();
                this.ae = null;
            }
            if (this.aa != null) {
                this.aa.dismiss();
                this.aa = null;
            }
            k();
            this.r.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.a(getClass().getName(), "onDestroy", e.toString());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("mark_state", this.az);
        bundle.putString("id", this.p);
        bundle.putString("pid", this.q);
        bundle.putBoolean("sequence", this.o.c());
        bundle.putBoolean("hostMode", this.o.d());
        bundle.putString("markid", this.o.j());
        if (this.ai != null) {
            bundle.putString("st_type", this.ai);
        }
    }

    public static boolean a(com.baidu.tieba.b.r rVar) {
        com.baidu.tieba.a.ax b;
        String a;
        return rVar == null || rVar.a() == null || (b = rVar.a().b()) == null || b.h() == null || (a = b.h().a()) == null || a.equals("0");
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
        if (this.m != null && this.m.j() != TiebaApplication.b().af()) {
            this.m.c(TiebaApplication.b().af());
            this.m.notifyDataSetChanged();
        }
        if (this.m != null && this.m.i() != TiebaApplication.b().ae()) {
            this.m.c(TiebaApplication.b().ae());
            this.m.notifyDataSetChanged();
        }
        if (this.o != null) {
            String y = TiebaApplication.y();
            if (this.al == null && y != null && y.length() > 0) {
                this.al = y;
                if (this.o.a() != null && this.o.a().f() != null) {
                    this.o.a().f().a(1);
                }
            }
        }
        if (this.m != null) {
            this.m.notifyDataSetChanged();
        }
        this.aC.run();
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
        com.baidu.tieba.c.ae.a(this.aB, i);
        com.baidu.tieba.c.ae.c(this.B, i);
        com.baidu.tieba.c.ae.c(this.f, i);
        com.baidu.tieba.c.ae.e((TextView) this.i, i);
        com.baidu.tieba.c.ae.g(this.l, i);
        com.baidu.tieba.c.ae.b(this.d, i);
        this.m.notifyDataSetChanged();
        if (i == 1) {
            this.f.setBackgroundResource(R.drawable.pb_title_button_1);
            a(this.g, R.drawable.pb_bottom_btn_reply_1);
            a(this.j, R.drawable.pb_bottom_btn_more_1);
            a(this.Z, R.drawable.pb_bottom_btn_mark_1);
            this.g.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.Z.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
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
        a(this.Z, R.drawable.pb_bottom_btn_mark);
        this.g.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.Z.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
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

    private void s() {
        this.aB = (RelativeLayout) findViewById(R.id.parent);
        this.t = new bo(this);
        this.u = new bp(this);
        this.f = (TextView) findViewById(R.id.title_text);
        this.B = (LinearLayout) findViewById(R.id.title);
        this.D = (LinearLayout) findViewById(R.id.bottom_bar);
        this.f.setClickable(true);
        this.f.setOnClickListener(new bq(this));
        this.j = (Button) findViewById(R.id.more);
        this.j.setOnClickListener(new br(this));
        this.i = (Button) findViewById(R.id.back);
        this.i.setOnClickListener(new bt(this));
        this.h = (Button) findViewById(R.id.view_host);
        this.h.setOnClickListener(new bu(this));
        this.g = (Button) findViewById(R.id.reply);
        this.g.setOnClickListener(new ar(this));
        this.Z = (Button) findViewById(R.id.mark);
        this.Z.setOnClickListener(new as(this));
        this.l = (Button) findViewById(R.id.recommend);
        this.l.setOnClickListener(new at(this));
        this.d = (ListView) findViewById(R.id.pb_list);
        this.d.setFastScrollEnabled(true);
        this.m = new cd(this, null, com.baidu.tieba.c.ai.a(this, 234.0f), this.u);
        this.m.c(TiebaApplication.b().af());
        this.m.c(TiebaApplication.b().ae());
        this.m.b(0);
        this.m.a(0);
        this.d.setAdapter((ListAdapter) this.m);
        this.d.setOnItemClickListener(new au(this));
        this.d.setOnScrollListener(new av(this));
        this.d.setOnItemLongClickListener(this.t);
        this.d.setOnTouchListener(new ax(this, new GestureDetector(this, new aw(this))));
        this.r = (ProgressBar) findViewById(R.id.progress);
        this.r.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.o != null && this.o.a() != null) {
            if (TiebaApplication.b().l()) {
                StatService.onEvent(this, "pb_share", "pbclick", 1);
            }
            try {
                Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
                intent.addCategory("android.intent.category.DEFAULT");
                String a = this.o.a().b().a();
                String c = this.o.a().a().c();
                String c2 = this.o.a().b().c();
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
    public void u() {
        if (this.z == null) {
            this.z = new Dialog(this, R.style.common_alert_dialog);
            this.z.setCanceledOnTouchOutside(true);
            this.z.setCancelable(true);
            this.C = getLayoutInflater().inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            this.z.setContentView(this.C);
            WindowManager.LayoutParams attributes = this.z.getWindow().getAttributes();
            attributes.gravity = 49;
            attributes.y = com.baidu.tieba.c.ai.a(this, 54.0f);
            attributes.width = (int) (com.baidu.tieba.c.ai.a((Context) this) * 0.9d);
            this.z.getWindow().setAttributes(attributes);
            this.z.setOnKeyListener(new ay(this));
            this.k = (EditText) this.C.findViewById(R.id.input_page_number);
            this.k.setOnFocusChangeListener(new az(this));
            ((Button) this.C.findViewById(R.id.dialog_button_ok)).setOnClickListener(new ba(this));
            ((Button) this.C.findViewById(R.id.dialog_button_cancel)).setOnClickListener(new bc(this));
        }
        if (this.o.a() != null) {
            TextView textView = (TextView) this.C.findViewById(R.id.current_page_number);
            int b = this.o.a().e().b();
            int a = this.o.a().e().a();
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
    public AlertDialog v() {
        if (e() != null && e().isShowing()) {
            return e();
        }
        return a(new String[]{getString(R.string.copy)}, new bd(this));
    }

    private void d(int i) {
        ArrayList d;
        if (this.o != null && this.o.a() != null && (d = this.o.a().d()) != null && d.size() > 0) {
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
    public void w() {
        d(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        d(0);
    }

    private void a(Bundle bundle) {
        Boolean bool;
        Boolean bool2;
        this.ah = new a(this, new String[]{getString(R.string.reply), getString(R.string.share)});
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setAdapter(this.ah, this.c);
        if (this.e == null) {
            this.e = builder.create();
            this.e.setCanceledOnTouchOutside(true);
        }
        this.o = new com.baidu.tieba.b.r();
        Boolean.valueOf(true);
        Boolean.valueOf(false);
        String str = null;
        this.an = getIntent().getBooleanExtra("is_message_pv", false);
        this.ao = getIntent().getLongExtra("message_id", 0L);
        if (bundle != null) {
            this.az = bundle.getBoolean("mark_state");
            this.p = bundle.getString("id");
            this.q = bundle.getString("pid");
            Boolean valueOf = Boolean.valueOf(bundle.getBoolean("sequence", true));
            Boolean valueOf2 = Boolean.valueOf(bundle.getBoolean("hostMode", false));
            String string = bundle.getString("markid");
            this.ai = bundle.getString("st_type");
            bool = valueOf;
            bool2 = valueOf2;
            str = string;
        } else {
            Intent intent = getIntent();
            this.ai = intent.getStringExtra("st_type");
            com.baidu.tieba.a.ae aeVar = (com.baidu.tieba.a.ae) intent.getSerializableExtra("mark");
            if (aeVar != null) {
                this.o.i(true);
                this.az = true;
                this.Z.setText(R.string.remove_mark);
                this.p = aeVar.c();
                Boolean e = aeVar.e();
                Boolean valueOf3 = Boolean.valueOf(aeVar.f());
                String g = aeVar.g();
                this.o.i(true);
                bool = e;
                bool2 = valueOf3;
                str = g;
            } else {
                this.o.i(false);
                this.az = false;
                this.Z.setText(R.string.mark);
                this.p = intent.getStringExtra("id");
                this.q = intent.getStringExtra("pid");
                Boolean valueOf4 = Boolean.valueOf(intent.getBooleanExtra("sequence", true));
                Boolean valueOf5 = Boolean.valueOf(intent.getBooleanExtra("hostMode", false));
                a(intent.getBooleanExtra("can_skip", true));
                bool = valueOf4;
                bool2 = valueOf5;
            }
        }
        TiebaApplication tiebaApplication = (TiebaApplication) getApplication();
        if (tiebaApplication != null) {
            this.o.a(tiebaApplication.t());
            this.o.g(tiebaApplication.u());
        }
        if (bool2.booleanValue()) {
            bool = true;
        }
        this.o.b(bool.booleanValue());
        this.o.c(bool2.booleanValue());
        if (bool2.booleanValue()) {
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
        this.ap = true;
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
                    int a = this.o.a().e().a();
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
                        } else if (this.o.k() < this.o.a().e().a()) {
                            arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.o.k() + 1)).toString()));
                            this.o.h(false);
                        } else {
                            this.o.h(true);
                        }
                    }
                    ArrayList d = this.o.a().d();
                    if (d != null && d.size() > 0) {
                        int size = d.size();
                        String a2 = ((com.baidu.tieba.a.an) d.get(0)).a();
                        if (a2 != null && a2.length() > 0) {
                            arrayList.add(new BasicNameValuePair("pid", a2));
                        }
                        if (size > com.baidu.tieba.a.i.b() - 30) {
                            for (int i3 = 1; i3 <= size - (com.baidu.tieba.a.i.b() - 30) && size - i3 >= 0; i3++) {
                                d.remove(size - i3);
                            }
                            this.m.b(2);
                            this.m.notifyDataSetChanged();
                        }
                    }
                } else if (i == 1) {
                    arrayList.add(new BasicNameValuePair("back", String.valueOf(0)));
                    ArrayList d2 = this.o.a().d();
                    if (d2 != null && d2.size() > 0) {
                        int size2 = d2.size();
                        String a3 = ((com.baidu.tieba.a.an) d2.get(size2 - 1)).a();
                        if (a3 != null && a3.length() > 0) {
                            arrayList.add(new BasicNameValuePair("pid", a3));
                        }
                        if (size2 > com.baidu.tieba.a.i.b() - 30) {
                            for (int b = com.baidu.tieba.a.i.b() - 30; b < size2; b++) {
                                d2.remove(0);
                            }
                            this.m.a(2);
                            this.m.notifyDataSetChanged();
                        }
                    } else if (!this.o.c()) {
                        arrayList.add(new BasicNameValuePair("last", String.valueOf(1)));
                    }
                    if (!this.o.n() && this.q == null) {
                        if (this.o.c()) {
                            if (this.o.k() < this.o.a().e().a()) {
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
                    arrayList.add(new BasicNameValuePair("st_type", "store_thread"));
                    this.m.b(0);
                    this.m.a(0);
                    this.r.setVisibility(0);
                } else if (i == 6) {
                    arrayList.add(new BasicNameValuePair("pid", this.q));
                    arrayList.add(new BasicNameValuePair("back", "0"));
                    this.m.b(0);
                    this.m.a(0);
                    this.r.setVisibility(0);
                    if (this.ai != null) {
                        arrayList.add(new BasicNameValuePair("st_type", this.ai));
                    }
                } else if (i == 3) {
                    arrayList.add(new BasicNameValuePair("back", "0"));
                    if (this.o.c()) {
                        arrayList.add(new BasicNameValuePair("pn", "1"));
                    } else if ((getIntent().getStringExtra("st_type") == null || !getIntent().getStringExtra("st_type").equals("tb_frslist") || getIntent().getBooleanExtra("sequence", true)) && this.o != null && this.o.a() != null && this.o.a().e() != null) {
                        arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.o.a().e().a())).toString()));
                    }
                    if (this.o != null) {
                        if (!this.o.c()) {
                            arrayList.add(new BasicNameValuePair("last", String.valueOf(1)));
                        }
                        if (this.o.a() != null) {
                            this.o.a().d().clear();
                            this.m.notifyDataSetChanged();
                        }
                    }
                    this.m.b(0);
                    this.m.a(0);
                    if (this.ai != null) {
                        arrayList.add(new BasicNameValuePair("st_type", this.ai));
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
                this.n = new bz(this, stringBuffer.toString(), arrayList, i);
                this.n.execute(stringBuffer.toString(), arrayList);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("PbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.o.c(true);
        if (TiebaApplication.b().ah() == 1) {
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
    public void z() {
        this.o.c(false);
        if (TiebaApplication.b().ah() == 1) {
            a(this.h, R.drawable.pb_bottom_btn_viewhost_1);
        } else {
            a(this.h, R.drawable.pb_bottom_btn_viewhost);
        }
        this.h.setText(R.string.view_host);
        e(3);
        this.m.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.o.b(false);
        this.o.c(false);
        if (TiebaApplication.b().ah() == 1) {
            a(this.h, R.drawable.pb_bottom_btn_viewhost_1);
        } else {
            a(this.h, R.drawable.pb_bottom_btn_viewhost);
        }
        this.h.setText(R.string.view_host);
        e(3);
        this.m.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.o.b(true);
        e(3);
        this.m.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.o.g(true);
        TiebaApplication.b().b((Boolean) true);
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.o.g(false);
        TiebaApplication.b().b((Boolean) false);
        E();
    }

    public void a(int i, String str, int i2) {
        if (this.E == null) {
            this.E = new Dialog(this, R.style.common_alert_dialog);
            this.E.setCanceledOnTouchOutside(true);
            this.E.setCancelable(true);
            this.F = getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.E.setContentView(this.F);
            WindowManager.LayoutParams attributes = this.E.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ai.a((Context) this) * 0.9d);
            this.E.getWindow().setAttributes(attributes);
            this.G = (Button) this.F.findViewById(R.id.dialog_button_ok);
            this.H = (Button) this.F.findViewById(R.id.dialog_button_cancel);
            this.H.setOnClickListener(new be(this));
            this.I = (TextView) this.F.findViewById(R.id.confirm_text);
        }
        if (this.o != null && this.o.a() != null) {
            this.G.setOnClickListener(new bf(this, i, str, i2));
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
            attributes.width = (int) (com.baidu.tieba.c.ai.a((Context) this) * 0.9d);
            this.J.getWindow().setAttributes(attributes);
            this.M = (RadioGroup) this.K.findViewById(R.id.radio_group);
            this.N = (RadioButton) this.K.findViewById(R.id.radio_button_1day);
            this.O = (RadioButton) this.K.findViewById(R.id.radio_button_3day);
            this.P = (RadioButton) this.K.findViewById(R.id.radio_button_10day);
            bg bgVar = new bg(this);
            this.N.setOnCheckedChangeListener(bgVar);
            this.O.setOnCheckedChangeListener(bgVar);
            this.P.setOnCheckedChangeListener(bgVar);
            this.Q = (Button) this.K.findViewById(R.id.dialog_button_ok);
            this.R = (Button) this.K.findViewById(R.id.dialog_button_cancel);
            this.R.setOnClickListener(new bh(this));
            this.S = (TextView) this.K.findViewById(R.id.user_name);
        }
        if (this.o != null && this.o.a() != null) {
            this.S.setText(str);
            this.M.check(R.id.radio_button_1day);
            if (i == 2) {
                this.O.setVisibility(8);
                this.P.setVisibility(8);
            }
            this.Q.setOnClickListener(new bi(this, str));
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
                    y();
                    return;
                case 1100007:
                    A();
                    return;
                case 1100009:
                    a(this.ak, this.o.n() ? false : true);
                    return;
                case 1300001:
                case 1300002:
                    try {
                        String y = TiebaApplication.y();
                        String a = this.o.a().b().h().a();
                        if (!this.o.d() || y.equals(a)) {
                            if (this.o.c() && this.m.f() == 1) {
                                w();
                            } else if (!this.o.c() && this.m.d() == 1) {
                                x();
                            }
                        }
                        return;
                    } catch (Exception e) {
                        com.baidu.tieba.c.ag.b(getClass().getName(), "onActivityResult", e.getMessage());
                        return;
                    }
                case 1300004:
                    String stringExtra = intent.getStringExtra("del_post_id");
                    if (stringExtra != null && this.o != null && this.o.a() != null) {
                        ArrayList d = this.o.a().d();
                        int size = d.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                if (!stringExtra.equals(((com.baidu.tieba.a.an) d.get(i3)).a())) {
                                    i3++;
                                } else {
                                    d.remove(i3);
                                }
                            }
                        }
                        E();
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
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100017);
        } else if (!this.o.f()) {
            this.o.d(true);
            if (this.ad != null) {
                this.ad.a();
                this.ad = null;
            }
            com.baidu.tieba.a.q a = this.o.a().a();
            this.ad = new bv(this, a.b(), a.c(), this.o.a().b().a(), str, i, i2);
            if (i == 1) {
                str2 = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/delthread";
            } else {
                str2 = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/delpost";
            }
            this.ad.execute(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100018);
        } else if (!this.o.g()) {
            this.o.e(true);
            if (this.ae != null) {
                this.ae.a();
                this.ae = null;
            }
            com.baidu.tieba.a.q a = this.o.a().a();
            this.ae = new bw(this, a.b(), a.c(), this.o.a().b().a(), str, String.valueOf(this.L));
            this.ae.execute("http://c.tieba.baidu.com/c/c/bawu/commitprison");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        try {
            if (this.o != null && this.o.a() != null) {
                if (this.o.a().d() != null) {
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
                if (!this.o.n()) {
                    this.Z.setText(R.string.mark);
                } else {
                    this.Z.setText(R.string.remove_mark);
                }
            }
            if (this.am) {
                this.d.setSelection(this.d.getCount());
            }
            this.am = false;
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("PbActivity", "refreshActivity", "error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        String str;
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100022);
        } else if (!this.o.h()) {
            this.o.f(true);
            if (this.af != null) {
                this.af.a();
                this.af = null;
            }
            com.baidu.tieba.a.q a = this.o.a().a();
            this.af = new cc(this, a.b(), a.c(), this.o.a().b().a(), i);
            if (i == 5) {
                str = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/goodlist";
            } else if (i == 1 || i == 2) {
                str = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/commitgood";
            } else {
                str = String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/committop";
            }
            this.af.execute(str);
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
                attributes.width = (int) (com.baidu.tieba.c.ai.a((Context) this) * 0.9d);
                this.T.getWindow().setAttributes(attributes);
                this.W = new bj(this);
                this.V = (RadioGroup) this.U.findViewById(R.id.good_class_group);
                this.Y = (Button) this.U.findViewById(R.id.dialog_button_cancel);
                this.Y.setOnClickListener(new bk(this));
                this.X = (Button) this.U.findViewById(R.id.dialog_button_ok);
                this.X.setOnClickListener(new bl(this));
            }
            if (this.o != null && this.o.a() != null) {
                this.V.removeAllViews();
                LayoutInflater layoutInflater = getLayoutInflater();
                RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                radioButton.setTag("0");
                radioButton.setText(getResources().getString(R.string.def_good_class));
                radioButton.setOnCheckedChangeListener(this.W);
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
                layoutParams.setMargins(com.baidu.tieba.c.ai.a(this, 10.0f), com.baidu.tieba.c.ai.a(this, 5.0f), com.baidu.tieba.c.ai.a(this, 10.0f), com.baidu.tieba.c.ai.a(this, 5.0f));
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
            com.baidu.tieba.c.ag.b(getClass().getName(), "openCommitGoodDialog", e.getMessage());
        }
    }

    private void F() {
        if (this.aa == null) {
            this.aa = new Dialog(this, R.style.common_alert_dialog);
            this.aa.setCancelable(true);
            this.ab = getLayoutInflater().inflate(R.layout.mark_guide, (ViewGroup) null);
            this.aa.setContentView(this.ab);
            WindowManager.LayoutParams attributes = this.aa.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ai.a((Context) this) * 0.7d);
            this.aa.getWindow().setAttributes(attributes);
            ((Button) this.ab.findViewById(R.id.dialog_button_ok)).setOnClickListener(new bn(this));
        }
        this.aa.show();
    }

    private boolean G() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", 0);
        boolean z = sharedPreferences.getBoolean("mark_guide_show", false);
        if (!z) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("mark_guide_show", true);
            edit.commit();
        }
        return z;
    }
}
