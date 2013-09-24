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
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MsgRemindActivity extends com.baidu.tieba.j implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    private aj f1468a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1468a = new aj(this);
        this.f1468a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.f1468a.a(i);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, MsgRemindActivity.class));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.f1468a.e()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().i(true);
            } else {
                TiebaApplication.g().i(false);
            }
        } else if (view == this.f1468a.f()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().q(true);
                this.f1468a.c();
                this.f1468a.b(true);
                return;
            }
            TiebaApplication.g().q(false);
            this.f1468a.b(false);
        } else if (view == this.f1468a.g()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().d(300);
                this.f1468a.c(true);
                return;
            }
            TiebaApplication.g().d(0);
            this.f1468a.c(false);
        } else if (view == this.f1468a.i()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().k(true);
                this.f1468a.a(true);
                return;
            }
            TiebaApplication.g().k(false);
            this.f1468a.a(false);
        } else if (view == this.f1468a.m()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().j(true);
            } else {
                TiebaApplication.g().j(false);
            }
        } else if (view == this.f1468a.n()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().l(true);
            } else {
                TiebaApplication.g().l(false);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f1468a.b().performClick();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f1468a.b()) {
            if (this.f1468a.b) {
                finish();
            } else {
                this.f1468a.d(true);
            }
        } else if (view == this.f1468a.h()) {
            showDialog(R.id.sign_remind);
        } else if (view == this.f1468a.j()) {
            this.f1468a.d(false);
        } else if (view == this.f1468a.k()) {
            showDialog(R.id.no_disturb_start_time);
        } else if (view == this.f1468a.l()) {
            showDialog(R.id.no_disturb_end_time);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (dialog instanceof TimePickerDialog) {
            TiebaApplication g = TiebaApplication.g();
            if (i == R.id.sign_remind) {
                ((TimePickerDialog) dialog).updateTime(g.af(), g.ag());
                return;
            } else if (i == R.id.no_disturb_start_time || i == R.id.no_disturb_end_time) {
                String[] split = i == R.id.no_disturb_start_time ? g.U().split(":") : g.V().split(":");
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
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new ai(this, i, TiebaApplication.g()), 0, 0, true);
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
            case R.id.check_replyme /* 2131100467 */:
                if (z) {
                    TiebaApplication.g().o(true);
                    return;
                } else {
                    TiebaApplication.g().o(false);
                    return;
                }
            case R.id.check_atme /* 2131100468 */:
                if (z) {
                    TiebaApplication.g().n(true);
                    return;
                } else {
                    TiebaApplication.g().n(false);
                    return;
                }
            case R.id.check_newfans /* 2131100469 */:
                if (z) {
                    TiebaApplication.g().m(true);
                    return;
                } else {
                    TiebaApplication.g().m(false);
                    return;
                }
            case R.id.check_chatmessage /* 2131100470 */:
                if (z) {
                    TiebaApplication.g().p(true);
                    return;
                } else {
                    TiebaApplication.g().p(false);
                    return;
                }
            default:
                return;
        }
    }
}
