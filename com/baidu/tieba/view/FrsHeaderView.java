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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class FrsHeaderView {
    public static int[] b = {R.drawable.label_green, R.drawable.label_blue, R.drawable.label_orange, R.drawable.label_red, R.drawable.label_purple};
    public static int[] c = {R.drawable.label_green_1, R.drawable.label_blue_1, R.drawable.label_orange_1, R.drawable.label_red_1, R.drawable.label_purple_1};
    private ProgressBar E;
    private FrsStarImageView G;
    private ImageView H;
    private com.baidu.tieba.util.a I;
    private ImageView J;
    private TextView K;
    private String L;
    private int M;
    private boolean R;
    private int S;
    private RelativeLayout d;
    private RelativeLayout e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private Button k;
    private RelativeLayout l;
    private ImageView m;
    private Button n;
    private Button o;
    private RelativeLayout p;
    private TextView q;
    private TextView r;
    private ImageView s;
    private ImageView t;
    private View u;
    private Activity v;
    private String w;
    private String x;
    private int y = 0;
    private int z = 0;
    private int A = -1;
    private String B = null;
    private String C = null;
    private String D = null;
    private boolean F = false;

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.bh f1824a = null;
    private float N = 0.0f;
    private float O = 0.0f;
    private boolean P = false;
    private boolean Q = true;
    private boolean T = false;
    private AnimationDrawable U = null;

    /* loaded from: classes.dex */
    public enum PAGE {
        FRS_LIST,
        FRS_IMAGE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PAGE[] valuesCustom() {
            PAGE[] valuesCustom = values();
            int length = valuesCustom.length;
            PAGE[] pageArr = new PAGE[length];
            System.arraycopy(valuesCustom, 0, pageArr, 0, length);
            return pageArr;
        }
    }

    public FrsHeaderView(Activity activity, PAGE page, String str, String str2) {
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
        this.E = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.v = activity;
        this.w = str;
        this.x = str2;
        this.u = LayoutInflater.from(activity).inflate(R.layout.frs_header, (ViewGroup) null);
        if (this.w == null || this.x == null) {
            this.u.setVisibility(8);
        }
        this.e = (RelativeLayout) this.u.findViewById(R.id.container);
        this.p = (RelativeLayout) this.u.findViewById(R.id.btn_love_content);
        this.q = (TextView) this.u.findViewById(R.id.level_name);
        this.r = (TextView) this.u.findViewById(R.id.level);
        this.s = (ImageView) this.u.findViewById(R.id.love_level_top);
        this.t = (ImageView) this.u.findViewById(R.id.love_level_bg);
        this.n = (Button) this.u.findViewById(R.id.btn_love);
        this.o = (Button) this.u.findViewById(R.id.btn_sign);
        this.f = (TextView) this.u.findViewById(R.id.member_num_text);
        this.i = (TextView) this.u.findViewById(R.id.post_num_text);
        this.h = (TextView) this.u.findViewById(R.id.member_image);
        this.g = (TextView) this.u.findViewById(R.id.post_image);
        this.j = (TextView) this.u.findViewById(R.id.title_text);
        this.l = (RelativeLayout) this.u.findViewById(R.id.lay_start_local);
        this.k = (Button) this.u.findViewById(R.id.btn_start_local);
        this.m = (ImageView) this.u.findViewById(R.id.img_voice_anim);
        this.d = (RelativeLayout) this.u.findViewById(R.id.frs_tag_layout);
        this.J = (ImageView) this.u.findViewById(R.id.frs_tag_bg);
        this.K = (TextView) this.u.findViewById(R.id.frs_tag_text);
        this.G = (FrsStarImageView) this.u.findViewById(R.id.frs_image);
        this.H = (ImageView) this.u.findViewById(R.id.frs_image_bg);
        this.E = (ProgressBar) this.u.findViewById(R.id.frs_title_progress);
        this.I = new com.baidu.tieba.util.a(this.v);
        this.I.a(UtilHelper.a((Context) this.v), UtilHelper.a((Context) this.v));
    }

    public void a(View.OnClickListener onClickListener) {
        this.n.setOnClickListener(onClickListener);
        this.o.setOnClickListener(onClickListener);
        this.J.setOnClickListener(new x(this));
        this.k.setOnClickListener(new y(this));
    }

    public com.baidu.tieba.util.a a() {
        return this.I;
    }

    public com.baidu.tieba.data.bh b() {
        return this.f1824a;
    }

    public void a(int i) {
        this.S = i;
        if (this.F) {
            c(1);
        } else {
            c(0);
        }
        this.G.invalidate();
        if (i == 1) {
            this.e.setBackgroundResource(R.drawable.bg_topbar_1);
            this.j.setTextColor(-8682095);
            this.f.setTextColor(-959965);
            this.i.setTextColor(-959965);
            this.H.setBackgroundResource(R.drawable.pic_bj_touxiang_n_1);
            if (this.A >= 0 && this.A < b.length) {
                this.J.setBackgroundResource(c[this.A]);
            }
            this.K.setTextColor(-2960686);
            this.n.setBackgroundResource(R.drawable.frs_btn_like_1);
            this.h.setTextColor(-10523526);
            this.g.setTextColor(-10523526);
            this.q.setTextColor(-8682095);
            this.r.setTextColor(-8682095);
            this.s.setBackgroundResource(R.drawable.progressbar_blue_1);
            this.t.setBackgroundResource(R.drawable.progressbar_black_1);
            return;
        }
        this.e.setBackgroundResource(R.drawable.bg_topbar);
        this.j.setTextColor(-12564913);
        this.f.setTextColor(-959965);
        this.i.setTextColor(-959965);
        this.H.setBackgroundResource(R.drawable.pic_bj_touxiang_n);
        if (this.A >= 0 && this.A < b.length) {
            this.J.setBackgroundResource(b[this.A]);
        }
        this.K.setTextColor(-1);
        this.n.setBackgroundResource(R.drawable.frs_btn_like);
        this.h.setTextColor(-8552574);
        this.g.setTextColor(-8552574);
        this.q.setTextColor(-14277082);
        this.r.setTextColor(-14277082);
        this.s.setBackgroundResource(R.drawable.progressbar_blue);
        this.t.setBackgroundResource(R.drawable.progressbar_black);
    }

    public View c() {
        return this.u;
    }

    public void a(com.baidu.tieba.data.v vVar) {
        this.w = vVar.b();
        this.x = vVar.a();
        this.y = vVar.d();
        this.z = vVar.c();
        this.B = vVar.m();
        this.C = vVar.o();
        this.D = vVar.n();
        this.L = vVar.k();
        this.M = vVar.h();
        if (vVar.f() == 0 || !TiebaApplication.g().am()) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            this.j.setMaxWidth(UtilHelper.a((Context) this.v, 100.0f));
            if (vVar.g() == 1) {
                if (this.U != null) {
                    this.U.stop();
                }
                this.m.setBackgroundResource(R.anim.voice_play);
                this.U = (AnimationDrawable) this.m.getBackground();
                this.U.start();
            }
        }
        this.u.setVisibility(0);
        this.f1824a = new com.baidu.tieba.data.bh();
        com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
        aiVar.a(3);
        aiVar.a(this.D);
        this.f1824a.m().add(aiVar);
        i();
    }

    private void i() {
        if (this.f != null) {
            this.f.setText(String.valueOf(this.y));
        }
        if (this.i != null) {
            this.i.setText(String.valueOf(this.z));
        }
        if (this.j != null) {
            this.j.setText(this.w);
        }
        if (this.B != null && this.B.length() > 0) {
            if (this.K != null) {
                this.K.setText(this.B);
            }
            if (this.J != null && this.C != null && this.C.length() > 0) {
                this.A = Integer.parseInt(this.C);
                if (this.A >= 0 && this.A < b.length) {
                    this.J.setBackgroundResource(b[this.A]);
                }
            }
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        this.G.setTag(this.D);
        this.G.setImageType(1);
    }

    public void a(int i, String str, int i2, float f) {
        this.L = str;
        this.M = i2;
        if (i == 0) {
            this.T = false;
            this.n.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.T = true;
        this.n.setVisibility(4);
        a(f);
        this.p.setVisibility(0);
    }

    public void b(int i) {
        if (i == 0) {
            this.T = false;
            this.n.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.T = true;
        this.n.setVisibility(4);
        this.p.setVisibility(0);
    }

    private void c(boolean z) {
        float f = 0.0f;
        Bitmap a2 = com.baidu.tieba.util.e.a((int) R.drawable.btn_like_n);
        if (a2 != null) {
            if (z) {
                this.q.setText(R.string.level_up);
                this.r.setText("");
            } else {
                this.q.setText(this.L);
                this.r.setText(String.valueOf(this.M) + "级");
            }
            float width = a2.getWidth() * this.N;
            float f2 = width > 0.001f ? this.O / width : 0.0f;
            this.O = width;
            if (this.P) {
                this.P = false;
            } else {
                f = f2;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams.width = a2.getWidth();
            this.t.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
            layoutParams2.width = (int) this.O;
            this.s.setLayoutParams(layoutParams2);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.s.startAnimation(scaleAnimation);
        }
    }

    public void c(int i) {
        if (i == 0) {
            this.F = false;
            if (this.S == 1) {
                this.o.setBackgroundResource(R.drawable.frs_btn_sign_1);
                return;
            } else {
                this.o.setBackgroundResource(R.drawable.frs_btn_sign);
                return;
            }
        }
        this.F = true;
        if (this.S == 1) {
            this.o.setBackgroundResource(R.drawable.btn_sign_d_1);
        } else {
            this.o.setBackgroundResource(R.drawable.btn_sign_d);
        }
    }

    public boolean d() {
        return this.F;
    }

    public void a(boolean z) {
        this.R = z;
        if (this.R) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }

    public void a(float f) {
        if (this.N >= 0.999f) {
            this.P = true;
        }
        this.N = f >= 1.0f ? 1.0f : f;
        c(f >= 1.0f);
    }

    public void e() {
        if (this.U != null) {
            this.U.stop();
        }
    }

    public void f() {
        if (this.U != null) {
            this.U.stop();
        }
    }

    public void g() {
        if (this.U != null) {
            this.U.start();
        }
    }

    public boolean h() {
        return this.T;
    }

    public void b(boolean z) {
        if (z) {
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(8);
        }
    }
}
