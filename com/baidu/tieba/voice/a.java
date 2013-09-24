package com.baidu.tieba.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c b;
    private static String c;
    private static i d;

    /* renamed from: a  reason: collision with root package name */
    private static int f2017a = 0;
    private static Handler e = new Handler(new b());

    public static boolean a(String str, i iVar, int i) {
        if (f2017a == 0) {
            if (b == null) {
                b = new c(e, i);
            } else {
                b.a(i);
            }
            c = str;
            d = iVar;
            b.a(str);
            f2017a = 2;
            new Thread(b).start();
            return true;
        }
        return false;
    }

    public static void a() {
        if (b != null) {
            b.c();
        } else {
            f2017a = 0;
        }
    }
}
