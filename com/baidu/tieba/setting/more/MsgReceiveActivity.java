package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private f mWB;
    private MsgRemindModel mWC;
    private OfficialAccountPushModel mWD;
    private MsgRemindModel.a mWE = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mWB.dJp().turnOffNoCallback();
                        MsgReceiveActivity.this.mWB.xA(false);
                        MsgReceiveActivity.this.mWB.xz(false);
                        return;
                    }
                    MsgReceiveActivity.this.mWB.dJp().turnOnNoCallback();
                    MsgReceiveActivity.this.mWB.xA(true);
                    MsgReceiveActivity.this.mWB.xz(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mWB.dJq().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.mWB.dJq().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().kb(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.mWB.dJr().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.mWB.dJr().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a mWF = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.mWB != null) {
                MsgReceiveActivity.this.mWB.bi(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mWB = new f(this);
        this.mWB.init();
        this.mWC = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mWB.cYx()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mWB.dJp()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWC.a(8, true, this.mWE);
                this.mWB.xA(true);
                this.mWB.xz(true);
                return;
            }
            this.mWC.a(8, false, this.mWE);
            this.mWB.xA(false);
            this.mWB.xz(false);
        } else if (view == this.mWB.dJq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWC.a(9, true, this.mWE);
            } else {
                this.mWC.a(9, false, this.mWE);
            }
        } else if (view == this.mWB.dJr()) {
            this.mWC.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mWE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mWB.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mWD == null) {
            this.mWD = new OfficialAccountPushModel(this.mWF);
        }
        this.mWD.dKG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mWD != null) {
            this.mWD.onDestroy();
        }
    }
}
