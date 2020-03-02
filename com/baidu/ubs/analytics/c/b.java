package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0642a kVY;
    private static a.InterfaceC0642a kVZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.Ls(" ActivityLifeTask   add  " + new Date().toLocaleString());
                kVY = new c();
                kVZ = new m();
                a.cXs().cXu();
                a.cXs().a(kVZ);
                a.cXs().a(kVY);
                a.cXs().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.Ls(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
