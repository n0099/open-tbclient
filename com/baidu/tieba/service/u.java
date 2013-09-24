package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.z;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
class u extends BdAsyncTask<String, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaUpdateService f1804a;
    private String b;
    private z c = null;
    private volatile boolean d = false;

    public u(TiebaUpdateService tiebaUpdateService, String str) {
        this.f1804a = tiebaUpdateService;
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
                this.c = new z(this.b);
                handler = this.f1804a.k;
                bool2 = this.c.a(String.valueOf(this.f1804a.f1783a) + ".tmp", handler, 900003);
                if (bool2.booleanValue()) {
                    break;
                } else if (this.c.e() == -2) {
                    bool = bool2;
                    break;
                } else if (!this.c.m()) {
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
                com.baidu.tieba.util.p.i(this.f1804a.f1783a);
                File c = com.baidu.tieba.util.p.c(String.valueOf(this.f1804a.f1783a) + ".tmp");
                if (c != null && (d = com.baidu.tieba.util.p.d(this.f1804a.f1783a)) != null && !c.renameTo(d)) {
                    av.b(getClass().getName(), "doInBackground", "renameTo error");
                }
            }
        } catch (Exception e4) {
            e = e4;
            av.b(getClass().getName(), "doInBackground", e.getMessage());
            return bool;
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.f1804a.g = null;
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
        super.a((u) bool);
        this.f1804a.g = null;
        try {
            if (bool.booleanValue()) {
                notificationManager2 = this.f1804a.b;
                notificationManager2.cancel(14);
            } else {
                notification = this.f1804a.d;
                if (notification != null) {
                    notification2 = this.f1804a.d;
                    notification2.contentView.setTextViewText(R.id.info, this.f1804a.getString(R.string.error_sd_error));
                    notification3 = this.f1804a.d;
                    notification3.flags = 16;
                    notificationManager = this.f1804a.b;
                    notification4 = this.f1804a.d;
                    notificationManager.notify(14, notification4);
                }
            }
        } catch (Exception e) {
            av.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        z = this.f1804a.i;
        if (!z) {
            this.f1804a.i = true;
            return;
        }
        handler = this.f1804a.j;
        handler2 = this.f1804a.j;
        versionData = this.f1804a.f;
        handler.sendMessageDelayed(handler2.obtainMessage(1, versionData), 100L);
    }
}
