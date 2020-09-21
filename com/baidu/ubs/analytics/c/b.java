package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0846a nqo;
    private static a.InterfaceC0846a nqp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.I(" ActivityLifeTask   add  " + new Date().toLocaleString());
                nqo = new c();
                nqp = new m();
                a.dQs().S();
                a.dQs().a(nqp);
                a.dQs().a(nqo);
                a.dQs().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.I(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
