package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NavigationBarCoverTip extends LinearLayout {
    private View hKw;
    private Animation ifF;
    private Animation ifG;
    private Activity mActivity;
    private Runnable mHideRunnable;
    private int mSkinType;
    private a mpf;

    /* loaded from: classes.dex */
    public interface a {
        void GF();

        void dtE();
    }

    public NavigationBarCoverTip(Context context) {
        this(context, null);
    }

    public NavigationBarCoverTip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationBarCoverTip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setOrientation(1);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            setPadding(0, UtilHelper.getStatusBarHeight(), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        } else {
            setPadding(0, 0, 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(NavigationBarCoverTip.this.mHideRunnable);
                NavigationBarCoverTip.this.hideTip();
            }
        });
        initAnimation();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initAnimation() {
        this.ifF = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        this.ifF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (NavigationBarCoverTip.this.mpf != null) {
                    NavigationBarCoverTip.this.mpf.GF();
                }
                if (NavigationBarCoverTip.this.mActivity != null) {
                    UtilHelper.changeStatusBarIconAndTextColor(true, NavigationBarCoverTip.this.mActivity);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.ifG = AnimationUtils.loadAnimation(getContext(), R.anim.out_to_top);
        this.ifG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (NavigationBarCoverTip.this.mpf != null) {
                    NavigationBarCoverTip.this.mpf.dtE();
                }
                NavigationBarCoverTip.this.release();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.4
            @Override // java.lang.Runnable
            public void run() {
                NavigationBarCoverTip.this.hideTip();
            }
        };
    }

    public void f(Activity activity, View view) {
        a(activity, view, 5000);
    }

    public void a(Activity activity, View view, int i) {
        this.mActivity = activity;
        if (view != this.hKw) {
            removeAllViews();
            addView(view);
            this.hKw = view;
        }
        if (i < 0) {
            i = 5000;
        }
        setVisibility(0);
        clearAnimation();
        startAnimation(this.ifF);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.mHideRunnable, i);
    }

    public void i(Activity activity, int i) {
        this.mActivity = activity;
        if (i < 0) {
            i = 5000;
        }
        setVisibility(0);
        clearAnimation();
        startAnimation(this.ifF);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.mHideRunnable, i);
    }

    public void hideTip() {
        clearAnimation();
        startAnimation(this.ifG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
        clearAnimation();
        setVisibility(8);
        if (this.mActivity != null) {
            UtilHelper.changeStatusBarIconAndTextColor(false, this.mActivity);
            this.mActivity = null;
        }
    }

    public void onDestroy() {
        release();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundColor(this, R.color.cp_link_tip_a_alpha95);
            this.mSkinType = i;
        }
    }

    public void setCoverTipListener(a aVar) {
        this.mpf = aVar;
    }
}
