package com.baidu.tieba.pb.c;

import com.baidu.adp.base.f;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class a extends f {
    private b bHC;
    private String filename;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bHC = null;
        this.filename = null;
    }

    public boolean hD(String str) {
        this.filename = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        if (this.bHC != null) {
            this.bHC.cancel();
        }
        this.bHC = new b(this, this.filename);
        this.bHC.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bHC != null) {
            this.bHC.cancel();
            return true;
        }
        return true;
    }
}
