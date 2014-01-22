package com.baidu.tieba.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class bg {
    public static int a;
    private static bg b;
    private static long d;
    private static volatile int c = 0;
    private static int e = 300000;
    private static int f = 10;

    private bg() {
        a = TiebaApplication.h().aS();
    }

    public static synchronized bg a() {
        bg bgVar;
        synchronized (bg.class) {
            if (b == null) {
                b = new bg();
            }
            bgVar = b;
        }
        return bgVar;
    }

    public al a(bl blVar) {
        switch (a) {
            case 0:
                return new NetWorkCore(blVar);
            case 1:
                return new NetWorkCoreByBdHttp(blVar);
            default:
                return new NetWorkCoreByBdHttp(blVar);
        }
    }

    public static synchronized void b() {
        synchronized (bg.class) {
            if (a == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d < e) {
                    c++;
                    com.baidu.adp.lib.g.e.c(bg.class.getName(), "addError", "发生一次新网络内核不通畅警告！ errotime:" + c);
                    if (c > f) {
                        a = 0;
                        com.baidu.adp.lib.g.e.b(bg.class.getName(), "addError", "切换会老的网络内核");
                        TiebaApplication.h().k(a);
                        by.a(TiebaApplication.h().getApplicationContext(), "network_core", "current Net：" + UtilHelper.g(TiebaApplication.h().getApplicationContext()) + ", TelType:" + com.baidu.adp.lib.network.i.c() + ", wap:" + c(), 1, new Object[0]);
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
