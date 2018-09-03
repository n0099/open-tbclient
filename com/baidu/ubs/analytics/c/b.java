package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0263a hCy;
    private static a.InterfaceC0263a hCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.wi(" ActivityLifeTask   add  " + new Date().toLocaleString());
                hCy = new c();
                hCz = new m();
                a.bJb().S();
                a.bJb().a(hCz);
                a.bJb().a(hCy);
                a.bJb().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.wi(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
