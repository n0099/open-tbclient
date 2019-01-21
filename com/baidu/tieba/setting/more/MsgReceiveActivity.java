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
    private OfficialAccountPushModel hbA;
    private MsgRemindModel.a hbB = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.hby.byV().nU();
                        MsgReceiveActivity.this.hby.na(false);
                        MsgReceiveActivity.this.hby.mZ(false);
                        return;
                    }
                    MsgReceiveActivity.this.hby.byV().nT();
                    MsgReceiveActivity.this.hby.na(true);
                    MsgReceiveActivity.this.hby.mZ(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.hby.byW().nU();
                    } else {
                        MsgReceiveActivity.this.hby.byW().nT();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().cd(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.hby.byX().nU();
                } else {
                    MsgReceiveActivity.this.hby.byX().nT();
                }
            }
        }
    };
    private OfficialAccountPushModel.a hbC = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.hby != null) {
                MsgReceiveActivity.this.hby.au(arrayList);
            }
        }
    };
    private f hby;
    private MsgRemindModel hbz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hby = new f(this);
        this.hby.init();
        this.hbz = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hby.aTU()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.hby.byV()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hbz.a(8, true, this.hbB);
                this.hby.na(true);
                this.hby.mZ(true);
                return;
            }
            this.hbz.a(8, false, this.hbB);
            this.hby.na(false);
            this.hby.mZ(false);
        } else if (view == this.hby.byW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hbz.a(9, true, this.hbB);
            } else {
                this.hbz.a(9, false, this.hbB);
            }
        } else if (view == this.hby.byX()) {
            this.hbz.a(7, switchState == BdSwitchView.SwitchState.OFF, this.hbB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hby.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hbA == null) {
            this.hbA = new OfficialAccountPushModel(this.hbC);
        }
        this.hbA.bzW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hbA != null) {
            this.hbA.onDestroy();
        }
    }
}
