package com.baidu.tieba.themeCenter.theme.all;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.theme.top.d;
/* loaded from: classes.dex */
public class AllThemeListActivity extends BaseActivity<AllThemeListActivity> {
    private d dhV;
    private h dhW;
    private com.baidu.tieba.themeCenter.d dhX;
    private d.a dhY = new a(this);
    private BdListView.e mScrollToBottomListener = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dhX = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dhW = new h(this, this.dhX.aAc());
        this.dhW.setOnSrollToBottomListener(this.mScrollToBottomListener);
        this.dhV = new d();
        this.dhV.a(this.dhY);
        showLoadingView(this.dhW.getRootView());
        this.dhV.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dhW != null) {
            this.dhW.tc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dhV != null) {
            this.dhV.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dhV != null && this.dhW != null) {
            showLoadingView(this.dhW.getRootView());
            this.dhV.LoadData();
        }
    }
}
