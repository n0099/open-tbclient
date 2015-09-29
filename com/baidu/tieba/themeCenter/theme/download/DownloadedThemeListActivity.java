package com.baidu.tieba.themeCenter.theme.download;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.SkinItemView;
import com.baidu.tieba.themeCenter.theme.download.d;
/* loaded from: classes.dex */
public class DownloadedThemeListActivity extends BaseActivity<DownloadedThemeListActivity> {
    private com.baidu.tieba.themeCenter.d dfR;
    private h dgE;
    private d dgF;
    private boolean dgG = false;
    private d.a dgH = new a(this);
    private View.OnClickListener dgI = new b(this);
    private SkinItemView.a dgJ = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dfR = new com.baidu.tieba.themeCenter.d(getPageContext());
        this.dgE = new h(this, this.dgJ);
        this.dgE.azx().setOnClickListener(this.dgI);
        this.dgF = new d();
        this.dgF.a(this.dgH);
        this.dgF.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dgE != null) {
            this.dgE.tc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dgF != null) {
            this.dgF.destroy();
        }
    }
}
