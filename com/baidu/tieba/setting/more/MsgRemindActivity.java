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
    private MsgRemindModel jTD;
    private g jTO;
    private final com.baidu.tbadk.widget.timepicker.a.d.e jTP = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.jTO != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLl().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.jTO.cGw();
                MsgRemindActivity.this.jTO.cGX();
            }
        }
    };
    private MsgRemindModel.a jRu = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cGz = MsgRemindActivity.this.jTO.cGz();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLl().lP(300);
                        MsgRemindActivity.this.jTO.ss(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLl().lP(0);
                        MsgRemindActivity.this.jTO.ss(false);
                    }
                    if (cGz != null) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cGz.turnOnNoCallback();
                                } else {
                                    cGz.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (cGz != null) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cGz.turnOffNoCallback();
                            } else {
                                cGz.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLl().gi(z2);
                }
                MsgRemindActivity.this.jTO.cGT();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLl().gj(z2);
                }
                MsgRemindActivity.this.jTO.cGU();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLl().fZ(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.jTO.cGW();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLl().fY(z2);
                }
                MsgRemindActivity.this.jTO.cGV();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLl().gh(z2);
                }
                MsgRemindActivity.this.jTO.cGR();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aLl().ga(z2);
                }
                MsgRemindActivity.this.jTO.cGS();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jTO = new g(this);
        this.jTO.b(this);
        this.jTD = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jTO.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.jTO.cGy()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLl().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").X("obj_type", 2));
                TiebaStatic.log(new an("c13254").X("obj_type", 1));
                this.jTO.cGw();
                this.jTO.sr(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aLl().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").X("obj_type", 1));
            TiebaStatic.log(new an("c13254").X("obj_type", 0));
            this.jTO.sr(false);
        } else if (view == this.jTO.cGz()) {
            this.jTD.a(14, switchState == BdSwitchView.SwitchState.ON, this.jRu);
        } else if (view == this.jTO.cGB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLl().gc(true);
                this.jTO.sq(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aLl().gc(false);
            this.jTO.sq(false);
        } else if (view == this.jTO.cGF()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLl().gf(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLl().gf(false);
            }
        } else if (view == this.jTO.cGG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLl().gd(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLl().gd(false);
            }
        } else if (view == this.jTO.cGH()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLl().ge(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLl().ge(false);
            }
        } else if (view == this.jTO.cGI()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLl().gg(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aLl().gg(false);
            }
        } else if (view == this.jTO.cGJ()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTD.a(1, true, this.jRu);
            } else {
                this.jTD.a(1, false, this.jRu);
            }
        } else if (view == this.jTO.cGK()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTD.a(20, true, this.jRu);
            } else {
                this.jTD.a(20, false, this.jRu);
            }
        } else if (view == this.jTO.cGL()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTD.a(2, true, this.jRu);
            } else {
                this.jTD.a(2, false, this.jRu);
            }
        } else if (view == this.jTO.cGM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTD.a(5, true, this.jRu);
            } else {
                this.jTD.a(5, false, this.jRu);
            }
        } else if (view == this.jTO.cGN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTD.a(4, true, this.jRu);
            } else {
                this.jTD.a(4, false, this.jRu);
            }
        } else if (view == this.jTO.cGO()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.jTD.a(3, true, this.jRu);
            } else {
                this.jTD.a(3, false, this.jRu);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.jTO.AA().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jTO.AA()) {
            if (this.jTO.isFront) {
                finish();
            } else {
                this.jTO.st(true);
            }
        } else if (view == this.jTO.cGA()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aLG().a(getPageContext(), this.jTP);
        } else if (view == this.jTO.cGC()) {
            this.jTO.st(false);
        } else if (view == this.jTO.cGD()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.jTO.cGE()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.jTO.cGP()) {
            TiebaStatic.log(new an("c13286").cy("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.jTO.cGQ()) {
            com.baidu.tbadk.core.b.a.aAd().aAf();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.jTO.isFront) {
                    finish();
                    return true;
                }
                this.jTO.st(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLy().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLz().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog BI(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLl().up(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aLl().uq(str);
                    }
                    MsgRemindActivity.this.jTO.cGx();
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
            return BI(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLm();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jTO != null) {
            this.jTO.onDestroy();
        }
    }
}
