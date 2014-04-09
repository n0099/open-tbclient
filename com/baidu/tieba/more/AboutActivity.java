package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.model.bb;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends com.baidu.tbadk.a {
    private d a;
    private com.baidu.tieba.model.a b;
    private c c = null;
    private String d = String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/topic_page/110_1";

    public static void a(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new d(this, new a(this));
        this.a.e();
        this.c = new c(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tbadk.core.data.n.z());
        registerReceiver(this.c, intentFilter);
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.e();
        }
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
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

    @Override // com.baidu.tbadk.a
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
        bb bbVar = obj != null ? (bb) obj : null;
        if (bbVar == null) {
            aboutActivity.showToast(aboutActivity.getResources().getString(com.baidu.tieba.a.k.neterror));
            return;
        }
        com.baidu.tieba.p.c().a(bbVar.c());
        TbadkApplication.j().k(false);
        if (bbVar.c().getHas_new_ver() != 1) {
            aboutActivity.showToast(aboutActivity.getResources().getString(com.baidu.tieba.a.k.neednot_update));
        } else if (bbVar.c().getForce_update() == 1) {
            com.baidu.tieba.p.c();
            UpdateDialog.a(com.baidu.tieba.p.d(), bbVar.c(), bbVar.b());
        } else {
            Long valueOf = Long.valueOf(new Date().getTime());
            TbadkApplication.j();
            TbadkApplication.a(valueOf.longValue());
            com.baidu.tieba.p.c();
            UpdateDialog.a(com.baidu.tieba.p.d(), bbVar.c(), bbVar.b());
        }
        if (aboutActivity.a != null) {
            aboutActivity.a.e();
        }
    }
}
