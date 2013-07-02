package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.a.d {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private AlertDialog K;
    private ImageView L;
    private BdSwitchView M;
    private BdSwitchView N;
    private BdSwitchView O;
    private BdSwitchView P;
    TextView b;
    private LinearLayout c;
    private LinearLayout d;
    private TextView e;
    private RelativeLayout f;
    private View g;
    private ImageView h;
    private TextView i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private LinearLayout o;
    private LinearLayout p;
    private LinearLayout q;
    private LinearLayout r;
    private LinearLayout s;
    private LinearLayout t;
    private LinearLayout u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public z(MoreActivity moreActivity) {
        super(moreActivity);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.b = null;
        moreActivity.setContentView(R.layout.more_activity);
        this.f = (RelativeLayout) moreActivity.findViewById(R.id.parent);
        this.g = moreActivity.findViewById(R.id.title);
        this.h = (ImageView) moreActivity.findViewById(R.id.back);
        this.h.setOnClickListener(moreActivity);
        this.i = (TextView) moreActivity.findViewById(R.id.title_text);
        this.c = (LinearLayout) moreActivity.findViewById(R.id.account_manager);
        this.b = (TextView) moreActivity.findViewById(R.id.account_name);
        this.c.setOnClickListener(moreActivity);
        this.d = (LinearLayout) moreActivity.findViewById(R.id.person_info);
        this.e = (TextView) moreActivity.findViewById(R.id.person_info_text);
        this.d.setOnClickListener(moreActivity);
        this.j = (LinearLayout) moreActivity.findViewById(R.id.msg_remind);
        this.j.setOnClickListener(moreActivity);
        this.v = (TextView) moreActivity.findViewById(R.id.msg_remind_text);
        this.k = (LinearLayout) moreActivity.findViewById(R.id.sign_remind);
        this.k.setOnClickListener(moreActivity);
        this.w = (TextView) moreActivity.findViewById(R.id.sign_remind_text);
        this.I = (TextView) moreActivity.findViewById(R.id.sign_remind_time);
        this.l = (LinearLayout) moreActivity.findViewById(R.id.browse_setting);
        this.l.setOnClickListener(moreActivity);
        SpannableString spannableString = new SpannableString(this.a.getString(R.string.browse_setting_spannable));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.util.ab.a(this.a, 12.0f)), 6, spannableString.length(), 18);
        this.x = (TextView) moreActivity.findViewById(R.id.browse_setting_text);
        this.x.setText(spannableString);
        this.n = (LinearLayout) moreActivity.findViewById(R.id.clear_cash);
        this.n.setOnClickListener(moreActivity);
        this.F = (TextView) moreActivity.findViewById(R.id.clear_cash_text);
        this.p = (LinearLayout) moreActivity.findViewById(R.id.about_tieba);
        this.p.setOnClickListener(moreActivity);
        this.G = (TextView) moreActivity.findViewById(R.id.about_tieba_text);
        this.L = (ImageView) moreActivity.findViewById(R.id.new_version_img);
        this.u = (LinearLayout) moreActivity.findViewById(R.id.recommend_app);
        this.u.setOnClickListener(moreActivity);
        this.B = (TextView) moreActivity.findViewById(R.id.recommend_app_text);
        if (!TiebaApplication.f().x()) {
            this.u.setVisibility(8);
        } else {
            this.u.setVisibility(0);
        }
        this.q = (LinearLayout) moreActivity.findViewById(R.id.position_paper);
        this.q.setOnClickListener(moreActivity);
        this.E = (TextView) moreActivity.findViewById(R.id.position_paper_text);
        this.H = (TextView) moreActivity.findViewById(R.id.frequency_time);
        this.A = (TextView) moreActivity.findViewById(R.id.image_quality_text);
        this.J = (TextView) moreActivity.findViewById(R.id.text_upload_image_quality);
        this.m = (LinearLayout) moreActivity.findViewById(R.id.share_location_layout);
        this.m.setClickable(false);
        this.D = (TextView) moreActivity.findViewById(R.id.share_location_text);
        this.O = (BdSwitchView) moreActivity.findViewById(R.id.share_location_switch);
        this.O.setOnSwitchStateChangeListener(moreActivity);
        this.r = (LinearLayout) moreActivity.findViewById(R.id.eyeshield_mode);
        this.r.setClickable(false);
        this.z = (TextView) moreActivity.findViewById(R.id.eyeshield_mode_text);
        this.N = (BdSwitchView) moreActivity.findViewById(R.id.eyeshield_mode_switch);
        this.N.setOnSwitchStateChangeListener(moreActivity);
        this.t = (LinearLayout) moreActivity.findViewById(R.id.promoted_message);
        this.t.setClickable(false);
        this.C = (TextView) moreActivity.findViewById(R.id.promoted_message_text);
        this.P = (BdSwitchView) moreActivity.findViewById(R.id.promoted_message_switch);
        this.P.setOnSwitchStateChangeListener(moreActivity);
        this.s = (LinearLayout) moreActivity.findViewById(R.id.abstract_selection);
        this.s.setClickable(false);
        this.M = (BdSwitchView) moreActivity.findViewById(R.id.abstract_state_switch);
        this.M.setOnSwitchStateChangeListener(moreActivity);
        this.y = (TextView) moreActivity.findViewById(R.id.abstract_text);
        this.o = (LinearLayout) moreActivity.findViewById(R.id.upload_image_quality);
        this.o.setOnClickListener(new aa(this));
    }

    public ImageView a() {
        return this.h;
    }

    public LinearLayout b() {
        return this.c;
    }

    public LinearLayout c() {
        return this.d;
    }

    public LinearLayout d() {
        return this.j;
    }

    public LinearLayout e() {
        return this.k;
    }

    public LinearLayout f() {
        return this.l;
    }

    public LinearLayout g() {
        return this.n;
    }

    public LinearLayout h() {
        return this.p;
    }

    public LinearLayout i() {
        return this.q;
    }

    public LinearLayout j() {
        return this.u;
    }

    public BdSwitchView k() {
        return this.M;
    }

    public BdSwitchView l() {
        return this.N;
    }

    public BdSwitchView m() {
        return this.O;
    }

    public BdSwitchView n() {
        return this.P;
    }

    public void o() {
        v();
        w();
        C();
        D();
        x();
        y();
        E();
        u();
        z();
    }

    public void p() {
        ((com.baidu.tieba.g) this.a).b(this.a.getString(R.string.deleting));
    }

    public void q() {
        ((com.baidu.tieba.g) this.a).h();
    }

    public void r() {
        this.c.setFocusable(false);
        this.c.setClickable(false);
        this.b.setText(TiebaApplication.H());
    }

    public void s() {
        this.b.setText(R.string.putin_account);
        this.c.setOnClickListener((com.baidu.tieba.g) this.a);
    }

    public void t() {
        ((ImageView) ((com.baidu.tieba.g) this.a).findViewById(R.id.arrow)).setVisibility(8);
    }

    public void u() {
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
    }

    public void v() {
        if (TiebaApplication.f().R() <= 0) {
            this.H.setText(R.string.close);
        } else if (TiebaApplication.f().R() == 30) {
            this.H.setText(R.string._30_second);
        } else if (TiebaApplication.f().R() == 120) {
            this.H.setText(R.string.tow_minute);
        } else {
            this.H.setText(R.string.five_minute);
        }
    }

    public void w() {
        TiebaApplication f = TiebaApplication.f();
        if (f.ai()) {
            this.I.setText(this.a.getString(R.string.sign_remind_time, f.aj() > 9 ? String.valueOf(f.aj()) : "0" + f.aj(), f.ak() > 9 ? String.valueOf(f.ak()) : "0" + f.ak()));
        } else {
            this.I.setText(R.string.close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        switch (TiebaApplication.f().an()) {
            case 1:
                this.J.setText(this.a.getString(R.string.image_quality_high));
                return;
            case 2:
                this.J.setText(this.a.getString(R.string.image_quality_mid));
                return;
            case 3:
                this.J.setText(this.a.getString(R.string.image_quality_low));
                return;
            default:
                return;
        }
    }

    private void D() {
        if (TiebaApplication.f().T()) {
            this.P.a();
        } else {
            this.P.b();
        }
    }

    public void x() {
        if (TiebaApplication.f().ar()) {
            this.M.a();
        } else {
            this.M.b();
        }
    }

    public void y() {
        if (TiebaApplication.f().at() == 1) {
            this.N.a();
        } else {
            this.N.b();
        }
    }

    private void E() {
        if (TiebaApplication.f().u()) {
            this.O.a();
        } else {
            this.O.b();
        }
    }

    public void z() {
        if (TiebaApplication.aT()) {
            this.L.setVisibility(0);
        } else {
            this.L.setVisibility(8);
        }
    }

    public void a(int i) {
        ImageView imageView = (ImageView) this.c.findViewById(R.id.arrow);
        ImageView imageView2 = (ImageView) this.d.findViewById(R.id.arrow1);
        ImageView imageView3 = (ImageView) this.j.findViewById(R.id.arrow2);
        ImageView imageView4 = (ImageView) this.l.findViewById(R.id.arrow3);
        ImageView imageView5 = (ImageView) this.u.findViewById(R.id.arrow4);
        ImageView imageView6 = (ImageView) this.q.findViewById(R.id.arrow5);
        ImageView imageView7 = (ImageView) this.p.findViewById(R.id.arrow6);
        ImageView imageView8 = (ImageView) this.k.findViewById(R.id.arrow7);
        com.baidu.tieba.util.x.a(this.h, i);
        com.baidu.tieba.util.x.d(this.g, i);
        com.baidu.tieba.util.x.f(this.i, i);
        com.baidu.tieba.util.x.b(this.f, i);
        if (i == 1) {
            if (this.d.getVisibility() == 0) {
                com.baidu.tieba.util.x.h(this.c, (int) R.drawable.more_up_1);
            } else {
                com.baidu.tieba.util.x.h(this.c, (int) R.drawable.more_all_1);
            }
            com.baidu.tieba.util.x.h(this.d, (int) R.drawable.more_down_1);
            com.baidu.tieba.util.x.h(this.j, (int) R.drawable.more_up_1);
            com.baidu.tieba.util.x.h(this.k, (int) R.drawable.more_down_1);
            com.baidu.tieba.util.x.h(this.l, (int) R.drawable.more_up_1);
            com.baidu.tieba.util.x.h(this.s, (int) R.drawable.more_middle_1);
            com.baidu.tieba.util.x.h(this.r, (int) R.drawable.more_middle_1);
            com.baidu.tieba.util.x.h(this.o, (int) R.drawable.more_down_1);
            com.baidu.tieba.util.x.h(this.u, (int) R.drawable.more_all_1);
            com.baidu.tieba.util.x.h(this.t, (int) R.drawable.more_up_1);
            com.baidu.tieba.util.x.h(this.m, (int) R.drawable.more_down_1);
            com.baidu.tieba.util.x.h(this.q, (int) R.drawable.more_up_1);
            com.baidu.tieba.util.x.h(this.n, (int) R.drawable.more_middle_1);
            com.baidu.tieba.util.x.h(this.p, (int) R.drawable.more_down_1);
            this.M.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
            this.N.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
            this.O.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
            this.P.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
            imageView.setImageResource(R.drawable.icon_arrow_right_1);
            imageView2.setImageResource(R.drawable.icon_arrow_right_1);
            imageView3.setImageResource(R.drawable.icon_arrow_right_1);
            imageView4.setImageResource(R.drawable.icon_arrow_right_1);
            imageView5.setImageResource(R.drawable.icon_arrow_right_1);
            imageView6.setImageResource(R.drawable.icon_arrow_right_1);
            imageView7.setImageResource(R.drawable.icon_arrow_right_1);
            imageView8.setImageResource(R.drawable.icon_arrow_right_1);
            this.H.setTextColor(-11446171);
            this.I.setTextColor(-11446171);
            this.J.setTextColor(-11446171);
        } else {
            if (this.d.getVisibility() == 0) {
                com.baidu.tieba.util.x.h(this.c, (int) R.drawable.more_up);
            } else {
                com.baidu.tieba.util.x.h(this.c, (int) R.drawable.more_all);
            }
            com.baidu.tieba.util.x.h(this.d, (int) R.drawable.more_down);
            com.baidu.tieba.util.x.h(this.j, (int) R.drawable.more_up);
            com.baidu.tieba.util.x.h(this.k, (int) R.drawable.more_down);
            com.baidu.tieba.util.x.h(this.l, (int) R.drawable.more_up);
            com.baidu.tieba.util.x.h(this.s, (int) R.drawable.more_middle);
            com.baidu.tieba.util.x.h(this.r, (int) R.drawable.more_middle);
            com.baidu.tieba.util.x.h(this.o, (int) R.drawable.more_down);
            com.baidu.tieba.util.x.h(this.u, (int) R.drawable.more_all);
            com.baidu.tieba.util.x.h(this.t, (int) R.drawable.more_up);
            com.baidu.tieba.util.x.h(this.m, (int) R.drawable.more_down);
            com.baidu.tieba.util.x.h(this.q, (int) R.drawable.more_up);
            com.baidu.tieba.util.x.h(this.n, (int) R.drawable.more_middle);
            com.baidu.tieba.util.x.h(this.p, (int) R.drawable.more_down);
            this.M.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
            this.N.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
            this.O.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
            this.P.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
            imageView.setImageResource(R.drawable.icon_arrow_right);
            imageView2.setImageResource(R.drawable.icon_arrow_right);
            imageView3.setImageResource(R.drawable.icon_arrow_right);
            imageView4.setImageResource(R.drawable.icon_arrow_right);
            imageView5.setImageResource(R.drawable.icon_arrow_right);
            imageView6.setImageResource(R.drawable.icon_arrow_right);
            imageView7.setImageResource(R.drawable.icon_arrow_right);
            imageView8.setImageResource(R.drawable.icon_arrow_right);
            this.H.setTextColor(-5065030);
            this.I.setTextColor(-5065030);
            this.J.setTextColor(-5065030);
        }
        a(this.b, i);
        a(this.e, i);
        a(this.v, i);
        a(this.w, i);
        a(this.x, i);
        a(this.y, i);
        a(this.z, i);
        a(this.A, i);
        a(this.B, i);
        a(this.C, i);
        a(this.D, i);
        a(this.E, i);
        a(this.F, i);
        a(this.G, i);
    }

    public void a(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                textView.setTextColor(this.a.getResources().getColor(R.color.skin_1_common_color));
            } else {
                textView.setTextColor(this.a.getResources().getColor(R.color.more_color));
            }
        }
    }

    public void A() {
        this.c.setBackgroundResource(0);
        this.d.setBackgroundResource(0);
        this.j.setBackgroundResource(0);
        this.l.setBackgroundResource(0);
        this.s.setBackgroundResource(0);
        this.r.setBackgroundResource(0);
        this.o.setBackgroundResource(0);
        this.u.setBackgroundResource(0);
        this.t.setBackgroundResource(0);
        this.m.setBackgroundResource(0);
        this.q.setBackgroundResource(0);
        this.n.setBackgroundResource(0);
        this.p.setBackgroundResource(0);
    }

    public void B() {
        if (this.K != null) {
            this.K.dismiss();
        }
    }
}
