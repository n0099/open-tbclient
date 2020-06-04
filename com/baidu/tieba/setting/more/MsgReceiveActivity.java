package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private f kXN;
    private MsgRemindModel kXO;
    private OfficialAccountPushModel kXP;
    private MsgRemindModel.a kXQ = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.kXN.cYt().turnOffNoCallback();
                        MsgReceiveActivity.this.kXN.tU(false);
                        MsgReceiveActivity.this.kXN.tT(false);
                        return;
                    }
                    MsgReceiveActivity.this.kXN.cYt().turnOnNoCallback();
                    MsgReceiveActivity.this.kXN.tU(true);
                    MsgReceiveActivity.this.kXN.tT(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.kXN.cYu().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.kXN.cYu().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hH(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.kXN.cYv().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.kXN.cYv().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a kXR = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.kXN != null) {
                MsgReceiveActivity.this.kXN.aS(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kXN = new f(this);
        this.kXN.init();
        this.kXO = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kXN.cob()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.kXN.cYt()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kXO.a(8, true, this.kXQ);
                this.kXN.tU(true);
                this.kXN.tT(true);
                return;
            }
            this.kXO.a(8, false, this.kXQ);
            this.kXN.tU(false);
            this.kXN.tT(false);
        } else if (view == this.kXN.cYu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kXO.a(9, true, this.kXQ);
            } else {
                this.kXO.a(9, false, this.kXQ);
            }
        } else if (view == this.kXN.cYv()) {
            this.kXO.a(7, switchState == BdSwitchView.SwitchState.OFF, this.kXQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kXN.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kXP == null) {
            this.kXP = new OfficialAccountPushModel(this.kXR);
        }
        this.kXP.cZw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kXP != null) {
            this.kXP.onDestroy();
        }
    }
}
