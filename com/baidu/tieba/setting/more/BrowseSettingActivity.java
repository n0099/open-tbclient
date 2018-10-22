package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class BrowseSettingActivity extends BaseActivity {
    private b gNT = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gNT = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gNT.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gNT.bvr()) {
            this.gNT.bvv();
            TiebaStatic.log("c10649");
        }
        if (view == this.gNT.bvs()) {
            this.gNT.bvw();
            TiebaStatic.log("c10653");
        } else if (view == this.gNT.bvt()) {
            this.gNT.bvx();
        } else if (view == this.gNT.bvu()) {
            this.gNT.bvy();
        }
    }
}
