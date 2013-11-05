package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class bf {
    public static void a(Context context) {
        try {
            com.baidu.adp.lib.g.a.a().a(context, com.baidu.tieba.data.h.j(), com.baidu.tieba.data.h.a(), TiebaApplication.P(), "tieba", "tieba_android");
        } catch (Exception e) {
            be.b("TiebaStatic", "init", e.toString());
        }
    }

    public static void a(String str, String str2) {
        try {
            com.baidu.adp.lib.g.a.a().a(str2, str);
        } catch (Exception e) {
            be.b("TiebaStatic", "setUserInfo", e.toString());
        }
    }

    public static void a(z zVar) {
        if (zVar != null && zVar.b() <= 180000) {
            try {
                if (zVar.b() >= 0 && zVar.g() >= 0 && zVar.f() >= 0 && zVar.i() >= 0) {
                    com.baidu.adp.lib.g.a.a().a(zVar.c(), zVar.e(), zVar.d(), zVar.b(), zVar.g(), zVar.f(), zVar.i(), zVar.h(), zVar.j());
                }
                be.b("api=" + zVar.c() + " downsize=" + zVar.e() + " upsize=" + zVar.d() + " dns=" + zVar.g() + " cost=" + zVar.b() + " conTime=" + zVar.f() + " rspTime=" + zVar.i() + " retry=" + zVar.h() + " errorCode=" + zVar.j());
            } catch (Exception e) {
                e.printStackTrace();
                be.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
            }
        }
    }

    public static void a(long j, int i, String str) {
        com.baidu.adp.lib.g.a.a().a(true, "module", "msg", "message_id", Long.valueOf(j), "op_type", Integer.valueOf(i), "stat", 2, "link", str);
    }

    public static void a(String str, long j, long j2) {
        if (j <= 180000) {
            try {
                com.baidu.adp.lib.g.a.a().a(str, j, j2);
            } catch (Exception e) {
                be.b("TiebaStatic", "op", e.toString());
            }
        }
    }

    public static void a(String str) {
        try {
            com.baidu.adp.lib.g.a.a().a(str);
        } catch (Exception e) {
            be.b("TiebaStatic", "crash", e.toString());
        }
    }

    public static void a() {
        try {
            com.baidu.adp.lib.g.a.a().b();
        } catch (Exception e) {
            be.b("TiebaStatic", "upload", e.toString());
        }
    }
}
