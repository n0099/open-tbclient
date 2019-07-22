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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import java.util.Date;
/* loaded from: classes3.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel iSg;
    private g iSr;
    private final com.baidu.tbadk.widget.timepicker.a.d.e iSs = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.iSr != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aok().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.iSr.ckU();
                MsgRemindActivity.this.iSr.clv();
            }
        }
    };
    private MsgRemindModel.a iQc = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void f(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView ckX = MsgRemindActivity.this.iSr.ckX();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aok().jx(300);
                        MsgRemindActivity.this.iSr.qH(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aok().jx(0);
                        MsgRemindActivity.this.iSr.qH(false);
                    }
                    if (ckX != null) {
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    ckX.nk();
                                } else {
                                    ckX.nl();
                                }
                            }
                        }, 500L);
                    }
                } else if (ckX != null) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                ckX.nl();
                            } else {
                                ckX.nk();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aok().eL(z2);
                }
                MsgRemindActivity.this.iSr.clr();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aok().eM(z2);
                }
                MsgRemindActivity.this.iSr.cls();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aok().eC(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.iSr.clu();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aok().eB(z2);
                }
                MsgRemindActivity.this.iSr.clt();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aok().eK(z2);
                }
                MsgRemindActivity.this.iSr.clp();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aok().eD(z2);
                }
                MsgRemindActivity.this.iSr.clq();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iSr = new g(this);
        this.iSr.b(this);
        this.iSg = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iSr.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iSr.ckW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aok().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").P("obj_type", 2));
                TiebaStatic.log(new an("c13254").P("obj_type", 1));
                this.iSr.ckU();
                this.iSr.qG(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aok().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").P("obj_type", 1));
            TiebaStatic.log(new an("c13254").P("obj_type", 0));
            this.iSr.qG(false);
        } else if (view == this.iSr.ckX()) {
            this.iSg.a(14, switchState == BdSwitchView.SwitchState.ON, this.iQc);
        } else if (view == this.iSr.ckZ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aok().eF(true);
                this.iSr.qF(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aok().eF(false);
            this.iSr.qF(false);
        } else if (view == this.iSr.cld()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aok().eI(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aok().eI(false);
            }
        } else if (view == this.iSr.cle()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aok().eG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aok().eG(false);
            }
        } else if (view == this.iSr.clf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aok().eH(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aok().eH(false);
            }
        } else if (view == this.iSr.clg()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aok().eJ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aok().eJ(false);
            }
        } else if (view == this.iSr.clh()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iSg.a(1, true, this.iQc);
            } else {
                this.iSg.a(1, false, this.iQc);
            }
        } else if (view == this.iSr.cli()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iSg.a(20, true, this.iQc);
            } else {
                this.iSg.a(20, false, this.iQc);
            }
        } else if (view == this.iSr.clj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iSg.a(2, true, this.iQc);
            } else {
                this.iSg.a(2, false, this.iQc);
            }
        } else if (view == this.iSr.clk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iSg.a(5, true, this.iQc);
            } else {
                this.iSg.a(5, false, this.iQc);
            }
        } else if (view == this.iSr.cll()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iSg.a(4, true, this.iQc);
            } else {
                this.iSg.a(4, false, this.iQc);
            }
        } else if (view == this.iSr.clm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iSg.a(3, true, this.iQc);
            } else {
                this.iSg.a(3, false, this.iQc);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.iSr.ckO().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iSr.ckO()) {
            if (this.iSr.iSU) {
                finish();
            } else {
                this.iSr.qI(true);
            }
        } else if (view == this.iSr.ckY()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aoF().a(getPageContext(), this.iSs);
        } else if (view == this.iSr.cla()) {
            this.iSr.qI(false);
        } else if (view == this.iSr.clb()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.iSr.clc()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.iSr.cln()) {
            TiebaStatic.log(new an("c13286").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.iSr.clo()) {
            com.baidu.tbadk.core.c.a.acu().acw();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.iSr.iSU) {
                    finish();
                    return true;
                }
                this.iSr.qI(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        String[] split;
        if (dialog instanceof TimePickerDialog) {
            if (i == R.id.no_disturb_start_time || i == R.id.no_disturb_end_time) {
                if (i == R.id.no_disturb_start_time) {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aok().aox().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoy().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog An(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aok().pm(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aok().pn(str);
                    }
                    MsgRemindActivity.this.iSr.ckV();
                }
            }
        }, 0, 0, true);
        if (i == R.id.no_disturb_end_time) {
            bVar.setTitle(R.string.no_disturb_end_time);
        } else if (i == R.id.no_disturb_start_time) {
            bVar.setTitle(R.string.no_disturb_start_time);
        }
        bVar.setButton(-1, getPageContext().getString(R.string.alert_yes_button), bVar);
        bVar.setButton(-2, getPageContext().getString(R.string.cancel), bVar);
        bVar.getWindow().setSoftInputMode(2);
        return bVar;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        if (i == R.id.no_disturb_end_time || i == R.id.no_disturb_start_time) {
            return An(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aok().aol();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iSr != null) {
            this.iSr.onDestroy();
        }
    }
}
