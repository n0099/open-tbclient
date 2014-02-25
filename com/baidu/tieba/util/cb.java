package com.baidu.tieba.util;

import android.content.Context;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteFullException;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class cb {
    private static int a;
    private static long b;
    private static int c;

    static {
        com.baidu.adp.lib.util.f.a("com.baidu.tieba.im");
        a = 0;
        b = 0L;
        c = 10;
    }

    public static void a(Context context) {
        try {
            com.baidu.adp.lib.stats.g.a().a(context, String.valueOf(com.baidu.tieba.data.i.a) + "c/s/newlog", String.valueOf(com.baidu.tieba.data.i.a) + "c/s/logsync", "tieba", "tieba_android", com.baidu.tieba.data.i.u(), com.baidu.tieba.data.i.l(), TiebaApplication.K(), TiebaApplication.g().o(), TiebaApplication.g().p(), af.a + "/" + com.baidu.tieba.data.i.k() + "/stat");
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "init", e.toString());
        }
    }

    public static void a(String str, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.g.a().a(str2, str, str3);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "setUserInfo", e.toString());
        }
    }

    public static void a(an anVar) {
        if (anVar != null && anVar.c() <= 180000) {
            try {
                if (anVar.c() >= 0 && anVar.g() >= 0 && anVar.j() >= 0) {
                    int k = anVar.k();
                    if (!anVar.q()) {
                        k = anVar.A();
                    }
                    String str = null;
                    String a2 = cc.a();
                    if (k != 0) {
                        str = anVar.r();
                        com.baidu.adp.lib.util.f.d("api=" + anVar.d() + " downsize=" + anVar.f() + " upsize=" + anVar.e() + " dns=" + anVar.h() + " from=" + a2 + " cost=" + anVar.c() + " conTime=" + anVar.g() + " rspTime=" + anVar.j() + " retry=" + anVar.i() + " errorCode=" + anVar.k());
                    }
                    if (anVar.b()) {
                        com.baidu.adp.lib.stats.g.a().a(null, anVar.C(), a2, anVar.f(), anVar.e(), anVar.c(), anVar.g(), anVar.j(), anVar.i(), k, str, new Object[0]);
                    } else {
                        com.baidu.adp.lib.stats.g.a().b(anVar.d(), anVar.C(), a2, anVar.f(), anVar.e(), anVar.c(), anVar.g(), anVar.j(), anVar.i(), k, str, new Object[0]);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
            }
        }
    }

    public static void a(long j, int i, String str, String str2) {
        com.baidu.adp.lib.stats.g.a().a("module", "msg", "message_id", Long.valueOf(j), "op_type", Integer.valueOf(i), "stat", str2, "link", str);
    }

    public static void a(String str) {
        try {
            com.baidu.adp.lib.stats.g.a().a(str, (String) null, (String) null, new Object[0]);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "crash", e.toString());
        }
    }

    public static void a(Throwable th, String str, Object... objArr) {
        if (th != null) {
            if (th instanceof SQLiteDatabaseCorruptException) {
                a(str, -14, th.toString(), objArr);
            } else if (th instanceof SQLiteAbortException) {
                a(str, -11, th.toString(), objArr);
            } else if (th instanceof SQLiteConstraintException) {
                a(str, -12, th.toString(), objArr);
            } else if (th instanceof SQLiteDiskIOException) {
                a(str, -15, th.toString(), objArr);
            } else if (th instanceof SQLiteFullException) {
                a(str, -16, th.toString(), objArr);
            } else if (th instanceof SQLiteDoneException) {
                a(str, -19, th.toString(), objArr);
            } else {
                a(str, -17, th.toString(), objArr);
            }
        }
    }

    public static void a(String str, int i, String str2, Object... objArr) {
        try {
            com.baidu.adp.lib.stats.g.a().b(str, null, cc.a(), i, str2, objArr);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "printDBExceptionLog", e.toString());
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(context, str, str2, 1);
            }
            com.baidu.adp.lib.stats.g.a().a(context, str, str2, 1, new Object[0]);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "eventStat", e.toString());
        }
    }

    public static void a(Context context, String str, String str2, int i, Object... objArr) {
        try {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(context, str, str2, i);
            }
            com.baidu.adp.lib.stats.g.a().a(context, str, str2, i, objArr);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "eventStat", e.toString());
        }
    }

    public static void a(String str, int i, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.g.a().c("op_img", str, cc.a(), i, str2, "img_inf", str3);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "imgError", e.toString());
        }
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String a2 = com.baidu.adp.lib.stats.o.a((String.valueOf(com.baidu.tieba.im.f.a()) + str).getBytes());
                return a2.substring(a2.length() - 16, a2.length());
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(e.getMessage());
            }
        }
        return null;
    }

    public static void b(String str, int i, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.g.a().d("op_voice", str, cc.a(), i, str2, "voice_inf", str3);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "voiceError", e.toString());
        }
    }

    public static synchronized void a(int i, int i2, String str, String str2, String str3, int i3, String str4, long j, int i4, String str5) {
        synchronized (cb.class) {
            try {
                String a2 = com.baidu.tieba.log.i.a(i);
                com.baidu.adp.lib.stats.g a3 = com.baidu.adp.lib.stats.g.a();
                Object[] objArr = new Object[22];
                objArr[0] = "cmd";
                objArr[1] = String.valueOf(i);
                objArr[2] = "cmdRemark";
                objArr[3] = a2;
                objArr[4] = "seqID";
                objArr[5] = String.valueOf(i2);
                objArr[6] = "reason";
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                objArr[7] = str;
                objArr[8] = "action";
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                objArr[9] = str2;
                objArr[10] = "result";
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                objArr[11] = str3;
                objArr[12] = "errorCode";
                objArr[13] = String.valueOf(i3);
                objArr[14] = "errorMsg";
                if (TextUtils.isEmpty(str4)) {
                    str4 = "";
                }
                objArr[15] = str4;
                objArr[16] = "costTime";
                objArr[17] = String.valueOf(j);
                objArr[18] = "size";
                objArr[19] = String.valueOf(i4);
                objArr[20] = "comment";
                if (TextUtils.isEmpty(str5)) {
                    str5 = "";
                }
                objArr[21] = str5;
                a3.b("im", objArr);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("TiebaStatic", "im", e.toString());
            }
        }
    }

    public static synchronized void b(String str, String str2, String str3) {
        synchronized (cb.class) {
            a(0, 0, str, str2, str3, 0, null, 0L, 0, null);
        }
    }

    public static synchronized void a(String str, String str2, String str3, int i, String str4) {
        synchronized (cb.class) {
            a(0, 0, str, str2, str3, i, str4, 0L, 0, null);
        }
    }

    public static synchronized void a(int i, int i2, String str, String str2, String str3, int i3, String str4) {
        synchronized (cb.class) {
            a(i, i2, str, str2, str3, i3, str4, 0L, 0, null);
        }
    }

    public static synchronized void a(int i, int i2, String str, String str2, String str3, int i3, String str4, long j) {
        synchronized (cb.class) {
            a(i, i2, str, str2, str3, i3, str4, j, 0, null);
        }
    }

    public static void a(String str, long j) {
        try {
            com.baidu.adp.lib.stats.g.a().a(str, (String) null, (String) null, j, 0, (String) null, new Object[0]);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "page", e.toString());
        }
    }

    public static void a(Exception exc, String str) {
        if (exc != null) {
            a(exc.getMessage(), str);
        } else {
            a("", str);
        }
    }

    public static void a(String str, String str2) {
        String a2 = cc.a();
        try {
            if (af.a()) {
                com.baidu.adp.lib.stats.g.a().a(str2, null, a2, -27, str, "sd_state", b(), "sd_size", Long.valueOf(af.e()));
            } else {
                com.baidu.adp.lib.stats.g.a().a(str2, null, a2, -23, str, "sd_state", b());
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "file", e.toString());
        }
    }

    public static void a() {
        try {
            com.baidu.adp.lib.stats.g.a().c();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("TiebaStatic", "save", e.toString());
        }
    }

    private static String b() {
        return Environment.getExternalStorageState();
    }

    public static synchronized void a(String str, int i, int i2, String str2, int i3) {
        synchronized (cb.class) {
            try {
                com.baidu.adp.lib.stats.g.a().a("im", str, b(String.valueOf(i2)), "cmd:" + i, i3, str2, new Object[0]);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(e.toString());
            }
        }
    }

    public static synchronized void a(int i, long j, int i2, int i3, String str) {
        synchronized (cb.class) {
            try {
                com.baidu.adp.lib.stats.g.a().a("op_im_send_msg_cost", String.valueOf(i), (String) null, j, i3, str, "msgtype", Integer.valueOf(i2));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(e.toString());
            }
        }
    }

    public static synchronized void a(long j) {
        synchronized (cb.class) {
            a++;
            b += j;
            if (a >= c) {
                b(b / a);
                b = 0L;
            }
        }
    }

    private static void b(long j) {
        try {
            com.baidu.adp.lib.stats.g.a().a("op_im_pull_msg_cost", (String) null, (String) null, j, 0, (String) null, new Object[0]);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.toString());
        }
    }
}
