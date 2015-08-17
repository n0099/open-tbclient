package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.model.g;
/* loaded from: classes.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, BdSwitchView.a {
    private g.a cwd = new z(this);
    private ae cxV;
    private com.baidu.tieba.setting.model.g cxW;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cxV = new ae(this);
        this.cxV.b(this);
        this.cxW = new com.baidu.tieba.setting.model.g(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cxV.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.cxV.alS()) {
            this.cxW.a(6, switchState == BdSwitchView.SwitchState.ON, this.cwd);
        } else if (view == this.cxV.alT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().setSignAlertOn(true);
                this.cxV.alQ();
                this.cxV.fe(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xq().setSignAlertOn(false);
            this.cxV.fe(false);
        } else if (view == this.cxV.alU()) {
            this.cxW.a(14, switchState == BdSwitchView.SwitchState.ON, this.cwd);
        } else if (view == this.cxV.alW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aE(true);
                this.cxV.fd(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xq().aE(false);
            this.cxV.fd(false);
        } else if (view == this.cxV.ama()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aH(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aH(false);
            }
        } else if (view == this.cxV.amb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aF(false);
            }
        } else if (view == this.cxV.amc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aG(false);
            }
        } else if (view == this.cxV.amd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aJ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aJ(false);
            }
        } else if (view == this.cxV.ame()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aI(true);
                SettingStatic.p(3, true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xq().aI(false);
            SettingStatic.p(3, false);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.cxV.ahK().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cxV.ahK()) {
            if (this.cxV.cyB) {
                finish();
            } else {
                this.cxV.fg(true);
            }
        } else if (view == this.cxV.alV()) {
            showDialog(i.f.sign_remind);
        } else if (view == this.cxV.alX()) {
            this.cxV.fg(false);
        } else if (view == this.cxV.alY()) {
            showDialog(i.f.no_disturb_start_time);
        } else if (view == this.cxV.alZ()) {
            showDialog(i.f.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.cxV.cyB) {
                    finish();
                    return true;
                }
                this.cxV.fg(true);
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
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.xq().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.xq().getSignAlertMins());
                return;
            } else if (i == i.f.no_disturb_start_time || i == i.f.no_disturb_end_time) {
                if (i == i.f.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.xq().xD().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.xq().xE().split(":");
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
            aVar.setTitle(i.C0057i.sign_remind);
        } else if (i == i.f.no_disturb_end_time) {
            aVar.setTitle(i.C0057i.no_disturb_end_time);
        } else if (i == i.f.no_disturb_start_time) {
            aVar.setTitle(i.C0057i.no_disturb_start_time);
        }
        aVar.setButton(-1, getPageContext().getString(i.C0057i.alert_yes_button), aVar);
        aVar.setButton(-2, getPageContext().getString(i.C0057i.alert_no_button), aVar);
        return aVar;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.xq().xr();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.cxV.amf()) {
            this.cxW.a(1, z, this.cwd);
        } else if (compoundButton == this.cxV.amg()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.xq().aC(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xq().xv() && !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xy() && !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xw() && !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xx() && !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xG() && !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xF()) {
                this.cwd.a(14, true, false);
            }
        } else if (compoundButton == this.cxV.amh()) {
            this.cxW.a(2, z, this.cwd);
        } else if (compoundButton == this.cxV.ami()) {
            this.cxW.a(5, z, this.cwd);
        } else if (compoundButton == this.cxV.amj()) {
            this.cxW.a(4, z, this.cwd);
        } else if (compoundButton == this.cxV.amk()) {
            this.cxW.a(3, z, this.cwd);
        }
    }
}
