package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.AsyncTask;
import android.os.Handler;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ax;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.ai;
import com.baidu.tieba.c.t;
import java.io.File;
/* loaded from: classes.dex */
class q extends AsyncTask {
    final /* synthetic */ TiebaUpdateService a;
    private ax b;
    private t c = null;
    private volatile boolean d = false;

    public q(TiebaUpdateService tiebaUpdateService, ax axVar) {
        this.a = tiebaUpdateService;
        this.b = null;
        this.b = axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        Boolean bool;
        Exception e;
        File d;
        Handler handler;
        Boolean bool2 = false;
        while (!this.d) {
            try {
                this.c = new t(this.b.d());
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
                com.baidu.tieba.c.o.h(this.b.f());
                File c = com.baidu.tieba.c.o.c(String.valueOf(this.b.f()) + ".tmp");
                if (c != null && (d = com.baidu.tieba.c.o.d(this.b.f())) != null && !c.renameTo(d)) {
                    ag.b(getClass().getName(), "doInBackground", "renameTo error");
                }
            }
        } catch (Exception e4) {
            e = e4;
            ag.b(getClass().getName(), "doInBackground", e.getMessage());
            return bool;
        }
        return bool;
    }

    public void a() {
        this.a.c = null;
        this.d = true;
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        NotificationManager notificationManager2;
        super.onPostExecute(bool);
        this.a.c = null;
        try {
            if (bool.booleanValue()) {
                notificationManager2 = this.a.a;
                notificationManager2.cancel(10);
                ai.b(TiebaApplication.b(), this.b.f());
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
            ag.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.a.stopSelf();
    }
}
