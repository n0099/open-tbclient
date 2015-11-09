package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends BaseActivity implements BdSwitchView.a {
    private l cOr = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cOr = new l(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cOr.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cOr.asc()) {
            this.cOr.asg();
        } else if (view == this.cOr.asd()) {
            this.cOr.ash();
        } else if (view == this.cOr.ase()) {
            this.cOr.asi();
        } else if (view == this.cOr.asf()) {
            this.cOr.asj();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.cOr.kP(1);
        } else {
            this.cOr.kP(0);
        }
    }
}
