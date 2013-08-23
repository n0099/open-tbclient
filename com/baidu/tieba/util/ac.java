package com.baidu.tieba.util;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    public static int f1777a;
    private static ac b;
    private static long d;
    private static volatile int c = 0;
    private static int e = 300000;
    private static int f = 10;

    private ac() {
        f1777a = TiebaApplication.g().aV();
    }

    public static synchronized ac a() {
        ac acVar;
        synchronized (ac.class) {
            if (b == null) {
                b = new ac();
            }
            acVar = b;
        }
        return acVar;
    }

    public s a(ad adVar) {
        switch (f1777a) {
            case 0:
                return new NetWorkCore(adVar);
            case 1:
                return new NetWorkCoreByBdHttp(adVar);
            default:
                return new NetWorkCoreByBdHttp(adVar);
        }
    }

    public static synchronized void b() {
        synchronized (ac.class) {
            if (f1777a == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d < e) {
                    c++;
                    aq.c(ac.class.getName(), "addError", "发生一次新网络内核不通畅警告！ errotime:" + c);
                    if (c > f) {
                        f1777a = 0;
                        aq.b(ac.class.getName(), "addError", "切换会老的网络内核");
                        TiebaApplication.g().m(f1777a);
                        if (TiebaApplication.g().u()) {
                            StatService.onEvent(TiebaApplication.g().getApplicationContext(), "network_core", "current Net：" + UtilHelper.i(TiebaApplication.g().getApplicationContext()) + "  readNetworkOperatorType:" + com.baidu.adp.lib.network.g.c(), 1);
                        }
                    }
                } else {
                    c = 0;
                    d = currentTimeMillis;
                }
            }
        }
    }
}
