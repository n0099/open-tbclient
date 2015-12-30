package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.themeCenter.background.d;
/* loaded from: classes.dex */
public class BackgroundGroupActivity extends BaseActivity<BackgroundGroupActivity> {
    private d dLL;
    private g dLM;
    private i dLN;
    private d.a dLO = new a(this);
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.dLL = new d(this);
        this.dLL.a(this.dLO);
        this.dLN = new i(this.mPageContext);
        this.dLM = new g(this, this.dLN);
        this.dLM.aHE();
        showLoadingView(this.dLM.getRootView());
        this.dLL.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.m411getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
            showLoadingView(this.dLM.getRootView());
            this.dLL.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dLM != null) {
            this.dLM.ot();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dLL != null && this.dLM != null) {
            showLoadingView(this.dLM.getRootView());
            this.dLL.LoadData();
        }
    }

    public int getPropId() {
        return this.dLN.getPropId();
    }
}
