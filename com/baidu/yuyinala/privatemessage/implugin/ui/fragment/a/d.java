package com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public class d {
    private static d oXE;
    private b oXF;
    private b oXG;
    private a oXH;
    private String oXI = "";
    private ConcurrentHashMap<String, c> oXJ = new ConcurrentHashMap<>(4);
    private AtomicInteger mOpenCounter = new AtomicInteger();

    public static d emC() {
        if (oXE == null) {
            synchronized (d.class) {
                if (oXE == null) {
                    oXE = new d();
                }
            }
        }
        return oXE;
    }

    public c Yu(String str) {
        return this.oXJ.get(str);
    }

    public String emD() {
        return this.oXI;
    }

    public void a(String str, c cVar) {
        this.oXI = str;
        if (cVar != null) {
            this.oXJ.put(str, cVar);
        }
    }

    public void Yv(String str) {
        if (this.oXJ.containsKey(str)) {
            this.oXJ.remove(str);
        }
    }

    public b emE() {
        return this.oXF;
    }

    public void a(b bVar) {
        this.oXF = bVar;
    }

    public b emF() {
        return this.oXG;
    }

    public void b(b bVar) {
        this.oXG = bVar;
    }

    public static void emG() {
        oXE = null;
    }

    public a emH() {
        return this.oXH;
    }
}
