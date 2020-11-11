package com.baidu.tieba.quickWebView;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d mrR;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> mrO = new HashMap<>();
    private com.baidu.tieba.quickWebView.data.b mrP = null;
    private boolean mrQ = false;

    public static d dzQ() {
        if (mrR == null) {
            synchronized (d.class) {
                if (mrR == null) {
                    mrR = new d();
                }
            }
        }
        return mrR;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Rk(String str) {
        if (this.mrO == null || !this.mrQ) {
            return null;
        }
        return this.mrO.get(str);
    }

    public List<String> Rl(String str) {
        if (this.mrP == null || this.mrP.mrV == null || !this.mrQ) {
            return null;
        }
        return this.mrP.mrV.get(str);
    }

    public void H(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.mrO = hashMap;
    }

    public HashMap<String, com.baidu.tieba.quickWebView.data.a> dzR() {
        return this.mrO;
    }

    public void a(com.baidu.tieba.quickWebView.data.b bVar) {
        this.mrP = bVar;
    }

    public boolean dzS() {
        return this.mrQ;
    }

    public void wC(boolean z) {
        this.mrQ = z;
    }
}
