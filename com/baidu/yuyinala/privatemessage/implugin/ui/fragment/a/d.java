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

    public static d emD() {
        if (oXE == null) {
            synchronized (d.class) {
                if (oXE == null) {
                    oXE = new d();
                }
            }
        }
        return oXE;
    }

    public c Yt(String str) {
        return this.oXJ.get(str);
    }

    public String emE() {
        return this.oXI;
    }

    public void a(String str, c cVar) {
        this.oXI = str;
        if (cVar != null) {
            this.oXJ.put(str, cVar);
        }
    }

    public void Yu(String str) {
        if (this.oXJ.containsKey(str)) {
            this.oXJ.remove(str);
        }
    }

    public b emF() {
        return this.oXF;
    }

    public void a(b bVar) {
        this.oXF = bVar;
    }

    public b emG() {
        return this.oXG;
    }

    public void b(b bVar) {
        this.oXG = bVar;
    }

    public static void emH() {
        oXE = null;
    }

    public a emI() {
        return this.oXH;
    }
}
