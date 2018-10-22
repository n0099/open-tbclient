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
    private e gOZ;
    private MsgRemindModel gPa;
    private OfficialAccountPushModel gPb;
    private MsgRemindModel.a gPc = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gOZ.bwi().nT();
                        MsgReceiveActivity.this.gOZ.mI(false);
                        MsgReceiveActivity.this.gOZ.mH(false);
                        return;
                    }
                    MsgReceiveActivity.this.gOZ.bwi().nS();
                    MsgReceiveActivity.this.gOZ.mI(true);
                    MsgReceiveActivity.this.gOZ.mH(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gOZ.bwj().nT();
                    } else {
                        MsgReceiveActivity.this.gOZ.bwj().nS();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bK(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gOZ.bwk().nT();
                } else {
                    MsgReceiveActivity.this.gOZ.bwk().nS();
                }
            }
        }
    };
    private OfficialAccountPushModel.a gPd = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.gOZ != null) {
                MsgReceiveActivity.this.gOZ.av(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gOZ = new e(this);
        this.gOZ.init();
        this.gPa = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gOZ.aRs()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gOZ.bwi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gPa.a(8, true, this.gPc);
                this.gOZ.mI(true);
                this.gOZ.mH(true);
                return;
            }
            this.gPa.a(8, false, this.gPc);
            this.gOZ.mI(false);
            this.gOZ.mH(false);
        } else if (view == this.gOZ.bwj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gPa.a(9, true, this.gPc);
            } else {
                this.gPa.a(9, false, this.gPc);
            }
        } else if (view == this.gOZ.bwk()) {
            this.gPa.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gPc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gOZ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gPb == null) {
            this.gPb = new OfficialAccountPushModel(this.gPd);
        }
        this.gPb.bxj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gPb != null) {
            this.gPb.onDestroy();
        }
    }
}
