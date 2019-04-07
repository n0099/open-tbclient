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
    private f isS;
    private MsgRemindModel isT;
    private OfficialAccountPushModel isU;
    private MsgRemindModel.a isV = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void e(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.isS.bZI().nZ();
                        MsgReceiveActivity.this.isS.pz(false);
                        MsgReceiveActivity.this.isS.py(false);
                        return;
                    }
                    MsgReceiveActivity.this.isS.bZI().nY();
                    MsgReceiveActivity.this.isS.pz(true);
                    MsgReceiveActivity.this.isS.py(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.isS.bZJ().nZ();
                    } else {
                        MsgReceiveActivity.this.isS.bZJ().nY();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().em(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.isS.bZK().nZ();
                } else {
                    MsgReceiveActivity.this.isS.bZK().nY();
                }
            }
        }
    };
    private OfficialAccountPushModel.a isW = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.isS != null) {
                MsgReceiveActivity.this.isS.ay(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isS = new f(this);
        this.isS.init();
        this.isT = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.isS.buv()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.isS.bZI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isT.a(8, true, this.isV);
                this.isS.pz(true);
                this.isS.py(true);
                return;
            }
            this.isT.a(8, false, this.isV);
            this.isS.pz(false);
            this.isS.py(false);
        } else if (view == this.isS.bZJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isT.a(9, true, this.isV);
            } else {
                this.isT.a(9, false, this.isV);
            }
        } else if (view == this.isS.bZK()) {
            this.isT.a(7, switchState == BdSwitchView.SwitchState.OFF, this.isV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.isS.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isU == null) {
            this.isU = new OfficialAccountPushModel(this.isW);
        }
        this.isU.caJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.isU != null) {
            this.isU.onDestroy();
        }
    }
}
