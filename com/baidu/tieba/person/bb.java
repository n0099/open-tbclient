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
    private LinearLayout H;
    private TextView I;
    private ImageView J;
    private TextView K;
    private TextView L;
    private ImageView M;
    private TextView N;
    private ImageView O;
    private TextView P;
    private TextView Q;
    private ImageView R;
    private TextView S;
    private TextView T;
    private ImageView U;
    private TextView V;
    private ImageView W;
    private TextView X;
    private TextView Y;
    private TextView Z;
    private ImageView aa;
    private LinearLayout ab;
    private Button ac;
    private Button ad;
    private ImageView ae;
    private TextView af;
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
    private com.baidu.tieba.view.w u;
    private FrameLayout v;
    private ProgressBar w;
    private ProgressBar x;
    private LinearLayout y;
    private LinearLayout z;

    public bb(PersonInfoActivity personInfoActivity, com.baidu.tieba.model.bi biVar) {
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
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.b = personInfoActivity;
        personInfoActivity.setContentView(R.layout.person_info_activity);
        this.w = (ProgressBar) personInfoActivity.findViewById(R.id.progress);
        this.x = (ProgressBar) personInfoActivity.findViewById(R.id.attention_progress);
        this.q = (LinearLayout) personInfoActivity.findViewById(R.id.parent);
        this.r = (LinearLayout) personInfoActivity.findViewById(R.id.title);
        this.t = (BdPullRefreshScrollView) personInfoActivity.findViewById(R.id.scrollview);
        this.u = new com.baidu.tieba.view.w(personInfoActivity);
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
        this.U = (ImageView) personInfoActivity.findViewById(R.id.my_msg_image);
        this.T = (TextView) personInfoActivity.findViewById(R.id.my_msg_text);
        this.J = (ImageView) personInfoActivity.findViewById(R.id.bookmark_image);
        this.I = (TextView) personInfoActivity.findViewById(R.id.bookmark_text);
        this.K = (TextView) personInfoActivity.findViewById(R.id.likes_text);
        this.M = (ImageView) personInfoActivity.findViewById(R.id.likes_image);
        this.N = (TextView) personInfoActivity.findViewById(R.id.my_attention_text);
        this.O = (ImageView) personInfoActivity.findViewById(R.id.attention_image);
        this.Q = (TextView) personInfoActivity.findViewById(R.id.fans_text);
        this.R = (ImageView) personInfoActivity.findViewById(R.id.fans_image);
        this.B = (LinearLayout) personInfoActivity.findViewById(R.id.button_mention);
        this.C = (LinearLayout) personInfoActivity.findViewById(R.id.button_bookmark);
        this.D = (LinearLayout) personInfoActivity.findViewById(R.id.button_likes);
        this.E = (LinearLayout) personInfoActivity.findViewById(R.id.button_attention);
        this.F = (LinearLayout) personInfoActivity.findViewById(R.id.button_fans);
        this.H = (LinearLayout) personInfoActivity.findViewById(R.id.button_lbs);
        this.G = (LinearLayout) personInfoActivity.findViewById(R.id.button_mypost);
        this.V = (TextView) personInfoActivity.findViewById(R.id.my_post_text);
        this.W = (ImageView) personInfoActivity.findViewById(R.id.my_post_image);
        this.X = (TextView) personInfoActivity.findViewById(R.id.new_fans_count);
        this.Y = (TextView) personInfoActivity.findViewById(R.id.new_mention_count);
        this.L = (TextView) personInfoActivity.findViewById(R.id.likes_num);
        this.P = (TextView) personInfoActivity.findViewById(R.id.attention_num);
        this.S = (TextView) personInfoActivity.findViewById(R.id.fans_num);
        int a = com.baidu.tieba.util.ab.a((Context) personInfoActivity);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Y.getLayoutParams();
        layoutParams.topMargin = com.baidu.tieba.util.ab.a(personInfoActivity, 8.0f);
        layoutParams.rightMargin = (a / 6) - com.baidu.tieba.util.ab.a(personInfoActivity, 30.0f);
        this.Y.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.X.getLayoutParams();
        layoutParams2.topMargin = com.baidu.tieba.util.ab.a(personInfoActivity, 8.0f);
        layoutParams2.rightMargin = (a / 6) - com.baidu.tieba.util.ab.a(personInfoActivity, 30.0f);
        this.X.setLayoutParams(layoutParams2);
        this.Z = (TextView) personInfoActivity.findViewById(R.id.lbs_text);
        this.aa = (ImageView) personInfoActivity.findViewById(R.id.lbs_image);
        this.B.setOnClickListener(personInfoActivity);
        this.C.setOnClickListener(personInfoActivity);
        this.H.setOnClickListener(personInfoActivity);
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
        this.ab = (LinearLayout) personInfoActivity.findViewById(R.id.not_login_view);
        this.ae = (ImageView) personInfoActivity.findViewById(R.id.not_login_img);
        this.af = (TextView) personInfoActivity.findViewById(R.id.not_login_text);
        this.ac = (Button) personInfoActivity.findViewById(R.id.login_btn);
        this.ac.setOnClickListener(personInfoActivity);
        this.ad = (Button) personInfoActivity.findViewById(R.id.reg_btn);
        this.ad.setOnClickListener(personInfoActivity);
        a(biVar);
    }

    public void a(com.baidu.tieba.model.bi biVar) {
        if (biVar.a() == null || biVar.a().length() < 0) {
            this.y.setVisibility(8);
            this.ab.setVisibility(0);
        } else {
            this.y.setVisibility(0);
            this.ab.setVisibility(8);
        }
        b(biVar);
        d(biVar);
        c(biVar);
        i(biVar);
        e(biVar);
    }

    public void b(com.baidu.tieba.model.bi biVar) {
        if (biVar.a() == null || biVar.a().length() < 0) {
            this.s.setText(R.string.person_info);
            this.p.setVisibility(0);
            this.o.setVisibility(8);
            this.c.setVisibility(4);
        } else if (biVar.b()) {
            this.s.setText(R.string.person_info);
            if (biVar.l()) {
                this.c.setVisibility(4);
                this.o.setVisibility(8);
                this.p.setVisibility(0);
            } else if (biVar.m()) {
                this.c.setVisibility(0);
                this.o.setVisibility(8);
                this.p.setVisibility(0);
            } else {
                this.c.setVisibility(0);
                this.o.setVisibility(0);
                this.p.setVisibility(8);
            }
        } else {
            if (biVar.c() == null) {
                this.s.setText(biVar.f());
            } else {
                this.s.setText(biVar.c().getName_show());
            }
            this.c.setVisibility(0);
            this.o.setVisibility(0);
            this.p.setVisibility(8);
        }
    }

    public void c(com.baidu.tieba.model.bi biVar) {
        if (biVar.a() != null && biVar.a().length() > 0) {
            this.k.setVisibility(0);
            if (biVar.b()) {
                if (TiebaApplication.f().at() == 1) {
                    this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_lately_1));
                } else {
                    this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_lately));
                }
                this.m.setText(R.string.my_chat);
                long h = biVar.h();
                if (h > 0) {
                    this.n.setVisibility(0);
                    this.n.setText(String.valueOf(h));
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            if (TiebaApplication.f().at() == 1) {
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

    public void d(com.baidu.tieba.model.bi biVar) {
        if (biVar.a() != null && biVar.a().length() > 0) {
            if (biVar.c() == null) {
                this.f.setText(biVar.f());
                return;
            }
            this.f.setText(biVar.c().getName_show());
            if (biVar.c().getSex() == 1) {
                this.g.setImageResource(R.drawable.cent_icon_boy_n);
            } else if (biVar.c().getSex() == 2) {
                this.g.setImageResource(R.drawable.cent_icon_girl_n);
            }
            this.h.setText(biVar.c().getIntro());
        }
    }

    private void i(com.baidu.tieba.model.bi biVar) {
        this.z.setVisibility(8);
        if (biVar.a() != null && biVar.a().length() > 0 && !biVar.b() && biVar.c() != null) {
            this.z.setVisibility(0);
            if (biVar.c().getHave_attention() == 1) {
                this.z.setBackgroundResource(R.drawable.attention_cancel);
                this.A.setText(R.string.attention_cancel);
                return;
            }
            this.z.setBackgroundResource(R.drawable.attention);
            this.A.setText(R.string.attention);
        }
    }

    public void e(com.baidu.tieba.model.bi biVar) {
        if (biVar.a() != null && biVar.a().length() > 0) {
            if (biVar.b()) {
                this.B.setVisibility(0);
                this.C.setVisibility(0);
                this.V.setText(R.string.my_post);
                this.K.setText(R.string.my_like_forums);
                this.N.setText(R.string.my_attention);
                this.Q.setText(R.string.my_fans);
                this.Z.setText(R.string.my_lbs_text);
                long j = biVar.j();
                if (j > 0) {
                    this.Y.setVisibility(0);
                    if (j > 99) {
                        this.Y.setText("99+");
                    } else {
                        this.Y.setText(String.valueOf(j));
                    }
                } else {
                    this.Y.setVisibility(8);
                }
                long g = biVar.g();
                if (g > 0) {
                    this.X.setVisibility(0);
                    if (g > 99) {
                        this.X.setText("99+");
                    } else {
                        this.X.setText(String.valueOf(g));
                    }
                } else {
                    this.X.setVisibility(8);
                }
            } else {
                this.B.setVisibility(4);
                this.C.setVisibility(8);
                this.V.setText(R.string.his_post);
                this.X.setVisibility(8);
                this.Y.setVisibility(8);
                this.K.setText(R.string.hisbars);
                this.N.setText(R.string.his_attention);
                this.Q.setText(R.string.his_fans);
                this.Z.setText(R.string.his_lbs_text);
            }
            if (biVar.c() != null && biVar.c().getLike_bars() > 0) {
                this.L.setVisibility(0);
                this.L.setText(String.valueOf(biVar.c().getLike_bars()));
            } else {
                this.L.setVisibility(4);
            }
            if (biVar.c() != null && biVar.c().getConcern_num() > 0) {
                this.P.setVisibility(0);
                this.P.setText(String.valueOf(biVar.c().getConcern_num()));
            } else {
                this.P.setVisibility(4);
            }
            if (biVar.c() != null && biVar.c().getFans_num() > 0) {
                this.S.setVisibility(0);
                this.S.setText(String.valueOf(biVar.c().getFans_num()));
                return;
            }
            this.S.setVisibility(4);
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

    public void a(int i, com.baidu.tieba.model.bi biVar) {
        com.baidu.tieba.util.x.a(this.q, i);
        com.baidu.tieba.util.x.f(this.s, i);
        com.baidu.tieba.util.x.d(this.r, i);
        com.baidu.tieba.util.x.g((TextView) this.p, i);
        com.baidu.tieba.util.x.a(this.c, i);
        com.baidu.tieba.util.x.d(this.o, i);
        a(i, this.I, (TextView) null);
        a(i, this.T, (TextView) null);
        a(i, this.V, (TextView) null);
        a(i, this.Z, (TextView) null);
        com.baidu.tieba.util.x.a(this.u, i);
        this.u.a(i);
        if (i == 1) {
            com.baidu.tieba.util.x.h(this.v, (int) R.drawable.person_seperator_1);
            this.f.setTextColor(-5524539);
            this.h.setTextColor(-8352873);
            this.B.setBackgroundResource(R.drawable.person_button_1);
            this.C.setBackgroundResource(R.drawable.person_button_1);
            this.D.setBackgroundResource(R.drawable.person_button_1);
            this.E.setBackgroundResource(R.drawable.person_button_1);
            this.F.setBackgroundResource(R.drawable.person_button_1);
            this.G.setBackgroundResource(R.drawable.person_button_1);
            this.H.setBackgroundResource(R.drawable.person_button_1);
            this.M.setImageResource(R.drawable.icon_my_like_ba_1);
            this.O.setImageResource(R.drawable.icon_my_attention_1);
            this.R.setImageResource(R.drawable.icon_my_fass_1);
            this.J.setImageResource(R.drawable.icon_my_collect_1);
            this.U.setImageResource(R.drawable.icon_my_news_1);
            this.W.setImageResource(R.drawable.icon_my_post_1);
            this.aa.setImageResource(R.drawable.icon_my_paste_1);
            this.K.setTextColor(-10523526);
            this.N.setTextColor(-10523526);
            this.I.setTextColor(-10523526);
            this.V.setTextColor(-10523526);
            this.T.setTextColor(-10523526);
            this.Q.setTextColor(-10523526);
            this.Z.setTextColor(-10523526);
            this.i.setBackgroundColor(-13618114);
            this.e.setForeground(this.b.getResources().getDrawable(R.drawable.pic_bj_touxiang_n_1));
            this.af.setTextColor(-11446171);
            this.ac.setBackgroundResource(R.drawable.btn_blue_square_1);
            this.ad.setBackgroundResource(R.drawable.btn_w_square_1);
            this.ac.setTextColor(-5454368);
            this.ad.setTextColor(-9207399);
            this.A.setTextColor(-8682095);
            this.ae.setImageResource(R.drawable.pic_inset_login_1);
            com.baidu.tieba.util.x.h(this.k, (int) R.drawable.btn_blue_bg_selector_1);
            if (biVar.b()) {
                this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_lately_1));
            } else {
                this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_chat_1));
            }
            this.m.setTextColor(-6900265);
            this.n.setTextColor(-5584160);
            this.L.setTextColor(-8352873);
            this.S.setTextColor(-8352873);
            this.P.setTextColor(-8352873);
        } else {
            com.baidu.tieba.util.x.h(this.v, (int) R.drawable.person_seperator);
            this.f.setTextColor(-1);
            this.h.setTextColor(-4802890);
            this.B.setBackgroundResource(R.drawable.person_button);
            this.C.setBackgroundResource(R.drawable.person_button);
            this.D.setBackgroundResource(R.drawable.person_button);
            this.E.setBackgroundResource(R.drawable.person_button);
            this.F.setBackgroundResource(R.drawable.person_button);
            this.G.setBackgroundResource(R.drawable.person_button);
            this.H.setBackgroundResource(R.drawable.person_button);
            this.M.setImageResource(R.drawable.icon_my_like_ba);
            this.O.setImageResource(R.drawable.icon_my_attention);
            this.R.setImageResource(R.drawable.icon_my_fass);
            this.J.setImageResource(R.drawable.icon_my_collect);
            this.U.setImageResource(R.drawable.icon_my_news);
            this.W.setImageResource(R.drawable.icon_my_post);
            this.aa.setImageResource(R.drawable.icon_my_paste);
            this.K.setTextColor(-12564913);
            this.N.setTextColor(-12564913);
            this.I.setTextColor(-12564913);
            this.V.setTextColor(-12564913);
            this.T.setTextColor(-12564913);
            this.Q.setTextColor(-12564913);
            this.Z.setTextColor(-12564913);
            this.i.setBackgroundColor(-1644051);
            this.e.setForeground(this.b.getResources().getDrawable(R.drawable.pic_bj_touxiang_n));
            this.af.setTextColor(-5065030);
            this.ac.setBackgroundResource(R.drawable.btn_blue_square);
            this.ad.setBackgroundResource(R.drawable.btn_w_square);
            this.ac.setTextColor(-1);
            this.ad.setTextColor(-14277082);
            this.A.setTextColor(-1);
            this.ae.setImageResource(R.drawable.pic_inset_login);
            com.baidu.tieba.util.x.h(this.k, (int) R.drawable.btn_blue_bg_selector);
            if (biVar.b()) {
                this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_lately));
            } else {
                this.l.setImageDrawable(this.b.getResources().getDrawable(R.drawable.icon_cent_chat));
            }
            this.m.setTextColor(-1);
            this.n.setTextColor(-5584160);
            this.L.setTextColor(-6576974);
            this.S.setTextColor(-6576974);
            this.P.setTextColor(-6576974);
        }
        this.j.setImageResource(R.drawable.pic_banner_pic);
    }

    private void a(int i, TextView textView, TextView textView2) {
        if (i == 1) {
            if (textView != null) {
                textView.setTextColor(com.baidu.tieba.util.x.a(i));
            }
            if (textView2 != null) {
                textView2.setTextColor(com.baidu.tieba.util.x.c(i));
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

    public void a() {
        this.B.setBackgroundResource(0);
        this.C.setBackgroundResource(0);
        this.D.setBackgroundResource(0);
        this.E.setBackgroundResource(0);
        this.F.setBackgroundResource(0);
        this.G.setBackgroundColor(0);
        this.H.setBackgroundResource(0);
        this.M.setImageResource(0);
        this.O.setImageResource(0);
        this.R.setImageResource(0);
        this.J.setImageResource(0);
        this.U.setImageResource(0);
        this.W.setImageResource(0);
        this.aa.setImageResource(0);
        this.ae.setImageResource(0);
        this.j.setImageDrawable(null);
    }

    public void f(com.baidu.tieba.model.bi biVar) {
        if (biVar.c() == null) {
            this.w.setVisibility(0);
        }
    }

    public void a(boolean z, com.baidu.tieba.model.bi biVar, int i) {
        this.w.setVisibility(8);
        if (z) {
            a(biVar);
            h(biVar);
        }
        if (i == 1) {
            this.t.c();
            if (biVar.getErrorString() != null) {
                this.b.a(biVar.getErrorString());
            }
        }
    }

    public void g(com.baidu.tieba.model.bi biVar) {
        if (biVar.c() != null) {
            this.x.setVisibility(0);
        }
    }

    public void a(boolean z, com.baidu.tieba.model.bi biVar) {
        this.x.setVisibility(8);
        if (z) {
            this.b.a(this.b.getString(R.string.success));
            i(biVar);
        } else if (biVar.getErrorString() != null) {
            this.b.a(biVar.getErrorString());
        }
    }

    public void b() {
        this.d.setImageResource(R.drawable.person_photo);
    }

    public void h(com.baidu.tieba.model.bi biVar) {
        String portrait;
        if (biVar != null && biVar.c() != null && (portrait = biVar.c().getPortrait()) != null && portrait.length() > 0) {
            com.baidu.adp.widget.a.b b = biVar.e().b(portrait);
            if (b == null) {
                biVar.e().c(portrait, new bc(this));
            } else {
                b.b(this.d);
            }
        }
    }

    public void c() {
        if (this.w != null) {
            this.w.setVisibility(8);
        }
        if (this.x != null) {
            this.x.setVisibility(8);
        }
    }

    public ImageView d() {
        return this.c;
    }

    public ImageView e() {
        return this.o;
    }

    public LinearLayout f() {
        return this.z;
    }

    public Button g() {
        return this.p;
    }

    public LinearLayout h() {
        return this.B;
    }

    public LinearLayout i() {
        return this.C;
    }

    public LinearLayout j() {
        return this.D;
    }

    public LinearLayout k() {
        return this.E;
    }

    public LinearLayout l() {
        return this.F;
    }

    public LinearLayout m() {
        return this.G;
    }

    public LinearLayout n() {
        return this.H;
    }

    public Button o() {
        return this.ac;
    }

    public Button p() {
        return this.ad;
    }

    public LinearLayout q() {
        return this.k;
    }
}
