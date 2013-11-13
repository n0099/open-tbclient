package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.model.ch;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private d f1956a;
    private com.baidu.tieba.model.a b;
    private c c = null;
    private String d = com.baidu.tieba.data.h.b + "mo/q/topic_page/110_1";

    public static void a(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1956a = new d(this, new a(this));
        this.f1956a.f();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f1956a != null) {
            this.f1956a.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c();
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.f1956a != null) {
            this.f1956a.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.f1956a != null) {
            this.f1956a.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.b == null) {
            this.b = new com.baidu.tieba.model.a(this, new b(this));
        } else {
            this.b.cancelLoadData();
        }
        this.b.a();
        if (this.f1956a != null) {
            this.f1956a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        if (this.f1956a != null) {
            this.f1956a.e();
        }
        ch chVar = obj != null ? (ch) obj : null;
        if (chVar != null) {
            TiebaApplication.g().a(chVar.c());
            TiebaApplication.g().w(false);
            if (chVar.c().getHas_new_ver() == 1) {
                if (chVar.c().getForce_update() == 1) {
                    UpdateDialog.a(TiebaApplication.g(), chVar.c(), chVar.b());
                } else {
                    TiebaApplication.g().a(Long.valueOf(new Date().getTime()).longValue());
                    UpdateDialog.a(TiebaApplication.g(), chVar.c(), chVar.b());
                }
            } else {
                showToast(getResources().getString(R.string.neednot_update));
            }
            if (this.f1956a != null) {
                this.f1956a.f();
                return;
            }
            return;
        }
        showToast(getResources().getString(R.string.neterror));
    }

    private void b() {
        this.c = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
        registerReceiver(this.c, intentFilter);
    }

    private void c() {
        if (this.c != null) {
            unregisterReceiver(this.c);
        }
    }
}
