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
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private int mDuration;
    private Runnable mHideTipRunnable;
    private Runnable mRunnable;
    private TranslateAnimation mTipInAnimation;
    private Animation mTipOutAnimation;

    public CommonTipView(Context context) {
        super(context);
        this.mDuration = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
        this.mTipOutAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_out);
        this.mTipInAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds56), 0.0f);
        this.mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.1
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
        this.mDuration = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
        this.mTipOutAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_out);
        this.mTipInAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds56), 0.0f);
        this.mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.1
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
        this.mDuration = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
        this.mTipOutAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_out);
        this.mTipInAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds56), 0.0f);
        this.mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.1
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
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds24));
        setGravity(17);
        this.mTipOutAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.CommonTipView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CommonTipView.this.onDestroy();
                CommonTipView.this.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(CommonTipView.this.mRunnable, 600L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mTipInAnimation.setDuration(400L);
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.CommonTipView.4
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.mTipInAnimation);
        }
    }

    public void show(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds56));
            layoutParams.setMargins(0, 0, 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.mTipInAnimation);
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
        al.d(this, e.d.common_color_10260, i);
        al.b(this, e.d.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.mHideTipRunnable);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mRunnable);
        hide();
    }
}
