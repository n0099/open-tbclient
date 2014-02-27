package com.baidu.tieba.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MsgRemindActivity extends com.baidu.tieba.f implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, com.baidu.adp.widget.BdSwitchView.c {
    private ak a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new ak(this);
        this.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
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
                TiebaApplication.g().h(true);
            } else {
                TiebaApplication.g().h(false);
            }
        } else if (view == this.a.g()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().q(true);
                this.a.d();
                this.a.e(true);
                this.a.c(true);
                return;
            }
            TiebaApplication.g().q(false);
            this.a.e(false);
            this.a.c(false);
        } else if (view == this.a.h()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().b(300);
                this.a.f(true);
                this.a.b(true);
                return;
            }
            TiebaApplication.g().b(0);
            this.a.f(false);
            this.a.b(false);
        } else if (view == this.a.j()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().j(true);
                this.a.d(true);
                this.a.a(true);
                return;
            }
            TiebaApplication.g().j(false);
            this.a.d(false);
            this.a.a(false);
        } else if (view == this.a.n()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().i(true);
            } else {
                TiebaApplication.g().i(false);
            }
        } else if (view == this.a.o()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().k(true);
            } else {
                TiebaApplication.g().k(false);
            }
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
            showDialog(R.id.sign_remind);
        } else if (view == this.a.k()) {
            this.a.g(false);
        } else if (view == this.a.l()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.a.m()) {
            showDialog(R.id.no_disturb_end_time);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (dialog instanceof TimePickerDialog) {
            TiebaApplication g = TiebaApplication.g();
            if (i == R.id.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(g.V(), g.W());
                return;
            } else if (i == R.id.no_disturb_start_time || i == R.id.no_disturb_end_time) {
                String[] split = i == R.id.no_disturb_start_time ? g.J().split(":") : g.K().split(":");
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
        com.baidu.tieba.view.h hVar = new com.baidu.tieba.view.h(this, new aj(this, i, TiebaApplication.g()), 0, 0, true);
        if (i == R.id.sign_remind) {
            hVar.setTitle(R.string.sign_remind);
        } else if (i == R.id.no_disturb_end_time) {
            hVar.setTitle(R.string.no_disturb_end_time);
        } else if (i == R.id.no_disturb_start_time) {
            hVar.setTitle(R.string.no_disturb_start_time);
        }
        hVar.setButton(-1, getString(R.string.alert_yes_button), hVar);
        hVar.setButton(-2, getString(R.string.alert_no_button), hVar);
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DatabaseService.r();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (id == R.id.check_replyme) {
            if (z) {
                TiebaApplication.g().n(true);
            } else {
                TiebaApplication.g().n(false);
            }
        } else if (id == R.id.check_atme) {
            if (z) {
                TiebaApplication.g().m(true);
            } else {
                TiebaApplication.g().m(false);
            }
        } else if (id == R.id.check_newfans) {
            if (z) {
                TiebaApplication.g().l(true);
            } else {
                TiebaApplication.g().l(false);
            }
        } else if (id == R.id.check_chatmessage) {
            if (z) {
                TiebaApplication.g().o(true);
            } else {
                TiebaApplication.g().o(false);
            }
        } else if (id == R.id.check_groupmessage) {
            if (z) {
                TiebaApplication.g().p(true);
                return;
            }
            TiebaApplication.g().p(false);
            cb.a(this, "group_message_remind", "check_click", 1, new Object[0]);
        }
    }
}
