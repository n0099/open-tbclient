package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0445a jWC;
    private static a.InterfaceC0445a jWD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.Hn(" ActivityLifeTask   add  " + new Date().toLocaleString());
                jWC = new c();
                jWD = new m();
                a.cDo().S();
                a.cDo().a(jWD);
                a.cDo().a(jWC);
                a.cDo().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.Hn(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
