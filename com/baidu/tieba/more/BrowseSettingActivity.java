package com.baidu.tieba.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    private k bvj = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(BrowseSettingActivityConfig.class, BrowseSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bvj = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bvj.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvj.UP()) {
            this.bvj.UU();
        } else if (view == this.bvj.UQ()) {
            this.bvj.UV();
        } else if (view == this.bvj.UR()) {
            this.bvj.UW();
        } else if (view == this.bvj.US()) {
            this.bvj.UX();
        } else if (view == this.bvj.UT()) {
            this.bvj.UY();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.bvj.gT(1);
        } else {
            this.bvj.gT(0);
        }
    }
}
