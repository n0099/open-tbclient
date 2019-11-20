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
    private f iUA;
    private MsgRemindModel iUB;
    private OfficialAccountPushModel iUC;
    private MsgRemindModel.a iUD = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void f(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iUA.cjw().turnOffNoCallback();
                        MsgReceiveActivity.this.iUA.qr(false);
                        MsgReceiveActivity.this.iUA.qq(false);
                        return;
                    }
                    MsgReceiveActivity.this.iUA.cjw().turnOnNoCallback();
                    MsgReceiveActivity.this.iUA.qr(true);
                    MsgReceiveActivity.this.iUA.qq(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.iUA.cjx().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.iUA.cjx().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eM(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.iUA.cjy().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.iUA.cjy().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a iUE = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.iUA != null) {
                MsgReceiveActivity.this.iUA.aG(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iUA = new f(this);
        this.iUA.init();
        this.iUB = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iUA.bCD()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iUA.cjw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iUB.a(8, true, this.iUD);
                this.iUA.qr(true);
                this.iUA.qq(true);
                return;
            }
            this.iUB.a(8, false, this.iUD);
            this.iUA.qr(false);
            this.iUA.qq(false);
        } else if (view == this.iUA.cjx()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iUB.a(9, true, this.iUD);
            } else {
                this.iUB.a(9, false, this.iUD);
            }
        } else if (view == this.iUA.cjy()) {
            this.iUB.a(7, switchState == BdSwitchView.SwitchState.OFF, this.iUD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iUA.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iUC == null) {
            this.iUC = new OfficialAccountPushModel(this.iUE);
        }
        this.iUC.ckx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iUC != null) {
            this.iUC.onDestroy();
        }
    }
}
