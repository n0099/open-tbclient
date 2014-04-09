package com.baidu.tieba.person;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.TbadkApplication;
import java.text.DecimalFormat;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public final class ag extends RelativeLayout {
    private float A;
    private Context a;
    private View b;
    private ViewPager c;
    private ImageView d;
    private ImageView e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private FrameLayout i;
    private LinearLayout j;
    private List<View> k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private ImageView t;
    private com.baidu.tieba.model.av u;
    private bn v;
    private BdExpandImageView w;
    private ImageView x;
    private boolean y;
    private aj z;

    public ag(Context context, bn bnVar) {
        super(context);
        this.y = true;
        this.A = 360.0f;
        this.a = context;
        this.v = bnVar;
        this.b = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.person_center_head_view, (ViewGroup) this, true);
        this.w = (BdExpandImageView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_cover_im);
        if (TbadkApplication.j().l() == 1) {
            this.w.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tieba.a.g.cent_banner_pic_n_1));
        } else {
            this.w.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tieba.a.g.cent_banner_pic_n));
        }
        this.c = (ViewPager) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_viewpager);
        this.d = (ImageView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_back);
        this.e = (ImageView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_edit);
        this.f = (LinearLayout) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_point);
        this.g = (LinearLayout) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_forums);
        this.g.setOnClickListener(this.v);
        this.h = (LinearLayout) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_post);
        this.h.setOnClickListener(this.v);
        this.i = (FrameLayout) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_fans);
        this.i.setOnClickListener(this.v);
        this.j = (LinearLayout) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_attention);
        this.j.setOnClickListener(this.v);
        this.l = (TextView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_forums_num);
        this.m = (TextView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_forums_name);
        this.n = (TextView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_post_num);
        this.o = (TextView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_post_name);
        this.p = (TextView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_attention_num);
        this.q = (TextView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_attention_name);
        this.r = (TextView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_fans_num);
        this.s = (TextView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_fans_name);
        this.t = (ImageView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_msg_icon);
        this.t.setVisibility(8);
        this.d.setOnClickListener(this.v);
        this.e.setOnClickListener(this.v);
        this.x = (ImageView) this.b.findViewById(com.baidu.tieba.a.h.user_info_center_head_progress);
        this.l.setText("0");
        this.n.setText("0");
        this.p.setText("0");
        this.r.setText("0");
        this.k = this.v.b();
        this.e.setVisibility(8);
        this.m.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_forums_name_text_n));
        this.o.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_post_name_text_n));
        this.q.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_attention_name_text_n));
        this.s.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_fans_name_text_n));
        this.z = new aj(this, this.k);
        this.c.setAdapter(this.z);
        this.c.setOnPageChangeListener(new ai(this));
        b(0);
    }

    public final ImageView getBackBtn() {
        return this.d;
    }

    public final ImageView getEditBtn() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        int childCount = this.f.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ImageView imageView = (ImageView) this.f.getChildAt(i2);
            if (i2 == i % 2) {
                if (TbadkApplication.j().l() == 1) {
                    imageView.setImageResource(com.baidu.tieba.a.g.icon_pop_dot_s_1);
                } else {
                    imageView.setImageResource(com.baidu.tieba.a.g.icon_pop_dot_s);
                }
            } else if (TbadkApplication.j().l() == 1) {
                imageView.setImageResource(com.baidu.tieba.a.g.icon_pop_dot_n_1);
            } else {
                imageView.setImageResource(com.baidu.tieba.a.g.icon_pop_dot_n);
            }
        }
    }

    public final void a(com.baidu.tieba.model.av avVar) {
        if (avVar.g() != null) {
            this.u = avVar;
            this.l.setText(c(avVar.g().getLike_bars()));
            this.n.setText(c(avVar.g().getPosts_num()));
            this.p.setText(c(avVar.g().getConcern_num()));
            this.r.setText(c(avVar.g().getFans_num()));
            this.k = this.v.b();
            if (this.u != null && !this.u.f()) {
                if (this.y) {
                    this.e.setVisibility(8);
                }
                if (avVar.g().getSex() == 1) {
                    this.m.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_forums_name_text_b));
                    this.o.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_post_name_text_b));
                    this.q.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_attention_name_text_b));
                    this.s.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_fans_name_text_b));
                } else if (avVar.g().getSex() == 2) {
                    this.m.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_forums_name_text_g));
                    this.o.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_post_name_text_g));
                    this.q.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_attention_name_text_g));
                    this.s.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_fans_name_text_g));
                } else {
                    this.m.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_forums_name_text_n));
                    this.o.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_post_name_text_n));
                    this.q.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_attention_name_text_n));
                    this.s.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_fans_name_text_n));
                }
            } else {
                this.e.setVisibility(0);
                this.m.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_forums_name_text));
                this.o.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_post_name_text));
                this.q.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_attention_name_text));
                this.s.setText(this.a.getResources().getString(com.baidu.tieba.a.k.user_info_center_head_fans_name_text));
            }
            this.z.notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 int)] */
    private static String c(int i) {
        if (i > 9999) {
            return String.valueOf(new DecimalFormat(".00").format(i / 10000.0f)) + "w";
        }
        return new StringBuilder().append(i).toString();
    }

    public final void a() {
        this.z.notifyDataSetChanged();
    }

    public final int getForumId() {
        return com.baidu.tieba.a.h.user_info_center_head_forums;
    }

    public final int getPostId() {
        return com.baidu.tieba.a.h.user_info_center_head_post;
    }

    public final int getFansId() {
        return com.baidu.tieba.a.h.user_info_center_head_fans;
    }

    public final int getAttentionId() {
        return com.baidu.tieba.a.h.user_info_center_head_attention;
    }

    public final void a(int i) {
        ((com.baidu.tbadk.core.e) this.a).b().a(i == 1);
        ((com.baidu.tbadk.core.e) this.a).b().a(this.b);
    }

    public final void a(boolean z) {
        if (z) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(4);
        }
    }

    public final void a(float f) {
        if (!this.x.isShown()) {
            this.x.setVisibility(0);
            this.x.setImageDrawable(getResources().getDrawable(com.baidu.tieba.a.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.A, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.x.startAnimation(rotateAnimation);
        this.A = f;
    }

    public final void b() {
        this.x.clearAnimation();
        this.x.setImageDrawable(null);
        this.x.setVisibility(8);
    }

    public final void c() {
        postDelayed(new ah(this), 500L);
    }

    public final void d() {
        if (!this.x.isShown()) {
            this.x.setVisibility(0);
            this.x.setImageDrawable(getResources().getDrawable(com.baidu.tieba.a.g.icon_pop_refresh));
        }
        this.x.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(getContext(), com.baidu.tieba.a.b.user_info_center_head_rotate));
    }

    public final void b(boolean z) {
        this.y = false;
        this.e.setVisibility(0);
        if (z) {
            com.baidu.tbadk.core.util.ba.f(this.e, com.baidu.tieba.a.g.icon_pop_blacklist_d);
        } else {
            com.baidu.tbadk.core.util.ba.f(this.e, com.baidu.tieba.a.g.icon_pop_blacklist);
        }
    }
}
