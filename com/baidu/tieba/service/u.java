package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
class u extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ TiebaUpdateService a;
    private String b;
    private ba c = null;
    private volatile boolean d = false;

    public u(TiebaUpdateService tiebaUpdateService, String str) {
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
        File e2;
        Handler handler;
        Boolean bool2 = false;
        while (!this.d) {
            try {
                this.c = new ba(this.b);
                handler = this.a.l;
                bool2 = Boolean.valueOf(this.c.a(String.valueOf(this.a.a) + ".tmp", handler, 900003));
                if (bool2.booleanValue()) {
                    break;
                } else if (this.c.f() == -2) {
                    bool = bool2;
                    break;
                } else if (!this.c.o()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e3) {
                    }
                }
            } catch (Exception e4) {
                bool = bool2;
                e = e4;
            }
        }
        bool = bool2;
        try {
            if (bool.booleanValue()) {
                af.j(this.a.a);
                File d = af.d(String.valueOf(this.a.a) + ".tmp");
                if (d != null && (e2 = af.e(this.a.a)) != null && !d.renameTo(e2)) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", "renameTo error");
                    cb.a("renameTo erro", "TiebaUpdateService.DownLoadingOtherAsyncTask");
                }
            }
        } catch (Exception e5) {
            e = e5;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
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
            this.c.k();
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
        super.a((u) bool);
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
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        z = this.a.j;
        if (!z) {
            this.a.j = true;
            return;
        }
        handler = this.a.k;
        handler2 = this.a.k;
        versionData = this.a.f;
        handler.sendMessageDelayed(handler2.obtainMessage(1, versionData), 100L);
    }
}
