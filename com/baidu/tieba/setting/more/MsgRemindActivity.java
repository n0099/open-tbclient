package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TimePicker;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import java.util.Date;
/* loaded from: classes3.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel gHD;
    private f gHO;
    private final com.baidu.tbadk.widget.timepicker.a.d.e gHP = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.gHO != null) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ff().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.gHO.bth();
                MsgRemindActivity.this.gHO.btH();
            }
        }
    };
    private MsgRemindModel.a gFK = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView btk = MsgRemindActivity.this.gHO.btk();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ff().em(300);
                        MsgRemindActivity.this.gHO.mu(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ff().em(0);
                        MsgRemindActivity.this.gHO.mu(false);
                    }
                    if (btk != null) {
                        com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    btk.nI();
                                } else {
                                    btk.nJ();
                                }
                            }
                        }, 500L);
                    }
                } else if (btk != null) {
                    com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                btk.nJ();
                            } else {
                                btk.nI();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bz(z2);
                }
                MsgRemindActivity.this.gHO.btD();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bA(z2);
                }
                MsgRemindActivity.this.gHO.btE();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bq(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.gHO.btG();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bp(z2);
                }
                MsgRemindActivity.this.gHO.btF();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ff().by(z2);
                }
                MsgRemindActivity.this.gHO.btB();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ff().br(z2);
                }
                MsgRemindActivity.this.gHO.btC();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gHO = new f(this);
        this.gHO.b(this);
        this.gHD = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gHO.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gHO.btj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ff().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").w("obj_type", 2));
                TiebaStatic.log(new am("c13254").w("obj_type", 1));
                this.gHO.bth();
                this.gHO.mt(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Ff().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").w("obj_type", 1));
            TiebaStatic.log(new am("c13254").w("obj_type", 0));
            this.gHO.mt(false);
        } else if (view == this.gHO.btk()) {
            this.gHD.a(14, switchState == BdSwitchView.SwitchState.ON, this.gFK);
        } else if (view == this.gHO.btm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bt(true);
                this.gHO.ms(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bt(false);
            this.gHO.ms(false);
        } else if (view == this.gHO.btq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bw(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bw(false);
            }
        } else if (view == this.gHO.btr()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bu(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bu(false);
            }
        } else if (view == this.gHO.bts()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bv(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bv(false);
            }
        } else if (view == this.gHO.btt()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bx(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ff().bx(false);
            }
        } else if (view == this.gHO.btu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gHD.a(1, true, this.gFK);
            } else {
                this.gHD.a(1, false, this.gFK);
            }
        } else if (view == this.gHO.btv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gHD.a(20, true, this.gFK);
            } else {
                this.gHD.a(20, false, this.gFK);
            }
        } else if (view == this.gHO.btw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gHD.a(2, true, this.gFK);
            } else {
                this.gHD.a(2, false, this.gFK);
            }
        } else if (view == this.gHO.btx()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gHD.a(5, true, this.gFK);
            } else {
                this.gHD.a(5, false, this.gFK);
            }
        } else if (view == this.gHO.bty()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gHD.a(4, true, this.gFK);
            } else {
                this.gHD.a(4, false, this.gFK);
            }
        } else if (view == this.gHO.btz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gHD.a(3, true, this.gFK);
            } else {
                this.gHD.a(3, false, this.gFK);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.gHO.btb().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gHO.btb()) {
            if (this.gHO.gIr) {
                finish();
            } else {
                this.gHO.mv(true);
            }
        } else if (view == this.gHO.btl()) {
            com.baidu.tbadk.coreExtra.messageCenter.d.FA().a(getPageContext(), this.gHP);
        } else if (view == this.gHO.btn()) {
            this.gHO.mv(false);
        } else if (view == this.gHO.bto()) {
            showDialog(e.g.no_disturb_start_time);
        } else if (view == this.gHO.btp()) {
            showDialog(e.g.no_disturb_end_time);
        } else if (view == this.gHO.btA()) {
            TiebaStatic.log(new am("c13286").al("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.gHO.gIr) {
                    finish();
                    return true;
                }
                this.gHO.mv(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == e.g.no_disturb_start_time || i == e.g.no_disturb_end_time) {
                if (i == e.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fs().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Ft().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog tp(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == e.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ff().gd(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ff().ge(str);
                    }
                    MsgRemindActivity.this.gHO.bti();
                }
            }
        }, 0, 0, true);
        if (i == e.g.no_disturb_end_time) {
            bVar.setTitle(e.j.no_disturb_end_time);
        } else if (i == e.g.no_disturb_start_time) {
            bVar.setTitle(e.j.no_disturb_start_time);
        }
        bVar.setButton(-1, getPageContext().getString(e.j.alert_yes_button), bVar);
        bVar.setButton(-2, getPageContext().getString(e.j.cancel), bVar);
        bVar.getWindow().setSoftInputMode(2);
        return bVar;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        if (i == e.g.no_disturb_end_time || i == e.g.no_disturb_start_time) {
            return tp(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fg();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gHO != null) {
            this.gHO.onDestroy();
        }
    }
}
