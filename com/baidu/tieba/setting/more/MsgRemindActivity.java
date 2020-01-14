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
    private MsgRemindModel jSG;
    private g jSR;
    private final com.baidu.tbadk.widget.timepicker.a.d.e jSS = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.jSR != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.jSR.cET();
                MsgRemindActivity.this.jSR.cFu();
            }
        }
    };
    private MsgRemindModel.a jQx = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cEW = MsgRemindActivity.this.jSR.cEW();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().ly(300);
                        MsgRemindActivity.this.jSR.sp(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().ly(0);
                        MsgRemindActivity.this.jSR.sp(false);
                    }
                    if (cEW != null) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cEW.turnOnNoCallback();
                                } else {
                                    cEW.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cEW != null) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cEW.turnOffNoCallback();
                            } else {
                                cEW.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().gb(z2);
                }
                MsgRemindActivity.this.jSR.cFq();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().gc(z2);
                }
                MsgRemindActivity.this.jSR.cFr();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fS(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.jSR.cFt();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fR(z2);
                }
                MsgRemindActivity.this.jSR.cFs();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().ga(z2);
                }
                MsgRemindActivity.this.jSR.cFo();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fT(z2);
                }
                MsgRemindActivity.this.jSR.cFp();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jSR = new g(this);
        this.jSR.b(this);
        this.jSG = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jSR.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jSR.cEV()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").Z("obj_type", 2));
                TiebaStatic.log(new an("c13254").Z("obj_type", 1));
                this.jSR.cET();
                this.jSR.so(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").Z("obj_type", 1));
            TiebaStatic.log(new an("c13254").Z("obj_type", 0));
            this.jSR.so(false);
        } else if (view == this.jSR.cEW()) {
            this.jSG.a(14, switchState == BdSwitchView.SwitchState.ON, this.jQx);
        } else if (view == this.jSR.cEY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fV(true);
                this.jSR.sn(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fV(false);
            this.jSR.sn(false);
        } else if (view == this.jSR.cFc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fY(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fY(false);
            }
        } else if (view == this.jSR.cFd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fW(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fW(false);
            }
        } else if (view == this.jSR.cFe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fX(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fX(false);
            }
        } else if (view == this.jSR.cFf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fZ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().fZ(false);
            }
        } else if (view == this.jSR.cFg()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSG.a(1, true, this.jQx);
            } else {
                this.jSG.a(1, false, this.jQx);
            }
        } else if (view == this.jSR.cFh()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSG.a(20, true, this.jQx);
            } else {
                this.jSG.a(20, false, this.jQx);
            }
        } else if (view == this.jSR.cFi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSG.a(2, true, this.jQx);
            } else {
                this.jSG.a(2, false, this.jQx);
            }
        } else if (view == this.jSR.cFj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSG.a(5, true, this.jQx);
            } else {
                this.jSG.a(5, false, this.jQx);
            }
        } else if (view == this.jSR.cFk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSG.a(4, true, this.jQx);
            } else {
                this.jSG.a(4, false, this.jQx);
            }
        } else if (view == this.jSR.cFl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jSG.a(3, true, this.jQx);
            } else {
                this.jSG.a(3, false, this.jQx);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.jSR.yh().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jSR.yh()) {
            if (this.jSR.isFront) {
                finish();
            } else {
                this.jSR.sq(true);
            }
        } else if (view == this.jSR.cEX()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aJl().a(getPageContext(), this.jSS);
        } else if (view == this.jSR.cEZ()) {
            this.jSR.sq(false);
        } else if (view == this.jSR.cFa()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.jSR.cFb()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.jSR.cFm()) {
            TiebaStatic.log(new an("c13286").cp("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.jSR.cFn()) {
            com.baidu.tbadk.core.b.a.axN().axP();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.jSR.isFront) {
                    finish();
                    return true;
                }
                this.jSR.sq(true);
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
                    MsgRemindActivity.this.jSR.cEU();
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
        if (this.jSR != null) {
            this.jSR.onDestroy();
        }
    }
}
