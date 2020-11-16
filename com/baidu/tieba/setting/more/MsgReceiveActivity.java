package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes25.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private OfficialAccountPushModel mIA;
    private MsgRemindModel.a mIB = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mIy.dEd().turnOffNoCallback();
                        MsgReceiveActivity.this.mIy.wW(false);
                        MsgReceiveActivity.this.mIy.wV(false);
                        return;
                    }
                    MsgReceiveActivity.this.mIy.dEd().turnOnNoCallback();
                    MsgReceiveActivity.this.mIy.wW(true);
                    MsgReceiveActivity.this.mIy.wV(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.mIy.dEe().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.mIy.dEe().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jL(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.mIy.dEf().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.mIy.dEf().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a mIC = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.mIy != null) {
                MsgReceiveActivity.this.mIy.bg(arrayList);
            }
        }
    };
    private f mIy;
    private MsgRemindModel mIz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mIy = new f(this);
        this.mIy.init();
        this.mIz = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mIy.cTk()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mIy.dEd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mIz.a(8, true, this.mIB);
                this.mIy.wW(true);
                this.mIy.wV(true);
                return;
            }
            this.mIz.a(8, false, this.mIB);
            this.mIy.wW(false);
            this.mIy.wV(false);
        } else if (view == this.mIy.dEe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mIz.a(9, true, this.mIB);
            } else {
                this.mIz.a(9, false, this.mIB);
            }
        } else if (view == this.mIy.dEf()) {
            this.mIz.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mIB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mIy.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mIA == null) {
            this.mIA = new OfficialAccountPushModel(this.mIC);
        }
        this.mIA.dFt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mIA != null) {
            this.mIA.onDestroy();
        }
    }
}
