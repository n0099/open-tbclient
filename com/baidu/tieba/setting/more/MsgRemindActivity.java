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
    private g kEK;
    private MsgRemindModel kEz;
    private final com.baidu.tbadk.widget.timepicker.a.d.e kEL = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.kEK != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTN().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.kEK.cRp();
                MsgRemindActivity.this.kEK.cRQ();
            }
        }
    };
    private MsgRemindModel.a kCq = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cRs = MsgRemindActivity.this.kEK.cRs();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aTN().md(300);
                        MsgRemindActivity.this.kEK.tz(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aTN().md(0);
                        MsgRemindActivity.this.kEK.tz(false);
                    }
                    if (cRs != null) {
                        com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cRs.turnOnNoCallback();
                                } else {
                                    cRs.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cRs != null) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cRs.turnOffNoCallback();
                            } else {
                                cRs.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTN().hh(z2);
                }
                MsgRemindActivity.this.kEK.cRM();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTN().hi(z2);
                }
                MsgRemindActivity.this.kEK.cRN();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTN().gY(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.kEK.cRP();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTN().gX(z2);
                }
                MsgRemindActivity.this.kEK.cRO();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTN().hg(z2);
                }
                MsgRemindActivity.this.kEK.cRK();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aTN().gZ(z2);
                }
                MsgRemindActivity.this.kEK.cRL();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kEK = new g(this);
        this.kEK.b(this);
        this.kEz = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kEK.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.kEK.cRr()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTN().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").af("obj_type", 2));
                TiebaStatic.log(new an("c13254").af("obj_type", 1));
                this.kEK.cRp();
                this.kEK.ty(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aTN().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").af("obj_type", 1));
            TiebaStatic.log(new an("c13254").af("obj_type", 0));
            this.kEK.ty(false);
        } else if (view == this.kEK.cRs()) {
            this.kEz.a(14, switchState == BdSwitchView.SwitchState.ON, this.kCq);
        } else if (view == this.kEK.cRu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTN().hb(true);
                this.kEK.tx(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aTN().hb(false);
            this.kEK.tx(false);
        } else if (view == this.kEK.cRy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTN().he(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTN().he(false);
            }
        } else if (view == this.kEK.cRz()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTN().hc(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTN().hc(false);
            }
        } else if (view == this.kEK.cRA()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTN().hd(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTN().hd(false);
            }
        } else if (view == this.kEK.cRB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTN().hf(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aTN().hf(false);
            }
        } else if (view == this.kEK.cRC()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kEz.a(1, true, this.kCq);
            } else {
                this.kEz.a(1, false, this.kCq);
            }
        } else if (view == this.kEK.cRD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kEz.a(20, true, this.kCq);
            } else {
                this.kEz.a(20, false, this.kCq);
            }
        } else if (view == this.kEK.cRE()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kEz.a(2, true, this.kCq);
            } else {
                this.kEz.a(2, false, this.kCq);
            }
        } else if (view == this.kEK.cRF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kEz.a(5, true, this.kCq);
            } else {
                this.kEz.a(5, false, this.kCq);
            }
        } else if (view == this.kEK.cRG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kEz.a(4, true, this.kCq);
            } else {
                this.kEz.a(4, false, this.kCq);
            }
        } else if (view == this.kEK.cRH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kEz.a(3, true, this.kCq);
            } else {
                this.kEz.a(3, false, this.kCq);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.kEK.FF().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kEK.FF()) {
            if (this.kEK.kFn) {
                finish();
            } else {
                this.kEK.tA(true);
            }
        } else if (view == this.kEK.cRt()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aUi().a(getPageContext(), this.kEL);
        } else if (view == this.kEK.cRv()) {
            this.kEK.tA(false);
        } else if (view == this.kEK.cRw()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.kEK.cRx()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.kEK.cRI()) {
            TiebaStatic.log(new an("c13286").cI("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.kEK.cRJ()) {
            com.baidu.tbadk.core.b.a.aIt().aIv();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.kEK.kFn) {
                    finish();
                    return true;
                }
                this.kEK.tA(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aUa().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aUb().split(":");
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
                        com.baidu.tbadk.coreExtra.messageCenter.d.aTN().vE(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aTN().vF(str);
                    }
                    MsgRemindActivity.this.kEK.cRq();
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
        com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTO();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kEK != null) {
            this.kEK.onDestroy();
        }
    }
}
