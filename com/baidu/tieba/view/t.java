package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.a.d {
    private com.baidu.tieba.util.a D;
    private FrsStarImageView E;
    private FrsStarImageView F;
    private ImageView G;
    private Button H;
    private TextView I;
    private CustomTimerView J;
    private ImageView K;
    private TextView L;
    private String M;
    private int N;
    private RelativeLayout R;
    private RelativeLayout S;
    private boolean T;
    private int U;
    private LinearLayout W;
    private RelativeLayout X;
    private RelativeLayout Y;
    private RelativeLayout Z;
    private ImageView aA;
    private ImageView aB;
    private ImageView aC;
    private ImageView aD;
    private LinearLayout aa;
    private TextView ab;
    private TextView ac;
    private TextView ad;
    private TextView ae;
    private HeadImageView af;
    private TextView ag;
    private HeadImageView ah;
    private TextView ai;
    private HeadImageView aj;
    private TextView ak;
    private HeadImageView al;
    private TextView am;
    private TextView an;
    private TextView ao;
    private TextView ap;
    private TextView aq;
    private TextView ar;
    private RelativeLayout as;
    private RelativeLayout at;
    private ImageView au;
    private ImageView av;
    private ImageView aw;
    private ImageView ax;
    private ImageView ay;
    private ImageView az;
    private TextView b;
    private ProgressBar c;
    private RelativeLayout d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private TextView h;
    private Button i;
    private RelativeLayout j;
    private ImageView k;
    private Button l;
    private Button m;
    private RelativeLayout n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private ImageView r;
    private View s;
    private Activity u;
    private String v;
    private String w;
    private com.baidu.tieba.util.a z;
    private boolean t = false;
    private int x = 0;
    private int y = 0;
    private String A = "?tag=";
    private com.baidu.tieba.data.x B = null;
    private com.baidu.tieba.data.bj C = null;

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.bm f1849a = null;
    private float O = 0.0f;
    private float P = 0.0f;
    private boolean Q = false;
    private boolean V = false;
    private boolean aE = true;
    private boolean aF = true;
    private View.OnClickListener aG = null;
    private AnimationDrawable aH = null;

    public t(Activity activity, String str, String str2) {
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
        this.u = null;
        this.v = null;
        this.w = null;
        this.z = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.R = null;
        this.S = null;
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
        this.am = null;
        this.an = null;
        this.ao = null;
        this.ap = null;
        this.aq = null;
        this.ar = null;
        this.as = null;
        this.at = null;
        this.au = null;
        this.av = null;
        this.aw = null;
        this.ax = null;
        this.ay = null;
        this.az = null;
        this.aA = null;
        this.aB = null;
        this.aC = null;
        this.aD = null;
        this.u = activity;
        this.z = new com.baidu.tieba.util.a(this.u);
        int a2 = com.baidu.tieba.util.am.a((Context) this.u, 54.0f);
        this.z.a(a2, a2);
        this.v = str;
        this.w = str2;
        this.s = LayoutInflater.from(activity).inflate(R.layout.frs_star_title, (ViewGroup) null);
        if (this.v == null || this.w == null) {
            this.s.setVisibility(8);
        }
        this.c = (ProgressBar) this.s.findViewById(R.id.frs_star_title_progress);
        this.d = (RelativeLayout) this.s.findViewById(R.id.frs_star_title);
        this.n = (RelativeLayout) this.s.findViewById(R.id.btn_love_content);
        this.o = (TextView) this.s.findViewById(R.id.level_name);
        this.p = (TextView) this.s.findViewById(R.id.level);
        this.q = (ImageView) this.s.findViewById(R.id.love_level_top);
        this.r = (ImageView) this.s.findViewById(R.id.love_level_bg);
        this.l = (Button) this.s.findViewById(R.id.btn_love);
        this.m = (Button) this.s.findViewById(R.id.btn_sign);
        this.b = (TextView) this.s.findViewById(R.id.member_num_text);
        this.e = (TextView) this.s.findViewById(R.id.post_num_text);
        this.g = (ImageView) this.s.findViewById(R.id.member_image);
        this.f = (ImageView) this.s.findViewById(R.id.post_image);
        this.h = (TextView) this.s.findViewById(R.id.title_text);
        this.j = (RelativeLayout) this.s.findViewById(R.id.lay_start_local);
        this.i = (Button) this.s.findViewById(R.id.btn_start_local);
        this.k = (ImageView) this.s.findViewById(R.id.img_voice_anim);
        this.R = (RelativeLayout) this.s.findViewById(R.id.fan_timer_layout);
        this.S = (RelativeLayout) this.s.findViewById(R.id.fan_num_layout);
        this.K = (ImageView) this.s.findViewById(R.id.fan_num_icon);
        this.E = (FrsStarImageView) this.s.findViewById(R.id.frs_star_top_pic);
        this.F = (FrsStarImageView) this.s.findViewById(R.id.frs_star_bottom_photo);
        this.G = (ImageView) this.s.findViewById(R.id.frs_star_bottom_bg);
        this.H = (Button) this.s.findViewById(R.id.add_fan);
        this.H.setOnClickListener(new u(this));
        this.I = (TextView) this.s.findViewById(R.id.fan_num);
        this.L = (TextView) this.s.findViewById(R.id.add_fan_intro_text);
        this.J = (CustomTimerView) this.s.findViewById(R.id.open_timer);
        this.J.setTextSize(10);
        this.J.setTextColor(-14277082);
        this.J.setNumSize(12);
        this.J.setNumColor(-12809494);
        this.J.setTextMargin(3);
        this.J.setNumMargin(2);
        this.W = (LinearLayout) this.s.findViewById(R.id.kn_layout);
        this.X = (RelativeLayout) this.s.findViewById(R.id.kn_title_layout);
        this.Y = (RelativeLayout) this.s.findViewById(R.id.kn_pk_1_layout);
        this.Z = (RelativeLayout) this.s.findViewById(R.id.kn_pk_2_layout);
        this.aa = (LinearLayout) this.s.findViewById(R.id.kn_bottom_layout);
        this.ab = (TextView) this.s.findViewById(R.id.kn_rank_title);
        this.ac = (TextView) this.s.findViewById(R.id.kn_vote_title);
        this.ad = (TextView) this.s.findViewById(R.id.kn_rank_text);
        this.ae = (TextView) this.s.findViewById(R.id.kn_vote_text);
        this.an = (TextView) this.s.findViewById(R.id.kn_support_text);
        this.ao = (TextView) this.s.findViewById(R.id.kn_support_text_1);
        this.ap = (TextView) this.s.findViewById(R.id.kn_support_text_2);
        this.aq = (TextView) this.s.findViewById(R.id.kn_relative_video_text);
        this.ar = (TextView) this.s.findViewById(R.id.kn_relative_music_text);
        this.af = (HeadImageView) this.s.findViewById(R.id.kn_pk_1_left_image);
        this.ah = (HeadImageView) this.s.findViewById(R.id.kn_pk_1_right_image);
        this.aj = (HeadImageView) this.s.findViewById(R.id.kn_pk_2_left_image);
        this.al = (HeadImageView) this.s.findViewById(R.id.kn_pk_2_right_image);
        this.ag = (TextView) this.s.findViewById(R.id.kn_pk_1_left_text);
        this.ai = (TextView) this.s.findViewById(R.id.kn_pk_1_right_text);
        this.ak = (TextView) this.s.findViewById(R.id.kn_pk_2_left_text);
        this.am = (TextView) this.s.findViewById(R.id.kn_pk_2_right_text);
        this.as = (RelativeLayout) this.s.findViewById(R.id.kn_relative_video);
        this.at = (RelativeLayout) this.s.findViewById(R.id.kn_relative_music);
        this.au = (ImageView) this.s.findViewById(R.id.kn_title_divider);
        this.av = (ImageView) this.s.findViewById(R.id.kn_pk1_divider);
        this.aw = (ImageView) this.s.findViewById(R.id.kn_pk2_divider);
        this.ax = (ImageView) this.s.findViewById(R.id.kn_pk_1_vs);
        this.ay = (ImageView) this.s.findViewById(R.id.kn_pk_2_vs);
        this.az = (ImageView) this.s.findViewById(R.id.kn_support_image);
        this.aA = (ImageView) this.s.findViewById(R.id.kn_support_image_1);
        this.aB = (ImageView) this.s.findViewById(R.id.kn_support_image_2);
        this.aC = (ImageView) this.s.findViewById(R.id.kn_relative_video_icon);
        this.aD = (ImageView) this.s.findViewById(R.id.kn_relative_music_icon);
        this.D = new com.baidu.tieba.util.a(this.u);
        this.D.a(com.baidu.tieba.util.am.a((Context) this.u), com.baidu.tieba.util.am.a((Context) this.u));
    }

    public void a(View.OnClickListener onClickListener) {
        this.aG = onClickListener;
        this.l.setOnClickListener(onClickListener);
        this.m.setOnClickListener(onClickListener);
        this.X.setOnClickListener(onClickListener);
        this.Y.setOnClickListener(onClickListener);
        this.Z.setOnClickListener(onClickListener);
        this.as.setOnClickListener(onClickListener);
        this.at.setOnClickListener(onClickListener);
        this.i.setOnClickListener(new v(this));
    }

    public com.baidu.tieba.util.a a() {
        return this.D;
    }

    public com.baidu.tieba.data.bm b() {
        return this.f1849a;
    }

    public void a(int i) {
        this.U = i;
        if (this.V) {
            c(1);
        } else {
            c(0);
        }
        this.F.invalidate();
        if (i == 1) {
            this.d.setBackgroundResource(R.drawable.bg_topbar_1);
            this.h.setTextColor(-8682095);
            this.b.setTextColor(-11446171);
            this.e.setTextColor(-11446171);
            this.G.setBackgroundResource(R.drawable.pic_bj_touxiang_n_1);
            this.l.setBackgroundResource(R.drawable.frs_btn_like_1);
            this.g.setBackgroundResource(R.drawable.icon_little_people_1);
            this.f.setBackgroundResource(R.drawable.icon_little_discuss_1);
            this.o.setTextColor(-8682095);
            this.p.setTextColor(-8682095);
            this.q.setBackgroundResource(R.drawable.progressbar_blue_1);
            this.r.setBackgroundResource(R.drawable.progressbar_black_1);
            this.H.setBackgroundResource(R.drawable.frs_star_add_fan_1);
            this.H.setTextColor(-12687203);
            this.K.setBackgroundResource(R.drawable.label_no_1);
            this.I.setTextColor(-5947365);
            this.L.setTextColor(-11446171);
            this.J.setTextColor(-10523526);
            this.J.setNumColor(-12687203);
            this.W.setBackgroundResource(R.drawable.frs_pk_bg_1);
            this.ab.setTextColor(-8682095);
            this.ac.setTextColor(-8682095);
            this.ad.setTextColor(-959965);
            this.ae.setTextColor(-959965);
            this.an.setTextColor(-8682095);
            this.ao.setTextColor(-8682095);
            this.ap.setTextColor(-8682095);
            this.ag.setTextColor(-8682095);
            this.ai.setTextColor(-8682095);
            this.ak.setTextColor(-8682095);
            this.am.setTextColor(-8682095);
            this.au.setBackgroundResource(R.drawable.discovery_dot_line_1);
            this.av.setBackgroundResource(R.drawable.discovery_dot_line_1);
            this.aw.setBackgroundResource(R.drawable.discovery_dot_line_1);
            this.ax.setBackgroundResource(R.drawable.icon_frs_vs_1);
            this.ay.setBackgroundResource(R.drawable.icon_frs_vs_1);
            this.az.setBackgroundResource(R.drawable.icon_frs_arrows_1);
            this.aA.setBackgroundResource(R.drawable.icon_frs_arrows_1);
            this.aB.setBackgroundResource(R.drawable.icon_frs_arrows_1);
            if (this.aF) {
                this.as.setBackgroundResource(R.drawable.btn_frs_video_1);
                this.aq.setTextColor(-12810784);
                this.aC.setBackgroundResource(R.drawable.icon_frs_video_n_1);
            } else {
                this.as.setBackgroundResource(R.drawable.btn_frs_video_d_1);
                this.aq.setTextColor(-8682095);
                this.aC.setBackgroundResource(R.drawable.icon_frs_video_d_1);
            }
            if (this.aE) {
                this.at.setBackgroundResource(R.drawable.btn_frs_video_1);
                this.ar.setTextColor(-12810784);
                this.aD.setBackgroundResource(R.drawable.icon_frs_music_n_1);
                return;
            }
            this.at.setBackgroundResource(R.drawable.btn_frs_video_d_1);
            this.ar.setTextColor(-8682095);
            this.aD.setBackgroundResource(R.drawable.icon_frs_music_d_1);
            return;
        }
        this.d.setBackgroundResource(R.drawable.bg_topbar);
        this.h.setTextColor(-12564913);
        this.b.setTextColor(-5065030);
        this.e.setTextColor(-5065030);
        this.l.setBackgroundResource(R.drawable.frs_btn_like);
        this.g.setBackgroundResource(R.drawable.icon_little_people);
        this.f.setBackgroundResource(R.drawable.icon_little_discuss);
        this.G.setBackgroundResource(R.drawable.pic_bj_touxiang_n);
        this.o.setTextColor(-14277082);
        this.p.setTextColor(-14277082);
        this.q.setBackgroundResource(R.drawable.progressbar_blue);
        this.r.setBackgroundResource(R.drawable.progressbar_black);
        this.H.setBackgroundResource(R.drawable.frs_star_add_fan);
        this.H.setTextColor(-12810784);
        this.K.setBackgroundResource(R.drawable.label_no);
        this.I.setTextColor(-3060450);
        this.L.setTextColor(-7100744);
        this.J.setTextColor(-14277082);
        this.J.setNumColor(-12809494);
        this.W.setBackgroundResource(R.drawable.frs_pk_bg);
        this.ab.setTextColor(-14277082);
        this.ac.setTextColor(-14277082);
        this.ad.setTextColor(-959965);
        this.ae.setTextColor(-959965);
        this.an.setTextColor(-14277082);
        this.ao.setTextColor(-14277082);
        this.ap.setTextColor(-14277082);
        this.ag.setTextColor(-10066330);
        this.ai.setTextColor(-10066330);
        this.ak.setTextColor(-10066330);
        this.am.setTextColor(-10066330);
        this.au.setBackgroundResource(R.drawable.discovery_dot_line);
        this.av.setBackgroundResource(R.drawable.discovery_dot_line);
        this.aw.setBackgroundResource(R.drawable.discovery_dot_line);
        this.ax.setBackgroundResource(R.drawable.icon_frs_vs);
        this.ay.setBackgroundResource(R.drawable.icon_frs_vs);
        this.az.setBackgroundResource(R.drawable.icon_frs_arrows);
        this.aA.setBackgroundResource(R.drawable.icon_frs_arrows);
        this.aB.setBackgroundResource(R.drawable.icon_frs_arrows);
        this.aC.setBackgroundResource(R.drawable.icon_frs_video_n);
        this.aD.setBackgroundResource(R.drawable.icon_frs_music_n);
        if (this.aF) {
            this.as.setBackgroundResource(R.drawable.btn_frs_video);
            this.aq.setTextColor(-12810784);
            this.aC.setBackgroundResource(R.drawable.icon_frs_video_n);
        } else {
            this.as.setBackgroundResource(R.drawable.btn_frs_video_d);
            this.aq.setTextColor(-5065030);
            this.aC.setBackgroundResource(R.drawable.icon_frs_video_d);
        }
        if (this.aE) {
            this.at.setBackgroundResource(R.drawable.btn_frs_video);
            this.ar.setTextColor(-12810784);
            this.aD.setBackgroundResource(R.drawable.icon_frs_music_n);
            return;
        }
        this.at.setBackgroundResource(R.drawable.btn_frs_video_d);
        this.ar.setTextColor(-5065030);
        this.aD.setBackgroundResource(R.drawable.icon_frs_music_d);
    }

    public View c() {
        return this.s;
    }

    public void a(com.baidu.tieba.data.v vVar, com.baidu.tieba.data.x xVar) {
        this.v = vVar.b();
        this.w = vVar.a();
        this.x = vVar.d();
        this.y = vVar.c();
        this.B = xVar;
        this.f1849a = new com.baidu.tieba.data.bm();
        if (this.B != null) {
            this.C = this.B.l();
            com.baidu.tieba.data.am amVar = new com.baidu.tieba.data.am();
            amVar.a(3);
            amVar.a(this.B.b());
            this.f1849a.m().add(amVar);
            com.baidu.tieba.data.am amVar2 = new com.baidu.tieba.data.am();
            amVar2.a(3);
            amVar2.a(this.B.c());
            this.f1849a.m().add(amVar2);
        }
        this.s.setVisibility(0);
        if (vVar.f() == 0 || !TiebaApplication.f().at()) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.h.setMaxWidth(com.baidu.tieba.util.am.a((Context) this.u, 100.0f));
            if (vVar.g() == 1) {
                if (this.aH != null) {
                    this.aH.stop();
                }
                this.k.setBackgroundResource(R.anim.voice_play);
                this.aH = (AnimationDrawable) this.k.getBackground();
                this.aH.start();
            }
        }
        i();
    }

    private void i() {
        if (this.b != null) {
            this.b.setText(String.valueOf(this.x));
        }
        if (this.e != null) {
            this.e.setText(String.valueOf(this.y));
        }
        if (this.h != null) {
            this.h.setText(String.valueOf(this.v) + "吧");
        }
        this.E.setImageType(0);
        this.F.setImageType(1);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams.width = com.baidu.tieba.util.am.a((Context) this.u);
        if (this.B.d() == 0) {
            layoutParams.height = 1;
        } else {
            layoutParams.height = (layoutParams.width * this.B.e()) / this.B.d();
        }
        this.E.setLayoutParams(layoutParams);
        this.E.setTag(this.B.b());
        this.F.setTag(this.B.c());
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
        layoutParams2.width = com.baidu.tieba.util.am.a((Context) this.u) / 4;
        if (this.B.f() == 0) {
            layoutParams2.height = layoutParams2.width;
        } else {
            layoutParams2.height = (layoutParams2.width * this.B.g()) / this.B.f();
        }
        this.F.setLayoutParams(layoutParams2);
        if (this.B.h() == 0) {
            this.S.setVisibility(8);
            this.H.setVisibility(8);
            if (this.B.i() <= 0) {
                this.R.setVisibility(8);
            } else {
                this.R.setVisibility(0);
            }
        } else {
            this.R.setVisibility(8);
            if (this.B.j() == 0) {
                this.S.setVisibility(8);
                this.H.setVisibility(0);
            } else {
                this.H.setVisibility(8);
                this.S.setVisibility(0);
                this.I.setText(String.valueOf(this.B.k()));
            }
        }
        if (this.C != null) {
            j();
        }
    }

    private void j() {
        if (this.C.f()) {
            this.W.setVisibility(0);
            m();
            l();
            k();
            return;
        }
        this.W.setVisibility(8);
    }

    private void k() {
        if (this.C.g() == 0 && this.C.h() == 0) {
            this.aa.setVisibility(8);
            return;
        }
        this.aa.setVisibility(0);
        if (this.C.g() == 0) {
            this.aE = false;
            this.at.setClickable(false);
            this.at.setOnClickListener(null);
        } else {
            this.aE = true;
            this.at.setClickable(true);
            this.at.setOnClickListener(this.aG);
        }
        if (this.C.h() == 0) {
            this.aF = false;
            this.as.setClickable(false);
            this.as.setOnClickListener(null);
        } else {
            this.aF = true;
            this.as.setClickable(true);
            this.as.setOnClickListener(this.aG);
        }
        if (this.U == 1) {
            if (this.aF) {
                this.as.setBackgroundResource(R.drawable.btn_frs_video_1);
                this.aq.setTextColor(-12810784);
                this.aC.setBackgroundResource(R.drawable.icon_frs_video_n_1);
            } else {
                this.as.setBackgroundResource(R.drawable.btn_frs_video_d_1);
                this.aq.setTextColor(-8682095);
                this.aC.setBackgroundResource(R.drawable.icon_frs_video_d_1);
            }
            if (this.aE) {
                this.at.setBackgroundResource(R.drawable.btn_frs_video_1);
                this.ar.setTextColor(-12810784);
                this.aD.setBackgroundResource(R.drawable.icon_frs_music_n_1);
                return;
            }
            this.at.setBackgroundResource(R.drawable.btn_frs_video_d_1);
            this.ar.setTextColor(-8682095);
            this.aD.setBackgroundResource(R.drawable.icon_frs_music_d_1);
            return;
        }
        if (this.aF) {
            this.as.setBackgroundResource(R.drawable.btn_frs_video);
            this.aq.setTextColor(-12810784);
            this.aC.setBackgroundResource(R.drawable.icon_frs_video_n);
        } else {
            this.as.setBackgroundResource(R.drawable.btn_frs_video_d);
            this.aq.setTextColor(-5065030);
            this.aC.setBackgroundResource(R.drawable.icon_frs_video_d);
        }
        if (this.aE) {
            this.at.setBackgroundResource(R.drawable.btn_frs_video);
            this.ar.setTextColor(-12810784);
            this.aD.setBackgroundResource(R.drawable.icon_frs_music_n);
            return;
        }
        this.at.setBackgroundResource(R.drawable.btn_frs_video_d);
        this.ar.setTextColor(-5065030);
        this.aD.setBackgroundResource(R.drawable.icon_frs_music_d);
    }

    private void l() {
        int size = this.C.e().size();
        if (size == 0) {
            this.Y.setVisibility(8);
            this.Z.setVisibility(8);
        } else if (size >= 1) {
            this.Y.setVisibility(0);
            com.baidu.tieba.data.aq aqVar = (com.baidu.tieba.data.aq) this.C.e().get(0);
            if (aqVar.b() != null) {
                this.ag.setText(aqVar.b().a());
                String str = String.valueOf(aqVar.b().b()) + this.A + String.valueOf((int) R.id.kn_pk_1_left_image);
                this.af.setTag(str);
                com.baidu.adp.widget.a.b d = this.z.d(str);
                if (d != null) {
                    d.b(this.af);
                } else {
                    if (this.U == 1) {
                        this.af.setImageResource(R.drawable.pic_image_h_not_1);
                    } else {
                        this.af.setImageResource(R.drawable.pic_image_h_not);
                    }
                    this.z.e(str, this);
                }
            }
            if (aqVar.c() != null) {
                this.ai.setText(((com.baidu.tieba.data.aq) this.C.e().get(0)).c().a());
                String str2 = String.valueOf(aqVar.c().b()) + this.A + String.valueOf((int) R.id.kn_pk_1_right_image);
                this.ah.setTag(str2);
                com.baidu.adp.widget.a.b d2 = this.z.d(str2);
                if (d2 != null) {
                    d2.b(this.ah);
                } else {
                    if (this.U == 1) {
                        this.ah.setImageResource(R.drawable.pic_image_h_not_1);
                    } else {
                        this.ah.setImageResource(R.drawable.pic_image_h_not);
                    }
                    this.z.e(str2, this);
                }
            }
            if (this.U == 1) {
                this.ag.setTextColor(-8682095);
                this.ai.setTextColor(-8682095);
                this.ao.setTextColor(-8682095);
            } else {
                this.ag.setTextColor(-10066330);
                this.ai.setTextColor(-10066330);
                this.ao.setTextColor(-14277082);
            }
            if (aqVar.e() == 0) {
                this.ao.setText(this.u.getResources().getString(R.string.pk_not_start));
            } else if (aqVar.e() == 1) {
                this.ao.setText(this.u.getResources().getString(R.string.pk_ing));
            } else if (aqVar.e() == 2) {
                if (this.U == 1) {
                    this.ag.setTextColor(-8682095);
                    this.ai.setTextColor(-8682095);
                    this.ao.setTextColor(-8682095);
                } else {
                    this.ag.setTextColor(-5065030);
                    this.ai.setTextColor(-5065030);
                    this.ao.setTextColor(-5065030);
                }
                this.ao.setText(this.u.getResources().getString(R.string.pk_end));
            }
            if (size >= 2) {
                this.Z.setVisibility(0);
                com.baidu.tieba.data.aq aqVar2 = (com.baidu.tieba.data.aq) this.C.e().get(1);
                if (aqVar2.b() != null) {
                    this.ak.setText(((com.baidu.tieba.data.aq) this.C.e().get(1)).b().a());
                    String str3 = String.valueOf(aqVar2.b().b()) + this.A + String.valueOf((int) R.id.kn_pk_2_left_image);
                    this.aj.setTag(str3);
                    com.baidu.adp.widget.a.b d3 = this.z.d(str3);
                    if (d3 != null) {
                        d3.b(this.aj);
                    } else {
                        if (this.U == 1) {
                            this.aj.setImageResource(R.drawable.pic_image_h_not_1);
                        } else {
                            this.aj.setImageResource(R.drawable.pic_image_h_not);
                        }
                        this.z.e(str3, this);
                    }
                }
                if (aqVar2.c() != null) {
                    this.am.setText(((com.baidu.tieba.data.aq) this.C.e().get(1)).c().a());
                    String str4 = String.valueOf(aqVar2.c().b()) + this.A + String.valueOf((int) R.id.kn_pk_2_right_image);
                    this.al.setTag(str4);
                    com.baidu.adp.widget.a.b d4 = this.z.d(str4);
                    if (d4 != null) {
                        d4.b(this.al);
                    } else {
                        if (this.U == 1) {
                            this.al.setImageResource(R.drawable.pic_image_h_not_1);
                        } else {
                            this.al.setImageResource(R.drawable.pic_image_h_not);
                        }
                        this.z.e(str4, this);
                    }
                }
                if (this.U == 1) {
                    this.ak.setTextColor(-8682095);
                    this.am.setTextColor(-8682095);
                    this.ap.setTextColor(-8682095);
                } else {
                    this.ak.setTextColor(-10066330);
                    this.am.setTextColor(-10066330);
                    this.ap.setTextColor(-14277082);
                }
                if (aqVar2.e() == 0) {
                    this.ap.setText(this.u.getResources().getString(R.string.pk_not_start));
                    return;
                } else if (aqVar2.e() == 1) {
                    this.ap.setText(this.u.getResources().getString(R.string.pk_ing));
                    return;
                } else if (aqVar2.e() == 2) {
                    if (this.U == 1) {
                        this.ak.setTextColor(-8682095);
                        this.am.setTextColor(-8682095);
                        this.ap.setTextColor(-8682095);
                    } else {
                        this.ak.setTextColor(-5065030);
                        this.am.setTextColor(-5065030);
                        this.ap.setTextColor(-5065030);
                    }
                    this.ap.setText(this.u.getResources().getString(R.string.pk_end));
                    return;
                } else {
                    return;
                }
            }
            this.Z.setVisibility(8);
        }
    }

    private void m() {
        if (this.C.a() != null) {
            this.X.setVisibility(0);
        } else {
            this.X.setVisibility(8);
        }
        this.ad.setText(String.valueOf(this.C.d()));
        this.ae.setText(String.valueOf(this.C.c()));
    }

    private void c(boolean z) {
        float f = 0.0f;
        Bitmap a2 = com.baidu.tieba.util.e.a((int) R.drawable.btn_like_n);
        if (a2 != null) {
            if (z) {
                this.o.setText(R.string.level_up);
                this.p.setText("");
            } else {
                this.o.setText(this.M);
                this.p.setText(String.valueOf(this.N) + "级");
            }
            float width = a2.getWidth() * this.O;
            float f2 = width > 0.001f ? this.P / width : 0.0f;
            this.P = width;
            if (this.Q) {
                this.Q = false;
            } else {
                f = f2;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams.width = a2.getWidth();
            this.r.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams2.width = (int) this.P;
            this.q.setLayoutParams(layoutParams2);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.q.startAnimation(scaleAnimation);
        }
    }

    public void a(float f) {
        if (this.O >= 0.999f) {
            this.Q = true;
        }
        this.O = f >= 1.0f ? 1.0f : f;
        c(f >= 1.0f);
    }

    public void a(int i, String str, int i2, float f) {
        this.M = str;
        this.N = i2;
        if (i == 0) {
            this.t = false;
            this.l.setVisibility(0);
            this.n.setVisibility(8);
            return;
        }
        this.t = true;
        this.l.setVisibility(4);
        a(f);
        this.n.setVisibility(0);
    }

    public void b(int i) {
        if (i == 0) {
            this.t = false;
            this.l.setVisibility(0);
            this.n.setVisibility(8);
            return;
        }
        this.t = true;
        this.l.setVisibility(4);
        this.n.setVisibility(0);
    }

    public void c(int i) {
        if (i == 0) {
            this.V = false;
            if (this.U == 1) {
                this.m.setBackgroundResource(R.drawable.frs_btn_sign_1);
                return;
            } else {
                this.m.setBackgroundResource(R.drawable.frs_btn_sign);
                return;
            }
        }
        this.V = true;
        if (this.U == 1) {
            this.m.setBackgroundResource(R.drawable.btn_sign_d_1);
        } else {
            this.m.setBackgroundResource(R.drawable.btn_sign_d);
        }
    }

    public boolean d() {
        return this.V;
    }

    public void a(boolean z) {
        this.T = z;
        if (this.T) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    public boolean e() {
        return this.t;
    }

    public void f() {
        if (this.aH != null) {
            this.aH.stop();
        }
    }

    public void g() {
        if (this.aH != null) {
            this.aH.stop();
        }
    }

    public void h() {
        if (this.aH != null) {
            this.aH.start();
        }
    }

    public void b(boolean z) {
        if (z) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        ImageView imageView;
        if (bVar != null && (imageView = (ImageView) this.s.findViewWithTag(str)) != null) {
            bVar.b(imageView);
            imageView.invalidate();
        }
    }
}
