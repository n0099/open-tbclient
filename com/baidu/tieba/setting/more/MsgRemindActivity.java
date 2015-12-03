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
    private g.a dlM = new ab(this);
    private ag dnK;
    private com.baidu.tieba.setting.model.g dnL;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dnK = new ag(this);
        this.dnK.b(this);
        this.dnL = new com.baidu.tieba.setting.model.g(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dnK.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.dnK.ayD()) {
            this.dnL.a(6, switchState == BdSwitchView.SwitchState.ON, this.dlM);
        } else if (view == this.dnK.ayE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().setSignAlertOn(true);
                this.dnK.ayA();
                this.dnK.gT(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.yg().setSignAlertOn(false);
            this.dnK.gT(false);
        } else if (view == this.dnK.ayF()) {
            this.dnL.a(14, switchState == BdSwitchView.SwitchState.ON, this.dlM);
        } else if (view == this.dnK.ayH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aI(true);
                this.dnK.gS(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.yg().aI(false);
            this.dnK.gS(false);
        } else if (view == this.dnK.ayL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aL(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aL(false);
            }
        } else if (view == this.dnK.ayM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aJ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aJ(false);
            }
        } else if (view == this.dnK.ayN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aK(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aK(false);
            }
        } else if (view == this.dnK.ayO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aN(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aN(false);
            }
        } else if (view == this.dnK.ayP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aM(true);
                SettingStatic.s(3, true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.yg().aM(false);
            SettingStatic.s(3, false);
        } else if (view == this.dnK.ayC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aR(true);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10308").r("obj_type", 1));
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aR(false);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10308").r("obj_type", 0));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH));
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.dnK.apG().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dnK.apG()) {
            if (this.dnK.dor) {
                finish();
            } else {
                this.dnK.gV(true);
            }
        } else if (view == this.dnK.ayG()) {
            showDialog(n.f.sign_remind);
        } else if (view == this.dnK.ayI()) {
            this.dnK.gV(false);
        } else if (view == this.dnK.ayJ()) {
            showDialog(n.f.no_disturb_start_time);
        } else if (view == this.dnK.ayK()) {
            showDialog(n.f.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.dnK.dor) {
                    finish();
                    return true;
                }
                this.dnK.gV(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == n.f.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.yg().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.yg().getSignAlertMins());
                return;
            } else if (i == n.f.no_disturb_start_time || i == n.f.no_disturb_end_time) {
                if (i == n.f.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.yg().yt().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.yg().yu().split(":");
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
        com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new af(this, i), 0, 0, true);
        if (i == n.f.sign_remind) {
            aVar.setTitle(n.i.sign_remind);
        } else if (i == n.f.no_disturb_end_time) {
            aVar.setTitle(n.i.no_disturb_end_time);
        } else if (i == n.f.no_disturb_start_time) {
            aVar.setTitle(n.i.no_disturb_start_time);
        }
        aVar.setButton(-1, getPageContext().getString(n.i.alert_yes_button), aVar);
        aVar.setButton(-2, getPageContext().getString(n.i.alert_no_button), aVar);
        return aVar;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.yg().yh();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.dnK.ayQ()) {
            this.dnL.a(1, z, this.dlM);
        } else if (compoundButton == this.dnK.ayR()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.yg().aG(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yg().yl() && !com.baidu.tbadk.coreExtra.messageCenter.c.yg().yo() && !com.baidu.tbadk.coreExtra.messageCenter.c.yg().ym() && !com.baidu.tbadk.coreExtra.messageCenter.c.yg().yn() && !com.baidu.tbadk.coreExtra.messageCenter.c.yg().yw() && !com.baidu.tbadk.coreExtra.messageCenter.c.yg().yv()) {
                this.dlM.a(14, true, false);
            }
        } else if (compoundButton == this.dnK.ayS()) {
            this.dnL.a(2, z, this.dlM);
        } else if (compoundButton == this.dnK.ayT()) {
            this.dnL.a(5, z, this.dlM);
        } else if (compoundButton == this.dnK.ayU()) {
            this.dnL.a(4, z, this.dlM);
        } else if (compoundButton == this.dnK.ayV()) {
            this.dnL.a(3, z, this.dlM);
        }
    }
}
