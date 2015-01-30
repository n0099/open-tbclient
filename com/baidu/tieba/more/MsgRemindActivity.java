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
    private aw bwp;
    private ao bwq;
    private ar bwr = new aj(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(MsgRemindActivityConfig.class, MsgRemindActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bwp = new aw(this);
        this.bwp.b(this);
        this.bwq = new ao(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bwp.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.bwp.VY()) {
            this.bwq.a(6, switchState == BdSwitchView.SwitchState.ON, this.bwr);
        } else if (view == this.bwp.VZ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setSignAlertOn(true);
                this.bwp.VW();
                this.bwp.dF(true);
                this.bwp.dD(true);
                return;
            }
            TbadkCoreApplication.m255getInst().setSignAlertOn(false);
            this.bwp.dF(false);
            this.bwp.dD(false);
        } else if (view == this.bwp.Wa()) {
            this.bwq.a(14, switchState == BdSwitchView.SwitchState.ON, this.bwr);
        } else if (view == this.bwp.Wc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setNoDisturbOn(true);
                this.bwp.dE(true);
                this.bwp.dB(true);
                return;
            }
            TbadkCoreApplication.m255getInst().setNoDisturbOn(false);
            this.bwp.dE(false);
            this.bwp.dB(false);
        } else if (view == this.bwp.Wg()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setMsgTone(true);
            } else {
                TbadkCoreApplication.m255getInst().setMsgTone(false);
            }
        } else if (view == this.bwp.Wh()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setMsgVibrate(true);
            } else {
                TbadkCoreApplication.m255getInst().setMsgVibrate(false);
            }
        } else if (view == this.bwp.Wi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setMsgLight(true);
            } else {
                TbadkCoreApplication.m255getInst().setMsgLight(false);
            }
        } else if (view == this.bwp.Wj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setScreenLock(true);
            } else {
                TbadkCoreApplication.m255getInst().setScreenLock(false);
            }
        } else if (view == this.bwp.Wk()) {
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
        this.bwp.BI().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bwp.BI()) {
            if (this.bwp.bxD) {
                finish();
            } else {
                this.bwp.dH(true);
            }
        } else if (view == this.bwp.Wb()) {
            showDialog(com.baidu.tieba.w.sign_remind);
        } else if (view == this.bwp.Wd()) {
            this.bwp.dH(false);
        } else if (view == this.bwp.We()) {
            showDialog(com.baidu.tieba.w.no_disturb_start_time);
        } else if (view == this.bwp.Wf()) {
            showDialog(com.baidu.tieba.w.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.bwp.bxD) {
                    finish();
                    return true;
                }
                this.bwp.dH(true);
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
            this.bwq.a(1, z, this.bwr);
        } else if (id == com.baidu.tieba.w.check_zan) {
            TbadkCoreApplication.m255getInst().setMsgZanOn(z);
            if (!TbadkCoreApplication.m255getInst().isMsgAtmeOn() && !TbadkCoreApplication.m255getInst().isMsgChatOn() && !TbadkCoreApplication.m255getInst().isMsgNewFansOn() && !TbadkCoreApplication.m255getInst().isMsgReplymeOn() && !TbadkCoreApplication.m255getInst().isMsgZanOn() && !TbadkCoreApplication.m255getInst().isGroupMsgOn() && !TbadkCoreApplication.m255getInst().isStrangerChatOn()) {
                this.bwr.a(14, true, false);
            }
        } else if (id == com.baidu.tieba.w.check_atme) {
            this.bwq.a(2, z, this.bwr);
        } else if (id == com.baidu.tieba.w.check_chatmessage) {
            this.bwq.a(5, z, this.bwr);
        } else if (id == com.baidu.tieba.w.check_groupmessage) {
            this.bwq.a(4, z, this.bwr);
        } else if (id == com.baidu.tieba.w.check_new_fans) {
            this.bwq.a(3, z, this.bwr);
        } else if (id == com.baidu.tieba.w.check_strangermessage) {
            this.bwq.a(23, z, this.bwr);
        }
    }
}
