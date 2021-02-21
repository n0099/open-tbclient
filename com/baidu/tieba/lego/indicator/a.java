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
    private ImageView kyI;
    private TextView kyJ;
    private Animation kyM;
    private Animation kyN;
    private SlidingTabLayout lgd;
    private Context mContext;
    private View rootView;
    private boolean kyO = true;
    private d lge = new d() { // from class: com.baidu.tieba.lego.indicator.a.1
        @Override // com.baidu.adp.lib.f.d
        public void onSafeAnimationEnd(Animation animation) {
            if (a.this.kyJ != null) {
                if (animation == a.this.kyM) {
                    a.this.kyJ.setVisibility(0);
                    a.this.kyJ.setClickable(true);
                } else if (animation == a.this.kyN) {
                    a.this.kyJ.setVisibility(8);
                    a.this.kyJ.setClickable(false);
                }
            }
        }
    };

    public a(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.kyJ = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.kyI = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.lgd = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.kyI != null) {
            this.kyI.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager, int i) {
        if (this.lgd != null) {
            this.lgd.setViewPager(viewPager, i);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0205);
        ap.setBackgroundColor(this.kyJ, R.color.CAM_X0205);
        ap.setViewTextColor(this.kyJ, R.color.CAM_X0106, 1);
        if (this.kyO) {
            ap.setImageResource(this.kyI, R.drawable.lego_icon_triangle_down_normal);
        } else {
            ap.setImageResource(this.kyI, R.drawable.lego_icon_triangle_up_normal);
        }
        ap.setBackgroundResource(this.kyI, R.drawable.lego_btn_more_selector);
        if (this.lgd != null) {
            this.lgd.onChangeSkinType(i);
        }
    }

    public void bkE() {
        this.kyO = false;
        if (this.kyJ != null) {
            this.kyJ.clearAnimation();
            this.kyJ.setVisibility(0);
            this.kyJ.startAnimation(getInAnimation());
        }
        ap.setImageResource(this.kyI, R.drawable.lego_icon_triangle_up_normal);
    }

    public void cTY() {
        this.kyO = true;
        if (this.kyJ != null) {
            this.kyJ.clearAnimation();
            this.kyJ.startAnimation(getOutAnimation());
        }
        ap.setImageResource(this.kyI, R.drawable.lego_icon_triangle_down_normal);
    }

    private Animation getInAnimation() {
        if (this.kyM == null) {
            this.kyM = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.kyM.setAnimationListener(this.lge);
        }
        return this.kyM;
    }

    private Animation getOutAnimation() {
        if (this.kyN == null) {
            this.kyN = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.kyN.setAnimationListener(this.lge);
        }
        return this.kyN;
    }
}
