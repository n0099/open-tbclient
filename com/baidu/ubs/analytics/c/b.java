package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0440a jPD;
    private static a.InterfaceC0440a jPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.Gt(" ActivityLifeTask   add  " + new Date().toLocaleString());
                jPD = new c();
                jPE = new m();
                a.cAp().S();
                a.cAp().a(jPE);
                a.cAp().a(jPD);
                a.cAp().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.Gt(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
