package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TimePicker;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import java.util.Date;
/* loaded from: classes13.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel jTP;
    private g jUa;
    private final com.baidu.tbadk.widget.timepicker.a.d.e jUb = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.jUa != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLm().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.jUa.cGx();
                MsgRemindActivity.this.jUa.cGY();
            }
        }
    };
    private MsgRemindModel.a jRG = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cGA = MsgRemindActivity.this.jUa.cGA();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLm().lP(300);
                        MsgRemindActivity.this.jUa.ss(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLm().lP(0);
                        MsgRemindActivity.this.jUa.ss(false);
                    }
                    if (cGA != null) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cGA.turnOnNoCallback();
                                } else {
                                    cGA.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cGA != null) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cGA.turnOffNoCallback();
                            } else {
                                cGA.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLm().gi(z2);
                }
                MsgRemindActivity.this.jUa.cGU();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLm().gj(z2);
                }
                MsgRemindActivity.this.jUa.cGV();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLm().fZ(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.jUa.cGX();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLm().fY(z2);
                }
                MsgRemindActivity.this.jUa.cGW();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLm().gh(z2);
                }
                MsgRemindActivity.this.jUa.cGS();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLm().ga(z2);
                }
                MsgRemindActivity.this.jUa.cGT();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jUa = new g(this);
        this.jUa.b(this);
        this.jTP = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jUa.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jUa.cGz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLm().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").X("obj_type", 2));
                TiebaStatic.log(new an("c13254").X("obj_type", 1));
                this.jUa.cGx();
                this.jUa.sr(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aLm().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").X("obj_type", 1));
            TiebaStatic.log(new an("c13254").X("obj_type", 0));
            this.jUa.sr(false);
        } else if (view == this.jUa.cGA()) {
            this.jTP.a(14, switchState == BdSwitchView.SwitchState.ON, this.jRG);
        } else if (view == this.jUa.cGC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLm().gc(true);
                this.jUa.sq(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aLm().gc(false);
            this.jUa.sq(false);
        } else if (view == this.jUa.cGG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLm().gf(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLm().gf(false);
            }
        } else if (view == this.jUa.cGH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLm().gd(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLm().gd(false);
            }
        } else if (view == this.jUa.cGI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLm().ge(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLm().ge(false);
            }
        } else if (view == this.jUa.cGJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLm().gg(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLm().gg(false);
            }
        } else if (view == this.jUa.cGK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTP.a(1, true, this.jRG);
            } else {
                this.jTP.a(1, false, this.jRG);
            }
        } else if (view == this.jUa.cGL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTP.a(20, true, this.jRG);
            } else {
                this.jTP.a(20, false, this.jRG);
            }
        } else if (view == this.jUa.cGM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTP.a(2, true, this.jRG);
            } else {
                this.jTP.a(2, false, this.jRG);
            }
        } else if (view == this.jUa.cGN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTP.a(5, true, this.jRG);
            } else {
                this.jTP.a(5, false, this.jRG);
            }
        } else if (view == this.jUa.cGO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTP.a(4, true, this.jRG);
            } else {
                this.jTP.a(4, false, this.jRG);
            }
        } else if (view == this.jUa.cGP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTP.a(3, true, this.jRG);
            } else {
                this.jTP.a(3, false, this.jRG);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.jUa.AA().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jUa.AA()) {
            if (this.jUa.isFront) {
                finish();
            } else {
                this.jUa.st(true);
            }
        } else if (view == this.jUa.cGB()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aLH().a(getPageContext(), this.jUb);
        } else if (view == this.jUa.cGD()) {
            this.jUa.st(false);
        } else if (view == this.jUa.cGE()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.jUa.cGF()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.jUa.cGQ()) {
            TiebaStatic.log(new an("c13286").cy("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.jUa.cGR()) {
            com.baidu.tbadk.core.b.a.aAd().aAf();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.jUa.isFront) {
                    finish();
                    return true;
                }
                this.jUa.st(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLz().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLA().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog BI(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLm().uq(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLm().ur(str);
                    }
                    MsgRemindActivity.this.jUa.cGy();
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
            return BI(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLn();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jUa != null) {
            this.jUa.onDestroy();
        }
    }
}
