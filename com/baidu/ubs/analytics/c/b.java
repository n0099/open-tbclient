package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0261a hxK;
    private static a.InterfaceC0261a hxL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.wh(" ActivityLifeTask   add  " + new Date().toLocaleString());
                hxK = new c();
                hxL = new m();
                a.bJS().S();
                a.bJS().a(hxL);
                a.bJS().a(hxK);
                a.bJS().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.wh(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
