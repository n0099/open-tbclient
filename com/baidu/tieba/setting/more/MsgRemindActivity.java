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
    private g hbK;
    private MsgRemindModel hbz;
    private final com.baidu.tbadk.widget.timepicker.a.d.e hbL = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.hbK != null) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.hbK.bzj();
                MsgRemindActivity.this.hbK.bzJ();
            }
        }
    };
    private MsgRemindModel.a gZw = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bzm = MsgRemindActivity.this.hbK.bzm();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.IM().eY(300);
                        MsgRemindActivity.this.hbK.nd(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.IM().eY(0);
                        MsgRemindActivity.this.hbK.nd(false);
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
                MsgRemindActivity.this.hbK.bzF();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().cc(z2);
                }
                MsgRemindActivity.this.hbK.bzG();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().bS(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.hbK.bzI();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().bR(z2);
                }
                MsgRemindActivity.this.hbK.bzH();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().ca(z2);
                }
                MsgRemindActivity.this.hbK.bzD();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.IM().bT(z2);
                }
                MsgRemindActivity.this.hbK.bzE();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbK = new g(this);
        this.hbK.b(this);
        this.hbz = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hbK.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.hbK.bzl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").y("obj_type", 2));
                TiebaStatic.log(new am("c13254").y("obj_type", 1));
                this.hbK.bzj();
                this.hbK.nc(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.IM().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").y("obj_type", 1));
            TiebaStatic.log(new am("c13254").y("obj_type", 0));
            this.hbK.nc(false);
        } else if (view == this.hbK.bzm()) {
            this.hbz.a(14, switchState == BdSwitchView.SwitchState.ON, this.gZw);
        } else if (view == this.hbK.bzo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bV(true);
                this.hbK.nb(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.IM().bV(false);
            this.hbK.nb(false);
        } else if (view == this.hbK.bzs()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bY(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bY(false);
            }
        } else if (view == this.hbK.bzt()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bW(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bW(false);
            }
        } else if (view == this.hbK.bzu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bX(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bX(false);
            }
        } else if (view == this.hbK.bzv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bZ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.IM().bZ(false);
            }
        } else if (view == this.hbK.bzw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hbz.a(1, true, this.gZw);
            } else {
                this.hbz.a(1, false, this.gZw);
            }
        } else if (view == this.hbK.bzx()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hbz.a(20, true, this.gZw);
            } else {
                this.hbz.a(20, false, this.gZw);
            }
        } else if (view == this.hbK.bzy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hbz.a(2, true, this.gZw);
            } else {
                this.hbz.a(2, false, this.gZw);
            }
        } else if (view == this.hbK.bzz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hbz.a(5, true, this.gZw);
            } else {
                this.hbz.a(5, false, this.gZw);
            }
        } else if (view == this.hbK.bzA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hbz.a(4, true, this.gZw);
            } else {
                this.hbz.a(4, false, this.gZw);
            }
        } else if (view == this.hbK.bzB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.hbz.a(3, true, this.gZw);
            } else {
                this.hbz.a(3, false, this.gZw);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.hbK.bzd().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hbK.bzd()) {
            if (this.hbK.hcn) {
                finish();
            } else {
                this.hbK.ne(true);
            }
        } else if (view == this.hbK.bzn()) {
            com.baidu.tbadk.coreExtra.messageCenter.d.Jh().a(getPageContext(), this.hbL);
        } else if (view == this.hbK.bzp()) {
            this.hbK.ne(false);
        } else if (view == this.hbK.bzq()) {
            showDialog(e.g.no_disturb_start_time);
        } else if (view == this.hbK.bzr()) {
            showDialog(e.g.no_disturb_end_time);
        } else if (view == this.hbK.bzC()) {
            TiebaStatic.log(new am("c13286").aB("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.hbK.hcn) {
                    finish();
                    return true;
                }
                this.hbK.ne(true);
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
                    MsgRemindActivity.this.hbK.bzk();
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
        if (this.hbK != null) {
            this.hbK.onDestroy();
        }
    }
}
