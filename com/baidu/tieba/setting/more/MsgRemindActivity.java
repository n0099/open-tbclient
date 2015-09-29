package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.model.g;
/* loaded from: classes.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, BdSwitchView.a {
    private g.a cLA = new z(this);
    private ae cNt;
    private com.baidu.tieba.setting.model.g cNu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cNt = new ae(this);
        this.cNt.b(this);
        this.cNu = new com.baidu.tieba.setting.model.g(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cNt.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.cNt.ast()) {
            this.cNu.a(6, switchState == BdSwitchView.SwitchState.ON, this.cLA);
        } else if (view == this.cNt.asu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().setSignAlertOn(true);
                this.cNt.asq();
                this.cNt.ga(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xh().setSignAlertOn(false);
            this.cNt.ga(false);
        } else if (view == this.cNt.asv()) {
            this.cNu.a(14, switchState == BdSwitchView.SwitchState.ON, this.cLA);
        } else if (view == this.cNt.asx()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aD(true);
                this.cNt.fZ(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xh().aD(false);
            this.cNt.fZ(false);
        } else if (view == this.cNt.asB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aG(false);
            }
        } else if (view == this.cNt.asC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aE(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aE(false);
            }
        } else if (view == this.cNt.asD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aF(false);
            }
        } else if (view == this.cNt.asE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aI(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aI(false);
            }
        } else if (view == this.cNt.asF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aH(true);
                SettingStatic.r(3, true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xh().aH(false);
            SettingStatic.r(3, false);
        } else if (view == this.cNt.ass()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aM(true);
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10308").r("obj_type", 1));
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aM(false);
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10308").r("obj_type", 0));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH));
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.cNt.akd().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cNt.akd()) {
            if (this.cNt.cOa) {
                finish();
            } else {
                this.cNt.gc(true);
            }
        } else if (view == this.cNt.asw()) {
            showDialog(i.f.sign_remind);
        } else if (view == this.cNt.asy()) {
            this.cNt.gc(false);
        } else if (view == this.cNt.asz()) {
            showDialog(i.f.no_disturb_start_time);
        } else if (view == this.cNt.asA()) {
            showDialog(i.f.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.cNt.cOa) {
                    finish();
                    return true;
                }
                this.cNt.gc(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == i.f.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertMins());
                return;
            } else if (i == i.f.no_disturb_start_time || i == i.f.no_disturb_end_time) {
                if (i == i.f.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.xh().xu().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.xh().xv().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            } else {
                return;
            }
        }
        super.onPrepareDialog(i, dialog);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new ad(this, i), 0, 0, true);
        if (i == i.f.sign_remind) {
            aVar.setTitle(i.h.sign_remind);
        } else if (i == i.f.no_disturb_end_time) {
            aVar.setTitle(i.h.no_disturb_end_time);
        } else if (i == i.f.no_disturb_start_time) {
            aVar.setTitle(i.h.no_disturb_start_time);
        }
        aVar.setButton(-1, getPageContext().getString(i.h.alert_yes_button), aVar);
        aVar.setButton(-2, getPageContext().getString(i.h.alert_no_button), aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.xh().xi();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.cNt.asG()) {
            this.cNu.a(1, z, this.cLA);
        } else if (compoundButton == this.cNt.asH()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.xh().aB(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xh().xm() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xn() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xo() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xx() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xw()) {
                this.cLA.a(14, true, false);
            }
        } else if (compoundButton == this.cNt.asI()) {
            this.cNu.a(2, z, this.cLA);
        } else if (compoundButton == this.cNt.asJ()) {
            this.cNu.a(5, z, this.cLA);
        } else if (compoundButton == this.cNt.asK()) {
            this.cNu.a(4, z, this.cLA);
        } else if (compoundButton == this.cNt.asL()) {
            this.cNu.a(3, z, this.cLA);
        }
    }
}
