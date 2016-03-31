package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends BaseActivity implements BdSwitchView.a {
    private l ecs = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ecs = new l(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ecs.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ecs.aNy()) {
            this.ecs.aND();
            TiebaStatic.log("c10650");
            return;
        }
        if (view == this.ecs.aNx()) {
            this.ecs.aNC();
            TiebaStatic.log("c10649");
        }
        if (view == this.ecs.aNz()) {
            this.ecs.aNE();
            TiebaStatic.log("c10653");
        } else if (view == this.ecs.aNA()) {
            this.ecs.aNF();
        } else if (view == this.ecs.aNB()) {
            this.ecs.aNG();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.ecs.oQ(1);
        } else {
            this.ecs.oQ(0);
        }
    }
}
