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
    private ImageView fZg;
    private TextView fZh;
    private Animation fZk;
    private Animation fZl;
    private SlidingTabLayout gLi;
    private Context mContext;
    private View rootView;
    private boolean fZm = true;
    private d gLj = new d() { // from class: com.baidu.tieba.lego.indicator.a.1
        @Override // com.baidu.adp.lib.g.d
        public void b(Animation animation) {
            if (a.this.fZh != null) {
                if (animation == a.this.fZk) {
                    a.this.fZh.setVisibility(0);
                    a.this.fZh.setClickable(true);
                } else if (animation == a.this.fZl) {
                    a.this.fZh.setVisibility(8);
                    a.this.fZh.setClickable(false);
                }
            }
        }
    };

    public a(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.fZh = (TextView) view.findViewById(d.g.tab_widget_switch);
        this.fZg = (ImageView) view.findViewById(d.g.tab_widget_more);
        this.gLi = (SlidingTabLayout) view.findViewById(d.g.tab_widget_sliding_tab);
    }

    public void v(View.OnClickListener onClickListener) {
        if (this.fZg != null) {
            this.fZg.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager, int i) {
        if (this.gLi != null) {
            this.gLi.setViewPager(viewPager, i);
        }
    }

    public void onChangeSkinType(int i) {
        al.l(this.rootView, d.C0236d.cp_bg_line_e);
        al.l(this.fZh, d.C0236d.cp_bg_line_e);
        al.d(this.fZh, d.C0236d.cp_cont_f, 1);
        if (this.fZm) {
            al.c(this.fZg, d.f.lego_icon_triangle_down_normal);
        } else {
            al.c(this.fZg, d.f.lego_icon_triangle_up_normal);
        }
        al.k(this.fZg, d.f.lego_btn_more_selector);
        if (this.gLi != null) {
            this.gLi.onChangeSkinType(i);
        }
    }

    public void VU() {
        this.fZm = false;
        if (this.fZh != null) {
            this.fZh.clearAnimation();
            this.fZh.setVisibility(0);
            this.fZh.startAnimation(getInAnimation());
        }
        al.c(this.fZg, d.f.lego_icon_triangle_up_normal);
    }

    public void bpg() {
        this.fZm = true;
        if (this.fZh != null) {
            this.fZh.clearAnimation();
            this.fZh.startAnimation(getOutAnimation());
        }
        al.c(this.fZg, d.f.lego_icon_triangle_down_normal);
    }

    private Animation getInAnimation() {
        if (this.fZk == null) {
            this.fZk = AnimationUtils.loadAnimation(this.mContext, d.a.fade_in);
            this.fZk.setAnimationListener(this.gLj);
        }
        return this.fZk;
    }

    private Animation getOutAnimation() {
        if (this.fZl == null) {
            this.fZl = AnimationUtils.loadAnimation(this.mContext, d.a.fade_out);
            this.fZl.setAnimationListener(this.gLj);
        }
        return this.fZl;
    }
}
