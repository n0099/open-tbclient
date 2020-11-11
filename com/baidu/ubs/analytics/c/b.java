package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0930a orq;
    private static a.InterfaceC0930a orr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.I(" ActivityLifeTask   add  " + new Date().toLocaleString());
                orq = new c();
                orr = new m();
                a.edD().S();
                a.edD().a(orr);
                a.edD().a(orq);
                a.edD().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.I(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
