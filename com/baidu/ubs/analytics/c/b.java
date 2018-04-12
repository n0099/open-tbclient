package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0244a hkO;
    private static a.InterfaceC0244a hkP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.vk(" ActivityLifeTask   add  " + new Date().toLocaleString());
                hkO = new c();
                hkP = new m();
                a.bEQ().S();
                a.bEQ().a(hkP);
                a.bEQ().a(hkO);
                a.bEQ().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.vk(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
