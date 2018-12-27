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
    private g haE;
    private MsgRemindModel hat;
    private final com.baidu.tbadk.widget.timepicker.a.d.e haF = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.haE != null) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ix().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.haE.byA();
                MsgRemindActivity.this.haE.bza();
            }
        }
    };
    private MsgRemindModel.a gYq = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView byD = MsgRemindActivity.this.haE.byD();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().eY(300);
                        MsgRemindActivity.this.haE.nc(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().eY(0);
                        MsgRemindActivity.this.haE.nc(false);
                    }
                    if (byD != null) {
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    byD.nP();
                                } else {
                                    byD.nQ();
                                }
                            }
                        }, 500L);
                    }
                } else if (byD != null) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                byD.nQ();
                            } else {
                                byD.nP();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ix().ca(z2);
                }
                MsgRemindActivity.this.haE.byW();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ix().cb(z2);
                }
                MsgRemindActivity.this.haE.byX();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bR(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.haE.byZ();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bQ(z2);
                }
                MsgRemindActivity.this.haE.byY();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bZ(z2);
                }
                MsgRemindActivity.this.haE.byU();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bS(z2);
                }
                MsgRemindActivity.this.haE.byV();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.haE = new g(this);
        this.haE.b(this);
        this.hat = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.haE.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.haE.byC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ix().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").x("obj_type", 2));
                TiebaStatic.log(new am("c13254").x("obj_type", 1));
                this.haE.byA();
                this.haE.nb(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").x("obj_type", 1));
            TiebaStatic.log(new am("c13254").x("obj_type", 0));
            this.haE.nb(false);
        } else if (view == this.haE.byD()) {
            this.hat.a(14, switchState == BdSwitchView.SwitchState.ON, this.gYq);
        } else if (view == this.haE.byF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bU(true);
                this.haE.na(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bU(false);
            this.haE.na(false);
        } else if (view == this.haE.byJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bX(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bX(false);
            }
        } else if (view == this.haE.byK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bV(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bV(false);
            }
        } else if (view == this.haE.byL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bW(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bW(false);
            }
        } else if (view == this.haE.byM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bY(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bY(false);
            }
        } else if (view == this.haE.byN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hat.a(1, true, this.gYq);
            } else {
                this.hat.a(1, false, this.gYq);
            }
        } else if (view == this.haE.byO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hat.a(20, true, this.gYq);
            } else {
                this.hat.a(20, false, this.gYq);
            }
        } else if (view == this.haE.byP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hat.a(2, true, this.gYq);
            } else {
                this.hat.a(2, false, this.gYq);
            }
        } else if (view == this.haE.byQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hat.a(5, true, this.gYq);
            } else {
                this.hat.a(5, false, this.gYq);
            }
        } else if (view == this.haE.byR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hat.a(4, true, this.gYq);
            } else {
                this.hat.a(4, false, this.gYq);
            }
        } else if (view == this.haE.byS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hat.a(3, true, this.gYq);
            } else {
                this.hat.a(3, false, this.gYq);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.haE.byu().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.haE.byu()) {
            if (this.haE.hbh) {
                finish();
            } else {
                this.haE.nd(true);
            }
        } else if (view == this.haE.byE()) {
            com.baidu.tbadk.coreExtra.messageCenter.d.IS().a(getPageContext(), this.haF);
        } else if (view == this.haE.byG()) {
            this.haE.nd(false);
        } else if (view == this.haE.byH()) {
            showDialog(e.g.no_disturb_start_time);
        } else if (view == this.haE.byI()) {
            showDialog(e.g.no_disturb_end_time);
        } else if (view == this.haE.byT()) {
            TiebaStatic.log(new am("c13286").aA("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.haE.hbh) {
                    finish();
                    return true;
                }
                this.haE.nd(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IK().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IL().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog uM(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == e.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().gM(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().gN(str);
                    }
                    MsgRemindActivity.this.haE.byB();
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
            return uM(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().Iy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.haE != null) {
            this.haE.onDestroy();
        }
    }
}
