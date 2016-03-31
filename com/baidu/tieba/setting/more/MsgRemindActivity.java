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
import com.baidu.tieba.setting.model.g;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, BdSwitchView.a {
    private g.a ebr = new ae(this);
    private aj edy;
    private com.baidu.tieba.setting.model.g edz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.edy = new aj(this);
        this.edy.b(this);
        this.edz = new com.baidu.tieba.setting.model.g(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.edy.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.edy.aOE()) {
            this.edz.a(6, switchState == BdSwitchView.SwitchState.ON, this.ebr);
        } else if (view == this.edy.aOG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().setSignAlertOn(true);
                this.edy.aOB();
                this.edy.iq(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.zM().setSignAlertOn(false);
            this.edy.iq(false);
        } else if (view == this.edy.aOH()) {
            this.edz.a(14, switchState == BdSwitchView.SwitchState.ON, this.ebr);
        } else if (view == this.edy.aOJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aL(true);
                this.edy.ip(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.zM().aL(false);
            this.edy.ip(false);
        } else if (view == this.edy.aON()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aO(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aO(false);
            }
        } else if (view == this.edy.aOO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aM(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aM(false);
            }
        } else if (view == this.edy.aOP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aN(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aN(false);
            }
        } else if (view == this.edy.aOQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aQ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aQ(false);
            }
        } else if (view == this.edy.aOR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aP(true);
                SettingStatic.v(3, true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.zM().aP(false);
            SettingStatic.v(3, false);
        } else if (view == this.edy.aOD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aU(true);
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10308").r("obj_type", 1));
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aU(false);
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10308").r("obj_type", 0));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH));
        } else if (view == this.edy.aOF()) {
            this.edz.a(7, switchState == BdSwitchView.SwitchState.OFF, this.ebr);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.edy.aDR().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.edy.aDR()) {
            if (this.edy.eeg) {
                finish();
            } else {
                this.edy.is(true);
            }
        } else if (view == this.edy.aOI()) {
            showDialog(t.g.sign_remind);
        } else if (view == this.edy.aOK()) {
            this.edy.is(false);
        } else if (view == this.edy.aOL()) {
            showDialog(t.g.no_disturb_start_time);
        } else if (view == this.edy.aOM()) {
            showDialog(t.g.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.edy.eeg) {
                    finish();
                    return true;
                }
                this.edy.is(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == t.g.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.zM().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.zM().getSignAlertMins());
                return;
            } else if (i == t.g.no_disturb_start_time || i == t.g.no_disturb_end_time) {
                if (i == t.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.zM().zZ().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.zM().Aa().split(":");
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
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new ai(this, i), 0, 0, true);
        if (i == t.g.sign_remind) {
            bVar.setTitle(t.j.sign_remind);
        } else if (i == t.g.no_disturb_end_time) {
            bVar.setTitle(t.j.no_disturb_end_time);
        } else if (i == t.g.no_disturb_start_time) {
            bVar.setTitle(t.j.no_disturb_start_time);
        }
        bVar.setButton(-1, getPageContext().getString(t.j.alert_yes_button), bVar);
        bVar.setButton(-2, getPageContext().getString(t.j.alert_no_button), bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.zM().zN();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.edy.aOS()) {
            this.edz.a(1, z, this.ebr);
        } else if (compoundButton == this.edy.aOT()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.zM().aJ(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().zR() && !com.baidu.tbadk.coreExtra.messageCenter.c.zM().zU() && !com.baidu.tbadk.coreExtra.messageCenter.c.zM().zS() && !com.baidu.tbadk.coreExtra.messageCenter.c.zM().zT() && !com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ac() && !com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ab()) {
                this.ebr.a(14, true, false);
            }
        } else if (compoundButton == this.edy.aOU()) {
            this.edz.a(2, z, this.ebr);
        } else if (compoundButton == this.edy.aOV()) {
            this.edz.a(5, z, this.ebr);
        } else if (compoundButton == this.edy.aOW()) {
            this.edz.a(4, z, this.ebr);
        } else if (compoundButton == this.edy.aOX()) {
            this.edz.a(3, z, this.ebr);
        }
    }
}
