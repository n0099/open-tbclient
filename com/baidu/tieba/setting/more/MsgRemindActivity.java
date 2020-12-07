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
    private MsgRemindModel mWA;
    private g mWL;
    private MsgRemindModel.a mWC = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mWL.dJo().turnOffNoCallback();
                        MsgRemindActivity.this.mWL.xA(false);
                        MsgRemindActivity.this.mWL.xz(false);
                        return;
                    }
                    MsgRemindActivity.this.mWL.dJo().turnOnNoCallback();
                    MsgRemindActivity.this.mWL.xA(true);
                    MsgRemindActivity.this.mWL.xz(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mWL.dJp().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.mWL.dJp().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().kb(z2);
                } else if (z2) {
                    MsgRemindActivity.this.mWL.dJq().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.mWL.dJq().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mWL.dKe().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.mWL.dKe().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().kc(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e mWN = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.mWL != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.mWL.dJD();
                MsgRemindActivity.this.mWL.dKf();
            }
        }
    };
    private MsgRemindModel.a mUm = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dJG = MsgRemindActivity.this.mWL.dJG();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().rJ(300);
                        MsgRemindActivity.this.mWL.xD(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().rJ(0);
                        MsgRemindActivity.this.mWL.xD(false);
                    }
                    if (dJG != null) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dJG.turnOnNoCallback();
                                } else {
                                    dJG.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dJG != null) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dJG.turnOffNoCallback();
                            } else {
                                dJG.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jZ(z2);
                }
                MsgRemindActivity.this.mWL.dKa();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().ka(z2);
                }
                MsgRemindActivity.this.mWL.dKb();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jQ(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.mWL.dKd();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jP(z2);
                }
                MsgRemindActivity.this.mWL.dKc();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jY(z2);
                }
                MsgRemindActivity.this.mWL.dJY();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jR(z2);
                }
                MsgRemindActivity.this.mWL.dJZ();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mWL = new g(this);
        this.mWL.b(this);
        this.mWA = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mWL.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mWL.dJF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().setSignAlertOn(true);
                TiebaStatic.log(new ar("c12939").al("obj_type", 2));
                TiebaStatic.log(new ar("c13254").al("obj_type", 1));
                this.mWL.dJD();
                this.mWL.xC(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().setSignAlertOn(false);
                TiebaStatic.log(new ar("c12939").al("obj_type", 1));
                TiebaStatic.log(new ar("c13254").al("obj_type", 0));
                this.mWL.xC(false);
            }
            a(switchState, 7);
        } else if (view == this.mWL.dJG()) {
            this.mWA.a(14, switchState == BdSwitchView.SwitchState.ON, this.mUm);
        } else if (view == this.mWL.dJI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jT(true);
                this.mWL.xB(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jT(false);
            this.mWL.xB(false);
        } else if (view == this.mWL.dJM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jW(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jW(false);
            }
        } else if (view == this.mWL.dJN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jU(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jU(false);
            }
        } else if (view == this.mWL.dJO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jV(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jV(false);
            }
        } else if (view == this.mWL.dJP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jX(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jX(false);
            }
        } else if (view == this.mWL.dJQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWA.a(1, true, this.mUm);
            } else {
                this.mWA.a(1, false, this.mUm);
            }
            a(switchState, 1);
        } else if (view == this.mWL.dJR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWA.a(20, true, this.mUm);
            } else {
                this.mWA.a(20, false, this.mUm);
            }
            a(switchState, 2);
        } else if (view == this.mWL.dJS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWA.a(2, true, this.mUm);
            } else {
                this.mWA.a(2, false, this.mUm);
            }
            a(switchState, 3);
        } else if (view == this.mWL.dJT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWA.a(5, true, this.mUm);
            } else {
                this.mWA.a(5, false, this.mUm);
            }
        } else if (view == this.mWL.dJU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWA.a(4, true, this.mUm);
            } else {
                this.mWA.a(4, false, this.mUm);
            }
        } else if (view == this.mWL.dJV()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWA.a(3, true, this.mUm);
            } else {
                this.mWA.a(3, false, this.mUm);
            }
            a(switchState, 4);
        } else if (view == this.mWL.dJo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWA.a(8, true, this.mWC);
                this.mWL.xA(true);
                this.mWL.xz(true);
            } else {
                this.mWA.a(8, false, this.mWC);
                this.mWL.xA(false);
                this.mWL.xz(false);
            }
            a(switchState, 5);
        } else if (view == this.mWL.dJp()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mWA.a(9, true, this.mWC);
            } else {
                this.mWA.a(9, false, this.mWC);
            }
            a(switchState, 6);
        } else if (view == this.mWL.dJq()) {
            this.mWA.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mWC);
            a(switchState, 9);
        } else if (view == this.mWL.dKe()) {
            this.mWA.a(6, switchState == BdSwitchView.SwitchState.OFF, this.mWC);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new ar("c13889").al("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).al("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mWL.VV().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mWL.VV()) {
            if (this.mWL.mXp) {
                finish();
            } else {
                this.mWL.xE(true);
            }
        } else if (view == this.mWL.dJH()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bzH().a(getPageContext(), this.mWN);
        } else if (view == this.mWL.dJJ()) {
            this.mWL.xE(false);
        } else if (view == this.mWL.dJK()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.mWL.dJL()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.mWL.dJW()) {
            TiebaStatic.log(new ar("c13286").dY("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mWL.dJX()) {
            com.baidu.tbadk.core.b.a.bmk().bmm();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dJr();
        }
    }

    private void dJr() {
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
                if (this.mWL.mXp) {
                    finish();
                    return true;
                }
                this.mWL.xE(true);
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
                    MsgRemindActivity.this.mWL.dJE();
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
        if (this.mWL != null) {
            this.mWL.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mWL != null) {
            this.mWL.onResume();
        }
    }
}
