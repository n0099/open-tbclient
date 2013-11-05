package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private az f1908a = null;
    private String b = null;

    public boolean a(String str) {
        this.b = str;
        return LoadData();
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        if (this.f1908a != null) {
            this.f1908a.cancel();
        }
        this.f1908a = new az(this, this.b);
        this.f1908a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.f1908a != null) {
            this.f1908a.cancel();
            return true;
        }
        return true;
    }
}
