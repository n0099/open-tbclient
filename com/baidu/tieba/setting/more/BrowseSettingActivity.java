package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class BrowseSettingActivity extends BaseActivity implements BdSwitchView.a {
    private b gMC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gMC = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gMC.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gMC.bqk()) {
            this.gMC.bqp();
            TiebaStatic.log("c10649");
        }
        if (view == this.gMC.bql()) {
            this.gMC.bqq();
            TiebaStatic.log("c10653");
        } else if (view == this.gMC.bqm()) {
            this.gMC.bqr();
        } else if (view == this.gMC.bqn()) {
            this.gMC.bqs();
        } else if (view == this.gMC.bqo()) {
            this.gMC.bqt();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.gMC.uR(1);
        } else {
            this.gMC.uR(0);
        }
    }
}
