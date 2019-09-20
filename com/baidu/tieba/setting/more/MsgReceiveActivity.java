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
    private f iVE;
    private MsgRemindModel iVF;
    private OfficialAccountPushModel iVG;
    private MsgRemindModel.a iVH = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void f(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iVE.clK().nl();
                        MsgReceiveActivity.this.iVE.qI(false);
                        MsgReceiveActivity.this.iVE.qH(false);
                        return;
                    }
                    MsgReceiveActivity.this.iVE.clK().nk();
                    MsgReceiveActivity.this.iVE.qI(true);
                    MsgReceiveActivity.this.iVE.qH(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iVE.clL().nl();
                    } else {
                        MsgReceiveActivity.this.iVE.clL().nk();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eQ(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.iVE.clM().nl();
                } else {
                    MsgReceiveActivity.this.iVE.clM().nk();
                }
            }
        }
    };
    private OfficialAccountPushModel.a iVI = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.iVE != null) {
                MsgReceiveActivity.this.iVE.aC(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iVE = new f(this);
        this.iVE.init();
        this.iVF = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iVE.bFU()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iVE.clK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVF.a(8, true, this.iVH);
                this.iVE.qI(true);
                this.iVE.qH(true);
                return;
            }
            this.iVF.a(8, false, this.iVH);
            this.iVE.qI(false);
            this.iVE.qH(false);
        } else if (view == this.iVE.clL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVF.a(9, true, this.iVH);
            } else {
                this.iVF.a(9, false, this.iVH);
            }
        } else if (view == this.iVE.clM()) {
            this.iVF.a(7, switchState == BdSwitchView.SwitchState.OFF, this.iVH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iVE.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iVG == null) {
            this.iVG = new OfficialAccountPushModel(this.iVI);
        }
        this.iVG.aWt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iVG != null) {
            this.iVG.onDestroy();
        }
    }
}
