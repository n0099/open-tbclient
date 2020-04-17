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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NavigationBarCoverTip extends LinearLayout {
    private View hcC;
    private Animation hwL;
    private Animation hwM;
    private a lua;
    private Activity mActivity;
    private Runnable mHideRunnable;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void Cd();

        void deE();
    }

    public NavigationBarCoverTip(Context context) {
        super(context);
        this.mSkinType = 3;
        init();
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
                com.baidu.adp.lib.f.e.lb().removeCallbacks(NavigationBarCoverTip.this.mHideRunnable);
                NavigationBarCoverTip.this.hideTip();
            }
        });
        initAnimation();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initAnimation() {
        this.hwL = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        this.hwL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (NavigationBarCoverTip.this.lua != null) {
                    NavigationBarCoverTip.this.lua.Cd();
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
        this.hwM = AnimationUtils.loadAnimation(getContext(), R.anim.out_to_top);
        this.hwM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (NavigationBarCoverTip.this.lua != null) {
                    NavigationBarCoverTip.this.lua.deE();
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

    public void g(Activity activity, View view) {
        a(activity, view, 5000);
    }

    public void a(Activity activity, View view, int i) {
        this.mActivity = activity;
        if (view != this.hcC) {
            removeAllViews();
            addView(view);
            this.hcC = view;
        }
        if (i < 0) {
            i = 5000;
        }
        setVisibility(0);
        clearAnimation();
        startAnimation(this.hwL);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.mHideRunnable);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.mHideRunnable, i);
    }

    public void k(Activity activity, int i) {
        this.mActivity = activity;
        if (i < 0) {
            i = 5000;
        }
        setVisibility(0);
        clearAnimation();
        startAnimation(this.hwL);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.mHideRunnable);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.mHideRunnable, i);
    }

    public void hideTip() {
        clearAnimation();
        startAnimation(this.hwM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.mHideRunnable);
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
            am.setBackgroundColor(this, R.color.cp_link_tip_a_alpha95);
            this.mSkinType = i;
        }
    }

    public void setCoverTipListener(a aVar) {
        this.lua = aVar;
    }
}
