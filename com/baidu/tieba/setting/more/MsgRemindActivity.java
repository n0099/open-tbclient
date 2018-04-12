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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel.a ggV = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void c(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bmE = MsgRemindActivity.this.giV.bmE();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ae().dV(300);
                        MsgRemindActivity.this.giV.lT(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ae().dV(0);
                        MsgRemindActivity.this.giV.lT(false);
                    }
                    if (bmE != null) {
                        com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    bmE.jM();
                                } else {
                                    bmE.jN();
                                }
                            }
                        }, 500L);
                    }
                } else if (bmE != null) {
                    com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                bmE.jN();
                            } else {
                                bmE.jM();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bh(z2);
                }
                MsgRemindActivity.this.giV.bmX();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bi(z2);
                }
                MsgRemindActivity.this.giV.bmY();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().aY(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.giV.bna();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().aX(z2);
                }
                MsgRemindActivity.this.giV.bmZ();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bg(z2);
                }
                MsgRemindActivity.this.giV.bmV();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().aZ(z2);
                }
                MsgRemindActivity.this.giV.bmW();
            }
        }
    };
    private MsgRemindModel giO;
    private f giV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.giV = new f(this);
        this.giV.b(this);
        this.giO = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.giV.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (view2 == this.giV.bmD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().setSignAlertOn(true);
                TiebaStatic.log(new al("c12939").r("obj_type", 2));
                this.giV.bmB();
                this.giV.lS(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Ae().setSignAlertOn(false);
            TiebaStatic.log(new al("c12939").r("obj_type", 1));
            this.giV.lS(false);
        } else if (view2 == this.giV.bmE()) {
            this.giO.a(14, switchState == BdSwitchView.SwitchState.ON, this.ggV);
        } else if (view2 == this.giV.bmG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bb(true);
                this.giV.lR(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bb(false);
            this.giV.lR(false);
        } else if (view2 == this.giV.bmK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().be(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().be(false);
            }
        } else if (view2 == this.giV.bmL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bc(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bc(false);
            }
        } else if (view2 == this.giV.bmM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bd(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bd(false);
            }
        } else if (view2 == this.giV.bmN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bf(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bf(false);
            }
        } else if (view2 == this.giV.bmO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giO.a(1, true, this.ggV);
            } else {
                this.giO.a(1, false, this.ggV);
            }
        } else if (view2 == this.giV.bmP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giO.a(20, true, this.ggV);
            } else {
                this.giO.a(20, false, this.ggV);
            }
        } else if (view2 == this.giV.bmQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giO.a(2, true, this.ggV);
            } else {
                this.giO.a(2, false, this.ggV);
            }
        } else if (view2 == this.giV.bmR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giO.a(5, true, this.ggV);
            } else {
                this.giO.a(5, false, this.ggV);
            }
        } else if (view2 == this.giV.bmS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giO.a(4, true, this.ggV);
            } else {
                this.giO.a(4, false, this.ggV);
            }
        } else if (view2 == this.giV.bmT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giO.a(3, true, this.ggV);
            } else {
                this.giO.a(3, false, this.ggV);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.giV.bmv().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.giV.bmv()) {
            if (this.giV.gjx) {
                finish();
            } else {
                this.giV.lU(true);
            }
        } else if (view2 == this.giV.bmF()) {
            showDialog(d.g.sign_remind);
        } else if (view2 == this.giV.bmH()) {
            this.giV.lU(false);
        } else if (view2 == this.giV.bmI()) {
            showDialog(d.g.no_disturb_start_time);
        } else if (view2 == this.giV.bmJ()) {
            showDialog(d.g.no_disturb_end_time);
        } else if (view2 == this.giV.bmU()) {
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.giV.gjx) {
                    finish();
                    return true;
                }
                this.giV.lU(true);
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
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.Ae().getSignAlertMins());
                return;
            } else if (i == d.g.no_disturb_start_time || i == d.g.no_disturb_end_time) {
                if (i == d.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ar().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Ae().As().split(":");
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
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (i == d.g.sign_remind) {
                    if (timePicker != null) {
                        timePicker.clearFocus();
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ae().setSignAlertTime(timePicker.getCurrentHour().intValue(), timePicker.getCurrentMinute().intValue());
                        MsgRemindActivity.this.giV.bmB();
                    }
                } else if (i == d.g.no_disturb_end_time || i == d.g.no_disturb_start_time) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == d.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ae().fi(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ae().fj(str);
                    }
                    MsgRemindActivity.this.giV.bmC();
                }
            }
        }, 0, 0, true);
        if (i == d.g.sign_remind) {
            bVar.setTitle(d.k.sign_remind);
        } else if (i == d.g.no_disturb_end_time) {
            bVar.setTitle(d.k.no_disturb_end_time);
        } else if (i == d.g.no_disturb_start_time) {
            bVar.setTitle(d.k.no_disturb_start_time);
        }
        bVar.setButton(-1, getPageContext().getString(d.k.alert_yes_button), bVar);
        bVar.setButton(-2, getPageContext().getString(d.k.cancel), bVar);
        bVar.getWindow().setSoftInputMode(2);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Af();
    }
}
