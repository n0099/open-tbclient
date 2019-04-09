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
    private MsgRemindModel isU;
    private g itf;
    private final com.baidu.tbadk.widget.timepicker.a.d.e itg = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.itf != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.itf.bZW();
                MsgRemindActivity.this.itf.caw();
            }
        }
    };
    private MsgRemindModel.a iqQ = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void e(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bZZ = MsgRemindActivity.this.itf.bZZ();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().iD(300);
                        MsgRemindActivity.this.itf.pC(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().iD(0);
                        MsgRemindActivity.this.itf.pC(false);
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
                MsgRemindActivity.this.itf.cas();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().el(z2);
                }
                MsgRemindActivity.this.itf.cat();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().eb(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.itf.cav();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().ea(z2);
                }
                MsgRemindActivity.this.itf.cau();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().ej(z2);
                }
                MsgRemindActivity.this.itf.caq();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aie().ec(z2);
                }
                MsgRemindActivity.this.itf.car();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.itf = new g(this);
        this.itf.b(this);
        this.isU = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.itf.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.itf.bZY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").T("obj_type", 2));
                TiebaStatic.log(new am("c13254").T("obj_type", 1));
                this.itf.bZW();
                this.itf.pB(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aie().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").T("obj_type", 1));
            TiebaStatic.log(new am("c13254").T("obj_type", 0));
            this.itf.pB(false);
        } else if (view == this.itf.bZZ()) {
            this.isU.a(14, switchState == BdSwitchView.SwitchState.ON, this.iqQ);
        } else if (view == this.itf.cab()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().ee(true);
                this.itf.pA(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ee(false);
            this.itf.pA(false);
        } else if (view == this.itf.caf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().eh(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().eh(false);
            }
        } else if (view == this.itf.cag()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().ef(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().ef(false);
            }
        } else if (view == this.itf.cah()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().eg(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().eg(false);
            }
        } else if (view == this.itf.cai()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().ei(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aie().ei(false);
            }
        } else if (view == this.itf.caj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isU.a(1, true, this.iqQ);
            } else {
                this.isU.a(1, false, this.iqQ);
            }
        } else if (view == this.itf.cak()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isU.a(20, true, this.iqQ);
            } else {
                this.isU.a(20, false, this.iqQ);
            }
        } else if (view == this.itf.cal()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isU.a(2, true, this.iqQ);
            } else {
                this.isU.a(2, false, this.iqQ);
            }
        } else if (view == this.itf.cam()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isU.a(5, true, this.iqQ);
            } else {
                this.isU.a(5, false, this.iqQ);
            }
        } else if (view == this.itf.can()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isU.a(4, true, this.iqQ);
            } else {
                this.isU.a(4, false, this.iqQ);
            }
        } else if (view == this.itf.cao()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.isU.a(3, true, this.iqQ);
            } else {
                this.isU.a(3, false, this.iqQ);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.itf.bZQ().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.itf.bZQ()) {
            if (this.itf.itI) {
                finish();
            } else {
                this.itf.pD(true);
            }
        } else if (view == this.itf.caa()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aiz().a(getPageContext(), this.itg);
        } else if (view == this.itf.cac()) {
            this.itf.pD(false);
        } else if (view == this.itf.cad()) {
            showDialog(d.g.no_disturb_start_time);
        } else if (view == this.itf.cae()) {
            showDialog(d.g.no_disturb_end_time);
        } else if (view == this.itf.cap()) {
            TiebaStatic.log(new am("c13286").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.itf.itI) {
                    finish();
                    return true;
                }
                this.itf.pD(true);
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
                    MsgRemindActivity.this.itf.bZX();
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
        if (this.itf != null) {
            this.itf.onDestroy();
        }
    }
}
