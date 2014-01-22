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
import com.baidu.tieba.util.ad;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class TiebaUpdateService extends Service {
    private static boolean h = false;
    protected String a = null;
    private NotificationManager b = null;
    private Notification c = null;
    private Notification d = null;
    private u e = null;
    private VersionData f = null;
    private v g = null;
    private String i = null;
    private boolean j = false;
    private Handler k = new s(this);
    private Handler l = new t(this);

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
        PendingIntent activity = PendingIntent.getActivity(TiebaApplication.h(), 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = new RemoteViews(TiebaApplication.h().getPackageName(), (int) R.layout.notify_item);
        notification.contentView.setProgressBar(R.id.progress, 100, 0, false);
        notification.contentIntent = activity;
        notification.flags = 32;
        return notification;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.k.removeMessages(900002);
        this.l.removeMessages(900003);
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
        h = false;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        boolean z;
        com.baidu.adp.lib.g.e.a(getClass().getName(), "onStart", "onStart");
        if (!h) {
            h = true;
            if (intent != null && intent.getBooleanExtra("update", false)) {
                VersionData versionData = (VersionData) intent.getSerializableExtra("version");
                this.f = versionData;
                if (versionData != null) {
                    this.c.contentView.setTextViewText(R.id.info, String.format(getString(R.string.tieba_downloading), this.f.getNew_version()));
                    this.c.contentView.setTextViewText(R.id.schedule, "0/0");
                    if (ad.d(this.f.getNew_file()) != null) {
                        this.k.sendMessageDelayed(this.k.obtainMessage(1, this.f), 100L);
                    } else if (this.e == null) {
                        this.e = new u(this, this.f);
                        this.e.execute(new String[0]);
                        this.c.contentView.setProgressBar(R.id.progress, 100, 0, false);
                        this.b.notify(10, this.c);
                    }
                    this.i = intent.getStringExtra("other_url");
                    if (this.i == null || this.i.length() == 0) {
                        this.j = true;
                        z = false;
                    } else {
                        z = true;
                    }
                    this.a = a(this.i);
                    if (this.a == null || this.a.length() < 4) {
                        this.j = true;
                        z = false;
                    }
                    if (z) {
                        this.d.contentView.setTextViewText(R.id.info, getString(R.string.is_downloading));
                        this.d.contentView.setTextViewText(R.id.schedule, "0/0");
                        if (ad.d(this.a) != null) {
                            this.l.sendMessageDelayed(this.l.obtainMessage(2, this.f), 100L);
                        } else if (this.g == null) {
                            this.g = new v(this, this.i);
                            this.g.execute(new String[0]);
                            this.d.contentView.setProgressBar(R.id.progress, 100, 0, false);
                            this.b.notify(14, this.d);
                        }
                    }
                }
            }
            super.onStart(intent, i);
        }
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
