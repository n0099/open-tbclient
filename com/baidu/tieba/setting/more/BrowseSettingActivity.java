package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes20.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c lPl = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lPl = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lPl.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lPl.dqu()) {
            this.lPl.dqy();
            TiebaStatic.log("c10649");
        }
        if (view == this.lPl.dqv()) {
            this.lPl.dqz();
            TiebaStatic.log("c10653");
        } else if (view == this.lPl.dqw()) {
            this.lPl.dqA();
        } else if (view == this.lPl.dqx()) {
            this.lPl.dqB();
        }
    }
}
