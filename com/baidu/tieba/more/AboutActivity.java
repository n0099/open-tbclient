package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.model.bd;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity {
    private d a;
    private com.baidu.tieba.model.a b;
    private c c = null;
    private String d = String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/topic_page/110_1";

    public static void a(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new d(this, new a(this));
        this.a.c();
        b();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.c();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c();
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
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
            this.a.b();
        }
        bd bdVar = obj != null ? (bd) obj : null;
        if (bdVar != null) {
            com.baidu.tieba.ai.c().a(bdVar.c());
            TbadkApplication.m252getInst().refreshNewVersion(false);
            if (bdVar.c().hasNewVer()) {
                if (bdVar.c().forceUpdate()) {
                    UpdateDialog.a(com.baidu.tieba.ai.c().d(), bdVar.c(), bdVar.b());
                } else {
                    TbadkApplication.m252getInst().setUpdateNotifyTime(Long.valueOf(new Date().getTime()).longValue());
                    UpdateDialog.a(com.baidu.tieba.ai.c().d(), bdVar.c(), bdVar.b());
                }
            } else {
                showToast(getResources().getString(com.baidu.tieba.y.neednot_update));
            }
            if (this.a != null) {
                this.a.c();
                return;
            }
            return;
        }
        showToast(getResources().getString(com.baidu.tieba.y.neterror));
    }

    private void b() {
        this.c = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.c, intentFilter);
    }

    private void c() {
        if (this.c != null) {
            unregisterReceiver(this.c);
        }
    }
}
