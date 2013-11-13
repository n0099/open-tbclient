package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private aw f1902a = null;
    private String b = null;

    public boolean a(String str) {
        this.b = str;
        return LoadData();
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        if (this.f1902a != null) {
            this.f1902a.cancel();
        }
        this.f1902a = new aw(this, this.b);
        this.f1902a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.f1902a != null) {
            this.f1902a.cancel();
            return true;
        }
        return true;
    }
}
