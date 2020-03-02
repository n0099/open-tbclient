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
    private f jTC;
    private MsgRemindModel jTD;
    private OfficialAccountPushModel jTE;
    private MsgRemindModel.a jTF = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.jTC.cGj().turnOffNoCallback();
                        MsgReceiveActivity.this.jTC.sp(false);
                        MsgReceiveActivity.this.jTC.so(false);
                        return;
                    }
                    MsgReceiveActivity.this.jTC.cGj().turnOnNoCallback();
                    MsgReceiveActivity.this.jTC.sp(true);
                    MsgReceiveActivity.this.jTC.so(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.jTC.cGk().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.jTC.cGk().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLl().gk(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.jTC.cGl().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.jTC.cGl().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a jTG = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.jTC != null) {
                MsgReceiveActivity.this.jTC.aP(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jTC = new f(this);
        this.jTC.init();
        this.jTD = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jTC.bWC()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jTC.cGj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTD.a(8, true, this.jTF);
                this.jTC.sp(true);
                this.jTC.so(true);
                return;
            }
            this.jTD.a(8, false, this.jTF);
            this.jTC.sp(false);
            this.jTC.so(false);
        } else if (view == this.jTC.cGk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTD.a(9, true, this.jTF);
            } else {
                this.jTD.a(9, false, this.jTF);
            }
        } else if (view == this.jTC.cGl()) {
            this.jTD.a(7, switchState == BdSwitchView.SwitchState.OFF, this.jTF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jTC.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jTE == null) {
            this.jTE = new OfficialAccountPushModel(this.jTG);
        }
        this.jTE.cHm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jTE != null) {
            this.jTE.onDestroy();
        }
    }
}
