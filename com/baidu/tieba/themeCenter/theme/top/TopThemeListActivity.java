package com.baidu.tieba.themeCenter.theme.top;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.themeCenter.theme.top.d;
/* loaded from: classes.dex */
public class TopThemeListActivity extends BaseActivity<TopThemeListActivity> {
    private com.baidu.tieba.themeCenter.d dGg;
    private d.a dGh = new b(this);
    private d dHk;
    private h dHl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
        this.dGg = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dHl = new h(this, this.dGg.aFj());
        this.dHk = new d(this);
        this.dHk.a(this.dGh);
        showLoadingView(this.dHl.getRootView());
        this.dHk.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.m411getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
            showLoadingView(this.dHl.getRootView());
            this.dHk.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dHl != null) {
            this.dHl.oV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dHk != null) {
            this.dHk.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dHk != null && this.dHl != null) {
            showLoadingView(this.dHl.getRootView());
            this.dHk.LoadData();
        }
    }
}
