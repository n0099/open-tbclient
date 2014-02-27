package com.baidu.tieba.mention;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.tieba.service.DealIntentService;
import com.baidu.tieba.service.TiebaMessageService;
import com.baidu.tieba.util.bs;
import com.slidingmenu.lib.R;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class v {
    private static v h;
    private static Date j = null;
    private static long k = System.currentTimeMillis();
    NotificationManager a = null;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private ah i = new ah();
    private int[] l = new int[10];
    private Context b = TiebaApplication.g().b();

    public static v a() {
        if (h == null) {
            h = new v();
        }
        return h;
    }

    public final void b() {
        this.a = (NotificationManager) this.b.getSystemService("notification");
    }

    private v() {
    }

    public final void a(int i, int i2, int i3, int i4, int i5) {
        if (i == this.c && i2 == this.d && i3 == this.e && i4 == this.f && i5 == this.g) {
            com.baidu.adp.lib.util.e.d("消息数字都没有变化" + this.c + this.d + this.e + this.f + this.g);
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
        int i7 = w() > 0 ? i6 : 2;
        if (TiebaApplication.v() != null && TiebaApplication.v().length() > 0) {
            g();
            a(i7, 16);
            a(i7, 17);
            a(i7, 11);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        if (i != this.c || i2 != this.d || i3 != this.e || i4 != this.f) {
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            g();
            if (w() <= 0) {
                a(2, 16);
                a(2, 17);
                a(2, 11);
            }
        }
    }

    public static boolean c() {
        boolean z = false;
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
        if (g.I()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = g.J().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = g.K().split(":");
            int parseInt2 = Integer.parseInt(split2[1]) + (Integer.parseInt(split2[0]) * 60);
            if (parseInt >= parseInt2 ? !(parseInt <= parseInt2 || ((i < parseInt || i > 1439) && (i < 0 || i > parseInt2))) : !(i < parseInt || i > parseInt2)) {
                z = true;
            }
        }
        return z;
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
                    } else if (i2 != 16 && TiebaApplication.g().S()) {
                        TiebaApplication.g().G();
                    }
                } else if (i == 2) {
                    this.a.cancel(11);
                    this.a.cancel(16);
                    this.a.cancel(17);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x01b4 A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:6:0x000d, B:8:0x0016, B:10:0x001a, B:12:0x001e, B:14:0x0022, B:16:0x0029, B:17:0x003c, B:19:0x0040, B:20:0x0055, B:25:0x0081, B:27:0x008b, B:29:0x0095, B:30:0x009f, B:32:0x00ab, B:34:0x00b5, B:35:0x00ba, B:37:0x00c0, B:40:0x00ea, B:42:0x00f4, B:43:0x00fc, B:45:0x0102, B:46:0x0121, B:48:0x012a, B:49:0x0133, B:51:0x013d, B:53:0x0147, B:55:0x0152, B:57:0x0158, B:59:0x015c, B:61:0x016c, B:62:0x0188, B:64:0x018e, B:67:0x0194, B:69:0x01b4, B:71:0x01c0, B:75:0x01d7, B:72:0x01cf), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c0 A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:6:0x000d, B:8:0x0016, B:10:0x001a, B:12:0x001e, B:14:0x0022, B:16:0x0029, B:17:0x003c, B:19:0x0040, B:20:0x0055, B:25:0x0081, B:27:0x008b, B:29:0x0095, B:30:0x009f, B:32:0x00ab, B:34:0x00b5, B:35:0x00ba, B:37:0x00c0, B:40:0x00ea, B:42:0x00f4, B:43:0x00fc, B:45:0x0102, B:46:0x0121, B:48:0x012a, B:49:0x0133, B:51:0x013d, B:53:0x0147, B:55:0x0152, B:57:0x0158, B:59:0x015c, B:61:0x016c, B:62:0x0188, B:64:0x018e, B:67:0x0194, B:69:0x01b4, B:71:0x01c0, B:75:0x01d7, B:72:0x01cf), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, ah ahVar) {
        boolean z;
        String h2;
        String g;
        boolean z2 = false;
        boolean z3 = true;
        if (this.a != null && ahVar != null) {
            try {
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
                    int a = (!TiebaApplication.g().S() || TiebaApplication.g().G() <= 0) ? 0 : ahVar.a() - ahVar.e();
                    long j2 = 0;
                    if (TiebaApplication.g().R() && TiebaApplication.g().G() > 0) {
                        j2 = ahVar.n();
                    }
                    long j3 = a + j2;
                    if (j3 > 1) {
                        stringBuffer.append(String.format(this.b.getString(R.string.notify_chat), Long.valueOf(j3)));
                        a(16, (String) null, stringBuffer.toString());
                    } else if (j3 == 1) {
                        ahVar.q();
                        ahVar.o();
                        if (j2 == 1) {
                            h2 = ahVar.q();
                            g = ahVar.o();
                        } else if (a == 1) {
                            h2 = ahVar.h();
                            g = ahVar.g();
                        } else {
                            return;
                        }
                        if (TextUtils.isEmpty(g)) {
                            g = stringBuffer.append(String.format(this.b.getString(R.string.notify_chat), Long.valueOf(j3))).toString();
                        }
                        a(16, h2, g);
                    }
                } else if (TiebaApplication.g().S() && TiebaApplication.g().G() > 0 && ahVar.b() + ahVar.d() > 0) {
                    if (ahVar.b() > 0 && !UpdatesActivity.a) {
                        long b = ahVar.b() - ahVar.c();
                        if (b > 0) {
                            stringBuffer.append(String.format(this.b.getString(R.string.notify_updates), Long.valueOf(b)));
                            z = false;
                            z2 = true;
                        } else if (ahVar.c() > 0) {
                            z = true;
                        }
                        if (ahVar.d() > 0 || ValidateActivity.a) {
                            z3 = z2;
                        } else if (!z2) {
                            stringBuffer.append(String.format(this.b.getString(R.string.notify_validate), Integer.valueOf(ahVar.d())));
                        } else {
                            stringBuffer.append(String.format(this.b.getString(R.string.notify_validate_1), Integer.valueOf(ahVar.d())));
                        }
                        if (z3) {
                            a(17, (String) null, stringBuffer.toString());
                        }
                        if (!z) {
                            a(18, ahVar.i(), ahVar.j());
                            return;
                        }
                        return;
                    }
                    z = false;
                    if (ahVar.d() > 0) {
                    }
                    z3 = z2;
                    if (z3) {
                    }
                    if (!z) {
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    private Notification s() {
        return new Notification(R.drawable.icon, this.b.getString(R.string.notify_text), System.currentTimeMillis());
    }

    private void a(int i, String str, String str2) {
        Intent intent;
        Notification notification = new Notification(R.drawable.icon_notify, this.b.getString(R.string.notify_text), System.currentTimeMillis());
        if (this.a != null) {
            this.a.cancel(i);
        }
        if (i == 11 && this.e > 0 && this.c == 0 && this.d == 0) {
            intent = new Intent(this.b, DealIntentService.class);
            intent.putExtra("class", 10);
            intent.putExtra("KeyOfNotiId", i);
            String v = TiebaApplication.v();
            String z = TiebaApplication.z();
            if (!TextUtils.isEmpty(v) && !TextUtils.isEmpty(z)) {
                intent.putExtra("un", v);
                intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, z);
            }
        } else if (i == 18) {
            intent = t();
        } else if (i == 18) {
            intent = t();
        } else {
            intent = new Intent(this.b, DealIntentService.class);
            intent.putExtra("class", 5);
            intent.putExtra("KeyOfNotiId", i);
            intent.putExtra("at_me", this.d);
            intent.putExtra("reply_me", this.c);
            intent.putExtra("fans", this.e);
            intent.putExtra("chat", this.f);
            intent.putExtra("group_msg", this.i.a() - this.i.e());
            intent.putExtra("group_msg_validate", this.i.d());
            intent.putExtra("group_msg_updates", this.i.b());
        }
        intent.setFlags(268435456);
        PendingIntent service = PendingIntent.getService(this.b, i, intent, 134217728);
        int i2 = 0;
        try {
            Field field = Class.forName("com.android.internal.R$id").getField("icon");
            field.setAccessible(true);
            i2 = field.getInt(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            notification = s();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            notification = s();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            notification = s();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            notification = s();
        } catch (SecurityException e5) {
            e5.printStackTrace();
            notification = s();
        }
        if (bs.c(str) || (i != 16 && i != 18)) {
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
            if (!TiebaApplication.g().M()) {
                notification.defaults &= -3;
            }
            if (!TiebaApplication.g().L()) {
                notification.defaults &= -2;
            } else {
                notification.audioStreamType = 5;
            }
        }
        if (this.a != null) {
            this.a.notify(i, notification);
        }
    }

    private Intent t() {
        Intent intent = new Intent(this.b, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.i.c());
        return intent;
    }

    public final void d() {
        if (this.a != null) {
            this.a.cancel(11);
            this.a.cancel(16);
            this.a.cancel(17);
            this.a.cancel(15);
            this.a.cancel(13);
            this.a.cancel(12);
        }
    }

    private void u() {
        if (this.a != null) {
            this.a.cancel(16);
        }
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            u();
            return;
        }
        ah ahVar = this.i;
        if (ahVar == null) {
            u();
            return;
        }
        HashMap<String, String> k2 = ahVar.k();
        if (k2 == null || k2.isEmpty()) {
            u();
        } else if (k2.containsKey(str)) {
            u();
        }
    }

    private void v() {
        if (this.a != null) {
            this.a.cancel(17);
        }
    }

    public final void a(int i) {
        ah ahVar = this.i;
        if (ahVar == null) {
            v();
        } else if (1 == i) {
            if (ahVar.b() <= 0) {
                v();
            }
        } else if (2 == i && ahVar.d() <= 0) {
            v();
        }
    }

    public final void e() {
        if (this.a != null) {
            this.a.cancel(18);
        }
    }

    public final void f() {
        if (this.a != null) {
            this.a.cancel(11);
            this.a.cancel(16);
            this.a.cancel(17);
        }
    }

    public final void g() {
        com.baidu.tieba.im.message.v vVar = new com.baidu.tieba.im.message.v();
        vVar.b(this.d);
        vVar.f(this.g);
        vVar.d(o());
        vVar.c(this.e);
        vVar.a(this.c);
        com.baidu.tieba.im.messageCenter.d.a().d(vVar);
    }

    public final void h() {
        if (TiebaApplication.g().T()) {
            try {
                this.b.startService(new Intent(this.b, TiebaMessageService.class));
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "startMsgReceive", e.toString());
            }
        }
    }

    public final void i() {
        if (TiebaApplication.g().T()) {
            try {
                Intent intent = new Intent(this.b, TiebaMessageService.class);
                intent.putExtra("getMessageAtOnce", true);
                this.b.startService(intent);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "startMsgReceive", e.toString());
            }
        }
    }

    public final void j() {
        try {
            this.b.stopService(new Intent(this.b, TiebaMessageService.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int k() {
        return this.c;
    }

    public final void b(int i) {
        a(0, this.d, this.e, this.f, this.g);
    }

    public final int l() {
        return this.d;
    }

    public final void c(int i) {
        a(this.c, 0, this.e, this.f, this.g);
    }

    public final int m() {
        return this.e;
    }

    public final void d(int i) {
        a(this.c, this.d, 0, this.f, this.g);
    }

    public final int n() {
        return this.f;
    }

    public final int o() {
        return (this.i.n() + this.i.a()) - this.i.e();
    }

    public final void e(int i) {
        if (i >= 0) {
            a(this.c, this.d, this.e, i, this.g);
        }
    }

    public final int p() {
        return this.g;
    }

    public final void f(int i) {
        if (i >= 0) {
            a(this.c, this.d, this.e, this.f, i);
        }
    }

    public final void a(boolean z) {
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

    private int w() {
        return this.c + this.d + this.e + this.f;
    }

    public final int g(int i) {
        return this.l[i];
    }

    public final void a(ah ahVar) {
        if (ahVar != null) {
            this.i = ahVar;
            this.f = (ahVar.a() - ahVar.e()) + ahVar.n();
            com.baidu.adp.lib.util.e.e("groupMsgName" + ahVar.h());
            com.baidu.adp.lib.util.e.e("privateMsgName" + ahVar.q());
            if (ahVar != null) {
                com.baidu.tieba.im.message.v vVar = new com.baidu.tieba.im.message.v();
                vVar.b(this.d);
                vVar.f(this.g);
                vVar.d((ahVar.n() + ahVar.a()) - ahVar.e());
                vVar.c(this.e);
                vVar.a(this.c);
                com.baidu.tieba.im.messageCenter.d.a().d(vVar);
            }
            com.baidu.adp.lib.util.e.e("result.isShowInNotifyBar():" + ahVar.f() + "isShowNotify");
            long currentTimeMillis = System.currentTimeMillis();
            if (ahVar.f()) {
                if (currentTimeMillis - k < 5000) {
                    com.baidu.adp.lib.util.e.e(" notify limit:" + (currentTimeMillis - k));
                    return;
                }
                k = System.currentTimeMillis();
            }
            if (ahVar.f()) {
                int i = 0;
                if (TiebaApplication.g().S() && TiebaApplication.g().G() > 0) {
                    i = ahVar.a() - ahVar.e();
                }
                long n = (!TiebaApplication.g().R() || TiebaApplication.g().G() <= 0) ? 0L : ahVar.n();
                if (i > 0 || n > 0) {
                    a(1, 16, ahVar);
                }
                if (ahVar.b() > ahVar.l() || ahVar.d() > ahVar.m()) {
                    if (ahVar.b() <= ahVar.l() || ahVar.d() != ahVar.m() || !UpdatesActivity.a) {
                        if (ahVar.b() != ahVar.l() || ahVar.d() <= ahVar.m() || !ValidateActivity.a) {
                            a(1, 17, ahVar);
                        }
                    }
                }
            }
        }
    }

    public final int q() {
        if (this.i == null) {
            return 0;
        }
        return this.i.a();
    }

    public final ah r() {
        return this.i;
    }

    public final void b(ah ahVar) {
        this.i = ahVar;
    }
}
