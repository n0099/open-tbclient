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
    private f iTj;
    private MsgRemindModel iTk;
    private OfficialAccountPushModel iTl;
    private MsgRemindModel.a iTm = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void f(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iTj.ckY().nl();
                        MsgReceiveActivity.this.iTj.qF(false);
                        MsgReceiveActivity.this.iTj.qE(false);
                        return;
                    }
                    MsgReceiveActivity.this.iTj.ckY().nk();
                    MsgReceiveActivity.this.iTj.qF(true);
                    MsgReceiveActivity.this.iTj.qE(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iTj.ckZ().nl();
                    } else {
                        MsgReceiveActivity.this.iTj.ckZ().nk();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aom().eN(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.iTj.cla().nl();
                } else {
                    MsgReceiveActivity.this.iTj.cla().nk();
                }
            }
        }
    };
    private OfficialAccountPushModel.a iTn = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.iTj != null) {
                MsgReceiveActivity.this.iTj.aC(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iTj = new f(this);
        this.iTj.init();
        this.iTk = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iTj.bFg()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iTj.ckY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iTk.a(8, true, this.iTm);
                this.iTj.qF(true);
                this.iTj.qE(true);
                return;
            }
            this.iTk.a(8, false, this.iTm);
            this.iTj.qF(false);
            this.iTj.qE(false);
        } else if (view == this.iTj.ckZ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iTk.a(9, true, this.iTm);
            } else {
                this.iTk.a(9, false, this.iTm);
            }
        } else if (view == this.iTj.cla()) {
            this.iTk.a(7, switchState == BdSwitchView.SwitchState.OFF, this.iTm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iTj.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iTl == null) {
            this.iTl = new OfficialAccountPushModel(this.iTn);
        }
        this.iTl.aVP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iTl != null) {
            this.iTl.onDestroy();
        }
    }
}
