package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private e gNI;
    private MsgRemindModel gNJ;
    private MsgRemindModel.a gNK = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gNI.bre().rI();
                        MsgReceiveActivity.this.gNI.mp(false);
                        MsgReceiveActivity.this.gNI.mo(false);
                        return;
                    }
                    MsgReceiveActivity.this.gNI.bre().rH();
                    MsgReceiveActivity.this.gNI.mp(true);
                    MsgReceiveActivity.this.gNI.mo(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gNI.brf().rI();
                    } else {
                        MsgReceiveActivity.this.gNI.brf().rH();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bR(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gNI.brg().rI();
                } else {
                    MsgReceiveActivity.this.gNI.brg().rH();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gNI = new e(this);
        this.gNI.init();
        this.gNJ = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gNI.aKu()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gNI.bre()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNJ.a(8, true, this.gNK);
                this.gNI.mp(true);
                this.gNI.mo(true);
                return;
            }
            this.gNJ.a(8, false, this.gNK);
            this.gNI.mp(false);
            this.gNI.mo(false);
        } else if (view == this.gNI.brf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNJ.a(9, true, this.gNK);
            } else {
                this.gNJ.a(9, false, this.gNK);
            }
        } else if (view == this.gNI.brg()) {
            this.gNJ.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gNK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gNI.onChangeSkinType(i);
    }
}
