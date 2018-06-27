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
    private MsgRemindModel.a gxk = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void c(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bsd = MsgRemindActivity.this.gzo.bsd();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DW().dY(300);
                        MsgRemindActivity.this.gzo.ml(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DW().dY(0);
                        MsgRemindActivity.this.gzo.ml(false);
                    }
                    if (bsd != null) {
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    bsd.mA();
                                } else {
                                    bsd.mB();
                                }
                            }
                        }, 500L);
                    }
                } else if (bsd != null) {
                    com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                bsd.mB();
                            } else {
                                bsd.mA();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DW().bo(z2);
                }
                MsgRemindActivity.this.gzo.bsw();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DW().bp(z2);
                }
                MsgRemindActivity.this.gzo.bsx();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DW().bf(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.gzo.bsz();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DW().be(z2);
                }
                MsgRemindActivity.this.gzo.bsy();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DW().bn(z2);
                }
                MsgRemindActivity.this.gzo.bsu();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.DW().bg(z2);
                }
                MsgRemindActivity.this.gzo.bsv();
            }
        }
    };
    private MsgRemindModel gzh;
    private f gzo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gzo = new f(this);
        this.gzo.b(this);
        this.gzh = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gzo.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gzo.bsc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DW().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").r("obj_type", 2));
                this.gzo.bsa();
                this.gzo.mk(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.DW().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").r("obj_type", 1));
            this.gzo.mk(false);
        } else if (view == this.gzo.bsd()) {
            this.gzh.a(14, switchState == BdSwitchView.SwitchState.ON, this.gxk);
        } else if (view == this.gzo.bsf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DW().bi(true);
                this.gzo.mj(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.DW().bi(false);
            this.gzo.mj(false);
        } else if (view == this.gzo.bsj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DW().bl(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DW().bl(false);
            }
        } else if (view == this.gzo.bsk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DW().bj(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DW().bj(false);
            }
        } else if (view == this.gzo.bsl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DW().bk(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DW().bk(false);
            }
        } else if (view == this.gzo.bsm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.DW().bm(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.DW().bm(false);
            }
        } else if (view == this.gzo.bsn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gzh.a(1, true, this.gxk);
            } else {
                this.gzh.a(1, false, this.gxk);
            }
        } else if (view == this.gzo.bso()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gzh.a(20, true, this.gxk);
            } else {
                this.gzh.a(20, false, this.gxk);
            }
        } else if (view == this.gzo.bsp()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gzh.a(2, true, this.gxk);
            } else {
                this.gzh.a(2, false, this.gxk);
            }
        } else if (view == this.gzo.bsq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gzh.a(5, true, this.gxk);
            } else {
                this.gzh.a(5, false, this.gxk);
            }
        } else if (view == this.gzo.bsr()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gzh.a(4, true, this.gxk);
            } else {
                this.gzh.a(4, false, this.gxk);
            }
        } else if (view == this.gzo.bss()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gzh.a(3, true, this.gxk);
            } else {
                this.gzh.a(3, false, this.gxk);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.gzo.brU().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gzo.brU()) {
            if (this.gzo.gzQ) {
                finish();
            } else {
                this.gzo.mm(true);
            }
        } else if (view == this.gzo.bse()) {
            showDialog(d.g.sign_remind);
        } else if (view == this.gzo.bsg()) {
            this.gzo.mm(false);
        } else if (view == this.gzo.bsh()) {
            showDialog(d.g.no_disturb_start_time);
        } else if (view == this.gzo.bsi()) {
            showDialog(d.g.no_disturb_end_time);
        } else if (view == this.gzo.bst()) {
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.gzo.gzQ) {
                    finish();
                    return true;
                }
                this.gzo.mm(true);
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
                ((TimePickerDialog) dialog).updateTime(com.baidu.tbadk.coreExtra.messageCenter.c.DW().getSignAlertHours(), com.baidu.tbadk.coreExtra.messageCenter.c.DW().getSignAlertMins());
                return;
            } else if (i == d.g.no_disturb_start_time || i == d.g.no_disturb_end_time) {
                if (i == d.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ej().split(SystemInfoUtil.COLON);
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ek().split(SystemInfoUtil.COLON);
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
                        com.baidu.tbadk.coreExtra.messageCenter.c.DW().setSignAlertTime(timePicker.getCurrentHour().intValue(), timePicker.getCurrentMinute().intValue());
                        MsgRemindActivity.this.gzo.bsa();
                    }
                } else if (i == d.g.no_disturb_end_time || i == d.g.no_disturb_start_time) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + SystemInfoUtil.COLON + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == d.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DW().fJ(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DW().fK(str);
                    }
                    MsgRemindActivity.this.gzo.bsb();
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
        com.baidu.tbadk.coreExtra.messageCenter.c.DW().DX();
    }
}
