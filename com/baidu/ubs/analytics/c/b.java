package com.baidu.ubs.analytics.c;

import android.content.Context;
import com.baidu.ubs.analytics.c.a;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b {
    private static boolean ad = false;
    private static a.InterfaceC0634a kVl;
    private static a.InterfaceC0634a kVm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (!ad) {
                com.baidu.ubs.analytics.d.b.Lf(" ActivityLifeTask   add  " + new Date().toLocaleString());
                kVl = new c();
                kVm = new m();
                a.cWa().cWc();
                a.cWa().a(kVm);
                a.cWa().a(kVl);
                a.cWa().c(context);
                ad = true;
            } else {
                com.baidu.ubs.analytics.d.b.Lf(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
