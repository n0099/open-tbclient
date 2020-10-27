package com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class d {
    private static d oru;
    private b orv;
    private b orw;
    private a orx;
    private String ory = "";
    private ConcurrentHashMap<String, c> orz = new ConcurrentHashMap<>(4);
    private AtomicInteger mOpenCounter = new AtomicInteger();

    public static d ecY() {
        if (oru == null) {
            synchronized (d.class) {
                if (oru == null) {
                    oru = new d();
                }
            }
        }
        return oru;
    }

    public c Xa(String str) {
        return this.orz.get(str);
    }

    public String ecZ() {
        return this.ory;
    }

    public void a(String str, c cVar) {
        this.ory = str;
        if (cVar != null) {
            this.orz.put(str, cVar);
        }
    }

    public void Xb(String str) {
        if (this.orz.containsKey(str)) {
            this.orz.remove(str);
        }
    }

    public b eda() {
        return this.orv;
    }

    public void a(b bVar) {
        this.orv = bVar;
    }

    public b edb() {
        return this.orw;
    }

    public void b(b bVar) {
        this.orw = bVar;
    }

    public static void edc() {
        oru = null;
    }

    public a edd() {
        return this.orx;
    }
}
