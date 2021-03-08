package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private f njE;
    private MsgRemindModel njF;
    private OfficialAccountPushModel njG;
    private MsgRemindModel.a njH = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.njE.dHO().turnOffNoCallback();
                        MsgReceiveActivity.this.njE.xQ(false);
                        MsgReceiveActivity.this.njE.xP(false);
                        return;
                    }
                    MsgReceiveActivity.this.njE.dHO().turnOnNoCallback();
                    MsgReceiveActivity.this.njE.xQ(true);
                    MsgReceiveActivity.this.njE.xP(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.njE.dHP().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.njE.dHP().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.byh().kw(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.njE.dHQ().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.njE.dHQ().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a njI = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.njE != null) {
                MsgReceiveActivity.this.njE.bc(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.njE = new f(this);
        this.njE.init();
        this.njF = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.njE.cWM()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.njE.dHO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.njF.a(8, true, this.njH);
                this.njE.xQ(true);
                this.njE.xP(true);
                return;
            }
            this.njF.a(8, false, this.njH);
            this.njE.xQ(false);
            this.njE.xP(false);
        } else if (view == this.njE.dHP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.njF.a(9, true, this.njH);
            } else {
                this.njF.a(9, false, this.njH);
            }
        } else if (view == this.njE.dHQ()) {
            this.njF.a(7, switchState == BdSwitchView.SwitchState.OFF, this.njH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.njE.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.njG == null) {
            this.njG = new OfficialAccountPushModel(this.njI);
        }
        this.njG.dJf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.njG != null) {
            this.njG.onDestroy();
        }
    }
}
