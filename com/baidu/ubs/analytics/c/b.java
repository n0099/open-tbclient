package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0849a nfU;
    private static a.InterfaceC0849a nfV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.I(" ActivityLifeTask   add  " + new Date().toLocaleString());
                nfU = new c();
                nfV = new m();
                a.dMl().S();
                a.dMl().a(nfV);
                a.dMl().a(nfU);
                a.dMl().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.I(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
