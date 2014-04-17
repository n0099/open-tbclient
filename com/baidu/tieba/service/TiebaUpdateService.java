package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public class TiebaUpdateService extends Service {
    private static boolean g = false;
    protected String a = null;
    private NotificationManager b = null;
    private Notification c = null;
    private r d = null;
    private VersionData e = null;
    private s f = null;
    private String h = null;
    private boolean i = false;
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private boolean n = false;
    private int o = 0;
    private int p = 0;
    private long q = 0;
    private long r = 0;
    private boolean s = false;
    private boolean t = false;
    private Handler u = new p(this);
    private Handler v = new q(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(TiebaUpdateService tiebaUpdateService, long j, long j2) {
        if (j2 != 0) {
            tiebaUpdateService.c.contentView.setProgressBar(com.baidu.tieba.a.h.progress, 100, (int) ((100 * j) / j2), false);
            StringBuffer stringBuffer = new StringBuffer(20);
            stringBuffer.append(String.valueOf(j / 1000));
            stringBuffer.append("K/");
            stringBuffer.append(String.valueOf(j2 / 1000));
            stringBuffer.append("K");
            tiebaUpdateService.c.contentView.setTextViewText(com.baidu.tieba.a.h.schedule, stringBuffer);
            tiebaUpdateService.b.notify(10, tiebaUpdateService.c);
        }
    }

    public final void a(int i) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.NewsVersion");
        intent.putExtra("progress", i);
        sendBroadcast(intent);
    }

    public final void a(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.NewsVersion");
        intent.putExtra(str, str2);
        sendBroadcast(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.b = (NotificationManager) getSystemService("notification");
        com.baidu.tieba.p.c();
        PendingIntent activity = PendingIntent.getActivity(com.baidu.tieba.p.d(), 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        com.baidu.tieba.p.c();
        notification.contentView = new RemoteViews(com.baidu.tieba.p.d().getPackageName(), com.baidu.tieba.a.i.notify_item);
        notification.contentView.setProgressBar(com.baidu.tieba.a.h.progress, 100, 0, false);
        notification.contentIntent = activity;
        notification.flags = 32;
        this.c = notification;
        if (this.b == null) {
            stopSelf();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.t = false;
        this.u.removeMessages(900002);
        this.v.removeMessages(900003);
        if (this.d != null) {
            this.d.cancel();
        }
        if (this.f != null) {
            this.f.cancel();
        }
        if (this.b != null) {
            this.b.cancel(10);
        }
        g = false;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        boolean z;
        String str;
        boolean z2;
        String[] split;
        this.t = true;
        this.q = System.currentTimeMillis();
        this.r = System.currentTimeMillis();
        com.baidu.adp.lib.util.f.a(getClass().getName(), "onStart", "onStart");
        if (!g && intent != null) {
            this.h = intent.getStringExtra("other_url");
            if (this.h == null || this.h.length() == 0) {
                this.i = true;
                z = false;
            } else {
                z = true;
            }
            String str2 = this.h;
            if (str2 == null || str2.length() == 0) {
                str = null;
            } else {
                if (str2.contains("?")) {
                    str2 = str2.substring(0, str2.indexOf("?"));
                }
                str = str2.split("/")[split.length - 1];
            }
            this.a = str;
            if (this.a == null || this.a.length() < 4) {
                this.i = true;
                z2 = false;
            } else {
                z2 = z;
            }
            this.n = z2;
            g = true;
            if (intent != null && intent.getBooleanExtra("update", false)) {
                VersionData versionData = (VersionData) intent.getSerializableExtra("version");
                this.e = versionData;
                if (versionData != null) {
                    this.c.contentView.setTextViewText(com.baidu.tieba.a.h.info, String.format(getString(com.baidu.tieba.a.k.tieba_downloading), this.e.getNew_version()));
                    this.c.contentView.setTextViewText(com.baidu.tieba.a.h.schedule, "0/0");
                    a(0);
                    if (w.d(this.e.getNew_file()) != null) {
                        this.u.sendMessageDelayed(this.u.obtainMessage(1, this.e), 100L);
                    } else if (this.d == null) {
                        this.d = new r(this, this.e);
                        this.d.execute(new String[0]);
                        this.c.contentView.setProgressBar(com.baidu.tieba.a.h.progress, 100, 0, false);
                        this.b.notify(10, this.c);
                    }
                    if (z2) {
                        if (w.d(this.a) != null) {
                            this.n = false;
                            this.v.sendMessageDelayed(this.v.obtainMessage(2, this.e), 100L);
                        } else if (this.f == null) {
                            this.n = true;
                            this.f = new s(this, this.h);
                            this.f.execute(new String[0]);
                        }
                    }
                }
            }
            super.onStart(intent, i);
        }
    }
}
