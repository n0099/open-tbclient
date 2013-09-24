package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
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
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.a.d {
    private com.baidu.tieba.util.a A;
    private FrsStarImageView B;
    private FrsStarImageView C;
    private ImageView D;
    private Button E;
    private TextView F;
    private CustomTimerView G;
    private ImageView H;
    private TextView I;
    private String J;
    private int K;
    private RelativeLayout O;
    private RelativeLayout P;
    private boolean Q;
    private int R;
    private LinearLayout T;
    private RelativeLayout U;
    private RelativeLayout V;
    private RelativeLayout W;
    private LinearLayout X;
    private TextView Y;
    private TextView Z;
    private ImageView aA;
    private ImageView aE;
    private TextView aa;
    private TextView ab;
    private HeadImageView ac;
    private TextView ad;
    private HeadImageView ae;
    private TextView af;
    private HeadImageView ag;
    private TextView ah;
    private HeadImageView ai;
    private TextView aj;
    private TextView ak;
    private TextView al;
    private TextView am;
    private TextView an;
    private TextView ao;
    private RelativeLayout ap;
    private RelativeLayout aq;
    private ImageView ar;
    private ImageView as;
    private ImageView at;
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
    private TextView f;
    private TextView g;
    private TextView h;
    private Button i;
    private Button j;
    private RelativeLayout k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private ImageView o;
    private View p;
    private Activity r;
    private String s;
    private String t;
    private com.baidu.tieba.util.a w;
    private boolean q = false;
    private int u = 0;
    private int v = 0;
    private String x = "?tag=";
    private com.baidu.tieba.data.z y = null;
    private com.baidu.tieba.data.bf z = null;

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.bh f1966a = null;
    private float L = 0.0f;
    private float M = 0.0f;
    private boolean N = false;
    private boolean S = false;
    private boolean aB = true;
    private boolean aC = true;
    private View.OnClickListener aD = null;

    public ac(Activity activity, String str, String str2) {
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
        this.r = null;
        this.s = null;
        this.t = null;
        this.w = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.O = null;
        this.P = null;
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
        this.r = activity;
        this.w = new com.baidu.tieba.util.a(this.r);
        int a2 = UtilHelper.a((Context) this.r, 54.0f);
        this.w.a(a2, a2);
        this.s = str;
        this.t = str2;
        this.p = LayoutInflater.from(activity).inflate(R.layout.frs_star_title, (ViewGroup) null);
        if (this.s == null || this.t == null) {
            this.p.setVisibility(8);
        }
        this.c = (ProgressBar) this.p.findViewById(R.id.frs_star_title_progress);
        this.d = (RelativeLayout) this.p.findViewById(R.id.frs_star_title);
        this.k = (RelativeLayout) this.p.findViewById(R.id.btn_love_content);
        this.l = (TextView) this.p.findViewById(R.id.level_name);
        this.m = (TextView) this.p.findViewById(R.id.level);
        this.n = (ImageView) this.p.findViewById(R.id.love_level_top);
        this.o = (ImageView) this.p.findViewById(R.id.love_level_bg);
        this.i = (Button) this.p.findViewById(R.id.btn_love);
        this.j = (Button) this.p.findViewById(R.id.btn_sign);
        this.b = (TextView) this.p.findViewById(R.id.member_num_text);
        this.e = (TextView) this.p.findViewById(R.id.post_num_text);
        this.g = (TextView) this.p.findViewById(R.id.member_image);
        this.f = (TextView) this.p.findViewById(R.id.post_image);
        this.h = (TextView) this.p.findViewById(R.id.title_text);
        this.O = (RelativeLayout) this.p.findViewById(R.id.fan_timer_layout);
        this.P = (RelativeLayout) this.p.findViewById(R.id.fan_num_layout);
        this.H = (ImageView) this.p.findViewById(R.id.fan_num_icon);
        this.B = (FrsStarImageView) this.p.findViewById(R.id.frs_star_top_pic);
        this.C = (FrsStarImageView) this.p.findViewById(R.id.frs_star_bottom_photo);
        this.D = (ImageView) this.p.findViewById(R.id.frs_star_bottom_bg);
        this.E = (Button) this.p.findViewById(R.id.add_fan);
        this.F = (TextView) this.p.findViewById(R.id.fan_num);
        this.I = (TextView) this.p.findViewById(R.id.add_fan_intro_text);
        this.G = (CustomTimerView) this.p.findViewById(R.id.open_timer);
        this.G.setTextSize(10);
        this.G.setTextColor(-14277082);
        this.G.setNumSize(12);
        this.G.setNumColor(-12809494);
        this.G.setTextMargin(3);
        this.G.setNumMargin(2);
        this.T = (LinearLayout) this.p.findViewById(R.id.kn_layout);
        this.U = (RelativeLayout) this.p.findViewById(R.id.kn_title_layout);
        this.V = (RelativeLayout) this.p.findViewById(R.id.kn_pk_1_layout);
        this.W = (RelativeLayout) this.p.findViewById(R.id.kn_pk_2_layout);
        this.X = (LinearLayout) this.p.findViewById(R.id.kn_bottom_layout);
        this.Y = (TextView) this.p.findViewById(R.id.kn_rank_title);
        this.Z = (TextView) this.p.findViewById(R.id.kn_vote_title);
        this.aa = (TextView) this.p.findViewById(R.id.kn_rank_text);
        this.ab = (TextView) this.p.findViewById(R.id.kn_vote_text);
        this.ak = (TextView) this.p.findViewById(R.id.kn_support_text);
        this.al = (TextView) this.p.findViewById(R.id.kn_support_text_1);
        this.am = (TextView) this.p.findViewById(R.id.kn_support_text_2);
        this.an = (TextView) this.p.findViewById(R.id.kn_relative_video_text);
        this.ao = (TextView) this.p.findViewById(R.id.kn_relative_music_text);
        this.ac = (HeadImageView) this.p.findViewById(R.id.kn_pk_1_left_image);
        this.ae = (HeadImageView) this.p.findViewById(R.id.kn_pk_1_right_image);
        this.ag = (HeadImageView) this.p.findViewById(R.id.kn_pk_2_left_image);
        this.ai = (HeadImageView) this.p.findViewById(R.id.kn_pk_2_right_image);
        this.ad = (TextView) this.p.findViewById(R.id.kn_pk_1_left_text);
        this.af = (TextView) this.p.findViewById(R.id.kn_pk_1_right_text);
        this.ah = (TextView) this.p.findViewById(R.id.kn_pk_2_left_text);
        this.aj = (TextView) this.p.findViewById(R.id.kn_pk_2_right_text);
        this.ap = (RelativeLayout) this.p.findViewById(R.id.kn_relative_video);
        this.aq = (RelativeLayout) this.p.findViewById(R.id.kn_relative_music);
        this.ar = (ImageView) this.p.findViewById(R.id.kn_title_divider);
        this.as = (ImageView) this.p.findViewById(R.id.kn_pk1_divider);
        this.at = (ImageView) this.p.findViewById(R.id.kn_pk2_divider);
        this.au = (ImageView) this.p.findViewById(R.id.kn_pk_1_vs);
        this.av = (ImageView) this.p.findViewById(R.id.kn_pk_2_vs);
        this.aw = (ImageView) this.p.findViewById(R.id.kn_support_image);
        this.ax = (ImageView) this.p.findViewById(R.id.kn_support_image_1);
        this.ay = (ImageView) this.p.findViewById(R.id.kn_support_image_2);
        this.az = (ImageView) this.p.findViewById(R.id.kn_relative_video_icon);
        this.aA = (ImageView) this.p.findViewById(R.id.kn_relative_music_icon);
        this.A = new com.baidu.tieba.util.a(this.r);
        this.A.a(UtilHelper.a((Context) this.r), UtilHelper.a((Context) this.r));
        this.aE = (ImageView) this.p.findViewById(R.id.frs_enter_detail);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.aE.setVisibility(0);
        } else {
            this.aE.setVisibility(8);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.aD = onClickListener;
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.p.setOnClickListener(new ad(this));
        }
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.U.setOnClickListener(onClickListener);
        this.V.setOnClickListener(onClickListener);
        this.W.setOnClickListener(onClickListener);
        this.ap.setOnClickListener(onClickListener);
        this.aq.setOnClickListener(onClickListener);
        this.E.setOnClickListener(onClickListener);
    }

    public com.baidu.tieba.util.a a() {
        return this.A;
    }

    public com.baidu.tieba.data.bh b() {
        return this.f1966a;
    }

    public void a(int i) {
        this.R = i;
        if (this.S) {
            b(1);
        } else {
            b(0);
        }
        this.C.invalidate();
        if (i == 1) {
            this.d.setBackgroundResource(R.drawable.bg_topbar_1);
            this.h.setTextColor(-8682095);
            this.b.setTextColor(-959965);
            this.e.setTextColor(-959965);
            this.D.setBackgroundResource(R.drawable.pic_bj_touxiang_n_1);
            this.i.setBackgroundResource(R.drawable.frs_btn_like_1);
            this.g.setTextColor(-10523526);
            this.f.setTextColor(-10523526);
            this.l.setTextColor(-8682095);
            this.m.setTextColor(-8682095);
            this.n.setBackgroundResource(R.drawable.progressbar_blue_1);
            this.o.setBackgroundResource(R.drawable.progressbar_black_1);
            this.E.setBackgroundResource(R.drawable.frs_star_add_fan_1);
            this.E.setTextColor(-12687203);
            this.H.setBackgroundResource(R.drawable.label_no_1);
            this.F.setTextColor(-5947365);
            this.I.setTextColor(-11446171);
            this.G.setTextColor(-10523526);
            this.G.setNumColor(-12687203);
            this.T.setBackgroundResource(R.drawable.frs_pk_bg_1);
            this.Y.setTextColor(-8682095);
            this.Z.setTextColor(-8682095);
            this.aa.setTextColor(-959965);
            this.ab.setTextColor(-959965);
            this.ak.setTextColor(-8682095);
            this.al.setTextColor(-8682095);
            this.am.setTextColor(-8682095);
            this.ad.setTextColor(-8682095);
            this.af.setTextColor(-8682095);
            this.ah.setTextColor(-8682095);
            this.aj.setTextColor(-8682095);
            this.ar.setBackgroundResource(R.drawable.discovery_dot_line_1);
            this.as.setBackgroundResource(R.drawable.discovery_dot_line_1);
            this.at.setBackgroundResource(R.drawable.discovery_dot_line_1);
            this.au.setBackgroundResource(R.drawable.icon_frs_vs_1);
            this.av.setBackgroundResource(R.drawable.icon_frs_vs_1);
            this.aw.setBackgroundResource(R.drawable.icon_frs_arrows_1);
            this.ax.setBackgroundResource(R.drawable.icon_frs_arrows_1);
            this.ay.setBackgroundResource(R.drawable.icon_frs_arrows_1);
            if (this.aC) {
                this.ap.setBackgroundResource(R.drawable.btn_frs_video_1);
                this.an.setTextColor(-12810784);
                this.az.setBackgroundResource(R.drawable.icon_frs_video_n_1);
            } else {
                this.ap.setBackgroundResource(R.drawable.btn_frs_video_d_1);
                this.an.setTextColor(-8682095);
                this.az.setBackgroundResource(R.drawable.icon_frs_video_d_1);
            }
            if (this.aB) {
                this.aq.setBackgroundResource(R.drawable.btn_frs_video_1);
                this.ao.setTextColor(-12810784);
                this.aA.setBackgroundResource(R.drawable.icon_frs_music_n_1);
            } else {
                this.aq.setBackgroundResource(R.drawable.btn_frs_video_d_1);
                this.ao.setTextColor(-8682095);
                this.aA.setBackgroundResource(R.drawable.icon_frs_music_d_1);
            }
            this.aE.setImageResource(R.drawable.icon_arrow_right_1);
            return;
        }
        this.aE.setImageResource(R.drawable.icon_arrow_right);
        this.d.setBackgroundResource(R.drawable.bg_topbar);
        this.h.setTextColor(-12564913);
        this.b.setTextColor(-959965);
        this.e.setTextColor(-959965);
        this.i.setBackgroundResource(R.drawable.frs_btn_like);
        this.g.setTextColor(-8552574);
        this.f.setTextColor(-8552574);
        this.D.setBackgroundResource(R.drawable.pic_bj_touxiang_n);
        this.l.setTextColor(-14277082);
        this.m.setTextColor(-14277082);
        this.n.setBackgroundResource(R.drawable.progressbar_blue);
        this.o.setBackgroundResource(R.drawable.progressbar_black);
        this.E.setBackgroundResource(R.drawable.frs_star_add_fan);
        this.E.setTextColor(-12810784);
        this.H.setBackgroundResource(R.drawable.label_no);
        this.F.setTextColor(-3060450);
        this.I.setTextColor(-7100744);
        this.G.setTextColor(-14277082);
        this.G.setNumColor(-12809494);
        this.T.setBackgroundResource(R.drawable.frs_pk_bg);
        this.Y.setTextColor(-14277082);
        this.Z.setTextColor(-14277082);
        this.aa.setTextColor(-959965);
        this.ab.setTextColor(-959965);
        this.ak.setTextColor(-14277082);
        this.al.setTextColor(-14277082);
        this.am.setTextColor(-14277082);
        this.ad.setTextColor(-10066330);
        this.af.setTextColor(-10066330);
        this.ah.setTextColor(-10066330);
        this.aj.setTextColor(-10066330);
        this.ar.setBackgroundResource(R.drawable.discovery_dot_line);
        this.as.setBackgroundResource(R.drawable.discovery_dot_line);
        this.at.setBackgroundResource(R.drawable.discovery_dot_line);
        this.au.setBackgroundResource(R.drawable.icon_frs_vs);
        this.av.setBackgroundResource(R.drawable.icon_frs_vs);
        this.aw.setBackgroundResource(R.drawable.icon_frs_arrows);
        this.ax.setBackgroundResource(R.drawable.icon_frs_arrows);
        this.ay.setBackgroundResource(R.drawable.icon_frs_arrows);
        this.az.setBackgroundResource(R.drawable.icon_frs_video_n);
        this.aA.setBackgroundResource(R.drawable.icon_frs_music_n);
        if (this.aC) {
            this.ap.setBackgroundResource(R.drawable.btn_frs_video);
            this.an.setTextColor(-12810784);
            this.az.setBackgroundResource(R.drawable.icon_frs_video_n);
        } else {
            this.ap.setBackgroundResource(R.drawable.btn_frs_video_d);
            this.an.setTextColor(-5065030);
            this.az.setBackgroundResource(R.drawable.icon_frs_video_d);
        }
        if (this.aB) {
            this.aq.setBackgroundResource(R.drawable.btn_frs_video);
            this.ao.setTextColor(-12810784);
            this.aA.setBackgroundResource(R.drawable.icon_frs_music_n);
            return;
        }
        this.aq.setBackgroundResource(R.drawable.btn_frs_video_d);
        this.ao.setTextColor(-5065030);
        this.aA.setBackgroundResource(R.drawable.icon_frs_music_d);
    }

    public View c() {
        return this.p;
    }

    public void a(com.baidu.tieba.data.v vVar, com.baidu.tieba.data.z zVar) {
        this.s = vVar.b();
        this.t = vVar.a();
        this.u = vVar.d();
        this.v = vVar.c();
        this.y = zVar;
        this.f1966a = new com.baidu.tieba.data.bh();
        if (this.y != null) {
            this.z = this.y.l();
            com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
            aiVar.a(3);
            aiVar.a(this.y.b());
            this.f1966a.o().add(aiVar);
            com.baidu.tieba.data.ai aiVar2 = new com.baidu.tieba.data.ai();
            aiVar2.a(3);
            aiVar2.a(this.y.c());
            this.f1966a.o().add(aiVar2);
        }
        this.p.setVisibility(0);
        f();
    }

    private void f() {
        if (this.b != null) {
            this.b.setText(String.valueOf(this.u));
        }
        if (this.e != null) {
            this.e.setText(String.valueOf(this.v));
        }
        if (this.h != null) {
            this.h.setText(String.valueOf(this.s) + "吧");
        }
        this.B.setImageType(0);
        this.C.setImageType(1);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
        layoutParams.width = UtilHelper.a((Context) this.r);
        if (this.y.d() == 0) {
            layoutParams.height = 1;
        } else {
            layoutParams.height = (layoutParams.width * this.y.e()) / this.y.d();
        }
        this.B.setLayoutParams(layoutParams);
        this.B.setTag(this.y.b());
        this.C.setTag(this.y.c());
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams2.width = UtilHelper.a((Context) this.r) / 4;
        if (this.y.f() == 0) {
            layoutParams2.height = layoutParams2.width;
        } else {
            layoutParams2.height = (layoutParams2.width * this.y.g()) / this.y.f();
        }
        this.C.setLayoutParams(layoutParams2);
        if (this.y.h() == 0) {
            this.P.setVisibility(8);
            this.E.setVisibility(8);
            if (this.y.i() <= 0) {
                this.O.setVisibility(8);
            } else {
                this.O.setVisibility(0);
            }
        } else {
            this.O.setVisibility(8);
            if (this.y.j() == 0) {
                this.P.setVisibility(8);
                this.E.setVisibility(0);
            } else {
                this.E.setVisibility(8);
                this.P.setVisibility(0);
                this.F.setText(String.valueOf(this.y.k()));
            }
        }
        if (this.z != null) {
            g();
        }
    }

    private void g() {
        if (this.z.f()) {
            this.T.setVisibility(0);
            j();
            i();
            h();
            return;
        }
        this.T.setVisibility(8);
    }

    private void h() {
        if (this.z.g() == 0 && this.z.h() == 0) {
            this.X.setVisibility(8);
            return;
        }
        this.X.setVisibility(0);
        if (this.z.g() == 0) {
            this.aB = false;
            this.aq.setClickable(false);
            this.aq.setOnClickListener(null);
        } else {
            this.aB = true;
            this.aq.setClickable(true);
            this.aq.setOnClickListener(this.aD);
        }
        if (this.z.h() == 0) {
            this.aC = false;
            this.ap.setClickable(false);
            this.ap.setOnClickListener(null);
        } else {
            this.aC = true;
            this.ap.setClickable(true);
            this.ap.setOnClickListener(this.aD);
        }
        if (this.R == 1) {
            if (this.aC) {
                this.ap.setBackgroundResource(R.drawable.btn_frs_video_1);
                this.an.setTextColor(-12810784);
                this.az.setBackgroundResource(R.drawable.icon_frs_video_n_1);
            } else {
                this.ap.setBackgroundResource(R.drawable.btn_frs_video_d_1);
                this.an.setTextColor(-8682095);
                this.az.setBackgroundResource(R.drawable.icon_frs_video_d_1);
            }
            if (this.aB) {
                this.aq.setBackgroundResource(R.drawable.btn_frs_video_1);
                this.ao.setTextColor(-12810784);
                this.aA.setBackgroundResource(R.drawable.icon_frs_music_n_1);
                return;
            }
            this.aq.setBackgroundResource(R.drawable.btn_frs_video_d_1);
            this.ao.setTextColor(-8682095);
            this.aA.setBackgroundResource(R.drawable.icon_frs_music_d_1);
            return;
        }
        if (this.aC) {
            this.ap.setBackgroundResource(R.drawable.btn_frs_video);
            this.an.setTextColor(-12810784);
            this.az.setBackgroundResource(R.drawable.icon_frs_video_n);
        } else {
            this.ap.setBackgroundResource(R.drawable.btn_frs_video_d);
            this.an.setTextColor(-5065030);
            this.az.setBackgroundResource(R.drawable.icon_frs_video_d);
        }
        if (this.aB) {
            this.aq.setBackgroundResource(R.drawable.btn_frs_video);
            this.ao.setTextColor(-12810784);
            this.aA.setBackgroundResource(R.drawable.icon_frs_music_n);
            return;
        }
        this.aq.setBackgroundResource(R.drawable.btn_frs_video_d);
        this.ao.setTextColor(-5065030);
        this.aA.setBackgroundResource(R.drawable.icon_frs_music_d);
    }

    private void i() {
        int size = this.z.e().size();
        if (size == 0) {
            this.V.setVisibility(8);
            this.W.setVisibility(8);
        } else if (size >= 1) {
            this.V.setVisibility(0);
            com.baidu.tieba.data.am amVar = this.z.e().get(0);
            if (amVar.b() != null) {
                this.ad.setText(amVar.b().a());
                String str = String.valueOf(amVar.b().b()) + this.x + String.valueOf((int) R.id.kn_pk_1_left_image);
                this.ac.setTag(str);
                com.baidu.adp.widget.a.c d = this.w.d(str);
                if (d != null) {
                    d.a(this.ac);
                } else {
                    if (this.R == 1) {
                        this.ac.setImageResource(R.drawable.pic_image_h_not_1);
                    } else {
                        this.ac.setImageResource(R.drawable.pic_image_h_not);
                    }
                    this.w.e(str, this);
                }
            }
            if (amVar.c() != null) {
                this.af.setText(this.z.e().get(0).c().a());
                String str2 = String.valueOf(amVar.c().b()) + this.x + String.valueOf((int) R.id.kn_pk_1_right_image);
                this.ae.setTag(str2);
                com.baidu.adp.widget.a.c d2 = this.w.d(str2);
                if (d2 != null) {
                    d2.a(this.ae);
                } else {
                    if (this.R == 1) {
                        this.ae.setImageResource(R.drawable.pic_image_h_not_1);
                    } else {
                        this.ae.setImageResource(R.drawable.pic_image_h_not);
                    }
                    this.w.e(str2, this);
                }
            }
            if (this.R == 1) {
                this.ad.setTextColor(-8682095);
                this.af.setTextColor(-8682095);
                this.al.setTextColor(-8682095);
            } else {
                this.ad.setTextColor(-10066330);
                this.af.setTextColor(-10066330);
                this.al.setTextColor(-14277082);
            }
            if (amVar.e() == 0) {
                this.al.setText(this.r.getResources().getString(R.string.pk_not_start));
            } else if (amVar.e() == 1) {
                this.al.setText(this.r.getResources().getString(R.string.pk_ing));
            } else if (amVar.e() == 2) {
                if (this.R == 1) {
                    this.ad.setTextColor(-8682095);
                    this.af.setTextColor(-8682095);
                    this.al.setTextColor(-8682095);
                } else {
                    this.ad.setTextColor(-5065030);
                    this.af.setTextColor(-5065030);
                    this.al.setTextColor(-5065030);
                }
                this.al.setText(this.r.getResources().getString(R.string.pk_end));
            }
            if (size >= 2) {
                this.W.setVisibility(0);
                com.baidu.tieba.data.am amVar2 = this.z.e().get(1);
                if (amVar2.b() != null) {
                    this.ah.setText(this.z.e().get(1).b().a());
                    String str3 = String.valueOf(amVar2.b().b()) + this.x + String.valueOf((int) R.id.kn_pk_2_left_image);
                    this.ag.setTag(str3);
                    com.baidu.adp.widget.a.c d3 = this.w.d(str3);
                    if (d3 != null) {
                        d3.a(this.ag);
                    } else {
                        if (this.R == 1) {
                            this.ag.setImageResource(R.drawable.pic_image_h_not_1);
                        } else {
                            this.ag.setImageResource(R.drawable.pic_image_h_not);
                        }
                        this.w.e(str3, this);
                    }
                }
                if (amVar2.c() != null) {
                    this.aj.setText(this.z.e().get(1).c().a());
                    String str4 = String.valueOf(amVar2.c().b()) + this.x + String.valueOf((int) R.id.kn_pk_2_right_image);
                    this.ai.setTag(str4);
                    com.baidu.adp.widget.a.c d4 = this.w.d(str4);
                    if (d4 != null) {
                        d4.a(this.ai);
                    } else {
                        if (this.R == 1) {
                            this.ai.setImageResource(R.drawable.pic_image_h_not_1);
                        } else {
                            this.ai.setImageResource(R.drawable.pic_image_h_not);
                        }
                        this.w.e(str4, this);
                    }
                }
                if (this.R == 1) {
                    this.ah.setTextColor(-8682095);
                    this.aj.setTextColor(-8682095);
                    this.am.setTextColor(-8682095);
                } else {
                    this.ah.setTextColor(-10066330);
                    this.aj.setTextColor(-10066330);
                    this.am.setTextColor(-14277082);
                }
                if (amVar2.e() == 0) {
                    this.am.setText(this.r.getResources().getString(R.string.pk_not_start));
                    return;
                } else if (amVar2.e() == 1) {
                    this.am.setText(this.r.getResources().getString(R.string.pk_ing));
                    return;
                } else if (amVar2.e() == 2) {
                    if (this.R == 1) {
                        this.ah.setTextColor(-8682095);
                        this.aj.setTextColor(-8682095);
                        this.am.setTextColor(-8682095);
                    } else {
                        this.ah.setTextColor(-5065030);
                        this.aj.setTextColor(-5065030);
                        this.am.setTextColor(-5065030);
                    }
                    this.am.setText(this.r.getResources().getString(R.string.pk_end));
                    return;
                } else {
                    return;
                }
            }
            this.W.setVisibility(8);
        }
    }

    private void j() {
        if (this.z.a() != null) {
            this.U.setVisibility(0);
        } else {
            this.U.setVisibility(8);
        }
        this.aa.setText(String.valueOf(this.z.d()));
        this.ab.setText(String.valueOf(this.z.c()));
    }

    private void c(boolean z) {
        float f = 0.0f;
        Bitmap a2 = com.baidu.tieba.util.e.a((int) R.drawable.btn_like_n);
        if (a2 != null) {
            if (z) {
                this.l.setText(R.string.level_up);
                this.m.setText("");
            } else {
                this.l.setText(this.J);
                this.m.setText(String.valueOf(this.K) + "级");
            }
            float width = a2.getWidth() * this.L;
            float f2 = width > 0.001f ? this.M / width : 0.0f;
            this.M = width;
            if (this.N) {
                this.N = false;
            } else {
                f = f2;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.width = a2.getWidth();
            this.o.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams2.width = (int) this.M;
            this.n.setLayoutParams(layoutParams2);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.n.startAnimation(scaleAnimation);
        }
    }

    public void a(float f) {
        if (this.L >= 0.999f) {
            this.N = true;
        }
        this.L = f >= 1.0f ? 1.0f : f;
        c(f >= 1.0f);
    }

    public void a(int i, String str, int i2, float f) {
        this.J = str;
        this.K = i2;
        if (i == 0) {
            this.q = false;
            this.i.setVisibility(0);
            this.k.setVisibility(8);
            return;
        }
        this.q = true;
        this.i.setVisibility(4);
        a(f);
        this.k.setVisibility(0);
    }

    public void b(int i) {
        if (i == 0) {
            this.S = false;
            if (this.R == 1) {
                this.j.setBackgroundResource(R.drawable.frs_btn_sign_1);
                return;
            } else {
                this.j.setBackgroundResource(R.drawable.frs_btn_sign);
                return;
            }
        }
        this.S = true;
        if (this.R == 1) {
            this.j.setBackgroundResource(R.drawable.btn_sign_d_1);
        } else {
            this.j.setBackgroundResource(R.drawable.btn_sign_d);
        }
    }

    public boolean d() {
        return this.S;
    }

    public void a(boolean z) {
        this.Q = z;
        if (this.Q) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public boolean e() {
        return this.q;
    }

    public void b(boolean z) {
        if (z) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        ImageView imageView;
        if (cVar != null && (imageView = (ImageView) this.p.findViewWithTag(str)) != null) {
            cVar.a(imageView);
            imageView.invalidate();
        }
    }
}
