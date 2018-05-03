package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private e giK;
    private MsgRemindModel giL;
    private MsgRemindModel.a giM = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void c(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.giK.bmn().jN();
                        MsgReceiveActivity.this.giK.lQ(false);
                        MsgReceiveActivity.this.giK.lP(false);
                        return;
                    }
                    MsgReceiveActivity.this.giK.bmn().jM();
                    MsgReceiveActivity.this.giK.lQ(true);
                    MsgReceiveActivity.this.giK.lP(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.giK.bmo().jN();
                    } else {
                        MsgReceiveActivity.this.giK.bmo().jM();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bj(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.giK.bmp().jN();
                } else {
                    MsgReceiveActivity.this.giK.bmp().jM();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.giK = new e(this);
        this.giK.init();
        this.giL = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.giK.aFr()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (view2 == this.giK.bmn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giL.a(8, true, this.giM);
                this.giK.lQ(true);
                this.giK.lP(true);
                return;
            }
            this.giL.a(8, false, this.giM);
            this.giK.lQ(false);
            this.giK.lP(false);
        } else if (view2 == this.giK.bmo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giL.a(9, true, this.giM);
            } else {
                this.giL.a(9, false, this.giM);
            }
        } else if (view2 == this.giK.bmp()) {
            this.giL.a(7, switchState == BdSwitchView.SwitchState.OFF, this.giM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.giK.onChangeSkinType(i);
    }
}
