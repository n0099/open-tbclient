package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class bp {
    public static void a(Context context) {
        try {
            com.baidu.adp.lib.g.a.a().a(context, com.baidu.tieba.data.h.j(), com.baidu.tieba.data.h.a(), TiebaApplication.L(), "tieba", "tieba_android");
        } catch (Exception e) {
            bo.b("TiebaStatic", "init", e.toString());
        }
    }

    public static void a(String str, String str2) {
        try {
            com.baidu.adp.lib.g.a.a().a(str2, str);
        } catch (Exception e) {
            bo.b("TiebaStatic", "setUserInfo", e.toString());
        }
    }

    public static void a(ai aiVar) {
        if (aiVar != null && aiVar.b() <= 180000) {
            try {
                if (aiVar.b() >= 0 && aiVar.f() >= 0 && aiVar.i() >= 0) {
                    com.baidu.adp.lib.g.a.a().a(aiVar.c(), aiVar.A(), aiVar.e(), aiVar.d(), aiVar.b(), aiVar.g(), aiVar.f(), aiVar.i(), aiVar.h(), !aiVar.p() ? aiVar.y() : aiVar.j());
                }
                bo.b("api=" + aiVar.c() + " downsize=" + aiVar.e() + " upsize=" + aiVar.d() + " dns=" + aiVar.g() + " cost=" + aiVar.b() + " conTime=" + aiVar.f() + " rspTime=" + aiVar.i() + " retry=" + aiVar.h() + " errorCode=" + aiVar.j());
            } catch (Exception e) {
                e.printStackTrace();
                bo.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
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
                bo.b("TiebaStatic", "op", e.toString());
            }
        }
    }

    public static void a(String str) {
        try {
            com.baidu.adp.lib.g.a.a().a(str);
        } catch (Exception e) {
            bo.b("TiebaStatic", "crash", e.toString());
        }
    }

    public static void a() {
        try {
            com.baidu.adp.lib.g.a.a().b();
        } catch (Exception e) {
            bo.b("TiebaStatic", "upload", e.toString());
        }
    }
}
