package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class BrowseSettingActivity extends BaseActivity implements BdSwitchView.a {
    private b gMD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gMD = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gMD.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gMD.bqk()) {
            this.gMD.bqp();
            TiebaStatic.log("c10649");
        }
        if (view == this.gMD.bql()) {
            this.gMD.bqq();
            TiebaStatic.log("c10653");
        } else if (view == this.gMD.bqm()) {
            this.gMD.bqr();
        } else if (view == this.gMD.bqn()) {
            this.gMD.bqs();
        } else if (view == this.gMD.bqo()) {
            this.gMD.bqt();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.gMD.uS(1);
        } else {
            this.gMD.uS(0);
        }
    }
}
