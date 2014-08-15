package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.e {
    private ad a = null;
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
        this.a = new ad(this, this.b);
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
