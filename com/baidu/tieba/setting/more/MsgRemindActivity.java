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
/* loaded from: classes10.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel jOY;
    private g jPj;
    private final com.baidu.tbadk.widget.timepicker.a.d.e jPk = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.jPj != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIw().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.jPj.cDN();
                MsgRemindActivity.this.jPj.cEo();
            }
        }
    };
    private MsgRemindModel.a jMP = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cDQ = MsgRemindActivity.this.jPj.cDQ();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aIw().ly(300);
                        MsgRemindActivity.this.jPj.sd(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aIw().ly(0);
                        MsgRemindActivity.this.jPj.sd(false);
                    }
                    if (cDQ != null) {
                        com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cDQ.turnOnNoCallback();
                                } else {
                                    cDQ.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cDQ != null) {
                    com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cDQ.turnOffNoCallback();
                            } else {
                                cDQ.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fW(z2);
                }
                MsgRemindActivity.this.jPj.cEk();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fX(z2);
                }
                MsgRemindActivity.this.jPj.cEl();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fN(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.jPj.cEn();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fM(z2);
                }
                MsgRemindActivity.this.jPj.cEm();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fV(z2);
                }
                MsgRemindActivity.this.jPj.cEi();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fO(z2);
                }
                MsgRemindActivity.this.jPj.cEj();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jPj = new g(this);
        this.jPj.b(this);
        this.jOY = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jPj.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jPj.cDP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIw().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").Z("obj_type", 2));
                TiebaStatic.log(new an("c13254").Z("obj_type", 1));
                this.jPj.cDN();
                this.jPj.sc(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aIw().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").Z("obj_type", 1));
            TiebaStatic.log(new an("c13254").Z("obj_type", 0));
            this.jPj.sc(false);
        } else if (view == this.jPj.cDQ()) {
            this.jOY.a(14, switchState == BdSwitchView.SwitchState.ON, this.jMP);
        } else if (view == this.jPj.cDS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fQ(true);
                this.jPj.sb(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fQ(false);
            this.jPj.sb(false);
        } else if (view == this.jPj.cDW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fT(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fT(false);
            }
        } else if (view == this.jPj.cDX()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fR(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fR(false);
            }
        } else if (view == this.jPj.cDY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fS(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fS(false);
            }
        } else if (view == this.jPj.cDZ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fU(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aIw().fU(false);
            }
        } else if (view == this.jPj.cEa()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jOY.a(1, true, this.jMP);
            } else {
                this.jOY.a(1, false, this.jMP);
            }
        } else if (view == this.jPj.cEb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jOY.a(20, true, this.jMP);
            } else {
                this.jOY.a(20, false, this.jMP);
            }
        } else if (view == this.jPj.cEc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jOY.a(2, true, this.jMP);
            } else {
                this.jOY.a(2, false, this.jMP);
            }
        } else if (view == this.jPj.cEd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jOY.a(5, true, this.jMP);
            } else {
                this.jOY.a(5, false, this.jMP);
            }
        } else if (view == this.jPj.cEe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jOY.a(4, true, this.jMP);
            } else {
                this.jOY.a(4, false, this.jMP);
            }
        } else if (view == this.jPj.cEf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jOY.a(3, true, this.jMP);
            } else {
                this.jOY.a(3, false, this.jMP);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.jPj.xR().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jPj.xR()) {
            if (this.jPj.isFront) {
                finish();
            } else {
                this.jPj.se(true);
            }
        } else if (view == this.jPj.cDR()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aIR().a(getPageContext(), this.jPk);
        } else if (view == this.jPj.cDT()) {
            this.jPj.se(false);
        } else if (view == this.jPj.cDU()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.jPj.cDV()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.jPj.cEg()) {
            TiebaStatic.log(new an("c13286").cp("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.jPj.cEh()) {
            com.baidu.tbadk.core.b.a.axu().axw();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.jPj.isFront) {
                    finish();
                    return true;
                }
                this.jPj.se(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIJ().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIK().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog Bu(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aIw().tT(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aIw().tU(str);
                    }
                    MsgRemindActivity.this.jPj.cDO();
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
            return Bu(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIx();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jPj != null) {
            this.jPj.onDestroy();
        }
    }
}
