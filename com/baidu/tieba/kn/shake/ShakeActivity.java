package com.baidu.tieba.kn.shake;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.View;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.view.be;
/* loaded from: classes.dex */
public class ShakeActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private PowerManager.WakeLock f1245a = null;
    private PowerManager b = null;
    private Vibrator c = null;
    private g d = null;
    private f e = null;
    private j f = null;
    private i g = null;
    private k j = null;
    private h k = new a(this);
    private be l = new b(this);
    private DialogInterface.OnClickListener m = new c(this);
    private DialogInterface.OnDismissListener n = new d(this);

    public static void a(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, ShakeActivity.class);
        intent.putExtra("key_mode", 0);
        intent.putExtra("key_from", str4);
        intent.putExtra("key_pk_id", str);
        intent.putExtra("key_player_id", str2);
        intent.putExtra("key_player_name", str3);
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, ShakeActivity.class);
        intent.putExtra("key_mode", 1);
        intent.putExtra("key_from", str3);
        intent.putExtra("key_player_id", str);
        intent.putExtra("key_player_name", str2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f != null) {
            new Handler().postDelayed(new e(this), 1500L);
        }
        this.j.f();
    }

    private void b() {
        this.j.e();
        this.e.a();
        this.f.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        b();
        if (this.f1245a != null) {
            this.f1245a.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!this.e.b()) {
            this.g.a(1);
            k();
        } else if (!this.g.b()) {
            this.f.c();
        } else {
            this.j.g();
            this.f.a((int) this.j.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        c();
        if (this.f1245a != null) {
            this.f1245a.acquire();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        this.e.a();
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.g.a(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.g.a(true);
        this.j.a(10000L);
        this.f.d();
        this.f.e();
        if (this.c != null) {
            this.c.vibrate(200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.g.a(false);
        this.g.b(true);
        this.e.a();
        this.f.g();
        if (this.g.a() > 0) {
            if (this.g.d() == 0) {
                VoteResultActivity.a(this, this.g.e(), this.g.f(), this.g.g(), this.g.a());
            } else {
                VoteResultActivity.a(this, this.g.f(), this.g.g(), this.g.a());
            }
        }
        if (this.c != null) {
            this.c.vibrate(200L);
        }
        finish();
    }

    private void l() {
        this.j = new k(this);
        this.j.a(this.l);
        this.j.a(this.m);
        this.j.a(this.n);
    }

    private void a(Bundle bundle) {
        if (bundle == null) {
            this.g = new i(getIntent());
        } else {
            this.g = new i(bundle);
        }
        try {
            this.b = (PowerManager) getSystemService("power");
            this.f1245a = this.b.newWakeLock(26, "My Lock");
        } catch (Exception e) {
            aj.b(getClass().getName(), "initData", e.toString());
        }
        this.e = new f(this, this);
        this.d = new g();
        this.d.a(this.k);
        this.f = new j(this);
        this.c = (Vibrator) getSystemService("vibrator");
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.j.b()) {
            k();
        } else if ((view == this.j.c() || view == this.j.d()) && !this.g.b()) {
            d();
        }
    }
}
