package com.baidu.tieba.pb.c;

import com.baidu.adp.base.f;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class a extends f {
    private b bKe;
    private String filename;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bKe = null;
        this.filename = null;
    }

    public boolean il(String str) {
        this.filename = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        if (this.bKe != null) {
            this.bKe.cancel();
        }
        this.bKe = new b(this, this.filename);
        this.bKe.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bKe != null) {
            this.bKe.cancel();
            return true;
        }
        return true;
    }
}
