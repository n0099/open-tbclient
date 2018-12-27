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
    private f has;
    private MsgRemindModel hat;
    private OfficialAccountPushModel hau;
    private MsgRemindModel.a hav = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.has.bym().nQ();
                        MsgReceiveActivity.this.has.mZ(false);
                        MsgReceiveActivity.this.has.mY(false);
                        return;
                    }
                    MsgReceiveActivity.this.has.bym().nP();
                    MsgReceiveActivity.this.has.mZ(true);
                    MsgReceiveActivity.this.has.mY(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.has.byn().nQ();
                    } else {
                        MsgReceiveActivity.this.has.byn().nP();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ix().cc(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.has.byo().nQ();
                } else {
                    MsgReceiveActivity.this.has.byo().nP();
                }
            }
        }
    };
    private OfficialAccountPushModel.a haw = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.has != null) {
                MsgReceiveActivity.this.has.au(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.has = new f(this);
        this.has.init();
        this.hat = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.has.aTu()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.has.bym()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hat.a(8, true, this.hav);
                this.has.mZ(true);
                this.has.mY(true);
                return;
            }
            this.hat.a(8, false, this.hav);
            this.has.mZ(false);
            this.has.mY(false);
        } else if (view == this.has.byn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hat.a(9, true, this.hav);
            } else {
                this.hat.a(9, false, this.hav);
            }
        } else if (view == this.has.byo()) {
            this.hat.a(7, switchState == BdSwitchView.SwitchState.OFF, this.hav);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.has.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hau == null) {
            this.hau = new OfficialAccountPushModel(this.haw);
        }
        this.hau.bzn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hau != null) {
            this.hau.onDestroy();
        }
    }
}
