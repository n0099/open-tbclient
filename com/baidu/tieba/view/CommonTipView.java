package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private Animation bji;
    private TranslateAnimation bjj;
    private Runnable bjk;
    private int mDuration;
    private Runnable mRunnable;

    public CommonTipView(Context context) {
        super(context);
        this.mDuration = 4000;
        this.bji = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.bjj = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bjk = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.1
            @Override // java.lang.Runnable
            public void run() {
                CommonTipView.this.hideTip();
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) CommonTipView.this.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(CommonTipView.this);
                }
            }
        };
        init();
    }

    public CommonTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDuration = 4000;
        this.bji = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.bjj = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bjk = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.1
            @Override // java.lang.Runnable
            public void run() {
                CommonTipView.this.hideTip();
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) CommonTipView.this.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(CommonTipView.this);
                }
            }
        };
        init();
    }

    public CommonTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDuration = 4000;
        this.bji = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.bjj = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bjk = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.1
            @Override // java.lang.Runnable
            public void run() {
                CommonTipView.this.hideTip();
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) CommonTipView.this.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(CommonTipView.this);
                }
            }
        };
        init();
    }

    private void init() {
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds24));
        setGravity(17);
        this.bji.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.CommonTipView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CommonTipView.this.onDestroy();
                CommonTipView.this.setVisibility(8);
                com.baidu.adp.lib.f.e.ld().postDelayed(CommonTipView.this.mRunnable, 600L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.bjj.setDuration(400L);
        this.bjj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.CommonTipView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CommonTipView.this.postDelayed(CommonTipView.this.bjk, CommonTipView.this.mDuration);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.bjk);
        if (this != null && getParent() != null) {
            startAnimation(this.bji);
        }
    }

    public void c(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.bjj);
        }
    }

    public void b(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds56));
            layoutParams.setMargins(0, 0, 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.bjj);
        }
    }

    public void hide() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.mDuration = i;
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundResource(this, R.color.common_color_10260, i);
        am.setViewTextColor(this, R.color.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.bjk);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.mRunnable);
        hide();
    }
}
