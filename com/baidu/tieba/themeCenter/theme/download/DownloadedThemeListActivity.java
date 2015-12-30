package com.baidu.tieba.themeCenter.theme.download;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.SkinItemView;
import com.baidu.tieba.themeCenter.theme.download.d;
/* loaded from: classes.dex */
public class DownloadedThemeListActivity extends BaseActivity<DownloadedThemeListActivity> {
    private com.baidu.tieba.themeCenter.d dNH;
    private h dOw;
    private d dOx;
    private boolean dOy = false;
    private d.a dOz = new a(this);
    private View.OnClickListener bzd = new b(this);
    private SkinItemView.a dOA = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dNH = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dOw = new h(this, this.dOA);
        this.dOw.aHT().setOnClickListener(this.bzd);
        this.dOx = new d();
        this.dOx.a(this.dOz);
        this.dOx.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dOw != null) {
            this.dOw.tr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dOx != null) {
            this.dOx.destroy();
        }
    }
}
