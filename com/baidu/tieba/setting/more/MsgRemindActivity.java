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
    private ar cbn;
    private aj cbo;
    private am cbp = new ae(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cbn = new ar(this);
        this.cbn.b(this);
        this.cbo = new aj(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cbn.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.cbn.ahz()) {
            this.cbo.a(6, switchState == BdSwitchView.SwitchState.ON, this.cbp);
        } else if (view == this.cbn.ahA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().setSignAlertOn(true);
                this.cbn.ahx();
                this.cbn.et(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.vw().setSignAlertOn(false);
            this.cbn.et(false);
        } else if (view == this.cbn.ahB()) {
            this.cbo.a(14, switchState == BdSwitchView.SwitchState.ON, this.cbp);
        } else if (view == this.cbn.ahD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().at(true);
                this.cbn.es(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.vw().at(false);
            this.cbn.es(false);
        } else if (view == this.cbn.ahH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().aw(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().aw(false);
            }
        } else if (view == this.cbn.ahI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().au(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().au(false);
            }
        } else if (view == this.cbn.ahJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().av(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().av(false);
            }
        } else if (view == this.cbn.ahK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().ay(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().ay(false);
            }
        } else if (view == this.cbn.ahL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().ax(true);
                MsgRemindStatic.s(3, true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.vw().ax(false);
            MsgRemindStatic.s(3, false);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.cbn.aeH().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cbn.aeH()) {
            if (this.cbn.cce) {
                finish();
            } else {
                this.cbn.ev(true);
            }
        } else if (view == this.cbn.ahC()) {
            showDialog(com.baidu.tieba.v.sign_remind);
        } else if (view == this.cbn.ahE()) {
            this.cbn.ev(false);
        } else if (view == this.cbn.ahF()) {
            showDialog(com.baidu.tieba.v.no_disturb_start_time);
        } else if (view == this.cbn.ahG()) {
            showDialog(com.baidu.tieba.v.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.cbn.cce) {
                    finish();
                    return true;
                }
                this.cbn.ev(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == com.baidu.tieba.v.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.vw().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.vw().getSignAlertMins());
                return;
            } else if (i == com.baidu.tieba.v.no_disturb_start_time || i == com.baidu.tieba.v.no_disturb_end_time) {
                if (i == com.baidu.tieba.v.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.vw().vJ().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.vw().vK().split(":");
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
        if (i == com.baidu.tieba.v.sign_remind) {
            aVar.setTitle(com.baidu.tieba.y.sign_remind);
        } else if (i == com.baidu.tieba.v.no_disturb_end_time) {
            aVar.setTitle(com.baidu.tieba.y.no_disturb_end_time);
        } else if (i == com.baidu.tieba.v.no_disturb_start_time) {
            aVar.setTitle(com.baidu.tieba.y.no_disturb_start_time);
        }
        aVar.setButton(-1, getPageContext().getString(com.baidu.tieba.y.alert_yes_button), aVar);
        aVar.setButton(-2, getPageContext().getString(com.baidu.tieba.y.alert_no_button), aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.vw().vx();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.cbn.ahM()) {
            this.cbo.a(1, z, this.cbp);
        } else if (compoundButton == this.cbn.ahN()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.vw().ar(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vw().vB() && !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vE() && !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vC() && !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vD() && !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vM() && !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vL() && !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vA()) {
                this.cbp.a(14, true, false);
            }
        } else if (compoundButton == this.cbn.ahO()) {
            this.cbo.a(2, z, this.cbp);
        } else if (compoundButton == this.cbn.ahP()) {
            this.cbo.a(5, z, this.cbp);
        } else if (compoundButton == this.cbn.ahQ()) {
            this.cbo.a(4, z, this.cbp);
        } else if (compoundButton == this.cbn.ahR()) {
            this.cbo.a(3, z, this.cbp);
        } else if (compoundButton == this.cbn.ahS()) {
            this.cbo.a(23, z, this.cbp);
        }
    }
}
