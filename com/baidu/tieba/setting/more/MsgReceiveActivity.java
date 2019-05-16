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
    private f iLH;
    private MsgRemindModel iLI;
    private OfficialAccountPushModel iLJ;
    private MsgRemindModel.a iLK = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void e(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iLH.chM().mU();
                        MsgReceiveActivity.this.iLH.qo(false);
                        MsgReceiveActivity.this.iLH.qn(false);
                        return;
                    }
                    MsgReceiveActivity.this.iLH.chM().mT();
                    MsgReceiveActivity.this.iLH.qo(true);
                    MsgReceiveActivity.this.iLH.qn(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iLH.chN().mU();
                    } else {
                        MsgReceiveActivity.this.iLH.chN().mT();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.anf().eJ(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.iLH.chO().mU();
                } else {
                    MsgReceiveActivity.this.iLH.chO().mT();
                }
            }
        }
    };
    private OfficialAccountPushModel.a iLL = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.iLH != null) {
                MsgReceiveActivity.this.iLH.aC(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iLH = new f(this);
        this.iLH.init();
        this.iLI = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iLH.bCh()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iLH.chM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iLI.a(8, true, this.iLK);
                this.iLH.qo(true);
                this.iLH.qn(true);
                return;
            }
            this.iLI.a(8, false, this.iLK);
            this.iLH.qo(false);
            this.iLH.qn(false);
        } else if (view == this.iLH.chN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iLI.a(9, true, this.iLK);
            } else {
                this.iLI.a(9, false, this.iLK);
            }
        } else if (view == this.iLH.chO()) {
            this.iLI.a(7, switchState == BdSwitchView.SwitchState.OFF, this.iLK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iLH.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iLJ == null) {
            this.iLJ = new OfficialAccountPushModel(this.iLL);
        }
        this.iLJ.ciN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iLJ != null) {
            this.iLJ.onDestroy();
        }
    }
}
