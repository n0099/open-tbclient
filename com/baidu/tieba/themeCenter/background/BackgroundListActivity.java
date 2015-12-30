package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.themeCenter.background.o;
/* loaded from: classes.dex */
public class BackgroundListActivity extends BaseActivity<BackgroundListActivity> {
    i dLN;
    private o dMk;
    private r dMl;
    private TbPageContext<?> mPageContext;
    private o.a dMm = new k(this);
    private BdListView.e mScrollToBottomListener = new l(this);
    private final r.a bdP = new m(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.dMk = new o(this);
        this.dMk.a(this.dMm);
        this.dLN = new i(this.mPageContext);
        this.dMl = new r(this, this.dLN);
        this.dMl.a(this.mScrollToBottomListener, this.bdP);
        showLoadingView(this.dMl.getRootView());
        this.dMk.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.m411getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
            showLoadingView(this.dMl.getRootView());
            this.dMk.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dMl != null) {
            this.dMl.ot();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dMk != null) {
            this.dMk.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dMk != null && this.dMl != null) {
            showLoadingView(this.dMl.getRootView());
            this.dMk.LoadData();
        }
    }

    public int getPropId() {
        return this.dLN.getPropId();
    }
}
