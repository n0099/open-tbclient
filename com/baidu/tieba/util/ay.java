package com.baidu.tieba.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    public static int f2477a;
    private static ay b;
    private static long d;
    private static volatile int c = 0;
    private static int e = 300000;
    private static int f = 10;

    private ay() {
        f2477a = TiebaApplication.g().aT();
    }

    public static synchronized ay a() {
        ay ayVar;
        synchronized (ay.class) {
            if (b == null) {
                b = new ay();
            }
            ayVar = b;
        }
        return ayVar;
    }

    public ai a(az azVar) {
        switch (f2477a) {
            case 0:
                return new NetWorkCore(azVar);
            case 1:
                return new NetWorkCoreByBdHttp(azVar);
            default:
                return new NetWorkCoreByBdHttp(azVar);
        }
    }

    public static synchronized void b() {
        synchronized (ay.class) {
            if (f2477a == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d < e) {
                    c++;
                    bg.c(ay.class.getName(), "addError", "发生一次新网络内核不通畅警告！ errotime:" + c);
                    if (c > f) {
                        f2477a = 0;
                        bg.b(ay.class.getName(), "addError", "切换会老的网络内核");
                        TiebaApplication.g().l(f2477a);
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
        f2477a = i;
    }
}
