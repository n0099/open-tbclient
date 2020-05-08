package com.baidu.tieba.setting.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TimePicker;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import java.util.Date;
/* loaded from: classes13.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel kED;
    private g kEO;
    private final com.baidu.tbadk.widget.timepicker.a.d.e kEP = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.kEO != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTL().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.kEO.cRm();
                MsgRemindActivity.this.kEO.cRN();
            }
        }
    };
    private MsgRemindModel.a kCu = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cRp = MsgRemindActivity.this.kEO.cRp();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aTL().md(300);
                        MsgRemindActivity.this.kEO.tz(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aTL().md(0);
                        MsgRemindActivity.this.kEO.tz(false);
                    }
                    if (cRp != null) {
                        com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cRp.turnOnNoCallback();
                                } else {
                                    cRp.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cRp != null) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cRp.turnOffNoCallback();
                            } else {
                                cRp.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTL().hh(z2);
                }
                MsgRemindActivity.this.kEO.cRJ();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTL().hi(z2);
                }
                MsgRemindActivity.this.kEO.cRK();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTL().gY(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.kEO.cRM();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTL().gX(z2);
                }
                MsgRemindActivity.this.kEO.cRL();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTL().hg(z2);
                }
                MsgRemindActivity.this.kEO.cRH();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTL().gZ(z2);
                }
                MsgRemindActivity.this.kEO.cRI();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kEO = new g(this);
        this.kEO.b(this);
        this.kED = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kEO.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.kEO.cRo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTL().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").af("obj_type", 2));
                TiebaStatic.log(new an("c13254").af("obj_type", 1));
                this.kEO.cRm();
                this.kEO.ty(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aTL().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").af("obj_type", 1));
            TiebaStatic.log(new an("c13254").af("obj_type", 0));
            this.kEO.ty(false);
        } else if (view == this.kEO.cRp()) {
            this.kED.a(14, switchState == BdSwitchView.SwitchState.ON, this.kCu);
        } else if (view == this.kEO.cRr()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTL().hb(true);
                this.kEO.tx(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aTL().hb(false);
            this.kEO.tx(false);
        } else if (view == this.kEO.cRv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTL().he(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTL().he(false);
            }
        } else if (view == this.kEO.cRw()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTL().hc(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTL().hc(false);
            }
        } else if (view == this.kEO.cRx()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTL().hd(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTL().hd(false);
            }
        } else if (view == this.kEO.cRy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTL().hf(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTL().hf(false);
            }
        } else if (view == this.kEO.cRz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kED.a(1, true, this.kCu);
            } else {
                this.kED.a(1, false, this.kCu);
            }
        } else if (view == this.kEO.cRA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kED.a(20, true, this.kCu);
            } else {
                this.kED.a(20, false, this.kCu);
            }
        } else if (view == this.kEO.cRB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kED.a(2, true, this.kCu);
            } else {
                this.kED.a(2, false, this.kCu);
            }
        } else if (view == this.kEO.cRC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kED.a(5, true, this.kCu);
            } else {
                this.kED.a(5, false, this.kCu);
            }
        } else if (view == this.kEO.cRD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kED.a(4, true, this.kCu);
            } else {
                this.kED.a(4, false, this.kCu);
            }
        } else if (view == this.kEO.cRE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kED.a(3, true, this.kCu);
            } else {
                this.kED.a(3, false, this.kCu);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.kEO.FE().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kEO.FE()) {
            if (this.kEO.kFr) {
                finish();
            } else {
                this.kEO.tA(true);
            }
        } else if (view == this.kEO.cRq()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aUg().a(getPageContext(), this.kEP);
        } else if (view == this.kEO.cRs()) {
            this.kEO.tA(false);
        } else if (view == this.kEO.cRt()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.kEO.cRu()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.kEO.cRF()) {
            TiebaStatic.log(new an("c13286").cI("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.kEO.cRG()) {
            com.baidu.tbadk.core.b.a.aIr().aIt();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.kEO.kFr) {
                    finish();
                    return true;
                }
                this.kEO.tA(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTY().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTZ().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog Cq(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aTL().vH(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aTL().vI(str);
                    }
                    MsgRemindActivity.this.kEO.cRn();
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
            return Cq(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTM();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kEO != null) {
            this.kEO.onDestroy();
        }
    }
}
