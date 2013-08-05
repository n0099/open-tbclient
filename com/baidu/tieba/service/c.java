package com.baidu.tieba.service;

import android.app.ActivityManager;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.am;
/* loaded from: classes.dex */
class c extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DealIntentService f1697a;
    private Intent b;

    public c(DealIntentService dealIntentService, Intent intent) {
        this.f1697a = dealIntentService;
        this.b = null;
        this.b = intent;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        if (this.b != null && this.b.getExtras() != null) {
            int i = this.b.getExtras().getInt("class", -1);
            if (this.b.getExtras().getBoolean("is_notify", false)) {
                b(i);
            }
            if (i != 5) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) TiebaApplication.f().getSystemService("activity")).getRunningTasks(BdWebErrorView.ERROR_CODE_500)) {
                    if (runningTaskInfo.baseActivity.getClassName().startsWith(this.f1697a.getPackageName())) {
                        this.b.addFlags(268435456);
                        am.a(this.f1697a.getBaseContext(), this.b);
                        break;
                    }
                }
            }
            if (this.b.getExtras().getBoolean("is_notify", false)) {
                a(i);
            }
            LogoActivity.a(this.f1697a, this.b);
        }
        return null;
    }

    private void a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                TiebaSyncService.a("push_msg");
                return;
            case 4:
            default:
                return;
            case 5:
                TiebaSyncService.a("user_msg");
                return;
            case 6:
            case 7:
            case 8:
                TiebaSyncService.a("kuainan_msg");
                return;
            case 9:
                TiebaSyncService.a("sign_msg");
                return;
        }
    }

    private void b(int i) {
        switch (i) {
            case 6:
                StatService.onEvent(this.f1697a.getBaseContext(), "notify_to_pk_before", "click");
                return;
            case 7:
                StatService.onEvent(this.f1697a.getBaseContext(), "notify_to_pk_end", "click");
                return;
            case 8:
                StatService.onEvent(this.f1697a.getBaseContext(), "notify_to_vote_list", "click");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        this.f1697a.stopSelf();
    }
}
