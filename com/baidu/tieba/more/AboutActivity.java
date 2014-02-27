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
        this.a.e();
        this.c = new c(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tieba.data.i.a());
        registerReceiver(this.c, intentFilter);
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.e();
        }
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            unregisterReceiver(this.c);
        }
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.a != null) {
            this.a.d();
        }
    }

    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public static /* synthetic */ void b(AboutActivity aboutActivity) {
        if (aboutActivity.b == null) {
            aboutActivity.b = new com.baidu.tieba.model.a(aboutActivity, new b(aboutActivity));
        } else {
            aboutActivity.b.cancelLoadData();
        }
        aboutActivity.b.a();
        if (aboutActivity.a != null) {
            aboutActivity.a.a();
        }
    }

    public static /* synthetic */ void a(AboutActivity aboutActivity, Object obj) {
        if (aboutActivity.a != null) {
            aboutActivity.a.d();
        }
        bw bwVar = obj != null ? (bw) obj : null;
        if (bwVar == null) {
            aboutActivity.showToast(aboutActivity.getResources().getString(R.string.neterror));
            return;
        }
        TiebaApplication.g().a(bwVar.c());
        TiebaApplication.g().w(false);
        if (bwVar.c().getHas_new_ver() != 1) {
            aboutActivity.showToast(aboutActivity.getResources().getString(R.string.neednot_update));
        } else if (bwVar.c().getForce_update() == 1) {
            UpdateDialog.a(TiebaApplication.g().b(), bwVar.c(), bwVar.b());
        } else {
            TiebaApplication.g().a(Long.valueOf(new Date().getTime()).longValue());
            UpdateDialog.a(TiebaApplication.g().b(), bwVar.c(), bwVar.b());
        }
        if (aboutActivity.a != null) {
            aboutActivity.a.e();
        }
    }
}
