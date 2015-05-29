package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, com.baidu.adp.widget.BdSwitchView.b {
    private ar cfP;
    private aj cfQ;
    private am cfR = new ae(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cfP = new ar(this);
        this.cfP.b(this);
        this.cfQ = new aj(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cfP.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.cfP.ajq()) {
            this.cfQ.a(6, switchState == BdSwitchView.SwitchState.ON, this.cfR);
        } else if (view == this.cfP.ajr()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().setSignAlertOn(true);
                this.cfP.ajo();
                this.cfP.eN(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.wg().setSignAlertOn(false);
            this.cfP.eN(false);
        } else if (view == this.cfP.ajs()) {
            this.cfQ.a(14, switchState == BdSwitchView.SwitchState.ON, this.cfR);
        } else if (view == this.cfP.aju()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aA(true);
                this.cfP.eM(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.wg().aA(false);
            this.cfP.eM(false);
        } else if (view == this.cfP.ajy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aD(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aD(false);
            }
        } else if (view == this.cfP.ajz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aB(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aB(false);
            }
        } else if (view == this.cfP.ajA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aC(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aC(false);
            }
        } else if (view == this.cfP.ajB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aF(false);
            }
        } else if (view == this.cfP.ajC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aE(true);
                MsgRemindStatic.r(3, true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.wg().aE(false);
            MsgRemindStatic.r(3, false);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.cfP.afN().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cfP.afN()) {
            if (this.cfP.cgG) {
                finish();
            } else {
                this.cfP.eP(true);
            }
        } else if (view == this.cfP.ajt()) {
            showDialog(com.baidu.tieba.q.sign_remind);
        } else if (view == this.cfP.ajv()) {
            this.cfP.eP(false);
        } else if (view == this.cfP.ajw()) {
            showDialog(com.baidu.tieba.q.no_disturb_start_time);
        } else if (view == this.cfP.ajx()) {
            showDialog(com.baidu.tieba.q.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.cfP.cgG) {
                    finish();
                    return true;
                }
                this.cfP.eP(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == com.baidu.tieba.q.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.wg().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.wg().getSignAlertMins());
                return;
            } else if (i == com.baidu.tieba.q.no_disturb_start_time || i == com.baidu.tieba.q.no_disturb_end_time) {
                if (i == com.baidu.tieba.q.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.wg().wt().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.wg().wu().split(":");
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
        com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new ai(this, i), 0, 0, true);
        if (i == com.baidu.tieba.q.sign_remind) {
            aVar.setTitle(com.baidu.tieba.t.sign_remind);
        } else if (i == com.baidu.tieba.q.no_disturb_end_time) {
            aVar.setTitle(com.baidu.tieba.t.no_disturb_end_time);
        } else if (i == com.baidu.tieba.q.no_disturb_start_time) {
            aVar.setTitle(com.baidu.tieba.t.no_disturb_start_time);
        }
        aVar.setButton(-1, getPageContext().getString(com.baidu.tieba.t.alert_yes_button), aVar);
        aVar.setButton(-2, getPageContext().getString(com.baidu.tieba.t.alert_no_button), aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.wg().wh();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.cfP.ajD()) {
            this.cfQ.a(1, z, this.cfR);
        } else if (compoundButton == this.cfP.ajE()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.wg().ay(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wl() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wm() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wn() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().ww() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk()) {
                this.cfR.a(14, true, false);
            }
        } else if (compoundButton == this.cfP.ajF()) {
            this.cfQ.a(2, z, this.cfR);
        } else if (compoundButton == this.cfP.ajG()) {
            this.cfQ.a(5, z, this.cfR);
        } else if (compoundButton == this.cfP.ajH()) {
            this.cfQ.a(4, z, this.cfR);
        } else if (compoundButton == this.cfP.ajI()) {
            this.cfQ.a(3, z, this.cfR);
        } else if (compoundButton == this.cfP.ajJ()) {
            this.cfQ.a(23, z, this.cfR);
        }
    }
}
