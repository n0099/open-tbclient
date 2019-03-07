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
    private f ito;
    private MsgRemindModel itp;
    private OfficialAccountPushModel itq;
    private MsgRemindModel.a itr = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void e(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.ito.bZJ().nZ();
                        MsgReceiveActivity.this.ito.pz(false);
                        MsgReceiveActivity.this.ito.py(false);
                        return;
                    }
                    MsgReceiveActivity.this.ito.bZJ().nY();
                    MsgReceiveActivity.this.ito.pz(true);
                    MsgReceiveActivity.this.ito.py(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.ito.bZK().nZ();
                    } else {
                        MsgReceiveActivity.this.ito.bZK().nY();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().em(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.ito.bZL().nZ();
                } else {
                    MsgReceiveActivity.this.ito.bZL().nY();
                }
            }
        }
    };
    private OfficialAccountPushModel.a its = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.ito != null) {
                MsgReceiveActivity.this.ito.ay(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ito = new f(this);
        this.ito.init();
        this.itp = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ito.buy()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.ito.bZJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itp.a(8, true, this.itr);
                this.ito.pz(true);
                this.ito.py(true);
                return;
            }
            this.itp.a(8, false, this.itr);
            this.ito.pz(false);
            this.ito.py(false);
        } else if (view == this.ito.bZK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itp.a(9, true, this.itr);
            } else {
                this.itp.a(9, false, this.itr);
            }
        } else if (view == this.ito.bZL()) {
            this.itp.a(7, switchState == BdSwitchView.SwitchState.OFF, this.itr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ito.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.itq == null) {
            this.itq = new OfficialAccountPushModel(this.its);
        }
        this.itq.caK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.itq != null) {
            this.itq.onDestroy();
        }
    }
}
