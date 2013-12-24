package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class bf {
    public static void a(Context context) {
        try {
            com.baidu.adp.lib.g.a.a().a(context, com.baidu.tieba.data.h.j(), com.baidu.tieba.data.h.a(), TiebaApplication.L(), "tieba", "tieba_android");
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

    public static void a(ag agVar) {
        if (agVar != null && agVar.b() <= 180000) {
            try {
                if (agVar.b() >= 0 && agVar.f() >= 0 && agVar.i() >= 0) {
                    com.baidu.adp.lib.g.a.a().a(agVar.c(), agVar.A(), agVar.e(), agVar.d(), agVar.b(), agVar.g(), agVar.f(), agVar.i(), agVar.h(), !agVar.p() ? agVar.y() : agVar.j());
                }
                be.b("api=" + agVar.c() + " downsize=" + agVar.e() + " upsize=" + agVar.d() + " dns=" + agVar.g() + " cost=" + agVar.b() + " conTime=" + agVar.f() + " rspTime=" + agVar.i() + " retry=" + agVar.h() + " errorCode=" + agVar.j());
            } catch (Exception e) {
                e.printStackTrace();
                be.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
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
