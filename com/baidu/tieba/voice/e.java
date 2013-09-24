package com.baidu.tieba.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class e {
    private static g b;
    private static String c;
    private static q d;

    /* renamed from: a  reason: collision with root package name */
    private static int f2032a = 0;
    private static long e = 0;
    private static Handler f = new Handler(new f());

    public static boolean a(String str, int i, q qVar) {
        long currentTimeMillis = System.currentTimeMillis() - e;
        if (currentTimeMillis < 1000) {
            com.baidu.adp.lib.f.d.b("----start duration......" + currentTimeMillis);
            return false;
        }
        e = System.currentTimeMillis();
        if (f2032a == 0) {
            if (b == null) {
                b = new g(f);
            }
            c = str;
            d = qVar;
            if (b.a(str, i)) {
                f2032a = 3;
                com.baidu.adp.lib.f.d.b("----start record......");
                new Thread(b).start();
                return true;
            }
            return false;
        }
        com.baidu.adp.lib.f.d.b("----start record state......" + f2032a);
        return false;
    }

    public static void a() {
        com.baidu.adp.lib.f.d.b("----stop record......");
        if (b != null) {
            b.a();
        }
        f2032a = 0;
    }
}
