package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ad;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.u;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        if (j2 != 0) {
            this.c.contentView.setProgressBar(com.baidu.tieba.r.progress, 100, (int) ((100 * j) / j2), false);
            StringBuffer stringBuffer = new StringBuffer(20);
            stringBuffer.append(String.valueOf(j / 1000));
            stringBuffer.append("K/");
            stringBuffer.append(String.valueOf(j2 / 1000));
            stringBuffer.append("K");
            this.c.contentView.setTextViewText(com.baidu.tieba.r.schedule, stringBuffer);
            this.b.notify(10, this.c);
        }
    }

    public void a(int i) {
        Intent intent = new Intent();
        intent.setAction(TbConfig.APP_UPDATE_ACTION);
        intent.putExtra("progress", i);
        sendBroadcast(intent);
    }

    public void a(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction(TbConfig.APP_UPDATE_ACTION);
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
        this.c = a();
        if (this.b == null || this.c == null) {
            stopSelf();
        }
    }

    private Notification a() {
        PendingIntent activity = PendingIntent.getActivity(ad.c().d(), 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = new RemoteViews(ad.c().d().getPackageName(), com.baidu.tieba.s.notify_item);
        notification.contentView.setProgressBar(com.baidu.tieba.r.progress, 100, 0, false);
        notification.contentIntent = activity;
        notification.flags = 32;
        return notification;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.t = false;
        this.u.removeMessages(TbConfig.NET_MSG_GETLENTH);
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
        boolean z2;
        this.t = true;
        this.q = System.currentTimeMillis();
        this.r = System.currentTimeMillis();
        BdLog.i(getClass().getName(), "onStart", "onStart");
        if (!g && intent != null) {
            this.h = intent.getStringExtra("other_url");
            if (this.h == null || this.h.length() == 0) {
                this.i = true;
                z = false;
            } else {
                z = true;
            }
            this.a = a(this.h);
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
                    String format = String.format(getString(u.tieba_downloading), this.e.getNewVersion());
                    if (this.b != null && this.c != null && this.c.contentView != null) {
                        this.c.contentView.setTextViewText(com.baidu.tieba.r.info, format);
                        this.c.contentView.setTextViewText(com.baidu.tieba.r.schedule, "0/0");
                        if (this.u != null && this.v != null) {
                            a(0);
                            if (x.d(this.e.getNewFile()) != null) {
                                this.u.sendMessageDelayed(this.u.obtainMessage(1, this.e), 100L);
                            } else if (this.d == null) {
                                this.d = new r(this, this.e);
                                if (this.d != null) {
                                    this.d.execute(new String[0]);
                                    this.c.contentView.setProgressBar(com.baidu.tieba.r.progress, 100, 0, false);
                                    this.b.notify(10, this.c);
                                }
                            }
                            if (z2) {
                                if (x.d(this.a) != null) {
                                    this.n = false;
                                    this.v.sendMessageDelayed(this.v.obtainMessage(2, this.e), 100L);
                                } else if (this.f == null) {
                                    this.n = true;
                                    this.f = new s(this, this.h);
                                    if (this.f != null) {
                                        this.f.execute(new String[0]);
                                    }
                                }
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
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
