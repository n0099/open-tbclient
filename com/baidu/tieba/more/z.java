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
    private AlertDialog H;
    private ImageView I;
    private BdSwitchView J;
    private BdSwitchView K;
    private BdSwitchView L;
    private BdSwitchView M;
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
    private TextView u;
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
        this.u = (TextView) moreActivity.findViewById(R.id.msg_remind_text);
        this.k = (LinearLayout) moreActivity.findViewById(R.id.browse_setting);
        this.k.setOnClickListener(moreActivity);
        SpannableString spannableString = new SpannableString(this.a.getString(R.string.browse_setting_spannable));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.d.ag.a(this.a, 12.0f)), 6, spannableString.length(), 18);
        this.v = (TextView) moreActivity.findViewById(R.id.browse_setting_text);
        this.v.setText(spannableString);
        this.m = (LinearLayout) moreActivity.findViewById(R.id.clear_cash);
        this.m.setOnClickListener(moreActivity);
        this.D = (TextView) moreActivity.findViewById(R.id.clear_cash_text);
        this.o = (LinearLayout) moreActivity.findViewById(R.id.about_tieba);
        this.o.setOnClickListener(moreActivity);
        this.E = (TextView) moreActivity.findViewById(R.id.about_tieba_text);
        this.I = (ImageView) moreActivity.findViewById(R.id.new_version_img);
        this.t = (LinearLayout) moreActivity.findViewById(R.id.recommend_app);
        this.t.setOnClickListener(moreActivity);
        this.z = (TextView) moreActivity.findViewById(R.id.recommend_app_text);
        if (!TiebaApplication.d().r()) {
            this.t.setVisibility(8);
        } else {
            this.t.setVisibility(0);
        }
        this.p = (LinearLayout) moreActivity.findViewById(R.id.position_paper);
        this.p.setOnClickListener(moreActivity);
        this.C = (TextView) moreActivity.findViewById(R.id.position_paper_text);
        this.F = (TextView) moreActivity.findViewById(R.id.frequency_time);
        this.y = (TextView) moreActivity.findViewById(R.id.image_quality_text);
        this.G = (TextView) moreActivity.findViewById(R.id.text_upload_image_quality);
        this.l = (LinearLayout) moreActivity.findViewById(R.id.share_location_layout);
        this.l.setClickable(false);
        this.B = (TextView) moreActivity.findViewById(R.id.share_location_text);
        this.L = (BdSwitchView) moreActivity.findViewById(R.id.share_location_switch);
        this.L.setOnSwitchStateChangeListener(moreActivity);
        this.q = (LinearLayout) moreActivity.findViewById(R.id.eyeshield_mode);
        this.q.setClickable(false);
        this.x = (TextView) moreActivity.findViewById(R.id.eyeshield_mode_text);
        this.K = (BdSwitchView) moreActivity.findViewById(R.id.eyeshield_mode_switch);
        this.K.setOnSwitchStateChangeListener(moreActivity);
        this.s = (LinearLayout) moreActivity.findViewById(R.id.promoted_message);
        this.s.setClickable(false);
        this.A = (TextView) moreActivity.findViewById(R.id.promoted_message_text);
        this.M = (BdSwitchView) moreActivity.findViewById(R.id.promoted_message_switch);
        this.M.setOnSwitchStateChangeListener(moreActivity);
        this.r = (LinearLayout) moreActivity.findViewById(R.id.abstract_selection);
        this.r.setClickable(false);
        this.J = (BdSwitchView) moreActivity.findViewById(R.id.abstract_state_switch);
        this.J.setOnSwitchStateChangeListener(moreActivity);
        this.w = (TextView) moreActivity.findViewById(R.id.abstract_text);
        this.n = (LinearLayout) moreActivity.findViewById(R.id.upload_image_quality);
        this.n.setOnClickListener(new aa(this));
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
        return this.m;
    }

    public LinearLayout g() {
        return this.o;
    }

    public LinearLayout h() {
        return this.p;
    }

    public LinearLayout i() {
        return this.t;
    }

    public BdSwitchView j() {
        return this.J;
    }

    public BdSwitchView k() {
        return this.K;
    }

    public BdSwitchView l() {
        return this.L;
    }

    public BdSwitchView m() {
        return this.M;
    }

    public void n() {
        u();
        A();
        B();
        v();
        w();
        C();
        t();
        x();
    }

    public void o() {
        ((com.baidu.tieba.e) this.a).b(this.a.getString(R.string.deleting));
    }

    public void p() {
        ((com.baidu.tieba.e) this.a).h();
    }

    public void q() {
        this.c.setFocusable(false);
        this.c.setClickable(false);
        this.b.setText(TiebaApplication.D());
    }

    public void r() {
        this.b.setText(R.string.putin_account);
        this.c.setOnClickListener((com.baidu.tieba.e) this.a);
    }

    public void s() {
        ((ImageView) ((com.baidu.tieba.e) this.a).findViewById(R.id.arrow)).setVisibility(8);
    }

    public void t() {
        String z = TiebaApplication.z();
        if (z == null || z.length() <= 0) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
    }

    public void u() {
        if (TiebaApplication.d().N() <= 0) {
            this.F.setText(R.string.close);
        } else if (TiebaApplication.d().N() == 30) {
            this.F.setText(R.string._30_second);
        } else if (TiebaApplication.d().N() == 120) {
            this.F.setText(R.string.tow_minute);
        } else {
            this.F.setText(R.string.five_minute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        switch (TiebaApplication.d().ad()) {
            case 1:
                this.G.setText(this.a.getString(R.string.image_quality_high));
                return;
            case 2:
                this.G.setText(this.a.getString(R.string.image_quality_mid));
                return;
            case 3:
                this.G.setText(this.a.getString(R.string.image_quality_low));
                return;
            default:
                return;
        }
    }

    private void B() {
        if (TiebaApplication.d().P()) {
            this.M.a();
        } else {
            this.M.b();
        }
    }

    public void v() {
        if (TiebaApplication.d().ah()) {
            this.J.a();
        } else {
            this.J.b();
        }
    }

    public void w() {
        if (TiebaApplication.d().ai() == 1) {
            this.K.a();
        } else {
            this.K.b();
        }
    }

    private void C() {
        if (TiebaApplication.d().o()) {
            this.L.a();
        } else {
            this.L.b();
        }
    }

    public void x() {
        if (TiebaApplication.aH()) {
            this.I.setVisibility(0);
        } else {
            this.I.setVisibility(8);
        }
    }

    public void a(int i) {
        ImageView imageView = (ImageView) this.c.findViewById(R.id.arrow);
        ImageView imageView2 = (ImageView) this.d.findViewById(R.id.arrow1);
        ImageView imageView3 = (ImageView) this.j.findViewById(R.id.arrow2);
        ImageView imageView4 = (ImageView) this.k.findViewById(R.id.arrow3);
        ImageView imageView5 = (ImageView) this.t.findViewById(R.id.arrow4);
        ImageView imageView6 = (ImageView) this.p.findViewById(R.id.arrow5);
        ImageView imageView7 = (ImageView) this.o.findViewById(R.id.arrow6);
        com.baidu.tieba.d.ac.a(this.h, i);
        com.baidu.tieba.d.ac.d(this.g, i);
        com.baidu.tieba.d.ac.f(this.i, i);
        com.baidu.tieba.d.ac.b(this.f, i);
        if (i == 1) {
            if (this.d.getVisibility() == 0) {
                com.baidu.tieba.d.ac.h(this.c, (int) R.drawable.more_up_1);
            } else {
                com.baidu.tieba.d.ac.h(this.c, (int) R.drawable.more_all_1);
            }
            com.baidu.tieba.d.ac.h(this.d, (int) R.drawable.more_down_1);
            com.baidu.tieba.d.ac.h(this.j, (int) R.drawable.more_all_1);
            com.baidu.tieba.d.ac.h(this.k, (int) R.drawable.more_up_1);
            com.baidu.tieba.d.ac.h(this.r, (int) R.drawable.more_middle_1);
            com.baidu.tieba.d.ac.h(this.q, (int) R.drawable.more_middle_1);
            com.baidu.tieba.d.ac.h(this.n, (int) R.drawable.more_down_1);
            com.baidu.tieba.d.ac.h(this.t, (int) R.drawable.more_all_1);
            com.baidu.tieba.d.ac.h(this.s, (int) R.drawable.more_up_1);
            com.baidu.tieba.d.ac.h(this.l, (int) R.drawable.more_down_1);
            com.baidu.tieba.d.ac.h(this.p, (int) R.drawable.more_up_1);
            com.baidu.tieba.d.ac.h(this.m, (int) R.drawable.more_middle_1);
            com.baidu.tieba.d.ac.h(this.o, (int) R.drawable.more_down_1);
            this.J.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.NIGHT);
            this.K.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.NIGHT);
            this.L.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.NIGHT);
            this.M.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.NIGHT);
            imageView.setImageResource(R.drawable.icon_arrow_right_1);
            imageView2.setImageResource(R.drawable.icon_arrow_right_1);
            imageView3.setImageResource(R.drawable.icon_arrow_right_1);
            imageView4.setImageResource(R.drawable.icon_arrow_right_1);
            imageView5.setImageResource(R.drawable.icon_arrow_right_1);
            imageView6.setImageResource(R.drawable.icon_arrow_right_1);
            imageView7.setImageResource(R.drawable.icon_arrow_right_1);
            this.F.setTextColor(-11446171);
            this.G.setTextColor(-11446171);
        } else {
            if (this.d.getVisibility() == 0) {
                com.baidu.tieba.d.ac.h(this.c, (int) R.drawable.more_up);
            } else {
                com.baidu.tieba.d.ac.h(this.c, (int) R.drawable.more_all);
            }
            com.baidu.tieba.d.ac.h(this.d, (int) R.drawable.more_down);
            com.baidu.tieba.d.ac.h(this.j, (int) R.drawable.more_all);
            com.baidu.tieba.d.ac.h(this.k, (int) R.drawable.more_up);
            com.baidu.tieba.d.ac.h(this.r, (int) R.drawable.more_middle);
            com.baidu.tieba.d.ac.h(this.q, (int) R.drawable.more_middle);
            com.baidu.tieba.d.ac.h(this.n, (int) R.drawable.more_down);
            com.baidu.tieba.d.ac.h(this.t, (int) R.drawable.more_all);
            com.baidu.tieba.d.ac.h(this.s, (int) R.drawable.more_up);
            com.baidu.tieba.d.ac.h(this.l, (int) R.drawable.more_down);
            com.baidu.tieba.d.ac.h(this.p, (int) R.drawable.more_up);
            com.baidu.tieba.d.ac.h(this.m, (int) R.drawable.more_middle);
            com.baidu.tieba.d.ac.h(this.o, (int) R.drawable.more_down);
            this.J.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.DAY);
            this.K.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.DAY);
            this.L.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.DAY);
            this.M.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.DAY);
            imageView.setImageResource(R.drawable.icon_arrow_right);
            imageView2.setImageResource(R.drawable.icon_arrow_right);
            imageView3.setImageResource(R.drawable.icon_arrow_right);
            imageView4.setImageResource(R.drawable.icon_arrow_right);
            imageView5.setImageResource(R.drawable.icon_arrow_right);
            imageView6.setImageResource(R.drawable.icon_arrow_right);
            imageView7.setImageResource(R.drawable.icon_arrow_right);
            this.F.setTextColor(-5065030);
            this.G.setTextColor(-5065030);
        }
        a(this.b, i);
        a(this.e, i);
        a(this.u, i);
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

    public void y() {
        this.c.setBackgroundResource(0);
        this.d.setBackgroundResource(0);
        this.j.setBackgroundResource(0);
        this.k.setBackgroundResource(0);
        this.r.setBackgroundResource(0);
        this.q.setBackgroundResource(0);
        this.n.setBackgroundResource(0);
        this.t.setBackgroundResource(0);
        this.s.setBackgroundResource(0);
        this.l.setBackgroundResource(0);
        this.p.setBackgroundResource(0);
        this.m.setBackgroundResource(0);
        this.o.setBackgroundResource(0);
    }

    public void z() {
        if (this.H != null) {
            this.H.dismiss();
        }
    }
}
