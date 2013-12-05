package com.baidu.tieba;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
class w extends BdAsyncTask<String, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FileDownloader f2753a;
    private com.baidu.tieba.util.am b = null;
    private volatile boolean c = false;
    private String d;
    private String e;

    public w(FileDownloader fileDownloader, String str, String str2) {
        this.f2753a = fileDownloader;
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
                this.b = new com.baidu.tieba.util.am(this.d);
                handler = this.f2753a.d;
                bool = this.b.a(this.e + ".tmp", handler, 900002);
                if (bool.booleanValue() || this.b.e() == -2) {
                    break;
                } else if (!this.b.o()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
            }
        }
        if (bool.booleanValue()) {
            com.baidu.tieba.util.x.j(this.e);
            File d = com.baidu.tieba.util.x.d(this.e + ".tmp");
            if (d != null && (e = com.baidu.tieba.util.x.e(this.e)) != null) {
                if (!d.renameTo(e)) {
                }
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.f2753a.c = null;
        this.c = true;
        if (this.b != null) {
            this.b.j();
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
        super.a((w) bool);
        this.f2753a.c = null;
        if (bool.booleanValue()) {
            notificationManager2 = this.f2753a.f1006a;
            notificationManager2.cancel(10);
            handler = this.f2753a.d;
            handler2 = this.f2753a.d;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.e), 100L);
            return;
        }
        notification = this.f2753a.b;
        if (notification != null) {
            notification2 = this.f2753a.b;
            notification2.contentView.setTextViewText(R.id.info, this.f2753a.getString(R.string.error_sd_error));
            notification3 = this.f2753a.b;
            notification3.flags = 16;
            notificationManager = this.f2753a.f1006a;
            notification4 = this.f2753a.b;
            notificationManager.notify(10, notification4);
        }
        this.f2753a.stopSelf();
    }
}
