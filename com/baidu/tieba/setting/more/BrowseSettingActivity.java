package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes8.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c nfR = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nfR = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.nfR.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nfR.dGG()) {
            this.nfR.dGK();
            TiebaStatic.log("c10649");
        }
        if (view == this.nfR.dGH()) {
            this.nfR.dGL();
            TiebaStatic.log("c10653");
        } else if (view == this.nfR.dGI()) {
            this.nfR.dGM();
        } else if (view == this.nfR.dGJ()) {
            this.nfR.dGN();
        } else if (view == this.nfR.dGO()) {
            bf.bsV().b(getPageContext(), new String[]{"http://bjhw-bac-orp-tieba-core-137287.bjhw.baidu.com:8899/#/app-tool"});
        }
    }
}
