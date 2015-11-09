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
    private g.a cNv = new z(this);
    private ae cPo;
    private com.baidu.tieba.setting.model.g cPp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cPo = new ae(this);
        this.cPo.b(this);
        this.cPp = new com.baidu.tieba.setting.model.g(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cPo.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.cPo.atb()) {
            this.cPp.a(6, switchState == BdSwitchView.SwitchState.ON, this.cNv);
        } else if (view == this.cPo.atc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().setSignAlertOn(true);
                this.cPo.asY();
                this.cPo.gd(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xj().setSignAlertOn(false);
            this.cPo.gd(false);
        } else if (view == this.cPo.atd()) {
            this.cPp.a(14, switchState == BdSwitchView.SwitchState.ON, this.cNv);
        } else if (view == this.cPo.atf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aD(true);
                this.cPo.gc(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xj().aD(false);
            this.cPo.gc(false);
        } else if (view == this.cPo.atj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aG(false);
            }
        } else if (view == this.cPo.atk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aE(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aE(false);
            }
        } else if (view == this.cPo.atl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aF(false);
            }
        } else if (view == this.cPo.atm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aI(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aI(false);
            }
        } else if (view == this.cPo.atn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aH(true);
                SettingStatic.r(3, true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xj().aH(false);
            SettingStatic.r(3, false);
        } else if (view == this.cPo.ata()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aM(true);
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10308").r("obj_type", 1));
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aM(false);
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10308").r("obj_type", 0));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH));
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.cPo.akF().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cPo.akF()) {
            if (this.cPo.cPV) {
                finish();
            } else {
                this.cPo.gf(true);
            }
        } else if (view == this.cPo.ate()) {
            showDialog(i.f.sign_remind);
        } else if (view == this.cPo.atg()) {
            this.cPo.gf(false);
        } else if (view == this.cPo.ath()) {
            showDialog(i.f.no_disturb_start_time);
        } else if (view == this.cPo.ati()) {
            showDialog(i.f.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.cPo.cPV) {
                    finish();
                    return true;
                }
                this.cPo.gf(true);
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
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.xj().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.xj().getSignAlertMins());
                return;
            } else if (i == i.f.no_disturb_start_time || i == i.f.no_disturb_end_time) {
                if (i == i.f.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.xj().xw().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.xj().xx().split(":");
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
        com.baidu.tbadk.coreExtra.messageCenter.c.xj().xk();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.cPo.ato()) {
            this.cPp.a(1, z, this.cNv);
        } else if (compoundButton == this.cPo.atp()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.xj().aB(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xo() && !com.baidu.tbadk.coreExtra.messageCenter.c.xj().xr() && !com.baidu.tbadk.coreExtra.messageCenter.c.xj().xp() && !com.baidu.tbadk.coreExtra.messageCenter.c.xj().xq() && !com.baidu.tbadk.coreExtra.messageCenter.c.xj().xz() && !com.baidu.tbadk.coreExtra.messageCenter.c.xj().xy()) {
                this.cNv.a(14, true, false);
            }
        } else if (compoundButton == this.cPo.atq()) {
            this.cPp.a(2, z, this.cNv);
        } else if (compoundButton == this.cPo.atr()) {
            this.cPp.a(5, z, this.cNv);
        } else if (compoundButton == this.cPo.ats()) {
            this.cPp.a(4, z, this.cNv);
        } else if (compoundButton == this.cPo.att()) {
            this.cPp.a(3, z, this.cNv);
        }
    }
}
