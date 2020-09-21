package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes25.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private f lZM;
    private MsgRemindModel lZN;
    private OfficialAccountPushModel lZO;
    private MsgRemindModel.a lZP = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.lZM.dvd().turnOffNoCallback();
                        MsgReceiveActivity.this.lZM.vM(false);
                        MsgReceiveActivity.this.lZM.vL(false);
                        return;
                    }
                    MsgReceiveActivity.this.lZM.dvd().turnOnNoCallback();
                    MsgReceiveActivity.this.lZM.vM(true);
                    MsgReceiveActivity.this.lZM.vL(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.lZM.dve().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.lZM.dve().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bps().iQ(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.lZM.dvf().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.lZM.dvf().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a lZQ = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.lZM != null) {
                MsgReceiveActivity.this.lZM.bc(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lZM = new f(this);
        this.lZM.init();
        this.lZN = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lZM.cKn()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.lZM.dvd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lZN.a(8, true, this.lZP);
                this.lZM.vM(true);
                this.lZM.vL(true);
                return;
            }
            this.lZN.a(8, false, this.lZP);
            this.lZM.vM(false);
            this.lZM.vL(false);
        } else if (view == this.lZM.dve()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lZN.a(9, true, this.lZP);
            } else {
                this.lZN.a(9, false, this.lZP);
            }
        } else if (view == this.lZM.dvf()) {
            this.lZN.a(7, switchState == BdSwitchView.SwitchState.OFF, this.lZP);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lZM.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lZO == null) {
            this.lZO = new OfficialAccountPushModel(this.lZQ);
        }
        this.lZO.dwk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lZO != null) {
            this.lZO.onDestroy();
        }
    }
}
