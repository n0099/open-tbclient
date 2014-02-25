package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.a.d {
    private aq a = null;
    private String b = null;

    public boolean a(String str) {
        this.b = str;
        return LoadData();
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        if (this.a != null) {
            this.a.cancel();
        }
        this.a = new aq(this, this.b);
        this.a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
