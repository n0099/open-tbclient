package com.baidu.tieba;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
final class n extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ FileDownloader a;
    private com.baidu.tieba.util.ba b = null;
    private volatile boolean c = false;
    private String d;
    private String e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Boolean a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        NotificationManager notificationManager2;
        Handler handler;
        Handler handler2;
        Boolean bool2 = bool;
        super.a((n) bool2);
        this.a.c = null;
        if (bool2.booleanValue()) {
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

    public n(FileDownloader fileDownloader, String str, String str2) {
        this.a = fileDownloader;
        this.d = str;
        this.e = str2;
    }

    private Boolean d() {
        File e;
        Handler handler;
        Boolean bool = false;
        while (!this.c) {
            try {
                this.b = new com.baidu.tieba.util.ba(this.d);
                handler = this.a.d;
                bool = Boolean.valueOf(this.b.a(String.valueOf(this.e) + ".tmp", handler, 900002));
                if (bool.booleanValue() || this.b.e() == -2) {
                    break;
                } else if (!this.b.n()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
            }
        }
        if (bool.booleanValue()) {
            com.baidu.tieba.util.af.j(this.e);
            File d = com.baidu.tieba.util.af.d(String.valueOf(this.e) + ".tmp");
            if (d != null && (e = com.baidu.tieba.util.af.e(this.e)) != null) {
                d.renameTo(e);
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        this.a.c = null;
        this.c = true;
        if (this.b != null) {
            this.b.j();
        }
    }
}
