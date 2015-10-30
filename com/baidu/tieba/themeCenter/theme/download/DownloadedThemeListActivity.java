package com.baidu.tieba.themeCenter.theme.download;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.SkinItemView;
import com.baidu.tieba.themeCenter.theme.download.d;
/* loaded from: classes.dex */
public class DownloadedThemeListActivity extends BaseActivity<DownloadedThemeListActivity> {
    private com.baidu.tieba.themeCenter.d dgr;
    private h dhe;
    private d dhf;
    private boolean dhg = false;
    private d.a dhh = new a(this);
    private View.OnClickListener dhi = new b(this);
    private SkinItemView.a dhj = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dgr = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dhe = new h(this, this.dhj);
        this.dhe.azD().setOnClickListener(this.dhi);
        this.dhf = new d();
        this.dhf.a(this.dhh);
        this.dhf.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dhe != null) {
            this.dhe.sZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dhf != null) {
            this.dhf.destroy();
        }
    }
}
