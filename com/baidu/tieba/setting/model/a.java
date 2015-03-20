package com.baidu.tieba.setting.model;

import android.content.Context;
import com.baidu.adp.base.f;
import com.baidu.adp.base.i;
import com.baidu.tieba.setting.more.AboutActivity;
/* loaded from: classes.dex */
public class a extends f<AboutActivity> {
    private b bZE;
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
        if (this.bZE != null) {
            this.bZE.cancel();
            return false;
        }
        return false;
    }

    public void agh() {
        if (this.bZE == null) {
            this.bZE = new b(this, null);
        }
        this.bZE.setPriority(3);
        this.bZE.execute(new String[0]);
    }
}
