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
    private MsgRemindModel kWF;
    private g kWQ;
    private final com.baidu.tbadk.widget.timepicker.a.d.e kWR = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.kWQ != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZS().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.kWQ.cYq();
                MsgRemindActivity.this.kWQ.cYR();
            }
        }
    };
    private MsgRemindModel.a kUw = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cYt = MsgRemindActivity.this.kWQ.cYt();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aZS().mG(300);
                        MsgRemindActivity.this.kWQ.tX(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aZS().mG(0);
                        MsgRemindActivity.this.kWQ.tX(false);
                    }
                    if (cYt != null) {
                        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cYt.turnOnNoCallback();
                                } else {
                                    cYt.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cYt != null) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cYt.turnOffNoCallback();
                            } else {
                                cYt.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hF(z2);
                }
                MsgRemindActivity.this.kWQ.cYN();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hG(z2);
                }
                MsgRemindActivity.this.kWQ.cYO();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hw(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.kWQ.cYQ();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hv(z2);
                }
                MsgRemindActivity.this.kWQ.cYP();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hE(z2);
                }
                MsgRemindActivity.this.kWQ.cYL();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hx(z2);
                }
                MsgRemindActivity.this.kWQ.cYM();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kWQ = new g(this);
        this.kWQ.b(this);
        this.kWF = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kWQ.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.kWQ.cYs()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZS().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").ag("obj_type", 2));
                TiebaStatic.log(new an("c13254").ag("obj_type", 1));
                this.kWQ.cYq();
                this.kWQ.tW(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aZS().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").ag("obj_type", 1));
            TiebaStatic.log(new an("c13254").ag("obj_type", 0));
            this.kWQ.tW(false);
        } else if (view == this.kWQ.cYt()) {
            this.kWF.a(14, switchState == BdSwitchView.SwitchState.ON, this.kUw);
        } else if (view == this.kWQ.cYv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hz(true);
                this.kWQ.tV(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hz(false);
            this.kWQ.tV(false);
        } else if (view == this.kWQ.cYz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hC(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hC(false);
            }
        } else if (view == this.kWQ.cYA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hA(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hA(false);
            }
        } else if (view == this.kWQ.cYB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hB(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hB(false);
            }
        } else if (view == this.kWQ.cYC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hD(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZS().hD(false);
            }
        } else if (view == this.kWQ.cYD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kWF.a(1, true, this.kUw);
            } else {
                this.kWF.a(1, false, this.kUw);
            }
        } else if (view == this.kWQ.cYE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kWF.a(20, true, this.kUw);
            } else {
                this.kWF.a(20, false, this.kUw);
            }
        } else if (view == this.kWQ.cYF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kWF.a(2, true, this.kUw);
            } else {
                this.kWF.a(2, false, this.kUw);
            }
        } else if (view == this.kWQ.cYG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kWF.a(5, true, this.kUw);
            } else {
                this.kWF.a(5, false, this.kUw);
            }
        } else if (view == this.kWQ.cYH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kWF.a(4, true, this.kUw);
            } else {
                this.kWF.a(4, false, this.kUw);
            }
        } else if (view == this.kWQ.cYI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kWF.a(3, true, this.kUw);
            } else {
                this.kWF.a(3, false, this.kUw);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.kWQ.HI().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kWQ.HI()) {
            if (this.kWQ.kXt) {
                finish();
            } else {
                this.kWQ.tY(true);
            }
        } else if (view == this.kWQ.cYu()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.ban().a(getPageContext(), this.kWR);
        } else if (view == this.kWQ.cYw()) {
            this.kWQ.tY(false);
        } else if (view == this.kWQ.cYx()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.kWQ.cYy()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.kWQ.cYJ()) {
            TiebaStatic.log(new an("c13286").dh("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.kWQ.cYK()) {
            com.baidu.tbadk.core.b.a.aOf().aOh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.kWQ.kXt) {
                    finish();
                    return true;
                }
                this.kWQ.tY(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aZS().baf().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aZS().bag().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog Da(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aZS().xn(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aZS().xo(str);
                    }
                    MsgRemindActivity.this.kWQ.cYr();
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
            return Da(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aZS().aZT();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kWQ != null) {
            this.kWQ.onDestroy();
        }
    }
}
