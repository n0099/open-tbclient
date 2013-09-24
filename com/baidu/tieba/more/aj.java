package com.baidu.tieba.more;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.as;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.a.d {
    private NavigationBar A;
    private TextView B;
    private ImageView C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private TextView G;
    private TextView H;
    private LinearLayout I;
    private TextView J;
    private TextView K;
    private LinearLayout L;
    private TextView M;
    private BdSwitchView N;
    private LinearLayout O;
    private TextView P;
    private BdSwitchView Q;
    private ak R;
    public boolean b;
    private LinearLayout c;
    private TextView d;
    private BdSwitchView e;
    private LinearLayout f;
    private TextView g;
    private TextView h;
    private LinearLayout i;
    private TextView j;
    private BdSwitchView k;
    private LinearLayout l;
    private CheckBox m;
    private CheckBox n;
    private CheckBox o;
    private CheckBox p;
    private LinearLayout q;
    private TextView r;
    private BdSwitchView s;
    private LinearLayout t;
    private TextView u;
    private TextView v;
    private LinearLayout w;
    private TextView x;
    private BdSwitchView y;
    private RelativeLayout z;

    public aj(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity);
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.b = true;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void a(MsgRemindActivity msgRemindActivity) {
        b(msgRemindActivity);
        o();
        t();
        p();
        q();
        r();
        s();
        c(msgRemindActivity);
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            this.c.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(8);
            this.l.setVisibility(8);
            this.q.setVisibility(8);
            this.t.setVisibility(8);
            this.L.setVisibility(8);
            this.O.setVisibility(8);
        }
    }

    public void a(int i) {
        as.b(this.z, i);
        this.A.b(i);
        boolean z = i == 1;
        int a2 = z ? as.a(i) : a().getResources().getColor(R.color.more_color);
        int i2 = z ? -11446171 : -5065030;
        int i3 = z ? R.drawable.more_all_1 : R.drawable.more_all;
        int i4 = z ? R.drawable.more_up_1 : R.drawable.more_up;
        int i5 = z ? R.drawable.more_down_1 : R.drawable.more_down;
        int i6 = z ? R.drawable.more_middle_1 : R.drawable.more_middle;
        BdSwitchView.SwitchStyle switchStyle = z ? BdSwitchView.SwitchStyle.NIGHT : BdSwitchView.SwitchStyle.DAY;
        if (this.f.getVisibility() != 0) {
            as.e(this.c, i3);
        } else {
            as.e(this.c, i4);
        }
        as.e(this.f, i5);
        this.e.setSwitchStyle(switchStyle);
        as.e(this.F, i4);
        as.e(this.I, i5);
        if (this.l.getVisibility() != 0) {
            as.e(this.i, i3);
        } else {
            as.e(this.i, i4);
        }
        as.e((View) this.m, i6);
        as.e((View) this.n, i6);
        as.e((View) this.o, i6);
        as.e((View) this.p, i5);
        this.k.setSwitchStyle(switchStyle);
        if (this.t.getVisibility() != 0) {
            as.e(this.q, i3);
        } else {
            as.e(this.q, i4);
        }
        as.e(this.t, i5);
        this.s.setSwitchStyle(switchStyle);
        int i7 = z ? R.drawable.icon_arrow_right_1 : R.drawable.icon_arrow_right;
        ((ImageView) this.f.findViewById(R.id.no_disturb_mode_time_arrow)).setImageResource(i7);
        ((ImageView) this.t.findViewById(R.id.sign_remind_arrow)).setImageResource(i7);
        ((ImageView) this.F.findViewById(R.id.no_disturb_start_time_arrow)).setImageResource(i7);
        ((ImageView) this.I.findViewById(R.id.no_disturb_end_time_arrow)).setImageResource(i7);
        as.e(this.w, i3);
        this.y.setSwitchStyle(switchStyle);
        as.e(this.L, i4);
        this.N.setSwitchStyle(switchStyle);
        as.e(this.O, i5);
        this.Q.setSwitchStyle(switchStyle);
        this.d.setTextColor(a2);
        this.g.setTextColor(a2);
        this.h.setTextColor(i2);
        this.G.setTextColor(a2);
        this.H.setTextColor(i2);
        this.J.setTextColor(a2);
        this.K.setTextColor(i2);
        this.j.setTextColor(a2);
        this.m.setTextColor(a2);
        this.n.setTextColor(a2);
        this.o.setTextColor(a2);
        this.p.setTextColor(a2);
        this.r.setTextColor(a2);
        this.u.setTextColor(a2);
        this.v.setTextColor(i2);
        this.x.setTextColor(a2);
        this.M.setTextColor(a2);
        this.P.setTextColor(a2);
    }

    void b(MsgRemindActivity msgRemindActivity) {
        this.z = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        this.A = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.B = this.A.a(msgRemindActivity.getString(R.string.msg_remind));
        this.C = this.A.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, msgRemindActivity);
        this.c = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_container);
        this.c.setClickable(false);
        this.d = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_text);
        this.e = (BdSwitchView) msgRemindActivity.findViewById(R.id.no_disturb_mode_switch);
        this.f = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.g = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_text);
        this.h = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.i = (LinearLayout) msgRemindActivity.findViewById(R.id.message_remind_container);
        this.i.setClickable(false);
        this.j = (TextView) msgRemindActivity.findViewById(R.id.message_remind_text);
        this.k = (BdSwitchView) msgRemindActivity.findViewById(R.id.message_remind_switch);
        this.l = (LinearLayout) msgRemindActivity.findViewById(R.id.message_remind_value);
        this.m = (CheckBox) msgRemindActivity.findViewById(R.id.check_replyme);
        this.n = (CheckBox) msgRemindActivity.findViewById(R.id.check_atme);
        this.o = (CheckBox) msgRemindActivity.findViewById(R.id.check_newfans);
        this.q = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind_on);
        this.q.setClickable(false);
        this.r = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_on_text);
        this.s = (BdSwitchView) msgRemindActivity.findViewById(R.id.sign_remind_on_switch);
        this.t = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.u = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_text);
        this.v = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.w = (LinearLayout) msgRemindActivity.findViewById(R.id.promoted_message);
        this.w.setClickable(false);
        this.x = (TextView) msgRemindActivity.findViewById(R.id.promoted_message_text);
        this.y = (BdSwitchView) msgRemindActivity.findViewById(R.id.promoted_message_switch);
        this.p = (CheckBox) msgRemindActivity.findViewById(R.id.check_chatmessage);
        this.D = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.E = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.F = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.G = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_text);
        this.H = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.I = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.J = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_text);
        this.K = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.L = (LinearLayout) msgRemindActivity.findViewById(R.id.remind_tone);
        this.L.setClickable(false);
        this.M = (TextView) msgRemindActivity.findViewById(R.id.tone_text);
        this.N = (BdSwitchView) msgRemindActivity.findViewById(R.id.remind_tone_switch);
        this.O = (LinearLayout) msgRemindActivity.findViewById(R.id.remind_vibrate);
        this.O.setClickable(false);
        this.P = (TextView) msgRemindActivity.findViewById(R.id.vibrate_text);
        this.Q = (BdSwitchView) msgRemindActivity.findViewById(R.id.remind_vibrate_switch);
    }

    public ImageView b() {
        return this.C;
    }

    private void o() {
        if (TiebaApplication.g().T()) {
            this.e.a();
            this.f.setVisibility(0);
            d();
            return;
        }
        this.e.b();
        this.f.setVisibility(8);
    }

    private void p() {
        if (TiebaApplication.g().ab()) {
            this.m.setChecked(true);
        }
        if (TiebaApplication.g().aa()) {
            this.n.setChecked(true);
        }
        if (TiebaApplication.g().Z()) {
            this.o.setChecked(true);
        }
        if (TiebaApplication.g().ac()) {
            this.p.setChecked(true);
        }
    }

    private void q() {
        if (TiebaApplication.g().S()) {
            this.y.a();
        } else {
            this.y.b();
        }
    }

    private void r() {
        if (TiebaApplication.g().ae()) {
            this.s.a();
            this.t.setVisibility(0);
            c();
            return;
        }
        this.s.b();
        this.t.setVisibility(8);
    }

    private void s() {
        if (TiebaApplication.g().W()) {
            this.N.a();
        } else {
            this.N.b();
        }
        if (TiebaApplication.g().X()) {
            this.Q.a();
        } else {
            this.Q.b();
        }
    }

    private void t() {
        if (TiebaApplication.g().ad()) {
            this.k.a();
            this.l.setVisibility(0);
            return;
        }
        this.k.b();
        this.l.setVisibility(8);
    }

    private void c(MsgRemindActivity msgRemindActivity) {
        this.k.setOnSwitchStateChangeListener(msgRemindActivity);
        this.s.setOnSwitchStateChangeListener(msgRemindActivity);
        this.y.setOnSwitchStateChangeListener(msgRemindActivity);
        this.e.setOnSwitchStateChangeListener(msgRemindActivity);
        this.m.setOnCheckedChangeListener(msgRemindActivity);
        this.n.setOnCheckedChangeListener(msgRemindActivity);
        this.o.setOnCheckedChangeListener(msgRemindActivity);
        this.p.setOnCheckedChangeListener(msgRemindActivity);
        this.t.setOnClickListener(msgRemindActivity);
        this.f.setOnClickListener(msgRemindActivity);
        this.F.setOnClickListener(msgRemindActivity);
        this.I.setOnClickListener(msgRemindActivity);
        this.N.setOnSwitchStateChangeListener(msgRemindActivity);
        this.Q.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void a(boolean z) {
        boolean z2 = TiebaApplication.g().ap() == 1;
        int i = z2 ? R.drawable.more_all_1 : R.drawable.more_all;
        int i2 = z2 ? R.drawable.more_up_1 : R.drawable.more_up;
        int i3 = z2 ? R.drawable.more_down_1 : R.drawable.more_down;
        if (z) {
            this.f.setVisibility(0);
            d();
            as.e(this.c, i2);
            as.e(this.f, i3);
            return;
        }
        this.f.setVisibility(8);
        as.e(this.c, i);
    }

    public void b(boolean z) {
        boolean z2 = TiebaApplication.g().ap() == 1;
        int i = z2 ? R.drawable.more_all_1 : R.drawable.more_all;
        int i2 = z2 ? R.drawable.more_up_1 : R.drawable.more_up;
        int i3 = z2 ? R.drawable.more_down_1 : R.drawable.more_down;
        if (z) {
            this.t.setVisibility(0);
            as.e(this.q, i2);
            as.e(this.t, i3);
            return;
        }
        this.t.setVisibility(8);
        as.e(this.q, i);
    }

    public void c(boolean z) {
        if (this.R == null) {
            this.R = new ak(this.l, BdWebErrorView.ERROR_CODE_500);
        }
        boolean z2 = TiebaApplication.g().ap() == 1;
        int i = z2 ? R.drawable.more_all_1 : R.drawable.more_all;
        int i2 = z2 ? R.drawable.more_up_1 : R.drawable.more_up;
        int i3 = z2 ? R.drawable.more_down_1 : R.drawable.more_down;
        int i4 = z2 ? R.drawable.more_middle_1 : R.drawable.more_middle;
        if (z) {
            this.R.a();
            as.e(this.i, i2);
            as.e((View) this.m, i4);
            as.e((View) this.n, i4);
            as.e((View) this.o, i4);
            as.e((View) this.p, i3);
            return;
        }
        this.R.b();
        as.e(this.i, i);
    }

    public void c() {
        String str;
        String str2;
        TiebaApplication g = TiebaApplication.g();
        if (g.ae()) {
            if (g.af() > 9) {
                str = String.valueOf(g.af());
            } else {
                str = "0" + g.af();
            }
            if (g.ag() > 9) {
                str2 = String.valueOf(g.ag());
            } else {
                str2 = "0" + g.ag();
            }
            this.v.setText(a().getString(R.string.sign_remind_time, str, str2));
            this.t.setVisibility(0);
            if (!this.s.c()) {
                this.s.a();
                return;
            }
            return;
        }
        this.v.setText(R.string.close);
        this.t.setVisibility(8);
        if (this.s.c()) {
            this.s.b();
        }
    }

    public void d() {
        this.h.setText(String.valueOf(TiebaApplication.g().U()) + "-" + TiebaApplication.g().V());
        this.H.setText(TiebaApplication.g().U());
        this.K.setText(TiebaApplication.g().V());
    }

    public View e() {
        return this.y;
    }

    public View f() {
        return this.s;
    }

    public View g() {
        return this.k;
    }

    public View h() {
        return this.t;
    }

    public View i() {
        return this.e;
    }

    public View j() {
        return this.f;
    }

    public LinearLayout k() {
        return this.F;
    }

    public LinearLayout l() {
        return this.I;
    }

    public BdSwitchView m() {
        return this.N;
    }

    public BdSwitchView n() {
        return this.Q;
    }

    public void d(boolean z) {
        if (this.b != z) {
            this.b = z;
            if (z) {
                this.B.setText(R.string.msg_remind);
                this.D.setVisibility(0);
                this.E.setVisibility(8);
                return;
            }
            this.B.setText(R.string.no_disturb_mode_time);
            this.E.setVisibility(0);
            this.D.setVisibility(8);
        }
    }
}
