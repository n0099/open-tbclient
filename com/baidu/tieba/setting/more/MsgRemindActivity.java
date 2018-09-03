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
import com.baidu.tieba.f;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel gAs;
    private f gAz;
    private MsgRemindModel.a gyv = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bqH = MsgRemindActivity.this.gAz.bqH();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DS().ea(300);
                        MsgRemindActivity.this.gAz.lW(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DS().ea(0);
                        MsgRemindActivity.this.gAz.lW(false);
                    }
                    if (bqH != null) {
                        com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    bqH.mC();
                                } else {
                                    bqH.mD();
                                }
                            }
                        }, 500L);
                    }
                } else if (bqH != null) {
                    com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                bqH.mD();
                            } else {
                                bqH.mC();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().bn(z2);
                }
                MsgRemindActivity.this.gAz.bra();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().bo(z2);
                }
                MsgRemindActivity.this.gAz.brb();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().be(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.gAz.brd();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().bd(z2);
                }
                MsgRemindActivity.this.gAz.brc();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().bm(z2);
                }
                MsgRemindActivity.this.gAz.bqY();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DS().bf(z2);
                }
                MsgRemindActivity.this.gAz.bqZ();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gAz = new f(this);
        this.gAz.b(this);
        this.gAs = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gAz.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gAz.bqG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").r("obj_type", 2));
                this.gAz.bqE();
                this.gAz.lV(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.DS().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").r("obj_type", 1));
            this.gAz.lV(false);
        } else if (view == this.gAz.bqH()) {
            this.gAs.a(14, switchState == BdSwitchView.SwitchState.ON, this.gyv);
        } else if (view == this.gAz.bqJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bh(true);
                this.gAz.lU(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.DS().bh(false);
            this.gAz.lU(false);
        } else if (view == this.gAz.bqN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bk(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bk(false);
            }
        } else if (view == this.gAz.bqO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bi(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bi(false);
            }
        } else if (view == this.gAz.bqP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bj(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bj(false);
            }
        } else if (view == this.gAz.bqQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bl(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DS().bl(false);
            }
        } else if (view == this.gAz.bqR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAs.a(1, true, this.gyv);
            } else {
                this.gAs.a(1, false, this.gyv);
            }
        } else if (view == this.gAz.bqS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAs.a(20, true, this.gyv);
            } else {
                this.gAs.a(20, false, this.gyv);
            }
        } else if (view == this.gAz.bqT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAs.a(2, true, this.gyv);
            } else {
                this.gAs.a(2, false, this.gyv);
            }
        } else if (view == this.gAz.bqU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAs.a(5, true, this.gyv);
            } else {
                this.gAs.a(5, false, this.gyv);
            }
        } else if (view == this.gAz.bqV()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAs.a(4, true, this.gyv);
            } else {
                this.gAs.a(4, false, this.gyv);
            }
        } else if (view == this.gAz.bqW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gAs.a(3, true, this.gyv);
            } else {
                this.gAs.a(3, false, this.gyv);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.gAz.bqy().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gAz.bqy()) {
            if (this.gAz.gBb) {
                finish();
            } else {
                this.gAz.lX(true);
            }
        } else if (view == this.gAz.bqI()) {
            showDialog(f.g.sign_remind);
        } else if (view == this.gAz.bqK()) {
            this.gAz.lX(false);
        } else if (view == this.gAz.bqL()) {
            showDialog(f.g.no_disturb_start_time);
        } else if (view == this.gAz.bqM()) {
            showDialog(f.g.no_disturb_end_time);
        } else if (view == this.gAz.bqX()) {
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.gAz.gBb) {
                    finish();
                    return true;
                }
                this.gAz.lX(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == f.g.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.DS().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.DS().getSignAlertMins());
                return;
            } else if (i == f.g.no_disturb_start_time || i == f.g.no_disturb_end_time) {
                if (i == f.g.no_disturb_start_time) {
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
                if (i == f.g.sign_remind) {
                    if (timePicker != null) {
                        timePicker.clearFocus();
                        com.baidu.tbadk.coreExtra.messageCenter.c.DS().setSignAlertTime(timePicker.getCurrentHour().intValue(), timePicker.getCurrentMinute().intValue());
                        MsgRemindActivity.this.gAz.bqE();
                    }
                } else if (i == f.g.no_disturb_end_time || i == f.g.no_disturb_start_time) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + SystemInfoUtil.COLON + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == f.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DS().fH(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DS().fI(str);
                    }
                    MsgRemindActivity.this.gAz.bqF();
                }
            }
        }, 0, 0, true);
        if (i == f.g.sign_remind) {
            bVar.setTitle(f.j.sign_remind);
        } else if (i == f.g.no_disturb_end_time) {
            bVar.setTitle(f.j.no_disturb_end_time);
        } else if (i == f.g.no_disturb_start_time) {
            bVar.setTitle(f.j.no_disturb_start_time);
        }
        bVar.setButton(-1, getPageContext().getString(f.j.alert_yes_button), bVar);
        bVar.setButton(-2, getPageContext().getString(f.j.cancel), bVar);
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
