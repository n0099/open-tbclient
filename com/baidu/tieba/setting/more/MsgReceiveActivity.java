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
    private f jTA;
    private MsgRemindModel jTB;
    private OfficialAccountPushModel jTC;
    private MsgRemindModel.a jTD = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.jTA.cGh().turnOffNoCallback();
                        MsgReceiveActivity.this.jTA.sp(false);
                        MsgReceiveActivity.this.jTA.so(false);
                        return;
                    }
                    MsgReceiveActivity.this.jTA.cGh().turnOnNoCallback();
                    MsgReceiveActivity.this.jTA.sp(true);
                    MsgReceiveActivity.this.jTA.so(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.jTA.cGi().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.jTA.cGi().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLj().gk(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.jTA.cGj().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.jTA.cGj().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a jTE = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.jTA != null) {
                MsgReceiveActivity.this.jTA.aP(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jTA = new f(this);
        this.jTA.init();
        this.jTB = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jTA.bWA()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jTA.cGh()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTB.a(8, true, this.jTD);
                this.jTA.sp(true);
                this.jTA.so(true);
                return;
            }
            this.jTB.a(8, false, this.jTD);
            this.jTA.sp(false);
            this.jTA.so(false);
        } else if (view == this.jTA.cGi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTB.a(9, true, this.jTD);
            } else {
                this.jTB.a(9, false, this.jTD);
            }
        } else if (view == this.jTA.cGj()) {
            this.jTB.a(7, switchState == BdSwitchView.SwitchState.OFF, this.jTD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jTA.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jTC == null) {
            this.jTC = new OfficialAccountPushModel(this.jTE);
        }
        this.jTC.cHk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jTC != null) {
            this.jTC.onDestroy();
        }
    }
}
