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
    private g lQE;
    private MsgRemindModel lQt;
    private MsgRemindModel.a lQv = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.lQE.drk().turnOffNoCallback();
                        MsgRemindActivity.this.lQE.vC(false);
                        MsgRemindActivity.this.lQE.vB(false);
                        return;
                    }
                    MsgRemindActivity.this.lQE.drk().turnOnNoCallback();
                    MsgRemindActivity.this.lQE.vC(true);
                    MsgRemindActivity.this.lQE.vB(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.lQE.drl().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.lQE.drl().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iS(z2);
                } else if (z2) {
                    MsgRemindActivity.this.lQE.drm().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.lQE.drm().turnOnNoCallback();
                }
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e lQF = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.lQE != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.lQE.dry();
                MsgRemindActivity.this.lQE.drZ();
            }
        }
    };
    private MsgRemindModel.a lOj = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView drB = MsgRemindActivity.this.lQE.drB();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().pE(300);
                        MsgRemindActivity.this.lQE.vF(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().pE(0);
                        MsgRemindActivity.this.lQE.vF(false);
                    }
                    if (drB != null) {
                        com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    drB.turnOnNoCallback();
                                } else {
                                    drB.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (drB != null) {
                    com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                drB.turnOffNoCallback();
                            } else {
                                drB.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iQ(z2);
                }
                MsgRemindActivity.this.lQE.drV();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iR(z2);
                }
                MsgRemindActivity.this.lQE.drW();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iH(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.lQE.drY();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iG(z2);
                }
                MsgRemindActivity.this.lQE.drX();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iP(z2);
                }
                MsgRemindActivity.this.lQE.drT();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.boy().iI(z2);
                }
                MsgRemindActivity.this.lQE.drU();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lQE = new g(this);
        this.lQE.b(this);
        this.lQt = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lQE.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.lQE.drA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().setSignAlertOn(true);
                TiebaStatic.log(new aq("c12939").ai("obj_type", 2));
                TiebaStatic.log(new aq("c13254").ai("obj_type", 1));
                this.lQE.dry();
                this.lQE.vE(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().setSignAlertOn(false);
                TiebaStatic.log(new aq("c12939").ai("obj_type", 1));
                TiebaStatic.log(new aq("c13254").ai("obj_type", 0));
                this.lQE.vE(false);
            }
            a(switchState, 7);
        } else if (view == this.lQE.drB()) {
            this.lQt.a(14, switchState == BdSwitchView.SwitchState.ON, this.lOj);
        } else if (view == this.lQE.drD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iK(true);
                this.lQE.vD(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iK(false);
            this.lQE.vD(false);
        } else if (view == this.lQE.drH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iN(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iN(false);
            }
        } else if (view == this.lQE.drI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iL(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iL(false);
            }
        } else if (view == this.lQE.drJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iM(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iM(false);
            }
        } else if (view == this.lQE.drK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iO(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.boy().iO(false);
            }
        } else if (view == this.lQE.drL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQt.a(1, true, this.lOj);
            } else {
                this.lQt.a(1, false, this.lOj);
            }
            a(switchState, 1);
        } else if (view == this.lQE.drM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQt.a(20, true, this.lOj);
            } else {
                this.lQt.a(20, false, this.lOj);
            }
            a(switchState, 2);
        } else if (view == this.lQE.drN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQt.a(2, true, this.lOj);
            } else {
                this.lQt.a(2, false, this.lOj);
            }
            a(switchState, 3);
        } else if (view == this.lQE.drO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQt.a(5, true, this.lOj);
            } else {
                this.lQt.a(5, false, this.lOj);
            }
        } else if (view == this.lQE.drP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQt.a(4, true, this.lOj);
            } else {
                this.lQt.a(4, false, this.lOj);
            }
        } else if (view == this.lQE.drQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQt.a(3, true, this.lOj);
            } else {
                this.lQt.a(3, false, this.lOj);
            }
            a(switchState, 4);
        } else if (view == this.lQE.drk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQt.a(8, true, this.lQv);
                this.lQE.vC(true);
                this.lQE.vB(true);
            } else {
                this.lQt.a(8, false, this.lQv);
                this.lQE.vC(false);
                this.lQE.vB(false);
            }
            a(switchState, 5);
        } else if (view == this.lQE.drl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lQt.a(9, true, this.lQv);
            } else {
                this.lQt.a(9, false, this.lQv);
            }
            a(switchState, 6);
        } else if (view == this.lQE.drm()) {
            this.lQt.a(7, switchState == BdSwitchView.SwitchState.OFF, this.lQv);
            a(switchState, 9);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new aq("c13889").ai("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).ai("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.lQE.OT().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lQE.OT()) {
            if (this.lQE.lRh) {
                finish();
            } else {
                this.lQE.vG(true);
            }
        } else if (view == this.lQE.drC()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.boT().a(getPageContext(), this.lQF);
        } else if (view == this.lQE.drE()) {
            this.lQE.vG(false);
        } else if (view == this.lQE.drF()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.lQE.drG()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.lQE.drR()) {
            TiebaStatic.log(new aq("c13286").dD("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.lQE.drS()) {
            com.baidu.tbadk.core.b.a.bcb().bcd();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            drn();
        }
    }

    private void drn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.ns(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.zz(getString(R.string.push_permission_guide_des));
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
                if (this.lQE.lRh) {
                    finish();
                    return true;
                }
                this.lQE.vG(true);
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
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().Bc(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().Bd(str);
                    }
                    MsgRemindActivity.this.lQE.drz();
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
        if (this.lQE != null) {
            this.lQE.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lQE != null) {
            this.lQE.onResume();
        }
    }
}
