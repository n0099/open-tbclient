package com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class d {
    private static d oCr;
    private b oCs;
    private b oCt;
    private a oCu;
    private String oCv = "";
    private ConcurrentHashMap<String, c> oCw = new ConcurrentHashMap<>(4);
    private AtomicInteger mOpenCounter = new AtomicInteger();

    public static d egL() {
        if (oCr == null) {
            synchronized (d.class) {
                if (oCr == null) {
                    oCr = new d();
                }
            }
        }
        return oCr;
    }

    public c Xp(String str) {
        return this.oCw.get(str);
    }

    public String egM() {
        return this.oCv;
    }

    public void a(String str, c cVar) {
        this.oCv = str;
        if (cVar != null) {
            this.oCw.put(str, cVar);
        }
    }

    public void Xq(String str) {
        if (this.oCw.containsKey(str)) {
            this.oCw.remove(str);
        }
    }

    public b egN() {
        return this.oCs;
    }

    public void a(b bVar) {
        this.oCs = bVar;
    }

    public b egO() {
        return this.oCt;
    }

    public void b(b bVar) {
        this.oCt = bVar;
    }

    public static void egP() {
        oCr = null;
    }

    public a egQ() {
        return this.oCu;
    }
}
