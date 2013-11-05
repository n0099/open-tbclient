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

    /* renamed from: a  reason: collision with root package name */
    private al f1970a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1970a = new al(this);
        this.f1970a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.f1970a.a(i);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, MsgRemindActivity.class));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.f1970a.g()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().i(true);
            } else {
                TiebaApplication.g().i(false);
            }
        } else if (view == this.f1970a.h()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().r(true);
                this.f1970a.e();
                this.f1970a.b(true);
                return;
            }
            TiebaApplication.g().r(false);
            this.f1970a.b(false);
        } else if (view == this.f1970a.i()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().d(300);
                this.f1970a.c(true);
                return;
            }
            TiebaApplication.g().d(0);
            this.f1970a.c(false);
        } else if (view == this.f1970a.k()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().k(true);
                this.f1970a.a(true);
                return;
            }
            TiebaApplication.g().k(false);
            this.f1970a.a(false);
        } else if (view == this.f1970a.o()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().j(true);
            } else {
                TiebaApplication.g().j(false);
            }
        } else if (view == this.f1970a.p()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().l(true);
            } else {
                TiebaApplication.g().l(false);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f1970a.a().performClick();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f1970a.a()) {
            if (this.f1970a.f1987a) {
                finish();
            } else {
                this.f1970a.d(true);
            }
        } else if (view == this.f1970a.j()) {
            showDialog(R.id.sign_remind);
        } else if (view == this.f1970a.l()) {
            this.f1970a.d(false);
        } else if (view == this.f1970a.m()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.f1970a.n()) {
            showDialog(R.id.no_disturb_end_time);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (dialog instanceof TimePickerDialog) {
            TiebaApplication g = TiebaApplication.g();
            if (i == R.id.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(g.ah(), g.ai());
                return;
            } else if (i == R.id.no_disturb_start_time || i == R.id.no_disturb_end_time) {
                String[] split = i == R.id.no_disturb_start_time ? g.V().split(":") : g.W().split(":");
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
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new ak(this, i, TiebaApplication.g()), 0, 0, true);
        if (i == R.id.sign_remind) {
            timePickerDialog.setTitle(R.string.sign_remind);
        } else if (i == R.id.no_disturb_end_time) {
            timePickerDialog.setTitle(R.string.no_disturb_end_time);
        } else if (i == R.id.no_disturb_start_time) {
            timePickerDialog.setTitle(R.string.no_disturb_start_time);
        }
        return timePickerDialog;
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
            case R.id.check_replyme /* 2131100682 */:
                if (z) {
                    TiebaApplication.g().o(true);
                    return;
                } else {
                    TiebaApplication.g().o(false);
                    return;
                }
            case R.id.check_atme /* 2131100683 */:
                if (z) {
                    TiebaApplication.g().n(true);
                    return;
                } else {
                    TiebaApplication.g().n(false);
                    return;
                }
            case R.id.check_newfans /* 2131100684 */:
                if (z) {
                    TiebaApplication.g().m(true);
                    return;
                } else {
                    TiebaApplication.g().m(false);
                    return;
                }
            case R.id.check_chatmessage /* 2131100685 */:
                if (z) {
                    TiebaApplication.g().p(true);
                    return;
                } else {
                    TiebaApplication.g().p(false);
                    return;
                }
            case R.id.check_groupmessage /* 2131100686 */:
                if (z) {
                    TiebaApplication.g().q(true);
                    return;
                }
                TiebaApplication.g().q(false);
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, "group_message_remind", "check_click", 1);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
