package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends BaseActivity implements BdSwitchView.a {
    private l dJY = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dJY = new l(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dJY.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dJY.aGO()) {
            this.dJY.aGT();
            TiebaStatic.log("c10650");
            return;
        }
        if (view == this.dJY.aGN()) {
            this.dJY.aGS();
            TiebaStatic.log("c10649");
        }
        if (view == this.dJY.aGP()) {
            this.dJY.aGU();
            TiebaStatic.log("c10653");
        } else if (view == this.dJY.aGQ()) {
            this.dJY.aGV();
        } else if (view == this.dJY.aGR()) {
            this.dJY.aGW();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.dJY.nL(1);
        } else {
            this.dJY.nL(0);
        }
    }
}
