package com.baidu.tieba;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
class t extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ FileDownloader a;
    private com.baidu.tieba.util.ax b = null;
    private volatile boolean c = false;
    private String d;
    private String e;

    public t(FileDownloader fileDownloader, String str, String str2) {
        this.a = fileDownloader;
        this.d = str;
        this.e = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        File e;
        Handler handler;
        Boolean bool = false;
        while (!this.c) {
            try {
                this.b = new com.baidu.tieba.util.ax(this.d);
                handler = this.a.d;
                bool = Boolean.valueOf(this.b.a(this.e + ".tmp", handler, 900002));
                if (bool.booleanValue() || this.b.f() == -2) {
                    break;
                } else if (!this.b.p()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
            }
        }
        if (bool.booleanValue()) {
            com.baidu.tieba.util.ad.j(this.e);
            File d = com.baidu.tieba.util.ad.d(this.e + ".tmp");
            if (d != null && (e = com.baidu.tieba.util.ad.e(this.e)) != null) {
                if (!d.renameTo(e)) {
                }
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.a.c = null;
        this.c = true;
        if (this.b != null) {
            this.b.k();
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
        this.a.c = null;
        if (bool.booleanValue()) {
            notificationManager2 = this.a.a;
            notificationManager2.cancel(10);
            handler = this.a.d;
            handler2 = this.a.d;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.e), 100L);
            return;
        }
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
        this.a.stopSelf();
    }
}
