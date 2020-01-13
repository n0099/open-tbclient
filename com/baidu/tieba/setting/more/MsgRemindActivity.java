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
/* loaded from: classes11.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel jSB;
    private g jSM;
    private final com.baidu.tbadk.widget.timepicker.a.d.e jSN = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.jSM != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.jSM.cER();
                MsgRemindActivity.this.jSM.cFs();
            }
        }
    };
    private MsgRemindModel.a jQs = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cEU = MsgRemindActivity.this.jSM.cEU();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().ly(300);
                        MsgRemindActivity.this.jSM.sp(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().ly(0);
                        MsgRemindActivity.this.jSM.sp(false);
                    }
                    if (cEU != null) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cEU.turnOnNoCallback();
                                } else {
                                    cEU.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cEU != null) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cEU.turnOffNoCallback();
                            } else {
                                cEU.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().gb(z2);
                }
                MsgRemindActivity.this.jSM.cFo();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().gc(z2);
                }
                MsgRemindActivity.this.jSM.cFp();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fS(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.jSM.cFr();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fR(z2);
                }
                MsgRemindActivity.this.jSM.cFq();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().ga(z2);
                }
                MsgRemindActivity.this.jSM.cFm();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fT(z2);
                }
                MsgRemindActivity.this.jSM.cFn();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jSM = new g(this);
        this.jSM.b(this);
        this.jSB = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jSM.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jSM.cET()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").Z("obj_type", 2));
                TiebaStatic.log(new an("c13254").Z("obj_type", 1));
                this.jSM.cER();
                this.jSM.so(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").Z("obj_type", 1));
            TiebaStatic.log(new an("c13254").Z("obj_type", 0));
            this.jSM.so(false);
        } else if (view == this.jSM.cEU()) {
            this.jSB.a(14, switchState == BdSwitchView.SwitchState.ON, this.jQs);
        } else if (view == this.jSM.cEW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fV(true);
                this.jSM.sn(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fV(false);
            this.jSM.sn(false);
        } else if (view == this.jSM.cFa()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fY(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fY(false);
            }
        } else if (view == this.jSM.cFb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fW(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fW(false);
            }
        } else if (view == this.jSM.cFc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fX(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fX(false);
            }
        } else if (view == this.jSM.cFd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fZ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fZ(false);
            }
        } else if (view == this.jSM.cFe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSB.a(1, true, this.jQs);
            } else {
                this.jSB.a(1, false, this.jQs);
            }
        } else if (view == this.jSM.cFf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSB.a(20, true, this.jQs);
            } else {
                this.jSB.a(20, false, this.jQs);
            }
        } else if (view == this.jSM.cFg()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSB.a(2, true, this.jQs);
            } else {
                this.jSB.a(2, false, this.jQs);
            }
        } else if (view == this.jSM.cFh()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSB.a(5, true, this.jQs);
            } else {
                this.jSB.a(5, false, this.jQs);
            }
        } else if (view == this.jSM.cFi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSB.a(4, true, this.jQs);
            } else {
                this.jSB.a(4, false, this.jQs);
            }
        } else if (view == this.jSM.cFj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSB.a(3, true, this.jQs);
            } else {
                this.jSB.a(3, false, this.jQs);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.jSM.yh().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jSM.yh()) {
            if (this.jSM.isFront) {
                finish();
            } else {
                this.jSM.sq(true);
            }
        } else if (view == this.jSM.cEV()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aJl().a(getPageContext(), this.jSN);
        } else if (view == this.jSM.cEX()) {
            this.jSM.sq(false);
        } else if (view == this.jSM.cEY()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.jSM.cEZ()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.jSM.cFk()) {
            TiebaStatic.log(new an("c13286").cp("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.jSM.cFl()) {
            com.baidu.tbadk.core.b.a.axN().axP();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.jSM.isFront) {
                    finish();
                    return true;
                }
                this.jSM.sq(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJd().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJe().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog Bz(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().tY(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().tZ(str);
                    }
                    MsgRemindActivity.this.jSM.cES();
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
            return Bz(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIR();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jSM != null) {
            this.jSM.onDestroy();
        }
    }
}
