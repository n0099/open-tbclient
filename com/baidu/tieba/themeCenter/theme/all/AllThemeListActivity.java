package com.baidu.tieba.themeCenter.theme.all;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.theme.top.d;
/* loaded from: classes.dex */
public class AllThemeListActivity extends BaseActivity<AllThemeListActivity> {
    private d dgp;
    private h dgq;
    private com.baidu.tieba.themeCenter.d dgr;
    private d.a dgs = new a(this);
    private BdListView.e mScrollToBottomListener = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dgr = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dgq = new h(this, this.dgr.azq());
        this.dgq.setOnSrollToBottomListener(this.mScrollToBottomListener);
        this.dgp = new d();
        this.dgp.a(this.dgs);
        showLoadingView(this.dgq.getRootView());
        this.dgp.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dgq != null) {
            this.dgq.tc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dgp != null) {
            this.dgp.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dgp != null && this.dgq != null) {
            showLoadingView(this.dgq.getRootView());
            this.dgp.LoadData();
        }
    }
}
