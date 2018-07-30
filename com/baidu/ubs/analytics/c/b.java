package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0263a hCw;
    private static a.InterfaceC0263a hCx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.we(" ActivityLifeTask   add  " + new Date().toLocaleString());
                hCw = new c();
                hCx = new m();
                a.bIX().S();
                a.bIX().a(hCx);
                a.bIX().a(hCw);
                a.bIX().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.we(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
