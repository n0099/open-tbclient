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
    private MsgRemindModel mBV;
    private g mCg;
    private MsgRemindModel.a mBX = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mCg.dBW().turnOffNoCallback();
                        MsgRemindActivity.this.mCg.wK(false);
                        MsgRemindActivity.this.mCg.wJ(false);
                        return;
                    }
                    MsgRemindActivity.this.mCg.dBW().turnOnNoCallback();
                    MsgRemindActivity.this.mCg.wK(true);
                    MsgRemindActivity.this.mCg.wJ(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mCg.dBX().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.mCg.dBX().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.btV().jB(z2);
                } else if (z2) {
                    MsgRemindActivity.this.mCg.dBY().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.mCg.dBY().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mCg.dCM().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.mCg.dCM().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().jC(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e mCh = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.mCg != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.mCg.dCl();
                MsgRemindActivity.this.mCg.dCN();
            }
        }
    };
    private MsgRemindModel.a mzJ = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dCo = MsgRemindActivity.this.mCg.dCo();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.btV().qA(300);
                        MsgRemindActivity.this.mCg.wN(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.btV().qA(0);
                        MsgRemindActivity.this.mCg.wN(false);
                    }
                    if (dCo != null) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dCo.turnOnNoCallback();
                                } else {
                                    dCo.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dCo != null) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dCo.turnOffNoCallback();
                            } else {
                                dCo.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.btV().jz(z2);
                }
                MsgRemindActivity.this.mCg.dCI();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.btV().jA(z2);
                }
                MsgRemindActivity.this.mCg.dCJ();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.btV().jq(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.mCg.dCL();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.btV().jp(z2);
                }
                MsgRemindActivity.this.mCg.dCK();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.btV().jy(z2);
                }
                MsgRemindActivity.this.mCg.dCG();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.btV().jr(z2);
                }
                MsgRemindActivity.this.mCg.dCH();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mCg = new g(this);
        this.mCg.b(this);
        this.mBV = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mCg.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mCg.dCn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().setSignAlertOn(true);
                TiebaStatic.log(new aq("c12939").aj("obj_type", 2));
                TiebaStatic.log(new aq("c13254").aj("obj_type", 1));
                this.mCg.dCl();
                this.mCg.wM(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().setSignAlertOn(false);
                TiebaStatic.log(new aq("c12939").aj("obj_type", 1));
                TiebaStatic.log(new aq("c13254").aj("obj_type", 0));
                this.mCg.wM(false);
            }
            a(switchState, 7);
        } else if (view == this.mCg.dCo()) {
            this.mBV.a(14, switchState == BdSwitchView.SwitchState.ON, this.mzJ);
        } else if (view == this.mCg.dCq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().jt(true);
                this.mCg.wL(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.btV().jt(false);
            this.mCg.wL(false);
        } else if (view == this.mCg.dCu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().jw(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().jw(false);
            }
        } else if (view == this.mCg.dCv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().ju(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().ju(false);
            }
        } else if (view == this.mCg.dCw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().jv(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().jv(false);
            }
        } else if (view == this.mCg.dCx()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().jx(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.btV().jx(false);
            }
        } else if (view == this.mCg.dCy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mBV.a(1, true, this.mzJ);
            } else {
                this.mBV.a(1, false, this.mzJ);
            }
            a(switchState, 1);
        } else if (view == this.mCg.dCz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mBV.a(20, true, this.mzJ);
            } else {
                this.mBV.a(20, false, this.mzJ);
            }
            a(switchState, 2);
        } else if (view == this.mCg.dCA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mBV.a(2, true, this.mzJ);
            } else {
                this.mBV.a(2, false, this.mzJ);
            }
            a(switchState, 3);
        } else if (view == this.mCg.dCB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mBV.a(5, true, this.mzJ);
            } else {
                this.mBV.a(5, false, this.mzJ);
            }
        } else if (view == this.mCg.dCC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mBV.a(4, true, this.mzJ);
            } else {
                this.mBV.a(4, false, this.mzJ);
            }
        } else if (view == this.mCg.dCD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mBV.a(3, true, this.mzJ);
            } else {
                this.mBV.a(3, false, this.mzJ);
            }
            a(switchState, 4);
        } else if (view == this.mCg.dBW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mBV.a(8, true, this.mBX);
                this.mCg.wK(true);
                this.mCg.wJ(true);
            } else {
                this.mBV.a(8, false, this.mBX);
                this.mCg.wK(false);
                this.mCg.wJ(false);
            }
            a(switchState, 5);
        } else if (view == this.mCg.dBX()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mBV.a(9, true, this.mBX);
            } else {
                this.mBV.a(9, false, this.mBX);
            }
            a(switchState, 6);
        } else if (view == this.mCg.dBY()) {
            this.mBV.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mBX);
            a(switchState, 9);
        } else if (view == this.mCg.dCM()) {
            this.mBV.a(6, switchState == BdSwitchView.SwitchState.OFF, this.mBX);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new aq("c13889").aj("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).aj("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mCg.Rw().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mCg.Rw()) {
            if (this.mCg.mCK) {
                finish();
            } else {
                this.mCg.wO(true);
            }
        } else if (view == this.mCg.dCp()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bur().a(getPageContext(), this.mCh);
        } else if (view == this.mCg.dCr()) {
            this.mCg.wO(false);
        } else if (view == this.mCg.dCs()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.mCg.dCt()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.mCg.dCE()) {
            TiebaStatic.log(new aq("c13286").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mCg.dCF()) {
            com.baidu.tbadk.core.b.a.bhw().bhy();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dBZ();
        }
    }

    private void dBZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.ol(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.Ba(getString(R.string.push_permission_guide_des));
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
                aqVar.aj("obj_source", 8);
                TiebaStatic.log(aqVar);
            }
        });
        aVar.b(getPageContext()).bmC();
        aq aqVar = new aq("c13674");
        aqVar.aj("obj_source", 8);
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.mCg.mCK) {
                    finish();
                    return true;
                }
                this.mCg.wO(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.btV().bui().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.btV().buj().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog Iz(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.6
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.btV().CE(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.btV().CF(str);
                    }
                    MsgRemindActivity.this.mCg.dCm();
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
            return Iz(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.btV().btW();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mCg != null) {
            this.mCg.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mCg != null) {
            this.mCg.onResume();
        }
    }
}
