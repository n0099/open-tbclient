package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private f ngZ;
    private MsgRemindModel nha;
    private OfficialAccountPushModel nhb;
    private MsgRemindModel.a nhc = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.ngZ.dHy().turnOffNoCallback();
                        MsgReceiveActivity.this.ngZ.xQ(false);
                        MsgReceiveActivity.this.ngZ.xP(false);
                        return;
                    }
                    MsgReceiveActivity.this.ngZ.dHy().turnOnNoCallback();
                    MsgReceiveActivity.this.ngZ.xQ(true);
                    MsgReceiveActivity.this.ngZ.xP(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.ngZ.dHz().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.ngZ.dHz().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().kw(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.ngZ.dHA().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.ngZ.dHA().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a nhd = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.ngZ != null) {
                MsgReceiveActivity.this.ngZ.bc(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ngZ = new f(this);
        this.ngZ.init();
        this.nha = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ngZ.cWy()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.ngZ.dHy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nha.a(8, true, this.nhc);
                this.ngZ.xQ(true);
                this.ngZ.xP(true);
                return;
            }
            this.nha.a(8, false, this.nhc);
            this.ngZ.xQ(false);
            this.ngZ.xP(false);
        } else if (view == this.ngZ.dHz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nha.a(9, true, this.nhc);
            } else {
                this.nha.a(9, false, this.nhc);
            }
        } else if (view == this.ngZ.dHA()) {
            this.nha.a(7, switchState == BdSwitchView.SwitchState.OFF, this.nhc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ngZ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nhb == null) {
            this.nhb = new OfficialAccountPushModel(this.nhd);
        }
        this.nhb.dIP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nhb != null) {
            this.nhb.onDestroy();
        }
    }
}
