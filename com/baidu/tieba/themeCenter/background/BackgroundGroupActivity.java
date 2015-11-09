package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.themeCenter.background.d;
/* loaded from: classes.dex */
public class BackgroundGroupActivity extends BaseActivity<BackgroundGroupActivity> {
    private d dgA;
    private g dgB;
    private i dgC;
    private d.a dgD = new a(this);
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        this.dgA = new d(this);
        this.dgA.a(this.dgD);
        this.dgC = new i(this.mPageContext);
        this.dgB = new g(this, this.dgC);
        showLoadingView(this.dgB.getRootView());
        this.dgA.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dgB != null) {
            this.dgB.oP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dgA != null && this.dgB != null) {
            showLoadingView(this.dgB.getRootView());
            this.dgA.LoadData();
        }
    }

    public int getPropId() {
        return this.dgC.getPropId();
    }
}
