package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.model.co;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private d f1965a;
    private com.baidu.tieba.model.a b;
    private c c = null;

    public static void a(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1965a = new d(this, new a(this));
        this.f1965a.f();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d();
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.f1965a != null) {
            this.f1965a.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        if (this.f1965a != null) {
            this.f1965a.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b == null) {
            this.b = new com.baidu.tieba.model.a(this, new b(this));
        } else {
            this.b.cancelLoadData();
        }
        this.b.a();
        if (this.f1965a != null) {
            this.f1965a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        if (this.f1965a != null) {
            this.f1965a.e();
        }
        co coVar = obj != null ? (co) obj : null;
        if (coVar != null) {
            TiebaApplication.g().a(coVar.c());
            TiebaApplication.g().w(false);
            if (coVar.c().getHas_new_ver() == 1) {
                if (coVar.c().getForce_update() == 1) {
                    UpdateDialog.a(TiebaApplication.g(), coVar.c(), coVar.b());
                } else {
                    TiebaApplication.g().a(Long.valueOf(new Date().getTime()).longValue());
                    UpdateDialog.a(TiebaApplication.g(), coVar.c(), coVar.b());
                }
            } else {
                a(getResources().getString(R.string.neednot_update));
            }
            if (this.f1965a != null) {
                this.f1965a.f();
                return;
            }
            return;
        }
        a(getResources().getString(R.string.neterror));
    }

    private void c() {
        this.c = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
        registerReceiver(this.c, intentFilter);
    }

    private void d() {
        if (this.c != null) {
            unregisterReceiver(this.c);
        }
    }
}
