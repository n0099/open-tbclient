package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.themeCenter.background.o;
/* loaded from: classes.dex */
public class BackgroundListActivity extends BaseActivity<BackgroundListActivity> {
    i deW;
    private o dfy;
    private r dfz;
    private TbPageContext<?> mPageContext;
    private o.a dfA = new k(this);
    private BdListView.e mScrollToBottomListener = new l(this);
    private final p.a aUw = new m(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        this.dfy = new o(this);
        this.dfy.a(this.dfA);
        this.deW = new i(this.mPageContext);
        this.dfz = new r(this, this.deW);
        this.dfz.a(this.mScrollToBottomListener, this.aUw);
        showLoadingView(this.dfz.getRootView());
        this.dfy.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dfz != null) {
            this.dfz.oO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dfy != null) {
            this.dfy.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dfy != null && this.dfz != null) {
            showLoadingView(this.dfz.getRootView());
            this.dfy.LoadData();
        }
    }

    public int getPropId() {
        return this.deW.getPropId();
    }
}
