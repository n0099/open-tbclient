package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0634a kVq;
    private static a.InterfaceC0634a kVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.Lf(" ActivityLifeTask   add  " + new Date().toLocaleString());
                kVq = new c();
                kVr = new m();
                a.cWc().cWe();
                a.cWc().a(kVr);
                a.cWc().a(kVq);
                a.cWc().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.Lf(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
