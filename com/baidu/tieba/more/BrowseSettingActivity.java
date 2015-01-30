package com.baidu.tieba.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    private k bvk = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(BrowseSettingActivityConfig.class, BrowseSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bvk = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bvk.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvk.UU()) {
            this.bvk.UZ();
        } else if (view == this.bvk.UV()) {
            this.bvk.Va();
        } else if (view == this.bvk.UW()) {
            this.bvk.Vb();
        } else if (view == this.bvk.UX()) {
            this.bvk.Vc();
        } else if (view == this.bvk.UY()) {
            this.bvk.Vd();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.bvk.gT(1);
        } else {
            this.bvk.gT(0);
        }
    }
}
