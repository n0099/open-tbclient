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
import com.baidu.tieba.data.ba;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class q {
    private Button A;
    private TextView B;
    private CustomTimerView C;
    private ImageView D;
    private TextView E;
    private String F;
    private int G;
    private RelativeLayout K;
    private RelativeLayout L;
    private boolean M;
    private int N;
    private TextView b;
    private RelativeLayout c;
    private TextView d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private Button h;
    private Button i;
    private RelativeLayout j;
    private TextView k;
    private TextView l;
    private ImageView m;
    private ImageView n;
    private View o;
    private Activity q;
    private String r;
    private String s;
    private com.baidu.tieba.util.a w;
    private FrsStarImageView x;
    private FrsStarImageView y;
    private ImageView z;
    private boolean p = false;
    private int t = 0;
    private int u = 0;
    private com.baidu.tieba.data.t v = null;
    ba a = null;
    private float H = 0.0f;
    private float I = 0.0f;
    private boolean J = false;
    private boolean O = false;

    public q(Activity activity, String str, String str2) {
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
        this.q = null;
        this.r = null;
        this.s = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.K = null;
        this.L = null;
        this.q = activity;
        this.r = str;
        this.s = str2;
        this.o = LayoutInflater.from(activity).inflate(R.layout.frs_star_title, (ViewGroup) null);
        if (this.r == null || this.s == null) {
            this.o.setVisibility(8);
        }
        this.c = (RelativeLayout) this.o.findViewById(R.id.frs_star_title);
        this.j = (RelativeLayout) this.o.findViewById(R.id.btn_love_content);
        this.k = (TextView) this.o.findViewById(R.id.level_name);
        this.l = (TextView) this.o.findViewById(R.id.level);
        this.m = (ImageView) this.o.findViewById(R.id.love_level_top);
        this.n = (ImageView) this.o.findViewById(R.id.love_level_bg);
        this.h = (Button) this.o.findViewById(R.id.btn_love);
        this.i = (Button) this.o.findViewById(R.id.btn_sign);
        this.b = (TextView) this.o.findViewById(R.id.member_num_text);
        this.d = (TextView) this.o.findViewById(R.id.post_num_text);
        this.f = (ImageView) this.o.findViewById(R.id.member_image);
        this.e = (ImageView) this.o.findViewById(R.id.post_image);
        this.g = (TextView) this.o.findViewById(R.id.title_text);
        this.K = (RelativeLayout) this.o.findViewById(R.id.fan_timer_layout);
        this.L = (RelativeLayout) this.o.findViewById(R.id.fan_num_layout);
        this.D = (ImageView) this.o.findViewById(R.id.fan_num_icon);
        this.x = (FrsStarImageView) this.o.findViewById(R.id.frs_star_top_pic);
        this.y = (FrsStarImageView) this.o.findViewById(R.id.frs_star_bottom_photo);
        this.z = (ImageView) this.o.findViewById(R.id.frs_star_bottom_bg);
        this.A = (Button) this.o.findViewById(R.id.add_fan);
        this.A.setOnClickListener(new r(this));
        this.B = (TextView) this.o.findViewById(R.id.fan_num);
        this.E = (TextView) this.o.findViewById(R.id.add_fan_intro_text);
        this.C = (CustomTimerView) this.o.findViewById(R.id.open_timer);
        this.C.setTextSize(10);
        this.C.setTextColor(-14277082);
        this.C.setNumSize(12);
        this.C.setNumColor(-12809494);
        this.C.setTextMargin(3);
        this.C.setNumMargin(2);
        this.w = new com.baidu.tieba.util.a(this.q);
        this.w.a(com.baidu.tieba.util.ab.a((Context) this.q), com.baidu.tieba.util.ab.a((Context) this.q));
    }

    public void a(View.OnClickListener onClickListener) {
        this.h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
    }

    public com.baidu.tieba.util.a a() {
        return this.w;
    }

    public ba b() {
        return this.a;
    }

    public void a(int i) {
        this.N = i;
        if (this.O) {
            c(1);
        } else {
            c(0);
        }
        this.y.invalidate();
        if (i == 1) {
            this.c.setBackgroundResource(R.drawable.bg_topbar_1);
            this.g.setTextColor(-8682095);
            this.b.setTextColor(-11446171);
            this.d.setTextColor(-11446171);
            this.z.setBackgroundResource(R.drawable.pic_bj_touxiang_n_1);
            this.h.setBackgroundResource(R.drawable.frs_btn_like_1);
            this.f.setBackgroundResource(R.drawable.icon_little_people_1);
            this.e.setBackgroundResource(R.drawable.icon_little_discuss_1);
            this.k.setTextColor(-8682095);
            this.l.setTextColor(-8682095);
            this.m.setBackgroundResource(R.drawable.progressbar_blue_1);
            this.n.setBackgroundResource(R.drawable.progressbar_black_1);
            this.A.setBackgroundResource(R.drawable.frs_star_add_fan_1);
            this.A.setTextColor(-12687203);
            this.D.setBackgroundResource(R.drawable.label_no_1);
            this.B.setTextColor(-5947365);
            this.E.setTextColor(-11446171);
            this.C.setTextColor(-10523526);
            this.C.setNumColor(-12687203);
            return;
        }
        this.c.setBackgroundResource(R.drawable.bg_topbar);
        this.g.setTextColor(-12564913);
        this.b.setTextColor(-5065030);
        this.d.setTextColor(-5065030);
        this.h.setBackgroundResource(R.drawable.frs_btn_like);
        this.f.setBackgroundResource(R.drawable.icon_little_people);
        this.e.setBackgroundResource(R.drawable.icon_little_discuss);
        this.z.setBackgroundResource(R.drawable.pic_bj_touxiang_n);
        this.k.setTextColor(-14277082);
        this.l.setTextColor(-14277082);
        this.m.setBackgroundResource(R.drawable.progressbar_blue);
        this.n.setBackgroundResource(R.drawable.progressbar_black);
        this.A.setBackgroundResource(R.drawable.frs_star_add_fan);
        this.A.setTextColor(-12810784);
        this.D.setBackgroundResource(R.drawable.label_no);
        this.B.setTextColor(-3060450);
        this.E.setTextColor(-7100744);
        this.C.setTextColor(-14277082);
        this.C.setNumColor(-12809494);
    }

    public View c() {
        return this.o;
    }

    public void a(com.baidu.tieba.data.r rVar, com.baidu.tieba.data.t tVar) {
        this.r = rVar.b();
        this.s = rVar.a();
        this.t = rVar.d();
        this.u = rVar.c();
        this.v = tVar;
        this.a = new ba();
        com.baidu.tieba.data.ae aeVar = new com.baidu.tieba.data.ae();
        aeVar.a(3);
        aeVar.a(this.v.b());
        this.a.m().add(aeVar);
        com.baidu.tieba.data.ae aeVar2 = new com.baidu.tieba.data.ae();
        aeVar2.a(3);
        aeVar2.a(this.v.c());
        this.a.m().add(aeVar2);
        this.o.setVisibility(0);
        g();
    }

    private void g() {
        if (this.b != null) {
            this.b.setText(String.valueOf(this.t));
        }
        if (this.d != null) {
            this.d.setText(String.valueOf(this.u));
        }
        if (this.g != null) {
            this.g.setText(String.valueOf(this.r) + "吧");
        }
        this.x.setImageType(0);
        this.y.setImageType(1);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        layoutParams.width = com.baidu.tieba.util.ab.a((Context) this.q);
        if (this.v.d() == 0) {
            layoutParams.height = 1;
        } else {
            layoutParams.height = (layoutParams.width * this.v.e()) / this.v.d();
        }
        this.x.setLayoutParams(layoutParams);
        this.x.setTag(this.v.b());
        this.y.setTag(this.v.c());
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
        layoutParams2.width = com.baidu.tieba.util.ab.a((Context) this.q) / 4;
        if (this.v.f() == 0) {
            layoutParams2.height = layoutParams2.width;
        } else {
            layoutParams2.height = (layoutParams2.width * this.v.g()) / this.v.f();
        }
        this.y.setLayoutParams(layoutParams2);
        if (this.v.h() == 0) {
            this.L.setVisibility(8);
            this.A.setVisibility(8);
            if (this.v.i() <= 0) {
                this.K.setVisibility(8);
                return;
            } else {
                this.K.setVisibility(0);
                return;
            }
        }
        this.K.setVisibility(8);
        if (this.v.j() == 0) {
            this.L.setVisibility(8);
            this.A.setVisibility(0);
            return;
        }
        this.A.setVisibility(8);
        this.L.setVisibility(0);
        this.B.setText(String.valueOf(this.v.k()));
    }

    private void b(boolean z) {
        float f = 0.0f;
        Bitmap a = com.baidu.tieba.util.d.a((int) R.drawable.btn_like_n);
        if (a != null) {
            if (z) {
                this.k.setText(R.string.level_up);
                this.l.setText("");
            } else {
                this.k.setText(this.F);
                this.l.setText(String.valueOf(this.G) + "级");
            }
            float width = a.getWidth() * this.H;
            float f2 = width > 0.001f ? this.I / width : 0.0f;
            this.I = width;
            if (this.J) {
                this.J = false;
            } else {
                f = f2;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.width = a.getWidth();
            this.n.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams2.width = (int) this.I;
            this.m.setLayoutParams(layoutParams2);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.m.startAnimation(scaleAnimation);
        }
    }

    public void a(float f) {
        if (this.H >= 0.999f) {
            this.J = true;
        }
        this.H = f >= 1.0f ? 1.0f : f;
        b(f >= 1.0f);
    }

    public void a(int i, String str, int i2, float f) {
        this.F = str;
        this.G = i2;
        if (i == 0) {
            this.p = false;
            this.h.setVisibility(0);
            this.j.setVisibility(8);
            return;
        }
        this.p = true;
        this.h.setVisibility(4);
        a(f);
        this.j.setVisibility(0);
    }

    public void b(int i) {
        if (i == 0) {
            this.p = false;
            this.h.setVisibility(0);
            this.j.setVisibility(8);
            return;
        }
        this.p = true;
        this.h.setVisibility(4);
        this.j.setVisibility(0);
    }

    public void c(int i) {
        if (i == 0) {
            this.O = false;
            if (this.N == 1) {
                this.i.setBackgroundResource(R.drawable.frs_btn_sign_1);
                return;
            } else {
                this.i.setBackgroundResource(R.drawable.frs_btn_sign);
                return;
            }
        }
        this.O = true;
        if (this.N == 1) {
            this.i.setBackgroundResource(R.drawable.btn_sign_d_1);
        } else {
            this.i.setBackgroundResource(R.drawable.btn_sign_d);
        }
    }

    public boolean d() {
        return this.O;
    }

    public void a(boolean z) {
        this.M = z;
        if (this.M) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public boolean e() {
        return this.p;
    }

    public void f() {
    }
}
