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
/* loaded from: classes8.dex */
public class a {
    private SlidingTabLayout kXL;
    private ImageView kqn;
    private TextView kqo;
    private Animation kqr;
    private Animation kqs;
    private Context mContext;
    private View rootView;
    private boolean kqt = true;
    private d kXM = new d() { // from class: com.baidu.tieba.lego.indicator.a.1
        @Override // com.baidu.adp.lib.f.d
        public void onSafeAnimationEnd(Animation animation) {
            if (a.this.kqo != null) {
                if (animation == a.this.kqr) {
                    a.this.kqo.setVisibility(0);
                    a.this.kqo.setClickable(true);
                } else if (animation == a.this.kqs) {
                    a.this.kqo.setVisibility(8);
                    a.this.kqo.setClickable(false);
                }
            }
        }
    };

    public a(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.kqo = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.kqn = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.kXL = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.kqn != null) {
            this.kqn.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager, int i) {
        if (this.kXL != null) {
            this.kXL.setViewPager(viewPager, i);
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.rootView, R.color.CAM_X0205);
        ao.setBackgroundColor(this.kqo, R.color.CAM_X0205);
        ao.setViewTextColor(this.kqo, R.color.CAM_X0106, 1);
        if (this.kqt) {
            ao.setImageResource(this.kqn, R.drawable.lego_icon_triangle_down_normal);
        } else {
            ao.setImageResource(this.kqn, R.drawable.lego_icon_triangle_up_normal);
        }
        ao.setBackgroundResource(this.kqn, R.drawable.lego_btn_more_selector);
        if (this.kXL != null) {
            this.kXL.onChangeSkinType(i);
        }
    }

    public void bkm() {
        this.kqt = false;
        if (this.kqo != null) {
            this.kqo.clearAnimation();
            this.kqo.setVisibility(0);
            this.kqo.startAnimation(getInAnimation());
        }
        ao.setImageResource(this.kqn, R.drawable.lego_icon_triangle_up_normal);
    }

    public void cRS() {
        this.kqt = true;
        if (this.kqo != null) {
            this.kqo.clearAnimation();
            this.kqo.startAnimation(getOutAnimation());
        }
        ao.setImageResource(this.kqn, R.drawable.lego_icon_triangle_down_normal);
    }

    private Animation getInAnimation() {
        if (this.kqr == null) {
            this.kqr = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.kqr.setAnimationListener(this.kXM);
        }
        return this.kqr;
    }

    private Animation getOutAnimation() {
        if (this.kqs == null) {
            this.kqs = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.kqs.setAnimationListener(this.kXM);
        }
        return this.kqs;
    }
}
