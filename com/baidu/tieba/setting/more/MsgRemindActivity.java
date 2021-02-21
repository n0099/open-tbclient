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
    private MsgRemindModel nhA;
    private g nhL;
    private MsgRemindModel.a nhC = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.nhL.dHG().turnOffNoCallback();
                        MsgRemindActivity.this.nhL.xQ(false);
                        MsgRemindActivity.this.nhL.xP(false);
                        return;
                    }
                    MsgRemindActivity.this.nhL.dHG().turnOnNoCallback();
                    MsgRemindActivity.this.nhL.xQ(true);
                    MsgRemindActivity.this.nhL.xP(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.nhL.dHH().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.nhL.dHH().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().kw(z2);
                } else if (z2) {
                    MsgRemindActivity.this.nhL.dHI().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.nhL.dHI().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.nhL.dIw().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.nhL.dIw().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kx(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e nhM = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.nhL != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.nhL.dHV();
                MsgRemindActivity.this.nhL.dIx();
            }
        }
    };
    private MsgRemindModel.a nfn = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dHY = MsgRemindActivity.this.nhL.dHY();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bye().qu(300);
                        MsgRemindActivity.this.nhL.xT(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bye().qu(0);
                        MsgRemindActivity.this.nhL.xT(false);
                    }
                    if (dHY != null) {
                        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dHY.turnOnNoCallback();
                                } else {
                                    dHY.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dHY != null) {
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dHY.turnOffNoCallback();
                            } else {
                                dHY.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().ku(z2);
                }
                MsgRemindActivity.this.nhL.dIs();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().kv(z2);
                }
                MsgRemindActivity.this.nhL.dIt();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().kl(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.nhL.dIv();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().kk(z2);
                }
                MsgRemindActivity.this.nhL.dIu();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().kt(z2);
                }
                MsgRemindActivity.this.nhL.dIq();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bye().km(z2);
                }
                MsgRemindActivity.this.nhL.dIr();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nhL = new g(this);
        this.nhL.b(this);
        this.nhA = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.nhL.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.nhL.dHX()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().setSignAlertOn(true);
                TiebaStatic.log(new ar("c12939").ap("obj_type", 2));
                TiebaStatic.log(new ar("c13254").ap("obj_type", 1));
                this.nhL.dHV();
                this.nhL.xS(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().setSignAlertOn(false);
                TiebaStatic.log(new ar("c12939").ap("obj_type", 1));
                TiebaStatic.log(new ar("c13254").ap("obj_type", 0));
                this.nhL.xS(false);
            }
            a(switchState, 7);
        } else if (view == this.nhL.dHY()) {
            this.nhA.a(14, switchState == BdSwitchView.SwitchState.ON, this.nfn);
        } else if (view == this.nhL.dIa()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().ko(true);
                this.nhL.xR(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bye().ko(false);
            this.nhL.xR(false);
        } else if (view == this.nhL.dIe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kr(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kr(false);
            }
        } else if (view == this.nhL.dIf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kp(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kp(false);
            }
        } else if (view == this.nhL.dIg()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kq(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().kq(false);
            }
        } else if (view == this.nhL.dIh()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().ks(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bye().ks(false);
            }
        } else if (view == this.nhL.dIi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nhA.a(1, true, this.nfn);
            } else {
                this.nhA.a(1, false, this.nfn);
            }
            a(switchState, 1);
        } else if (view == this.nhL.dIj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nhA.a(20, true, this.nfn);
            } else {
                this.nhA.a(20, false, this.nfn);
            }
            a(switchState, 2);
        } else if (view == this.nhL.dIk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nhA.a(2, true, this.nfn);
            } else {
                this.nhA.a(2, false, this.nfn);
            }
            a(switchState, 3);
        } else if (view == this.nhL.dIl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nhA.a(5, true, this.nfn);
            } else {
                this.nhA.a(5, false, this.nfn);
            }
        } else if (view == this.nhL.dIm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nhA.a(4, true, this.nfn);
            } else {
                this.nhA.a(4, false, this.nfn);
            }
        } else if (view == this.nhL.dIn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nhA.a(3, true, this.nfn);
            } else {
                this.nhA.a(3, false, this.nfn);
            }
            a(switchState, 4);
        } else if (view == this.nhL.dHG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nhA.a(8, true, this.nhC);
                this.nhL.xQ(true);
                this.nhL.xP(true);
            } else {
                this.nhA.a(8, false, this.nhC);
                this.nhL.xQ(false);
                this.nhL.xP(false);
            }
            a(switchState, 5);
        } else if (view == this.nhL.dHH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nhA.a(9, true, this.nhC);
            } else {
                this.nhA.a(9, false, this.nhC);
            }
            a(switchState, 6);
        } else if (view == this.nhL.dHI()) {
            this.nhA.a(7, switchState == BdSwitchView.SwitchState.OFF, this.nhC);
            a(switchState, 9);
        } else if (view == this.nhL.dIw()) {
            this.nhA.a(6, switchState == BdSwitchView.SwitchState.OFF, this.nhC);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new ar("c13889").ap("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).ap("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.nhL.UM().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.nhL.UM()) {
            if (this.nhL.nip) {
                finish();
            } else {
                this.nhL.xU(true);
            }
        } else if (view == this.nhL.dHZ()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.byA().a(getPageContext(), this.nhM);
        } else if (view == this.nhL.dIb()) {
            this.nhL.xU(false);
        } else if (view == this.nhL.dIc()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.nhL.dId()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.nhL.dIo()) {
            TiebaStatic.log(new ar("c13286").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.nhL.dIp()) {
            com.baidu.tbadk.core.b.a.blk().blm();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dHJ();
        }
    }

    private void dHJ() {
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
                if (this.nhL.nip) {
                    finish();
                    return true;
                }
                this.nhL.xU(true);
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
                    MsgRemindActivity.this.nhL.dHW();
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
        if (this.nhL != null) {
            this.nhL.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nhL != null) {
            this.nhL.onResume();
        }
    }
}
