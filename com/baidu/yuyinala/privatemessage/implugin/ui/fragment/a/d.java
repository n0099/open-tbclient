package com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class d {
    private static d oRx;
    private a oRA;
    private b oRy;
    private b oRz;
    private String oRB = "";
    private ConcurrentHashMap<String, c> oRC = new ConcurrentHashMap<>(4);
    private AtomicInteger mOpenCounter = new AtomicInteger();

    public static d emz() {
        if (oRx == null) {
            synchronized (d.class) {
                if (oRx == null) {
                    oRx = new d();
                }
            }
        }
        return oRx;
    }

    public c YK(String str) {
        return this.oRC.get(str);
    }

    public String emA() {
        return this.oRB;
    }

    public void a(String str, c cVar) {
        this.oRB = str;
        if (cVar != null) {
            this.oRC.put(str, cVar);
        }
    }

    public void YL(String str) {
        if (this.oRC.containsKey(str)) {
            this.oRC.remove(str);
        }
    }

    public b emB() {
        return this.oRy;
    }

    public void a(b bVar) {
        this.oRy = bVar;
    }

    public b emC() {
        return this.oRz;
    }

    public void b(b bVar) {
        this.oRz = bVar;
    }

    public static void emD() {
        oRx = null;
    }

    public a emE() {
        return this.oRA;
    }
}
