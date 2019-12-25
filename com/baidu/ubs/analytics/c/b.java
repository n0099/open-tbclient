package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0629a kRK;
    private static a.InterfaceC0629a kRL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.KV(" ActivityLifeTask   add  " + new Date().toLocaleString());
                kRK = new c();
                kRL = new m();
                a.cUX().cUZ();
                a.cUX().a(kRL);
                a.cUX().a(kRK);
                a.cUX().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.KV(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
