package com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class d {
    private static d oTc;
    private b oTd;
    private b oTe;
    private a oTf;
    private String oTg = "";
    private ConcurrentHashMap<String, c> oTh = new ConcurrentHashMap<>(4);
    private AtomicInteger mOpenCounter = new AtomicInteger();

    public static d eiJ() {
        if (oTc == null) {
            synchronized (d.class) {
                if (oTc == null) {
                    oTc = new d();
                }
            }
        }
        return oTc;
    }

    public c Xl(String str) {
        return this.oTh.get(str);
    }

    public String eiK() {
        return this.oTg;
    }

    public void a(String str, c cVar) {
        this.oTg = str;
        if (cVar != null) {
            this.oTh.put(str, cVar);
        }
    }

    public void Xm(String str) {
        if (this.oTh.containsKey(str)) {
            this.oTh.remove(str);
        }
    }

    public b eiL() {
        return this.oTd;
    }

    public void a(b bVar) {
        this.oTd = bVar;
    }

    public b eiM() {
        return this.oTe;
    }

    public void b(b bVar) {
        this.oTe = bVar;
    }

    public static void eiN() {
        oTc = null;
    }

    public a eiO() {
        return this.oTf;
    }
}
