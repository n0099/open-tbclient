package com.baidu.tieba.model;

import android.content.Context;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.base.e {
    private ae bph;
    private String bpi;

    public ad(Context context) {
        super(context);
        this.bph = null;
        this.bpi = null;
    }

    public boolean gS(String str) {
        this.bpi = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        if (this.bph != null) {
            this.bph.cancel();
        }
        this.bph = new ae(this, this.bpi);
        this.bph.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bph != null) {
            this.bph.cancel();
            return true;
        }
        return true;
    }
}
