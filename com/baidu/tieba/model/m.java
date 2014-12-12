package com.baidu.tieba.model;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.f {
    private n btg;
    private String filename;

    public m(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.btg = null;
        this.filename = null;
    }

    public boolean hq(String str) {
        this.filename = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        if (this.btg != null) {
            this.btg.cancel();
        }
        this.btg = new n(this, this.filename);
        this.btg.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.btg != null) {
            this.btg.cancel();
            return true;
        }
        return true;
    }
}
