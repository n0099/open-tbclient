package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ak {
    public static void a(Context context) {
        try {
            com.baidu.adp.lib.d.a.a().a(context, com.baidu.tieba.data.g.i(), com.baidu.tieba.data.g.a(), TiebaApplication.Q(), "tieba", "tieba_android");
        } catch (Exception e) {
            aj.b("TiebaStatic", "init", e.toString());
        }
    }

    public static void a(String str, String str2) {
        try {
            com.baidu.adp.lib.d.a.a().a(str2, str);
        } catch (Exception e) {
            aj.b("TiebaStatic", "setUserInfo", e.toString());
        }
    }

    public static void a(NetWorkCore netWorkCore) {
        if (netWorkCore != null && netWorkCore.g() <= 180000) {
            try {
                com.baidu.adp.lib.d.a.a().a(netWorkCore.f(), netWorkCore.b(), netWorkCore.a(), netWorkCore.g(), 0L, netWorkCore.c(), netWorkCore.d(), netWorkCore.e(), netWorkCore.p());
                aj.b("api=" + netWorkCore.f() + " downsize=" + netWorkCore.b() + " upsize=" + netWorkCore.a() + " cost=" + netWorkCore.g() + " conTime=" + netWorkCore.c() + " rspTime=" + netWorkCore.d() + " retry=" + netWorkCore.e() + " errorCode=" + netWorkCore.p());
            } catch (Exception e) {
                aj.b("TiebaStatic", com.baidu.loginshare.e.e, e.toString());
            }
        }
    }

    public static void a(String str, long j, long j2) {
        if (j <= 180000) {
            try {
                com.baidu.adp.lib.d.a.a().a(str, j, j2);
            } catch (Exception e) {
                aj.b("TiebaStatic", "op", e.toString());
            }
        }
    }

    public static void a(String str) {
        try {
            com.baidu.adp.lib.d.a.a().a(str);
        } catch (Exception e) {
            aj.b("TiebaStatic", "crash", e.toString());
        }
    }

    public static void a() {
        try {
            com.baidu.adp.lib.d.a.a().b();
        } catch (Exception e) {
            aj.b("TiebaStatic", "upload", e.toString());
        }
    }
}
