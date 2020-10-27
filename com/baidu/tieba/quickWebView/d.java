package com.baidu.tieba.quickWebView;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d mlU;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> mlR = new HashMap<>();
    private com.baidu.tieba.quickWebView.data.b mlS = null;
    private boolean mlT = false;

    public static d dxo() {
        if (mlU == null) {
            synchronized (d.class) {
                if (mlU == null) {
                    mlU = new d();
                }
            }
        }
        return mlU;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a QT(String str) {
        if (this.mlR == null || !this.mlT) {
            return null;
        }
        return this.mlR.get(str);
    }

    public List<String> QU(String str) {
        if (this.mlS == null || this.mlS.mlY == null || !this.mlT) {
            return null;
        }
        return this.mlS.mlY.get(str);
    }

    public void H(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.mlR = hashMap;
    }

    public HashMap<String, com.baidu.tieba.quickWebView.data.a> dxp() {
        return this.mlR;
    }

    public void a(com.baidu.tieba.quickWebView.data.b bVar) {
        this.mlS = bVar;
    }

    public boolean dxq() {
        return this.mlT;
    }

    public void wt(boolean z) {
        this.mlT = z;
    }
}
