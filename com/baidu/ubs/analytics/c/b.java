package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0642a kVW;
    private static a.InterfaceC0642a kVX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.Ls(" ActivityLifeTask   add  " + new Date().toLocaleString());
                kVW = new c();
                kVX = new m();
                a.cXq().cXs();
                a.cXq().a(kVX);
                a.cXq().a(kVW);
                a.cXq().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.Ls(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
