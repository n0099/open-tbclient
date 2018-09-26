package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0269a hKU;
    private static a.InterfaceC0269a hKV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.wT(" ActivityLifeTask   add  " + new Date().toLocaleString());
                hKU = new c();
                hKV = new m();
                a.bLS().S();
                a.bLS().a(hKV);
                a.bLS().a(hKU);
                a.bLS().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.wT(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
