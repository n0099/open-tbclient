package com.baidu.tieba.square;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.a.d {
    private ar b;
    private ax a = null;
    private aw c = null;

    public av() {
        this.b = null;
        this.b = new ar();
    }

    public ar a() {
        return this.b;
    }

    public void a(aw awVar) {
        this.c = awVar;
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
        this.a = new ax(this, i);
        this.a.execute(new Object[0]);
        return true;
    }
}
