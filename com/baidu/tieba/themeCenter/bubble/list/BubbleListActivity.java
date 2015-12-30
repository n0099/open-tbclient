package com.baidu.tieba.themeCenter.bubble.list;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.themeCenter.bubble.list.e;
/* loaded from: classes.dex */
public class BubbleListActivity extends BaseActivity<BubbleListActivity> {
    private com.baidu.tieba.themeCenter.bubble.all.a dMZ;
    private e dNk;
    private h dNl;
    private e.a dNm = new a(this);
    private BdListView.e mScrollToBottomListener = new b(this);
    private final r.a bdP = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dNk = new e(this);
        this.dNk.a(this.dNm);
        this.dMZ = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.dNl = new h(this, this.dMZ);
        this.dNl.a(this.mScrollToBottomListener, this.bdP);
        showLoadingView(this.dNl.getRootView());
        this.dNk.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dNl != null) {
            this.dNl.ot();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dNk != null && this.dNl != null) {
            showLoadingView(this.dNl.getRootView());
            this.dNk.LoadData();
        }
    }
}
