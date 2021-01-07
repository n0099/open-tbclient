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
    private f nbW;
    private MsgRemindModel nbX;
    private OfficialAccountPushModel nbY;
    private MsgRemindModel.a nbZ = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.nbW.dJf().turnOffNoCallback();
                        MsgReceiveActivity.this.nbW.xB(false);
                        MsgReceiveActivity.this.nbW.xA(false);
                        return;
                    }
                    MsgReceiveActivity.this.nbW.dJf().turnOnNoCallback();
                    MsgReceiveActivity.this.nbW.xB(true);
                    MsgReceiveActivity.this.nbW.xA(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.nbW.dJg().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.nbW.dJg().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kx(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.nbW.dJh().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.nbW.dJh().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a nca = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.nbW != null) {
                MsgReceiveActivity.this.nbW.bi(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nbW = new f(this);
        this.nbW.init();
        this.nbX = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.nbW.cYs()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.nbW.dJf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbX.a(8, true, this.nbZ);
                this.nbW.xB(true);
                this.nbW.xA(true);
                return;
            }
            this.nbX.a(8, false, this.nbZ);
            this.nbW.xB(false);
            this.nbW.xA(false);
        } else if (view == this.nbW.dJg()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbX.a(9, true, this.nbZ);
            } else {
                this.nbX.a(9, false, this.nbZ);
            }
        } else if (view == this.nbW.dJh()) {
            this.nbX.a(7, switchState == BdSwitchView.SwitchState.OFF, this.nbZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.nbW.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nbY == null) {
            this.nbY = new OfficialAccountPushModel(this.nca);
        }
        this.nbY.dKw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nbY != null) {
            this.nbY.onDestroy();
        }
    }
}
