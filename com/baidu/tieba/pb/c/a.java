package com.baidu.tieba.pb.c;

import com.baidu.adp.base.f;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class a extends f {
    private b bHP;
    private String filename;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bHP = null;
        this.filename = null;
    }

    public boolean hG(String str) {
        this.filename = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        if (this.bHP != null) {
            this.bHP.cancel();
        }
        this.bHP = new b(this, this.filename);
        this.bHP.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bHP != null) {
            this.bHP.cancel();
            return true;
        }
        return true;
    }
}
