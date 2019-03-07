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
import com.baidu.tieba.d;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import java.util.Date;
/* loaded from: classes3.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private g itA;
    private MsgRemindModel itp;
    private final com.baidu.tbadk.widget.timepicker.a.d.e itB = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.itA != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.itA.bZX();
                MsgRemindActivity.this.itA.cax();
            }
        }
    };
    private MsgRemindModel.a irl = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void e(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView caa = MsgRemindActivity.this.itA.caa();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aih().iE(300);
                        MsgRemindActivity.this.itA.pC(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aih().iE(0);
                        MsgRemindActivity.this.itA.pC(false);
                    }
                    if (caa != null) {
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    caa.nY();
                                } else {
                                    caa.nZ();
                                }
                            }
                        }, 500L);
                    }
                } else if (caa != null) {
                    com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                caa.nZ();
                            } else {
                                caa.nY();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().ek(z2);
                }
                MsgRemindActivity.this.itA.cat();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().el(z2);
                }
                MsgRemindActivity.this.itA.cau();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().eb(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.itA.caw();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().ea(z2);
                }
                MsgRemindActivity.this.itA.cav();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().ej(z2);
                }
                MsgRemindActivity.this.itA.car();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().ec(z2);
                }
                MsgRemindActivity.this.itA.cas();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.itA = new g(this);
        this.itA.b(this);
        this.itp = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.itA.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.itA.bZZ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").T("obj_type", 2));
                TiebaStatic.log(new am("c13254").T("obj_type", 1));
                this.itA.bZX();
                this.itA.pB(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aih().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").T("obj_type", 1));
            TiebaStatic.log(new am("c13254").T("obj_type", 0));
            this.itA.pB(false);
        } else if (view == this.itA.caa()) {
            this.itp.a(14, switchState == BdSwitchView.SwitchState.ON, this.irl);
        } else if (view == this.itA.cac()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().ee(true);
                this.itA.pA(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aih().ee(false);
            this.itA.pA(false);
        } else if (view == this.itA.cag()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().eh(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().eh(false);
            }
        } else if (view == this.itA.cah()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().ef(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().ef(false);
            }
        } else if (view == this.itA.cai()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().eg(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().eg(false);
            }
        } else if (view == this.itA.caj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().ei(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().ei(false);
            }
        } else if (view == this.itA.cak()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itp.a(1, true, this.irl);
            } else {
                this.itp.a(1, false, this.irl);
            }
        } else if (view == this.itA.cal()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itp.a(20, true, this.irl);
            } else {
                this.itp.a(20, false, this.irl);
            }
        } else if (view == this.itA.cam()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itp.a(2, true, this.irl);
            } else {
                this.itp.a(2, false, this.irl);
            }
        } else if (view == this.itA.can()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itp.a(5, true, this.irl);
            } else {
                this.itp.a(5, false, this.irl);
            }
        } else if (view == this.itA.cao()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itp.a(4, true, this.irl);
            } else {
                this.itp.a(4, false, this.irl);
            }
        } else if (view == this.itA.cap()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itp.a(3, true, this.irl);
            } else {
                this.itp.a(3, false, this.irl);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.itA.bZR().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.itA.bZR()) {
            if (this.itA.iud) {
                finish();
            } else {
                this.itA.pD(true);
            }
        } else if (view == this.itA.cab()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aiC().a(getPageContext(), this.itB);
        } else if (view == this.itA.cad()) {
            this.itA.pD(false);
        } else if (view == this.itA.cae()) {
            showDialog(d.g.no_disturb_start_time);
        } else if (view == this.itA.caf()) {
            showDialog(d.g.no_disturb_end_time);
        } else if (view == this.itA.caq()) {
            TiebaStatic.log(new am("c13286").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.itA.iud) {
                    finish();
                    return true;
                }
                this.itA.pD(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == d.g.no_disturb_start_time || i == d.g.no_disturb_end_time) {
                if (i == d.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiu().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiv().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog yE(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == d.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aih().nL(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aih().nM(str);
                    }
                    MsgRemindActivity.this.itA.bZY();
                }
            }
        }, 0, 0, true);
        if (i == d.g.no_disturb_end_time) {
            bVar.setTitle(d.j.no_disturb_end_time);
        } else if (i == d.g.no_disturb_start_time) {
            bVar.setTitle(d.j.no_disturb_start_time);
        }
        bVar.setButton(-1, getPageContext().getString(d.j.alert_yes_button), bVar);
        bVar.setButton(-2, getPageContext().getString(d.j.cancel), bVar);
        bVar.getWindow().setSoftInputMode(2);
        return bVar;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        if (i == d.g.no_disturb_end_time || i == d.g.no_disturb_start_time) {
            return yE(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aih().aii();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.itA != null) {
            this.itA.onDestroy();
        }
    }
}
