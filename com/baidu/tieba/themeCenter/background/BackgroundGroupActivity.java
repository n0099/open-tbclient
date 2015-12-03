package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.themeCenter.background.d;
/* loaded from: classes.dex */
public class BackgroundGroupActivity extends BaseActivity<BackgroundGroupActivity> {
    private d dEh;
    private g dEi;
    private i dEj;
    private d.a dEk = new a(this);
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.dEh = new d(this);
        this.dEh.a(this.dEk);
        this.dEj = new i(this.mPageContext);
        this.dEi = new g(this, this.dEj);
        this.dEi.aFp();
        showLoadingView(this.dEi.getRootView());
        this.dEh.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.m411getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
            showLoadingView(this.dEi.getRootView());
            this.dEh.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dEi != null) {
            this.dEi.oV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dEh != null && this.dEi != null) {
            showLoadingView(this.dEi.getRootView());
            this.dEh.LoadData();
        }
    }

    public int getPropId() {
        return this.dEj.getPropId();
    }
}
