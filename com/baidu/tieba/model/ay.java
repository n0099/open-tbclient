package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ay {
    private com.baidu.tieba.data.ag a = new com.baidu.tieba.data.ag();
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

    public com.baidu.tieba.data.ag d() {
        return this.a;
    }

    public void a(String str, boolean z) {
        com.baidu.adp.lib.cache.s<String> m;
        if (str != null && this.c != null) {
            if (z) {
                m = com.baidu.tbadk.core.a.b.a().l();
            } else {
                m = com.baidu.tbadk.core.a.b.a().m();
            }
            if (m != null) {
                m.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.c, str, 604800000L);
            }
        }
    }

    public com.baidu.tieba.data.ag b(boolean z) {
        com.baidu.adp.lib.cache.s<String> m;
        if (this.c == null) {
            return null;
        }
        if (z) {
            m = com.baidu.tbadk.core.a.b.a().l();
        } else {
            m = com.baidu.tbadk.core.a.b.a().m();
        }
        if (m != null) {
            String a = m.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.c);
            if (a == null) {
                return null;
            }
            com.baidu.tieba.data.ag agVar = new com.baidu.tieba.data.ag();
            agVar.a(a);
            return agVar;
        }
        return null;
    }
}
