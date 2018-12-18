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
    private e gXo;
    private MsgRemindModel gXp;
    private OfficialAccountPushModel gXq;
    private MsgRemindModel.a gXr = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gXo.bxw().nQ();
                        MsgReceiveActivity.this.gXo.mW(false);
                        MsgReceiveActivity.this.gXo.mV(false);
                        return;
                    }
                    MsgReceiveActivity.this.gXo.bxw().nP();
                    MsgReceiveActivity.this.gXo.mW(true);
                    MsgReceiveActivity.this.gXo.mV(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gXo.bxx().nQ();
                    } else {
                        MsgReceiveActivity.this.gXo.bxx().nP();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Iw().cc(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gXo.bxy().nQ();
                } else {
                    MsgReceiveActivity.this.gXo.bxy().nP();
                }
            }
        }
    };
    private OfficialAccountPushModel.a gXs = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.gXo != null) {
                MsgReceiveActivity.this.gXo.au(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gXo = new e(this);
        this.gXo.init();
        this.gXp = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gXo.aSG()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gXo.bxw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gXp.a(8, true, this.gXr);
                this.gXo.mW(true);
                this.gXo.mV(true);
                return;
            }
            this.gXp.a(8, false, this.gXr);
            this.gXo.mW(false);
            this.gXo.mV(false);
        } else if (view == this.gXo.bxx()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gXp.a(9, true, this.gXr);
            } else {
                this.gXp.a(9, false, this.gXr);
            }
        } else if (view == this.gXo.bxy()) {
            this.gXp.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gXr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gXo.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gXq == null) {
            this.gXq = new OfficialAccountPushModel(this.gXs);
        }
        this.gXq.byx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gXq != null) {
            this.gXq.onDestroy();
        }
    }
}
