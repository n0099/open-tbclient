package com.baidu.tieba.model;

import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.a.d {
    private com.baidu.tieba.data.u d;
    private q e;
    private boolean c = false;
    private int f = 1;
    protected int a = 0;
    protected String b = null;
    private int g = 0;

    public boolean a() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.g == 0;
    }

    public boolean c() {
        ArrayList<com.baidu.tieba.data.v> b;
        return (this.d == null || (b = this.d.b()) == null || b.size() < 300) ? false : true;
    }

    public boolean d() {
        return this.d != null && (this.d.d() || a());
    }

    public boolean e() {
        ArrayList<com.baidu.tieba.data.v> b;
        return (this.d == null || (b = this.d.b()) == null || b.size() <= 0) ? false : true;
    }

    public boolean f() {
        return !c() && d();
    }

    public void a(int i) {
        this.f = i;
        this.e = new q(this);
        this.e.execute(Integer.valueOf((i != 2 || a()) ? 1 : k()));
        this.g = 1;
    }

    public void g() {
        if (this.e == null) {
            this.e = new q(this);
        }
        this.e.execute(1, 1);
        this.g = 1;
    }

    public com.baidu.tieba.data.u h() {
        String A = TiebaApplication.A();
        if (A == null) {
            return null;
        }
        com.baidu.adp.lib.cache.s<String> g = com.baidu.tieba.c.a.a().g();
        String a = g != null ? g.a("home_forumfeed_" + A) : null;
        if (a != null) {
            com.baidu.tieba.data.u uVar = new com.baidu.tieba.data.u();
            uVar.a(a);
            this.d = uVar;
            return uVar;
        }
        return null;
    }

    public int i() {
        return this.f;
    }

    private int k() {
        ArrayList<com.baidu.tieba.data.v> b;
        if (this.d == null || (b = this.d.b()) == null) {
            return 1;
        }
        return (b.size() / 20) + 1;
    }

    @Override // com.baidu.adp.a.d
    public int getErrorCode() {
        return this.a;
    }

    @Override // com.baidu.adp.a.d
    public void setErrorCode(int i) {
        this.a = i;
    }

    @Override // com.baidu.adp.a.d
    public String getErrorString() {
        return this.b;
    }

    @Override // com.baidu.adp.a.d
    public void setErrorString(String str) {
        this.b = str;
    }

    public com.baidu.tieba.data.u j() {
        return this.d;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.e != null) {
            this.e.cancel();
            return true;
        }
        return true;
    }
}
