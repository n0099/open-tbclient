package com.baidu.tieba.quickWebView;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d lKf;
    private HashMap<String, com.baidu.tieba.quickWebView.data.a> lKc = new HashMap<>();
    private com.baidu.tieba.quickWebView.data.b lKd = null;
    private boolean lKe = false;

    public static d dqw() {
        if (lKf == null) {
            synchronized (d.class) {
                if (lKf == null) {
                    lKf = new d();
                }
            }
        }
        return lKf;
    }

    private d() {
    }

    public com.baidu.tieba.quickWebView.data.a PG(String str) {
        if (this.lKc == null || !this.lKe) {
            return null;
        }
        return this.lKc.get(str);
    }

    public List<String> PH(String str) {
        if (this.lKd == null || this.lKd.lKj == null || !this.lKe) {
            return null;
        }
        return this.lKd.lKj.get(str);
    }

    public void F(HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap) {
        this.lKc = hashMap;
    }

    public HashMap<String, com.baidu.tieba.quickWebView.data.a> dqx() {
        return this.lKc;
    }

    public void a(com.baidu.tieba.quickWebView.data.b bVar) {
        this.lKd = bVar;
    }

    public boolean dqy() {
        return this.lKe;
    }

    public void vv(boolean z) {
        this.lKe = z;
    }
}
