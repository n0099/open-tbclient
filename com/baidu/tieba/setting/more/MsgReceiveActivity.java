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
    private OfficialAccountPushModel kEA;
    private MsgRemindModel.a kEB = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.kEy.cRc().turnOffNoCallback();
                        MsgReceiveActivity.this.kEy.tw(false);
                        MsgReceiveActivity.this.kEy.tv(false);
                        return;
                    }
                    MsgReceiveActivity.this.kEy.cRc().turnOnNoCallback();
                    MsgReceiveActivity.this.kEy.tw(true);
                    MsgReceiveActivity.this.kEy.tv(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.kEy.cRd().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.kEy.cRd().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTN().hj(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.kEy.cRe().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.kEy.cRe().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a kEC = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.kEy != null) {
                MsgReceiveActivity.this.kEy.aR(arrayList);
            }
        }
    };
    private f kEy;
    private MsgRemindModel kEz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kEy = new f(this);
        this.kEy.init();
        this.kEz = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kEy.chw()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.kEy.cRc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kEz.a(8, true, this.kEB);
                this.kEy.tw(true);
                this.kEy.tv(true);
                return;
            }
            this.kEz.a(8, false, this.kEB);
            this.kEy.tw(false);
            this.kEy.tv(false);
        } else if (view == this.kEy.cRd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kEz.a(9, true, this.kEB);
            } else {
                this.kEz.a(9, false, this.kEB);
            }
        } else if (view == this.kEy.cRe()) {
            this.kEz.a(7, switchState == BdSwitchView.SwitchState.OFF, this.kEB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kEy.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kEA == null) {
            this.kEA = new OfficialAccountPushModel(this.kEC);
        }
        this.kEA.cSf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kEA != null) {
            this.kEA.onDestroy();
        }
    }
}
