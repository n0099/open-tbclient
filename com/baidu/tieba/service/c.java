package com.baidu.tieba.service;

import android.app.ActivityManager;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.as;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ DealIntentService a;
    private Intent b;

    public c(DealIntentService dealIntentService, Intent intent) {
        this.a = dealIntentService;
        this.b = null;
        this.b = intent;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        String str2;
        if (this.b == null || this.b.getExtras() == null) {
            return null;
        }
        int i = this.b.getExtras().getInt("class", -1);
        if (this.b.getExtras().getBoolean("is_notify", false)) {
            b(i);
        }
        String string = this.b.getExtras().getString("stat");
        String stringExtra = this.b.getStringExtra("link");
        long j = this.b.getExtras().getLong("message_id");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(stringExtra)) {
            by.a(TiebaApplication.h().getApplicationContext(), "cl_push_noti:" + string, "msgID:" + j);
            by.a(j, 2, stringExtra, string);
        }
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) TiebaApplication.h().getSystemService("activity")).getRunningTasks(500)) {
            if (runningTaskInfo.baseActivity.getClassName().startsWith(this.a.getPackageName())) {
                com.baidu.adp.lib.g.e.d("see noti goto maintab app active");
                if (5 == this.b.getIntExtra("class", -1)) {
                    com.baidu.adp.lib.g.e.d("see noti goto maintab");
                    if (!runningTaskInfo.topActivity.getClassName().equalsIgnoreCase(MainTabActivity.class.getName())) {
                        com.baidu.adp.lib.g.e.d("see noti goto maintab new");
                        this.b.putExtra("class", 11);
                    }
                } else if (10 == this.b.getIntExtra("class", -1)) {
                    this.b.putExtra("class", 12);
                }
                str2 = DealIntentService.b;
                return str2;
            }
        }
        if (this.b.getExtras().getBoolean("is_notify", false)) {
            a(i);
        }
        com.baidu.adp.lib.g.e.d("see noti goto maintab app not active");
        str = DealIntentService.c;
        return str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        String str2;
        String str3;
        if (str != null) {
            str2 = DealIntentService.b;
            if (!str.equals(str2)) {
                str3 = DealIntentService.c;
                if (str.equals(str3)) {
                    LogoActivity.a(this.a, this.b);
                }
            } else {
                this.b.addFlags(268435456);
                UtilHelper.a(this.a.getBaseContext(), this.b);
            }
        }
        this.a.stopSelf();
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
            case 10:
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
                by.a(this.a.getBaseContext(), "notify_to_pk_before", "click");
                return;
            case 7:
                by.a(this.a.getBaseContext(), "notify_to_pk_end", "click");
                return;
            case 8:
                by.a(this.a.getBaseContext(), "notify_to_vote_list", "click");
                return;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return;
            case 14:
                as.a(this.a.getBaseContext(), "notify_group_event_click");
                return;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
    }
}
