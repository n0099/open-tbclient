package com.baidu.tieba.person;

import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.bn;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.a.d {
    private TextView A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private LinearLayout G;
    private TextView H;
    private ImageView I;
    private TextView J;
    private TextView K;
    private ImageView L;
    private TextView M;
    private ImageView N;
    private TextView O;
    private TextView P;
    private ImageView Q;
    private TextView R;
    private TextView S;
    private ImageView T;
    private TextView U;
    private ImageView V;
    private TextView W;
    private TextView X;
    private LinearLayout Y;
    private Button Z;
    private Button aa;
    private ImageView ab;
    private TextView ac;
    PersonInfoActivity b;
    private ImageView c;
    private ImageView d;
    private FrameLayout e;
    private TextView f;
    private ImageView g;
    private TextView h;
    private ImageView i;
    private ImageView j;
    private LinearLayout k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private Button p;
    private LinearLayout q;
    private LinearLayout r;
    private TextView s;
    private BdPullRefreshScrollView t;
    private com.baidu.tieba.view.aa u;
    private FrameLayout v;
    private ProgressBar w;
    private ProgressBar x;
    private LinearLayout y;
    private LinearLayout z;

    public bb(PersonInfoActivity personInfoActivity, bn bnVar) {
        super(personInfoActivity);
        this.b = null;
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
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
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
        this.b = personInfoActivity;
        personInfoActivity.setContentView(R.layout.person_info_activity);
        this.w = (ProgressBar) personInfoActivity.findViewById(R.id.progress);
        this.x = (ProgressBar) personInfoActivity.findViewById(R.id.attention_progress);
        this.q = (LinearLayout) personInfoActivity.findViewById(R.id.parent);
        this.r = (LinearLayout) personInfoActivity.findViewById(R.id.title);
        this.t = (BdPullRefreshScrollView) personInfoActivity.findViewById(R.id.scrollview);
        this.u = new com.baidu.tieba.view.aa(personInfoActivity);
        this.t.setCustomHeaderView(this.u);
        this.v = (FrameLayout) personInfoActivity.findViewById(R.id.info);
        this.s = (TextView) personInfoActivity.findViewById(R.id.titel_text);
        this.d = (ImageView) personInfoActivity.findViewById(R.id.photo);
        this.e = (FrameLayout) personInfoActivity.findViewById(R.id.photo_frame);
        this.c = (ImageView) personInfoActivity.findViewById(R.id.back);
        this.c.setOnClickListener(personInfoActivity);
        this.o = (ImageView) personInfoActivity.findViewById(R.id.home);
        this.o.setOnClickListener(personInfoActivity);
        this.p = (Button) personInfoActivity.findViewById(R.id.settings);
        this.p.setOnClickListener(personInfoActivity);
        this.y = (LinearLayout) personInfoActivity.findViewById(R.id.person_info_view);
        this.T = (ImageView) personInfoActivity.findViewById(R.id.my_msg_image);
        this.S = (TextView) personInfoActivity.findViewById(R.id.my_msg_text);
        this.I = (ImageView) personInfoActivity.findViewById(R.id.bookmark_image);
        this.H = (TextView) personInfoActivity.findViewById(R.id.bookmark_text);
        this.J = (TextView) personInfoActivity.findViewById(R.id.likes_text);
        this.L = (ImageView) personInfoActivity.findViewById(R.id.likes_image);
        this.M = (TextView) personInfoActivity.findViewById(R.id.my_attention_text);
        this.N = (ImageView) personInfoActivity.findViewById(R.id.attention_image);
        this.P = (TextView) personInfoActivity.findViewById(R.id.fans_text);
        this.Q = (ImageView) personInfoActivity.findViewById(R.id.fans_image);
        this.B = (LinearLayout) personInfoActivity.findViewById(R.id.button_mention);
        this.C = (LinearLayout) personInfoActivity.findViewById(R.id.button_bookmark);
        this.D = (LinearLayout) personInfoActivity.findViewById(R.id.button_likes);
        this.E = (LinearLayout) personInfoActivity.findViewById(R.id.button_attention);
        this.F = (LinearLayout) personInfoActivity.findViewById(R.id.button_fans);
        this.G = (LinearLayout) personInfoActivity.findViewById(R.id.button_mypost);
        this.U = (TextView) personInfoActivity.findViewById(R.id.my_post_text);
        this.V = (ImageView) personInfoActivity.findViewById(R.id.my_post_image);
        this.W = (TextView) personInfoActivity.findViewById(R.id.new_fans_count);
        this.X = (TextView) personInfoActivity.findViewById(R.id.new_mention_count);
        this.K = (TextView) personInfoActivity.findViewById(R.id.likes_num);
        this.O = (TextView) personInfoActivity.findViewById(R.id.attention_num);
        this.R = (TextView) personInfoActivity.findViewById(R.id.fans_num);
        int a2 = com.baidu.tieba.util.am.a((Context) personInfoActivity);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.X.getLayoutParams();
        layoutParams.topMargin = com.baidu.tieba.util.am.a((Context) personInfoActivity, 8.0f);
        layoutParams.rightMargin = (a2 / 6) - com.baidu.tieba.util.am.a((Context) personInfoActivity, 30.0f);
        this.X.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.W.getLayoutParams();
        layoutParams2.topMargin = com.baidu.tieba.util.am.a((Context) personInfoActivity, 8.0f);
        layoutParams2.rightMargin = (a2 / 6) - com.baidu.tieba.util.am.a((Context) personInfoActivity, 30.0f);
        this.W.setLayoutParams(layoutParams2);
        this.B.setOnClickListener(personInfoActivity);
        this.C.setOnClickListener(personInfoActivity);
        this.D.setOnClickListener(personInfoActivity);
        this.E.setOnClickListener(personInfoActivity);
        this.F.setOnClickListener(personInfoActivity);
        this.G.setOnClickListener(personInfoActivity);
        this.f = (TextView) personInfoActivity.findViewById(R.id.name);
        this.g = (ImageView) personInfoActivity.findViewById(R.id.sex);
        this.h = (TextView) personInfoActivity.findViewById(R.id.intro);
        this.z = (LinearLayout) personInfoActivity.findViewById(R.id.attention);
        this.A = (TextView) personInfoActivity.findViewById(R.id.attention_text);
        this.z.setOnClickListener(personInfoActivity);
        this.i = (ImageView) personInfoActivity.findViewById(R.id.background_bottom);
        this.j = (ImageView) personInfoActivity.findViewById(R.id.background_image);
        this.k = (LinearLayout) personInfoActivity.findViewById(R.id.btn_chat);
        this.l = (ImageView) personInfoActivity.findViewById(R.id.chat_icon);
        this.m = (TextView) personInfoActivity.findViewById(R.id.chat_text);
        this.n = (TextView) personInfoActivity.findViewById(R.id.chat_num);
        this.k.setOnClickListener(personInfoActivity);
        this.Y = (LinearLayout) personInfoActivity.findViewById(R.id.not_login_view);
        this.ab = (ImageView) personInfoActivity.findViewById(R.id.not_login_img);
        this.ac = (TextView) personInfoActivity.findViewById(R.id.not_login_text);
        this.Z = (Button) personInfoActivity.findViewById(R.id.login_btn);
        this.Z.setOnClickListener(personInfoActivity);
        this.aa = (Button) personInfoActivity.findViewById(R.id.reg_btn);
        this.aa.setOnClickListener(personInfoActivity);
        a(bnVar);
    }

    public void a(bn bnVar) {
        if (bnVar.a() == null || bnVar.a().length() < 0) {
            this.y.setVisibility(8);
            this.Y.setVisibility(0);
        } else {
            this.y.setVisibility(0);
            this.Y.setVisibility(8);
        }
        b(bnVar);
        d(bnVar);
        c(bnVar);
        i(bnVar);
        e(bnVar);
    }

    public void b(bn bnVar) {
        if (bnVar.a() == null || bnVar.a().length() < 0) {
            this.s.setText(R.string.person_info);
            this.p.setVisibility(0);
            this.o.setVisibility(8);
            this.c.setVisibility(4);
        } else if (bnVar.b()) {
            this.s.setText(R.string.person_info);
            if (bnVar.l()) {
                this.c.setVisibility(4);
                this.o.setVisibility(8);
                this.p.setVisibility(0);
            } else if (bnVar.m()) {
                this.c.setVisibility(0);
                this.o.setVisibility(8);
                this.p.setVisibility(0);
            } else {
                this.c.setVisibility(0);
                this.o.setVisibility(0);
                this.p.setVisibility(8);
            }
        } else {
            if (bnVar.c() == null) {
                this.s.setText(bnVar.f());
            } else {
                this.s.setText(bnVar.c().getName_show());
            }
            this.c.setVisibility(0);
            this.o.setVisibility(0);
            this.p.setVisibility(8);
        }
    }

    public void c(bn bnVar) {
        if (bnVar.a() != null && bnVar.a().length() > 0) {
            this.k.setVisibility(0);
            if (bnVar.b()) {
                if (TiebaApplication.f().au() == 1) {
                    this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_lately_1));
                } else {
                    this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_lately));
                }
                this.m.setText(R.string.my_chat);
                long h = bnVar.h();
                if (h > 0) {
                    this.n.setVisibility(0);
                    this.n.setText(String.valueOf(h));
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            if (TiebaApplication.f().au() == 1) {
                this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_chat_1));
            } else {
                this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_chat));
            }
            this.m.setText(R.string.chat_with_it);
            this.n.setVisibility(8);
            return;
        }
        this.k.setVisibility(8);
    }

    public void d(bn bnVar) {
        if (bnVar.a() != null && bnVar.a().length() > 0) {
            if (bnVar.c() == null) {
                this.f.setText(bnVar.f());
                return;
            }
            this.f.setText(bnVar.c().getName_show());
            if (bnVar.c().getSex() == 1) {
                this.g.setImageResource(R.drawable.cent_icon_boy_n);
            } else if (bnVar.c().getSex() == 2) {
                this.g.setImageResource(R.drawable.cent_icon_girl_n);
            }
            this.h.setText(bnVar.c().getIntro());
        }
    }

    private void i(bn bnVar) {
        this.z.setVisibility(8);
        if (bnVar.a() != null && bnVar.a().length() > 0 && !bnVar.b() && bnVar.c() != null) {
            this.z.setVisibility(0);
            if (bnVar.c().getHave_attention() == 1) {
                this.z.setBackgroundResource(R.drawable.attention_cancel);
                this.A.setText(R.string.attention_cancel);
                return;
            }
            this.z.setBackgroundResource(R.drawable.attention);
            this.A.setText(R.string.attention);
        }
    }

    public void e(bn bnVar) {
        if (bnVar.a() != null && bnVar.a().length() > 0) {
            if (bnVar.b()) {
                this.B.setVisibility(0);
                this.C.setVisibility(0);
                this.U.setText(R.string.my_post);
                this.J.setText(R.string.my_like_forums);
                this.M.setText(R.string.my_attention);
                this.P.setText(R.string.my_fans);
                long j = bnVar.j();
                if (j > 0) {
                    this.X.setVisibility(0);
                    if (j > 99) {
                        this.X.setText("99+");
                    } else {
                        this.X.setText(String.valueOf(j));
                    }
                } else {
                    this.X.setVisibility(8);
                }
                long g = bnVar.g();
                if (g > 0) {
                    this.W.setVisibility(0);
                    if (g > 99) {
                        this.W.setText("99+");
                    } else {
                        this.W.setText(String.valueOf(g));
                    }
                } else {
                    this.W.setVisibility(8);
                }
            } else {
                this.B.setVisibility(4);
                this.C.setVisibility(4);
                this.U.setText(R.string.his_post);
                this.W.setVisibility(8);
                this.X.setVisibility(8);
                this.J.setText(R.string.hisbars);
                this.M.setText(R.string.his_attention);
                this.P.setText(R.string.his_fans);
            }
            if (bnVar.c() != null && bnVar.c().getLike_bars() > 0) {
                this.K.setVisibility(0);
                this.K.setText(String.valueOf(bnVar.c().getLike_bars()));
            } else {
                this.K.setVisibility(4);
            }
            if (bnVar.c() != null && bnVar.c().getConcern_num() > 0) {
                this.O.setVisibility(0);
                this.O.setText(String.valueOf(bnVar.c().getConcern_num()));
            } else {
                this.O.setVisibility(4);
            }
            if (bnVar.c() != null && bnVar.c().getFans_num() > 0) {
                this.R.setVisibility(0);
                this.R.setText(String.valueOf(bnVar.c().getFans_num()));
                return;
            }
            this.R.setVisibility(4);
        }
    }

    public void a(boolean z) {
        if (!z) {
            this.t.setMode(BdPullRefreshScrollView.Mode.DISABLED);
        } else {
            this.t.setMode(BdPullRefreshScrollView.Mode.PULL_FROM_START);
        }
    }

    public void a(com.baidu.adp.widget.ScrollView.n nVar) {
        this.t.setOnPullDownListener(nVar);
    }

    public void a(int i, bn bnVar) {
        com.baidu.tieba.util.ah.a(this.q, i);
        com.baidu.tieba.util.ah.f(this.s, i);
        com.baidu.tieba.util.ah.d(this.r, i);
        com.baidu.tieba.util.ah.g((TextView) this.p, i);
        com.baidu.tieba.util.ah.a(this.c, i);
        com.baidu.tieba.util.ah.d(this.o, i);
        a(i, this.H, (TextView) null);
        a(i, this.S, (TextView) null);
        a(i, this.U, (TextView) null);
        com.baidu.tieba.util.ah.a(this.u, i);
        this.u.a(i);
        if (i == 1) {
            com.baidu.tieba.util.ah.h(this.v, (int) R.drawable.person_seperator_1);
            this.f.setTextColor(-5524539);
            this.h.setTextColor(-8352873);
            this.B.setBackgroundResource(R.drawable.person_button_1);
            this.C.setBackgroundResource(R.drawable.person_button_1);
            this.D.setBackgroundResource(R.drawable.person_button_1);
            this.E.setBackgroundResource(R.drawable.person_button_1);
            this.F.setBackgroundResource(R.drawable.person_button_1);
            this.G.setBackgroundResource(R.drawable.person_button_1);
            this.L.setImageResource(R.drawable.icon_my_like_ba_1);
            this.N.setImageResource(R.drawable.icon_my_attention_1);
            this.Q.setImageResource(R.drawable.icon_my_fass_1);
            this.I.setImageResource(R.drawable.icon_my_collect_1);
            this.T.setImageResource(R.drawable.icon_my_news_1);
            this.V.setImageResource(R.drawable.icon_my_post_1);
            this.J.setTextColor(-10523526);
            this.M.setTextColor(-10523526);
            this.H.setTextColor(-10523526);
            this.U.setTextColor(-10523526);
            this.S.setTextColor(-10523526);
            this.P.setTextColor(-10523526);
            this.i.setBackgroundColor(-13618114);
            this.e.setForeground(this.b.getResources().getDrawable(R.drawable.pic_bj_touxiang_n_1));
            this.ac.setTextColor(-11446171);
            this.Z.setBackgroundResource(R.drawable.btn_blue_square_1);
            this.aa.setBackgroundResource(R.drawable.btn_w_square_1);
            this.Z.setTextColor(-5454368);
            this.aa.setTextColor(-9207399);
            this.A.setTextColor(-8682095);
            this.ab.setImageResource(R.drawable.pic_inset_login_1);
            com.baidu.tieba.util.ah.h(this.k, (int) R.drawable.btn_blue_bg_selector_1);
            if (bnVar.b()) {
                this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_lately_1));
            } else {
                this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_chat_1));
            }
            this.m.setTextColor(-6900265);
            this.n.setTextColor(-5584160);
            this.K.setTextColor(-8352873);
            this.R.setTextColor(-8352873);
            this.O.setTextColor(-8352873);
        } else {
            com.baidu.tieba.util.ah.h(this.v, (int) R.drawable.person_seperator);
            this.f.setTextColor(-1);
            this.h.setTextColor(-4802890);
            this.B.setBackgroundResource(R.drawable.person_button);
            this.C.setBackgroundResource(R.drawable.person_button);
            this.D.setBackgroundResource(R.drawable.person_button);
            this.E.setBackgroundResource(R.drawable.person_button);
            this.F.setBackgroundResource(R.drawable.person_button);
            this.G.setBackgroundResource(R.drawable.person_button);
            this.L.setImageResource(R.drawable.icon_my_like_ba);
            this.N.setImageResource(R.drawable.icon_my_attention);
            this.Q.setImageResource(R.drawable.icon_my_fass);
            this.I.setImageResource(R.drawable.icon_my_collect);
            this.T.setImageResource(R.drawable.icon_my_news);
            this.V.setImageResource(R.drawable.icon_my_post);
            this.J.setTextColor(-12564913);
            this.M.setTextColor(-12564913);
            this.H.setTextColor(-12564913);
            this.U.setTextColor(-12564913);
            this.S.setTextColor(-12564913);
            this.P.setTextColor(-12564913);
            this.i.setBackgroundColor(-1644051);
            this.e.setForeground(this.b.getResources().getDrawable(R.drawable.pic_bj_touxiang_n));
            this.ac.setTextColor(-5065030);
            this.Z.setBackgroundResource(R.drawable.btn_blue_square);
            this.aa.setBackgroundResource(R.drawable.btn_w_square);
            this.Z.setTextColor(-1);
            this.aa.setTextColor(-14277082);
            this.A.setTextColor(-1);
            this.ab.setImageResource(R.drawable.pic_inset_login);
            com.baidu.tieba.util.ah.h(this.k, (int) R.drawable.btn_blue_bg_selector);
            if (bnVar.b()) {
                this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_lately));
            } else {
                this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_chat));
            }
            this.m.setTextColor(-1);
            this.n.setTextColor(-5584160);
            this.K.setTextColor(-6576974);
            this.R.setTextColor(-6576974);
            this.O.setTextColor(-6576974);
        }
        this.j.setImageResource(R.drawable.pic_banner_pic);
    }

    private void a(int i, TextView textView, TextView textView2) {
        if (i == 1) {
            if (textView != null) {
                textView.setTextColor(com.baidu.tieba.util.ah.a(i));
            }
            if (textView2 != null) {
                textView2.setTextColor(com.baidu.tieba.util.ah.c(i));
                return;
            }
            return;
        }
        if (textView != null) {
            textView.setTextColor(-14277082);
        }
        if (textView2 != null) {
            textView2.setTextColor(-7566196);
        }
    }

    public void b() {
        this.B.setBackgroundResource(0);
        this.C.setBackgroundResource(0);
        this.D.setBackgroundResource(0);
        this.E.setBackgroundResource(0);
        this.F.setBackgroundResource(0);
        this.G.setBackgroundColor(0);
        this.L.setImageResource(0);
        this.N.setImageResource(0);
        this.Q.setImageResource(0);
        this.I.setImageResource(0);
        this.T.setImageResource(0);
        this.V.setImageResource(0);
        this.ab.setImageResource(0);
        this.j.setImageDrawable(null);
    }

    public void f(bn bnVar) {
        if (bnVar.c() == null) {
            this.w.setVisibility(0);
        }
    }

    public void a(boolean z, bn bnVar, int i) {
        this.w.setVisibility(8);
        if (z) {
            a(bnVar);
            h(bnVar);
        }
        if (i == 1) {
            this.t.c();
            if (bnVar.getErrorString() != null) {
                this.b.a(bnVar.getErrorString());
            }
        }
    }

    public void g(bn bnVar) {
        if (bnVar.c() != null) {
            this.x.setVisibility(0);
        }
    }

    public void a(boolean z, bn bnVar) {
        this.x.setVisibility(8);
        if (z) {
            this.b.a(this.b.getString(R.string.success));
            i(bnVar);
        } else if (bnVar.getErrorString() != null) {
            this.b.a(bnVar.getErrorString());
        }
    }

    public void c() {
        this.d.setImageResource(R.drawable.person_photo);
    }

    public void h(bn bnVar) {
        String portrait;
        if (bnVar != null && bnVar.c() != null && (portrait = bnVar.c().getPortrait()) != null && portrait.length() > 0) {
            com.baidu.adp.widget.a.b c = bnVar.e().c(portrait);
            if (c == null) {
                bnVar.e().c(portrait, new bc(this));
            } else {
                c.b(this.d);
            }
        }
    }

    public void d() {
        if (this.w != null) {
            this.w.setVisibility(8);
        }
        if (this.x != null) {
            this.x.setVisibility(8);
        }
    }

    public ImageView e() {
        return this.c;
    }

    public ImageView f() {
        return this.o;
    }

    public LinearLayout g() {
        return this.z;
    }

    public Button h() {
        return this.p;
    }

    public LinearLayout i() {
        return this.B;
    }

    public LinearLayout j() {
        return this.C;
    }

    public LinearLayout k() {
        return this.D;
    }

    public LinearLayout l() {
        return this.E;
    }

    public LinearLayout m() {
        return this.F;
    }

    public LinearLayout n() {
        return this.G;
    }

    public Button o() {
        return this.Z;
    }

    public Button p() {
        return this.aa;
    }

    public LinearLayout q() {
        return this.k;
    }
}
