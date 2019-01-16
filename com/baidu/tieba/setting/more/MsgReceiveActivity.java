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
    private MsgRemindModel.a hbA = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.hbx.byV().nU();
                        MsgReceiveActivity.this.hbx.na(false);
                        MsgReceiveActivity.this.hbx.mZ(false);
                        return;
                    }
                    MsgReceiveActivity.this.hbx.byV().nT();
                    MsgReceiveActivity.this.hbx.na(true);
                    MsgReceiveActivity.this.hbx.mZ(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.hbx.byW().nU();
                    } else {
                        MsgReceiveActivity.this.hbx.byW().nT();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().cd(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.hbx.byX().nU();
                } else {
                    MsgReceiveActivity.this.hbx.byX().nT();
                }
            }
        }
    };
    private OfficialAccountPushModel.a hbB = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.hbx != null) {
                MsgReceiveActivity.this.hbx.au(arrayList);
            }
        }
    };
    private f hbx;
    private MsgRemindModel hby;
    private OfficialAccountPushModel hbz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbx = new f(this);
        this.hbx.init();
        this.hby = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hbx.aTU()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.hbx.byV()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hby.a(8, true, this.hbA);
                this.hbx.na(true);
                this.hbx.mZ(true);
                return;
            }
            this.hby.a(8, false, this.hbA);
            this.hbx.na(false);
            this.hbx.mZ(false);
        } else if (view == this.hbx.byW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hby.a(9, true, this.hbA);
            } else {
                this.hby.a(9, false, this.hbA);
            }
        } else if (view == this.hbx.byX()) {
            this.hby.a(7, switchState == BdSwitchView.SwitchState.OFF, this.hbA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hbx.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hbz == null) {
            this.hbz = new OfficialAccountPushModel(this.hbB);
        }
        this.hbz.bzW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hbz != null) {
            this.hbz.onDestroy();
        }
    }
}
