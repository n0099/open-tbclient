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
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.text.DecimalFormat;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class af extends RelativeLayout {
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
    private bm v;
    private BdExpandImageView w;
    private ImageView x;
    private boolean y;
    private ai z;

    public af(Context context, bm bmVar) {
        super(context);
        this.y = true;
        this.A = 360.0f;
        this.a = context;
        this.v = bmVar;
        f();
        a();
    }

    public void a() {
        this.l.setText("0");
        this.n.setText("0");
        this.p.setText("0");
        this.r.setText("0");
        this.k = this.v.f();
        this.e.setVisibility(8);
        this.m.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_forums_name_text_n));
        this.o.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_post_name_text_n));
        this.q.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_attention_name_text_n));
        this.s.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_fans_name_text_n));
        this.z = new ai(this, this.k);
        this.c.setAdapter(this.z);
        this.c.setOnPageChangeListener(new ah(this));
        b(0);
    }

    private void f() {
        this.b = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(com.baidu.tieba.w.person_center_head_view, (ViewGroup) this, true);
        this.w = (BdExpandImageView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_cover_im);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.w.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tieba.u.cent_banner_pic_n_1));
        } else {
            this.w.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tieba.u.cent_banner_pic_n));
        }
        this.c = (ViewPager) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_viewpager);
        this.d = (ImageView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_back);
        this.e = (ImageView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_edit);
        this.f = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_point);
        this.g = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_forums);
        this.g.setOnClickListener(this.v);
        this.h = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_post);
        this.h.setOnClickListener(this.v);
        this.i = (FrameLayout) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_fans);
        this.i.setOnClickListener(this.v);
        this.j = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_attention);
        this.j.setOnClickListener(this.v);
        this.l = (TextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_forums_num);
        this.m = (TextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_forums_name);
        this.n = (TextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_post_num);
        this.o = (TextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_post_name);
        this.p = (TextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_attention_num);
        this.q = (TextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_attention_name);
        this.r = (TextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_fans_num);
        this.s = (TextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_fans_name);
        this.t = (ImageView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_msg_icon);
        this.t.setVisibility(8);
        this.d.setOnClickListener(this.v);
        this.e.setOnClickListener(this.v);
        this.x = (ImageView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_progress);
    }

    public ImageView getBackBtn() {
        return this.d;
    }

    public ImageView getEditBtn() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        int childCount = this.f.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ImageView imageView = (ImageView) this.f.getChildAt(i2);
            if (i2 == i % 2) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    imageView.setImageResource(com.baidu.tieba.u.icon_pop_dot_s_1);
                } else {
                    imageView.setImageResource(com.baidu.tieba.u.icon_pop_dot_s);
                }
            } else if (TbadkApplication.m252getInst().getSkinType() == 1) {
                imageView.setImageResource(com.baidu.tieba.u.icon_pop_dot_n_1);
            } else {
                imageView.setImageResource(com.baidu.tieba.u.icon_pop_dot_n);
            }
        }
    }

    public void a(com.baidu.tieba.model.av avVar) {
        if (avVar.h() != null) {
            this.u = avVar;
            this.l.setText(c(avVar.h().getLike_bars()));
            this.n.setText(c(avVar.h().getPosts_num()));
            this.p.setText(c(avVar.h().getConcern_num()));
            this.r.setText(c(avVar.h().getFans_num()));
            this.k = this.v.f();
            if (this.u != null && !this.u.g()) {
                if (this.y) {
                    this.e.setVisibility(8);
                }
                if (avVar.h().getSex() == 1) {
                    this.m.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_forums_name_text_b));
                    this.o.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_post_name_text_b));
                    this.q.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_attention_name_text_b));
                    this.s.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_fans_name_text_b));
                } else if (avVar.h().getSex() == 2) {
                    this.m.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_forums_name_text_g));
                    this.o.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_post_name_text_g));
                    this.q.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_attention_name_text_g));
                    this.s.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_fans_name_text_g));
                } else {
                    this.m.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_forums_name_text_n));
                    this.o.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_post_name_text_n));
                    this.q.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_attention_name_text_n));
                    this.s.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_fans_name_text_n));
                }
            } else {
                this.e.setVisibility(0);
                this.m.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_forums_name_text));
                this.o.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_post_name_text));
                this.q.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_attention_name_text));
                this.s.setText(this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_fans_name_text));
            }
            this.z.notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
    private String c(int i) {
        if (i > 9999) {
            return String.valueOf(new DecimalFormat(".00").format(i / 10000.0f)) + "w";
        }
        return new StringBuilder().append(i).toString();
    }

    public void b() {
        this.z.notifyDataSetChanged();
    }

    public int getForumId() {
        return com.baidu.tieba.v.user_info_center_head_forums;
    }

    public int getPostId() {
        return com.baidu.tieba.v.user_info_center_head_post;
    }

    public int getFansId() {
        return com.baidu.tieba.v.user_info_center_head_fans;
    }

    public int getAttentionId() {
        return com.baidu.tieba.v.user_info_center_head_attention;
    }

    public void a(int i) {
        ((BaseFragmentActivity) this.a).a().a(i == 1);
        ((BaseFragmentActivity) this.a).a().a(this.b);
    }

    public void a(boolean z) {
        if (z) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(4);
        }
    }

    public void a(float f) {
        if (!this.x.isShown()) {
            this.x.setVisibility(0);
            this.x.setImageDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.A, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.x.startAnimation(rotateAnimation);
        this.A = f;
    }

    public void c() {
        this.x.clearAnimation();
        this.x.setImageDrawable(null);
        this.x.setVisibility(8);
    }

    public void d() {
        postDelayed(new ag(this), 500L);
    }

    public void e() {
        if (!this.x.isShown()) {
            this.x.setVisibility(0);
            this.x.setImageDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_pop_refresh));
        }
        this.x.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(getContext(), com.baidu.tieba.p.user_info_center_head_rotate));
    }

    public void b(boolean z) {
        this.y = false;
        this.e.setVisibility(0);
        if (z) {
            com.baidu.tbadk.core.util.bc.f(this.e, com.baidu.tieba.u.icon_pop_blacklist_d);
        } else {
            com.baidu.tbadk.core.util.bc.f(this.e, com.baidu.tieba.u.icon_pop_blacklist);
        }
    }
}
