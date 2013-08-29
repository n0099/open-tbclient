package com.baidu.tieba.mention;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.service.TiebaMessageService;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class r {
    private static r h;

    /* renamed from: a  reason: collision with root package name */
    NotificationManager f1340a = null;
    private long c = 0;
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private int[] i = new int[10];
    private TiebaApplication b = TiebaApplication.g();

    public static r a() {
        if (h == null) {
            h = new r();
        }
        return h;
    }

    public void b() {
        this.f1340a = (NotificationManager) this.b.getSystemService("notification");
    }

    private r() {
    }

    public void a(long j, long j2, long j3, long j4, long j5) {
        if (j != this.c || j2 != this.d || j3 != this.e || j4 != this.f || j5 != this.g) {
            int i = 0;
            if (j > this.c || j2 > this.d || j3 > this.e || j4 > this.f || j5 > this.g) {
                i = 1;
            } else if (j < this.c || j2 < this.d || j3 < this.e || j5 < this.g) {
                i = 2;
            }
            this.c = j;
            this.d = j2;
            this.e = j3;
            this.f = j4;
            this.g = j5;
            p();
            if (l() <= 0) {
                i = 2;
            }
            b(i);
        }
    }

    public void a(long j, long j2, long j3, long j4) {
        if (j != this.c || j2 != this.d || j3 != this.e || j4 != this.f) {
            this.c = j;
            this.d = j2;
            this.e = j3;
            this.f = j4;
            p();
            if (l() <= 0) {
                b(2);
            }
        }
    }

    private void b(int i) {
        Intent n;
        if (this.f1340a != null) {
            try {
                if (i == 1) {
                    Notification notification = new Notification(R.drawable.icon, this.b.getString(R.string.notify_text), System.currentTimeMillis());
                    StringBuffer stringBuffer = new StringBuffer();
                    if (this.c > 0 || this.d > 0 || this.f > 0) {
                        stringBuffer.append(String.valueOf(this.c + this.d + this.f));
                        stringBuffer.append(this.b.getString(R.string.notify_msg));
                    }
                    if (this.e > 0) {
                        stringBuffer.append(String.valueOf(this.e));
                        stringBuffer.append(this.b.getString(R.string.notify_fans));
                    }
                    if (this.e != 0 || this.c != 0 || this.d != 0 || this.f != 0) {
                        if (this.e > 0 && this.c == 0 && this.d == 0 && this.f == 0) {
                            n = m();
                        } else {
                            n = n();
                        }
                        stringBuffer.append(this.b.getString(R.string.notify_click));
                        n.setFlags(268435456);
                        notification.setLatestEventInfo(this.b, this.b.getString(R.string.app_name), stringBuffer, PendingIntent.getActivity(this.b, 0, n, 0));
                        notification.defaults = -1;
                        notification.flags = 16;
                        notification.audioStreamType = 5;
                        if (!this.b.V()) {
                            notification.defaults &= -2;
                        }
                        if (!this.b.W()) {
                            notification.defaults &= -3;
                        }
                        this.f1340a.notify(11, notification);
                    }
                } else if (i == 2) {
                    this.f1340a.cancel(11);
                }
            } catch (Exception e) {
                aq.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    private Intent m() {
        if (!o()) {
            Intent intent = new Intent();
            intent.putExtra("class", 10);
            Intent intent2 = new Intent(this.b, LogoActivity.class);
            intent2.setFlags(268435456);
            intent2.putExtra("extra_intent", intent);
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setAction("android.intent.action.MAIN");
            return intent2;
        }
        Intent intent3 = new Intent(this.b, PersonInfoActivity.class);
        intent3.putExtra("showBack", true);
        String E = TiebaApplication.E();
        String I = TiebaApplication.I();
        if (!TextUtils.isEmpty(E) && !TextUtils.isEmpty(I)) {
            intent3.putExtra("un", E);
            intent3.putExtra("name", I);
            return intent3;
        }
        return intent3;
    }

    private Intent n() {
        if (!o()) {
            Intent intent = new Intent();
            intent.putExtra("class", 5);
            intent.putExtra("at_me", this.d);
            intent.putExtra("reply_me", this.c);
            intent.putExtra("fans", this.e);
            intent.putExtra("chat", this.f);
            Intent intent2 = new Intent(this.b, LogoActivity.class);
            intent2.setFlags(268435456);
            intent2.putExtra("extra_intent", intent);
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setAction("android.intent.action.MAIN");
            return intent2;
        }
        Intent intent3 = new Intent(this.b, MentionActivity.class);
        intent3.putExtra("showBack", true);
        return intent3;
    }

    private boolean o() {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) TiebaApplication.g().getSystemService("activity")).getRunningTasks(BdWebErrorView.ERROR_CODE_500)) {
            if (runningTaskInfo.baseActivity.getClassName().startsWith(TiebaApplication.g().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        if (this.f1340a != null) {
            this.f1340a.cancel(11);
            this.f1340a.cancel(15);
            this.f1340a.cancel(13);
            this.f1340a.cancel(12);
        }
    }

    public void d() {
        if (this.f1340a != null) {
            this.f1340a.cancel(11);
        }
    }

    private void p() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
        intent.putExtra("relay", g());
        intent.putExtra("at_me", h());
        intent.putExtra("fans", i());
        intent.putExtra("pletter", j());
        intent.putExtra("new_bookmark", k());
        this.b.sendBroadcast(intent);
        aq.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d %d", Long.valueOf(g()), Long.valueOf(h()), Long.valueOf(i()), Long.valueOf(k())));
    }

    public void e() {
        if (TiebaApplication.g().ab()) {
            try {
                this.b.startService(new Intent(this.b, TiebaMessageService.class));
            } catch (Exception e) {
                aq.b(getClass().getName(), "startMsgReceive", e.toString());
            }
        }
    }

    public void f() {
        this.b.stopService(new Intent(this.b, TiebaMessageService.class));
    }

    public long g() {
        return this.c;
    }

    public void a(long j) {
        if (j >= 0) {
            a(j, this.d, this.e, this.f, this.g);
        }
    }

    public long h() {
        return this.d;
    }

    public void b(long j) {
        if (j >= 0) {
            a(this.c, j, this.e, this.f, this.g);
        }
    }

    public long i() {
        return this.e;
    }

    public void c(long j) {
        if (j >= 0) {
            a(this.c, this.d, j, this.f, this.g);
        }
    }

    public long j() {
        return this.f;
    }

    public void d(long j) {
        if (j >= 0) {
            a(this.c, this.d, this.e, j, this.g);
        }
    }

    public long k() {
        return this.g;
    }

    public void e(long j) {
        if (j >= 0) {
            a(this.c, this.d, this.e, this.f, j);
        }
    }

    public void a(boolean z) {
        if (z) {
            a(0L, 0L, 0L, 0L, 0L);
            return;
        }
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
    }

    public long l() {
        return this.c + this.d + this.e + this.f;
    }

    public int a(int i) {
        return this.i[i];
    }
}
