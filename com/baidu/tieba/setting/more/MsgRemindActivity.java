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
    private MsgRemindModel iVF;
    private g iVQ;
    private final com.baidu.tbadk.widget.timepicker.a.d.e iVR = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.iVQ != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aoy().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.iVQ.clY();
                MsgRemindActivity.this.iVQ.cmz();
            }
        }
    };
    private MsgRemindModel.a iTB = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void f(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cmb = MsgRemindActivity.this.iVQ.cmb();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aoy().jB(300);
                        MsgRemindActivity.this.iVQ.qL(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aoy().jB(0);
                        MsgRemindActivity.this.iVQ.qL(false);
                    }
                    if (cmb != null) {
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cmb.nk();
                                } else {
                                    cmb.nl();
                                }
                            }
                        }, 500L);
                    }
                } else if (cmb != null) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cmb.nl();
                            } else {
                                cmb.nk();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eO(z2);
                }
                MsgRemindActivity.this.iVQ.cmv();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eP(z2);
                }
                MsgRemindActivity.this.iVQ.cmw();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eF(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.iVQ.cmy();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eE(z2);
                }
                MsgRemindActivity.this.iVQ.cmx();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eN(z2);
                }
                MsgRemindActivity.this.iVQ.cmt();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eG(z2);
                }
                MsgRemindActivity.this.iVQ.cmu();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iVQ = new g(this);
        this.iVQ.b(this);
        this.iVF = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iVQ.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iVQ.cma()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aoy().setSignAlertOn(true);
                TiebaStatic.log(new an("c12939").P("obj_type", 2));
                TiebaStatic.log(new an("c13254").P("obj_type", 1));
                this.iVQ.clY();
                this.iVQ.qK(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aoy().setSignAlertOn(false);
            TiebaStatic.log(new an("c12939").P("obj_type", 1));
            TiebaStatic.log(new an("c13254").P("obj_type", 0));
            this.iVQ.qK(false);
        } else if (view == this.iVQ.cmb()) {
            this.iVF.a(14, switchState == BdSwitchView.SwitchState.ON, this.iTB);
        } else if (view == this.iVQ.cmd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eI(true);
                this.iVQ.qJ(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eI(false);
            this.iVQ.qJ(false);
        } else if (view == this.iVQ.cmh()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eL(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eL(false);
            }
        } else if (view == this.iVQ.cmi()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eJ(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eJ(false);
            }
        } else if (view == this.iVQ.cmj()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eK(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eK(false);
            }
        } else if (view == this.iVQ.cmk()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eM(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.aoy().eM(false);
            }
        } else if (view == this.iVQ.cml()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVF.a(1, true, this.iTB);
            } else {
                this.iVF.a(1, false, this.iTB);
            }
        } else if (view == this.iVQ.cmm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVF.a(20, true, this.iTB);
            } else {
                this.iVF.a(20, false, this.iTB);
            }
        } else if (view == this.iVQ.cmn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVF.a(2, true, this.iTB);
            } else {
                this.iVF.a(2, false, this.iTB);
            }
        } else if (view == this.iVQ.cmo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVF.a(5, true, this.iTB);
            } else {
                this.iVF.a(5, false, this.iTB);
            }
        } else if (view == this.iVQ.cmp()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVF.a(4, true, this.iTB);
            } else {
                this.iVF.a(4, false, this.iTB);
            }
        } else if (view == this.iVQ.cmq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iVF.a(3, true, this.iTB);
            } else {
                this.iVF.a(3, false, this.iTB);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.iVQ.clS().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iVQ.clS()) {
            if (this.iVQ.iWt) {
                finish();
            } else {
                this.iVQ.qM(true);
            }
        } else if (view == this.iVQ.cmc()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.aoT().a(getPageContext(), this.iVR);
        } else if (view == this.iVQ.cme()) {
            this.iVQ.qM(false);
        } else if (view == this.iVQ.cmf()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.iVQ.cmg()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.iVQ.cmr()) {
            TiebaStatic.log(new an("c13286").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.iVQ.cms()) {
            com.baidu.tbadk.core.c.a.acz().acB();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.iVQ.iWt) {
                    finish();
                    return true;
                }
                this.iVQ.qM(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoL().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoM().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog As(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aoy().px(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aoy().py(str);
                    }
                    MsgRemindActivity.this.iVQ.clZ();
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
            return As(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoz();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iVQ != null) {
            this.iVQ.onDestroy();
        }
    }
}
