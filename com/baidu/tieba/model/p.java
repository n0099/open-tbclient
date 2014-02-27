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

    public final boolean a() {
        return this.c;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final boolean b() {
        return this.g == 0;
    }

    public final boolean c() {
        ArrayList<com.baidu.tieba.data.v> b;
        return (this.d == null || (b = this.d.b()) == null || b.size() <= 0) ? false : true;
    }

    public final boolean d() {
        ArrayList<com.baidu.tieba.data.v> b;
        if (!((this.d == null || (b = this.d.b()) == null || b.size() < 300) ? false : true)) {
            if (this.d != null && (this.d.c() || this.c)) {
                return true;
            }
        }
        return false;
    }

    public final void a(int i) {
        int i2;
        ArrayList<com.baidu.tieba.data.v> b;
        this.f = i;
        this.e = new q(this);
        if (i != 2 || this.c) {
            i2 = 1;
        } else {
            i2 = (this.d == null || (b = this.d.b()) == null) ? 1 : (b.size() / 20) + 1;
        }
        this.e.execute(Integer.valueOf(i2));
        this.g = 1;
    }

    public final void e() {
        if (this.e == null) {
            this.e = new q(this);
        }
        this.e.execute(1, 1);
        this.g = 1;
    }

    public final com.baidu.tieba.data.u f() {
        String v = TiebaApplication.v();
        if (v == null) {
            return null;
        }
        com.baidu.adp.lib.cache.s<String> g = com.baidu.tieba.c.a.a().g();
        String a = g != null ? g.a("home_forumfeed_" + v) : null;
        if (a != null) {
            com.baidu.tieba.data.u uVar = new com.baidu.tieba.data.u();
            uVar.a(a);
            this.d = uVar;
            return uVar;
        }
        return null;
    }

    public final int g() {
        return this.f;
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

    public final com.baidu.tieba.data.u h() {
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
