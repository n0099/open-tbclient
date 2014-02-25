package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.model.bw;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends com.baidu.tieba.f {
    private d a;
    private com.baidu.tieba.model.a b;
    private c c = null;
    private String d = String.valueOf(com.baidu.tieba.data.i.b) + "mo/q/topic_page/110_1";

    public static void a(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new d(this, new a(this));
        this.a.f();
        b();
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.f();
        }
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c();
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.a != null) {
            this.a.e();
        }
    }

    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public void a() {
        if (this.b == null) {
            this.b = new com.baidu.tieba.model.a(this, new b(this));
        } else {
            this.b.cancelLoadData();
        }
        this.b.a();
        if (this.a != null) {
            this.a.a();
        }
    }

    public void a(Object obj) {
        if (this.a != null) {
            this.a.e();
        }
        bw bwVar = obj != null ? (bw) obj : null;
        if (bwVar != null) {
            TiebaApplication.g().a(bwVar.c());
            TiebaApplication.g().x(false);
            if (bwVar.c().getHas_new_ver() == 1) {
                if (bwVar.c().getForce_update() == 1) {
                    UpdateDialog.a(TiebaApplication.g().b(), bwVar.c(), bwVar.b());
                } else {
                    TiebaApplication.g().a(Long.valueOf(new Date().getTime()).longValue());
                    UpdateDialog.a(TiebaApplication.g().b(), bwVar.c(), bwVar.b());
                }
            } else {
                showToast(getResources().getString(R.string.neednot_update));
            }
            if (this.a != null) {
                this.a.f();
                return;
            }
            return;
        }
        showToast(getResources().getString(R.string.neterror));
    }

    private void b() {
        this.c = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tieba.data.i.a());
        registerReceiver(this.c, intentFilter);
    }

    private void c() {
        if (this.c != null) {
            unregisterReceiver(this.c);
        }
    }
}
