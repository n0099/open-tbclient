package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.w;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
class u extends BdAsyncTask<String, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaUpdateService f2324a;
    private VersionData b;
    private ag c = null;
    private volatile boolean d = false;

    public u(TiebaUpdateService tiebaUpdateService, VersionData versionData) {
        this.f2324a = tiebaUpdateService;
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
                this.c = new ag(this.b.getUrl());
                handler = this.f2324a.j;
                bool2 = this.c.a(this.b.getNew_file() + ".tmp", handler, 900002);
                if (bool2.booleanValue()) {
                    break;
                } else if (this.c.e() == -2) {
                    bool = bool2;
                    break;
                } else if (!this.c.m()) {
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
                w.j(this.b.getNew_file());
                File d = w.d(this.b.getNew_file() + ".tmp");
                if (d != null && (e2 = w.e(this.b.getNew_file())) != null && !d.renameTo(e2)) {
                    be.b(getClass().getName(), "doInBackground", "renameTo error");
                }
            }
        } catch (Exception e5) {
            e = e5;
            be.b(getClass().getName(), "doInBackground", e.getMessage());
            return bool;
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.f2324a.e = null;
        this.d = true;
        if (this.c != null) {
            this.c.h();
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
        super.a((u) bool);
        this.f2324a.e = null;
        try {
        } catch (Exception e) {
            be.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        if (bool.booleanValue()) {
            notificationManager2 = this.f2324a.b;
            notificationManager2.cancel(10);
            handler = this.f2324a.j;
            handler2 = this.f2324a.j;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.b), 100L);
            return;
        }
        notification = this.f2324a.c;
        if (notification != null) {
            notification2 = this.f2324a.c;
            notification2.contentView.setTextViewText(R.id.info, this.f2324a.getString(R.string.error_sd_error));
            notification3 = this.f2324a.c;
            notification3.flags = 16;
            notificationManager = this.f2324a.b;
            notification4 = this.f2324a.c;
            notificationManager.notify(10, notification4);
        }
        this.f2324a.stopSelf();
    }
}
