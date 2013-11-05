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
class v extends BdAsyncTask<String, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaUpdateService f2325a;
    private String b;
    private ag c = null;
    private volatile boolean d = false;

    public v(TiebaUpdateService tiebaUpdateService, String str) {
        this.f2325a = tiebaUpdateService;
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
                this.c = new ag(this.b);
                handler = this.f2325a.k;
                bool2 = this.c.a(this.f2325a.f2304a + ".tmp", handler, 900003);
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
                w.j(this.f2325a.f2304a);
                File d = w.d(this.f2325a.f2304a + ".tmp");
                if (d != null && (e2 = w.e(this.f2325a.f2304a)) != null && !d.renameTo(e2)) {
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
        this.f2325a.g = null;
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
        super.a((v) bool);
        this.f2325a.g = null;
        try {
            if (bool.booleanValue()) {
                notificationManager2 = this.f2325a.b;
                notificationManager2.cancel(14);
            } else {
                notification = this.f2325a.d;
                if (notification != null) {
                    notification2 = this.f2325a.d;
                    notification2.contentView.setTextViewText(R.id.info, this.f2325a.getString(R.string.error_sd_error));
                    notification3 = this.f2325a.d;
                    notification3.flags = 16;
                    notificationManager = this.f2325a.b;
                    notification4 = this.f2325a.d;
                    notificationManager.notify(14, notification4);
                }
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        z = this.f2325a.i;
        if (z) {
            handler = this.f2325a.j;
            handler2 = this.f2325a.j;
            versionData = this.f2325a.f;
            handler.sendMessageDelayed(handler2.obtainMessage(1, versionData), 100L);
            return;
        }
        this.f2325a.i = true;
    }
}
