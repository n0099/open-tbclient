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
    private g mpF;
    private MsgRemindModel mpu;
    private MsgRemindModel.a mpw = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, boolean z2) {
            if (i == 8) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mpF.dyO().turnOffNoCallback();
                        MsgRemindActivity.this.mpF.wt(false);
                        MsgRemindActivity.this.mpF.ws(false);
                        return;
                    }
                    MsgRemindActivity.this.mpF.dyO().turnOnNoCallback();
                    MsgRemindActivity.this.mpF.wt(true);
                    MsgRemindActivity.this.mpF.ws(true);
                }
            } else if (i == 9) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mpF.dyP().turnOffNoCallback();
                    } else {
                        MsgRemindActivity.this.mpF.dyP().turnOnNoCallback();
                    }
                }
            } else if (i == 7) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jo(z2);
                } else if (z2) {
                    MsgRemindActivity.this.mpF.dyQ().turnOffNoCallback();
                } else {
                    MsgRemindActivity.this.mpF.dyQ().turnOnNoCallback();
                }
            } else if (i == 6) {
                if (!z) {
                    if (z2) {
                        MsgRemindActivity.this.mpF.dzE().turnOffNoCallback();
                        return;
                    } else {
                        MsgRemindActivity.this.mpF.dzE().turnOnNoCallback();
                        return;
                    }
                }
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jp(z2);
            }
        }
    };
    private final com.baidu.tbadk.widget.timepicker.a.d.e mpG = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.5
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.mpF != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.mpF.dzd();
                MsgRemindActivity.this.mpF.dzF();
            }
        }
    };
    private MsgRemindModel.a mni = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void i(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dzg = MsgRemindActivity.this.mpF.dzg();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bsc().qp(300);
                        MsgRemindActivity.this.mpF.ww(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bsc().qp(0);
                        MsgRemindActivity.this.mpF.ww(false);
                    }
                    if (dzg != null) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dzg.turnOnNoCallback();
                                } else {
                                    dzg.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dzg != null) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dzg.turnOffNoCallback();
                            } else {
                                dzg.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jm(z2);
                }
                MsgRemindActivity.this.mpF.dzA();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jn(z2);
                }
                MsgRemindActivity.this.mpF.dzB();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jd(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.mpF.dzD();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jc(z2);
                }
                MsgRemindActivity.this.mpF.dzC();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jl(z2);
                }
                MsgRemindActivity.this.mpF.dzy();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bsc().je(z2);
                }
                MsgRemindActivity.this.mpF.dzz();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mpF = new g(this);
        this.mpF.b(this);
        this.mpu = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mpF.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.mpF.dzf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().setSignAlertOn(true);
                TiebaStatic.log(new aq("c12939").aj("obj_type", 2));
                TiebaStatic.log(new aq("c13254").aj("obj_type", 1));
                this.mpF.dzd();
                this.mpF.wv(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().setSignAlertOn(false);
                TiebaStatic.log(new aq("c12939").aj("obj_type", 1));
                TiebaStatic.log(new aq("c13254").aj("obj_type", 0));
                this.mpF.wv(false);
            }
            a(switchState, 7);
        } else if (view == this.mpF.dzg()) {
            this.mpu.a(14, switchState == BdSwitchView.SwitchState.ON, this.mni);
        } else if (view == this.mpF.dzi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jg(true);
                this.mpF.wu(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jg(false);
            this.mpF.wu(false);
        } else if (view == this.mpF.dzm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jj(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jj(false);
            }
        } else if (view == this.mpF.dzn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jh(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jh(false);
            }
        } else if (view == this.mpF.dzo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().ji(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().ji(false);
            }
        } else if (view == this.mpF.dzp()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jk(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bsc().jk(false);
            }
        } else if (view == this.mpF.dzq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mpu.a(1, true, this.mni);
            } else {
                this.mpu.a(1, false, this.mni);
            }
            a(switchState, 1);
        } else if (view == this.mpF.dzr()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mpu.a(20, true, this.mni);
            } else {
                this.mpu.a(20, false, this.mni);
            }
            a(switchState, 2);
        } else if (view == this.mpF.dzs()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mpu.a(2, true, this.mni);
            } else {
                this.mpu.a(2, false, this.mni);
            }
            a(switchState, 3);
        } else if (view == this.mpF.dzt()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mpu.a(5, true, this.mni);
            } else {
                this.mpu.a(5, false, this.mni);
            }
        } else if (view == this.mpF.dzu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mpu.a(4, true, this.mni);
            } else {
                this.mpu.a(4, false, this.mni);
            }
        } else if (view == this.mpF.dzv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mpu.a(3, true, this.mni);
            } else {
                this.mpu.a(3, false, this.mni);
            }
            a(switchState, 4);
        } else if (view == this.mpF.dyO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mpu.a(8, true, this.mpw);
                this.mpF.wt(true);
                this.mpF.ws(true);
            } else {
                this.mpu.a(8, false, this.mpw);
                this.mpF.wt(false);
                this.mpF.ws(false);
            }
            a(switchState, 5);
        } else if (view == this.mpF.dyP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.mpu.a(9, true, this.mpw);
            } else {
                this.mpu.a(9, false, this.mpw);
            }
            a(switchState, 6);
        } else if (view == this.mpF.dyQ()) {
            this.mpu.a(7, switchState == BdSwitchView.SwitchState.OFF, this.mpw);
            a(switchState, 9);
        } else if (view == this.mpF.dzE()) {
            this.mpu.a(6, switchState == BdSwitchView.SwitchState.OFF, this.mpw);
        }
    }

    private void a(BdSwitchView.SwitchState switchState, int i) {
        TiebaStatic.log(new aq("c13889").aj("obj_locate", switchState == BdSwitchView.SwitchState.ON ? 1 : 2).aj("obj_source", i));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mpF.QB().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mpF.QB()) {
            if (this.mpF.mqi) {
                finish();
            } else {
                this.mpF.wx(true);
            }
        } else if (view == this.mpF.dzh()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bsy().a(getPageContext(), this.mpG);
        } else if (view == this.mpF.dzj()) {
            this.mpF.wx(false);
        } else if (view == this.mpF.dzk()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.mpF.dzl()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.mpF.dzw()) {
            TiebaStatic.log(new aq("c13286").dK("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mpF.dzx()) {
            com.baidu.tbadk.core.b.a.bfD().bfF();
        } else if (view.getId() == R.id.system_msg_permission_switch_cover) {
            dyR();
        }
    }

    private void dyR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.oa(R.string.push_permission_guide_title);
        aVar.setTitleShowCenter(true);
        aVar.AH(getString(R.string.push_permission_guide_des));
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
                aqVar.aj("obj_source", 8);
                TiebaStatic.log(aqVar);
            }
        });
        aVar.b(getPageContext()).bkJ();
        aq aqVar = new aq("c13674");
        aqVar.aj("obj_source", 8);
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.mpF.mqi) {
                    finish();
                    return true;
                }
                this.mpF.wx(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsp().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsq().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog Ig(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.6
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bsc().Cl(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bsc().Cm(str);
                    }
                    MsgRemindActivity.this.mpF.dze();
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
            return Ig(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsd();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mpF != null) {
            this.mpF.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mpF != null) {
            this.mpF.onResume();
        }
    }
}
