package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ay {
    private com.baidu.tieba.data.ah a = new com.baidu.tieba.data.ah();
    private boolean b = true;
    private String c = null;
    private int d;

    public void a(String str) {
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public void a(int i) {
        this.d = i;
    }

    public int b() {
        return this.d;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean c() {
        return this.b;
    }

    public com.baidu.tieba.data.ah d() {
        return this.a;
    }

    public void a(String str, boolean z) {
        com.baidu.adp.lib.cache.s<String> n;
        if (str != null && this.c != null) {
            if (z) {
                n = com.baidu.tbadk.core.a.b.a().m();
            } else {
                n = com.baidu.tbadk.core.a.b.a().n();
            }
            if (n != null) {
                n.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.c, str, 604800000L);
            }
        }
    }

    public com.baidu.tieba.data.ah b(boolean z) {
        com.baidu.adp.lib.cache.s<String> n;
        if (this.c == null) {
            return null;
        }
        if (z) {
            n = com.baidu.tbadk.core.a.b.a().m();
        } else {
            n = com.baidu.tbadk.core.a.b.a().n();
        }
        if (n != null) {
            String a = n.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.c);
            if (a == null) {
                return null;
            }
            com.baidu.tieba.data.ah ahVar = new com.baidu.tieba.data.ah();
            ahVar.a(a);
            return ahVar;
        }
        return null;
    }
}
