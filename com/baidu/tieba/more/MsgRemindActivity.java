package com.baidu.tieba.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MsgRemindActivityConfig;
/* loaded from: classes.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, com.baidu.adp.widget.BdSwitchView.c {
    private aw bwo;
    private ao bwp;
    private ar bwq = new aj(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(MsgRemindActivityConfig.class, MsgRemindActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bwo = new aw(this);
        this.bwo.b(this);
        this.bwp = new ao(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bwo.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.bwo.VT()) {
            this.bwp.a(6, switchState == BdSwitchView.SwitchState.ON, this.bwq);
        } else if (view == this.bwo.VU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setSignAlertOn(true);
                this.bwo.VR();
                this.bwo.dF(true);
                this.bwo.dD(true);
                return;
            }
            TbadkCoreApplication.m255getInst().setSignAlertOn(false);
            this.bwo.dF(false);
            this.bwo.dD(false);
        } else if (view == this.bwo.VV()) {
            this.bwp.a(14, switchState == BdSwitchView.SwitchState.ON, this.bwq);
        } else if (view == this.bwo.VX()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setNoDisturbOn(true);
                this.bwo.dE(true);
                this.bwo.dB(true);
                return;
            }
            TbadkCoreApplication.m255getInst().setNoDisturbOn(false);
            this.bwo.dE(false);
            this.bwo.dB(false);
        } else if (view == this.bwo.Wb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setMsgTone(true);
            } else {
                TbadkCoreApplication.m255getInst().setMsgTone(false);
            }
        } else if (view == this.bwo.Wc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setMsgVibrate(true);
            } else {
                TbadkCoreApplication.m255getInst().setMsgVibrate(false);
            }
        } else if (view == this.bwo.Wd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setMsgLight(true);
            } else {
                TbadkCoreApplication.m255getInst().setMsgLight(false);
            }
        } else if (view == this.bwo.We()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setScreenLock(true);
            } else {
                TbadkCoreApplication.m255getInst().setScreenLock(false);
            }
        } else if (view == this.bwo.Wf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setChatFloatWindowLock(true);
                MsgRemindStatic.t(3, true);
                return;
            }
            TbadkCoreApplication.m255getInst().setChatFloatWindowLock(false);
            MsgRemindStatic.t(3, false);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.bwo.BC().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bwo.BC()) {
            if (this.bwo.bxC) {
                finish();
            } else {
                this.bwo.dH(true);
            }
        } else if (view == this.bwo.VW()) {
            showDialog(com.baidu.tieba.w.sign_remind);
        } else if (view == this.bwo.VY()) {
            this.bwo.dH(false);
        } else if (view == this.bwo.VZ()) {
            showDialog(com.baidu.tieba.w.no_disturb_start_time);
        } else if (view == this.bwo.Wa()) {
            showDialog(com.baidu.tieba.w.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.bwo.bxC) {
                    finish();
                    return true;
                }
                this.bwo.dH(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (dialog instanceof TimePickerDialog) {
            TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
            if (i == com.baidu.tieba.w.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(TbadkCoreApplication.m255getInst().getSignAlertHours(), TbadkCoreApplication.m255getInst().getSignAlertMins());
                return;
            } else if (i == com.baidu.tieba.w.no_disturb_start_time || i == com.baidu.tieba.w.no_disturb_end_time) {
                String[] split = i == com.baidu.tieba.w.no_disturb_start_time ? m255getInst.getNoDisturbStartTime().split(":") : m255getInst.getNoDisturbEndTime().split(":");
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
        com.baidu.tieba.view.g gVar = new com.baidu.tieba.view.g(getPageContext().getPageActivity(), new an(this, i, TbadkCoreApplication.m255getInst()), 0, 0, true);
        if (i == com.baidu.tieba.w.sign_remind) {
            gVar.setTitle(com.baidu.tieba.z.sign_remind);
        } else if (i == com.baidu.tieba.w.no_disturb_end_time) {
            gVar.setTitle(com.baidu.tieba.z.no_disturb_end_time);
        } else if (i == com.baidu.tieba.w.no_disturb_start_time) {
            gVar.setTitle(com.baidu.tieba.z.no_disturb_start_time);
        }
        gVar.setButton(-1, getPageContext().getString(com.baidu.tieba.z.alert_yes_button), gVar);
        gVar.setButton(-2, getPageContext().getString(com.baidu.tieba.z.alert_no_button), gVar);
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TbadkCoreApplication.m255getInst().saveSettingData();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (id == com.baidu.tieba.w.check_replyme) {
            this.bwp.a(1, z, this.bwq);
        } else if (id == com.baidu.tieba.w.check_zan) {
            TbadkCoreApplication.m255getInst().setMsgZanOn(z);
            if (!TbadkCoreApplication.m255getInst().isMsgAtmeOn() && !TbadkCoreApplication.m255getInst().isMsgChatOn() && !TbadkCoreApplication.m255getInst().isMsgNewFansOn() && !TbadkCoreApplication.m255getInst().isMsgReplymeOn() && !TbadkCoreApplication.m255getInst().isMsgZanOn() && !TbadkCoreApplication.m255getInst().isGroupMsgOn() && !TbadkCoreApplication.m255getInst().isStrangerChatOn()) {
                this.bwq.a(14, true, false);
            }
        } else if (id == com.baidu.tieba.w.check_atme) {
            this.bwp.a(2, z, this.bwq);
        } else if (id == com.baidu.tieba.w.check_chatmessage) {
            this.bwp.a(5, z, this.bwq);
        } else if (id == com.baidu.tieba.w.check_groupmessage) {
            this.bwp.a(4, z, this.bwq);
        } else if (id == com.baidu.tieba.w.check_new_fans) {
            this.bwp.a(3, z, this.bwq);
        } else if (id == com.baidu.tieba.w.check_strangermessage) {
            this.bwp.a(23, z, this.bwq);
        }
    }
}
