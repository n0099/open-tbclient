package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ca {
    private com.baidu.tieba.data.ap a = new com.baidu.tieba.data.ap();
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

    public com.baidu.tieba.data.ap d() {
        return this.a;
    }

    public void a(String str, boolean z) {
        if (str != null && this.c != null) {
            com.baidu.adp.lib.cache.s<String> j = z ? com.baidu.tieba.b.a.a().j() : com.baidu.tieba.b.a.a().k();
            if (j != null) {
                j.a((z ? "personal_followme" : "personal_myfollow") + "_" + this.c, str, 604800000L);
            }
        }
    }

    public com.baidu.tieba.data.ap b(boolean z) {
        if (this.c == null) {
            return null;
        }
        com.baidu.adp.lib.cache.s<String> j = z ? com.baidu.tieba.b.a.a().j() : com.baidu.tieba.b.a.a().k();
        if (j != null) {
            String a = j.a((z ? "personal_followme" : "personal_myfollow") + "_" + this.c);
            if (a == null) {
                return null;
            }
            com.baidu.tieba.data.ap apVar = new com.baidu.tieba.data.ap();
            apVar.a(a);
            return apVar;
        }
        return null;
    }
}
