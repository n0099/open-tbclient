package com.baidu.tieba.themeCenter.theme.top;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.theme.top.d;
/* loaded from: classes.dex */
public class TopThemeListActivity extends BaseActivity<TopThemeListActivity> {
    private com.baidu.tieba.themeCenter.d dgr;
    private d.a dgs = new b(this);
    private d dhu;
    private h dhv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dgr = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dhv = new h(this, this.dgr.azq());
        this.dhu = new d();
        this.dhu.a(this.dgs);
        showLoadingView(this.dhv.getRootView());
        this.dhu.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dhv != null) {
            this.dhv.oO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dhu != null) {
            this.dhu.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dhu != null && this.dhv != null) {
            showLoadingView(this.dhv.getRootView());
            this.dhu.LoadData();
        }
    }
}
