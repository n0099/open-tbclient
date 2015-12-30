package com.baidu.tieba.themeCenter.theme.top;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.themeCenter.theme.top.d;
/* loaded from: classes.dex */
public class TopThemeListActivity extends BaseActivity<TopThemeListActivity> {
    private com.baidu.tieba.themeCenter.d dNH;
    private d.a dNI = new b(this);
    private d dOL;
    private h dOM;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
        this.dNH = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dOM = new h(this, this.dNH.aHy());
        this.dOL = new d(this);
        this.dOL.a(this.dNI);
        showLoadingView(this.dOM.getRootView());
        this.dOL.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.m411getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
            showLoadingView(this.dOM.getRootView());
            this.dOL.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dOM != null) {
            this.dOM.ot();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dOL != null) {
            this.dOL.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dOL != null && this.dOM != null) {
            showLoadingView(this.dOM.getRootView());
            this.dOL.LoadData();
        }
    }
}
