package com.baidu.tieba.person;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class ao extends RelativeLayout {
    private BdExpandImageView A;
    private ImageView B;
    private ar C;
    private float D;
    TextView[] a;
    ImageView[] b;
    private Context c;
    private View d;
    private ViewPager e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private List<View> k;
    private TextView l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private ImageView s;
    private TextView t;
    private TextView u;
    private ImageView v;
    private TextView w;
    private com.baidu.tieba.model.au x;
    private cr y;
    private Bitmap z;

    public ao(Context context, cr crVar) {
        super(context);
        this.z = null;
        this.A = null;
        this.D = 360.0f;
        this.c = context;
        this.y = crVar;
        h();
        g();
    }

    private void g() {
        this.l.setText("0");
        this.r.setText("0");
        this.o.setText("0");
        this.u.setText("0");
        this.k = this.y.f();
        this.n.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_forums_name_text_n));
        this.t.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_post_name_text_n));
        this.q.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_group_name_text_n));
        this.w.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_friend_name_text_n));
        this.C = new ar(this, this.k);
        this.e.setAdapter(this.C);
        this.e.setOnPageChangeListener(new aq(this));
        b(0);
    }

    private void h() {
        this.d = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(com.baidu.tieba.w.person_center_head_view, (ViewGroup) this, true);
        this.A = (BdExpandImageView) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_cover_im);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.z = com.baidu.tbadk.core.util.h.a(this.c, com.baidu.tieba.u.cent_banner_pic_n_1);
        } else {
            this.z = com.baidu.tbadk.core.util.h.a(this.c, com.baidu.tieba.u.cent_banner_pic_n);
        }
        if (this.z != null) {
            this.A.setImageBitmap(this.z);
        }
        this.e = (ViewPager) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_viewpager);
        this.f = (LinearLayout) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_point);
        this.g = (LinearLayout) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_forums);
        this.g.setOnClickListener(this.y);
        this.h = (LinearLayout) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_post);
        this.h.setOnClickListener(this.y);
        this.i = (LinearLayout) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_friend);
        this.i.setOnClickListener(this.y);
        this.j = (LinearLayout) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_group);
        this.j.setOnClickListener(this.y);
        this.l = (TextView) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_forums_num);
        this.m = (ImageView) findViewById(com.baidu.tieba.v.user_info_center_head_forums_lock);
        this.n = (TextView) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_forums_name);
        this.r = (TextView) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_post_num);
        this.s = (ImageView) findViewById(com.baidu.tieba.v.user_info_center_head_post_lock);
        this.t = (TextView) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_post_name);
        this.o = (TextView) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_group_num);
        this.p = (ImageView) findViewById(com.baidu.tieba.v.user_info_center_head_group_lock);
        this.q = (TextView) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_group_name);
        this.u = (TextView) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_friend_num);
        this.v = (ImageView) findViewById(com.baidu.tieba.v.user_info_center_head_friend_lock);
        this.w = (TextView) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_friend_name);
        this.B = (ImageView) this.d.findViewById(com.baidu.tieba.v.user_info_center_head_progress);
        this.a = new TextView[]{this.l, this.o, this.r, this.u};
        this.b = new ImageView[]{this.m, this.p, this.s, this.v};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.A != null) {
            this.A.setImageBitmap(null);
        }
        if (this.z != null && !this.z.isRecycled()) {
            this.z.recycle();
            this.z = null;
        }
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

    public void a(com.baidu.tieba.model.au auVar) {
        if (auVar != null && auVar.j() != null && auVar.a() != null) {
            this.x = auVar;
            this.l.setText(c(auVar.j().getLike_bars()));
            this.r.setText(c(auVar.j().getPosts_num()));
            this.o.setText(c(auVar.a().e()));
            this.u.setText(c(auVar.a().f()));
            this.k = this.y.f();
            if (this.x != null && !this.x.i()) {
                if (this.x.j().getSex() == 1) {
                    this.n.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_forums_name_text_b));
                    this.t.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_post_name_text_b));
                    this.q.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_group_name_text_b));
                    this.w.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_friend_name_text_b));
                } else if (this.x.j().getSex() == 2) {
                    this.n.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_forums_name_text_g));
                    this.t.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_post_name_text_g));
                    this.q.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_group_name_text_g));
                    this.w.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_friend_name_text_g));
                } else {
                    this.n.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_forums_name_text_n));
                    this.t.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_post_name_text_n));
                    this.q.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_group_name_text_n));
                    this.w.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_friend_name_text_n));
                }
            } else {
                this.n.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_forums_name_text));
                this.t.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_post_name_text));
                this.q.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_group_name_text));
                this.w.setText(this.c.getResources().getString(com.baidu.tieba.y.user_info_center_head_friend_name_text));
            }
            if (this.x != null && !this.x.i()) {
                f();
            }
            if (this.C != null) {
                this.C.notifyDataSetChanged();
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    private String c(int i) {
        if (i > 99) {
            return "99+";
        }
        if (i < 0) {
            return "0";
        }
        return new StringBuilder().append(i).toString();
    }

    public void b() {
        this.C.notifyDataSetChanged();
    }

    public int getForumId() {
        return com.baidu.tieba.v.user_info_center_head_forums;
    }

    public int getPostId() {
        return com.baidu.tieba.v.user_info_center_head_post;
    }

    public int getFriendId() {
        return com.baidu.tieba.v.user_info_center_head_friend;
    }

    public int getGroupId() {
        return com.baidu.tieba.v.user_info_center_head_group;
    }

    public void a(int i) {
        ((BaseFragmentActivity) this.c).c().a(i == 1);
        ((BaseFragmentActivity) this.c).c().a(this.d);
        f();
    }

    public void a(float f) {
        if (!this.B.isShown()) {
            this.B.setVisibility(0);
            this.B.setImageDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.D, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.B.startAnimation(rotateAnimation);
        this.D = f;
    }

    public void c() {
        this.B.clearAnimation();
        this.B.setImageDrawable(null);
        this.B.setVisibility(8);
    }

    public void d() {
        postDelayed(new ap(this), 500L);
    }

    public void e() {
        if (!this.B.isShown()) {
            this.B.setVisibility(0);
            this.B.setImageDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_pop_refresh));
        }
        this.B.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(getContext(), com.baidu.tieba.p.user_info_center_head_rotate));
    }

    public void f() {
        if (this.x != null && !this.x.i() && this.x.j() != null && this.x.j().getPersonPrivate() != null && this.x.a() != null) {
            com.baidu.tbadk.data.b personPrivate = this.x.j().getPersonPrivate();
            bx a = this.x.a();
            int[] iArr = {personPrivate.b(), personPrivate.c(), personPrivate.d(), personPrivate.e()};
            boolean z = a.g() == 1;
            if (this.a != null && this.b != null) {
                for (int i = 0; i < this.a.length; i++) {
                    if (iArr[i] == 2 && !z) {
                        this.a[i].setVisibility(4);
                        com.baidu.tbadk.core.util.bk.c(this.b[i], com.baidu.tieba.u.icon_seg_grouplock);
                        this.b[i].setVisibility(0);
                    } else if (iArr[i] == 3) {
                        this.a[i].setVisibility(4);
                        com.baidu.tbadk.core.util.bk.c(this.b[i], com.baidu.tieba.u.icon_seg_lock);
                        this.b[i].setVisibility(0);
                    } else {
                        this.a[i].setVisibility(0);
                        this.b[i].setVisibility(4);
                    }
                }
            }
        }
    }
}
