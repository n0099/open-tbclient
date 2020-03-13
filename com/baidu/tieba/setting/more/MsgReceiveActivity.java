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
    private f jTO;
    private MsgRemindModel jTP;
    private OfficialAccountPushModel jTQ;
    private MsgRemindModel.a jTR = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.jTO.cGk().turnOffNoCallback();
                        MsgReceiveActivity.this.jTO.sp(false);
                        MsgReceiveActivity.this.jTO.so(false);
                        return;
                    }
                    MsgReceiveActivity.this.jTO.cGk().turnOnNoCallback();
                    MsgReceiveActivity.this.jTO.sp(true);
                    MsgReceiveActivity.this.jTO.so(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.jTO.cGl().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.jTO.cGl().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLm().gk(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.jTO.cGm().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.jTO.cGm().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a jTS = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.jTO != null) {
                MsgReceiveActivity.this.jTO.aP(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jTO = new f(this);
        this.jTO.init();
        this.jTP = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jTO.bWD()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jTO.cGk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTP.a(8, true, this.jTR);
                this.jTO.sp(true);
                this.jTO.so(true);
                return;
            }
            this.jTP.a(8, false, this.jTR);
            this.jTO.sp(false);
            this.jTO.so(false);
        } else if (view == this.jTO.cGl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTP.a(9, true, this.jTR);
            } else {
                this.jTP.a(9, false, this.jTR);
            }
        } else if (view == this.jTO.cGm()) {
            this.jTP.a(7, switchState == BdSwitchView.SwitchState.OFF, this.jTR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jTO.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jTQ == null) {
            this.jTQ = new OfficialAccountPushModel(this.jTS);
        }
        this.jTQ.cHn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jTQ != null) {
            this.jTQ.onDestroy();
        }
    }
}
