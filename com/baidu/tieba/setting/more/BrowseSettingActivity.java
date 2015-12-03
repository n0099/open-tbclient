package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends BaseActivity implements BdSwitchView.a {
    private l dmI = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dmI = new l(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dmI.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dmI.axB()) {
            this.dmI.axG();
            TiebaStatic.log("c10650");
            return;
        }
        if (view == this.dmI.axA()) {
            this.dmI.axF();
            TiebaStatic.log("c10649");
        }
        if (view == this.dmI.axC()) {
            this.dmI.axH();
            TiebaStatic.log("c10653");
        } else if (view == this.dmI.axD()) {
            this.dmI.axI();
        } else if (view == this.dmI.axE()) {
            this.dmI.axJ();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.dmI.lX(1);
        } else {
            this.dmI.lX(0);
        }
    }
}
