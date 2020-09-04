package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private f lQF;
    private MsgRemindModel lQG;
    private OfficialAccountPushModel lQH;
    private MsgRemindModel.a lQI = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.lQF.drn().turnOffNoCallback();
                        MsgReceiveActivity.this.lQF.vE(false);
                        MsgReceiveActivity.this.lQF.vD(false);
                        return;
                    }
                    MsgReceiveActivity.this.lQF.drn().turnOnNoCallback();
                    MsgReceiveActivity.this.lQF.vE(true);
                    MsgReceiveActivity.this.lQF.vD(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.lQF.dro().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.lQF.dro().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iT(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.lQF.drp().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.lQF.drp().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a lQJ = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.lQF != null) {
                MsgReceiveActivity.this.lQF.ba(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lQF = new f(this);
        this.lQF.init();
        this.lQG = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lQF.cGH()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.lQF.drn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQG.a(8, true, this.lQI);
                this.lQF.vE(true);
                this.lQF.vD(true);
                return;
            }
            this.lQG.a(8, false, this.lQI);
            this.lQF.vE(false);
            this.lQF.vD(false);
        } else if (view == this.lQF.dro()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQG.a(9, true, this.lQI);
            } else {
                this.lQG.a(9, false, this.lQI);
            }
        } else if (view == this.lQF.drp()) {
            this.lQG.a(7, switchState == BdSwitchView.SwitchState.OFF, this.lQI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lQF.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lQH == null) {
            this.lQH = new OfficialAccountPushModel(this.lQJ);
        }
        this.lQH.dsu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lQH != null) {
            this.lQH.onDestroy();
        }
    }
}
