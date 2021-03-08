package com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class d {
    private static d pfV;
    private b pfW;
    private b pfX;
    private a pfY;
    private String pfZ = "";
    private ConcurrentHashMap<String, c> pga = new ConcurrentHashMap<>(4);
    private AtomicInteger mOpenCounter = new AtomicInteger();

    public static d elv() {
        if (pfV == null) {
            synchronized (d.class) {
                if (pfV == null) {
                    pfV = new d();
                }
            }
        }
        return pfV;
    }

    public c YG(String str) {
        return this.pga.get(str);
    }

    public String elw() {
        return this.pfZ;
    }

    public void a(String str, c cVar) {
        this.pfZ = str;
        if (cVar != null) {
            this.pga.put(str, cVar);
        }
    }

    public void YH(String str) {
        if (this.pga.containsKey(str)) {
            this.pga.remove(str);
        }
    }

    public b elx() {
        return this.pfW;
    }

    public void a(b bVar) {
        this.pfW = bVar;
    }

    public b ely() {
        return this.pfX;
    }

    public void b(b bVar) {
        this.pfX = bVar;
    }

    public static void elz() {
        pfV = null;
    }

    public a elA() {
        return this.pfY;
    }
}
