package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes26.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c mGO = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mGO = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mGO.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mGO.dDG()) {
            this.mGO.dDK();
            TiebaStatic.log("c10649");
        }
        if (view == this.mGO.dDH()) {
            this.mGO.dDL();
            TiebaStatic.log("c10653");
        } else if (view == this.mGO.dDI()) {
            this.mGO.dDM();
        } else if (view == this.mGO.dDJ()) {
            this.mGO.dDN();
        } else if (view == this.mGO.dDO()) {
            be.brr().b(getPageContext(), new String[]{"http://10.64.36.212:8011/auxiliary-pages/index.html#/app-tool"});
        }
    }
}
