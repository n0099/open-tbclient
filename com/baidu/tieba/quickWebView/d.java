package com.baidu.tieba.quickWebView;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private static d lBa;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> lAX = new HashMap<>();
    private com.baidu.tieba.quickWebView.data.b lAY = null;
    private boolean lAZ = false;

    public static d dmK() {
        if (lBa == null) {
            synchronized (d.class) {
                if (lBa == null) {
                    lBa = new d();
                }
            }
        }
        return lBa;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Pf(String str) {
        if (this.lAX == null || !this.lAZ) {
            return null;
        }
        return this.lAX.get(str);
    }

    public List<String> Pg(String str) {
        if (this.lAY == null || this.lAY.lBe == null || !this.lAZ) {
            return null;
        }
        return this.lAY.lBe.get(str);
    }

    public void F(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.lAX = hashMap;
    }

    public void a(com.baidu.tieba.quickWebView.data.b bVar) {
        this.lAY = bVar;
    }

    public boolean dmL() {
        return this.lAZ;
    }

    public void vl(boolean z) {
        this.lAZ = z;
    }
}
