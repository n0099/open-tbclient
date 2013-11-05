package com.baidu.tieba.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    public static int f2426a;
    private static ap b;
    private static long d;
    private static volatile int c = 0;
    private static int e = 300000;
    private static int f = 10;

    private ap() {
        f2426a = TiebaApplication.g().aW();
    }

    public static synchronized ap a() {
        ap apVar;
        synchronized (ap.class) {
            if (b == null) {
                b = new ap();
            }
            apVar = b;
        }
        return apVar;
    }

    public z a(aq aqVar) {
        switch (f2426a) {
            case 0:
                return new NetWorkCore(aqVar);
            case 1:
                return new NetWorkCoreByBdHttp(aqVar);
            default:
                return new NetWorkCoreByBdHttp(aqVar);
        }
    }

    public static synchronized void b() {
        synchronized (ap.class) {
            if (f2426a == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d < e) {
                    c++;
                    be.c(ap.class.getName(), "addError", "发生一次新网络内核不通畅警告！ errotime:" + c);
                    if (c > f) {
                        f2426a = 0;
                        be.b(ap.class.getName(), "addError", "切换会老的网络内核");
                        TiebaApplication.g().o(f2426a);
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

    public static void a(int i) {
        f2426a = i;
    }
}
