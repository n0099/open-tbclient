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
    private g itB;
    private MsgRemindModel itq;
    private final com.baidu.tbadk.widget.timepicker.a.d.e itC = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.itB != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.itB.bZY();
                MsgRemindActivity.this.itB.cay();
            }
        }
    };
    private MsgRemindModel.a irm = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void e(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cab = MsgRemindActivity.this.itB.cab();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aih().iE(300);
                        MsgRemindActivity.this.itB.pC(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aih().iE(0);
                        MsgRemindActivity.this.itB.pC(false);
                    }
                    if (cab != null) {
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cab.nY();
                                } else {
                                    cab.nZ();
                                }
                            }
                        }, 500L);
                    }
                } else if (cab != null) {
                    com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cab.nZ();
                            } else {
                                cab.nY();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().ek(z2);
                }
                MsgRemindActivity.this.itB.cau();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().el(z2);
                }
                MsgRemindActivity.this.itB.cav();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().eb(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.itB.cax();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().ea(z2);
                }
                MsgRemindActivity.this.itB.caw();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().ej(z2);
                }
                MsgRemindActivity.this.itB.cas();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aih().ec(z2);
                }
                MsgRemindActivity.this.itB.cat();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.itB = new g(this);
        this.itB.b(this);
        this.itq = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.itB.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.itB.caa()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").T("obj_type", 2));
                TiebaStatic.log(new am("c13254").T("obj_type", 1));
                this.itB.bZY();
                this.itB.pB(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aih().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").T("obj_type", 1));
            TiebaStatic.log(new am("c13254").T("obj_type", 0));
            this.itB.pB(false);
        } else if (view == this.itB.cab()) {
            this.itq.a(14, switchState == BdSwitchView.SwitchState.ON, this.irm);
        } else if (view == this.itB.cad()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().ee(true);
                this.itB.pA(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aih().ee(false);
            this.itB.pA(false);
        } else if (view == this.itB.cah()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().eh(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().eh(false);
            }
        } else if (view == this.itB.cai()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().ef(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().ef(false);
            }
        } else if (view == this.itB.caj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().eg(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().eg(false);
            }
        } else if (view == this.itB.cak()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().ei(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aih().ei(false);
            }
        } else if (view == this.itB.cal()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itq.a(1, true, this.irm);
            } else {
                this.itq.a(1, false, this.irm);
            }
        } else if (view == this.itB.cam()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itq.a(20, true, this.irm);
            } else {
                this.itq.a(20, false, this.irm);
            }
        } else if (view == this.itB.can()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itq.a(2, true, this.irm);
            } else {
                this.itq.a(2, false, this.irm);
            }
        } else if (view == this.itB.cao()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itq.a(5, true, this.irm);
            } else {
                this.itq.a(5, false, this.irm);
            }
        } else if (view == this.itB.cap()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itq.a(4, true, this.irm);
            } else {
                this.itq.a(4, false, this.irm);
            }
        } else if (view == this.itB.caq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.itq.a(3, true, this.irm);
            } else {
                this.itq.a(3, false, this.irm);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.itB.bZS().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.itB.bZS()) {
            if (this.itB.iue) {
                finish();
            } else {
                this.itB.pD(true);
            }
        } else if (view == this.itB.cac()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aiC().a(getPageContext(), this.itC);
        } else if (view == this.itB.cae()) {
            this.itB.pD(false);
        } else if (view == this.itB.caf()) {
            showDialog(d.g.no_disturb_start_time);
        } else if (view == this.itB.cag()) {
            showDialog(d.g.no_disturb_end_time);
        } else if (view == this.itB.car()) {
            TiebaStatic.log(new am("c13286").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.itB.iue) {
                    finish();
                    return true;
                }
                this.itB.pD(true);
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
                    MsgRemindActivity.this.itB.bZZ();
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
        if (this.itB != null) {
            this.itB.onDestroy();
        }
    }
}
