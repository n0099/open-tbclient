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
    private MsgRemindModel mWA;
    private OfficialAccountPushModel mWB;
    private MsgRemindModel.a mWC = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mWz.dJo().turnOffNoCallback();
                        MsgReceiveActivity.this.mWz.xA(false);
                        MsgReceiveActivity.this.mWz.xz(false);
                        return;
                    }
                    MsgReceiveActivity.this.mWz.dJo().turnOnNoCallback();
                    MsgReceiveActivity.this.mWz.xA(true);
                    MsgReceiveActivity.this.mWz.xz(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mWz.dJp().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.mWz.dJp().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().kb(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.mWz.dJq().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.mWz.dJq().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a mWD = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.mWz != null) {
                MsgReceiveActivity.this.mWz.bi(arrayList);
            }
        }
    };
    private f mWz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mWz = new f(this);
        this.mWz.init();
        this.mWA = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mWz.cYw()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mWz.dJo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWA.a(8, true, this.mWC);
                this.mWz.xA(true);
                this.mWz.xz(true);
                return;
            }
            this.mWA.a(8, false, this.mWC);
            this.mWz.xA(false);
            this.mWz.xz(false);
        } else if (view == this.mWz.dJp()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWA.a(9, true, this.mWC);
            } else {
                this.mWA.a(9, false, this.mWC);
            }
        } else if (view == this.mWz.dJq()) {
            this.mWA.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mWC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mWz.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mWB == null) {
            this.mWB = new OfficialAccountPushModel(this.mWD);
        }
        this.mWB.dKF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mWB != null) {
            this.mWB.onDestroy();
        }
    }
}
