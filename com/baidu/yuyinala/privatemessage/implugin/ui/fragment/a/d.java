package com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class d {
    private static d oRz;
    private b oRA;
    private b oRB;
    private a oRC;
    private String oRD = "";
    private ConcurrentHashMap<String, c> oRE = new ConcurrentHashMap<>(4);
    private AtomicInteger mOpenCounter = new AtomicInteger();

    public static d emA() {
        if (oRz == null) {
            synchronized (d.class) {
                if (oRz == null) {
                    oRz = new d();
                }
            }
        }
        return oRz;
    }

    public c YK(String str) {
        return this.oRE.get(str);
    }

    public String emB() {
        return this.oRD;
    }

    public void a(String str, c cVar) {
        this.oRD = str;
        if (cVar != null) {
            this.oRE.put(str, cVar);
        }
    }

    public void YL(String str) {
        if (this.oRE.containsKey(str)) {
            this.oRE.remove(str);
        }
    }

    public b emC() {
        return this.oRA;
    }

    public void a(b bVar) {
        this.oRA = bVar;
    }

    public b emD() {
        return this.oRB;
    }

    public void b(b bVar) {
        this.oRB = bVar;
    }

    public static void emE() {
        oRz = null;
    }

    public a emF() {
        return this.oRC;
    }
}
