package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.a.d {
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private TextView E;
    private ImageView F;
    private TextView G;
    private ImageView H;
    private TextView I;
    private ImageView J;
    private TextView K;
    private ImageView L;
    private TextView M;
    private ImageView N;
    private TextView O;
    private ImageView P;
    private TextView Q;
    private TextView R;
    private TextView S;
    private ImageView T;
    private LinearLayout U;
    private Button V;
    private Button W;
    private ImageView X;
    private TextView Y;
    PersonInfoActivity b;
    private ImageView c;
    private ImageView d;
    private FrameLayout e;
    private TextView f;
    private ImageView g;
    private TextView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private Button l;
    private LinearLayout m;
    private LinearLayout n;
    private TextView o;
    private BdPullRefreshScrollView p;
    private com.baidu.tieba.view.v q;
    private FrameLayout r;
    private ProgressBar s;
    private ProgressBar t;
    private LinearLayout u;
    private LinearLayout v;
    private TextView w;
    private LinearLayout x;
    private LinearLayout y;
    private LinearLayout z;

    public ba(PersonInfoActivity personInfoActivity, com.baidu.tieba.c.bf bfVar) {
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
        this.b = personInfoActivity;
        personInfoActivity.setContentView(R.layout.person_info_activity);
        this.s = (ProgressBar) personInfoActivity.findViewById(R.id.progress);
        this.t = (ProgressBar) personInfoActivity.findViewById(R.id.attention_progress);
        this.m = (LinearLayout) personInfoActivity.findViewById(R.id.parent);
        this.n = (LinearLayout) personInfoActivity.findViewById(R.id.title);
        this.p = (BdPullRefreshScrollView) personInfoActivity.findViewById(R.id.scrollview);
        this.q = new com.baidu.tieba.view.v(personInfoActivity);
        this.p.setCustomHeaderView(this.q);
        this.r = (FrameLayout) personInfoActivity.findViewById(R.id.info);
        this.o = (TextView) personInfoActivity.findViewById(R.id.titel_text);
        this.d = (ImageView) personInfoActivity.findViewById(R.id.photo);
        this.e = (FrameLayout) personInfoActivity.findViewById(R.id.photo_frame);
        this.c = (ImageView) personInfoActivity.findViewById(R.id.back);
        this.c.setOnClickListener(personInfoActivity);
        this.k = (ImageView) personInfoActivity.findViewById(R.id.home);
        this.k.setOnClickListener(personInfoActivity);
        this.l = (Button) personInfoActivity.findViewById(R.id.settings);
        this.l.setOnClickListener(personInfoActivity);
        this.u = (LinearLayout) personInfoActivity.findViewById(R.id.person_info_view);
        this.N = (ImageView) personInfoActivity.findViewById(R.id.my_msg_image);
        this.M = (TextView) personInfoActivity.findViewById(R.id.my_msg_text);
        this.F = (ImageView) personInfoActivity.findViewById(R.id.bookmark_image);
        this.E = (TextView) personInfoActivity.findViewById(R.id.bookmark_text);
        this.G = (TextView) personInfoActivity.findViewById(R.id.likes_text);
        this.H = (ImageView) personInfoActivity.findViewById(R.id.likes_image);
        this.I = (TextView) personInfoActivity.findViewById(R.id.my_attention_text);
        this.J = (ImageView) personInfoActivity.findViewById(R.id.attention_image);
        this.K = (TextView) personInfoActivity.findViewById(R.id.fans_text);
        this.L = (ImageView) personInfoActivity.findViewById(R.id.fans_image);
        this.x = (LinearLayout) personInfoActivity.findViewById(R.id.button_mention);
        this.y = (LinearLayout) personInfoActivity.findViewById(R.id.button_bookmark);
        this.z = (LinearLayout) personInfoActivity.findViewById(R.id.button_likes);
        this.A = (LinearLayout) personInfoActivity.findViewById(R.id.button_attention);
        this.B = (LinearLayout) personInfoActivity.findViewById(R.id.button_fans);
        this.D = (LinearLayout) personInfoActivity.findViewById(R.id.button_lbs);
        this.C = (LinearLayout) personInfoActivity.findViewById(R.id.button_mypost);
        this.O = (TextView) personInfoActivity.findViewById(R.id.my_post_text);
        this.P = (ImageView) personInfoActivity.findViewById(R.id.my_post_image);
        this.Q = (TextView) personInfoActivity.findViewById(R.id.new_fans_count);
        this.R = (TextView) personInfoActivity.findViewById(R.id.new_mention_count);
        int a = com.baidu.tieba.d.ag.a((Context) personInfoActivity);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
        layoutParams.topMargin = com.baidu.tieba.d.ag.a(personInfoActivity, 8.0f);
        layoutParams.rightMargin = (a / 6) - com.baidu.tieba.d.ag.a(personInfoActivity, 30.0f);
        this.R.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Q.getLayoutParams();
        layoutParams2.topMargin = com.baidu.tieba.d.ag.a(personInfoActivity, 8.0f);
        layoutParams2.rightMargin = (a / 6) - com.baidu.tieba.d.ag.a(personInfoActivity, 30.0f);
        this.Q.setLayoutParams(layoutParams2);
        this.S = (TextView) personInfoActivity.findViewById(R.id.lbs_text);
        this.T = (ImageView) personInfoActivity.findViewById(R.id.lbs_image);
        this.x.setOnClickListener(personInfoActivity);
        this.y.setOnClickListener(personInfoActivity);
        this.D.setOnClickListener(personInfoActivity);
        this.z.setOnClickListener(personInfoActivity);
        this.A.setOnClickListener(personInfoActivity);
        this.B.setOnClickListener(personInfoActivity);
        this.C.setOnClickListener(personInfoActivity);
        this.f = (TextView) personInfoActivity.findViewById(R.id.name);
        this.g = (ImageView) personInfoActivity.findViewById(R.id.sex);
        this.h = (TextView) personInfoActivity.findViewById(R.id.intro);
        this.v = (LinearLayout) personInfoActivity.findViewById(R.id.attention);
        this.w = (TextView) personInfoActivity.findViewById(R.id.attention_text);
        this.v.setOnClickListener(personInfoActivity);
        this.i = (ImageView) personInfoActivity.findViewById(R.id.background_bottom);
        this.j = (ImageView) personInfoActivity.findViewById(R.id.background_image);
        this.U = (LinearLayout) personInfoActivity.findViewById(R.id.not_login_view);
        this.X = (ImageView) personInfoActivity.findViewById(R.id.not_login_img);
        this.Y = (TextView) personInfoActivity.findViewById(R.id.not_login_text);
        this.V = (Button) personInfoActivity.findViewById(R.id.login_btn);
        this.V.setOnClickListener(personInfoActivity);
        this.W = (Button) personInfoActivity.findViewById(R.id.reg_btn);
        this.W.setOnClickListener(personInfoActivity);
        a(bfVar);
    }

    public void a(com.baidu.tieba.c.bf bfVar) {
        if (bfVar.d() == null || bfVar.d().length() < 0) {
            this.u.setVisibility(8);
            this.U.setVisibility(0);
        } else {
            this.u.setVisibility(0);
            this.U.setVisibility(8);
        }
        b(bfVar);
        c(bfVar);
        h(bfVar);
        d(bfVar);
    }

    public void b(com.baidu.tieba.c.bf bfVar) {
        if (bfVar.d() == null || bfVar.d().length() < 0) {
            this.o.setText(R.string.person_info);
            this.l.setVisibility(0);
            this.k.setVisibility(8);
            this.c.setVisibility(4);
        } else if (bfVar.e()) {
            this.o.setText(R.string.person_info);
            if (bfVar.n()) {
                this.c.setVisibility(4);
                this.k.setVisibility(8);
                this.l.setVisibility(0);
            } else if (bfVar.o()) {
                this.c.setVisibility(0);
                this.k.setVisibility(8);
                this.l.setVisibility(0);
            } else {
                this.c.setVisibility(0);
                this.k.setVisibility(0);
                this.l.setVisibility(8);
            }
        } else {
            if (bfVar.f() == null) {
                this.o.setText(bfVar.i());
            } else {
                this.o.setText(bfVar.f().d());
            }
            this.c.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        }
    }

    public void c(com.baidu.tieba.c.bf bfVar) {
        if (bfVar.d() != null && bfVar.d().length() > 0) {
            if (bfVar.f() == null) {
                this.f.setText(bfVar.i());
                return;
            }
            this.f.setText(bfVar.f().d());
            if (bfVar.f().i() == 1) {
                this.g.setImageResource(R.drawable.cent_icon_boy_n);
            } else if (bfVar.f().i() == 2) {
                this.g.setImageResource(R.drawable.cent_icon_girl_n);
            }
            this.h.setText(bfVar.f().h());
        }
    }

    private void h(com.baidu.tieba.c.bf bfVar) {
        this.v.setVisibility(8);
        if (bfVar.d() != null && bfVar.d().length() > 0 && !bfVar.e() && bfVar.f() != null) {
            this.v.setVisibility(0);
            if (bfVar.f().l() == 1) {
                this.v.setBackgroundResource(R.drawable.attention_cancel);
                this.w.setText(R.string.attention_cancel);
                return;
            }
            this.v.setBackgroundResource(R.drawable.attention);
            this.w.setText(R.string.attention);
        }
    }

    public void d(com.baidu.tieba.c.bf bfVar) {
        if (bfVar.d() != null && bfVar.d().length() > 0) {
            if (bfVar.e()) {
                this.x.setVisibility(0);
                this.y.setVisibility(0);
                this.C.setVisibility(0);
                this.G.setText(R.string.my_like_forums);
                this.I.setText(R.string.my_attention);
                this.K.setText(R.string.my_fans);
                this.S.setText(R.string.my_lbs_text);
                long l = bfVar.l();
                if (l > 0) {
                    this.R.setVisibility(0);
                    if (l > 99) {
                        this.R.setText("99+");
                    } else {
                        this.R.setText(String.valueOf(l));
                    }
                } else {
                    this.R.setVisibility(8);
                }
                long j = bfVar.j();
                if (j > 0) {
                    this.Q.setVisibility(0);
                    if (j > 99) {
                        this.Q.setText("99+");
                        return;
                    } else {
                        this.Q.setText(String.valueOf(j));
                        return;
                    }
                }
                this.Q.setVisibility(8);
                return;
            }
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            this.C.setVisibility(8);
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
            this.G.setText(R.string.hisbars);
            this.I.setText(R.string.his_attention);
            this.K.setText(R.string.his_fans);
            this.S.setText(R.string.his_lbs_text);
        }
    }

    public void a(boolean z) {
        if (!z) {
            this.p.setMode(com.baidu.adp.widget.ScrollView.n.DISABLED);
        } else {
            this.p.setMode(com.baidu.adp.widget.ScrollView.n.PULL_FROM_START);
        }
    }

    public void a(com.baidu.adp.widget.ScrollView.o oVar) {
        this.p.setOnPullDownListener(oVar);
    }

    public void a(int i) {
        com.baidu.tieba.d.ac.a(this.m, i);
        com.baidu.tieba.d.ac.f(this.o, i);
        com.baidu.tieba.d.ac.d(this.n, i);
        com.baidu.tieba.d.ac.g((TextView) this.l, i);
        com.baidu.tieba.d.ac.a(this.c, i);
        com.baidu.tieba.d.ac.d(this.k, i);
        a(i, this.E, (TextView) null);
        a(i, this.M, (TextView) null);
        a(i, this.O, (TextView) null);
        a(i, this.S, (TextView) null);
        com.baidu.tieba.d.ac.a(this.q, i);
        this.q.a(i);
        if (i == 1) {
            com.baidu.tieba.d.ac.h(this.r, (int) R.drawable.person_seperator_1);
            this.f.setTextColor(-5524539);
            this.h.setTextColor(-8682095);
            this.x.setBackgroundResource(R.drawable.person_button_1);
            this.y.setBackgroundResource(R.drawable.person_button_1);
            this.z.setBackgroundResource(R.drawable.person_button_1);
            this.A.setBackgroundResource(R.drawable.person_button_1);
            this.B.setBackgroundResource(R.drawable.person_button_1);
            this.C.setBackgroundResource(R.drawable.person_button_1);
            this.D.setBackgroundResource(R.drawable.person_button_1);
            this.H.setImageResource(R.drawable.icon_my_like_ba_1);
            this.J.setImageResource(R.drawable.icon_my_attention_1);
            this.L.setImageResource(R.drawable.icon_my_fass_1);
            this.F.setImageResource(R.drawable.icon_my_collect_1);
            this.N.setImageResource(R.drawable.icon_my_news_1);
            this.P.setImageResource(R.drawable.icon_my_post_1);
            this.T.setImageResource(R.drawable.icon_my_paste_1);
            this.G.setTextColor(-10523526);
            this.I.setTextColor(-10523526);
            this.E.setTextColor(-10523526);
            this.O.setTextColor(-10523526);
            this.M.setTextColor(-10523526);
            this.K.setTextColor(-10523526);
            this.S.setTextColor(-10523526);
            this.i.setBackgroundColor(-13618114);
            this.e.setForeground(this.b.getResources().getDrawable(R.drawable.pic_bj_touxiang_n_1));
            this.Y.setTextColor(-11446171);
            this.V.setBackgroundResource(R.drawable.btn_blue_square_1);
            this.W.setBackgroundResource(R.drawable.btn_w_square_1);
            this.V.setTextColor(-5454368);
            this.W.setTextColor(-9207399);
            this.w.setTextColor(-8682095);
            this.X.setImageResource(R.drawable.pic_inset_login_1);
            return;
        }
        com.baidu.tieba.d.ac.h(this.r, (int) R.drawable.person_seperator);
        this.f.setTextColor(-1);
        this.h.setTextColor(-12564913);
        this.x.setBackgroundResource(R.drawable.person_button);
        this.y.setBackgroundResource(R.drawable.person_button);
        this.z.setBackgroundResource(R.drawable.person_button);
        this.A.setBackgroundResource(R.drawable.person_button);
        this.B.setBackgroundResource(R.drawable.person_button);
        this.C.setBackgroundResource(R.drawable.person_button);
        this.D.setBackgroundResource(R.drawable.person_button);
        this.H.setImageResource(R.drawable.icon_my_like_ba);
        this.J.setImageResource(R.drawable.icon_my_attention);
        this.L.setImageResource(R.drawable.icon_my_fass);
        this.F.setImageResource(R.drawable.icon_my_collect);
        this.N.setImageResource(R.drawable.icon_my_news);
        this.P.setImageResource(R.drawable.icon_my_post);
        this.T.setImageResource(R.drawable.icon_my_paste);
        this.G.setTextColor(-12564913);
        this.I.setTextColor(-12564913);
        this.E.setTextColor(-12564913);
        this.O.setTextColor(-12564913);
        this.M.setTextColor(-12564913);
        this.K.setTextColor(-12564913);
        this.S.setTextColor(-12564913);
        this.i.setBackgroundColor(-1644051);
        this.e.setForeground(this.b.getResources().getDrawable(R.drawable.pic_bj_touxiang_n));
        this.Y.setTextColor(-5065030);
        this.V.setBackgroundResource(R.drawable.btn_blue_square);
        this.W.setBackgroundResource(R.drawable.btn_w_square);
        this.V.setTextColor(-1);
        this.W.setTextColor(-14277082);
        this.w.setTextColor(-1);
        this.X.setImageResource(R.drawable.pic_inset_login);
    }

    private void a(int i, TextView textView, TextView textView2) {
        if (i == 1) {
            if (textView != null) {
                textView.setTextColor(com.baidu.tieba.d.ac.a(i));
            }
            if (textView2 != null) {
                textView2.setTextColor(com.baidu.tieba.d.ac.c(i));
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
        this.x.setBackgroundResource(0);
        this.y.setBackgroundResource(0);
        this.z.setBackgroundResource(0);
        this.A.setBackgroundResource(0);
        this.B.setBackgroundResource(0);
        this.C.setBackgroundColor(0);
        this.D.setBackgroundResource(0);
        this.H.setImageResource(0);
        this.J.setImageResource(0);
        this.L.setImageResource(0);
        this.F.setImageResource(0);
        this.N.setImageResource(0);
        this.P.setImageResource(0);
        this.T.setImageResource(0);
        this.X.setImageResource(0);
        this.j.setImageResource(0);
    }

    public void e(com.baidu.tieba.c.bf bfVar) {
        if (bfVar.f() == null) {
            this.s.setVisibility(0);
        }
    }

    public void a(boolean z, com.baidu.tieba.c.bf bfVar, int i) {
        this.s.setVisibility(8);
        if (z) {
            a(bfVar);
            g(bfVar);
        }
        if (i == 1) {
            this.p.c();
            if (bfVar.c() != null) {
                this.b.a(bfVar.c());
            }
        }
    }

    public void f(com.baidu.tieba.c.bf bfVar) {
        if (bfVar.f() != null) {
            this.t.setVisibility(0);
        }
    }

    public void a(boolean z, com.baidu.tieba.c.bf bfVar) {
        this.t.setVisibility(8);
        if (z) {
            this.b.a(this.b.getString(R.string.success));
            h(bfVar);
        } else if (bfVar.c() != null) {
            this.b.a(bfVar.c());
        }
    }

    public void b() {
        this.d.setImageResource(R.drawable.person_photo);
    }

    public void g(com.baidu.tieba.c.bf bfVar) {
        String e;
        if (bfVar != null && bfVar.f() != null && (e = bfVar.f().e()) != null && e.length() > 0) {
            Bitmap b = bfVar.h().b(e);
            if (b == null) {
                bfVar.h().c(e, new bb(this));
            } else {
                this.d.setImageBitmap(b);
            }
        }
    }

    public void c() {
        if (this.s != null) {
            this.s.setVisibility(8);
        }
        if (this.t != null) {
            this.t.setVisibility(8);
        }
    }

    public ImageView d() {
        return this.c;
    }

    public ImageView e() {
        return this.k;
    }

    public LinearLayout f() {
        return this.v;
    }

    public Button g() {
        return this.l;
    }

    public LinearLayout h() {
        return this.x;
    }

    public LinearLayout i() {
        return this.y;
    }

    public LinearLayout j() {
        return this.z;
    }

    public LinearLayout k() {
        return this.A;
    }

    public LinearLayout l() {
        return this.B;
    }

    public LinearLayout m() {
        return this.C;
    }

    public LinearLayout n() {
        return this.D;
    }

    public Button o() {
        return this.V;
    }

    public Button p() {
        return this.W;
    }
}
