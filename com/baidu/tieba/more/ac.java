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
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.f {
    private NavigationBar A;
    private TextView B;
    private View C;
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
    private BaseActivity R;
    private LinearLayout S;
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
    private ad ah;
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

    public ac(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity);
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.a = true;
        this.S = null;
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
        this.R = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.w.msg_remind_activity);
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
            this.q.setVisibility(8);
            this.t.setVisibility(8);
            this.L.setVisibility(8);
            this.O.setVisibility(8);
            this.S.setVisibility(8);
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
        }
    }

    public void a(int i) {
        this.R.getLayoutMode().a(i == 1);
        this.R.getLayoutMode().a((View) this.z);
        if (i == 1) {
            this.z.setBackgroundColor(this.R.getResources().getColor(com.baidu.tieba.s.bg_page_setting_1));
        } else {
            this.z.setBackgroundColor(this.R.getResources().getColor(com.baidu.tieba.s.bg_page_setting));
        }
        this.A.c(i);
        boolean z = i == 1;
        int a = z ? bk.a(i) : getContext().getResources().getColor(com.baidu.tieba.s.more_color);
        int i2 = z ? -11446171 : -5065030;
        int i3 = z ? com.baidu.tieba.u.more_all_1 : com.baidu.tieba.u.more_all;
        BdSwitchView.SwitchStyle switchStyle = z ? BdSwitchView.SwitchStyle.NIGHT : BdSwitchView.SwitchStyle.DAY;
        bk.e(this.b, i3);
        bk.e(this.e, i3);
        this.d.setSwitchStyle(switchStyle);
        bk.e(this.F, i3);
        bk.e(this.I, i3);
        bk.e(this.h, i3);
        bk.e((View) this.l, i3);
        bk.e((View) this.m, i3);
        bk.e((View) this.n, i3);
        bk.e((View) this.o, i3);
        bk.e((View) this.p, i3);
        this.j.setSwitchStyle(switchStyle);
        bk.e(this.q, i3);
        bk.e(this.t, i3);
        this.s.setSwitchStyle(switchStyle);
        int i4 = z ? com.baidu.tieba.u.icon_arrow_right_1 : com.baidu.tieba.u.icon_arrow_right;
        ((ImageView) this.e.findViewById(com.baidu.tieba.v.no_disturb_mode_time_arrow)).setImageResource(i4);
        ((ImageView) this.t.findViewById(com.baidu.tieba.v.sign_remind_arrow)).setImageResource(i4);
        ((ImageView) this.F.findViewById(com.baidu.tieba.v.no_disturb_start_time_arrow)).setImageResource(i4);
        ((ImageView) this.I.findViewById(com.baidu.tieba.v.no_disturb_end_time_arrow)).setImageResource(i4);
        bk.e(this.w, i3);
        this.y.setSwitchStyle(switchStyle);
        bk.e(this.L, i3);
        this.N.setSwitchStyle(switchStyle);
        bk.e(this.O, i3);
        this.Q.setSwitchStyle(switchStyle);
        this.c.setTextColor(a);
        this.f.setTextColor(a);
        this.g.setTextColor(i2);
        this.G.setTextColor(a);
        this.H.setTextColor(i2);
        this.J.setTextColor(a);
        this.K.setTextColor(i2);
        this.i.setTextColor(a);
        this.l.setTextColor(a);
        this.m.setTextColor(a);
        this.n.setTextColor(a);
        this.o.setTextColor(a);
        this.p.setTextColor(a);
        this.r.setTextColor(a);
        this.u.setTextColor(a);
        this.v.setTextColor(i2);
        this.x.setTextColor(a);
        this.M.setTextColor(a);
        this.P.setTextColor(a);
    }

    void b(MsgRemindActivity msgRemindActivity) {
        this.z = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.parent);
        this.A = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.C = this.A.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.B = this.A.a(msgRemindActivity.getString(com.baidu.tieba.y.msg_remind));
        this.b = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_container);
        this.b.setClickable(false);
        this.c = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_text);
        this.d = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_switch);
        this.e = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_container);
        this.f = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_text);
        this.g = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_value);
        this.h = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.message_remind_container);
        this.h.setClickable(false);
        this.i = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.message_remind_text);
        this.j = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.message_remind_switch);
        this.k = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.message_remind_value);
        this.l = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_replyme);
        this.m = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_zan);
        this.n = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_atme);
        this.q = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_on);
        this.q.setClickable(false);
        this.r = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_on_text);
        this.s = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_on_switch);
        this.t = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind);
        this.u = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_text);
        this.v = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_time);
        this.w = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.promoted_message);
        this.w.setClickable(false);
        this.x = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.promoted_message_text);
        this.y = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.promoted_message_switch);
        this.o = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_chatmessage);
        this.p = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_groupmessage);
        this.D = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.front_container);
        this.E = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.back_container);
        this.F = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time);
        this.G = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time_text);
        this.H = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time_value);
        this.I = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time);
        this.J = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time_text);
        this.K = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time_value);
        this.L = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_tone);
        this.L.setClickable(false);
        this.M = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.tone_text);
        this.N = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_tone_switch);
        this.O = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_vibrate);
        this.O.setClickable(false);
        this.P = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.vibrate_text);
        this.Q = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_vibrate_switch);
    }

    private void a(BaseActivity baseActivity) {
        this.S = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line1_layout);
        this.T = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line2_layout);
        this.U = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line3_layout);
        this.V = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line4_layout);
        this.W = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line5_layout);
        this.X = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line6_layout);
        this.Y = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line7_layout);
        this.Z = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line8_layout);
        this.aa = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line9_layout);
        this.ab = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line10_layout);
        this.ac = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line12_layout);
        this.ad = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line13_layout);
        this.ae = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line14_layout);
        this.af = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line15_layout);
        this.ag = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line16_layout);
    }

    public View a() {
        return this.C;
    }

    public void a(boolean z) {
        if (z) {
            this.T.setVisibility(0);
        } else {
            this.T.setVisibility(8);
        }
    }

    public void b(boolean z) {
        if (z) {
            this.Z.setPadding(this.R.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30), 0, this.R.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30), 0);
        } else {
            this.Z.setPadding(0, 0, 0, 0);
        }
    }

    public void c(boolean z) {
        if (z) {
            this.af.setVisibility(0);
        } else {
            this.af.setVisibility(8);
        }
    }

    private void n() {
        if (TbadkApplication.m252getInst().isNoDisturbOn()) {
            this.d.c();
            this.e.setVisibility(0);
            c();
            this.T.setVisibility(0);
            return;
        }
        this.d.d();
        this.e.setVisibility(8);
        this.T.setVisibility(8);
    }

    private void o() {
        if (TbadkApplication.m252getInst().isMsgRemindOn()) {
            this.Z.setPadding(this.R.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30), 0, this.R.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30), 0);
        } else {
            this.Z.setPadding(0, 0, 0, 0);
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
        if (TbadkApplication.m252getInst().isMsgChatOn()) {
            this.o.setChecked(true);
        }
        if (TbadkApplication.m252getInst().isGroupMsgOn()) {
            this.p.setChecked(true);
        }
    }

    private void p() {
        if (TbadkApplication.m252getInst().isPromotedMessageOn()) {
            this.y.c();
        } else {
            this.y.d();
        }
    }

    private void q() {
        if (com.baidu.tieba.ai.c().s()) {
            this.s.c();
            this.t.setVisibility(0);
            b();
            this.af.setVisibility(0);
            return;
        }
        this.s.d();
        this.t.setVisibility(8);
        this.af.setVisibility(8);
    }

    private void r() {
        if (TbadkApplication.m252getInst().isMsgToneOn()) {
            this.N.c();
        } else {
            this.N.d();
        }
        if (TbadkApplication.m252getInst().isMsgVibrateOn()) {
            this.Q.c();
        } else {
            this.Q.d();
        }
    }

    private void s() {
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
        this.s.setOnSwitchStateChangeListener(msgRemindActivity);
        this.y.setOnSwitchStateChangeListener(msgRemindActivity);
        this.d.setOnSwitchStateChangeListener(msgRemindActivity);
        this.l.setOnCheckedChangeListener(msgRemindActivity);
        this.m.setOnCheckedChangeListener(msgRemindActivity);
        this.n.setOnCheckedChangeListener(msgRemindActivity);
        this.o.setOnCheckedChangeListener(msgRemindActivity);
        this.p.setOnCheckedChangeListener(msgRemindActivity);
        this.t.setOnClickListener(msgRemindActivity);
        this.e.setOnClickListener(msgRemindActivity);
        this.F.setOnClickListener(msgRemindActivity);
        this.I.setOnClickListener(msgRemindActivity);
        this.N.setOnSwitchStateChangeListener(msgRemindActivity);
        this.Q.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void d(boolean z) {
        int i = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.u.more_all_1 : com.baidu.tieba.u.more_all;
        if (z) {
            this.e.setVisibility(0);
            c();
            bk.e(this.b, i);
            bk.e(this.e, i);
            return;
        }
        this.e.setVisibility(8);
        bk.e(this.b, i);
    }

    public void e(boolean z) {
        int i = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.u.more_all_1 : com.baidu.tieba.u.more_all;
        if (z) {
            this.t.setVisibility(0);
            bk.e(this.q, i);
            bk.e(this.t, i);
            return;
        }
        this.t.setVisibility(8);
        bk.e(this.q, i);
    }

    public void f(boolean z) {
        if (this.ah == null) {
            this.ah = new ad(this.k, 500);
        }
        int i = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.u.more_all_1 : com.baidu.tieba.u.more_all;
        if (z) {
            this.ah.a();
            bk.e(this.h, i);
            bk.e((View) this.l, i);
            bk.e((View) this.n, i);
            bk.e((View) this.o, i);
            bk.e((View) this.p, i);
            return;
        }
        this.ah.b();
        bk.e(this.h, i);
    }

    public void b() {
        String str;
        String str2;
        com.baidu.tieba.ai c = com.baidu.tieba.ai.c();
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
            this.v.setText(getContext().getString(com.baidu.tieba.y.sign_remind_time, str, str2));
            this.t.setVisibility(0);
            if (!this.s.e()) {
                this.s.c();
                return;
            }
            return;
        }
        this.v.setText(com.baidu.tieba.y.close);
        this.t.setVisibility(8);
        if (this.s.e()) {
            this.s.d();
        }
    }

    public void c() {
        this.g.setText(String.valueOf(TbadkApplication.m252getInst().getNoDisturbStartTime()) + "-" + TbadkApplication.m252getInst().getNoDisturbEndTime());
        this.H.setText(TbadkApplication.m252getInst().getNoDisturbStartTime());
        this.K.setText(TbadkApplication.m252getInst().getNoDisturbEndTime());
    }

    public View d() {
        return this.y;
    }

    public View e() {
        return this.s;
    }

    public View f() {
        return this.j;
    }

    public View g() {
        return this.t;
    }

    public View h() {
        return this.d;
    }

    public View i() {
        return this.e;
    }

    public LinearLayout j() {
        return this.F;
    }

    public LinearLayout k() {
        return this.I;
    }

    public BdSwitchView l() {
        return this.N;
    }

    public BdSwitchView m() {
        return this.Q;
    }

    public void g(boolean z) {
        if (this.a != z) {
            this.a = z;
            if (z) {
                this.B.setText(com.baidu.tieba.y.msg_remind);
                this.D.setVisibility(0);
                this.E.setVisibility(8);
                return;
            }
            this.B.setText(com.baidu.tieba.y.no_disturb_mode_time);
            this.E.setVisibility(0);
            this.D.setVisibility(8);
        }
    }
}
