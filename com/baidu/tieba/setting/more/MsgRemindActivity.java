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
/* loaded from: classes8.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel nbX;
    private g nci;
    private MsgRemindModel.a nbZ = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.nci.dJf().turnOffNoCallback();
                        MsgRemindActivity.this.nci.xB(false);
                        MsgRemindActivity.this.nci.xA(false);
                        return;
                    }
                    MsgRemindActivity.this.nci.dJf().turnOnNoCallback();
                    MsgRemindActivity.this.nci.xB(true);
                    MsgRemindActivity.this.nci.xA(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.nci.dJg().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.nci.dJg().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kx(z2);
                } else if (z2) {
                    MsgRemindActivity.this.nci.dJh().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.nci.dJh().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.nci.dJV().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.nci.dJV().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().ky(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e ncj = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.nci != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.nci.dJu();
                MsgRemindActivity.this.nci.dJW();
            }
        }
    };
    private MsgRemindModel.a mZJ = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dJx = MsgRemindActivity.this.nci.dJx();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bBG().rV(300);
                        MsgRemindActivity.this.nci.xE(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bBG().rV(0);
                        MsgRemindActivity.this.nci.xE(false);
                    }
                    if (dJx != null) {
                        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dJx.turnOnNoCallback();
                                } else {
                                    dJx.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dJx != null) {
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dJx.turnOffNoCallback();
                            } else {
                                dJx.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kv(z2);
                }
                MsgRemindActivity.this.nci.dJR();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kw(z2);
                }
                MsgRemindActivity.this.nci.dJS();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBG().km(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.nci.dJU();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kl(z2);
                }
                MsgRemindActivity.this.nci.dJT();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBG().ku(z2);
                }
                MsgRemindActivity.this.nci.dJP();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kn(z2);
                }
                MsgRemindActivity.this.nci.dJQ();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nci = new g(this);
        this.nci.b(this);
        this.nbX = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.nci.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.nci.dJw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().setSignAlertOn(true);
                TiebaStatic.log(new aq("c12939").an("obj_type", 2));
                TiebaStatic.log(new aq("c13254").an("obj_type", 1));
                this.nci.dJu();
                this.nci.xD(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().setSignAlertOn(false);
                TiebaStatic.log(new aq("c12939").an("obj_type", 1));
                TiebaStatic.log(new aq("c13254").an("obj_type", 0));
                this.nci.xD(false);
            }
            a(switchState, 7);
        } else if (view == this.nci.dJx()) {
            this.nbX.a(14, switchState == BdSwitchView.SwitchState.ON, this.mZJ);
        } else if (view == this.nci.dJz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kp(true);
                this.nci.xC(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kp(false);
            this.nci.xC(false);
        } else if (view == this.nci.dJD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().ks(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().ks(false);
            }
        } else if (view == this.nci.dJE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kq(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kq(false);
            }
        } else if (view == this.nci.dJF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kr(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kr(false);
            }
        } else if (view == this.nci.dJG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kt(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBG().kt(false);
            }
        } else if (view == this.nci.dJH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbX.a(1, true, this.mZJ);
            } else {
                this.nbX.a(1, false, this.mZJ);
            }
            a(switchState, 1);
        } else if (view == this.nci.dJI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbX.a(20, true, this.mZJ);
            } else {
                this.nbX.a(20, false, this.mZJ);
            }
            a(switchState, 2);
        } else if (view == this.nci.dJJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbX.a(2, true, this.mZJ);
            } else {
                this.nbX.a(2, false, this.mZJ);
            }
            a(switchState, 3);
        } else if (view == this.nci.dJK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbX.a(5, true, this.mZJ);
            } else {
                this.nbX.a(5, false, this.mZJ);
            }
        } else if (view == this.nci.dJL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbX.a(4, true, this.mZJ);
            } else {
                this.nbX.a(4, false, this.mZJ);
            }
        } else if (view == this.nci.dJM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbX.a(3, true, this.mZJ);
            } else {
                this.nbX.a(3, false, this.mZJ);
            }
            a(switchState, 4);
        } else if (view == this.nci.dJf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbX.a(8, true, this.nbZ);
                this.nci.xB(true);
                this.nci.xA(true);
            } else {
                this.nbX.a(8, false, this.nbZ);
                this.nci.xB(false);
                this.nci.xA(false);
            }
            a(switchState, 5);
        } else if (view == this.nci.dJg()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbX.a(9, true, this.nbZ);
            } else {
                this.nbX.a(9, false, this.nbZ);
            }
            a(switchState, 6);
        } else if (view == this.nci.dJh()) {
            this.nbX.a(7, switchState == BdSwitchView.SwitchState.OFF, this.nbZ);
            a(switchState, 9);
        } else if (view == this.nci.dJV()) {
            this.nbX.a(6, switchState == BdSwitchView.SwitchState.OFF, this.nbZ);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new aq("c13889").an("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).an("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.nci.WY().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.nci.WY()) {
            if (this.nci.ncL) {
                finish();
            } else {
                this.nci.xF(true);
            }
        } else if (view == this.nci.dJy()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bCc().a(getPageContext(), this.ncj);
        } else if (view == this.nci.dJA()) {
            this.nci.xF(false);
        } else if (view == this.nci.dJB()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.nci.dJC()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.nci.dJN()) {
            TiebaStatic.log(new aq("c13286").dX("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.nci.dJO()) {
            com.baidu.tbadk.core.b.a.boM().boO();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dJi();
        }
    }

    private void dJi() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.oZ(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.Bo(getString(R.string.push_permission_guide_des));
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
        aVar.b(getPageContext()).btY();
        aq aqVar = new aq("c13674");
        aqVar.an("obj_source", 8);
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.nci.ncL) {
                    finish();
                    return true;
                }
                this.nci.xF(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBT().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBU().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog JY(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.6
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bBG().CW(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bBG().CX(str);
                    }
                    MsgRemindActivity.this.nci.dJv();
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
            return JY(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBH();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nci != null) {
            this.nci.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nci != null) {
            this.nci.onResume();
        }
    }
}
