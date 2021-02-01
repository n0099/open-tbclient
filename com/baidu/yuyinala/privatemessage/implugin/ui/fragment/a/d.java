package com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public class d {
    private static d pdq;
    private b pdr;
    private b pds;
    private a pdt;
    private String pdu = "";
    private ConcurrentHashMap<String, c> pdv = new ConcurrentHashMap<>(4);
    private AtomicInteger mOpenCounter = new AtomicInteger();

    public static d eld() {
        if (pdq == null) {
            synchronized (d.class) {
                if (pdq == null) {
                    pdq = new d();
                }
            }
        }
        return pdq;
    }

    public c Yn(String str) {
        return this.pdv.get(str);
    }

    public String ele() {
        return this.pdu;
    }

    public void a(String str, c cVar) {
        this.pdu = str;
        if (cVar != null) {
            this.pdv.put(str, cVar);
        }
    }

    public void Yo(String str) {
        if (this.pdv.containsKey(str)) {
            this.pdv.remove(str);
        }
    }

    public b elf() {
        return this.pdr;
    }

    public void a(b bVar) {
        this.pdr = bVar;
    }

    public b elg() {
        return this.pds;
    }

    public void b(b bVar) {
        this.pds = bVar;
    }

    public static void elh() {
        pdq = null;
    }

    public a eli() {
        return this.pdt;
    }
}
