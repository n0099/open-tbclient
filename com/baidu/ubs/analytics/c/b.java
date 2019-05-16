package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0440a jPA;
    private static a.InterfaceC0440a jPz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.Gr(" ActivityLifeTask   add  " + new Date().toLocaleString());
                jPz = new c();
                jPA = new m();
                a.cAo().S();
                a.cAo().a(jPA);
                a.cAo().a(jPz);
                a.cAo().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.Gr(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
