package com.baidu.tieba.kn.pk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.ap;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PKEndActivity extends com.baidu.tieba.g implements View.OnClickListener, com.baidu.adp.widget.ScrollView.n {

    /* renamed from: a  reason: collision with root package name */
    private c f1204a;
    private b b;
    private String c;
    private boolean d = false;
    private com.baidu.tieba.util.a e;

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        c();
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, PKEndActivity.class);
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
        this.e = new com.baidu.tieba.util.a(this);
        this.e.a(am.a((Context) this, 50.0f), am.a((Context) this, 50.0f));
        this.c = getIntent().getStringExtra("pk_id");
        String stringExtra = getIntent().getStringExtra("pk_title");
        setContentView(R.layout.kn_pkend_activity);
        this.f1204a = new c(this, stringExtra);
        this.f1204a.b.a(this);
        if (PKJumpActivity.f1205a != null) {
            a(PKJumpActivity.f1205a);
            PKJumpActivity.f1205a = null;
            return;
        }
        c();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f1204a.b.a(R.drawable.pk_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f1204a.b.a(0);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f1204a.b()) {
            b();
        } else if (this.d) {
            if (view.getId() == R.id.pk_left_bar_container) {
                FrsActivity.a(this, this.f1204a.f1210a.j.e, (String) null);
            } else if (view.getId() == R.id.pk_right_bar_container) {
                FrsActivity.a(this, this.f1204a.f1210a.k.e, (String) null);
            } else {
                ap.a(this, view.getId(), this.f1204a.f1210a.f1226a, new a(this));
            }
        }
    }

    protected void b() {
        finish();
    }

    protected void c() {
        this.f1204a.a().setVisibility(0);
        if (this.b != null) {
            this.b.cancel(true);
        }
        this.b = new b(this);
        this.b.setPriority(3);
        this.b.execute("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.b = null;
        try {
            this.f1204a.a(this.e, sVar);
            if (!sVar.a()) {
                this.d = true;
            }
        } catch (Throwable th) {
            a(getString(R.string.kn_data_corrupted));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (this.b != null) {
            this.b.cancel(true);
            this.b = null;
        }
        this.f1204a.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
