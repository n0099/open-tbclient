package com.baidu.tieba.more;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public final class ab extends com.baidu.adp.a.f {
    private BdSwitchView A;
    private RelativeLayout B;
    private NavigationBar C;
    private TextView D;
    private View E;
    private LinearLayout F;
    private LinearLayout G;
    private LinearLayout H;
    private TextView I;
    private TextView J;
    private LinearLayout K;
    private TextView L;
    private TextView M;
    private LinearLayout N;
    private TextView O;
    private BdSwitchView P;
    private LinearLayout Q;
    private TextView R;
    private BdSwitchView S;
    private com.baidu.tbadk.a T;
    private LinearLayout U;
    private LinearLayout V;
    private LinearLayout W;
    private LinearLayout X;
    private LinearLayout Y;
    private LinearLayout Z;
    public boolean a;
    private LinearLayout aa;
    private LinearLayout ab;
    private LinearLayout ac;
    private LinearLayout ad;
    private LinearLayout ae;
    private LinearLayout af;
    private LinearLayout ag;
    private LinearLayout ah;
    private LinearLayout ai;
    private LinearLayout aj;
    private ac ak;
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
    private CheckBox r;
    private LinearLayout s;
    private TextView t;
    private BdSwitchView u;
    private LinearLayout v;
    private TextView w;
    private TextView x;
    private LinearLayout y;
    private TextView z;

    public ab(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity);
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.a = true;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
        this.ab = null;
        this.ac = null;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.ah = null;
        this.ai = null;
        this.aj = null;
        this.T = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.a.i.msg_remind_activity);
    }

    public final void a(MsgRemindActivity msgRemindActivity) {
        this.B = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.parent);
        this.C = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.E = this.C.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.D = this.C.a(msgRemindActivity.getString(com.baidu.tieba.a.k.msg_remind));
        this.c = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.no_disturb_mode_container);
        this.c.setClickable(false);
        this.d = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.no_disturb_mode_text);
        this.e = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.no_disturb_mode_switch);
        this.f = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.no_disturb_mode_time_container);
        this.g = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.no_disturb_mode_time_text);
        this.h = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.no_disturb_mode_time_value);
        this.i = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.message_remind_container);
        this.i.setClickable(false);
        this.j = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.message_remind_text);
        this.k = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.message_remind_switch);
        this.l = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.message_remind_value);
        this.m = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.a.h.check_replyme);
        this.n = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.a.h.check_zan);
        this.o = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.a.h.check_atme);
        this.p = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.a.h.check_newfans);
        this.s = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.sign_remind_on);
        this.s.setClickable(false);
        this.t = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.sign_remind_on_text);
        this.u = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.sign_remind_on_switch);
        this.v = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.sign_remind);
        this.w = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.sign_remind_text);
        this.x = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.sign_remind_time);
        this.y = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.promoted_message);
        this.y.setClickable(false);
        this.z = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.promoted_message_text);
        this.A = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.promoted_message_switch);
        this.q = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.a.h.check_chatmessage);
        this.r = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.a.h.check_groupmessage);
        this.F = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.front_container);
        this.G = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.back_container);
        this.H = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.no_disturb_start_time);
        this.I = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.no_disturb_start_time_text);
        this.J = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.no_disturb_start_time_value);
        this.K = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.no_disturb_end_time);
        this.L = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.no_disturb_end_time_text);
        this.M = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.no_disturb_end_time_value);
        this.N = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.remind_tone);
        this.N.setClickable(false);
        this.O = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.tone_text);
        this.P = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.remind_tone_switch);
        this.Q = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.remind_vibrate);
        this.Q.setClickable(false);
        this.R = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.vibrate_text);
        this.S = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.a.h.remind_vibrate_switch);
        this.U = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line1_layout);
        this.V = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line2_layout);
        this.W = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line3_layout);
        this.X = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line4_layout);
        this.Y = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line5_layout);
        this.Z = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line6_layout);
        this.aa = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line7_layout);
        this.ab = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line8_layout);
        this.ac = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line9_layout);
        this.ad = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line10_layout);
        this.ae = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line11_layout);
        this.af = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line12_layout);
        this.ag = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line13_layout);
        this.ah = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line14_layout);
        this.ai = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line15_layout);
        this.aj = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.a.h.line16_layout);
        if (TbadkApplication.j().aq()) {
            this.e.a();
            this.f.setVisibility(0);
            e();
            this.V.setVisibility(0);
        } else {
            this.e.b();
            this.f.setVisibility(8);
            this.V.setVisibility(8);
        }
        com.baidu.tieba.r.c();
        if (com.baidu.tieba.r.p()) {
            this.k.a();
            this.l.setVisibility(0);
        } else {
            this.k.b();
            this.l.setVisibility(8);
        }
        com.baidu.tieba.r.c();
        if (com.baidu.tieba.r.p()) {
            this.ab.setPadding(this.T.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds30), 0, this.T.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds30), 0);
        } else {
            this.ab.setPadding(0, 0, 0, 0);
        }
        if (TbadkApplication.j().ai()) {
            this.m.setChecked(true);
        }
        if (TbadkApplication.j().aj()) {
            this.n.setChecked(true);
        }
        if (TbadkApplication.j().ah()) {
            this.o.setChecked(true);
        }
        if (TbadkApplication.j().ak()) {
            this.p.setChecked(true);
        }
        if (TbadkApplication.j().ae()) {
            this.q.setChecked(true);
        }
        TbadkApplication.j();
        if (TbadkApplication.ad()) {
            this.r.setChecked(true);
        }
        if (com.baidu.tieba.r.c().n()) {
            this.A.a();
        } else {
            this.A.b();
        }
        com.baidu.tieba.r.c();
        if (com.baidu.tieba.r.q()) {
            this.u.a();
            this.v.setVisibility(0);
            d();
            this.ai.setVisibility(0);
        } else {
            this.u.b();
            this.v.setVisibility(8);
            this.ai.setVisibility(8);
        }
        if (TbadkApplication.j().ap()) {
            this.P.a();
        } else {
            this.P.b();
        }
        if (TbadkApplication.j().ao()) {
            this.S.a();
        } else {
            this.S.b();
        }
        this.k.setOnSwitchStateChangeListener(msgRemindActivity);
        this.u.setOnSwitchStateChangeListener(msgRemindActivity);
        this.A.setOnSwitchStateChangeListener(msgRemindActivity);
        this.e.setOnSwitchStateChangeListener(msgRemindActivity);
        this.m.setOnCheckedChangeListener(msgRemindActivity);
        this.n.setOnCheckedChangeListener(msgRemindActivity);
        this.o.setOnCheckedChangeListener(msgRemindActivity);
        this.p.setOnCheckedChangeListener(msgRemindActivity);
        this.q.setOnCheckedChangeListener(msgRemindActivity);
        this.r.setOnCheckedChangeListener(msgRemindActivity);
        this.v.setOnClickListener(msgRemindActivity);
        this.f.setOnClickListener(msgRemindActivity);
        this.H.setOnClickListener(msgRemindActivity);
        this.K.setOnClickListener(msgRemindActivity);
        this.P.setOnSwitchStateChangeListener(msgRemindActivity);
        this.S.setOnSwitchStateChangeListener(msgRemindActivity);
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            this.c.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(8);
            this.l.setVisibility(8);
            this.s.setVisibility(8);
            this.v.setVisibility(8);
            this.N.setVisibility(8);
            this.Q.setVisibility(8);
            this.U.setVisibility(8);
            this.V.setVisibility(8);
            this.W.setVisibility(8);
            this.X.setVisibility(8);
            this.Y.setVisibility(8);
            this.Z.setVisibility(8);
            this.aa.setVisibility(8);
            this.ab.setVisibility(8);
            this.ac.setVisibility(8);
            this.ad.setVisibility(8);
            this.ae.setVisibility(8);
            this.af.setVisibility(8);
            this.ag.setVisibility(8);
            this.ah.setVisibility(8);
            this.ai.setVisibility(8);
            this.aj.setVisibility(8);
        }
    }

    public final void a(int i) {
        this.T.getLayoutMode().a(i == 1);
        this.T.getLayoutMode().a(this.B);
        if (i == 1) {
            this.B.setBackgroundColor(this.T.getResources().getColor(com.baidu.tieba.a.e.bg_page_setting_1));
        } else {
            this.B.setBackgroundColor(this.T.getResources().getColor(com.baidu.tieba.a.e.bg_page_setting));
        }
        this.C.b(i);
        boolean z = i == 1;
        int a = z ? ba.a(i) : b().getResources().getColor(com.baidu.tieba.a.e.more_color);
        int i2 = z ? -11446171 : -5065030;
        int i3 = z ? com.baidu.tieba.a.g.more_all_1 : com.baidu.tieba.a.g.more_all;
        BdSwitchView.SwitchStyle switchStyle = z ? BdSwitchView.SwitchStyle.NIGHT : BdSwitchView.SwitchStyle.DAY;
        ba.e(this.c, i3);
        ba.e(this.f, i3);
        this.e.setSwitchStyle(switchStyle);
        ba.e(this.H, i3);
        ba.e(this.K, i3);
        ba.e(this.i, i3);
        ba.e((View) this.m, i3);
        ba.e((View) this.n, i3);
        ba.e((View) this.o, i3);
        ba.e((View) this.p, i3);
        ba.e((View) this.q, i3);
        ba.e((View) this.r, i3);
        this.k.setSwitchStyle(switchStyle);
        ba.e(this.s, i3);
        ba.e(this.v, i3);
        this.u.setSwitchStyle(switchStyle);
        int i4 = z ? com.baidu.tieba.a.g.icon_arrow_right_1 : com.baidu.tieba.a.g.icon_arrow_right;
        ((ImageView) this.f.findViewById(com.baidu.tieba.a.h.no_disturb_mode_time_arrow)).setImageResource(i4);
        ((ImageView) this.v.findViewById(com.baidu.tieba.a.h.sign_remind_arrow)).setImageResource(i4);
        ((ImageView) this.H.findViewById(com.baidu.tieba.a.h.no_disturb_start_time_arrow)).setImageResource(i4);
        ((ImageView) this.K.findViewById(com.baidu.tieba.a.h.no_disturb_end_time_arrow)).setImageResource(i4);
        ba.e(this.y, i3);
        this.A.setSwitchStyle(switchStyle);
        ba.e(this.N, i3);
        this.P.setSwitchStyle(switchStyle);
        ba.e(this.Q, i3);
        this.S.setSwitchStyle(switchStyle);
        this.d.setTextColor(a);
        this.g.setTextColor(a);
        this.h.setTextColor(i2);
        this.I.setTextColor(a);
        this.J.setTextColor(i2);
        this.L.setTextColor(a);
        this.M.setTextColor(i2);
        this.j.setTextColor(a);
        this.m.setTextColor(a);
        this.n.setTextColor(a);
        this.o.setTextColor(a);
        this.p.setTextColor(a);
        this.q.setTextColor(a);
        this.r.setTextColor(a);
        this.t.setTextColor(a);
        this.w.setTextColor(a);
        this.x.setTextColor(i2);
        this.z.setTextColor(a);
        this.O.setTextColor(a);
        this.R.setTextColor(a);
    }

    public final View a() {
        return this.E;
    }

    public final void a(boolean z) {
        if (z) {
            this.V.setVisibility(0);
        } else {
            this.V.setVisibility(8);
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.ab.setPadding(this.T.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds30), 0, this.T.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds30), 0);
        } else {
            this.ab.setPadding(0, 0, 0, 0);
        }
    }

    public final void c(boolean z) {
        if (z) {
            this.ai.setVisibility(0);
        } else {
            this.ai.setVisibility(8);
        }
    }

    public final void d(boolean z) {
        int i = TbadkApplication.j().l() == 1 ? com.baidu.tieba.a.g.more_all_1 : com.baidu.tieba.a.g.more_all;
        if (z) {
            this.f.setVisibility(0);
            e();
            ba.e(this.c, i);
            ba.e(this.f, i);
            return;
        }
        this.f.setVisibility(8);
        ba.e(this.c, i);
    }

    public final void e(boolean z) {
        int i = TbadkApplication.j().l() == 1 ? com.baidu.tieba.a.g.more_all_1 : com.baidu.tieba.a.g.more_all;
        if (z) {
            this.v.setVisibility(0);
            ba.e(this.s, i);
            ba.e(this.v, i);
            return;
        }
        this.v.setVisibility(8);
        ba.e(this.s, i);
    }

    public final void f(boolean z) {
        if (this.ak == null) {
            this.ak = new ac(this.l, 500);
        }
        int i = TbadkApplication.j().l() == 1 ? com.baidu.tieba.a.g.more_all_1 : com.baidu.tieba.a.g.more_all;
        if (z) {
            this.ak.a();
            ba.e(this.i, i);
            ba.e((View) this.m, i);
            ba.e((View) this.o, i);
            ba.e((View) this.p, i);
            ba.e((View) this.q, i);
            ba.e((View) this.r, i);
            return;
        }
        this.ak.b();
        ba.e(this.i, i);
    }

    public final void d() {
        String str;
        String str2;
        com.baidu.tieba.r c = com.baidu.tieba.r.c();
        if (com.baidu.tieba.r.q()) {
            if (c.r() > 9) {
                str = String.valueOf(c.r());
            } else {
                str = "0" + c.r();
            }
            if (c.s() > 9) {
                str2 = String.valueOf(c.s());
            } else {
                str2 = "0" + c.s();
            }
            this.x.setText(b().getString(com.baidu.tieba.a.k.sign_remind_time, str, str2));
            this.v.setVisibility(0);
            if (!this.u.c()) {
                this.u.a();
                return;
            }
            return;
        }
        this.x.setText(com.baidu.tieba.a.k.close);
        this.v.setVisibility(8);
        if (this.u.c()) {
            this.u.b();
        }
    }

    public final void e() {
        this.h.setText(String.valueOf(TbadkApplication.j().ar()) + "-" + TbadkApplication.j().as());
        this.J.setText(TbadkApplication.j().ar());
        this.M.setText(TbadkApplication.j().as());
    }

    public final View f() {
        return this.A;
    }

    public final View g() {
        return this.u;
    }

    public final View h() {
        return this.k;
    }

    public final View i() {
        return this.v;
    }

    public final View j() {
        return this.e;
    }

    public final View k() {
        return this.f;
    }

    public final LinearLayout l() {
        return this.H;
    }

    public final LinearLayout m() {
        return this.K;
    }

    public final BdSwitchView n() {
        return this.P;
    }

    public final BdSwitchView o() {
        return this.S;
    }

    public final void g(boolean z) {
        if (this.a != z) {
            this.a = z;
            if (z) {
                this.D.setText(com.baidu.tieba.a.k.msg_remind);
                this.F.setVisibility(0);
                this.G.setVisibility(8);
                return;
            }
            this.D.setText(com.baidu.tieba.a.k.no_disturb_mode_time);
            this.G.setVisibility(0);
            this.F.setVisibility(8);
        }
    }
}
