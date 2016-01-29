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
    private g.a dIX = new ac(this);
    private ah dLb;
    private com.baidu.tieba.setting.model.g dLc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dLb = new ah(this);
        this.dLb.b(this);
        this.dLc = new com.baidu.tieba.setting.model.g(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dLb.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.dLb.aHQ()) {
            this.dLc.a(6, switchState == BdSwitchView.SwitchState.ON, this.dIX);
        } else if (view == this.dLb.aHR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().setSignAlertOn(true);
                this.dLb.aHN();
                this.dLb.hB(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.zk().setSignAlertOn(false);
            this.dLb.hB(false);
        } else if (view == this.dLb.aHS()) {
            this.dLc.a(14, switchState == BdSwitchView.SwitchState.ON, this.dIX);
        } else if (view == this.dLb.aHU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aG(true);
                this.dLb.hA(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.zk().aG(false);
            this.dLb.hA(false);
        } else if (view == this.dLb.aHY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aJ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aJ(false);
            }
        } else if (view == this.dLb.aHZ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aH(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aH(false);
            }
        } else if (view == this.dLb.aIa()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aI(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aI(false);
            }
        } else if (view == this.dLb.aIb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aL(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aL(false);
            }
        } else if (view == this.dLb.aIc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aK(true);
                SettingStatic.v(3, true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.zk().aK(false);
            SettingStatic.v(3, false);
        } else if (view == this.dLb.aHP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aP(true);
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10308").r("obj_type", 1));
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aP(false);
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10308").r("obj_type", 0));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH));
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.dLb.awm().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dLb.awm()) {
            if (this.dLb.dLI) {
                finish();
            } else {
                this.dLb.hD(true);
            }
        } else if (view == this.dLb.aHT()) {
            showDialog(t.g.sign_remind);
        } else if (view == this.dLb.aHV()) {
            this.dLb.hD(false);
        } else if (view == this.dLb.aHW()) {
            showDialog(t.g.no_disturb_start_time);
        } else if (view == this.dLb.aHX()) {
            showDialog(t.g.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.dLb.dLI) {
                    finish();
                    return true;
                }
                this.dLb.hD(true);
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
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.zk().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.zk().getSignAlertMins());
                return;
            } else if (i == t.g.no_disturb_start_time || i == t.g.no_disturb_end_time) {
                if (i == t.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.zk().zx().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.zk().zy().split(":");
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
        if (i == t.g.sign_remind) {
            aVar.setTitle(t.j.sign_remind);
        } else if (i == t.g.no_disturb_end_time) {
            aVar.setTitle(t.j.no_disturb_end_time);
        } else if (i == t.g.no_disturb_start_time) {
            aVar.setTitle(t.j.no_disturb_start_time);
        }
        aVar.setButton(-1, getPageContext().getString(t.j.alert_yes_button), aVar);
        aVar.setButton(-2, getPageContext().getString(t.j.alert_no_button), aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.zk().zl();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.dLb.aId()) {
            this.dLc.a(1, z, this.dIX);
        } else if (compoundButton == this.dLb.aIe()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.zk().aE(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zp() && !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zs() && !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zq() && !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zr() && !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zA() && !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zz()) {
                this.dIX.a(14, true, false);
            }
        } else if (compoundButton == this.dLb.aIf()) {
            this.dLc.a(2, z, this.dIX);
        } else if (compoundButton == this.dLb.aIg()) {
            this.dLc.a(5, z, this.dIX);
        } else if (compoundButton == this.dLb.aIh()) {
            this.dLc.a(4, z, this.dIX);
        } else if (compoundButton == this.dLb.aIi()) {
            this.dLc.a(3, z, this.dIX);
        }
    }
}
