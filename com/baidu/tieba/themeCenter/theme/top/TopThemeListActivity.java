package com.baidu.tieba.themeCenter.theme.top;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.theme.top.d;
/* loaded from: classes.dex */
public class TopThemeListActivity extends BaseActivity<TopThemeListActivity> {
    private com.baidu.tieba.themeCenter.d dfR;
    private d.a dfS = new b(this);
    private d dgU;
    private h dgV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dfR = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dgV = new h(this, this.dfR.azg());
        this.dgU = new d();
        this.dgU.a(this.dfS);
        showLoadingView(this.dgV.getRootView());
        this.dgU.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dgV != null) {
            this.dgV.oO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dgU != null) {
            this.dgU.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dgU != null && this.dgV != null) {
            showLoadingView(this.dgV.getRootView());
            this.dgU.LoadData();
        }
    }
}
