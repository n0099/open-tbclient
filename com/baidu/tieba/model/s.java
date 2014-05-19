package com.baidu.tieba.model;

import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.d {
    private com.baidu.tieba.data.p d;
    private t e;
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
        ArrayList<com.baidu.tieba.data.q> b;
        return (this.d == null || (b = this.d.b()) == null || b.size() < 300) ? false : true;
    }

    public boolean d() {
        return this.d != null && (this.d.d() || a());
    }

    public boolean e() {
        ArrayList<com.baidu.tieba.data.q> b;
        return (this.d == null || (b = this.d.b()) == null || b.size() <= 0) ? false : true;
    }

    public boolean f() {
        return !c() && d();
    }

    public void a(int i) {
        this.f = i;
        this.e = new t(this);
        this.e.execute(Integer.valueOf((i != 2 || a()) ? 1 : k()));
        this.g = 1;
    }

    public void g() {
        if (this.e == null) {
            this.e = new t(this);
        }
        this.e.execute(1, 1);
        this.g = 1;
    }

    public com.baidu.tieba.data.p h() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null) {
            return null;
        }
        com.baidu.adp.lib.cache.s<String> i = com.baidu.tbadk.core.a.b.a().i();
        String a = i != null ? i.a("home_forumfeed_" + currentAccount) : null;
        if (a != null) {
            com.baidu.tieba.data.p pVar = new com.baidu.tieba.data.p();
            pVar.a(a);
            this.d = pVar;
            return pVar;
        }
        return null;
    }

    public int i() {
        return this.f;
    }

    private int k() {
        ArrayList<com.baidu.tieba.data.q> b;
        if (this.d == null || (b = this.d.b()) == null) {
            return 1;
        }
        return (b.size() / 20) + 1;
    }

    @Override // com.baidu.adp.base.d
    public int getErrorCode() {
        return this.a;
    }

    @Override // com.baidu.adp.base.d
    public void setErrorCode(int i) {
        this.a = i;
    }

    @Override // com.baidu.adp.base.d
    public String getErrorString() {
        return this.b;
    }

    @Override // com.baidu.adp.base.d
    public void setErrorString(String str) {
        this.b = str;
    }

    public com.baidu.tieba.data.p j() {
        return this.d;
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        if (this.e != null) {
            this.e.cancel();
            return true;
        }
        return true;
    }
}
