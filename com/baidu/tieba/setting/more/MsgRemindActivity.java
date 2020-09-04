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
/* loaded from: classes20.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel lQG;
    private g lQR;
    private MsgRemindModel.a lQI = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.lQR.drn().turnOffNoCallback();
                        MsgRemindActivity.this.lQR.vE(false);
                        MsgRemindActivity.this.lQR.vD(false);
                        return;
                    }
                    MsgRemindActivity.this.lQR.drn().turnOnNoCallback();
                    MsgRemindActivity.this.lQR.vE(true);
                    MsgRemindActivity.this.lQR.vD(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.lQR.dro().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.lQR.dro().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iT(z2);
                } else if (z2) {
                    MsgRemindActivity.this.lQR.drp().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.lQR.drp().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.lQR.dsd().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.lQR.dsd().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iU(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e lQS = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.lQR != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.lQR.drC();
                MsgRemindActivity.this.lQR.dse();
            }
        }
    };
    private MsgRemindModel.a lOw = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView drF = MsgRemindActivity.this.lQR.drF();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().pE(300);
                        MsgRemindActivity.this.lQR.vH(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().pE(0);
                        MsgRemindActivity.this.lQR.vH(false);
                    }
                    if (drF != null) {
                        com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    drF.turnOnNoCallback();
                                } else {
                                    drF.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (drF != null) {
                    com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                drF.turnOffNoCallback();
                            } else {
                                drF.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iR(z2);
                }
                MsgRemindActivity.this.lQR.drZ();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iS(z2);
                }
                MsgRemindActivity.this.lQR.dsa();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iI(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.lQR.dsc();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iH(z2);
                }
                MsgRemindActivity.this.lQR.dsb();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iQ(z2);
                }
                MsgRemindActivity.this.lQR.drX();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iJ(z2);
                }
                MsgRemindActivity.this.lQR.drY();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lQR = new g(this);
        this.lQR.b(this);
        this.lQG = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lQR.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.lQR.drE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().setSignAlertOn(true);
                TiebaStatic.log(new aq("c12939").ai("obj_type", 2));
                TiebaStatic.log(new aq("c13254").ai("obj_type", 1));
                this.lQR.drC();
                this.lQR.vG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().setSignAlertOn(false);
                TiebaStatic.log(new aq("c12939").ai("obj_type", 1));
                TiebaStatic.log(new aq("c13254").ai("obj_type", 0));
                this.lQR.vG(false);
            }
            a(switchState, 7);
        } else if (view == this.lQR.drF()) {
            this.lQG.a(14, switchState == BdSwitchView.SwitchState.ON, this.lOw);
        } else if (view == this.lQR.drH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iL(true);
                this.lQR.vF(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iL(false);
            this.lQR.vF(false);
        } else if (view == this.lQR.drL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iO(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iO(false);
            }
        } else if (view == this.lQR.drM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iM(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iM(false);
            }
        } else if (view == this.lQR.drN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iN(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iN(false);
            }
        } else if (view == this.lQR.drO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iP(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iP(false);
            }
        } else if (view == this.lQR.drP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQG.a(1, true, this.lOw);
            } else {
                this.lQG.a(1, false, this.lOw);
            }
            a(switchState, 1);
        } else if (view == this.lQR.drQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQG.a(20, true, this.lOw);
            } else {
                this.lQG.a(20, false, this.lOw);
            }
            a(switchState, 2);
        } else if (view == this.lQR.drR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQG.a(2, true, this.lOw);
            } else {
                this.lQG.a(2, false, this.lOw);
            }
            a(switchState, 3);
        } else if (view == this.lQR.drS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQG.a(5, true, this.lOw);
            } else {
                this.lQG.a(5, false, this.lOw);
            }
        } else if (view == this.lQR.drT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQG.a(4, true, this.lOw);
            } else {
                this.lQG.a(4, false, this.lOw);
            }
        } else if (view == this.lQR.drU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQG.a(3, true, this.lOw);
            } else {
                this.lQG.a(3, false, this.lOw);
            }
            a(switchState, 4);
        } else if (view == this.lQR.drn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQG.a(8, true, this.lQI);
                this.lQR.vE(true);
                this.lQR.vD(true);
            } else {
                this.lQG.a(8, false, this.lQI);
                this.lQR.vE(false);
                this.lQR.vD(false);
            }
            a(switchState, 5);
        } else if (view == this.lQR.dro()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQG.a(9, true, this.lQI);
            } else {
                this.lQG.a(9, false, this.lQI);
            }
            a(switchState, 6);
        } else if (view == this.lQR.drp()) {
            this.lQG.a(7, switchState == BdSwitchView.SwitchState.OFF, this.lQI);
            a(switchState, 9);
        } else if (view == this.lQR.dsd()) {
            this.lQG.a(6, switchState == BdSwitchView.SwitchState.OFF, this.lQI);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new aq("c13889").ai("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).ai("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.lQR.OT().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lQR.OT()) {
            if (this.lQR.lRu) {
                finish();
            } else {
                this.lQR.vI(true);
            }
        } else if (view == this.lQR.drG()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.boU().a(getPageContext(), this.lQS);
        } else if (view == this.lQR.drI()) {
            this.lQR.vI(false);
        } else if (view == this.lQR.drJ()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.lQR.drK()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.lQR.drV()) {
            TiebaStatic.log(new aq("c13286").dD("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.lQR.drW()) {
            com.baidu.tbadk.core.b.a.bcb().bcd();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            drq();
        }
    }

    private void drq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.ns(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.zA(getString(R.string.push_permission_guide_des));
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
        aVar.b(getPageContext()).bhg();
        aq aqVar = new aq("c13674");
        aqVar.ai("obj_source", 8);
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.lQR.lRu) {
                    finish();
                    return true;
                }
                this.lQR.vI(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.boy().boL().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.boy().boM().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog GX(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.6
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().Bd(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().Be(str);
                    }
                    MsgRemindActivity.this.lQR.drD();
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
            return GX(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.boy().boz();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lQR != null) {
            this.lQR.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lQR != null) {
            this.lQR.onResume();
        }
    }
}
