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
    private f kEC;
    private MsgRemindModel kED;
    private OfficialAccountPushModel kEE;
    private MsgRemindModel.a kEF = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.kEC.cRa().turnOffNoCallback();
                        MsgReceiveActivity.this.kEC.tw(false);
                        MsgReceiveActivity.this.kEC.tv(false);
                        return;
                    }
                    MsgReceiveActivity.this.kEC.cRa().turnOnNoCallback();
                    MsgReceiveActivity.this.kEC.tw(true);
                    MsgReceiveActivity.this.kEC.tv(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.kEC.cRb().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.kEC.cRb().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTL().hj(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.kEC.cRc().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.kEC.cRc().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a kEG = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.kEC != null) {
                MsgReceiveActivity.this.kEC.aR(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kEC = new f(this);
        this.kEC.init();
        this.kED = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kEC.chv()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.kEC.cRa()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kED.a(8, true, this.kEF);
                this.kEC.tw(true);
                this.kEC.tv(true);
                return;
            }
            this.kED.a(8, false, this.kEF);
            this.kEC.tw(false);
            this.kEC.tv(false);
        } else if (view == this.kEC.cRb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kED.a(9, true, this.kEF);
            } else {
                this.kED.a(9, false, this.kEF);
            }
        } else if (view == this.kEC.cRc()) {
            this.kED.a(7, switchState == BdSwitchView.SwitchState.OFF, this.kEF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kEC.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kEE == null) {
            this.kEE = new OfficialAccountPushModel(this.kEG);
        }
        this.kEE.cSd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kEE != null) {
            this.kEE.onDestroy();
        }
    }
}
