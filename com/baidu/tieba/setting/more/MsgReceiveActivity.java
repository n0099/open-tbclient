package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private e gjQ;
    private MsgRemindModel gjR;
    private MsgRemindModel.a gjS = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void c(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gjQ.bmm().jN();
                        MsgReceiveActivity.this.gjQ.lR(false);
                        MsgReceiveActivity.this.gjQ.lQ(false);
                        return;
                    }
                    MsgReceiveActivity.this.gjQ.bmm().jM();
                    MsgReceiveActivity.this.gjQ.lR(true);
                    MsgReceiveActivity.this.gjQ.lQ(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gjQ.bmn().jN();
                    } else {
                        MsgReceiveActivity.this.gjQ.bmn().jM();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ad().bj(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gjQ.bmo().jN();
                } else {
                    MsgReceiveActivity.this.gjQ.bmo().jM();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gjQ = new e(this);
        this.gjQ.init();
        this.gjR = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.gjQ.aFp()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (view2 == this.gjQ.bmm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gjR.a(8, true, this.gjS);
                this.gjQ.lR(true);
                this.gjQ.lQ(true);
                return;
            }
            this.gjR.a(8, false, this.gjS);
            this.gjQ.lR(false);
            this.gjQ.lQ(false);
        } else if (view2 == this.gjQ.bmn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gjR.a(9, true, this.gjS);
            } else {
                this.gjR.a(9, false, this.gjS);
            }
        } else if (view2 == this.gjQ.bmo()) {
            this.gjR.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gjS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gjQ.onChangeSkinType(i);
    }
}
