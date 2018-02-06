package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private e gNH;
    private MsgRemindModel gNI;
    private MsgRemindModel.a gNJ = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gNH.bre().rI();
                        MsgReceiveActivity.this.gNH.mk(false);
                        MsgReceiveActivity.this.gNH.mj(false);
                        return;
                    }
                    MsgReceiveActivity.this.gNH.bre().rH();
                    MsgReceiveActivity.this.gNH.mk(true);
                    MsgReceiveActivity.this.gNH.mj(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gNH.brf().rI();
                    } else {
                        MsgReceiveActivity.this.gNH.brf().rH();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bR(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gNH.brg().rI();
                } else {
                    MsgReceiveActivity.this.gNH.brg().rH();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gNH = new e(this);
        this.gNH.init();
        this.gNI = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gNH.aKu()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gNH.bre()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNI.a(8, true, this.gNJ);
                this.gNH.mk(true);
                this.gNH.mj(true);
                return;
            }
            this.gNI.a(8, false, this.gNJ);
            this.gNH.mk(false);
            this.gNH.mj(false);
        } else if (view == this.gNH.brf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNI.a(9, true, this.gNJ);
            } else {
                this.gNI.a(9, false, this.gNJ);
            }
        } else if (view == this.gNH.brg()) {
            this.gNI.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gNJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gNH.onChangeSkinType(i);
    }
}
