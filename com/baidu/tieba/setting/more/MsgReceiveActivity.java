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
    private f mBU;
    private MsgRemindModel mBV;
    private OfficialAccountPushModel mBW;
    private MsgRemindModel.a mBX = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mBU.dBW().turnOffNoCallback();
                        MsgReceiveActivity.this.mBU.wK(false);
                        MsgReceiveActivity.this.mBU.wJ(false);
                        return;
                    }
                    MsgReceiveActivity.this.mBU.dBW().turnOnNoCallback();
                    MsgReceiveActivity.this.mBU.wK(true);
                    MsgReceiveActivity.this.mBU.wJ(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mBU.dBX().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.mBU.dBX().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.btV().jB(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.mBU.dBY().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.mBU.dBY().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a mBY = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.mBU != null) {
                MsgReceiveActivity.this.mBU.bf(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBU = new f(this);
        this.mBU.init();
        this.mBV = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mBU.cRd()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mBU.dBW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mBV.a(8, true, this.mBX);
                this.mBU.wK(true);
                this.mBU.wJ(true);
                return;
            }
            this.mBV.a(8, false, this.mBX);
            this.mBU.wK(false);
            this.mBU.wJ(false);
        } else if (view == this.mBU.dBX()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mBV.a(9, true, this.mBX);
            } else {
                this.mBV.a(9, false, this.mBX);
            }
        } else if (view == this.mBU.dBY()) {
            this.mBV.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mBX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mBU.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mBW == null) {
            this.mBW = new OfficialAccountPushModel(this.mBY);
        }
        this.mBW.dDd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mBW != null) {
            this.mBW.onDestroy();
        }
    }
}
