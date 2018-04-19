package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class BrowseSettingActivity extends BaseActivity implements BdSwitchView.a {
    private b ghH = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ghH = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ghH.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.ghH.blt()) {
            this.ghH.bly();
            TiebaStatic.log("c10649");
        }
        if (view2 == this.ghH.blu()) {
            this.ghH.blz();
            TiebaStatic.log("c10653");
        } else if (view2 == this.ghH.blv()) {
            this.ghH.blA();
        } else if (view2 == this.ghH.blw()) {
            this.ghH.blB();
        } else if (view2 == this.ghH.blx()) {
            this.ghH.blC();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.ghH.su(1);
        } else {
            this.ghH.su(0);
        }
    }
}
