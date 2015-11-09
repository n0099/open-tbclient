package com.baidu.tieba.themeCenter.theme.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SkinDetailActivityConfig;
import com.baidu.tieba.themeCenter.theme.detail.d;
/* loaded from: classes.dex */
public class SkinDetailActivity extends BaseActivity<SkinDetailActivity> {
    private d dis;
    private f dit;
    private int diu;
    private String div;
    private String diw;
    private d.a dix = new a(this);
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
            this.diu = intent.getIntExtra(SkinDetailActivityConfig.THEME_ID, 0);
            this.mSkinType = intent.getIntExtra(SkinDetailActivityConfig.THEME_CURRENT_TYPE, 1);
            this.div = intent.getStringExtra(SkinDetailActivityConfig.THEME_ALBUM_PICTURE);
            this.diw = intent.getStringExtra(SkinDetailActivityConfig.THEME_PERMISSION_ICON_URL);
        }
        this.dit = new f(this);
        this.dit.setOnClickListener(this.mClickListener);
        this.dis = new d();
        this.dis.a(this.dix);
        showLoadingView(this.dit.getRootView());
        this.dis.lO(this.diu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dis != null) {
            this.dis.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dis != null && this.dit != null) {
            showLoadingView(this.dit.getRootView());
            this.dis.lO(this.diu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dit != null) {
            this.dit.vB();
        }
    }
}
