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
    private MsgRemindModel.a gLC = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bru = MsgRemindActivity.this.gNA.bru();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hp().gW(300);
                        MsgRemindActivity.this.gNA.mn(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hp().gW(0);
                        MsgRemindActivity.this.gNA.mn(false);
                    }
                    if (bru != null) {
                        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    bru.rH();
                                } else {
                                    bru.rI();
                                }
                            }
                        }, 500L);
                    }
                } else if (bru != null) {
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                bru.rI();
                            } else {
                                bru.rH();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bP(z2);
                }
                MsgRemindActivity.this.gNA.brN();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bQ(z2);
                }
                MsgRemindActivity.this.gNA.brO();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bG(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.gNA.brQ();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bF(z2);
                }
                MsgRemindActivity.this.gNA.brP();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bO(z2);
                }
                MsgRemindActivity.this.gNA.brL();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bH(z2);
                }
                MsgRemindActivity.this.gNA.brM();
            }
        }
    };
    private f gNA;
    private MsgRemindModel gNt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gNA = new f(this);
        this.gNA.b(this);
        this.gNt = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gNA.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gNA.brt()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hp().setSignAlertOn(true);
                TiebaStatic.log(new ak("c12939").s("obj_type", 2));
                this.gNA.brr();
                this.gNA.mm(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Hp().setSignAlertOn(false);
            TiebaStatic.log(new ak("c12939").s("obj_type", 1));
            this.gNA.mm(false);
        } else if (view == this.gNA.bru()) {
            this.gNt.a(14, switchState == BdSwitchView.SwitchState.ON, this.gLC);
        } else if (view == this.gNA.brw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bJ(true);
                this.gNA.ml(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bJ(false);
            this.gNA.ml(false);
        } else if (view == this.gNA.brA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bM(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bM(false);
            }
        } else if (view == this.gNA.brB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bK(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bK(false);
            }
        } else if (view == this.gNA.brC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bL(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bL(false);
            }
        } else if (view == this.gNA.brD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bN(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hp().bN(false);
            }
        } else if (view == this.gNA.brE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNt.a(1, true, this.gLC);
            } else {
                this.gNt.a(1, false, this.gLC);
            }
        } else if (view == this.gNA.brF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNt.a(20, true, this.gLC);
            } else {
                this.gNt.a(20, false, this.gLC);
            }
        } else if (view == this.gNA.brG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNt.a(2, true, this.gLC);
            } else {
                this.gNt.a(2, false, this.gLC);
            }
        } else if (view == this.gNA.brH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNt.a(5, true, this.gLC);
            } else {
                this.gNt.a(5, false, this.gLC);
            }
        } else if (view == this.gNA.brI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNt.a(4, true, this.gLC);
            } else {
                this.gNt.a(4, false, this.gLC);
            }
        } else if (view == this.gNA.brJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gNt.a(3, true, this.gLC);
            } else {
                this.gNt.a(3, false, this.gLC);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.gNA.brl().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gNA.brl()) {
            if (this.gNA.gOc) {
                finish();
            } else {
                this.gNA.mo(true);
            }
        } else if (view == this.gNA.brv()) {
            showDialog(d.g.sign_remind);
        } else if (view == this.gNA.brx()) {
            this.gNA.mo(false);
        } else if (view == this.gNA.bry()) {
            showDialog(d.g.no_disturb_start_time);
        } else if (view == this.gNA.brz()) {
            showDialog(d.g.no_disturb_end_time);
        } else if (view == this.gNA.brK()) {
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.gNA.gOc) {
                    finish();
                    return true;
                }
                this.gNA.mo(true);
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
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.Hp().getSignAlertMins());
                return;
            } else if (i == d.g.no_disturb_start_time || i == d.g.no_disturb_end_time) {
                if (i == d.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HC().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HD().split(":");
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
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hp().setSignAlertTime(timePicker.getCurrentHour().intValue(), timePicker.getCurrentMinute().intValue());
                        MsgRemindActivity.this.gNA.brr();
                    }
                } else if (i == d.g.no_disturb_end_time || i == d.g.no_disturb_start_time) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == d.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hp().fq(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hp().fr(str);
                    }
                    MsgRemindActivity.this.gNA.brs();
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
        com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hq();
    }
}
