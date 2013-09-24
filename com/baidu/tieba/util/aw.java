package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class aw {
    public static void a(Context context) {
        try {
            com.baidu.adp.lib.e.a.a().a(context, com.baidu.tieba.data.g.j(), com.baidu.tieba.data.g.a(), TiebaApplication.O(), "tieba", "tieba_android");
        } catch (Exception e) {
            av.b("TiebaStatic", "init", e.toString());
        }
    }

    public static void a(String str, String str2) {
        try {
            com.baidu.adp.lib.e.a.a().a(str2, str);
        } catch (Exception e) {
            av.b("TiebaStatic", "setUserInfo", e.toString());
        }
    }

    public static void a(s sVar) {
        if (sVar != null && sVar.b() <= 180000) {
            try {
                if (sVar.b() >= 0 && sVar.g() >= 0 && sVar.f() >= 0 && sVar.i() >= 0) {
                    com.baidu.adp.lib.e.a.a().a(sVar.c(), sVar.e(), sVar.d(), sVar.b(), sVar.g(), sVar.f(), sVar.i(), sVar.h(), sVar.j());
                }
                av.b("api=" + sVar.c() + " downsize=" + sVar.e() + " upsize=" + sVar.d() + " dns=" + sVar.g() + " cost=" + sVar.b() + " conTime=" + sVar.f() + " rspTime=" + sVar.i() + " retry=" + sVar.h() + " errorCode=" + sVar.j());
            } catch (Exception e) {
                av.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
            }
        }
    }

    public static void a(String str, long j, long j2) {
        if (j <= 180000) {
            try {
                com.baidu.adp.lib.e.a.a().a(str, j, j2);
            } catch (Exception e) {
                av.b("TiebaStatic", "op", e.toString());
            }
        }
    }

    public static void a(String str) {
        try {
            com.baidu.adp.lib.e.a.a().a(str);
        } catch (Exception e) {
            av.b("TiebaStatic", "crash", e.toString());
        }
    }

    public static void a() {
        try {
            com.baidu.adp.lib.e.a.a().b();
        } catch (Exception e) {
            av.b("TiebaStatic", "upload", e.toString());
        }
    }
}
