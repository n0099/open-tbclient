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
    private f itp;
    private MsgRemindModel itq;
    private OfficialAccountPushModel itr;
    private MsgRemindModel.a its = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void e(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.itp.bZK().nZ();
                        MsgReceiveActivity.this.itp.pz(false);
                        MsgReceiveActivity.this.itp.py(false);
                        return;
                    }
                    MsgReceiveActivity.this.itp.bZK().nY();
                    MsgReceiveActivity.this.itp.pz(true);
                    MsgReceiveActivity.this.itp.py(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.itp.bZL().nZ();
                    } else {
                        MsgReceiveActivity.this.itp.bZL().nY();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().em(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.itp.bZM().nZ();
                } else {
                    MsgReceiveActivity.this.itp.bZM().nY();
                }
            }
        }
    };
    private OfficialAccountPushModel.a itt = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.itp != null) {
                MsgReceiveActivity.this.itp.ay(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.itp = new f(this);
        this.itp.init();
        this.itq = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.itp.buz()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.itp.bZK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itq.a(8, true, this.its);
                this.itp.pz(true);
                this.itp.py(true);
                return;
            }
            this.itq.a(8, false, this.its);
            this.itp.pz(false);
            this.itp.py(false);
        } else if (view == this.itp.bZL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itq.a(9, true, this.its);
            } else {
                this.itq.a(9, false, this.its);
            }
        } else if (view == this.itp.bZM()) {
            this.itq.a(7, switchState == BdSwitchView.SwitchState.OFF, this.its);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.itp.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.itr == null) {
            this.itr = new OfficialAccountPushModel(this.itt);
        }
        this.itr.caL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.itr != null) {
            this.itr.onDestroy();
        }
    }
}
