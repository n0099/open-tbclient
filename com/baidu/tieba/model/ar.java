package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private as f1902a;
    private at b;

    public void a(at atVar) {
        this.b = atVar;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(String str) {
        this.f1902a = new as(this, str);
        this.f1902a.execute(new Void[0]);
    }
}
