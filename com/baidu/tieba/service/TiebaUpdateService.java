package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.aw;
import com.baidu.tieba.c.ae;
/* loaded from: classes.dex */
public class TiebaUpdateService extends Service {
    private NotificationManager a = null;
    private Notification b = null;
    private p c = null;
    private Handler d = new o(this);

    public Notification a() {
        PendingIntent activity = PendingIntent.getActivity(TiebaApplication.a(), 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = new RemoteViews(TiebaApplication.a().getPackageName(), (int) R.layout.notify_item);
        notification.contentView.setProgressBar(R.id.progress, 100, 0, false);
        notification.contentIntent = activity;
        notification.flags = 32;
        return notification;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.a = (NotificationManager) getSystemService("notification");
        this.b = a();
        if (this.a == null) {
            stopSelf();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.d.removeMessages(900002);
        if (this.c != null) {
            this.c.a();
        }
        if (this.a != null) {
            this.a.cancel(10);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        aw awVar;
        ae.a(getClass().getName(), "onStart", "onStart");
        if (intent != null && intent.getBooleanExtra("update", false) && (awVar = (aw) intent.getSerializableExtra("version")) != null) {
            this.b.contentView.setTextViewText(R.id.info, String.format(getString(R.string.downloading), awVar.c()));
            this.b.contentView.setTextViewText(R.id.schedule, "0/0");
            if (com.baidu.tieba.c.o.c(awVar.f()) != null) {
                this.d.sendMessageDelayed(this.d.obtainMessage(1, awVar), 100L);
            } else if (awVar != null && this.c == null) {
                this.c = new p(this, awVar);
                this.c.execute(new String[0]);
                this.b.contentView.setProgressBar(R.id.progress, 100, 0, false);
                this.a.notify(10, this.b);
            }
        }
        super.onStart(intent, i);
    }
}
