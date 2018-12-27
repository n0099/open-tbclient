package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0348a ifU;
    private static a.InterfaceC0348a ifV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.yE(" ActivityLifeTask   add  " + new Date().toLocaleString());
                ifU = new c();
                ifV = new m();
                a.bSC().S();
                a.bSC().a(ifV);
                a.bSC().a(ifU);
                a.bSC().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.yE(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
