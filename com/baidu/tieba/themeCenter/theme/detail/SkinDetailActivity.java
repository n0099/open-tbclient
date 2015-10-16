package com.baidu.tieba.themeCenter.theme.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SkinDetailActivityConfig;
import com.baidu.tieba.themeCenter.theme.detail.d;
/* loaded from: classes.dex */
public class SkinDetailActivity extends BaseActivity<SkinDetailActivity> {
    private d dgM;
    private f dgN;
    private int dgO;
    private String dgP;
    private String dgQ;
    private d.a dgR = new a(this);
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
            this.dgO = intent.getIntExtra(SkinDetailActivityConfig.THEME_ID, 0);
            this.mSkinType = intent.getIntExtra(SkinDetailActivityConfig.THEME_CURRENT_TYPE, 1);
            this.dgP = intent.getStringExtra(SkinDetailActivityConfig.THEME_ALBUM_PICTURE);
            this.dgQ = intent.getStringExtra(SkinDetailActivityConfig.THEME_PERMISSION_ICON_URL);
        }
        this.dgN = new f(this);
        this.dgN.setOnClickListener(this.mClickListener);
        this.dgM = new d();
        this.dgM.a(this.dgR);
        showLoadingView(this.dgN.getRootView());
        this.dgM.lA(this.dgO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dgM != null) {
            this.dgM.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dgM != null && this.dgN != null) {
            showLoadingView(this.dgN.getRootView());
            this.dgM.lA(this.dgO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dgN != null) {
            this.dgN.vA();
        }
    }
}
