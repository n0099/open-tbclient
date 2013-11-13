package com.baidu.tieba.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class f {
    private static h b;
    private static String c;
    private static r d;

    /* renamed from: a  reason: collision with root package name */
    private static int f2625a = 0;
    private static long e = 0;
    private static Handler f = new Handler(new g());

    public static boolean a(String str, int i, r rVar) {
        long currentTimeMillis = System.currentTimeMillis() - e;
        if (currentTimeMillis < 1000) {
            com.baidu.adp.lib.h.d.c("----start duration......" + currentTimeMillis);
            return false;
        }
        e = System.currentTimeMillis();
        if (f2625a == 0) {
            if (b == null) {
                b = new h(f);
            }
            c = str;
            d = rVar;
            if (b.a(str, i)) {
                f2625a = 3;
                com.baidu.adp.lib.h.d.c("----start record......");
                new Thread(b).start();
                return true;
            }
            return false;
        }
        com.baidu.adp.lib.h.d.c("----start record state......" + f2625a);
        return false;
    }

    public static void a() {
        com.baidu.adp.lib.h.d.c("----stop record......");
        if (b != null) {
            b.a();
        }
        f2625a = 0;
    }

    public static void b() {
        com.baidu.adp.lib.h.d.c("----cancel record......");
        if (b != null) {
            b.b();
        }
        f2625a = 0;
    }
}
