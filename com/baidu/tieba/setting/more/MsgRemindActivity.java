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
    private MsgRemindModel jTB;
    private g jTM;
    private final com.baidu.tbadk.widget.timepicker.a.d.e jTN = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.jTM != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLj().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.jTM.cGu();
                MsgRemindActivity.this.jTM.cGV();
            }
        }
    };
    private MsgRemindModel.a jRs = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cGx = MsgRemindActivity.this.jTM.cGx();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLj().lP(300);
                        MsgRemindActivity.this.jTM.ss(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLj().lP(0);
                        MsgRemindActivity.this.jTM.ss(false);
                    }
                    if (cGx != null) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cGx.turnOnNoCallback();
                                } else {
                                    cGx.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cGx != null) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cGx.turnOffNoCallback();
                            } else {
                                cGx.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLj().gi(z2);
                }
                MsgRemindActivity.this.jTM.cGR();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLj().gj(z2);
                }
                MsgRemindActivity.this.jTM.cGS();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLj().fZ(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.jTM.cGU();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLj().fY(z2);
                }
                MsgRemindActivity.this.jTM.cGT();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLj().gh(z2);
                }
                MsgRemindActivity.this.jTM.cGP();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLj().ga(z2);
                }
                MsgRemindActivity.this.jTM.cGQ();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jTM = new g(this);
        this.jTM.b(this);
        this.jTB = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jTM.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jTM.cGw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLj().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").X("obj_type", 2));
                TiebaStatic.log(new an("c13254").X("obj_type", 1));
                this.jTM.cGu();
                this.jTM.sr(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aLj().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").X("obj_type", 1));
            TiebaStatic.log(new an("c13254").X("obj_type", 0));
            this.jTM.sr(false);
        } else if (view == this.jTM.cGx()) {
            this.jTB.a(14, switchState == BdSwitchView.SwitchState.ON, this.jRs);
        } else if (view == this.jTM.cGz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLj().gc(true);
                this.jTM.sq(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aLj().gc(false);
            this.jTM.sq(false);
        } else if (view == this.jTM.cGD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLj().gf(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLj().gf(false);
            }
        } else if (view == this.jTM.cGE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLj().gd(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLj().gd(false);
            }
        } else if (view == this.jTM.cGF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLj().ge(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLj().ge(false);
            }
        } else if (view == this.jTM.cGG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLj().gg(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLj().gg(false);
            }
        } else if (view == this.jTM.cGH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTB.a(1, true, this.jRs);
            } else {
                this.jTB.a(1, false, this.jRs);
            }
        } else if (view == this.jTM.cGI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTB.a(20, true, this.jRs);
            } else {
                this.jTB.a(20, false, this.jRs);
            }
        } else if (view == this.jTM.cGJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTB.a(2, true, this.jRs);
            } else {
                this.jTB.a(2, false, this.jRs);
            }
        } else if (view == this.jTM.cGK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTB.a(5, true, this.jRs);
            } else {
                this.jTB.a(5, false, this.jRs);
            }
        } else if (view == this.jTM.cGL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTB.a(4, true, this.jRs);
            } else {
                this.jTB.a(4, false, this.jRs);
            }
        } else if (view == this.jTM.cGM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTB.a(3, true, this.jRs);
            } else {
                this.jTB.a(3, false, this.jRs);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.jTM.Ay().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jTM.Ay()) {
            if (this.jTM.isFront) {
                finish();
            } else {
                this.jTM.st(true);
            }
        } else if (view == this.jTM.cGy()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aLE().a(getPageContext(), this.jTN);
        } else if (view == this.jTM.cGA()) {
            this.jTM.st(false);
        } else if (view == this.jTM.cGB()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.jTM.cGC()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.jTM.cGN()) {
            TiebaStatic.log(new an("c13286").cy("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.jTM.cGO()) {
            com.baidu.tbadk.core.b.a.aAb().aAd();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.jTM.isFront) {
                    finish();
                    return true;
                }
                this.jTM.st(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLw().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLx().split(":");
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
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLj().up(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLj().uq(str);
                    }
                    MsgRemindActivity.this.jTM.cGv();
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
        com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLk();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jTM != null) {
            this.jTM.onDestroy();
        }
    }
}
