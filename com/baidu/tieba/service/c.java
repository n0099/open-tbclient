package com.baidu.tieba.service;

import android.app.ActivityManager;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bf;
import java.util.Iterator;
/* loaded from: classes.dex */
class c extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DealIntentService f2307a;
    private Intent b;

    public c(DealIntentService dealIntentService, Intent intent) {
        this.f2307a = dealIntentService;
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
            String string = this.b.getExtras().getString("stat");
            String stringExtra = this.b.getStringExtra("link");
            long j = this.b.getExtras().getLong("message_id");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(stringExtra)) {
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(TiebaApplication.g().getApplicationContext(), "cl_push_noti:" + string, "msgID:" + j);
                }
                bf.a(j, 2, stringExtra);
            }
            Iterator<ActivityManager.RunningTaskInfo> it = ((ActivityManager) TiebaApplication.g().getSystemService("activity")).getRunningTasks(BdWebErrorView.ERROR_CODE_500).iterator();
            while (true) {
                if (it.hasNext()) {
                    ActivityManager.RunningTaskInfo next = it.next();
                    if (next.baseActivity.getClassName().startsWith(this.f2307a.getPackageName())) {
                        if (5 == this.b.getIntExtra("class", -1)) {
                            if (!next.topActivity.getClassName().equalsIgnoreCase(MainTabActivity.class.getName())) {
                                this.b.putExtra("class", 11);
                            }
                        } else if (10 == this.b.getIntExtra("class", -1) && !next.topActivity.getClassName().equalsIgnoreCase(MainTabActivity.class.getName())) {
                            this.b.putExtra("class", 12);
                        }
                        this.b.addFlags(268435456);
                        UtilHelper.a(this.f2307a.getBaseContext(), this.b);
                    }
                } else {
                    if (this.b.getExtras().getBoolean("is_notify", false)) {
                        a(i);
                    }
                    LogoActivity.a(this.f2307a, this.b);
                }
            }
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
                StatService.onEvent(this.f2307a.getBaseContext(), "notify_to_pk_before", "click");
                return;
            case 7:
                StatService.onEvent(this.f2307a.getBaseContext(), "notify_to_pk_end", "click");
                return;
            case 8:
                StatService.onEvent(this.f2307a.getBaseContext(), "notify_to_vote_list", "click");
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
        this.f2307a.stopSelf();
    }
}
