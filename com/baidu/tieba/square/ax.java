package com.baidu.tieba.square;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.a.d {
    private ar b;

    /* renamed from: a  reason: collision with root package name */
    private az f2392a = null;
    private ay c = null;

    public ax() {
        this.b = null;
        this.b = new ar();
    }

    public ar a() {
        return this.b;
    }

    public void a(ay ayVar) {
        this.c = ayVar;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.f2392a != null) {
            this.f2392a.cancel();
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
        if (this.f2392a != null) {
            return false;
        }
        this.f2392a = new az(this, i);
        this.f2392a.execute(new Object[0]);
        return true;
    }
}
