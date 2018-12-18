package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0348a icH;
    private static a.InterfaceC0348a icI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.yB(" ActivityLifeTask   add  " + new Date().toLocaleString());
                icH = new c();
                icI = new m();
                a.bRL().S();
                a.bRL().a(icI);
                a.bRL().a(icH);
                a.bRL().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.yB(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
