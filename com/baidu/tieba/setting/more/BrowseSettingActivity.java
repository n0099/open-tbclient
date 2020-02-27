package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes13.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c jSu = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jSu = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jSu.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jSu.cFs()) {
            this.jSu.cFw();
            TiebaStatic.log("c10649");
        }
        if (view == this.jSu.cFt()) {
            this.jSu.cFx();
            TiebaStatic.log("c10653");
        } else if (view == this.jSu.cFu()) {
            this.jSu.cFy();
        } else if (view == this.jSu.cFv()) {
            this.jSu.cFz();
        }
    }
}
