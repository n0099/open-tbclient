package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class BrowseSettingActivity extends BaseActivity {
    private b gxW = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gxW = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gxW.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gxW.bqR()) {
            this.gxW.bqW();
            TiebaStatic.log("c10649");
        }
        if (view == this.gxW.bqS()) {
            this.gxW.bqX();
            TiebaStatic.log("c10653");
        } else if (view == this.gxW.bqT()) {
            this.gxW.bqY();
        } else if (view == this.gxW.bqU()) {
            this.gxW.bqZ();
        } else if (view == this.gxW.bqV()) {
            this.gxW.bra();
        }
    }
}
