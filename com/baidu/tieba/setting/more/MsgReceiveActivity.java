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
    private f jVq;
    private MsgRemindModel jVr;
    private OfficialAccountPushModel jVs;
    private MsgRemindModel.a jVt = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.jVq.cGE().turnOffNoCallback();
                        MsgReceiveActivity.this.jVq.sv(false);
                        MsgReceiveActivity.this.jVq.su(false);
                        return;
                    }
                    MsgReceiveActivity.this.jVq.cGE().turnOnNoCallback();
                    MsgReceiveActivity.this.jVq.sv(true);
                    MsgReceiveActivity.this.jVq.su(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.jVq.cGF().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.jVq.cGF().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gl(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.jVq.cGG().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.jVq.cGG().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a jVu = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.jVq != null) {
                MsgReceiveActivity.this.jVq.aP(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jVq = new f(this);
        this.jVq.init();
        this.jVr = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jVq.bWV()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jVq.cGE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jVr.a(8, true, this.jVt);
                this.jVq.sv(true);
                this.jVq.su(true);
                return;
            }
            this.jVr.a(8, false, this.jVt);
            this.jVq.sv(false);
            this.jVq.su(false);
        } else if (view == this.jVq.cGF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jVr.a(9, true, this.jVt);
            } else {
                this.jVr.a(9, false, this.jVt);
            }
        } else if (view == this.jVq.cGG()) {
            this.jVr.a(7, switchState == BdSwitchView.SwitchState.OFF, this.jVt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jVq.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jVs == null) {
            this.jVs = new OfficialAccountPushModel(this.jVu);
        }
        this.jVs.cHH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jVs != null) {
            this.jVs.onDestroy();
        }
    }
}
