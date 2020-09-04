package com.baidu.tieba.quickWebView;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d lBl;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> lBi = new HashMap<>();
    private com.baidu.tieba.quickWebView.data.b lBj = null;
    private boolean lBk = false;

    public static d dmN() {
        if (lBl == null) {
            synchronized (d.class) {
                if (lBl == null) {
                    lBl = new d();
                }
            }
        }
        return lBl;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a Pg(String str) {
        if (this.lBi == null || !this.lBk) {
            return null;
        }
        return this.lBi.get(str);
    }

    public List<String> Ph(String str) {
        if (this.lBj == null || this.lBj.lBp == null || !this.lBk) {
            return null;
        }
        return this.lBj.lBp.get(str);
    }

    public void F(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.lBi = hashMap;
    }

    public void a(com.baidu.tieba.quickWebView.data.b bVar) {
        this.lBj = bVar;
    }

    public boolean dmO() {
        return this.lBk;
    }

    public void vn(boolean z) {
        this.lBk = z;
    }
}
