package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class BrowseSettingActivity extends BaseActivity {
    private b gNS = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gNS = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gNS.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gNS.bvr()) {
            this.gNS.bvv();
            TiebaStatic.log("c10649");
        }
        if (view == this.gNS.bvs()) {
            this.gNS.bvw();
            TiebaStatic.log("c10653");
        } else if (view == this.gNS.bvt()) {
            this.gNS.bvx();
        } else if (view == this.gNS.bvu()) {
            this.gNS.bvy();
        }
    }
}
