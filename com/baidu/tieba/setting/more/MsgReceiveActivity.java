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
    private f iLN;
    private MsgRemindModel iLO;
    private OfficialAccountPushModel iLP;
    private MsgRemindModel.a iLQ = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void e(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iLN.chP().mU();
                        MsgReceiveActivity.this.iLN.qp(false);
                        MsgReceiveActivity.this.iLN.qo(false);
                        return;
                    }
                    MsgReceiveActivity.this.iLN.chP().mT();
                    MsgReceiveActivity.this.iLN.qp(true);
                    MsgReceiveActivity.this.iLN.qo(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iLN.chQ().mU();
                    } else {
                        MsgReceiveActivity.this.iLN.chQ().mT();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.anf().eJ(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.iLN.chR().mU();
                } else {
                    MsgReceiveActivity.this.iLN.chR().mT();
                }
            }
        }
    };
    private OfficialAccountPushModel.a iLR = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.iLN != null) {
                MsgReceiveActivity.this.iLN.aC(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iLN = new f(this);
        this.iLN.init();
        this.iLO = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iLN.bCl()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iLN.chP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iLO.a(8, true, this.iLQ);
                this.iLN.qp(true);
                this.iLN.qo(true);
                return;
            }
            this.iLO.a(8, false, this.iLQ);
            this.iLN.qp(false);
            this.iLN.qo(false);
        } else if (view == this.iLN.chQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iLO.a(9, true, this.iLQ);
            } else {
                this.iLO.a(9, false, this.iLQ);
            }
        } else if (view == this.iLN.chR()) {
            this.iLO.a(7, switchState == BdSwitchView.SwitchState.OFF, this.iLQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iLN.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iLP == null) {
            this.iLP = new OfficialAccountPushModel(this.iLR);
        }
        this.iLP.ciQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iLP != null) {
            this.iLP.onDestroy();
        }
    }
}
