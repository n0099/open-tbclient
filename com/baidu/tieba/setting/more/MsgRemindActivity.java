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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import java.util.Date;
/* loaded from: classes3.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private f gQK;
    private MsgRemindModel gQz;
    private final com.baidu.tbadk.widget.timepicker.a.d.e gQL = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.gQK != null) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hs().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.gQK.bvS();
                MsgRemindActivity.this.gQK.bws();
            }
        }
    };
    private MsgRemindModel.a gOG = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void d(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView bvV = MsgRemindActivity.this.gQK.bvV();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hs().eJ(300);
                        MsgRemindActivity.this.gQK.mW(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hs().eJ(0);
                        MsgRemindActivity.this.gQK.mW(false);
                    }
                    if (bvV != null) {
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    bvV.nQ();
                                } else {
                                    bvV.nR();
                                }
                            }
                        }, 500L);
                    }
                } else if (bvV != null) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                bvV.nR();
                            } else {
                                bvV.nQ();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bZ(z2);
                }
                MsgRemindActivity.this.gQK.bwo();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hs().ca(z2);
                }
                MsgRemindActivity.this.gQK.bwp();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bQ(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.gQK.bwr();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bP(z2);
                }
                MsgRemindActivity.this.gQK.bwq();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bY(z2);
                }
                MsgRemindActivity.this.gQK.bwm();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bR(z2);
                }
                MsgRemindActivity.this.gQK.bwn();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gQK = new f(this);
        this.gQK.b(this);
        this.gQz = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gQK.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.gQK.bvU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hs().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").x("obj_type", 2));
                TiebaStatic.log(new am("c13254").x("obj_type", 1));
                this.gQK.bvS();
                this.gQK.mV(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Hs().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").x("obj_type", 1));
            TiebaStatic.log(new am("c13254").x("obj_type", 0));
            this.gQK.mV(false);
        } else if (view == this.gQK.bvV()) {
            this.gQz.a(14, switchState == BdSwitchView.SwitchState.ON, this.gOG);
        } else if (view == this.gQK.bvX()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bT(true);
                this.gQK.mU(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bT(false);
            this.gQK.mU(false);
        } else if (view == this.gQK.bwb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bW(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bW(false);
            }
        } else if (view == this.gQK.bwc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bU(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bU(false);
            }
        } else if (view == this.gQK.bwd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bV(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bV(false);
            }
        } else if (view == this.gQK.bwe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bX(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.Hs().bX(false);
            }
        } else if (view == this.gQK.bwf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gQz.a(1, true, this.gOG);
            } else {
                this.gQz.a(1, false, this.gOG);
            }
        } else if (view == this.gQK.bwg()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gQz.a(20, true, this.gOG);
            } else {
                this.gQz.a(20, false, this.gOG);
            }
        } else if (view == this.gQK.bwh()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gQz.a(2, true, this.gOG);
            } else {
                this.gQz.a(2, false, this.gOG);
            }
        } else if (view == this.gQK.bwi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gQz.a(5, true, this.gOG);
            } else {
                this.gQz.a(5, false, this.gOG);
            }
        } else if (view == this.gQK.bwj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gQz.a(4, true, this.gOG);
            } else {
                this.gQz.a(4, false, this.gOG);
            }
        } else if (view == this.gQK.bwk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.gQz.a(3, true, this.gOG);
            } else {
                this.gQz.a(3, false, this.gOG);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.gQK.bvM().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gQK.bvM()) {
            if (this.gQK.gRn) {
                finish();
            } else {
                this.gQK.mX(true);
            }
        } else if (view == this.gQK.bvW()) {
            com.baidu.tbadk.coreExtra.messageCenter.d.HN().a(getPageContext(), this.gQL);
        } else if (view == this.gQK.bvY()) {
            this.gQK.mX(false);
        } else if (view == this.gQK.bvZ()) {
            showDialog(e.g.no_disturb_start_time);
        } else if (view == this.gQK.bwa()) {
            showDialog(e.g.no_disturb_end_time);
        } else if (view == this.gQK.bwl()) {
            TiebaStatic.log(new am("c13286").ax("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.gQK.gRn) {
                    finish();
                    return true;
                }
                this.gQK.mX(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == e.g.no_disturb_start_time || i == e.g.no_disturb_end_time) {
                if (i == e.g.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HF().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HG().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog uf(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == e.g.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hs().gt(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hs().gu(str);
                    }
                    MsgRemindActivity.this.gQK.bvT();
                }
            }
        }, 0, 0, true);
        if (i == e.g.no_disturb_end_time) {
            bVar.setTitle(e.j.no_disturb_end_time);
        } else if (i == e.g.no_disturb_start_time) {
            bVar.setTitle(e.j.no_disturb_start_time);
        }
        bVar.setButton(-1, getPageContext().getString(e.j.alert_yes_button), bVar);
        bVar.setButton(-2, getPageContext().getString(e.j.cancel), bVar);
        bVar.getWindow().setSoftInputMode(2);
        return bVar;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        if (i == e.g.no_disturb_end_time || i == e.g.no_disturb_start_time) {
            return uf(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.c.Hs().Ht();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gQK != null) {
            this.gQK.onDestroy();
        }
    }
}
