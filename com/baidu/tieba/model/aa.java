package com.baidu.tieba.model;

import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.a.d {
    private com.baidu.tieba.data.w d;
    private ab e;
    private boolean c = false;
    private int f = 1;

    /* renamed from: a  reason: collision with root package name */
    protected int f1885a = 0;
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
        ArrayList<com.baidu.tieba.data.x> a2;
        return (this.d == null || (a2 = this.d.a()) == null || a2.size() < 300) ? false : true;
    }

    public boolean d() {
        return this.d != null && (this.d.c() || a());
    }

    public boolean e() {
        ArrayList<com.baidu.tieba.data.x> a2;
        return (this.d == null || (a2 = this.d.a()) == null || a2.size() <= 0) ? false : true;
    }

    public boolean f() {
        return !c() && d();
    }

    public void a(int i) {
        this.f = i;
        this.e = new ab(this);
        this.e.execute(Integer.valueOf((i != 2 || a()) ? 1 : k()));
        this.g = 1;
    }

    public void g() {
        if (this.e == null) {
            this.e = new ab(this);
        }
        this.e.execute(1, 1);
        this.g = 1;
    }

    public com.baidu.tieba.data.w h() {
        String C = TiebaApplication.C();
        if (C == null) {
            return null;
        }
        com.baidu.adp.lib.cache.s<String> e = com.baidu.tieba.b.a.a().e();
        String a2 = e != null ? e.a("home_forumfeed_" + C) : null;
        if (a2 != null) {
            com.baidu.tieba.data.w wVar = new com.baidu.tieba.data.w();
            wVar.a(a2);
            this.d = wVar;
            return wVar;
        }
        return null;
    }

    public int i() {
        return this.f;
    }

    private int k() {
        ArrayList<com.baidu.tieba.data.x> a2;
        if (this.d == null || (a2 = this.d.a()) == null) {
            return 1;
        }
        return (a2.size() / 20) + 1;
    }

    @Override // com.baidu.adp.a.d
    public int getErrorCode() {
        return this.f1885a;
    }

    @Override // com.baidu.adp.a.d
    public void setErrorCode(int i) {
        this.f1885a = i;
    }

    @Override // com.baidu.adp.a.d
    public String getErrorString() {
        return this.b;
    }

    @Override // com.baidu.adp.a.d
    public void setErrorString(String str) {
        this.b = str;
    }

    public com.baidu.tieba.data.w j() {
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
