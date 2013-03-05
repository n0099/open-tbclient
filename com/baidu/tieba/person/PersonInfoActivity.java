package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class PersonInfoActivity extends com.baidu.tieba.e {
    private Button c = null;
    private Button d = null;
    private ImageView e = null;
    private TextView f = null;
    private ImageView g = null;
    private TextView h = null;
    private Button i = null;
    private Button j = null;
    private LinearLayout k = null;
    private LinearLayout l = null;
    private TextView m = null;
    private ScrollView n = null;
    private RelativeLayout o = null;
    private com.baidu.tieba.b.s p = null;
    private View.OnClickListener q = null;
    private View.OnClickListener r = null;
    private bc s = null;
    private ProgressBar t = null;
    private ProgressBar u = null;
    private LinearLayout v = null;
    private TextView w = null;
    private LinearLayout x = null;
    private LinearLayout y = null;
    private LinearLayout z = null;
    private LinearLayout A = null;
    private LinearLayout B = null;
    private LinearLayout C = null;
    private LinearLayout D = null;
    private TextView E = null;
    private TextView F = null;
    private ImageView G = null;
    private TextView H = null;
    private TextView I = null;
    private ImageView J = null;
    private TextView K = null;
    private TextView L = null;
    private ImageView M = null;
    private TextView N = null;
    private TextView O = null;
    private ImageView P = null;
    private TextView Q = null;
    private ImageView R = null;
    private TextView S = null;
    private ImageView T = null;
    private TextView U = null;
    private TextView V = null;
    private TextView W = null;
    private ImageView X = null;
    private bb Y = null;
    private BroadcastReceiver Z = null;

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (str != null && str.length() > 0 && !str.equals("0")) {
            Intent intent = new Intent(context, PersonInfoActivity.class);
            intent.putExtra("un", str);
            intent.putExtra("name", str2);
            if (TiebaApplication.x() != null && TiebaApplication.x().equals(str)) {
                intent.putExtra("self", true);
            } else {
                intent.putExtra("self", false);
            }
            intent.putExtra("tab_page", false);
            if (z) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_info_activity);
        a(bundle);
        i();
        com.baidu.tieba.c.k.b((Boolean) true);
        if (this.p.b()) {
            a(true, true);
        } else {
            a(false, true);
        }
        k();
    }

    private void a(Bundle bundle) {
        this.p = new com.baidu.tieba.b.s(this);
        if (bundle != null) {
            this.p.a(bundle.getBoolean("self", true));
            this.p.a(bundle.getString("un"));
            this.p.b(bundle.getString("name"));
            this.p.b(bundle.getBoolean("tab_page", false));
            this.p.c(bundle.getBoolean("tab_msg", false));
        } else {
            Intent intent = getIntent();
            this.p.a(intent.getBooleanExtra("self", true));
            this.p.a(intent.getStringExtra("un"));
            this.p.b(intent.getStringExtra("name"));
            this.p.b(intent.getBooleanExtra("tab_page", false));
            this.p.c(intent.getBooleanExtra("tab_msg", false));
        }
        if (this.p.b()) {
            IntentFilter intentFilter = new IntentFilter();
            this.Z = new ax(this);
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.Z, intentFilter);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("self", this.p.b());
        bundle.putString("un", this.p.a());
        bundle.putBoolean("tab_page", this.p.i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.p.b()) {
            this.p.a(TiebaApplication.b().Z());
            this.p.c(TiebaApplication.b().X());
            this.p.b(TiebaApplication.b().Y());
            if (com.baidu.tieba.c.k.s().booleanValue()) {
                this.p.a(com.baidu.tieba.c.k.t());
            }
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.a(this.k, i);
        com.baidu.tieba.c.ae.c(this.m, i);
        com.baidu.tieba.c.ae.c(this.l, i);
        com.baidu.tieba.c.ae.e((View) this.j, i);
        com.baidu.tieba.c.ae.e((TextView) this.c, i);
        com.baidu.tieba.c.ae.h(this.i, i);
        a(i, this.H, this.I);
        a(i, this.K, this.L);
        a(i, this.N, this.O);
        a(i, this.F, this.E);
        a(i, this.Q, (TextView) null);
        a(i, this.S, (TextView) null);
        a(i, this.W, (TextView) null);
        if (i == 1) {
            com.baidu.tieba.c.ae.i(this.o, R.drawable.person_seperator_1);
            this.f.setTextColor(com.baidu.tieba.c.ae.a(i));
            this.h.setTextColor(com.baidu.tieba.c.ae.b(i));
            this.d.setBackgroundResource(R.drawable.button_change_1);
            this.n.setBackgroundColor(com.baidu.tieba.c.ae.d(i));
            this.x.setBackgroundResource(R.drawable.person_button_1);
            this.y.setBackgroundResource(R.drawable.person_button_1);
            this.z.setBackgroundResource(R.drawable.person_button_1);
            this.A.setBackgroundResource(R.drawable.person_button_1);
            this.B.setBackgroundResource(R.drawable.person_button_1);
            this.C.setBackgroundResource(R.drawable.person_button_1);
            this.D.setBackgroundResource(R.drawable.person_button_1);
            this.J.setImageResource(R.drawable.person_likes_1);
            this.M.setImageResource(R.drawable.person_attention_1);
            this.P.setImageResource(R.drawable.person_fans_1);
            this.G.setImageResource(R.drawable.person_bookmark_1);
            this.R.setImageResource(R.drawable.person_mention_1);
            this.T.setImageResource(R.drawable.person_mypost_1);
            this.X.setImageResource(R.drawable.person_lbs_1);
            return;
        }
        com.baidu.tieba.c.ae.i(this.o, R.drawable.person_seperator);
        this.f.setTextColor(-14277082);
        this.h.setTextColor(-7566196);
        this.d.setBackgroundResource(R.drawable.button_change);
        this.n.setBackgroundColor(-2302756);
        this.x.setBackgroundResource(R.drawable.person_button);
        this.y.setBackgroundResource(R.drawable.person_button);
        this.z.setBackgroundResource(R.drawable.person_button);
        this.A.setBackgroundResource(R.drawable.person_button);
        this.B.setBackgroundResource(R.drawable.person_button);
        this.C.setBackgroundResource(R.drawable.person_button);
        this.D.setBackgroundResource(R.drawable.person_button);
        this.J.setImageResource(R.drawable.person_likes);
        this.M.setImageResource(R.drawable.person_attention);
        this.P.setImageResource(R.drawable.person_fans);
        this.G.setImageResource(R.drawable.person_bookmark);
        this.R.setImageResource(R.drawable.person_mention);
        this.T.setImageResource(R.drawable.person_mypost);
        this.X.setImageResource(R.drawable.person_lbs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void g() {
        super.g();
        a_(-1);
        this.d.setBackgroundResource(0);
        this.x.setBackgroundResource(0);
        this.y.setBackgroundResource(0);
        this.z.setBackgroundResource(0);
        this.A.setBackgroundResource(0);
        this.B.setBackgroundResource(0);
        this.C.setBackgroundColor(0);
        this.D.setBackgroundResource(0);
        this.J.setImageResource(0);
        this.M.setImageResource(0);
        this.P.setImageResource(0);
        this.G.setImageResource(0);
        this.R.setImageResource(0);
        this.T.setImageResource(0);
        this.X.setImageResource(0);
    }

    private void a(int i, TextView textView, TextView textView2) {
        if (i == 1) {
            if (textView != null) {
                textView.setTextColor(com.baidu.tieba.c.ae.a(i));
            }
            if (textView2 != null) {
                textView2.setTextColor(com.baidu.tieba.c.ae.c(i));
                return;
            }
            return;
        }
        if (textView != null) {
            textView.setTextColor(-14277082);
        }
        if (textView2 != null) {
            textView2.setTextColor(-7566196);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        if (this.s == null) {
            this.s = new bc(this, null);
            this.s.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    private void i() {
        this.t = (ProgressBar) findViewById(R.id.progress);
        this.u = (ProgressBar) findViewById(R.id.attention_progress);
        this.q = new ay(this);
        this.k = (LinearLayout) findViewById(R.id.parent);
        this.l = (LinearLayout) findViewById(R.id.title);
        this.n = (ScrollView) findViewById(R.id.scrollview);
        this.o = (RelativeLayout) findViewById(R.id.info);
        this.m = (TextView) findViewById(R.id.titel_text);
        if (this.p.b()) {
            this.m.setText(R.string.person_info);
        } else if (this.p.d() == null) {
            this.m.setText(this.p.f());
        }
        this.e = (ImageView) findViewById(R.id.photo);
        this.d = (Button) findViewById(R.id.change);
        this.d.setOnClickListener(this.q);
        this.c = (Button) findViewById(R.id.back);
        this.c.setOnClickListener(this.q);
        this.i = (Button) findViewById(R.id.home);
        this.i.setOnClickListener(this.q);
        this.j = (Button) findViewById(R.id.refresh);
        this.j.setOnClickListener(this.q);
        if (this.p.b()) {
            this.d.setVisibility(0);
            if (this.p.i()) {
                this.c.setVisibility(4);
                this.i.setVisibility(8);
                this.j.setVisibility(0);
            } else if (this.p.j()) {
                this.c.setVisibility(0);
                this.i.setVisibility(8);
                this.j.setVisibility(0);
            } else {
                this.c.setVisibility(0);
                this.i.setVisibility(0);
                this.j.setVisibility(8);
            }
        } else {
            this.c.setVisibility(0);
            this.d.setVisibility(8);
            this.i.setVisibility(0);
            this.j.setVisibility(8);
        }
        this.R = (ImageView) findViewById(R.id.my_msg_image);
        this.Q = (TextView) findViewById(R.id.my_msg_text);
        this.E = (TextView) findViewById(R.id.bookmark_number);
        this.G = (ImageView) findViewById(R.id.bookmark_image);
        this.F = (TextView) findViewById(R.id.bookmark_text);
        this.H = (TextView) findViewById(R.id.likes_text);
        this.I = (TextView) findViewById(R.id.likes_number);
        this.J = (ImageView) findViewById(R.id.likes_image);
        this.K = (TextView) findViewById(R.id.my_attention_text);
        this.L = (TextView) findViewById(R.id.attention_number);
        this.M = (ImageView) findViewById(R.id.attention_image);
        this.N = (TextView) findViewById(R.id.fans_text);
        this.O = (TextView) findViewById(R.id.fans_number);
        this.P = (ImageView) findViewById(R.id.fans_image);
        this.x = (LinearLayout) findViewById(R.id.button_mention);
        this.y = (LinearLayout) findViewById(R.id.button_bookmark);
        this.z = (LinearLayout) findViewById(R.id.button_likes);
        this.A = (LinearLayout) findViewById(R.id.button_attention);
        this.B = (LinearLayout) findViewById(R.id.button_fans);
        this.D = (LinearLayout) findViewById(R.id.button_lbs);
        this.C = (LinearLayout) findViewById(R.id.button_mypost);
        this.S = (TextView) findViewById(R.id.my_post_text);
        this.T = (ImageView) findViewById(R.id.my_post_image);
        this.U = (TextView) findViewById(R.id.new_fans_count);
        this.V = (TextView) findViewById(R.id.new_mention_count);
        this.W = (TextView) findViewById(R.id.lbs_text);
        this.X = (ImageView) findViewById(R.id.lbs_image);
        this.r = new az(this);
        this.x.setOnClickListener(this.r);
        this.y.setOnClickListener(this.r);
        this.D.setOnClickListener(this.r);
        this.z.setOnClickListener(this.r);
        this.A.setOnClickListener(this.r);
        this.B.setOnClickListener(this.r);
        this.C.setOnClickListener(this.r);
        this.f = (TextView) findViewById(R.id.name);
        if (this.p.d() == null) {
            this.f.setText(this.p.f());
        }
        this.g = (ImageView) findViewById(R.id.sex);
        this.h = (TextView) findViewById(R.id.intro);
        this.v = (LinearLayout) findViewById(R.id.attention);
        if (this.p.b()) {
            this.v.setVisibility(8);
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
            this.v.setVisibility(8);
        }
        this.w = (TextView) findViewById(R.id.attention_text);
        this.v.setOnClickListener(this.q);
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        k();
        if (this.p != null && this.p.d() != null) {
            this.f.setText(this.p.d().c());
            if (this.p.d().i() == 1) {
                this.g.setImageResource(R.drawable.male);
            } else if (this.p.d().i() == 2) {
                this.g.setImageResource(R.drawable.female);
            }
            this.h.setText(this.p.d().h());
            if (!this.p.b()) {
                this.m.setText(this.p.d().c());
            }
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.p.b()) {
            this.x.setVisibility(0);
            this.y.setVisibility(0);
            this.C.setVisibility(0);
            this.H.setText(R.string.my_like_forums);
            this.K.setText(R.string.my_attention);
            this.N.setText(R.string.my_fans);
            this.W.setText(R.string.my_lbs_text);
            long h = this.p.h();
            if (h > 0) {
                this.V.setVisibility(0);
                if (h > 99) {
                    h = 99;
                }
                this.V.setText(String.valueOf(h));
            } else {
                this.V.setVisibility(8);
            }
            long g = this.p.g();
            if (g > 0) {
                this.U.setVisibility(0);
                this.U.setText(String.valueOf(g <= 99 ? g : 99L));
            } else {
                this.U.setVisibility(8);
            }
        } else {
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            this.C.setVisibility(8);
            this.U.setVisibility(8);
            this.V.setVisibility(8);
            this.H.setText(R.string.hisbars);
            this.K.setText(R.string.his_attention);
            this.N.setText(R.string.his_fans);
            this.W.setText(R.string.his_lbs_text);
        }
        if (this.p.d() != null) {
            this.E.setText(String.valueOf(this.p.c()));
            this.I.setText(String.valueOf(this.p.d().l()));
            this.L.setText(String.valueOf(this.p.d().g()));
            this.O.setText(String.valueOf(this.p.d().f()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!this.p.b()) {
            if (this.p.d() != null) {
                this.v.setVisibility(0);
                if (this.p.d().m() == 1) {
                    this.v.setBackgroundResource(R.drawable.attention_cancel);
                    this.w.setText(R.string.attention_cancel);
                    return;
                }
                this.v.setBackgroundResource(R.drawable.attention);
                this.w.setText(R.string.attention);
                return;
            }
            this.v.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        String d;
        if (this.p != null && this.p.d() != null && (d = this.p.d().d()) != null && d.length() > 0) {
            Bitmap b = this.p.e().b(d);
            if (b == null) {
                this.p.e().c(d, new ba(this));
            } else {
                this.e.setImageBitmap(b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.s != null) {
            this.s.a();
        }
        if (this.Y != null) {
            this.Y.a();
        }
        if (this.p.e() != null) {
            this.p.e().b();
        }
        if (this.p.b()) {
            unregisterReceiver(this.Z);
        }
        if (this.t != null) {
            this.t.setVisibility(8);
        }
        if (this.u != null) {
            this.u.setVisibility(8);
        }
        com.baidu.tieba.c.k.b((Boolean) true);
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 101) {
            a(intent);
        }
    }

    private void a(Intent intent) {
        com.baidu.tieba.b.r rVar = (com.baidu.tieba.b.r) intent.getSerializableExtra("data");
        if (rVar != null && this.p.d() != null) {
            this.p.d().b(rVar.b());
            this.p.d().b(rVar.c());
            this.p.d().f(rVar.a());
            if (rVar.d()) {
                this.e.setImageResource(R.drawable.person_photo);
                if (this.p.d() != null) {
                    this.p.e().d(this.p.d().d());
                }
            }
            j();
            m();
        }
        a(false, false);
    }
}
