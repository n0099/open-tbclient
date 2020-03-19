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
    private g jVC;
    private MsgRemindModel jVr;
    private final com.baidu.tbadk.widget.timepicker.a.d.e jVD = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.jVC != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLq().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.jVC.cGR();
                MsgRemindActivity.this.jVC.cHs();
            }
        }
    };
    private MsgRemindModel.a jTi = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cGU = MsgRemindActivity.this.jVC.cGU();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLq().lR(300);
                        MsgRemindActivity.this.jVC.sy(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLq().lR(0);
                        MsgRemindActivity.this.jVC.sy(false);
                    }
                    if (cGU != null) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cGU.turnOnNoCallback();
                                } else {
                                    cGU.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cGU != null) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cGU.turnOffNoCallback();
                            } else {
                                cGU.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gj(z2);
                }
                MsgRemindActivity.this.jVC.cHo();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gk(z2);
                }
                MsgRemindActivity.this.jVC.cHp();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLq().ga(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.jVC.cHr();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLq().fZ(z2);
                }
                MsgRemindActivity.this.jVC.cHq();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gi(z2);
                }
                MsgRemindActivity.this.jVC.cHm();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gb(z2);
                }
                MsgRemindActivity.this.jVC.cHn();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jVC = new g(this);
        this.jVC.b(this);
        this.jVr = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jVC.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jVC.cGT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLq().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").X("obj_type", 2));
                TiebaStatic.log(new an("c13254").X("obj_type", 1));
                this.jVC.cGR();
                this.jVC.sx(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aLq().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").X("obj_type", 1));
            TiebaStatic.log(new an("c13254").X("obj_type", 0));
            this.jVC.sx(false);
        } else if (view == this.jVC.cGU()) {
            this.jVr.a(14, switchState == BdSwitchView.SwitchState.ON, this.jTi);
        } else if (view == this.jVC.cGW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gd(true);
                this.jVC.sw(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gd(false);
            this.jVC.sw(false);
        } else if (view == this.jVC.cHa()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gg(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gg(false);
            }
        } else if (view == this.jVC.cHb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLq().ge(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLq().ge(false);
            }
        } else if (view == this.jVC.cHc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gf(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gf(false);
            }
        } else if (view == this.jVC.cHd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gh(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLq().gh(false);
            }
        } else if (view == this.jVC.cHe()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jVr.a(1, true, this.jTi);
            } else {
                this.jVr.a(1, false, this.jTi);
            }
        } else if (view == this.jVC.cHf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jVr.a(20, true, this.jTi);
            } else {
                this.jVr.a(20, false, this.jTi);
            }
        } else if (view == this.jVC.cHg()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jVr.a(2, true, this.jTi);
            } else {
                this.jVr.a(2, false, this.jTi);
            }
        } else if (view == this.jVC.cHh()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jVr.a(5, true, this.jTi);
            } else {
                this.jVr.a(5, false, this.jTi);
            }
        } else if (view == this.jVC.cHi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jVr.a(4, true, this.jTi);
            } else {
                this.jVr.a(4, false, this.jTi);
            }
        } else if (view == this.jVC.cHj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jVr.a(3, true, this.jTi);
            } else {
                this.jVr.a(3, false, this.jTi);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.jVC.AH().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jVC.AH()) {
            if (this.jVC.isFront) {
                finish();
            } else {
                this.jVC.sz(true);
            }
        } else if (view == this.jVC.cGV()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aLL().a(getPageContext(), this.jVD);
        } else if (view == this.jVC.cGX()) {
            this.jVC.sz(false);
        } else if (view == this.jVC.cGY()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.jVC.cGZ()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.jVC.cHk()) {
            TiebaStatic.log(new an("c13286").cx("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.jVC.cHl()) {
            com.baidu.tbadk.core.b.a.aAg().aAi();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.jVC.isFront) {
                    finish();
                    return true;
                }
                this.jVC.sz(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLD().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLE().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog BQ(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLq().uq(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLq().ur(str);
                    }
                    MsgRemindActivity.this.jVC.cGS();
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
            return BQ(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLr();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jVC != null) {
            this.jVC.onDestroy();
        }
    }
}
