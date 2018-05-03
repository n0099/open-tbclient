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
    private MsgRemindModel.a ggS = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void c(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bmE = MsgRemindActivity.this.giS.bmE();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ae().dU(300);
                        MsgRemindActivity.this.giS.lT(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ae().dU(0);
                        MsgRemindActivity.this.giS.lT(false);
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
                MsgRemindActivity.this.giS.bmX();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bi(z2);
                }
                MsgRemindActivity.this.giS.bmY();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().aY(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.giS.bna();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().aX(z2);
                }
                MsgRemindActivity.this.giS.bmZ();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bg(z2);
                }
                MsgRemindActivity.this.giS.bmV();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Ae().aZ(z2);
                }
                MsgRemindActivity.this.giS.bmW();
            }
        }
    };
    private MsgRemindModel giL;
    private f giS;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.giS = new f(this);
        this.giS.b(this);
        this.giL = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.giS.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (view2 == this.giS.bmD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().setSignAlertOn(true);
                TiebaStatic.log(new al("c12939").r("obj_type", 2));
                this.giS.bmB();
                this.giS.lS(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Ae().setSignAlertOn(false);
            TiebaStatic.log(new al("c12939").r("obj_type", 1));
            this.giS.lS(false);
        } else if (view2 == this.giS.bmE()) {
            this.giL.a(14, switchState == BdSwitchView.SwitchState.ON, this.ggS);
        } else if (view2 == this.giS.bmG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bb(true);
                this.giS.lR(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bb(false);
            this.giS.lR(false);
        } else if (view2 == this.giS.bmK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().be(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().be(false);
            }
        } else if (view2 == this.giS.bmL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bc(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bc(false);
            }
        } else if (view2 == this.giS.bmM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bd(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bd(false);
            }
        } else if (view2 == this.giS.bmN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bf(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Ae().bf(false);
            }
        } else if (view2 == this.giS.bmO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giL.a(1, true, this.ggS);
            } else {
                this.giL.a(1, false, this.ggS);
            }
        } else if (view2 == this.giS.bmP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giL.a(20, true, this.ggS);
            } else {
                this.giL.a(20, false, this.ggS);
            }
        } else if (view2 == this.giS.bmQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giL.a(2, true, this.ggS);
            } else {
                this.giL.a(2, false, this.ggS);
            }
        } else if (view2 == this.giS.bmR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giL.a(5, true, this.ggS);
            } else {
                this.giL.a(5, false, this.ggS);
            }
        } else if (view2 == this.giS.bmS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giL.a(4, true, this.ggS);
            } else {
                this.giL.a(4, false, this.ggS);
            }
        } else if (view2 == this.giS.bmT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.giL.a(3, true, this.ggS);
            } else {
                this.giL.a(3, false, this.ggS);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.giS.bmv().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.giS.bmv()) {
            if (this.giS.gju) {
                finish();
            } else {
                this.giS.lU(true);
            }
        } else if (view2 == this.giS.bmF()) {
            showDialog(d.g.sign_remind);
        } else if (view2 == this.giS.bmH()) {
            this.giS.lU(false);
        } else if (view2 == this.giS.bmI()) {
            showDialog(d.g.no_disturb_start_time);
        } else if (view2 == this.giS.bmJ()) {
            showDialog(d.g.no_disturb_end_time);
        } else if (view2 == this.giS.bmU()) {
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.giS.gju) {
                    finish();
                    return true;
                }
                this.giS.lU(true);
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
                        MsgRemindActivity.this.giS.bmB();
                    }
                } else if (i == d.g.no_disturb_end_time || i == d.g.no_disturb_start_time) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == d.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ae().fi(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ae().fj(str);
                    }
                    MsgRemindActivity.this.giS.bmC();
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
