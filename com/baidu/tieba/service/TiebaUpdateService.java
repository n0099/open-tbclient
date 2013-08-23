package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class TiebaUpdateService extends Service {

    /* renamed from: a  reason: collision with root package name */
    protected String f1709a = null;
    private NotificationManager b = null;
    private Notification c = null;
    private Notification d = null;
    private v e = null;
    private VersionData f = null;
    private w g = null;
    private String h = null;
    private boolean i = false;
    private Handler j = new t(this);
    private Handler k = new u(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.b = (NotificationManager) getSystemService("notification");
        this.c = a();
        this.d = a();
        if (this.b == null) {
            stopSelf();
        }
    }

    public Notification a() {
        PendingIntent activity = PendingIntent.getActivity(TiebaApplication.g(), 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = new RemoteViews(TiebaApplication.g().getPackageName(), (int) R.layout.notify_item);
        notification.contentView.setProgressBar(R.id.progress, 100, 0, false);
        notification.contentIntent = activity;
        notification.flags = 32;
        return notification;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.j.removeMessages(900002);
        this.k.removeMessages(900003);
        if (this.e != null) {
            this.e.cancel();
        }
        if (this.g != null) {
            this.g.cancel();
        }
        if (this.b != null) {
            this.b.cancel(10);
            this.b.cancel(14);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        boolean z;
        aq.a(getClass().getName(), "onStart", "onStart");
        if (intent != null && intent.getBooleanExtra("update", false)) {
            VersionData versionData = (VersionData) intent.getSerializableExtra("version");
            this.f = versionData;
            if (versionData != null) {
                this.c.contentView.setTextViewText(R.id.info, String.format(getString(R.string.tieba_downloading), this.f.getNew_version()));
                this.c.contentView.setTextViewText(R.id.schedule, "0/0");
                if (com.baidu.tieba.util.p.c(this.f.getNew_file()) != null) {
                    this.j.sendMessageDelayed(this.j.obtainMessage(1, this.f), 100L);
                } else if (this.e == null) {
                    this.e = new v(this, this.f);
                    this.e.execute(new String[0]);
                    this.c.contentView.setProgressBar(R.id.progress, 100, 0, false);
                    this.b.notify(10, this.c);
                }
                this.h = intent.getStringExtra("other_url");
                if (this.h == null || this.h.length() == 0) {
                    this.i = true;
                    z = false;
                } else {
                    z = true;
                }
                this.f1709a = a(this.h);
                if (this.f1709a == null || this.f1709a.length() < 4) {
                    this.i = true;
                    z = false;
                }
                if (z) {
                    this.d.contentView.setTextViewText(R.id.info, getString(R.string.is_downloading));
                    this.d.contentView.setTextViewText(R.id.schedule, "0/0");
                    if (com.baidu.tieba.util.p.c(this.f1709a) != null) {
                        this.k.sendMessageDelayed(this.k.obtainMessage(2, this.f), 100L);
                    } else if (this.g == null) {
                        this.g = new w(this, this.h);
                        this.g.execute(new String[0]);
                        this.d.contentView.setProgressBar(R.id.progress, 100, 0, false);
                        this.b.notify(14, this.d);
                    }
                }
            }
        }
        super.onStart(intent, i);
    }

    private String a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }
}
