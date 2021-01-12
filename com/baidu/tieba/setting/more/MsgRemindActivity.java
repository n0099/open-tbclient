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
/* loaded from: classes7.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private g mXD;
    private MsgRemindModel mXs;
    private MsgRemindModel.a mXu = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mXD.dFn().turnOffNoCallback();
                        MsgRemindActivity.this.mXD.xx(false);
                        MsgRemindActivity.this.mXD.xw(false);
                        return;
                    }
                    MsgRemindActivity.this.mXD.dFn().turnOnNoCallback();
                    MsgRemindActivity.this.mXD.xx(true);
                    MsgRemindActivity.this.mXD.xw(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mXD.dFo().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.mXD.dFo().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bxM().kt(z2);
                } else if (z2) {
                    MsgRemindActivity.this.mXD.dFp().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.mXD.dFp().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mXD.dGd().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.mXD.dGd().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().ku(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e mXE = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.mXD != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.mXD.dFC();
                MsgRemindActivity.this.mXD.dGe();
            }
        }
    };
    private MsgRemindModel.a mVe = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dFF = MsgRemindActivity.this.mXD.dFF();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bxM().qp(300);
                        MsgRemindActivity.this.mXD.xA(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bxM().qp(0);
                        MsgRemindActivity.this.mXD.xA(false);
                    }
                    if (dFF != null) {
                        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dFF.turnOnNoCallback();
                                } else {
                                    dFF.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dFF != null) {
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dFF.turnOffNoCallback();
                            } else {
                                dFF.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bxM().kr(z2);
                }
                MsgRemindActivity.this.mXD.dFZ();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bxM().ks(z2);
                }
                MsgRemindActivity.this.mXD.dGa();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bxM().ki(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.mXD.dGc();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bxM().kh(z2);
                }
                MsgRemindActivity.this.mXD.dGb();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bxM().kq(z2);
                }
                MsgRemindActivity.this.mXD.dFX();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bxM().kj(z2);
                }
                MsgRemindActivity.this.mXD.dFY();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mXD = new g(this);
        this.mXD.b(this);
        this.mXs = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mXD.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mXD.dFE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().setSignAlertOn(true);
                TiebaStatic.log(new aq("c12939").an("obj_type", 2));
                TiebaStatic.log(new aq("c13254").an("obj_type", 1));
                this.mXD.dFC();
                this.mXD.xz(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().setSignAlertOn(false);
                TiebaStatic.log(new aq("c12939").an("obj_type", 1));
                TiebaStatic.log(new aq("c13254").an("obj_type", 0));
                this.mXD.xz(false);
            }
            a(switchState, 7);
        } else if (view == this.mXD.dFF()) {
            this.mXs.a(14, switchState == BdSwitchView.SwitchState.ON, this.mVe);
        } else if (view == this.mXD.dFH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().kl(true);
                this.mXD.xy(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bxM().kl(false);
            this.mXD.xy(false);
        } else if (view == this.mXD.dFL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().ko(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().ko(false);
            }
        } else if (view == this.mXD.dFM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().km(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().km(false);
            }
        } else if (view == this.mXD.dFN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().kn(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().kn(false);
            }
        } else if (view == this.mXD.dFO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().kp(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bxM().kp(false);
            }
        } else if (view == this.mXD.dFP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mXs.a(1, true, this.mVe);
            } else {
                this.mXs.a(1, false, this.mVe);
            }
            a(switchState, 1);
        } else if (view == this.mXD.dFQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mXs.a(20, true, this.mVe);
            } else {
                this.mXs.a(20, false, this.mVe);
            }
            a(switchState, 2);
        } else if (view == this.mXD.dFR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mXs.a(2, true, this.mVe);
            } else {
                this.mXs.a(2, false, this.mVe);
            }
            a(switchState, 3);
        } else if (view == this.mXD.dFS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mXs.a(5, true, this.mVe);
            } else {
                this.mXs.a(5, false, this.mVe);
            }
        } else if (view == this.mXD.dFT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mXs.a(4, true, this.mVe);
            } else {
                this.mXs.a(4, false, this.mVe);
            }
        } else if (view == this.mXD.dFU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mXs.a(3, true, this.mVe);
            } else {
                this.mXs.a(3, false, this.mVe);
            }
            a(switchState, 4);
        } else if (view == this.mXD.dFn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mXs.a(8, true, this.mXu);
                this.mXD.xx(true);
                this.mXD.xw(true);
            } else {
                this.mXs.a(8, false, this.mXu);
                this.mXD.xx(false);
                this.mXD.xw(false);
            }
            a(switchState, 5);
        } else if (view == this.mXD.dFo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mXs.a(9, true, this.mXu);
            } else {
                this.mXs.a(9, false, this.mXu);
            }
            a(switchState, 6);
        } else if (view == this.mXD.dFp()) {
            this.mXs.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mXu);
            a(switchState, 9);
        } else if (view == this.mXD.dGd()) {
            this.mXs.a(6, switchState == BdSwitchView.SwitchState.OFF, this.mXu);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new aq("c13889").an("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).an("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mXD.Tf().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mXD.Tf()) {
            if (this.mXD.mYg) {
                finish();
            } else {
                this.mXD.xB(true);
            }
        } else if (view == this.mXD.dFG()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.byi().a(getPageContext(), this.mXE);
        } else if (view == this.mXD.dFI()) {
            this.mXD.xB(false);
        } else if (view == this.mXD.dFJ()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.mXD.dFK()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.mXD.dFV()) {
            TiebaStatic.log(new aq("c13286").dW("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mXD.dFW()) {
            com.baidu.tbadk.core.b.a.bkS().bkU();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dFq();
        }
    }

    private void dFq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.nt(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.Ad(getString(R.string.push_permission_guide_des));
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
        aVar.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aq aqVar = new aq("c13673");
                aqVar.an("obj_source", 8);
                TiebaStatic.log(aqVar);
            }
        });
        aVar.b(getPageContext()).bqe();
        aq aqVar = new aq("c13674");
        aqVar.an("obj_source", 8);
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.mXD.mYg) {
                    finish();
                    return true;
                }
                this.mXD.xB(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxZ().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bya().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog Ir(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.6
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bxM().BL(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bxM().BM(str);
                    }
                    MsgRemindActivity.this.mXD.dFD();
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
            return Ir(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxN();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mXD != null) {
            this.mXD.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mXD != null) {
            this.mXD.onResume();
        }
    }
}
