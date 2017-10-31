package com.baidu.tieba.view;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private a gLU;
    private int mDuration;
    private Runnable mHideTipRunnable;
    private TranslateAnimation mTipInAnimation;
    private Animation mTipOutAnimation;

    /* loaded from: classes.dex */
    public interface a {
        void onTipCompleted();
    }

    public CommonTipView(Context context) {
        super(context);
        this.mDuration = 4000;
        this.mTipOutAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);
        this.mTipInAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds56), 0.0f);
        this.mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.1
            @Override // java.lang.Runnable
            public void run() {
                CommonTipView.this.hideTip();
            }
        };
        init();
    }

    private void init() {
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds24));
        setGravity(17);
        this.mTipOutAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.CommonTipView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CommonTipView.this.onDestroy();
                ViewGroup viewGroup = (ViewGroup) CommonTipView.this.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(CommonTipView.this);
                }
                if (CommonTipView.this.gLU != null) {
                    CommonTipView.this.gLU.onTipCompleted();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mTipInAnimation.setDuration(400L);
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.CommonTipView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CommonTipView.this.postDelayed(CommonTipView.this.mHideTipRunnable, CommonTipView.this.mDuration);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.mHideTipRunnable);
        if (this != null && getParent() != null) {
            startAnimation(this.mTipOutAnimation);
        }
    }

    public void show(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.mTipInAnimation);
        }
    }

    public void show(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds56));
            layoutParams.setMargins(0, 0, 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.mTipInAnimation);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.mDuration = i;
        }
    }

    public void onChangeSkinType(int i) {
        aj.d(this, d.C0080d.common_color_10260, i);
        aj.b(this, d.C0080d.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.mHideTipRunnable);
    }
}
