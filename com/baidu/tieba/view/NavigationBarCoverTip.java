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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBarCoverTip extends LinearLayout {
    private Animation dGu;
    private Animation dGv;
    private View dpR;
    private a hpy;
    private Activity mActivity;
    private Runnable mHideRunnable;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void Yv();

        void onHide();
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
            setPadding(0, UtilHelper.getStatusBarHeight(), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        } else {
            setPadding(0, 0, 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.e.in().removeCallbacks(NavigationBarCoverTip.this.mHideRunnable);
                NavigationBarCoverTip.this.hideTip();
            }
        });
        bov();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bov() {
        this.dGu = AnimationUtils.loadAnimation(getContext(), d.a.in_from_top);
        this.dGu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (NavigationBarCoverTip.this.hpy != null) {
                    NavigationBarCoverTip.this.hpy.Yv();
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
        this.dGv = AnimationUtils.loadAnimation(getContext(), d.a.out_to_top);
        this.dGv.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.NavigationBarCoverTip.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (NavigationBarCoverTip.this.hpy != null) {
                    NavigationBarCoverTip.this.hpy.onHide();
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

    public void a(Activity activity, View view, int i) {
        this.mActivity = activity;
        if (view != this.dpR) {
            removeAllViews();
            addView(view);
            this.dpR = view;
        }
        if (i < 0) {
            i = 5000;
        }
        setVisibility(0);
        clearAnimation();
        startAnimation(this.dGu);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.mHideRunnable);
        com.baidu.adp.lib.g.e.in().postDelayed(this.mHideRunnable, i);
    }

    public void h(Activity activity, int i) {
        this.mActivity = activity;
        if (i < 0) {
            i = 5000;
        }
        setVisibility(0);
        clearAnimation();
        startAnimation(this.dGu);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.mHideRunnable);
        com.baidu.adp.lib.g.e.in().postDelayed(this.mHideRunnable, i);
    }

    public void hideTip() {
        clearAnimation();
        startAnimation(this.dGv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.mHideRunnable);
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
            am.j(this, d.C0140d.cp_link_tip_a_alpha95);
            this.mSkinType = i;
        }
    }

    public void setCoverTipListener(a aVar) {
        this.hpy = aVar;
    }
}
