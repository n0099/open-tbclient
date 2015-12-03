package com.baidu.tieba.themeCenter.bubble.list;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.themeCenter.bubble.list.e;
/* loaded from: classes.dex */
public class BubbleListActivity extends BaseActivity<BubbleListActivity> {
    private e dFI;
    private h dFJ;
    private com.baidu.tieba.themeCenter.bubble.all.a dFx;
    private e.a dFK = new a(this);
    private BdListView.e mScrollToBottomListener = new b(this);
    private final q.a aZS = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dFI = new e(this);
        this.dFI.a(this.dFK);
        this.dFx = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.dFJ = new h(this, this.dFx);
        this.dFJ.a(this.mScrollToBottomListener, this.aZS);
        showLoadingView(this.dFJ.getRootView());
        this.dFI.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dFJ != null) {
            this.dFJ.oV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dFI != null && this.dFJ != null) {
            showLoadingView(this.dFJ.getRootView());
            this.dFI.LoadData();
        }
    }
}
