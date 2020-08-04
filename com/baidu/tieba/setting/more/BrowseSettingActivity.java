package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes20.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c lxX = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lxX = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lxX.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lxX.dfb()) {
            this.lxX.dff();
            TiebaStatic.log("c10649");
        }
        if (view == this.lxX.dfc()) {
            this.lxX.dfg();
            TiebaStatic.log("c10653");
        } else if (view == this.lxX.dfd()) {
            this.lxX.dfh();
        } else if (view == this.lxX.dfe()) {
            this.lxX.dfi();
        }
    }
}
