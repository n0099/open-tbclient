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
    private MsgRemindModel gPa;
    private f gPl;
    private final com.baidu.tbadk.widget.timepicker.a.d.e gPm = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.gPl != null) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hg().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.gPl.bww();
                MsgRemindActivity.this.gPl.bwW();
            }
        }
    };
    private MsgRemindModel.a gNh = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bwz = MsgRemindActivity.this.gPl.bwz();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hg().ev(300);
                        MsgRemindActivity.this.gPl.mL(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hg().ev(0);
                        MsgRemindActivity.this.gPl.mL(false);
                    }
                    if (bwz != null) {
                        com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    bwz.nS();
                                } else {
                                    bwz.nT();
                                }
                            }
                        }, 500L);
                    }
                } else if (bwz != null) {
                    com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                bwz.nT();
                            } else {
                                bwz.nS();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bI(z2);
                }
                MsgRemindActivity.this.gPl.bwS();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bJ(z2);
                }
                MsgRemindActivity.this.gPl.bwT();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bz(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.gPl.bwV();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hg().by(z2);
                }
                MsgRemindActivity.this.gPl.bwU();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bH(z2);
                }
                MsgRemindActivity.this.gPl.bwQ();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bA(z2);
                }
                MsgRemindActivity.this.gPl.bwR();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gPl = new f(this);
        this.gPl.b(this);
        this.gPa = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gPl.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gPl.bwy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hg().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").x("obj_type", 2));
                TiebaStatic.log(new am("c13254").x("obj_type", 1));
                this.gPl.bww();
                this.gPl.mK(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Hg().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").x("obj_type", 1));
            TiebaStatic.log(new am("c13254").x("obj_type", 0));
            this.gPl.mK(false);
        } else if (view == this.gPl.bwz()) {
            this.gPa.a(14, switchState == BdSwitchView.SwitchState.ON, this.gNh);
        } else if (view == this.gPl.bwB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bC(true);
                this.gPl.mJ(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bC(false);
            this.gPl.mJ(false);
        } else if (view == this.gPl.bwF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bF(false);
            }
        } else if (view == this.gPl.bwG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bD(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bD(false);
            }
        } else if (view == this.gPl.bwH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bE(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bE(false);
            }
        } else if (view == this.gPl.bwI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hg().bG(false);
            }
        } else if (view == this.gPl.bwJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gPa.a(1, true, this.gNh);
            } else {
                this.gPa.a(1, false, this.gNh);
            }
        } else if (view == this.gPl.bwK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gPa.a(20, true, this.gNh);
            } else {
                this.gPa.a(20, false, this.gNh);
            }
        } else if (view == this.gPl.bwL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gPa.a(2, true, this.gNh);
            } else {
                this.gPa.a(2, false, this.gNh);
            }
        } else if (view == this.gPl.bwM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gPa.a(5, true, this.gNh);
            } else {
                this.gPa.a(5, false, this.gNh);
            }
        } else if (view == this.gPl.bwN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gPa.a(4, true, this.gNh);
            } else {
                this.gPa.a(4, false, this.gNh);
            }
        } else if (view == this.gPl.bwO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gPa.a(3, true, this.gNh);
            } else {
                this.gPa.a(3, false, this.gNh);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.gPl.bwq().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gPl.bwq()) {
            if (this.gPl.gPO) {
                finish();
            } else {
                this.gPl.mM(true);
            }
        } else if (view == this.gPl.bwA()) {
            com.baidu.tbadk.coreExtra.messageCenter.d.HB().a(getPageContext(), this.gPm);
        } else if (view == this.gPl.bwC()) {
            this.gPl.mM(false);
        } else if (view == this.gPl.bwD()) {
            showDialog(e.g.no_disturb_start_time);
        } else if (view == this.gPl.bwE()) {
            showDialog(e.g.no_disturb_end_time);
        } else if (view == this.gPl.bwP()) {
            TiebaStatic.log(new am("c13286").ax("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.gPl.gPO) {
                    finish();
                    return true;
                }
                this.gPl.mM(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Ht().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hu().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog tM(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == e.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hg().gr(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hg().gt(str);
                    }
                    MsgRemindActivity.this.gPl.bwx();
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
            return tM(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hh();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gPl != null) {
            this.gPl.onDestroy();
        }
    }
}
