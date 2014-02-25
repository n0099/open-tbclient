package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class br {
    private com.baidu.tieba.data.ao a = new com.baidu.tieba.data.ao();
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

    public com.baidu.tieba.data.ao d() {
        return this.a;
    }

    public void a(String str, boolean z) {
        com.baidu.adp.lib.cache.s<String> k;
        if (str != null && this.c != null) {
            if (z) {
                k = com.baidu.tieba.c.a.a().j();
            } else {
                k = com.baidu.tieba.c.a.a().k();
            }
            if (k != null) {
                k.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.c, str, 604800000L);
            }
        }
    }

    public com.baidu.tieba.data.ao b(boolean z) {
        com.baidu.adp.lib.cache.s<String> k;
        if (this.c == null) {
            return null;
        }
        if (z) {
            k = com.baidu.tieba.c.a.a().j();
        } else {
            k = com.baidu.tieba.c.a.a().k();
        }
        if (k != null) {
            String a = k.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.c);
            if (a == null) {
                return null;
            }
            com.baidu.tieba.data.ao aoVar = new com.baidu.tieba.data.ao();
            aoVar.a(a);
            return aoVar;
        }
        return null;
    }
}
