package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.themeCenter.background.d;
/* loaded from: classes.dex */
public class BackgroundGroupActivity extends BaseActivity<BackgroundGroupActivity> {
    private d deu;
    private g dev;
    private i dew;
    private d.a dex = new a(this);
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        this.deu = new d(this);
        this.deu.a(this.dex);
        this.dew = new i(this.mPageContext);
        this.dev = new g(this, this.dew);
        showLoadingView(this.dev.getRootView());
        this.deu.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dev != null) {
            this.dev.oO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.deu != null && this.dev != null) {
            showLoadingView(this.dev.getRootView());
            this.deu.LoadData();
        }
    }

    public int getPropId() {
        return this.dew.getPropId();
    }
}
