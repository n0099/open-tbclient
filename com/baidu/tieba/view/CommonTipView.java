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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private Animation asK;
    private TranslateAnimation asL;
    private Runnable asM;
    private int mDuration;
    private Runnable mRunnable;

    public CommonTipView(Context context) {
        super(context);
        this.mDuration = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
        this.asK = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.asL = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.asM = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.1
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
        this.asK = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.asL = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.asM = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.1
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
        this.asK = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.asL = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.asM = new Runnable() { // from class: com.baidu.tieba.view.CommonTipView.1
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
        this.asK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.CommonTipView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CommonTipView.this.onDestroy();
                CommonTipView.this.setVisibility(8);
                com.baidu.adp.lib.g.e.fZ().postDelayed(CommonTipView.this.mRunnable, 600L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.asL.setDuration(400L);
        this.asL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.CommonTipView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CommonTipView.this.postDelayed(CommonTipView.this.asM, CommonTipView.this.mDuration);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.asM);
        if (this != null && getParent() != null) {
            startAnimation(this.asK);
        }
    }

    public void c(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.asL);
        }
    }

    public void b(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds56));
            layoutParams.setMargins(0, 0, 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.asL);
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
        removeCallbacks(this.asM);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.mRunnable);
        hide();
    }
}
