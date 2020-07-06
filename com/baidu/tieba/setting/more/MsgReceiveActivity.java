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
    private f lrK;
    private MsgRemindModel lrL;
    private OfficialAccountPushModel lrM;
    private MsgRemindModel.a lrN = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.lrK.dcJ().turnOffNoCallback();
                        MsgReceiveActivity.this.lrK.uj(false);
                        MsgReceiveActivity.this.lrK.ui(false);
                        return;
                    }
                    MsgReceiveActivity.this.lrK.dcJ().turnOnNoCallback();
                    MsgReceiveActivity.this.lrK.uj(true);
                    MsgReceiveActivity.this.lrK.ui(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.lrK.dcK().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.lrK.dcK().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hQ(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.lrK.dcL().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.lrK.dcL().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a lrO = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.lrK != null) {
                MsgReceiveActivity.this.lrK.aT(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lrK = new f(this);
        this.lrK.init();
        this.lrL = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lrK.crR()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.lrK.dcJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lrL.a(8, true, this.lrN);
                this.lrK.uj(true);
                this.lrK.ui(true);
                return;
            }
            this.lrL.a(8, false, this.lrN);
            this.lrK.uj(false);
            this.lrK.ui(false);
        } else if (view == this.lrK.dcK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lrL.a(9, true, this.lrN);
            } else {
                this.lrL.a(9, false, this.lrN);
            }
        } else if (view == this.lrK.dcL()) {
            this.lrL.a(7, switchState == BdSwitchView.SwitchState.OFF, this.lrN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lrK.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lrM == null) {
            this.lrM = new OfficialAccountPushModel(this.lrO);
        }
        this.lrM.ddM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lrM != null) {
            this.lrM.onDestroy();
        }
    }
}
