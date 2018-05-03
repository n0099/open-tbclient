package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class BrowseSettingActivity extends BaseActivity implements BdSwitchView.a {
    private b ghE = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ghE = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ghE.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.ghE.blt()) {
            this.ghE.bly();
            TiebaStatic.log("c10649");
        }
        if (view2 == this.ghE.blu()) {
            this.ghE.blz();
            TiebaStatic.log("c10653");
        } else if (view2 == this.ghE.blv()) {
            this.ghE.blA();
        } else if (view2 == this.ghE.blw()) {
            this.ghE.blB();
        } else if (view2 == this.ghE.blx()) {
            this.ghE.blC();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.ghE.su(1);
        } else {
            this.ghE.su(0);
        }
    }
}
