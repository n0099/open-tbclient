package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.util.z;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
class w extends BdAsyncTask {
    final /* synthetic */ TiebaUpdateService a;
    private String b;
    private com.baidu.tieba.util.r c = null;
    private volatile boolean d = false;

    public w(TiebaUpdateService tiebaUpdateService, String str) {
        this.a = tiebaUpdateService;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        Boolean bool;
        Exception e;
        File d;
        Handler handler;
        Boolean bool2 = false;
        while (!this.d) {
            try {
                this.c = new com.baidu.tieba.util.r(this.b);
                handler = this.a.k;
                bool2 = this.c.a(String.valueOf(TiebaUpdateService.a) + ".tmp", handler, 900003);
                if (bool2.booleanValue()) {
                    break;
                } else if (this.c.e() == -2) {
                    bool = bool2;
                    break;
                } else if (!this.c.l()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                bool = bool2;
                e = e3;
            }
        }
        bool = bool2;
        try {
            if (bool.booleanValue()) {
                com.baidu.tieba.util.m.h(TiebaUpdateService.a);
                File c = com.baidu.tieba.util.m.c(String.valueOf(TiebaUpdateService.a) + ".tmp");
                if (c != null && (d = com.baidu.tieba.util.m.d(TiebaUpdateService.a)) != null && !c.renameTo(d)) {
                    z.b(getClass().getName(), "doInBackground", "renameTo error");
                }
            }
        } catch (Exception e4) {
            e = e4;
            z.b(getClass().getName(), "doInBackground", e.getMessage());
            return bool;
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.a.g = null;
        this.d = true;
        if (this.c != null) {
            this.c.h();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        boolean z;
        Handler handler;
        Handler handler2;
        VersionData versionData;
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        NotificationManager notificationManager2;
        super.a((Object) bool);
        this.a.g = null;
        try {
            if (bool.booleanValue()) {
                notificationManager2 = this.a.b;
                notificationManager2.cancel(14);
            } else {
                notification = this.a.d;
                if (notification != null) {
                    notification2 = this.a.d;
                    notification2.contentView.setTextViewText(R.id.info, this.a.getString(R.string.error_sd_error));
                    notification3 = this.a.d;
                    notification3.flags = 16;
                    notificationManager = this.a.b;
                    notification4 = this.a.d;
                    notificationManager.notify(14, notification4);
                }
            }
        } catch (Exception e) {
            z.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        z = this.a.i;
        if (!z) {
            this.a.i = true;
            return;
        }
        handler = this.a.j;
        handler2 = this.a.j;
        versionData = this.a.f;
        handler.sendMessageDelayed(handler2.obtainMessage(1, versionData), 100L);
    }
}
