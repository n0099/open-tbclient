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
    private MsgRemindModel nbY;
    private g ncj;
    private MsgRemindModel.a nca = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.ncj.dJe().turnOffNoCallback();
                        MsgRemindActivity.this.ncj.xB(false);
                        MsgRemindActivity.this.ncj.xA(false);
                        return;
                    }
                    MsgRemindActivity.this.ncj.dJe().turnOnNoCallback();
                    MsgRemindActivity.this.ncj.xB(true);
                    MsgRemindActivity.this.ncj.xA(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.ncj.dJf().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.ncj.dJf().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kx(z2);
                } else if (z2) {
                    MsgRemindActivity.this.ncj.dJg().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.ncj.dJg().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.ncj.dJU().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.ncj.dJU().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().ky(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e nck = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.ncj != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.ncj.dJt();
                MsgRemindActivity.this.ncj.dJV();
            }
        }
    };
    private MsgRemindModel.a mZK = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dJw = MsgRemindActivity.this.ncj.dJw();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bBF().rV(300);
                        MsgRemindActivity.this.ncj.xE(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bBF().rV(0);
                        MsgRemindActivity.this.ncj.xE(false);
                    }
                    if (dJw != null) {
                        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dJw.turnOnNoCallback();
                                } else {
                                    dJw.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dJw != null) {
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dJw.turnOffNoCallback();
                            } else {
                                dJw.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kv(z2);
                }
                MsgRemindActivity.this.ncj.dJQ();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kw(z2);
                }
                MsgRemindActivity.this.ncj.dJR();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBF().km(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.ncj.dJT();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kl(z2);
                }
                MsgRemindActivity.this.ncj.dJS();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBF().ku(z2);
                }
                MsgRemindActivity.this.ncj.dJO();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kn(z2);
                }
                MsgRemindActivity.this.ncj.dJP();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ncj = new g(this);
        this.ncj.b(this);
        this.nbY = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ncj.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.ncj.dJv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().setSignAlertOn(true);
                TiebaStatic.log(new aq("c12939").an("obj_type", 2));
                TiebaStatic.log(new aq("c13254").an("obj_type", 1));
                this.ncj.dJt();
                this.ncj.xD(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().setSignAlertOn(false);
                TiebaStatic.log(new aq("c12939").an("obj_type", 1));
                TiebaStatic.log(new aq("c13254").an("obj_type", 0));
                this.ncj.xD(false);
            }
            a(switchState, 7);
        } else if (view == this.ncj.dJw()) {
            this.nbY.a(14, switchState == BdSwitchView.SwitchState.ON, this.mZK);
        } else if (view == this.ncj.dJy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kp(true);
                this.ncj.xC(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kp(false);
            this.ncj.xC(false);
        } else if (view == this.ncj.dJC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().ks(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().ks(false);
            }
        } else if (view == this.ncj.dJD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kq(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kq(false);
            }
        } else if (view == this.ncj.dJE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kr(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kr(false);
            }
        } else if (view == this.ncj.dJF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kt(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bBF().kt(false);
            }
        } else if (view == this.ncj.dJG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbY.a(1, true, this.mZK);
            } else {
                this.nbY.a(1, false, this.mZK);
            }
            a(switchState, 1);
        } else if (view == this.ncj.dJH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbY.a(20, true, this.mZK);
            } else {
                this.nbY.a(20, false, this.mZK);
            }
            a(switchState, 2);
        } else if (view == this.ncj.dJI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbY.a(2, true, this.mZK);
            } else {
                this.nbY.a(2, false, this.mZK);
            }
            a(switchState, 3);
        } else if (view == this.ncj.dJJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbY.a(5, true, this.mZK);
            } else {
                this.nbY.a(5, false, this.mZK);
            }
        } else if (view == this.ncj.dJK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbY.a(4, true, this.mZK);
            } else {
                this.nbY.a(4, false, this.mZK);
            }
        } else if (view == this.ncj.dJL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbY.a(3, true, this.mZK);
            } else {
                this.nbY.a(3, false, this.mZK);
            }
            a(switchState, 4);
        } else if (view == this.ncj.dJe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbY.a(8, true, this.nca);
                this.ncj.xB(true);
                this.ncj.xA(true);
            } else {
                this.nbY.a(8, false, this.nca);
                this.ncj.xB(false);
                this.ncj.xA(false);
            }
            a(switchState, 5);
        } else if (view == this.ncj.dJf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.nbY.a(9, true, this.nca);
            } else {
                this.nbY.a(9, false, this.nca);
            }
            a(switchState, 6);
        } else if (view == this.ncj.dJg()) {
            this.nbY.a(7, switchState == BdSwitchView.SwitchState.OFF, this.nca);
            a(switchState, 9);
        } else if (view == this.ncj.dJU()) {
            this.nbY.a(6, switchState == BdSwitchView.SwitchState.OFF, this.nca);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new aq("c13889").an("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).an("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.ncj.WX().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ncj.WX()) {
            if (this.ncj.ncM) {
                finish();
            } else {
                this.ncj.xF(true);
            }
        } else if (view == this.ncj.dJx()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bCb().a(getPageContext(), this.nck);
        } else if (view == this.ncj.dJz()) {
            this.ncj.xF(false);
        } else if (view == this.ncj.dJA()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.ncj.dJB()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.ncj.dJM()) {
            TiebaStatic.log(new aq("c13286").dX("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.ncj.dJN()) {
            com.baidu.tbadk.core.b.a.boL().boN();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dJh();
        }
    }

    private void dJh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.oZ(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.Bp(getString(R.string.push_permission_guide_des));
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
        aVar.b(getPageContext()).btX();
        aq aqVar = new aq("c13674");
        aqVar.an("obj_source", 8);
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.ncj.ncM) {
                    finish();
                    return true;
                }
                this.ncj.xF(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBS().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBT().split(":");
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
                        com.baidu.tbadk.coreExtra.messageCenter.d.bBF().CX(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bBF().CY(str);
                    }
                    MsgRemindActivity.this.ncj.dJu();
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
        com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBG();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ncj != null) {
            this.ncj.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ncj != null) {
            this.ncj.onResume();
        }
    }
}
