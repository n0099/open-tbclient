package com.baidu.tieba.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class av {

    /* renamed from: a  reason: collision with root package name */
    public static int f2590a;
    private static av b;
    private static long d;
    private static volatile int c = 0;
    private static int e = 300000;
    private static int f = 10;

    private av() {
        f2590a = TiebaApplication.h().aU();
    }

    public static synchronized av a() {
        av avVar;
        synchronized (av.class) {
            if (b == null) {
                b = new av();
            }
            avVar = b;
        }
        return avVar;
    }

    public af a(aw awVar) {
        switch (f2590a) {
            case 0:
                return new NetWorkCore(awVar);
            case 1:
                return new NetWorkCoreByBdHttp(awVar);
            default:
                return new NetWorkCoreByBdHttp(awVar);
        }
    }

    public static synchronized void b() {
        synchronized (av.class) {
            if (f2590a == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d < e) {
                    c++;
                    bd.c(av.class.getName(), "addError", "发生一次新网络内核不通畅警告！ errotime:" + c);
                    if (c > f) {
                        f2590a = 0;
                        bd.b(av.class.getName(), "addError", "切换会老的网络内核");
                        TiebaApplication.h().k(f2590a);
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
        f2590a = i;
    }
}
