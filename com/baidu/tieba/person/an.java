package com.baidu.tieba.person;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class an extends RelativeLayout {
    private Context a;
    private View b;
    private ViewPager c;
    private LinearLayout d;
    private ap e;
    private ap f;
    private ap g;
    private ap h;
    private ap i;
    private ap j;
    private List<View> k;
    private com.baidu.tieba.model.av l;
    private ct m;
    private BdExpandImageView n;
    private Bitmap o;
    private ImageView p;
    private int q;
    private ar r;
    private float s;

    public an(Context context, ct ctVar, com.baidu.tieba.model.av avVar) {
        super(context);
        this.n = null;
        this.o = null;
        this.q = -1;
        this.s = 360.0f;
        this.a = context;
        this.m = ctVar;
        this.l = avVar;
        j();
        i();
    }

    private void i() {
        this.e.a(0);
        this.f.a(0);
        this.h.a(0);
        this.g.a(0);
        this.i.a(0);
        this.j.a(0);
        this.k = this.m.g();
        if (this.l.j()) {
            this.e.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_forums_name_text));
            this.f.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_post_name_text));
            this.h.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_group_name_text));
            this.g.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_friend_name_text));
            this.i.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_attention_name_text));
            this.j.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_fans_name_text));
        } else {
            this.e.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_forums_name_text_n));
            this.f.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_post_name_text_n));
            this.h.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_group_name_text_n));
            this.g.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_friend_name_text_n));
            this.i.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_attention_name_text_n));
            this.j.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_fans_name_text_n));
        }
        this.r = new ar(this, this.k);
        this.c.setAdapter(this.r);
        this.c.setOnPageChangeListener(new aq(this));
        b(0);
    }

    private void j() {
        this.b = com.baidu.adp.lib.e.b.a().a(getContext(), com.baidu.tieba.v.person_center_head_view, this, true);
        this.n = (BdExpandImageView) this.b.findViewById(com.baidu.tieba.u.user_info_center_head_cover_im);
        this.c = (ViewPager) this.b.findViewById(com.baidu.tieba.u.user_info_center_head_viewpager);
        this.d = (LinearLayout) this.b.findViewById(com.baidu.tieba.u.user_info_center_head_point);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(com.baidu.tieba.u.user_info_center_head_forums);
        linearLayout.setOnClickListener(this.m);
        this.e = new ap(linearLayout);
        LinearLayout linearLayout2 = (LinearLayout) this.b.findViewById(com.baidu.tieba.u.user_info_center_head_post);
        linearLayout2.setOnClickListener(this.m);
        this.f = new ap(linearLayout2);
        LinearLayout linearLayout3 = (LinearLayout) this.b.findViewById(com.baidu.tieba.u.user_info_center_head_friend);
        linearLayout3.setOnClickListener(this.m);
        this.g = new ap(linearLayout3);
        LinearLayout linearLayout4 = (LinearLayout) this.b.findViewById(com.baidu.tieba.u.user_info_center_head_group);
        linearLayout4.setOnClickListener(this.m);
        this.h = new ap(linearLayout4);
        LinearLayout linearLayout5 = (LinearLayout) this.b.findViewById(com.baidu.tieba.u.user_info_center_head_attention);
        linearLayout5.setOnClickListener(this.m);
        this.i = new ap(linearLayout5);
        LinearLayout linearLayout6 = (LinearLayout) this.b.findViewById(com.baidu.tieba.u.user_info_center_head_fans);
        linearLayout6.setOnClickListener(this.m);
        this.j = new ap(linearLayout6);
        this.p = (ImageView) this.b.findViewById(com.baidu.tieba.u.user_info_center_head_progress);
    }

    private void k() {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.o = com.baidu.tbadk.core.util.d.b(this.a, com.baidu.tieba.t.cent_banner_pic_n_1);
        } else {
            this.o = com.baidu.tbadk.core.util.d.b(this.a, com.baidu.tieba.t.cent_banner_pic_n);
        }
        if (this.n != null && this.o != null) {
            this.n.setImageBitmap(this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.n != null) {
            this.n.setImageDrawable(null);
        }
        if (this.o != null) {
            if (!this.o.isRecycled()) {
                this.o.recycle();
            }
            this.o = null;
        }
    }

    void c() {
        if (this.n != null) {
            this.n.setImageBitmap(null);
        }
        if (this.o != null && !this.o.isRecycled()) {
            this.o.recycle();
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        int childCount = this.d.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ImageView imageView = (ImageView) this.d.getChildAt(i2);
            if (i2 == i % 2) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    imageView.setImageResource(com.baidu.tieba.t.icon_pop_dot_s_1);
                } else {
                    imageView.setImageResource(com.baidu.tieba.t.icon_pop_dot_s);
                }
            } else if (TbadkApplication.m252getInst().getSkinType() == 1) {
                imageView.setImageResource(com.baidu.tieba.t.icon_pop_dot_n_1);
            } else {
                imageView.setImageResource(com.baidu.tieba.t.icon_pop_dot_n);
            }
        }
    }

    public void a(com.baidu.tieba.model.av avVar) {
        if (avVar != null && avVar.k() != null && avVar.a() != null) {
            this.l = avVar;
            this.e.a(avVar.k().getLike_bars());
            this.f.a(avVar.k().getPosts_num());
            this.h.a(avVar.a().e());
            this.g.a(avVar.a().f());
            this.i.a(avVar.k().getConcern_num());
            this.j.a(avVar.k().getFansNum());
            this.k = this.m.g();
            if (this.l != null && !this.l.j()) {
                if (this.l.k().getSex() == 1) {
                    this.e.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_forums_name_text_b));
                    this.f.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_post_name_text_b));
                    this.h.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_group_name_text_b));
                    this.g.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_friend_name_text_b));
                    this.i.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_attention_name_text_b));
                    this.j.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_fans_name_text_b));
                } else if (this.l.k().getSex() == 2) {
                    this.e.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_forums_name_text_g));
                    this.f.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_post_name_text_g));
                    this.h.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_group_name_text_g));
                    this.g.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_friend_name_text_g));
                    this.i.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_attention_name_text_g));
                    this.j.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_fans_name_text_g));
                } else {
                    this.e.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_forums_name_text_n));
                    this.f.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_post_name_text_n));
                    this.h.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_group_name_text_n));
                    this.g.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_friend_name_text_n));
                    this.i.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_attention_name_text_n));
                    this.j.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_fans_name_text_n));
                }
            } else {
                this.e.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_forums_name_text));
                this.f.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_post_name_text));
                this.h.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_group_name_text));
                this.g.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_friend_name_text));
                this.i.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_attention_name_text));
                this.j.a(this.a.getResources().getString(com.baidu.tieba.x.user_info_center_head_fans_name_text));
            }
            if (this.l != null && !this.l.j()) {
                h();
            }
            if (this.r != null) {
                this.r.notifyDataSetChanged();
            }
        }
    }

    public void d() {
        this.r.notifyDataSetChanged();
    }

    public View getForumView() {
        return this.e.a;
    }

    public View getPostView() {
        return this.f.a;
    }

    public View getFriendView() {
        return this.g.a;
    }

    public View getGroupView() {
        return this.h.a;
    }

    public View getAttentionView() {
        return this.i.a;
    }

    public View getFansView() {
        return this.j.a;
    }

    public void a(int i) {
        ((BaseFragmentActivity) this.a).c().a(i == 1);
        ((BaseFragmentActivity) this.a).c().a(this.b);
        com.baidu.tbadk.core.util.ay.f(this.e.a, com.baidu.tieba.t.bg_user_info_center_head_btn);
        com.baidu.tbadk.core.util.ay.f(this.h.a, com.baidu.tieba.t.bg_user_info_center_head_btn);
        com.baidu.tbadk.core.util.ay.f(this.i.a, com.baidu.tieba.t.bg_user_info_center_head_btn);
        com.baidu.tbadk.core.util.ay.f(this.j.a, com.baidu.tieba.t.bg_user_info_center_head_btn);
        com.baidu.tbadk.core.util.ay.f(this.g.a, com.baidu.tieba.t.bg_user_info_center_head_btn);
        com.baidu.tbadk.core.util.ay.f(this.f.a, com.baidu.tieba.t.bg_user_info_center_head_btn);
        h();
        if (this.q != -1 && this.q != i) {
            c();
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                this.o = com.baidu.tbadk.core.util.d.a(this.a, com.baidu.tieba.t.cent_banner_pic_n_1);
            } else {
                this.o = com.baidu.tbadk.core.util.d.a(this.a, com.baidu.tieba.t.cent_banner_pic_n);
            }
            if (this.o != null) {
                this.n.setImageBitmap(this.o);
                this.n.setImageBitmap(this.o);
            }
        }
        this.q = i;
    }

    public void a(boolean z) {
        if (z) {
            this.j.e.setVisibility(0);
        } else {
            this.j.e.setVisibility(4);
        }
    }

    public void a(float f) {
        if (!this.p.isShown()) {
            this.p.setVisibility(0);
            this.p.setImageDrawable(getResources().getDrawable(com.baidu.tieba.t.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.s, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.p.startAnimation(rotateAnimation);
        this.s = f;
    }

    public void e() {
        this.p.clearAnimation();
        this.p.setImageDrawable(null);
        this.p.setVisibility(8);
    }

    public void f() {
        postDelayed(new ao(this), 500L);
    }

    public void g() {
        if (!this.p.isShown()) {
            this.p.setVisibility(0);
            this.p.setImageDrawable(getResources().getDrawable(com.baidu.tieba.t.icon_pop_refresh));
        }
        this.p.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(getContext(), com.baidu.tieba.o.user_info_center_head_rotate));
    }

    public void h() {
        if (this.l != null && !this.l.j() && this.l.k() != null && this.l.k().getPersonPrivate() != null && this.l.a() != null) {
            com.baidu.tbadk.data.b personPrivate = this.l.k().getPersonPrivate();
            boolean z = this.l.a().g() == 1;
            this.e.a(personPrivate.b(), z);
            this.f.a(personPrivate.d(), z);
            this.i.a(1, z);
            this.j.a(1, z);
            this.h.a(personPrivate.c(), z);
            this.g.a(personPrivate.e(), z);
        }
    }
}
