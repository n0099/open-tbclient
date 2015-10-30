package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends BaseActivity implements BdSwitchView.a {
    private l cMV = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cMV = new l(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cMV.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cMV.arw()) {
            this.cMV.arA();
        } else if (view == this.cMV.arx()) {
            this.cMV.arB();
        } else if (view == this.cMV.ary()) {
            this.cMV.arC();
        } else if (view == this.cMV.arz()) {
            this.cMV.arD();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.cMV.kB(1);
        } else {
            this.cMV.kB(0);
        }
    }
}
