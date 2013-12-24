package com.baidu.tieba.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class aw {
    public static int a;
    private static aw b;
    private static long d;
    private static volatile int c = 0;
    private static int e = 300000;
    private static int f = 10;

    private aw() {
        a = TiebaApplication.h().aU();
    }

    public static synchronized aw a() {
        aw awVar;
        synchronized (aw.class) {
            if (b == null) {
                b = new aw();
            }
            awVar = b;
        }
        return awVar;
    }

    public ag a(ax axVar) {
        switch (a) {
            case 0:
                return new NetWorkCore(axVar);
            case 1:
                return new NetWorkCoreByBdHttp(axVar);
            default:
                return new NetWorkCoreByBdHttp(axVar);
        }
    }

    public static synchronized void b() {
        synchronized (aw.class) {
            if (a == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d < e) {
                    c++;
                    be.c(aw.class.getName(), "addError", "发生一次新网络内核不通畅警告！ errotime:" + c);
                    if (c > f) {
                        a = 0;
                        be.b(aw.class.getName(), "addError", "切换会老的网络内核");
                        TiebaApplication.h().k(a);
                        if (TiebaApplication.h().t()) {
                            StatService.onEvent(TiebaApplication.h().getApplicationContext(), "network_core", "current Net：" + UtilHelper.g(TiebaApplication.h().getApplicationContext()) + ", TelType:" + com.baidu.adp.lib.network.g.c() + ", wap:" + c(), 1);
                        }
                    }
                } else {
                    c = 0;
                    d = currentTimeMillis;
                }
            }
        }
    }

    public static String c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) TiebaApplication.h().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    return "wifi";
                }
                String defaultHost = Proxy.getDefaultHost();
                if (defaultHost != null) {
                    if (defaultHost.length() > 0) {
                        return com.baidu.loginshare.e.d;
                    }
                }
                return com.baidu.loginshare.e.e;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static void a(int i) {
        a = i;
    }
}
