package com.baidu.tieba.themeCenter.theme.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SkinDetailActivityConfig;
import com.baidu.tieba.themeCenter.theme.detail.d;
/* loaded from: classes.dex */
public class SkinDetailActivity extends BaseActivity<SkinDetailActivity> {
    private d dgm;
    private f dgn;
    private int dgo;
    private String dgp;
    private String dgq;
    private d.a dgr = new a(this);
    private View.OnClickListener mClickListener = new b(this);
    private com.baidu.tieba.themeCenter.b mSkinData;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSkinData = new com.baidu.tieba.themeCenter.b();
        Intent intent = getIntent();
        if (intent != null) {
            this.dgo = intent.getIntExtra(SkinDetailActivityConfig.THEME_ID, 0);
            this.mSkinType = intent.getIntExtra(SkinDetailActivityConfig.THEME_CURRENT_TYPE, 1);
            this.dgp = intent.getStringExtra(SkinDetailActivityConfig.THEME_ALBUM_PICTURE);
            this.dgq = intent.getStringExtra(SkinDetailActivityConfig.THEME_PERMISSION_ICON_URL);
        }
        this.dgn = new f(this);
        this.dgn.setOnClickListener(this.mClickListener);
        this.dgm = new d();
        this.dgm.a(this.dgr);
        showLoadingView(this.dgn.getRootView());
        this.dgm.ly(this.dgo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dgm != null) {
            this.dgm.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dgm != null && this.dgn != null) {
            showLoadingView(this.dgn.getRootView());
            this.dgm.ly(this.dgo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dgn != null) {
            this.dgn.vA();
        }
    }
}
