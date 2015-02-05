package com.baidu.tieba.model;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.f {
    private n buD;
    private String filename;

    public m(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.buD = null;
        this.filename = null;
    }

    public boolean hu(String str) {
        this.filename = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        if (this.buD != null) {
            this.buD.cancel();
        }
        this.buD = new n(this, this.filename);
        this.buD.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.buD != null) {
            this.buD.cancel();
            return true;
        }
        return true;
    }
}
