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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.a.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class n {
    private FrsStarImageView A;
    private ImageView B;
    private com.baidu.tieba.d.a C;
    private ImageView D;
    private TextView E;
    private String F;
    private int G;
    private boolean M;
    private int N;
    private RelativeLayout b;
    private RelativeLayout c;
    private TextView d;
    private ImageView e;
    private ImageView f;
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
    private Activity q;
    private String r;
    private String s;
    private int t = 0;
    private int u = 0;
    private int v = -1;
    private String w = null;
    private String x = null;
    private String y = null;
    private boolean z = false;
    bb a = null;
    private float H = 0.0f;
    private float I = 0.0f;
    private boolean J = false;
    private int[] K = {R.drawable.label_green, R.drawable.label_blue, R.drawable.label_orange, R.drawable.label_red, R.drawable.label_purple};
    private int[] L = {R.drawable.label_green_1, R.drawable.label_blue_1, R.drawable.label_orange_1, R.drawable.label_red_1, R.drawable.label_purple_1};
    private boolean O = false;

    public n(Activity activity, o oVar, String str, String str2) {
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
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.q = activity;
        this.r = str;
        this.s = str2;
        this.p = LayoutInflater.from(activity).inflate(R.layout.frs_header, (ViewGroup) null);
        if (this.r == null || this.s == null) {
            this.p.setVisibility(8);
        }
        this.c = (RelativeLayout) this.p.findViewById(R.id.container);
        this.k = (RelativeLayout) this.p.findViewById(R.id.btn_love_content);
        this.l = (TextView) this.p.findViewById(R.id.level_name);
        this.m = (TextView) this.p.findViewById(R.id.level);
        this.n = (ImageView) this.p.findViewById(R.id.love_level_top);
        this.o = (ImageView) this.p.findViewById(R.id.love_level_bg);
        this.i = (Button) this.p.findViewById(R.id.btn_love);
        this.j = (Button) this.p.findViewById(R.id.btn_sign);
        this.d = (TextView) this.p.findViewById(R.id.member_num_text);
        this.g = (TextView) this.p.findViewById(R.id.post_num_text);
        this.f = (ImageView) this.p.findViewById(R.id.member_image);
        this.e = (ImageView) this.p.findViewById(R.id.post_image);
        this.h = (TextView) this.p.findViewById(R.id.title_text);
        this.b = (RelativeLayout) this.p.findViewById(R.id.frs_tag_layout);
        this.D = (ImageView) this.p.findViewById(R.id.frs_tag_bg);
        this.E = (TextView) this.p.findViewById(R.id.frs_tag_text);
        this.A = (FrsStarImageView) this.p.findViewById(R.id.frs_image);
        this.B = (ImageView) this.p.findViewById(R.id.frs_image_bg);
        this.C = new com.baidu.tieba.d.a(this.q);
        this.C.a(com.baidu.tieba.d.ag.a((Context) this.q), com.baidu.tieba.d.ag.a((Context) this.q));
    }

    public void a(View.OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
    }

    public com.baidu.tieba.d.a a() {
        return this.C;
    }

    public bb b() {
        return this.a;
    }

    public void a(int i) {
        this.N = i;
        if (this.z) {
            c(1);
        } else {
            c(0);
        }
        this.A.invalidate();
        if (i == 1) {
            this.c.setBackgroundResource(R.drawable.bg_topbar_1);
            this.h.setTextColor(-8682095);
            this.d.setTextColor(-11446171);
            this.g.setTextColor(-11446171);
            this.B.setBackgroundResource(R.drawable.pic_bj_touxiang_n_1);
            if (this.v >= 0 && this.v < this.K.length) {
                this.D.setBackgroundResource(this.L[this.v]);
            }
            this.E.setTextColor(-2960686);
            this.i.setBackgroundResource(R.drawable.frs_btn_like_1);
            this.f.setBackgroundResource(R.drawable.icon_little_people_1);
            this.e.setBackgroundResource(R.drawable.icon_little_discuss_1);
            this.l.setTextColor(-8682095);
            this.m.setTextColor(-8682095);
            this.n.setBackgroundResource(R.drawable.progressbar_blue_1);
            this.o.setBackgroundResource(R.drawable.progressbar_black_1);
            return;
        }
        this.c.setBackgroundResource(R.drawable.bg_topbar);
        this.h.setTextColor(-12564913);
        this.d.setTextColor(-5065030);
        this.g.setTextColor(-5065030);
        this.B.setBackgroundResource(R.drawable.pic_bj_touxiang_n);
        if (this.v >= 0 && this.v < this.K.length) {
            this.D.setBackgroundResource(this.K[this.v]);
        }
        this.E.setTextColor(-1);
        this.i.setBackgroundResource(R.drawable.frs_btn_like);
        this.f.setBackgroundResource(R.drawable.icon_little_people);
        this.e.setBackgroundResource(R.drawable.icon_little_discuss);
        this.l.setTextColor(-14277082);
        this.m.setTextColor(-14277082);
        this.n.setBackgroundResource(R.drawable.progressbar_blue);
        this.o.setBackgroundResource(R.drawable.progressbar_black);
    }

    public View c() {
        return this.p;
    }

    public void a(com.baidu.tieba.a.s sVar) {
        this.r = sVar.b();
        this.s = sVar.a();
        this.t = sVar.d();
        this.u = sVar.c();
        this.w = sVar.k();
        this.x = sVar.m();
        this.y = sVar.l();
        this.F = sVar.i();
        this.G = sVar.f();
        this.p.setVisibility(0);
        this.a = new bb();
        com.baidu.tieba.a.ag agVar = new com.baidu.tieba.a.ag();
        agVar.a(3);
        agVar.a(this.y);
        this.a.m().add(agVar);
        g();
    }

    private void g() {
        if (this.d != null) {
            this.d.setText(String.valueOf(this.t));
        }
        if (this.g != null) {
            this.g.setText(String.valueOf(this.u));
        }
        if (this.h != null) {
            this.h.setText(this.r);
        }
        if (this.w != null && this.w.length() > 0) {
            if (this.E != null) {
                this.E.setText(this.w);
            }
            if (this.D != null && this.x != null && this.x.length() > 0) {
                this.v = Integer.parseInt(this.x);
                if (this.v >= 0 && this.v < this.K.length) {
                    this.D.setBackgroundResource(this.K[this.v]);
                }
            }
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        this.A.setTag(this.y);
        this.A.setImageType(1);
    }

    public void a(int i, String str, int i2, float f) {
        this.F = str;
        this.G = i2;
        if (i == 0) {
            this.O = false;
            this.i.setVisibility(0);
            this.k.setVisibility(8);
            return;
        }
        this.O = true;
        this.i.setVisibility(4);
        a(f);
        this.k.setVisibility(0);
    }

    public void b(int i) {
        if (i == 0) {
            this.O = false;
            this.i.setVisibility(0);
            this.k.setVisibility(8);
            return;
        }
        this.O = true;
        this.i.setVisibility(4);
        this.k.setVisibility(0);
    }

    private void b(boolean z) {
        float f = 0.0f;
        Bitmap a = com.baidu.tieba.d.e.a((int) R.drawable.btn_like_n);
        if (a != null) {
            if (z) {
                this.l.setText(R.string.level_up);
                this.m.setText("");
            } else {
                this.l.setText(this.F);
                this.m.setText(String.valueOf(this.G) + "级");
            }
            float width = a.getWidth() * this.H;
            float f2 = width > 0.001f ? this.I / width : 0.0f;
            this.I = width;
            if (this.J) {
                this.J = false;
            } else {
                f = f2;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.width = a.getWidth();
            this.o.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams2.width = (int) this.I;
            this.n.setLayoutParams(layoutParams2);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.n.startAnimation(scaleAnimation);
        }
    }

    public void c(int i) {
        if (i == 0) {
            this.z = false;
            if (this.N == 1) {
                this.j.setBackgroundResource(R.drawable.frs_btn_sign_1);
                return;
            } else {
                this.j.setBackgroundResource(R.drawable.frs_btn_sign);
                return;
            }
        }
        this.z = true;
        if (this.N == 1) {
            this.j.setBackgroundResource(R.drawable.btn_sign_d_1);
        } else {
            this.j.setBackgroundResource(R.drawable.btn_sign_d);
        }
    }

    public boolean d() {
        return this.z;
    }

    public void a(boolean z) {
        this.M = z;
        if (this.M) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public void a(float f) {
        if (this.H >= 0.999f) {
            this.J = true;
        }
        this.H = f >= 1.0f ? 1.0f : f;
        b(f >= 1.0f);
    }

    public void e() {
    }

    public boolean f() {
        return this.O;
    }
}
