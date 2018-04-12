package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private e giN;
    private MsgRemindModel giO;
    private MsgRemindModel.a giP = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void c(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.giN.bmn().jN();
                        MsgReceiveActivity.this.giN.lQ(false);
                        MsgReceiveActivity.this.giN.lP(false);
                        return;
                    }
                    MsgReceiveActivity.this.giN.bmn().jM();
                    MsgReceiveActivity.this.giN.lQ(true);
                    MsgReceiveActivity.this.giN.lP(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.giN.bmo().jN();
                    } else {
                        MsgReceiveActivity.this.giN.bmo().jM();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bj(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.giN.bmp().jN();
                } else {
                    MsgReceiveActivity.this.giN.bmp().jM();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.giN = new e(this);
        this.giN.init();
        this.giO = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.giN.aFr()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (view2 == this.giN.bmn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giO.a(8, true, this.giP);
                this.giN.lQ(true);
                this.giN.lP(true);
                return;
            }
            this.giO.a(8, false, this.giP);
            this.giN.lQ(false);
            this.giN.lP(false);
        } else if (view2 == this.giN.bmo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giO.a(9, true, this.giP);
            } else {
                this.giO.a(9, false, this.giP);
            }
        } else if (view2 == this.giN.bmp()) {
            this.giO.a(7, switchState == BdSwitchView.SwitchState.OFF, this.giP);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.giN.onChangeSkinType(i);
    }
}
