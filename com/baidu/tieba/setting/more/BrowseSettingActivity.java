package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.b {
    private k cah = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cah = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cah.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cah.agm()) {
            this.cah.agq();
        } else if (view == this.cah.agn()) {
            this.cah.agr();
        } else if (view == this.cah.ago()) {
            this.cah.ags();
        } else if (view == this.cah.agp()) {
            this.cah.agt();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.cah.hU(1);
        } else {
            this.cah.hU(0);
        }
    }
}
