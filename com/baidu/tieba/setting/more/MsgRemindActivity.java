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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.MsgReceiveActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import java.util.Date;
/* loaded from: classes3.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements View.OnClickListener, BdSwitchView.a {
    private MsgRemindModel iLK;
    private g iLV;
    private final com.baidu.tbadk.widget.timepicker.a.d.e iLW = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.1
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (MsgRemindActivity.this.iLV != null) {
                com.baidu.tbadk.coreExtra.messageCenter.d.anf().setSignAlertTime(date.getHours(), date.getMinutes());
                MsgRemindActivity.this.iLV.cic();
                MsgRemindActivity.this.iLV.ciC();
            }
        }
    };
    private MsgRemindModel.a iJG = new MsgRemindModel.a() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3
        @Override // com.baidu.tieba.setting.model.MsgRemindModel.a
        public void e(int i, boolean z, final boolean z2) {
            if (i == 14) {
                final BdSwitchView cif = MsgRemindActivity.this.iLV.cif();
                if (z) {
                    if (z2) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.anf().jr(300);
                        MsgRemindActivity.this.iLV.qr(true);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.anf().jr(0);
                        MsgRemindActivity.this.iLV.qr(false);
                    }
                    if (cif != null) {
                        com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z2) {
                                    cif.mT();
                                } else {
                                    cif.mU();
                                }
                            }
                        }, 500L);
                    }
                } else if (cif != null) {
                    com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2) {
                                cif.mU();
                            } else {
                                cif.mT();
                            }
                        }
                    }, 500L);
                }
            } else if (i == 2) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.anf().eH(z2);
                }
                MsgRemindActivity.this.iLV.ciy();
            } else if (i == 3) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.anf().eI(z2);
                }
                MsgRemindActivity.this.iLV.ciz();
            } else if (i == 4) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.anf().ey(z2);
                    if (!z2) {
                        TiebaStatic.eventStat(MsgRemindActivity.this.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                    }
                }
                MsgRemindActivity.this.iLV.ciB();
            } else if (i == 5) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.anf().ex(z2);
                }
                MsgRemindActivity.this.iLV.ciA();
            } else if (i == 1) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.anf().eG(z2);
                }
                MsgRemindActivity.this.iLV.ciw();
            } else if (i == 20) {
                if (z) {
                    com.baidu.tbadk.coreExtra.messageCenter.d.anf().ez(z2);
                }
                MsgRemindActivity.this.iLV.cix();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iLV = new g(this);
        this.iLV.b(this);
        this.iLK = new MsgRemindModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iLV.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.iLV.cie()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.anf().setSignAlertOn(true);
                TiebaStatic.log(new am("c12939").P("obj_type", 2));
                TiebaStatic.log(new am("c13254").P("obj_type", 1));
                this.iLV.cic();
                this.iLV.qq(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.anf().setSignAlertOn(false);
            TiebaStatic.log(new am("c12939").P("obj_type", 1));
            TiebaStatic.log(new am("c13254").P("obj_type", 0));
            this.iLV.qq(false);
        } else if (view == this.iLV.cif()) {
            this.iLK.a(14, switchState == BdSwitchView.SwitchState.ON, this.iJG);
        } else if (view == this.iLV.cih()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.anf().eB(true);
                this.iLV.qp(true);
                return;
            }
            com.baidu.tbadk.coreExtra.messageCenter.d.anf().eB(false);
            this.iLV.qp(false);
        } else if (view == this.iLV.cil()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.anf().eE(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.anf().eE(false);
            }
        } else if (view == this.iLV.cim()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.anf().eC(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.anf().eC(false);
            }
        } else if (view == this.iLV.cin()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.anf().eD(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.anf().eD(false);
            }
        } else if (view == this.iLV.cio()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tbadk.coreExtra.messageCenter.d.anf().eF(true);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.d.anf().eF(false);
            }
        } else if (view == this.iLV.cip()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iLK.a(1, true, this.iJG);
            } else {
                this.iLK.a(1, false, this.iJG);
            }
        } else if (view == this.iLV.ciq()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iLK.a(20, true, this.iJG);
            } else {
                this.iLK.a(20, false, this.iJG);
            }
        } else if (view == this.iLV.cir()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iLK.a(2, true, this.iJG);
            } else {
                this.iLK.a(2, false, this.iJG);
            }
        } else if (view == this.iLV.cis()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iLK.a(5, true, this.iJG);
            } else {
                this.iLK.a(5, false, this.iJG);
            }
        } else if (view == this.iLV.cit()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iLK.a(4, true, this.iJG);
            } else {
                this.iLK.a(4, false, this.iJG);
            }
        } else if (view == this.iLV.ciu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.iLK.a(3, true, this.iJG);
            } else {
                this.iLK.a(3, false, this.iJG);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.iLV.chW().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iLV.chW()) {
            if (this.iLV.iMy) {
                finish();
            } else {
                this.iLV.qs(true);
            }
        } else if (view == this.iLV.cig()) {
            com.baidu.tbadk.coreExtra.messageCenter.f.anA().a(getPageContext(), this.iLW);
        } else if (view == this.iLV.cii()) {
            this.iLV.qs(false);
        } else if (view == this.iLV.cij()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.iLV.cik()) {
            showDialog(R.id.no_disturb_end_time);
        } else if (view == this.iLV.civ()) {
            TiebaStatic.log(new am("c13286").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            sendMessage(new CustomMessage(2002001, new MsgReceiveActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.iLV.iMy) {
                    finish();
                    return true;
                }
                this.iLV.qs(true);
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
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.anf().ans().split(":");
                } else {
                    split = com.baidu.tbadk.coreExtra.messageCenter.d.anf().ant().split(":");
                }
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            }
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected Dialog zH(final int i) {
        com.baidu.tieba.view.b bVar = new com.baidu.tieba.view.b(getActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.setting.more.MsgRemindActivity.2
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                if (timePicker != null) {
                    timePicker.clearFocus();
                    String str = ((timePicker.getCurrentHour().intValue() < 10 ? "0" : "") + timePicker.getCurrentHour()) + ":" + ((timePicker.getCurrentMinute().intValue() < 10 ? "0" : "") + timePicker.getCurrentMinute());
                    if (i == R.id.no_disturb_start_time) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.anf().oW(str);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.anf().oX(str);
                    }
                    MsgRemindActivity.this.iLV.cid();
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
            return zH(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.coreExtra.messageCenter.d.anf().ang();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iLV != null) {
            this.iLV.onDestroy();
        }
    }
}
