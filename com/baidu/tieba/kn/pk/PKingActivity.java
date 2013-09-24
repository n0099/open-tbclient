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
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ba;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PKingActivity extends com.baidu.tieba.j implements View.OnClickListener, com.baidu.adp.widget.ScrollView.n {
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
    Runnable f1272a = new o(this);

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
        n();
        this.d = new r(this);
        this.d.setPriority(3);
        this.d.execute("");
    }

    protected void c() {
        if (this.b.f1292a != null) {
            int e = (int) (this.b.f1292a.f - (this.b.f1292a.e() / 1000));
            if (e <= 0) {
                PKEndActivity.a(this, this.e, this.b.f1292a.d());
                finish();
                return;
            }
            int i = e % 60;
            int i2 = e - i;
            int i3 = (i2 % 3600) / 60;
            this.b.b.a(Math.min(99, (i2 - (i3 * 60)) / 3600), i3, i);
        }
    }

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        if (this.g) {
            a(true);
        } else {
            e();
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

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = new com.baidu.tieba.util.a(this);
        this.l.a(UtilHelper.a((Context) this, 50.0f), UtilHelper.a((Context) this, 50.0f));
        this.e = getIntent().getStringExtra("pk_id");
        String stringExtra = getIntent().getStringExtra("pk_title");
        setContentView(R.layout.kn_pking_activity);
        this.b = new t(this, stringExtra);
        this.b.b.a(this);
        if (PKJumpActivity.f1270a != null) {
            a(PKJumpActivity.f1270a);
            PKJumpActivity.f1270a = null;
            return;
        }
        e();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.b.b.a(R.drawable.pk_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
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
                StatService.onEvent(this, "pk_support_click", this.b.f1292a.f1291a);
                if (!TiebaApplication.D()) {
                    LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 20003);
                } else {
                    ShakeActivity.a(this, this.b.f1292a.f1291a, this.b.f1292a.j.f1308a, this.b.f1292a.j.b, null);
                }
            } else if (view.getId() == R.id.star2) {
                StatService.onEvent(this, "pk_support_click", "all");
                StatService.onEvent(this, "pk_support_click", this.b.f1292a.f1291a);
                if (!TiebaApplication.D()) {
                    LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 20003);
                } else {
                    ShakeActivity.a(this, this.b.f1292a.f1291a, this.b.f1292a.k.f1308a, this.b.f1292a.k.b, null);
                }
            } else if (view.getId() == R.id.pk_left_bar_container) {
                FrsActivity.a(this, this.b.f1292a.j.e, (String) null);
            } else if (view.getId() == R.id.pk_right_bar_container) {
                FrsActivity.a(this, this.b.f1292a.k.e, (String) null);
            } else {
                ba.a(this, view.getId(), this.b.f1292a.f1291a, new p(this));
            }
        }
    }

    protected void d() {
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    protected void e() {
        this.b.a().setVisibility(0);
        if (this.c != null) {
            this.c.cancel(true);
        }
        this.c = new q(this);
        this.c.setPriority(3);
        this.c.execute("");
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.c = null;
        try {
            this.b.a(this.k, this.l, sVar);
            if (sVar != null && !sVar.b()) {
                this.f = 0;
                this.g = true;
                n();
            }
        } catch (Throwable th) {
            a(getString(R.string.kn_data_corrupted));
            com.baidu.adp.lib.f.d.a(getClass(), "onDataReadyFromUIThread", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (this.c != null) {
            this.c.cancel(true);
            this.c = null;
        }
        this.b.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.k.removeCallbacks(this.f1272a);
        m();
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.g && this.f > 0) {
            this.b.a(this.k);
            a(true);
        }
        this.k.removeCallbacks(this.f1272a);
        this.k.postDelayed(this.f1272a, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.d = null;
        this.f = 0;
        if (hVar == null) {
            this.b.a(this.k, (h) null);
        } else if (!hVar.b()) {
            this.b.a(this.k, hVar);
        } else if (this.m) {
            a(hVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
    }
}
