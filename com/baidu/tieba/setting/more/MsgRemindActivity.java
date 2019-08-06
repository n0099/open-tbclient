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
    private MsgRemindModel iTk;
    private g iTv;
    private final com.baidu.tbadk.widget.timepicker.a.d.e iTw = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.iTv != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aom().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.iTv.clm();
                MsgRemindActivity.this.iTv.clN();
            }
        }
    };
    private MsgRemindModel.a iRg = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void f(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView clp = MsgRemindActivity.this.iTv.clp();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aom().jy(300);
                        MsgRemindActivity.this.iTv.qI(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aom().jy(0);
                        MsgRemindActivity.this.iTv.qI(false);
                    }
                    if (clp != null) {
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    clp.nk();
                                } else {
                                    clp.nl();
                                }
                            }
                        }, 500L);
                    }
                } else if (clp != null) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                clp.nl();
                            } else {
                                clp.nk();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aom().eL(z2);
                }
                MsgRemindActivity.this.iTv.clJ();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aom().eM(z2);
                }
                MsgRemindActivity.this.iTv.clK();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aom().eC(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.iTv.clM();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aom().eB(z2);
                }
                MsgRemindActivity.this.iTv.clL();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aom().eK(z2);
                }
                MsgRemindActivity.this.iTv.clH();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aom().eD(z2);
                }
                MsgRemindActivity.this.iTv.clI();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iTv = new g(this);
        this.iTv.b(this);
        this.iTk = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iTv.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iTv.clo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aom().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").P("obj_type", 2));
                TiebaStatic.log(new an("c13254").P("obj_type", 1));
                this.iTv.clm();
                this.iTv.qH(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aom().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").P("obj_type", 1));
            TiebaStatic.log(new an("c13254").P("obj_type", 0));
            this.iTv.qH(false);
        } else if (view == this.iTv.clp()) {
            this.iTk.a(14, switchState == BdSwitchView.SwitchState.ON, this.iRg);
        } else if (view == this.iTv.clr()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aom().eF(true);
                this.iTv.qG(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aom().eF(false);
            this.iTv.qG(false);
        } else if (view == this.iTv.clv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aom().eI(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aom().eI(false);
            }
        } else if (view == this.iTv.clw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aom().eG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aom().eG(false);
            }
        } else if (view == this.iTv.clx()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aom().eH(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aom().eH(false);
            }
        } else if (view == this.iTv.cly()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aom().eJ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aom().eJ(false);
            }
        } else if (view == this.iTv.clz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iTk.a(1, true, this.iRg);
            } else {
                this.iTk.a(1, false, this.iRg);
            }
        } else if (view == this.iTv.clA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iTk.a(20, true, this.iRg);
            } else {
                this.iTk.a(20, false, this.iRg);
            }
        } else if (view == this.iTv.clB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iTk.a(2, true, this.iRg);
            } else {
                this.iTk.a(2, false, this.iRg);
            }
        } else if (view == this.iTv.clC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iTk.a(5, true, this.iRg);
            } else {
                this.iTk.a(5, false, this.iRg);
            }
        } else if (view == this.iTv.clD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iTk.a(4, true, this.iRg);
            } else {
                this.iTk.a(4, false, this.iRg);
            }
        } else if (view == this.iTv.clE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iTk.a(3, true, this.iRg);
            } else {
                this.iTk.a(3, false, this.iRg);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.iTv.clg().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iTv.clg()) {
            if (this.iTv.iTY) {
                finish();
            } else {
                this.iTv.qJ(true);
            }
        } else if (view == this.iTv.clq()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aoH().a(getPageContext(), this.iTw);
        } else if (view == this.iTv.cls()) {
            this.iTv.qJ(false);
        } else if (view == this.iTv.clt()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.iTv.clu()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.iTv.clF()) {
            TiebaStatic.log(new an("c13286").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.iTv.clG()) {
            com.baidu.tbadk.core.c.a.acv().acx();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.iTv.iTY) {
                    finish();
                    return true;
                }
                this.iTv.qJ(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoz().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoA().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog Ap(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aom().pm(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aom().pn(str);
                    }
                    MsgRemindActivity.this.iTv.cln();
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
            return Ap(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aom().aon();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iTv != null) {
            this.iTv.onDestroy();
        }
    }
}
