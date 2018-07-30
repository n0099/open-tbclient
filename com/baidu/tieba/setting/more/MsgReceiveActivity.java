package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private e gAo;
    private MsgRemindModel gAp;
    private MsgRemindModel.a gAq = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gAo.bqp().mD();
                        MsgReceiveActivity.this.gAo.lT(false);
                        MsgReceiveActivity.this.gAo.lS(false);
                        return;
                    }
                    MsgReceiveActivity.this.gAo.bqp().mC();
                    MsgReceiveActivity.this.gAo.lT(true);
                    MsgReceiveActivity.this.gAo.lS(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gAo.bqq().mD();
                    } else {
                        MsgReceiveActivity.this.gAo.bqq().mC();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().bo(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gAo.bqr().mD();
                } else {
                    MsgReceiveActivity.this.gAo.bqr().mC();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gAo = new e(this);
        this.gAo.init();
        this.gAp = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gAo.aLR()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gAo.bqp()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAp.a(8, true, this.gAq);
                this.gAo.lT(true);
                this.gAo.lS(true);
                return;
            }
            this.gAp.a(8, false, this.gAq);
            this.gAo.lT(false);
            this.gAo.lS(false);
        } else if (view == this.gAo.bqq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAp.a(9, true, this.gAq);
            } else {
                this.gAp.a(9, false, this.gAq);
            }
        } else if (view == this.gAo.bqr()) {
            this.gAp.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gAq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gAo.onChangeSkinType(i);
    }
}
