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
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.im.c.l {
    private static t h;
    private static Date j = null;
    private static long k = System.currentTimeMillis();
    private static long l = System.currentTimeMillis();
    NotificationManager a = null;
    private long c = 0;
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private ae i = new ae();
    private int[] m = new int[10];
    private TiebaApplication b = TiebaApplication.h();

    public static t a() {
        if (h == null) {
            h = new t();
        }
        return h;
    }

    public void b() {
        this.a = (NotificationManager) this.b.getSystemService("notification");
    }

    private t() {
        com.baidu.tieba.im.c.m.a().a("apply_join_group", this);
        com.baidu.tieba.im.c.m.a().a("group_msg_arrived", this);
        com.baidu.tieba.im.c.m.a().a("apply_join_success", this);
        com.baidu.tieba.im.c.m.a().a("kick_out", this);
        com.baidu.tieba.im.c.m.a().a("group_intro_change", this);
        com.baidu.tieba.im.c.m.a().a("group_level_up", this);
        com.baidu.tieba.im.c.m.a().a("group_name_change", this);
        com.baidu.tieba.im.c.m.a().a("group_notice_change", this);
    }

    public void a(long j2, long j3, long j4, long j5, long j6) {
        if (j2 == this.c && j3 == this.d && j4 == this.e && j5 == this.f && j6 == this.g) {
            be.b("消息数字都没有变化" + this.c + this.d + this.e + this.f + this.g);
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
        if (s() <= 0) {
            i = 2;
        }
        if (TiebaApplication.B() != null && TiebaApplication.B().length() > 0) {
            i();
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
            i();
            if (s() <= 0) {
                a(2, 16);
                a(2, 17);
                a(2, 11);
            }
        }
    }

    public static boolean c() {
        TiebaApplication h2 = TiebaApplication.h();
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
        if (h2.Q()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = h2.R().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = h2.S().split(":");
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
        if (this.a != null) {
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
                    } else if (i2 == 16 || !TiebaApplication.h().aa() || TiebaApplication.h().N() > 0) {
                    }
                } else if (i == 2) {
                    this.a.cancel(11);
                    this.a.cancel(16);
                    this.a.cancel(17);
                }
            } catch (Exception e) {
                be.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x01c4 A[Catch: Exception -> 0x007a, TryCatch #0 {Exception -> 0x007a, blocks: (B:7:0x0011, B:9:0x001a, B:11:0x0020, B:13:0x0026, B:15:0x002c, B:17:0x0035, B:18:0x0048, B:20:0x004e, B:21:0x0063, B:26:0x008f, B:28:0x0099, B:30:0x00a3, B:31:0x00ad, B:33:0x00b7, B:35:0x00c1, B:36:0x00c5, B:38:0x00cb, B:41:0x00f5, B:43:0x00ff, B:44:0x0107, B:46:0x010d, B:47:0x012c, B:50:0x0137, B:51:0x0140, B:53:0x014a, B:55:0x0154, B:57:0x0161, B:59:0x0169, B:61:0x016d, B:63:0x017a, B:64:0x0196, B:66:0x019e, B:69:0x01a4, B:71:0x01c4, B:73:0x01d0, B:77:0x01e9, B:74:0x01df, B:80:0x020b), top: B:86:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d0 A[Catch: Exception -> 0x007a, TryCatch #0 {Exception -> 0x007a, blocks: (B:7:0x0011, B:9:0x001a, B:11:0x0020, B:13:0x0026, B:15:0x002c, B:17:0x0035, B:18:0x0048, B:20:0x004e, B:21:0x0063, B:26:0x008f, B:28:0x0099, B:30:0x00a3, B:31:0x00ad, B:33:0x00b7, B:35:0x00c1, B:36:0x00c5, B:38:0x00cb, B:41:0x00f5, B:43:0x00ff, B:44:0x0107, B:46:0x010d, B:47:0x012c, B:50:0x0137, B:51:0x0140, B:53:0x014a, B:55:0x0154, B:57:0x0161, B:59:0x0169, B:61:0x016d, B:63:0x017a, B:64:0x0196, B:66:0x019e, B:69:0x01a4, B:71:0x01c4, B:73:0x01d0, B:77:0x01e9, B:74:0x01df, B:80:0x020b), top: B:86:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, ae aeVar) {
        boolean z;
        String k2;
        String j2;
        boolean z2 = false;
        boolean z3 = true;
        if (this.a != null && aeVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 11 && (this.c > 0 || this.d > 0 || this.e > 0)) {
                        long j3 = this.c + this.d;
                        if (j3 > 0) {
                            stringBuffer.append(String.valueOf(j3));
                            stringBuffer.append(this.b.getString(R.string.notify_msg));
                        }
                        if (this.e > 0) {
                            stringBuffer.append(String.valueOf(this.e));
                            stringBuffer.append(this.b.getString(R.string.notify_fans));
                        }
                        stringBuffer.append(this.b.getString(R.string.notify_click));
                        a(11, (String) null, stringBuffer.toString());
                    } else if (i2 == 16) {
                        long d = (!TiebaApplication.h().aa() || TiebaApplication.h().N() <= 0) ? 0L : aeVar.d() - aeVar.h();
                        long q = (!TiebaApplication.h().Z() || TiebaApplication.h().N() <= 0) ? 0L : aeVar.q();
                        long j4 = q + d;
                        if (j4 > 1) {
                            stringBuffer.append(String.format(this.b.getString(R.string.notify_chat), Long.valueOf(j4)));
                            a(16, (String) null, stringBuffer.toString());
                        } else if (j4 == 1) {
                            aeVar.t();
                            aeVar.r();
                            if (q == 1) {
                                k2 = aeVar.t();
                                j2 = aeVar.r();
                            } else if (d == 1) {
                                k2 = aeVar.k();
                                j2 = aeVar.j();
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(j2)) {
                                j2 = stringBuffer.append(String.format(this.b.getString(R.string.notify_chat), Long.valueOf(j4))).toString();
                            }
                            a(16, k2, j2);
                        }
                    } else if (TiebaApplication.h().aa() && TiebaApplication.h().N() > 0 && aeVar.e() + aeVar.g() > 0) {
                        if (aeVar.e() > 0 && !UpdatesActivity.a) {
                            long e = aeVar.e() - aeVar.f();
                            if (e > 0) {
                                stringBuffer.append(String.format(this.b.getString(R.string.notify_updates), Long.valueOf(e)));
                                z = false;
                                z2 = true;
                            } else if (aeVar.f() > 0) {
                                z = true;
                            }
                            if (aeVar.g() > 0 || ValidateActivity.a) {
                                z3 = z2;
                            } else if (z2) {
                                stringBuffer.append(String.format(this.b.getString(R.string.notify_validate_1), Long.valueOf(aeVar.g())));
                            } else {
                                stringBuffer.append(String.format(this.b.getString(R.string.notify_validate), Long.valueOf(aeVar.g())));
                            }
                            if (z3) {
                                a(17, (String) null, stringBuffer.toString());
                            }
                            if (!z) {
                                a(18, aeVar.l(), aeVar.m());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (aeVar.g() > 0) {
                        }
                        z3 = z2;
                        if (z3) {
                        }
                        if (!z) {
                        }
                    }
                } else if (i == 2) {
                    this.a.cancel(11);
                    this.a.cancel(16);
                    this.a.cancel(17);
                }
            } catch (Exception e2) {
                be.b(getClass().toString(), "showNotification", e2.getMessage());
            }
        }
    }

    private void a(Notification notification) {
        new Notification(R.drawable.icon, this.b.getString(R.string.notify_text), System.currentTimeMillis());
    }

    private void a(int i, String str, String str2) {
        Intent w;
        Notification notification = new Notification(R.drawable.icon_notify, this.b.getString(R.string.notify_text), System.currentTimeMillis());
        if (this.a != null) {
            this.a.cancel(i);
        }
        if (i == 11 && this.e > 0 && this.c == 0 && this.d == 0) {
            w = v();
        } else if (i == 18) {
            w = x();
        } else {
            w = w();
        }
        w.setFlags(268435456);
        PendingIntent service = PendingIntent.getService(this.b, i, w, 134217728);
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
        if (bc.c(str) || (i != 16 && i != 18)) {
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
            if (!this.b.U()) {
                notification.defaults &= -3;
            }
            if (!this.b.T()) {
                notification.defaults &= -2;
            } else {
                notification.audioStreamType = 5;
            }
        }
        if (this.a != null) {
            this.a.notify(i, notification);
        }
    }

    private Intent v() {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 10);
        String B = TiebaApplication.B();
        String G = TiebaApplication.G();
        if (!TextUtils.isEmpty(B) && !TextUtils.isEmpty(G)) {
            intent.putExtra("un", B);
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, G);
        }
        return intent;
    }

    private Intent w() {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("at_me", this.d);
        intent.putExtra("reply_me", this.c);
        intent.putExtra("fans", this.e);
        intent.putExtra("chat", p());
        intent.putExtra("group_msg", this.i.d() - this.i.h());
        intent.putExtra("group_msg_validate", this.i.g());
        intent.putExtra("group_msg_updates", this.i.e());
        return intent;
    }

    private Intent x() {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.i.f());
        return intent;
    }

    public void d() {
        if (this.a != null) {
            this.a.cancel(11);
            this.a.cancel(16);
            this.a.cancel(17);
            this.a.cancel(15);
            this.a.cancel(13);
            this.a.cancel(12);
        }
    }

    public void e() {
        if (this.a != null) {
            this.a.cancel(16);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            e();
            return;
        }
        ae u = u();
        if (u == null) {
            e();
            return;
        }
        HashMap<String, String> n = u.n();
        if (n == null || n.isEmpty()) {
            e();
        } else if (n.containsKey(str)) {
            e();
        }
    }

    public void f() {
        if (this.a != null) {
            this.a.cancel(17);
        }
    }

    public void a(int i) {
        ae u = u();
        if (u == null) {
            f();
        } else if (1 == i) {
            if (u.e() <= 0) {
                f();
            }
        } else if (2 == i && u.g() <= 0) {
            f();
        }
    }

    public void g() {
        if (this.a != null) {
            this.a.cancel(18);
        }
    }

    public void h() {
        if (this.a != null) {
            this.a.cancel(11);
            this.a.cancel(16);
            this.a.cancel(17);
        }
    }

    public void i() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
        intent.putExtra("relay", m());
        intent.putExtra("at_me", n());
        intent.putExtra("fans", o());
        intent.putExtra("pletter", q());
        intent.putExtra("new_bookmark", r());
        this.b.sendBroadcast(intent);
        be.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d %d", Long.valueOf(m()), Long.valueOf(n()), Long.valueOf(o()), Long.valueOf(r())));
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
            intent.putExtra("relay", m());
            intent.putExtra("at_me", n());
            intent.putExtra("fans", o());
            intent.putExtra("pletter", (aeVar.q() + aeVar.d()) - aeVar.h());
            intent.putExtra("new_bookmark", r());
            this.b.sendBroadcast(intent);
            be.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d %d", Long.valueOf(m()), Long.valueOf(n()), Long.valueOf(o()), Long.valueOf(r())));
        }
    }

    public void j() {
        if (TiebaApplication.h().ab()) {
            try {
                this.b.startService(new Intent(this.b, TiebaMessageService.class));
            } catch (Exception e) {
                be.b(getClass().getName(), "startMsgReceive", e.toString());
            }
        }
    }

    public void k() {
        if (TiebaApplication.h().ab()) {
            try {
                Intent intent = new Intent(this.b, TiebaMessageService.class);
                intent.putExtra("getMessageAtOnce", true);
                this.b.startService(intent);
            } catch (Exception e) {
                be.b(getClass().getName(), "startMsgReceive", e.toString());
            }
        }
    }

    public void l() {
        try {
            this.b.stopService(new Intent(this.b, TiebaMessageService.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long m() {
        return this.c;
    }

    public void a(long j2) {
        if (j2 >= 0) {
            a(j2, this.d, this.e, this.f, this.g);
        }
    }

    public long n() {
        return this.d;
    }

    public void b(long j2) {
        if (j2 >= 0) {
            a(this.c, j2, this.e, this.f, this.g);
        }
    }

    public long o() {
        return this.e;
    }

    public void c(long j2) {
        if (j2 >= 0) {
            a(this.c, this.d, j2, this.f, this.g);
        }
    }

    public long p() {
        return this.f;
    }

    public long q() {
        return (this.i.q() + this.i.d()) - this.i.h();
    }

    public void d(long j2) {
        if (j2 >= 0) {
            a(this.c, this.d, this.e, j2, this.g);
        }
    }

    public long r() {
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

    public long s() {
        return this.c + this.d + this.e + this.f;
    }

    public int b(int i) {
        return this.m[i];
    }

    @Override // com.baidu.tieba.im.c.l
    public void a(GroupNewsPojo groupNewsPojo) {
    }

    public void b(ae aeVar) {
        if (aeVar != null) {
            this.i = aeVar;
            this.f = (aeVar.d() - aeVar.h()) + aeVar.q();
            com.baidu.adp.lib.h.e.d("groupMsgName" + aeVar.k());
            com.baidu.adp.lib.h.e.d("privateMsgName" + aeVar.t());
            a(aeVar);
            com.baidu.adp.lib.h.e.d("result.isShowInNotifyBar():" + aeVar.i() + "isShowNotify");
            long currentTimeMillis = System.currentTimeMillis();
            if (aeVar.i()) {
                if (currentTimeMillis - k < 5000) {
                    com.baidu.adp.lib.h.e.d(" notify limit:" + (currentTimeMillis - k));
                    return;
                }
                k = System.currentTimeMillis();
            }
            if (aeVar.i()) {
                long d = (!TiebaApplication.h().aa() || TiebaApplication.h().N() <= 0) ? 0L : aeVar.d() - aeVar.h();
                long q = (!TiebaApplication.h().Z() || TiebaApplication.h().N() <= 0) ? 0L : aeVar.q();
                if (d > 0 || q > 0) {
                    a(1, 16, aeVar);
                }
                if (aeVar.e() > aeVar.o() || aeVar.g() > aeVar.p()) {
                    if (aeVar.e() <= aeVar.o() || aeVar.g() != aeVar.p() || !UpdatesActivity.a) {
                        if (aeVar.e() != aeVar.o() || aeVar.g() <= aeVar.p() || !ValidateActivity.a) {
                            a(1, 17, aeVar);
                        }
                    }
                }
            }
        }
    }

    public long t() {
        if (this.i == null) {
            return 0L;
        }
        return this.i.d();
    }

    public ae u() {
        return this.i;
    }

    public void c(ae aeVar) {
        this.i = aeVar;
    }
}
