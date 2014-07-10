package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.e {
    private ac a = null;
    private String b = null;

    public boolean a(String str) {
        this.b = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        if (this.a != null) {
            this.a.cancel();
        }
        this.a = new ac(this, this.b);
        this.a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
