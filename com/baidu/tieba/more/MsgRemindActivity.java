package com.baidu.tieba.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MsgRemindActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.notify.WindowSwitchResponse;
/* loaded from: classes.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, com.baidu.adp.widget.BdSwitchView.c {
    private ak buT;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(MsgRemindActivityConfig.class, MsgRemindActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.buT = new ak(this);
        this.buT.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.buT.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.buT.Vy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setPromotedMessage(true);
            } else {
                TbadkCoreApplication.m255getInst().setPromotedMessage(false);
            }
        } else if (view == this.buT.Vz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setSignAlertOn(true);
                this.buT.Vw();
                this.buT.dz(true);
                this.buT.dx(true);
                return;
            }
            TbadkCoreApplication.m255getInst().setSignAlertOn(false);
            this.buT.dz(false);
            this.buT.dx(false);
        } else if (view == this.buT.VA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setMsgFrequency(300);
                this.buT.dA(true);
                this.buT.dw(true);
                s(0, true);
                return;
            }
            TbadkCoreApplication.m255getInst().setMsgFrequency(0);
            this.buT.dA(false);
            this.buT.dw(false);
            s(0, false);
        } else if (view == this.buT.VC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setNoDisturbOn(true);
                this.buT.dy(true);
                this.buT.dv(true);
                return;
            }
            TbadkCoreApplication.m255getInst().setNoDisturbOn(false);
            this.buT.dy(false);
            this.buT.dv(false);
        } else if (view == this.buT.VG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setMsgTone(true);
            } else {
                TbadkCoreApplication.m255getInst().setMsgTone(false);
            }
        } else if (view == this.buT.VH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setMsgVibrate(true);
            } else {
                TbadkCoreApplication.m255getInst().setMsgVibrate(false);
            }
        } else if (view == this.buT.VI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setMsgLight(true);
            } else {
                TbadkCoreApplication.m255getInst().setMsgLight(false);
            }
        } else if (view == this.buT.VJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setScreenLock(true);
            } else {
                TbadkCoreApplication.m255getInst().setScreenLock(false);
            }
        } else if (view == this.buT.VK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkCoreApplication.m255getInst().setChatFloatWindowLock(true);
                s(3, true);
                return;
            }
            TbadkCoreApplication.m255getInst().setChatFloatWindowLock(false);
            s(3, false);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.buT.Bj().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.buT.Bj()) {
            if (this.buT.bvT) {
                finish();
            } else {
                this.buT.dB(true);
            }
        } else if (view == this.buT.VB()) {
            showDialog(com.baidu.tieba.w.sign_remind);
        } else if (view == this.buT.VD()) {
            this.buT.dB(false);
        } else if (view == this.buT.VE()) {
            showDialog(com.baidu.tieba.w.no_disturb_start_time);
        } else if (view == this.buT.VF()) {
            showDialog(com.baidu.tieba.w.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.buT.bvT) {
                    finish();
                    return true;
                }
                this.buT.dB(true);
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
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new aj(this, i, TbadkCoreApplication.m255getInst()), 0, 0, true);
        if (i == com.baidu.tieba.w.sign_remind) {
            bVar.setTitle(com.baidu.tieba.z.sign_remind);
        } else if (i == com.baidu.tieba.w.no_disturb_end_time) {
            bVar.setTitle(com.baidu.tieba.z.no_disturb_end_time);
        } else if (i == com.baidu.tieba.w.no_disturb_start_time) {
            bVar.setTitle(com.baidu.tieba.z.no_disturb_start_time);
        }
        bVar.setButton(-1, getPageContext().getString(com.baidu.tieba.z.alert_yes_button), bVar);
        bVar.setButton(-2, getPageContext().getString(com.baidu.tieba.z.alert_no_button), bVar);
        return bVar;
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
            if (z) {
                TbadkCoreApplication.m255getInst().setMsgReplymeOn(true);
            } else {
                TbadkCoreApplication.m255getInst().setMsgReplymeOn(false);
            }
        } else if (id == com.baidu.tieba.w.check_zan) {
            if (z) {
                TbadkCoreApplication.m255getInst().setMsgZanOn(true);
            } else {
                TbadkCoreApplication.m255getInst().setMsgZanOn(false);
            }
        } else if (id == com.baidu.tieba.w.check_atme) {
            if (z) {
                TbadkCoreApplication.m255getInst().setMsgAtmeOn(true);
            } else {
                TbadkCoreApplication.m255getInst().setMsgAtmeOn(false);
            }
        } else if (id == com.baidu.tieba.w.check_chatmessage) {
            if (z) {
                TbadkCoreApplication.m255getInst().setMsgChatOn(true);
                s(1, true);
                return;
            }
            TbadkCoreApplication.m255getInst().setMsgChatOn(false);
            s(1, false);
        } else if (id == com.baidu.tieba.w.check_groupmessage) {
            if (z) {
                TbadkCoreApplication.m255getInst().setGroupMsgOn(true);
                return;
            }
            TbadkCoreApplication.m255getInst().setGroupMsgOn(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
        } else if (id == com.baidu.tieba.w.check_new_fans) {
            TbadkCoreApplication.m255getInst().setMsgNewFansOn(z);
        } else if (id == com.baidu.tieba.w.check_strangermessage) {
            if (z) {
                TbadkCoreApplication.m255getInst().setStrangerChatOn(true);
                s(2, true);
                return;
            }
            TbadkCoreApplication.m255getInst().setStrangerChatOn(false);
            s(2, false);
        }
    }

    private void s(int i, boolean z) {
        WindowSwitchResponse windowSwitchResponse = new WindowSwitchResponse();
        windowSwitchResponse.setIsOpen(z);
        windowSwitchResponse.setSwitchType(i);
        MessageManager.getInstance().dispatchResponsedMessage(windowSwitchResponse);
    }
}
