package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ca {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.aq f1931a = new com.baidu.tieba.data.aq();
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

    public com.baidu.tieba.data.aq d() {
        return this.f1931a;
    }

    public void a(String str, boolean z) {
        if (str != null && this.c != null) {
            com.baidu.adp.lib.cache.s<String> f = z ? com.baidu.tieba.b.a.a().f() : com.baidu.tieba.b.a.a().g();
            if (f != null) {
                f.a((z ? "personal_followme" : "personal_myfollow") + "_" + this.c, str, 604800000L);
            }
        }
    }

    public com.baidu.tieba.data.aq b(boolean z) {
        if (this.c == null) {
            return null;
        }
        com.baidu.adp.lib.cache.s<String> f = z ? com.baidu.tieba.b.a.a().f() : com.baidu.tieba.b.a.a().g();
        if (f != null) {
            String a2 = f.a((z ? "personal_followme" : "personal_myfollow") + "_" + this.c);
            if (a2 == null) {
                return null;
            }
            com.baidu.tieba.data.aq aqVar = new com.baidu.tieba.data.aq();
            aqVar.a(a2);
            return aqVar;
        }
        return null;
    }
}
