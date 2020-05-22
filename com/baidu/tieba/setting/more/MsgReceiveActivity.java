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
    private f kWE;
    private MsgRemindModel kWF;
    private OfficialAccountPushModel kWG;
    private MsgRemindModel.a kWH = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.kWE.cYd().turnOffNoCallback();
                        MsgReceiveActivity.this.kWE.tU(false);
                        MsgReceiveActivity.this.kWE.tT(false);
                        return;
                    }
                    MsgReceiveActivity.this.kWE.cYd().turnOnNoCallback();
                    MsgReceiveActivity.this.kWE.tU(true);
                    MsgReceiveActivity.this.kWE.tT(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.kWE.cYe().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.kWE.cYe().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hH(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.kWE.cYf().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.kWE.cYf().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a kWI = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.kWE != null) {
                MsgReceiveActivity.this.kWE.aS(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kWE = new f(this);
        this.kWE.init();
        this.kWF = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kWE.cnS()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.kWE.cYd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kWF.a(8, true, this.kWH);
                this.kWE.tU(true);
                this.kWE.tT(true);
                return;
            }
            this.kWF.a(8, false, this.kWH);
            this.kWE.tU(false);
            this.kWE.tT(false);
        } else if (view == this.kWE.cYe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kWF.a(9, true, this.kWH);
            } else {
                this.kWF.a(9, false, this.kWH);
            }
        } else if (view == this.kWE.cYf()) {
            this.kWF.a(7, switchState == BdSwitchView.SwitchState.OFF, this.kWH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kWE.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kWG == null) {
            this.kWG = new OfficialAccountPushModel(this.kWI);
        }
        this.kWG.cZg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kWG != null) {
            this.kWG.onDestroy();
        }
    }
}
