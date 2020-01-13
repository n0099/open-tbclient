package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private f jSA;
    private MsgRemindModel jSB;
    private OfficialAccountPushModel jSC;
    private MsgRemindModel.a jSD = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.jSA.cEE().turnOffNoCallback();
                        MsgReceiveActivity.this.jSA.sm(false);
                        MsgReceiveActivity.this.jSA.sl(false);
                        return;
                    }
                    MsgReceiveActivity.this.jSA.cEE().turnOnNoCallback();
                    MsgReceiveActivity.this.jSA.sm(true);
                    MsgReceiveActivity.this.jSA.sl(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.jSA.cEF().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.jSA.cEF().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().gd(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.jSA.cEG().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.jSA.cEG().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a jSE = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.jSA != null) {
                MsgReceiveActivity.this.jSA.aQ(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jSA = new f(this);
        this.jSA.init();
        this.jSB = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jSA.bUZ()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jSA.cEE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSB.a(8, true, this.jSD);
                this.jSA.sm(true);
                this.jSA.sl(true);
                return;
            }
            this.jSB.a(8, false, this.jSD);
            this.jSA.sm(false);
            this.jSA.sl(false);
        } else if (view == this.jSA.cEF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSB.a(9, true, this.jSD);
            } else {
                this.jSB.a(9, false, this.jSD);
            }
        } else if (view == this.jSA.cEG()) {
            this.jSB.a(7, switchState == BdSwitchView.SwitchState.OFF, this.jSD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jSA.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jSC == null) {
            this.jSC = new OfficialAccountPushModel(this.jSE);
        }
        this.jSC.cFH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jSC != null) {
            this.jSC.onDestroy();
        }
    }
}
