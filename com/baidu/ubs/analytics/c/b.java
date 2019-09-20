package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0456a kaf;
    private static a.InterfaceC0456a kag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.HO(" ActivityLifeTask   add  " + new Date().toLocaleString());
                kaf = new c();
                kag = new m();
                a.cEx().S();
                a.cEx().a(kag);
                a.cEx().a(kaf);
                a.cEx().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.HO(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
