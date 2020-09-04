package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes20.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c lPy = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lPy = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lPy.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lPy.dqx()) {
            this.lPy.dqB();
            TiebaStatic.log("c10649");
        }
        if (view == this.lPy.dqy()) {
            this.lPy.dqC();
            TiebaStatic.log("c10653");
        } else if (view == this.lPy.dqz()) {
            this.lPy.dqD();
        } else if (view == this.lPy.dqA()) {
            this.lPy.dqE();
        }
    }
}
