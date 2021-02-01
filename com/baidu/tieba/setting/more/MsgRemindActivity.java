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
/* loaded from: classes8.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel nha;
    private g nhl;
    private MsgRemindModel.a nhc = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.nhl.dHy().turnOffNoCallback();
                        MsgRemindActivity.this.nhl.xQ(false);
                        MsgRemindActivity.this.nhl.xP(false);
                        return;
                    }
                    MsgRemindActivity.this.nhl.dHy().turnOnNoCallback();
                    MsgRemindActivity.this.nhl.xQ(true);
                    MsgRemindActivity.this.nhl.xP(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.nhl.dHz().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.nhl.dHz().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().kw(z2);
                } else if (z2) {
                    MsgRemindActivity.this.nhl.dHA().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.nhl.dHA().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.nhl.dIo().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.nhl.dIo().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kx(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e nhm = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.nhl != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.nhl.dHN();
                MsgRemindActivity.this.nhl.dIp();
            }
        }
    };
    private MsgRemindModel.a neN = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dHQ = MsgRemindActivity.this.nhl.dHQ();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bye().qu(300);
                        MsgRemindActivity.this.nhl.xT(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bye().qu(0);
                        MsgRemindActivity.this.nhl.xT(false);
                    }
                    if (dHQ != null) {
                        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dHQ.turnOnNoCallback();
                                } else {
                                    dHQ.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dHQ != null) {
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dHQ.turnOffNoCallback();
                            } else {
                                dHQ.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().ku(z2);
                }
                MsgRemindActivity.this.nhl.dIk();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().kv(z2);
                }
                MsgRemindActivity.this.nhl.dIl();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().kl(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.nhl.dIn();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().kk(z2);
                }
                MsgRemindActivity.this.nhl.dIm();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().kt(z2);
                }
                MsgRemindActivity.this.nhl.dIi();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().km(z2);
                }
                MsgRemindActivity.this.nhl.dIj();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nhl = new g(this);
        this.nhl.b(this);
        this.nha = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.nhl.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.nhl.dHP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().setSignAlertOn(true);
                TiebaStatic.log(new ar("c12939").ap("obj_type", 2));
                TiebaStatic.log(new ar("c13254").ap("obj_type", 1));
                this.nhl.dHN();
                this.nhl.xS(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().setSignAlertOn(false);
                TiebaStatic.log(new ar("c12939").ap("obj_type", 1));
                TiebaStatic.log(new ar("c13254").ap("obj_type", 0));
                this.nhl.xS(false);
            }
            a(switchState, 7);
        } else if (view == this.nhl.dHQ()) {
            this.nha.a(14, switchState == BdSwitchView.SwitchState.ON, this.neN);
        } else if (view == this.nhl.dHS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().ko(true);
                this.nhl.xR(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bye().ko(false);
            this.nhl.xR(false);
        } else if (view == this.nhl.dHW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kr(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kr(false);
            }
        } else if (view == this.nhl.dHX()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kp(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kp(false);
            }
        } else if (view == this.nhl.dHY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kq(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kq(false);
            }
        } else if (view == this.nhl.dHZ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().ks(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().ks(false);
            }
        } else if (view == this.nhl.dIa()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nha.a(1, true, this.neN);
            } else {
                this.nha.a(1, false, this.neN);
            }
            a(switchState, 1);
        } else if (view == this.nhl.dIb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nha.a(20, true, this.neN);
            } else {
                this.nha.a(20, false, this.neN);
            }
            a(switchState, 2);
        } else if (view == this.nhl.dIc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nha.a(2, true, this.neN);
            } else {
                this.nha.a(2, false, this.neN);
            }
            a(switchState, 3);
        } else if (view == this.nhl.dId()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nha.a(5, true, this.neN);
            } else {
                this.nha.a(5, false, this.neN);
            }
        } else if (view == this.nhl.dIe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nha.a(4, true, this.neN);
            } else {
                this.nha.a(4, false, this.neN);
            }
        } else if (view == this.nhl.dIf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nha.a(3, true, this.neN);
            } else {
                this.nha.a(3, false, this.neN);
            }
            a(switchState, 4);
        } else if (view == this.nhl.dHy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nha.a(8, true, this.nhc);
                this.nhl.xQ(true);
                this.nhl.xP(true);
            } else {
                this.nha.a(8, false, this.nhc);
                this.nhl.xQ(false);
                this.nhl.xP(false);
            }
            a(switchState, 5);
        } else if (view == this.nhl.dHz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nha.a(9, true, this.nhc);
            } else {
                this.nha.a(9, false, this.nhc);
            }
            a(switchState, 6);
        } else if (view == this.nhl.dHA()) {
            this.nha.a(7, switchState == BdSwitchView.SwitchState.OFF, this.nhc);
            a(switchState, 9);
        } else if (view == this.nhl.dIo()) {
            this.nha.a(6, switchState == BdSwitchView.SwitchState.OFF, this.nhc);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new ar("c13889").ap("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).ap("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.nhl.UM().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.nhl.UM()) {
            if (this.nhl.nhO) {
                finish();
            } else {
                this.nhl.xU(true);
            }
        } else if (view == this.nhl.dHR()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.byA().a(getPageContext(), this.nhm);
        } else if (view == this.nhl.dHT()) {
            this.nhl.xU(false);
        } else if (view == this.nhl.dHU()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.nhl.dHV()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.nhl.dIg()) {
            TiebaStatic.log(new ar("c13286").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.nhl.dIh()) {
            com.baidu.tbadk.core.b.a.blk().blm();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dHB();
        }
    }

    private void dHB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.nw(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.Au(getString(R.string.push_permission_guide_des));
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
                arVar.ap("obj_source", 8);
                TiebaStatic.log(arVar);
            }
        });
        aVar.b(getPageContext()).bqx();
        ar arVar = new ar("c13674");
        arVar.ap("obj_source", 8);
        TiebaStatic.log(arVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.nhl.nhO) {
                    finish();
                    return true;
                }
                this.nhl.xU(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bye().byr().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bye().bys().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog IL(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.6
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bye().Cc(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bye().Cd(str);
                    }
                    MsgRemindActivity.this.nhl.dHO();
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
            return IL(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.bye().byf();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nhl != null) {
            this.nhl.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nhl != null) {
            this.nhl.onResume();
        }
    }
}
