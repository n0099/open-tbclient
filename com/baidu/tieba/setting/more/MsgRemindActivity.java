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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import java.util.Date;
/* loaded from: classes26.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel mWC;
    private g mWO;
    private MsgRemindModel.a mWE = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mWO.dJp().turnOffNoCallback();
                        MsgRemindActivity.this.mWO.xA(false);
                        MsgRemindActivity.this.mWO.xz(false);
                        return;
                    }
                    MsgRemindActivity.this.mWO.dJp().turnOnNoCallback();
                    MsgRemindActivity.this.mWO.xA(true);
                    MsgRemindActivity.this.mWO.xz(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mWO.dJq().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.mWO.dJq().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().kb(z2);
                } else if (z2) {
                    MsgRemindActivity.this.mWO.dJr().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.mWO.dJr().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mWO.dKf().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.mWO.dKf().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().kc(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e mWP = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.mWO != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.mWO.dJE();
                MsgRemindActivity.this.mWO.dKg();
            }
        }
    };
    private MsgRemindModel.a mUo = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dJH = MsgRemindActivity.this.mWO.dJH();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().rJ(300);
                        MsgRemindActivity.this.mWO.xD(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().rJ(0);
                        MsgRemindActivity.this.mWO.xD(false);
                    }
                    if (dJH != null) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dJH.turnOnNoCallback();
                                } else {
                                    dJH.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dJH != null) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dJH.turnOffNoCallback();
                            } else {
                                dJH.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jZ(z2);
                }
                MsgRemindActivity.this.mWO.dKb();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().ka(z2);
                }
                MsgRemindActivity.this.mWO.dKc();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jQ(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.mWO.dKe();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jP(z2);
                }
                MsgRemindActivity.this.mWO.dKd();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jY(z2);
                }
                MsgRemindActivity.this.mWO.dJZ();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jR(z2);
                }
                MsgRemindActivity.this.mWO.dKa();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mWO = new g(this);
        this.mWO.b(this);
        this.mWC = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mWO.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mWO.dJG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().setSignAlertOn(true);
                TiebaStatic.log(new ar("c12939").al("obj_type", 2));
                TiebaStatic.log(new ar("c13254").al("obj_type", 1));
                this.mWO.dJE();
                this.mWO.xC(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().setSignAlertOn(false);
                TiebaStatic.log(new ar("c12939").al("obj_type", 1));
                TiebaStatic.log(new ar("c13254").al("obj_type", 0));
                this.mWO.xC(false);
            }
            a(switchState, 7);
        } else if (view == this.mWO.dJH()) {
            this.mWC.a(14, switchState == BdSwitchView.SwitchState.ON, this.mUo);
        } else if (view == this.mWO.dJJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jT(true);
                this.mWO.xB(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jT(false);
            this.mWO.xB(false);
        } else if (view == this.mWO.dJN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jW(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jW(false);
            }
        } else if (view == this.mWO.dJO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jU(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jU(false);
            }
        } else if (view == this.mWO.dJP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jV(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jV(false);
            }
        } else if (view == this.mWO.dJQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jX(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jX(false);
            }
        } else if (view == this.mWO.dJR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWC.a(1, true, this.mUo);
            } else {
                this.mWC.a(1, false, this.mUo);
            }
            a(switchState, 1);
        } else if (view == this.mWO.dJS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWC.a(20, true, this.mUo);
            } else {
                this.mWC.a(20, false, this.mUo);
            }
            a(switchState, 2);
        } else if (view == this.mWO.dJT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWC.a(2, true, this.mUo);
            } else {
                this.mWC.a(2, false, this.mUo);
            }
            a(switchState, 3);
        } else if (view == this.mWO.dJU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWC.a(5, true, this.mUo);
            } else {
                this.mWC.a(5, false, this.mUo);
            }
        } else if (view == this.mWO.dJV()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWC.a(4, true, this.mUo);
            } else {
                this.mWC.a(4, false, this.mUo);
            }
        } else if (view == this.mWO.dJW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWC.a(3, true, this.mUo);
            } else {
                this.mWC.a(3, false, this.mUo);
            }
            a(switchState, 4);
        } else if (view == this.mWO.dJp()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWC.a(8, true, this.mWE);
                this.mWO.xA(true);
                this.mWO.xz(true);
            } else {
                this.mWC.a(8, false, this.mWE);
                this.mWO.xA(false);
                this.mWO.xz(false);
            }
            a(switchState, 5);
        } else if (view == this.mWO.dJq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWC.a(9, true, this.mWE);
            } else {
                this.mWC.a(9, false, this.mWE);
            }
            a(switchState, 6);
        } else if (view == this.mWO.dJr()) {
            this.mWC.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mWE);
            a(switchState, 9);
        } else if (view == this.mWO.dKf()) {
            this.mWC.a(6, switchState == BdSwitchView.SwitchState.OFF, this.mWE);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new ar("c13889").al("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).al("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mWO.VV().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mWO.VV()) {
            if (this.mWO.mXr) {
                finish();
            } else {
                this.mWO.xE(true);
            }
        } else if (view == this.mWO.dJI()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bzH().a(getPageContext(), this.mWP);
        } else if (view == this.mWO.dJK()) {
            this.mWO.xE(false);
        } else if (view == this.mWO.dJL()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.mWO.dJM()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.mWO.dJX()) {
            TiebaStatic.log(new ar("c13286").dY("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mWO.dJY()) {
            com.baidu.tbadk.core.b.a.bmk().bmm();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dJs();
        }
    }

    private void dJs() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.oP(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.Bq(getString(R.string.push_permission_guide_des));
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
                ar arVar = new ar("c13673");
                arVar.al("obj_source", 8);
                TiebaStatic.log(arVar);
            }
        });
        aVar.b(getPageContext()).brv();
        ar arVar = new ar("c13674");
        arVar.al("obj_source", 8);
        TiebaStatic.log(arVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.mWO.mXr) {
                    finish();
                    return true;
                }
                this.mWO.xE(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzy().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzz().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog Ke(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.6
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().CZ(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().Da(str);
                    }
                    MsgRemindActivity.this.mWO.dJF();
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
            return Ke(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzm();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mWO != null) {
            this.mWO.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mWO != null) {
            this.mWO.onResume();
        }
    }
}
