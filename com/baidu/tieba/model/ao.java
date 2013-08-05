package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private ap f1333a = null;
    private String b = null;

    public boolean a(String str) {
        this.b = str;
        return LoadData();
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        if (this.f1333a != null) {
            this.f1333a.cancel();
        }
        this.f1333a = new ap(this, this.b);
        this.f1333a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.f1333a != null) {
            this.f1333a.cancel();
            return true;
        }
        return true;
    }
}
