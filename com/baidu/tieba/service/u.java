package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.bg;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.ag;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
class u extends com.baidu.adp.lib.a.a {
    final /* synthetic */ TiebaUpdateService a;
    private bg b;
    private com.baidu.tieba.d.t c = null;
    private volatile boolean d = false;

    public u(TiebaUpdateService tiebaUpdateService, bg bgVar) {
        this.a = tiebaUpdateService;
        this.b = null;
        this.b = bgVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Boolean a(String... strArr) {
        Boolean bool;
        Exception e;
        File d;
        Handler handler;
        Boolean bool2 = false;
        while (!this.d) {
            try {
                this.c = new com.baidu.tieba.d.t(this.b.d());
                handler = this.a.d;
                bool2 = this.c.a(String.valueOf(this.b.f()) + ".tmp", handler);
                if (bool2.booleanValue()) {
                    break;
                } else if (this.c.d() == -2) {
                    bool = bool2;
                    break;
                } else if (!this.c.k()) {
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
                com.baidu.tieba.d.o.h(this.b.f());
                File c = com.baidu.tieba.d.o.c(String.valueOf(this.b.f()) + ".tmp");
                if (c != null && (d = com.baidu.tieba.d.o.d(this.b.f())) != null && !c.renameTo(d)) {
                    ae.b(getClass().getName(), "doInBackground", "renameTo error");
                }
            }
        } catch (Exception e4) {
            e = e4;
            ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return bool;
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.a.c = null;
        this.d = true;
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        NotificationManager notificationManager2;
        super.a((Object) bool);
        this.a.c = null;
        try {
            if (bool.booleanValue()) {
                notificationManager2 = this.a.a;
                notificationManager2.cancel(10);
                ag.b(TiebaApplication.d(), this.b.f());
            } else {
                notification = this.a.b;
                if (notification != null) {
                    notification2 = this.a.b;
                    notification2.contentView.setTextViewText(R.id.info, this.a.getString(R.string.error_sd_error));
                    notification3 = this.a.b;
                    notification3.flags = 16;
                    notificationManager = this.a.a;
                    notification4 = this.a.b;
                    notificationManager.notify(10, notification4);
                }
            }
        } catch (Exception e) {
            ae.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.a.stopSelf();
    }
}
