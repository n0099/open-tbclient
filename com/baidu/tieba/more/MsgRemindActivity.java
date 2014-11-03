package com.baidu.tieba.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class MsgRemindActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, com.baidu.adp.widget.BdSwitchView.c {
    private al brE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.brE = new al(this);
        this.brE.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.brE.onChangeSkinType(i);
    }

    public static void ae(Context context) {
        context.startActivity(new Intent(context, MsgRemindActivity.class));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.brE.Vl()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkApplication.m251getInst().setPromotedMessage(true);
            } else {
                TbadkApplication.m251getInst().setPromotedMessage(false);
            }
        } else if (view == this.brE.Vm()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.aj.wm().ba(true);
                this.brE.Vj();
                this.brE.dO(true);
                this.brE.dM(true);
                return;
            }
            com.baidu.tieba.aj.wm().ba(false);
            this.brE.dO(false);
            this.brE.dM(false);
        } else if (view == this.brE.Vn()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.aj.wm().dA(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
                this.brE.dP(true);
                this.brE.dL(true);
                return;
            }
            com.baidu.tieba.aj.wm().dA(0);
            this.brE.dP(false);
            this.brE.dL(false);
        } else if (view == this.brE.Vp()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.aj.wm().aT(true);
                this.brE.dN(true);
                this.brE.dK(true);
                return;
            }
            com.baidu.tieba.aj.wm().aT(false);
            this.brE.dN(false);
            this.brE.dK(false);
        } else if (view == this.brE.Vt()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.aj.wm().aS(true);
            } else {
                com.baidu.tieba.aj.wm().aS(false);
            }
        } else if (view == this.brE.Vu()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.aj.wm().aU(true);
            } else {
                com.baidu.tieba.aj.wm().aU(false);
            }
        } else if (view == this.brE.Vv()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.aj.wm().aV(true);
            } else {
                com.baidu.tieba.aj.wm().aV(false);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.brE.xQ().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.brE.xQ()) {
            if (this.brE.bsx) {
                finish();
            } else {
                this.brE.dQ(true);
            }
        } else if (view == this.brE.Vo()) {
            showDialog(com.baidu.tieba.v.sign_remind);
        } else if (view == this.brE.Vq()) {
            this.brE.dQ(false);
        } else if (view == this.brE.Vr()) {
            showDialog(com.baidu.tieba.v.no_disturb_start_time);
        } else if (view == this.brE.Vs()) {
            showDialog(com.baidu.tieba.v.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.brE.bsx) {
                    finish();
                    return true;
                }
                this.brE.dQ(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (dialog instanceof TimePickerDialog) {
            TbadkApplication m251getInst = TbadkApplication.m251getInst();
            if (i == com.baidu.tieba.v.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(com.baidu.tieba.aj.wm().wC(), com.baidu.tieba.aj.wm().wE());
                return;
            } else if (i == com.baidu.tieba.v.no_disturb_start_time || i == com.baidu.tieba.v.no_disturb_end_time) {
                String[] split = i == com.baidu.tieba.v.no_disturb_start_time ? m251getInst.getNoDisturbStartTime().split(":") : m251getInst.getNoDisturbEndTime().split(":");
                ((TimePickerDialog) dialog).updateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                return;
            } else {
                return;
            }
        }
        super.onPrepareDialog(i, dialog);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        com.baidu.tieba.view.c cVar = new com.baidu.tieba.view.c(this, new ak(this, i, com.baidu.tieba.aj.wm()), 0, 0, true);
        if (i == com.baidu.tieba.v.sign_remind) {
            cVar.setTitle(com.baidu.tieba.y.sign_remind);
        } else if (i == com.baidu.tieba.v.no_disturb_end_time) {
            cVar.setTitle(com.baidu.tieba.y.no_disturb_end_time);
        } else if (i == com.baidu.tieba.v.no_disturb_start_time) {
            cVar.setTitle(com.baidu.tieba.y.no_disturb_start_time);
        }
        cVar.setButton(-1, getString(com.baidu.tieba.y.alert_yes_button), cVar);
        cVar.setButton(-2, getString(com.baidu.tieba.y.alert_no_button), cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tieba.util.j.aeJ();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (id == com.baidu.tieba.v.check_replyme) {
            if (z) {
                com.baidu.tieba.aj.wm().aX(true);
            } else {
                com.baidu.tieba.aj.wm().aX(false);
            }
        } else if (id == com.baidu.tieba.v.check_zan) {
            if (z) {
                com.baidu.tieba.aj.wm().setMsgZanOn(true);
            } else {
                com.baidu.tieba.aj.wm().setMsgZanOn(false);
            }
        } else if (id == com.baidu.tieba.v.check_atme) {
            if (z) {
                com.baidu.tieba.aj.wm().aW(true);
            } else {
                com.baidu.tieba.aj.wm().aW(false);
            }
        } else if (id == com.baidu.tieba.v.check_chatmessage) {
            if (z) {
                com.baidu.tieba.aj.wm().aZ(true);
            } else {
                com.baidu.tieba.aj.wm().aZ(false);
            }
        } else if (id == com.baidu.tieba.v.check_groupmessage) {
            if (z) {
                TbadkApplication.m251getInst().setGroupMsgOn(true);
                return;
            }
            TbadkApplication.m251getInst().setGroupMsgOn(false);
            TiebaStatic.eventStat(this, "group_message_remind", "check_click", 1, new Object[0]);
        } else if (id == com.baidu.tieba.v.check_new_fans) {
            com.baidu.tieba.aj.wm().aY(z);
        }
    }
}
