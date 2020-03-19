package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0643a kXN;
    private static a.InterfaceC0643a kXO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.Lt(" ActivityLifeTask   add  " + new Date().toLocaleString());
                kXN = new c();
                kXO = new m();
                a.cXR().cXT();
                a.cXR().a(kXO);
                a.cXR().a(kXN);
                a.cXR().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.Lt(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
