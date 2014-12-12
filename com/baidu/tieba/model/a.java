package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.base.i;
import com.baidu.tieba.more.AboutActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f<AboutActivity> {
    private b bsI;
    private Context mContext;
    protected i mLoadDataCallBack;

    public a(AboutActivity aboutActivity, i iVar) {
        super(aboutActivity.getPageContext());
        this.mLoadDataCallBack = null;
        this.mContext = aboutActivity.getPageContext().getPageActivity();
        this.mLoadDataCallBack = iVar;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bsI != null) {
            this.bsI.cancel();
            return false;
        }
        return false;
    }

    public void TW() {
        if (this.bsI == null) {
            this.bsI = new b(this, null);
        }
        this.bsI.setPriority(3);
        this.bsI.execute(new String[0]);
    }
}
