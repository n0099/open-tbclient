package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private ai f1360a;
    private aj b;

    public void a(aj ajVar) {
        this.b = ajVar;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        return false;
    }

    public void a(String str) {
        this.f1360a = new ai(this, str);
        this.f1360a.execute(new Void[0]);
    }
}
