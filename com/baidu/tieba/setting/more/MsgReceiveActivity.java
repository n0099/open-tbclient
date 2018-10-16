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
    private e gOY;
    private MsgRemindModel gOZ;
    private OfficialAccountPushModel gPa;
    private MsgRemindModel.a gPb = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gOY.bwi().nT();
                        MsgReceiveActivity.this.gOY.mI(false);
                        MsgReceiveActivity.this.gOY.mH(false);
                        return;
                    }
                    MsgReceiveActivity.this.gOY.bwi().nS();
                    MsgReceiveActivity.this.gOY.mI(true);
                    MsgReceiveActivity.this.gOY.mH(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gOY.bwj().nT();
                    } else {
                        MsgReceiveActivity.this.gOY.bwj().nS();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bK(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gOY.bwk().nT();
                } else {
                    MsgReceiveActivity.this.gOY.bwk().nS();
                }
            }
        }
    };
    private OfficialAccountPushModel.a gPc = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.gOY != null) {
                MsgReceiveActivity.this.gOY.av(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gOY = new e(this);
        this.gOY.init();
        this.gOZ = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gOY.aRs()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gOY.bwi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gOZ.a(8, true, this.gPb);
                this.gOY.mI(true);
                this.gOY.mH(true);
                return;
            }
            this.gOZ.a(8, false, this.gPb);
            this.gOY.mI(false);
            this.gOY.mH(false);
        } else if (view == this.gOY.bwj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gOZ.a(9, true, this.gPb);
            } else {
                this.gOZ.a(9, false, this.gPb);
            }
        } else if (view == this.gOY.bwk()) {
            this.gOZ.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gPb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gOY.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gPa == null) {
            this.gPa = new OfficialAccountPushModel(this.gPc);
        }
        this.gPa.bxj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gPa != null) {
            this.gPa.onDestroy();
        }
    }
}
