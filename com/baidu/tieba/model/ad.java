package com.baidu.tieba.model;

import android.content.Context;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.base.e {
    private ae boT;
    private String boU;

    public ad(Context context) {
        super(context);
        this.boT = null;
        this.boU = null;
    }

    public boolean gS(String str) {
        this.boU = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        if (this.boT != null) {
            this.boT.cancel();
        }
        this.boT = new ae(this, this.boU);
        this.boT.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.boT != null) {
            this.boT.cancel();
            return true;
        }
        return true;
    }
}
