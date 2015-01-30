package com.baidu.tieba.model;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.f {
    private n buE;
    private String filename;

    public m(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.buE = null;
        this.filename = null;
    }

    public boolean hx(String str) {
        this.filename = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        if (this.buE != null) {
            this.buE.cancel();
        }
        this.buE = new n(this, this.filename);
        this.buE.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.buE != null) {
            this.buE.cancel();
            return true;
        }
        return true;
    }
}
