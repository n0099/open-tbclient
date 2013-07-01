package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private ah f1013a = null;
    private String b = null;

    public boolean a(String str) {
        this.b = str;
        return LoadData();
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        if (this.f1013a != null) {
            this.f1013a.cancel();
        }
        this.f1013a = new ah(this, this.b);
        this.f1013a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.f1013a != null) {
            this.f1013a.cancel();
            return true;
        }
        return true;
    }
}
