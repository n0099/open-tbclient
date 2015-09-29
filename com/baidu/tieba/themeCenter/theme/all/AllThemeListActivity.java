package com.baidu.tieba.themeCenter.theme.all;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.theme.top.d;
/* loaded from: classes.dex */
public class AllThemeListActivity extends BaseActivity<AllThemeListActivity> {
    private d dfP;
    private h dfQ;
    private com.baidu.tieba.themeCenter.d dfR;
    private d.a dfS = new a(this);
    private BdListView.e mScrollToBottomListener = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dfR = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dfQ = new h(this, this.dfR.azg());
        this.dfQ.setOnSrollToBottomListener(this.mScrollToBottomListener);
        this.dfP = new d();
        this.dfP.a(this.dfS);
        showLoadingView(this.dfQ.getRootView());
        this.dfP.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dfQ != null) {
            this.dfQ.tc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dfP != null) {
            this.dfP.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dfP != null && this.dfQ != null) {
            showLoadingView(this.dfQ.getRootView());
            this.dfP.LoadData();
        }
    }
}
