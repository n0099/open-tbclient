package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0953a oUr;
    private static a.InterfaceC0953a oUs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.I(" ActivityLifeTask   add  " + new Date().toLocaleString());
                oUr = new c();
                oUs = new m();
                a.eij().S();
                a.eij().a(oUs);
                a.eij().a(oUr);
                a.eij().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.I(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
