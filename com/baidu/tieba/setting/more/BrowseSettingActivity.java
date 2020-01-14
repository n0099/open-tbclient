package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes11.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c jRz = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jRz = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jRz.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jRz.cDR()) {
            this.jRz.cDV();
            TiebaStatic.log("c10649");
        }
        if (view == this.jRz.cDS()) {
            this.jRz.cDW();
            TiebaStatic.log("c10653");
        } else if (view == this.jRz.cDT()) {
            this.jRz.cDX();
        } else if (view == this.jRz.cDU()) {
            this.jRz.cDY();
        }
    }
}
