package com.baidu.tieba.more;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.f {
    private RelativeLayout A;
    private NavigationBar B;
    private TextView C;
    private View D;
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
    private LinearLayout S;
    private TextView T;
    private BdSwitchView U;
    private BaseActivity V;
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
    private LinearLayout ak;
    private LinearLayout al;
    private ai am;
    private LinearLayout b;
    private TextView c;
    private BdSwitchView d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private LinearLayout h;
    private TextView i;
    private BdSwitchView j;
    private LinearLayout k;
    private CheckBox l;
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

    public ah(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity);
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.a = true;
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
        this.ak = null;
        this.al = null;
        this.V = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.v.msg_remind_activity);
    }

    public void a(MsgRemindActivity msgRemindActivity) {
        b(msgRemindActivity);
        a((BaseActivity) msgRemindActivity);
        o();
        t();
        p();
        q();
        r();
        s();
        c(msgRemindActivity);
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.b.setVisibility(8);
            this.e.setVisibility(8);
            this.h.setVisibility(8);
            this.k.setVisibility(8);
            this.r.setVisibility(8);
            this.u.setVisibility(8);
            this.M.setVisibility(8);
            this.P.setVisibility(8);
            this.S.setVisibility(8);
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
            this.ak.setVisibility(8);
            this.al.setVisibility(8);
        }
    }

    public void a(int i) {
        this.V.getLayoutMode().a(i == 1);
        this.V.getLayoutMode().a((View) this.A);
        if (i == 1) {
            this.A.setBackgroundColor(this.V.getResources().getColor(com.baidu.tieba.r.bg_page_setting_1));
        } else {
            this.A.setBackgroundColor(this.V.getResources().getColor(com.baidu.tieba.r.bg_page_setting));
        }
        this.B.c(i);
        boolean z = i == 1;
        int a = z ? com.baidu.tbadk.core.util.ay.a(i) : getContext().getResources().getColor(com.baidu.tieba.r.more_color);
        int i2 = z ? -11446171 : -5065030;
        int i3 = z ? com.baidu.tieba.t.more_all_1 : com.baidu.tieba.t.more_all;
        BdSwitchView.SwitchStyle switchStyle = z ? BdSwitchView.SwitchStyle.NIGHT : BdSwitchView.SwitchStyle.DAY;
        com.baidu.tbadk.core.util.ay.e(this.b, i3);
        com.baidu.tbadk.core.util.ay.e(this.e, i3);
        this.d.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.ay.e(this.G, i3);
        com.baidu.tbadk.core.util.ay.e(this.J, i3);
        com.baidu.tbadk.core.util.ay.e(this.h, i3);
        com.baidu.tbadk.core.util.ay.e((View) this.l, i3);
        com.baidu.tbadk.core.util.ay.e((View) this.m, i3);
        com.baidu.tbadk.core.util.ay.e((View) this.n, i3);
        com.baidu.tbadk.core.util.ay.e((View) this.o, i3);
        com.baidu.tbadk.core.util.ay.e((View) this.q, i3);
        com.baidu.tbadk.core.util.ay.e((View) this.p, i3);
        this.j.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.ay.e(this.r, i3);
        com.baidu.tbadk.core.util.ay.e(this.u, i3);
        this.t.setSwitchStyle(switchStyle);
        int i4 = z ? com.baidu.tieba.t.icon_arrow_right_1 : com.baidu.tieba.t.icon_arrow_right;
        ((ImageView) this.e.findViewById(com.baidu.tieba.u.no_disturb_mode_time_arrow)).setImageResource(i4);
        ((ImageView) this.u.findViewById(com.baidu.tieba.u.sign_remind_arrow)).setImageResource(i4);
        ((ImageView) this.G.findViewById(com.baidu.tieba.u.no_disturb_start_time_arrow)).setImageResource(i4);
        ((ImageView) this.J.findViewById(com.baidu.tieba.u.no_disturb_end_time_arrow)).setImageResource(i4);
        com.baidu.tbadk.core.util.ay.e(this.x, i3);
        this.z.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.ay.e(this.M, i3);
        this.O.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.ay.e(this.P, i3);
        this.R.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.ay.e(this.S, i3);
        this.U.setSwitchStyle(switchStyle);
        this.c.setTextColor(a);
        this.f.setTextColor(a);
        this.g.setTextColor(i2);
        this.H.setTextColor(a);
        this.I.setTextColor(i2);
        this.K.setTextColor(a);
        this.L.setTextColor(i2);
        this.i.setTextColor(a);
        this.l.setTextColor(a);
        this.m.setTextColor(a);
        this.n.setTextColor(a);
        this.q.setTextColor(a);
        this.o.setTextColor(a);
        this.p.setTextColor(a);
        this.s.setTextColor(a);
        this.v.setTextColor(a);
        this.w.setTextColor(i2);
        this.y.setTextColor(a);
        this.N.setTextColor(a);
        this.Q.setTextColor(a);
        this.T.setTextColor(a);
    }

    void b(MsgRemindActivity msgRemindActivity) {
        this.A = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.parent);
        this.B = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.D = this.B.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.C = this.B.a(msgRemindActivity.getString(com.baidu.tieba.x.msg_remind));
        this.b = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.no_disturb_mode_container);
        this.b.setClickable(false);
        this.c = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.no_disturb_mode_text);
        this.d = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.u.no_disturb_mode_switch);
        this.e = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.no_disturb_mode_time_container);
        this.f = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.no_disturb_mode_time_text);
        this.g = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.no_disturb_mode_time_value);
        this.h = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.message_remind_container);
        this.h.setClickable(false);
        this.i = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.message_remind_text);
        this.j = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.u.message_remind_switch);
        this.k = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.message_remind_value);
        this.l = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.u.check_replyme);
        this.m = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.u.check_zan);
        this.n = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.u.check_atme);
        this.q = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.u.check_new_fans);
        this.r = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.sign_remind_on);
        this.r.setClickable(false);
        this.s = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.sign_remind_on_text);
        this.t = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.u.sign_remind_on_switch);
        this.u = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.sign_remind);
        this.v = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.sign_remind_text);
        this.w = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.sign_remind_time);
        this.x = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.promoted_message);
        this.x.setClickable(false);
        this.y = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.promoted_message_text);
        this.z = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.u.promoted_message_switch);
        this.o = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.u.check_chatmessage);
        this.p = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.u.check_groupmessage);
        this.E = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.front_container);
        this.F = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.back_container);
        this.G = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.no_disturb_start_time);
        this.H = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.no_disturb_start_time_text);
        this.I = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.no_disturb_start_time_value);
        this.J = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.no_disturb_end_time);
        this.K = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.no_disturb_end_time_text);
        this.L = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.no_disturb_end_time_value);
        this.M = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.remind_tone);
        this.M.setClickable(false);
        this.N = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.tone_text);
        this.O = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.u.remind_tone_switch);
        this.P = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.remind_vibrate);
        this.P.setClickable(false);
        this.Q = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.vibrate_text);
        this.R = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.u.remind_vibrate_switch);
        this.S = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.u.remid_light);
        this.S.setClickable(false);
        this.T = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.u.light_text);
        this.U = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.u.remind_light_switch);
    }

    private void a(BaseActivity baseActivity) {
        this.W = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line1_layout);
        this.X = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line2_layout);
        this.Y = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line3_layout);
        this.Z = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line4_layout);
        this.aa = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line5_layout);
        this.ab = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line6_layout);
        this.ac = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line7_layout);
        this.ad = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line8_layout);
        this.ae = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line9_layout);
        this.af = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line10_layout);
        this.ag = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line11_layout);
        this.ah = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line12_layout);
        this.ai = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line13_layout);
        this.aj = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line14_layout);
        this.ak = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line15_layout);
        this.al = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.line16_layout);
    }

    public View a() {
        return this.D;
    }

    public void a(boolean z) {
        if (z) {
            this.X.setVisibility(0);
        } else {
            this.X.setVisibility(8);
        }
    }

    public void b(boolean z) {
        if (z) {
            this.ad.setPadding(this.V.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds30), 0, this.V.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds30), 0);
        } else {
            this.ad.setPadding(0, 0, 0, 0);
        }
    }

    public void c(boolean z) {
        if (z) {
            this.ak.setVisibility(0);
        } else {
            this.ak.setVisibility(8);
        }
    }

    private void o() {
        if (TbadkApplication.m252getInst().isNoDisturbOn()) {
            this.d.c();
            this.e.setVisibility(0);
            c();
            this.X.setVisibility(0);
            return;
        }
        this.d.d();
        this.e.setVisibility(8);
        this.X.setVisibility(8);
    }

    private void p() {
        if (TbadkApplication.m252getInst().isMsgRemindOn()) {
            this.ad.setPadding(this.V.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds30), 0, this.V.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds30), 0);
        } else {
            this.ad.setPadding(0, 0, 0, 0);
        }
        if (TbadkApplication.m252getInst().isMsgReplymeOn()) {
            this.l.setChecked(true);
        }
        if (TbadkApplication.m252getInst().isMsgZanOn()) {
            this.m.setChecked(true);
        }
        if (TbadkApplication.m252getInst().isMsgAtmeOn()) {
            this.n.setChecked(true);
        }
        this.q.setChecked(TbadkApplication.m252getInst().isMsgNewFansOn());
        if (TbadkApplication.m252getInst().isMsgChatOn()) {
            this.o.setChecked(true);
        }
        if (TbadkApplication.m252getInst().isGroupMsgOn()) {
            this.p.setChecked(true);
        }
    }

    private void q() {
        if (TbadkApplication.m252getInst().isPromotedMessageOn()) {
            this.z.c();
        } else {
            this.z.d();
        }
    }

    private void r() {
        if (com.baidu.tieba.ai.c().r()) {
            this.t.c();
            this.u.setVisibility(0);
            b();
            this.ak.setVisibility(0);
            return;
        }
        this.t.d();
        this.u.setVisibility(8);
        this.ak.setVisibility(8);
    }

    private void s() {
        if (TbadkApplication.m252getInst().isMsgToneOn()) {
            this.O.c();
        } else {
            this.O.d();
        }
        if (TbadkApplication.m252getInst().isMsgVibrateOn()) {
            this.R.c();
        } else {
            this.R.d();
        }
        if (TbadkApplication.m252getInst().isMsgLightOn()) {
            this.U.c();
        } else {
            this.U.d();
        }
    }

    private void t() {
        if (TbadkApplication.m252getInst().isMsgRemindOn()) {
            this.j.c();
            this.k.setVisibility(0);
            return;
        }
        this.j.d();
        this.k.setVisibility(8);
    }

    private void c(MsgRemindActivity msgRemindActivity) {
        this.j.setOnSwitchStateChangeListener(msgRemindActivity);
        this.t.setOnSwitchStateChangeListener(msgRemindActivity);
        this.z.setOnSwitchStateChangeListener(msgRemindActivity);
        this.d.setOnSwitchStateChangeListener(msgRemindActivity);
        this.l.setOnCheckedChangeListener(msgRemindActivity);
        this.m.setOnCheckedChangeListener(msgRemindActivity);
        this.n.setOnCheckedChangeListener(msgRemindActivity);
        this.q.setOnCheckedChangeListener(msgRemindActivity);
        this.o.setOnCheckedChangeListener(msgRemindActivity);
        this.p.setOnCheckedChangeListener(msgRemindActivity);
        this.u.setOnClickListener(msgRemindActivity);
        this.e.setOnClickListener(msgRemindActivity);
        this.G.setOnClickListener(msgRemindActivity);
        this.J.setOnClickListener(msgRemindActivity);
        this.O.setOnSwitchStateChangeListener(msgRemindActivity);
        this.R.setOnSwitchStateChangeListener(msgRemindActivity);
        this.U.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void d(boolean z) {
        int i = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.t.more_all_1 : com.baidu.tieba.t.more_all;
        if (z) {
            this.e.setVisibility(0);
            c();
            com.baidu.tbadk.core.util.ay.e(this.b, i);
            com.baidu.tbadk.core.util.ay.e(this.e, i);
            return;
        }
        this.e.setVisibility(8);
        com.baidu.tbadk.core.util.ay.e(this.b, i);
    }

    public void e(boolean z) {
        int i = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.t.more_all_1 : com.baidu.tieba.t.more_all;
        if (z) {
            this.u.setVisibility(0);
            com.baidu.tbadk.core.util.ay.e(this.r, i);
            com.baidu.tbadk.core.util.ay.e(this.u, i);
            return;
        }
        this.u.setVisibility(8);
        com.baidu.tbadk.core.util.ay.e(this.r, i);
    }

    public void f(boolean z) {
        if (this.am == null) {
            this.am = new ai(this.k, 500);
        }
        int i = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.t.more_all_1 : com.baidu.tieba.t.more_all;
        if (z) {
            this.am.a();
            com.baidu.tbadk.core.util.ay.e(this.h, i);
            com.baidu.tbadk.core.util.ay.e((View) this.l, i);
            com.baidu.tbadk.core.util.ay.e((View) this.n, i);
            com.baidu.tbadk.core.util.ay.e((View) this.q, i);
            com.baidu.tbadk.core.util.ay.e((View) this.o, i);
            com.baidu.tbadk.core.util.ay.e((View) this.p, i);
            return;
        }
        this.am.b();
        com.baidu.tbadk.core.util.ay.e(this.h, i);
    }

    public void b() {
        String str;
        String str2;
        com.baidu.tieba.ai c = com.baidu.tieba.ai.c();
        if (c.r()) {
            if (c.s() > 9) {
                str = String.valueOf(c.s());
            } else {
                str = "0" + c.s();
            }
            if (c.t() > 9) {
                str2 = String.valueOf(c.t());
            } else {
                str2 = "0" + c.t();
            }
            this.w.setText(getContext().getString(com.baidu.tieba.x.sign_remind_time, str, str2));
            this.u.setVisibility(0);
            if (!this.t.e()) {
                this.t.c();
                return;
            }
            return;
        }
        this.w.setText(com.baidu.tieba.x.close);
        this.u.setVisibility(8);
        if (this.t.e()) {
            this.t.d();
        }
    }

    public void c() {
        this.g.setText(String.valueOf(TbadkApplication.m252getInst().getNoDisturbStartTime()) + "-" + TbadkApplication.m252getInst().getNoDisturbEndTime());
        this.I.setText(TbadkApplication.m252getInst().getNoDisturbStartTime());
        this.L.setText(TbadkApplication.m252getInst().getNoDisturbEndTime());
    }

    public View d() {
        return this.z;
    }

    public View e() {
        return this.t;
    }

    public View f() {
        return this.j;
    }

    public View g() {
        return this.u;
    }

    public View h() {
        return this.d;
    }

    public View i() {
        return this.e;
    }

    public LinearLayout j() {
        return this.G;
    }

    public LinearLayout k() {
        return this.J;
    }

    public BdSwitchView l() {
        return this.O;
    }

    public BdSwitchView m() {
        return this.R;
    }

    public BdSwitchView n() {
        return this.U;
    }

    public void g(boolean z) {
        if (this.a != z) {
            this.a = z;
            if (z) {
                this.C.setText(com.baidu.tieba.x.msg_remind);
                this.E.setVisibility(0);
                this.F.setVisibility(8);
                return;
            }
            this.C.setText(com.baidu.tieba.x.no_disturb_mode_time);
            this.F.setVisibility(0);
            this.E.setVisibility(8);
        }
    }
}
