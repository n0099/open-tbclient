package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0306a hTN;
    private static a.InterfaceC0306a hTO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.xT(" ActivityLifeTask   add  " + new Date().toLocaleString());
                hTN = new c();
                hTO = new m();
                a.bQi().S();
                a.bQi().a(hTO);
                a.bQi().a(hTN);
                a.bQi().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.xT(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
