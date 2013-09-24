package com.baidu.tieba.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    public static int f1896a;
    private static ag b;
    private static long d;
    private static volatile int c = 0;
    private static int e = 300000;
    private static int f = 10;

    private ag() {
        f1896a = TiebaApplication.g().aR();
    }

    public static synchronized ag a() {
        ag agVar;
        synchronized (ag.class) {
            if (b == null) {
                b = new ag();
            }
            agVar = b;
        }
        return agVar;
    }

    public s a(ah ahVar) {
        switch (f1896a) {
            case 0:
                return new NetWorkCore(ahVar);
            case 1:
                return new NetWorkCoreByBdHttp(ahVar);
            default:
                return new NetWorkCoreByBdHttp(ahVar);
        }
    }

    public static synchronized void b() {
        synchronized (ag.class) {
            if (f1896a == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d < e) {
                    c++;
                    av.c(ag.class.getName(), "addError", "发生一次新网络内核不通畅警告！ errotime:" + c);
                    if (c > f) {
                        f1896a = 0;
                        av.b(ag.class.getName(), "addError", "切换会老的网络内核");
                        TiebaApplication.g().o(f1896a);
                        if (TiebaApplication.g().s()) {
                            StatService.onEvent(TiebaApplication.g().getApplicationContext(), "network_core", "current Net：" + UtilHelper.i(TiebaApplication.g().getApplicationContext()) + ", TelType:" + com.baidu.adp.lib.network.g.c() + ", wap:" + c(), 1);
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
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) TiebaApplication.g().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
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
}
