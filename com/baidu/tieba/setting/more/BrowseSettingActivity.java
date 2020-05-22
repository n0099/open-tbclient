package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes13.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c kVy = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kVy = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kVy.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kVy.cXo()) {
            this.kVy.cXs();
            TiebaStatic.log("c10649");
        }
        if (view == this.kVy.cXp()) {
            this.kVy.cXt();
            TiebaStatic.log("c10653");
        } else if (view == this.kVy.cXq()) {
            this.kVy.cXu();
        } else if (view == this.kVy.cXr()) {
            this.kVy.cXv();
        }
    }
}
