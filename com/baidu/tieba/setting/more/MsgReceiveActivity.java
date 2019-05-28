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
    private f iLJ;
    private MsgRemindModel iLK;
    private OfficialAccountPushModel iLL;
    private MsgRemindModel.a iLM = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void e(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iLJ.chO().mU();
                        MsgReceiveActivity.this.iLJ.qo(false);
                        MsgReceiveActivity.this.iLJ.qn(false);
                        return;
                    }
                    MsgReceiveActivity.this.iLJ.chO().mT();
                    MsgReceiveActivity.this.iLJ.qo(true);
                    MsgReceiveActivity.this.iLJ.qn(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iLJ.chP().mU();
                    } else {
                        MsgReceiveActivity.this.iLJ.chP().mT();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.anf().eJ(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.iLJ.chQ().mU();
                } else {
                    MsgReceiveActivity.this.iLJ.chQ().mT();
                }
            }
        }
    };
    private OfficialAccountPushModel.a iLN = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.iLJ != null) {
                MsgReceiveActivity.this.iLJ.aC(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iLJ = new f(this);
        this.iLJ.init();
        this.iLK = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iLJ.bCk()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iLJ.chO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iLK.a(8, true, this.iLM);
                this.iLJ.qo(true);
                this.iLJ.qn(true);
                return;
            }
            this.iLK.a(8, false, this.iLM);
            this.iLJ.qo(false);
            this.iLJ.qn(false);
        } else if (view == this.iLJ.chP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iLK.a(9, true, this.iLM);
            } else {
                this.iLK.a(9, false, this.iLM);
            }
        } else if (view == this.iLJ.chQ()) {
            this.iLK.a(7, switchState == BdSwitchView.SwitchState.OFF, this.iLM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iLJ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iLL == null) {
            this.iLL = new OfficialAccountPushModel(this.iLN);
        }
        this.iLL.ciP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iLL != null) {
            this.iLL.onDestroy();
        }
    }
}
