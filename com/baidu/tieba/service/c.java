package com.baidu.tieba.service;

import android.app.ActivityManager;
import android.content.Intent;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.d.ag;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class c extends com.baidu.adp.lib.a.a {
    final /* synthetic */ DealIntentService a;
    private Intent b;

    public c(DealIntentService dealIntentService, Intent intent) {
        this.a = dealIntentService;
        this.b = null;
        this.b = intent;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        int i = this.b.getExtras().getInt("class", -1);
        if (i != 5) {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) TiebaApplication.d().getSystemService("activity")).getRunningTasks(BdWebErrorView.ERROR_CODE_500)) {
                if (runningTaskInfo.baseActivity.getClassName().startsWith(this.a.getPackageName())) {
                    switch (i) {
                        case 0:
                            ag.c(this.a, this.b.getExtras().getString("url"));
                            break;
                        case 1:
                            if (this.b.getBooleanExtra("is_message_pv", false)) {
                                NewPbActivity.a(this.a, this.b.getStringExtra("id"), null, this.b.getStringExtra("from"), this.b.getLongExtra("message_id", 0L));
                                break;
                            } else {
                                NewPbActivity.a(this.a, this.b.getStringExtra("id"), null, this.b.getStringExtra("from"));
                                break;
                            }
                        case 2:
                            FrsActivity.a(this.a, this.b.getStringExtra("fname"), this.b.getStringExtra("from"));
                            break;
                        case 3:
                            this.b.setClass(this.a, MainTabActivity.class);
                            this.b.addFlags(268435456);
                            this.a.startActivity(this.b);
                            break;
                    }
                    return null;
                }
            }
        }
        LogoActivity.a(this.a, this.b);
        return null;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        this.a.stopSelf();
    }
}
