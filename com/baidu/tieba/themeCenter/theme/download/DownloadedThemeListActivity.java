package com.baidu.tieba.themeCenter.theme.download;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.SkinItemView;
import com.baidu.tieba.themeCenter.theme.download.d;
/* loaded from: classes.dex */
public class DownloadedThemeListActivity extends BaseActivity<DownloadedThemeListActivity> {
    private h dGV;
    private d dGW;
    private com.baidu.tieba.themeCenter.d dGg;
    private boolean dGX = false;
    private d.a dGY = new a(this);
    private View.OnClickListener bvm = new b(this);
    private SkinItemView.a dGZ = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dGg = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dGV = new h(this, this.dGZ);
        this.dGV.aFE().setOnClickListener(this.bvm);
        this.dGW = new d();
        this.dGW.a(this.dGY);
        this.dGW.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dGV != null) {
            this.dGV.tH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dGW != null) {
            this.dGW.destroy();
        }
    }
}
