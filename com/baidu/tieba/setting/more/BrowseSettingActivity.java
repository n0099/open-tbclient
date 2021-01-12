package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes7.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c mWi = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mWi = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mWi.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mWi.dEv()) {
            this.mWi.dEz();
            TiebaStatic.log("c10649");
        }
        if (view == this.mWi.dEw()) {
            this.mWi.dEA();
            TiebaStatic.log("c10653");
        } else if (view == this.mWi.dEx()) {
            this.mWi.dEB();
        } else if (view == this.mWi.dEy()) {
            this.mWi.dEC();
        } else if (view == this.mWi.dED()) {
            be.bsB().b(getPageContext(), new String[]{"http://bjhw-bac-orp-tieba-core-137287.bjhw.baidu.com:8899/#/app-tool"});
        }
    }
}
