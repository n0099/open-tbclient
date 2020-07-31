package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes20.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c lxV = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lxV = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lxV.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lxV.dfb()) {
            this.lxV.dff();
            TiebaStatic.log("c10649");
        }
        if (view == this.lxV.dfc()) {
            this.lxV.dfg();
            TiebaStatic.log("c10653");
        } else if (view == this.lxV.dfd()) {
            this.lxV.dfh();
        } else if (view == this.lxV.dfe()) {
            this.lxV.dfi();
        }
    }
}
