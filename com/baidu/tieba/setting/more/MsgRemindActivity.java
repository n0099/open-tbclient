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
/* loaded from: classes7.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel njF;
    private g njQ;
    private MsgRemindModel.a njH = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.njQ.dHO().turnOffNoCallback();
                        MsgRemindActivity.this.njQ.xQ(false);
                        MsgRemindActivity.this.njQ.xP(false);
                        return;
                    }
                    MsgRemindActivity.this.njQ.dHO().turnOnNoCallback();
                    MsgRemindActivity.this.njQ.xQ(true);
                    MsgRemindActivity.this.njQ.xP(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.njQ.dHP().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.njQ.dHP().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.byh().kw(z2);
                } else if (z2) {
                    MsgRemindActivity.this.njQ.dHQ().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.njQ.dHQ().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.njQ.dIE().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.njQ.dIE().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().kx(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e njR = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.njQ != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.njQ.dId();
                MsgRemindActivity.this.njQ.dIF();
            }
        }
    };
    private MsgRemindModel.a nhr = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dIg = MsgRemindActivity.this.njQ.dIg();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.byh().qv(300);
                        MsgRemindActivity.this.njQ.xT(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.byh().qv(0);
                        MsgRemindActivity.this.njQ.xT(false);
                    }
                    if (dIg != null) {
                        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dIg.turnOnNoCallback();
                                } else {
                                    dIg.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dIg != null) {
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dIg.turnOffNoCallback();
                            } else {
                                dIg.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.byh().ku(z2);
                }
                MsgRemindActivity.this.njQ.dIA();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.byh().kv(z2);
                }
                MsgRemindActivity.this.njQ.dIB();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.byh().kl(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.njQ.dID();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.byh().kk(z2);
                }
                MsgRemindActivity.this.njQ.dIC();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.byh().kt(z2);
                }
                MsgRemindActivity.this.njQ.dIy();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.byh().km(z2);
                }
                MsgRemindActivity.this.njQ.dIz();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.njQ = new g(this);
        this.njQ.b(this);
        this.njF = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.njQ.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.njQ.dIf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().setSignAlertOn(true);
                TiebaStatic.log(new ar("c12939").aq("obj_type", 2));
                TiebaStatic.log(new ar("c13254").aq("obj_type", 1));
                this.njQ.dId();
                this.njQ.xS(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().setSignAlertOn(false);
                TiebaStatic.log(new ar("c12939").aq("obj_type", 1));
                TiebaStatic.log(new ar("c13254").aq("obj_type", 0));
                this.njQ.xS(false);
            }
            a(switchState, 7);
        } else if (view == this.njQ.dIg()) {
            this.njF.a(14, switchState == BdSwitchView.SwitchState.ON, this.nhr);
        } else if (view == this.njQ.dIi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().ko(true);
                this.njQ.xR(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.byh().ko(false);
            this.njQ.xR(false);
        } else if (view == this.njQ.dIm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().kr(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().kr(false);
            }
        } else if (view == this.njQ.dIn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().kp(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().kp(false);
            }
        } else if (view == this.njQ.dIo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().kq(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().kq(false);
            }
        } else if (view == this.njQ.dIp()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().ks(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.byh().ks(false);
            }
        } else if (view == this.njQ.dIq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.njF.a(1, true, this.nhr);
            } else {
                this.njF.a(1, false, this.nhr);
            }
            a(switchState, 1);
        } else if (view == this.njQ.dIr()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.njF.a(20, true, this.nhr);
            } else {
                this.njF.a(20, false, this.nhr);
            }
            a(switchState, 2);
        } else if (view == this.njQ.dIs()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.njF.a(2, true, this.nhr);
            } else {
                this.njF.a(2, false, this.nhr);
            }
            a(switchState, 3);
        } else if (view == this.njQ.dIt()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.njF.a(5, true, this.nhr);
            } else {
                this.njF.a(5, false, this.nhr);
            }
        } else if (view == this.njQ.dIu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.njF.a(4, true, this.nhr);
            } else {
                this.njF.a(4, false, this.nhr);
            }
        } else if (view == this.njQ.dIv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.njF.a(3, true, this.nhr);
            } else {
                this.njF.a(3, false, this.nhr);
            }
            a(switchState, 4);
        } else if (view == this.njQ.dHO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.njF.a(8, true, this.njH);
                this.njQ.xQ(true);
                this.njQ.xP(true);
            } else {
                this.njF.a(8, false, this.njH);
                this.njQ.xQ(false);
                this.njQ.xP(false);
            }
            a(switchState, 5);
        } else if (view == this.njQ.dHP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.njF.a(9, true, this.njH);
            } else {
                this.njF.a(9, false, this.njH);
            }
            a(switchState, 6);
        } else if (view == this.njQ.dHQ()) {
            this.njF.a(7, switchState == BdSwitchView.SwitchState.OFF, this.njH);
            a(switchState, 9);
        } else if (view == this.njQ.dIE()) {
            this.njF.a(6, switchState == BdSwitchView.SwitchState.OFF, this.njH);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new ar("c13889").aq("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).aq("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.njQ.UP().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.njQ.UP()) {
            if (this.njQ.nkt) {
                finish();
            } else {
                this.njQ.xU(true);
            }
        } else if (view == this.njQ.dIh()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.byD().a(getPageContext(), this.njR);
        } else if (view == this.njQ.dIj()) {
            this.njQ.xU(false);
        } else if (view == this.njQ.dIk()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.njQ.dIl()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.njQ.dIw()) {
            TiebaStatic.log(new ar("c13286").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.njQ.dIx()) {
            com.baidu.tbadk.core.b.a.blm().blo();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dHR();
        }
    }

    private void dHR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.nx(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.AB(getString(R.string.push_permission_guide_des));
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
                arVar.aq("obj_source", 8);
                TiebaStatic.log(arVar);
            }
        });
        aVar.b(getPageContext()).bqz();
        ar arVar = new ar("c13674");
        arVar.aq("obj_source", 8);
        TiebaStatic.log(arVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.njQ.nkt) {
                    finish();
                    return true;
                }
                this.njQ.xU(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.byh().byu().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.byh().byv().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog IP(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.6
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.byh().Cj(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.byh().Ck(str);
                    }
                    MsgRemindActivity.this.njQ.dIe();
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
            return IP(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.byh().byi();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.njQ != null) {
            this.njQ.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.njQ != null) {
            this.njQ.onResume();
        }
    }
}
