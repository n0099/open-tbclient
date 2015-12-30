package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends BaseActivity implements BdSwitchView.a {
    private l dtU = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dtU = new l(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dtU.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dtU.azH()) {
            this.dtU.azM();
            TiebaStatic.log("c10650");
            return;
        }
        if (view == this.dtU.azG()) {
            this.dtU.azL();
            TiebaStatic.log("c10649");
        }
        if (view == this.dtU.azI()) {
            this.dtU.azN();
            TiebaStatic.log("c10653");
        } else if (view == this.dtU.azJ()) {
            this.dtU.azO();
        } else if (view == this.dtU.azK()) {
            this.dtU.azP();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.dtU.mz(1);
        } else {
            this.dtU.mz(0);
        }
    }
}
