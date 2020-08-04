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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import java.util.Date;
/* loaded from: classes20.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel lzf;
    private g lzq;
    private final com.baidu.tbadk.widget.timepicker.a.d.e lzr = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.lzq != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bfO().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.lzq.dgd();
                MsgRemindActivity.this.lzq.dgE();
            }
        }
    };
    private MsgRemindModel.a lwV = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void h(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView dgg = MsgRemindActivity.this.lzq.dgg();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bfO().nu(300);
                        MsgRemindActivity.this.lzq.uQ(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bfO().nu(0);
                        MsgRemindActivity.this.lzq.uQ(false);
                    }
                    if (dgg != null) {
                        com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    dgg.turnOnNoCallback();
                                } else {
                                    dgg.turnOffNoCallback();
                                }
                            }
                        }, 500L);
                    }
                } else if (dgg != null) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                dgg.turnOffNoCallback();
                            } else {
                                dgg.turnOnNoCallback();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bfO().is(z2);
                }
                MsgRemindActivity.this.lzq.dgA();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bfO().it(z2);
                }
                MsgRemindActivity.this.lzq.dgB();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bfO().ij(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.lzq.dgD();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bfO().ii(z2);
                }
                MsgRemindActivity.this.lzq.dgC();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bfO().ir(z2);
                }
                MsgRemindActivity.this.lzq.dgy();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.bfO().ik(z2);
                }
                MsgRemindActivity.this.lzq.dgz();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lzq = new g(this);
        this.lzq.b(this);
        this.lzf = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lzq.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.lzq.dgf()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bfO().setSignAlertOn(true);
                TiebaStatic.log(new ap("c12939").ah("obj_type", 2));
                TiebaStatic.log(new ap("c13254").ah("obj_type", 1));
                this.lzq.dgd();
                this.lzq.uP(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bfO().setSignAlertOn(false);
            TiebaStatic.log(new ap("c12939").ah("obj_type", 1));
            TiebaStatic.log(new ap("c13254").ah("obj_type", 0));
            this.lzq.uP(false);
        } else if (view == this.lzq.dgg()) {
            this.lzf.a(14, switchState == BdSwitchView.SwitchState.ON, this.lwV);
        } else if (view == this.lzq.dgi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bfO().im(true);
                this.lzq.uO(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.bfO().im(false);
            this.lzq.uO(false);
        } else if (view == this.lzq.dgm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bfO().ip(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bfO().ip(false);
            }
        } else if (view == this.lzq.dgn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bfO().in(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bfO().in(false);
            }
        } else if (view == this.lzq.dgo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bfO().io(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bfO().io(false);
            }
        } else if (view == this.lzq.dgp()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.bfO().iq(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.bfO().iq(false);
            }
        } else if (view == this.lzq.dgq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lzf.a(1, true, this.lwV);
            } else {
                this.lzf.a(1, false, this.lwV);
            }
        } else if (view == this.lzq.dgr()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lzf.a(20, true, this.lwV);
            } else {
                this.lzf.a(20, false, this.lwV);
            }
        } else if (view == this.lzq.dgs()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lzf.a(2, true, this.lwV);
            } else {
                this.lzf.a(2, false, this.lwV);
            }
        } else if (view == this.lzq.dgt()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lzf.a(5, true, this.lwV);
            } else {
                this.lzf.a(5, false, this.lwV);
            }
        } else if (view == this.lzq.dgu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lzf.a(4, true, this.lwV);
            } else {
                this.lzf.a(4, false, this.lwV);
            }
        } else if (view == this.lzq.dgv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.lzf.a(3, true, this.lwV);
            } else {
                this.lzf.a(3, false, this.lwV);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.lzq.Jb().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lzq.Jb()) {
            if (this.lzq.lzT) {
                finish();
            } else {
                this.lzq.uR(true);
            }
        } else if (view == this.lzq.dgh()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.bgj().a(getPageContext(), this.lzr);
        } else if (view == this.lzq.dgj()) {
            this.lzq.uR(false);
        } else if (view == this.lzq.dgk()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.lzq.dgl()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.lzq.dgw()) {
            TiebaStatic.log(new ap("c13286").dn("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.lzq.dgx()) {
            com.baidu.tbadk.core.b.a.aTK().aTM();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.lzq.lzT) {
                    finish();
                    return true;
                }
                this.lzq.uR(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgb().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgc().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog EA(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bfO().yM(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bfO().yN(str);
                    }
                    MsgRemindActivity.this.lzq.dge();
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
            return EA(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfP();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lzq != null) {
            this.lzq.onDestroy();
        }
    }
}
