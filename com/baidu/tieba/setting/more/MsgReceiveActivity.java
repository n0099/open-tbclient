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
    private OfficialAccountPushModel gQA;
    private MsgRemindModel.a gQB = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gQy.bvE().nR();
                        MsgReceiveActivity.this.gQy.mT(false);
                        MsgReceiveActivity.this.gQy.mS(false);
                        return;
                    }
                    MsgReceiveActivity.this.gQy.bvE().nQ();
                    MsgReceiveActivity.this.gQy.mT(true);
                    MsgReceiveActivity.this.gQy.mS(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gQy.bvF().nR();
                    } else {
                        MsgReceiveActivity.this.gQy.bvF().nQ();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hs().cb(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gQy.bvG().nR();
                } else {
                    MsgReceiveActivity.this.gQy.bvG().nQ();
                }
            }
        }
    };
    private OfficialAccountPushModel.a gQC = new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.2
        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            if (i == OfficialAccountPushModel.NET_SUCCESS && MsgReceiveActivity.this.gQy != null) {
                MsgReceiveActivity.this.gQy.au(arrayList);
            }
        }
    };
    private e gQy;
    private MsgRemindModel gQz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gQy = new e(this);
        this.gQy.init();
        this.gQz = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gQy.aQP()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gQy.bvE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gQz.a(8, true, this.gQB);
                this.gQy.mT(true);
                this.gQy.mS(true);
                return;
            }
            this.gQz.a(8, false, this.gQB);
            this.gQy.mT(false);
            this.gQy.mS(false);
        } else if (view == this.gQy.bvF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gQz.a(9, true, this.gQB);
            } else {
                this.gQz.a(9, false, this.gQB);
            }
        } else if (view == this.gQy.bvG()) {
            this.gQz.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gQB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gQy.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gQA == null) {
            this.gQA = new OfficialAccountPushModel(this.gQC);
        }
        this.gQA.bwF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gQA != null) {
            this.gQA.onDestroy();
        }
    }
}
