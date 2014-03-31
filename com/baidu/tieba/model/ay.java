package com.baidu.tieba.model;
/* loaded from: classes.dex */
public final class ay {
    private com.baidu.tieba.data.ag a = new com.baidu.tieba.data.ag();
    private boolean b = true;
    private String c = null;
    private int d;

    public final void a(String str) {
        this.c = str;
    }

    public final String a() {
        return this.c;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final int b() {
        return this.d;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final boolean c() {
        return this.b;
    }

    public final com.baidu.tieba.data.ag d() {
        return this.a;
    }

    public final void a(String str, boolean z) {
        com.baidu.adp.lib.cache.s<String> k;
        if (str != null && this.c != null) {
            if (z) {
                k = com.baidu.tbadk.core.c.b.a().j();
            } else {
                k = com.baidu.tbadk.core.c.b.a().k();
            }
            if (k != null) {
                k.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.c, str, 604800000L);
            }
        }
    }

    public final com.baidu.tieba.data.ag b(boolean z) {
        com.baidu.adp.lib.cache.s<String> k;
        if (this.c == null) {
            return null;
        }
        if (z) {
            k = com.baidu.tbadk.core.c.b.a().j();
        } else {
            k = com.baidu.tbadk.core.c.b.a().k();
        }
        if (k != null) {
            String a = k.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.c);
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
