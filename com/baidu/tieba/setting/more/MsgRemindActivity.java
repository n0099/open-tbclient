package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TimePicker;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.mobstat.Config;
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
    private MsgRemindModel isT;
    private g ite;
    private final com.baidu.tbadk.widget.timepicker.a.d.e itf = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.ite != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.ite.bZW();
                MsgRemindActivity.this.ite.caw();
            }
        }
    };
    private MsgRemindModel.a iqP = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void e(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bZZ = MsgRemindActivity.this.ite.bZZ();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().iD(300);
                        MsgRemindActivity.this.ite.pC(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().iD(0);
                        MsgRemindActivity.this.ite.pC(false);
                    }
                    if (bZZ != null) {
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    bZZ.nY();
                                } else {
                                    bZZ.nZ();
                                }
                            }
                        }, 500L);
                    }
                } else if (bZZ != null) {
                    com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                bZZ.nZ();
                            } else {
                                bZZ.nY();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().ek(z2);
                }
                MsgRemindActivity.this.ite.cas();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().el(z2);
                }
                MsgRemindActivity.this.ite.cat();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().eb(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.ite.cav();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().ea(z2);
                }
                MsgRemindActivity.this.ite.cau();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().ej(z2);
                }
                MsgRemindActivity.this.ite.caq();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().ec(z2);
                }
                MsgRemindActivity.this.ite.car();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ite = new g(this);
        this.ite.b(this);
        this.isT = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ite.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.ite.bZY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").T("obj_type", 2));
                TiebaStatic.log(new am("c13254").T("obj_type", 1));
                this.ite.bZW();
                this.ite.pB(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aie().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").T("obj_type", 1));
            TiebaStatic.log(new am("c13254").T("obj_type", 0));
            this.ite.pB(false);
        } else if (view == this.ite.bZZ()) {
            this.isT.a(14, switchState == BdSwitchView.SwitchState.ON, this.iqP);
        } else if (view == this.ite.cab()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().ee(true);
                this.ite.pA(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ee(false);
            this.ite.pA(false);
        } else if (view == this.ite.caf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().eh(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().eh(false);
            }
        } else if (view == this.ite.cag()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().ef(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().ef(false);
            }
        } else if (view == this.ite.cah()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().eg(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().eg(false);
            }
        } else if (view == this.ite.cai()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().ei(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().ei(false);
            }
        } else if (view == this.ite.caj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isT.a(1, true, this.iqP);
            } else {
                this.isT.a(1, false, this.iqP);
            }
        } else if (view == this.ite.cak()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isT.a(20, true, this.iqP);
            } else {
                this.isT.a(20, false, this.iqP);
            }
        } else if (view == this.ite.cal()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isT.a(2, true, this.iqP);
            } else {
                this.isT.a(2, false, this.iqP);
            }
        } else if (view == this.ite.cam()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isT.a(5, true, this.iqP);
            } else {
                this.isT.a(5, false, this.iqP);
            }
        } else if (view == this.ite.can()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isT.a(4, true, this.iqP);
            } else {
                this.isT.a(4, false, this.iqP);
            }
        } else if (view == this.ite.cao()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isT.a(3, true, this.iqP);
            } else {
                this.isT.a(3, false, this.iqP);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.ite.bZQ().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ite.bZQ()) {
            if (this.ite.itH) {
                finish();
            } else {
                this.ite.pD(true);
            }
        } else if (view == this.ite.caa()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aiz().a(getPageContext(), this.itf);
        } else if (view == this.ite.cac()) {
            this.ite.pD(false);
        } else if (view == this.ite.cad()) {
            showDialog(d.g.no_disturb_start_time);
        } else if (view == this.ite.cae()) {
            showDialog(d.g.no_disturb_end_time);
        } else if (view == this.ite.cap()) {
            TiebaStatic.log(new am("c13286").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.ite.itH) {
                    finish();
                    return true;
                }
                this.ite.pD(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aie().air().split(Config.TRACE_TODAY_VISIT_SPLIT);
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aie().ais().split(Config.TRACE_TODAY_VISIT_SPLIT);
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog yA(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + Config.TRACE_TODAY_VISIT_SPLIT + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == d.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().nM(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().nN(str);
                    }
                    MsgRemindActivity.this.ite.bZX();
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
            return yA(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aie().aif();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ite != null) {
            this.ite.onDestroy();
        }
    }
}
