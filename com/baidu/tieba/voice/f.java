package com.baidu.tieba.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class f {
    private static h b;
    private static String c;
    private static r d;
    private static int a = 0;
    private static long e = 0;
    private static Handler f = new Handler(new g());

    public static boolean a(String str, int i, r rVar) {
        long currentTimeMillis = System.currentTimeMillis() - e;
        if (currentTimeMillis < 1000) {
            com.baidu.adp.lib.g.e.c("----start duration......" + currentTimeMillis);
            return false;
        }
        e = System.currentTimeMillis();
        if (a == 0) {
            if (b == null) {
                b = new h(f);
            }
            c = str;
            d = rVar;
            if (b.a(str, i)) {
                a = 3;
                com.baidu.adp.lib.g.e.c("----start record......");
                new Thread(b).start();
                return true;
            }
            return false;
        }
        com.baidu.adp.lib.g.e.c("----start record state......" + a);
        return false;
    }

    public static void a() {
        com.baidu.adp.lib.g.e.c("----stop record......");
        if (b != null) {
            b.a();
        }
        a = 0;
    }

    public static void b() {
        com.baidu.adp.lib.g.e.c("----cancel record......");
        if (b != null) {
            b.b();
        }
        a = 0;
    }
}
