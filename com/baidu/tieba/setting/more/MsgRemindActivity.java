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
    private f gXA;
    private MsgRemindModel gXp;
    private final com.baidu.tbadk.widget.timepicker.a.d.e gXB = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.gXA != null) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Iw().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.gXA.bxL();
                MsgRemindActivity.this.gXA.byl();
            }
        }
    };
    private MsgRemindModel.a gVw = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bxO = MsgRemindActivity.this.gXA.bxO();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Iw().eX(300);
                        MsgRemindActivity.this.gXA.mZ(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Iw().eX(0);
                        MsgRemindActivity.this.gXA.mZ(false);
                    }
                    if (bxO != null) {
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    bxO.nP();
                                } else {
                                    bxO.nQ();
                                }
                            }
                        }, 500L);
                    }
                } else if (bxO != null) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                bxO.nQ();
                            } else {
                                bxO.nP();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Iw().ca(z2);
                }
                MsgRemindActivity.this.gXA.byh();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Iw().cb(z2);
                }
                MsgRemindActivity.this.gXA.byi();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bR(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.gXA.byk();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bQ(z2);
                }
                MsgRemindActivity.this.gXA.byj();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bZ(z2);
                }
                MsgRemindActivity.this.gXA.byf();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bS(z2);
                }
                MsgRemindActivity.this.gXA.byg();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gXA = new f(this);
        this.gXA.b(this);
        this.gXp = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gXA.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gXA.bxN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Iw().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").x("obj_type", 2));
                TiebaStatic.log(new am("c13254").x("obj_type", 1));
                this.gXA.bxL();
                this.gXA.mY(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Iw().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").x("obj_type", 1));
            TiebaStatic.log(new am("c13254").x("obj_type", 0));
            this.gXA.mY(false);
        } else if (view == this.gXA.bxO()) {
            this.gXp.a(14, switchState == BdSwitchView.SwitchState.ON, this.gVw);
        } else if (view == this.gXA.bxQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bU(true);
                this.gXA.mX(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bU(false);
            this.gXA.mX(false);
        } else if (view == this.gXA.bxU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bX(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bX(false);
            }
        } else if (view == this.gXA.bxV()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bV(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bV(false);
            }
        } else if (view == this.gXA.bxW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bW(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bW(false);
            }
        } else if (view == this.gXA.bxX()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bY(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Iw().bY(false);
            }
        } else if (view == this.gXA.bxY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gXp.a(1, true, this.gVw);
            } else {
                this.gXp.a(1, false, this.gVw);
            }
        } else if (view == this.gXA.bxZ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gXp.a(20, true, this.gVw);
            } else {
                this.gXp.a(20, false, this.gVw);
            }
        } else if (view == this.gXA.bya()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gXp.a(2, true, this.gVw);
            } else {
                this.gXp.a(2, false, this.gVw);
            }
        } else if (view == this.gXA.byb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gXp.a(5, true, this.gVw);
            } else {
                this.gXp.a(5, false, this.gVw);
            }
        } else if (view == this.gXA.byc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gXp.a(4, true, this.gVw);
            } else {
                this.gXp.a(4, false, this.gVw);
            }
        } else if (view == this.gXA.byd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gXp.a(3, true, this.gVw);
            } else {
                this.gXp.a(3, false, this.gVw);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.gXA.bxF().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gXA.bxF()) {
            if (this.gXA.gYd) {
                finish();
            } else {
                this.gXA.na(true);
            }
        } else if (view == this.gXA.bxP()) {
            com.baidu.tbadk.coreExtra.messageCenter.d.IR().a(getPageContext(), this.gXB);
        } else if (view == this.gXA.bxR()) {
            this.gXA.na(false);
        } else if (view == this.gXA.bxS()) {
            showDialog(e.g.no_disturb_start_time);
        } else if (view == this.gXA.bxT()) {
            showDialog(e.g.no_disturb_end_time);
        } else if (view == this.gXA.bye()) {
            TiebaStatic.log(new am("c13286").aA("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.gXA.gYd) {
                    finish();
                    return true;
                }
                this.gXA.na(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IJ().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IK().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog uz(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == e.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Iw().gL(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Iw().gM(str);
                    }
                    MsgRemindActivity.this.gXA.bxM();
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
            return uz(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.Iw().Ix();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gXA != null) {
            this.gXA.onDestroy();
        }
    }
}
