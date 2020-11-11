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
/* loaded from: classes26.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel mHX;
    private g mIj;
    private MsgRemindModel.a mHZ = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mIj.dEy().turnOffNoCallback();
                        MsgRemindActivity.this.mIj.wT(false);
                        MsgRemindActivity.this.mIj.wS(false);
                        return;
                    }
                    MsgRemindActivity.this.mIj.dEy().turnOnNoCallback();
                    MsgRemindActivity.this.mIj.wT(true);
                    MsgRemindActivity.this.mIj.wS(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mIj.dEz().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.mIj.dEz().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jK(z2);
                } else if (z2) {
                    MsgRemindActivity.this.mIj.dEA().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.mIj.dEA().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mIj.dFo().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.mIj.dFo().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jL(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e mIk = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.mIj != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.mIj.dEN();
                MsgRemindActivity.this.mIj.dFp();
            }
        }
    };
    private MsgRemindModel.a mFL = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dEQ = MsgRemindActivity.this.mIj.dEQ();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bwv().qK(300);
                        MsgRemindActivity.this.mIj.wW(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bwv().qK(0);
                        MsgRemindActivity.this.mIj.wW(false);
                    }
                    if (dEQ != null) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dEQ.turnOnNoCallback();
                                } else {
                                    dEQ.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dEQ != null) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dEQ.turnOffNoCallback();
                            } else {
                                dEQ.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jI(z2);
                }
                MsgRemindActivity.this.mIj.dFk();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jJ(z2);
                }
                MsgRemindActivity.this.mIj.dFl();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jz(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.mIj.dFn();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jy(z2);
                }
                MsgRemindActivity.this.mIj.dFm();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jH(z2);
                }
                MsgRemindActivity.this.mIj.dFi();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jA(z2);
                }
                MsgRemindActivity.this.mIj.dFj();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mIj = new g(this);
        this.mIj.b(this);
        this.mHX = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mIj.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mIj.dEP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().setSignAlertOn(true);
                TiebaStatic.log(new aq("c12939").al("obj_type", 2));
                TiebaStatic.log(new aq("c13254").al("obj_type", 1));
                this.mIj.dEN();
                this.mIj.wV(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().setSignAlertOn(false);
                TiebaStatic.log(new aq("c12939").al("obj_type", 1));
                TiebaStatic.log(new aq("c13254").al("obj_type", 0));
                this.mIj.wV(false);
            }
            a(switchState, 7);
        } else if (view == this.mIj.dEQ()) {
            this.mHX.a(14, switchState == BdSwitchView.SwitchState.ON, this.mFL);
        } else if (view == this.mIj.dES()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jC(true);
                this.mIj.wU(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jC(false);
            this.mIj.wU(false);
        } else if (view == this.mIj.dEW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jF(false);
            }
        } else if (view == this.mIj.dEX()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jD(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jD(false);
            }
        } else if (view == this.mIj.dEY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jE(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jE(false);
            }
        } else if (view == this.mIj.dEZ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bwv().jG(false);
            }
        } else if (view == this.mIj.dFa()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mHX.a(1, true, this.mFL);
            } else {
                this.mHX.a(1, false, this.mFL);
            }
            a(switchState, 1);
        } else if (view == this.mIj.dFb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mHX.a(20, true, this.mFL);
            } else {
                this.mHX.a(20, false, this.mFL);
            }
            a(switchState, 2);
        } else if (view == this.mIj.dFc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mHX.a(2, true, this.mFL);
            } else {
                this.mHX.a(2, false, this.mFL);
            }
            a(switchState, 3);
        } else if (view == this.mIj.dFd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mHX.a(5, true, this.mFL);
            } else {
                this.mHX.a(5, false, this.mFL);
            }
        } else if (view == this.mIj.dFe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mHX.a(4, true, this.mFL);
            } else {
                this.mHX.a(4, false, this.mFL);
            }
        } else if (view == this.mIj.dFf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mHX.a(3, true, this.mFL);
            } else {
                this.mHX.a(3, false, this.mFL);
            }
            a(switchState, 4);
        } else if (view == this.mIj.dEy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mHX.a(8, true, this.mHZ);
                this.mIj.wT(true);
                this.mIj.wS(true);
            } else {
                this.mHX.a(8, false, this.mHZ);
                this.mIj.wT(false);
                this.mIj.wS(false);
            }
            a(switchState, 5);
        } else if (view == this.mIj.dEz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mHX.a(9, true, this.mHZ);
            } else {
                this.mHX.a(9, false, this.mHZ);
            }
            a(switchState, 6);
        } else if (view == this.mIj.dEA()) {
            this.mHX.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mHZ);
            a(switchState, 9);
        } else if (view == this.mIj.dFo()) {
            this.mHX.a(6, switchState == BdSwitchView.SwitchState.OFF, this.mHZ);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new aq("c13889").al("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).al("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mIj.Ue().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mIj.Ue()) {
            if (this.mIj.mIP) {
                finish();
            } else {
                this.mIj.wX(true);
            }
        } else if (view == this.mIj.dER()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bwR().a(getPageContext(), this.mIk);
        } else if (view == this.mIj.dET()) {
            this.mIj.wX(false);
        } else if (view == this.mIj.dEU()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.mIj.dEV()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.mIj.dFg()) {
            TiebaStatic.log(new aq("c13286").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mIj.dFh()) {
            com.baidu.tbadk.core.b.a.bjW().bjY();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dEB();
        }
    }

    private void dEB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.ov(R.string.push_permission_guide_title);
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
                aqVar.al("obj_source", 8);
                TiebaStatic.log(aqVar);
            }
        });
        aVar.b(getPageContext()).bpc();
        aq aqVar = new aq("c13674");
        aqVar.al("obj_source", 8);
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.mIj.mIP) {
                    finish();
                    return true;
                }
                this.mIj.wX(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwI().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwJ().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog IM(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.6
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bwv().CS(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bwv().CT(str);
                    }
                    MsgRemindActivity.this.mIj.dEO();
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
            return IM(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bww();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mIj != null) {
            this.mIj.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mIj != null) {
            this.mIj.onResume();
        }
    }
}
