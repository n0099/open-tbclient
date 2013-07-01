package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private p f1059a = null;
    private r b = null;
    private t c = null;

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        a();
        return false;
    }

    public void a() {
        if (this.f1059a != null) {
            this.f1059a.cancel();
            this.f1059a = null;
        }
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.f1059a != null) {
            this.f1059a.cancel();
            this.f1059a = null;
        }
        this.mLoadDataMode = 0;
        this.f1059a = new p(this, str, str2, str3, str4, i, i2, z);
        this.f1059a.setPriority(2);
        this.f1059a.execute(new String[0]);
    }

    public boolean b() {
        return (this.f1059a == null && this.b == null && this.c == null) ? false : true;
    }

    public void a(String str, String str2, String str3, String str4, int i) {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        this.mLoadDataMode = 1;
        this.b = new r(this, str, str2, str3, str4, String.valueOf(i));
        this.b.setPriority(2);
        this.b.execute(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/bawu/commitprison");
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
        this.mLoadDataMode = i;
        this.c = new t(this, str, str2, str3, i, str4);
        this.c.setPriority(2);
        String str6 = com.baidu.tieba.data.g.f787a;
        if (i == 6) {
            str5 = String.valueOf(str6) + "c/c/bawu/goodlist";
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + "c/c/bawu/commitgood";
        } else {
            str5 = String.valueOf(str6) + "c/c/bawu/committop";
        }
        this.c.execute(str5);
    }
}
