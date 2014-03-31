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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class MsgRemindActivity extends com.baidu.tbadk.a implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, com.baidu.adp.widget.BdSwitchView.c {
    private ab a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new ab(this);
        this.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, MsgRemindActivity.class));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.a.f()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.r.c().f(true);
            } else {
                com.baidu.tieba.r.c().f(false);
            }
        } else if (view == this.a.g()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.r.c().o(true);
                this.a.d();
                this.a.e(true);
                this.a.c(true);
                return;
            }
            com.baidu.tieba.r.c().o(false);
            this.a.e(false);
            this.a.c(false);
        } else if (view == this.a.h()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.r.c().b(300);
                this.a.f(true);
                this.a.b(true);
                return;
            }
            com.baidu.tieba.r.c().b(0);
            this.a.f(false);
            this.a.b(false);
        } else if (view == this.a.j()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.r.c();
                com.baidu.tieba.r.h(true);
                this.a.d(true);
                this.a.a(true);
                return;
            }
            com.baidu.tieba.r.c();
            com.baidu.tieba.r.h(false);
            this.a.d(false);
            this.a.a(false);
        } else if (view == this.a.n()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.r.c();
                com.baidu.tieba.r.g(true);
                return;
            }
            com.baidu.tieba.r.c();
            com.baidu.tieba.r.g(false);
        } else if (view == this.a.o()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                com.baidu.tieba.r.c();
                com.baidu.tieba.r.i(true);
                return;
            }
            com.baidu.tieba.r.c();
            com.baidu.tieba.r.i(false);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.a.a().performClick();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.a()) {
            if (this.a.a) {
                finish();
            } else {
                this.a.g(true);
            }
        } else if (view == this.a.i()) {
            showDialog(com.baidu.tieba.a.h.sign_remind);
        } else if (view == this.a.k()) {
            this.a.g(false);
        } else if (view == this.a.l()) {
            showDialog(com.baidu.tieba.a.h.no_disturb_start_time);
        } else if (view == this.a.m()) {
            showDialog(com.baidu.tieba.a.h.no_disturb_end_time);
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
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
            TbadkApplication j = TbadkApplication.j();
            if (i == com.baidu.tieba.a.h.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(com.baidu.tieba.r.c().r(), com.baidu.tieba.r.c().s());
                return;
            } else if (i == com.baidu.tieba.a.h.no_disturb_start_time || i == com.baidu.tieba.a.h.no_disturb_end_time) {
                String[] split = i == com.baidu.tieba.a.h.no_disturb_start_time ? j.ar().split(":") : j.as().split(":");
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
        com.baidu.tieba.view.d dVar = new com.baidu.tieba.view.d(this, new aa(this, i, com.baidu.tieba.r.c()), 0, 0, true);
        if (i == com.baidu.tieba.a.h.sign_remind) {
            dVar.setTitle(com.baidu.tieba.a.k.sign_remind);
        } else if (i == com.baidu.tieba.a.h.no_disturb_end_time) {
            dVar.setTitle(com.baidu.tieba.a.k.no_disturb_end_time);
        } else if (i == com.baidu.tieba.a.h.no_disturb_start_time) {
            dVar.setTitle(com.baidu.tieba.a.k.no_disturb_start_time);
        }
        dVar.setButton(-1, getString(com.baidu.tieba.a.k.alert_yes_button), dVar);
        dVar.setButton(-2, getString(com.baidu.tieba.a.k.alert_no_button), dVar);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.util.k.m();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (id == com.baidu.tieba.a.h.check_replyme) {
            if (z) {
                com.baidu.tieba.r.c();
                com.baidu.tieba.r.m(true);
                return;
            }
            com.baidu.tieba.r.c();
            com.baidu.tieba.r.m(false);
        } else if (id == com.baidu.tieba.a.h.check_zan) {
            if (z) {
                com.baidu.tieba.r.c();
                com.baidu.tieba.r.l(true);
                return;
            }
            com.baidu.tieba.r.c();
            com.baidu.tieba.r.l(false);
        } else if (id == com.baidu.tieba.a.h.check_atme) {
            if (z) {
                com.baidu.tieba.r.c();
                com.baidu.tieba.r.k(true);
                return;
            }
            com.baidu.tieba.r.c();
            com.baidu.tieba.r.k(false);
        } else if (id == com.baidu.tieba.a.h.check_newfans) {
            if (z) {
                com.baidu.tieba.r.c();
                com.baidu.tieba.r.j(true);
                return;
            }
            com.baidu.tieba.r.c();
            com.baidu.tieba.r.j(false);
        } else if (id == com.baidu.tieba.a.h.check_chatmessage) {
            if (z) {
                com.baidu.tieba.r.c();
                com.baidu.tieba.r.n(true);
                return;
            }
            com.baidu.tieba.r.c();
            com.baidu.tieba.r.n(false);
        } else if (id == com.baidu.tieba.a.h.check_groupmessage) {
            if (z) {
                TbadkApplication.j();
                TbadkApplication.g(true);
                return;
            }
            TbadkApplication.j();
            TbadkApplication.g(false);
            TiebaStatic.a(this, "group_message_remind", "check_click", 1, new Object[0]);
        }
    }
}
