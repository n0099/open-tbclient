package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private f mXr;
    private MsgRemindModel mXs;
    private OfficialAccountPushModel mXt;
    private MsgRemindModel.a mXu = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mXr.dFn().turnOffNoCallback();
                        MsgReceiveActivity.this.mXr.xx(false);
                        MsgReceiveActivity.this.mXr.xw(false);
                        return;
                    }
                    MsgReceiveActivity.this.mXr.dFn().turnOnNoCallback();
                    MsgReceiveActivity.this.mXr.xx(true);
                    MsgReceiveActivity.this.mXr.xw(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mXr.dFo().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.mXr.dFo().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bxM().kt(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.mXr.dFp().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.mXr.dFp().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a mXv = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.mXr != null) {
                MsgReceiveActivity.this.mXr.bd(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mXr = new f(this);
        this.mXr.init();
        this.mXs = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mXr.cUA()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mXr.dFn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mXs.a(8, true, this.mXu);
                this.mXr.xx(true);
                this.mXr.xw(true);
                return;
            }
            this.mXs.a(8, false, this.mXu);
            this.mXr.xx(false);
            this.mXr.xw(false);
        } else if (view == this.mXr.dFo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mXs.a(9, true, this.mXu);
            } else {
                this.mXs.a(9, false, this.mXu);
            }
        } else if (view == this.mXr.dFp()) {
            this.mXs.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mXu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mXr.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mXt == null) {
            this.mXt = new OfficialAccountPushModel(this.mXv);
        }
        this.mXt.dGE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mXt != null) {
            this.mXt.onDestroy();
        }
    }
}
