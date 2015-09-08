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
    private g.a cEz = new z(this);
    private ae cGs;
    private com.baidu.tieba.setting.model.g cGt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cGs = new ae(this);
        this.cGs.b(this);
        this.cGt = new com.baidu.tieba.setting.model.g(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cGs.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.cGs.aqb()) {
            this.cGt.a(6, switchState == BdSwitchView.SwitchState.ON, this.cEz);
        } else if (view == this.cGs.aqc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().setSignAlertOn(true);
                this.cGs.apY();
                this.cGs.fP(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xw().setSignAlertOn(false);
            this.cGs.fP(false);
        } else if (view == this.cGs.aqd()) {
            this.cGt.a(14, switchState == BdSwitchView.SwitchState.ON, this.cEz);
        } else if (view == this.cGs.aqf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aE(true);
                this.cGs.fO(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xw().aE(false);
            this.cGs.fO(false);
        } else if (view == this.cGs.aqj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aH(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aH(false);
            }
        } else if (view == this.cGs.aqk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aF(false);
            }
        } else if (view == this.cGs.aql()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aG(false);
            }
        } else if (view == this.cGs.aqm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aJ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aJ(false);
            }
        } else if (view == this.cGs.aqn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aI(true);
                SettingStatic.q(3, true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xw().aI(false);
            SettingStatic.q(3, false);
        } else if (view == this.cGs.aqa()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aN(true);
                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10308").r("obj_type", 1));
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aN(false);
                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10308").r("obj_type", 0));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH));
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.cGs.aic().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cGs.aic()) {
            if (this.cGs.cGZ) {
                finish();
            } else {
                this.cGs.fR(true);
            }
        } else if (view == this.cGs.aqe()) {
            showDialog(i.f.sign_remind);
        } else if (view == this.cGs.aqg()) {
            this.cGs.fR(false);
        } else if (view == this.cGs.aqh()) {
            showDialog(i.f.no_disturb_start_time);
        } else if (view == this.cGs.aqi()) {
            showDialog(i.f.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.cGs.cGZ) {
                    finish();
                    return true;
                }
                this.cGs.fR(true);
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
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.xw().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.xw().getSignAlertMins());
                return;
            } else if (i == i.f.no_disturb_start_time || i == i.f.no_disturb_end_time) {
                if (i == i.f.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.xw().xJ().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.xw().xK().split(":");
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
        com.baidu.tbadk.coreExtra.messageCenter.c.xw().xx();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.cGs.aqo()) {
            this.cGt.a(1, z, this.cEz);
        } else if (compoundButton == this.cGs.aqp()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.xw().aC(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xw().xB() && !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xE() && !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xC() && !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xD() && !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xM() && !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xL()) {
                this.cEz.a(14, true, false);
            }
        } else if (compoundButton == this.cGs.aqq()) {
            this.cGt.a(2, z, this.cEz);
        } else if (compoundButton == this.cGs.aqr()) {
            this.cGt.a(5, z, this.cEz);
        } else if (compoundButton == this.cGs.aqs()) {
            this.cGt.a(4, z, this.cEz);
        } else if (compoundButton == this.cGs.aqt()) {
            this.cGt.a(3, z, this.cEz);
        }
    }
}
