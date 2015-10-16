package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.themeCenter.background.d;
/* loaded from: classes.dex */
public class BackgroundGroupActivity extends BaseActivity<BackgroundGroupActivity> {
    private d deU;
    private g deV;
    private i deW;
    private d.a deX = new a(this);
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        this.deU = new d(this);
        this.deU.a(this.deX);
        this.deW = new i(this.mPageContext);
        this.deV = new g(this, this.deW);
        showLoadingView(this.deV.getRootView());
        this.deU.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.deV != null) {
            this.deV.oO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.deU != null && this.deV != null) {
            showLoadingView(this.deV.getRootView());
            this.deU.LoadData();
        }
    }

    public int getPropId() {
        return this.deW.getPropId();
    }
}
