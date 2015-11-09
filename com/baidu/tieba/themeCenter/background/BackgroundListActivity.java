package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.themeCenter.background.o;
/* loaded from: classes.dex */
public class BackgroundListActivity extends BaseActivity<BackgroundListActivity> {
    i dgC;
    private o dhe;
    private r dhf;
    private TbPageContext<?> mPageContext;
    private o.a dhg = new k(this);
    private BdListView.e mScrollToBottomListener = new l(this);
    private final p.a aUE = new m(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        this.dhe = new o(this);
        this.dhe.a(this.dhg);
        this.dgC = new i(this.mPageContext);
        this.dhf = new r(this, this.dgC);
        this.dhf.a(this.mScrollToBottomListener, this.aUE);
        showLoadingView(this.dhf.getRootView());
        this.dhe.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dhf != null) {
            this.dhf.oP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dhe != null) {
            this.dhe.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dhe != null && this.dhf != null) {
            showLoadingView(this.dhf.getRootView());
            this.dhe.LoadData();
        }
    }

    public int getPropId() {
        return this.dgC.getPropId();
    }
}
