package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.base.i;
import com.baidu.tieba.more.AboutActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f<AboutActivity> {
    private b bue;
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
        if (this.bue != null) {
            this.bue.cancel();
            return false;
        }
        return false;
    }

    public void Up() {
        if (this.bue == null) {
            this.bue = new b(this, null);
        }
        this.bue.setPriority(3);
        this.bue.execute(new String[0]);
    }
}
