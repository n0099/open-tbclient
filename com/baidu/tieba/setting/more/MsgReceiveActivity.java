package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private e gHC;
    private MsgRemindModel gHD;
    private OfficialAccountPushModel gHE;
    private MsgRemindModel.a gHF = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gHC.bsT().nJ();
                        MsgReceiveActivity.this.gHC.mr(false);
                        MsgReceiveActivity.this.gHC.mq(false);
                        return;
                    }
                    MsgReceiveActivity.this.gHC.bsT().nI();
                    MsgReceiveActivity.this.gHC.mr(true);
                    MsgReceiveActivity.this.gHC.mq(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gHC.bsU().nJ();
                    } else {
                        MsgReceiveActivity.this.gHC.bsU().nI();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bB(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gHC.bsV().nJ();
                } else {
                    MsgReceiveActivity.this.gHC.bsV().nI();
                }
            }
        }
    };
    private OfficialAccountPushModel.a gHG = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.gHC != null) {
                MsgReceiveActivity.this.gHC.av(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gHC = new e(this);
        this.gHC.init();
        this.gHD = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gHC.aOd()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gHC.bsT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gHD.a(8, true, this.gHF);
                this.gHC.mr(true);
                this.gHC.mq(true);
                return;
            }
            this.gHD.a(8, false, this.gHF);
            this.gHC.mr(false);
            this.gHC.mq(false);
        } else if (view == this.gHC.bsU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gHD.a(9, true, this.gHF);
            } else {
                this.gHD.a(9, false, this.gHF);
            }
        } else if (view == this.gHC.bsV()) {
            this.gHD.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gHF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gHC.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gHE == null) {
            this.gHE = new OfficialAccountPushModel(this.gHG);
        }
        this.gHE.btU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gHE != null) {
            this.gHE.onDestroy();
        }
    }
}
