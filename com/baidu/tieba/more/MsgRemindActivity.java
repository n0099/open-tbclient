package com.baidu.tieba.more;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MsgRemindActivity extends com.baidu.tieba.j implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, com.baidu.adp.widget.BdSwitchView.c {
    private al a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new al(this);
        this.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, MsgRemindActivity.class));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.a.g()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.h().i(true);
            } else {
                TiebaApplication.h().i(false);
            }
        } else if (view == this.a.h()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.h().r(true);
                this.a.e();
                this.a.b(true);
                return;
            }
            TiebaApplication.h().r(false);
            this.a.b(false);
        } else if (view == this.a.i()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.h().b(300);
                this.a.c(true);
                return;
            }
            TiebaApplication.h().b(0);
            this.a.c(false);
        } else if (view == this.a.k()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.h().k(true);
                this.a.a(true);
                return;
            }
            TiebaApplication.h().k(false);
            this.a.a(false);
        } else if (view == this.a.o()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.h().j(true);
            } else {
                TiebaApplication.h().j(false);
            }
        } else if (view == this.a.p()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.h().l(true);
            } else {
                TiebaApplication.h().l(false);
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
                this.a.d(true);
            }
        } else if (view == this.a.j()) {
            showDialog(R.id.sign_remind);
        } else if (view == this.a.l()) {
            this.a.d(false);
        } else if (view == this.a.m()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.a.n()) {
            showDialog(R.id.no_disturb_end_time);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (dialog instanceof TimePickerDialog) {
            TiebaApplication h = TiebaApplication.h();
            if (i == R.id.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(h.ad(), h.ae());
                return;
            } else if (i == R.id.no_disturb_start_time || i == R.id.no_disturb_end_time) {
                String[] split = i == R.id.no_disturb_start_time ? h.R().split(":") : h.S().split(":");
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
        com.baidu.tieba.view.f fVar = new com.baidu.tieba.view.f(this, new ak(this, i, TiebaApplication.h()), 0, 0, true);
        if (i == R.id.sign_remind) {
            fVar.setTitle(R.string.sign_remind);
        } else if (i == R.id.no_disturb_end_time) {
            fVar.setTitle(R.string.no_disturb_end_time);
        } else if (i == R.id.no_disturb_start_time) {
            fVar.setTitle(R.string.no_disturb_start_time);
        }
        fVar.setButton(-1, getString(R.string.alert_yes_button), fVar);
        fVar.setButton(-2, getString(R.string.alert_no_button), fVar);
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DatabaseService.u();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.check_replyme /* 2131100678 */:
                if (z) {
                    TiebaApplication.h().o(true);
                    return;
                } else {
                    TiebaApplication.h().o(false);
                    return;
                }
            case R.id.check_atme /* 2131100679 */:
                if (z) {
                    TiebaApplication.h().n(true);
                    return;
                } else {
                    TiebaApplication.h().n(false);
                    return;
                }
            case R.id.check_newfans /* 2131100680 */:
                if (z) {
                    TiebaApplication.h().m(true);
                    return;
                } else {
                    TiebaApplication.h().m(false);
                    return;
                }
            case R.id.check_chatmessage /* 2131100681 */:
                if (z) {
                    TiebaApplication.h().p(true);
                    return;
                } else {
                    TiebaApplication.h().p(false);
                    return;
                }
            case R.id.check_groupmessage /* 2131100682 */:
                if (z) {
                    TiebaApplication.h().q(true);
                    return;
                }
                TiebaApplication.h().q(false);
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this, "group_message_remind", "check_click", 1);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
