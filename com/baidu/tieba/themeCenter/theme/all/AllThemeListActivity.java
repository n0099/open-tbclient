package com.baidu.tieba.themeCenter.theme.all;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.themeCenter.theme.top.d;
/* loaded from: classes.dex */
public class AllThemeListActivity extends BaseActivity<AllThemeListActivity> {
    private d dNF;
    private h dNG;
    private com.baidu.tieba.themeCenter.d dNH;
    private d.a dNI = new a(this);
    private BdListView.e mScrollToBottomListener = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
        this.dNH = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dNG = new h(this, this.dNH.aHy());
        this.dNG.setOnSrollToBottomListener(this.mScrollToBottomListener);
        this.dNF = new d(this);
        this.dNF.a(this.dNI);
        showLoadingView(this.dNG.getRootView());
        this.dNF.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.m411getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
            showLoadingView(this.dNG.getRootView());
            this.dNF.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dNG != null) {
            this.dNG.tr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dNF != null) {
            this.dNF.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dNF != null && this.dNG != null) {
            showLoadingView(this.dNG.getRootView());
            this.dNF.LoadData();
        }
    }
}
