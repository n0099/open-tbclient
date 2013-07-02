package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.a.c {
    private ah a = null;
    private String b = null;

    public boolean a(String str) {
        this.b = str;
        return LoadData();
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        if (this.a != null) {
            this.a.cancel();
        }
        this.a = new ah(this, this.b);
        this.a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
