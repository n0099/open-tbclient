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
class t extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ TiebaUpdateService a;
    private VersionData b;
    private ba c = null;
    private volatile boolean d = false;

    public t(TiebaUpdateService tiebaUpdateService, VersionData versionData) {
        this.a = tiebaUpdateService;
        this.b = null;
        this.b = versionData;
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
                this.c = new ba(this.b.getUrl());
                handler = this.a.k;
                bool2 = Boolean.valueOf(this.c.a(String.valueOf(this.b.getNew_file()) + ".tmp", handler, 900002));
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
                af.j(this.b.getNew_file());
                File d = af.d(String.valueOf(this.b.getNew_file()) + ".tmp");
                if (d != null && (e2 = af.e(this.b.getNew_file())) != null && !d.renameTo(e2)) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", "renameTo error");
                    cb.a("renameTo erro", "TiebaUpdateService.DownLoadingAsyncTask");
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
        this.a.e = null;
        this.d = true;
        if (this.c != null) {
            this.c.k();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        NotificationManager notificationManager2;
        Handler handler;
        Handler handler2;
        super.a((t) bool);
        this.a.e = null;
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        if (bool.booleanValue()) {
            notificationManager2 = this.a.b;
            notificationManager2.cancel(10);
            handler = this.a.k;
            handler2 = this.a.k;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.b), 100L);
            return;
        }
        notification = this.a.c;
        if (notification != null) {
            notification2 = this.a.c;
            notification2.contentView.setTextViewText(R.id.info, this.a.getString(R.string.error_sd_error));
            notification3 = this.a.c;
            notification3.flags = 16;
            notificationManager = this.a.b;
            notification4 = this.a.c;
            notificationManager.notify(10, notification4);
        }
        this.a.stopSelf();
    }
}
