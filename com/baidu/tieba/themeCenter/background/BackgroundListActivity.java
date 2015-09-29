package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.themeCenter.background.o;
/* loaded from: classes.dex */
public class BackgroundListActivity extends BaseActivity<BackgroundListActivity> {
    private o deY;
    private r deZ;
    i dew;
    private TbPageContext<?> mPageContext;
    private o.a dfa = new k(this);
    private BdListView.e mScrollToBottomListener = new l(this);
    private final p.a aUl = new m(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        this.deY = new o(this);
        this.deY.a(this.dfa);
        this.dew = new i(this.mPageContext);
        this.deZ = new r(this, this.dew);
        this.deZ.a(this.mScrollToBottomListener, this.aUl);
        showLoadingView(this.deZ.getRootView());
        this.deY.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.deZ != null) {
            this.deZ.oO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.deY != null) {
            this.deY.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.deY != null && this.deZ != null) {
            showLoadingView(this.deZ.getRootView());
            this.deY.LoadData();
        }
    }

    public int getPropId() {
        return this.dew.getPropId();
    }
}
