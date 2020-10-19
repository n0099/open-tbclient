package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private f mpt;
    private MsgRemindModel mpu;
    private OfficialAccountPushModel mpv;
    private MsgRemindModel.a mpw = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mpt.dyO().turnOffNoCallback();
                        MsgReceiveActivity.this.mpt.wt(false);
                        MsgReceiveActivity.this.mpt.ws(false);
                        return;
                    }
                    MsgReceiveActivity.this.mpt.dyO().turnOnNoCallback();
                    MsgReceiveActivity.this.mpt.wt(true);
                    MsgReceiveActivity.this.mpt.ws(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mpt.dyP().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.mpt.dyP().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jo(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.mpt.dyQ().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.mpt.dyQ().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a mpx = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.mpt != null) {
                MsgReceiveActivity.this.mpt.bc(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mpt = new f(this);
        this.mpt.init();
        this.mpu = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mpt.cNW()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mpt.dyO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mpu.a(8, true, this.mpw);
                this.mpt.wt(true);
                this.mpt.ws(true);
                return;
            }
            this.mpu.a(8, false, this.mpw);
            this.mpt.wt(false);
            this.mpt.ws(false);
        } else if (view == this.mpt.dyP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mpu.a(9, true, this.mpw);
            } else {
                this.mpu.a(9, false, this.mpw);
            }
        } else if (view == this.mpt.dyQ()) {
            this.mpu.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mpw);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mpt.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mpv == null) {
            this.mpv = new OfficialAccountPushModel(this.mpx);
        }
        this.mpv.dzV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mpv != null) {
            this.mpv.onDestroy();
        }
    }
}
