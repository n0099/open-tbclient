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
    private f jSF;
    private MsgRemindModel jSG;
    private OfficialAccountPushModel jSH;
    private MsgRemindModel.a jSI = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.jSF.cEG().turnOffNoCallback();
                        MsgReceiveActivity.this.jSF.sm(false);
                        MsgReceiveActivity.this.jSF.sl(false);
                        return;
                    }
                    MsgReceiveActivity.this.jSF.cEG().turnOnNoCallback();
                    MsgReceiveActivity.this.jSF.sm(true);
                    MsgReceiveActivity.this.jSF.sl(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.jSF.cEH().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.jSF.cEH().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().gd(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.jSF.cEI().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.jSF.cEI().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a jSJ = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.jSF != null) {
                MsgReceiveActivity.this.jSF.aQ(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jSF = new f(this);
        this.jSF.init();
        this.jSG = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jSF.bUZ()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jSF.cEG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSG.a(8, true, this.jSI);
                this.jSF.sm(true);
                this.jSF.sl(true);
                return;
            }
            this.jSG.a(8, false, this.jSI);
            this.jSF.sm(false);
            this.jSF.sl(false);
        } else if (view == this.jSF.cEH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSG.a(9, true, this.jSI);
            } else {
                this.jSG.a(9, false, this.jSI);
            }
        } else if (view == this.jSF.cEI()) {
            this.jSG.a(7, switchState == BdSwitchView.SwitchState.OFF, this.jSI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jSF.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jSH == null) {
            this.jSH = new OfficialAccountPushModel(this.jSJ);
        }
        this.jSH.cFJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jSH != null) {
            this.jSH.onDestroy();
        }
    }
}
