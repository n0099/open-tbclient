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
    private f nbX;
    private MsgRemindModel nbY;
    private OfficialAccountPushModel nbZ;
    private MsgRemindModel.a nca = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.nbX.dJe().turnOffNoCallback();
                        MsgReceiveActivity.this.nbX.xB(false);
                        MsgReceiveActivity.this.nbX.xA(false);
                        return;
                    }
                    MsgReceiveActivity.this.nbX.dJe().turnOnNoCallback();
                    MsgReceiveActivity.this.nbX.xB(true);
                    MsgReceiveActivity.this.nbX.xA(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.nbX.dJf().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.nbX.dJf().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kx(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.nbX.dJg().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.nbX.dJg().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a ncb = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.nbX != null) {
                MsgReceiveActivity.this.nbX.bi(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nbX = new f(this);
        this.nbX.init();
        this.nbY = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.nbX.cYr()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.nbX.dJe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbY.a(8, true, this.nca);
                this.nbX.xB(true);
                this.nbX.xA(true);
                return;
            }
            this.nbY.a(8, false, this.nca);
            this.nbX.xB(false);
            this.nbX.xA(false);
        } else if (view == this.nbX.dJf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbY.a(9, true, this.nca);
            } else {
                this.nbY.a(9, false, this.nca);
            }
        } else if (view == this.nbX.dJg()) {
            this.nbY.a(7, switchState == BdSwitchView.SwitchState.OFF, this.nca);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.nbX.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nbZ == null) {
            this.nbZ = new OfficialAccountPushModel(this.ncb);
        }
        this.nbZ.dKv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nbZ != null) {
            this.nbZ.onDestroy();
        }
    }
}
