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
    private f iVr;
    private MsgRemindModel iVs;
    private OfficialAccountPushModel iVt;
    private MsgRemindModel.a iVu = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void f(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iVr.cjy().turnOffNoCallback();
                        MsgReceiveActivity.this.iVr.qr(false);
                        MsgReceiveActivity.this.iVr.qq(false);
                        return;
                    }
                    MsgReceiveActivity.this.iVr.cjy().turnOnNoCallback();
                    MsgReceiveActivity.this.iVr.qr(true);
                    MsgReceiveActivity.this.iVr.qq(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iVr.cjz().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.iVr.cjz().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.ara().eM(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.iVr.cjA().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.iVr.cjA().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a iVv = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.iVr != null) {
                MsgReceiveActivity.this.iVr.aG(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iVr = new f(this);
        this.iVr.init();
        this.iVs = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iVr.bCF()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iVr.cjy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVs.a(8, true, this.iVu);
                this.iVr.qr(true);
                this.iVr.qq(true);
                return;
            }
            this.iVs.a(8, false, this.iVu);
            this.iVr.qr(false);
            this.iVr.qq(false);
        } else if (view == this.iVr.cjz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVs.a(9, true, this.iVu);
            } else {
                this.iVs.a(9, false, this.iVu);
            }
        } else if (view == this.iVr.cjA()) {
            this.iVs.a(7, switchState == BdSwitchView.SwitchState.OFF, this.iVu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iVr.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iVt == null) {
            this.iVt = new OfficialAccountPushModel(this.iVv);
        }
        this.iVt.ckz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iVt != null) {
            this.iVt.onDestroy();
        }
    }
}
