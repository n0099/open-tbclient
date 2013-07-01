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
class v extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaUpdateService f1424a;
    private VersionData b;
    private com.baidu.tieba.util.r c = null;
    private volatile boolean d = false;

    public v(TiebaUpdateService tiebaUpdateService, VersionData versionData) {
        this.f1424a = tiebaUpdateService;
        this.b = null;
        this.b = versionData;
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
                this.c = new com.baidu.tieba.util.r(this.b.getUrl());
                handler = this.f1424a.j;
                bool2 = this.c.a(String.valueOf(this.b.getNew_file()) + ".tmp", handler, 900002);
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
                com.baidu.tieba.util.m.h(this.b.getNew_file());
                File c = com.baidu.tieba.util.m.c(String.valueOf(this.b.getNew_file()) + ".tmp");
                if (c != null && (d = com.baidu.tieba.util.m.d(this.b.getNew_file())) != null && !c.renameTo(d)) {
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
        this.f1424a.e = null;
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
        super.a((Object) bool);
        this.f1424a.e = null;
        try {
        } catch (Exception e) {
            z.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        if (bool.booleanValue()) {
            notificationManager2 = this.f1424a.b;
            notificationManager2.cancel(10);
            handler = this.f1424a.j;
            handler2 = this.f1424a.j;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.b), 100L);
            return;
        }
        notification = this.f1424a.c;
        if (notification != null) {
            notification2 = this.f1424a.c;
            notification2.contentView.setTextViewText(R.id.info, this.f1424a.getString(R.string.error_sd_error));
            notification3 = this.f1424a.c;
            notification3.flags = 16;
            notificationManager = this.f1424a.b;
            notification4 = this.f1424a.c;
            notificationManager.notify(10, notification4);
        }
        this.f1424a.stopSelf();
    }
}
