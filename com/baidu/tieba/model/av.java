package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private aw f1997a = null;
    private String b = null;

    public boolean a(String str) {
        this.b = str;
        return LoadData();
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        if (this.f1997a != null) {
            this.f1997a.cancel();
        }
        this.f1997a = new aw(this, this.b);
        this.f1997a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.f1997a != null) {
            this.f1997a.cancel();
            return true;
        }
        return true;
    }
}
