package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ar {
    public static void a(Context context) {
        try {
            com.baidu.adp.lib.d.a.a().a(context, com.baidu.tieba.data.g.j(), com.baidu.tieba.data.g.a(), TiebaApplication.Q(), "tieba", "tieba_android");
        } catch (Exception e) {
            aq.b("TiebaStatic", "init", e.toString());
        }
    }

    public static void a(String str, String str2) {
        try {
            com.baidu.adp.lib.d.a.a().a(str2, str);
        } catch (Exception e) {
            aq.b("TiebaStatic", "setUserInfo", e.toString());
        }
    }

    public static void a(s sVar) {
        if (sVar != null && sVar.a() <= 180000) {
            try {
                if (sVar.a() >= 0 && sVar.f() >= 0 && sVar.e() >= 0 && sVar.h() >= 0) {
                    com.baidu.adp.lib.d.a.a().a(sVar.b(), sVar.d(), sVar.c(), sVar.a(), sVar.f(), sVar.e(), sVar.h(), sVar.g(), sVar.i());
                }
                aq.b("api=" + sVar.b() + " downsize=" + sVar.d() + " upsize=" + sVar.c() + " dns=" + sVar.f() + " cost=" + sVar.a() + " conTime=" + sVar.e() + " rspTime=" + sVar.h() + " retry=" + sVar.g() + " errorCode=" + sVar.i());
            } catch (Exception e) {
                aq.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
            }
        }
    }

    public static void a(String str, long j, long j2) {
        if (j <= 180000) {
            try {
                com.baidu.adp.lib.d.a.a().a(str, j, j2);
            } catch (Exception e) {
                aq.b("TiebaStatic", "op", e.toString());
            }
        }
    }

    public static void a(String str) {
        try {
            com.baidu.adp.lib.d.a.a().a(str);
        } catch (Exception e) {
            aq.b("TiebaStatic", "crash", e.toString());
        }
    }

    public static void a() {
        try {
            com.baidu.adp.lib.d.a.a().b();
        } catch (Exception e) {
            aq.b("TiebaStatic", "upload", e.toString());
        }
    }
}
