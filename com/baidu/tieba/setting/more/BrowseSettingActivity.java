package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes11.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c jRu = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jRu = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jRu.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jRu.cDP()) {
            this.jRu.cDT();
            TiebaStatic.log("c10649");
        }
        if (view == this.jRu.cDQ()) {
            this.jRu.cDU();
            TiebaStatic.log("c10653");
        } else if (view == this.jRu.cDR()) {
            this.jRu.cDV();
        } else if (view == this.jRu.cDS()) {
            this.jRu.cDW();
        }
    }
}
