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
    private f lQs;
    private MsgRemindModel lQt;
    private OfficialAccountPushModel lQu;
    private MsgRemindModel.a lQv = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.lQs.drk().turnOffNoCallback();
                        MsgReceiveActivity.this.lQs.vC(false);
                        MsgReceiveActivity.this.lQs.vB(false);
                        return;
                    }
                    MsgReceiveActivity.this.lQs.drk().turnOnNoCallback();
                    MsgReceiveActivity.this.lQs.vC(true);
                    MsgReceiveActivity.this.lQs.vB(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.lQs.drl().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.lQs.drl().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iS(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.lQs.drm().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.lQs.drm().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a lQw = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.lQs != null) {
                MsgReceiveActivity.this.lQs.ba(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lQs = new f(this);
        this.lQs.init();
        this.lQt = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lQs.cGG()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.lQs.drk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQt.a(8, true, this.lQv);
                this.lQs.vC(true);
                this.lQs.vB(true);
                return;
            }
            this.lQt.a(8, false, this.lQv);
            this.lQs.vC(false);
            this.lQs.vB(false);
        } else if (view == this.lQs.drl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQt.a(9, true, this.lQv);
            } else {
                this.lQt.a(9, false, this.lQv);
            }
        } else if (view == this.lQs.drm()) {
            this.lQt.a(7, switchState == BdSwitchView.SwitchState.OFF, this.lQv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lQs.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lQu == null) {
            this.lQu = new OfficialAccountPushModel(this.lQw);
        }
        this.lQu.dsp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lQu != null) {
            this.lQu.onDestroy();
        }
    }
}
