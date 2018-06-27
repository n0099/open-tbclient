package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0263a hBR;
    private static a.InterfaceC0263a hBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.wd(" ActivityLifeTask   add  " + new Date().toLocaleString());
                hBR = new c();
                hBS = new m();
                a.bKt().S();
                a.bKt().a(hBS);
                a.bKt().a(hBR);
                a.bKt().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.wd(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
