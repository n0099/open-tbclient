package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes13.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c jSI = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jSI = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jSI.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jSI.cFv()) {
            this.jSI.cFz();
            TiebaStatic.log("c10649");
        }
        if (view == this.jSI.cFw()) {
            this.jSI.cFA();
            TiebaStatic.log("c10653");
        } else if (view == this.jSI.cFx()) {
            this.jSI.cFB();
        } else if (view == this.jSI.cFy()) {
            this.jSI.cFC();
        }
    }
}
