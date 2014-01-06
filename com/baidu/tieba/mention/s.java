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
import com.baidu.tieba.util.bm;
import com.baidu.tieba.util.bo;
import com.slidingmenu.lib.R;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.c.l {
    private static s h;
    private static Date j = null;
    private static long k = System.currentTimeMillis();
    NotificationManager a = null;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private ad i = new ad();
    private int[] l = new int[10];
    private TiebaApplication b = TiebaApplication.g();

    public static s a() {
        if (h == null) {
            h = new s();
        }
        return h;
    }

    public void b() {
        this.a = (NotificationManager) this.b.getSystemService("notification");
    }

    private s() {
        com.baidu.tieba.im.c.m.a().a("apply_join_group", this);
        com.baidu.tieba.im.c.m.a().a("group_msg_arrived", this);
        com.baidu.tieba.im.c.m.a().a("apply_join_success", this);
        com.baidu.tieba.im.c.m.a().a("kick_out", this);
        com.baidu.tieba.im.c.m.a().a("group_intro_change", this);
        com.baidu.tieba.im.c.m.a().a("group_level_up", this);
        com.baidu.tieba.im.c.m.a().a("group_name_change", this);
        com.baidu.tieba.im.c.m.a().a("group_notice_change", this);
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i == this.c && i2 == this.d && i3 == this.e && i4 == this.f && i5 == this.g) {
            bo.b("消息数字都没有变化" + this.c + this.d + this.e + this.f + this.g);
            return;
        }
        int i6 = 0;
        if (i > this.c || i2 > this.d || i3 > this.e || i4 > this.f || i5 > this.g) {
            i6 = 1;
        } else if (i < this.c || i2 < this.d || i3 < this.e || i5 < this.g) {
            i6 = 2;
        }
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        int i7 = s() > 0 ? i6 : 2;
        if (TiebaApplication.A() != null && TiebaApplication.A().length() > 0) {
            i();
            a(i7, 16);
            a(i7, 17);
            a(i7, 11);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i != this.c || i2 != this.d || i3 != this.e || i4 != this.f) {
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            i();
            if (s() <= 0) {
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
        if (g.Q()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = g.R().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = g.S().split(":");
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
                        int i3 = this.c + this.d;
                        if (i3 > 0) {
                            stringBuffer.append(String.valueOf(i3));
                            stringBuffer.append(this.b.getString(R.string.notify_msg));
                        }
                        if (this.e > 0) {
                            stringBuffer.append(String.valueOf(this.e));
                            stringBuffer.append(this.b.getString(R.string.notify_fans));
                        }
                        stringBuffer.append(this.b.getString(R.string.notify_click));
                        a(11, (String) null, stringBuffer.toString());
                    } else if (i2 == 16 || !TiebaApplication.g().aa() || TiebaApplication.g().N() <= 0) {
                    }
                } else if (i == 2) {
                    this.a.cancel(11);
                    this.a.cancel(16);
                    this.a.cancel(17);
                }
            } catch (Exception e) {
                bo.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01ba A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:7:0x000f, B:9:0x0016, B:11:0x001a, B:13:0x001e, B:15:0x0022, B:17:0x0029, B:18:0x003c, B:20:0x0040, B:21:0x0055, B:26:0x0081, B:28:0x008b, B:30:0x0095, B:31:0x009f, B:33:0x00ab, B:35:0x00b5, B:36:0x00ba, B:38:0x00c2, B:41:0x00ee, B:43:0x00fa, B:44:0x0102, B:46:0x0108, B:47:0x0127, B:49:0x0130, B:50:0x0139, B:52:0x0143, B:54:0x014d, B:56:0x0158, B:58:0x015e, B:60:0x0162, B:62:0x0172, B:63:0x018e, B:65:0x0194, B:68:0x019a, B:70:0x01ba, B:72:0x01c6, B:76:0x01dd, B:73:0x01d5, B:79:0x01ff), top: B:84:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c6 A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:7:0x000f, B:9:0x0016, B:11:0x001a, B:13:0x001e, B:15:0x0022, B:17:0x0029, B:18:0x003c, B:20:0x0040, B:21:0x0055, B:26:0x0081, B:28:0x008b, B:30:0x0095, B:31:0x009f, B:33:0x00ab, B:35:0x00b5, B:36:0x00ba, B:38:0x00c2, B:41:0x00ee, B:43:0x00fa, B:44:0x0102, B:46:0x0108, B:47:0x0127, B:49:0x0130, B:50:0x0139, B:52:0x0143, B:54:0x014d, B:56:0x0158, B:58:0x015e, B:60:0x0162, B:62:0x0172, B:63:0x018e, B:65:0x0194, B:68:0x019a, B:70:0x01ba, B:72:0x01c6, B:76:0x01dd, B:73:0x01d5, B:79:0x01ff), top: B:84:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, ad adVar) {
        boolean z;
        String k2;
        String j2;
        boolean z2 = false;
        boolean z3 = true;
        if (this.a != null && adVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 11 && (this.c > 0 || this.d > 0 || this.e > 0)) {
                        int i3 = this.c + this.d;
                        if (i3 > 0) {
                            stringBuffer.append(String.valueOf(i3));
                            stringBuffer.append(this.b.getString(R.string.notify_msg));
                        }
                        if (this.e > 0) {
                            stringBuffer.append(String.valueOf(this.e));
                            stringBuffer.append(this.b.getString(R.string.notify_fans));
                        }
                        stringBuffer.append(this.b.getString(R.string.notify_click));
                        a(11, (String) null, stringBuffer.toString());
                    } else if (i2 == 16) {
                        int d = (!TiebaApplication.g().aa() || TiebaApplication.g().N() <= 0) ? 0 : adVar.d() - adVar.h();
                        long j3 = 0;
                        if (TiebaApplication.g().Z() && TiebaApplication.g().N() > 0) {
                            j3 = adVar.q();
                        }
                        long j4 = d + j3;
                        if (j4 > 1) {
                            stringBuffer.append(String.format(this.b.getString(R.string.notify_chat), Long.valueOf(j4)));
                            a(16, (String) null, stringBuffer.toString());
                        } else if (j4 == 1) {
                            adVar.t();
                            adVar.r();
                            if (j3 == 1) {
                                k2 = adVar.t();
                                j2 = adVar.r();
                            } else if (d == 1) {
                                k2 = adVar.k();
                                j2 = adVar.j();
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(j2)) {
                                j2 = stringBuffer.append(String.format(this.b.getString(R.string.notify_chat), Long.valueOf(j4))).toString();
                            }
                            a(16, k2, j2);
                        }
                    } else if (TiebaApplication.g().aa() && TiebaApplication.g().N() > 0 && adVar.e() + adVar.g() > 0) {
                        if (adVar.e() > 0 && !UpdatesActivity.a) {
                            long e = adVar.e() - adVar.f();
                            if (e > 0) {
                                stringBuffer.append(String.format(this.b.getString(R.string.notify_updates), Long.valueOf(e)));
                                z = false;
                                z2 = true;
                            } else if (adVar.f() > 0) {
                                z = true;
                            }
                            if (adVar.g() > 0 || ValidateActivity.a) {
                                z3 = z2;
                            } else if (z2) {
                                stringBuffer.append(String.format(this.b.getString(R.string.notify_validate_1), Integer.valueOf(adVar.g())));
                            } else {
                                stringBuffer.append(String.format(this.b.getString(R.string.notify_validate), Integer.valueOf(adVar.g())));
                            }
                            if (z3) {
                                a(17, (String) null, stringBuffer.toString());
                            }
                            if (!z) {
                                a(18, adVar.l(), adVar.m());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (adVar.g() > 0) {
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
                bo.b(getClass().toString(), "showNotification", e2.getMessage());
            }
        }
    }

    private void a(Notification notification) {
        new Notification(R.drawable.icon, this.b.getString(R.string.notify_text), System.currentTimeMillis());
    }

    private void a(int i, String str, String str2) {
        Intent i2;
        Notification notification = new Notification(R.drawable.icon_notify, this.b.getString(R.string.notify_text), System.currentTimeMillis());
        if (this.a != null) {
            this.a.cancel(i);
        }
        if (i == 11 && this.e > 0 && this.c == 0 && this.d == 0) {
            i2 = h(i);
        } else if (i == 18) {
            i2 = v();
        } else if (i == 18) {
            i2 = v();
        } else {
            i2 = i(i);
        }
        i2.setFlags(268435456);
        PendingIntent service = PendingIntent.getService(this.b, i, i2, 134217728);
        int i3 = 0;
        try {
            Field field = Class.forName("com.android.internal.R$id").getField("icon");
            field.setAccessible(true);
            i3 = field.getInt(null);
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
        if (bm.c(str) || (i != 16 && i != 18)) {
            notification.setLatestEventInfo(this.b, this.b.getString(R.string.app_name), str2, service);
        } else {
            notification.setLatestEventInfo(this.b, str, str2, service);
        }
        if (i3 != 0 && notification.contentView != null) {
            notification.contentView.setImageViewResource(i3, R.drawable.icon);
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

    private Intent h(int i) {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 10);
        intent.putExtra("KeyOfNotiId", i);
        String A = TiebaApplication.A();
        String G = TiebaApplication.G();
        if (!TextUtils.isEmpty(A) && !TextUtils.isEmpty(G)) {
            intent.putExtra("un", A);
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, G);
        }
        return intent;
    }

    private Intent i(int i) {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("at_me", this.d);
        intent.putExtra("reply_me", this.c);
        intent.putExtra("fans", this.e);
        intent.putExtra("chat", p());
        intent.putExtra("group_msg", this.i.d() - this.i.h());
        intent.putExtra("group_msg_validate", this.i.g());
        intent.putExtra("group_msg_updates", this.i.e());
        return intent;
    }

    private Intent v() {
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
        ad u = u();
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
        ad u = u();
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
        com.baidu.tieba.im.message.r rVar = new com.baidu.tieba.im.message.r();
        rVar.b(n());
        rVar.f(r());
        rVar.d(q());
        rVar.c(o());
        rVar.a(m());
        com.baidu.tieba.im.messageCenter.e.a().d(rVar);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            com.baidu.tieba.im.message.r rVar = new com.baidu.tieba.im.message.r();
            rVar.b(n());
            rVar.f(r());
            rVar.d((adVar.q() + adVar.d()) - adVar.h());
            rVar.c(o());
            rVar.a(m());
            com.baidu.tieba.im.messageCenter.e.a().d(rVar);
        }
    }

    public void j() {
        if (TiebaApplication.g().ab()) {
            try {
                this.b.startService(new Intent(this.b, TiebaMessageService.class));
            } catch (Exception e) {
                bo.b(getClass().getName(), "startMsgReceive", e.toString());
            }
        }
    }

    public void k() {
        if (TiebaApplication.g().ab()) {
            try {
                Intent intent = new Intent(this.b, TiebaMessageService.class);
                intent.putExtra("getMessageAtOnce", true);
                this.b.startService(intent);
            } catch (Exception e) {
                bo.b(getClass().getName(), "startMsgReceive", e.toString());
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

    public int m() {
        return this.c;
    }

    public void b(int i) {
        if (i >= 0) {
            a(i, this.d, this.e, this.f, this.g);
        }
    }

    public int n() {
        return this.d;
    }

    public void c(int i) {
        if (i >= 0) {
            a(this.c, i, this.e, this.f, this.g);
        }
    }

    public int o() {
        return this.e;
    }

    public void d(int i) {
        if (i >= 0) {
            a(this.c, this.d, i, this.f, this.g);
        }
    }

    public int p() {
        return this.f;
    }

    public int q() {
        return (this.i.q() + this.i.d()) - this.i.h();
    }

    public void e(int i) {
        if (i >= 0) {
            a(this.c, this.d, this.e, i, this.g);
        }
    }

    public int r() {
        return this.g;
    }

    public void f(int i) {
        if (i >= 0) {
            a(this.c, this.d, this.e, this.f, i);
        }
    }

    public void a(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0);
            return;
        }
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    public int s() {
        return this.c + this.d + this.e + this.f;
    }

    public int g(int i) {
        return this.l[i];
    }

    @Override // com.baidu.tieba.im.c.l
    public void a(GroupNewsPojo groupNewsPojo) {
    }

    public void b(ad adVar) {
        if (adVar != null) {
            this.i = adVar;
            this.f = (adVar.d() - adVar.h()) + adVar.q();
            com.baidu.adp.lib.h.e.d("groupMsgName" + adVar.k());
            com.baidu.adp.lib.h.e.d("privateMsgName" + adVar.t());
            a(adVar);
            com.baidu.adp.lib.h.e.d("result.isShowInNotifyBar():" + adVar.i() + "isShowNotify");
            long currentTimeMillis = System.currentTimeMillis();
            if (adVar.i()) {
                if (currentTimeMillis - k < 5000) {
                    com.baidu.adp.lib.h.e.d(" notify limit:" + (currentTimeMillis - k));
                    return;
                }
                k = System.currentTimeMillis();
            }
            if (adVar.i()) {
                int i = 0;
                if (TiebaApplication.g().aa() && TiebaApplication.g().N() > 0) {
                    i = adVar.d() - adVar.h();
                }
                long q = (!TiebaApplication.g().Z() || TiebaApplication.g().N() <= 0) ? 0L : adVar.q();
                if (i > 0 || q > 0) {
                    a(1, 16, adVar);
                }
                if (adVar.e() > adVar.o() || adVar.g() > adVar.p()) {
                    if (adVar.e() <= adVar.o() || adVar.g() != adVar.p() || !UpdatesActivity.a) {
                        if (adVar.e() != adVar.o() || adVar.g() <= adVar.p() || !ValidateActivity.a) {
                            a(1, 17, adVar);
                        }
                    }
                }
            }
        }
    }

    public int t() {
        if (this.i == null) {
            return 0;
        }
        return this.i.d();
    }

    public ad u() {
        return this.i;
    }

    public void c(ad adVar) {
        this.i = adVar;
    }
}
