package com.baidu.tieba.pb.c;

import com.baidu.adp.base.f;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class a extends f {
    private b bKf;
    private String filename;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bKf = null;
        this.filename = null;
    }

    public boolean il(String str) {
        this.filename = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        if (this.bKf != null) {
            this.bKf.cancel();
        }
        this.bKf = new b(this, this.filename);
        this.bKf.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bKf != null) {
            this.bKf.cancel();
            return true;
        }
        return true;
    }
}
