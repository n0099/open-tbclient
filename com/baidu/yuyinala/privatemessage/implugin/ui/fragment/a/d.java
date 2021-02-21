package com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public class d {
    private static d pdQ;
    private b pdR;
    private b pdS;
    private a pdT;
    private String pdU = "";
    private ConcurrentHashMap<String, c> pdV = new ConcurrentHashMap<>(4);
    private AtomicInteger mOpenCounter = new AtomicInteger();

    public static d ell() {
        if (pdQ == null) {
            synchronized (d.class) {
                if (pdQ == null) {
                    pdQ = new d();
                }
            }
        }
        return pdQ;
    }

    public c Yz(String str) {
        return this.pdV.get(str);
    }

    public String elm() {
        return this.pdU;
    }

    public void a(String str, c cVar) {
        this.pdU = str;
        if (cVar != null) {
            this.pdV.put(str, cVar);
        }
    }

    public void YA(String str) {
        if (this.pdV.containsKey(str)) {
            this.pdV.remove(str);
        }
    }

    public b eln() {
        return this.pdR;
    }

    public void a(b bVar) {
        this.pdR = bVar;
    }

    public b elo() {
        return this.pdS;
    }

    public void b(b bVar) {
        this.pdS = bVar;
    }

    public static void elp() {
        pdQ = null;
    }

    public a elq() {
        return this.pdT;
    }
}
