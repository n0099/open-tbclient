package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0347a ihc;
    private static a.InterfaceC0347a ihd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.yU(" ActivityLifeTask   add  " + new Date().toLocaleString());
                ihc = new c();
                ihd = new m();
                a.bTk().S();
                a.bTk().a(ihd);
                a.bTk().a(ihc);
                a.bTk().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.yU(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
