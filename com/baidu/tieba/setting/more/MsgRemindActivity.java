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
    private g iVD;
    private MsgRemindModel iVs;
    private final com.baidu.tbadk.widget.timepicker.a.d.e iVE = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.iVD != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.ara().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.iVD.cjL();
                MsgRemindActivity.this.iVD.ckm();
            }
        }
    };
    private MsgRemindModel.a iTm = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void f(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cjO = MsgRemindActivity.this.iVD.cjO();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.ara().jm(300);
                        MsgRemindActivity.this.iVD.qu(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.ara().jm(0);
                        MsgRemindActivity.this.iVD.qu(false);
                    }
                    if (cjO != null) {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cjO.turnOnNoCallback();
                                } else {
                                    cjO.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cjO != null) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cjO.turnOffNoCallback();
                            } else {
                                cjO.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.ara().eK(z2);
                }
                MsgRemindActivity.this.iVD.cki();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.ara().eL(z2);
                }
                MsgRemindActivity.this.iVD.ckj();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.ara().eB(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.iVD.ckl();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.ara().eA(z2);
                }
                MsgRemindActivity.this.iVD.ckk();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.ara().eJ(z2);
                }
                MsgRemindActivity.this.iVD.ckg();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.ara().eC(z2);
                }
                MsgRemindActivity.this.iVD.ckh();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iVD = new g(this);
        this.iVD.b(this);
        this.iVs = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iVD.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iVD.cjN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.ara().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").O("obj_type", 2));
                TiebaStatic.log(new an("c13254").O("obj_type", 1));
                this.iVD.cjL();
                this.iVD.qt(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.ara().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").O("obj_type", 1));
            TiebaStatic.log(new an("c13254").O("obj_type", 0));
            this.iVD.qt(false);
        } else if (view == this.iVD.cjO()) {
            this.iVs.a(14, switchState == BdSwitchView.SwitchState.ON, this.iTm);
        } else if (view == this.iVD.cjQ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.ara().eE(true);
                this.iVD.qs(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.ara().eE(false);
            this.iVD.qs(false);
        } else if (view == this.iVD.cjU()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.ara().eH(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.ara().eH(false);
            }
        } else if (view == this.iVD.cjV()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.ara().eF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.ara().eF(false);
            }
        } else if (view == this.iVD.cjW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.ara().eG(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.ara().eG(false);
            }
        } else if (view == this.iVD.cjX()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.ara().eI(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.ara().eI(false);
            }
        } else if (view == this.iVD.cjY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVs.a(1, true, this.iTm);
            } else {
                this.iVs.a(1, false, this.iTm);
            }
        } else if (view == this.iVD.cjZ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVs.a(20, true, this.iTm);
            } else {
                this.iVs.a(20, false, this.iTm);
            }
        } else if (view == this.iVD.cka()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVs.a(2, true, this.iTm);
            } else {
                this.iVs.a(2, false, this.iTm);
            }
        } else if (view == this.iVD.ckb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVs.a(5, true, this.iTm);
            } else {
                this.iVs.a(5, false, this.iTm);
            }
        } else if (view == this.iVD.ckc()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVs.a(4, true, this.iTm);
            } else {
                this.iVs.a(4, false, this.iTm);
            }
        } else if (view == this.iVD.ckd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVs.a(3, true, this.iTm);
            } else {
                this.iVs.a(3, false, this.iTm);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.iVD.vS().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iVD.vS()) {
            if (this.iVD.iWg) {
                finish();
            } else {
                this.iVD.qv(true);
            }
        } else if (view == this.iVD.cjP()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.arv().a(getPageContext(), this.iVE);
        } else if (view == this.iVD.cjR()) {
            this.iVD.qv(false);
        } else if (view == this.iVD.cjS()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.iVD.cjT()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.iVD.cke()) {
            TiebaStatic.log(new an("c13286").bS("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.iVD.ckf()) {
            com.baidu.tbadk.core.c.a.agF().agH();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.iVD.iWg) {
                    finish();
                    return true;
                }
                this.iVD.qv(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.ara().arn().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.ara().aro().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog za(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.ara().oQ(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.ara().oR(str);
                    }
                    MsgRemindActivity.this.iVD.cjM();
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
            return za(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.ara().arb();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iVD != null) {
            this.iVD.onDestroy();
        }
    }
}
