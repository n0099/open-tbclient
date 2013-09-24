package com.baidu.tieba.mention;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.service.DealIntentService;
import com.baidu.tieba.service.TiebaMessageService;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
import java.util.Calendar;
/* loaded from: classes.dex */
public class s {
    private static s h;

    /* renamed from: a  reason: collision with root package name */
    NotificationManager f1376a = null;
    private long c = 0;
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private int[] i = new int[10];
    private TiebaApplication b = TiebaApplication.g();

    public static s a() {
        if (h == null) {
            h = new s();
        }
        return h;
    }

    public void b() {
        this.f1376a = (NotificationManager) this.b.getSystemService("notification");
    }

    private s() {
    }

    public void a(long j, long j2, long j3, long j4, long j5) {
        if (j == this.c && j2 == this.d && j3 == this.e && j4 == this.f && j5 == this.g) {
            av.b("消息数字都没有变化" + this.c + this.d + this.e + this.f + this.g);
            return;
        }
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
        if (n() <= 0) {
            i = 2;
        }
        if (TiebaApplication.C() != null && TiebaApplication.C().length() > 0) {
            q();
            b(i);
        }
    }

    public void a(long j, long j2, long j3, long j4) {
        if (j != this.c || j2 != this.d || j3 != this.e || j4 != this.f) {
            this.c = j;
            this.d = j2;
            this.e = j3;
            this.f = j4;
            q();
            if (n() <= 0) {
                b(2);
            }
        }
    }

    public static boolean c() {
        TiebaApplication g = TiebaApplication.g();
        if (g.T()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = g.U().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = g.V().split(":");
            int parseInt2 = Integer.parseInt(split2[1]) + (Integer.parseInt(split2[0]) * 60);
            if (parseInt < parseInt2) {
                if (i >= parseInt && i <= parseInt2) {
                    return true;
                }
            } else if (parseInt > parseInt2) {
                if (i >= parseInt && i <= 1439) {
                    return true;
                }
                if (i >= 0 && i <= parseInt2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void b(int i) {
        Intent p;
        if (this.f1376a != null) {
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
                            p = o();
                        } else {
                            p = p();
                        }
                        stringBuffer.append(this.b.getString(R.string.notify_click));
                        p.setFlags(268435456);
                        notification.setLatestEventInfo(this.b, this.b.getString(R.string.app_name), stringBuffer, PendingIntent.getService(this.b, 0, p, 1073741824));
                        notification.defaults = -1;
                        notification.flags = 16;
                        if (c()) {
                            notification.defaults &= -2;
                            notification.defaults &= -3;
                        } else {
                            if (!this.b.X()) {
                                notification.defaults &= -3;
                            }
                            if (!this.b.W()) {
                                notification.defaults &= -2;
                            } else {
                                notification.audioStreamType = 5;
                            }
                        }
                        this.f1376a.notify(11, notification);
                    }
                } else if (i == 2) {
                    this.f1376a.cancel(11);
                }
            } catch (Exception e) {
                av.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    private Intent o() {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 10);
        String C = TiebaApplication.C();
        String G = TiebaApplication.G();
        if (!TextUtils.isEmpty(C) && !TextUtils.isEmpty(G)) {
            intent.putExtra("un", C);
            intent.putExtra("name", G);
        }
        return intent;
    }

    private Intent p() {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("at_me", this.d);
        intent.putExtra("reply_me", this.c);
        intent.putExtra("fans", this.e);
        intent.putExtra("chat", this.f);
        return intent;
    }

    public void d() {
        if (this.f1376a != null) {
            this.f1376a.cancel(11);
            this.f1376a.cancel(15);
            this.f1376a.cancel(13);
            this.f1376a.cancel(12);
        }
    }

    public void e() {
        if (this.f1376a != null) {
            this.f1376a.cancel(11);
        }
    }

    private void q() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
        intent.putExtra("relay", i());
        intent.putExtra("at_me", j());
        intent.putExtra("fans", k());
        intent.putExtra("pletter", l());
        intent.putExtra("new_bookmark", m());
        this.b.sendBroadcast(intent);
        av.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d %d", Long.valueOf(i()), Long.valueOf(j()), Long.valueOf(k()), Long.valueOf(m())));
    }

    public void f() {
        if (TiebaApplication.g().ad()) {
            try {
                this.b.startService(new Intent(this.b, TiebaMessageService.class));
            } catch (Exception e) {
                av.b(getClass().getName(), "startMsgReceive", e.toString());
            }
        }
    }

    public void g() {
        if (TiebaApplication.g().ad()) {
            try {
                Intent intent = new Intent(this.b, TiebaMessageService.class);
                intent.putExtra("getMessageAtOnce", true);
                this.b.startService(intent);
            } catch (Exception e) {
                av.b(getClass().getName(), "startMsgReceive", e.toString());
            }
        }
    }

    public void h() {
        this.b.stopService(new Intent(this.b, TiebaMessageService.class));
    }

    public long i() {
        return this.c;
    }

    public void a(long j) {
        if (j >= 0) {
            a(j, this.d, this.e, this.f, this.g);
        }
    }

    public long j() {
        return this.d;
    }

    public void b(long j) {
        if (j >= 0) {
            a(this.c, j, this.e, this.f, this.g);
        }
    }

    public long k() {
        return this.e;
    }

    public void c(long j) {
        if (j >= 0) {
            a(this.c, this.d, j, this.f, this.g);
        }
    }

    public long l() {
        return this.f;
    }

    public void d(long j) {
        if (j >= 0) {
            a(this.c, this.d, this.e, j, this.g);
        }
    }

    public long m() {
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

    public long n() {
        return this.c + this.d + this.e + this.f;
    }

    public int a(int i) {
        return this.i[i];
    }
}
