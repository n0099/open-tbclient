package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.themeCenter.background.o;
/* loaded from: classes.dex */
public class BackgroundListActivity extends BaseActivity<BackgroundListActivity> {
    private o dEH;
    private r dEI;
    i dEj;
    private TbPageContext<?> mPageContext;
    private o.a dEJ = new k(this);
    private BdListView.e mScrollToBottomListener = new l(this);
    private final q.a aZS = new m(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.dEH = new o(this);
        this.dEH.a(this.dEJ);
        this.dEj = new i(this.mPageContext);
        this.dEI = new r(this, this.dEj);
        this.dEI.a(this.mScrollToBottomListener, this.aZS);
        showLoadingView(this.dEI.getRootView());
        this.dEH.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.m411getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
            showLoadingView(this.dEI.getRootView());
            this.dEH.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dEI != null) {
            this.dEI.oV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dEH != null) {
            this.dEH.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dEH != null && this.dEI != null) {
            showLoadingView(this.dEI.getRootView());
            this.dEH.LoadData();
        }
    }

    public int getPropId() {
        return this.dEj.getPropId();
    }
}
