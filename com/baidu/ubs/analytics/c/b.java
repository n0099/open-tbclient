package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0765a mhK;
    private static a.InterfaceC0765a mhL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.I(" ActivityLifeTask   add  " + new Date().toLocaleString());
                mhK = new c();
                mhL = new m();
                a.dso().S();
                a.dso().a(mhL);
                a.dso().a(mhK);
                a.dso().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.I(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
