package com.baidu.tieba.kn.pk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bj;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PKWaitingActivity extends com.baidu.tieba.j implements View.OnClickListener, com.baidu.adp.widget.ScrollView.o {
    private l b;
    private k c;
    private String d;
    private boolean f;
    private com.baidu.tieba.util.a j;
    private boolean e = false;
    private Handler g = new Handler();

    /* renamed from: a  reason: collision with root package name */
    Runnable f1766a = new i(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.e && !this.f) {
            c();
        }
    }

    protected void c() {
        if (this.b.f1779a != null && !this.b.f1779a.g()) {
            if (this.b.f1779a.f()) {
                PKEndActivity.a(this, this.d, this.b.f1779a.d());
            } else {
                PKingActivity.a(this, this.d, this.b.f1779a.d());
            }
            finish();
        }
    }

    @Override // com.baidu.adp.widget.ScrollView.o
    public void a() {
        e();
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, PKWaitingActivity.class);
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
        this.j = new com.baidu.tieba.util.a(this);
        this.j.a(UtilHelper.a((Context) this, 50.0f), UtilHelper.a((Context) this, 50.0f));
        this.d = getIntent().getStringExtra("pk_id");
        String stringExtra = getIntent().getStringExtra("pk_title");
        setContentView(R.layout.kn_pkwaiting_activity);
        this.b = new l(this, stringExtra);
        this.b.b.a(this);
        if (PKJumpActivity.f1765a != null) {
            a(PKJumpActivity.f1765a);
            PKJumpActivity.f1765a = null;
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
        } else if (this.e) {
            if (view.getId() == R.id.pk_left_bar_container) {
                FrsActivity.a(this, this.b.f1779a.j.e, (String) null);
            } else if (view.getId() == R.id.pk_right_bar_container) {
                FrsActivity.a(this, this.b.f1779a.k.e, (String) null);
            } else {
                bj.a(this, view.getId(), this.b.f1779a.f1786a, new j(this));
            }
        }
    }

    protected void d() {
        finish();
    }

    protected void e() {
        this.b.a().setVisibility(0);
        if (this.c != null) {
            this.c.cancel(true);
        }
        this.c = new k(this);
        this.c.setPriority(3);
        this.c.execute("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.c = null;
        try {
            this.b.a(this.j, sVar);
            if (!sVar.b()) {
                this.e = true;
            }
        } catch (Throwable th) {
            a(getString(R.string.kn_data_corrupted));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
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
        this.g.removeCallbacks(this.f1766a);
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.g.postDelayed(this.f1766a, 1000L);
    }
}
