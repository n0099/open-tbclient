package com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class d {
    private static d oAN;
    private b oAO;
    private b oAP;
    private a oAQ;
    private String oAR = "";
    private ConcurrentHashMap<String, c> oAS = new ConcurrentHashMap<>(4);
    private AtomicInteger mOpenCounter = new AtomicInteger();

    public static d egN() {
        if (oAN == null) {
            synchronized (d.class) {
                if (oAN == null) {
                    oAN = new d();
                }
            }
        }
        return oAN;
    }

    public c XE(String str) {
        return this.oAS.get(str);
    }

    public String egO() {
        return this.oAR;
    }

    public void a(String str, c cVar) {
        this.oAR = str;
        if (cVar != null) {
            this.oAS.put(str, cVar);
        }
    }

    public void XF(String str) {
        if (this.oAS.containsKey(str)) {
            this.oAS.remove(str);
        }
    }

    public b egP() {
        return this.oAO;
    }

    public void a(b bVar) {
        this.oAO = bVar;
    }

    public b egQ() {
        return this.oAP;
    }

    public void b(b bVar) {
        this.oAP = bVar;
    }

    public static void egR() {
        oAN = null;
    }

    public a egS() {
        return this.oAQ;
    }
}
