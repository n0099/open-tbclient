package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private ar f1403a = null;
    private String b = null;

    public boolean a(String str) {
        this.b = str;
        return LoadData();
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        if (this.f1403a != null) {
            this.f1403a.cancel();
        }
        this.f1403a = new ar(this, this.b);
        this.f1403a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.f1403a != null) {
            this.f1403a.cancel();
            return true;
        }
        return true;
    }
}
