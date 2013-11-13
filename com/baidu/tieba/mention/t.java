package com.baidu.tieba.mention;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.tieba.service.DealIntentService;
import com.baidu.tieba.service.TiebaMessageService;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.im.pushNotify.m {
    private static t h;
    private static Date j = null;
    private static long k = System.currentTimeMillis();
    private static long l = System.currentTimeMillis();

    /* renamed from: a  reason: collision with root package name */
    NotificationManager f1871a = null;
    private long c = 0;
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private ae i = new ae();
    private int[] m = new int[10];
    private TiebaApplication b = TiebaApplication.g();

    public static t a() {
        if (h == null) {
            h = new t();
        }
        return h;
    }

    public void b() {
        this.f1871a = (NotificationManager) this.b.getSystemService("notification");
    }

    private t() {
        com.baidu.tieba.im.pushNotify.n.a().a("apply_join_group", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_msg_arrived", this);
        com.baidu.tieba.im.pushNotify.n.a().a("apply_join_success", this);
        com.baidu.tieba.im.pushNotify.n.a().a("kick_out", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_intro_change", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_level_up", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_name_change", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_notice_change", this);
    }

    public void a(long j2, long j3, long j4, long j5, long j6) {
        if (j2 == this.c && j3 == this.d && j4 == this.e && j5 == this.f && j6 == this.g) {
            bg.b("消息数字都没有变化" + this.c + this.d + this.e + this.f + this.g);
            return;
        }
        int i = 0;
        if (j2 > this.c || j3 > this.d || j4 > this.e || j5 > this.f || j6 > this.g) {
            i = 1;
        } else if (j2 < this.c || j3 < this.d || j4 < this.e || j6 < this.g) {
            i = 2;
        }
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        if (r() <= 0) {
            i = 2;
        }
        if (TiebaApplication.A() != null && TiebaApplication.A().length() > 0) {
            h();
            a(i, 16);
            a(i, 17);
            a(i, 11);
        }
    }

    public void a(long j2, long j3, long j4, long j5) {
        if (j2 != this.c || j3 != this.d || j4 != this.e || j5 != this.f) {
            this.c = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            h();
            if (r() <= 0) {
                a(2, 16);
                a(2, 17);
                a(2, 11);
            }
        }
    }

    public static boolean c() {
        TiebaApplication g = TiebaApplication.g();
        if (j == null) {
            j = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - j.getTime() < 10000) {
                j = date;
                return true;
            }
            j = date;
        }
        if (g.S()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = g.T().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = g.U().split(":");
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

    private void a(int i, int i2) {
        if (this.f1871a != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 11 && (this.c > 0 || this.d > 0 || this.e > 0)) {
                        long j2 = this.c + this.d;
                        if (j2 > 0) {
                            stringBuffer.append(String.valueOf(j2));
                            stringBuffer.append(this.b.getString(R.string.notify_msg));
                        }
                        if (this.e > 0) {
                            stringBuffer.append(String.valueOf(this.e));
                            stringBuffer.append(this.b.getString(R.string.notify_fans));
                        }
                        stringBuffer.append(this.b.getString(R.string.notify_click));
                        a(11, (String) null, stringBuffer.toString());
                    } else if (i2 == 16 || !TiebaApplication.g().ac() || TiebaApplication.g().P() > 0) {
                    }
                } else if (i == 2) {
                    this.f1871a.cancel(11);
                    this.f1871a.cancel(16);
                    this.f1871a.cancel(17);
                }
            } catch (Exception e) {
                bg.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    private void a(int i, int i2, ae aeVar) {
        boolean z = true;
        if (this.f1871a != null && aeVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 11 && (this.c > 0 || this.d > 0 || this.e > 0)) {
                        long j2 = this.c + this.d;
                        if (j2 > 0) {
                            stringBuffer.append(String.valueOf(j2));
                            stringBuffer.append(this.b.getString(R.string.notify_msg));
                        }
                        if (this.e > 0) {
                            stringBuffer.append(String.valueOf(this.e));
                            stringBuffer.append(this.b.getString(R.string.notify_fans));
                        }
                        stringBuffer.append(this.b.getString(R.string.notify_click));
                        a(11, (String) null, stringBuffer.toString());
                    } else if (i2 == 16) {
                        long b = ((!TiebaApplication.g().ac() || TiebaApplication.g().P() <= 0) ? 0L : aeVar.b() - aeVar.e()) + o();
                        if (b > 1 || o() == 1) {
                            stringBuffer.append(String.format(this.b.getString(R.string.notify_chat), Long.valueOf(b)));
                            a(16, aeVar.i(), stringBuffer.toString());
                        } else if (b == 1) {
                            if (be.c(aeVar.h())) {
                                stringBuffer.append(String.format(this.b.getString(R.string.notify_chat), Long.valueOf(b)));
                                a(16, aeVar.i(), stringBuffer.toString());
                                return;
                            }
                            com.baidu.adp.lib.h.d.d("getLastSummary():" + aeVar.h());
                            a(16, aeVar.i(), aeVar.h());
                        }
                    } else if (TiebaApplication.g().ac() && TiebaApplication.g().P() > 0 && aeVar.c() + aeVar.d() > 0) {
                        if (aeVar.c() <= 0 || UpdatesActivity.f1706a) {
                            z = false;
                        } else {
                            stringBuffer.append(String.format(this.b.getString(R.string.notify_updates), Long.valueOf(aeVar.c())));
                        }
                        if (aeVar.d() > 0 && !ValidateActivity.f1803a) {
                            if (z) {
                                stringBuffer.append(String.format(this.b.getString(R.string.notify_validate_1), Long.valueOf(aeVar.d())));
                            } else {
                                stringBuffer.append(String.format(this.b.getString(R.string.notify_validate), Long.valueOf(aeVar.d())));
                            }
                        }
                        a(17, (String) null, stringBuffer.toString());
                    }
                } else if (i == 2) {
                    this.f1871a.cancel(11);
                    this.f1871a.cancel(16);
                    this.f1871a.cancel(17);
                }
            } catch (Exception e) {
                bg.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    private void a(Notification notification) {
        new Notification(R.drawable.icon, this.b.getString(R.string.notify_text), System.currentTimeMillis());
    }

    private void a(int i, String str, String str2) {
        Intent v;
        Notification notification = new Notification(R.drawable.icon_notify, this.b.getString(R.string.notify_text), System.currentTimeMillis());
        if (this.f1871a != null) {
            this.f1871a.cancel(i);
        }
        if (i == 11 && this.e > 0 && this.c == 0 && this.d == 0) {
            v = u();
        } else {
            v = v();
        }
        v.setFlags(268435456);
        PendingIntent service = PendingIntent.getService(this.b, i, v, 134217728);
        int i2 = 0;
        try {
            Field field = Class.forName("com.android.internal.R$id").getField("icon");
            field.setAccessible(true);
            i2 = field.getInt(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            a(notification);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            a(notification);
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            a(notification);
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            a(notification);
        } catch (SecurityException e5) {
            e5.printStackTrace();
            a(notification);
        }
        if (be.c(str) || i != 16) {
            notification.setLatestEventInfo(this.b, this.b.getString(R.string.app_name), str2, service);
        } else {
            notification.setLatestEventInfo(this.b, str, str2, service);
        }
        if (i2 != 0 && notification.contentView != null) {
            notification.contentView.setImageViewResource(i2, R.drawable.icon);
        }
        notification.defaults = -1;
        notification.flags = 16;
        if (c()) {
            notification.defaults &= -2;
            notification.defaults &= -3;
        } else {
            if (!this.b.W()) {
                notification.defaults &= -3;
            }
            if (!this.b.V()) {
                notification.defaults &= -2;
            } else {
                notification.audioStreamType = 5;
            }
        }
        if (this.f1871a != null) {
            this.f1871a.notify(i, notification);
        }
    }

    private Intent u() {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 10);
        String A = TiebaApplication.A();
        String F = TiebaApplication.F();
        if (!TextUtils.isEmpty(A) && !TextUtils.isEmpty(F)) {
            intent.putExtra("un", A);
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, F);
        }
        return intent;
    }

    private Intent v() {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("at_me", this.d);
        intent.putExtra("reply_me", this.c);
        intent.putExtra("fans", this.e);
        intent.putExtra("chat", o());
        intent.putExtra("group_msg", this.i.b());
        intent.putExtra("group_msg_validate", this.i.d());
        intent.putExtra("group_msg_updates", this.i.c());
        return intent;
    }

    public void d() {
        if (this.f1871a != null) {
            this.f1871a.cancel(11);
            this.f1871a.cancel(16);
            this.f1871a.cancel(17);
            this.f1871a.cancel(15);
            this.f1871a.cancel(13);
            this.f1871a.cancel(12);
        }
    }

    public void e() {
        if (this.f1871a != null) {
            this.f1871a.cancel(16);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            e();
            return;
        }
        ae t = t();
        if (t == null) {
            e();
            return;
        }
        HashMap<String, String> j2 = t.j();
        if (j2 == null || j2.isEmpty()) {
            e();
        } else if (j2.containsKey(str)) {
            e();
        }
    }

    public void f() {
        if (this.f1871a != null) {
            this.f1871a.cancel(17);
        }
    }

    public void a(int i) {
        ae t = t();
        if (t == null) {
            f();
        } else if (1 == i) {
            if (t.c() <= 0) {
                f();
            }
        } else if (2 == i && t.d() <= 0) {
            f();
        }
    }

    public void g() {
        if (this.f1871a != null) {
            this.f1871a.cancel(11);
            this.f1871a.cancel(16);
            this.f1871a.cancel(17);
        }
    }

    public void h() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
        intent.putExtra("relay", l());
        intent.putExtra("at_me", m());
        intent.putExtra("fans", n());
        intent.putExtra("pletter", p());
        intent.putExtra("new_bookmark", q());
        this.b.sendBroadcast(intent);
        bg.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d %d", Long.valueOf(l()), Long.valueOf(m()), Long.valueOf(n()), Long.valueOf(q())));
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
            intent.putExtra("relay", l());
            intent.putExtra("at_me", m());
            intent.putExtra("fans", n());
            intent.putExtra("pletter", o() + aeVar.b());
            intent.putExtra("new_bookmark", q());
            this.b.sendBroadcast(intent);
            bg.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d %d", Long.valueOf(l()), Long.valueOf(m()), Long.valueOf(n()), Long.valueOf(q())));
        }
    }

    public void i() {
        if (TiebaApplication.g().ad()) {
            try {
                this.b.startService(new Intent(this.b, TiebaMessageService.class));
            } catch (Exception e) {
                bg.b(getClass().getName(), "startMsgReceive", e.toString());
            }
        }
    }

    public void j() {
        if (TiebaApplication.g().ad()) {
            try {
                Intent intent = new Intent(this.b, TiebaMessageService.class);
                intent.putExtra("getMessageAtOnce", true);
                this.b.startService(intent);
            } catch (Exception e) {
                bg.b(getClass().getName(), "startMsgReceive", e.toString());
            }
        }
    }

    public void k() {
        this.b.stopService(new Intent(this.b, TiebaMessageService.class));
    }

    public long l() {
        return this.c;
    }

    public void a(long j2) {
        if (j2 >= 0) {
            a(j2, this.d, this.e, this.f, this.g);
        }
    }

    public long m() {
        return this.d;
    }

    public void b(long j2) {
        if (j2 >= 0) {
            a(this.c, j2, this.e, this.f, this.g);
        }
    }

    public long n() {
        return this.e;
    }

    public void c(long j2) {
        if (j2 >= 0) {
            a(this.c, this.d, j2, this.f, this.g);
        }
    }

    public long o() {
        return this.f;
    }

    public long p() {
        return o() + this.i.b();
    }

    public void d(long j2) {
        if (j2 >= 0) {
            a(this.c, this.d, this.e, j2, this.g);
        }
    }

    public long q() {
        return this.g;
    }

    public void e(long j2) {
        if (j2 >= 0) {
            a(this.c, this.d, this.e, this.f, j2);
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

    public long r() {
        return this.c + this.d + this.e + this.f;
    }

    public int b(int i) {
        return this.m[i];
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    public void a(GroupNewsPojo groupNewsPojo) {
    }

    public void b(ae aeVar) {
        if (aeVar != null) {
            this.i = aeVar;
            com.baidu.adp.lib.h.d.d("groupMsgName" + aeVar.i());
            a(aeVar);
            com.baidu.adp.lib.h.d.d("result.isShowInNotifyBar():" + aeVar.f() + "isShowNotify");
            long currentTimeMillis = System.currentTimeMillis();
            if (aeVar.f()) {
                if (currentTimeMillis - k < 5000) {
                    com.baidu.adp.lib.h.d.d(" notify limit:" + (currentTimeMillis - k));
                    return;
                }
                k = System.currentTimeMillis();
            }
            if (aeVar.f()) {
                if (((!TiebaApplication.g().ac() || TiebaApplication.g().P() <= 0) ? 0L : (aeVar.b() - aeVar.e()) - aeVar.g()) > 0) {
                    a(1, 16, aeVar);
                }
                if (aeVar.c() > aeVar.k() || aeVar.d() > aeVar.l()) {
                    if (aeVar.c() <= aeVar.k() || aeVar.d() != aeVar.l() || !UpdatesActivity.f1706a) {
                        if (aeVar.c() != aeVar.k() || aeVar.d() <= aeVar.l() || !ValidateActivity.f1803a) {
                            a(1, 17, aeVar);
                        }
                    }
                }
            }
        }
    }

    public long s() {
        if (this.i == null) {
            return 0L;
        }
        return this.i.b();
    }

    public ae t() {
        return this.i;
    }

    public void c(ae aeVar) {
        this.i = aeVar;
    }
}
