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
    private g.a cLZ = new z(this);
    private ae cNS;
    private com.baidu.tieba.setting.model.g cNT;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cNS = new ae(this);
        this.cNS.b(this);
        this.cNT = new com.baidu.tieba.setting.model.g(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cNS.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.cNS.asv()) {
            this.cNT.a(6, switchState == BdSwitchView.SwitchState.ON, this.cLZ);
        } else if (view == this.cNS.asw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().setSignAlertOn(true);
                this.cNS.ass();
                this.cNS.ga(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xe().setSignAlertOn(false);
            this.cNS.ga(false);
        } else if (view == this.cNS.asx()) {
            this.cNT.a(14, switchState == BdSwitchView.SwitchState.ON, this.cLZ);
        } else if (view == this.cNS.asz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().aD(true);
                this.cNS.fZ(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aD(false);
            this.cNS.fZ(false);
        } else if (view == this.cNS.asD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().aG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().aG(false);
            }
        } else if (view == this.cNS.asE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().aE(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().aE(false);
            }
        } else if (view == this.cNS.asF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().aF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().aF(false);
            }
        } else if (view == this.cNS.asG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().aI(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().aI(false);
            }
        } else if (view == this.cNS.asH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().aH(true);
                SettingStatic.r(3, true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aH(false);
            SettingStatic.r(3, false);
        } else if (view == this.cNS.asu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().aM(true);
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10308").r("obj_type", 1));
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().aM(false);
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10308").r("obj_type", 0));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH));
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.cNS.ajZ().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cNS.ajZ()) {
            if (this.cNS.cOz) {
                finish();
            } else {
                this.cNS.gc(true);
            }
        } else if (view == this.cNS.asy()) {
            showDialog(i.f.sign_remind);
        } else if (view == this.cNS.asA()) {
            this.cNS.gc(false);
        } else if (view == this.cNS.asB()) {
            showDialog(i.f.no_disturb_start_time);
        } else if (view == this.cNS.asC()) {
            showDialog(i.f.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.cNS.cOz) {
                    finish();
                    return true;
                }
                this.cNS.gc(true);
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
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.xe().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.xe().getSignAlertMins());
                return;
            } else if (i == i.f.no_disturb_start_time || i == i.f.no_disturb_end_time) {
                if (i == i.f.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.xe().xr().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.xe().xs().split(":");
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
        com.baidu.tbadk.coreExtra.messageCenter.c.xe().xf();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.cNS.asI()) {
            this.cNT.a(1, z, this.cLZ);
        } else if (compoundButton == this.cNS.asJ()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aB(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xe().xj() && !com.baidu.tbadk.coreExtra.messageCenter.c.xe().xm() && !com.baidu.tbadk.coreExtra.messageCenter.c.xe().xk() && !com.baidu.tbadk.coreExtra.messageCenter.c.xe().xl() && !com.baidu.tbadk.coreExtra.messageCenter.c.xe().xu() && !com.baidu.tbadk.coreExtra.messageCenter.c.xe().xt()) {
                this.cLZ.a(14, true, false);
            }
        } else if (compoundButton == this.cNS.asK()) {
            this.cNT.a(2, z, this.cLZ);
        } else if (compoundButton == this.cNS.asL()) {
            this.cNT.a(5, z, this.cLZ);
        } else if (compoundButton == this.cNS.asM()) {
            this.cNT.a(4, z, this.cLZ);
        } else if (compoundButton == this.cNS.asN()) {
            this.cNT.a(3, z, this.cLZ);
        }
    }
}
