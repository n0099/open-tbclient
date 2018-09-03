package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private e gAr;
    private MsgRemindModel gAs;
    private MsgRemindModel.a gAt = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gAr.bqq().mD();
                        MsgReceiveActivity.this.gAr.lT(false);
                        MsgReceiveActivity.this.gAr.lS(false);
                        return;
                    }
                    MsgReceiveActivity.this.gAr.bqq().mC();
                    MsgReceiveActivity.this.gAr.lT(true);
                    MsgReceiveActivity.this.gAr.lS(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gAr.bqr().mD();
                    } else {
                        MsgReceiveActivity.this.gAr.bqr().mC();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().bp(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gAr.bqs().mD();
                } else {
                    MsgReceiveActivity.this.gAr.bqs().mC();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gAr = new e(this);
        this.gAr.init();
        this.gAs = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gAr.aLO()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gAr.bqq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAs.a(8, true, this.gAt);
                this.gAr.lT(true);
                this.gAr.lS(true);
                return;
            }
            this.gAs.a(8, false, this.gAt);
            this.gAr.lT(false);
            this.gAr.lS(false);
        } else if (view == this.gAr.bqr()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAs.a(9, true, this.gAt);
            } else {
                this.gAs.a(9, false, this.gAt);
            }
        } else if (view == this.gAr.bqs()) {
            this.gAs.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gAr.onChangeSkinType(i);
    }
}
