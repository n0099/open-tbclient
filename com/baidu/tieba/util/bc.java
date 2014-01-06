package com.baidu.tieba.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class bc {
    public static int a;
    private static bc b;
    private static long d;
    private static volatile int c = 0;
    private static int e = 300000;
    private static int f = 10;

    private bc() {
        a = TiebaApplication.g().aU();
    }

    public static synchronized bc a() {
        bc bcVar;
        synchronized (bc.class) {
            if (b == null) {
                b = new bc();
            }
            bcVar = b;
        }
        return bcVar;
    }

    public ai a(bh bhVar) {
        switch (a) {
            case 0:
                return new NetWorkCore(bhVar);
            case 1:
                return new NetWorkCoreByBdHttp(bhVar);
            default:
                return new NetWorkCoreByBdHttp(bhVar);
        }
    }

    public static synchronized void b() {
        synchronized (bc.class) {
            if (a == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d < e) {
                    c++;
                    bo.c(bc.class.getName(), "addError", "发生一次新网络内核不通畅警告！ errotime:" + c);
                    if (c > f) {
                        a = 0;
                        bo.b(bc.class.getName(), "addError", "切换会老的网络内核");
                        TiebaApplication.g().k(a);
                        if (TiebaApplication.g().s()) {
                            StatService.onEvent(TiebaApplication.g().getApplicationContext(), "network_core", "current Net：" + UtilHelper.g(TiebaApplication.g().getApplicationContext()) + ", TelType:" + com.baidu.adp.lib.network.g.c() + ", wap:" + c(), 1);
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
        a = i;
    }
}
