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
    private g hbJ;
    private MsgRemindModel hby;
    private final com.baidu.tbadk.widget.timepicker.a.d.e hbK = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.hbJ != null) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.hbJ.bzj();
                MsgRemindActivity.this.hbJ.bzJ();
            }
        }
    };
    private MsgRemindModel.a gZv = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bzm = MsgRemindActivity.this.hbJ.bzm();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.IM().eY(300);
                        MsgRemindActivity.this.hbJ.nd(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.IM().eY(0);
                        MsgRemindActivity.this.hbJ.nd(false);
                    }
                    if (bzm != null) {
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    bzm.nT();
                                } else {
                                    bzm.nU();
                                }
                            }
                        }, 500L);
                    }
                } else if (bzm != null) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                bzm.nU();
                            } else {
                                bzm.nT();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().cb(z2);
                }
                MsgRemindActivity.this.hbJ.bzF();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().cc(z2);
                }
                MsgRemindActivity.this.hbJ.bzG();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().bS(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.hbJ.bzI();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().bR(z2);
                }
                MsgRemindActivity.this.hbJ.bzH();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().ca(z2);
                }
                MsgRemindActivity.this.hbJ.bzD();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().bT(z2);
                }
                MsgRemindActivity.this.hbJ.bzE();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbJ = new g(this);
        this.hbJ.b(this);
        this.hby = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hbJ.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.hbJ.bzl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").y("obj_type", 2));
                TiebaStatic.log(new am("c13254").y("obj_type", 1));
                this.hbJ.bzj();
                this.hbJ.nc(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.IM().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").y("obj_type", 1));
            TiebaStatic.log(new am("c13254").y("obj_type", 0));
            this.hbJ.nc(false);
        } else if (view == this.hbJ.bzm()) {
            this.hby.a(14, switchState == BdSwitchView.SwitchState.ON, this.gZv);
        } else if (view == this.hbJ.bzo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bV(true);
                this.hbJ.nb(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.IM().bV(false);
            this.hbJ.nb(false);
        } else if (view == this.hbJ.bzs()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bY(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bY(false);
            }
        } else if (view == this.hbJ.bzt()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bW(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bW(false);
            }
        } else if (view == this.hbJ.bzu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bX(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bX(false);
            }
        } else if (view == this.hbJ.bzv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bZ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bZ(false);
            }
        } else if (view == this.hbJ.bzw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hby.a(1, true, this.gZv);
            } else {
                this.hby.a(1, false, this.gZv);
            }
        } else if (view == this.hbJ.bzx()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hby.a(20, true, this.gZv);
            } else {
                this.hby.a(20, false, this.gZv);
            }
        } else if (view == this.hbJ.bzy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hby.a(2, true, this.gZv);
            } else {
                this.hby.a(2, false, this.gZv);
            }
        } else if (view == this.hbJ.bzz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hby.a(5, true, this.gZv);
            } else {
                this.hby.a(5, false, this.gZv);
            }
        } else if (view == this.hbJ.bzA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hby.a(4, true, this.gZv);
            } else {
                this.hby.a(4, false, this.gZv);
            }
        } else if (view == this.hbJ.bzB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hby.a(3, true, this.gZv);
            } else {
                this.hby.a(3, false, this.gZv);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.hbJ.bzd().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hbJ.bzd()) {
            if (this.hbJ.hcm) {
                finish();
            } else {
                this.hbJ.ne(true);
            }
        } else if (view == this.hbJ.bzn()) {
            com.baidu.tbadk.coreExtra.messageCenter.d.Jh().a(getPageContext(), this.hbK);
        } else if (view == this.hbJ.bzp()) {
            this.hbJ.ne(false);
        } else if (view == this.hbJ.bzq()) {
            showDialog(e.g.no_disturb_start_time);
        } else if (view == this.hbJ.bzr()) {
            showDialog(e.g.no_disturb_end_time);
        } else if (view == this.hbJ.bzC()) {
            TiebaStatic.log(new am("c13286").aB("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.hbJ.hcm) {
                    finish();
                    return true;
                }
                this.hbJ.ne(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.IM().IZ().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.IM().Ja().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog uP(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == e.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.IM().gZ(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.IM().ha(str);
                    }
                    MsgRemindActivity.this.hbJ.bzk();
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
            return uP(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.IM().IN();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hbJ != null) {
            this.hbJ.onDestroy();
        }
    }
}
