package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.f.d;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private ImageView kuS;
    private TextView kuT;
    private Animation kuW;
    private Animation kuX;
    private SlidingTabLayout lcr;
    private Context mContext;
    private View rootView;
    private boolean kuY = true;
    private d lcs = new d() { // from class: com.baidu.tieba.lego.indicator.a.1
        @Override // com.baidu.adp.lib.f.d
        public void onSafeAnimationEnd(Animation animation) {
            if (a.this.kuT != null) {
                if (animation == a.this.kuW) {
                    a.this.kuT.setVisibility(0);
                    a.this.kuT.setClickable(true);
                } else if (animation == a.this.kuX) {
                    a.this.kuT.setVisibility(8);
                    a.this.kuT.setClickable(false);
                }
            }
        }
    };

    public a(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.kuT = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.kuS = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.lcr = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.kuS != null) {
            this.kuS.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager, int i) {
        if (this.lcr != null) {
            this.lcr.setViewPager(viewPager, i);
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.rootView, R.color.CAM_X0205);
        ao.setBackgroundColor(this.kuT, R.color.CAM_X0205);
        ao.setViewTextColor(this.kuT, R.color.CAM_X0106, 1);
        if (this.kuY) {
            ao.setImageResource(this.kuS, R.drawable.lego_icon_triangle_down_normal);
        } else {
            ao.setImageResource(this.kuS, R.drawable.lego_icon_triangle_up_normal);
        }
        ao.setBackgroundResource(this.kuS, R.drawable.lego_btn_more_selector);
        if (this.lcr != null) {
            this.lcr.onChangeSkinType(i);
        }
    }

    public void bog() {
        this.kuY = false;
        if (this.kuT != null) {
            this.kuT.clearAnimation();
            this.kuT.setVisibility(0);
            this.kuT.startAnimation(getInAnimation());
        }
        ao.setImageResource(this.kuS, R.drawable.lego_icon_triangle_up_normal);
    }

    public void cVK() {
        this.kuY = true;
        if (this.kuT != null) {
            this.kuT.clearAnimation();
            this.kuT.startAnimation(getOutAnimation());
        }
        ao.setImageResource(this.kuS, R.drawable.lego_icon_triangle_down_normal);
    }

    private Animation getInAnimation() {
        if (this.kuW == null) {
            this.kuW = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.kuW.setAnimationListener(this.lcs);
        }
        return this.kuW;
    }

    private Animation getOutAnimation() {
        if (this.kuX == null) {
            this.kuX = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.kuX.setAnimationListener(this.lcs);
        }
        return this.kuX;
    }
}
