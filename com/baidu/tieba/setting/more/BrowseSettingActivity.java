package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes13.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c kWH = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kWH = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kWH.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kWH.cXE()) {
            this.kWH.cXI();
            TiebaStatic.log("c10649");
        }
        if (view == this.kWH.cXF()) {
            this.kWH.cXJ();
            TiebaStatic.log("c10653");
        } else if (view == this.kWH.cXG()) {
            this.kWH.cXK();
        } else if (view == this.kWH.cXH()) {
            this.kWH.cXL();
        }
    }
}
