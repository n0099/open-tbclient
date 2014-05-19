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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.e {
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
    private BaseActivity S;
    private LinearLayout T;
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
    private ac aj;
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

    public ab(MsgRemindActivity msgRemindActivity) {
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
        this.T = null;
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
        this.S = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.s.msg_remind_activity);
    }

    public void a(MsgRemindActivity msgRemindActivity) {
        b(msgRemindActivity);
        a((BaseActivity) msgRemindActivity);
        n();
        s();
        o();
        p();
        q();
        r();
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
            this.T.setVisibility(8);
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
        }
    }

    public void a(int i) {
        this.S.getLayoutMode().a(i == 1);
        this.S.getLayoutMode().a((View) this.A);
        if (i == 1) {
            this.A.setBackgroundColor(this.S.getResources().getColor(com.baidu.tieba.o.bg_page_setting_1));
        } else {
            this.A.setBackgroundColor(this.S.getResources().getColor(com.baidu.tieba.o.bg_page_setting));
        }
        this.B.c(i);
        boolean z = i == 1;
        int a = z ? bc.a(i) : getContext().getResources().getColor(com.baidu.tieba.o.more_color);
        int i2 = z ? -11446171 : -5065030;
        int i3 = z ? com.baidu.tieba.q.more_all_1 : com.baidu.tieba.q.more_all;
        BdSwitchView.SwitchStyle switchStyle = z ? BdSwitchView.SwitchStyle.NIGHT : BdSwitchView.SwitchStyle.DAY;
        bc.e(this.b, i3);
        bc.e(this.e, i3);
        this.d.setSwitchStyle(switchStyle);
        bc.e(this.G, i3);
        bc.e(this.J, i3);
        bc.e(this.h, i3);
        bc.e((View) this.l, i3);
        bc.e((View) this.m, i3);
        bc.e((View) this.n, i3);
        bc.e((View) this.o, i3);
        bc.e((View) this.p, i3);
        bc.e((View) this.q, i3);
        this.j.setSwitchStyle(switchStyle);
        bc.e(this.r, i3);
        bc.e(this.u, i3);
        this.t.setSwitchStyle(switchStyle);
        int i4 = z ? com.baidu.tieba.q.icon_arrow_right_1 : com.baidu.tieba.q.icon_arrow_right;
        ((ImageView) this.e.findViewById(com.baidu.tieba.r.no_disturb_mode_time_arrow)).setImageResource(i4);
        ((ImageView) this.u.findViewById(com.baidu.tieba.r.sign_remind_arrow)).setImageResource(i4);
        ((ImageView) this.G.findViewById(com.baidu.tieba.r.no_disturb_start_time_arrow)).setImageResource(i4);
        ((ImageView) this.J.findViewById(com.baidu.tieba.r.no_disturb_end_time_arrow)).setImageResource(i4);
        bc.e(this.x, i3);
        this.z.setSwitchStyle(switchStyle);
        bc.e(this.M, i3);
        this.O.setSwitchStyle(switchStyle);
        bc.e(this.P, i3);
        this.R.setSwitchStyle(switchStyle);
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
        this.o.setTextColor(a);
        this.p.setTextColor(a);
        this.q.setTextColor(a);
        this.s.setTextColor(a);
        this.v.setTextColor(a);
        this.w.setTextColor(i2);
        this.y.setTextColor(a);
        this.N.setTextColor(a);
        this.Q.setTextColor(a);
    }

    void b(MsgRemindActivity msgRemindActivity) {
        this.A = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.parent);
        this.B = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.D = this.B.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.C = this.B.a(msgRemindActivity.getString(com.baidu.tieba.u.msg_remind));
        this.b = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.no_disturb_mode_container);
        this.b.setClickable(false);
        this.c = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.no_disturb_mode_text);
        this.d = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.r.no_disturb_mode_switch);
        this.e = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.no_disturb_mode_time_container);
        this.f = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.no_disturb_mode_time_text);
        this.g = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.no_disturb_mode_time_value);
        this.h = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.message_remind_container);
        this.h.setClickable(false);
        this.i = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.message_remind_text);
        this.j = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.r.message_remind_switch);
        this.k = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.message_remind_value);
        this.l = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.r.check_replyme);
        this.m = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.r.check_zan);
        this.n = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.r.check_atme);
        this.o = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.r.check_newfans);
        this.r = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.sign_remind_on);
        this.r.setClickable(false);
        this.s = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.sign_remind_on_text);
        this.t = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.r.sign_remind_on_switch);
        this.u = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.sign_remind);
        this.v = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.sign_remind_text);
        this.w = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.sign_remind_time);
        this.x = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.promoted_message);
        this.x.setClickable(false);
        this.y = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.promoted_message_text);
        this.z = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.r.promoted_message_switch);
        this.p = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.r.check_chatmessage);
        this.q = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.r.check_groupmessage);
        this.E = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.front_container);
        this.F = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.back_container);
        this.G = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.no_disturb_start_time);
        this.H = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.no_disturb_start_time_text);
        this.I = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.no_disturb_start_time_value);
        this.J = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.no_disturb_end_time);
        this.K = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.no_disturb_end_time_text);
        this.L = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.no_disturb_end_time_value);
        this.M = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.remind_tone);
        this.M.setClickable(false);
        this.N = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.tone_text);
        this.O = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.r.remind_tone_switch);
        this.P = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.r.remind_vibrate);
        this.P.setClickable(false);
        this.Q = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.r.vibrate_text);
        this.R = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.r.remind_vibrate_switch);
    }

    private void a(BaseActivity baseActivity) {
        this.T = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line1_layout);
        this.U = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line2_layout);
        this.V = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line3_layout);
        this.W = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line4_layout);
        this.X = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line5_layout);
        this.Y = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line6_layout);
        this.Z = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line7_layout);
        this.aa = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line8_layout);
        this.ab = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line9_layout);
        this.ac = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line10_layout);
        this.ad = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line11_layout);
        this.ae = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line12_layout);
        this.af = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line13_layout);
        this.ag = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line14_layout);
        this.ah = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line15_layout);
        this.ai = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.r.line16_layout);
    }

    public View a() {
        return this.D;
    }

    public void a(boolean z) {
        if (z) {
            this.U.setVisibility(0);
        } else {
            this.U.setVisibility(8);
        }
    }

    public void b(boolean z) {
        if (z) {
            this.aa.setPadding(this.S.getResources().getDimensionPixelSize(com.baidu.tieba.p.ds30), 0, this.S.getResources().getDimensionPixelSize(com.baidu.tieba.p.ds30), 0);
        } else {
            this.aa.setPadding(0, 0, 0, 0);
        }
    }

    public void c(boolean z) {
        if (z) {
            this.ah.setVisibility(0);
        } else {
            this.ah.setVisibility(8);
        }
    }

    private void n() {
        if (TbadkApplication.m252getInst().isNoDisturbOn()) {
            this.d.a();
            this.e.setVisibility(0);
            c();
            this.U.setVisibility(0);
            return;
        }
        this.d.b();
        this.e.setVisibility(8);
        this.U.setVisibility(8);
    }

    private void o() {
        if (TbadkApplication.m252getInst().isMsgRemindOn()) {
            this.aa.setPadding(this.S.getResources().getDimensionPixelSize(com.baidu.tieba.p.ds30), 0, this.S.getResources().getDimensionPixelSize(com.baidu.tieba.p.ds30), 0);
        } else {
            this.aa.setPadding(0, 0, 0, 0);
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
        if (TbadkApplication.m252getInst().isMsgFansOn()) {
            this.o.setChecked(true);
        }
        if (TbadkApplication.m252getInst().isMsgChatOn()) {
            this.p.setChecked(true);
        }
        if (TbadkApplication.m252getInst().isGroupMsgOn()) {
            this.q.setChecked(true);
        }
    }

    private void p() {
        if (TbadkApplication.m252getInst().isPromotedMessageOn()) {
            this.z.a();
        } else {
            this.z.b();
        }
    }

    private void q() {
        if (com.baidu.tieba.ad.c().s()) {
            this.t.a();
            this.u.setVisibility(0);
            b();
            this.ah.setVisibility(0);
            return;
        }
        this.t.b();
        this.u.setVisibility(8);
        this.ah.setVisibility(8);
    }

    private void r() {
        if (TbadkApplication.m252getInst().isMsgToneOn()) {
            this.O.a();
        } else {
            this.O.b();
        }
        if (TbadkApplication.m252getInst().isMsgVibrateOn()) {
            this.R.a();
        } else {
            this.R.b();
        }
    }

    private void s() {
        if (TbadkApplication.m252getInst().isMsgRemindOn()) {
            this.j.a();
            this.k.setVisibility(0);
            return;
        }
        this.j.b();
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
        this.o.setOnCheckedChangeListener(msgRemindActivity);
        this.p.setOnCheckedChangeListener(msgRemindActivity);
        this.q.setOnCheckedChangeListener(msgRemindActivity);
        this.u.setOnClickListener(msgRemindActivity);
        this.e.setOnClickListener(msgRemindActivity);
        this.G.setOnClickListener(msgRemindActivity);
        this.J.setOnClickListener(msgRemindActivity);
        this.O.setOnSwitchStateChangeListener(msgRemindActivity);
        this.R.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void d(boolean z) {
        int i = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.q.more_all_1 : com.baidu.tieba.q.more_all;
        if (z) {
            this.e.setVisibility(0);
            c();
            bc.e(this.b, i);
            bc.e(this.e, i);
            return;
        }
        this.e.setVisibility(8);
        bc.e(this.b, i);
    }

    public void e(boolean z) {
        int i = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.q.more_all_1 : com.baidu.tieba.q.more_all;
        if (z) {
            this.u.setVisibility(0);
            bc.e(this.r, i);
            bc.e(this.u, i);
            return;
        }
        this.u.setVisibility(8);
        bc.e(this.r, i);
    }

    public void f(boolean z) {
        if (this.aj == null) {
            this.aj = new ac(this.k, 500);
        }
        int i = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.q.more_all_1 : com.baidu.tieba.q.more_all;
        if (z) {
            this.aj.a();
            bc.e(this.h, i);
            bc.e((View) this.l, i);
            bc.e((View) this.n, i);
            bc.e((View) this.o, i);
            bc.e((View) this.p, i);
            bc.e((View) this.q, i);
            return;
        }
        this.aj.b();
        bc.e(this.h, i);
    }

    public void b() {
        String str;
        String str2;
        com.baidu.tieba.ad c = com.baidu.tieba.ad.c();
        if (c.s()) {
            if (c.t() > 9) {
                str = String.valueOf(c.t());
            } else {
                str = "0" + c.t();
            }
            if (c.u() > 9) {
                str2 = String.valueOf(c.u());
            } else {
                str2 = "0" + c.u();
            }
            this.w.setText(getContext().getString(com.baidu.tieba.u.sign_remind_time, str, str2));
            this.u.setVisibility(0);
            if (!this.t.c()) {
                this.t.a();
                return;
            }
            return;
        }
        this.w.setText(com.baidu.tieba.u.close);
        this.u.setVisibility(8);
        if (this.t.c()) {
            this.t.b();
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

    public void g(boolean z) {
        if (this.a != z) {
            this.a = z;
            if (z) {
                this.C.setText(com.baidu.tieba.u.msg_remind);
                this.E.setVisibility(0);
                this.F.setVisibility(8);
                return;
            }
            this.C.setText(com.baidu.tieba.u.no_disturb_mode_time);
            this.F.setVisibility(0);
            this.E.setVisibility(8);
        }
    }
}
