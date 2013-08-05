package com.baidu.tieba.kn.pk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.kn.shake.ShakeActivity;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.ap;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PKingActivity extends com.baidu.tieba.g implements View.OnClickListener, com.baidu.adp.widget.ScrollView.n {
    private t b;
    private q c;
    private r d;
    private String e;
    private int f;
    private boolean j;
    private com.baidu.tieba.util.a l;
    private boolean m;
    private boolean g = false;
    private Handler k = new Handler();

    /* renamed from: a  reason: collision with root package name */
    Runnable f1207a = new o(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.f++;
        if (this.g && !this.j) {
            if (this.f % 15 == 0) {
                a(false);
            }
            c();
        }
    }

    protected void a(boolean z) {
        this.m = z;
        this.f = 0;
        m();
        this.d = new r(this);
        this.d.setPriority(3);
        this.d.execute("");
    }

    protected void c() {
        if (this.b.f1227a != null) {
            int d = (int) (this.b.f1227a.f - (this.b.f1227a.d() / 1000));
            if (d <= 0) {
                PKEndActivity.a(this, this.e, this.b.f1227a.c());
                finish();
                return;
            }
            int i = d % 60;
            int i2 = d - i;
            int i3 = (i2 % 3600) / 60;
            this.b.b.a(Math.min(99, (i2 - (i3 * 60)) / 3600), i3, i);
        }
    }

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        if (this.g) {
            a(true);
        } else {
            k();
        }
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, PKingActivity.class);
        intent.putExtra("pk_id", str);
        intent.putExtra("pk_title", str2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = new com.baidu.tieba.util.a(this);
        this.l.a(am.a((Context) this, 50.0f), am.a((Context) this, 50.0f));
        this.e = getIntent().getStringExtra("pk_id");
        String stringExtra = getIntent().getStringExtra("pk_title");
        setContentView(R.layout.kn_pking_activity);
        this.b = new t(this, stringExtra);
        this.b.b.a(this);
        if (PKJumpActivity.f1205a != null) {
            a(PKJumpActivity.f1205a);
            PKJumpActivity.f1205a = null;
            return;
        }
        k();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.b.b.a(R.drawable.pk_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        super.onStop();
        this.b.b.a(0);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.b()) {
            d();
        } else if (this.g) {
            if (view.getId() == R.id.star1) {
                StatService.onEvent(this, "pk_support_click", "all");
                StatService.onEvent(this, "pk_support_click", this.b.f1227a.f1226a);
                if (!TiebaApplication.F()) {
                    LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 20003);
                } else {
                    ShakeActivity.a(this, this.b.f1227a.f1226a, this.b.f1227a.j.f1243a, this.b.f1227a.j.b, null);
                }
            } else if (view.getId() == R.id.star2) {
                StatService.onEvent(this, "pk_support_click", "all");
                StatService.onEvent(this, "pk_support_click", this.b.f1227a.f1226a);
                if (!TiebaApplication.F()) {
                    LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 20003);
                } else {
                    ShakeActivity.a(this, this.b.f1227a.f1226a, this.b.f1227a.k.f1243a, this.b.f1227a.k.b, null);
                }
            } else if (view.getId() == R.id.pk_left_bar_container) {
                FrsActivity.a(this, this.b.f1227a.j.e, (String) null);
            } else if (view.getId() == R.id.pk_right_bar_container) {
                FrsActivity.a(this, this.b.f1227a.k.e, (String) null);
            } else {
                ap.a(this, view.getId(), this.b.f1227a.f1226a, new p(this));
            }
        }
    }

    protected void d() {
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    protected void k() {
        this.b.a().setVisibility(0);
        if (this.c != null) {
            this.c.cancel(true);
        }
        this.c = new q(this);
        this.c.setPriority(3);
        this.c.execute("");
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.c = null;
        try {
            this.b.a(this.k, this.l, sVar);
            if (sVar != null && !sVar.a()) {
                this.f = 0;
                this.g = true;
                m();
            }
        } catch (Throwable th) {
            a(getString(R.string.kn_data_corrupted));
            com.baidu.adp.lib.e.d.a(getClass(), "onDataReadyFromUIThread", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        if (this.c != null) {
            this.c.cancel(true);
            this.c = null;
        }
        this.b.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        this.k.removeCallbacks(this.f1207a);
        l();
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.g && this.f > 0) {
            this.b.a(this.k);
            a(true);
        }
        this.k.removeCallbacks(this.f1207a);
        this.k.postDelayed(this.f1207a, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.d = null;
        this.f = 0;
        if (hVar == null) {
            this.b.a(this.k, (h) null);
        } else if (!hVar.a()) {
            this.b.a(this.k, hVar);
        } else if (this.m) {
            a(hVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
    }
}
