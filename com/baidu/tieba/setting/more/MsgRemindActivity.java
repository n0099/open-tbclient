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
    private ar cfQ;
    private aj cfR;
    private am cfS = new ae(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cfQ = new ar(this);
        this.cfQ.b(this);
        this.cfR = new aj(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cfQ.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.cfQ.ajr()) {
            this.cfR.a(6, switchState == BdSwitchView.SwitchState.ON, this.cfS);
        } else if (view == this.cfQ.ajs()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().setSignAlertOn(true);
                this.cfQ.ajp();
                this.cfQ.eN(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.wg().setSignAlertOn(false);
            this.cfQ.eN(false);
        } else if (view == this.cfQ.ajt()) {
            this.cfR.a(14, switchState == BdSwitchView.SwitchState.ON, this.cfS);
        } else if (view == this.cfQ.ajv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aA(true);
                this.cfQ.eM(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.wg().aA(false);
            this.cfQ.eM(false);
        } else if (view == this.cfQ.ajz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aD(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aD(false);
            }
        } else if (view == this.cfQ.ajA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aB(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aB(false);
            }
        } else if (view == this.cfQ.ajB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aC(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aC(false);
            }
        } else if (view == this.cfQ.ajC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aF(false);
            }
        } else if (view == this.cfQ.ajD()) {
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
        this.cfQ.afO().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cfQ.afO()) {
            if (this.cfQ.cgH) {
                finish();
            } else {
                this.cfQ.eP(true);
            }
        } else if (view == this.cfQ.aju()) {
            showDialog(com.baidu.tieba.q.sign_remind);
        } else if (view == this.cfQ.ajw()) {
            this.cfQ.eP(false);
        } else if (view == this.cfQ.ajx()) {
            showDialog(com.baidu.tieba.q.no_disturb_start_time);
        } else if (view == this.cfQ.ajy()) {
            showDialog(com.baidu.tieba.q.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.cfQ.cgH) {
                    finish();
                    return true;
                }
                this.cfQ.eP(true);
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
        if (compoundButton == this.cfQ.ajE()) {
            this.cfR.a(1, z, this.cfS);
        } else if (compoundButton == this.cfQ.ajF()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.wg().ay(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wl() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wm() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wn() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().ww() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk()) {
                this.cfS.a(14, true, false);
            }
        } else if (compoundButton == this.cfQ.ajG()) {
            this.cfR.a(2, z, this.cfS);
        } else if (compoundButton == this.cfQ.ajH()) {
            this.cfR.a(5, z, this.cfS);
        } else if (compoundButton == this.cfQ.ajI()) {
            this.cfR.a(4, z, this.cfS);
        } else if (compoundButton == this.cfQ.ajJ()) {
            this.cfR.a(3, z, this.cfS);
        } else if (compoundButton == this.cfQ.ajK()) {
            this.cfR.a(23, z, this.cfS);
        }
    }
}
