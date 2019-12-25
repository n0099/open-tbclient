package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes10.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c jNR = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jNR = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jNR.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jNR.cCL()) {
            this.jNR.cCP();
            TiebaStatic.log("c10649");
        }
        if (view == this.jNR.cCM()) {
            this.jNR.cCQ();
            TiebaStatic.log("c10653");
        } else if (view == this.jNR.cCN()) {
            this.jNR.cCR();
        } else if (view == this.jNR.cCO()) {
            this.jNR.cCS();
        }
    }
}
