package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.x;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
class v extends BdAsyncTask<String, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaUpdateService f2460a;
    private String b;
    private am c = null;
    private volatile boolean d = false;

    public v(TiebaUpdateService tiebaUpdateService, String str) {
        this.f2460a = tiebaUpdateService;
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
                this.c = new am(this.b);
                handler = this.f2460a.l;
                bool2 = this.c.a(this.f2460a.f2439a + ".tmp", handler, 900003);
                if (bool2.booleanValue()) {
                    break;
                } else if (this.c.e() == -2) {
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
                x.j(this.f2460a.f2439a);
                File d = x.d(this.f2460a.f2439a + ".tmp");
                if (d != null && (e2 = x.e(this.f2460a.f2439a)) != null && !d.renameTo(e2)) {
                    bd.b(getClass().getName(), "doInBackground", "renameTo error");
                }
            }
        } catch (Exception e5) {
            e = e5;
            bd.b(getClass().getName(), "doInBackground", e.getMessage());
            return bool;
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.f2460a.g = null;
        this.d = true;
        if (this.c != null) {
            this.c.j();
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
        this.f2460a.g = null;
        try {
            if (bool.booleanValue()) {
                notificationManager2 = this.f2460a.b;
                notificationManager2.cancel(14);
            } else {
                notification = this.f2460a.d;
                if (notification != null) {
                    notification2 = this.f2460a.d;
                    notification2.contentView.setTextViewText(R.id.info, this.f2460a.getString(R.string.error_sd_error));
                    notification3 = this.f2460a.d;
                    notification3.flags = 16;
                    notificationManager = this.f2460a.b;
                    notification4 = this.f2460a.d;
                    notificationManager.notify(14, notification4);
                }
            }
        } catch (Exception e) {
            bd.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        z = this.f2460a.j;
        if (z) {
            handler = this.f2460a.k;
            handler2 = this.f2460a.k;
            versionData = this.f2460a.f;
            handler.sendMessageDelayed(handler2.obtainMessage(1, versionData), 100L);
            return;
        }
        this.f2460a.j = true;
    }
}
