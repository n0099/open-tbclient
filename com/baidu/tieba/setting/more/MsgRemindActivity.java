package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TimePicker;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel.a gLS = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView brv = MsgRemindActivity.this.gNQ.brv();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().gW(300);
                        MsgRemindActivity.this.gNQ.ms(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().gW(0);
                        MsgRemindActivity.this.gNQ.ms(false);
                    }
                    if (brv != null) {
                        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    brv.rH();
                                } else {
                                    brv.rI();
                                }
                            }
                        }, 500L);
                    }
                } else if (brv != null) {
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                brv.rI();
                            } else {
                                brv.rH();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bP(z2);
                }
                MsgRemindActivity.this.gNQ.brO();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bQ(z2);
                }
                MsgRemindActivity.this.gNQ.brP();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bG(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.gNQ.brR();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bF(z2);
                }
                MsgRemindActivity.this.gNQ.brQ();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bO(z2);
                }
                MsgRemindActivity.this.gNQ.brM();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bH(z2);
                }
                MsgRemindActivity.this.gNQ.brN();
            }
        }
    };
    private MsgRemindModel gNJ;
    private f gNQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gNQ = new f(this);
        this.gNQ.b(this);
        this.gNJ = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gNQ.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gNQ.bru()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hq().setSignAlertOn(true);
                TiebaStatic.log(new ak("c12939").s("obj_type", 2));
                this.gNQ.brs();
                this.gNQ.mr(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().setSignAlertOn(false);
            TiebaStatic.log(new ak("c12939").s("obj_type", 1));
            this.gNQ.mr(false);
        } else if (view == this.gNQ.brv()) {
            this.gNJ.a(14, switchState == BdSwitchView.SwitchState.ON, this.gLS);
        } else if (view == this.gNQ.brx()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bJ(true);
                this.gNQ.mq(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bJ(false);
            this.gNQ.mq(false);
        } else if (view == this.gNQ.brB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bM(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bM(false);
            }
        } else if (view == this.gNQ.brC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bK(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bK(false);
            }
        } else if (view == this.gNQ.brD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bL(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bL(false);
            }
        } else if (view == this.gNQ.brE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bN(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bN(false);
            }
        } else if (view == this.gNQ.brF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNJ.a(1, true, this.gLS);
            } else {
                this.gNJ.a(1, false, this.gLS);
            }
        } else if (view == this.gNQ.brG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNJ.a(20, true, this.gLS);
            } else {
                this.gNJ.a(20, false, this.gLS);
            }
        } else if (view == this.gNQ.brH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNJ.a(2, true, this.gLS);
            } else {
                this.gNJ.a(2, false, this.gLS);
            }
        } else if (view == this.gNQ.brI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNJ.a(5, true, this.gLS);
            } else {
                this.gNJ.a(5, false, this.gLS);
            }
        } else if (view == this.gNQ.brJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNJ.a(4, true, this.gLS);
            } else {
                this.gNJ.a(4, false, this.gLS);
            }
        } else if (view == this.gNQ.brK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNJ.a(3, true, this.gLS);
            } else {
                this.gNJ.a(3, false, this.gLS);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.gNQ.brm().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gNQ.brm()) {
            if (this.gNQ.gOs) {
                finish();
            } else {
                this.gNQ.mt(true);
            }
        } else if (view == this.gNQ.brw()) {
            showDialog(d.g.sign_remind);
        } else if (view == this.gNQ.bry()) {
            this.gNQ.mt(false);
        } else if (view == this.gNQ.brz()) {
            showDialog(d.g.no_disturb_start_time);
        } else if (view == this.gNQ.brA()) {
            showDialog(d.g.no_disturb_end_time);
        } else if (view == this.gNQ.brL()) {
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.gNQ.gOs) {
                    finish();
                    return true;
                }
                this.gNQ.mt(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == d.g.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.Hq().getSignAlertMins());
                return;
            } else if (i == d.g.no_disturb_start_time || i == d.g.no_disturb_end_time) {
                if (i == d.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HD().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HE().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            } else {
                return;
            }
        }
        super.onPrepareDialog(i, dialog);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(final int i) {
        com.baidu.tieba.view.d dVar = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (i == d.g.sign_remind) {
                    if (timePicker != null) {
                        timePicker.clearFocus();
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().setSignAlertTime(timePicker.getCurrentHour().intValue(), timePicker.getCurrentMinute().intValue());
                        MsgRemindActivity.this.gNQ.brs();
                    }
                } else if (i == d.g.no_disturb_end_time || i == d.g.no_disturb_start_time) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == d.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().fq(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().fr(str);
                    }
                    MsgRemindActivity.this.gNQ.brt();
                }
            }
        }, 0, 0, true);
        if (i == d.g.sign_remind) {
            dVar.setTitle(d.j.sign_remind);
        } else if (i == d.g.no_disturb_end_time) {
            dVar.setTitle(d.j.no_disturb_end_time);
        } else if (i == d.g.no_disturb_start_time) {
            dVar.setTitle(d.j.no_disturb_start_time);
        }
        dVar.setButton(-1, getPageContext().getString(d.j.alert_yes_button), dVar);
        dVar.setButton(-2, getPageContext().getString(d.j.cancel), dVar);
        dVar.getWindow().setSoftInputMode(2);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hr();
    }
}
