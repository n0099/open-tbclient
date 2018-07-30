package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TimePicker;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel gAp;
    private f gAw;
    private MsgRemindModel.a gys = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bqG = MsgRemindActivity.this.gAw.bqG();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DS().eb(300);
                        MsgRemindActivity.this.gAw.lW(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DS().eb(0);
                        MsgRemindActivity.this.gAw.lW(false);
                    }
                    if (bqG != null) {
                        com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    bqG.mC();
                                } else {
                                    bqG.mD();
                                }
                            }
                        }, 500L);
                    }
                } else if (bqG != null) {
                    com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                bqG.mD();
                            } else {
                                bqG.mC();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().bm(z2);
                }
                MsgRemindActivity.this.gAw.bqZ();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().bn(z2);
                }
                MsgRemindActivity.this.gAw.bra();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().bd(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.gAw.brc();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().bc(z2);
                }
                MsgRemindActivity.this.gAw.brb();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().bl(z2);
                }
                MsgRemindActivity.this.gAw.bqX();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().be(z2);
                }
                MsgRemindActivity.this.gAw.bqY();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gAw = new f(this);
        this.gAw.b(this);
        this.gAp = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gAw.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gAw.bqF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").r("obj_type", 2));
                this.gAw.bqD();
                this.gAw.lV(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.DS().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").r("obj_type", 1));
            this.gAw.lV(false);
        } else if (view == this.gAw.bqG()) {
            this.gAp.a(14, switchState == BdSwitchView.SwitchState.ON, this.gys);
        } else if (view == this.gAw.bqI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bg(true);
                this.gAw.lU(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.DS().bg(false);
            this.gAw.lU(false);
        } else if (view == this.gAw.bqM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bj(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bj(false);
            }
        } else if (view == this.gAw.bqN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bh(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bh(false);
            }
        } else if (view == this.gAw.bqO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bi(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bi(false);
            }
        } else if (view == this.gAw.bqP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bk(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bk(false);
            }
        } else if (view == this.gAw.bqQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAp.a(1, true, this.gys);
            } else {
                this.gAp.a(1, false, this.gys);
            }
        } else if (view == this.gAw.bqR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAp.a(20, true, this.gys);
            } else {
                this.gAp.a(20, false, this.gys);
            }
        } else if (view == this.gAw.bqS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAp.a(2, true, this.gys);
            } else {
                this.gAp.a(2, false, this.gys);
            }
        } else if (view == this.gAw.bqT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAp.a(5, true, this.gys);
            } else {
                this.gAp.a(5, false, this.gys);
            }
        } else if (view == this.gAw.bqU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAp.a(4, true, this.gys);
            } else {
                this.gAp.a(4, false, this.gys);
            }
        } else if (view == this.gAw.bqV()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAp.a(3, true, this.gys);
            } else {
                this.gAp.a(3, false, this.gys);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.gAw.bqx().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gAw.bqx()) {
            if (this.gAw.gAY) {
                finish();
            } else {
                this.gAw.lX(true);
            }
        } else if (view == this.gAw.bqH()) {
            showDialog(d.g.sign_remind);
        } else if (view == this.gAw.bqJ()) {
            this.gAw.lX(false);
        } else if (view == this.gAw.bqK()) {
            showDialog(d.g.no_disturb_start_time);
        } else if (view == this.gAw.bqL()) {
            showDialog(d.g.no_disturb_end_time);
        } else if (view == this.gAw.bqW()) {
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.gAw.gAY) {
                    finish();
                    return true;
                }
                this.gAw.lX(true);
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
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.DS().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.DS().getSignAlertMins());
                return;
            } else if (i == d.g.no_disturb_start_time || i == d.g.no_disturb_end_time) {
                if (i == d.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ef().split(SystemInfoUtil.COLON);
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eg().split(SystemInfoUtil.COLON);
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
                        com.baidu.tbadk.coreExtra.messageCenter.c.DS().setSignAlertTime(timePicker.getCurrentHour().intValue(), timePicker.getCurrentMinute().intValue());
                        MsgRemindActivity.this.gAw.bqD();
                    }
                } else if (i == d.g.no_disturb_end_time || i == d.g.no_disturb_start_time) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + SystemInfoUtil.COLON + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == d.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DS().fH(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DS().fI(str);
                    }
                    MsgRemindActivity.this.gAw.bqE();
                }
            }
        }, 0, 0, true);
        if (i == d.g.sign_remind) {
            bVar.setTitle(d.j.sign_remind);
        } else if (i == d.g.no_disturb_end_time) {
            bVar.setTitle(d.j.no_disturb_end_time);
        } else if (i == d.g.no_disturb_start_time) {
            bVar.setTitle(d.j.no_disturb_start_time);
        }
        bVar.setButton(-1, getPageContext().getString(d.j.alert_yes_button), bVar);
        bVar.setButton(-2, getPageContext().getString(d.j.cancel), bVar);
        bVar.getWindow().setSoftInputMode(2);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.DS().DT();
    }
}
