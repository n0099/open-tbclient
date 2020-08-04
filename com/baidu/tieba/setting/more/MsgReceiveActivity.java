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
    private f lze;
    private MsgRemindModel lzf;
    private OfficialAccountPushModel lzg;
    private MsgRemindModel.a lzh = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.lze.dfQ().turnOffNoCallback();
                        MsgReceiveActivity.this.lze.uN(false);
                        MsgReceiveActivity.this.lze.uM(false);
                        return;
                    }
                    MsgReceiveActivity.this.lze.dfQ().turnOnNoCallback();
                    MsgReceiveActivity.this.lze.uN(true);
                    MsgReceiveActivity.this.lze.uM(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.lze.dfR().turnOffNoCallback();
                    } else {
                        MsgReceiveActivity.this.lze.dfR().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bfO().iu(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.lze.dfS().turnOffNoCallback();
                } else {
                    MsgReceiveActivity.this.lze.dfS().turnOnNoCallback();
                }
            }
        }
    };
    private OfficialAccountPushModel.a lzi = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.lze != null) {
                MsgReceiveActivity.this.lze.aU(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lze = new f(this);
        this.lze.init();
        this.lzf = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lze.cvP()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.lze.dfQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lzf.a(8, true, this.lzh);
                this.lze.uN(true);
                this.lze.uM(true);
                return;
            }
            this.lzf.a(8, false, this.lzh);
            this.lze.uN(false);
            this.lze.uM(false);
        } else if (view == this.lze.dfR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lzf.a(9, true, this.lzh);
            } else {
                this.lzf.a(9, false, this.lzh);
            }
        } else if (view == this.lze.dfS()) {
            this.lzf.a(7, switchState == BdSwitchView.SwitchState.OFF, this.lzh);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lze.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lzg == null) {
            this.lzg = new OfficialAccountPushModel(this.lzi);
        }
        this.lzg.dgT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lzg != null) {
            this.lzg.onDestroy();
        }
    }
}
