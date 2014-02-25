package com.baidu.tieba.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class bf {
    public static int a;
    private static bf b;
    private static long d;
    private static volatile int c = 0;
    private static int e = 300000;
    private static int f = 10;

    private bf() {
        a = TiebaApplication.g().aP();
    }

    public static synchronized bf a() {
        bf bfVar;
        synchronized (bf.class) {
            if (b == null) {
                b = new bf();
            }
            bfVar = b;
        }
        return bfVar;
    }

    public an a(bj bjVar) {
        switch (a) {
            case 0:
                return new NetWorkCore(bjVar);
            case 1:
                return new NetWorkCoreByBdHttp(bjVar);
            default:
                return new NetWorkCoreByBdHttp(bjVar);
        }
    }

    public static synchronized void b() {
        synchronized (bf.class) {
            if (a == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d < e) {
                    c++;
                    com.baidu.adp.lib.util.f.c(bf.class.getName(), "addError", "发生一次新网络内核不通畅警告！ errotime:" + c);
                    if (c > f) {
                        a = 0;
                        com.baidu.adp.lib.util.f.b(bf.class.getName(), "addError", "切换会老的网络内核");
                        TiebaApplication.g().k(a);
                        cb.a(TiebaApplication.g().b().getApplicationContext(), "network_core", "current Net：" + UtilHelper.h(TiebaApplication.g().b().getApplicationContext()) + ", TelType:" + com.baidu.adp.lib.network.i.c() + ", wap:" + c(), 1, new Object[0]);
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
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) TiebaApplication.g().b().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
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
