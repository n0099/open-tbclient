package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0325a jwH;
    private static a.InterfaceC0325a jwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.EW(" ActivityLifeTask   add  " + new Date().toLocaleString());
                jwH = new c();
                jwI = new m();
                a.csg().S();
                a.csg().a(jwI);
                a.csg().a(jwH);
                a.csg().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.EW(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
