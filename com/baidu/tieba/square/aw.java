package com.baidu.tieba.square;
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.a.d {
    private as b;
    private ay a = null;
    private ax c = null;

    public aw() {
        this.b = null;
        this.b = new as();
    }

    public as a() {
        return this.b;
    }

    public void a(ax axVar) {
        this.c = axVar;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }

    public boolean b() {
        return a(1);
    }

    public boolean c() {
        return a(0);
    }

    public boolean a(int i) {
        if (this.a != null) {
            return false;
        }
        this.a = new ay(this, i);
        this.a.execute(new Object[0]);
        return true;
    }
}
