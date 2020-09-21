package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes25.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c lYE = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lYE = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lYE.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lYE.dul()) {
            this.lYE.dup();
            TiebaStatic.log("c10649");
        }
        if (view == this.lYE.dum()) {
            this.lYE.duq();
            TiebaStatic.log("c10653");
        } else if (view == this.lYE.dun()) {
            this.lYE.dur();
        } else if (view == this.lYE.duo()) {
            this.lYE.dus();
        } else if (view == this.lYE.dut()) {
            be.bkp().b(getPageContext(), new String[]{"http://10.64.36.212:8011/auxiliary-pages/index.html#/app-tool"});
        }
    }
}
