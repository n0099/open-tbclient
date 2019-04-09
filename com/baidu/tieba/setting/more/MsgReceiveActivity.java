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
    private f isT;
    private MsgRemindModel isU;
    private OfficialAccountPushModel isV;
    private MsgRemindModel.a isW = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void e(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.isT.bZI().nZ();
                        MsgReceiveActivity.this.isT.pz(false);
                        MsgReceiveActivity.this.isT.py(false);
                        return;
                    }
                    MsgReceiveActivity.this.isT.bZI().nY();
                    MsgReceiveActivity.this.isT.pz(true);
                    MsgReceiveActivity.this.isT.py(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.isT.bZJ().nZ();
                    } else {
                        MsgReceiveActivity.this.isT.bZJ().nY();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().em(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.isT.bZK().nZ();
                } else {
                    MsgReceiveActivity.this.isT.bZK().nY();
                }
            }
        }
    };
    private OfficialAccountPushModel.a isX = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.isT != null) {
                MsgReceiveActivity.this.isT.ay(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isT = new f(this);
        this.isT.init();
        this.isU = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.isT.buv()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.isT.bZI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isU.a(8, true, this.isW);
                this.isT.pz(true);
                this.isT.py(true);
                return;
            }
            this.isU.a(8, false, this.isW);
            this.isT.pz(false);
            this.isT.py(false);
        } else if (view == this.isT.bZJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isU.a(9, true, this.isW);
            } else {
                this.isU.a(9, false, this.isW);
            }
        } else if (view == this.isT.bZK()) {
            this.isU.a(7, switchState == BdSwitchView.SwitchState.OFF, this.isW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.isT.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isV == null) {
            this.isV = new OfficialAccountPushModel(this.isX);
        }
        this.isV.caJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.isV != null) {
            this.isV.onDestroy();
        }
    }
}
