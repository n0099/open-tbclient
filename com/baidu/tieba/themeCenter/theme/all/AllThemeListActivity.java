package com.baidu.tieba.themeCenter.theme.all;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.themeCenter.theme.top.d;
/* loaded from: classes.dex */
public class AllThemeListActivity extends BaseActivity<AllThemeListActivity> {
    private d dGe;
    private h dGf;
    private com.baidu.tieba.themeCenter.d dGg;
    private d.a dGh = new a(this);
    private BdListView.e mScrollToBottomListener = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
        this.dGg = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dGf = new h(this, this.dGg.aFj());
        this.dGf.setOnSrollToBottomListener(this.mScrollToBottomListener);
        this.dGe = new d(this);
        this.dGe.a(this.dGh);
        showLoadingView(this.dGf.getRootView());
        this.dGe.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.m411getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
            showLoadingView(this.dGf.getRootView());
            this.dGe.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dGf != null) {
            this.dGf.tH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dGe != null) {
            this.dGe.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dGe != null && this.dGf != null) {
            showLoadingView(this.dGf.getRootView());
            this.dGe.LoadData();
        }
    }
}
