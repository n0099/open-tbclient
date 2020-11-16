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
/* loaded from: classes25.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private g mIL;
    private MsgRemindModel mIz;
    private MsgRemindModel.a mIB = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mIL.dEd().turnOffNoCallback();
                        MsgRemindActivity.this.mIL.wW(false);
                        MsgRemindActivity.this.mIL.wV(false);
                        return;
                    }
                    MsgRemindActivity.this.mIL.dEd().turnOnNoCallback();
                    MsgRemindActivity.this.mIL.wW(true);
                    MsgRemindActivity.this.mIL.wV(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mIL.dEe().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.mIL.dEe().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jL(z2);
                } else if (z2) {
                    MsgRemindActivity.this.mIL.dEf().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.mIL.dEf().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mIL.dET().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.mIL.dET().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jM(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e mIM = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.mIL != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.mIL.dEs();
                MsgRemindActivity.this.mIL.dEU();
            }
        }
    };
    private MsgRemindModel.a mGi = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dEv = MsgRemindActivity.this.mIL.dEv();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bvL().ri(300);
                        MsgRemindActivity.this.mIL.wZ(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bvL().ri(0);
                        MsgRemindActivity.this.mIL.wZ(false);
                    }
                    if (dEv != null) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dEv.turnOnNoCallback();
                                } else {
                                    dEv.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dEv != null) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dEv.turnOffNoCallback();
                            } else {
                                dEv.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jJ(z2);
                }
                MsgRemindActivity.this.mIL.dEP();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jK(z2);
                }
                MsgRemindActivity.this.mIL.dEQ();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jA(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.mIL.dES();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jz(z2);
                }
                MsgRemindActivity.this.mIL.dER();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jI(z2);
                }
                MsgRemindActivity.this.mIL.dEN();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jB(z2);
                }
                MsgRemindActivity.this.mIL.dEO();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mIL = new g(this);
        this.mIL.b(this);
        this.mIz = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mIL.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mIL.dEu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().setSignAlertOn(true);
                TiebaStatic.log(new ar("c12939").ak("obj_type", 2));
                TiebaStatic.log(new ar("c13254").ak("obj_type", 1));
                this.mIL.dEs();
                this.mIL.wY(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().setSignAlertOn(false);
                TiebaStatic.log(new ar("c12939").ak("obj_type", 1));
                TiebaStatic.log(new ar("c13254").ak("obj_type", 0));
                this.mIL.wY(false);
            }
            a(switchState, 7);
        } else if (view == this.mIL.dEv()) {
            this.mIz.a(14, switchState == BdSwitchView.SwitchState.ON, this.mGi);
        } else if (view == this.mIL.dEx()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jD(true);
                this.mIL.wX(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jD(false);
            this.mIL.wX(false);
        } else if (view == this.mIL.dEB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jG(false);
            }
        } else if (view == this.mIL.dEC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jE(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jE(false);
            }
        } else if (view == this.mIL.dED()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jF(false);
            }
        } else if (view == this.mIL.dEE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jH(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bvL().jH(false);
            }
        } else if (view == this.mIL.dEF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mIz.a(1, true, this.mGi);
            } else {
                this.mIz.a(1, false, this.mGi);
            }
            a(switchState, 1);
        } else if (view == this.mIL.dEG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mIz.a(20, true, this.mGi);
            } else {
                this.mIz.a(20, false, this.mGi);
            }
            a(switchState, 2);
        } else if (view == this.mIL.dEH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mIz.a(2, true, this.mGi);
            } else {
                this.mIz.a(2, false, this.mGi);
            }
            a(switchState, 3);
        } else if (view == this.mIL.dEI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mIz.a(5, true, this.mGi);
            } else {
                this.mIz.a(5, false, this.mGi);
            }
        } else if (view == this.mIL.dEJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mIz.a(4, true, this.mGi);
            } else {
                this.mIz.a(4, false, this.mGi);
            }
        } else if (view == this.mIL.dEK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mIz.a(3, true, this.mGi);
            } else {
                this.mIz.a(3, false, this.mGi);
            }
            a(switchState, 4);
        } else if (view == this.mIL.dEd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mIz.a(8, true, this.mIB);
                this.mIL.wW(true);
                this.mIL.wV(true);
            } else {
                this.mIz.a(8, false, this.mIB);
                this.mIL.wW(false);
                this.mIL.wV(false);
            }
            a(switchState, 5);
        } else if (view == this.mIL.dEe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mIz.a(9, true, this.mIB);
            } else {
                this.mIz.a(9, false, this.mIB);
            }
            a(switchState, 6);
        } else if (view == this.mIL.dEf()) {
            this.mIz.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mIB);
            a(switchState, 9);
        } else if (view == this.mIL.dET()) {
            this.mIz.a(6, switchState == BdSwitchView.SwitchState.OFF, this.mIB);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new ar("c13889").ak("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).ak("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mIL.Tv().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mIL.Tv()) {
            if (this.mIL.mJo) {
                finish();
            } else {
                this.mIL.xa(true);
            }
        } else if (view == this.mIL.dEw()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bwh().a(getPageContext(), this.mIM);
        } else if (view == this.mIL.dEy()) {
            this.mIL.xa(false);
        } else if (view == this.mIL.dEz()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.mIL.dEA()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.mIL.dEL()) {
            TiebaStatic.log(new ar("c13286").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mIL.dEM()) {
            com.baidu.tbadk.core.b.a.bja().bjc();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dEg();
        }
    }

    private void dEg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.or(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.AJ(getString(R.string.push_permission_guide_des));
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
                arVar.ak("obj_source", 8);
                TiebaStatic.log(arVar);
            }
        });
        aVar.b(getPageContext()).bog();
        ar arVar = new ar("c13674");
        arVar.ak("obj_source", 8);
        TiebaStatic.log(arVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.mIL.mJo) {
                    finish();
                    return true;
                }
                this.mIL.xa(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvY().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvZ().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog Jn(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.6
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bvL().Cr(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bvL().Cs(str);
                    }
                    MsgRemindActivity.this.mIL.dEt();
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
            return Jn(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvM();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mIL != null) {
            this.mIL.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mIL != null) {
            this.mIL.onResume();
        }
    }
}
