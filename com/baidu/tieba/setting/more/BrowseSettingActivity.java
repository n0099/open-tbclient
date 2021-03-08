package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes7.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c niw = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.niw = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.niw.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.niw.dGW()) {
            this.niw.dHa();
            TiebaStatic.log("c10649");
        }
        if (view == this.niw.dGX()) {
            this.niw.dHb();
            TiebaStatic.log("c10653");
        } else if (view == this.niw.dGY()) {
            this.niw.dHc();
        } else if (view == this.niw.dGZ()) {
            this.niw.dHd();
        } else if (view == this.niw.dHe()) {
            bf.bsY().b(getPageContext(), new String[]{"http://bjhw-bac-orp-tieba-core-137287.bjhw.baidu.com:8899/#/app-tool"});
        }
    }
}
