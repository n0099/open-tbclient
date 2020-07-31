package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private f lzc;
    private MsgRemindModel lzd;
    private OfficialAccountPushModel lze;
    private MsgRemindModel.a lzf = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.lzc.dfQ().turnOffNoCallback();
                        MsgReceiveActivity.this.lzc.uN(false);
                        MsgReceiveActivity.this.lzc.uM(false);
                        return;
                    }
                    MsgReceiveActivity.this.lzc.dfQ().turnOnNoCallback();
                    MsgReceiveActivity.this.lzc.uN(true);
                    MsgReceiveActivity.this.lzc.uM(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.lzc.dfR().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.lzc.dfR().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bfO().iu(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.lzc.dfS().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.lzc.dfS().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a lzg = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.lzc != null) {
                MsgReceiveActivity.this.lzc.aU(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lzc = new f(this);
        this.lzc.init();
        this.lzd = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lzc.cvP()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.lzc.dfQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lzd.a(8, true, this.lzf);
                this.lzc.uN(true);
                this.lzc.uM(true);
                return;
            }
            this.lzd.a(8, false, this.lzf);
            this.lzc.uN(false);
            this.lzc.uM(false);
        } else if (view == this.lzc.dfR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lzd.a(9, true, this.lzf);
            } else {
                this.lzd.a(9, false, this.lzf);
            }
        } else if (view == this.lzc.dfS()) {
            this.lzd.a(7, switchState == BdSwitchView.SwitchState.OFF, this.lzf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lzc.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lze == null) {
            this.lze = new OfficialAccountPushModel(this.lzg);
        }
        this.lze.dgT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lze != null) {
            this.lze.onDestroy();
        }
    }
}
