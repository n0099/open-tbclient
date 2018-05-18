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
    private MsgRemindModel.a ghY = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void c(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bmD = MsgRemindActivity.this.gjY.bmD();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ad().dV(300);
                        MsgRemindActivity.this.gjY.lU(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ad().dV(0);
                        MsgRemindActivity.this.gjY.lU(false);
                    }
                    if (bmD != null) {
                        com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    bmD.jM();
                                } else {
                                    bmD.jN();
                                }
                            }
                        }, 500L);
                    }
                } else if (bmD != null) {
                    com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                bmD.jN();
                            } else {
                                bmD.jM();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ad().bh(z2);
                }
                MsgRemindActivity.this.gjY.bmW();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ad().bi(z2);
                }
                MsgRemindActivity.this.gjY.bmX();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ad().aY(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.gjY.bmZ();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ad().aX(z2);
                }
                MsgRemindActivity.this.gjY.bmY();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ad().bg(z2);
                }
                MsgRemindActivity.this.gjY.bmU();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ad().aZ(z2);
                }
                MsgRemindActivity.this.gjY.bmV();
            }
        }
    };
    private MsgRemindModel gjR;
    private f gjY;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gjY = new f(this);
        this.gjY.b(this);
        this.gjR = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gjY.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (view2 == this.gjY.bmC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ad().setSignAlertOn(true);
                TiebaStatic.log(new al("c12939").r("obj_type", 2));
                this.gjY.bmA();
                this.gjY.lT(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Ad().setSignAlertOn(false);
            TiebaStatic.log(new al("c12939").r("obj_type", 1));
            this.gjY.lT(false);
        } else if (view2 == this.gjY.bmD()) {
            this.gjR.a(14, switchState == BdSwitchView.SwitchState.ON, this.ghY);
        } else if (view2 == this.gjY.bmF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ad().bb(true);
                this.gjY.lS(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Ad().bb(false);
            this.gjY.lS(false);
        } else if (view2 == this.gjY.bmJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ad().be(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ad().be(false);
            }
        } else if (view2 == this.gjY.bmK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ad().bc(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ad().bc(false);
            }
        } else if (view2 == this.gjY.bmL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ad().bd(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ad().bd(false);
            }
        } else if (view2 == this.gjY.bmM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ad().bf(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ad().bf(false);
            }
        } else if (view2 == this.gjY.bmN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gjR.a(1, true, this.ghY);
            } else {
                this.gjR.a(1, false, this.ghY);
            }
        } else if (view2 == this.gjY.bmO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gjR.a(20, true, this.ghY);
            } else {
                this.gjR.a(20, false, this.ghY);
            }
        } else if (view2 == this.gjY.bmP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gjR.a(2, true, this.ghY);
            } else {
                this.gjR.a(2, false, this.ghY);
            }
        } else if (view2 == this.gjY.bmQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gjR.a(5, true, this.ghY);
            } else {
                this.gjR.a(5, false, this.ghY);
            }
        } else if (view2 == this.gjY.bmR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gjR.a(4, true, this.ghY);
            } else {
                this.gjR.a(4, false, this.ghY);
            }
        } else if (view2 == this.gjY.bmS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gjR.a(3, true, this.ghY);
            } else {
                this.gjR.a(3, false, this.ghY);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.gjY.bmu().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.gjY.bmu()) {
            if (this.gjY.gkA) {
                finish();
            } else {
                this.gjY.lV(true);
            }
        } else if (view2 == this.gjY.bmE()) {
            showDialog(d.g.sign_remind);
        } else if (view2 == this.gjY.bmG()) {
            this.gjY.lV(false);
        } else if (view2 == this.gjY.bmH()) {
            showDialog(d.g.no_disturb_start_time);
        } else if (view2 == this.gjY.bmI()) {
            showDialog(d.g.no_disturb_end_time);
        } else if (view2 == this.gjY.bmT()) {
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.gjY.gkA) {
                    finish();
                    return true;
                }
                this.gjY.lV(true);
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
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.Ad().getSignAlertMins());
                return;
            } else if (i == d.g.no_disturb_start_time || i == d.g.no_disturb_end_time) {
                if (i == d.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Aq().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Ar().split(":");
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
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ad().setSignAlertTime(timePicker.getCurrentHour().intValue(), timePicker.getCurrentMinute().intValue());
                        MsgRemindActivity.this.gjY.bmA();
                    }
                } else if (i == d.g.no_disturb_end_time || i == d.g.no_disturb_start_time) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == d.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ad().fi(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ad().fj(str);
                    }
                    MsgRemindActivity.this.gjY.bmB();
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
        com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Ae();
    }
}
