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
/* loaded from: classes8.dex */
public class a {
    private ImageView kAK;
    private TextView kAL;
    private Animation kAO;
    private Animation kAP;
    private SlidingTabLayout lif;
    private Context mContext;
    private View rootView;
    private boolean kAQ = true;
    private d lig = new d() { // from class: com.baidu.tieba.lego.indicator.a.1
        @Override // com.baidu.adp.lib.f.d
        public void onSafeAnimationEnd(Animation animation) {
            if (a.this.kAL != null) {
                if (animation == a.this.kAO) {
                    a.this.kAL.setVisibility(0);
                    a.this.kAL.setClickable(true);
                } else if (animation == a.this.kAP) {
                    a.this.kAL.setVisibility(8);
                    a.this.kAL.setClickable(false);
                }
            }
        }
    };

    public a(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.kAL = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.kAK = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.lif = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.kAK != null) {
            this.kAK.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager, int i) {
        if (this.lif != null) {
            this.lif.setViewPager(viewPager, i);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0205);
        ap.setBackgroundColor(this.kAL, R.color.CAM_X0205);
        ap.setViewTextColor(this.kAL, R.color.CAM_X0106, 1);
        if (this.kAQ) {
            ap.setImageResource(this.kAK, R.drawable.lego_icon_triangle_down_normal);
        } else {
            ap.setImageResource(this.kAK, R.drawable.lego_icon_triangle_up_normal);
        }
        ap.setBackgroundResource(this.kAK, R.drawable.lego_btn_more_selector);
        if (this.lif != null) {
            this.lif.onChangeSkinType(i);
        }
    }

    public void bkG() {
        this.kAQ = false;
        if (this.kAL != null) {
            this.kAL.clearAnimation();
            this.kAL.setVisibility(0);
            this.kAL.startAnimation(getInAnimation());
        }
        ap.setImageResource(this.kAK, R.drawable.lego_icon_triangle_up_normal);
    }

    public void cUf() {
        this.kAQ = true;
        if (this.kAL != null) {
            this.kAL.clearAnimation();
            this.kAL.startAnimation(getOutAnimation());
        }
        ap.setImageResource(this.kAK, R.drawable.lego_icon_triangle_down_normal);
    }

    private Animation getInAnimation() {
        if (this.kAO == null) {
            this.kAO = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.kAO.setAnimationListener(this.lig);
        }
        return this.kAO;
    }

    private Animation getOutAnimation() {
        if (this.kAP == null) {
            this.kAP = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.kAP.setAnimationListener(this.lig);
        }
        return this.kAP;
    }
}
