package com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class d {
    private static d oTd;
    private b oTe;
    private b oTf;
    private a oTg;
    private String oTh = "";
    private ConcurrentHashMap<String, c> oTi = new ConcurrentHashMap<>(4);
    private AtomicInteger mOpenCounter = new AtomicInteger();

    public static d eiJ() {
        if (oTd == null) {
            synchronized (d.class) {
                if (oTd == null) {
                    oTd = new d();
                }
            }
        }
        return oTd;
    }

    public c Xm(String str) {
        return this.oTi.get(str);
    }

    public String eiK() {
        return this.oTh;
    }

    public void a(String str, c cVar) {
        this.oTh = str;
        if (cVar != null) {
            this.oTi.put(str, cVar);
        }
    }

    public void Xn(String str) {
        if (this.oTi.containsKey(str)) {
            this.oTi.remove(str);
        }
    }

    public b eiL() {
        return this.oTe;
    }

    public void a(b bVar) {
        this.oTe = bVar;
    }

    public b eiM() {
        return this.oTf;
    }

    public void b(b bVar) {
        this.oTf = bVar;
    }

    public static void eiN() {
        oTd = null;
    }

    public a eiO() {
        return this.oTg;
    }
}
