package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private f mHW;
    private MsgRemindModel mHX;
    private OfficialAccountPushModel mHY;
    private MsgRemindModel.a mHZ = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mHW.dEy().turnOffNoCallback();
                        MsgReceiveActivity.this.mHW.wT(false);
                        MsgReceiveActivity.this.mHW.wS(false);
                        return;
                    }
                    MsgReceiveActivity.this.mHW.dEy().turnOnNoCallback();
                    MsgReceiveActivity.this.mHW.wT(true);
                    MsgReceiveActivity.this.mHW.wS(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mHW.dEz().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.mHW.dEz().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jK(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.mHW.dEA().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.mHW.dEA().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a mIa = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.mHW != null) {
                MsgReceiveActivity.this.mHW.bf(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHW = new f(this);
        this.mHW.init();
        this.mHX = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mHW.cTE()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mHW.dEy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mHX.a(8, true, this.mHZ);
                this.mHW.wT(true);
                this.mHW.wS(true);
                return;
            }
            this.mHX.a(8, false, this.mHZ);
            this.mHW.wT(false);
            this.mHW.wS(false);
        } else if (view == this.mHW.dEz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mHX.a(9, true, this.mHZ);
            } else {
                this.mHX.a(9, false, this.mHZ);
            }
        } else if (view == this.mHW.dEA()) {
            this.mHX.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mHZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mHW.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mHY == null) {
            this.mHY = new OfficialAccountPushModel(this.mIa);
        }
        this.mHY.dFF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mHY != null) {
            this.mHY.onDestroy();
        }
    }
}
