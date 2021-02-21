package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private MsgRemindModel nhA;
    private OfficialAccountPushModel nhB;
    private MsgRemindModel.a nhC = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.nhz.dHG().turnOffNoCallback();
                        MsgReceiveActivity.this.nhz.xQ(false);
                        MsgReceiveActivity.this.nhz.xP(false);
                        return;
                    }
                    MsgReceiveActivity.this.nhz.dHG().turnOnNoCallback();
                    MsgReceiveActivity.this.nhz.xQ(true);
                    MsgReceiveActivity.this.nhz.xP(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.nhz.dHH().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.nhz.dHH().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().kw(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.nhz.dHI().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.nhz.dHI().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a nhD = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.nhz != null) {
                MsgReceiveActivity.this.nhz.bc(arrayList);
            }
        }
    };
    private f nhz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nhz = new f(this);
        this.nhz.init();
        this.nhA = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.nhz.cWF()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.nhz.dHG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nhA.a(8, true, this.nhC);
                this.nhz.xQ(true);
                this.nhz.xP(true);
                return;
            }
            this.nhA.a(8, false, this.nhC);
            this.nhz.xQ(false);
            this.nhz.xP(false);
        } else if (view == this.nhz.dHH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nhA.a(9, true, this.nhC);
            } else {
                this.nhA.a(9, false, this.nhC);
            }
        } else if (view == this.nhz.dHI()) {
            this.nhA.a(7, switchState == BdSwitchView.SwitchState.OFF, this.nhC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.nhz.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nhB == null) {
            this.nhB = new OfficialAccountPushModel(this.nhD);
        }
        this.nhB.dIX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nhB != null) {
            this.nhB.onDestroy();
        }
    }
}
