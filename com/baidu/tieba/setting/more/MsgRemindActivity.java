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
    private ar caY;
    private aj caZ;
    private am cba = new ae(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.caY = new ar(this);
        this.caY.b(this);
        this.caZ = new aj(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.caY.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.caY.ahk()) {
            this.caZ.a(6, switchState == BdSwitchView.SwitchState.ON, this.cba);
        } else if (view == this.caY.ahl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().setSignAlertOn(true);
                this.caY.ahi();
                this.caY.ev(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.vq().setSignAlertOn(false);
            this.caY.ev(false);
        } else if (view == this.caY.ahm()) {
            this.caZ.a(14, switchState == BdSwitchView.SwitchState.ON, this.cba);
        } else if (view == this.caY.aho()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().at(true);
                this.caY.eu(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.vq().at(false);
            this.caY.eu(false);
        } else if (view == this.caY.ahs()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().aw(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().aw(false);
            }
        } else if (view == this.caY.aht()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().au(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().au(false);
            }
        } else if (view == this.caY.ahu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().av(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().av(false);
            }
        } else if (view == this.caY.ahv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().ay(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().ay(false);
            }
        } else if (view == this.caY.ahw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().ax(true);
                MsgRemindStatic.s(3, true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.vq().ax(false);
            MsgRemindStatic.s(3, false);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.caY.aes().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.caY.aes()) {
            if (this.caY.cbP) {
                finish();
            } else {
                this.caY.ex(true);
            }
        } else if (view == this.caY.ahn()) {
            showDialog(com.baidu.tieba.v.sign_remind);
        } else if (view == this.caY.ahp()) {
            this.caY.ex(false);
        } else if (view == this.caY.ahq()) {
            showDialog(com.baidu.tieba.v.no_disturb_start_time);
        } else if (view == this.caY.ahr()) {
            showDialog(com.baidu.tieba.v.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.caY.cbP) {
                    finish();
                    return true;
                }
                this.caY.ex(true);
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
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.vq().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.vq().getSignAlertMins());
                return;
            } else if (i == com.baidu.tieba.v.no_disturb_start_time || i == com.baidu.tieba.v.no_disturb_end_time) {
                if (i == com.baidu.tieba.v.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.vq().vD().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.vq().vE().split(":");
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
        com.baidu.tbadk.coreExtra.messageCenter.c.vq().vr();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.caY.ahx()) {
            this.caZ.a(1, z, this.cba);
        } else if (compoundButton == this.caY.ahy()) {
            com.baidu.tbadk.coreExtra.messageCenter.c.vq().ar(z);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vv() && !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy() && !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vw() && !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vx() && !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vG() && !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vF() && !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vu()) {
                this.cba.a(14, true, false);
            }
        } else if (compoundButton == this.caY.ahz()) {
            this.caZ.a(2, z, this.cba);
        } else if (compoundButton == this.caY.ahA()) {
            this.caZ.a(5, z, this.cba);
        } else if (compoundButton == this.caY.ahB()) {
            this.caZ.a(4, z, this.cba);
        } else if (compoundButton == this.caY.ahC()) {
            this.caZ.a(3, z, this.cba);
        } else if (compoundButton == this.caY.ahD()) {
            this.caZ.a(23, z, this.cba);
        }
    }
}
