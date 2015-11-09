package com.baidu.tieba.themeCenter.theme.download;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.SkinItemView;
import com.baidu.tieba.themeCenter.theme.download.d;
/* loaded from: classes.dex */
public class DownloadedThemeListActivity extends BaseActivity<DownloadedThemeListActivity> {
    private com.baidu.tieba.themeCenter.d dhX;
    private h diK;
    private d diL;
    private boolean diM = false;
    private d.a diN = new a(this);
    private View.OnClickListener diO = new b(this);
    private SkinItemView.a diP = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dhX = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.diK = new h(this, this.diP);
        this.diK.aAt().setOnClickListener(this.diO);
        this.diL = new d();
        this.diL.a(this.diN);
        this.diL.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.diK != null) {
            this.diK.tc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.diL != null) {
            this.diL.destroy();
        }
    }
}
