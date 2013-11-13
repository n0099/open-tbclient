package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class bh {
    public static void a(Context context) {
        try {
            com.baidu.adp.lib.g.a.a().a(context, com.baidu.tieba.data.h.j(), com.baidu.tieba.data.h.a(), TiebaApplication.N(), "tieba", "tieba_android");
        } catch (Exception e) {
            bg.b("TiebaStatic", "init", e.toString());
        }
    }

    public static void a(String str, String str2) {
        try {
            com.baidu.adp.lib.g.a.a().a(str2, str);
        } catch (Exception e) {
            bg.b("TiebaStatic", "setUserInfo", e.toString());
        }
    }

    public static void a(ai aiVar) {
        if (aiVar != null && aiVar.d() <= 180000) {
            try {
                if (aiVar.d() >= 0 && aiVar.i() >= 0 && aiVar.h() >= 0 && aiVar.k() >= 0) {
                    com.baidu.adp.lib.g.a.a().a(aiVar.e(), aiVar.g(), aiVar.f(), aiVar.d(), aiVar.i(), aiVar.h(), aiVar.k(), aiVar.j(), aiVar.l());
                }
                bg.b("api=" + aiVar.e() + " downsize=" + aiVar.g() + " upsize=" + aiVar.f() + " dns=" + aiVar.i() + " cost=" + aiVar.d() + " conTime=" + aiVar.h() + " rspTime=" + aiVar.k() + " retry=" + aiVar.j() + " errorCode=" + aiVar.l());
            } catch (Exception e) {
                e.printStackTrace();
                bg.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
            }
        }
    }

    public static void b(ai aiVar) {
        int i;
        if (aiVar != null && aiVar.d() <= 180000) {
            try {
                if (aiVar.d() >= 0 && aiVar.i() >= 0 && aiVar.h() >= 0 && aiVar.k() >= 0) {
                    if (bf.a().b()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    com.baidu.adp.lib.g.a.a().a(aiVar.e(), aiVar.g(), aiVar.f(), aiVar.d(), aiVar.i(), aiVar.h(), aiVar.k(), aiVar.j(), aiVar.l(), aiVar.c(), 0, com.baidu.tieba.d.a.a().g(), aiVar.b(), i, System.currentTimeMillis());
                    bg.b("api=" + aiVar.e() + " downsize=" + aiVar.g() + " upsize=" + aiVar.f() + " dns=" + aiVar.i() + " cost=" + aiVar.d() + " conTime=" + aiVar.h() + " rspTime=" + aiVar.k() + " retry=" + aiVar.j() + " errorCode=" + aiVar.l() + " pic_src=" + aiVar.c() + " pic_hit=0 pic_set=" + com.baidu.tieba.d.a.a().g() + " pic_type=" + aiVar.b() + " pic_isbig=" + i + " ts=" + System.currentTimeMillis());
                }
            } catch (Exception e) {
                bg.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
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
                bg.b("TiebaStatic", "op", e.toString());
            }
        }
    }

    public static void a(String str) {
        try {
            com.baidu.adp.lib.g.a.a().a(str);
        } catch (Exception e) {
            bg.b("TiebaStatic", "crash", e.toString());
        }
    }

    public static void a() {
        try {
            com.baidu.adp.lib.g.a.a().b();
        } catch (Exception e) {
            bg.b("TiebaStatic", "upload", e.toString());
        }
    }
}
