package com.baidu.tieba.service;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ai;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.PbActivity;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends AsyncTask {
    final /* synthetic */ DealIntentService a;
    private Intent b;

    public c(DealIntentService dealIntentService, Intent intent) {
        this.a = dealIntentService;
        this.b = null;
        this.b = intent;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        Iterator<ActivityManager.RunningTaskInfo> it = ((ActivityManager) TiebaApplication.b().getSystemService("activity")).getRunningTasks(BdWebErrorView.ERROR_CODE_500).iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().baseActivity.getClassName().startsWith(this.a.getPackageName())) {
                    switch (this.b.getExtras().getInt("class", -1)) {
                        case 0:
                            ai.c(this.a, this.b.getExtras().getString("url"));
                            break;
                        case 1:
                            if (this.b.getBooleanExtra("is_message_pv", false)) {
                                PbActivity.a((Context) this.a, this.b.getStringExtra("id"), true, this.b.getLongExtra("message_id", 0L));
                                break;
                            } else {
                                PbActivity.a(this.a, this.b.getStringExtra("id"), this.b.getStringExtra("from"));
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
                }
            } else {
                LogoActivity.a(this.a, this.b);
                break;
            }
        }
        return null;
    }

    public void a() {
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        this.a.stopSelf();
    }
}
