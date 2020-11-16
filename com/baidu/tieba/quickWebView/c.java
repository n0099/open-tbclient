package com.baidu.tieba.quickWebView;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c msk;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> msh = new HashMap<>();
    private com.baidu.tieba.quickWebView.data.b msi = null;
    private boolean msj = false;

    public static c dzq() {
        if (msk == null) {
            synchronized (c.class) {
                if (msk == null) {
                    msk = new c();
                }
            }
        }
        return msk;
    }

    private c() {
    }

    public com.baidu.tieba.quickWebView.data.a QF(String str) {
        if (this.msh == null || !this.msj) {
            return null;
        }
        return this.msh.get(str);
    }

    public List<String> QG(String str) {
        if (this.msi == null || this.msi.mso == null || !this.msj) {
            return null;
        }
        return this.msi.mso.get(str);
    }

    public void G(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.msh = hashMap;
    }

    public HashMap<String, com.baidu.tieba.quickWebView.data.a> dzr() {
        return this.msh;
    }

    public void a(com.baidu.tieba.quickWebView.data.b bVar) {
        this.msi = bVar;
    }

    public boolean dzs() {
        return this.msj;
    }

    public void wF(boolean z) {
        this.msj = z;
    }
}
