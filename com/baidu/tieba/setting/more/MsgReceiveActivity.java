package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private e gNs;
    private MsgRemindModel gNt;
    private MsgRemindModel.a gNu = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gNs.brd().rI();
                        MsgReceiveActivity.this.gNs.mk(false);
                        MsgReceiveActivity.this.gNs.mj(false);
                        return;
                    }
                    MsgReceiveActivity.this.gNs.brd().rH();
                    MsgReceiveActivity.this.gNs.mk(true);
                    MsgReceiveActivity.this.gNs.mj(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gNs.bre().rI();
                    } else {
                        MsgReceiveActivity.this.gNs.bre().rH();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bR(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gNs.brf().rI();
                } else {
                    MsgReceiveActivity.this.gNs.brf().rH();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gNs = new e(this);
        this.gNs.init();
        this.gNt = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gNs.aKt()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gNs.brd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNt.a(8, true, this.gNu);
                this.gNs.mk(true);
                this.gNs.mj(true);
                return;
            }
            this.gNt.a(8, false, this.gNu);
            this.gNs.mk(false);
            this.gNs.mj(false);
        } else if (view == this.gNs.bre()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNt.a(9, true, this.gNu);
            } else {
                this.gNt.a(9, false, this.gNu);
            }
        } else if (view == this.gNs.brf()) {
            this.gNt.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gNu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gNs.onChangeSkinType(i);
    }
}
