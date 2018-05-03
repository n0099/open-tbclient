package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0244a hkL;
    private static a.InterfaceC0244a hkM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.vk(" ActivityLifeTask   add  " + new Date().toLocaleString());
                hkL = new c();
                hkM = new m();
                a.bEQ().S();
                a.bEQ().a(hkM);
                a.bEQ().a(hkL);
                a.bEQ().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.vk(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
