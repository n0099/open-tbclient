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
/* loaded from: classes3.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel iUB;
    private g iUM;
    private final com.baidu.tbadk.widget.timepicker.a.d.e iUN = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.iUM != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aqY().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.iUM.cjJ();
                MsgRemindActivity.this.iUM.ckk();
            }
        }
    };
    private MsgRemindModel.a iSv = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void f(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cjM = MsgRemindActivity.this.iUM.cjM();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aqY().jl(300);
                        MsgRemindActivity.this.iUM.qu(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aqY().jl(0);
                        MsgRemindActivity.this.iUM.qu(false);
                    }
                    if (cjM != null) {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cjM.turnOnNoCallback();
                                } else {
                                    cjM.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cjM != null) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cjM.turnOffNoCallback();
                            } else {
                                cjM.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eK(z2);
                }
                MsgRemindActivity.this.iUM.ckg();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eL(z2);
                }
                MsgRemindActivity.this.iUM.ckh();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eB(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.iUM.ckj();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eA(z2);
                }
                MsgRemindActivity.this.iUM.cki();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eJ(z2);
                }
                MsgRemindActivity.this.iUM.cke();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eC(z2);
                }
                MsgRemindActivity.this.iUM.ckf();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iUM = new g(this);
        this.iUM.b(this);
        this.iUB = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iUM.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iUM.cjL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aqY().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").O("obj_type", 2));
                TiebaStatic.log(new an("c13254").O("obj_type", 1));
                this.iUM.cjJ();
                this.iUM.qt(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aqY().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").O("obj_type", 1));
            TiebaStatic.log(new an("c13254").O("obj_type", 0));
            this.iUM.qt(false);
        } else if (view == this.iUM.cjM()) {
            this.iUB.a(14, switchState == BdSwitchView.SwitchState.ON, this.iSv);
        } else if (view == this.iUM.cjO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eE(true);
                this.iUM.qs(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eE(false);
            this.iUM.qs(false);
        } else if (view == this.iUM.cjS()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eH(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eH(false);
            }
        } else if (view == this.iUM.cjT()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eF(false);
            }
        } else if (view == this.iUM.cjU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eG(false);
            }
        } else if (view == this.iUM.cjV()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eI(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aqY().eI(false);
            }
        } else if (view == this.iUM.cjW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iUB.a(1, true, this.iSv);
            } else {
                this.iUB.a(1, false, this.iSv);
            }
        } else if (view == this.iUM.cjX()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iUB.a(20, true, this.iSv);
            } else {
                this.iUB.a(20, false, this.iSv);
            }
        } else if (view == this.iUM.cjY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iUB.a(2, true, this.iSv);
            } else {
                this.iUB.a(2, false, this.iSv);
            }
        } else if (view == this.iUM.cjZ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iUB.a(5, true, this.iSv);
            } else {
                this.iUB.a(5, false, this.iSv);
            }
        } else if (view == this.iUM.cka()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iUB.a(4, true, this.iSv);
            } else {
                this.iUB.a(4, false, this.iSv);
            }
        } else if (view == this.iUM.ckb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iUB.a(3, true, this.iSv);
            } else {
                this.iUB.a(3, false, this.iSv);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.iUM.vT().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iUM.vT()) {
            if (this.iUM.iVp) {
                finish();
            } else {
                this.iUM.qv(true);
            }
        } else if (view == this.iUM.cjN()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.art().a(getPageContext(), this.iUN);
        } else if (view == this.iUM.cjP()) {
            this.iUM.qv(false);
        } else if (view == this.iUM.cjQ()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.iUM.cjR()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.iUM.ckc()) {
            TiebaStatic.log(new an("c13286").bS("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.iUM.ckd()) {
            com.baidu.tbadk.core.c.a.agD().agF();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.iUM.iVp) {
                    finish();
                    return true;
                }
                this.iUM.qv(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arl().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arm().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog yZ(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aqY().oQ(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aqY().oR(str);
                    }
                    MsgRemindActivity.this.iUM.cjK();
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
            return yZ(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aqY().aqZ();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iUM != null) {
            this.iUM.onDestroy();
        }
    }
}
