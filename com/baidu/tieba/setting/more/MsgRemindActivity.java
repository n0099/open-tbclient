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
import com.baidu.tieba.n;
import com.baidu.tieba.setting.model.g;
/* loaded from: classes.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, BdSwitchView.a {
    private g.a dsT = new ac(this);
    private ah duX;
    private com.baidu.tieba.setting.model.g duY;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.duX = new ah(this);
        this.duX.b(this);
        this.duY = new com.baidu.tieba.setting.model.g(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.duX.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.duX.aAJ()) {
            this.duY.a(6, switchState == BdSwitchView.SwitchState.ON, this.dsT);
        } else if (view == this.duX.aAK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().setSignAlertOn(true);
                this.duX.aAG();
                this.duX.hb(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xS().setSignAlertOn(false);
            this.duX.hb(false);
        } else if (view == this.duX.aAL()) {
            this.duY.a(14, switchState == BdSwitchView.SwitchState.ON, this.dsT);
        } else if (view == this.duX.aAN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aF(true);
                this.duX.ha(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aF(false);
            this.duX.ha(false);
        } else if (view == this.duX.aAR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aI(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aI(false);
            }
        } else if (view == this.duX.aAS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aG(false);
            }
        } else if (view == this.duX.aAT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aH(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aH(false);
            }
        } else if (view == this.duX.aAU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aK(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aK(false);
            }
        } else if (view == this.duX.aAV()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aJ(true);
                SettingStatic.t(3, true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aJ(false);
            SettingStatic.t(3, false);
        } else if (view == this.duX.aAI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aO(true);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10308").r("obj_type", 1));
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aO(false);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10308").r("obj_type", 0));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH));
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.duX.aqV().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.duX.aqV()) {
            if (this.duX.dvE) {
                finish();
            } else {
                this.duX.hd(true);
            }
        } else if (view == this.duX.aAM()) {
            showDialog(n.g.sign_remind);
        } else if (view == this.duX.aAO()) {
            this.duX.hd(false);
        } else if (view == this.duX.aAP()) {
            showDialog(n.g.no_disturb_start_time);
        } else if (view == this.duX.aAQ()) {
            showDialog(n.g.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.duX.dvE) {
                    finish();
                    return true;
                }
                this.duX.hd(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == n.g.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.xS().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.xS().getSignAlertMins());
                return;
            } else if (i == n.g.no_disturb_start_time || i == n.g.no_disturb_end_time) {
                if (i == n.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.xS().yf().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.xS().yg().split(":");
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
        com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new ag(this, i), 0, 0, true);
        if (i == n.g.sign_remind) {
            aVar.setTitle(n.j.sign_remind);
        } else if (i == n.g.no_disturb_end_time) {
            aVar.setTitle(n.j.no_disturb_end_time);
        } else if (i == n.g.no_disturb_start_time) {
            aVar.setTitle(n.j.no_disturb_start_time);
        }
        aVar.setButton(-1, getPageContext().getString(n.j.alert_yes_button), aVar);
        aVar.setButton(-2, getPageContext().getString(n.j.alert_no_button), aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.xS().xT();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.duX.aAW()) {
            this.duY.a(1, z, this.dsT);
        } else if (compoundButton == this.duX.aAX()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aD(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xS().xX() && !com.baidu.tbadk.coreExtra.messageCenter.c.xS().ya() && !com.baidu.tbadk.coreExtra.messageCenter.c.xS().xY() && !com.baidu.tbadk.coreExtra.messageCenter.c.xS().xZ() && !com.baidu.tbadk.coreExtra.messageCenter.c.xS().yi() && !com.baidu.tbadk.coreExtra.messageCenter.c.xS().yh()) {
                this.dsT.a(14, true, false);
            }
        } else if (compoundButton == this.duX.aAY()) {
            this.duY.a(2, z, this.dsT);
        } else if (compoundButton == this.duX.aAZ()) {
            this.duY.a(5, z, this.dsT);
        } else if (compoundButton == this.duX.aBa()) {
            this.duY.a(4, z, this.dsT);
        } else if (compoundButton == this.duX.aBb()) {
            this.duY.a(3, z, this.dsT);
        }
    }
}
