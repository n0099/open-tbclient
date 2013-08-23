package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class bp {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.aq f1390a = new com.baidu.tieba.data.aq();
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
        return this.f1390a;
    }

    public void a(String str, boolean z) {
        com.baidu.adp.lib.cache.q f;
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
        com.baidu.adp.lib.cache.q f;
        if (this.c == null) {
            return null;
        }
        if (z) {
            f = com.baidu.tieba.b.a.a().e();
        } else {
            f = com.baidu.tieba.b.a.a().f();
        }
        if (f != null) {
            String str = (String) f.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.c);
            if (str == null) {
                return null;
            }
            com.baidu.tieba.data.aq aqVar = new com.baidu.tieba.data.aq();
            aqVar.a(str);
            return aqVar;
        }
        return null;
    }
}
