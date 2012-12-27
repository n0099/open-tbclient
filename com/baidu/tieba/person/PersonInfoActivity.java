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
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class PersonInfoActivity extends com.baidu.tieba.e {
    private Button b = null;
    private Button c = null;
    private ImageView d = null;
    private TextView e = null;
    private ImageView f = null;
    private TextView g = null;
    private Button h = null;
    private Button i = null;
    private TextView j = null;
    private com.baidu.tieba.b.p k = null;
    private View.OnClickListener l = null;
    private View.OnClickListener m = null;
    private ar n = null;
    private ProgressBar o = null;
    private ProgressBar p = null;
    private LinearLayout q = null;
    private TextView r = null;
    private LinearLayout s = null;
    private LinearLayout t = null;
    private LinearLayout u = null;
    private LinearLayout v = null;
    private LinearLayout w = null;
    private TextView x = null;
    private TextView y = null;
    private TextView z = null;
    private TextView A = null;
    private TextView B = null;
    private TextView C = null;
    private TextView D = null;
    private TextView E = null;
    private TextView F = null;
    private aq G = null;
    private BroadcastReceiver H = null;

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (str == null || str.length() <= 0 || str.equals("0")) {
            return;
        }
        Intent intent = new Intent(context, PersonInfoActivity.class);
        intent.putExtra("un", str);
        intent.putExtra("name", str2);
        if (TiebaApplication.u() == null || !TiebaApplication.u().equals(str)) {
            intent.putExtra("self", false);
        } else {
            intent.putExtra("self", true);
        }
        intent.putExtra("tab_page", false);
        if (z) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void a(Intent intent) {
        com.baidu.tieba.b.o oVar = (com.baidu.tieba.b.o) intent.getSerializableExtra("data");
        if (oVar != null && this.k.d() != null) {
            this.k.d().a(oVar.b());
            this.k.d().a(oVar.c());
            this.k.d().e(oVar.a());
            if (oVar.d()) {
                this.d.setImageResource(R.drawable.person_photo);
                if (this.k.d() != null) {
                    this.k.e().d(this.k.d().d());
                }
            }
            h();
            k();
        }
        a(false, false);
    }

    private void a(Bundle bundle) {
        this.k = new com.baidu.tieba.b.p(this);
        if (bundle != null) {
            this.k.a(bundle.getBoolean("self", true));
            this.k.a(bundle.getString("un"));
            this.k.b(bundle.getString("name"));
            this.k.b(bundle.getBoolean("tab_page", false));
        } else {
            Intent intent = getIntent();
            this.k.a(intent.getBooleanExtra("self", true));
            this.k.a(intent.getStringExtra("un"));
            this.k.b(intent.getStringExtra("name"));
            this.k.b(intent.getBooleanExtra("tab_page", false));
        }
        if (this.k.b()) {
            IntentFilter intentFilter = new IntentFilter();
            this.H = new am(this);
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.H, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        if (this.n == null) {
            this.n = new ar(this, null);
            this.n.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    private void g() {
        this.o = (ProgressBar) findViewById(R.id.progress);
        this.p = (ProgressBar) findViewById(R.id.attention_progress);
        this.l = new an(this);
        this.j = (TextView) findViewById(R.id.titel_text);
        if (this.k.b()) {
            this.j.setText(R.string.person_info);
        } else if (this.k.d() == null) {
            this.j.setText(this.k.f());
        }
        this.d = (ImageView) findViewById(R.id.photo);
        this.c = (Button) findViewById(R.id.change);
        this.c.setOnClickListener(this.l);
        this.b = (Button) findViewById(R.id.back);
        this.b.setOnClickListener(this.l);
        this.h = (Button) findViewById(R.id.home);
        this.h.setOnClickListener(this.l);
        this.i = (Button) findViewById(R.id.refresh);
        this.i.setOnClickListener(this.l);
        if (this.k.b()) {
            this.c.setVisibility(0);
            if (this.k.i()) {
                this.b.setVisibility(4);
                this.h.setVisibility(8);
                this.i.setVisibility(0);
            } else {
                this.b.setVisibility(0);
                this.h.setVisibility(0);
                this.i.setVisibility(8);
            }
        } else {
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            this.h.setVisibility(0);
            this.i.setVisibility(8);
        }
        this.x = (TextView) findViewById(R.id.bookmark_number);
        this.y = (TextView) findViewById(R.id.likes_text);
        this.z = (TextView) findViewById(R.id.likes_number);
        this.A = (TextView) findViewById(R.id.my_attention_text);
        this.B = (TextView) findViewById(R.id.attention_number);
        this.C = (TextView) findViewById(R.id.fans_text);
        this.D = (TextView) findViewById(R.id.fans_number);
        this.s = (LinearLayout) findViewById(R.id.button_mention);
        this.t = (LinearLayout) findViewById(R.id.button_bookmark);
        this.u = (LinearLayout) findViewById(R.id.button_likes);
        this.v = (LinearLayout) findViewById(R.id.button_attention);
        this.w = (LinearLayout) findViewById(R.id.button_fans);
        this.E = (TextView) findViewById(R.id.new_fans_count);
        this.F = (TextView) findViewById(R.id.new_mention_count);
        this.m = new ao(this);
        this.s.setOnClickListener(this.m);
        this.t.setOnClickListener(this.m);
        this.u.setOnClickListener(this.m);
        this.v.setOnClickListener(this.m);
        this.w.setOnClickListener(this.m);
        this.e = (TextView) findViewById(R.id.name);
        if (this.k.d() == null) {
            this.e.setText(this.k.f());
        }
        this.f = (ImageView) findViewById(R.id.sex);
        this.g = (TextView) findViewById(R.id.intro);
        this.q = (LinearLayout) findViewById(R.id.attention);
        if (this.k.b()) {
            this.q.setVisibility(8);
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
            this.q.setVisibility(8);
        }
        this.r = (TextView) findViewById(R.id.attention_text);
        this.q.setOnClickListener(this.l);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        i();
        if (this.k == null || this.k.d() == null) {
            return;
        }
        this.e.setText(this.k.d().c());
        if (this.k.d().i() == 1) {
            this.f.setImageResource(R.drawable.male);
        } else if (this.k.d().i() == 2) {
            this.f.setImageResource(R.drawable.female);
        }
        this.g.setText(this.k.d().h());
        if (!this.k.b()) {
            this.j.setText(this.k.d().c());
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.k.b()) {
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            this.y.setText(R.string.my_like_forums);
            this.A.setText(R.string.my_attention);
            this.C.setText(R.string.my_fans);
            this.u.setEnabled(true);
            this.v.setEnabled(true);
            this.w.setEnabled(true);
            long h = this.k.h();
            if (h > 0) {
                this.F.setVisibility(0);
                if (h > 99) {
                    h = 99;
                }
                this.F.setText(String.valueOf(h));
            } else {
                this.F.setVisibility(8);
            }
            long g = this.k.g();
            if (g > 0) {
                this.E.setVisibility(0);
                this.E.setText(String.valueOf(g <= 99 ? g : 99L));
            } else {
                this.E.setVisibility(8);
            }
        } else {
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.y.setText(R.string.hisbars);
            this.A.setText(R.string.his_attention);
            this.C.setText(R.string.his_fans);
            this.u.setEnabled(false);
            this.v.setEnabled(false);
            this.w.setEnabled(false);
        }
        if (this.k.d() != null) {
            this.x.setText(String.valueOf(this.k.c()));
            this.z.setText(String.valueOf(this.k.d().l()));
            this.B.setText(String.valueOf(this.k.d().g()));
            this.D.setText(String.valueOf(this.k.d().f()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.k.b()) {
            return;
        }
        if (this.k.d() == null) {
            this.q.setVisibility(8);
            return;
        }
        this.q.setVisibility(0);
        if (this.k.d().m() == 1) {
            this.q.setBackgroundResource(R.drawable.attention_cancel);
            this.r.setText(R.string.attention_cancel);
            return;
        }
        this.q.setBackgroundResource(R.drawable.attention);
        this.r.setText(R.string.attention);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        String d;
        if (this.k == null || this.k.d() == null || (d = this.k.d().d()) == null || d.length() <= 0) {
            return;
        }
        Bitmap b = this.k.e().b(d);
        if (b == null) {
            this.k.e().c(d, new ap(this));
        } else {
            this.d.setImageBitmap(b);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 101) {
            a(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_info_activity);
        a(bundle);
        g();
        com.baidu.tieba.c.k.b((Boolean) true);
        if (this.k.b()) {
            a(true, true);
        } else {
            a(false, true);
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.n != null) {
            this.n.a();
        }
        if (this.G != null) {
            this.G.a();
        }
        if (this.k.e() != null) {
            this.k.e().b();
        }
        if (this.k.b()) {
            unregisterReceiver(this.H);
        }
        if (this.o != null) {
            this.o.setVisibility(8);
        }
        if (this.p != null) {
            this.p.setVisibility(8);
        }
        com.baidu.tieba.c.k.b((Boolean) true);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        if (this.k.b()) {
            this.k.a(TiebaApplication.a().U());
            this.k.c(TiebaApplication.a().S());
            this.k.b(TiebaApplication.a().T());
            if (com.baidu.tieba.c.k.q().booleanValue()) {
                this.k.a(com.baidu.tieba.c.k.r());
            }
            i();
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("self", this.k.b());
        bundle.putString("un", this.k.a());
        bundle.putBoolean("tab_page", this.k.i());
    }
}
