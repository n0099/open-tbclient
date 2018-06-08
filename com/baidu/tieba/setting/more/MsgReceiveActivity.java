package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private e gvo;
    private MsgRemindModel gvp;
    private MsgRemindModel.a gvq = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void c(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gvo.brl().mB();
                        MsgReceiveActivity.this.gvo.lX(false);
                        MsgReceiveActivity.this.gvo.lW(false);
                        return;
                    }
                    MsgReceiveActivity.this.gvo.brl().mA();
                    MsgReceiveActivity.this.gvo.lX(true);
                    MsgReceiveActivity.this.gvo.lW(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gvo.brm().mB();
                    } else {
                        MsgReceiveActivity.this.gvo.brm().mA();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DE().bn(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gvo.brn().mB();
                } else {
                    MsgReceiveActivity.this.gvo.brn().mA();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gvo = new e(this);
        this.gvo.init();
        this.gvp = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gvo.aKk()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gvo.brl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gvp.a(8, true, this.gvq);
                this.gvo.lX(true);
                this.gvo.lW(true);
                return;
            }
            this.gvp.a(8, false, this.gvq);
            this.gvo.lX(false);
            this.gvo.lW(false);
        } else if (view == this.gvo.brm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gvp.a(9, true, this.gvq);
            } else {
                this.gvp.a(9, false, this.gvq);
            }
        } else if (view == this.gvo.brn()) {
            this.gvp.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gvq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gvo.onChangeSkinType(i);
    }
}
