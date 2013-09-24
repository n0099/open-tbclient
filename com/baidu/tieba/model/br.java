package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class br {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.aq f1427a = new com.baidu.tieba.data.aq();
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
        return this.f1427a;
    }

    public void a(String str, boolean z) {
        com.baidu.adp.lib.cache.q<String> f;
        if (str != null && this.c != null) {
            if (z) {
                f = com.baidu.tieba.b.a.a().e();
            } else {
                f = com.baidu.tieba.b.a.a().f();
            }
            if (f != null) {
                f.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.c, str, 604800000L);
            }
        }
    }

    public com.baidu.tieba.data.aq b(boolean z) {
        com.baidu.adp.lib.cache.q<String> f;
        if (this.c == null) {
            return null;
        }
        if (z) {
            f = com.baidu.tieba.b.a.a().e();
        } else {
            f = com.baidu.tieba.b.a.a().f();
        }
        if (f != null) {
            String a2 = f.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.c);
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
