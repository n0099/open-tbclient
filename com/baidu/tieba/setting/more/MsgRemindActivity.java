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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import java.util.Date;
/* loaded from: classes13.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel lrL;
    private g lrW;
    private final com.baidu.tbadk.widget.timepicker.a.d.e lrX = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.lrW != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bbV().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.lrW.dcW();
                MsgRemindActivity.this.lrW.ddx();
            }
        }
    };
    private MsgRemindModel.a lpC = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dcZ = MsgRemindActivity.this.lrW.dcZ();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bbV().nc(300);
                        MsgRemindActivity.this.lrW.um(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bbV().nc(0);
                        MsgRemindActivity.this.lrW.um(false);
                    }
                    if (dcZ != null) {
                        com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dcZ.turnOnNoCallback();
                                } else {
                                    dcZ.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dcZ != null) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dcZ.turnOffNoCallback();
                            } else {
                                dcZ.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hO(z2);
                }
                MsgRemindActivity.this.lrW.ddt();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hP(z2);
                }
                MsgRemindActivity.this.lrW.ddu();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hF(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.lrW.ddw();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hE(z2);
                }
                MsgRemindActivity.this.lrW.ddv();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hN(z2);
                }
                MsgRemindActivity.this.lrW.ddr();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hG(z2);
                }
                MsgRemindActivity.this.lrW.dds();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lrW = new g(this);
        this.lrW.b(this);
        this.lrL = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lrW.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.lrW.dcY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bbV().setSignAlertOn(true);
                TiebaStatic.log(new ao("c12939").ag("obj_type", 2));
                TiebaStatic.log(new ao("c13254").ag("obj_type", 1));
                this.lrW.dcW();
                this.lrW.ul(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bbV().setSignAlertOn(false);
            TiebaStatic.log(new ao("c12939").ag("obj_type", 1));
            TiebaStatic.log(new ao("c13254").ag("obj_type", 0));
            this.lrW.ul(false);
        } else if (view == this.lrW.dcZ()) {
            this.lrL.a(14, switchState == BdSwitchView.SwitchState.ON, this.lpC);
        } else if (view == this.lrW.ddb()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hI(true);
                this.lrW.uk(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hI(false);
            this.lrW.uk(false);
        } else if (view == this.lrW.ddf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hL(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hL(false);
            }
        } else if (view == this.lrW.ddg()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hJ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hJ(false);
            }
        } else if (view == this.lrW.ddh()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hK(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hK(false);
            }
        } else if (view == this.lrW.ddi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hM(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bbV().hM(false);
            }
        } else if (view == this.lrW.ddj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lrL.a(1, true, this.lpC);
            } else {
                this.lrL.a(1, false, this.lpC);
            }
        } else if (view == this.lrW.ddk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lrL.a(20, true, this.lpC);
            } else {
                this.lrL.a(20, false, this.lpC);
            }
        } else if (view == this.lrW.ddl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lrL.a(2, true, this.lpC);
            } else {
                this.lrL.a(2, false, this.lpC);
            }
        } else if (view == this.lrW.ddm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lrL.a(5, true, this.lpC);
            } else {
                this.lrL.a(5, false, this.lpC);
            }
        } else if (view == this.lrW.ddn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lrL.a(4, true, this.lpC);
            } else {
                this.lrL.a(4, false, this.lpC);
            }
        } else if (view == this.lrW.ddo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lrL.a(3, true, this.lpC);
            } else {
                this.lrL.a(3, false, this.lpC);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.lrW.IV().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lrW.IV()) {
            if (this.lrW.lsz) {
                finish();
            } else {
                this.lrW.un(true);
            }
        } else if (view == this.lrW.dda()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bcq().a(getPageContext(), this.lrX);
        } else if (view == this.lrW.ddc()) {
            this.lrW.un(false);
        } else if (view == this.lrW.ddd()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.lrW.dde()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.lrW.ddp()) {
            TiebaStatic.log(new ao("c13286").dk("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.lrW.ddq()) {
            com.baidu.tbadk.core.b.a.aPP().aPR();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.lrW.lsz) {
                    finish();
                    return true;
                }
                this.lrW.un(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bci().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcj().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog Ee(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bbV().xG(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bbV().xH(str);
                    }
                    MsgRemindActivity.this.lrW.dcX();
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
            return Ee(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bbW();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lrW != null) {
            this.lrW.onDestroy();
        }
    }
}
