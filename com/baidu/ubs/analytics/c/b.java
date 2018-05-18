package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0244a hlP;
    private static a.InterfaceC0244a hlQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.vn(" ActivityLifeTask   add  " + new Date().toLocaleString());
                hlP = new c();
                hlQ = new m();
                a.bEO().S();
                a.bEO().a(hlQ);
                a.bEO().a(hlP);
                a.bEO().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.vn(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
