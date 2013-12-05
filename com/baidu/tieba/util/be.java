package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class be {
    public static void a(Context context) {
        try {
            com.baidu.adp.lib.g.a.a().a(context, com.baidu.tieba.data.h.j(), com.baidu.tieba.data.h.a(), TiebaApplication.L(), "tieba", "tieba_android");
        } catch (Exception e) {
            bd.b("TiebaStatic", "init", e.toString());
        }
    }

    public static void a(String str, String str2) {
        try {
            com.baidu.adp.lib.g.a.a().a(str2, str);
        } catch (Exception e) {
            bd.b("TiebaStatic", "setUserInfo", e.toString());
        }
    }

    public static void a(af afVar) {
        if (afVar != null && afVar.b() <= 180000) {
            try {
                if (afVar.b() >= 0 && afVar.g() >= 0 && afVar.f() >= 0 && afVar.i() >= 0) {
                    com.baidu.adp.lib.g.a.a().a(afVar.c(), afVar.e(), afVar.d(), afVar.b(), afVar.g(), afVar.f(), afVar.i(), afVar.h(), afVar.j());
                }
                bd.b("api=" + afVar.c() + " downsize=" + afVar.e() + " upsize=" + afVar.d() + " dns=" + afVar.g() + " cost=" + afVar.b() + " conTime=" + afVar.f() + " rspTime=" + afVar.i() + " retry=" + afVar.h() + " errorCode=" + afVar.j());
            } catch (Exception e) {
                e.printStackTrace();
                bd.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
            }
        }
    }

    public static void a(long j, int i, String str, String str2) {
        com.baidu.adp.lib.g.a.a().a(true, "module", "msg", "message_id", Long.valueOf(j), "op_type", Integer.valueOf(i), "stat", str2, "link", str);
    }

    public static void a(String str, long j, long j2) {
        if (j <= 180000) {
            try {
                com.baidu.adp.lib.g.a.a().a(str, j, j2);
            } catch (Exception e) {
                bd.b("TiebaStatic", "op", e.toString());
            }
        }
    }

    public static void a(String str) {
        try {
            com.baidu.adp.lib.g.a.a().a(str);
        } catch (Exception e) {
            bd.b("TiebaStatic", "crash", e.toString());
        }
    }

    public static void a() {
        try {
            com.baidu.adp.lib.g.a.a().b();
        } catch (Exception e) {
            bd.b("TiebaStatic", "upload", e.toString());
        }
    }
}
