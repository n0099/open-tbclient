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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class FrsHeaderView {
    public static int[] b = {R.drawable.label_green, R.drawable.label_blue, R.drawable.label_orange, R.drawable.label_red, R.drawable.label_purple};
    public static int[] c = {R.drawable.label_green_1, R.drawable.label_blue_1, R.drawable.label_orange_1, R.drawable.label_red_1, R.drawable.label_purple_1};
    private ProgressBar B;
    private FrsStarImageView D;
    private ImageView E;
    private com.baidu.tieba.util.a F;
    private ImageView G;
    private TextView H;
    private String I;
    private int J;
    private boolean O;
    private int P;
    private ViewGroup R;
    private ImageView S;
    private RelativeLayout d;
    private RelativeLayout e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private Button k;
    private Button l;
    private RelativeLayout m;
    private TextView n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private View r;
    private Activity s;
    private String t;
    private String u;
    private int v = 0;
    private int w = 0;
    private int x = -1;
    private String y = null;
    private String z = null;
    private String A = null;
    private boolean C = false;

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.bh f1945a = null;
    private float K = 0.0f;
    private float L = 0.0f;
    private boolean M = false;
    private boolean N = true;
    private boolean Q = false;

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
        this.B = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.S = null;
        this.s = activity;
        this.t = str;
        this.u = str2;
        this.r = LayoutInflater.from(activity).inflate(R.layout.frs_header, (ViewGroup) null);
        if (this.t == null || this.u == null) {
            this.r.setVisibility(8);
        }
        this.e = (RelativeLayout) this.r.findViewById(R.id.container);
        this.m = (RelativeLayout) this.r.findViewById(R.id.btn_love_content);
        this.R = (ViewGroup) this.r.findViewById(R.id.frs_forum_entry);
        this.S = (ImageView) this.r.findViewById(R.id.frs_enter_detail);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.R.setVisibility(0);
        } else {
            this.R.setVisibility(8);
        }
        this.n = (TextView) this.r.findViewById(R.id.level_name);
        this.o = (TextView) this.r.findViewById(R.id.level);
        this.p = (ImageView) this.r.findViewById(R.id.love_level_top);
        this.q = (ImageView) this.r.findViewById(R.id.love_level_bg);
        this.k = (Button) this.r.findViewById(R.id.btn_love);
        this.l = (Button) this.r.findViewById(R.id.btn_sign);
        this.f = (TextView) this.r.findViewById(R.id.member_num_text);
        this.i = (TextView) this.r.findViewById(R.id.post_num_text);
        this.h = (TextView) this.r.findViewById(R.id.member_image);
        this.g = (TextView) this.r.findViewById(R.id.post_image);
        this.j = (TextView) this.r.findViewById(R.id.title_text);
        this.d = (RelativeLayout) this.r.findViewById(R.id.frs_tag_layout);
        this.G = (ImageView) this.r.findViewById(R.id.frs_tag_bg);
        this.H = (TextView) this.r.findViewById(R.id.frs_tag_text);
        this.D = (FrsStarImageView) this.r.findViewById(R.id.frs_image);
        this.E = (ImageView) this.r.findViewById(R.id.frs_image_bg);
        this.B = (ProgressBar) this.r.findViewById(R.id.frs_title_progress);
        this.F = new com.baidu.tieba.util.a(this.s);
        this.F.a(UtilHelper.a((Context) this.s), UtilHelper.a((Context) this.s));
    }

    public void a(View.OnClickListener onClickListener) {
        this.k.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.r.setOnClickListener(new y(this));
        }
        this.G.setOnClickListener(new z(this));
    }

    public com.baidu.tieba.util.a a() {
        return this.F;
    }

    public com.baidu.tieba.data.bh b() {
        return this.f1945a;
    }

    public void a(int i) {
        this.P = i;
        if (this.C) {
            b(1);
        } else {
            b(0);
        }
        this.D.invalidate();
        if (i == 1) {
            if (this.x >= 0 && this.x < b.length) {
                this.G.setBackgroundResource(c[this.x]);
            }
            this.p.setBackgroundResource(R.drawable.progressbar_blue_1);
            this.q.setBackgroundResource(R.drawable.progressbar_black_1);
            this.k.setBackgroundResource(R.drawable.frs_btn_like_1);
            com.baidu.tieba.util.as.e(this.S, (int) R.drawable.icon_arrow_right_1);
        } else {
            if (this.x >= 0 && this.x < b.length) {
                this.G.setBackgroundResource(b[this.x]);
            }
            this.p.setBackgroundResource(R.drawable.progressbar_blue);
            this.q.setBackgroundResource(R.drawable.progressbar_black);
            this.k.setBackgroundResource(R.drawable.frs_btn_like);
            com.baidu.tieba.util.as.e(this.S, (int) R.drawable.icon_arrow_right);
        }
        ((FrsActivity) this.s).l().a(i == 1);
        ((FrsActivity) this.s).l().a(this.r);
    }

    public View c() {
        return this.r;
    }

    public void a(com.baidu.tieba.data.v vVar) {
        this.t = vVar.b();
        this.u = vVar.a();
        this.v = vVar.d();
        this.w = vVar.c();
        this.y = vVar.k();
        this.z = vVar.m();
        this.A = vVar.l();
        this.I = vVar.i();
        this.J = vVar.f();
        this.r.setVisibility(0);
        this.f1945a = new com.baidu.tieba.data.bh();
        com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
        aiVar.a(3);
        aiVar.a(this.A);
        this.f1945a.o().add(aiVar);
        f();
    }

    private void f() {
        if (this.f != null) {
            this.f.setText(String.valueOf(this.v));
        }
        if (this.i != null) {
            this.i.setText(String.valueOf(this.w));
        }
        if (this.j != null) {
            this.j.setText(this.t);
        }
        if (this.y != null && this.y.length() > 0) {
            if (this.H != null) {
                this.H.setText(this.y);
            }
            if (this.G != null && this.z != null && this.z.length() > 0) {
                this.x = Integer.parseInt(this.z);
                if (this.x >= 0 && this.x < b.length) {
                    this.G.setBackgroundResource(b[this.x]);
                }
            }
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        this.D.setTag(this.A);
        this.D.setImageType(1);
    }

    public void a(int i, String str, int i2, float f) {
        this.I = str;
        this.J = i2;
        if (i == 0) {
            this.Q = false;
            this.k.setVisibility(0);
            this.m.setVisibility(8);
            return;
        }
        this.Q = true;
        this.k.setVisibility(4);
        a(f);
        this.m.setVisibility(0);
    }

    private void c(boolean z) {
        float f = 0.0f;
        Bitmap a2 = com.baidu.tieba.util.e.a((int) R.drawable.btn_like_n);
        if (a2 != null) {
            if (z) {
                this.n.setText(R.string.level_up);
                this.o.setText("");
            } else {
                this.n.setText(this.I);
                this.o.setText(String.valueOf(this.J) + "级");
            }
            float width = a2.getWidth() * this.K;
            float f2 = width > 0.001f ? this.L / width : 0.0f;
            this.L = width;
            if (this.M) {
                this.M = false;
            } else {
                f = f2;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams.width = a2.getWidth();
            this.q.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams2.width = (int) this.L;
            this.p.setLayoutParams(layoutParams2);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.p.startAnimation(scaleAnimation);
        }
    }

    public void b(int i) {
        if (i == 0) {
            this.C = false;
            if (this.P == 1) {
                this.l.setBackgroundResource(R.drawable.frs_btn_sign_1);
                return;
            } else {
                this.l.setBackgroundResource(R.drawable.frs_btn_sign);
                return;
            }
        }
        this.C = true;
        if (this.P == 1) {
            this.l.setBackgroundResource(R.drawable.btn_sign_d_1);
        } else {
            this.l.setBackgroundResource(R.drawable.btn_sign_d);
        }
    }

    public boolean d() {
        return this.C;
    }

    public void a(boolean z) {
        this.O = z;
        if (this.O) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    public void a(float f) {
        if (this.K >= 0.999f) {
            this.M = true;
        }
        this.K = f >= 1.0f ? 1.0f : f;
        c(f >= 1.0f);
    }

    public boolean e() {
        return this.Q;
    }

    public void b(boolean z) {
        if (z) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
    }
}
