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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
/* loaded from: classes3.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel.a gts = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void c(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView brC = MsgRemindActivity.this.gvw.brC();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().dX(300);
                        MsgRemindActivity.this.gvw.ma(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().dX(0);
                        MsgRemindActivity.this.gvw.ma(false);
                    }
                    if (brC != null) {
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    brC.mA();
                                } else {
                                    brC.mB();
                                }
                            }
                        }, 500L);
                    }
                } else if (brC != null) {
                    com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                brC.mB();
                            } else {
                                brC.mA();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DE().bl(z2);
                }
                MsgRemindActivity.this.gvw.brV();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DE().bm(z2);
                }
                MsgRemindActivity.this.gvw.brW();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DE().bc(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.gvw.brY();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DE().bb(z2);
                }
                MsgRemindActivity.this.gvw.brX();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DE().bk(z2);
                }
                MsgRemindActivity.this.gvw.brT();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DE().bd(z2);
                }
                MsgRemindActivity.this.gvw.brU();
            }
        }
    };
    private MsgRemindModel gvp;
    private f gvw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gvw = new f(this);
        this.gvw.b(this);
        this.gvp = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gvw.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gvw.brB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DE().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").r("obj_type", 2));
                this.gvw.brz();
                this.gvw.lZ(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.DE().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").r("obj_type", 1));
            this.gvw.lZ(false);
        } else if (view == this.gvw.brC()) {
            this.gvp.a(14, switchState == BdSwitchView.SwitchState.ON, this.gts);
        } else if (view == this.gvw.brE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DE().bf(true);
                this.gvw.lY(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bf(false);
            this.gvw.lY(false);
        } else if (view == this.gvw.brI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DE().bi(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DE().bi(false);
            }
        } else if (view == this.gvw.brJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DE().bg(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DE().bg(false);
            }
        } else if (view == this.gvw.brK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DE().bh(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DE().bh(false);
            }
        } else if (view == this.gvw.brL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DE().bj(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DE().bj(false);
            }
        } else if (view == this.gvw.brM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gvp.a(1, true, this.gts);
            } else {
                this.gvp.a(1, false, this.gts);
            }
        } else if (view == this.gvw.brN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gvp.a(20, true, this.gts);
            } else {
                this.gvp.a(20, false, this.gts);
            }
        } else if (view == this.gvw.brO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gvp.a(2, true, this.gts);
            } else {
                this.gvp.a(2, false, this.gts);
            }
        } else if (view == this.gvw.brP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gvp.a(5, true, this.gts);
            } else {
                this.gvp.a(5, false, this.gts);
            }
        } else if (view == this.gvw.brQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gvp.a(4, true, this.gts);
            } else {
                this.gvp.a(4, false, this.gts);
            }
        } else if (view == this.gvw.brR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gvp.a(3, true, this.gts);
            } else {
                this.gvp.a(3, false, this.gts);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.gvw.brt().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gvw.brt()) {
            if (this.gvw.gvY) {
                finish();
            } else {
                this.gvw.mb(true);
            }
        } else if (view == this.gvw.brD()) {
            showDialog(d.g.sign_remind);
        } else if (view == this.gvw.brF()) {
            this.gvw.mb(false);
        } else if (view == this.gvw.brG()) {
            showDialog(d.g.no_disturb_start_time);
        } else if (view == this.gvw.brH()) {
            showDialog(d.g.no_disturb_end_time);
        } else if (view == this.gvw.brS()) {
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.gvw.gvY) {
                    finish();
                    return true;
                }
                this.gvw.mb(true);
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
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.DE().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.DE().getSignAlertMins());
                return;
            } else if (i == d.g.no_disturb_start_time || i == d.g.no_disturb_end_time) {
                if (i == d.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.DE().DR().split(SystemInfoUtil.COLON);
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.DE().DS().split(SystemInfoUtil.COLON);
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
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().setSignAlertTime(timePicker.getCurrentHour().intValue(), timePicker.getCurrentMinute().intValue());
                        MsgRemindActivity.this.gvw.brz();
                    }
                } else if (i == d.g.no_disturb_end_time || i == d.g.no_disturb_start_time) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + SystemInfoUtil.COLON + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == d.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().fF(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().fG(str);
                    }
                    MsgRemindActivity.this.gvw.brA();
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
        com.baidu.tbadk.coreExtra.messageCenter.c.DE().DF();
    }
}
