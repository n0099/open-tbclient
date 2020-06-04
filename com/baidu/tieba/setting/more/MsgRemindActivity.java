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
    private MsgRemindModel kXO;
    private g kXZ;
    private final com.baidu.tbadk.widget.timepicker.a.d.e kYa = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.kXZ != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZT().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.kXZ.cYG();
                MsgRemindActivity.this.kXZ.cZh();
            }
        }
    };
    private MsgRemindModel.a kVF = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cYJ = MsgRemindActivity.this.kXZ.cYJ();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aZT().mI(300);
                        MsgRemindActivity.this.kXZ.tX(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aZT().mI(0);
                        MsgRemindActivity.this.kXZ.tX(false);
                    }
                    if (cYJ != null) {
                        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cYJ.turnOnNoCallback();
                                } else {
                                    cYJ.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cYJ != null) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cYJ.turnOffNoCallback();
                            } else {
                                cYJ.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hF(z2);
                }
                MsgRemindActivity.this.kXZ.cZd();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hG(z2);
                }
                MsgRemindActivity.this.kXZ.cZe();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hw(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.kXZ.cZg();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hv(z2);
                }
                MsgRemindActivity.this.kXZ.cZf();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hE(z2);
                }
                MsgRemindActivity.this.kXZ.cZb();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hx(z2);
                }
                MsgRemindActivity.this.kXZ.cZc();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kXZ = new g(this);
        this.kXZ.b(this);
        this.kXO = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kXZ.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.kXZ.cYI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZT().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").ag("obj_type", 2));
                TiebaStatic.log(new an("c13254").ag("obj_type", 1));
                this.kXZ.cYG();
                this.kXZ.tW(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aZT().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").ag("obj_type", 1));
            TiebaStatic.log(new an("c13254").ag("obj_type", 0));
            this.kXZ.tW(false);
        } else if (view == this.kXZ.cYJ()) {
            this.kXO.a(14, switchState == BdSwitchView.SwitchState.ON, this.kVF);
        } else if (view == this.kXZ.cYL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hz(true);
                this.kXZ.tV(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hz(false);
            this.kXZ.tV(false);
        } else if (view == this.kXZ.cYP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hC(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hC(false);
            }
        } else if (view == this.kXZ.cYQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hA(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hA(false);
            }
        } else if (view == this.kXZ.cYR()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hB(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hB(false);
            }
        } else if (view == this.kXZ.cYS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hD(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aZT().hD(false);
            }
        } else if (view == this.kXZ.cYT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kXO.a(1, true, this.kVF);
            } else {
                this.kXO.a(1, false, this.kVF);
            }
        } else if (view == this.kXZ.cYU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kXO.a(20, true, this.kVF);
            } else {
                this.kXO.a(20, false, this.kVF);
            }
        } else if (view == this.kXZ.cYV()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kXO.a(2, true, this.kVF);
            } else {
                this.kXO.a(2, false, this.kVF);
            }
        } else if (view == this.kXZ.cYW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kXO.a(5, true, this.kVF);
            } else {
                this.kXO.a(5, false, this.kVF);
            }
        } else if (view == this.kXZ.cYX()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kXO.a(4, true, this.kVF);
            } else {
                this.kXO.a(4, false, this.kVF);
            }
        } else if (view == this.kXZ.cYY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.kXO.a(3, true, this.kVF);
            } else {
                this.kXO.a(3, false, this.kVF);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.kXZ.HI().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kXZ.HI()) {
            if (this.kXZ.kYC) {
                finish();
            } else {
                this.kXZ.tY(true);
            }
        } else if (view == this.kXZ.cYK()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bao().a(getPageContext(), this.kYa);
        } else if (view == this.kXZ.cYM()) {
            this.kXZ.tY(false);
        } else if (view == this.kXZ.cYN()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.kXZ.cYO()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.kXZ.cYZ()) {
            TiebaStatic.log(new an("c13286").dh("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.kXZ.cZa()) {
            com.baidu.tbadk.core.b.a.aOf().aOh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.kXZ.kYC) {
                    finish();
                    return true;
                }
                this.kXZ.tY(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bag().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bah().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog Dc(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aZT().xn(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aZT().xo(str);
                    }
                    MsgRemindActivity.this.kXZ.cYH();
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
            return Dc(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aZT().aZU();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kXZ != null) {
            this.kXZ.onDestroy();
        }
    }
}
