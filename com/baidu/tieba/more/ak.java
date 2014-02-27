package com.baidu.tieba.more;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class ak extends com.baidu.adp.a.e {
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
    private com.baidu.tieba.f S;
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
    private an aj;
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

    public ak(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity);
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
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public final void a(MsgRemindActivity msgRemindActivity) {
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
        this.T = (LinearLayout) msgRemindActivity.findViewById(R.id.line1_layout);
        this.U = (LinearLayout) msgRemindActivity.findViewById(R.id.line2_layout);
        this.V = (LinearLayout) msgRemindActivity.findViewById(R.id.line3_layout);
        this.W = (LinearLayout) msgRemindActivity.findViewById(R.id.line4_layout);
        this.X = (LinearLayout) msgRemindActivity.findViewById(R.id.line5_layout);
        this.Y = (LinearLayout) msgRemindActivity.findViewById(R.id.line6_layout);
        this.Z = (LinearLayout) msgRemindActivity.findViewById(R.id.line7_layout);
        this.aa = (LinearLayout) msgRemindActivity.findViewById(R.id.line8_layout);
        this.ab = (LinearLayout) msgRemindActivity.findViewById(R.id.line9_layout);
        this.ac = (LinearLayout) msgRemindActivity.findViewById(R.id.line10_layout);
        this.ad = (LinearLayout) msgRemindActivity.findViewById(R.id.line11_layout);
        this.ae = (LinearLayout) msgRemindActivity.findViewById(R.id.line12_layout);
        this.af = (LinearLayout) msgRemindActivity.findViewById(R.id.line13_layout);
        this.ag = (LinearLayout) msgRemindActivity.findViewById(R.id.line14_layout);
        this.ah = (LinearLayout) msgRemindActivity.findViewById(R.id.line15_layout);
        this.ai = (LinearLayout) msgRemindActivity.findViewById(R.id.line16_layout);
        if (TiebaApplication.g().I()) {
            this.e.a();
            this.f.setVisibility(0);
            e();
            this.U.setVisibility(0);
        } else {
            this.e.b();
            this.f.setVisibility(8);
            this.U.setVisibility(8);
        }
        if (TiebaApplication.g().T()) {
            this.k.a();
            this.l.setVisibility(0);
        } else {
            this.k.b();
            this.l.setVisibility(8);
        }
        if (TiebaApplication.g().T()) {
            this.aa.setPadding(this.S.getResources().getDimensionPixelSize(R.dimen.ds30), 0, this.S.getResources().getDimensionPixelSize(R.dimen.ds30), 0);
        } else {
            this.aa.setPadding(0, 0, 0, 0);
        }
        if (TiebaApplication.g().Q()) {
            this.m.setChecked(true);
        }
        if (TiebaApplication.g().P()) {
            this.n.setChecked(true);
        }
        if (TiebaApplication.g().O()) {
            this.o.setChecked(true);
        }
        if (TiebaApplication.g().R()) {
            this.p.setChecked(true);
        }
        if (TiebaApplication.g().S()) {
            this.q.setChecked(true);
        }
        if (TiebaApplication.g().H()) {
            this.z.a();
        } else {
            this.z.b();
        }
        if (TiebaApplication.g().U()) {
            this.t.a();
            this.u.setVisibility(0);
            d();
            this.ah.setVisibility(0);
        } else {
            this.t.b();
            this.u.setVisibility(8);
            this.ah.setVisibility(8);
        }
        if (TiebaApplication.g().L()) {
            this.O.a();
        } else {
            this.O.b();
        }
        if (TiebaApplication.g().M()) {
            this.R.a();
        } else {
            this.R.b();
        }
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
        String v = TiebaApplication.v();
        if (v == null || v.length() <= 0) {
            this.c.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(8);
            this.l.setVisibility(8);
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

    public final void a(int i) {
        this.S.getLayoutMode().a(i == 1);
        this.S.getLayoutMode().a(this.A);
        if (i == 1) {
            this.A.setBackgroundColor(this.S.getResources().getColor(R.color.bg_page_setting_1));
        } else {
            this.A.setBackgroundColor(this.S.getResources().getColor(R.color.bg_page_setting));
        }
        this.B.b(i);
        boolean z = i == 1;
        int a = z ? bq.a(i) : b().getResources().getColor(R.color.more_color);
        int i2 = z ? -11446171 : -5065030;
        int i3 = z ? R.drawable.more_all_1 : R.drawable.more_all;
        BdSwitchView.SwitchStyle switchStyle = z ? BdSwitchView.SwitchStyle.NIGHT : BdSwitchView.SwitchStyle.DAY;
        bq.e(this.c, i3);
        bq.e(this.f, i3);
        this.e.setSwitchStyle(switchStyle);
        bq.e(this.G, i3);
        bq.e(this.J, i3);
        bq.e(this.i, i3);
        bq.e((View) this.m, i3);
        bq.e((View) this.n, i3);
        bq.e((View) this.o, i3);
        bq.e((View) this.p, i3);
        bq.e((View) this.q, i3);
        this.k.setSwitchStyle(switchStyle);
        bq.e(this.r, i3);
        bq.e(this.u, i3);
        this.t.setSwitchStyle(switchStyle);
        int i4 = z ? R.drawable.icon_arrow_right_1 : R.drawable.icon_arrow_right;
        ((ImageView) this.f.findViewById(R.id.no_disturb_mode_time_arrow)).setImageResource(i4);
        ((ImageView) this.u.findViewById(R.id.sign_remind_arrow)).setImageResource(i4);
        ((ImageView) this.G.findViewById(R.id.no_disturb_start_time_arrow)).setImageResource(i4);
        ((ImageView) this.J.findViewById(R.id.no_disturb_end_time_arrow)).setImageResource(i4);
        bq.e(this.x, i3);
        this.z.setSwitchStyle(switchStyle);
        bq.e(this.M, i3);
        this.O.setSwitchStyle(switchStyle);
        bq.e(this.P, i3);
        this.R.setSwitchStyle(switchStyle);
        this.d.setTextColor(a);
        this.g.setTextColor(a);
        this.h.setTextColor(i2);
        this.H.setTextColor(a);
        this.I.setTextColor(i2);
        this.K.setTextColor(a);
        this.L.setTextColor(i2);
        this.j.setTextColor(a);
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

    public final ImageView a() {
        return this.D;
    }

    public final void a(boolean z) {
        if (z) {
            this.U.setVisibility(0);
        } else {
            this.U.setVisibility(8);
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.aa.setPadding(this.S.getResources().getDimensionPixelSize(R.dimen.ds30), 0, this.S.getResources().getDimensionPixelSize(R.dimen.ds30), 0);
        } else {
            this.aa.setPadding(0, 0, 0, 0);
        }
    }

    public final void c(boolean z) {
        if (z) {
            this.ah.setVisibility(0);
        } else {
            this.ah.setVisibility(8);
        }
    }

    public final void d(boolean z) {
        int i = TiebaApplication.g().ae() == 1 ? R.drawable.more_all_1 : R.drawable.more_all;
        if (z) {
            this.f.setVisibility(0);
            e();
            bq.e(this.c, i);
            bq.e(this.f, i);
            return;
        }
        this.f.setVisibility(8);
        bq.e(this.c, i);
    }

    public final void e(boolean z) {
        int i = TiebaApplication.g().ae() == 1 ? R.drawable.more_all_1 : R.drawable.more_all;
        if (z) {
            this.u.setVisibility(0);
            bq.e(this.r, i);
            bq.e(this.u, i);
            return;
        }
        this.u.setVisibility(8);
        bq.e(this.r, i);
    }

    public final void f(boolean z) {
        if (this.aj == null) {
            this.aj = new an(this.l, 500);
        }
        int i = TiebaApplication.g().ae() == 1 ? R.drawable.more_all_1 : R.drawable.more_all;
        if (z) {
            this.aj.a();
            bq.e(this.i, i);
            bq.e((View) this.m, i);
            bq.e((View) this.n, i);
            bq.e((View) this.o, i);
            bq.e((View) this.p, i);
            bq.e((View) this.q, i);
            return;
        }
        this.aj.b();
        bq.e(this.i, i);
    }

    public final void d() {
        String str;
        String str2;
        TiebaApplication g = TiebaApplication.g();
        if (g.U()) {
            if (g.V() > 9) {
                str = String.valueOf(g.V());
            } else {
                str = SocialConstants.FALSE + g.V();
            }
            if (g.W() > 9) {
                str2 = String.valueOf(g.W());
            } else {
                str2 = SocialConstants.FALSE + g.W();
            }
            this.w.setText(b().getString(R.string.sign_remind_time, str, str2));
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

    public final void e() {
        this.h.setText(String.valueOf(TiebaApplication.g().J()) + "-" + TiebaApplication.g().K());
        this.I.setText(TiebaApplication.g().J());
        this.L.setText(TiebaApplication.g().K());
    }

    public final View f() {
        return this.z;
    }

    public final View g() {
        return this.t;
    }

    public final View h() {
        return this.k;
    }

    public final View i() {
        return this.u;
    }

    public final View j() {
        return this.e;
    }

    public final View k() {
        return this.f;
    }

    public final LinearLayout l() {
        return this.G;
    }

    public final LinearLayout m() {
        return this.J;
    }

    public final BdSwitchView n() {
        return this.O;
    }

    public final BdSwitchView o() {
        return this.R;
    }

    public final void g(boolean z) {
        if (this.a != z) {
            this.a = z;
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
