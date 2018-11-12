package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0334a hVx;
    private static a.InterfaceC0334a hVy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.xY(" ActivityLifeTask   add  " + new Date().toLocaleString());
                hVx = new c();
                hVy = new m();
                a.bPG().S();
                a.bPG().a(hVy);
                a.bPG().a(hVx);
                a.bPG().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.xY(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
