package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0445a jXI;
    private static a.InterfaceC0445a jXJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.Ho(" ActivityLifeTask   add  " + new Date().toLocaleString());
                jXI = new c();
                jXJ = new m();
                a.cDJ().S();
                a.cDJ().a(jXJ);
                a.cDJ().a(jXI);
                a.cDJ().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.Ho(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
