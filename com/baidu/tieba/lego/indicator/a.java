package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.f.d;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private ImageView kyu;
    private TextView kyv;
    private Animation kyy;
    private Animation kyz;
    private SlidingTabLayout lfP;
    private Context mContext;
    private View rootView;
    private boolean kyA = true;
    private d lfQ = new d() { // from class: com.baidu.tieba.lego.indicator.a.1
        @Override // com.baidu.adp.lib.f.d
        public void onSafeAnimationEnd(Animation animation) {
            if (a.this.kyv != null) {
                if (animation == a.this.kyy) {
                    a.this.kyv.setVisibility(0);
                    a.this.kyv.setClickable(true);
                } else if (animation == a.this.kyz) {
                    a.this.kyv.setVisibility(8);
                    a.this.kyv.setClickable(false);
                }
            }
        }
    };

    public a(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.kyv = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.kyu = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.lfP = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.kyu != null) {
            this.kyu.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager, int i) {
        if (this.lfP != null) {
            this.lfP.setViewPager(viewPager, i);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0205);
        ap.setBackgroundColor(this.kyv, R.color.CAM_X0205);
        ap.setViewTextColor(this.kyv, R.color.CAM_X0106, 1);
        if (this.kyA) {
            ap.setImageResource(this.kyu, R.drawable.lego_icon_triangle_down_normal);
        } else {
            ap.setImageResource(this.kyu, R.drawable.lego_icon_triangle_up_normal);
        }
        ap.setBackgroundResource(this.kyu, R.drawable.lego_btn_more_selector);
        if (this.lfP != null) {
            this.lfP.onChangeSkinType(i);
        }
    }

    public void bkE() {
        this.kyA = false;
        if (this.kyv != null) {
            this.kyv.clearAnimation();
            this.kyv.setVisibility(0);
            this.kyv.startAnimation(getInAnimation());
        }
        ap.setImageResource(this.kyu, R.drawable.lego_icon_triangle_up_normal);
    }

    public void cTR() {
        this.kyA = true;
        if (this.kyv != null) {
            this.kyv.clearAnimation();
            this.kyv.startAnimation(getOutAnimation());
        }
        ap.setImageResource(this.kyu, R.drawable.lego_icon_triangle_down_normal);
    }

    private Animation getInAnimation() {
        if (this.kyy == null) {
            this.kyy = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.kyy.setAnimationListener(this.lfQ);
        }
        return this.kyy;
    }

    private Animation getOutAnimation() {
        if (this.kyz == null) {
            this.kyz = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.kyz.setAnimationListener(this.lfQ);
        }
        return this.kyz;
    }
}
