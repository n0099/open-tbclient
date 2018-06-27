package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgReceiveActivity extends BaseActivity<MsgReceiveActivity> implements BdSwitchView.a {
    private e gzg;
    private MsgRemindModel gzh;
    private MsgRemindModel.a gzi = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgReceiveActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void c(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gzg.brM().mB();
                        MsgReceiveActivity.this.gzg.mi(false);
                        MsgReceiveActivity.this.gzg.mh(false);
                        return;
                    }
                    MsgReceiveActivity.this.gzg.brM().mA();
                    MsgReceiveActivity.this.gzg.mi(true);
                    MsgReceiveActivity.this.gzg.mh(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgReceiveActivity.this.gzg.brN().mB();
                    } else {
                        MsgReceiveActivity.this.gzg.brN().mA();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DW().bq(z2);
                } else if (z2) {
                    MsgReceiveActivity.this.gzg.brO().mB();
                } else {
                    MsgReceiveActivity.this.gzg.brO().mA();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gzg = new e(this);
        this.gzg.init();
        this.gzh = new MsgRemindModel(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gzg.aKQ()) {
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gzg.brM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gzh.a(8, true, this.gzi);
                this.gzg.mi(true);
                this.gzg.mh(true);
                return;
            }
            this.gzh.a(8, false, this.gzi);
            this.gzg.mi(false);
            this.gzg.mh(false);
        } else if (view == this.gzg.brN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gzh.a(9, true, this.gzi);
            } else {
                this.gzh.a(9, false, this.gzi);
            }
        } else if (view == this.gzg.brO()) {
            this.gzh.a(7, switchState == BdSwitchView.SwitchState.OFF, this.gzi);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gzg.onChangeSkinType(i);
    }
}
