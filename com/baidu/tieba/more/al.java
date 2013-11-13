package com.baidu.tieba.more;

import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class al extends com.baidu.adp.a.e {
    private RelativeLayout A;
    private NavigationBar B;
    private TextView C;
    private ImageView D;
    private LinearLayout E;
    private LinearLayout F;
    private LinearLayout G;
    private TextView H;
    private TextView I;
    private LinearLayout J;
    private TextView K;
    private TextView L;
    private LinearLayout M;
    private TextView N;
    private BdSwitchView O;
    private LinearLayout P;
    private TextView Q;
    private BdSwitchView R;
    private Activity S;
    private am T;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1979a;
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
    private CheckBox q;
    private LinearLayout r;
    private TextView s;
    private BdSwitchView t;
    private LinearLayout u;
    private TextView v;
    private TextView w;
    private LinearLayout x;
    private TextView y;
    private BdSwitchView z;

    public al(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity);
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.f1979a = true;
        this.S = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void a(MsgRemindActivity msgRemindActivity) {
        b(msgRemindActivity);
        q();
        v();
        r();
        s();
        t();
        u();
        c(msgRemindActivity);
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            this.c.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(8);
            this.l.setVisibility(8);
            this.r.setVisibility(8);
            this.u.setVisibility(8);
            this.M.setVisibility(8);
            this.P.setVisibility(8);
        }
    }

    public void a(int i) {
        if (i == 1) {
            this.A.setBackgroundColor(this.S.getResources().getColor(R.color.bg_page_setting_1));
        } else {
            this.A.setBackgroundColor(this.S.getResources().getColor(R.color.bg_page_setting));
        }
        this.B.c(i);
        boolean z = i == 1;
        int a2 = z ? bd.a(i) : b().getResources().getColor(R.color.more_color);
        int i2 = z ? -11446171 : -5065030;
        int i3 = z ? R.drawable.more_all_1 : R.drawable.more_all;
        int i4 = z ? R.drawable.more_up_1 : R.drawable.more_up;
        int i5 = z ? R.drawable.more_down_1 : R.drawable.more_down;
        int i6 = z ? R.drawable.more_middle_1 : R.drawable.more_middle;
        BdSwitchView.SwitchStyle switchStyle = z ? BdSwitchView.SwitchStyle.NIGHT : BdSwitchView.SwitchStyle.DAY;
        if (this.f.getVisibility() != 0) {
            bd.e(this.c, i3);
        } else {
            bd.e(this.c, i4);
        }
        bd.e(this.f, i5);
        this.e.setSwitchStyle(switchStyle);
        bd.e(this.G, i4);
        bd.e(this.J, i5);
        if (this.l.getVisibility() != 0) {
            bd.e(this.i, i3);
        } else {
            bd.e(this.i, i4);
        }
        bd.e((View) this.m, i6);
        bd.e((View) this.n, i6);
        bd.e((View) this.o, i6);
        bd.e((View) this.p, i6);
        bd.e((View) this.q, i5);
        this.k.setSwitchStyle(switchStyle);
        if (this.u.getVisibility() != 0) {
            bd.e(this.r, i3);
        } else {
            bd.e(this.r, i4);
        }
        bd.e(this.u, i5);
        this.t.setSwitchStyle(switchStyle);
        int i7 = z ? R.drawable.icon_arrow_right_1 : R.drawable.icon_arrow_right;
        ((ImageView) this.f.findViewById(R.id.no_disturb_mode_time_arrow)).setImageResource(i7);
        ((ImageView) this.u.findViewById(R.id.sign_remind_arrow)).setImageResource(i7);
        ((ImageView) this.G.findViewById(R.id.no_disturb_start_time_arrow)).setImageResource(i7);
        ((ImageView) this.J.findViewById(R.id.no_disturb_end_time_arrow)).setImageResource(i7);
        bd.e(this.x, i3);
        this.z.setSwitchStyle(switchStyle);
        bd.e(this.M, i4);
        this.O.setSwitchStyle(switchStyle);
        bd.e(this.P, i5);
        this.R.setSwitchStyle(switchStyle);
        this.d.setTextColor(a2);
        this.g.setTextColor(a2);
        this.h.setTextColor(i2);
        this.H.setTextColor(a2);
        this.I.setTextColor(i2);
        this.K.setTextColor(a2);
        this.L.setTextColor(i2);
        this.j.setTextColor(a2);
        this.m.setTextColor(a2);
        this.n.setTextColor(a2);
        this.o.setTextColor(a2);
        this.p.setTextColor(a2);
        this.q.setTextColor(a2);
        this.s.setTextColor(a2);
        this.v.setTextColor(a2);
        this.w.setTextColor(i2);
        this.y.setTextColor(a2);
        this.N.setTextColor(a2);
        this.Q.setTextColor(a2);
    }

    void b(MsgRemindActivity msgRemindActivity) {
        this.A = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        this.B = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.C = this.B.a(msgRemindActivity.getString(R.string.msg_remind));
        this.D = this.B.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, msgRemindActivity);
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
        this.r = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind_on);
        this.r.setClickable(false);
        this.s = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_on_text);
        this.t = (BdSwitchView) msgRemindActivity.findViewById(R.id.sign_remind_on_switch);
        this.u = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.v = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_text);
        this.w = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.x = (LinearLayout) msgRemindActivity.findViewById(R.id.promoted_message);
        this.x.setClickable(false);
        this.y = (TextView) msgRemindActivity.findViewById(R.id.promoted_message_text);
        this.z = (BdSwitchView) msgRemindActivity.findViewById(R.id.promoted_message_switch);
        this.p = (CheckBox) msgRemindActivity.findViewById(R.id.check_chatmessage);
        this.q = (CheckBox) msgRemindActivity.findViewById(R.id.check_groupmessage);
        this.E = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.F = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.G = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.H = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_text);
        this.I = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.J = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.K = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_text);
        this.L = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.M = (LinearLayout) msgRemindActivity.findViewById(R.id.remind_tone);
        this.M.setClickable(false);
        this.N = (TextView) msgRemindActivity.findViewById(R.id.tone_text);
        this.O = (BdSwitchView) msgRemindActivity.findViewById(R.id.remind_tone_switch);
        this.P = (LinearLayout) msgRemindActivity.findViewById(R.id.remind_vibrate);
        this.P.setClickable(false);
        this.Q = (TextView) msgRemindActivity.findViewById(R.id.vibrate_text);
        this.R = (BdSwitchView) msgRemindActivity.findViewById(R.id.remind_vibrate_switch);
    }

    public ImageView a() {
        return this.D;
    }

    private void q() {
        if (TiebaApplication.g().S()) {
            this.e.a();
            this.f.setVisibility(0);
            f();
            return;
        }
        this.e.b();
        this.f.setVisibility(8);
    }

    private void r() {
        if (TiebaApplication.g().aa()) {
            this.m.setChecked(true);
        }
        if (TiebaApplication.g().Z()) {
            this.n.setChecked(true);
        }
        if (TiebaApplication.g().Y()) {
            this.o.setChecked(true);
        }
        if (TiebaApplication.g().ab()) {
            this.p.setChecked(true);
        }
        if (TiebaApplication.g().ac()) {
            this.q.setChecked(true);
        }
    }

    private void s() {
        if (TiebaApplication.g().R()) {
            this.z.a();
        } else {
            this.z.b();
        }
    }

    private void t() {
        if (TiebaApplication.g().ae()) {
            this.t.a();
            this.u.setVisibility(0);
            e();
            return;
        }
        this.t.b();
        this.u.setVisibility(8);
    }

    private void u() {
        if (TiebaApplication.g().V()) {
            this.O.a();
        } else {
            this.O.b();
        }
        if (TiebaApplication.g().W()) {
            this.R.a();
        } else {
            this.R.b();
        }
    }

    private void v() {
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
        this.t.setOnSwitchStateChangeListener(msgRemindActivity);
        this.z.setOnSwitchStateChangeListener(msgRemindActivity);
        this.e.setOnSwitchStateChangeListener(msgRemindActivity);
        this.m.setOnCheckedChangeListener(msgRemindActivity);
        this.n.setOnCheckedChangeListener(msgRemindActivity);
        this.o.setOnCheckedChangeListener(msgRemindActivity);
        this.p.setOnCheckedChangeListener(msgRemindActivity);
        this.q.setOnCheckedChangeListener(msgRemindActivity);
        this.u.setOnClickListener(msgRemindActivity);
        this.f.setOnClickListener(msgRemindActivity);
        this.G.setOnClickListener(msgRemindActivity);
        this.J.setOnClickListener(msgRemindActivity);
        this.O.setOnSwitchStateChangeListener(msgRemindActivity);
        this.R.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void a(boolean z) {
        boolean z2 = TiebaApplication.g().ap() == 1;
        int i = z2 ? R.drawable.more_all_1 : R.drawable.more_all;
        int i2 = z2 ? R.drawable.more_up_1 : R.drawable.more_up;
        int i3 = z2 ? R.drawable.more_down_1 : R.drawable.more_down;
        if (z) {
            this.f.setVisibility(0);
            f();
            bd.e(this.c, i2);
            bd.e(this.f, i3);
            return;
        }
        this.f.setVisibility(8);
        bd.e(this.c, i);
    }

    public void b(boolean z) {
        boolean z2 = TiebaApplication.g().ap() == 1;
        int i = z2 ? R.drawable.more_all_1 : R.drawable.more_all;
        int i2 = z2 ? R.drawable.more_up_1 : R.drawable.more_up;
        int i3 = z2 ? R.drawable.more_down_1 : R.drawable.more_down;
        if (z) {
            this.u.setVisibility(0);
            bd.e(this.r, i2);
            bd.e(this.u, i3);
            return;
        }
        this.u.setVisibility(8);
        bd.e(this.r, i);
    }

    public void c(boolean z) {
        if (this.T == null) {
            this.T = new am(this.l, BdWebErrorView.ERROR_CODE_500);
        }
        boolean z2 = TiebaApplication.g().ap() == 1;
        int i = z2 ? R.drawable.more_all_1 : R.drawable.more_all;
        int i2 = z2 ? R.drawable.more_up_1 : R.drawable.more_up;
        int i3 = z2 ? R.drawable.more_down_1 : R.drawable.more_down;
        int i4 = z2 ? R.drawable.more_middle_1 : R.drawable.more_middle;
        if (z) {
            this.T.a();
            bd.e(this.i, i2);
            bd.e((View) this.m, i4);
            bd.e((View) this.n, i4);
            bd.e((View) this.o, i4);
            bd.e((View) this.p, i4);
            bd.e((View) this.q, i3);
            return;
        }
        this.T.b();
        bd.e(this.i, i);
    }

    public void e() {
        TiebaApplication g = TiebaApplication.g();
        if (g.ae()) {
            this.w.setText(b().getString(R.string.sign_remind_time, g.af() > 9 ? String.valueOf(g.af()) : SocialConstants.FALSE + g.af(), g.ag() > 9 ? String.valueOf(g.ag()) : SocialConstants.FALSE + g.ag()));
            this.u.setVisibility(0);
            if (!this.t.c()) {
                this.t.a();
                return;
            }
            return;
        }
        this.w.setText(R.string.close);
        this.u.setVisibility(8);
        if (this.t.c()) {
            this.t.b();
        }
    }

    public void f() {
        this.h.setText(TiebaApplication.g().T() + "-" + TiebaApplication.g().U());
        this.I.setText(TiebaApplication.g().T());
        this.L.setText(TiebaApplication.g().U());
    }

    public View g() {
        return this.z;
    }

    public View h() {
        return this.t;
    }

    public View i() {
        return this.k;
    }

    public View j() {
        return this.u;
    }

    public View k() {
        return this.e;
    }

    public View l() {
        return this.f;
    }

    public LinearLayout m() {
        return this.G;
    }

    public LinearLayout n() {
        return this.J;
    }

    public BdSwitchView o() {
        return this.O;
    }

    public BdSwitchView p() {
        return this.R;
    }

    public void d(boolean z) {
        if (this.f1979a != z) {
            this.f1979a = z;
            if (z) {
                this.C.setText(R.string.msg_remind);
                this.E.setVisibility(0);
                this.F.setVisibility(8);
                return;
            }
            this.C.setText(R.string.no_disturb_mode_time);
            this.F.setVisibility(0);
            this.E.setVisibility(8);
        }
    }
}
