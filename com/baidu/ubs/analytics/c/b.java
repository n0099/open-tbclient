package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0551a jYe;
    private static a.InterfaceC0551a jYf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.Gf(" ActivityLifeTask   add  " + new Date().toLocaleString());
                jYe = new c();
                jYf = new m();
                a.cBh().cBj();
                a.cBh().a(jYf);
                a.cBh().a(jYe);
                a.cBh().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.Gf(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
