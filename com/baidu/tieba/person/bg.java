package com.baidu.tieba.person;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.text.DecimalFormat;
import java.util.List;
/* loaded from: classes.dex */
public class bg extends LinearLayout {
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
    private com.baidu.tieba.model.bp u;
    private cm v;
    private BdCenterImageView w;
    private bi x;

    public bg(Context context, cm cmVar) {
        super(context);
        this.a = context;
        this.v = cmVar;
        c();
        a();
        addView(this.b);
    }

    public void a() {
        this.l.setText(SocialConstants.FALSE);
        this.n.setText(SocialConstants.FALSE);
        this.p.setText(SocialConstants.FALSE);
        this.r.setText(SocialConstants.FALSE);
        this.k = this.v.c();
        this.e.setVisibility(8);
        this.m.setText(this.a.getResources().getString(R.string.user_info_center_head_forums_name_text_n));
        this.o.setText(this.a.getResources().getString(R.string.user_info_center_head_post_name_text_n));
        this.q.setText(this.a.getResources().getString(R.string.user_info_center_head_attention_name_text_n));
        this.s.setText(this.a.getResources().getString(R.string.user_info_center_head_fans_name_text_n));
        this.x = new bi(this, this.k);
        this.c.setAdapter(this.x);
        this.c.setOnPageChangeListener(new bh(this));
        b(0);
    }

    private void c() {
        this.b = View.inflate(this.a, R.layout.person_center_head_view, null);
        this.w = (BdCenterImageView) this.b.findViewById(R.id.user_info_center_head_cover_im);
        if (TiebaApplication.g().al() == 1) {
            this.w.setImageDrawable(this.a.getResources().getDrawable(R.drawable.cent_banner_pic_n_1));
        } else {
            this.w.setImageDrawable(this.a.getResources().getDrawable(R.drawable.cent_banner_pic_n));
        }
        this.c = (ViewPager) this.b.findViewById(R.id.user_info_center_head_viewpager);
        this.d = (ImageView) this.b.findViewById(R.id.user_info_center_head_back);
        this.e = (ImageView) this.b.findViewById(R.id.user_info_center_head_edit);
        this.f = (LinearLayout) this.b.findViewById(R.id.user_info_center_head_point);
        this.g = (LinearLayout) this.b.findViewById(R.id.user_info_center_head_forums);
        this.g.setOnClickListener(this.v);
        this.h = (LinearLayout) this.b.findViewById(R.id.user_info_center_head_post);
        this.h.setOnClickListener(this.v);
        this.i = (FrameLayout) this.b.findViewById(R.id.user_info_center_head_fans);
        this.i.setOnClickListener(this.v);
        this.j = (LinearLayout) this.b.findViewById(R.id.user_info_center_head_attention);
        this.j.setOnClickListener(this.v);
        this.l = (TextView) this.b.findViewById(R.id.user_info_center_head_forums_num);
        this.m = (TextView) this.b.findViewById(R.id.user_info_center_head_forums_name);
        this.n = (TextView) this.b.findViewById(R.id.user_info_center_head_post_num);
        this.o = (TextView) this.b.findViewById(R.id.user_info_center_head_post_name);
        this.p = (TextView) this.b.findViewById(R.id.user_info_center_head_attention_num);
        this.q = (TextView) this.b.findViewById(R.id.user_info_center_head_attention_name);
        this.r = (TextView) this.b.findViewById(R.id.user_info_center_head_fans_num);
        this.s = (TextView) this.b.findViewById(R.id.user_info_center_head_fans_name);
        this.t = (ImageView) this.b.findViewById(R.id.user_info_center_head_msg_icon);
        this.t.setVisibility(8);
        this.d.setOnClickListener(this.v);
        this.e.setOnClickListener(this.v);
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
                if (TiebaApplication.g().al() == 1) {
                    imageView.setImageResource(R.drawable.icon_pop_dot_s_1);
                } else {
                    imageView.setImageResource(R.drawable.icon_pop_dot_s);
                }
            } else if (TiebaApplication.g().al() == 1) {
                imageView.setImageResource(R.drawable.icon_pop_dot_n_1);
            } else {
                imageView.setImageResource(R.drawable.icon_pop_dot_n);
            }
        }
    }

    public void a(com.baidu.tieba.model.bp bpVar) {
        if (bpVar.f() != null) {
            this.u = bpVar;
            this.l.setText(c(bpVar.f().getLike_bars()));
            this.n.setText(c(bpVar.f().getPosts_num()));
            this.p.setText(c(bpVar.f().getConcern_num()));
            this.r.setText(c(bpVar.f().getFans_num()));
            this.k = this.v.c();
            if (this.u != null && !this.u.e()) {
                this.e.setVisibility(8);
                if (bpVar.f().getSex() == 1) {
                    this.m.setText(this.a.getResources().getString(R.string.user_info_center_head_forums_name_text_b));
                    this.o.setText(this.a.getResources().getString(R.string.user_info_center_head_post_name_text_b));
                    this.q.setText(this.a.getResources().getString(R.string.user_info_center_head_attention_name_text_b));
                    this.s.setText(this.a.getResources().getString(R.string.user_info_center_head_fans_name_text_b));
                } else if (bpVar.f().getSex() == 2) {
                    this.m.setText(this.a.getResources().getString(R.string.user_info_center_head_forums_name_text_g));
                    this.o.setText(this.a.getResources().getString(R.string.user_info_center_head_post_name_text_g));
                    this.q.setText(this.a.getResources().getString(R.string.user_info_center_head_attention_name_text_g));
                    this.s.setText(this.a.getResources().getString(R.string.user_info_center_head_fans_name_text_g));
                } else {
                    this.m.setText(this.a.getResources().getString(R.string.user_info_center_head_forums_name_text_n));
                    this.o.setText(this.a.getResources().getString(R.string.user_info_center_head_post_name_text_n));
                    this.q.setText(this.a.getResources().getString(R.string.user_info_center_head_attention_name_text_n));
                    this.s.setText(this.a.getResources().getString(R.string.user_info_center_head_fans_name_text_n));
                }
            } else {
                this.e.setVisibility(0);
                this.m.setText(this.a.getResources().getString(R.string.user_info_center_head_forums_name_text));
                this.o.setText(this.a.getResources().getString(R.string.user_info_center_head_post_name_text));
                this.q.setText(this.a.getResources().getString(R.string.user_info_center_head_attention_name_text));
                this.s.setText(this.a.getResources().getString(R.string.user_info_center_head_fans_name_text));
            }
            this.x.notifyDataSetChanged();
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
        this.x.notifyDataSetChanged();
    }

    public int getForumId() {
        return R.id.user_info_center_head_forums;
    }

    public int getPostId() {
        return R.id.user_info_center_head_post;
    }

    public int getFansId() {
        return R.id.user_info_center_head_fans;
    }

    public int getAttentionId() {
        return R.id.user_info_center_head_attention;
    }

    public void a(int i) {
        ((com.baidu.tieba.k) this.a).a().a(i == 1);
        ((com.baidu.tieba.k) this.a).a().a(this.b);
    }

    public void a(boolean z) {
        if (z) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(4);
        }
    }
}
