package com.baidu.tieba.model;

import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.e {
    private com.baidu.tieba.data.q d;
    private r e;
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
        ArrayList<com.baidu.tieba.data.r> b;
        return (this.d == null || (b = this.d.b()) == null || b.size() < 300) ? false : true;
    }

    public boolean d() {
        return this.d != null && (this.d.d() || a());
    }

    public boolean e() {
        ArrayList<com.baidu.tieba.data.r> b;
        return (this.d == null || (b = this.d.b()) == null || b.size() <= 0) ? false : true;
    }

    public boolean f() {
        return !c() && d();
    }

    public void a(int i) {
        this.f = i;
        this.e = new r(this);
        this.e.execute(Integer.valueOf((i != 2 || a()) ? 1 : k()));
        this.g = 1;
    }

    public void g() {
        if (this.e == null) {
            this.e = new r(this);
        }
        this.e.execute(1, 1);
        this.g = 1;
    }

    public com.baidu.tieba.data.q h() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null) {
            return null;
        }
        com.baidu.adp.lib.cache.s<String> k = com.baidu.tbadk.core.a.b.a().k();
        String a = k != null ? k.a("home_forumfeed_" + currentAccount) : null;
        if (a != null) {
            com.baidu.tieba.data.q qVar = new com.baidu.tieba.data.q();
            qVar.a(a);
            this.d = qVar;
            return qVar;
        }
        return null;
    }

    public int i() {
        return this.f;
    }

    private int k() {
        ArrayList<com.baidu.tieba.data.r> b;
        if (this.d == null || (b = this.d.b()) == null) {
            return 1;
        }
        return (b.size() / 20) + 1;
    }

    @Override // com.baidu.adp.base.e
    public int getErrorCode() {
        return this.a;
    }

    @Override // com.baidu.adp.base.e
    public void setErrorCode(int i) {
        this.a = i;
    }

    @Override // com.baidu.adp.base.e
    public String getErrorString() {
        return this.b;
    }

    @Override // com.baidu.adp.base.e
    public void setErrorString(String str) {
        this.b = str;
    }

    public com.baidu.tieba.data.q j() {
        return this.d;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.e != null) {
            this.e.cancel();
            return true;
        }
        return true;
    }
}
