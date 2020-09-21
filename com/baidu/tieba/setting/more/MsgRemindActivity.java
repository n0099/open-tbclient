package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TimePicker;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import java.util.Date;
/* loaded from: classes25.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel lZN;
    private g lZY;
    private MsgRemindModel.a lZP = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.lZY.dvd().turnOffNoCallback();
                        MsgRemindActivity.this.lZY.vM(false);
                        MsgRemindActivity.this.lZY.vL(false);
                        return;
                    }
                    MsgRemindActivity.this.lZY.dvd().turnOnNoCallback();
                    MsgRemindActivity.this.lZY.vM(true);
                    MsgRemindActivity.this.lZY.vL(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.lZY.dve().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.lZY.dve().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bps().iQ(z2);
                } else if (z2) {
                    MsgRemindActivity.this.lZY.dvf().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.lZY.dvf().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.lZY.dvT().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.lZY.dvT().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().iR(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e lZZ = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.lZY != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.lZY.dvs();
                MsgRemindActivity.this.lZY.dvU();
            }
        }
    };
    private MsgRemindModel.a lXC = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dvv = MsgRemindActivity.this.lZY.dvv();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bps().pR(300);
                        MsgRemindActivity.this.lZY.vP(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bps().pR(0);
                        MsgRemindActivity.this.lZY.vP(false);
                    }
                    if (dvv != null) {
                        com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dvv.turnOnNoCallback();
                                } else {
                                    dvv.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dvv != null) {
                    com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dvv.turnOffNoCallback();
                            } else {
                                dvv.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bps().iO(z2);
                }
                MsgRemindActivity.this.lZY.dvP();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bps().iP(z2);
                }
                MsgRemindActivity.this.lZY.dvQ();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bps().iF(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.lZY.dvS();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bps().iE(z2);
                }
                MsgRemindActivity.this.lZY.dvR();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bps().iN(z2);
                }
                MsgRemindActivity.this.lZY.dvN();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bps().iG(z2);
                }
                MsgRemindActivity.this.lZY.dvO();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lZY = new g(this);
        this.lZY.b(this);
        this.lZN = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lZY.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.lZY.dvu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().setSignAlertOn(true);
                TiebaStatic.log(new aq("c12939").ai("obj_type", 2));
                TiebaStatic.log(new aq("c13254").ai("obj_type", 1));
                this.lZY.dvs();
                this.lZY.vO(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().setSignAlertOn(false);
                TiebaStatic.log(new aq("c12939").ai("obj_type", 1));
                TiebaStatic.log(new aq("c13254").ai("obj_type", 0));
                this.lZY.vO(false);
            }
            a(switchState, 7);
        } else if (view == this.lZY.dvv()) {
            this.lZN.a(14, switchState == BdSwitchView.SwitchState.ON, this.lXC);
        } else if (view == this.lZY.dvx()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().iI(true);
                this.lZY.vN(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bps().iI(false);
            this.lZY.vN(false);
        } else if (view == this.lZY.dvB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().iL(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().iL(false);
            }
        } else if (view == this.lZY.dvC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().iJ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().iJ(false);
            }
        } else if (view == this.lZY.dvD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().iK(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().iK(false);
            }
        } else if (view == this.lZY.dvE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().iM(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bps().iM(false);
            }
        } else if (view == this.lZY.dvF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lZN.a(1, true, this.lXC);
            } else {
                this.lZN.a(1, false, this.lXC);
            }
            a(switchState, 1);
        } else if (view == this.lZY.dvG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lZN.a(20, true, this.lXC);
            } else {
                this.lZN.a(20, false, this.lXC);
            }
            a(switchState, 2);
        } else if (view == this.lZY.dvH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lZN.a(2, true, this.lXC);
            } else {
                this.lZN.a(2, false, this.lXC);
            }
            a(switchState, 3);
        } else if (view == this.lZY.dvI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lZN.a(5, true, this.lXC);
            } else {
                this.lZN.a(5, false, this.lXC);
            }
        } else if (view == this.lZY.dvJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lZN.a(4, true, this.lXC);
            } else {
                this.lZN.a(4, false, this.lXC);
            }
        } else if (view == this.lZY.dvK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lZN.a(3, true, this.lXC);
            } else {
                this.lZN.a(3, false, this.lXC);
            }
            a(switchState, 4);
        } else if (view == this.lZY.dvd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lZN.a(8, true, this.lZP);
                this.lZY.vM(true);
                this.lZY.vL(true);
            } else {
                this.lZN.a(8, false, this.lZP);
                this.lZY.vM(false);
                this.lZY.vL(false);
            }
            a(switchState, 5);
        } else if (view == this.lZY.dve()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lZN.a(9, true, this.lZP);
            } else {
                this.lZN.a(9, false, this.lZP);
            }
            a(switchState, 6);
        } else if (view == this.lZY.dvf()) {
            this.lZN.a(7, switchState == BdSwitchView.SwitchState.OFF, this.lZP);
            a(switchState, 9);
        } else if (view == this.lZY.dvT()) {
            this.lZN.a(6, switchState == BdSwitchView.SwitchState.OFF, this.lZP);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new aq("c13889").ai("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).ai("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.lZY.Pw().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lZY.Pw()) {
            if (this.lZY.maE) {
                finish();
            } else {
                this.lZY.vQ(true);
            }
        } else if (view == this.lZY.dvw()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bpO().a(getPageContext(), this.lZZ);
        } else if (view == this.lZY.dvy()) {
            this.lZY.vQ(false);
        } else if (view == this.lZY.dvz()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.lZY.dvA()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.lZY.dvL()) {
            TiebaStatic.log(new aq("c13286").dF("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.lZY.dvM()) {
            com.baidu.tbadk.core.b.a.bcV().bcX();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dvg();
        }
    }

    private void dvg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.nD(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.zV(getString(R.string.push_permission_guide_des));
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(R.string.go_to_set, new a.b() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tbadk.coreExtra.c.a.f(MsgRemindActivity.this.getPageContext());
                aVar2.dismiss();
            }
        });
        aVar.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aq aqVar = new aq("c13673");
                aqVar.ai("obj_source", 8);
                TiebaStatic.log(aqVar);
            }
        });
        aVar.b(getPageContext()).bia();
        aq aqVar = new aq("c13674");
        aqVar.ai("obj_source", 8);
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.lZY.maE) {
                    finish();
                    return true;
                }
                this.lZY.vQ(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == R.id.no_disturb_start_time || i == R.id.no_disturb_end_time) {
                if (i == R.id.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpF().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpG().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog HA(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.6
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bps().Bz(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bps().BA(str);
                    }
                    MsgRemindActivity.this.lZY.dvt();
                }
            }
        }, 0, 0, true);
        if (i == R.id.no_disturb_end_time) {
            bVar.setTitle(R.string.no_disturb_end_time);
        } else if (i == R.id.no_disturb_start_time) {
            bVar.setTitle(R.string.no_disturb_start_time);
        }
        bVar.setButton(-1, getPageContext().getString(R.string.alert_yes_button), bVar);
        bVar.setButton(-2, getPageContext().getString(R.string.cancel), bVar);
        bVar.getWindow().setSoftInputMode(2);
        return bVar;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        if (i == R.id.no_disturb_end_time || i == R.id.no_disturb_start_time) {
            return HA(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpt();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lZY != null) {
            this.lZY.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lZY != null) {
            this.lZY.onResume();
        }
    }
}
