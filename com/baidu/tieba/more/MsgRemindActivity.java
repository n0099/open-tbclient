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
    private ab a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new ab(this);
        this.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, MsgRemindActivity.class));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.a.d()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbadkApplication.m252getInst().setPromotedMessage(true);
            } else {
                TbadkApplication.m252getInst().setPromotedMessage(false);
            }
        } else if (view == this.a.e()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.ai.c().n(true);
                this.a.b();
                this.a.e(true);
                this.a.c(true);
                return;
            }
            com.baidu.tieba.ai.c().n(false);
            this.a.e(false);
            this.a.c(false);
        } else if (view == this.a.f()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.ai.c().b(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
                this.a.f(true);
                this.a.b(true);
                return;
            }
            com.baidu.tieba.ai.c().b(0);
            this.a.f(false);
            this.a.b(false);
        } else if (view == this.a.h()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.ai.c().g(true);
                this.a.d(true);
                this.a.a(true);
                return;
            }
            com.baidu.tieba.ai.c().g(false);
            this.a.d(false);
            this.a.a(false);
        } else if (view == this.a.l()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.ai.c().f(true);
            } else {
                com.baidu.tieba.ai.c().f(false);
            }
        } else if (view == this.a.m()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.ai.c().h(true);
            } else {
                com.baidu.tieba.ai.c().h(false);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.a.a().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.a()) {
            if (this.a.a) {
                finish();
            } else {
                this.a.g(true);
            }
        } else if (view == this.a.g()) {
            showDialog(com.baidu.tieba.v.sign_remind);
        } else if (view == this.a.i()) {
            this.a.g(false);
        } else if (view == this.a.j()) {
            showDialog(com.baidu.tieba.v.no_disturb_start_time);
        } else if (view == this.a.k()) {
            showDialog(com.baidu.tieba.v.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.a.a) {
                    finish();
                    return true;
                }
                this.a.g(true);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (dialog instanceof TimePickerDialog) {
            TbadkApplication m252getInst = TbadkApplication.m252getInst();
            if (i == com.baidu.tieba.v.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(com.baidu.tieba.ai.c().t(), com.baidu.tieba.ai.c().u());
                return;
            } else if (i == com.baidu.tieba.v.no_disturb_start_time || i == com.baidu.tieba.v.no_disturb_end_time) {
                String[] split = i == com.baidu.tieba.v.no_disturb_start_time ? m252getInst.getNoDisturbStartTime().split(":") : m252getInst.getNoDisturbEndTime().split(":");
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
        com.baidu.tieba.view.d dVar = new com.baidu.tieba.view.d(this, new aa(this, i, com.baidu.tieba.ai.c()), 0, 0, true);
        if (i == com.baidu.tieba.v.sign_remind) {
            dVar.setTitle(com.baidu.tieba.y.sign_remind);
        } else if (i == com.baidu.tieba.v.no_disturb_end_time) {
            dVar.setTitle(com.baidu.tieba.y.no_disturb_end_time);
        } else if (i == com.baidu.tieba.v.no_disturb_start_time) {
            dVar.setTitle(com.baidu.tieba.y.no_disturb_start_time);
        }
        dVar.setButton(-1, getString(com.baidu.tieba.y.alert_yes_button), dVar);
        dVar.setButton(-2, getString(com.baidu.tieba.y.alert_no_button), dVar);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.util.k.m();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (id == com.baidu.tieba.v.check_replyme) {
            if (z) {
                com.baidu.tieba.ai.c().l(true);
            } else {
                com.baidu.tieba.ai.c().l(false);
            }
        } else if (id == com.baidu.tieba.v.check_zan) {
            if (z) {
                com.baidu.tieba.ai.c().k(true);
            } else {
                com.baidu.tieba.ai.c().k(false);
            }
        } else if (id == com.baidu.tieba.v.check_atme) {
            if (z) {
                com.baidu.tieba.ai.c().j(true);
            } else {
                com.baidu.tieba.ai.c().j(false);
            }
        } else if (id == com.baidu.tieba.v.check_newfans) {
            if (z) {
                com.baidu.tieba.ai.c().i(true);
            } else {
                com.baidu.tieba.ai.c().i(false);
            }
        } else if (id == com.baidu.tieba.v.check_chatmessage) {
            if (z) {
                com.baidu.tieba.ai.c().m(true);
            } else {
                com.baidu.tieba.ai.c().m(false);
            }
        } else if (id == com.baidu.tieba.v.check_groupmessage) {
            if (z) {
                TbadkApplication.m252getInst().setGroupMsgOn(true);
                return;
            }
            TbadkApplication.m252getInst().setGroupMsgOn(false);
            TiebaStatic.eventStat(this, "group_message_remind", "check_click", 1, new Object[0]);
        }
    }
}
