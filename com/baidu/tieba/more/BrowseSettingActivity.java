package com.baidu.tieba.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    private k btN = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(BrowseSettingActivityConfig.class, BrowseSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.btN = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.btN.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.btN.Uw()) {
            this.btN.UB();
        } else if (view == this.btN.Ux()) {
            this.btN.UC();
        } else if (view == this.btN.Uy()) {
            this.btN.UD();
        } else if (view == this.btN.Uz()) {
            this.btN.UE();
        } else if (view == this.btN.UA()) {
            this.btN.UF();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.btN.gK(1);
        } else {
            this.btN.gK(0);
        }
    }
}
