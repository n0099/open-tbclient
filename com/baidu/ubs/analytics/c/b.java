package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0328a jxa;
    private static a.InterfaceC0328a jxb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.EZ(" ActivityLifeTask   add  " + new Date().toLocaleString());
                jxa = new c();
                jxb = new m();
                a.csq().S();
                a.csq().a(jxb);
                a.csq().a(jxa);
                a.csq().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.EZ(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
