package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class BrowseSettingActivity extends BaseActivity {
    private b gue = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gue = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gue.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gue.bqq()) {
            this.gue.bqv();
            TiebaStatic.log("c10649");
        }
        if (view == this.gue.bqr()) {
            this.gue.bqw();
            TiebaStatic.log("c10653");
        } else if (view == this.gue.bqs()) {
            this.gue.bqx();
        } else if (view == this.gue.bqt()) {
            this.gue.bqy();
        } else if (view == this.gue.bqu()) {
            this.gue.bqz();
        }
    }
}
