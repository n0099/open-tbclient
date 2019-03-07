package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.g.d;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private ImageView fZf;
    private TextView fZg;
    private Animation fZj;
    private Animation fZk;
    private SlidingTabLayout gLh;
    private Context mContext;
    private View rootView;
    private boolean fZl = true;
    private d gLi = new d() { // from class: com.baidu.tieba.lego.indicator.a.1
        @Override // com.baidu.adp.lib.g.d
        public void b(Animation animation) {
            if (a.this.fZg != null) {
                if (animation == a.this.fZj) {
                    a.this.fZg.setVisibility(0);
                    a.this.fZg.setClickable(true);
                } else if (animation == a.this.fZk) {
                    a.this.fZg.setVisibility(8);
                    a.this.fZg.setClickable(false);
                }
            }
        }
    };

    public a(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.fZg = (TextView) view.findViewById(d.g.tab_widget_switch);
        this.fZf = (ImageView) view.findViewById(d.g.tab_widget_more);
        this.gLh = (SlidingTabLayout) view.findViewById(d.g.tab_widget_sliding_tab);
    }

    public void v(View.OnClickListener onClickListener) {
        if (this.fZf != null) {
            this.fZf.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager, int i) {
        if (this.gLh != null) {
            this.gLh.setViewPager(viewPager, i);
        }
    }

    public void onChangeSkinType(int i) {
        al.l(this.rootView, d.C0236d.cp_bg_line_e);
        al.l(this.fZg, d.C0236d.cp_bg_line_e);
        al.d(this.fZg, d.C0236d.cp_cont_f, 1);
        if (this.fZl) {
            al.c(this.fZf, d.f.lego_icon_triangle_down_normal);
        } else {
            al.c(this.fZf, d.f.lego_icon_triangle_up_normal);
        }
        al.k(this.fZf, d.f.lego_btn_more_selector);
        if (this.gLh != null) {
            this.gLh.onChangeSkinType(i);
        }
    }

    public void VU() {
        this.fZl = false;
        if (this.fZg != null) {
            this.fZg.clearAnimation();
            this.fZg.setVisibility(0);
            this.fZg.startAnimation(getInAnimation());
        }
        al.c(this.fZf, d.f.lego_icon_triangle_up_normal);
    }

    public void bpf() {
        this.fZl = true;
        if (this.fZg != null) {
            this.fZg.clearAnimation();
            this.fZg.startAnimation(getOutAnimation());
        }
        al.c(this.fZf, d.f.lego_icon_triangle_down_normal);
    }

    private Animation getInAnimation() {
        if (this.fZj == null) {
            this.fZj = AnimationUtils.loadAnimation(this.mContext, d.a.fade_in);
            this.fZj.setAnimationListener(this.gLi);
        }
        return this.fZj;
    }

    private Animation getOutAnimation() {
        if (this.fZk == null) {
            this.fZk = AnimationUtils.loadAnimation(this.mContext, d.a.fade_out);
            this.fZk.setAnimationListener(this.gLi);
        }
        return this.fZk;
    }
}
